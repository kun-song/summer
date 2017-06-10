package com.satansk.summer.site.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/10
 */
public class SiteUtil {
    // 时间格式
    private static final String timePattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * 返回当前系统时间
     *
     * @return 表示时间的字符串，格式：2017-04-25 23:42:37
     */
    public static String now() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern(timePattern));
    }
}
