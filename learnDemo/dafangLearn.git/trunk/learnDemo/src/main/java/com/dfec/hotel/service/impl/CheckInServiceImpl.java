package com.dfec.hotel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dfec.hotel.entity.CheckIn;
import com.dfec.hotel.mapper.CheckInMapper;
import com.dfec.hotel.service.ICheckInService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 入住退房登记表 服务实现类
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@Service
public class CheckInServiceImpl extends ServiceImpl<CheckInMapper, CheckIn> implements ICheckInService {

}
