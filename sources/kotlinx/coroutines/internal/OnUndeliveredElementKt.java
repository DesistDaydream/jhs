package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.k2.u.l;
import h.m;
import h.t1;
import i.b.k0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\u001aE\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001a\u00028\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a?\u0010\u000b\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aK\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000e\u0010\u000f**\b\u0000\u0010\u0010\u001a\u0004\b\u0000\u0010\u0000\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0011"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlin/Function1;", "Lh/t1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "element", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "undeliveredElementException", "c", "(Lh/k2/u/l;Ljava/lang/Object;Lkotlinx/coroutines/internal/UndeliveredElementException;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "Lkotlin/coroutines/CoroutineContext;", "context", "b", "(Lh/k2/u/l;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "", am.av, "(Lh/k2/u/l;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lh/k2/u/l;", "OnUndeliveredElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class OnUndeliveredElementKt {
    @d
    public static final <E> l<Throwable, t1> a(@d l<? super E, t1> lVar, E e2, @d CoroutineContext coroutineContext) {
        return new OnUndeliveredElementKt$bindCancellationFun$1(lVar, e2, coroutineContext);
    }

    public static final <E> void b(@d l<? super E, t1> lVar, E e2, @d CoroutineContext coroutineContext) {
        UndeliveredElementException c2 = c(lVar, e2, null);
        if (c2 != null) {
            k0.b(coroutineContext, c2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @e
    public static final <E> UndeliveredElementException c(@d l<? super E, t1> lVar, E e2, @e UndeliveredElementException undeliveredElementException) {
        try {
            lVar.invoke(e2);
        } catch (Throwable th) {
            if (undeliveredElementException != null && undeliveredElementException.getCause() != th) {
                m.a(undeliveredElementException, th);
            } else {
                return new UndeliveredElementException("Exception in undelivered element handler for " + e2, th);
            }
        }
        return undeliveredElementException;
    }

    public static /* synthetic */ UndeliveredElementException d(l lVar, Object obj, UndeliveredElementException undeliveredElementException, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            undeliveredElementException = null;
        }
        return c(lVar, obj, undeliveredElementException);
    }
}
