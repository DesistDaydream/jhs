package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.dataacquisition.DeviceInfos;

/* loaded from: classes3.dex */
public class TGlobalHelper {
    private static Context a;
    private static volatile String b;
    public static String curProcessName;

    private static synchronized String a() {
        synchronized (TGlobalHelper.class) {
            if (b != null) {
                return b;
            }
            b = DeviceInfos.getDM();
            return b;
        }
    }

    public static Context getContext(Context context) {
        if (a == null) {
            a = context;
        }
        return a;
    }

    public static synchronized String getDM(Context context) {
        synchronized (TGlobalHelper.class) {
            if (b != null) {
                return b;
            }
            if (context == null) {
                context = a;
            }
            if (!Util.isMainProcess(context)) {
                b = (String) PushPreferences.getObject(context, "dm", "");
            } else {
                b = DeviceInfos.getDM();
            }
            if (b == null) {
                b = "";
            }
            return b;
        }
    }

    public static Object loadWithIPC(String str) {
        if (Util.isNullOrEmptyString(str)) {
            return null;
        }
        if ("dm".equals(str)) {
            return a();
        }
        TBaseLogger.d("TGlobalHelper", "don't support type");
        return null;
    }

    public static void setContext(Context context) {
        a = context;
    }
}
