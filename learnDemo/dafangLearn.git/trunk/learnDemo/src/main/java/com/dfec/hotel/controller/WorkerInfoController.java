package com.dfec.hotel.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dfec.hotel.auth.OAuth2Token;
import com.dfec.hotel.auth.TokenGenerator;
import com.dfec.hotel.entity.WorkerInfo;
import com.dfec.hotel.service.IWorkerInfoService;
import com.dfec.hotel.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 工作人员信息表 前端控制器
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@RestController
@RequestMapping("/hotel/worker-info")
@Api(tags = "员工管理")
public class WorkerInfoController {

    @Autowired
    private IWorkerInfoService workerInfoService;
    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation("员工登录")
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public R loginWorker(String username, String password){
        Subject subject = SecurityUtils.getSubject();
        WorkerInfo workerByUsername = workerInfoService.getWorkerByUsername(username);
        boolean equals = workerByUsername.getPassword().equals(password);
        if (equals){
            OAuth2Token oAuth2Token = new OAuth2Token(TokenGenerator.generateValue());
            this.redisUtils.set("token:"+(String) oAuth2Token.getPrincipal(),workerByUsername,50L, TimeUnit.MINUTES);
            subject.login(oAuth2Token);
            return R.ok(subject.getSession().getId());
        }else {
            return R.failed("login failed").setCode(1000);
        }
    }
    @ApiOperation("列出所有的员工")
    @RequestMapping(method = RequestMethod.GET)
    public R allWorker(@RequestParam Long limit, Long page){
        Page<WorkerInfo> page1 = workerInfoService.page(new Page<WorkerInfo>(page,limit));
        return R.ok(page1);
    }

    @ApiOperation("员工详细信息")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public R workerDetails(@PathVariable Integer id){
        WorkerInfo byId = workerInfoService.getById(id);
        return R.ok(byId);
    }

    @ApiOperation("员工添加")
    @RequestMapping(method = RequestMethod.POST)
    public R addWork(@RequestBody WorkerInfo workerInfo){
        LocalDateTime localDateTime =LocalDateTime.now();
        workerInfo.setCreateTime(localDateTime);
        workerInfo.setUpdateTime(localDateTime);
        boolean save = this.workerInfoService.save(workerInfo);
        return R.ok(save);
    }
    @ApiOperation("员工修改")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public R updateWork(@PathVariable Integer id, @RequestBody WorkerInfo workerInfo ){
        WorkerInfo byId = this.workerInfoService.getById(id);
        byId.setUsername(workerInfo.getUsername());
        byId.setPassword(workerInfo.getPassword());
        byId.setRole(workerInfo.getRole());
        byId.setName(workerInfo.getName());
        byId.setGender(workerInfo.getGender());
        byId.setPhone(workerInfo.getPhone());
        byId.setUpdateTime(LocalDateTime.now());
        boolean b = this.workerInfoService.updateById(byId);
        return  R.ok(b);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ApiOperation("删除员工")
    public R deleteWorker(@PathVariable String id){
        boolean b = this.workerInfoService.removeById(id);
        return R.ok(b);
    }

}
