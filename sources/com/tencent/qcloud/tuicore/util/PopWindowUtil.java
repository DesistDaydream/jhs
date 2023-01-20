package com.tencent.qcloud.tuicore.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.qcloud.tuicore.R;

/* loaded from: classes3.dex */
public class PopWindowUtil {
    public static AlertDialog buildFullScreenDialog(Activity activity) {
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.TUIKit_AlertDialogStyle);
            builder.setTitle("");
            builder.setCancelable(true);
            AlertDialog create = builder.create();
            create.getWindow().setDimAmount(0.0f);
            create.setCanceledOnTouchOutside(true);
            create.show();
            create.getWindow().setLayout(-1, -1);
            create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            return create;
        }
        return null;
    }

    public static PopupWindow popupWindow(View view, View view2, int i2, int i3) {
        PopupWindow popupWindow = new PopupWindow(view, -2, -2);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(-1360073216));
        popupWindow.showAtLocation(view, 49, i2, i3);
        return popupWindow;
    }
}
