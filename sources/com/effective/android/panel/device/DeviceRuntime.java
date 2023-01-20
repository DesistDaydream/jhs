package com.effective.android.panel.device;

import android.content.Context;
import android.view.Window;
import com.effective.android.panel.utils.DisplayUtil;
import h.k2.v.f0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000bR\u0019\u0010!\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/effective/android/panel/device/DeviceRuntime;", "", "", "cache", "Lcom/effective/android/panel/device/DeviceInfo;", "getDeviceInfoByOrientation", "(Z)Lcom/effective/android/panel/device/DeviceInfo;", "isPad", "Z", "()Z", "setPad", "(Z)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "deviceInfoL", "Lcom/effective/android/panel/device/DeviceInfo;", "getDeviceInfoL", "()Lcom/effective/android/panel/device/DeviceInfo;", "setDeviceInfoL", "(Lcom/effective/android/panel/device/DeviceInfo;)V", "isNavigationBarShow", "setNavigationBarShow", "isPortrait", "setPortrait", "deviceInfoP", "getDeviceInfoP", "setDeviceInfoP", "isFullScreen", "setFullScreen", "Landroid/view/Window;", "window", "Landroid/view/Window;", "getWindow", "()Landroid/view/Window;", "<init>", "(Landroid/content/Context;Landroid/view/Window;)V", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class DeviceRuntime {
    @d
    private final Context context;
    @e
    private DeviceInfo deviceInfoL;
    @e
    private DeviceInfo deviceInfoP;
    private boolean isFullScreen;
    private boolean isNavigationBarShow;
    private boolean isPad;
    private boolean isPortrait;
    @d
    private final Window window;

    public DeviceRuntime(@d Context context, @d Window window) {
        this.context = context;
        this.window = window;
        this.isPad = (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        this.isPortrait = DisplayUtil.isPortrait(context);
        this.isNavigationBarShow = DisplayUtil.isNavigationBarShow(context, window);
        this.isFullScreen = DisplayUtil.isFullScreen(window);
    }

    public static /* synthetic */ DeviceInfo getDeviceInfoByOrientation$default(DeviceRuntime deviceRuntime, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return deviceRuntime.getDeviceInfoByOrientation(z);
    }

    @d
    public final Context getContext() {
        return this.context;
    }

    @d
    public final DeviceInfo getDeviceInfoByOrientation(boolean z) {
        DeviceInfo deviceInfo;
        DeviceInfo deviceInfo2;
        DeviceInfo deviceInfo3;
        this.isPortrait = DisplayUtil.isPortrait(this.context);
        this.isNavigationBarShow = DisplayUtil.isNavigationBarShow(this.context, this.window);
        this.isFullScreen = DisplayUtil.isFullScreen(this.window);
        if (z) {
            boolean z2 = this.isPortrait;
            if (z2 && (deviceInfo3 = this.deviceInfoP) != null) {
                if (deviceInfo3 == null) {
                    f0.L();
                }
                return deviceInfo3;
            } else if (!z2 && (deviceInfo2 = this.deviceInfoL) != null) {
                if (deviceInfo2 == null) {
                    f0.L();
                }
                return deviceInfo2;
            }
        }
        int navigationBarHeight = DisplayUtil.getNavigationBarHeight(this.context, this.window);
        int statusBarHeight = DisplayUtil.getStatusBarHeight(this.window);
        int toolbarHeight = DisplayUtil.getToolbarHeight(this.window);
        int i2 = toolbarHeight == statusBarHeight ? 0 : toolbarHeight;
        int screenRealHeight = DisplayUtil.INSTANCE.getScreenRealHeight(this.window);
        int screenHeightWithoutSystemUI = DisplayUtil.getScreenHeightWithoutSystemUI(this.window);
        int screenHeightWithoutNavigationBar = DisplayUtil.getScreenHeightWithoutNavigationBar(this.context);
        if (this.isPortrait) {
            deviceInfo = new DeviceInfo(this.window, true, statusBarHeight, navigationBarHeight, i2, screenRealHeight, screenHeightWithoutSystemUI, screenHeightWithoutNavigationBar);
            this.deviceInfoP = deviceInfo;
            if (deviceInfo == null) {
                f0.L();
            }
        } else {
            deviceInfo = new DeviceInfo(this.window, false, statusBarHeight, navigationBarHeight, i2, screenRealHeight, screenHeightWithoutSystemUI, screenHeightWithoutNavigationBar);
            this.deviceInfoL = deviceInfo;
            if (deviceInfo == null) {
                f0.L();
            }
        }
        return deviceInfo;
    }

    @e
    public final DeviceInfo getDeviceInfoL() {
        return this.deviceInfoL;
    }

    @e
    public final DeviceInfo getDeviceInfoP() {
        return this.deviceInfoP;
    }

    @d
    public final Window getWindow() {
        return this.window;
    }

    public final boolean isFullScreen() {
        return this.isFullScreen;
    }

    public final boolean isNavigationBarShow() {
        return this.isNavigationBarShow;
    }

    public final boolean isPad() {
        return this.isPad;
    }

    public final boolean isPortrait() {
        return this.isPortrait;
    }

    public final void setDeviceInfoL(@e DeviceInfo deviceInfo) {
        this.deviceInfoL = deviceInfo;
    }

    public final void setDeviceInfoP(@e DeviceInfo deviceInfo) {
        this.deviceInfoP = deviceInfo;
    }

    public final void setFullScreen(boolean z) {
        this.isFullScreen = z;
    }

    public final void setNavigationBarShow(boolean z) {
        this.isNavigationBarShow = z;
    }

    public final void setPad(boolean z) {
        this.isPad = z;
    }

    public final void setPortrait(boolean z) {
        this.isPortrait = z;
    }
}
