package bykvm_19do.bykvm_19do.bykvm_19do;

/* loaded from: classes.dex */
public class x1 extends a2 {

    /* renamed from: g */
    private boolean f194g;

    public x1(v1 v1Var) {
        super(v1Var);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a2, bykvm_19do.bykvm_19do.bykvm_19do.t1
    public long b() {
        return this.f194g ? Long.MAX_VALUE : 0L;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a2, bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean d() {
        boolean d2 = super.d();
        this.f194g = d2;
        return d2;
    }
}
