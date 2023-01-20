package com.m7.imkfsdk.utils.permission;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.m7.imkfsdk.utils.permission.request.PermissionBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes2.dex */
public class PermissionCollection {
    private static final String TAG = "PermissionCollection";
    private FragmentActivity activity;

    public PermissionCollection(FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;
    }

    public PermissionBuilder permissions(String... strArr) {
        return permissions(new ArrayList(Arrays.asList(strArr)));
    }

    public PermissionBuilder permissions(List<String> list) {
        boolean z;
        HashSet hashSet = new HashSet(list);
        HashSet hashSet2 = new HashSet();
        if (hashSet.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
            int i2 = Build.VERSION.SDK_INT;
            int i3 = this.activity.getApplicationInfo().targetSdkVersion;
            if (i2 >= 30 && i3 >= 30) {
                z = true;
                hashSet.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
                return new PermissionBuilder(this.activity, hashSet, z, hashSet2);
            } else if (i2 < 29) {
                hashSet.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
                hashSet2.add("android.permission.ACCESS_BACKGROUND_LOCATION");
            }
        }
        z = false;
        return new PermissionBuilder(this.activity, hashSet, z, hashSet2);
    }
}
