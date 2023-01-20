package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes3.dex */
public class a {
    private static String a = null;
    private static final String b = "umeng+";

    /* renamed from: c  reason: collision with root package name */
    private static final String f7308c = "ek__id";

    /* renamed from: d  reason: collision with root package name */
    private static final String f7309d = "ek_key";

    /* renamed from: e  reason: collision with root package name */
    private static String f7310e = "";

    /* renamed from: f  reason: collision with root package name */
    private static final String f7311f = "umeng_subprocess_info";

    /* renamed from: g  reason: collision with root package name */
    private static String f7312g = "";

    /* renamed from: h  reason: collision with root package name */
    private static a f7313h;

    private a() {
    }

    public static a a() {
        if (f7313h == null) {
            synchronized (a.class) {
                if (f7313h == null) {
                    f7313h = new a();
                }
            }
        }
        return f7313h;
    }

    private String c(String str) {
        String str2 = "";
        try {
            String substring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < substring.length(); i2++) {
                char charAt = substring.charAt(i2);
                if (Character.isDigit(charAt)) {
                    if (Integer.parseInt(Character.toString(charAt)) == 0) {
                        sb.append(0);
                    } else {
                        sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                    }
                } else {
                    sb.append(charAt);
                }
            }
            str2 = sb.toString();
            return str2 + new StringBuilder(str2).reverse().toString();
        } catch (Throwable unused) {
            return str2;
        }
    }

    public String b(String str) {
        String str2;
        String str3 = null;
        try {
            if (!TextUtils.isEmpty(a)) {
                str = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), a.getBytes()));
            }
            return str;
        } catch (Exception unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            if (TextUtils.isEmpty(f7310e)) {
                return null;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                String str4 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f7310e.getBytes()));
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                    return str4;
                } catch (Exception unused2) {
                    str3 = str4;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                    try {
                        str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f7312g.getBytes()));
                    } catch (Throwable unused3) {
                    }
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                        return str2;
                    } catch (Throwable unused4) {
                        str3 = str2;
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str3;
                    }
                }
            } catch (Exception unused5) {
            }
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f7308c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    f7310e = c(multiProcessSP);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + f7310e);
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f7311f, 0);
                if (sharedPreferences != null) {
                    f7312g = sharedPreferences.getString(f7308c, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + f7312g);
                }
                a = c(UMUtils.genId());
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + a);
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
