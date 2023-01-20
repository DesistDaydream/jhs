package com.m7.imkfsdk.view.pickerview.lib;

/* loaded from: classes2.dex */
public final class newOnItemSelectedRunnable implements Runnable {
    public final newWheelView loopView;

    public newOnItemSelectedRunnable(newWheelView newwheelview) {
        this.loopView = newwheelview;
    }

    @Override // java.lang.Runnable
    public final void run() {
        newWheelView newwheelview = this.loopView;
        newwheelview.onItemSelectedListener.onItemSelected(newwheelview.getCurrentItem());
    }
}
