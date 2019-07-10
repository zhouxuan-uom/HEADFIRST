package demo;

import redis.clients.jedis.Jedis;

/**
 * Created by zhouxuan on 2019-07-10
 *
 * @Author: zhouxuan
 * @Date: 2019-07-10
 */

public class JedisDemo {
    public static Jedis init() {
        Jedis jedis = new Jedis("10.77.121.229", 6379);
        return jedis;
    }
}
