package com.zeng.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class MemcachedData {
    public static void main(String[] args) throws Exception{
        String server = "192.168.0.121:11211 192.168.0.121:11212 192.168.0.121:11213";
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(
                AddrUtil.getAddresses(server));
        // Must use binary protocol
        builder.setCommandFactory(new BinaryCommandFactory());
        MemcachedClient client=builder.build();

        for (int i = 0; i < 10; i++) {
			/*将对象加入到memcached缓存 600 is 10*60 s*/
            client.set("ll" + i, 0, "Hello" + i);
        }

        for (int i = 0; i < 10; i++) {
			/*从memcached缓存中按key值取对象*/
            String result = (String) client.get("ll" + i);
            System.out.println("result"+ i + "=" + result);
        }

        client.shutdown();
        System.out.println("over");

    }
}
