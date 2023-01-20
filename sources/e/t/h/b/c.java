package e.t.h.b;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.RequiresApi;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.vector.compat.network.NetworkConnType;
import e.t.h.b.b;
import h.k2.v.f0;
import h.k2.v.n0;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017¨\u0006\n"}, d2 = {"Lcom/vector/compat/network/NetworkOptionImpl23;", "Lcom/vector/compat/network/NetworkOption;", "()V", "getType", "Lcom/vector/compat/network/NetworkConnType;", "context", "Landroid/content/Context;", "isAvailable", "", "isConnected", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c implements b {
    @Override // e.t.h.b.b
    public boolean a(@k.e.a.d Context context) {
        return b.a.a(this, context);
    }

    @Override // e.t.h.b.b
    public boolean b(@k.e.a.d Context context) {
        return b.a.b(this, context);
    }

    @Override // e.t.h.b.b
    @RequiresApi(23)
    public boolean c(@k.e.a.d Context context) {
        ConnectivityManager connectivityManager;
        h.p2.d d2 = n0.d(ConnectivityManager.class);
        if (f0.g(d2, n0.d(ConnectivityManager.class))) {
            Object systemService = context.getApplicationContext().getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService;
        } else if (f0.g(d2, n0.d(ActivityManager.class))) {
            Object systemService2 = context.getApplicationContext().getSystemService("activity");
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService2;
        } else if (f0.g(d2, n0.d(WifiManager.class))) {
            Object systemService3 = context.getApplicationContext().getSystemService("wifi");
            Objects.requireNonNull(systemService3, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService3;
        } else if (f0.g(d2, n0.d(PowerManager.class))) {
            Object systemService4 = context.getApplicationContext().getSystemService("power");
            Objects.requireNonNull(systemService4, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService4;
        } else if (f0.g(d2, n0.d(NotificationManager.class))) {
            Object systemService5 = context.getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
            Objects.requireNonNull(systemService5, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService5;
        } else if (f0.g(d2, n0.d(ClipboardManager.class))) {
            Object systemService6 = context.getApplicationContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService6, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService6;
        } else if (f0.g(d2, n0.d(WindowManager.class))) {
            Object systemService7 = context.getApplicationContext().getSystemService("window");
            Objects.requireNonNull(systemService7, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService7;
        } else if (f0.g(d2, n0.d(InputMethodManager.class))) {
            Object systemService8 = context.getApplicationContext().getSystemService("input_method");
            Objects.requireNonNull(systemService8, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService8;
        } else if (f0.g(d2, n0.d(LocationManager.class))) {
            Object systemService9 = context.getApplicationContext().getSystemService("location");
            Objects.requireNonNull(systemService9, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService9;
        } else if (!f0.g(d2, n0.d(CameraManager.class))) {
            throw new IllegalArgumentException("can not find class");
        } else {
            Object systemService10 = context.getApplicationContext().getSystemService("camera");
            Objects.requireNonNull(systemService10, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService10;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return networkCapabilities != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
    }

    @Override // e.t.h.b.b
    @RequiresApi(23)
    public boolean d(@k.e.a.d Context context) {
        ConnectivityManager connectivityManager;
        h.p2.d d2 = n0.d(ConnectivityManager.class);
        if (f0.g(d2, n0.d(ConnectivityManager.class))) {
            Object systemService = context.getApplicationContext().getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService;
        } else if (f0.g(d2, n0.d(ActivityManager.class))) {
            Object systemService2 = context.getApplicationContext().getSystemService("activity");
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService2;
        } else if (f0.g(d2, n0.d(WifiManager.class))) {
            Object systemService3 = context.getApplicationContext().getSystemService("wifi");
            Objects.requireNonNull(systemService3, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService3;
        } else if (f0.g(d2, n0.d(PowerManager.class))) {
            Object systemService4 = context.getApplicationContext().getSystemService("power");
            Objects.requireNonNull(systemService4, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService4;
        } else if (f0.g(d2, n0.d(NotificationManager.class))) {
            Object systemService5 = context.getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
            Objects.requireNonNull(systemService5, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService5;
        } else if (f0.g(d2, n0.d(ClipboardManager.class))) {
            Object systemService6 = context.getApplicationContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService6, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService6;
        } else if (f0.g(d2, n0.d(WindowManager.class))) {
            Object systemService7 = context.getApplicationContext().getSystemService("window");
            Objects.requireNonNull(systemService7, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService7;
        } else if (f0.g(d2, n0.d(InputMethodManager.class))) {
            Object systemService8 = context.getApplicationContext().getSystemService("input_method");
            Objects.requireNonNull(systemService8, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService8;
        } else if (f0.g(d2, n0.d(LocationManager.class))) {
            Object systemService9 = context.getApplicationContext().getSystemService("location");
            Objects.requireNonNull(systemService9, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService9;
        } else if (!f0.g(d2, n0.d(CameraManager.class))) {
            throw new IllegalArgumentException("can not find class");
        } else {
            Object systemService10 = context.getApplicationContext().getSystemService("camera");
            Objects.requireNonNull(systemService10, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService10;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3);
    }

    @Override // e.t.h.b.b
    @RequiresApi(23)
    @k.e.a.d
    public NetworkConnType getType(@k.e.a.d Context context) {
        ConnectivityManager connectivityManager;
        h.p2.d d2 = n0.d(ConnectivityManager.class);
        if (f0.g(d2, n0.d(ConnectivityManager.class))) {
            Object systemService = context.getApplicationContext().getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService;
        } else if (f0.g(d2, n0.d(ActivityManager.class))) {
            Object systemService2 = context.getApplicationContext().getSystemService("activity");
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService2;
        } else if (f0.g(d2, n0.d(WifiManager.class))) {
            Object systemService3 = context.getApplicationContext().getSystemService("wifi");
            Objects.requireNonNull(systemService3, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService3;
        } else if (f0.g(d2, n0.d(PowerManager.class))) {
            Object systemService4 = context.getApplicationContext().getSystemService("power");
            Objects.requireNonNull(systemService4, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService4;
        } else if (f0.g(d2, n0.d(NotificationManager.class))) {
            Object systemService5 = context.getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
            Objects.requireNonNull(systemService5, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService5;
        } else if (f0.g(d2, n0.d(ClipboardManager.class))) {
            Object systemService6 = context.getApplicationContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService6, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService6;
        } else if (f0.g(d2, n0.d(WindowManager.class))) {
            Object systemService7 = context.getApplicationContext().getSystemService("window");
            Objects.requireNonNull(systemService7, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService7;
        } else if (f0.g(d2, n0.d(InputMethodManager.class))) {
            Object systemService8 = context.getApplicationContext().getSystemService("input_method");
            Objects.requireNonNull(systemService8, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService8;
        } else if (f0.g(d2, n0.d(LocationManager.class))) {
            Object systemService9 = context.getApplicationContext().getSystemService("location");
            Objects.requireNonNull(systemService9, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService9;
        } else if (!f0.g(d2, n0.d(CameraManager.class))) {
            throw new IllegalArgumentException("can not find class");
        } else {
            Object systemService10 = context.getApplicationContext().getSystemService("camera");
            Objects.requireNonNull(systemService10, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService10;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities == null) {
            return NetworkConnType.NONE;
        }
        return networkCapabilities.hasTransport(1) ? NetworkConnType.WIFI : networkCapabilities.hasTransport(0) ? NetworkConnType.CELLULAR : networkCapabilities.hasTransport(3) ? NetworkConnType.ETHERNET : NetworkConnType.NONE;
    }
}
