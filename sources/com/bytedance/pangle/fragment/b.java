package com.bytedance.pangle.fragment;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bytedance.pangle.log.ZeusLogger;

/* loaded from: classes.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    public Fragment a;

    public b(Fragment fragment) {
        this.a = fragment;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostSaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        if (this.a.getActivity() == activity && activity.getClassLoader() != this.a.getClass().getClassLoader()) {
            try {
                Object obj = bundle.get("androidx.lifecycle.BundlableSavedStateRegistry.key");
                if (obj != null) {
                    ((Bundle) obj).remove("android:support:fragments");
                }
                bundle.remove("android:support:fragments");
                ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "clear fragment, Activity:".concat(String.valueOf(activity)));
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@NonNull Activity activity) {
    }
}
