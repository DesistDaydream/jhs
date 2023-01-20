package e.l.n.c;

import com.jihuanshe.model.RankCardInfo;
import com.jihuanshe.model.RankTypeInfo;
import com.jihuanshe.net.config.NetService;
import java.util.List;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.MARKET)
/* loaded from: classes2.dex */
public interface q {
    @l.y.f("ranking/type")
    @k.e.a.d
    Flow<List<RankTypeInfo>> a();

    @l.y.f("ranking")
    @k.e.a.d
    Flow<e.l.h.i.e<RankCardInfo>> b(@k.e.a.d @l.y.t("type") String str, @l.y.t("ranking_type") int i2, @k.e.a.e @l.y.t("game_key") String str2, @k.e.a.e @l.y.t("game_sub_key") String str3, @l.y.t("page") int i3);
}
