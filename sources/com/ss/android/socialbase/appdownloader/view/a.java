package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.jihuanshe.model.Constants;
import com.ss.android.socialbase.appdownloader.e.d;
import com.ss.android.socialbase.downloader.constants.e;
import com.ss.android.socialbase.downloader.downloader.c;

/* loaded from: classes3.dex */
public class a extends Fragment {
    public static Intent d() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    private Context e() {
        Context N = c.N();
        return (N != null || getActivity() == null || getActivity().isFinishing()) ? N : getActivity().getApplicationContext();
    }

    private Intent f() {
        Context e2 = e();
        if (e2 == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = e2.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i2 = e2.getApplicationInfo().uid;
        intent.putExtra(Constants.KEY_PARAM_USER_ID, i2);
        intent.putExtra("app_uid", i2);
        return intent;
    }

    public void a() {
        try {
            try {
                try {
                    startActivityForResult(f(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(b(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(d(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(c(), 1000);
        }
    }

    public Intent b() {
        int i2 = Build.VERSION.SDK_INT;
        Context e2 = e();
        if (e2 == null) {
            return null;
        }
        String packageName = e2.getPackageName();
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(e.f5569c)) {
                Intent intent = new Intent();
                intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACKAGE_NAME, packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            } else if (lowerCase.contains("vivo")) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                if (i2 >= 25) {
                    intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                } else {
                    intent2.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                }
                return intent2;
            } else if (lowerCase.contains("meizu") && i2 < 25) {
                Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent3.putExtra(com.tencent.android.tpush.common.Constants.FLAG_PACKAGE_NAME, packageName);
                intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + e2.getPackageName()));
    }

    public Intent c() {
        Context e2 = e();
        if (e2 == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + e2.getPackageName()));
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (d.a()) {
            d.a(true);
        } else {
            d.a(false);
        }
    }
}
