package e.l.n.c;

import com.jihuanshe.model.CardProduct;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.net.config.NetService;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.PRODUCT)
/* loaded from: classes2.dex */
public interface o {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Flow a(o oVar, int i2, int i3, int i4, String str, String str2, int i5, Object obj) {
            if (obj == null) {
                if ((i5 & 16) != 0) {
                    str2 = null;
                }
                return oVar.b(i2, i3, i4, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSellerCardVersionNew");
        }
    }

    @l.y.f("bySellerCardVersionId")
    @k.e.a.d
    Flow<CardProduct> a(@l.y.t("seller_user_id") int i2, @l.y.t("card_version_id") int i3, @k.e.a.d @l.y.t("game_key") String str, @k.e.a.d @l.y.t("game_sub_key") String str2);

    @l.y.f("bySellerCardVersionId")
    @k.e.a.d
    Flow<CardProductNew> b(@l.y.t("seller_user_id") int i2, @l.y.t("card_version_id") int i3, @l.y.t("append_warehouse") int i4, @k.e.a.d @l.y.t("game_key") String str, @k.e.a.e @l.y.t("game_sub_key") String str2);
}
