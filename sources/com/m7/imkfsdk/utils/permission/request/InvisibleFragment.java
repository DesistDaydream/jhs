package com.m7.imkfsdk.utils.permission.request;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.m7.imkfsdk.utils.permission.PermissionX;
import com.m7.imkfsdk.utils.permission.callback.ExplainReasonCallbackWithBeforeParam;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes2.dex */
public class InvisibleFragment extends Fragment {
    public static final int FORWARD_TO_SETTINGS = 2;
    public static final int REQUEST_BACKGROUND_LOCATION_PERMISSION = 2;
    public static final int REQUEST_NORMAL_PERMISSIONS = 1;
    private PermissionBuilder pb;
    private ChainTask task;

    private void onRequestBackgroundLocationPermissionResult() {
        if (PermissionX.isGranted(getContext(), "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            this.pb.grantedPermissions.add("android.permission.ACCESS_BACKGROUND_LOCATION");
            this.pb.deniedPermissions.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
            this.pb.permanentDeniedPermissions.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
            this.task.finish();
            return;
        }
        boolean z = true;
        boolean shouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale("android.permission.ACCESS_BACKGROUND_LOCATION");
        PermissionBuilder permissionBuilder = this.pb;
        if ((permissionBuilder.explainReasonCallback != null || permissionBuilder.explainReasonCallbackWithBeforeParam != null) && shouldShowRequestPermissionRationale) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
            PermissionBuilder permissionBuilder2 = this.pb;
            ExplainReasonCallbackWithBeforeParam explainReasonCallbackWithBeforeParam = permissionBuilder2.explainReasonCallbackWithBeforeParam;
            if (explainReasonCallbackWithBeforeParam != null) {
                explainReasonCallbackWithBeforeParam.onExplainReason(this.task.getExplainScope(), arrayList, false);
            } else {
                permissionBuilder2.explainReasonCallback.onExplainReason(this.task.getExplainScope(), arrayList);
            }
        } else {
            if (permissionBuilder.forwardToSettingsCallback != null && !shouldShowRequestPermissionRationale) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                this.pb.forwardToSettingsCallback.onForwardToSettings(this.task.getForwardScope(), arrayList2);
            }
            if (z && this.pb.showDialogCalled) {
                return;
            }
            this.task.finish();
        }
        z = false;
        if (z) {
        }
        this.task.finish();
    }

    private void onRequestNormalPermissionsResult(@NonNull String[] strArr, @NonNull int[] iArr) {
        this.pb.grantedPermissions.clear();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z = false;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            if (iArr[i2] == 0) {
                this.pb.grantedPermissions.add(str);
                this.pb.deniedPermissions.remove(str);
                this.pb.permanentDeniedPermissions.remove(str);
            } else if (shouldShowRequestPermissionRationale(str)) {
                arrayList.add(strArr[i2]);
                this.pb.deniedPermissions.add(str);
            } else {
                arrayList2.add(strArr[i2]);
                this.pb.permanentDeniedPermissions.add(str);
                this.pb.deniedPermissions.remove(str);
            }
        }
        ArrayList<String> arrayList3 = new ArrayList();
        arrayList3.addAll(this.pb.deniedPermissions);
        arrayList3.addAll(this.pb.permanentDeniedPermissions);
        for (String str2 : arrayList3) {
            if (PermissionX.isGranted(getContext(), str2)) {
                this.pb.deniedPermissions.remove(str2);
                this.pb.grantedPermissions.add(str2);
            }
        }
        if (this.pb.grantedPermissions.size() == this.pb.normalPermissions.size()) {
            this.task.finish();
            return;
        }
        PermissionBuilder permissionBuilder = this.pb;
        if ((permissionBuilder.explainReasonCallback != null || permissionBuilder.explainReasonCallbackWithBeforeParam != null) && !arrayList.isEmpty()) {
            PermissionBuilder permissionBuilder2 = this.pb;
            ExplainReasonCallbackWithBeforeParam explainReasonCallbackWithBeforeParam = permissionBuilder2.explainReasonCallbackWithBeforeParam;
            if (explainReasonCallbackWithBeforeParam != null) {
                explainReasonCallbackWithBeforeParam.onExplainReason(this.task.getExplainScope(), new ArrayList(this.pb.deniedPermissions), false);
            } else {
                permissionBuilder2.explainReasonCallback.onExplainReason(this.task.getExplainScope(), new ArrayList(this.pb.deniedPermissions));
            }
        } else if (this.pb.forwardToSettingsCallback == null || arrayList2.isEmpty()) {
            z = true;
        } else {
            this.pb.forwardToSettingsCallback.onForwardToSettings(this.task.getForwardScope(), new ArrayList(this.pb.permanentDeniedPermissions));
        }
        if (z || !this.pb.showDialogCalled) {
            this.task.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2) {
            ChainTask chainTask = this.task;
            if (chainTask != null && this.pb != null) {
                chainTask.requestAgain(new ArrayList(this.pb.forwardPermissions));
            } else {
                Log.w("PermissionX", "permissionBuilder should not be null at this time, so we can do nothing in this case.");
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 == 1) {
            onRequestNormalPermissionsResult(strArr, iArr);
        } else if (i2 == 2) {
            onRequestBackgroundLocationPermissionResult();
        }
    }

    public void requestAccessBackgroundLocationNow(PermissionBuilder permissionBuilder, ChainTask chainTask) {
        this.pb = permissionBuilder;
        this.task = chainTask;
        requestPermissions(new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 2);
    }

    public void requestNow(PermissionBuilder permissionBuilder, Set<String> set, ChainTask chainTask) {
        this.pb = permissionBuilder;
        this.task = chainTask;
        requestPermissions((String[]) set.toArray(new String[0]), 1);
    }
}
