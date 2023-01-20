package i.b.a4;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.umeng.analytics.pro.am;
import i.b.w3.f0;
import i.b.w3.i0;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.sync.SemaphoreKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0086\b¢\u0006\u0004\b\t\u0010\nJ,\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0086\b¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Li/b/a4/e;", "Li/b/w3/f0;", "", "index", "", am.aH, "(I)Ljava/lang/Object;", "value", "Lh/t1;", IAdInterListener.AdReqParam.WIDTH, "(ILjava/lang/Object;)V", "expected", "", am.aI, "(ILjava/lang/Object;Ljava/lang/Object;)Z", "v", "(ILjava/lang/Object;)Ljava/lang/Object;", "s", "(I)V", "", "toString", "()Ljava/lang/String;", am.ax, "()I", "maxSlots", "", "id", "prev", "pointers", "<init>", "(JLi/b/a4/e;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class e extends f0<e> {
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public AtomicReferenceArray f15720e;

    public e(long j2, @k.e.a.e e eVar, int i2) {
        super(j2, eVar, i2);
        int i3;
        i3 = SemaphoreKt.f17033f;
        this.f15720e = new AtomicReferenceArray(i3);
    }

    @Override // i.b.w3.f0
    public int p() {
        int i2;
        i2 = SemaphoreKt.f17033f;
        return i2;
    }

    public final void s(int i2) {
        i0 i0Var;
        i0Var = SemaphoreKt.f17032e;
        this.f15720e.set(i2, i0Var);
        q();
    }

    public final boolean t(int i2, @k.e.a.e Object obj, @k.e.a.e Object obj2) {
        return this.f15720e.compareAndSet(i2, obj, obj2);
    }

    @k.e.a.d
    public String toString() {
        return "SemaphoreSegment[id=" + o() + ", hashCode=" + hashCode() + ']';
    }

    @k.e.a.e
    public final Object u(int i2) {
        return this.f15720e.get(i2);
    }

    @k.e.a.e
    public final Object v(int i2, @k.e.a.e Object obj) {
        return this.f15720e.getAndSet(i2, obj);
    }

    public final void w(int i2, @k.e.a.e Object obj) {
        this.f15720e.set(i2, obj);
    }
}
