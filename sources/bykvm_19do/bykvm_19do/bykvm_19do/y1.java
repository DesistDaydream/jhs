package bykvm_19do.bykvm_19do.bykvm_19do;

import android.os.Bundle;
import com.umeng.analytics.pro.am;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class y1 extends t1 {

    /* renamed from: e */
    private static final long[] f198e = {com.heytap.mcssdk.constant.a.f3314d};

    /* renamed from: d */
    private long f199d;

    public y1(v1 v1Var) {
        super(v1Var);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean a() {
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public long b() {
        return this.f199d + com.heytap.mcssdk.constant.a.f3314d;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public long[] c() {
        return f198e;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean d() {
        Bundle a;
        long currentTimeMillis = System.currentTimeMillis();
        b2 e2 = this.a.e();
        if (e2 != null && (a = e2.a(currentTimeMillis, 50000L)) != null) {
            a.a("play_session", a);
            a.a();
        }
        if (this.a.d().k() != 0) {
            JSONObject b = this.a.d().b();
            if (b == null) {
                l0.a(null);
                return false;
            }
            boolean a2 = this.a.b().a(b);
            this.f199d = System.currentTimeMillis();
            return a2;
        }
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public String e() {
        return am.ax;
    }
}
