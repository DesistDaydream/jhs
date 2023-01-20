package com.xiaomi.push.service;

import com.xiaomi.push.da;
import com.xiaomi.push.p;
import com.xiaomi.push.service.ay;
import java.util.List;

/* loaded from: classes3.dex */
public class az extends p.b {
    public boolean a = false;
    public final /* synthetic */ ay b;

    public az(ay ayVar) {
        this.b = ayVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039 A[Catch: Exception -> 0x0047, TRY_LEAVE, TryCatch #0 {Exception -> 0x0047, blocks: (B:2:0x0000, B:4:0x0012, B:9:0x0024, B:11:0x0039), top: B:16:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // com.xiaomi.push.p.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            r3 = this;
            android.content.Context r0 = com.xiaomi.push.jl.a()     // Catch: java.lang.Exception -> L47
            com.xiaomi.push.service.b r0 = com.xiaomi.push.service.b.a(r0)     // Catch: java.lang.Exception -> L47
            java.lang.String r0 = r0.a()     // Catch: java.lang.Exception -> L47
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L47
            if (r1 != 0) goto L22
            com.xiaomi.push.jg r1 = com.xiaomi.push.jg.China     // Catch: java.lang.Exception -> L47
            java.lang.String r1 = r1.name()     // Catch: java.lang.Exception -> L47
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Exception -> L47
            if (r0 == 0) goto L1f
            goto L22
        L1f:
            java.lang.String r0 = "https://resolver.msg.global.xiaomi.net/psc/?t=a"
            goto L24
        L22:
            java.lang.String r0 = "https://resolver.msg.xiaomi.net/psc/?t=a"
        L24:
            android.content.Context r1 = com.xiaomi.push.jl.a()     // Catch: java.lang.Exception -> L47
            r2 = 0
            java.lang.String r0 = com.xiaomi.push.cc.a(r1, r0, r2)     // Catch: java.lang.Exception -> L47
            r1 = 10
            byte[] r0 = android.util.Base64.decode(r0, r1)     // Catch: java.lang.Exception -> L47
            com.xiaomi.push.da$a r0 = com.xiaomi.push.da.a.a(r0)     // Catch: java.lang.Exception -> L47
            if (r0 == 0) goto L60
            com.xiaomi.push.service.ay r1 = r3.b     // Catch: java.lang.Exception -> L47
            com.xiaomi.push.service.ay.a(r1, r0)     // Catch: java.lang.Exception -> L47
            r0 = 1
            r3.a = r0     // Catch: java.lang.Exception -> L47
            com.xiaomi.push.service.ay r0 = r3.b     // Catch: java.lang.Exception -> L47
            com.xiaomi.push.service.ay.a(r0)     // Catch: java.lang.Exception -> L47
            goto L60
        L47:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "fetch config failure: "
            r1.append(r2)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.xiaomi.a.a.a.c.a(r0)
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.az.b():void");
    }

    @Override // com.xiaomi.push.p.b
    public void c() {
        List list;
        List list2;
        ay.a[] aVarArr;
        da.a aVar;
        this.b.f9113d = null;
        if (this.a) {
            synchronized (this.b) {
                list = this.b.b;
                list2 = this.b.b;
                aVarArr = (ay.a[]) list.toArray(new ay.a[list2.size()]);
            }
            for (ay.a aVar2 : aVarArr) {
                aVar = this.b.f9112c;
                aVar2.a(aVar);
            }
        }
    }
}
