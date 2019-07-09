package demo.other;

import com.alibaba.fastjson.JSON;
import demo.RedissonDemo;
import demo.collection.DemoObject;
import org.redisson.api.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhouxuan on 2019-07-09
 *
 * @Author: zhouxuan
 * @Date: 2019-07-09
 */

public class Main {
    public static void main(String[] args) {
        RedissonClient redissonClient1 = RedissonDemo.init();
        rbatchDemo(redissonClient1);
    }

    private static void rbatchDemo(RedissonClient redissonClient) {
        BatchOptions batchOptions = BatchOptions.defaults()
                .executionMode(BatchOptions.ExecutionMode.REDIS_WRITE_ATOMIC)
                .responseTimeout(2, TimeUnit.SECONDS)
                .retryAttempts(2)
                .retryInterval(200, TimeUnit.MILLISECONDS);
        RBatch rBatch = redissonClient.createBatch(batchOptions);
        RBucketAsync<String> stringRBucket = rBatch.getBucket("rbatch_string_key");
        RBucketAsync<DemoObject> objectRBucket = rBatch.getBucket("rbatch_object_key");
        stringRBucket.setAsync("rbatch_string_value");
        stringRBucket.getAsync();
        objectRBucket.setAsync(DemoObject.builder().string("str").integer(1).build());
        objectRBucket.getAsync();
        stringRBucket.setAsync("rbatch_string_value_new");
        stringRBucket.getAsync();
        BatchResult batchResult = rBatch.execute();
        List<Object> result = batchResult.getResponses();
        System.out.println(JSON.toJSON(result));
    }
}
