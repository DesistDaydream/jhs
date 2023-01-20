package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;

/* loaded from: classes3.dex */
public class StatHelper {
    public static void reportCloudControl(Context context, long j2, int i2, String str, long j3) {
        TBaseLogger.i("StatHelper", "action - reportCloudControl, cloudVersion:" + j2 + ", msg:" + str + ", req:" + j3);
        try {
            Class<?> cls = Class.forName("com.tencent.android.tpush.stat.ServiceStat");
            Class<?> cls2 = Long.TYPE;
            cls.getDeclaredMethod("reportCloudControl", Context.class, cls2, Integer.TYPE, String.class, cls2).invoke(cls, context, Long.valueOf(j2), Integer.valueOf(i2), str, Long.valueOf(j3));
        } catch (Throwable th) {
            TBaseLogger.ww("StatHelper", "unexpected for reportCloudControl, exception:", th);
        }
    }

    public static void reportErrCode(Context context, int i2, String str, long j2, String str2) {
        TBaseLogger.i("StatHelper", "action - reportErrCode, errCode:" + i2 + ", msg:" + str + ", req:" + j2);
        try {
            Class<?> cls = Class.forName("com.tencent.android.tpush.stat.ServiceStat");
            cls.getDeclaredMethod("reportErrCode", Context.class, Integer.TYPE, String.class, Long.TYPE, String.class).invoke(cls, context, Integer.valueOf(i2), str, Long.valueOf(j2), str2);
        } catch (Throwable th) {
            TBaseLogger.ww("StatHelper", "unexpected for reportErrCode, exception:", th);
        }
    }
}
