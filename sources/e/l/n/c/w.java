package e.l.n.c;

import com.jihuanshe.net.config.NetService;
import h.t1;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.USER)
/* loaded from: classes2.dex */
public interface w {
    @l.y.f("reportIssue")
    @k.e.a.d
    Flow<t1> a(@l.y.t("seller_user_id") int i2, @l.y.t("card_version_id") int i3, @k.e.a.d @l.y.t("reason") String str, @k.e.a.d @l.y.t("game_key") String str2, @k.e.a.d @l.y.t("game_sub_key") String str3);

    @l.y.e
    @l.y.o("follow")
    @k.e.a.d
    Flow<t1> b(@l.y.c("following_user_id") int i2);

    @l.y.e
    @l.y.o("cancelFollow")
    @k.e.a.d
    Flow<t1> c(@l.y.c("following_user_id") int i2);
}
