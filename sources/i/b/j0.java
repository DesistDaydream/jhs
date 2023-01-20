package i.b;

import com.umeng.analytics.pro.am;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\t¨\u0006\u000b"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "Lh/t1;", am.av, "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Ljava/util/List;", "handlers", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class j0 {
    private static final List<CoroutineExceptionHandler> a = SequencesKt___SequencesKt.V2(SequencesKt__SequencesKt.h(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator()));

    public static final void a(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d Throwable th) {
        for (CoroutineExceptionHandler coroutineExceptionHandler : a) {
            try {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, k0.c(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
