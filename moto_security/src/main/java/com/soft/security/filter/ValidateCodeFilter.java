package com.soft.security.filter;


import com.alibaba.fastjson.JSONObject;
import com.soft.common.model.ApiError;
import com.soft.security.config.properties.MySecurityProperties;
import com.soft.security.config.properties.ValidateCodeProperties;
import com.soft.security.controller.ValidateCodeController;
import com.soft.security.exception.ValidateCodeException;
import com.soft.security.validate.ImageCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author sucx
 * @projectName moto_parent
 * @description:
 * @date 2020/4/2914:01
 */
@Slf4j
@Component
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {


    /**
     * Session 对象
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * 创建一个Set 集合 存放 需要验证码的 urls
     */
    private Set<String> urls = new HashSet<>();

    /**
     * security applicaiton  配置属性
     */
    @Autowired
    private MySecurityProperties securityProperties;
    /**
     * spring的一个工具类：用来判断 两字符串 是否匹配
     */
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    /**
     * 这个方法是 InitializingBean 接口下的一个方法， 在初始化配置完成后 运行此方法
     */
    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        ValidateCodeProperties code = securityProperties.getCode();
        log.info(String.valueOf(code));
        //将 application 配置中的 url 属性进行 切割
        String[] configUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getImage().getUrl(), ",");
        //添加到 Set 集合里
        urls.addAll(Arrays.asList(configUrls));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        boolean action = false;
        for (String url : urls) {
            //如果请求的url 和 配置中的url 相匹配
            if (pathMatcher.match(url, request.getRequestURI())) {
                action = true;
            }
        }

        //拦截请求
        if (action) {
            log.info("拦截成功" + request.getRequestURI());
            //如果是登录请求
            //验证码校验
            try {
                validate(new ServletWebRequest(request));
                //通过校验-放行
                filterChain.doFilter(request, response);
            }catch (ValidateCodeException e){
                ApiError apiError = new ApiError(BAD_REQUEST.value(),e.getMessage());
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(JSONObject.toJSONString(apiError));
                return;
            }
        } else {
            //不做任何处理，调用后面的 过滤器
            filterChain.doFilter(request, response);
        }
    }

    private void validate(ServletWebRequest request) throws ServletRequestBindingException {
        //从session中取出 验证码
        ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(request, ValidateCodeController.SESSION_KEY);
        //从request 请求中 取出 验证码
        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");
        if (StringUtils.isBlank(codeInRequest)) {
            log.info("验证码不能为空");
            throw new ValidateCodeException("验证码不能为空");
        }
        if (codeInSession == null) {
            log.info("验证码不存在");
            throw new ValidateCodeException("验证码不存在");
        }
        if (codeInSession.isExpires()) {
            log.info("验证码已过期");
            sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
            throw new ValidateCodeException("验证码已过期");
        }
        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            log.info("验证码不匹配" + "codeInSession:" + codeInSession.getCode() + ", codeInRequest:" + codeInRequest);
            throw new ValidateCodeException("验证码不匹配");
        }
        //把对应 的 session信息  删掉
        sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
    }

}