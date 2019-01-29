package com.user;

import com.alibaba.dubbo.rpc.RpcContext;
import com.order.OrderDto;
import com.order.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class UserService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("MET-INF/spring/dubbo-provider.xml");
        OrderService orderService = (OrderService) context.getBean("orderServices");
        OrderDto dto = new OrderDto();
        dto.setData("哈哈哈");

        //调用服务
        OrderDto dto1 = orderService.doOrder(dto);
        System.out.println(dto1);
//        Future<OrderDto> future = RpcContext.getContext().getFuture();
//        System.out.println("===========");
//
//        OrderDto result = future.get();
//        System.out.println(result);
    }
}
