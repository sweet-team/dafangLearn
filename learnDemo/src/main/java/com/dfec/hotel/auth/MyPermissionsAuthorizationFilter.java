package com.dfec.hotel.auth;

import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class MyPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {

        System.out.println("PermissionsAuthorizationFilter");
        return false;
    }
}
