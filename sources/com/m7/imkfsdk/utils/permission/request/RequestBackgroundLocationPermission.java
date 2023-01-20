package com.m7.imkfsdk.utils.permission.request;

import com.m7.imkfsdk.utils.permission.PermissionX;
import com.m7.imkfsdk.utils.permission.callback.ExplainReasonCallbackWithBeforeParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class RequestBackgroundLocationPermission extends BaseTask {
    public static final String ACCESS_BACKGROUND_LOCATION = "android.permission.ACCESS_BACKGROUND_LOCATION";

    public RequestBackgroundLocationPermission(PermissionBuilder permissionBuilder) {
        super(permissionBuilder);
    }

    @Override // com.m7.imkfsdk.utils.permission.request.BaseTask, com.m7.imkfsdk.utils.permission.request.ChainTask
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.m7.imkfsdk.utils.permission.request.BaseTask, com.m7.imkfsdk.utils.permission.request.ChainTask
    public /* bridge */ /* synthetic */ ExplainScope getExplainScope() {
        return super.getExplainScope();
    }

    @Override // com.m7.imkfsdk.utils.permission.request.BaseTask, com.m7.imkfsdk.utils.permission.request.ChainTask
    public /* bridge */ /* synthetic */ ForwardScope getForwardScope() {
        return super.getForwardScope();
    }

    @Override // com.m7.imkfsdk.utils.permission.request.ChainTask
    public void request() {
        PermissionBuilder permissionBuilder = this.pb;
        if (permissionBuilder.requireBackgroundLocationPermission) {
            boolean isGranted = PermissionX.isGranted(permissionBuilder.activity, "android.permission.ACCESS_FINE_LOCATION");
            boolean isGranted2 = PermissionX.isGranted(this.pb.activity, "android.permission.ACCESS_COARSE_LOCATION");
            if (isGranted || isGranted2) {
                PermissionBuilder permissionBuilder2 = this.pb;
                if (permissionBuilder2.explainReasonCallback == null && permissionBuilder2.explainReasonCallbackWithBeforeParam == null) {
                    requestAgain(null);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                PermissionBuilder permissionBuilder3 = this.pb;
                ExplainReasonCallbackWithBeforeParam explainReasonCallbackWithBeforeParam = permissionBuilder3.explainReasonCallbackWithBeforeParam;
                if (explainReasonCallbackWithBeforeParam != null) {
                    explainReasonCallbackWithBeforeParam.onExplainReason(this.explainReasonScope, arrayList, true);
                    return;
                } else {
                    permissionBuilder3.explainReasonCallback.onExplainReason(this.explainReasonScope, arrayList);
                    return;
                }
            }
        }
        finish();
    }

    @Override // com.m7.imkfsdk.utils.permission.request.ChainTask
    public void requestAgain(List<String> list) {
        this.pb.requestAccessBackgroundLocationNow(this);
    }
}
