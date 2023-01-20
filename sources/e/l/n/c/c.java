package e.l.n.c;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.CardDetailInfo;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.net.config.NetService;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.CARD_VERSION)
/* loaded from: classes2.dex */
public interface c {
    @l.y.f("products")
    @k.e.a.d
    Flow<Result<e.l.h.i.e<GameCard>>> a(@l.y.t("card_version_id") int i2, @l.y.t("condition") int i3, @l.y.t("page") int i4, @k.e.a.e @l.y.t("game_key") String str, @k.e.a.e @l.y.t("game_sub_key") String str2);

    @l.y.f("wishes")
    @k.e.a.d
    Flow<Result<e.l.h.i.e<GameCard>>> b(@l.y.t("card_version_id") int i2, @l.y.t("page") int i3, @k.e.a.e @l.y.t("game_key") String str, @k.e.a.e @l.y.t("game_sub_key") String str2);

    @l.y.f("{card_version_id}")
    @k.e.a.d
    Flow<e.l.h.i.b<CardDetailInfo>> c(@l.y.s("card_version_id") int i2, @k.e.a.e @l.y.t("game_key") String str, @k.e.a.e @l.y.t("game_sub_key") String str2);
}
