package com.huawei.hms.aaid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.c;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.j;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;
import com.xiaomi.mipush.sdk.Constants;
import e.k.b.a.k;
import e.k.b.a.l;
import e.k.b.a.n;

/* loaded from: classes2.dex */
public class HmsInstanceId {
    public static final String TAG = "HmsInstanceId";
    public Context a;
    public PushPreferences b;

    /* renamed from: c */
    public HuaweiApi<Api.ApiOptions.NoOptions> f3407c;

    public HmsInstanceId(Context context) {
        this.a = context.getApplicationContext();
        this.b = new PushPreferences(context, "aaid");
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(context, new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, new PushClientBuilder());
        this.f3407c = huaweiApi;
        huaweiApi.setKitSdkVersion(60300305);
    }

    public static HmsInstanceId getInstance(Context context) {
        Preconditions.checkNotNull(context);
        c.c(context);
        return new HmsInstanceId(context);
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (p.e(this.a)) {
            String string = i.a(this.a).getString("subjectId");
            if (TextUtils.isEmpty(string)) {
                i.a(this.a).saveString("subjectId", str);
                return;
            } else if (string.contains(str)) {
                return;
            } else {
                i a = i.a(this.a);
                a.saveString("subjectId", string + Constants.ACCEPT_TIME_SEPARATOR_SP + str);
                return;
            }
        }
        i.a(this.a).removeKey("subjectId");
    }

    public final void b() throws ApiException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
        }
    }

    public void deleteAAID() throws ApiException {
        b();
        try {
            if (this.b.containsKey("aaid")) {
                this.b.removeKey("aaid");
                this.b.removeKey("creationTime");
                if (o.e(this.a)) {
                    if (ProxyCenter.getProxy() != null) {
                        HMSLog.i(TAG, "use proxy delete all token after delete AaId.");
                        ProxyCenter.getProxy().deleteAllToken(this.a);
                        return;
                    }
                    DeleteTokenReq b = o.b(this.a);
                    b.setDeleteType(1);
                    b.setMultiSender(false);
                    a(b, 1);
                    BaseUtils.deleteAllTokenCache(this.a);
                }
            }
        } catch (ApiException e2) {
            throw e2;
        } catch (Exception unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public void deleteToken(String str, String str2) throws ApiException {
        b();
        a();
        DeleteTokenReq a = o.a(this.a, str, str2);
        a.setMultiSender(false);
        a(a, 1);
    }

    public k<AAIDResult> getAAID() {
        try {
            return n.e(new j(this.a.getApplicationContext()));
        } catch (Exception unused) {
            l lVar = new l();
            lVar.c(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            return lVar.b();
        }
    }

    public long getCreationTime() {
        try {
            if (!this.b.containsKey("creationTime")) {
                getAAID();
            }
            return this.b.getLong("creationTime");
        } catch (Exception unused) {
            return 0L;
        }
    }

    public String getId() {
        return o.c(this.a);
    }

    @Deprecated
    public String getToken() {
        try {
            return getToken(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getToken(String str, String str2) throws ApiException {
        b();
        a();
        TokenReq b = o.b(this.a, null, str2);
        b.setAaid(getId());
        b.setMultiSender(false);
        i.a(this.a).saveString(this.a.getPackageName(), "1");
        return a(b, 1);
    }

    public void deleteToken(String str) throws ApiException {
        b();
        a();
        if (!TextUtils.isEmpty(str)) {
            String d2 = o.d(this.a);
            if (!TextUtils.isEmpty(d2)) {
                if (str.equals(d2)) {
                    deleteToken(null, null);
                    return;
                }
                DeleteTokenReq a = o.a(this.a, str);
                a.setMultiSender(true);
                a(a, 2);
                return;
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public String getToken(String str) throws ApiException {
        b();
        a();
        if (!TextUtils.isEmpty(str)) {
            String d2 = o.d(this.a);
            if (!TextUtils.isEmpty(d2)) {
                if (str.equals(d2)) {
                    return getToken(null, null);
                }
                TokenReq b = o.b(this.a, str);
                b.setAaid(getId());
                b.setMultiSender(true);
                return a(b, 2);
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public final String a(TokenReq tokenReq, int i2) throws ApiException {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            ProxyCenter.getProxy().getToken(this.a, tokenReq.getSubjectId(), null);
            return null;
        }
        a(tokenReq.getSubjectId());
        String a = q.a(this.a, "push.gettoken");
        try {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("getToken req :");
            sb.append(tokenReq.toString());
            HMSLog.d(str, sb.toString());
            com.huawei.hms.opendevice.l lVar = new com.huawei.hms.opendevice.l("push.gettoken", tokenReq, this.a, a);
            lVar.setApiLevel(i2);
            return ((TokenResult) n.c(this.f3407c.doWrite(lVar))).getToken();
        } catch (Exception e2) {
            if (e2.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e2.getCause();
                q.a(this.a, "push.gettoken", a, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            q.a(context, "push.gettoken", a, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    public final void a(DeleteTokenReq deleteTokenReq, int i2) throws ApiException {
        String subjectId = deleteTokenReq.getSubjectId();
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy delete token");
            ProxyCenter.getProxy().deleteToken(this.a, subjectId, null);
            return;
        }
        String a = q.a(this.a, "push.deletetoken");
        try {
            String b = i.a(this.a).b(subjectId);
            if (deleteTokenReq.isMultiSender() && (TextUtils.isEmpty(b) || b.equals(i.a(this.a).b(null)))) {
                i.a(this.a).removeKey(subjectId);
                HMSLog.i(TAG, "The local subject token is null");
                return;
            }
            deleteTokenReq.setToken(b);
            com.huawei.hms.opendevice.k kVar = new com.huawei.hms.opendevice.k("push.deletetoken", deleteTokenReq, a);
            kVar.setApiLevel(i2);
            n.c(this.f3407c.doWrite(kVar));
            i.a(this.a).c(subjectId);
        } catch (Exception e2) {
            if (e2.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e2.getCause();
                q.a(this.a, "push.deletetoken", a, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            q.a(context, "push.deletetoken", a, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    public final void a() throws ApiException {
        if (BaseUtils.getProxyInit(this.a) && ProxyCenter.getProxy() == null && !BaseUtils.isMainProc(this.a)) {
            HMSLog.e(TAG, "Operations in child processes are not supported.");
            throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
        }
    }
}
