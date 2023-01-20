package com.didichuxing.doraemonkit.kit.core;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\t\u0010\rJ\u001f\u0010\t\u001a\u00020\u00042\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u000eH&¢\u0006\u0004\b\t\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u0017\u001a\u0004\u0018\u00010\u0007\"\b\b\u0000\u0010\u0013*\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH&¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\u0012J\u000f\u0010\u001d\u001a\u00020\u0004H&¢\u0006\u0004\b\u001d\u0010\u0012J\u0019\u0010\u001e\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b \u0010\u001fJ\u0019\u0010!\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b!\u0010\u001fJ\u0019\u0010\"\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\"\u0010\u001f¨\u0006#"}, d2 = {"Lcom/didichuxing/doraemonkit/kit/core/DokitViewManagerInterface;", "", "Lcom/didichuxing/doraemonkit/kit/core/DokitIntent;", "dokitIntent", "Lh/t1;", "attach", "(Lcom/didichuxing/doraemonkit/kit/core/DokitIntent;)V", "Lcom/didichuxing/doraemonkit/kit/core/AbsDokitView;", "dokitView", "detach", "(Lcom/didichuxing/doraemonkit/kit/core/AbsDokitView;)V", "", RemoteMessageConst.Notification.TAG, "(Ljava/lang/String;)V", "Ljava/lang/Class;", "doKitViewClass", "(Ljava/lang/Class;)V", "detachAll", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/app/Activity;", "activity", "clazz", "getDoKitView", "(Landroid/app/Activity;Ljava/lang/Class;)Lcom/didichuxing/doraemonkit/kit/core/AbsDokitView;", "", "getDoKitViews", "(Landroid/app/Activity;)Ljava/util/Map;", "notifyBackground", "notifyForeground", "onActivityDestroyed", "(Landroid/app/Activity;)V", "onActivityPaused", "onActivityStopped", "dispatchOnActivityResumed", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface DokitViewManagerInterface {
    void attach(@d DokitIntent dokitIntent);

    void detach(@d AbsDokitView absDokitView);

    void detach(@d Class<? extends AbsDokitView> cls);

    void detach(@d String str);

    void detachAll();

    void dispatchOnActivityResumed(@e Activity activity);

    @e
    <T extends AbsDokitView> AbsDokitView getDoKitView(@e Activity activity, @d Class<T> cls);

    @e
    Map<String, AbsDokitView> getDoKitViews(@e Activity activity);

    void notifyBackground();

    void notifyForeground();

    void onActivityDestroyed(@e Activity activity);

    void onActivityPaused(@e Activity activity);

    void onActivityStopped(@e Activity activity);
}
