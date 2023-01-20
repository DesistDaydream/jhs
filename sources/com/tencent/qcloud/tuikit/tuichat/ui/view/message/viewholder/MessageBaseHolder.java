package com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageProperties;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.ICommonMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener;
import java.util.Date;

/* loaded from: classes3.dex */
public abstract class MessageBaseHolder extends RecyclerView.ViewHolder {
    public static final int MSG_TYPE_HEADER_VIEW = -99;
    public TextView chatTimeText;
    private ValueAnimator highLightAnimator;
    public ICommonMessageAdapter mAdapter;
    public RelativeLayout mContentLayout;
    public CheckBox mMutiSelectCheckBox;
    public FrameLayout msgContentFrame;
    public OnItemClickListener onItemClickListener;
    public MessageProperties properties;
    public RelativeLayout rightGroupLayout;

    public MessageBaseHolder(View view) {
        super(view);
        this.properties = MessageProperties.getInstance();
        this.chatTimeText = (TextView) view.findViewById(R.id.chat_time_tv);
        this.msgContentFrame = (FrameLayout) view.findViewById(R.id.msg_content_fl);
        this.mMutiSelectCheckBox = (CheckBox) view.findViewById(R.id.select_checkbox);
        this.rightGroupLayout = (RelativeLayout) view.findViewById(R.id.right_group_layout);
        this.mContentLayout = (RelativeLayout) view.findViewById(R.id.messsage_content_layout);
        initVariableLayout();
    }

    private void initVariableLayout() {
        if (getVariableLayout() != 0) {
            setVariableLayout(getVariableLayout());
        }
    }

    private void setVariableLayout(int i2) {
        if (this.msgContentFrame.getChildCount() == 0) {
            View.inflate(this.itemView.getContext(), i2, this.msgContentFrame);
        }
    }

    public void clearHighLightBackground() {
        Drawable background = this.msgContentFrame.getBackground();
        if (background != null) {
            background.setColorFilter(null);
        }
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public abstract int getVariableLayout();

    public void layoutViews(TUIMessageBean tUIMessageBean, int i2) {
        Boolean bool = Boolean.TRUE;
        if (this.properties.getChatTimeBubble() != null) {
            this.chatTimeText.setBackground(this.properties.getChatTimeBubble());
        }
        if (this.properties.getChatTimeFontColor() != 0) {
            this.chatTimeText.setTextColor(this.properties.getChatTimeFontColor());
        }
        if (this.properties.getChatTimeFontSize() != 0) {
            this.chatTimeText.setTextSize(this.properties.getChatTimeFontSize());
        }
        if (i2 > 1) {
            TUIMessageBean item = this.mAdapter.getItem(i2 - 1);
            if (item != null) {
                if (tUIMessageBean.getMessageTime() - item.getMessageTime() >= 300) {
                    this.chatTimeText.setVisibility(0);
                    this.chatTimeText.setText(DateTimeUtil.getTimeFormatText(new Date(tUIMessageBean.getMessageTime() * 1000), bool));
                    return;
                }
                this.chatTimeText.setVisibility(8);
                return;
            }
            return;
        }
        this.chatTimeText.setVisibility(0);
        this.chatTimeText.setText(DateTimeUtil.getTimeFormatText(new Date(tUIMessageBean.getMessageTime() * 1000), bool));
    }

    public void setAdapter(ICommonMessageAdapter iCommonMessageAdapter) {
        this.mAdapter = iCommonMessageAdapter;
    }

    public void setHighLightBackground(int i2) {
        Drawable background = this.msgContentFrame.getBackground();
        if (background != null) {
            background.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void startHighLight() {
        int color = this.itemView.getResources().getColor(R.color.chat_message_bubble_high_light_dark_color);
        int color2 = this.itemView.getResources().getColor(R.color.chat_message_bubble_high_light_light_color);
        if (this.highLightAnimator == null) {
            ArgbEvaluator argbEvaluator = new ArgbEvaluator();
            ValueAnimator valueAnimator = new ValueAnimator();
            this.highLightAnimator = valueAnimator;
            valueAnimator.setIntValues(color, color2);
            this.highLightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder.1
                {
                    MessageBaseHolder.this = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    MessageBaseHolder.this.setHighLightBackground(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
            this.highLightAnimator.addListener(new Animator.AnimatorListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder.2
                {
                    MessageBaseHolder.this = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    MessageBaseHolder.this.clearHighLightBackground();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    MessageBaseHolder.this.clearHighLightBackground();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            this.highLightAnimator.setEvaluator(argbEvaluator);
            this.highLightAnimator.setRepeatCount(3);
            this.highLightAnimator.setDuration(250L);
            this.highLightAnimator.setRepeatMode(2);
        }
        this.highLightAnimator.start();
    }

    public void stopHighLight() {
        ValueAnimator valueAnimator = this.highLightAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        clearHighLightBackground();
    }
}
