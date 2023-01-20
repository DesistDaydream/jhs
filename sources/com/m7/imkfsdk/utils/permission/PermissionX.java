package com.m7.imkfsdk.utils.permission;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

/* loaded from: classes2.dex */
public class PermissionX {
    public static PermissionCollection init(FragmentActivity fragmentActivity) {
        return new PermissionCollection(fragmentActivity);
    }

    public static boolean isGranted(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }
}
