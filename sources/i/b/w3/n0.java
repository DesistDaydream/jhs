package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import i.b.f3;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u001c\u001a\u00028\u0000\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\u00032\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ*\u0010\u0011\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010\u0010*\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00028\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Li/b/w3/n0;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/f3;", "Lkotlin/coroutines/CoroutineContext;", "context", "u0", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "oldState", "Lh/t1;", "J", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "Lkotlin/coroutines/CoroutineContext$b;", "key", "minusKey", "(Lkotlin/coroutines/CoroutineContext$b;)Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext$a;", ExifInterface.LONGITUDE_EAST, "get", "(Lkotlin/coroutines/CoroutineContext$b;)Lkotlin/coroutines/CoroutineContext$a;", "", "toString", "()Ljava/lang/String;", "Ljava/lang/ThreadLocal;", "c", "Ljava/lang/ThreadLocal;", "threadLocal", "b", "Ljava/lang/Object;", "value", am.av, "Lkotlin/coroutines/CoroutineContext$b;", "getKey", "()Lkotlin/coroutines/CoroutineContext$b;", "<init>", "(Ljava/lang/Object;Ljava/lang/ThreadLocal;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class n0<T> implements f3<T> {
    @k.e.a.d
    private final CoroutineContext.b<?> a;
    private final T b;

    /* renamed from: c  reason: collision with root package name */
    private final ThreadLocal<T> f15888c;

    public n0(T t, @k.e.a.d ThreadLocal<T> threadLocal) {
        this.b = t;
        this.f15888c = threadLocal;
        this.a = new o0(threadLocal);
    }

    @Override // i.b.f3
    public void J(@k.e.a.d CoroutineContext coroutineContext, T t) {
        this.f15888c.set(t);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @k.e.a.d h.k2.u.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) f3.a.a(this, r, pVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @k.e.a.e
    public <E extends CoroutineContext.a> E get(@k.e.a.d CoroutineContext.b<E> bVar) {
        if (h.k2.v.f0.g(getKey(), bVar)) {
            return this;
        }
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    @k.e.a.d
    public CoroutineContext.b<?> getKey() {
        return this.a;
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @k.e.a.d
    public CoroutineContext minusKey(@k.e.a.d CoroutineContext.b<?> bVar) {
        return h.k2.v.f0.g(getKey(), bVar) ? EmptyCoroutineContext.INSTANCE : this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @k.e.a.d
    public CoroutineContext plus(@k.e.a.d CoroutineContext coroutineContext) {
        return f3.a.d(this, coroutineContext);
    }

    @k.e.a.d
    public String toString() {
        return "ThreadLocal(value=" + this.b + ", threadLocal = " + this.f15888c + ')';
    }

    @Override // i.b.f3
    public T u0(@k.e.a.d CoroutineContext coroutineContext) {
        T t = this.f15888c.get();
        this.f15888c.set(this.b);
        return t;
    }
}
