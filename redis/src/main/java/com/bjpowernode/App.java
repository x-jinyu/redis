package com.bjpowernode;

import redis.clients.jedis.Jedis;

/**
 * 王金宇
 * 2021/1/23 0023
 */
public class App {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.flushAll();//删除所有的数据

        jedis.set("str1","aaa");
        String str1 = jedis.get("str1");
        System.out.println(str1);
        jedis.append("str1","bbb");
        String str2 = jedis.get("str1");
        System.out.println(str2);

    }
}
