package demo.collection;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import demo.RedissonDemo;
import org.redisson.api.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhouxuan on 2019-07-08
 *
 * @Author: zhouxuan
 * @Date: 2019-07-08
 */

public class Main {
    public static void main(String[] args) throws Exception {
        RedissonClient redissonClientSet = RedissonDemo.init();
        RedissonClient redissonClientGet = RedissonDemo.init();
//        mapDemo(redissonClientSet, redissonClientGet);
//        mapCacheDemo(redissonClientSet, redissonClientGet);
//        localCachedMapDemo(redissonClientSet, redissonClientGet);
        sortedSetDemo(redissonClientSet, redissonClientGet);
    }

    private static void mapCacheDemo(RedissonClient redissonClientSet, RedissonClient redissonClientGet) throws InterruptedException {
        //hint: 底层的redis存储方式使用的是hash
        RMapCache<String, DemoObject> mapCache = redissonClientSet.getMapCache("map_cache_demo_key");
        mapCache.put("key1", DemoObject.builder().string("str1").integer(1).list(Lists.newArrayList(1l, 2l, 3l)).build(), 1, TimeUnit.SECONDS);
        //hint：redis中的原生hash结构并不支持单字段过期，该功能由服务器端处理，性能损耗需要check一下
        mapCache.put("key2", DemoObject.builder().string("str2").integer(2).list(Lists.newArrayList(4l, 5l, 6l)).build(), 1000, TimeUnit.SECONDS);
        RMap<String, DemoObject> mapGet = redissonClientGet.getMap("map_cache_demo_key");
        System.out.println("key1: " + JSON.toJSONString(mapGet.get("key1")));
        System.out.println("key2: " + JSON.toJSONString(mapGet.get("key2")));
        Thread.currentThread().sleep(1000);
        System.out.println("key1 after sleep: " + JSON.toJSONString(mapGet.get("key1")));
    }

    private static void mapDemo(RedissonClient redissonClientSet, RedissonClient redissonClientGet) {
        //hint: 底层的redis存储方式使用的是hash
        RMap<String, DemoObject> map = redissonClientSet.getMap("map_demo_key");
        map.put("key1", DemoObject.builder().string("str1").integer(1).list(Lists.newArrayList(1l, 2l, 3l)).build());
        map.put("key2", DemoObject.builder().string("str2").integer(2).list(Lists.newArrayList(4l, 5l, 6l)).build());
    }

    private static void localCachedMapDemo(RedissonClient redissonClientSet, RedissonClient redissonClientGet) {
        //hint: 底层的redis存储方式使用的是hash
        LocalCachedMapOptions localCachedMapOptions = LocalCachedMapOptions.defaults()
                .evictionPolicy(LocalCachedMapOptions.EvictionPolicy.LRU)
                .cacheSize(1000)
                .reconnectionStrategy(LocalCachedMapOptions.ReconnectionStrategy.CLEAR)
                .syncStrategy(LocalCachedMapOptions.SyncStrategy.INVALIDATE)
                .timeToLive(60, TimeUnit.SECONDS)
                .maxIdle(600, TimeUnit.SECONDS);
        RLocalCachedMap<String, DemoObject> map = redissonClientSet.getLocalCachedMap("local_cached_map_demo_key", localCachedMapOptions);
        map.put("key1", DemoObject.builder().string("str1").integer(1).list(Lists.newArrayList(1l, 2l, 3l)).build());
        map.put("key2", DemoObject.builder().string("str2").integer(2).list(Lists.newArrayList(4l, 5l, 6l)).build());
    }

    private static void sortedSetDemo(RedissonClient redissonClientSet, RedissonClient redissonClientGet) {
        RScoredSortedSet<DemoObject> sortedSet = redissonClientGet.getScoredSortedSet("sorted_set_demo_key");
        sortedSet.add(0.1, DemoObject.builder().string("str1").integer(1).list(Lists.newArrayList(1l, 2l, 3l)).build());
        sortedSet.add(0.2, DemoObject.builder().string("str2").integer(2).list(Lists.newArrayList(4l, 5l, 6l)).build());
        System.out.println(JSON.toJSONString(sortedSet.valueRange(0.1, false, 0.2, true)));
    }
}
