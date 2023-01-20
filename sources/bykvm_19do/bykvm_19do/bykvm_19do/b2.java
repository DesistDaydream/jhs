package bykvm_19do.bykvm_19do.bykvm_19do;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

/* loaded from: classes.dex */
public class b2 {
    private static long n;
    private static b o;
    private final j2 a;
    private final k2 b;

    /* renamed from: c */
    private b0 f79c;

    /* renamed from: d */
    private b0 f80d;

    /* renamed from: e */
    public String f81e;

    /* renamed from: f */
    private long f82f;

    /* renamed from: g */
    private int f83g;

    /* renamed from: h */
    private long f84h = -1;

    /* renamed from: i */
    private volatile boolean f85i;

    /* renamed from: j */
    private long f86j;

    /* renamed from: k */
    private int f87k;

    /* renamed from: l */
    private String f88l;

    /* renamed from: m */
    private z f89m;

    /* loaded from: classes.dex */
    public static class b extends d0 {
        private b() {
        }
    }

    public b2(k2 k2Var, j2 j2Var) {
        this.b = k2Var;
        this.a = j2Var;
    }

    public static long a(j2 j2Var) {
        long j2 = n + 1;
        n = j2;
        if (j2 % 1000 == 0) {
            j2Var.a(j2 + 1000);
        }
        return n;
    }

    private void a(u uVar, ArrayList<u> arrayList, boolean z) {
        synchronized (this) {
            long j2 = uVar instanceof b ? -1L : uVar.a;
            this.f81e = UUID.randomUUID().toString();
            n = this.a.b();
            this.f84h = j2;
            this.f85i = z;
            this.f86j = 0L;
            if (l0.a) {
                l0.a("startSession, " + this.f81e + ", hadUi:" + z + " data:" + uVar, null);
            }
            if (z) {
                Calendar calendar = Calendar.getInstance();
                String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
                if (TextUtils.isEmpty(this.f88l)) {
                    this.f88l = this.a.u();
                    this.f87k = this.a.v();
                }
                if (str.equals(this.f88l)) {
                    this.f87k++;
                } else {
                    this.f88l = str;
                    this.f87k = 1;
                }
                this.a.a(str, this.f87k);
                this.f83g = 0;
            }
            if (j2 != -1) {
                z zVar = new z();
                zVar.f166c = this.f81e;
                zVar.b = a(this.a);
                zVar.a = this.f84h;
                zVar.f201j = this.b.d();
                zVar.f200i = this.b.c();
                if (this.a.N()) {
                    zVar.f168e = bykvm_19do.bykvm_19do.bykvm_19do.a.c();
                    zVar.f169f = bykvm_19do.bykvm_19do.bykvm_19do.a.d();
                }
                arrayList.add(zVar);
                this.f89m = zVar;
                if (l0.a) {
                    l0.a("gen launch, " + zVar.f166c + ", hadUi:" + z, null);
                }
            }
        }
    }

    public static boolean b(u uVar) {
        if (uVar instanceof b0) {
            return ((b0) uVar).j();
        }
        return false;
    }

    public static b d() {
        if (o == null) {
            o = new b();
        }
        o.a = System.currentTimeMillis();
        return o;
    }

    public Bundle a(long j2, long j3) {
        Bundle bundle;
        synchronized (this) {
            if (this.a.x() && c() && j2 - this.f82f > j3) {
                bundle = new Bundle();
                bundle.putInt("session_no", this.f87k);
                int i2 = this.f83g + 1;
                this.f83g = i2;
                bundle.putInt("send_times", i2);
                bundle.putLong("current_duration", (j2 - this.f82f) / 1000);
                bundle.putString(com.umeng.analytics.pro.u.a, u.a(this.f84h));
                this.f82f = j2;
            } else {
                bundle = null;
            }
        }
        return bundle;
    }

    public z a() {
        z zVar;
        synchronized (this) {
            zVar = this.f89m;
        }
        return zVar;
    }

    public void a(u uVar) {
        if (uVar != null) {
            uVar.f167d = this.b.f();
            uVar.f166c = this.f81e;
            uVar.b = a(this.a);
            if (this.a.N()) {
                uVar.f168e = bykvm_19do.bykvm_19do.bykvm_19do.a.c();
                uVar.f169f = bykvm_19do.bykvm_19do.bykvm_19do.a.d();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(bykvm_19do.bykvm_19do.bykvm_19do.u r12, java.util.ArrayList<bykvm_19do.bykvm_19do.bykvm_19do.u> r13) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof bykvm_19do.bykvm_19do.bykvm_19do.b0
            boolean r1 = b(r12)
            long r2 = r11.f84h
            r4 = 0
            r6 = 1
            r7 = -1
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 != 0) goto L19
            boolean r1 = b(r12)
        L15:
            r11.a(r12, r13, r1)
            goto L45
        L19:
            boolean r2 = r11.f85i
            if (r2 != 0) goto L23
            if (r1 == 0) goto L23
            r11.a(r12, r13, r6)
            goto L45
        L23:
            long r2 = r11.f86j
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 == 0) goto L37
            long r7 = r12.a
            bykvm_19do.bykvm_19do.bykvm_19do.j2 r9 = r11.a
            long r9 = r9.P()
            long r2 = r2 + r9
            int r9 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r9 <= 0) goto L37
            goto L43
        L37:
            long r2 = r11.f84h
            long r7 = r12.a
            r9 = 7200000(0x6ddd00, double:3.5572727E-317)
            long r7 = r7 + r9
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 <= 0) goto L44
        L43:
            goto L15
        L44:
            r6 = 0
        L45:
            if (r0 == 0) goto Lae
            r0 = r12
            bykvm_19do.bykvm_19do.bykvm_19do.b0 r0 = (bykvm_19do.bykvm_19do.bykvm_19do.b0) r0
            boolean r1 = r0.j()
            if (r1 == 0) goto L89
            long r1 = r12.a
            r11.f82f = r1
            r11.f86j = r4
            r13.add(r12)
            java.lang.String r13 = r0.f76j
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto Lb5
            bykvm_19do.bykvm_19do.bykvm_19do.b0 r13 = r11.f80d
            r1 = 500(0x1f4, double:2.47E-321)
            if (r13 == 0) goto L78
            long r3 = r0.a
            long r7 = r13.a
            long r3 = r3 - r7
            long r7 = r13.f75i
            long r3 = r3 - r7
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 >= 0) goto L78
        L73:
            java.lang.String r13 = r13.f77k
            r0.f76j = r13
            goto Lb5
        L78:
            bykvm_19do.bykvm_19do.bykvm_19do.b0 r13 = r11.f79c
            if (r13 == 0) goto Lb5
            long r3 = r0.a
            long r7 = r13.a
            long r3 = r3 - r7
            long r7 = r13.f75i
            long r3 = r3 - r7
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 >= 0) goto Lb5
            goto L73
        L89:
            long r1 = r12.a
            android.os.Bundle r1 = r11.a(r1, r4)
            if (r1 == 0) goto L96
            java.lang.String r2 = "play_session"
            bykvm_19do.bykvm_19do.bykvm_19do.a.a(r2, r1)
        L96:
            r11.f82f = r4
            long r1 = r0.a
            r11.f86j = r1
            r13.add(r12)
            boolean r13 = r0.k()
            if (r13 == 0) goto La8
            r11.f79c = r0
            goto Lb5
        La8:
            r11.f80d = r0
            r13 = 0
            r11.f79c = r13
            goto Lb5
        Lae:
            boolean r0 = r12 instanceof bykvm_19do.bykvm_19do.bykvm_19do.b2.b
            if (r0 != 0) goto Lb5
            r13.add(r12)
        Lb5:
            r11.a(r12)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.b2.a(bykvm_19do.bykvm_19do.bykvm_19do.u, java.util.ArrayList):boolean");
    }

    public boolean b() {
        return this.f85i;
    }

    public boolean c() {
        return b() && this.f86j == 0;
    }
}
