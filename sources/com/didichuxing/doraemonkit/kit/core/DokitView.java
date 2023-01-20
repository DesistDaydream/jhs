package com.didichuxing.doraemonkit.kit.core;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public interface DokitView {
    boolean canDrag();

    void initDokitViewLayoutParams(DokitViewLayoutParams params);

    boolean onBackPressed();

    void onCreate(Context context);

    View onCreateView(Context context, FrameLayout rootView);

    void onDestroy();

    void onEnterBackground();

    void onEnterForeground();

    void onPause();

    void onResume();

    void onViewCreated(FrameLayout rootView);

    boolean shouldDealBackKey();
}
