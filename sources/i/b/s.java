package i.b;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Li/b/s;", "Li/b/c2;", "Li/b/b2;", "", "cause", "Lh/t1;", "j0", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Li/b/o;", com.huawei.hms.push.e.a, "Li/b/o;", "child", "parent", "<init>", "(Li/b/b2;Li/b/o;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class s extends c2<b2> {
    @h.k2.d
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public final o<?> f15788e;

    public s(@k.e.a.d b2 b2Var, @k.e.a.d o<?> oVar) {
        super(b2Var);
        this.f15788e = oVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ h.t1 invoke(Throwable th) {
        j0(th);
        return h.t1.a;
    }

    @Override // i.b.d0
    public void j0(@k.e.a.e Throwable th) {
        o<?> oVar = this.f15788e;
        oVar.K(oVar.z(this.f15739d));
    }

    @Override // i.b.w3.s
    @k.e.a.d
    public String toString() {
        return "ChildContinuation[" + this.f15788e + ']';
    }
}
