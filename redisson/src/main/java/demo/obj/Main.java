package demo.obj;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import demo.RedissonDemo;
import org.redisson.api.RBinaryStream;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

import java.io.IOException;

/**
 * Created by zhouxuan on 2019-07-08
 *
 * @Author: zhouxuan
 * @Date: 2019-07-08
 */

public class Main {
    public static void main(String[] args) throws IOException {
        RedissonClient redissonClient = RedissonDemo.init();
        stringDemo(redissonClient);
        objectDemo(redissonClient);
        binaryStreamDemo(redissonClient);
    }

    private static void stringDemo(RedissonClient redissonClient) {
        //hint: 底层redis存储方式使用的是string形式
        RBucket<String> stringRBucket = redissonClient.getBucket("string_demo_key");
        stringRBucket.set("string_demo_value");
        System.out.println("string: " + stringRBucket.get());
    }

    private static void objectDemo(RedissonClient redissonClient) {
        //hint: 底层redis存储方式使用的是string形式
        RBucket<DemoObject> objectRBucket = redissonClient.getBucket("object_demo_key");
        DemoObject demoObject = DemoObject.builder().string("str").integer(1).list(Lists.newArrayList(1l, 2l, 3l)).build();
        objectRBucket.set(demoObject);
        System.out.println("object: " + JSON.toJSONString(demoObject));
    }

    private static void binaryStreamDemo(RedissonClient redissonClient) throws IOException {
        //hint: 底层redis存储方式使用的是string形式
        RBinaryStream rBinaryStream = redissonClient.getBinaryStream("binary_stream_demo_key");
        byte[] content = "test byte array".getBytes();
        rBinaryStream.set(content);
        byte[] readResult = new byte[15];
        rBinaryStream.getInputStream().read(readResult);
        System.out.println("binary stream: " + new String(readResult));
    }


}
