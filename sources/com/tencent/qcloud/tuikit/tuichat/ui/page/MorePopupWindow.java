package com.tencent.qcloud.tuikit.tuichat.ui.page;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: classes3.dex */
public class MorePopupWindow extends PopupWindow {
    private Context mContext;
    private OnClickPosListener mListener;

    /* loaded from: classes3.dex */
    public interface OnClickPosListener {
        void onClick(int i2);
    }

    public MorePopupWindow(Context context, OnClickPosListener onClickPosListener) {
        super(context);
        this.mListener = onClickPosListener;
        this.mContext = context;
        initView();
        initPopupWindow();
    }

    private void initPopupWindow() {
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.pop_more, (ViewGroup) null);
        inflate.findViewById(R.id.banBtn).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.MorePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MorePopupWindow.this.mListener != null) {
                    MorePopupWindow.this.dismiss();
                    MorePopupWindow.this.mListener.onClick(0);
                }
            }
        });
        inflate.findViewById(R.id.reportBtn).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.MorePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MorePopupWindow.this.mListener != null) {
                    MorePopupWindow.this.dismiss();
                    MorePopupWindow.this.mListener.onClick(1);
                }
            }
        });
        setContentView(inflate);
    }
}
