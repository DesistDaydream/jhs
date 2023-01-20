package com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.SoundReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;

/* loaded from: classes3.dex */
public class SoundReplyQuoteView extends TUIReplyQuoteView {
    private ImageView soundMsgIcon;
    private View soundMsgLayout;
    private TextView soundMsgTv;

    public SoundReplyQuoteView(Context context) {
        super(context);
        this.soundMsgLayout = findViewById(R.id.sound_msg_layout);
        this.soundMsgIcon = (ImageView) findViewById(R.id.sound_msg_icon_iv);
        this.soundMsgTv = (TextView) findViewById(R.id.sound_msg_time_tv);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public int getLayoutResourceId() {
        return R.layout.chat_reply_quote_sound_layout;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean) {
        this.soundMsgLayout.setVisibility(0);
        if (tUIReplyQuoteBean instanceof SoundReplyQuoteBean) {
            TextView textView = this.soundMsgTv;
            textView.setText(((SoundReplyQuoteBean) tUIReplyQuoteBean).getDuring() + "''");
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public void setSelf(boolean z) {
        if (!z) {
            TextView textView = this.soundMsgTv;
            textView.setTextColor(textView.getResources().getColor(TUIThemeManager.getAttrResId(this.soundMsgTv.getContext(), R.attr.chat_other_reply_quote_text_color)));
            return;
        }
        TextView textView2 = this.soundMsgTv;
        textView2.setTextColor(textView2.getResources().getColor(TUIThemeManager.getAttrResId(this.soundMsgTv.getContext(), R.attr.chat_self_reply_quote_text_color)));
    }
}
