package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.qiniu.android.collect.ReportItem;
import h.e2.a;
import h.e2.b;
import h.e2.c;
import h.e2.d;
import h.i;
import h.k2.u.l;
import h.k2.v.u;
import h.o;
import i.b.r0;
import i.b.w3.j;
import i.b.x1;
import java.util.Objects;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\n\u001a\u00060\bj\u0002`\tH&¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0017¢\u0006\u0004\b\u000e\u0010\rJ'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u000b2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "Lh/e2/a;", "Lh/e2/d;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "isDispatchNeeded", "(Lkotlin/coroutines/CoroutineContext;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", ReportItem.LogTypeBlock, "Lh/t1;", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", ExifInterface.GPS_DIRECTION_TRUE, "Lh/e2/c;", "continuation", "interceptContinuation", "(Lh/e2/c;)Lh/e2/c;", "releaseInterceptedContinuation", "(Lh/e2/c;)V", "other", "plus", "(Lkotlinx/coroutines/CoroutineDispatcher;)Lkotlinx/coroutines/CoroutineDispatcher;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class CoroutineDispatcher extends a implements d {
    public static final Key Key = new Key(null);

    @o
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lh/e2/b;", "Lh/e2/d;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Key extends b<d, CoroutineDispatcher> {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/coroutines/CoroutineContext$a;", AdvanceSetting.NETWORK_TYPE, "Lkotlinx/coroutines/CoroutineDispatcher;", "invoke", "(Lkotlin/coroutines/CoroutineContext$a;)Lkotlinx/coroutines/CoroutineDispatcher;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.CoroutineDispatcher$Key$1  reason: invalid class name */
        /* loaded from: classes4.dex */
        public static final class AnonymousClass1 extends Lambda implements l<CoroutineContext.a, CoroutineDispatcher> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // h.k2.u.l
            @e
            public final CoroutineDispatcher invoke(@k.e.a.d CoroutineContext.a aVar) {
                if (!(aVar instanceof CoroutineDispatcher)) {
                    aVar = null;
                }
                return (CoroutineDispatcher) aVar;
            }
        }

        public /* synthetic */ Key(u uVar) {
            this();
        }

        private Key() {
            super(d.v0, AnonymousClass1.INSTANCE);
        }
    }

    public CoroutineDispatcher() {
        super(d.v0);
    }

    public abstract void dispatch(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d Runnable runnable);

    @x1
    public void dispatchYield(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d Runnable runnable) {
        dispatch(coroutineContext, runnable);
    }

    @Override // h.e2.a, kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @e
    public <E extends CoroutineContext.a> E get(@k.e.a.d CoroutineContext.b<E> bVar) {
        return (E) d.a.b(this, bVar);
    }

    @Override // h.e2.d
    @k.e.a.d
    public final <T> c<T> interceptContinuation(@k.e.a.d c<? super T> cVar) {
        return new j(this, cVar);
    }

    public boolean isDispatchNeeded(@k.e.a.d CoroutineContext coroutineContext) {
        return true;
    }

    @Override // h.e2.a, kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @k.e.a.d
    public CoroutineContext minusKey(@k.e.a.d CoroutineContext.b<?> bVar) {
        return d.a.c(this, bVar);
    }

    @i(level = DeprecationLevel.ERROR, message = "Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
    @k.e.a.d
    public final CoroutineDispatcher plus(@k.e.a.d CoroutineDispatcher coroutineDispatcher) {
        return coroutineDispatcher;
    }

    @Override // h.e2.d
    @x1
    public void releaseInterceptedContinuation(@k.e.a.d c<?> cVar) {
        Objects.requireNonNull(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        i.b.o<?> o = ((j) cVar).o();
        if (o != null) {
            o.v();
        }
    }

    @k.e.a.d
    public String toString() {
        return r0.a(this) + '@' + r0.b(this);
    }
}
