package com.huawei.hms.push.utils;

import com.huawei.hms.support.log.HMSLog;
import e.j.a.c.m.o;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class DateUtil {
    public static String parseMilliSecondToString(Long l2) {
        if (l2 == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(l2);
        } catch (Exception e2) {
            HMSLog.e("DateUtil", "parseMilliSecondToString Exception.", e2);
            return null;
        }
    }

    public static long parseUtcToMillisecond(String str) throws ParseException, StringIndexOutOfBoundsException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(o.a));
        String substring = str.substring(0, str.indexOf("."));
        String substring2 = str.substring(str.indexOf("."));
        return simpleDateFormat.parse(substring + (substring2.substring(0, 4) + "Z")).getTime();
    }
}
