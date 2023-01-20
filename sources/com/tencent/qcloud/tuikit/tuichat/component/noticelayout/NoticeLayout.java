package com.tencent.qcloud.tuikit.tuichat.component.noticelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: classes3.dex */
public class NoticeLayout extends RelativeLayout implements INoticeLayout {
    private View.OnClickListener listener;
    private boolean mAwaysShow;
    private ImageView mCloseBtn;
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
        ImageView imageView = (ImageView) findViewById(R.id.close_btn);
        this.mCloseBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.noticelayout.NoticeLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NoticeLayout.this.listener != null) {
                    NoticeLayout.this.listener.onClick(view);
                }
                NoticeLayout.this.setVisibility(8);
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.noticelayout.INoticeLayout
    public void alwaysShow(boolean z) {
        this.mAwaysShow = z;
        if (z) {
            super.setVisibility(0);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.noticelayout.INoticeLayout
    public TextView getContent() {
        return this.mContentText;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.noticelayout.INoticeLayout
    public TextView getContentExtra() {
        return this.mContentExtraText;
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.listener = onClickListener;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.noticelayout.INoticeLayout
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
