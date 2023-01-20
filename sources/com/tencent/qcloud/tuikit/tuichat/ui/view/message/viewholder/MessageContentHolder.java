package com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class MessageContentHolder extends MessageBaseHolder {
    public boolean isForwardMode;
    public boolean isMultiSelectMode;
    public TextView isReadText;
    public UserIconView leftUserIcon;
    private List<TUIMessageBean> mDataSource;
    public LinearLayout msgContentLinear;
    public ChatPresenter presenter;
    public UserIconView rightUserIcon;
    public ProgressBar sendingProgress;
    public ImageView statusImage;
    public TextView unreadAudioText;
    public TextView usernameText;

    public MessageContentHolder(View view) {
        super(view);
        this.isForwardMode = false;
        this.isMultiSelectMode = false;
        this.mDataSource = new ArrayList();
        this.leftUserIcon = (UserIconView) view.findViewById(R.id.left_user_icon_view);
        this.rightUserIcon = (UserIconView) view.findViewById(R.id.right_user_icon_view);
        this.usernameText = (TextView) view.findViewById(R.id.user_name_tv);
        this.msgContentLinear = (LinearLayout) view.findViewById(R.id.msg_content_ll);
        this.statusImage = (ImageView) view.findViewById(R.id.message_status_iv);
        this.sendingProgress = (ProgressBar) view.findViewById(R.id.message_sending_pb);
        this.isReadText = (TextView) view.findViewById(R.id.is_read_tv);
        this.unreadAudioText = (TextView) view.findViewById(R.id.audio_unread);
    }

    private void setReadStatus(final TUIMessageBean tUIMessageBean) {
        if (TUIChatConfigs.getConfigs().getGeneralConfig().isShowRead()) {
            if (tUIMessageBean.isSelf() && 2 == tUIMessageBean.getStatus()) {
                if (tUIMessageBean.isGroup()) {
                    if (TUIChatConfigs.getConfigs().getGeneralConfig().isNeedReadReceipt()) {
                        if (!tUIMessageBean.isNeedReadReceipt()) {
                            this.isReadText.setVisibility(8);
                            return;
                        }
                        this.isReadText.setVisibility(0);
                        if (tUIMessageBean.isAllRead()) {
                            this.isReadText.setText(R.string.has_all_read);
                            return;
                        } else if (tUIMessageBean.isUnread()) {
                            TextView textView = this.isReadText;
                            textView.setTextColor(textView.getResources().getColor(TUIThemeManager.getAttrResId(this.isReadText.getContext(), R.attr.chat_read_receipt_text_color)));
                            this.isReadText.setText(R.string.unread);
                            this.isReadText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder.8
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    MessageContentHolder.this.startShowUnread(tUIMessageBean);
                                }
                            });
                            return;
                        } else {
                            long readCount = tUIMessageBean.getReadCount();
                            if (readCount > 0) {
                                TextView textView2 = this.isReadText;
                                textView2.setText(textView2.getResources().getString(R.string.someone_has_read, Long.valueOf(readCount)));
                                TextView textView3 = this.isReadText;
                                textView3.setTextColor(textView3.getResources().getColor(TUIThemeManager.getAttrResId(this.isReadText.getContext(), R.attr.chat_read_receipt_text_color)));
                                this.isReadText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder.9
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        MessageContentHolder.this.startShowUnread(tUIMessageBean);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                    }
                    this.isReadText.setVisibility(8);
                    return;
                }
                this.isReadText.setVisibility(0);
                if (tUIMessageBean.isPeerRead()) {
                    this.isReadText.setText(R.string.has_read);
                    return;
                } else {
                    this.isReadText.setText(R.string.unread);
                    return;
                }
            }
            this.isReadText.setVisibility(8);
        }
    }

    public List<TUIMessageBean> getDataSource() {
        return this.mDataSource;
    }

    public abstract void layoutVariableViews(TUIMessageBean tUIMessageBean, int i2);

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public void layoutViews(final TUIMessageBean tUIMessageBean, final int i2) {
        super.layoutViews(tUIMessageBean, i2);
        if (this.isForwardMode) {
            this.leftUserIcon.setVisibility(0);
            this.rightUserIcon.setVisibility(8);
        } else if (tUIMessageBean.isSelf()) {
            this.leftUserIcon.setVisibility(8);
            this.rightUserIcon.setVisibility(0);
        } else {
            this.leftUserIcon.setVisibility(0);
            this.rightUserIcon.setVisibility(8);
        }
        if (this.properties.getAvatar() != 0) {
            this.leftUserIcon.setDefaultImageResId(this.properties.getAvatar());
            this.rightUserIcon.setDefaultImageResId(this.properties.getAvatar());
        } else {
            UserIconView userIconView = this.leftUserIcon;
            Context context = userIconView.getContext();
            int i3 = R.attr.core_default_user_icon;
            userIconView.setDefaultImageResId(TUIThemeManager.getAttrResId(context, i3));
            UserIconView userIconView2 = this.rightUserIcon;
            userIconView2.setDefaultImageResId(TUIThemeManager.getAttrResId(userIconView2.getContext(), i3));
        }
        if (this.properties.getAvatarRadius() != 0) {
            this.leftUserIcon.setRadius(this.properties.getAvatarRadius());
            this.rightUserIcon.setRadius(this.properties.getAvatarRadius());
        } else {
            int dip2px = ScreenUtil.dip2px(4.0f);
            this.leftUserIcon.setRadius(dip2px);
            this.rightUserIcon.setRadius(dip2px);
        }
        if (this.properties.getAvatarSize() != null && this.properties.getAvatarSize().length == 2) {
            ViewGroup.LayoutParams layoutParams = this.leftUserIcon.getLayoutParams();
            layoutParams.width = this.properties.getAvatarSize()[0];
            layoutParams.height = this.properties.getAvatarSize()[1];
            this.leftUserIcon.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.rightUserIcon.getLayoutParams();
            layoutParams2.width = this.properties.getAvatarSize()[0];
            layoutParams2.height = this.properties.getAvatarSize()[1];
            this.rightUserIcon.setLayoutParams(layoutParams2);
        }
        if (this.isForwardMode) {
            this.usernameText.setVisibility(0);
        } else if (tUIMessageBean.isSelf()) {
            if (this.properties.getRightNameVisibility() == 0) {
                this.usernameText.setVisibility(8);
            } else {
                this.usernameText.setVisibility(this.properties.getRightNameVisibility());
            }
        } else if (this.properties.getLeftNameVisibility() == 0) {
            if (tUIMessageBean.isGroup()) {
                this.usernameText.setVisibility(0);
            } else {
                this.usernameText.setVisibility(8);
            }
        } else {
            this.usernameText.setVisibility(this.properties.getLeftNameVisibility());
        }
        if (this.properties.getNameFontColor() != 0) {
            this.usernameText.setTextColor(this.properties.getNameFontColor());
        }
        if (this.properties.getNameFontSize() != 0) {
            this.usernameText.setTextSize(this.properties.getNameFontSize());
        }
        if (!TextUtils.isEmpty(tUIMessageBean.getNameCard())) {
            this.usernameText.setText(tUIMessageBean.getNameCard());
        } else if (!TextUtils.isEmpty(tUIMessageBean.getFriendRemark())) {
            this.usernameText.setText(tUIMessageBean.getFriendRemark());
        } else if (!TextUtils.isEmpty(tUIMessageBean.getNickName())) {
            this.usernameText.setText(tUIMessageBean.getNickName());
        } else {
            this.usernameText.setText(tUIMessageBean.getSender());
        }
        if (!TextUtils.isEmpty(tUIMessageBean.getFaceUrl())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(tUIMessageBean.getFaceUrl());
            if (this.isForwardMode) {
                this.leftUserIcon.setIconUrls(arrayList);
            } else if (tUIMessageBean.isSelf()) {
                this.rightUserIcon.setIconUrls(arrayList);
            } else {
                this.leftUserIcon.setIconUrls(arrayList);
            }
        } else {
            this.rightUserIcon.setIconUrls(null);
            this.leftUserIcon.setIconUrls(null);
        }
        if (this.isForwardMode) {
            this.sendingProgress.setVisibility(8);
        } else if (tUIMessageBean.isSelf()) {
            if (tUIMessageBean.getStatus() != 3 && tUIMessageBean.getStatus() != 2 && !tUIMessageBean.isPeerRead()) {
                this.sendingProgress.setVisibility(0);
            } else {
                this.sendingProgress.setVisibility(8);
            }
        } else {
            this.sendingProgress.setVisibility(8);
        }
        if (this.isForwardMode) {
            this.msgContentFrame.setBackgroundResource(TUIThemeManager.getAttrResId(this.itemView.getContext(), R.attr.chat_bubble_other_bg));
            this.statusImage.setVisibility(8);
        } else {
            if (tUIMessageBean.isSelf()) {
                if (this.properties.getRightBubble() != null && this.properties.getRightBubble().getConstantState() != null) {
                    this.msgContentFrame.setBackground(this.properties.getRightBubble().getConstantState().newDrawable());
                } else {
                    this.msgContentFrame.setBackgroundResource(TUIThemeManager.getAttrResId(this.itemView.getContext(), R.attr.chat_bubble_self_bg));
                }
            } else if (this.properties.getLeftBubble() != null && this.properties.getLeftBubble().getConstantState() != null) {
                this.msgContentFrame.setBackground(this.properties.getLeftBubble().getConstantState().newDrawable());
                FrameLayout frameLayout = this.msgContentFrame;
                frameLayout.setLayoutParams(frameLayout.getLayoutParams());
            } else {
                this.msgContentFrame.setBackgroundResource(TUIThemeManager.getAttrResId(this.itemView.getContext(), R.attr.chat_bubble_other_bg));
            }
            if (this.onItemClickListener != null) {
                this.msgContentFrame.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder.1
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        MessageContentHolder.this.onItemClickListener.onMessageLongClick(view, i2, tUIMessageBean);
                        return true;
                    }
                });
                this.leftUserIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageContentHolder.this.onItemClickListener.onUserIconClick(view, i2, tUIMessageBean);
                    }
                });
                this.leftUserIcon.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder.3
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        MessageContentHolder.this.onItemClickListener.onUserIconLongClick(view, i2, tUIMessageBean);
                        return true;
                    }
                });
                this.rightUserIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageContentHolder.this.onItemClickListener.onUserIconClick(view, i2, tUIMessageBean);
                    }
                });
            }
            if (tUIMessageBean.getStatus() == 3) {
                this.statusImage.setVisibility(0);
                this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageContentHolder messageContentHolder = MessageContentHolder.this;
                        OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onMessageLongClick(messageContentHolder.msgContentFrame, i2, tUIMessageBean);
                        }
                    }
                });
                this.statusImage.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageContentHolder messageContentHolder = MessageContentHolder.this;
                        OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onSendFailBtnClick(messageContentHolder.statusImage, i2, tUIMessageBean);
                        }
                    }
                });
            } else {
                this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageContentHolder messageContentHolder = MessageContentHolder.this;
                        OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onMessageClick(messageContentHolder.msgContentFrame, i2, tUIMessageBean);
                        }
                    }
                });
                this.statusImage.setVisibility(8);
            }
        }
        int dimensionPixelSize = this.msgContentFrame.getResources().getDimensionPixelSize(R.dimen.chat_item_padding_bottom);
        this.msgContentFrame.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        if (this.isForwardMode) {
            this.msgContentLinear.removeView(this.msgContentFrame);
            this.msgContentLinear.addView(this.msgContentFrame);
        } else if (tUIMessageBean.isSelf()) {
            this.msgContentLinear.removeView(this.msgContentFrame);
            this.msgContentLinear.addView(this.msgContentFrame);
        } else {
            this.msgContentLinear.removeView(this.msgContentFrame);
            this.msgContentLinear.addView(this.msgContentFrame, 0);
        }
        RelativeLayout relativeLayout = this.rightGroupLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        this.msgContentLinear.setVisibility(0);
        TextView textView = this.isReadText;
        textView.setTextColor(textView.getResources().getColor(R.color.text_gray1));
        this.isReadText.setOnClickListener(null);
        if (this.isForwardMode) {
            this.isReadText.setVisibility(8);
            this.unreadAudioText.setVisibility(8);
        } else {
            setReadStatus(tUIMessageBean);
            this.unreadAudioText.setVisibility(8);
        }
        layoutVariableViews(tUIMessageBean, i2);
    }

    public void onRecycled() {
    }

    public void setDataSource(List<TUIMessageBean> list) {
        if (list == null || list.isEmpty()) {
            this.mDataSource = null;
        }
        ArrayList arrayList = new ArrayList();
        for (TUIMessageBean tUIMessageBean : list) {
            int msgType = tUIMessageBean.getMsgType();
            if (msgType == 3 || msgType == 5) {
                arrayList.add(tUIMessageBean);
            }
        }
        this.mDataSource = arrayList;
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
    }

    public void startShowUnread(TUIMessageBean tUIMessageBean) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(TUIChatConstants.MESSAGE_BEAN, tUIMessageBean);
        TUICore.startActivity("GroupMessageReceiptActivity", bundle);
    }
}
