package com.zz.bamboo.admin.service.impl;

import com.zz.bamboo.admin.dto.AdminParam;
import com.zz.bamboo.admin.model.AdminExample;
import com.zz.bamboo.admin.service.AdminService;
import com.zz.bamboo.admin.mapper.AdminMapper;
import com.zz.bamboo.admin.model.Admin;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin register(AdminParam adminParam) throws Exception{
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminParam, admin);
        admin.setCreateTime(new Date());
        admin.setStatus(1);
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(admin.getUsername());
        List<Admin
                > umsAdminList = adminMapper.selectByExample(example);
        if (umsAdminList.size() > 0) {
            return null;
        }
        throw new Exception("Sam 错误");
    }
}
