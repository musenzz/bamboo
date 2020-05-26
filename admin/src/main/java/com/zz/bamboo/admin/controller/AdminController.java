package com.zz.bamboo.admin.controller;

import com.zz.bamboo.admin.dto.AdminParam;
import com.zz.bamboo.admin.service.AdminService;
import com.zz.bamboo.common.api.CommonResult;
import com.zz.bamboo.admin.model.Admin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "AdminController")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Admin> register(@RequestBody AdminParam adminParam, BindingResult result) throws Exception {
        Admin admin = adminService.register(adminParam);
        if (admin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(admin);
    }
}
