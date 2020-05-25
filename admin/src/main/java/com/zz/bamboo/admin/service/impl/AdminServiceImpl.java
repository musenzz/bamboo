package com.zz.bamboo.admin.service.impl;

import com.zz.bamboo.admin.dto.AdminParam;
import com.zz.bamboo.admin.service.AdminService;
import com.zz.bamboo.admin.mapper.AdminMapper;
import com.zz.bamboo.admin.model.Admin;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin register(AdminParam adminParam) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminParam, admin);
        adminMapper.insert(admin);
        return null;
    }
}
