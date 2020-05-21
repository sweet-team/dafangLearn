package com.dfec.hotel.service.impl;

import com.dfec.hotel.entity.OrderInfo;
import com.dfec.hotel.mapper.OrderInfoMapper;
import com.dfec.hotel.service.IOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单信息表 服务实现类
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

}
