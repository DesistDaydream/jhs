package com.moor.imkf.lib.socket.websocket.util;

import android.content.Context;
import com.moor.imkf.lib.utils.MoorSdkVersionUtil;

/* loaded from: classes2.dex */
public class PermissionUtil {
    public static boolean checkPermission(Context context, String str) {
        return !MoorSdkVersionUtil.over23() || context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
