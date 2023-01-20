package cn.thinkingdata.android.aop.push;

import e.t.c;

/* loaded from: classes.dex */
public class TAPushUtils {
    public static String getJPushSource(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return "vivo";
                    }
                    return "OPPO";
                }
                return c.b;
            }
            return "HUAWEI";
        }
        return "Xiaomi";
    }
}
