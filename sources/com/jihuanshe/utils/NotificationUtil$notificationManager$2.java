package com.jihuanshe.utils;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.huawei.hms.push.constant.RemoteMessageConst;
import h.k2.u.a;
import h.k2.v.f0;
import h.k2.v.n0;
import java.util.Objects;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class NotificationUtil$notificationManager$2 extends Lambda implements a<NotificationManager> {
    public static final NotificationUtil$notificationManager$2 INSTANCE = new NotificationUtil$notificationManager$2();

    public NotificationUtil$notificationManager$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final NotificationManager invoke() {
        Context b = e.t.a.b();
        h.p2.d d2 = n0.d(NotificationManager.class);
        if (f0.g(d2, n0.d(ConnectivityManager.class))) {
            Object systemService = b.getApplicationContext().getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService;
        } else if (f0.g(d2, n0.d(ActivityManager.class))) {
            Object systemService2 = b.getApplicationContext().getSystemService("activity");
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService2;
        } else if (f0.g(d2, n0.d(WifiManager.class))) {
            Object systemService3 = b.getApplicationContext().getSystemService("wifi");
            Objects.requireNonNull(systemService3, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService3;
        } else if (f0.g(d2, n0.d(PowerManager.class))) {
            Object systemService4 = b.getApplicationContext().getSystemService("power");
            Objects.requireNonNull(systemService4, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService4;
        } else if (f0.g(d2, n0.d(NotificationManager.class))) {
            Object systemService5 = b.getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
            Objects.requireNonNull(systemService5, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService5;
        } else if (f0.g(d2, n0.d(ClipboardManager.class))) {
            Object systemService6 = b.getApplicationContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService6, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService6;
        } else if (f0.g(d2, n0.d(WindowManager.class))) {
            Object systemService7 = b.getApplicationContext().getSystemService("window");
            Objects.requireNonNull(systemService7, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService7;
        } else if (f0.g(d2, n0.d(InputMethodManager.class))) {
            Object systemService8 = b.getApplicationContext().getSystemService("input_method");
            Objects.requireNonNull(systemService8, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService8;
        } else if (f0.g(d2, n0.d(LocationManager.class))) {
            Object systemService9 = b.getApplicationContext().getSystemService("location");
            Objects.requireNonNull(systemService9, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService9;
        } else if (f0.g(d2, n0.d(CameraManager.class))) {
            Object systemService10 = b.getApplicationContext().getSystemService("camera");
            Objects.requireNonNull(systemService10, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService10;
        } else {
            throw new IllegalArgumentException("can not find class");
        }
    }
}
