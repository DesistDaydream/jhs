package com.huawei.hms.push;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.ConsentTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableConsentReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes2.dex */
public class HmsConsent {
    public HuaweiApi<Api.ApiOptions.NoOptions> a;
    public Context b;

    public HmsConsent(Context context) {
        Preconditions.checkNotNull(context);
        this.b = context;
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(context, new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, new PushClientBuilder());
        this.a = huaweiApi;
        huaweiApi.setKitSdkVersion(60500300);
    }

    public static HmsConsent getInstance(Context context) {
        return new HmsConsent(context);
    }

    public final e.k.b.a.k<Void> a(boolean z) {
        e.k.b.a.l lVar;
        int externalCode;
        String reportEntry = PushBiUtil.reportEntry(this.b, PushNaming.PUSH_CONSENT);
        try {
            if (s.d(this.b)) {
                EnableConsentReq enableConsentReq = new EnableConsentReq();
                enableConsentReq.setPackageName(this.b.getPackageName());
                enableConsentReq.setEnable(z);
                return this.a.doWrite(new ConsentTask(PushNaming.PUSH_CONSENT, JsonUtil.createJsonString(enableConsentReq), reportEntry));
            }
            throw ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException();
        } catch (ApiException e2) {
            e.k.b.a.l lVar2 = new e.k.b.a.l();
            lVar2.c(e2);
            externalCode = e2.getStatusCode();
            lVar = lVar2;
            PushBiUtil.reportExit(this.b, PushNaming.PUSH_CONSENT, reportEntry, externalCode);
            return lVar.b();
        } catch (Exception unused) {
            lVar = new e.k.b.a.l();
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            lVar.c(errorEnum.toApiException());
            externalCode = errorEnum.getExternalCode();
            PushBiUtil.reportExit(this.b, PushNaming.PUSH_CONSENT, reportEntry, externalCode);
            return lVar.b();
        }
    }

    public e.k.b.a.k<Void> consentOff() {
        return a(false);
    }

    public e.k.b.a.k<Void> consentOn() {
        return a(true);
    }
}
