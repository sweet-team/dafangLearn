package com.dfec.hotel.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.dfec.hotel.entity.CheckIn;
import com.dfec.hotel.service.ICheckInService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 入住退房登记表 前端控制器
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@RestController
@RequestMapping("/hotel/check-in")
public class CheckInController {
    @Autowired
    ICheckInService checkInService;

    @RequestMapping(method = RequestMethod.GET)
    public R getCheckIn(){
        List<CheckIn> list = checkInService.list();
        return R.ok(list);
    }
    @RequestMapping(method = RequestMethod.POST)
    public R addCheckIn(){
       return null;
    }

}
