package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class CardViewHolder extends BaseHolder {
    private TextView content;
    private ImageView icon;
    private RelativeLayout mRelativeLayout;
    private TextView mame;
    private TextView send;
    private TextView title;
    public View view_line;

    public CardViewHolder(int i2) {
        super(i2);
    }

    public TextView getContent() {
        return this.content;
    }

    public ImageView getIcon() {
        return this.icon;
    }

    public TextView getMame() {
        return this.mame;
    }

    public RelativeLayout getRelativeLayout() {
        return this.mRelativeLayout;
    }

    public TextView getSend() {
        return this.send;
    }

    public TextView getTitle() {
        return this.title;
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.icon = (ImageView) view.findViewById(R.id.kf_chat_card_icon);
        this.title = (TextView) view.findViewById(R.id.kf_chat_card_title);
        this.mame = (TextView) view.findViewById(R.id.kf_chat_card_name);
        this.content = (TextView) view.findViewById(R.id.kf_chat_card_content);
        this.send = (TextView) view.findViewById(R.id.kf_chat_card_send);
        this.mRelativeLayout = (RelativeLayout) view.findViewById(R.id.kf_chat_card_re);
        this.view_line = view.findViewById(R.id.view_line);
        return this;
    }
}
