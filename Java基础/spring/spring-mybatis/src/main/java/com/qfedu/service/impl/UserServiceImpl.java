package com.qfedu.service.impl;

import com.qfedu.dao.UserDAO;
import com.qfedu.pojo.User;
import com.qfedu.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

// 把实现类交给Spring管理
@Service
public class UserServiceImpl implements UserService {

    // 自动装配，由于applicationContext配置了Spring初始化的时候会扫描com.qfedu，这个时候就以及把类都交给Spring管理了，只需加@Resource就可以自动装配
    @Resource
    private UserDAO userDAO;

    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.SUPPORTS)
    public List<User> listUsers() {
        return userDAO.queryUsers();
    }
}
