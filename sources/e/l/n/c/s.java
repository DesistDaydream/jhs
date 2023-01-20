package e.l.n.c;

import com.jihuanshe.model.SearchResultCount;
import com.jihuanshe.model.SearchUser;
import com.jihuanshe.net.config.NetService;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.SEARCH)
/* loaded from: classes2.dex */
public interface s {
    @l.y.f("match-count")
    @k.e.a.d
    Flow<SearchResultCount> a(@k.e.a.d @l.y.t("keyword") String str);

    @l.y.f("match-user")
    @k.e.a.d
    Flow<e.l.h.i.e<SearchUser>> b(@k.e.a.d @l.y.t("keyword") String str, @l.y.t("page") int i2);
}
