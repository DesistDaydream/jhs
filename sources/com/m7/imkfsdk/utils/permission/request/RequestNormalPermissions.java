package com.m7.imkfsdk.utils.permission.request;

import com.m7.imkfsdk.utils.permission.PermissionX;
import com.m7.imkfsdk.utils.permission.callback.ExplainReasonCallbackWithBeforeParam;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes2.dex */
public class RequestNormalPermissions extends BaseTask {
    public RequestNormalPermissions(PermissionBuilder permissionBuilder) {
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
        ArrayList arrayList = new ArrayList();
        for (String str : this.pb.normalPermissions) {
            if (PermissionX.isGranted(this.pb.activity, str)) {
                this.pb.grantedPermissions.add(str);
            } else {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            finish();
            return;
        }
        PermissionBuilder permissionBuilder = this.pb;
        if (permissionBuilder.explainReasonBeforeRequest && (permissionBuilder.explainReasonCallback != null || permissionBuilder.explainReasonCallbackWithBeforeParam != null)) {
            permissionBuilder.explainReasonBeforeRequest = false;
            permissionBuilder.deniedPermissions.addAll(arrayList);
            PermissionBuilder permissionBuilder2 = this.pb;
            ExplainReasonCallbackWithBeforeParam explainReasonCallbackWithBeforeParam = permissionBuilder2.explainReasonCallbackWithBeforeParam;
            if (explainReasonCallbackWithBeforeParam != null) {
                explainReasonCallbackWithBeforeParam.onExplainReason(this.explainReasonScope, arrayList, true);
                return;
            } else {
                permissionBuilder2.explainReasonCallback.onExplainReason(this.explainReasonScope, arrayList);
                return;
            }
        }
        permissionBuilder.requestNow(permissionBuilder.normalPermissions, this);
    }

    @Override // com.m7.imkfsdk.utils.permission.request.ChainTask
    public void requestAgain(List<String> list) {
        HashSet hashSet = new HashSet(this.pb.grantedPermissions);
        hashSet.addAll(list);
        this.pb.requestNow(hashSet, this);
    }
}
