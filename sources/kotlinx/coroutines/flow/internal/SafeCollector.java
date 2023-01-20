package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import h.e2.j.b;
import h.e2.k.a.c;
import h.k2.d;
import h.k2.u.q;
import h.t1;
import i.b.e2;
import i.b.v3.c0.g;
import i.b.v3.c0.l;
import i.b.v3.f;
import java.util.Objects;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.StringsKt__IndentKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u00032\u00020\u0004B\u001d\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010.\u001a\u00020\f¢\u0006\u0004\b/\u00100J'\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J$\u0010\u001a\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\f8\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b.\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/f;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lh/e2/k/a/c;", "Lh/e2/c;", "Lh/t1;", "uCont", "value", "", "emit", "(Lh/e2/c;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "currentContext", "previousContext", "checkContext", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "Li/b/v3/c0/g;", "exception", "exceptionTransparencyViolated", "(Li/b/v3/c0/g;Ljava/lang/Object;)V", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "()V", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "getCallerFrame", "()Lh/e2/k/a/c;", "callerFrame", "completion", "Lh/e2/c;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "lastEmissionContext", "Lkotlin/coroutines/CoroutineContext;", "", "collectContextSize", ExpandableTextView.P, "collector", "Li/b/v3/f;", "collectContext", "<init>", "(Li/b/v3/f;Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class SafeCollector<T> extends ContinuationImpl implements f<T>, c {
    @d
    @k.e.a.d
    public final CoroutineContext collectContext;
    @d
    public final int collectContextSize;
    @d
    @k.e.a.d
    public final f<T> collector;
    private h.e2.c<? super t1> completion;
    private CoroutineContext lastEmissionContext;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(@k.e.a.d f<? super T> fVar, @k.e.a.d CoroutineContext coroutineContext) {
        super(l.b, EmptyCoroutineContext.INSTANCE);
        this.collector = fVar;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, SafeCollector$collectContextSize$1.INSTANCE)).intValue();
    }

    private final void checkContext(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, T t) {
        if (coroutineContext2 instanceof g) {
            exceptionTransparencyViolated((g) coroutineContext2, t);
        }
        SafeCollector_commonKt.a(this, coroutineContext);
        this.lastEmissionContext = coroutineContext;
    }

    private final void exceptionTransparencyViolated(g gVar, Object obj) {
        throw new IllegalStateException(StringsKt__IndentKt.p("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + gVar.b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // i.b.v3.f
    @e
    public Object emit(T t, @k.e.a.d h.e2.c<? super t1> cVar) {
        try {
            Object emit = emit(cVar, (h.e2.c<? super t1>) t);
            if (emit == b.h()) {
                h.e2.k.a.f.c(cVar);
            }
            return emit == b.h() ? emit : t1.a;
        } catch (Throwable th) {
            this.lastEmissionContext = new g(th);
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, h.e2.k.a.c
    @e
    public c getCallerFrame() {
        h.e2.c<? super t1> cVar = this.completion;
        if (!(cVar instanceof c)) {
            cVar = null;
        }
        return (c) cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, h.e2.c
    @k.e.a.d
    public CoroutineContext getContext() {
        CoroutineContext context;
        h.e2.c<? super t1> cVar = this.completion;
        return (cVar == null || (context = cVar.getContext()) == null) ? EmptyCoroutineContext.INSTANCE : context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, h.e2.k.a.c
    @e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public Object invokeSuspend(@k.e.a.d Object obj) {
        Throwable m109exceptionOrNullimpl = Result.m109exceptionOrNullimpl(obj);
        if (m109exceptionOrNullimpl != null) {
            this.lastEmissionContext = new g(m109exceptionOrNullimpl);
        }
        h.e2.c<? super t1> cVar = this.completion;
        if (cVar != null) {
            cVar.resumeWith(obj);
        }
        return b.h();
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }

    private final Object emit(h.e2.c<? super t1> cVar, T t) {
        q qVar;
        CoroutineContext context = cVar.getContext();
        e2.A(context);
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            checkContext(context, coroutineContext, t);
        }
        this.completion = cVar;
        qVar = SafeCollectorKt.a;
        f<T> fVar = this.collector;
        Objects.requireNonNull(fVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        return qVar.invoke(fVar, t, this);
    }
}
