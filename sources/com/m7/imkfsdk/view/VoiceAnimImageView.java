package com.m7.imkfsdk.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class VoiceAnimImageView extends TextView {
    private static final int TYPE_VOICE_DOWNLOADING = 0;
    private static final int TYPE_VOICE_PLAYING = 1;
    private boolean isFrom;
    private boolean isRunning;
    private Context mActivity;
    private AlphaAnimation mAlphaAnimation;
    private AnimationDrawable mChattingFromAnimationDrawable;
    private AnimationDrawable mChattingToAnimationDrawable;
    private int mDuration;
    private int mVoiceType;

    public VoiceAnimImageView(Context context) {
        super(context);
        this.mDuration = 300;
        this.mVoiceType = 1;
        this.isFrom = false;
        this.isRunning = false;
        this.mActivity = context;
        initAnimImageView();
    }

    public void initAnimImageView() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 0.1f);
        this.mAlphaAnimation = alphaAnimation;
        alphaAnimation.setDuration(1000L);
        this.mAlphaAnimation.setRepeatCount(-1);
        this.mAlphaAnimation.setRepeatMode(2);
        this.mChattingFromAnimationDrawable = new AnimationDrawable();
        Drawable drawable = getResources().getDrawable(R.drawable.ykfsdk_kf_chatfrom_voice_playing_f1);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mChattingFromAnimationDrawable.addFrame(drawable, this.mDuration);
        Drawable drawable2 = getResources().getDrawable(R.drawable.ykfsdk_kf_chatfrom_voice_playing_f2);
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        this.mChattingFromAnimationDrawable.addFrame(drawable2, this.mDuration);
        Drawable drawable3 = getResources().getDrawable(R.drawable.ykfsdk_kf_chatfrom_voice_playing_f3);
        drawable3.setBounds(0, 0, drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
        this.mChattingFromAnimationDrawable.addFrame(drawable3, this.mDuration);
        this.mChattingFromAnimationDrawable.setOneShot(false);
        this.mChattingFromAnimationDrawable.setVisible(true, true);
        this.mChattingToAnimationDrawable = new AnimationDrawable();
        Drawable drawable4 = getResources().getDrawable(R.drawable.ykfsdk_kf_chatto_voice_playing_f1);
        drawable4.setBounds(0, 0, drawable4.getIntrinsicWidth(), drawable4.getIntrinsicHeight());
        this.mChattingToAnimationDrawable.addFrame(drawable4, this.mDuration);
        Drawable drawable5 = getResources().getDrawable(R.drawable.ykfsdk_kf_chatto_voice_playing_f2);
        drawable5.setBounds(0, 0, drawable5.getIntrinsicWidth(), drawable5.getIntrinsicHeight());
        this.mChattingToAnimationDrawable.addFrame(drawable5, this.mDuration);
        Drawable drawable6 = getResources().getDrawable(R.drawable.ykfsdk_kf_chatto_voice_playing_f3);
        drawable6.setBounds(0, 0, drawable6.getIntrinsicWidth(), drawable6.getIntrinsicHeight());
        this.mChattingToAnimationDrawable.addFrame(drawable6, this.mDuration);
        this.mChattingToAnimationDrawable.setOneShot(false);
        this.mChattingToAnimationDrawable.setVisible(true, true);
    }

    public final void restBackground() {
        if (this.isFrom) {
            setBackgroundDrawable(getResources().getDrawable(R.drawable.ykfsdk_ykf_receive_msg_bg));
        } else {
            setBackgroundDrawable(getResources().getDrawable(R.drawable.ykfsdk_ykf_receive_msg_bg));
        }
    }

    public final void setVoiceFrom(boolean z) {
        this.isFrom = z;
    }

    public final void setVoiceType(int i2) {
        this.mVoiceType = i2;
    }

    public final void startVoiceAnimation() {
        int i2 = this.mVoiceType;
        if (i2 != 0) {
            if (i2 == 1 && !this.isRunning) {
                this.isRunning = true;
                if (this.isFrom) {
                    setCompoundDrawablesWithIntrinsicBounds(this.mChattingFromAnimationDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.mChattingFromAnimationDrawable.stop();
                    this.mChattingFromAnimationDrawable.start();
                    return;
                }
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mChattingToAnimationDrawable, (Drawable) null);
                this.mChattingToAnimationDrawable.stop();
                this.mChattingToAnimationDrawable.start();
                return;
            }
            return;
        }
        if (this.isFrom) {
            setBackgroundDrawable(this.mActivity.getResources().getDrawable(R.drawable.ykfsdk_ykf_receive_msg_bg));
        } else {
            setBackgroundDrawable(this.mActivity.getResources().getDrawable(R.drawable.ykfsdk_ykf_receive_msg_bg));
        }
        setAnimation(this.mAlphaAnimation);
        this.mAlphaAnimation.startNow();
    }

    public final void stopVoiceAnimation() {
        AlphaAnimation alphaAnimation = this.mAlphaAnimation;
        if (alphaAnimation != null && alphaAnimation.isInitialized()) {
            setAnimation(null);
        }
        if (this.mVoiceType != 1) {
            return;
        }
        this.isRunning = false;
        setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        setBackgroundDrawable(null);
        this.mChattingFromAnimationDrawable.stop();
        this.mChattingToAnimationDrawable.stop();
    }

    public VoiceAnimImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDuration = 300;
        this.mVoiceType = 1;
        this.isFrom = false;
        this.isRunning = false;
        this.mActivity = context;
        initAnimImageView();
    }

    public VoiceAnimImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mDuration = 300;
        this.mVoiceType = 1;
        this.isFrom = false;
        this.isRunning = false;
        this.mActivity = context;
        initAnimImageView();
    }
}
