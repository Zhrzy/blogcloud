package com.zy.myblog.conf;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zy 1716457206@qq.com
 * 改版本轮训算法，cas安全操作，实现ribbon的轮询负载均衡
 */
public class MyRoundBalance extends AbstractLoadBalancerRule {

    /*定义下次访问所属次数*/
    private AtomicInteger next;

    public MyRoundBalance(){
        next = new AtomicInteger(0);
    }

    @Override
    public Server choose(Object key) {
        //1、获取服务列表
        ILoadBalancer lb = getLoadBalancer();
        if (lb == null) {
            return null;
        }
        Server server=null;
        List<Server> allServer = lb.getAllServers();
        if (allServer.size() == 0) {
            return null;
        }
        int count = allServer.size();
        int foot=0;//获取服务器list的下标
        //2.获取下次访问次数
        foot = getFoot(count);
        System.out.println("下次访问下标："+foot);//输出都相同的对象地址，单例
        System.out.println(this);
        server=allServer.get(foot);

        //获取
        return server;
    }
    public int getFoot(int count) {
        for (;;) {
            int current = next.get();//获取当前
            int nexts=(current+1)%count;
            if (next.compareAndSet(current, nexts)) {
                return nexts;
            }
        }
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
