package e.l.n.c;

import com.jihuanshe.model.CardBaseInfo;
import com.jihuanshe.model.DatePrice;
import com.jihuanshe.model.Game;
import com.jihuanshe.net.config.NetService;
import com.jihuanshe.ui.page.detail.CardViewInfo;
import com.jihuanshe.ui.widget.GameBar;
import java.util.List;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.CARD_VERSION)
/* loaded from: classes2.dex */
public interface b {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Flow a(b bVar, int i2, String str, String str2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str = value == null ? null : value.getGameKey();
                    if (str == null) {
                        str = "";
                    }
                }
                if ((i3 & 4) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str2 = gameSubKey != null ? gameSubKey : "";
                }
                return bVar.b(i2, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAveragePrice");
        }
    }

    @l.y.f("user-images")
    @k.e.a.d
    Flow<List<CardViewInfo>> a(@l.y.t("card_version_id") int i2, @k.e.a.e @l.y.t("game_key") String str);

    @l.y.f("price-history")
    @k.e.a.d
    Flow<e.l.h.i.b<List<DatePrice>>> b(@l.y.t("card_version_id") int i2, @k.e.a.e @l.y.t("game_key") String str, @k.e.a.e @l.y.t("game_sub_key") String str2);

    @l.y.f("get-base-info")
    @k.e.a.d
    Flow<e.l.h.i.b<CardBaseInfo>> c(@k.e.a.e @l.y.t("game_key") String str, @l.y.t("card_version_id") int i2);

    @l.y.f("price-history")
    @k.e.a.d
    Flow<e.l.h.i.b<List<DatePrice>>> d(@l.y.t("card_version_id") int i2, @k.e.a.e @l.y.t("filter") String str, @k.e.a.e @l.y.t("game_key") String str2);
}
