package bykvm_19do.bykvm_19do.bykvm_19do;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class s1 extends t1 {

    /* renamed from: d */
    private boolean f163d;

    public s1(v1 v1Var) {
        super(v1Var);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean a() {
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public long b() {
        return this.f163d ? Long.MAX_VALUE : 0L;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public long[] c() {
        return z1.f212d;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean d() {
        if (this.a.d().k() != 0) {
            JSONObject a = this.a.d().a();
            if (a != null) {
                this.f163d = s.b(t.a(this.a.a(), this.a.d().a(), this.a.f().b(), true, a.j()), a);
            } else {
                l0.a(null);
            }
        }
        return this.f163d;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public String e() {
        return "ac";
    }
}
