package com.hj.service;

import com.hj.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lyon
 * @since 2024-05-21
 */
public interface IUserService extends IService<User> {


    public void add();

}
