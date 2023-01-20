package com.m7.imkfsdk.utils.permission;

import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.m7.imkfsdk.utils.permission.callback.ExplainReasonCallbackWithBeforeParam;
import com.m7.imkfsdk.utils.permission.callback.ForwardToSettingsCallback;
import com.m7.imkfsdk.utils.permission.callback.OnRequestCallback;
import com.m7.imkfsdk.utils.permission.callback.RequestCallback;
import com.m7.imkfsdk.utils.permission.request.ExplainScope;
import com.m7.imkfsdk.utils.permission.request.ForwardScope;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PermissionXUtil {
    public static void checkPermission(final FragmentActivity fragmentActivity, final OnRequestCallback onRequestCallback, String... strArr) {
        PermissionX.init(fragmentActivity).permissions(strArr).onExplainRequestReason(new ExplainReasonCallbackWithBeforeParam() { // from class: com.m7.imkfsdk.utils.permission.PermissionXUtil.3
            @Override // com.m7.imkfsdk.utils.permission.callback.ExplainReasonCallbackWithBeforeParam
            public void onExplainReason(ExplainScope explainScope, List<String> list, boolean z) {
                ArrayList arrayList = new ArrayList();
                for (String str : list) {
                    arrayList.add(PermissionConstants.getInstance().getPermissionName(str));
                }
                explainScope.showRequestReasonDialog(list, "为了保证程序正常工作，请您同意权限申请", "确认", "取消");
            }
        }).onForwardToSettings(new ForwardToSettingsCallback() { // from class: com.m7.imkfsdk.utils.permission.PermissionXUtil.2
            @Override // com.m7.imkfsdk.utils.permission.callback.ForwardToSettingsCallback
            public void onForwardToSettings(ForwardScope forwardScope, List<String> list) {
                ArrayList arrayList = new ArrayList();
                for (String str : list) {
                    arrayList.add(PermissionConstants.getInstance().getPermissionName(str));
                }
                forwardScope.showForwardToSettingsDialog(list, "您需要去应用程序设置当中手动开启权限", "确认", "取消");
            }
        }).request(new RequestCallback() { // from class: com.m7.imkfsdk.utils.permission.PermissionXUtil.1
            @Override // com.m7.imkfsdk.utils.permission.callback.RequestCallback
            public void onResult(boolean z, List<String> list, List<String> list2) {
                if (z) {
                    OnRequestCallback onRequestCallback2 = OnRequestCallback.this;
                    if (onRequestCallback2 != null) {
                        onRequestCallback2.requestSuccess();
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (String str : list2) {
                    arrayList.add(PermissionConstants.getInstance().getPermissionName(str));
                }
                FragmentActivity fragmentActivity2 = fragmentActivity;
                Toast.makeText(fragmentActivity2, "您拒绝了如下权限：" + arrayList, 1).show();
            }
        });
    }
}
