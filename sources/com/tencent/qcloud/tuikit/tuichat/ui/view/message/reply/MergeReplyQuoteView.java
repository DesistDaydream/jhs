package com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import java.util.List;

/* loaded from: classes3.dex */
public class MergeReplyQuoteView extends TUIReplyQuoteView {
    private TextView mergeMsgContent;
    private View mergeMsgLayout;
    private TextView mergeMsgTitle;

    public MergeReplyQuoteView(Context context) {
        super(context);
        this.mergeMsgLayout = findViewById(R.id.merge_msg_layout);
        this.mergeMsgTitle = (TextView) findViewById(R.id.merge_msg_title);
        this.mergeMsgContent = (TextView) findViewById(R.id.merge_msg_content);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public int getLayoutResourceId() {
        return R.layout.chat_reply_quote_merge_layout;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean) {
        MergeMessageBean mergeMessageBean = (MergeMessageBean) tUIReplyQuoteBean.getMessageBean();
        this.mergeMsgLayout.setVisibility(0);
        String title = mergeMessageBean.getTitle();
        List<String> abstractList = mergeMessageBean.getAbstractList();
        this.mergeMsgTitle.setText(title);
        String str = "";
        for (int i2 = 0; i2 < abstractList.size() && i2 < 2; i2++) {
            if (i2 != 0) {
                str = str + "\n";
            }
            str = str + abstractList.get(i2);
        }
        this.mergeMsgContent.setText(FaceManager.emojiJudge(str));
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView
    public void setSelf(boolean z) {
        if (!z) {
            TextView textView = this.mergeMsgContent;
            Resources resources = textView.getResources();
            Context context = this.mergeMsgContent.getContext();
            int i2 = R.attr.chat_other_reply_quote_text_color;
            textView.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, i2)));
            TextView textView2 = this.mergeMsgTitle;
            textView2.setTextColor(textView2.getResources().getColor(TUIThemeManager.getAttrResId(this.mergeMsgTitle.getContext(), i2)));
            return;
        }
        TextView textView3 = this.mergeMsgContent;
        Resources resources2 = textView3.getResources();
        Context context2 = this.mergeMsgContent.getContext();
        int i3 = R.attr.chat_self_reply_quote_text_color;
        textView3.setTextColor(resources2.getColor(TUIThemeManager.getAttrResId(context2, i3)));
        TextView textView4 = this.mergeMsgTitle;
        textView4.setTextColor(textView4.getResources().getColor(TUIThemeManager.getAttrResId(this.mergeMsgTitle.getContext(), i3)));
    }
}
