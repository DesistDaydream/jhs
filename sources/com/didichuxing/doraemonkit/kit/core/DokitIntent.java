package com.didichuxing.doraemonkit.kit.core;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import h.k2.v.f0;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b5\u00106J\u0018\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JL\u0010\u0017\u001a\u00020\u00002\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u000eJ\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\u000b\"\u0004\b#\u0010$R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010(R*\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010)\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010,R\"\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010-\u001a\u0004\b.\u0010\b\"\u0004\b/\u00100R\"\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u00101\u001a\u0004\b2\u0010\u000e\"\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/didichuxing/doraemonkit/kit/core/DokitIntent;", "", "Ljava/lang/Class;", "Lcom/didichuxing/doraemonkit/kit/core/AbsDokitView;", "component1", "()Ljava/lang/Class;", "Landroid/app/Activity;", "component2", "()Landroid/app/Activity;", "Landroid/os/Bundle;", "component3", "()Landroid/os/Bundle;", "", "component4", "()Ljava/lang/String;", "Lcom/didichuxing/doraemonkit/kit/core/DoKitViewLaunchMode;", "component5", "()Lcom/didichuxing/doraemonkit/kit/core/DoKitViewLaunchMode;", "targetClass", "activity", TTLiveConstants.BUNDLE_KEY, RemoteMessageConst.Notification.TAG, "mode", "copy", "(Ljava/lang/Class;Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;Lcom/didichuxing/doraemonkit/kit/core/DoKitViewLaunchMode;)Lcom/didichuxing/doraemonkit/kit/core/DokitIntent;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Bundle;", "getBundle", "setBundle", "(Landroid/os/Bundle;)V", "Lcom/didichuxing/doraemonkit/kit/core/DoKitViewLaunchMode;", "getMode", "setMode", "(Lcom/didichuxing/doraemonkit/kit/core/DoKitViewLaunchMode;)V", "Ljava/lang/Class;", "getTargetClass", "setTargetClass", "(Ljava/lang/Class;)V", "Landroid/app/Activity;", "getActivity", "setActivity", "(Landroid/app/Activity;)V", "Ljava/lang/String;", "getTag", "setTag", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/Class;Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;Lcom/didichuxing/doraemonkit/kit/core/DoKitViewLaunchMode;)V", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class DokitIntent {
    @d
    private Activity activity;
    @e
    private Bundle bundle;
    @d
    private DoKitViewLaunchMode mode;
    @d
    private String tag;
    @d
    private Class<? extends AbsDokitView> targetClass;

    public DokitIntent(@d Class<? extends AbsDokitView> cls, @d Activity activity, @e Bundle bundle, @d String str, @d DoKitViewLaunchMode doKitViewLaunchMode) {
        this.targetClass = cls;
        this.activity = activity;
        this.bundle = bundle;
        this.tag = str;
        this.mode = doKitViewLaunchMode;
    }

    public static /* synthetic */ DokitIntent copy$default(DokitIntent dokitIntent, Class cls, Activity activity, Bundle bundle, String str, DoKitViewLaunchMode doKitViewLaunchMode, int i2, Object obj) {
        Class<? extends AbsDokitView> cls2 = cls;
        if ((i2 & 1) != 0) {
            cls2 = dokitIntent.targetClass;
        }
        if ((i2 & 2) != 0) {
            activity = dokitIntent.activity;
        }
        Activity activity2 = activity;
        if ((i2 & 4) != 0) {
            bundle = dokitIntent.bundle;
        }
        Bundle bundle2 = bundle;
        if ((i2 & 8) != 0) {
            str = dokitIntent.tag;
        }
        String str2 = str;
        if ((i2 & 16) != 0) {
            doKitViewLaunchMode = dokitIntent.mode;
        }
        return dokitIntent.copy(cls2, activity2, bundle2, str2, doKitViewLaunchMode);
    }

    @d
    public final Class<? extends AbsDokitView> component1() {
        return this.targetClass;
    }

    @d
    public final Activity component2() {
        return this.activity;
    }

    @e
    public final Bundle component3() {
        return this.bundle;
    }

    @d
    public final String component4() {
        return this.tag;
    }

    @d
    public final DoKitViewLaunchMode component5() {
        return this.mode;
    }

    @d
    public final DokitIntent copy(@d Class<? extends AbsDokitView> cls, @d Activity activity, @e Bundle bundle, @d String str, @d DoKitViewLaunchMode doKitViewLaunchMode) {
        return new DokitIntent(cls, activity, bundle, str, doKitViewLaunchMode);
    }

    public boolean equals(@e Object obj) {
        if (this != obj) {
            if (obj instanceof DokitIntent) {
                DokitIntent dokitIntent = (DokitIntent) obj;
                return f0.g(this.targetClass, dokitIntent.targetClass) && f0.g(this.activity, dokitIntent.activity) && f0.g(this.bundle, dokitIntent.bundle) && f0.g(this.tag, dokitIntent.tag) && f0.g(this.mode, dokitIntent.mode);
            }
            return false;
        }
        return true;
    }

    @d
    public final Activity getActivity() {
        return this.activity;
    }

    @e
    public final Bundle getBundle() {
        return this.bundle;
    }

    @d
    public final DoKitViewLaunchMode getMode() {
        return this.mode;
    }

    @d
    public final String getTag() {
        return this.tag;
    }

    @d
    public final Class<? extends AbsDokitView> getTargetClass() {
        return this.targetClass;
    }

    public int hashCode() {
        Class<? extends AbsDokitView> cls = this.targetClass;
        int hashCode = (cls != null ? cls.hashCode() : 0) * 31;
        Activity activity = this.activity;
        int hashCode2 = (hashCode + (activity != null ? activity.hashCode() : 0)) * 31;
        Bundle bundle = this.bundle;
        int hashCode3 = (hashCode2 + (bundle != null ? bundle.hashCode() : 0)) * 31;
        String str = this.tag;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        DoKitViewLaunchMode doKitViewLaunchMode = this.mode;
        return hashCode4 + (doKitViewLaunchMode != null ? doKitViewLaunchMode.hashCode() : 0);
    }

    public final void setActivity(@d Activity activity) {
        this.activity = activity;
    }

    public final void setBundle(@e Bundle bundle) {
        this.bundle = bundle;
    }

    public final void setMode(@d DoKitViewLaunchMode doKitViewLaunchMode) {
        this.mode = doKitViewLaunchMode;
    }

    public final void setTag(@d String str) {
        this.tag = str;
    }

    public final void setTargetClass(@d Class<? extends AbsDokitView> cls) {
        this.targetClass = cls;
    }

    @d
    public String toString() {
        return "DokitIntent(targetClass=" + this.targetClass + ", activity=" + this.activity + ", bundle=" + this.bundle + ", tag=" + this.tag + ", mode=" + this.mode + ")";
    }

    public /* synthetic */ DokitIntent(Class cls, Activity activity, Bundle bundle, String str, DoKitViewLaunchMode doKitViewLaunchMode, int i2, u uVar) {
        this(cls, (i2 & 2) != 0 ? new Activity() : activity, (i2 & 4) != 0 ? null : bundle, (i2 & 8) != 0 ? "" : str, (i2 & 16) != 0 ? DoKitViewLaunchMode.SINGLE_INSTANCE : doKitViewLaunchMode);
    }
}
