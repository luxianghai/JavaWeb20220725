package com.lxh.util;

import javax.servlet.http.Cookie;

public class CookieUtils {

    /**
     * 获取指定key的cookie对象
     * @param key
     * @param cookies
     * @return
     */
    public static Cookie getCookie(String key, Cookie[] cookies) {
        if (key == null || "".equals(key) || null == cookies || 0 == cookies.length) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (key.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

}
