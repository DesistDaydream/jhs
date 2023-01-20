package com.didichuxing.doraemonkit.kit.core;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class TouchProxy {

    /* loaded from: classes.dex */
    public interface OnTouchEventListener {
        void onDown(int x, int y);

        void onMove(int x, int y, int dx, int dy);

        void onUp(int x, int y);
    }

    public TouchProxy(OnTouchEventListener eventListener) {
    }

    public boolean onTouchEvent(View v, MotionEvent event) {
        return true;
    }

    public void setEventListener(OnTouchEventListener eventListener) {
    }
}
