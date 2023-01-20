package e.l.s.n;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.model.BankDetail;
import e.l.n.c.k;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class b extends e.l.h.l.b {
    @d
    private final NLive<List<BankDetail>> b = new NLive<>(null, 1, null);

    @d
    public final NLive<List<BankDetail>> p0() {
        return this.b;
    }

    @d
    public final e.g.d.a<List<BankDetail>> q0(@d String str, @d String str2) {
        return e.g.d.a.h(FlowKt.a(k.a.u((k) e.l.n.a.d(k.class, true, false, false, 60L, true), str, str2, null, 4, null), this.b), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
