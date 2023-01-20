package com.m7.imkfsdk.utils.permission.request;

import java.util.List;

/* loaded from: classes2.dex */
public class ForwardScope {
    private ChainTask chainTask;
    private PermissionBuilder pb;

    public ForwardScope(PermissionBuilder permissionBuilder, ChainTask chainTask) {
        this.pb = permissionBuilder;
        this.chainTask = chainTask;
    }

    public void showForwardToSettingsDialog(List<String> list, String str, String str2, String str3) {
        this.pb.showHandlePermissionDialog(this.chainTask, false, list, str, str2, str3);
    }

    public void showForwardToSettingsDialog(List<String> list, String str, String str2) {
        showForwardToSettingsDialog(list, str, str2, null);
    }
}
