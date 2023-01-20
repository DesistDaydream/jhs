package com.tencent.qcloud.tuicore.util;

import android.content.Context;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes3.dex */
public class DateTimeUtil {
    private static final long day = 86400000;
    private static final long hour = 3600000;
    private static final long minute = 60000;
    private static final long month = 2678400000L;
    private static final String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
    private static final long year = 32140800000L;

    public static String formatSeconds(long j2) {
        Context appContext = TUIConfig.getAppContext();
        StringBuilder sb = new StringBuilder();
        sb.append(j2);
        int i2 = R.string.date_second_short;
        sb.append(appContext.getString(i2));
        String sb2 = sb.toString();
        if (j2 > 60) {
            long j3 = j2 % 60;
            long j4 = j2 / 60;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(j4);
            int i3 = R.string.date_minute_short;
            sb3.append(appContext.getString(i3));
            sb3.append(j3);
            sb3.append(appContext.getString(i2));
            String sb4 = sb3.toString();
            if (j4 > 60) {
                long j5 = j4 % 60;
                long j6 = j4 / 60;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j6);
                int i4 = R.string.date_hour_short;
                sb5.append(appContext.getString(i4));
                sb5.append(j5);
                sb5.append(appContext.getString(i3));
                sb5.append(j3);
                sb5.append(appContext.getString(i2));
                String sb6 = sb5.toString();
                long j7 = j6 % 24;
                if (j7 == 0) {
                    return (j6 / 24) + appContext.getString(R.string.date_day_short);
                } else if (j6 > 24) {
                    return (j6 / 24) + appContext.getString(R.string.date_day_short) + j7 + appContext.getString(i4) + j5 + appContext.getString(i3);
                } else {
                    return sb6;
                }
            }
            return sb4;
        }
        return sb2;
    }

    public static String formatSecondsTo00(int i2) {
        String str;
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        int i3 = i2 % 60;
        int i4 = i2 / 60;
        if (i4 > 0) {
            int i5 = i4 % 60;
            int i6 = i4 / 60;
            if (i6 > 0) {
                StringBuilder sb5 = new StringBuilder();
                if (i6 >= 10) {
                    sb2 = new StringBuilder();
                    sb2.append(i6);
                    sb2.append("");
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("0");
                    sb2.append(i6);
                }
                sb5.append(sb2.toString());
                sb5.append(Constants.COLON_SEPARATOR);
                if (i5 >= 10) {
                    sb3 = new StringBuilder();
                    sb3.append(i5);
                    sb3.append("");
                } else {
                    sb3 = new StringBuilder();
                    sb3.append("0");
                    sb3.append(i5);
                }
                sb5.append(sb3.toString());
                sb5.append(Constants.COLON_SEPARATOR);
                if (i3 >= 10) {
                    sb4 = new StringBuilder();
                    sb4.append(i3);
                    sb4.append("");
                } else {
                    sb4 = new StringBuilder();
                    sb4.append("0");
                    sb4.append(i3);
                }
                sb5.append(sb4.toString());
                return sb5.toString();
            }
            StringBuilder sb6 = new StringBuilder();
            if (i5 >= 10) {
                sb = new StringBuilder();
                sb.append(i5);
                sb.append("");
            } else {
                sb = new StringBuilder();
                sb.append("0");
                sb.append(i5);
            }
            sb6.append(sb.toString());
            sb6.append(Constants.COLON_SEPARATOR);
            if (i3 >= 10) {
                str2 = i3 + "";
            } else {
                str2 = "0" + i3;
            }
            sb6.append(str2);
            return sb6.toString();
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append("00:");
        if (i3 >= 10) {
            str = i3 + "";
        } else {
            str = "0" + i3;
        }
        sb7.append(str);
        return sb7.toString();
    }

    public static long getStringToDate(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        return date.getTime();
    }

    public static String getTimeFormatText(Date date, Boolean bool) {
        String str;
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        int i2 = calendar2.get(6);
        int i3 = calendar2.get(1);
        calendar2.setTime(date);
        int i4 = calendar2.get(1);
        int i5 = calendar2.get(6);
        int i6 = calendar2.get(12);
        String str2 = calendar2.get(11) + Constants.COLON_SEPARATOR;
        if (i6 < 10) {
            str = str2 + "0" + i6;
        } else {
            str = str2 + i6;
        }
        int i7 = calendar2.get(7);
        int i8 = calendar2.get(3);
        int i9 = calendar.get(3);
        if (i2 == i5) {
            return str;
        }
        Context appContext = TUIConfig.getAppContext();
        int i10 = i2 - i5;
        if (i10 == 1 && i3 == i4) {
            return appContext.getString(R.string.date_yesterday) + ExpandableTextView.N + str;
        } else if (i10 == 2 && i3 == i4) {
            return appContext.getString(R.string.date_before_yesterday) + ExpandableTextView.N + str;
        } else if (i10 <= 2 || i3 != i4) {
            if (bool.booleanValue()) {
                return i4 + "年" + Integer.valueOf(calendar2.get(2) + 1) + "月" + calendar2.get(5) + "日 " + str;
            }
            return i4 + "年" + Integer.valueOf(calendar2.get(2) + 1) + "月" + calendar2.get(5) + "日 ";
        } else if (i8 == i9) {
            if (bool.booleanValue()) {
                return weekDays[i7] + ExpandableTextView.N + str;
            }
            return weekDays[i7];
        } else if (bool.booleanValue()) {
            return Integer.valueOf(calendar2.get(2) + 1) + "月" + calendar2.get(5) + "日 " + str;
        } else {
            return Integer.valueOf(calendar2.get(2) + 1) + "月" + calendar2.get(5) + "日 ";
        }
    }
}
