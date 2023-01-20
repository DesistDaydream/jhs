package bykvm_19do.bykvm_19do.bykvm_19do;

/* loaded from: classes.dex */
public class w1 extends y1 {

    /* renamed from: f */
    private boolean f191f;

    public w1(v1 v1Var) {
        super(v1Var);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.y1, bykvm_19do.bykvm_19do.bykvm_19do.t1
    public long b() {
        return this.f191f ? Long.MAX_VALUE : 0L;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.y1, bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean d() {
        boolean d2 = super.d();
        this.f191f = d2;
        return d2;
    }
}
