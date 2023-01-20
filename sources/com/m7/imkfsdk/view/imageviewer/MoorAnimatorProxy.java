package com.m7.imkfsdk.view.imageviewer;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class MoorAnimatorProxy extends Animation {
    public static final boolean NEEDS_PROXY;
    private static final WeakHashMap<View, MoorAnimatorProxy> PROXIES;
    private boolean mHasPivot;
    private float mPivotX;
    private float mPivotY;
    private float mRotationX;
    private float mRotationY;
    private float mRotationZ;
    private float mTranslationX;
    private float mTranslationY;
    private final WeakReference<View> mView;
    private final Camera mCamera = new Camera();
    private final RectF mBefore = new RectF();
    private final RectF mAfter = new RectF();
    private final Matrix mTempMatrix = new Matrix();
    private float mAlpha = 1.0f;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;

    static {
        NEEDS_PROXY = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        PROXIES = new WeakHashMap<>();
    }

    private MoorAnimatorProxy(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.mView = new WeakReference<>(view);
    }

    private void computeRect(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.mTempMatrix;
        matrix.reset();
        transformMatrix(matrix, view);
        this.mTempMatrix.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        float f2 = rectF.right;
        float f3 = rectF.left;
        if (f2 < f3) {
            rectF.right = f3;
            rectF.left = f2;
        }
        float f4 = rectF.bottom;
        float f5 = rectF.top;
        if (f4 < f5) {
            rectF.top = f4;
            rectF.bottom = f5;
        }
    }

    private void invalidateAfterUpdate() {
        View view = this.mView.get();
        if (view == null || view.getParent() == null) {
            return;
        }
        RectF rectF = this.mAfter;
        computeRect(rectF, view);
        rectF.union(this.mBefore);
        ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void prepareForUpdate() {
        View view = this.mView.get();
        if (view != null) {
            computeRect(this.mBefore, view);
        }
    }

    private void transformMatrix(Matrix matrix, View view) {
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z = this.mHasPivot;
        float f2 = z ? this.mPivotX : width / 2.0f;
        float f3 = z ? this.mPivotY : height / 2.0f;
        float f4 = this.mRotationX;
        float f5 = this.mRotationY;
        float f6 = this.mRotationZ;
        if (f4 != 0.0f || f5 != 0.0f || f6 != 0.0f) {
            Camera camera = this.mCamera;
            camera.save();
            camera.rotateX(f4);
            camera.rotateY(f5);
            camera.rotateZ(-f6);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f2, -f3);
            matrix.postTranslate(f2, f3);
        }
        float f7 = this.mScaleX;
        float f8 = this.mScaleY;
        if (f7 != 1.0f || f8 != 1.0f) {
            matrix.postScale(f7, f8);
            matrix.postTranslate((-(f2 / width)) * ((f7 * width) - width), (-(f3 / height)) * ((f8 * height) - height));
        }
        matrix.postTranslate(this.mTranslationX, this.mTranslationY);
    }

    public static MoorAnimatorProxy wrap(View view) {
        WeakHashMap<View, MoorAnimatorProxy> weakHashMap = PROXIES;
        MoorAnimatorProxy moorAnimatorProxy = weakHashMap.get(view);
        if (moorAnimatorProxy == null || moorAnimatorProxy != view.getAnimation()) {
            MoorAnimatorProxy moorAnimatorProxy2 = new MoorAnimatorProxy(view);
            weakHashMap.put(view, moorAnimatorProxy2);
            return moorAnimatorProxy2;
        }
        return moorAnimatorProxy;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        View view = this.mView.get();
        if (view != null) {
            transformation.setAlpha(this.mAlpha);
            transformMatrix(transformation.getMatrix(), view);
        }
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getPivotX() {
        return this.mPivotX;
    }

    public float getPivotY() {
        return this.mPivotY;
    }

    public float getRotation() {
        return this.mRotationZ;
    }

    public float getRotationX() {
        return this.mRotationX;
    }

    public float getRotationY() {
        return this.mRotationY;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public int getScrollX() {
        View view = this.mView.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public int getScrollY() {
        View view = this.mView.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public float getTranslationX() {
        return this.mTranslationX;
    }

    public float getTranslationY() {
        return this.mTranslationY;
    }

    public float getX() {
        View view = this.mView.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getLeft() + this.mTranslationX;
    }

    public float getY() {
        View view = this.mView.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getTop() + this.mTranslationY;
    }

    public void setAlpha(float f2) {
        if (this.mAlpha != f2) {
            this.mAlpha = f2;
            View view = this.mView.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void setPivotX(float f2) {
        if (this.mHasPivot && this.mPivotX == f2) {
            return;
        }
        prepareForUpdate();
        this.mHasPivot = true;
        this.mPivotX = f2;
        invalidateAfterUpdate();
    }

    public void setPivotY(float f2) {
        if (this.mHasPivot && this.mPivotY == f2) {
            return;
        }
        prepareForUpdate();
        this.mHasPivot = true;
        this.mPivotY = f2;
        invalidateAfterUpdate();
    }

    public void setRotation(float f2) {
        if (this.mRotationZ != f2) {
            prepareForUpdate();
            this.mRotationZ = f2;
            invalidateAfterUpdate();
        }
    }

    public void setRotationX(float f2) {
        if (this.mRotationX != f2) {
            prepareForUpdate();
            this.mRotationX = f2;
            invalidateAfterUpdate();
        }
    }

    public void setRotationY(float f2) {
        if (this.mRotationY != f2) {
            prepareForUpdate();
            this.mRotationY = f2;
            invalidateAfterUpdate();
        }
    }

    public void setScaleX(float f2) {
        if (this.mScaleX != f2) {
            prepareForUpdate();
            this.mScaleX = f2;
            invalidateAfterUpdate();
        }
    }

    public void setScaleY(float f2) {
        if (this.mScaleY != f2) {
            prepareForUpdate();
            this.mScaleY = f2;
            invalidateAfterUpdate();
        }
    }

    public void setScrollX(int i2) {
        View view = this.mView.get();
        if (view != null) {
            view.scrollTo(i2, view.getScrollY());
        }
    }

    public void setScrollY(int i2) {
        View view = this.mView.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i2);
        }
    }

    public void setTranslationX(float f2) {
        if (this.mTranslationX != f2) {
            prepareForUpdate();
            this.mTranslationX = f2;
            invalidateAfterUpdate();
        }
    }

    public void setTranslationY(float f2) {
        if (this.mTranslationY != f2) {
            prepareForUpdate();
            this.mTranslationY = f2;
            invalidateAfterUpdate();
        }
    }

    public void setX(float f2) {
        View view = this.mView.get();
        if (view != null) {
            setTranslationX(f2 - view.getLeft());
        }
    }

    public void setY(float f2) {
        View view = this.mView.get();
        if (view != null) {
            setTranslationY(f2 - view.getTop());
        }
    }
}
