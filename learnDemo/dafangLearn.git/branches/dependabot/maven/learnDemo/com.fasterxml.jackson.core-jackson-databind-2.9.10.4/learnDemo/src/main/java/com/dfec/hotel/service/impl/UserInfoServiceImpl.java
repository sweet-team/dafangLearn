package com.dfec.hotel.service.impl;

import com.dfec.hotel.entity.UserInfo;
import com.dfec.hotel.mapper.UserInfoMapper;
import com.dfec.hotel.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 注册用户信息表 服务实现类
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
