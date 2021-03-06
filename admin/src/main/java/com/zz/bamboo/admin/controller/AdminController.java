package com.zz.bamboo.admin.controller;

import com.zz.bamboo.admin.dto.AdminLoginParam;
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

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@Api(tags = "AdminController")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "register")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Admin> register(@RequestBody AdminParam adminParam, BindingResult result) throws Exception {
        Admin admin = adminService.register(adminParam);
        if (admin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(admin);
    }

    @ApiOperation(value = "login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody AdminLoginParam loginParam, BindingResult result){
        String token = adminService.login(loginParam.getUsername(), loginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "refreshToken")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request) {
        return CommonResult.success("");
    }
}
