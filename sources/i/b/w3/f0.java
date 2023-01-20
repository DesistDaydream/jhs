package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import i.b.w3.f0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0005J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Li/b/w3/f0;", ExifInterface.LATITUDE_SOUTH, "Li/b/w3/g;", "", "r", "()Z", "n", "Lh/t1;", "q", "()V", "", am.ax, "()I", "maxSlots", "g", "removed", "", "c", "J", "o", "()J", "id", "prev", "pointers", "<init>", "(JLi/b/w3/f0;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class f0<S extends f0<S>> extends g<S> {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f15878d = AtomicIntegerFieldUpdater.newUpdater(f0.class, "cleanedAndPointers");

    /* renamed from: c  reason: collision with root package name */
    private final long f15879c;
    private volatile int cleanedAndPointers;

    public f0(long j2, @k.e.a.e S s, int i2) {
        super(s);
        this.f15879c = j2;
        this.cleanedAndPointers = i2 << 16;
    }

    @Override // i.b.w3.g
    public boolean g() {
        return this.cleanedAndPointers == p() && !i();
    }

    public final boolean n() {
        return f15878d.addAndGet(this, -65536) == p() && !i();
    }

    public final long o() {
        return this.f15879c;
    }

    public abstract int p();

    public final void q() {
        if (f15878d.incrementAndGet(this) != p() || i()) {
            return;
        }
        l();
    }

    public final boolean r() {
        int i2;
        do {
            i2 = this.cleanedAndPointers;
            if (!(i2 != p() || i())) {
                return false;
            }
        } while (!f15878d.compareAndSet(this, i2, 65536 + i2));
        return true;
    }
}
