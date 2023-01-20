package com.m7.imkfsdk.view.pickerview.lib;

import java.util.TimerTask;

/* loaded from: classes2.dex */
public final class InertiaTimerTask extends TimerTask {
    public float a = 2.14748365E9f;
    public final WheelView loopView;
    public final float velocityY;

    public InertiaTimerTask(WheelView wheelView, float f2) {
        this.loopView = wheelView;
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
        int i2 = (int) ((this.a * 10.0f) / 1000.0f);
        WheelView wheelView = this.loopView;
        wheelView.totalScrollY -= i2;
        if (!wheelView.isLoop) {
            float f2 = wheelView.itemHeight;
            float f3 = (-wheelView.initPosition) * f2;
            WheelView wheelView2 = this.loopView;
            float itemsCount = ((wheelView.getItemsCount() - 1) - wheelView2.initPosition) * f2;
            int i3 = wheelView2.totalScrollY;
            double d2 = f2 * 0.3d;
            if (i3 - d2 < f3) {
                f3 = i2 + i3;
            } else if (i3 + d2 > itemsCount) {
                itemsCount = i2 + i3;
            }
            if (i3 <= f3) {
                this.a = 40.0f;
                wheelView2.totalScrollY = (int) f3;
            } else if (i3 >= itemsCount) {
                wheelView2.totalScrollY = (int) itemsCount;
                this.a = -40.0f;
            }
        }
        float f4 = this.a;
        if (f4 < 0.0f) {
            this.a = f4 + 20.0f;
        } else {
            this.a = f4 - 20.0f;
        }
        this.loopView.handler.sendEmptyMessage(1000);
    }
}
