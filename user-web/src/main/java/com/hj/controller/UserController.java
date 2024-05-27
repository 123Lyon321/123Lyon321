package com.hj.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hj.entity.Dept;
import com.hj.entity.User;
import com.hj.service.IUserService;
import com.hj.service.IDeptFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    IDeptFeignService deptService;
    @Value("${server.port}")
    String port;
    @Value("${my.key}")
    String myKey;
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/list")
    public Object list(String name) {
        System.out.println("端口号" + port);
        QueryWrapper<User> query = new QueryWrapper<>();
        query.like("username", name);
        return userService.list(query);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println(i + "：" + (i % 2));
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @GetMapping("/add")
    public Object add(User user) {
        //String deptListStr = restTemplate.getForObject("http://DEPT-SERVICE/dept/list", String.class);
        //System.out.println(deptListStr);
        List<Dept> deptList =deptService.findAll();
        System.out.println(deptList);


        //userService.save(user);

        return "ok";
    }

//    int index = 0;
//    @GetMapping("/add")
//    public Object add(User user) {
//        user.setPassword(MD5Util.getMd5(user.getPassword()));
//
//        //打印部门列表
//        String url = "http://localhost:8081/dept/list";
//        String url1 = "http://localhost:8082/dept/list";
//        String[] urls = {url, url1};
//        String url2 = urls[index % 2];
//        index++;
//        String deptListStr = restTemplate.getForObject(url2, String.class);
//        System.out.println(deptListStr);
//        System.out.println(JSON.parseArray(deptListStr, Dept.class));
//
//
//        userService.save(user);
//        return "ok";
//    }

}
