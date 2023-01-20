package com.tencent.qcloud.tuicore.util;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qcloud.tuicore.TUIConfig;

/* loaded from: classes3.dex */
public class ToastUtil {
    private static Toast toast;

    public static void toastLongMessage(String str) {
        toastMessage(str, true);
    }

    private static void toastMessage(final String str, final boolean z) {
        BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuicore.util.ToastUtil.1
            @Override // java.lang.Runnable
            public void run() {
                TextView textView;
                if (ToastUtil.toast != null) {
                    ToastUtil.toast.cancel();
                    Toast unused = ToastUtil.toast = null;
                }
                Toast unused2 = ToastUtil.toast = Toast.makeText(TUIConfig.getAppContext(), str, z ? 1 : 0);
                View view = ToastUtil.toast.getView();
                if (view != null && (textView = (TextView) view.findViewById(16908299)) != null) {
                    textView.setGravity(17);
                }
                ToastUtil.toast.show();
            }
        });
    }

    public static void toastShortMessage(String str) {
        toastMessage(str, false);
    }
}
