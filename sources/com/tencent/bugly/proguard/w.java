package com.tencent.bugly.proguard;

import android.content.Context;
import android.util.Pair;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class w implements Runnable {
    private int a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f6802c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6803d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f6804e;

    /* renamed from: f  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f6805f;

    /* renamed from: g  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.strategy.a f6806g;

    /* renamed from: h  reason: collision with root package name */
    private final s f6807h;

    /* renamed from: i  reason: collision with root package name */
    private final v f6808i;

    /* renamed from: j  reason: collision with root package name */
    private final int f6809j;

    /* renamed from: k  reason: collision with root package name */
    private final u f6810k;

    /* renamed from: l  reason: collision with root package name */
    private final u f6811l;

    /* renamed from: m  reason: collision with root package name */
    private String f6812m;
    private final String n;
    private final Map<String, String> o;
    private int p;
    private long q;
    private long r;
    private boolean s;

    public w(Context context, int i2, int i3, byte[] bArr, String str, String str2, u uVar, boolean z, boolean z2) {
        this(context, i2, i3, bArr, str, str2, uVar, 2, 30000, z2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.tencent.bugly.proguard.ao r5, boolean r6, int r7, java.lang.String r8) {
        /*
            r4 = this;
            int r5 = r4.f6803d
            r0 = 630(0x276, float:8.83E-43)
            if (r5 == r0) goto L1a
            r0 = 640(0x280, float:8.97E-43)
            if (r5 == r0) goto L17
            r0 = 830(0x33e, float:1.163E-42)
            if (r5 == r0) goto L1a
            r0 = 840(0x348, float:1.177E-42)
            if (r5 == r0) goto L17
            java.lang.String r5 = java.lang.String.valueOf(r5)
            goto L1c
        L17:
            java.lang.String r5 = "userinfo"
            goto L1c
        L1a:
            java.lang.String r5 = "crash"
        L1c:
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L2a
            java.lang.Object[] r7 = new java.lang.Object[r0]
            r7[r1] = r5
            java.lang.String r5 = "[Upload] Success: %s"
            com.tencent.bugly.proguard.y.a(r5, r7)
            goto L3d
        L2a:
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r2[r1] = r7
            r2[r0] = r5
            r5 = 2
            r2[r5] = r8
            java.lang.String r5 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.proguard.y.e(r5, r2)
        L3d:
            long r0 = r4.q
            long r2 = r4.r
            long r0 = r0 + r2
            r2 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L5d
            com.tencent.bugly.proguard.v r5 = r4.f6808i
            boolean r7 = r4.s
            long r0 = r5.a(r7)
            long r2 = r4.q
            long r0 = r0 + r2
            long r2 = r4.r
            long r0 = r0 + r2
            com.tencent.bugly.proguard.v r5 = r4.f6808i
            boolean r7 = r4.s
            r5.a(r0, r7)
        L5d:
            com.tencent.bugly.proguard.u r5 = r4.f6810k
            if (r5 == 0) goto L64
            r5.a(r6, r8)
        L64:
            com.tencent.bugly.proguard.u r5 = r4.f6811l
            if (r5 == 0) goto L6b
            r5.a(r6, r8)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(com.tencent.bugly.proguard.ao, boolean, int, java.lang.String):void");
    }

    public final void b(long j2) {
        this.r += j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x01cf A[LOOP:0: B:37:0x00ce->B:69:0x01cf, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d3 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.run():void");
    }

    public w(Context context, int i2, int i3, byte[] bArr, String str, String str2, u uVar, int i4, int i5, boolean z, Map<String, String> map) {
        this.a = 2;
        this.b = 30000;
        this.f6812m = null;
        this.p = 0;
        this.q = 0L;
        this.r = 0L;
        this.s = false;
        this.f6802c = context;
        this.f6805f = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f6804e = bArr;
        this.f6806g = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.f6807h = s.a(context);
        this.f6808i = v.a();
        this.f6809j = i2;
        this.f6812m = str;
        this.n = str2;
        this.f6810k = uVar;
        this.f6811l = null;
        this.f6803d = i3;
        if (i4 > 0) {
            this.a = i4;
        }
        if (i5 > 0) {
            this.b = i5;
        }
        this.s = z;
        this.o = map;
    }

    private static boolean a(ao aoVar, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        if (aoVar == null) {
            y.d("resp == null!", new Object[0]);
            return false;
        }
        byte b = aoVar.a;
        if (b != 0) {
            y.e("resp result error %d", Byte.valueOf(b));
            return false;
        }
        try {
            if (!ab.a(aoVar.f6714e) && !com.tencent.bugly.crashreport.common.info.a.b().m().equals(aoVar.f6714e)) {
                o.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "device", aoVar.f6714e.getBytes("UTF-8"), (n) null, true);
                aVar.f(aoVar.f6714e);
            }
        } catch (Throwable th) {
            y.a(th);
        }
        aVar.f6524h = aoVar.f6713d;
        int i2 = aoVar.b;
        if (i2 == 510) {
            byte[] bArr = aoVar.f6712c;
            if (bArr == null) {
                y.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i2));
                return false;
            }
            aq aqVar = (aq) a.a(bArr, aq.class);
            if (aqVar == null) {
                y.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(aoVar.b));
                return false;
            }
            aVar2.a(aqVar);
        }
        return true;
    }

    private Pair<Boolean, Boolean> a(byte[] bArr, Map<String, String> map) {
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        if (bArr == null) {
            y.e("[Upload] Failed to upload(%d): %s", 1, "Failed to upload for no response!");
            return new Pair<>(bool2, bool);
        }
        y.c("[Upload] Received %d bytes", Integer.valueOf(bArr.length));
        if (bArr.length == 0) {
            a(null, false, 1, "response data from server is empty");
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    y.c("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
                }
            }
            return new Pair<>(bool2, bool2);
        }
        return new Pair<>(bool, bool);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.Pair<java.lang.Boolean, java.lang.Boolean> a(java.util.Map<java.lang.String, java.lang.String> r11) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(java.util.Map):android.util.Pair");
    }

    public final void a(long j2) {
        this.p++;
        this.q += j2;
    }

    private static String a(String str) {
        if (ab.a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            y.a(th);
            return str;
        }
    }
}
