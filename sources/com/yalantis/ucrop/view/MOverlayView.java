package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import com.jihuanshe.R;

/* loaded from: classes3.dex */
public class MOverlayView extends OverlayView {
    public MOverlayView(Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attributeSet) {
        processStyledAttributes(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_UCropView));
    }

    public MOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MOverlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet);
    }
}
