package com.moor.imkf.utils;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.heytap.mcssdk.constant.a;
import com.xiaomi.mipush.sdk.Constants;
import e.t.u.b0;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public class TimeUtil {
    public static String convertTimeToFriendly(long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - j2;
        if (j3 < a.f3314d) {
            return "刚刚";
        }
        if (a.f3314d < j3 && j3 < a.f3315e) {
            return ((int) (j3 / a.f3314d)) + "分钟前";
        } else if (j3 > a.f3315e) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(b0.a.f14659j);
            Date date = new Date(j2);
            String format = simpleDateFormat.format(new Date(currentTimeMillis));
            String format2 = simpleDateFormat.format(date);
            if (format.split(ExpandableTextView.N)[0].equals(format2.split(ExpandableTextView.N)[0])) {
                return "今天" + format2.substring(11);
            } else if (Integer.parseInt(format.substring(8, 9)) - Integer.parseInt(format2.substring(8, 9)) == 1) {
                return "昨天" + format2.substring(11);
            } else if (Integer.parseInt(format.substring(8, 9)) - Integer.parseInt(format2.substring(8, 9)) == 2) {
                return "前天" + format2.substring(11);
            } else {
                return format2.substring(5);
            }
        } else {
            return "";
        }
    }

    public static String convertTimeToFriendlyForChat(long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - j2;
        if (j3 < a.f3314d) {
            return "";
        }
        if (a.f3314d < j3 && j3 < a.f3315e) {
            return ((int) (j3 / a.f3314d)) + "分钟前";
        } else if (j3 > a.f3315e) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(b0.a.f14659j);
            Date date = new Date(j2);
            String format = simpleDateFormat.format(new Date(currentTimeMillis));
            String format2 = simpleDateFormat.format(date);
            if (format.split(ExpandableTextView.N)[0].equals(format2.split(ExpandableTextView.N)[0])) {
                return "今天" + format2.substring(11);
            } else if (Integer.parseInt(format.substring(8, 9)) - Integer.parseInt(format2.substring(8, 9)) == 1) {
                return "昨天" + format2.substring(11);
            } else if (Integer.parseInt(format.substring(8, 9)) - Integer.parseInt(format2.substring(8, 9)) == 2) {
                return "前天" + format2.substring(11);
            } else {
                return format2.substring(5);
            }
        } else {
            return "";
        }
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date());
    }

    public static String getVideoTime(long j2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 <= 0) {
            return "00:00:00";
        }
        int i3 = (j2 > 60L ? 1 : (j2 == 60L ? 0 : -1));
        if (i3 < 0 && i2 > 0) {
            if (j2 < 10) {
                return "00:00:0" + j2 + "";
            }
            return "00:00:" + j2 + "";
        } else if (i3 >= 0 && j2 < 3600) {
            int i4 = (int) (j2 / 60);
            if (i4 < 10) {
                str4 = "0" + i4;
            } else {
                str4 = i4 + "";
            }
            int i5 = (int) (j2 % 60);
            if (i5 < 10) {
                str5 = "0" + i5;
            } else {
                str5 = i5 + "";
            }
            return "00:" + str4 + Constants.COLON_SEPARATOR + str5;
        } else if (j2 >= 3600) {
            int i6 = (int) (j2 / 3600);
            if (i6 < 10) {
                str = "0" + i6;
            } else {
                str = i6 + "";
            }
            long j3 = j2 % 3600;
            int i7 = (int) (j3 / 60);
            if (i7 < 10) {
                str2 = "0" + i7;
            } else {
                str2 = i7 + "";
            }
            int i8 = (int) (j3 % 60);
            if (i8 < 10) {
                str3 = "0" + i8;
            } else {
                str3 = i8 + "";
            }
            return str + Constants.COLON_SEPARATOR + str2 + Constants.COLON_SEPARATOR + str3;
        } else {
            return "";
        }
    }
}
