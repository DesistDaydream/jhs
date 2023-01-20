package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f\"\u0004\b\u0001\u0010\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0017\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0019\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0013¨\u0006\u001d"}, d2 = {"Li/b/w3/u;", "", ExifInterface.LONGITUDE_EAST, "Lh/t1;", "b", "()V", "element", "", am.av, "(Ljava/lang/Object;)Z", "g", "()Ljava/lang/Object;", "R", "Lkotlin/Function1;", "transform", "", "f", "(Lh/k2/u/l;)Ljava/util/List;", e.j.a.b.c.f.f10128d, "()Z", "", "c", "()I", "size", com.huawei.hms.push.e.a, "isEmpty", "singleConsumer", "<init>", "(Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class u<E> {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(u.class, Object.class, "_cur");
    private volatile Object _cur;

    public u(boolean z) {
        this._cur = new v(8, z);
    }

    public final boolean a(@k.e.a.d E e2) {
        while (true) {
            v vVar = (v) this._cur;
            int a2 = vVar.a(e2);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                a.compareAndSet(this, vVar, vVar.k());
            } else if (a2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            v vVar = (v) this._cur;
            if (vVar.d()) {
                return;
            }
            a.compareAndSet(this, vVar, vVar.k());
        }
    }

    public final int c() {
        return ((v) this._cur).f();
    }

    public final boolean d() {
        return ((v) this._cur).g();
    }

    public final boolean e() {
        return ((v) this._cur).h();
    }

    @k.e.a.d
    public final <R> List<R> f(@k.e.a.d h.k2.u.l<? super E, ? extends R> lVar) {
        return ((v) this._cur).i(lVar);
    }

    @k.e.a.e
    public final E g() {
        while (true) {
            v vVar = (v) this._cur;
            E e2 = (E) vVar.l();
            if (e2 != v.s) {
                return e2;
            }
            a.compareAndSet(this, vVar, vVar.k());
        }
    }
}
