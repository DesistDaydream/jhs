package e.l.n.c;

import com.jihuanshe.model.CardInfo;
import com.jihuanshe.model.Game;
import com.jihuanshe.net.config.NetService;
import com.jihuanshe.ui.widget.GameBar;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.CARD)
/* loaded from: classes2.dex */
public interface a {

    /* renamed from: e.l.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0390a {
        public static /* synthetic */ Flow a(a aVar, int i2, String str, String str2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str = value == null ? null : value.getGameKey();
                }
                if ((i3 & 4) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    str2 = value2 == null ? null : value2.getGameSubKey();
                }
                return aVar.a(i2, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCardInfo");
        }
    }

    @l.y.f("{id}")
    @k.e.a.d
    Flow<e.l.h.i.b<CardInfo>> a(@l.y.s("id") int i2, @k.e.a.e @l.y.t("game_key") String str, @k.e.a.e @l.y.t("game_sub_key") String str2);
}
