package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.crop.MCropView;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;

/* loaded from: classes3.dex */
public class MUCropView extends FrameLayout {
    private MCropView mGestureCropImageView;
    private final OverlayView mViewOverlay;

    public MUCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setListenersToViews() {
        this.mGestureCropImageView.setCropBoundsChangeListener(new CropBoundsChangeListener() { // from class: com.yalantis.ucrop.view.MUCropView.1
            @Override // com.yalantis.ucrop.callback.CropBoundsChangeListener
            public void onCropAspectRatioChanged(float f2) {
                MUCropView.this.mViewOverlay.setTargetAspectRatio(f2);
            }
        });
        this.mViewOverlay.setOverlayViewChangeListener(new OverlayViewChangeListener() { // from class: com.yalantis.ucrop.view.MUCropView.2
            @Override // com.yalantis.ucrop.callback.OverlayViewChangeListener
            public void onCropRectUpdated(RectF rectF) {
                MUCropView.this.mGestureCropImageView.setCropRect(rectF);
            }
        });
    }

    @NonNull
    public MCropView getCropImageView() {
        return this.mGestureCropImageView;
    }

    @NonNull
    public OverlayView getOverlayView() {
        return this.mViewOverlay;
    }

    public void resetCropImageView() {
        removeView(this.mGestureCropImageView);
        this.mGestureCropImageView = new MCropView(getContext());
        setListenersToViews();
        this.mGestureCropImageView.setCropRect(getOverlayView().getCropViewRect());
        addView(this.mGestureCropImageView, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public MUCropView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(context).inflate(R.layout.mcrop_view, (ViewGroup) this, true);
        this.mGestureCropImageView = (MCropView) findViewById(R.id.image_view_crop);
        OverlayView overlayView = (OverlayView) findViewById(R.id.view_overlay);
        this.mViewOverlay = overlayView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_UCropView);
        overlayView.processStyledAttributes(obtainStyledAttributes);
        this.mGestureCropImageView.processStyledAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        setListenersToViews();
    }
}
