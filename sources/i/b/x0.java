package i.b;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Li/b/x0;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/w3/e0;", "", "w1", "()Z", "v1", "", "state", "Lh/t1;", "U", "(Ljava/lang/Object;)V", "l1", "u1", "()Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lh/e2/c;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lh/e2/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class x0<T> extends i.b.w3.e0<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f15914e = AtomicIntegerFieldUpdater.newUpdater(x0.class, "_decision");
    private volatile int _decision;

    public x0(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d h.e2.c<? super T> cVar) {
        super(coroutineContext, cVar);
        this._decision = 0;
    }

    private final boolean v1() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f15914e.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean w1() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f15914e.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // i.b.w3.e0, kotlinx.coroutines.JobSupport
    public void U(@k.e.a.e Object obj) {
        l1(obj);
    }

    @Override // i.b.w3.e0, i.b.a
    public void l1(@k.e.a.e Object obj) {
        if (v1()) {
            return;
        }
        i.b.w3.k.g(IntrinsicsKt__IntrinsicsJvmKt.d(this.f15877d), g0.a(obj, this.f15877d), null, 2, null);
    }

    @k.e.a.e
    public final Object u1() {
        if (w1()) {
            return h.e2.j.b.h();
        }
        Object o = i2.o(z0());
        if (o instanceof b0) {
            throw ((b0) o).a;
        }
        return o;
    }
}
