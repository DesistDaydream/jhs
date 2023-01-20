package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.gt;
import com.xiaomi.push.gu;
import com.xiaomi.push.ha;
import com.xiaomi.push.hq;
import com.xiaomi.push.ib;
import com.xiaomi.push.jl;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class bc {
    private static AtomicLong a = new AtomicLong(0);
    private static SimpleDateFormat b;

    /* renamed from: c  reason: collision with root package name */
    private static String f9128c;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        b = simpleDateFormat;
        f9128c = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    private static hq a(String str, String str2, gt gtVar) {
        return new hq(GMNetworkPlatformConst.AD_NETWORK_NO_PRICE, false).d(str).b(str2).a(com.xiaomi.push.c.a(ib.a(gtVar))).c(ha.UploadTinyData.ah);
    }

    public static synchronized String a() {
        String str;
        synchronized (bc.class) {
            String format = b.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(f9128c, format)) {
                a.set(0L);
                f9128c = format;
            }
            str = format + Constants.ACCEPT_TIME_SEPARATOR_SERVER + a.incrementAndGet();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.xiaomi.push.hq> a(java.util.List<com.xiaomi.push.gu> r11, java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r0 = 0
            if (r11 != 0) goto L9
            java.lang.String r11 = "requests can not be null in TinyDataHelper.transToThriftObj()."
        L5:
            com.xiaomi.a.a.a.c.d(r11)
            return r0
        L9:
            int r1 = r11.size()
            if (r1 != 0) goto L12
            java.lang.String r11 = "requests.length is 0 in TinyDataHelper.transToThriftObj()."
            goto L5
        L12:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.xiaomi.push.gt r2 = new com.xiaomi.push.gt
            r2.<init>()
            r3 = 0
            r4 = 0
            r5 = 0
        L1f:
            int r6 = r11.size()
            if (r4 >= r6) goto Laa
            java.lang.Object r6 = r11.get(r4)
            com.xiaomi.push.gu r6 = (com.xiaomi.push.gu) r6
            if (r6 != 0) goto L2f
            goto La6
        L2f:
            java.util.Map r7 = r6.o()
            if (r7 == 0) goto L6e
            java.util.Map r7 = r6.o()
            java.lang.String r8 = "item_size"
            boolean r7 = r7.containsKey(r8)
            if (r7 == 0) goto L6e
            java.util.Map r7 = r6.o()
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            boolean r9 = android.text.TextUtils.isEmpty(r7)
            if (r9 != 0) goto L56
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Exception -> L56
            goto L57
        L56:
            r7 = 0
        L57:
            java.util.Map r9 = r6.o()
            int r9 = r9.size()
            r10 = 1
            if (r9 != r10) goto L66
            r6.a(r0)
            goto L6f
        L66:
            java.util.Map r9 = r6.o()
            r9.remove(r8)
            goto L6f
        L6e:
            r7 = 0
        L6f:
            if (r7 > 0) goto L76
            byte[] r7 = com.xiaomi.push.ib.a(r6)
            int r7 = r7.length
        L76:
            if (r7 <= r14) goto L91
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "TinyData is too big, ignore upload request item:"
            r7.append(r8)
            java.lang.String r6 = r6.m()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.xiaomi.a.a.a.c.d(r6)
            goto La6
        L91:
            int r8 = r5 + r7
            if (r8 <= r14) goto La2
            com.xiaomi.push.hq r2 = a(r12, r13, r2)
            r1.add(r2)
            com.xiaomi.push.gt r2 = new com.xiaomi.push.gt
            r2.<init>()
            r5 = 0
        La2:
            r2.a(r6)
            int r5 = r5 + r7
        La6:
            int r4 = r4 + 1
            goto L1f
        Laa:
            int r11 = r2.a()
            if (r11 == 0) goto Lb7
            com.xiaomi.push.hq r11 = a(r12, r13, r2)
            r1.add(r11)
        Lb7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.bc.a(java.util.List, java.lang.String, java.lang.String, int):java.util.ArrayList");
    }

    public static void a(Context context, String str, String str2, long j2, String str3) {
        gu guVar = new gu();
        guVar.d(str);
        guVar.c(str2);
        guVar.a(j2);
        guVar.b(str3);
        guVar.a("push_sdk_channel");
        guVar.g(context.getPackageName());
        guVar.e(context.getPackageName());
        guVar.c(true);
        guVar.b(System.currentTimeMillis());
        guVar.f(a());
        be.a(context, guVar);
    }

    public static void a(String str, String str2, String str3, q qVar) {
        if (qVar == null) {
            return;
        }
        gu guVar = new gu();
        guVar.d(str);
        guVar.c(str2);
        guVar.g(str3);
        guVar.e(str3);
        HashMap hashMap = new HashMap();
        hashMap.put("chid", String.valueOf(qVar.a));
        hashMap.put("screen_on", String.valueOf(qVar.f9187c));
        hashMap.put("wifi", String.valueOf(qVar.f9188d));
        hashMap.put("rx_msg", String.valueOf(qVar.f9189e));
        hashMap.put("enqueue", String.valueOf(qVar.f9190f));
        hashMap.put("num", String.valueOf(qVar.b));
        hashMap.put("run", String.valueOf(qVar.f9191g));
        hashMap.put("send", String.valueOf(System.currentTimeMillis()));
        guVar.a(hashMap);
        be.a(guVar);
    }

    public static boolean a(gu guVar, boolean z) {
        String str;
        if (guVar == null) {
            str = "item is null, verfiy ClientUploadDataItem failed.";
        } else if (!z && TextUtils.isEmpty(guVar.a)) {
            str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(guVar.f8710g)) {
            str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(guVar.f8706c)) {
            str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (!com.xiaomi.push.ar.d(guVar.f8710g)) {
            str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (com.xiaomi.push.ar.d(guVar.f8706c)) {
            String str2 = guVar.b;
            if (str2 == null || str2.length() <= 10240) {
                return false;
            }
            str = "item.data is too large(" + guVar.b.length() + "), max size for data is 10240 , verfiy ClientUploadDataItem failed.";
        } else {
            str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
        }
        com.xiaomi.a.a.a.c.a(str);
        return true;
    }

    public static boolean a(String str) {
        return !jl.d() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}
