package com.tencent.qcloud.tuicore.component.gatherimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.R;
import java.util.List;

/* loaded from: classes3.dex */
public class SynthesizedImageView extends ShadeImageView {
    public int defaultImageResId;
    public int imageGap;
    public int imageSize;
    public int synthesizedBg;
    public TeamHeadSynthesizer teamHeadSynthesizer;

    public SynthesizedImageView(Context context) {
        super(context);
        this.imageSize = 109;
        this.synthesizedBg = Color.parseColor("#cfd3d8");
        this.defaultImageResId = 0;
        this.imageGap = 6;
        init(context);
    }

    private void init(Context context) {
        TeamHeadSynthesizer teamHeadSynthesizer = new TeamHeadSynthesizer(context, this);
        this.teamHeadSynthesizer = teamHeadSynthesizer;
        int i2 = this.imageSize;
        teamHeadSynthesizer.setMaxWidthHeight(i2, i2);
        this.teamHeadSynthesizer.setDefaultImage(this.defaultImageResId);
        this.teamHeadSynthesizer.setBgColor(this.synthesizedBg);
        this.teamHeadSynthesizer.setGap(this.imageGap);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SynthesizedImageView);
        if (obtainStyledAttributes != null) {
            this.synthesizedBg = obtainStyledAttributes.getColor(R.styleable.SynthesizedImageView_synthesized_image_bg, this.synthesizedBg);
            this.defaultImageResId = obtainStyledAttributes.getResourceId(R.styleable.SynthesizedImageView_synthesized_default_image, this.defaultImageResId);
            this.imageSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SynthesizedImageView_synthesized_image_size, this.imageSize);
            this.imageGap = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SynthesizedImageView_synthesized_image_gap, this.imageGap);
            obtainStyledAttributes.recycle();
        }
    }

    public void clear() {
        this.teamHeadSynthesizer.clearImage();
    }

    public SynthesizedImageView defaultImage(int i2) {
        this.teamHeadSynthesizer.setDefaultImage(i2);
        return this;
    }

    public SynthesizedImageView displayImage(List<Object> list) {
        this.teamHeadSynthesizer.getMultiImageData().setImageUrls(list);
        return this;
    }

    public void load(String str) {
        this.teamHeadSynthesizer.load(str);
    }

    public void setImageId(String str) {
        this.teamHeadSynthesizer.setImageId(str);
    }

    public SynthesizedImageView synthesizedWidthHeight(int i2, int i3) {
        this.teamHeadSynthesizer.setMaxWidthHeight(i2, i3);
        return this;
    }

    public SynthesizedImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.imageSize = 109;
        this.synthesizedBg = Color.parseColor("#cfd3d8");
        this.defaultImageResId = 0;
        this.imageGap = 6;
        initAttrs(attributeSet);
        init(context);
    }

    public SynthesizedImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.imageSize = 109;
        this.synthesizedBg = Color.parseColor("#cfd3d8");
        this.defaultImageResId = 0;
        this.imageGap = 6;
        initAttrs(attributeSet);
        init(context);
    }
}
