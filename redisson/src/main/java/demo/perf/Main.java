package demo.perf;

import demo.JedisDemo;
import demo.RedissonDemo;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import redis.clients.jedis.Jedis;

/**
 * Created by zhouxuan on 2019-07-10
 *
 * @Author: zhouxuan
 * @Date: 2019-07-10
 */

public class Main {
    public static void main(String[] args) {
        RedissonClient redisson = RedissonDemo.init();
        Jedis jedis = JedisDemo.init();
        for (int i = 100; i < 10000; i += 100) {
            jedis(jedis, i);
            redisson(redisson, i);
        }
    }

    private static void jedis(Jedis jedis, int count) {
        Long startTime;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            jedis.set("test_key_" + i, "test_value_" + i);
        }
        System.out.println("jedis set " + count + " " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            jedis.del("test_key_" + i);
        }
        System.out.println("jedis del " + count + " " + (System.currentTimeMillis() - startTime));

    }

    private static void redisson(RedissonClient redisson, int count) {
        Long startTime;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            RBucket<String> rBucket = redisson.getBucket("test_key_" + i);
            rBucket.set("test_value_" + i);
        }
        System.out.println("redisson set " + count + " " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            RBucket<String> rBucket = redisson.getBucket("test_key_" + i);
            rBucket.delete();
        }
        System.out.println("redisson del " + count + " " + (System.currentTimeMillis() - startTime));
    }
}
