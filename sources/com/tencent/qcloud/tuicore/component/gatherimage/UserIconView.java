package com.tencent.qcloud.tuicore.component.gatherimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qcloud.tuicore.R;
import java.util.List;

/* loaded from: classes3.dex */
public class UserIconView extends RelativeLayout {
    private int mDefaultImageResId;
    private int mIconRadius;
    private SynthesizedImageView mIconView;

    public UserIconView(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        RelativeLayout.inflate(getContext(), R.layout.profile_icon_view, this);
        if (attributeSet != null && (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.UserIconView)) != null) {
            this.mDefaultImageResId = obtainStyledAttributes.getResourceId(R.styleable.UserIconView_default_image, this.mDefaultImageResId);
            this.mIconRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.UserIconView_image_radius, this.mIconRadius);
            obtainStyledAttributes.recycle();
        }
        SynthesizedImageView synthesizedImageView = (SynthesizedImageView) findViewById(R.id.profile_icon);
        this.mIconView = synthesizedImageView;
        int i2 = this.mDefaultImageResId;
        if (i2 > 0) {
            synthesizedImageView.defaultImage(i2);
        }
        int i3 = this.mIconRadius;
        if (i3 > 0) {
            this.mIconView.setRadius(i3);
        }
    }

    public void setDefaultImageResId(int i2) {
        this.mDefaultImageResId = i2;
        this.mIconView.defaultImage(i2);
    }

    public void setIconUrls(List<Object> list) {
        this.mIconView.displayImage(list).load(null);
    }

    public void setRadius(int i2) {
        this.mIconRadius = i2;
        this.mIconView.setRadius(i2);
    }

    public UserIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public UserIconView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(attributeSet);
    }
}
