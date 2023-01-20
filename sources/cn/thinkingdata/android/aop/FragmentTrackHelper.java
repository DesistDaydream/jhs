package cn.thinkingdata.android.aop;

import android.os.Bundle;
import android.view.View;
import cn.thinkingdata.android.ThinkingDataRuntimeBridge;

/* loaded from: classes.dex */
public class FragmentTrackHelper {
    private static final String TAG = "ThinkingAnalytics";

    public static void onFragmentViewCreated(Object obj, View view, Bundle bundle) {
        ThinkingDataRuntimeBridge.onFragmentCreateView(obj, view);
    }

    public static void trackFragmentPause(Object obj) {
    }

    public static void trackFragmentResume(Object obj) {
        ThinkingDataRuntimeBridge.onFragmentOnResume(obj);
    }

    public static void trackFragmentSetUserVisibleHint(Object obj, boolean z) {
        ThinkingDataRuntimeBridge.onFragmentSetUserVisibleHint(obj, z);
    }

    public static void trackOnHiddenChanged(Object obj, boolean z) {
        ThinkingDataRuntimeBridge.onFragmentHiddenChanged(obj, z);
    }
}
