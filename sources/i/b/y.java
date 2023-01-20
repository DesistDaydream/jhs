package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CompletableDeferredImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a.\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/x;", "Lkotlin/Result;", "result", "", e.j.a.b.c.f.f10128d, "(Li/b/x;Ljava/lang/Object;)Z", "Li/b/b2;", "parent", "b", "(Li/b/b2;)Li/b/x;", "value", am.av, "(Ljava/lang/Object;)Li/b/x;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class y {
    @k.e.a.d
    public static final <T> x<T> a(T t) {
        CompletableDeferredImpl completableDeferredImpl = new CompletableDeferredImpl(null);
        completableDeferredImpl.complete(t);
        return completableDeferredImpl;
    }

    @k.e.a.d
    public static final <T> x<T> b(@k.e.a.e b2 b2Var) {
        return new CompletableDeferredImpl(b2Var);
    }

    public static /* synthetic */ x c(b2 b2Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            b2Var = null;
        }
        return b(b2Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean d(@k.e.a.d x<T> xVar, @k.e.a.d Object obj) {
        Throwable m109exceptionOrNullimpl = Result.m109exceptionOrNullimpl(obj);
        return m109exceptionOrNullimpl == null ? xVar.complete(obj) : xVar.d(m109exceptionOrNullimpl);
    }
}
