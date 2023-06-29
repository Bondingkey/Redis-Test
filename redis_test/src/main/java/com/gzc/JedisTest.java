package com.gzc;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * @author: 拿破仑
 * @Date&Time: 2023/06/29  15:20  周四
 * @Project: RedisTest
 * @Write software: IntelliJ IDEA
 * @Purpose: 在此处编辑
 */
public class JedisTest {

    Jedis jedis = new Jedis("192.168.150.100",6379);
    /**
     * 连接Redis的前提
     * 1.关闭虚拟机的防火墙
     * 2.修改redis的配置文件
     *      将bind 127.0.0.1注释
     *      将保护模式的yes改为no
     */

    @Test
    //测试连接redis
    public void test1(){
        String ping = jedis.ping();
        System.out.println("ping = " + ping);

    }

    @Test
    //测试Redis中的数据
    public void test2(){
        //查看库中的所有key
        Set<String> keys = jedis.keys("*");
        System.out.println("keys = " + keys);
        //判断key是否存在
        Boolean k8exist = jedis.exists("k8");
        System.out.println("k8exist = " + k8exist);
        //查看数据类型
        String typek1 = jedis.type("k1");
        System.out.println("typek1 = " + typek1);
        //获取key中的值
        String valuek1 = jedis.get("k1");
        System.out.println("valuek1 = " + valuek1);
        //遍历list集合
        List<String> k2 = jedis.lrange("k2", 0, -1);
        for (String s : k2) {
            System.out.println("s = " + s);
        }
        //获取set中的属性
        Set<String> set1 = jedis.smembers("set1");
        System.out.println("set1 = " + set1);
        //获取哈希中的属性
        Set<String> hash = jedis.hkeys("hash");
        System.out.println("hash = " + hash);
        //获取哈希中的属性值
        List<String> hash1 = jedis.hvals("hash");
        System.out.println("hash1 = " + hash1);

    }
}
