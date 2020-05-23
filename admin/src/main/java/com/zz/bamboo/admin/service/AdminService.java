package com.zz.bamboo.admin.service;


import com.zz.bamboo.admin.dto.AdminParam;
import com.zz.bamboo.mbg.model.admin.Admin;

public interface AdminService {
    /**
     * 注册功能
     */
    Admin register(AdminParam umsAdminParam);
}
