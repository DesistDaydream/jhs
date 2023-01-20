package com.xiaomi.mipush.sdk;

import com.xiaomi.push.gv;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class l {
    private static HashMap<e, a> a = new HashMap<>();

    /* loaded from: classes3.dex */
    public static class a {
        public String a;
        public String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    static {
        a(e.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(e.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(e.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(e.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static au a(e eVar) {
        int i2 = m.a[eVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return null;
                    }
                    return au.UPLOAD_FTOS_TOKEN;
                }
                return au.UPLOAD_COS_TOKEN;
            }
            return au.UPLOAD_FCM_TOKEN;
        }
        return au.UPLOAD_HUAWEI_TOKEN;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static a m100a(e eVar) {
        return a.get(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gv m101a(e eVar) {
        return gv.AggregatePushSwitch;
    }

    private static void a(e eVar, a aVar) {
        if (aVar != null) {
            a.put(eVar, aVar);
        }
    }
}
