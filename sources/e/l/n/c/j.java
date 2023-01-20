package e.l.n.c;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.MatchResult;
import com.jihuanshe.net.config.NetService;
import com.jihuanshe.ui.widget.GameBar;
import java.util.List;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.MARKET)
/* loaded from: classes2.dex */
public interface j {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Flow a(j jVar, String str, int i2, String str2, String str3, Integer num, String str4, String str5, int i3, Object obj) {
            String str6;
            String str7;
            if (obj == null) {
                Integer num2 = (i3 & 16) != 0 ? null : num;
                if ((i3 & 32) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str6 = value == null ? null : value.getGameKey();
                } else {
                    str6 = str4;
                }
                if ((i3 & 64) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    str7 = value2 == null ? null : value2.getGameSubKey();
                } else {
                    str7 = str5;
                }
                return jVar.e(str, i2, str2, str3, num2, str6, str7);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWishCardList");
        }
    }

    @l.y.f("wishes/match")
    @k.e.a.d
    Flow<Result<List<MatchResult>>> a(@k.e.a.e @l.y.t("game_key") String str, @k.e.a.e @l.y.t("game_sub_key") String str2, @k.e.a.e @l.y.t("wish_list_id") Integer num, @k.e.a.e @l.y.t("ignore_card_version") Integer num2);

    @l.y.f("sellers/products")
    @k.e.a.d
    Flow<Result<e.l.h.i.e<GameCard>>> b(@l.y.t("on_sale") int i2, @k.e.a.e @l.y.t("rarity") String str, @k.e.a.e @l.y.t("sorting") String str2, @k.e.a.e @l.y.t("keyword") String str3, @k.e.a.e @l.y.t("game_key") String str4, @k.e.a.e @l.y.t("game_sub_key") String str5, @l.y.t("page") int i3);

    @l.y.f("carts")
    @k.e.a.d
    Flow<Result<List<CardProduct>>> c(@l.y.t("seller_user_id") int i2);

    @l.y.f("card-versions")
    @k.e.a.d
    Flow<Result<e.l.h.i.b<e.l.h.i.e<GameCard>>>> d(@k.e.a.e @l.y.t("cardId") Integer num, @k.e.a.e @l.y.t("packId") Integer num2, @k.e.a.e @l.y.t("categoryId") Integer num3, @k.e.a.e @l.y.t("keyword") String str, @k.e.a.e @l.y.t("append_seller") Integer num4, @k.e.a.e @l.y.t("append_warehouse") Integer num5, @k.e.a.e @l.y.t("rarity") String str2, @k.e.a.e @l.y.t("sorting") String str3, @k.e.a.e @l.y.t("sorting_price_type") String str4, @k.e.a.d @l.y.t("game_key") String str5, @k.e.a.d @l.y.t("game_sub_key") String str6, @l.y.t("page") int i2);

    @l.y.f("wishes")
    @k.e.a.d
    Flow<Result<e.l.h.i.e<GameCard>>> e(@k.e.a.e @l.y.t("keyword") String str, @l.y.t("page") int i2, @k.e.a.e @l.y.t("rarity") String str2, @k.e.a.e @l.y.t("sorting") String str3, @k.e.a.e @l.y.t("user_id") Integer num, @k.e.a.e @l.y.t("game_key") String str4, @k.e.a.e @l.y.t("game_sub_key") String str5);

    @l.y.f("products")
    @k.e.a.d
    Flow<Result<e.l.h.i.b<e.l.h.i.e<GameCard>>>> f(@k.e.a.e @l.y.t("rarity") String str, @k.e.a.e @l.y.t("sorting") String str2, @k.e.a.d @l.y.t("game_key") String str3, @k.e.a.d @l.y.t("game_sub_key") String str4, @k.e.a.e @l.y.t("keyword") String str5, @l.y.t("page") int i2);
}
