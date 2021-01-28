package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 王金宇
 * 2021/1/23 0023
 */
public class App1 {

    public static void main(String[] args) {
        try {
            JedisPool pool = null;
            pool = RedisUtils.open("127.0.0.1", 6379);
            Jedis jedis = pool.getResource();
            jedis.flushAll();
            jedis.set("str1", "aaa");
            String str1 = jedis.get("str1");
            System.out.println(str1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            RedisUtils.close();
        }

    }
}
