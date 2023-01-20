package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.t1;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R5\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00078\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/flow/internal/UndispatchedContextCollector;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lh/e2/c;", "", "b", "Lh/k2/u/p;", "emitRef", am.av, "Ljava/lang/Object;", "countOrElement", "Lkotlin/coroutines/CoroutineContext;", "c", "Lkotlin/coroutines/CoroutineContext;", "emitContext", "downstream", "<init>", "(Li/b/v3/f;Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class UndispatchedContextCollector<T> implements f<T> {
    private final Object a;
    private final p<T, c<? super t1>, Object> b;

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineContext f16980c;

    public UndispatchedContextCollector(@d f<? super T> fVar, @d CoroutineContext coroutineContext) {
        this.f16980c = coroutineContext;
        this.a = ThreadContextKt.b(coroutineContext);
        this.b = new UndispatchedContextCollector$emitRef$1(fVar, null);
    }

    @Override // i.b.v3.f
    @e
    public Object emit(T t, @d c<? super t1> cVar) {
        Object c2 = i.b.v3.c0.e.c(this.f16980c, t, this.a, this.b, cVar);
        return c2 == b.h() ? c2 : t1.a;
    }
}
