package kotlinx.coroutines.internal;

import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.k2.u.p;
import i.b.f3;
import i.b.w3.i0;
import i.b.w3.s0;
import java.util.Objects;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\r\"(\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\"4\u0010\u0016\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00150\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013\",\u0010\u0017\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013\"(\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013¨\u0006\u001a"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", "b", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "countOrElement", "c", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)Ljava/lang/Object;", "oldState", "Lh/t1;", am.av, "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "Li/b/w3/i0;", "Li/b/w3/i0;", "ZERO", "Lkotlin/Function2;", "Li/b/w3/s0;", "Lkotlin/coroutines/CoroutineContext$a;", e.a, "Lh/k2/u/p;", "restoreState", "Li/b/f3;", "findOne", "countAll", f.f10128d, "updateState", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ThreadContextKt {
    private static final i0 a = new i0("ZERO");
    private static final p<Object, CoroutineContext.a, Object> b = ThreadContextKt$countAll$1.INSTANCE;

    /* renamed from: c  reason: collision with root package name */
    private static final p<f3<?>, CoroutineContext.a, f3<?>> f16982c = ThreadContextKt$findOne$1.INSTANCE;

    /* renamed from: d  reason: collision with root package name */
    private static final p<s0, CoroutineContext.a, s0> f16983d = ThreadContextKt$updateState$1.INSTANCE;

    /* renamed from: e  reason: collision with root package name */
    private static final p<s0, CoroutineContext.a, s0> f16984e = ThreadContextKt$restoreState$1.INSTANCE;

    public static final void a(@d CoroutineContext coroutineContext, @k.e.a.e Object obj) {
        if (obj == a) {
            return;
        }
        if (obj instanceof s0) {
            ((s0) obj).b();
            coroutineContext.fold(obj, f16984e);
            return;
        }
        Object fold = coroutineContext.fold(null, f16982c);
        Objects.requireNonNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((f3) fold).J(coroutineContext, obj);
    }

    @d
    public static final Object b(@d CoroutineContext coroutineContext) {
        return coroutineContext.fold(0, b);
    }

    @k.e.a.e
    public static final Object c(@d CoroutineContext coroutineContext, @k.e.a.e Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new s0(coroutineContext, ((Number) obj).intValue()), f16983d);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((f3) obj).u0(coroutineContext);
    }
}
