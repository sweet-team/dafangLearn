package com.dfec.hotel.service;

import com.dfec.hotel.entity.WorkerInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 工作人员信息表 服务类
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
public interface IWorkerInfoService extends IService<WorkerInfo> {

    WorkerInfo getWorkerByUsername(String userName);
}
