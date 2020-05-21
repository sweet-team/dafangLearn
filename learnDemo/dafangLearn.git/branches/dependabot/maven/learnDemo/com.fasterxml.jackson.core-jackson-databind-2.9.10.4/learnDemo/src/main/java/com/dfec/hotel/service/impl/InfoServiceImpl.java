package com.dfec.hotel.service.impl;

import com.dfec.hotel.entity.Info;
import com.dfec.hotel.mapper.InfoMapper;
import com.dfec.hotel.service.IInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 酒店信息表 服务实现类
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {

}
