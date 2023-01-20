package com.tencent.qcloud.tuicore.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.util.ScreenUtil;

/* loaded from: classes3.dex */
public class LineControllerView extends LinearLayout {
    private String mContent;
    private TextView mContentText;
    private boolean mIsBottom;
    private boolean mIsJump;
    private boolean mIsSwitch;
    private boolean mIsTop;
    private String mName;
    private TextView mNameText;
    private ImageView mNavArrowView;
    private Switch mSwitchView;

    public LineControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.line_controller_view, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LineControllerView, 0, 0);
        try {
            this.mName = obtainStyledAttributes.getString(R.styleable.LineControllerView_name);
            this.mContent = obtainStyledAttributes.getString(R.styleable.LineControllerView_subject);
            this.mIsBottom = obtainStyledAttributes.getBoolean(R.styleable.LineControllerView_isBottom, false);
            this.mIsTop = obtainStyledAttributes.getBoolean(R.styleable.LineControllerView_isTop, false);
            this.mIsJump = obtainStyledAttributes.getBoolean(R.styleable.LineControllerView_canNav, false);
            this.mIsSwitch = obtainStyledAttributes.getBoolean(R.styleable.LineControllerView_isSwitch, false);
            setUpView();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void setUpView() {
        TextView textView = (TextView) findViewById(R.id.name);
        this.mNameText = textView;
        textView.setText(this.mName);
        TextView textView2 = (TextView) findViewById(R.id.content);
        this.mContentText = textView2;
        textView2.setText(this.mContent);
        View findViewById = findViewById(R.id.bottomLine);
        View findViewById2 = findViewById(R.id.top_line);
        findViewById.setVisibility(this.mIsBottom ? 0 : 8);
        findViewById2.setVisibility(this.mIsTop ? 0 : 8);
        ImageView imageView = (ImageView) findViewById(R.id.rightArrow);
        this.mNavArrowView = imageView;
        imageView.setVisibility(this.mIsJump ? 0 : 8);
        ((RelativeLayout) findViewById(R.id.contentText)).setVisibility(this.mIsSwitch ? 8 : 0);
        Switch r0 = (Switch) findViewById(R.id.btnSwitch);
        this.mSwitchView = r0;
        r0.setVisibility(this.mIsSwitch ? 0 : 8);
    }

    public String getContent() {
        return this.mContentText.getText().toString();
    }

    public boolean isChecked() {
        return this.mSwitchView.isChecked();
    }

    public void setCanNav(boolean z) {
        this.mIsJump = z;
        this.mNavArrowView.setVisibility(z ? 0 : 8);
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.mContentText.getLayoutParams();
            layoutParams.width = ScreenUtil.getPxByDp(120.0f);
            layoutParams.height = -2;
            this.mContentText.setLayoutParams(layoutParams);
            this.mContentText.setTextIsSelectable(false);
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.mContentText.getLayoutParams();
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        this.mContentText.setLayoutParams(layoutParams2);
        this.mContentText.setTextIsSelectable(true);
    }

    public void setCheckListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mSwitchView.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void setChecked(boolean z) {
        this.mSwitchView.setChecked(z);
    }

    public void setContent(String str) {
        this.mContent = str;
        this.mContentText.setText(str);
    }

    public void setSingleLine(boolean z) {
        this.mContentText.setSingleLine(z);
    }
}
