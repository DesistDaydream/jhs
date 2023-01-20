package e.l.n.c;

import com.effective.android.panel.Constants;
import com.jihuanshe.model.UpdateUserInfoResult;
import com.jihuanshe.model.User;
import com.jihuanshe.model.UserNumber;
import com.jihuanshe.net.config.NetService;
import h.t1;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.AUTH)
/* loaded from: classes2.dex */
public interface i {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Flow a(i iVar, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = null;
                }
                return iVar.f(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshUserInfo");
        }

        public static /* synthetic */ Flow b(i iVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = null;
                }
                if ((i2 & 2) != 0) {
                    str2 = null;
                }
                if ((i2 & 4) != 0) {
                    str3 = null;
                }
                if ((i2 & 8) != 0) {
                    str4 = null;
                }
                if ((i2 & 16) != 0) {
                    str5 = null;
                }
                if ((i2 & 32) != 0) {
                    str6 = null;
                }
                if ((i2 & 64) != 0) {
                    str7 = null;
                }
                if ((i2 & 128) != 0) {
                    str8 = null;
                }
                if ((i2 & 256) != 0) {
                    str9 = null;
                }
                return iVar.i(str, str2, str3, str4, str5, str6, str7, str8, str9);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateInfo");
        }

        public static /* synthetic */ Flow c(i iVar, String str, String str2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str2 = Constants.ANDROID;
                }
                return iVar.a(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadPushToken");
        }
    }

    @l.y.e
    @l.y.o("update-push-token")
    @k.e.a.d
    Flow<t1> a(@l.y.c("push_token") @k.e.a.d String str, @l.y.c("push_device") @k.e.a.d String str2);

    @l.y.e
    @l.y.o("modify-bind-phone")
    @k.e.a.d
    Flow<t1> b(@l.y.c("original_phone") @k.e.a.d String str, @l.y.c("original_phone_code") @k.e.a.d String str2, @l.y.c("modify_phone") @k.e.a.d String str3, @l.y.c("modify_phone_code") @k.e.a.d String str4);

    @l.y.f("wechat-sns-login")
    @k.e.a.d
    Flow<User> c(@k.e.a.d @l.y.t("code") String str);

    @l.y.e
    @l.y.o("verify-phone-by-code")
    @k.e.a.d
    Flow<t1> d(@l.y.c("phone") @k.e.a.d String str, @l.y.c("code") @k.e.a.d String str2);

    @l.y.e
    @l.y.o("login-or-signup")
    @k.e.a.d
    Flow<User> e(@l.y.c("phone") @k.e.a.d String str, @l.y.c("code") @k.e.a.d String str2);

    @l.y.f("getUserInfo")
    @k.e.a.d
    Flow<User> f(@k.e.a.e @l.y.t("token") String str);

    @l.y.f("getUserInfoNumbers")
    @k.e.a.d
    Flow<UserNumber> g();

    @l.y.e
    @l.y.o("send-sms")
    @k.e.a.d
    Flow<t1> h(@l.y.c("phone") @k.e.a.d String str);

    @l.y.e
    @l.y.o("updateUserInfo")
    @k.e.a.d
    Flow<UpdateUserInfoResult> i(@k.e.a.e @l.y.c("username") String str, @k.e.a.e @l.y.c("seller_bio") String str2, @k.e.a.e @l.y.c("setting_province") String str3, @k.e.a.e @l.y.c("setting_city") String str4, @k.e.a.e @l.y.c("setting_district") String str5, @k.e.a.e @l.y.c("shipping_price") String str6, @k.e.a.e @l.y.c("free_shipping_amount") String str7, @k.e.a.e @l.y.c("avatar") String str8, @k.e.a.e @l.y.t("token") String str9);
}
