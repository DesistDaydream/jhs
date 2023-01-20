package com.m7.imkfsdk.view.pickerview.lib;

import java.util.TimerTask;

/* loaded from: classes2.dex */
public final class SmoothScrollTimerTask extends TimerTask {
    public final WheelView loopView;
    public int offset;
    public int realTotalOffset = Integer.MAX_VALUE;
    public int realOffset = 0;

    public SmoothScrollTimerTask(WheelView wheelView, int i2) {
        this.loopView = wheelView;
        this.offset = i2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.realTotalOffset == Integer.MAX_VALUE) {
            this.realTotalOffset = this.offset;
        }
        int i2 = this.realTotalOffset;
        int i3 = (int) (i2 * 0.1f);
        this.realOffset = i3;
        if (i3 == 0) {
            if (i2 < 0) {
                this.realOffset = -1;
            } else {
                this.realOffset = 1;
            }
        }
        if (Math.abs(i2) <= 1) {
            this.loopView.cancelFuture();
            this.loopView.handler.sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.loopView;
        wheelView.totalScrollY += this.realOffset;
        if (!wheelView.isLoop) {
            float f2 = wheelView.itemHeight;
            float f3 = (-wheelView.initPosition) * f2;
            WheelView wheelView2 = this.loopView;
            float itemsCount = ((wheelView.getItemsCount() - 1) - wheelView2.initPosition) * f2;
            int i4 = wheelView2.totalScrollY;
            if (i4 <= f3 || i4 >= itemsCount) {
                wheelView2.totalScrollY = i4 - this.realOffset;
                wheelView2.cancelFuture();
                this.loopView.handler.sendEmptyMessage(3000);
                return;
            }
        }
        this.loopView.handler.sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
