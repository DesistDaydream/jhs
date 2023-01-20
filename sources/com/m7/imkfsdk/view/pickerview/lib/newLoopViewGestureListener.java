package com.m7.imkfsdk.view.pickerview.lib;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: classes2.dex */
public final class newLoopViewGestureListener extends GestureDetector.SimpleOnGestureListener {
    public final newWheelView loopView;

    public newLoopViewGestureListener(newWheelView newwheelview) {
        this.loopView = newwheelview;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.loopView.scrollBy(f3);
        return true;
    }
}
