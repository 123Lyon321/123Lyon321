package com.hj.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hj.entity.User;
import com.hj.service.IDeptService;
import com.hj.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lyon
 * @since 2024-05-23
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Resource
    IDeptService deptService;
    @Value("${server.port:8888}")
    String port;

    @GetMapping("/list")
    public Object list(String name) {
        return deptService.list().stream().map((d) -> {
            d.setName(d.getName() +"："+ port);
            return d;
        }).collect(Collectors.toList());
    }



}
