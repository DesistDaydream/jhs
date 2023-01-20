package com.tencent.qcloud.tuicore.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.component.interfaces.INoticeLayout;

/* loaded from: classes3.dex */
public class NoticeLayout extends RelativeLayout implements INoticeLayout {
    private boolean mAwaysShow;
    private TextView mContentExtraText;
    private TextView mContentText;

    public NoticeLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        RelativeLayout.inflate(getContext(), R.layout.notice_layout, this);
        this.mContentText = (TextView) findViewById(R.id.notice_content);
        this.mContentExtraText = (TextView) findViewById(R.id.notice_content_extra);
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.INoticeLayout
    public void alwaysShow(boolean z) {
        this.mAwaysShow = z;
        if (z) {
            super.setVisibility(0);
        }
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.INoticeLayout
    public TextView getContent() {
        return this.mContentText;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.INoticeLayout
    public TextView getContentExtra() {
        return this.mContentExtraText;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.INoticeLayout
    public void setOnNoticeClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (this.mAwaysShow) {
            super.setVisibility(0);
        } else {
            super.setVisibility(i2);
        }
    }

    public NoticeLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public NoticeLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
