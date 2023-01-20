package com.tencent.qcloud.tuikit.tuichat.ui.view.input;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: classes3.dex */
public class ReplyPreviewBar extends RelativeLayout {
    public ReplyPreviewBar(Context context) {
        super(context);
        initViews();
    }

    private void initViews() {
        RelativeLayout.inflate(getContext(), R.layout.reply_preview_layout, this);
    }

    public ReplyPreviewBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViews();
    }

    public ReplyPreviewBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initViews();
    }
}
