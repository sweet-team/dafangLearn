package com.dfec.hotel.auth;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.dfec.hotel.entity.WorkerInfo;
import com.dfec.hotel.utils.RedisUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OAuth2Realm extends AuthorizingRealm {
    @Autowired
    private RedisUtils redisUtils;

    public OAuth2Realm() {
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        WorkerInfo user = (WorkerInfo)principals.getPrimaryPrincipal();
//        Set<String> permsSet = (Set)this.redisUtils.get("user:perms:" + user.getRole(), Set.class);
        String s = this.redisUtils.get("user:perms:" + user.getWorkerId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setStringPermissions(permsSet);
        Set<String> objects = new HashSet<>();
        objects.add(s);
        // 一个用户可以有无数个角色
        info.setRoles(objects);
        return info;
    }

        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String)token.getPrincipal();
        String userstr = this.redisUtils.get("token:" + accessToken);
        if (StringUtils.isBlank(userstr)) {
            throw new IncorrectCredentialsException("token失效，请重新登录");
        } else {
            WorkerInfo user = (WorkerInfo) JSON.toJavaObject(JSON.parseObject(userstr), WorkerInfo.class);
            this.redisUtils.set("user:perms:"+user.getWorkerId(),user.getRole());
//            if (user.getStatus() == 0) {
//                throw new LockedAccountException("账号已被锁定,请联系管理员");
//            } else {
//                long expiretime = this.redisUtils.getExpire("token:" + accessToken, TimeUnit.MINUTES);
////                if (user.getStatus() == 1 && expiretime != -1L && expiretime <= 60L) {
//                if ( expiretime != -1L && expiretime <= 60L) {
//                    this.redisUtils.expire("token:" + accessToken, 7200L, TimeUnit.SECONDS);
//                    this.redisUtils.expire("user:token:" + user.getWorkerId(), 7200L, TimeUnit.SECONDS);
                    this.redisUtils.expire("user:perms:" + user.getWorkerId(), 7200L, TimeUnit.SECONDS);
//                    this.redisUtils.expire("user:auth:deptids:" + user.getWorkerId(), 7200L, TimeUnit.SECONDS);
//                }

                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, this.getName());
                return info;
//            }
        }
    }
}
