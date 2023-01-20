package com.tencent.qcloud.tuikit.tuichat.bean;

import android.graphics.drawable.Drawable;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties;

/* loaded from: classes3.dex */
public class MessageProperties implements IMessageProperties {
    private static MessageProperties sP = new MessageProperties();
    private int[] avatarSize = null;
    private int mAvatarId;
    private int mAvatarRadius;
    private int mChatContextFontSize;
    private Drawable mChatTimeBubble;
    private int mChatTimeFontColor;
    private int mChatTimeFontSize;
    private Drawable mFriendBubble;
    private int mFriendChatContentFontColor;
    private int mLeftNameVisibility;
    private Drawable mMyBubble;
    private int mMyChatContentFontColor;
    private int mNameFontColor;
    private int mNameFontSize;
    private int mRightNameVisibility;
    private Drawable mTipsMessageBubble;
    private int mTipsMessageFontColor;
    private int mTipsMessageFontSize;

    private MessageProperties() {
    }

    public static MessageProperties getInstance() {
        if (sP == null) {
            sP = new MessageProperties();
        }
        return sP;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getAvatar() {
        return this.mAvatarId;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getAvatarRadius() {
        return this.mAvatarRadius;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int[] getAvatarSize() {
        return this.avatarSize;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getChatContextFontSize() {
        return this.mChatContextFontSize;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public Drawable getChatTimeBubble() {
        return this.mChatTimeBubble;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getChatTimeFontColor() {
        return this.mChatTimeFontColor;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getChatTimeFontSize() {
        return this.mChatTimeFontSize;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public Drawable getLeftBubble() {
        return this.mFriendBubble;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getLeftChatContentFontColor() {
        return this.mFriendChatContentFontColor;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getLeftNameVisibility() {
        return this.mLeftNameVisibility;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getNameFontColor() {
        return this.mNameFontColor;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getNameFontSize() {
        return this.mNameFontSize;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public Drawable getRightBubble() {
        return this.mMyBubble;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getRightChatContentFontColor() {
        return this.mMyChatContentFontColor;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getRightNameVisibility() {
        return this.mRightNameVisibility;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public Drawable getTipsMessageBubble() {
        return this.mTipsMessageBubble;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getTipsMessageFontColor() {
        return this.mTipsMessageFontColor;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getTipsMessageFontSize() {
        return this.mTipsMessageFontSize;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setAvatar(int i2) {
        this.mAvatarId = i2;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setAvatarRadius(int i2) {
        this.mAvatarRadius = ScreenUtil.getPxByDp(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setAvatarSize(int[] iArr) {
        if (iArr == null || iArr.length != 2) {
            return;
        }
        this.avatarSize = r0;
        int[] iArr2 = {ScreenUtil.getPxByDp(iArr[0])};
        this.avatarSize[1] = ScreenUtil.getPxByDp(iArr[1]);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setChatContextFontSize(int i2) {
        this.mChatContextFontSize = i2;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setChatTimeBubble(Drawable drawable) {
        this.mChatTimeBubble = drawable;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setChatTimeFontColor(int i2) {
        this.mChatTimeFontColor = i2;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setChatTimeFontSize(int i2) {
        this.mChatTimeFontSize = i2;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setLeftBubble(Drawable drawable) {
        this.mFriendBubble = drawable;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setLeftChatContentFontColor(int i2) {
        this.mFriendChatContentFontColor = i2;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setLeftNameVisibility(int i2) {
        this.mLeftNameVisibility = i2;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setNameFontColor(int i2) {
        this.mNameFontColor = i2;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setNameFontSize(int i2) {
        this.mNameFontSize = i2;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setRightBubble(Drawable drawable) {
        this.mMyBubble = drawable;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setRightChatContentFontColor(int i2) {
        this.mMyChatContentFontColor = i2;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setRightNameVisibility(int i2) {
        this.mRightNameVisibility = i2;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setTipsMessageBubble(Drawable drawable) {
        this.mTipsMessageBubble = drawable;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setTipsMessageFontColor(int i2) {
        this.mTipsMessageFontColor = i2;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setTipsMessageFontSize(int i2) {
        this.mTipsMessageFontSize = i2;
    }
}
