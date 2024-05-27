package com.hj.service;

import com.hj.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(value = "DEPT-SERVICE")
public interface IDeptFeignService {
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    List<Dept> findAll();

}
