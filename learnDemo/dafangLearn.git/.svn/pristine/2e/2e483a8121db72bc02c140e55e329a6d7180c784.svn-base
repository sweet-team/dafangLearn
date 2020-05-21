package com.dfec.hotel.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.dfec.hotel.entity.RoomType;
import com.dfec.hotel.service.IRoomTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 房间类型表 前端控制器
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@RestController
@RequestMapping("/hotel/room-type")
@Api(tags = "房间类型管理", value = "员工权限的测试")
public class RoomTypeController {
    @Autowired
    IRoomTypeService roomTypeService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "获取所有的房间类型")
    public R allRoomType(){
        List<RoomType> list = roomTypeService.list();
        return R.ok(list);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiOperation("根据ID获取详情")
    public R RomeTypeDetails(@PathVariable Integer id){
        RoomType byId = roomTypeService.getById(id);
        return R.ok(byId);
    }
    @RequiresAuthentication()
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("新增房间类型")
    public R addRoomType(@RequestBody RoomType roomType){
        LocalDateTime now = LocalDateTime.now();
        roomType.setUpdateTime(now);
        roomType.setCreateTime(now);
        boolean save = roomTypeService.save(roomType);
        return R.ok(save);
    }
    @RequiresAuthentication()
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ApiOperation("修改房间类型")
    public R updateRoomType(@PathVariable Integer id , @RequestBody RoomType roomType){
        RoomType byId = this.roomTypeService.getById(id);
        BeanUtils.copyProperties(roomType,byId);
        boolean b = this.roomTypeService.updateById(byId);
        return R.ok(b);
    }
    @RequiresAuthentication()
    @RequiresRoles("admin")
    @ApiOperation("删除房间类型")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public R deleteRoomType(@PathVariable Integer id){
        boolean b = this.roomTypeService.removeById(id);
        return R.ok(b);
    }

}
