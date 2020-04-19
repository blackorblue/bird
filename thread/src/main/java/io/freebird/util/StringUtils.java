package io.freebird.util;

/**
 * @author freebird
 * @date 2020/4/19 17:23
 */
public final class StringUtils {


    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0 || str.equals("null");
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
