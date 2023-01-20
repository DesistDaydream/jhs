package com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply;

import android.content.Context;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;

/* loaded from: classes3.dex */
public class TextReplyQuoteView extends TUIReplyQuoteView {
    public TextView textView;

    public TextReplyQuoteView(Context context) {
        super(context);
        this.textView = (TextView) findViewById(R.id.text_quote_tv);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public int getLayoutResourceId() {
        return R.layout.chat_reply_quote_text_layout;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean) {
        if (tUIReplyQuoteBean instanceof TextReplyQuoteBean) {
            FaceManager.handlerEmojiText(this.textView, ((TextReplyQuoteBean) tUIReplyQuoteBean).getText(), false);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public void setSelf(boolean z) {
        if (!z) {
            TextView textView = this.textView;
            textView.setTextColor(textView.getResources().getColor(TUIThemeManager.getAttrResId(this.textView.getContext(), R.attr.chat_other_reply_quote_text_color)));
            return;
        }
        TextView textView2 = this.textView;
        textView2.setTextColor(textView2.getResources().getColor(TUIThemeManager.getAttrResId(this.textView.getContext(), R.attr.chat_self_reply_quote_text_color)));
    }
}
