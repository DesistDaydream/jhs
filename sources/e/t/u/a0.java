package e.t.u;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u000bJ\u001c\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0001\u0010\u0010\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0010\u001a\u00020\u000bJ\u0012\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u0017\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J!\u0010\u001a\u001a\u00020\u00162\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u001c\"\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u001a\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0003J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\"\u001a\u00020\u000bJ\u001a\u0010!\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0001\u0010\"\u001a\u00020\u000bJ\u0018\u0010!\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\"\u001a\u00020\u000bJ\u0012\u0010#\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010$\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/vector/util/StatusBarUtil;", "", "()V", "KEY_FLYME_ICON_FALG", "", "KEY_FLYME_PUBLISH_FALG", "KEY_FLYME_SETUP_FALG", "KEY_MIUI_INTERNAL_STORAGE", "KEY_MIUI_VERSION_CODE", "KEY_MIUI_VERSION_NAME", "SYSTEM_UI_FLAG_OP_STATUS_BAR_TINT", "", "adjustTextColor", "", "act", "Landroid/app/Activity;", "bgColor", "window", "Landroid/view/Window;", "frag", "Landroidx/fragment/app/Fragment;", "isDark", "", "color", "isMIUI", "isMeizu", "isPropertiesExist", "keys", "", "([Ljava/lang/String;)Z", "setFLYMETextColor", "darkmode", "setMIUITextColor", "setTextColor", "textColor", "setTextDark", "setTextLight", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a0 {
    @k.e.a.d
    public static final a0 a = new a0();
    private static final int b = 16;
    @k.e.a.d

    /* renamed from: c */
    private static final String f14646c = "ro.miui.ui.version.code";
    @k.e.a.d

    /* renamed from: d */
    private static final String f14647d = "ro.miui.ui.version.name";
    @k.e.a.d

    /* renamed from: e */
    private static final String f14648e = "ro.miui.internal.storage";
    @k.e.a.d

    /* renamed from: f */
    private static final String f14649f = "persist.sys.use.flyme.icon";
    @k.e.a.d

    /* renamed from: g */
    private static final String f14650g = "ro.meizu.setupwizard.flyme";
    @k.e.a.d

    /* renamed from: h */
    private static final String f14651h = "ro.flyme.published";

    private a0() {
    }

    private final boolean d(@ColorInt int i2) {
        return ColorUtils.calculateLuminance(i2) < 0.5d;
    }

    private final boolean e() {
        return g(f14646c, f14647d, f14648e);
    }

    private final boolean f() {
        return g(f14649f, f14651h, f14650g);
    }

    private final boolean g(String... strArr) {
        if (strArr.length == 0) {
            return false;
        }
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            i2++;
            if (properties.getProperty(str, null) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x001e A[Catch: Exception -> 0x0057, TryCatch #0 {Exception -> 0x0057, blocks: (B:81:0x0049, B:86:0x0053, B:82:0x004c, B:79:0x0043, B:76:0x003d, B:70:0x002d, B:73:0x0034, B:67:0x0026, B:63:0x001e, B:56:0x000d, B:59:0x0014), top: B:91:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0026 A[Catch: Exception -> 0x0057, TryCatch #0 {Exception -> 0x0057, blocks: (B:81:0x0049, B:86:0x0053, B:82:0x004c, B:79:0x0043, B:76:0x003d, B:70:0x002d, B:73:0x0034, B:67:0x0026, B:63:0x001e, B:56:0x000d, B:59:0x0014), top: B:91:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x003d A[Catch: Exception -> 0x0057, TryCatch #0 {Exception -> 0x0057, blocks: (B:81:0x0049, B:86:0x0053, B:82:0x004c, B:79:0x0043, B:76:0x003d, B:70:0x002d, B:73:0x0034, B:67:0x0026, B:63:0x001e, B:56:0x000d, B:59:0x0014), top: B:91:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0043 A[Catch: Exception -> 0x0057, TryCatch #0 {Exception -> 0x0057, blocks: (B:81:0x0049, B:86:0x0053, B:82:0x004c, B:79:0x0043, B:76:0x003d, B:70:0x002d, B:73:0x0034, B:67:0x0026, B:63:0x001e, B:56:0x000d, B:59:0x0014), top: B:91:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0049 A[Catch: Exception -> 0x0057, TryCatch #0 {Exception -> 0x0057, blocks: (B:81:0x0049, B:86:0x0053, B:82:0x004c, B:79:0x0043, B:76:0x003d, B:70:0x002d, B:73:0x0034, B:67:0x0026, B:63:0x001e, B:56:0x000d, B:59:0x0014), top: B:91:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x004c A[Catch: Exception -> 0x0057, TryCatch #0 {Exception -> 0x0057, blocks: (B:81:0x0049, B:86:0x0053, B:82:0x004c, B:79:0x0043, B:76:0x003d, B:70:0x002d, B:73:0x0034, B:67:0x0026, B:63:0x001e, B:56:0x000d, B:59:0x0014), top: B:91:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void h(boolean r6, android.view.Window r7) {
        /*
            r5 = this;
            r0 = 0
            if (r7 != 0) goto L5
            r7 = r0
            goto L9
        L5:
            android.view.WindowManager$LayoutParams r7 = r7.getAttributes()
        L9:
            if (r7 != 0) goto Ld
        Lb:
            r1 = r0
            goto L1a
        Ld:
            java.lang.Class r1 = r7.getClass()     // Catch: java.lang.Exception -> L57
            if (r1 != 0) goto L14
            goto Lb
        L14:
            java.lang.String r2 = "MEIZU_FLAG_DARK_STATUS_BAR_ICON"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch: java.lang.Exception -> L57
        L1a:
            r2 = 1
            if (r1 != 0) goto L1e
            goto L21
        L1e:
            r1.setAccessible(r2)     // Catch: java.lang.Exception -> L57
        L21:
            r3 = 0
            if (r1 != 0) goto L26
            r1 = 0
            goto L2a
        L26:
            int r1 = r1.getInt(r7)     // Catch: java.lang.Exception -> L57
        L2a:
            if (r7 != 0) goto L2d
            goto L3a
        L2d:
            java.lang.Class r4 = r7.getClass()     // Catch: java.lang.Exception -> L57
            if (r4 != 0) goto L34
            goto L3a
        L34:
            java.lang.String r0 = "meizuFlags"
            java.lang.reflect.Field r0 = r4.getDeclaredField(r0)     // Catch: java.lang.Exception -> L57
        L3a:
            if (r0 != 0) goto L3d
            goto L40
        L3d:
            r0.setAccessible(r2)     // Catch: java.lang.Exception -> L57
        L40:
            if (r0 != 0) goto L43
            goto L47
        L43:
            int r3 = r0.getInt(r7)     // Catch: java.lang.Exception -> L57
        L47:
            if (r6 == 0) goto L4c
            r6 = r3 | r1
            goto L4e
        L4c:
            int r6 = ~r1     // Catch: java.lang.Exception -> L57
            r6 = r6 & r3
        L4e:
            if (r3 == r6) goto L5b
            if (r0 != 0) goto L53
            goto L5b
        L53:
            r0.setInt(r7, r6)     // Catch: java.lang.Exception -> L57
            goto L5b
        L57:
            r6 = move-exception
            r6.printStackTrace()
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.t.u.a0.h(boolean, android.view.Window):void");
    }

    @SuppressLint({"PrivateApi"})
    private final void i(boolean z, Window window) {
        Method method = null;
        Class<?> cls = window == null ? null : window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            if (cls != null) {
                Class<?> cls3 = Integer.TYPE;
                method = cls.getMethod("setExtraFlags", cls3, cls3);
            }
            if (method == null) {
                return;
            }
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i2 : 0);
            objArr[1] = Integer.valueOf(i2);
            method.invoke(window, objArr);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void m(Window window) {
        View decorView;
        if (Build.VERSION.SDK_INT >= 23) {
            if (e.t.a.a().e()) {
                decorView = window != null ? window.getDecorView() : null;
                if (decorView == null) {
                    return;
                }
                decorView.setSystemUiVisibility(9216);
                return;
            }
            if (window != null) {
                window.addFlags(Integer.MIN_VALUE);
            }
            decorView = window != null ? window.getDecorView() : null;
            if (decorView == null) {
                return;
            }
            decorView.setSystemUiVisibility(8192);
        } else if (h.t2.u.K1(Build.MANUFACTURER, "OPPO", true)) {
            if (window != null) {
                window.addFlags(Integer.MIN_VALUE);
            }
            decorView = window != null ? window.getDecorView() : null;
            if (decorView == null) {
                return;
            }
            decorView.setSystemUiVisibility(1296);
        } else if (e()) {
            i(true, window);
        } else if (f()) {
            h(true, window);
        } else {
            if (window != null) {
                window.addFlags(Integer.MIN_VALUE);
            }
            if (window == null) {
                return;
            }
            window.setStatusBarColor(ColorUtils.blendARGB(0, ViewCompat.MEASURED_STATE_MASK, 0.2f));
        }
    }

    private final void n(Window window) {
        View decorView;
        if (e.t.a.a().e()) {
            decorView = window != null ? window.getDecorView() : null;
            if (decorView == null) {
                return;
            }
            decorView.setSystemUiVisibility(1280);
            return;
        }
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
        }
        decorView = window != null ? window.getDecorView() : null;
        if (decorView == null) {
            return;
        }
        decorView.setSystemUiVisibility(256);
    }

    public final void a(@k.e.a.d Activity activity, @ColorInt int i2) {
        b(activity.getWindow(), i2);
    }

    @TargetApi(23)
    public final void b(@k.e.a.e Window window, @ColorInt int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (d(i2)) {
                n(window);
            } else {
                m(window);
            }
        }
    }

    public final void c(@k.e.a.d Fragment fragment, @ColorInt int i2) {
        FragmentActivity activity = fragment.getActivity();
        b(activity == null ? null : activity.getWindow(), i2);
    }

    public final void j(@k.e.a.d Activity activity, @ColorInt int i2) {
        k(activity.getWindow(), i2);
    }

    public final void k(@k.e.a.e Window window, @ColorInt int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (d(i2)) {
                m(window);
            } else {
                n(window);
            }
        }
    }

    public final void l(@k.e.a.d Fragment fragment, @ColorInt int i2) {
        FragmentActivity activity = fragment.getActivity();
        k(activity == null ? null : activity.getWindow(), i2);
    }
}
