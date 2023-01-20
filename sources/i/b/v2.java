package i.b;

import kotlin.Metadata;
import kotlin.Result;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Li/b/v2;", "Li/b/h2;", "Li/b/b2;", "", "cause", "Lh/t1;", "j0", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lh/e2/c;", com.huawei.hms.push.e.a, "Lh/e2/c;", "continuation", "job", "<init>", "(Li/b/b2;Lh/e2/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class v2 extends h2<b2> {

    /* renamed from: e  reason: collision with root package name */
    private final h.e2.c<h.t1> f15859e;

    /* JADX WARN: Multi-variable type inference failed */
    public v2(@k.e.a.d b2 b2Var, @k.e.a.d h.e2.c<? super h.t1> cVar) {
        super(b2Var);
        this.f15859e = cVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ h.t1 invoke(Throwable th) {
        j0(th);
        return h.t1.a;
    }

    @Override // i.b.d0
    public void j0(@k.e.a.e Throwable th) {
        h.e2.c<h.t1> cVar = this.f15859e;
        h.t1 t1Var = h.t1.a;
        Result.a aVar = Result.Companion;
        cVar.resumeWith(Result.m106constructorimpl(t1Var));
    }

    @Override // i.b.w3.s
    @k.e.a.d
    public String toString() {
        return "ResumeOnCompletion[" + this.f15859e + ']';
    }
}
