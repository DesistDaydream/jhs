package kotlinx.coroutines;

import h.k2.u.p;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \t2\u00020\u0001:\u0001\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$a;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "Lh/t1;", "handleException", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "x0", "b", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface CoroutineExceptionHandler extends CoroutineContext.a {
    public static final b x0 = b.a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        public static <R> R a(@d CoroutineExceptionHandler coroutineExceptionHandler, R r, @d p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) CoroutineContext.a.C0492a.a(coroutineExceptionHandler, r, pVar);
        }

        @e
        public static <E extends CoroutineContext.a> E b(@d CoroutineExceptionHandler coroutineExceptionHandler, @d CoroutineContext.b<E> bVar) {
            return (E) CoroutineContext.a.C0492a.b(coroutineExceptionHandler, bVar);
        }

        @d
        public static CoroutineContext c(@d CoroutineExceptionHandler coroutineExceptionHandler, @d CoroutineContext.b<?> bVar) {
            return CoroutineContext.a.C0492a.c(coroutineExceptionHandler, bVar);
        }

        @d
        public static CoroutineContext d(@d CoroutineExceptionHandler coroutineExceptionHandler, @d CoroutineContext coroutineContext) {
            return CoroutineContext.a.C0492a.d(coroutineExceptionHandler, coroutineContext);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandler$b", "Lkotlin/coroutines/CoroutineContext$b;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b implements CoroutineContext.b<CoroutineExceptionHandler> {
        public static final /* synthetic */ b a = new b();

        private b() {
        }
    }

    void handleException(@d CoroutineContext coroutineContext, @d Throwable th);
}
