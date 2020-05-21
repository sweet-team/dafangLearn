package com.dfec.hotel.service.impl;

import com.dfec.hotel.entity.OrderType;
import com.dfec.hotel.mapper.OrderTypeMapper;
import com.dfec.hotel.service.IOrderTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 预订方式表 服务实现类
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@Service
public class OrderTypeServiceImpl extends ServiceImpl<OrderTypeMapper, OrderType> implements IOrderTypeService {

}
