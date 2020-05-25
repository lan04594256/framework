//package com.lwl.common.view.interceptor;
//
//import com.alibaba.fastjson.JSONObject;
//import com.lwl.common.common.BizException;
//import com.lwl.common.common.CommonConstans;
//import com.lwl.common.common.UserUtil;
//import com.lwl.common.entity.CbUser;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
///**
// * token鉴定
// *
// * @version: V1.0
// * @author: <a href=mailto:lanwenliang@yidianlife.com>蓝文良</a>
// */
//@Slf4j
////@Component
//public class HeaderTokenInterceptor implements HandlerInterceptor {
//
//    @Resource
//    StringRedisTemplate stringRedisTemplate;
//
//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//                             Object handler) throws Exception {
//        return run(httpServletRequest, httpServletResponse);
//    }
//
//    private Boolean run(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
//        // 获取我们请求头中的token验证字符
//        String token;
//        try {
//            token = httpServletRequest.getHeaders((HttpHeaders.AUTHORIZATION)).nextElement();
//            // 检测当前页面,我们设置当页面不是登录页面时对其进行拦截
//            System.out.println("-------登录拦截成功-------------");
//            if (StringUtils.isEmpty(token)) {
//                throw new BizException(8000, "没有有效token");
//            }
//            //查询redis
//            //判断是否存在，不存在直接打回
//            CbUser cbUser = JSONObject.parseObject(stringRedisTemplate.opsForValue().get("key" + token), CbUser.class);
//            if (cbUser == null) {
//                throw new BizException(8000, "请重新登录");
//            }
//            UserUtil.setUserInfo(cbUser);
//            //设置TOKEN过期时间
//            stringRedisTemplate.expire("key" + token, CommonConstans.LOGIN_TIME_OUT, TimeUnit.MINUTES);
//            //防止一直占REDIS
//            stringRedisTemplate.expire("key" + cbUser.getPhone(), CommonConstans.LOGIN_TIME_OUT + 1, TimeUnit.MINUTES);
//        } catch (Exception ex) {
//            throw new BizException(8000, ex.getMessage());
//        }
//        return true;
//
//    }
//}
