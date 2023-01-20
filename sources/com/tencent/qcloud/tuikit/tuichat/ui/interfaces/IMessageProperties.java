package com.tencent.qcloud.tuikit.tuichat.ui.interfaces;

import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public interface IMessageProperties {
    int getAvatar();

    int getAvatarRadius();

    int[] getAvatarSize();

    int getChatContextFontSize();

    Drawable getChatTimeBubble();

    int getChatTimeFontColor();

    int getChatTimeFontSize();

    Drawable getLeftBubble();

    int getLeftChatContentFontColor();

    int getLeftNameVisibility();

    int getNameFontColor();

    int getNameFontSize();

    Drawable getRightBubble();

    int getRightChatContentFontColor();

    int getRightNameVisibility();

    Drawable getTipsMessageBubble();

    int getTipsMessageFontColor();

    int getTipsMessageFontSize();

    void setAvatar(int i2);

    void setAvatarRadius(int i2);

    void setAvatarSize(int[] iArr);

    void setChatContextFontSize(int i2);

    void setChatTimeBubble(Drawable drawable);

    void setChatTimeFontColor(int i2);

    void setChatTimeFontSize(int i2);

    void setLeftBubble(Drawable drawable);

    void setLeftChatContentFontColor(int i2);

    void setLeftNameVisibility(int i2);

    void setNameFontColor(int i2);

    void setNameFontSize(int i2);

    void setRightBubble(Drawable drawable);

    void setRightChatContentFontColor(int i2);

    void setRightNameVisibility(int i2);

    void setTipsMessageBubble(Drawable drawable);

    void setTipsMessageFontColor(int i2);

    void setTipsMessageFontSize(int i2);
}
