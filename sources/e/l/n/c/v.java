package e.l.n.c;

import com.jihuanshe.model.CloseContent;
import com.jihuanshe.model.UploadInfo;
import com.jihuanshe.model.User;
import com.jihuanshe.net.ServiceApiKt;
import com.jihuanshe.net.config.NetService;
import h.t1;
import kotlinx.coroutines.flow.Flow;
import okhttp3.FormBody;

@e.l.n.b(service = NetService.USER)
/* loaded from: classes2.dex */
public interface v {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Flow a(v vVar, FormBody formBody, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    formBody = ServiceApiKt.a();
                }
                return vVar.g(formBody);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closeAccount");
        }

        public static /* synthetic */ Flow b(v vVar, String str, String str2, String str3, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    str3 = "avatar";
                }
                return vVar.d(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUploadInfo");
        }
    }

    @l.y.f("following")
    @k.e.a.d
    Flow<e.l.h.i.e<User>> a(@l.y.t("user_id") int i2, @l.y.t("page") int i3);

    @l.y.f("get-delete-account-info")
    @k.e.a.d
    Flow<CloseContent> b();

    @l.y.f("followers")
    @k.e.a.d
    Flow<e.l.h.i.e<User>> c(@l.y.t("user_id") int i2, @l.y.t("page") int i3);

    @l.y.f("get-upload-token")
    @k.e.a.d
    Flow<UploadInfo> d(@k.e.a.d @l.y.t("filename") String str, @k.e.a.e @l.y.t("token") String str2, @k.e.a.d @l.y.t("type") String str3);

    @l.y.e
    @l.y.o("reportUserMessage")
    @k.e.a.d
    Flow<t1> e(@l.y.c("user_id") int i2, @l.y.c("type") @k.e.a.d String str, @l.y.c("reason") @k.e.a.d String str2);

    @l.y.f("{uid}")
    @k.e.a.d
    Flow<User> f(@l.y.s("uid") int i2);

    @l.y.o("delete-account")
    @k.e.a.d
    Flow<CloseContent> g(@l.y.a @k.e.a.d FormBody formBody);
}
