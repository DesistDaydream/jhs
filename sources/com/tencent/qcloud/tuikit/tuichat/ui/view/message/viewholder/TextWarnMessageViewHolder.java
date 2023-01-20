package com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder;

import android.view.View;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextWarnMessageBean;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.MaxWidthFrameLayout;

/* loaded from: classes3.dex */
public class TextWarnMessageViewHolder extends MessageBaseHolder {
    private TextWarnMessageBean bean;
    private TextView tv_warn;

    public TextWarnMessageViewHolder(View view) {
        super(view);
        this.tv_warn = (TextView) view.findViewById(R.id.tv_warn);
        view.findViewById(R.id.audio_unread).setVisibility(8);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.chat_warn_item;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public void layoutViews(TUIMessageBean tUIMessageBean, int i2) {
        super.layoutViews(tUIMessageBean, i2);
        ((MaxWidthFrameLayout) this.msgContentFrame).maxWidthPx = ScreenUtil.getScreenWidth(this.itemView.getContext());
        TextWarnMessageBean textWarnMessageBean = (TextWarnMessageBean) tUIMessageBean;
        this.bean = textWarnMessageBean;
        this.tv_warn.setText(textWarnMessageBean.getTitle());
    }
}
