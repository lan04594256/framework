//package com.lwl.common.view.interceptor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * <p>自定义拦截器配置类    </p>
// *
// * @version: V1.0
// * @author: <a href=mailto:lanwenliang@yidianlife.com>蓝文良</a>
// */
////@Configuration
//public class MyInterceptorConfig extends WebMvcConfigurationSupport {
//
//    @Autowired
//    private HeaderTokenInterceptor headerTokenInterceptor;
//
//    /**
//     * 功能描述:
//     * 配置静态资源,避免静态资源请求被拦截
//     *
//     * @auther: Tt(yehuawei)
//     * @date:
//     * @param:
//     * @return:
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations(
//                "classpath:/static/");
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
//                "classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations(
//                "classpath:/META-INF/resources/webjars/");
//        super.addResourceHandlers(registry);
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //不需要拦截的，白名单
//        List<String> list = new ArrayList();
//        //登录、发送短信验证码等
//        list.add("/cbUser/**");
//        //回调事件
//        list.add("/callback/**");
//        //检查验证码
//        list.add("/check_auth_code");
//        list.add("/swagger-resources/**");
//        list.add("/swagger-ui.html/**");
//        //首页
//        registry.addInterceptor(headerTokenInterceptor).excludePathPatterns(list).addPathPatterns("/cbCardInfo/**");
//        super.addInterceptors(registry);
//    }
//
//
//}
