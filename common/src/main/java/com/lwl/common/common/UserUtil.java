//package com.lwl.common.common;
//
//import com.lwl.common.entity.CbUser;
//
//import java.io.Serializable;
//
///**
// * <p>用户信息工具类</p>
// *
// * @version: V1.0
// * @author: <a href=mailto:lanwenliang@yidianlife.com>蓝文良</a>
// */
//public class UserUtil implements Serializable {
//
//    private static final long serialVersionUID = 931937842490178146L;
//    private static ThreadLocal<CbUser> userInfoThreadLocal = new ThreadLocal();
//
//    public UserUtil() {
//    }
//
//    public static void setUserInfo(CbUser userInfo) {
//        userInfoThreadLocal.set(userInfo);
//    }
//
//    public static void clear() {
//        userInfoThreadLocal.remove();
//    }
//
//    public static Long getUserId() {
//        CbUser userInfo = getUserInfo();
//        return userInfo == null ? null : userInfo.getId();
//    }
//
//    public static CbUser getUserInfo() {
//        return userInfoThreadLocal.get();
//    }
//}
