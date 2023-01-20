package com.m7.imkfsdk.view.pickerview.lib;

import java.util.TimerTask;

/* loaded from: classes2.dex */
public final class newSmoothScrollTimerTask extends TimerTask {
    public final newWheelView loopView;
    public int offset;
    public int realTotalOffset = Integer.MAX_VALUE;
    public int realOffset = 0;

    public newSmoothScrollTimerTask(newWheelView newwheelview, int i2) {
        this.loopView = newwheelview;
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
        newWheelView newwheelview = this.loopView;
        newwheelview.totalScrollY += this.realOffset;
        if (!newwheelview.isLoop) {
            float f2 = newwheelview.itemHeight;
            float f3 = (-newwheelview.initPosition) * f2;
            newWheelView newwheelview2 = this.loopView;
            float itemsCount = ((newwheelview.getItemsCount() - 1) - newwheelview2.initPosition) * f2;
            float f4 = newwheelview2.totalScrollY;
            if (f4 <= f3 || f4 >= itemsCount) {
                newwheelview2.totalScrollY = f4 - this.realOffset;
                newwheelview2.cancelFuture();
                this.loopView.handler.sendEmptyMessage(3000);
                return;
            }
        }
        this.loopView.handler.sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
