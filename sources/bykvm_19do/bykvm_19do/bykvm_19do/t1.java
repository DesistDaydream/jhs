package bykvm_19do.bykvm_19do.bykvm_19do;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;

/* loaded from: classes.dex */
public abstract class t1 {
    public final v1 a;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f164c;

    public t1(v1 v1Var) {
        this.a = v1Var;
    }

    public abstract boolean a();

    public abstract long b();

    public abstract long[] c();

    public abstract boolean d();

    public abstract String e();

    public void f() {
        this.f164c = true;
    }

    public boolean g() {
        return this.f164c;
    }

    public final long h() {
        boolean z;
        long j2;
        if (!a() || h0.a(this.a.a())) {
            long b = b();
            long currentTimeMillis = System.currentTimeMillis();
            if (b <= 1000 + currentTimeMillis) {
                try {
                    z = d();
                } catch (Exception e2) {
                    l0.a(e2);
                    z = false;
                }
                if (z) {
                    this.b = 0;
                    j2 = b() - System.currentTimeMillis();
                } else {
                    long[] c2 = c();
                    int i2 = this.b;
                    this.b = i2 + 1;
                    j2 = c2[i2 % c2.length];
                }
                l0.d(e() + " worked:" + z + ExpandableTextView.N + j2, null);
                return j2;
            }
            return b - currentTimeMillis;
        }
        return com.heytap.mcssdk.constant.a.f3314d;
    }
}
