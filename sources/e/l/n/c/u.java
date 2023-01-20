package e.l.n.c;

import com.jihuanshe.model.Poster;
import com.jihuanshe.net.config.NetService;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.SHARE)
/* loaded from: classes2.dex */
public interface u {
    @l.y.f("getShareImageUrl")
    @k.e.a.d
    Flow<Poster> a(@k.e.a.d @l.y.t("game_key") String str, @k.e.a.d @l.y.t("game_sub_key") String str2);
}
