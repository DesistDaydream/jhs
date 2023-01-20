package com.tencent.tpns.baseapi.base.logger;

import android.content.Context;
import android.os.Environment;
import com.m7.imkfsdk.utils.permission.PermissionConstants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes3.dex */
public class LogUtil {
    public static String PATTERN_DATETIME_FILENAME = "yyyyMMdd_HHmm";
    private static ThreadLocal<DateFormat> a = new ThreadLocal<>();

    private static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            TBaseLogger.e("LogUtil", "checkPermission error", th);
            return false;
        }
    }

    public static String formatDate(Date date, String str) {
        try {
            return a(str).format(date);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getTodayDateTimeForFilename() {
        return new SimpleDateFormat(PATTERN_DATETIME_FILENAME).format(new Date());
    }

    public static boolean isDaysAgo(Date date, int i2) {
        if (date == null) {
            return false;
        }
        try {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(date.getTime());
            calendar.add(5, -i2);
            return calendar.after(calendar2);
        } catch (Throwable th) {
            TBaseLogger.e("LogUtil", "action -> isDaysAgo ", th);
            return false;
        }
    }

    public static boolean isSDCardMounted(Context context) {
        String externalStorageState;
        if (context == null) {
            return false;
        }
        try {
            if (a(context, PermissionConstants.STORE) && (externalStorageState = Environment.getExternalStorageState()) != null) {
                if (externalStorageState.equals("mounted")) {
                    return true;
                }
            }
        } catch (Throwable th) {
            TBaseLogger.e("LogUtil", "isSDCardMounted", th);
        }
        return false;
    }

    public static Date parse(String str, String str2) {
        try {
            return a(str2).parse(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Date parseDateInFilename(String str) {
        try {
            return new SimpleDateFormat(PATTERN_DATETIME_FILENAME).parse(str);
        } catch (Throwable th) {
            TBaseLogger.e("LogUtil", "parse filename datetime error - " + str, th);
            return null;
        }
    }

    private static DateFormat a(String str) {
        DateFormat dateFormat = a.get();
        if (dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            a.set(simpleDateFormat);
            return simpleDateFormat;
        }
        return dateFormat;
    }
}
