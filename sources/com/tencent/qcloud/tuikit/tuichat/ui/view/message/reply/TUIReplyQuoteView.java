package com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;

/* loaded from: classes3.dex */
public abstract class TUIReplyQuoteView extends FrameLayout {
    public TUIReplyQuoteView(Context context) {
        super(context);
        int layoutResourceId = getLayoutResourceId();
        if (layoutResourceId != 0) {
            LayoutInflater.from(context).inflate(layoutResourceId, (ViewGroup) this, true);
        }
    }

    public abstract int getLayoutResourceId();

    public abstract void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean);

    public void setSelf(boolean z) {
    }
}
