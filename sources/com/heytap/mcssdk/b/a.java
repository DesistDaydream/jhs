package com.heytap.mcssdk.b;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.heytap.mcssdk.utils.e;
import com.heytap.mcssdk.utils.f;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.pushsdk.R;

/* loaded from: classes2.dex */
public class a {
    private static final String a = "Heytap PUSH";
    private static final String b = "System Default Channel";

    /* renamed from: c  reason: collision with root package name */
    private static final int f3305c = 3;

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(26)
    public boolean a(Context context, String str, String str2, int i2) {
        NotificationManager notificationManager;
        if (context == null || (notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)) == null) {
            return false;
        }
        notificationManager.createNotificationChannel(new NotificationChannel(str, str2, i2));
        return true;
    }

    public void a(final Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        f.a(new Runnable() { // from class: com.heytap.mcssdk.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.f().a()) {
                    return;
                }
                String string = context.getString(R.string.system_default_channel);
                if (TextUtils.isEmpty(string)) {
                    string = a.b;
                }
                e.f().a(a.this.a(context, a.a, string, 3));
            }
        });
    }
}
