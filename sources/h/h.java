package h;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

@o
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004BK\u00129\u0010\u0005\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\b\b\u0012\u0006\u0010\t\u001a\u00028\u0000ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u0015\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016Jc\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000429\u0010\u0018\u001a5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\b\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u000b\u0010\u001d\u001a\u00028\u0001¢\u0006\u0002\u0010\u001eJ5\u0010\u0015\u001a\u0002H\u001f\"\u0004\b\u0002\u0010 \"\u0004\b\u0003\u0010\u001f*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\u001f0!2\u0006\u0010\t\u001a\u0002H H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\"R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fRF\u0010\u0010\u001a5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\b\bX\u0082\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0011R\u001e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006#"}, d2 = {"Lkotlin/DeepRecursiveScopeImpl;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", ReportItem.LogTypeBlock, "Lkotlin/Function3;", "", "Lkotlin/ExtensionFunctionType;", "value", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;)V", "cont", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "function", "Lkotlin/jvm/functions/Function3;", "result", "Lkotlin/Result;", "Ljava/lang/Object;", "callRecursive", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "crossFunctionCompletion", "currentFunction", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "resumeWith", "", "(Ljava/lang/Object;)V", "runCallLoop", "()Ljava/lang/Object;", ExifInterface.LATITUDE_SOUTH, "U", "Lkotlin/DeepRecursiveFunction;", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class h<T, R> extends g<T, R> implements h.e2.c<R> {
    private h.k2.u.q<? super g<?, ?>, Object, ? super h.e2.c<Object>, ? extends Object> a;
    private Object b;

    /* renamed from: c  reason: collision with root package name */
    private h.e2.c<Object> f14866c;

    /* renamed from: d  reason: collision with root package name */
    private Object f14867d;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\nR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b¸\u0006\u0000"}, d2 = {"kotlin/coroutines/ContinuationKt$Continuation$1", "Lkotlin/coroutines/Continuation;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a implements h.e2.c<Object> {
        public final /* synthetic */ CoroutineContext a;
        public final /* synthetic */ h b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h.k2.u.q f14868c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h.e2.c f14869d;

        public a(CoroutineContext coroutineContext, h hVar, h.k2.u.q qVar, h.e2.c cVar) {
            this.a = coroutineContext;
            this.b = hVar;
            this.f14868c = qVar;
            this.f14869d = cVar;
        }

        @Override // h.e2.c
        @k.e.a.d
        public CoroutineContext getContext() {
            return this.a;
        }

        @Override // h.e2.c
        public void resumeWith(@k.e.a.d Object obj) {
            this.b.a = this.f14868c;
            this.b.f14866c = this.f14869d;
            this.b.f14867d = obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@k.e.a.d h.k2.u.q<? super g<T, R>, ? super T, ? super h.e2.c<? super R>, ? extends Object> qVar, T t) {
        super(null);
        Object obj;
        this.a = qVar;
        this.b = t;
        this.f14866c = this;
        obj = f.a;
        this.f14867d = obj;
    }

    private final h.e2.c<Object> n(h.k2.u.q<? super g<?, ?>, Object, ? super h.e2.c<Object>, ? extends Object> qVar, h.e2.c<Object> cVar) {
        return new a(EmptyCoroutineContext.INSTANCE, this, qVar, cVar);
    }

    @Override // h.g
    @k.e.a.e
    public Object b(T t, @k.e.a.d h.e2.c<? super R> cVar) {
        Objects.requireNonNull(cVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f14866c = cVar;
        this.b = t;
        Object h2 = h.e2.j.b.h();
        if (h2 == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return h2;
    }

    @Override // h.g
    @k.e.a.e
    public <U, S> Object c(@k.e.a.d e<U, S> eVar, U u, @k.e.a.d h.e2.c<? super S> cVar) {
        h.k2.u.q<g<U, S>, U, h.e2.c<? super S>, Object> a2 = eVar.a();
        Objects.requireNonNull(a2, "null cannot be cast to non-null type kotlin.DeepRecursiveFunctionBlock /* = suspend kotlin.DeepRecursiveScope<*, *>.(kotlin.Any?) -> kotlin.Any? */");
        h.k2.u.q<? super g<?, ?>, Object, ? super h.e2.c<Object>, ? extends Object> qVar = this.a;
        if (a2 != qVar) {
            this.a = a2;
            Objects.requireNonNull(cVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.f14866c = n(qVar, cVar);
        } else {
            Objects.requireNonNull(cVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.f14866c = cVar;
        }
        this.b = u;
        Object h2 = h.e2.j.b.h();
        if (h2 == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return h2;
    }

    @Override // h.e2.c
    @k.e.a.d
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final R o() {
        Object obj;
        Object obj2;
        while (true) {
            R r = (R) this.f14867d;
            h.e2.c<Object> cVar = this.f14866c;
            if (cVar != null) {
                obj = f.a;
                if (!Result.m108equalsimpl0(obj, r)) {
                    obj2 = f.a;
                    this.f14867d = obj2;
                    cVar.resumeWith(r);
                } else {
                    try {
                        h.k2.u.q<? super g<?, ?>, Object, ? super h.e2.c<Object>, ? extends Object> qVar = this.a;
                        Object obj3 = this.b;
                        if (qVar != null) {
                            Object invoke = ((h.k2.u.q) h.k2.v.t0.q(qVar, 3)).invoke(this, obj3, cVar);
                            if (invoke != h.e2.j.b.h()) {
                                Result.a aVar = Result.Companion;
                                cVar.resumeWith(Result.m106constructorimpl(invoke));
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type (R, P, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                            break;
                        }
                    } catch (Throwable th) {
                        Result.a aVar2 = Result.Companion;
                        cVar.resumeWith(Result.m106constructorimpl(r0.a(th)));
                    }
                }
            } else {
                r0.n(r);
                return r;
            }
        }
    }

    @Override // h.e2.c
    public void resumeWith(@k.e.a.d Object obj) {
        this.f14866c = null;
        this.f14867d = obj;
    }
}
