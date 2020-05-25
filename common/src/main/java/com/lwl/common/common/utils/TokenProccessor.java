package com.lwl.common.common.utils;

import com.lwl.common.common.BizException;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.UUID;

public class TokenProccessor {
    private TokenProccessor() {
    }

    ;
    private static final TokenProccessor instance = new TokenProccessor();

    public static TokenProccessor getInstance() {
        return instance;
    }

    /**
     * 生成Token
     *
     * @return
     */
    public String makeToken() {
        String token = String.valueOf(System.currentTimeMillis());
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            token = encoder.encode(md5);
            token = UUID.randomUUID().toString() + token;
            return token;
        } catch (Exception e) {
            throw new BizException(-1, "用户登录信息生成异常");
        }

    }
}
