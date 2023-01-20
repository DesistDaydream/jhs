package e.t.l;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.hardware.camera2.CameraManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Process;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import androidx.annotation.Dimension;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.vector.config.FitConfig;
import com.vector.fitter.Mode;
import h.k2.v.f0;
import h.k2.v.n0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\f\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u0002\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\u000b*\u0004\u0018\u00010\u0002\u001a\u0014\u0010\f\u001a\u00020\u0004*\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a(\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u001a\u001a\u0010\u0017\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012\u001a\u0014\u0010\u001a\u001a\u00020\u0010*\u00020\u00022\b\b\u0001\u0010\u001b\u001a\u00020\u0012\u001a\u0014\u0010\u001c\u001a\u00020\u0010*\u00020\u00022\b\b\u0001\u0010\u001b\u001a\u00020\u0012\u001a\n\u0010\u001d\u001a\u00020\u0016*\u00020\u0002\u001a+\u0010\u001e\u001a\u00020\u001f*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#\"\u00020$¢\u0006\u0002\u0010%\u001a/\u0010\u001e\u001a\u00020\u001f*\u00020\u00022\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'2\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#\"\u00020$¢\u0006\u0002\u0010(\u001a7\u0010)\u001a\u00020\u001f*\u00020\u00022\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'2\u0006\u0010*\u001a\u00020\u00122\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#\"\u00020$¢\u0006\u0002\u0010+\u001a+\u0010,\u001a\u00020\u001f*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#\"\u00020$¢\u0006\u0002\u0010%\u001a/\u0010,\u001a\u00020\u001f*\u00020\u00022\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'2\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#\"\u00020$¢\u0006\u0002\u0010(\u001a\u001a\u0010-\u001a\u0002H.\"\u0006\b\u0000\u0010.\u0018\u0001*\u00020\u0002H\u0086\b¢\u0006\u0002\u0010/¨\u00060"}, d2 = {"asLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "Landroid/content/Context;", "cloneLayoutInflater", "Landroid/view/LayoutInflater;", "createResourceContext", "mode", "Lcom/vector/fitter/Mode;", "currProcessName", "", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getStrategyInflater", "strategy", "Lcom/vector/fitter/FitStrategy;", "inflate", "Landroid/view/View;", "res", "", "parent", "Landroid/view/ViewGroup;", "attachToRoot", "", "inflateEmpty", IAdInterListener.AdReqParam.WIDTH, "h", "inflateEmptyOfDp", "value", "inflateEmptyOfPx", "isMainProcess", "startActivity", "", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, "", "Landroid/os/Bundle;", "(Landroid/content/Context;Landroid/content/Intent;[Landroid/os/Bundle;)V", "clz", "Lkotlin/reflect/KClass;", "(Landroid/content/Context;Lkotlin/reflect/KClass;[Landroid/os/Bundle;)V", "startActivityForResult", "code", "(Landroid/content/Context;Lkotlin/reflect/KClass;I[Landroid/os/Bundle;)V", "startService", "systemService", ExifInterface.GPS_DIRECTION_TRUE, "(Landroid/content/Context;)Ljava/lang/Object;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class k {
    @k.e.a.e
    public static final LifecycleOwner a(@k.e.a.e Context context) {
        while (!(context instanceof LifecycleOwner)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (LifecycleOwner) context;
    }

    @k.e.a.d
    public static final LayoutInflater b(@k.e.a.d Context context) {
        return LayoutInflater.from(context).cloneInContext(context);
    }

    @k.e.a.d
    public static final Context c(@k.e.a.d Context context, @k.e.a.d Mode mode) {
        return new u(mode, context);
    }

    public static /* synthetic */ Context d(Context context, Mode mode, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mode = FitConfig.a.a();
        }
        return c(context, mode);
    }

    @k.e.a.e
    public static final String e(@k.e.a.d Context context) {
        ActivityManager activityManager;
        Object obj;
        boolean z;
        int myPid = Process.myPid();
        h.p2.d d2 = n0.d(ActivityManager.class);
        if (f0.g(d2, n0.d(ConnectivityManager.class))) {
            Object systemService = context.getApplicationContext().getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            activityManager = (ActivityManager) systemService;
        } else if (f0.g(d2, n0.d(ActivityManager.class))) {
            Object systemService2 = context.getApplicationContext().getSystemService("activity");
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.app.ActivityManager");
            activityManager = (ActivityManager) systemService2;
        } else if (f0.g(d2, n0.d(WifiManager.class))) {
            Object systemService3 = context.getApplicationContext().getSystemService("wifi");
            Objects.requireNonNull(systemService3, "null cannot be cast to non-null type android.app.ActivityManager");
            activityManager = (ActivityManager) systemService3;
        } else if (f0.g(d2, n0.d(PowerManager.class))) {
            Object systemService4 = context.getApplicationContext().getSystemService("power");
            Objects.requireNonNull(systemService4, "null cannot be cast to non-null type android.app.ActivityManager");
            activityManager = (ActivityManager) systemService4;
        } else if (f0.g(d2, n0.d(NotificationManager.class))) {
            Object systemService5 = context.getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
            Objects.requireNonNull(systemService5, "null cannot be cast to non-null type android.app.ActivityManager");
            activityManager = (ActivityManager) systemService5;
        } else if (f0.g(d2, n0.d(ClipboardManager.class))) {
            Object systemService6 = context.getApplicationContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService6, "null cannot be cast to non-null type android.app.ActivityManager");
            activityManager = (ActivityManager) systemService6;
        } else if (f0.g(d2, n0.d(WindowManager.class))) {
            Object systemService7 = context.getApplicationContext().getSystemService("window");
            Objects.requireNonNull(systemService7, "null cannot be cast to non-null type android.app.ActivityManager");
            activityManager = (ActivityManager) systemService7;
        } else if (f0.g(d2, n0.d(InputMethodManager.class))) {
            Object systemService8 = context.getApplicationContext().getSystemService("input_method");
            Objects.requireNonNull(systemService8, "null cannot be cast to non-null type android.app.ActivityManager");
            activityManager = (ActivityManager) systemService8;
        } else if (f0.g(d2, n0.d(LocationManager.class))) {
            Object systemService9 = context.getApplicationContext().getSystemService("location");
            Objects.requireNonNull(systemService9, "null cannot be cast to non-null type android.app.ActivityManager");
            activityManager = (ActivityManager) systemService9;
        } else if (!f0.g(d2, n0.d(CameraManager.class))) {
            throw new IllegalArgumentException("can not find class");
        } else {
            Object systemService10 = context.getApplicationContext().getSystemService("camera");
            Objects.requireNonNull(systemService10, "null cannot be cast to non-null type android.app.ActivityManager");
            activityManager = (ActivityManager) systemService10;
        }
        Iterator<T> it = activityManager.getRunningAppProcesses().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ActivityManager.RunningAppProcessInfo) obj).pid == myPid) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj;
        if (runningAppProcessInfo == null) {
            return null;
        }
        return runningAppProcessInfo.processName;
    }

    @k.e.a.e
    public static final Lifecycle f(@k.e.a.e Context context) {
        while (!(context instanceof LifecycleOwner)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return ((LifecycleOwner) context).getLifecycle();
    }

    @k.e.a.d
    public static final LayoutInflater g(@k.e.a.d Context context, @k.e.a.e e.t.o.e eVar) {
        LayoutInflater from = LayoutInflater.from(context);
        return (eVar == null || eVar.value() == FitConfig.a.a()) ? from : from.cloneInContext(c(context, eVar.value()));
    }

    @k.e.a.d
    public static final View h(@k.e.a.d Context context, int i2, @k.e.a.e ViewGroup viewGroup, boolean z) {
        return b(context).inflate(i2, viewGroup, z);
    }

    public static /* synthetic */ View i(Context context, int i2, ViewGroup viewGroup, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            viewGroup = null;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return h(context, i2, viewGroup, z);
    }

    @k.e.a.d
    public static final View j(@k.e.a.d Context context, int i2, int i3) {
        View view = new View(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(i2, i3));
        return view;
    }

    @k.e.a.d
    public static final View k(@k.e.a.d Context context, @Dimension(unit = 0) int i2) {
        return l(context, e.t.o.d.a.a(context).d(i2));
    }

    @k.e.a.d
    public static final View l(@k.e.a.d Context context, @Dimension(unit = 1) int i2) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.addView(new View(context), e.t.u.p.p(-1, i2));
        return relativeLayout;
    }

    public static final boolean m(@k.e.a.d Context context) {
        return f0.g(context.getPackageName(), e(context));
    }

    public static final /* synthetic */ <T> T n(Context context) {
        f0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        h.p2.d d2 = n0.d(Object.class);
        if (f0.g(d2, n0.d(ConnectivityManager.class))) {
            T t = (T) context.getApplicationContext().getSystemService("connectivity");
            f0.y(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t;
        } else if (f0.g(d2, n0.d(ActivityManager.class))) {
            T t2 = (T) context.getApplicationContext().getSystemService("activity");
            f0.y(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t2;
        } else if (f0.g(d2, n0.d(WifiManager.class))) {
            T t3 = (T) context.getApplicationContext().getSystemService("wifi");
            f0.y(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t3;
        } else if (f0.g(d2, n0.d(PowerManager.class))) {
            T t4 = (T) context.getApplicationContext().getSystemService("power");
            f0.y(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t4;
        } else if (f0.g(d2, n0.d(NotificationManager.class))) {
            T t5 = (T) context.getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
            f0.y(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t5;
        } else if (f0.g(d2, n0.d(ClipboardManager.class))) {
            T t6 = (T) context.getApplicationContext().getSystemService("clipboard");
            f0.y(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t6;
        } else if (f0.g(d2, n0.d(WindowManager.class))) {
            T t7 = (T) context.getApplicationContext().getSystemService("window");
            f0.y(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t7;
        } else if (f0.g(d2, n0.d(InputMethodManager.class))) {
            T t8 = (T) context.getApplicationContext().getSystemService("input_method");
            f0.y(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t8;
        } else if (f0.g(d2, n0.d(LocationManager.class))) {
            T t9 = (T) context.getApplicationContext().getSystemService("location");
            f0.y(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t9;
        } else if (f0.g(d2, n0.d(CameraManager.class))) {
            T t10 = (T) context.getApplicationContext().getSystemService("camera");
            f0.y(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t10;
        } else {
            throw new IllegalArgumentException("can not find class");
        }
    }

    public static final void startActivity(@k.e.a.d Context context, @k.e.a.d h.p2.d<?> dVar, @k.e.a.d Bundle... bundleArr) {
        e.t.u.r.a.startActivity(context, dVar, (Bundle[]) Arrays.copyOf(bundleArr, bundleArr.length));
    }

    public static final void startActivityForResult(@k.e.a.d Context context, @k.e.a.d h.p2.d<?> dVar, int i2, @k.e.a.d Bundle... bundleArr) {
        e.t.u.r.a.startActivityForResult(context, dVar, i2, (Bundle[]) Arrays.copyOf(bundleArr, bundleArr.length));
    }

    public static final void startService(@k.e.a.d Context context, @k.e.a.d h.p2.d<?> dVar, @k.e.a.d Bundle... bundleArr) {
        Intent intent = new Intent(context, h.k2.a.c(dVar));
        e.t.u.r.a.a(intent, (Bundle[]) Arrays.copyOf(bundleArr, bundleArr.length));
        context.startService(intent);
    }

    public static final void startActivity(@k.e.a.d Context context, @k.e.a.d Intent intent, @k.e.a.d Bundle... bundleArr) {
        e.t.u.r.a.startActivity(context, intent, (Bundle[]) Arrays.copyOf(bundleArr, bundleArr.length));
    }

    public static final void startService(@k.e.a.d Context context, @k.e.a.d Intent intent, @k.e.a.d Bundle... bundleArr) {
        e.t.u.r.a.a(intent, (Bundle[]) Arrays.copyOf(bundleArr, bundleArr.length));
        context.startService(intent);
    }
}
