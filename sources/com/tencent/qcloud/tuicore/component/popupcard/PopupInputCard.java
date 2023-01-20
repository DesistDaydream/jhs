package com.tencent.qcloud.tuicore.component.popupcard;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class PopupInputCard {
    private TextView descriptionTv;
    private EditText editText;
    private String notMachRuleTip;
    private PopupWindow popupWindow;
    private Button positiveBtn;
    private OnClickListener positiveOnClickListener;
    private String rule;
    private TextView titleTv;
    private int minLimit = 0;
    private int maxLimit = Integer.MAX_VALUE;

    @FunctionalInterface
    /* loaded from: classes3.dex */
    public interface OnClickListener {
        void onClick(String str);
    }

    public PopupInputCard(final Activity activity) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.layout_popup_card, (ViewGroup) null);
        this.titleTv = (TextView) inflate.findViewById(R.id.popup_card_title);
        this.editText = (EditText) inflate.findViewById(R.id.popup_card_edit);
        this.descriptionTv = (TextView) inflate.findViewById(R.id.popup_card_description);
        this.positiveBtn = (Button) inflate.findViewById(R.id.popup_card_positive_btn);
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -2, true) { // from class: com.tencent.qcloud.tuicore.component.popupcard.PopupInputCard.1
            @Override // android.widget.PopupWindow
            public void dismiss() {
                Activity activity2 = activity;
                if (activity2 != null && !activity2.isFinishing()) {
                    Window window = activity.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.alpha = 1.0f;
                    window.setAttributes(attributes);
                }
                super.dismiss();
            }

            @Override // android.widget.PopupWindow
            public void showAtLocation(View view, int i2, int i3, int i4) {
                Activity activity2 = activity;
                if (activity2 != null && !activity2.isFinishing()) {
                    Window window = activity.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.alpha = 0.5f;
                    window.setAttributes(attributes);
                }
                super.showAtLocation(view, i2, i3, i4);
            }
        };
        this.popupWindow = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        this.popupWindow.setTouchable(true);
        this.popupWindow.setOutsideTouchable(false);
        this.positiveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.popupcard.PopupInputCard.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String obj = PopupInputCard.this.editText.getText().toString();
                if (obj.length() < PopupInputCard.this.minLimit || obj.length() > PopupInputCard.this.maxLimit) {
                    ToastUtil.toastShortMessage(PopupInputCard.this.notMachRuleTip);
                } else if (TextUtils.isEmpty(PopupInputCard.this.rule) || Pattern.matches(PopupInputCard.this.rule, obj)) {
                    if (PopupInputCard.this.positiveOnClickListener != null) {
                        PopupInputCard.this.positiveOnClickListener.onClick(PopupInputCard.this.editText.getText().toString());
                    }
                    PopupInputCard.this.popupWindow.dismiss();
                } else {
                    ToastUtil.toastShortMessage(PopupInputCard.this.notMachRuleTip);
                }
            }
        });
    }

    public void setContent(String str) {
        this.editText.setText(str);
    }

    public void setDescription(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.descriptionTv.setVisibility(0);
        this.descriptionTv.setText(str);
    }

    public void setMaxLimit(int i2) {
        this.maxLimit = i2;
    }

    public void setMinLimit(int i2) {
        this.minLimit = i2;
    }

    public void setNotMachRuleTip(String str) {
        this.notMachRuleTip = str;
    }

    public void setOnPositive(OnClickListener onClickListener) {
        this.positiveOnClickListener = onClickListener;
    }

    public void setRule(String str) {
        if (TextUtils.isEmpty(str)) {
            this.rule = "";
        } else {
            this.rule = str;
        }
    }

    public void setSingleLine(boolean z) {
        this.editText.setSingleLine(z);
    }

    public void setTitle(String str) {
        this.titleTv.setText(str);
    }

    public void show(View view, int i2) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.showAtLocation(view, i2, 0, 0);
        }
    }
}
