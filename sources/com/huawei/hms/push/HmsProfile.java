package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.ProfileTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.ProfileReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes2.dex */
public class HmsProfile {
    public static final int CUSTOM_PROFILE = 2;
    public static final int HUAWEI_PROFILE = 1;
    public static final String a = "HmsProfile";
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public HuaweiApi<Api.ApiOptions.NoOptions> f3640c;

    public HmsProfile(Context context) {
        this.b = null;
        Preconditions.checkNotNull(context);
        this.b = context;
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(context, new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, new PushClientBuilder());
        this.f3640c = huaweiApi;
        huaweiApi.setKitSdkVersion(60500300);
    }

    public static HmsProfile getInstance(Context context) {
        return new HmsProfile(context);
    }

    public final e.k.b.a.k<Void> a(int i2, String str, int i3, String str2) {
        if (!isSupportProfile()) {
            e.k.b.a.l lVar = new e.k.b.a.l();
            lVar.c(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
            return lVar.b();
        }
        if (!TextUtils.isEmpty(str)) {
            String a2 = a(this.b);
            if (TextUtils.isEmpty(a2)) {
                HMSLog.i(a, "agc connect services config missing project id.");
                e.k.b.a.l lVar2 = new e.k.b.a.l();
                lVar2.c(ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException());
                return lVar2.b();
            } else if (str.equals(a2)) {
                str = "";
            }
        }
        ProfileReq profileReq = new ProfileReq();
        if (i2 == 0) {
            profileReq.setOperation(0);
            profileReq.setType(i3);
        } else {
            profileReq.setOperation(1);
        }
        String reportEntry = PushBiUtil.reportEntry(this.b, PushNaming.PUSH_PROFILE);
        try {
            profileReq.setSubjectId(str);
            profileReq.setProfileId(e.k.c.a.a.h.d.d.b(str2));
            profileReq.setPkgName(this.b.getPackageName());
            return this.f3640c.doWrite(new ProfileTask(PushNaming.PUSH_PROFILE, JsonUtil.createJsonString(profileReq), reportEntry));
        } catch (Exception e2) {
            if (e2.getCause() instanceof ApiException) {
                e.k.b.a.l lVar3 = new e.k.b.a.l();
                ApiException apiException = (ApiException) e2.getCause();
                lVar3.c(apiException);
                PushBiUtil.reportExit(this.b, PushNaming.PUSH_PROFILE, reportEntry, apiException.getStatusCode());
                return lVar3.b();
            }
            e.k.b.a.l lVar4 = new e.k.b.a.l();
            Context context = this.b;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            PushBiUtil.reportExit(context, PushNaming.PUSH_PROFILE, reportEntry, errorEnum);
            lVar4.c(errorEnum.toApiException());
            return lVar4.b();
        }
    }

    public e.k.b.a.k<Void> addProfile(int i2, String str) {
        return addProfile("", i2, str);
    }

    public final boolean b(Context context) {
        return s.b(context) >= 110001400;
    }

    public e.k.b.a.k<Void> deleteProfile(String str) {
        return deleteProfile("", str);
    }

    public boolean isSupportProfile() {
        if (s.d(this.b)) {
            if (s.c()) {
                HMSLog.i(a, "current EMUI version below 9.1, not support profile operation.");
                return false;
            } else if (b(this.b)) {
                return true;
            } else {
                HMSLog.i(a, "current HwPushService.apk version below 11.0.1.400,please upgrade your HwPushService.apk version.");
                return false;
            }
        }
        return true;
    }

    public e.k.b.a.k<Void> addProfile(String str, int i2, String str2) {
        if (i2 != 1 && i2 != 2) {
            HMSLog.i(a, "add profile type undefined.");
            e.k.b.a.l lVar = new e.k.b.a.l();
            lVar.c(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
            return lVar.b();
        } else if (TextUtils.isEmpty(str2)) {
            HMSLog.i(a, "add profile params is empty.");
            e.k.b.a.l lVar2 = new e.k.b.a.l();
            lVar2.c(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
            return lVar2.b();
        } else {
            return a(0, str, i2, str2);
        }
    }

    public e.k.b.a.k<Void> deleteProfile(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            HMSLog.e(a, "del profile params is empty.");
            e.k.b.a.l lVar = new e.k.b.a.l();
            lVar.c(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
            return lVar.b();
        }
        return a(1, str, -1, str2);
    }

    public static String a(Context context) {
        return AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }
}
