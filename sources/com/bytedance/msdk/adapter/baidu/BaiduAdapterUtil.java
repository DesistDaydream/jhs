package com.bytedance.msdk.adapter.baidu;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class BaiduAdapterUtil {
    public static Map<String, Integer> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("0", 0);
        a.put("0103010", 1);
        a.put("0103011", 1);
        a.put("0103012", 1);
        a.put("0103060", 2);
        a.put("0107001", 3);
        a.put("0107002", 3);
        a.put("0107003", 4);
        a.put("1020001", 5);
        a.put("1040001", 6);
        a.put("1040003", 7);
        a.put("3030002", 8);
    }

    public static int dp2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean isNativeSmartOpt(int i2) {
        return i2 == 28 || i2 == 29 || i2 == 30 || i2 == 33 || i2 == 34 || i2 == 35 || i2 == 36 || i2 == 37;
    }
}
