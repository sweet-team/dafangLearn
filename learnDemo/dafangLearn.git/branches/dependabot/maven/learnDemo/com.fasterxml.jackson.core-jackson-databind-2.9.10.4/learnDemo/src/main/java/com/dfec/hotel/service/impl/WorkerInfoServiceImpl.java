package com.dfec.hotel.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dfec.hotel.entity.WorkerInfo;
import com.dfec.hotel.mapper.WorkerInfoMapper;
import com.dfec.hotel.service.IWorkerInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 工作人员信息表 服务实现类
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@Service
public class WorkerInfoServiceImpl extends ServiceImpl<WorkerInfoMapper, WorkerInfo> implements IWorkerInfoService {

    @Autowired
    private WorkerInfoMapper workerInfoMapper;

    @Override
    public WorkerInfo getWorkerByUsername(String userName) {
        if(Objects.isNull(userName)){
            return null;
        }
        WorkerInfo workerInfo = new WorkerInfo();
        Wrapper<WorkerInfo> queryWrapper = new QueryWrapper<>(workerInfo);
        workerInfo.setUsername(userName);
        WorkerInfo one = this.getOne(queryWrapper);
        return one;
    }
}
