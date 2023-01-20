package com.m7.imkfsdk.view.pickerview.lib;

import android.os.Handler;
import android.os.Message;
import com.m7.imkfsdk.view.pickerview.lib.WheelView;

/* loaded from: classes2.dex */
public final class MessageHandler extends Handler {
    public static final int WHAT_INVALIDATE_LOOP_VIEW = 1000;
    public static final int WHAT_ITEM_SELECTED = 3000;
    public static final int WHAT_SMOOTH_SCROLL = 2000;
    public final WheelView loopview;

    public MessageHandler(WheelView wheelView) {
        this.loopview = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1000) {
            this.loopview.invalidate();
        } else if (i2 == 2000) {
            this.loopview.smoothScroll(WheelView.ACTION.FLING);
        } else if (i2 != 3000) {
        } else {
            this.loopview.onItemSelected();
        }
    }
}
