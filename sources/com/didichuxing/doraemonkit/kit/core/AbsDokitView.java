package com.didichuxing.doraemonkit.kit.core;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.StringRes;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.didichuxing.doraemonkit.kit.core.DokitViewManager;
import com.didichuxing.doraemonkit.kit.core.TouchProxy;
import com.huawei.hms.push.constant.RemoteMessageConst;
import h.k2.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b~\u0010\nJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\nJ/\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\nJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\nJ\u0019\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0000H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\nJ\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\nJ\u0019\u0010%\u001a\u0004\u0018\u00010$2\b\b\u0001\u0010#\u001a\u00020\u0012¢\u0006\u0004\b%\u0010&J%\u0010*\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010(*\u00020'2\b\b\u0001\u0010)\u001a\u00020\u0012H\u0004¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0006¢\u0006\u0004\b,\u0010\nJ\u0017\u0010/\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J\u001f\u00103\u001a\u00020\u00062\u0006\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u000bH\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u000bH\u0016¢\u0006\u0004\b5\u0010\rJ\u0015\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u001d\u0010<\u001a\u00020\u00062\u0006\u00107\u001a\u0002062\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0006H\u0016¢\u0006\u0004\b>\u0010\nR\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0013\u0010K\u001a\u00020\u00128F@\u0006¢\u0006\u0006\u001a\u0004\bI\u0010JR$\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u00048F@\u0006¢\u0006\u0006\u001a\u0004\bS\u0010TR\u001c\u0010U\u001a\u00020\u000b8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bU\u0010\rR\u0013\u0010W\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\bW\u0010\rR\u0013\u0010Y\u001a\u00020\u00128F@\u0006¢\u0006\u0006\u001a\u0004\bX\u0010JR\u0015\u0010\\\u001a\u0004\u0018\u00010'8F@\u0006¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0015\u0010`\u001a\u0004\u0018\u00010]8F@\u0006¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0015\u0010d\u001a\u0004\u0018\u00010a8F@\u0006¢\u0006\u0006\u001a\u0004\bb\u0010cR\u001c\u0010e\u001a\u00020$8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\"\u0010j\u001a\u00020i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u00101\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010f\u001a\u0004\bp\u0010h\"\u0004\bq\u0010rR$\u0010t\u001a\u0004\u0018\u00010s8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u0015\u0010}\u001a\u0004\u0018\u00010z8F@\u0006¢\u0006\u0006\u001a\u0004\b{\u0010|¨\u0006\u007f"}, d2 = {"Lcom/didichuxing/doraemonkit/kit/core/AbsDokitView;", "Lcom/didichuxing/doraemonkit/kit/core/DokitView;", "Lcom/didichuxing/doraemonkit/kit/core/TouchProxy$OnTouchEventListener;", "Lcom/didichuxing/doraemonkit/kit/core/DokitViewManager$DokitViewAttachedListener;", "Landroid/app/Activity;", "activity", "Lh/t1;", "setActivity", "(Landroid/app/Activity;)V", "onDestroy", "()V", "", "canDrag", "()Z", "onBackPressed", "shouldDealBackKey", "onEnterBackground", "onEnterForeground", "", "x", "y", "dx", "dy", "onMove", "(IIII)V", "onUp", "(II)V", "onDown", "onHomeKeyPress", "onRecentAppKeyPress", "dokitView", "onDokitViewAdd", "(Lcom/didichuxing/doraemonkit/kit/core/AbsDokitView;)V", "onResume", "onPause", "resId", "", "getString", "(I)Ljava/lang/String;", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "id", "findViewById", "(I)Landroid/view/View;", "detach", "Landroid/widget/FrameLayout;", "decorRootView", "dealDecorRootView", "(Landroid/widget/FrameLayout;)V", RemoteMessageConst.Notification.TAG, "isActivityBackResume", "updateViewLayout", "(Ljava/lang/String;Z)V", "restrictBorderline", "Ljava/lang/Runnable;", "run", "post", "(Ljava/lang/Runnable;)V", "", "delayMillis", "postDelayed", "(Ljava/lang/Runnable;J)V", "immInvalidate", "", "mWindowManager", "Ljava/lang/Void;", "Landroid/widget/FrameLayout$LayoutParams;", "normalLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "getNormalLayoutParams", "()Landroid/widget/FrameLayout$LayoutParams;", "setNormalLayoutParams", "(Landroid/widget/FrameLayout$LayoutParams;)V", "getScreenShortSideLength", "()I", "screenShortSideLength", "Landroid/os/Bundle;", TTLiveConstants.BUNDLE_KEY, "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "getActivity", "()Landroid/app/Activity;", "isNormalMode", "Z", "isShow", "getScreenLongSideLength", "screenLongSideLength", "getDoKitView", "()Landroid/view/View;", "doKitView", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "resources", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Lcom/didichuxing/doraemonkit/kit/core/DoKitViewLaunchMode;", "mode", "Lcom/didichuxing/doraemonkit/kit/core/DoKitViewLaunchMode;", "getMode", "()Lcom/didichuxing/doraemonkit/kit/core/DoKitViewLaunchMode;", "setMode", "(Lcom/didichuxing/doraemonkit/kit/core/DoKitViewLaunchMode;)V", "getTag", "setTag", "(Ljava/lang/String;)V", "Landroid/view/WindowManager$LayoutParams;", "systemLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "getSystemLayoutParams", "()Landroid/view/WindowManager$LayoutParams;", "setSystemLayoutParams", "(Landroid/view/WindowManager$LayoutParams;)V", "Lcom/didichuxing/doraemonkit/kit/core/DokitFrameLayout;", "getParentView", "()Lcom/didichuxing/doraemonkit/kit/core/DokitFrameLayout;", "parentView", "<init>", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public abstract class AbsDokitView implements DokitView, TouchProxy.OnTouchEventListener, DokitViewManager.DokitViewAttachedListener {
    @e
    private Bundle bundle;
    private final boolean isNormalMode;
    @d
    @e
    public Void mWindowManager;
    @e
    private FrameLayout.LayoutParams normalLayoutParams;
    @e
    private WindowManager.LayoutParams systemLayoutParams;
    @k.e.a.d
    private final String TAG = "";
    @k.e.a.d
    private DoKitViewLaunchMode mode = DoKitViewLaunchMode.SINGLE_INSTANCE;
    @k.e.a.d
    private String tag = "";

    @Override // com.didichuxing.doraemonkit.kit.core.DokitView
    public boolean canDrag() {
        return true;
    }

    public final void dealDecorRootView(@e FrameLayout frameLayout) {
    }

    public final void detach() {
    }

    @e
    public final <T extends View> T findViewById(@IdRes int i2) {
        return null;
    }

    @e
    public final Activity getActivity() {
        return null;
    }

    @e
    public final Bundle getBundle() {
        return this.bundle;
    }

    @e
    public final Context getContext() {
        return null;
    }

    @e
    public final View getDoKitView() {
        return null;
    }

    @k.e.a.d
    public final DoKitViewLaunchMode getMode() {
        return this.mode;
    }

    @e
    public final FrameLayout.LayoutParams getNormalLayoutParams() {
        return this.normalLayoutParams;
    }

    @e
    public final DokitFrameLayout getParentView() {
        return null;
    }

    @e
    public final Resources getResources() {
        return null;
    }

    public final int getScreenLongSideLength() {
        return -1;
    }

    public final int getScreenShortSideLength() {
        return -1;
    }

    @e
    public final String getString(@StringRes int i2) {
        return null;
    }

    @e
    public final WindowManager.LayoutParams getSystemLayoutParams() {
        return this.systemLayoutParams;
    }

    @k.e.a.d
    public final String getTAG() {
        return this.TAG;
    }

    @k.e.a.d
    public final String getTag() {
        return this.tag;
    }

    public void immInvalidate() {
    }

    public final boolean isNormalMode() {
        return this.isNormalMode;
    }

    public final boolean isShow() {
        return false;
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitView
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitView
    public void onDestroy() {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitViewManager.DokitViewAttachedListener
    public void onDokitViewAdd(@e AbsDokitView absDokitView) {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.TouchProxy.OnTouchEventListener
    public void onDown(int i2, int i3) {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitView
    public void onEnterBackground() {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitView
    public void onEnterForeground() {
    }

    public void onHomeKeyPress() {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.TouchProxy.OnTouchEventListener
    public void onMove(int i2, int i3, int i4, int i5) {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitView
    public void onPause() {
    }

    public void onRecentAppKeyPress() {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitView
    public void onResume() {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.TouchProxy.OnTouchEventListener
    public void onUp(int i2, int i3) {
    }

    public final void post(@k.e.a.d Runnable runnable) {
    }

    public final void postDelayed(@k.e.a.d Runnable runnable, long j2) {
    }

    public boolean restrictBorderline() {
        return true;
    }

    public final void setActivity(@k.e.a.d Activity activity) {
    }

    public final void setBundle(@e Bundle bundle) {
        this.bundle = bundle;
    }

    public final void setMode(@k.e.a.d DoKitViewLaunchMode doKitViewLaunchMode) {
        this.mode = doKitViewLaunchMode;
    }

    public final void setNormalLayoutParams(@e FrameLayout.LayoutParams layoutParams) {
        this.normalLayoutParams = layoutParams;
    }

    public final void setSystemLayoutParams(@e WindowManager.LayoutParams layoutParams) {
        this.systemLayoutParams = layoutParams;
    }

    public final void setTag(@k.e.a.d String str) {
        this.tag = str;
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitView
    public boolean shouldDealBackKey() {
        return false;
    }

    public void updateViewLayout(@k.e.a.d String str, boolean z) {
    }
}
