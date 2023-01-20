package i.b;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Li/b/g1;", "Li/b/h2;", "Li/b/b2;", "", "cause", "Lh/t1;", "j0", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Li/b/e1;", com.huawei.hms.push.e.a, "Li/b/e1;", "handle", "job", "<init>", "(Li/b/b2;Li/b/e1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class g1 extends h2<b2> {

    /* renamed from: e  reason: collision with root package name */
    private final e1 f15738e;

    public g1(@k.e.a.d b2 b2Var, @k.e.a.d e1 e1Var) {
        super(b2Var);
        this.f15738e = e1Var;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ h.t1 invoke(Throwable th) {
        j0(th);
        return h.t1.a;
    }

    @Override // i.b.d0
    public void j0(@k.e.a.e Throwable th) {
        this.f15738e.dispose();
    }

    @Override // i.b.w3.s
    @k.e.a.d
    public String toString() {
        return "DisposeOnCompletion[" + this.f15738e + ']';
    }
}
