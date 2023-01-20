package com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomLinkMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;

/* loaded from: classes3.dex */
public class CustomLinkMessageHolder extends MessageContentHolder {
    public static final String TAG = "CustomLinkMessageHolder";
    private TextView linkView;
    private TextView textView;

    public CustomLinkMessageHolder(View view) {
        super(view);
        this.textView = (TextView) view.findViewById(R.id.test_custom_message_tv);
        this.linkView = (TextView) view.findViewById(R.id.link_tv);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.test_custom_message_layout1;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder
    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i2) {
        final String str;
        String str2 = "";
        if (tUIMessageBean instanceof CustomLinkMessageBean) {
            CustomLinkMessageBean customLinkMessageBean = (CustomLinkMessageBean) tUIMessageBean;
            str2 = customLinkMessageBean.getText();
            str = customLinkMessageBean.getLink();
        } else {
            str = "";
        }
        if (!tUIMessageBean.isSelf()) {
            TextView textView = this.textView;
            textView.setTextColor(textView.getResources().getColor(TUIThemeManager.getAttrResId(this.textView.getContext(), R.attr.chat_other_custom_msg_text_color)));
            this.linkView.setTextColor(this.textView.getResources().getColor(TUIThemeManager.getAttrResId(this.textView.getContext(), R.attr.chat_other_custom_msg_link_color)));
        } else {
            TextView textView2 = this.textView;
            textView2.setTextColor(textView2.getResources().getColor(TUIThemeManager.getAttrResId(this.textView.getContext(), R.attr.chat_self_custom_msg_text_color)));
            this.linkView.setTextColor(this.textView.getResources().getColor(TUIThemeManager.getAttrResId(this.textView.getContext(), R.attr.chat_self_custom_msg_link_color)));
        }
        this.textView.setText(str2);
        this.msgContentFrame.setClickable(true);
        this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.CustomLinkMessageHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.addFlags(268435456);
                TUIChatService.getAppContext().startActivity(intent);
            }
        });
    }
}
