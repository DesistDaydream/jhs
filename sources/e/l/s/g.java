package e.l.s;

import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.model.Rarity;
import e.n.i;
import h.k2.u.l;
import h.t1;
import java.util.List;

/* loaded from: classes2.dex */
public interface g {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ void a(g gVar, LifecycleOwner lifecycleOwner, l lVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observeRarity");
            }
            if ((i2 & 1) != 0) {
                lifecycleOwner = null;
            }
            gVar.z(lifecycleOwner, lVar);
        }
    }

    @k.e.a.d
    e.n.f<List<Rarity>> H();

    @k.e.a.e
    String J();

    void b0(@k.e.a.e List<Rarity> list);

    @k.e.a.d
    i c();

    @k.e.a.d
    l<List<Rarity>, t1> i0();

    void j();

    void z(@k.e.a.e LifecycleOwner lifecycleOwner, @k.e.a.d l<? super String, t1> lVar);
}
