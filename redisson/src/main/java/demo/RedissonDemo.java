package demo;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * Created by zhouxuan on 2019-07-08
 *
 * @Author: zhouxuan
 * @Date: 2019-07-08
 */

public class RedissonDemo {
    public static RedissonClient init() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://10.77.121.229:6379");
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }
}
