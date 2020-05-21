package com.dfec.hotel.auth;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.R;
import com.sun.net.httpserver.HttpContext;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OAuth2Filter  extends AuthenticatingFilter {
    public OAuth2Filter() {
    }

    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        String token = this.getRequestToken((HttpServletRequest)request);
        return StringUtils.isBlank(token) ? null : new OAuth2Token(token);
    }

    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return ((HttpServletRequest)request).getMethod().equals(RequestMethod.OPTIONS.name());
    }

    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        String token = this.getRequestToken((HttpServletRequest)request);
        if (!StringUtils.isBlank(token) && !token.equals("null")) {
            return this.executeLogin(request, response);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse)response;
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
//            String json = JSON.toJSONString(R.error(1001, "invalid token"));
            String json = JSON.toJSONString(R.failed("invalid token").setCode(1001));
            httpResponse.getWriter().print(json);
            return false;
        }
    }

    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
//        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());

        try {
            Throwable throwable = e.getCause() == null ? e : e.getCause();
            R r = R.failed( ((Throwable)throwable).getMessage()).setCode(1001);
            String json = JSON.toJSONString(r);
            httpResponse.getWriter().print(json);
        } catch (IOException var9) {
        }

        return false;
    }

    private String getRequestToken(HttpServletRequest httpRequest) {
        String token = httpRequest.getHeader("token");
        if (StringUtils.isBlank(token) || token.equals("null")) {
            token = httpRequest.getParameter("token");
        }

        return token;
    }
}
