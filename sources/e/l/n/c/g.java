package e.l.n.c;

import com.jihuanshe.model.Category;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GlobalConfig;
import com.jihuanshe.net.config.NetService;
import java.util.List;
import kotlinx.coroutines.flow.Flow;
import l.y.y;

@e.l.n.b(service = NetService.COMMON)
/* loaded from: classes2.dex */
public interface g {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Flow a(g gVar, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = "http://jihuanshe-qn-src.jihuanshe.com/configs/base_config.json";
                }
                return gVar.a(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConfig");
        }

        public static /* synthetic */ Flow b(g gVar, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = "http://jihuanshe-qn-src.jihuanshe.com/configs/games.json";
                }
                return gVar.b(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGames");
        }
    }

    @l.y.f
    @k.e.a.d
    Flow<GlobalConfig> a(@y @k.e.a.d String str);

    @l.y.f
    @k.e.a.d
    Flow<List<Game>> b(@y @k.e.a.d String str);

    @l.y.f
    @k.e.a.d
    Flow<List<Category>> c(@y @k.e.a.d String str);
}
