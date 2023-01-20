package com.m7.imkfsdk.utils.permission.request;

import java.util.List;

/* loaded from: classes2.dex */
public class ExplainScope {
    private ChainTask chainTask;
    private PermissionBuilder pb;

    public ExplainScope(PermissionBuilder permissionBuilder, ChainTask chainTask) {
        this.pb = permissionBuilder;
        this.chainTask = chainTask;
    }

    public void showRequestReasonDialog(List<String> list, String str, String str2, String str3) {
        this.pb.showHandlePermissionDialog(this.chainTask, true, list, str, str2, str3);
    }

    public void showRequestReasonDialog(List<String> list, String str, String str2) {
        showRequestReasonDialog(list, str, str2, null);
    }
}
