package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import i.b.x1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@x1
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u000e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0018\u001a\u00020\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Li/b/w3/d;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/w3/b0;", "", "decision", com.huawei.hms.push.e.a, "(Ljava/lang/Object;)Ljava/lang/Object;", "affected", "i", "failure", "Lh/t1;", e.j.a.b.c.f.f10128d, "(Ljava/lang/Object;Ljava/lang/Object;)V", "c", "", "g", "()J", "opSequence", am.av, "()Li/b/w3/d;", "atomicOp", "", "h", "()Z", "isDecided", "f", "()Ljava/lang/Object;", "consensus", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class d<T> extends b0 {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_consensus");
    private volatile Object _consensus = c.a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.b.w3.b0
    @k.e.a.d
    public d<?> a() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.b.w3.b0
    @k.e.a.e
    public final Object c(@k.e.a.e Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == c.a) {
            obj2 = e(i(obj));
        }
        d(obj, obj2);
        return obj2;
    }

    public abstract void d(T t, @k.e.a.e Object obj);

    @k.e.a.e
    public final Object e(@k.e.a.e Object obj) {
        if (i.b.q0.b()) {
            if (!(obj != c.a)) {
                throw new AssertionError();
            }
        }
        Object obj2 = this._consensus;
        Object obj3 = c.a;
        return obj2 != obj3 ? obj2 : a.compareAndSet(this, obj3, obj) ? obj : this._consensus;
    }

    @k.e.a.e
    public final Object f() {
        return this._consensus;
    }

    public long g() {
        return 0L;
    }

    public final boolean h() {
        return this._consensus != c.a;
    }

    @k.e.a.e
    public abstract Object i(T t);
}
