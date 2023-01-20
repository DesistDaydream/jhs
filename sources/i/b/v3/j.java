package i.b.v3;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.q0;
import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\tH\u0007¢\u0006\u0004\b\f\u0010\u000b\u001a)\u0010\u0012\u001a\u00020\u0011*\u0006\u0012\u0002\b\u00030\r2\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\"$\u0010\u0018\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\r8F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\"$\u0010\u001d\u001a\u00020\u0019*\u0006\u0012\u0002\b\u00030\r8F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/p;", "Lkotlinx/coroutines/flow/Flow;", "c", "(Li/b/v3/p;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/coroutines/CoroutineContext;", "context", "f", "(Li/b/v3/p;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/x;", e.j.a.b.c.f.f10128d, "(Li/b/v3/x;)Lkotlinx/coroutines/flow/Flow;", com.huawei.hms.push.e.a, "Li/b/v3/f;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "Lh/t1;", am.av, "(Li/b/v3/f;Ljava/util/concurrent/CancellationException;)V", "g", "(Li/b/v3/f;)Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext$annotations", "(Li/b/v3/f;)V", "coroutineContext", "", "i", "(Li/b/v3/f;)Z", "isActive$annotations", "isActive", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class j {
    @h.i(level = DeprecationLevel.ERROR, message = "cancel() is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().cancel() instead or specify the receiver of cancel() explicitly", replaceWith = @q0(expression = "currentCoroutineContext().cancel(cause)", imports = {}))
    public static final void a(@k.e.a.d f<?> fVar, @k.e.a.e CancellationException cancellationException) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void b(f fVar, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        a(fVar, cancellationException);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Applying 'cancellable' to a SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @q0(expression = "this", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> c(@k.e.a.d p<? extends T> pVar) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Applying 'conflate' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @q0(expression = "this", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> d(@k.e.a.d x<? extends T> xVar) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Applying 'distinctUntilChanged' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @q0(expression = "this", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> e(@k.e.a.d x<? extends T> xVar) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Applying 'flowOn' to SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @q0(expression = "this", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> f(@k.e.a.d p<? extends T> pVar, @k.e.a.d CoroutineContext coroutineContext) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @k.e.a.d
    public static final CoroutineContext g(@k.e.a.d f<?> fVar) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @h.i(level = DeprecationLevel.ERROR, message = "coroutineContext is resolved into the property of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext() instead or specify the receiver of coroutineContext explicitly", replaceWith = @q0(expression = "currentCoroutineContext()", imports = {}))
    public static /* synthetic */ void h(f fVar) {
    }

    public static final boolean i(@k.e.a.d f<?> fVar) {
        h.j1();
        throw new KotlinNothingValueException();
    }

    @h.i(level = DeprecationLevel.ERROR, message = "isActive is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().isActive or cancellable() operator instead or specify the receiver of isActive explicitly. Additionally, flow {} builder emissions are cancellable by default.", replaceWith = @q0(expression = "currentCoroutineContext().isActive", imports = {}))
    public static /* synthetic */ void j(f fVar) {
    }
}
