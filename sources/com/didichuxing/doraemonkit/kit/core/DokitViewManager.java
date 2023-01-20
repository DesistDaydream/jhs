package com.didichuxing.doraemonkit.kit.core;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import h.k2.k;
import h.k2.v.u;
import h.w;
import h.z;
import java.util.Map;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\u001f\u0010\u0013\u001a\u00020\u00022\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0018H\u0016¢\u0006\u0004\b\u0013\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J3\u0010\u001e\u001a\u0004\u0018\u00010\u0011\"\b\b\u0000\u0010\u001c*\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0011\u0018\u00010 2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/didichuxing/doraemonkit/kit/core/DokitViewManager;", "Lcom/didichuxing/doraemonkit/kit/core/DokitViewManagerInterface;", "Lh/t1;", "notifyBackground", "()V", "notifyForeground", "Landroid/app/Activity;", "activity", "onActivityDestroyed", "(Landroid/app/Activity;)V", "onActivityPaused", "onActivityStopped", "dispatchOnActivityResumed", "Lcom/didichuxing/doraemonkit/kit/core/DokitIntent;", "dokitIntent", "attach", "(Lcom/didichuxing/doraemonkit/kit/core/DokitIntent;)V", "Lcom/didichuxing/doraemonkit/kit/core/AbsDokitView;", "dokitView", "detach", "(Lcom/didichuxing/doraemonkit/kit/core/AbsDokitView;)V", "", RemoteMessageConst.Notification.TAG, "(Ljava/lang/String;)V", "Ljava/lang/Class;", "doKitViewClass", "(Ljava/lang/Class;)V", "detachAll", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "getDoKitView", "(Landroid/app/Activity;Ljava/lang/Class;)Lcom/didichuxing/doraemonkit/kit/core/AbsDokitView;", "", "getDoKitViews", "(Landroid/app/Activity;)Ljava/util/Map;", "<init>", "Companion", "DokitViewAttachedListener", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class DokitViewManager implements DokitViewManagerInterface {
    public static final Companion Companion = new Companion(null);
    @d
    private static final w instance$delegate = z.c(DokitViewManager$Companion$instance$2.INSTANCE);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\bR#\u0010\t\u001a\u00020\u00028F@\u0007X\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/didichuxing/doraemonkit/kit/core/DokitViewManager$Companion;", "", "Lcom/didichuxing/doraemonkit/kit/core/DokitViewManager;", "instance$delegate", "Lh/w;", "getInstance", "()Lcom/didichuxing/doraemonkit/kit/core/DokitViewManager;", "instance$annotations", "()V", "instance", "<init>", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        @k
        public static /* synthetic */ void instance$annotations() {
        }

        @d
        public final DokitViewManager getInstance() {
            w wVar = DokitViewManager.instance$delegate;
            Companion companion = DokitViewManager.Companion;
            return (DokitViewManager) wVar.getValue();
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/didichuxing/doraemonkit/kit/core/DokitViewManager$DokitViewAttachedListener;", "", "Lcom/didichuxing/doraemonkit/kit/core/AbsDokitView;", "dokitView", "Lh/t1;", "onDokitViewAdd", "(Lcom/didichuxing/doraemonkit/kit/core/AbsDokitView;)V", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public interface DokitViewAttachedListener {
        void onDokitViewAdd(@e AbsDokitView absDokitView);
    }

    @d
    public static final DokitViewManager getInstance() {
        return Companion.getInstance();
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitViewManagerInterface
    public void attach(@d DokitIntent dokitIntent) {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitViewManagerInterface
    public void detach(@d AbsDokitView absDokitView) {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitViewManagerInterface
    public void detach(@d Class<? extends AbsDokitView> cls) {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitViewManagerInterface
    public void detach(@d String str) {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitViewManagerInterface
    public void detachAll() {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitViewManagerInterface
    public void dispatchOnActivityResumed(@e Activity activity) {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitViewManagerInterface
    @e
    public <T extends AbsDokitView> AbsDokitView getDoKitView(@e Activity activity, @d Class<T> cls) {
        return null;
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitViewManagerInterface
    @e
    public Map<String, AbsDokitView> getDoKitViews(@e Activity activity) {
        return null;
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitViewManagerInterface
    public void notifyBackground() {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitViewManagerInterface
    public void notifyForeground() {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitViewManagerInterface
    public void onActivityDestroyed(@e Activity activity) {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitViewManagerInterface
    public void onActivityPaused(@e Activity activity) {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.DokitViewManagerInterface
    public void onActivityStopped(@e Activity activity) {
    }
}
