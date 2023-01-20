package e.l.n.c;

import com.jihuanshe.model.PackDetailResult;
import com.jihuanshe.net.config.NetService;
import h.t1;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.PACK)
/* loaded from: classes2.dex */
public interface m {
    @l.y.e
    @l.y.o("unlike")
    @k.e.a.d
    Flow<t1> a(@l.y.c("pack_id") int i2, @k.e.a.e @l.y.c("game_key") String str);

    @l.y.e
    @l.y.o("like")
    @k.e.a.d
    Flow<t1> b(@l.y.c("pack_id") int i2, @k.e.a.e @l.y.c("game_key") String str);

    @l.y.f("{pack_id}")
    @k.e.a.d
    Flow<e.l.h.i.b<PackDetailResult>> c(@l.y.s("pack_id") int i2, @k.e.a.e @l.y.t("game_key") String str, @k.e.a.e @l.y.t("game_sub_key") String str2);
}
