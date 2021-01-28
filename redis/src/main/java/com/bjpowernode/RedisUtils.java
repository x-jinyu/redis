package com.bjpowernode;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 王金宇
 * 2021/1/23 0023
 */
public class RedisUtils {
    //定义连接池对象
    private static JedisPool pool = null;

    //创建连接池
    public static JedisPool open(String host,int port){
        if (pool==null){
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(10); //最多10个链接
            config.setMaxIdle(3);  //最大空闲链接，可以保留足够的连接

            config.setTestOnBorrow(true);//redis没有访问密码的使用
            pool=new JedisPool(config,host,port);
            //Redis有访问密码时的使用方式
            //参数说明：Jedis配置对象，ip,端口号，连接超时时间，访问密码
            //pool=new JedisPool(config,host,port,6*1000,"123456");
        }
        return pool;
    }

    //关闭连接池
    public static void close(){
        if (pool!=null){
            pool.close();
        }
    }
}
