package com.m7.imkfsdk.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class AnimatedGifDrawable extends AnimationDrawable {
    private int mCurrentIndex = 0;
    private UpdateListener mListener;

    /* loaded from: classes2.dex */
    public interface UpdateListener {
        void update();
    }

    public AnimatedGifDrawable(InputStream inputStream, UpdateListener updateListener) {
        this.mListener = updateListener;
        GifDecoder gifDecoder = new GifDecoder();
        gifDecoder.read(inputStream);
        for (int i2 = 0; i2 < gifDecoder.getFrameCount(); i2++) {
            Bitmap frame = gifDecoder.getFrame(i2);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(frame);
            bitmapDrawable.setBounds(0, 0, frame.getWidth(), frame.getHeight());
            addFrame(bitmapDrawable, gifDecoder.getDelay(i2));
            if (i2 == 0) {
                setBounds(0, 0, frame.getWidth(), frame.getHeight());
            }
        }
    }

    public Drawable getDrawable() {
        return getFrame(this.mCurrentIndex);
    }

    public int getFrameDuration() {
        return getDuration(this.mCurrentIndex);
    }

    public void nextFrame() {
        this.mCurrentIndex = (this.mCurrentIndex + 1) % getNumberOfFrames();
        UpdateListener updateListener = this.mListener;
        if (updateListener != null) {
            updateListener.update();
        }
    }
}
