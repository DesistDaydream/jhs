package i.b;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B8\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u000bj\u0002`\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR7\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u000bj\u0002`\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Li/b/a2;", "Li/b/h2;", "Li/b/b2;", "", "cause", "Lh/t1;", "j0", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/Function1;", "Lh/k0;", "name", "Lkotlinx/coroutines/CompletionHandler;", com.huawei.hms.push.e.a, "Lh/k2/u/l;", "handler", "job", "<init>", "(Li/b/b2;Lh/k2/u/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class a2 extends h2<b2> {

    /* renamed from: e  reason: collision with root package name */
    private final h.k2.u.l<Throwable, h.t1> f15717e;

    /* JADX WARN: Multi-variable type inference failed */
    public a2(@k.e.a.d b2 b2Var, @k.e.a.d h.k2.u.l<? super Throwable, h.t1> lVar) {
        super(b2Var);
        this.f15717e = lVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ h.t1 invoke(Throwable th) {
        j0(th);
        return h.t1.a;
    }

    @Override // i.b.d0
    public void j0(@k.e.a.e Throwable th) {
        this.f15717e.invoke(th);
    }

    @Override // i.b.w3.s
    @k.e.a.d
    public String toString() {
        return "InvokeOnCompletion[" + r0.a(this) + '@' + r0.b(this) + ']';
    }
}
