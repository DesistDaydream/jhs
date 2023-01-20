package i.b;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0007J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\nR*\u0010\u000e\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0016\u0010\b\u001a\u00020\u00028@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0004¨\u0006\u0011"}, d2 = {"Li/b/h3;", "", "Li/b/i1;", am.av, "()Li/b/i1;", "Lh/t1;", "c", "()V", "eventLoop", e.j.a.b.c.f.f10128d, "(Li/b/i1;)V", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "Ljava/lang/ThreadLocal;", "ref", "b", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class h3 {
    public static final h3 b = new h3();
    private static final ThreadLocal<i1> a = new ThreadLocal<>();

    private h3() {
    }

    @k.e.a.e
    public final i1 a() {
        return a.get();
    }

    @k.e.a.d
    public final i1 b() {
        ThreadLocal<i1> threadLocal = a;
        i1 i1Var = threadLocal.get();
        if (i1Var != null) {
            return i1Var;
        }
        i1 a2 = l1.a();
        threadLocal.set(a2);
        return a2;
    }

    public final void c() {
        a.set(null);
    }

    public final void d(@k.e.a.d i1 i1Var) {
        a.set(i1Var);
    }
}
