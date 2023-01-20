package e.l.s.j;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.model.UserAddress;
import e.l.h.l.b;
import e.l.n.c.k;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class a extends b {
    @d
    private final NLive<List<UserAddress>> b = new NLive<>(null, 1, null);

    @d
    public final e.g.d.a<List<UserAddress>> p0() {
        return e.g.d.a.h(FlowKt.a(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).R(null), this.b), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<UserAddress>> q0() {
        return this.b;
    }
}
