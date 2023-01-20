package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import e.i.a.a.e;
import e.i.a.a.f;
import e.i.a.a.g;
import e.i.a.a.h;
import e.i.a.a.i;
import e.i.a.a.j;
import e.i.a.a.k;
import e.i.a.a.l;

/* loaded from: classes.dex */
public class PhotoView extends AppCompatImageView {
    private l a;
    private ImageView.ScaleType b;

    public PhotoView(Context context) {
        this(context, null);
    }

    private void init() {
        this.a = new l(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.b = null;
        }
    }

    public l getAttacher() {
        return this.a;
    }

    public void getDisplayMatrix(Matrix matrix) {
        this.a.D(matrix);
    }

    public RectF getDisplayRect() {
        return this.a.E();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.a.H();
    }

    public float getMaximumScale() {
        return this.a.K();
    }

    public float getMediumScale() {
        return this.a.L();
    }

    public float getMinimumScale() {
        return this.a.M();
    }

    public float getScale() {
        return this.a.N();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.a.O();
    }

    public void getSuppMatrix(Matrix matrix) {
        this.a.P(matrix);
    }

    public boolean isZoomable() {
        return this.a.S();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.a.U(z);
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        return this.a.W(matrix);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        if (frame) {
            this.a.update();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        l lVar = this.a;
        if (lVar != null) {
            lVar.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        l lVar = this.a;
        if (lVar != null) {
            lVar.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        l lVar = this.a;
        if (lVar != null) {
            lVar.update();
        }
    }

    public void setMaximumScale(float f2) {
        this.a.Y(f2);
    }

    public void setMediumScale(float f2) {
        this.a.Z(f2);
    }

    public void setMinimumScale(float f2) {
        this.a.a0(f2);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.a.b0(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.a.c0(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.a.d0(onLongClickListener);
    }

    public void setOnMatrixChangeListener(e eVar) {
        this.a.e0(eVar);
    }

    public void setOnOutsidePhotoTapListener(f fVar) {
        this.a.f0(fVar);
    }

    public void setOnPhotoTapListener(g gVar) {
        this.a.g0(gVar);
    }

    public void setOnScaleChangeListener(h hVar) {
        this.a.h0(hVar);
    }

    public void setOnSingleFlingListener(i iVar) {
        this.a.i0(iVar);
    }

    public void setOnViewDragListener(j jVar) {
        this.a.j0(jVar);
    }

    public void setOnViewTapListener(k kVar) {
        this.a.k0(kVar);
    }

    public void setRotationBy(float f2) {
        this.a.l0(f2);
    }

    public void setRotationTo(float f2) {
        this.a.m0(f2);
    }

    public void setScale(float f2) {
        this.a.n0(f2);
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        this.a.q0(f2, f3, f4);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        l lVar = this.a;
        if (lVar == null) {
            this.b = scaleType;
        } else {
            lVar.r0(scaleType);
        }
    }

    public boolean setSuppMatrix(Matrix matrix) {
        return this.a.W(matrix);
    }

    public void setZoomTransitionDuration(int i2) {
        this.a.t0(i2);
    }

    public void setZoomable(boolean z) {
        this.a.u0(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f2, boolean z) {
        this.a.p0(f2, z);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        this.a.o0(f2, f3, f4, z);
    }
}
