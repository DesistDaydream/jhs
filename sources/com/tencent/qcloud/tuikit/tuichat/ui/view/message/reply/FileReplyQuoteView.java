package com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FileReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;

/* loaded from: classes3.dex */
public class FileReplyQuoteView extends TUIReplyQuoteView {
    private ImageView fileMsgIcon;
    private View fileMsgLayout;
    private TextView fileMsgTv;

    public FileReplyQuoteView(Context context) {
        super(context);
        this.fileMsgLayout = findViewById(R.id.file_msg_layout);
        this.fileMsgIcon = (ImageView) findViewById(R.id.file_msg_icon_iv);
        this.fileMsgTv = (TextView) findViewById(R.id.file_msg_name_tv);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public int getLayoutResourceId() {
        return R.layout.chat_reply_quote_file_layout;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean) {
        this.fileMsgLayout.setVisibility(0);
        if (tUIReplyQuoteBean instanceof FileReplyQuoteBean) {
            this.fileMsgTv.setText(((FileReplyQuoteBean) tUIReplyQuoteBean).getFileName());
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public void setSelf(boolean z) {
        if (!z) {
            TextView textView = this.fileMsgTv;
            textView.setTextColor(textView.getResources().getColor(TUIThemeManager.getAttrResId(this.fileMsgTv.getContext(), R.attr.chat_other_reply_quote_text_color)));
            return;
        }
        TextView textView2 = this.fileMsgTv;
        textView2.setTextColor(textView2.getResources().getColor(TUIThemeManager.getAttrResId(this.fileMsgTv.getContext(), R.attr.chat_self_reply_quote_text_color)));
    }
}
