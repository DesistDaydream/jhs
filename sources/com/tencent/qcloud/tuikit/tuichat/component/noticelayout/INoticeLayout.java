package com.tencent.qcloud.tuikit.tuichat.component.noticelayout;

import android.view.View;
import android.widget.TextView;

/* loaded from: classes3.dex */
public interface INoticeLayout {
    void alwaysShow(boolean z);

    TextView getContent();

    TextView getContentExtra();

    void setOnNoticeClickListener(View.OnClickListener onClickListener);
}
