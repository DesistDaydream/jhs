package com.m7.imkfsdk.view.pickerview.lib;

/* loaded from: classes2.dex */
public final class OnItemSelectedRunnable implements Runnable {
    public final WheelView loopView;

    public OnItemSelectedRunnable(WheelView wheelView) {
        this.loopView = wheelView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WheelView wheelView = this.loopView;
        wheelView.onItemSelectedListener.onItemSelected(wheelView.getCurrentItem());
    }
}
