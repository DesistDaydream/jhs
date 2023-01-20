package i.b.v3;

import com.umeng.analytics.pro.am;
import i.b.v3.u;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StartedWhileSubscribed;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Li/b/v3/u$a;", "Lh/u2/d;", "stopTimeout", "replayExpiration", "Li/b/v3/u;", am.av, "(Li/b/v3/u$a;DD)Li/b/v3/u;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class v {
    @h.u2.j
    @k.e.a.d
    public static final u a(@k.e.a.d u.a aVar, double d2, double d3) {
        return new StartedWhileSubscribed(h.u2.d.toLongMilliseconds-impl(d2), h.u2.d.toLongMilliseconds-impl(d3));
    }

    public static /* synthetic */ u b(u.a aVar, double d2, double d3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = h.u2.d.f15705e.getZERO-UwyO8pc();
        }
        if ((i2 & 2) != 0) {
            d3 = h.u2.d.f15705e.getINFINITE-UwyO8pc();
        }
        return a(aVar, d2, d3);
    }
}
