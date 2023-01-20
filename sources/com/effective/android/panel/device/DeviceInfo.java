package com.effective.android.panel.device;

import android.view.Window;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import h.k2.v.f0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005¢\u0006\u0004\b.\u0010/J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000eJ`\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b \u0010\u000eJ\u001a\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010\nR\u0019\u0010\u0018\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010\u000eR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b\u0003\u0010\fR\u0019\u0010\u0019\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b)\u0010\u000eR\u0019\u0010\u0017\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b*\u0010\u000eR\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b+\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b,\u0010\u000eR\u0019\u0010\u001a\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b-\u0010\u000e¨\u00060"}, d2 = {"Lcom/effective/android/panel/device/DeviceInfo;", "", "", "isPortrait", "isPad", "", "getCurrentNavigationBarHeightWhenVisible", "(ZZ)I", "Landroid/view/Window;", "component1", "()Landroid/view/Window;", "component2", "()Z", "component3", "()I", "component4", "component5", "component6", "component7", "component8", "window", "statusBarH", "navigationBarH", "toolbarH", "screenH", "screenWithoutSystemUiH", "screenWithoutNavigationH", "copy", "(Landroid/view/Window;ZIIIIII)Lcom/effective/android/panel/device/DeviceInfo;", "", "toString", "()Ljava/lang/String;", TTDownloadField.TT_HASHCODE, "other", "equals", "(Ljava/lang/Object;)Z", "Landroid/view/Window;", "getWindow", ExpandableTextView.P, "getScreenH", "Z", "getScreenWithoutSystemUiH", "getToolbarH", "getNavigationBarH", "getStatusBarH", "getScreenWithoutNavigationH", "<init>", "(Landroid/view/Window;ZIIIIII)V", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class DeviceInfo {
    private final boolean isPortrait;
    private final int navigationBarH;
    private final int screenH;
    private final int screenWithoutNavigationH;
    private final int screenWithoutSystemUiH;
    private final int statusBarH;
    private final int toolbarH;
    @d
    private final Window window;

    public DeviceInfo(@d Window window, boolean z, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.window = window;
        this.isPortrait = z;
        this.statusBarH = i2;
        this.navigationBarH = i3;
        this.toolbarH = i4;
        this.screenH = i5;
        this.screenWithoutSystemUiH = i6;
        this.screenWithoutNavigationH = i7;
    }

    @d
    public final Window component1() {
        return this.window;
    }

    public final boolean component2() {
        return this.isPortrait;
    }

    public final int component3() {
        return this.statusBarH;
    }

    public final int component4() {
        return this.navigationBarH;
    }

    public final int component5() {
        return this.toolbarH;
    }

    public final int component6() {
        return this.screenH;
    }

    public final int component7() {
        return this.screenWithoutSystemUiH;
    }

    public final int component8() {
        return this.screenWithoutNavigationH;
    }

    @d
    public final DeviceInfo copy(@d Window window, boolean z, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new DeviceInfo(window, z, i2, i3, i4, i5, i6, i7);
    }

    public boolean equals(@e Object obj) {
        if (this != obj) {
            if (obj instanceof DeviceInfo) {
                DeviceInfo deviceInfo = (DeviceInfo) obj;
                return f0.g(this.window, deviceInfo.window) && this.isPortrait == deviceInfo.isPortrait && this.statusBarH == deviceInfo.statusBarH && this.navigationBarH == deviceInfo.navigationBarH && this.toolbarH == deviceInfo.toolbarH && this.screenH == deviceInfo.screenH && this.screenWithoutSystemUiH == deviceInfo.screenWithoutSystemUiH && this.screenWithoutNavigationH == deviceInfo.screenWithoutNavigationH;
            }
            return false;
        }
        return true;
    }

    public final int getCurrentNavigationBarHeightWhenVisible(boolean z, boolean z2) {
        if (z) {
            return this.navigationBarH;
        }
        if (z2) {
            return this.navigationBarH;
        }
        return 0;
    }

    public final int getNavigationBarH() {
        return this.navigationBarH;
    }

    public final int getScreenH() {
        return this.screenH;
    }

    public final int getScreenWithoutNavigationH() {
        return this.screenWithoutNavigationH;
    }

    public final int getScreenWithoutSystemUiH() {
        return this.screenWithoutSystemUiH;
    }

    public final int getStatusBarH() {
        return this.statusBarH;
    }

    public final int getToolbarH() {
        return this.toolbarH;
    }

    @d
    public final Window getWindow() {
        return this.window;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Window window = this.window;
        int hashCode = (window != null ? window.hashCode() : 0) * 31;
        boolean z = this.isPortrait;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return ((((((((((((hashCode + i2) * 31) + this.statusBarH) * 31) + this.navigationBarH) * 31) + this.toolbarH) * 31) + this.screenH) * 31) + this.screenWithoutSystemUiH) * 31) + this.screenWithoutNavigationH;
    }

    public final boolean isPortrait() {
        return this.isPortrait;
    }

    @d
    public String toString() {
        return "DeviceInfo(window=" + this.window + ", isPortrait=" + this.isPortrait + ", statusBarH=" + this.statusBarH + ", navigationBarH=" + this.navigationBarH + ", toolbarH=" + this.toolbarH + ", screenH=" + this.screenH + ", screenWithoutSystemUiH=" + this.screenWithoutSystemUiH + ", screenWithoutNavigationH=" + this.screenWithoutNavigationH + ")";
    }
}
