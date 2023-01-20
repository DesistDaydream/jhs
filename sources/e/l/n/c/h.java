package e.l.n.c;

import com.jihuanshe.model.InteractData;
import com.jihuanshe.model.InteractNewCount;
import com.jihuanshe.net.ServiceApiKt;
import com.jihuanshe.net.config.NetService;
import h.t1;
import kotlinx.coroutines.flow.Flow;
import okhttp3.FormBody;

@e.l.n.b(service = NetService.INTERACT)
/* loaded from: classes2.dex */
public interface h {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Flow a(h hVar, FormBody formBody, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    formBody = ServiceApiKt.a();
                }
                return hVar.e(formBody);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setReadAll");
        }
    }

    @l.y.f("have-new-messages")
    @k.e.a.d
    Flow<InteractNewCount> a();

    @l.y.f("review-reply")
    @k.e.a.d
    Flow<e.l.h.i.e<InteractData>> b(@l.y.t("page") int i2);

    @l.y.f("review-at")
    @k.e.a.d
    Flow<e.l.h.i.e<InteractData>> c(@l.y.t("page") int i2);

    @l.y.f("review-like")
    @k.e.a.d
    Flow<e.l.h.i.e<InteractData>> d(@l.y.t("page") int i2);

    @l.y.o("read-all")
    @k.e.a.d
    Flow<t1> e(@l.y.a @k.e.a.d FormBody formBody);

    @l.y.e
    @l.y.o("read")
    @k.e.a.d
    Flow<t1> f(@l.y.c("notification_id") int i2);
}
