package i.b;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B0\u0012'\u0010\u000f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\nj\u0002`\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR7\u0010\u000f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\nj\u0002`\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000e¨\u0006\u0012"}, d2 = {"Li/b/y1;", "Li/b/l;", "", "cause", "Lh/t1;", am.av, "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/Function1;", "Lh/k0;", "name", "Lkotlinx/coroutines/CompletionHandler;", "Lh/k2/u/l;", "handler", "<init>", "(Lh/k2/u/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class y1 extends l {
    private final h.k2.u.l<Throwable, h.t1> a;

    /* JADX WARN: Multi-variable type inference failed */
    public y1(@k.e.a.d h.k2.u.l<? super Throwable, h.t1> lVar) {
        this.a = lVar;
    }

    @Override // i.b.m
    public void a(@k.e.a.e Throwable th) {
        this.a.invoke(th);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ h.t1 invoke(Throwable th) {
        a(th);
        return h.t1.a;
    }

    @k.e.a.d
    public String toString() {
        return "InvokeOnCancel[" + r0.a(this.a) + '@' + r0.b(this) + ']';
    }
}
