package com.bytedance.msdk.api.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.e;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.f;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.v;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.m7.imkfsdk.utils.permission.PermissionConstants;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TTDelegateActivity extends Activity {
    public static final String INTENT_PERMISSIONS = "permissions";
    public static final String INTENT_TYPE = "type";
    public static final int INTENT_TYPE_ALL_PERMISSIONS_CHECK = 3;
    public static final int INTENT_TYPE_PERMISSIONS_CHECK = 1;
    public static final int INTENT_TYPE_REQUEST_PERMISSION = 2;
    public static final String PERMISSION_CONTENT_KEY = "permission_content_key";
    public static final String PERMISSION_ID_KEY = "permission_id_key";
    private Intent a;

    /* loaded from: classes.dex */
    public static class updateDeviceInfoRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            v.t(a.d());
        }
    }

    private void a() {
        try {
            int intExtra = this.a.getIntExtra("type", 0);
            if (intExtra == 1) {
                b(intExtra, this.a.getIntArrayExtra(INTENT_PERMISSIONS));
            } else if (intExtra == 2) {
                c(this.a.getStringExtra(PERMISSION_ID_KEY), this.a.getStringArrayExtra(PERMISSION_CONTENT_KEY));
            } else if (intExtra != 3) {
                finish();
            } else {
                b(intExtra, null);
            }
        } catch (Exception unused) {
            finish();
        }
    }

    private void b(int i2, int[] iArr) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                ArrayList arrayList = new ArrayList();
                if (i2 != 1) {
                    if (i2 == 3) {
                        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                        arrayList.add(PermissionConstants.PHONE_STATE);
                        arrayList.add(PermissionConstants.STORE);
                    }
                } else if (iArr != null && iArr.length > 0) {
                    for (int i3 : iArr) {
                        if (i3 == 1) {
                            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                        } else if (i3 == 2) {
                            arrayList.add(PermissionConstants.PHONE_STATE);
                        } else if (i3 == 3) {
                            arrayList.add(PermissionConstants.STORE);
                        }
                    }
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                e.a().a(this, strArr, new f() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.3
                    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.f
                    public void onDenied(String str) {
                        Logger.d("TMe", "-------=----- onDenied: " + str);
                        PermissionConstants.PHONE_STATE.equals(str);
                        ThreadHelper.runOnThreadPool(new updateDeviceInfoRunnable());
                        TTDelegateActivity.this.finish();
                    }

                    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.f
                    public void onGranted() {
                        Logger.d("TMe", "-------=----- onGranted");
                        ThreadHelper.runOnThreadPool(new updateDeviceInfoRunnable());
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception unused) {
            }
        } else {
            Logger.d(GMAdConstant.TAG, "已经有Read phone state权限");
        }
        finish();
    }

    private void c(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    e.a().a(this, strArr, new f() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.2
                        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.f
                        public void onDenied(String str2) {
                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.a.a(str, str2);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.f
                        public void onGranted() {
                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.a.a(str);
                            TTDelegateActivity.this.finish();
                        }
                    });
                    return;
                } catch (Exception unused) {
                }
            } else {
                Logger.d(GMAdConstant.TAG, "已经有权限");
            }
        }
        finish();
    }

    private void d() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    public static void requestPermission(String str, String[] strArr) {
        Intent intent = new Intent(a.d(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 2);
        intent.putExtra(PERMISSION_ID_KEY, str);
        intent.putExtra(PERMISSION_CONTENT_KEY, strArr);
        if (a.d() != null) {
            c.a(a.d(), intent, new c.a() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.1
                @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c.a
                public void startActivityFail(Throwable th) {
                    Logger.e("requestPermission->startActivity error :" + th.toString());
                }

                @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c.a
                public void startActivitySuccess() {
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        d();
        this.a = getIntent();
        if (a.d() == null) {
            a.b(this);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (a.d() == null) {
            a.b(this);
        }
        try {
            setIntent(intent);
            this.a = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        e.a().a(this, strArr, iArr);
        ThreadHelper.runOnThreadPool(new updateDeviceInfoRunnable());
        finish();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (getIntent() != null) {
            a();
        }
    }
}
