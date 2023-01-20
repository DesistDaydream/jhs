package com.tencent.qcloud.tuikit.tuichat.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;

/* loaded from: classes3.dex */
public class PermissionUtils {
    private static final String TAG = "PermissionUtils";

    public static boolean checkPermission(Context context, String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("checkPermission permission:");
        sb.append(str);
        sb.append("|sdk:");
        int i2 = Build.VERSION.SDK_INT;
        sb.append(i2);
        Log.i(str2, sb.toString());
        if (i2 < 23 || ContextCompat.checkSelfPermission(context, str) == 0) {
            return true;
        }
        showPermissionDialog(context);
        return false;
    }

    private static void showPermissionDialog(final Context context) {
        new AlertDialog.Builder(context).setMessage(TUIChatService.getAppContext().getString(R.string.permission_content)).setPositiveButton(TUIChatService.getAppContext().getString(R.string.setting), new DialogInterface.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.util.PermissionUtils.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                context.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName())));
            }
        }).setNegativeButton(TUIChatService.getAppContext().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.util.PermissionUtils.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        }).create().show();
    }
}
