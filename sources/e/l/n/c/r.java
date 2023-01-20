package e.l.n.c;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.Product;
import com.jihuanshe.net.config.NetService;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.SEARCH)
/* loaded from: classes2.dex */
public interface r {
    @l.y.f("match-product")
    @k.e.a.d
    Flow<Result<e.l.h.i.e<Product>>> a(@k.e.a.e @l.y.t("type") String str, @k.e.a.d @l.y.t("keyword") String str2, @k.e.a.e @l.y.t("game_key") String str3, @k.e.a.e @l.y.t("game_sub_key") String str4, @k.e.a.e @l.y.t("rarity") String str5, @l.y.t("page") int i2);
}
