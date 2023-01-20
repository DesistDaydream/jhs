package com.m7.imkfsdk.utils.permission.request;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.m7.imkfsdk.utils.permission.callback.ExplainReasonCallback;
import com.m7.imkfsdk.utils.permission.callback.ExplainReasonCallbackWithBeforeParam;
import com.m7.imkfsdk.utils.permission.callback.ForwardToSettingsCallback;
import com.m7.imkfsdk.utils.permission.callback.RequestCallback;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class PermissionBuilder {
    private static final String FRAGMENT_TAG = "InvisibleFragment";
    public FragmentActivity activity;
    public ExplainReasonCallback explainReasonCallback;
    public ExplainReasonCallbackWithBeforeParam explainReasonCallbackWithBeforeParam;
    public ForwardToSettingsCallback forwardToSettingsCallback;
    public Set<String> normalPermissions;
    public Set<String> permissionsWontRequest;
    public RequestCallback requestCallback;
    public boolean requireBackgroundLocationPermission;
    public boolean explainReasonBeforeRequest = false;
    public boolean showDialogCalled = false;
    public Set<String> grantedPermissions = new HashSet();
    public Set<String> deniedPermissions = new HashSet();
    public Set<String> permanentDeniedPermissions = new HashSet();
    public Set<String> forwardPermissions = new HashSet();

    public PermissionBuilder(FragmentActivity fragmentActivity, Set<String> set, boolean z, Set<String> set2) {
        this.activity = fragmentActivity;
        this.normalPermissions = set;
        this.requireBackgroundLocationPermission = z;
        this.permissionsWontRequest = set2;
    }

    public void forwardToSettings(List<String> list) {
        this.forwardPermissions.clear();
        this.forwardPermissions.addAll(list);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.activity.getPackageName(), null));
        getInvisibleFragment().startActivityForResult(intent, 2);
    }

    private InvisibleFragment getInvisibleFragment() {
        FragmentManager supportFragmentManager = this.activity.getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (findFragmentByTag != null) {
            return (InvisibleFragment) findFragmentByTag;
        }
        InvisibleFragment invisibleFragment = new InvisibleFragment();
        supportFragmentManager.beginTransaction().add(invisibleFragment, FRAGMENT_TAG).commitNow();
        return invisibleFragment;
    }

    public PermissionBuilder explainReasonBeforeRequest() {
        this.explainReasonBeforeRequest = true;
        return this;
    }

    public PermissionBuilder onExplainRequestReason(ExplainReasonCallback explainReasonCallback) {
        this.explainReasonCallback = explainReasonCallback;
        return this;
    }

    public PermissionBuilder onForwardToSettings(ForwardToSettingsCallback forwardToSettingsCallback) {
        this.forwardToSettingsCallback = forwardToSettingsCallback;
        return this;
    }

    public void request(RequestCallback requestCallback) {
        this.requestCallback = requestCallback;
        RequestChain requestChain = new RequestChain();
        requestChain.addTaskToChain(new RequestNormalPermissions(this));
        requestChain.addTaskToChain(new RequestBackgroundLocationPermission(this));
        requestChain.runTask();
    }

    public void requestAccessBackgroundLocationNow(ChainTask chainTask) {
        getInvisibleFragment().requestAccessBackgroundLocationNow(this, chainTask);
    }

    public void requestNow(Set<String> set, ChainTask chainTask) {
        getInvisibleFragment().requestNow(this, set, chainTask);
    }

    public void showHandlePermissionDialog(final ChainTask chainTask, final boolean z, final List<String> list, String str, String str2, String str3) {
        this.showDialogCalled = true;
        if (list != null && !list.isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
            builder.setMessage(str);
            builder.setCancelable(!TextUtils.isEmpty(str3));
            builder.setPositiveButton(str2, new DialogInterface.OnClickListener() { // from class: com.m7.imkfsdk.utils.permission.request.PermissionBuilder.1
                {
                    PermissionBuilder.this = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (!z) {
                        PermissionBuilder.this.forwardToSettings(list);
                    } else {
                        chainTask.requestAgain(list);
                    }
                }
            });
            if (!TextUtils.isEmpty(str3)) {
                builder.setNegativeButton(str3, new DialogInterface.OnClickListener() { // from class: com.m7.imkfsdk.utils.permission.request.PermissionBuilder.2
                    {
                        PermissionBuilder.this = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        chainTask.finish();
                    }
                });
            }
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(false);
            create.show();
            return;
        }
        chainTask.finish();
    }

    public PermissionBuilder onExplainRequestReason(ExplainReasonCallbackWithBeforeParam explainReasonCallbackWithBeforeParam) {
        this.explainReasonCallbackWithBeforeParam = explainReasonCallbackWithBeforeParam;
        return this;
    }
}
