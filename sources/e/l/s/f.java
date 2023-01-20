package e.l.s;

import androidx.lifecycle.LifecycleOwner;
import e.n.i;
import h.k2.u.l;
import h.t1;
import java.util.List;

/* loaded from: classes2.dex */
public interface f {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ void a(f fVar, LifecycleOwner lifecycleOwner, l lVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observeFilterInfo");
            }
            if ((i2 & 1) != 0) {
                lifecycleOwner = null;
            }
            fVar.U(lifecycleOwner, lVar);
        }
    }

    void D();

    @k.e.a.d
    e.n.f<List<e.l.s.a>> K();

    void R(@k.e.a.d List<e.l.s.a> list, int i2);

    void U(@k.e.a.e LifecycleOwner lifecycleOwner, @k.e.a.d l<? super e.l.s.a, t1> lVar);

    @k.e.a.d
    e.n.f<e.l.s.a> e0();

    @k.e.a.d
    e.n.l f();

    @k.e.a.d
    i g();

    @k.e.a.d
    l<e.l.s.a, t1> p();

    @k.e.a.e
    e.l.s.a u();
}
