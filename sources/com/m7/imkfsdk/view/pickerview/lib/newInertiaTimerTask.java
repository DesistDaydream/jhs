package com.m7.imkfsdk.view.pickerview.lib;

import java.util.TimerTask;

/* loaded from: classes2.dex */
public final class newInertiaTimerTask extends TimerTask {
    public float a = 2.14748365E9f;
    public final newWheelView loopView;
    public final float velocityY;

    public newInertiaTimerTask(newWheelView newwheelview, float f2) {
        this.loopView = newwheelview;
        this.velocityY = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.a == 2.14748365E9f) {
            if (Math.abs(this.velocityY) > 2000.0f) {
                if (this.velocityY > 0.0f) {
                    this.a = 2000.0f;
                } else {
                    this.a = -2000.0f;
                }
            } else {
                this.a = this.velocityY;
            }
        }
        if (Math.abs(this.a) >= 0.0f && Math.abs(this.a) <= 20.0f) {
            this.loopView.cancelFuture();
            this.loopView.handler.sendEmptyMessage(2000);
            return;
        }
        newWheelView newwheelview = this.loopView;
        float f2 = (int) ((this.a * 10.0f) / 1000.0f);
        newwheelview.totalScrollY -= f2;
        if (!newwheelview.isLoop) {
            float f3 = newwheelview.itemHeight;
            float f4 = (-newwheelview.initPosition) * f3;
            newWheelView newwheelview2 = this.loopView;
            float itemsCount = ((newwheelview.getItemsCount() - 1) - newwheelview2.initPosition) * f3;
            float f5 = newwheelview2.totalScrollY;
            double d2 = f3 * 0.25d;
            if (f5 - d2 < f4) {
                f4 = f5 + f2;
            } else if (f5 + d2 > itemsCount) {
                itemsCount = f5 + f2;
            }
            if (f5 <= f4) {
                this.a = 40.0f;
                newwheelview2.totalScrollY = (int) f4;
            } else if (f5 >= itemsCount) {
                newwheelview2.totalScrollY = (int) itemsCount;
                this.a = -40.0f;
            }
        }
        float f6 = this.a;
        if (f6 < 0.0f) {
            this.a = f6 + 20.0f;
        } else {
            this.a = f6 - 20.0f;
        }
        this.loopView.handler.sendEmptyMessage(1000);
    }
}
