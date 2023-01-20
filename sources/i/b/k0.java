package i.b;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n\u001a,\u0010\u000e\u001a\u00020\r2\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000bH\u0086\b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "Lh/t1;", "b", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "originalException", "thrownException", "c", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/Function2;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", am.av, "(Lh/k2/u/p;)Lkotlinx/coroutines/CoroutineExceptionHandler;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class k0 {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"i/b/k0$a", "Lh/e2/a;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "Lh/t1;", "handleException", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a extends h.e2.a implements CoroutineExceptionHandler {
        public final /* synthetic */ h.k2.u.p a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h.k2.u.p pVar, CoroutineContext.b bVar) {
            super(bVar);
            this.a = pVar;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d Throwable th) {
            this.a.invoke(coroutineContext, th);
        }
    }

    @k.e.a.d
    public static final CoroutineExceptionHandler a(@k.e.a.d h.k2.u.p<? super CoroutineContext, ? super Throwable, h.t1> pVar) {
        return new a(pVar, CoroutineExceptionHandler.x0);
    }

    @x1
    public static final void b(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler.x0);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } else {
                j0.a(coroutineContext, th);
            }
        } catch (Throwable th2) {
            j0.a(coroutineContext, c(th, th2));
        }
    }

    @k.e.a.d
    public static final Throwable c(@k.e.a.d Throwable th, @k.e.a.d Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        h.m.a(runtimeException, th);
        return runtimeException;
    }
}
