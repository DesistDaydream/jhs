package com.tencent.qcloud.tuicore.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuicore.util.ScreenUtil;

/* loaded from: classes3.dex */
public class TitleBarLayout extends LinearLayout implements ITitleBarLayout {
    private TextView mCenterTitle;
    private LinearLayout mLeftGroup;
    private ImageView mLeftIcon;
    private ImageView mLeftIcon2;
    private TextView mLeftTitle;
    private LinearLayout mRightGroup;
    private ImageView mRightIcon;
    private TextView mRightTitle;
    private RelativeLayout mTitleLayout;
    private UnreadCountTextView unreadCountTextView;

    /* renamed from: com.tencent.qcloud.tuicore.component.TitleBarLayout$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$tencent$qcloud$tuicore$component$interfaces$ITitleBarLayout$Position;

        static {
            int[] iArr = new int[ITitleBarLayout.Position.values().length];
            $SwitchMap$com$tencent$qcloud$tuicore$component$interfaces$ITitleBarLayout$Position = iArr;
            try {
                iArr[ITitleBarLayout.Position.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$qcloud$tuicore$component$interfaces$ITitleBarLayout$Position[ITitleBarLayout.Position.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$qcloud$tuicore$component$interfaces$ITitleBarLayout$Position[ITitleBarLayout.Position.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public TitleBarLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        LinearLayout.inflate(getContext(), R.layout.title_bar_layout, this);
        this.mTitleLayout = (RelativeLayout) findViewById(R.id.page_title_layout);
        this.mLeftGroup = (LinearLayout) findViewById(R.id.page_title_left_group);
        this.mRightGroup = (LinearLayout) findViewById(R.id.page_title_right_group);
        this.mLeftTitle = (TextView) findViewById(R.id.page_title_left_text);
        this.mRightTitle = (TextView) findViewById(R.id.page_title_right_text);
        this.mCenterTitle = (TextView) findViewById(R.id.page_title);
        this.mLeftIcon = (ImageView) findViewById(R.id.page_title_left_icon);
        this.mLeftIcon2 = (ImageView) findViewById(R.id.page_title_left_icon2);
        this.mRightIcon = (ImageView) findViewById(R.id.page_title_right_icon);
        this.unreadCountTextView = (UnreadCountTextView) findViewById(R.id.new_message_total_unread);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTitleLayout.getLayoutParams();
        layoutParams.height = ScreenUtil.getPxByDp(50.0f);
        this.mTitleLayout.setLayoutParams(layoutParams);
        setBackgroundColor(getResources().getColor(R.color.white));
        ScreenUtil.dip2px(20.0f);
        this.mLeftIcon.getLayoutParams();
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public LinearLayout getLeftGroup() {
        return this.mLeftGroup;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public ImageView getLeftIcon() {
        return this.mLeftIcon;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public TextView getLeftTitle() {
        return this.mLeftTitle;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public TextView getMiddleTitle() {
        return this.mCenterTitle;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public LinearLayout getRightGroup() {
        return this.mRightGroup;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public ImageView getRightIcon() {
        return this.mRightIcon;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public TextView getRightTitle() {
        return this.mRightTitle;
    }

    public UnreadCountTextView getUnreadCountTextView() {
        return this.unreadCountTextView;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public void setLeftIcon(int i2) {
        this.mLeftIcon.setImageResource(i2);
    }

    public void setLeftIcon2(int i2) {
        this.mLeftIcon2.setVisibility(0);
        this.mLeftIcon2.setImageResource(i2);
    }

    public void setLeftIcon2Padding(int i2) {
        this.mLeftIcon2.setPadding(i2, i2, i2, i2);
    }

    public void setLiftIcon2Click(View.OnClickListener onClickListener) {
        this.mLeftIcon2.setOnClickListener(onClickListener);
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public void setOnLeftClickListener(View.OnClickListener onClickListener) {
        this.mLeftGroup.setOnClickListener(onClickListener);
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public void setOnRightClickListener(View.OnClickListener onClickListener) {
        this.mRightGroup.setOnClickListener(onClickListener);
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public void setRightIcon(int i2) {
        this.mRightIcon.setImageResource(i2);
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public void setTitle(String str, ITitleBarLayout.Position position) {
        int i2 = AnonymousClass1.$SwitchMap$com$tencent$qcloud$tuicore$component$interfaces$ITitleBarLayout$Position[position.ordinal()];
        if (i2 == 1) {
            this.mLeftTitle.setText(str);
        } else if (i2 == 2) {
            this.mRightTitle.setText(str);
        } else if (i2 != 3) {
        } else {
            this.mCenterTitle.setText(str);
        }
    }

    public TitleBarLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TitleBarLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
