package e.l.n.c;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.net.config.NetService;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.PRODUCT)
/* loaded from: classes2.dex */
public interface p {
    @l.y.f("bySeller")
    @k.e.a.d
    Flow<Result<e.l.h.i.e<GameCard>>> a(@k.e.a.e @l.y.t("wish_list_id") Integer num, @l.y.t("seller_user_id") int i2, @k.e.a.e @l.y.t("rarity") String str, @k.e.a.e @l.y.t("sorting") String str2, @k.e.a.e @l.y.t("keyword") String str3, @k.e.a.d @l.y.t("game_key") String str4, @k.e.a.d @l.y.t("game_sub_key") String str5, @l.y.t("page") int i3);

    @l.y.f("bySeller")
    @k.e.a.d
    Flow<e.l.h.i.e<GameCard>> b(@l.y.t("seller_user_id") int i2, @k.e.a.e @l.y.t("rarity") String str, @k.e.a.e @l.y.t("sorting") String str2, @k.e.a.e @l.y.t("keyword") String str3, @k.e.a.d @l.y.t("game_key") String str4, @k.e.a.d @l.y.t("game_sub_key") String str5, @l.y.t("page") int i3);
}
