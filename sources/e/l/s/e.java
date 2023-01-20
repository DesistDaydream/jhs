package e.l.s;

import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.model.Game;
import h.k2.u.l;
import h.t1;
import java.util.List;

/* loaded from: classes2.dex */
public interface e {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ void a(e eVar, LifecycleOwner lifecycleOwner, l lVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observeGame");
            }
            if ((i2 & 1) != 0) {
                lifecycleOwner = null;
            }
            eVar.a(lifecycleOwner, lVar);
        }
    }

    void a(@k.e.a.e LifecycleOwner lifecycleOwner, @k.e.a.d l<? super Game, t1> lVar);

    @k.e.a.e
    Game b();

    @k.e.a.d
    l<Game, t1> c();

    @k.e.a.d
    e.n.f<List<Game>> d();

    void reset();
}
