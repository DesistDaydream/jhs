package com.huawei.hms.utils;

import com.huawei.hms.framework.common.ExceptionCode;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class StringUtil {
    public static String addByteForNum(String str, int i2, char c2) {
        int length = str.length();
        if (length == i2) {
            return str;
        }
        if (length > i2) {
            return str.substring(length - i2);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (length < i2) {
            stringBuffer.append(c2);
            length++;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static boolean checkVersion(String str) {
        return Pattern.compile("(^([0-9]{1,2}\\.){2}[0-9]{1,2}$)|(^([0-9]{1,2}\\.){3}[0-9]{1,3}$)").matcher(str).find();
    }

    public static int convertVersion2Integer(String str) {
        if (checkVersion(str)) {
            String[] split = str.split("\\.");
            if (split.length < 3) {
                return 0;
            }
            int parseInt = (Integer.parseInt(split[0]) * ExceptionCode.CRASH_EXCEPTION) + (Integer.parseInt(split[1]) * 100000) + (Integer.parseInt(split[2]) * 1000);
            return split.length == 4 ? parseInt + Integer.parseInt(split[3]) : parseInt;
        }
        return 0;
    }

    public static String objDesc(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
    }
}
