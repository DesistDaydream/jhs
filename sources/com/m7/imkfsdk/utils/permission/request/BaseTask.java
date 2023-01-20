package com.m7.imkfsdk.utils.permission.request;

import com.m7.imkfsdk.utils.permission.PermissionX;
import com.m7.imkfsdk.utils.permission.callback.RequestCallback;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class BaseTask implements ChainTask {
    public ExplainScope explainReasonScope;
    public ForwardScope forwardToSettingsScope;
    public ChainTask next;
    public PermissionBuilder pb;

    public BaseTask(PermissionBuilder permissionBuilder) {
        this.pb = permissionBuilder;
        this.explainReasonScope = new ExplainScope(permissionBuilder, this);
        this.forwardToSettingsScope = new ForwardScope(this.pb, this);
    }

    @Override // com.m7.imkfsdk.utils.permission.request.ChainTask
    public void finish() {
        ChainTask chainTask = this.next;
        if (chainTask != null) {
            chainTask.request();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.pb.deniedPermissions);
        arrayList.addAll(this.pb.permanentDeniedPermissions);
        arrayList.addAll(this.pb.permissionsWontRequest);
        PermissionBuilder permissionBuilder = this.pb;
        if (permissionBuilder.requireBackgroundLocationPermission) {
            if (PermissionX.isGranted(permissionBuilder.activity, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                this.pb.grantedPermissions.add("android.permission.ACCESS_BACKGROUND_LOCATION");
            } else {
                arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
            }
        }
        RequestCallback requestCallback = this.pb.requestCallback;
        if (requestCallback != null) {
            requestCallback.onResult(arrayList.isEmpty(), new ArrayList(this.pb.grantedPermissions), arrayList);
        }
    }

    @Override // com.m7.imkfsdk.utils.permission.request.ChainTask
    public ExplainScope getExplainScope() {
        return this.explainReasonScope;
    }

    @Override // com.m7.imkfsdk.utils.permission.request.ChainTask
    public ForwardScope getForwardScope() {
        return this.forwardToSettingsScope;
    }
}
