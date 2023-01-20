package com.m7.imkfsdk.view.imageviewer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes2.dex */
public class MoorHackyViewPager extends ViewPager {
    private boolean isLocked;

    public MoorHackyViewPager(Context context) {
        super(context);
        this.isLocked = false;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.isLocked) {
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException unused) {
            }
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !this.isLocked && super.onTouchEvent(motionEvent);
    }

    public void setLocked(boolean z) {
        this.isLocked = z;
    }

    public void toggleLock() {
        this.isLocked = !this.isLocked;
    }

    public MoorHackyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isLocked = false;
    }
}
