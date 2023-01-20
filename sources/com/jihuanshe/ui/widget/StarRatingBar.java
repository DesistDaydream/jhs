package com.jihuanshe.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RatingBar;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import com.jihuanshe.R;
import h.k2.h;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class StarRatingBar extends AppCompatRatingBar {
    private int a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f4238c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4239d;
    @e

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f4240e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final Shape f4241f;

    /* renamed from: g  reason: collision with root package name */
    private int f4242g;

    @h
    public StarRatingBar(@d Context context) {
        this(context, null, 0, 0, 0, 0, false, 126, null);
    }

    @h
    public StarRatingBar(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 0, 0, false, 124, null);
    }

    @h
    public StarRatingBar(@d Context context, @e AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0, 0, 0, false, 120, null);
    }

    @h
    public StarRatingBar(@d Context context, @e AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, 0, 0, false, 112, null);
    }

    @h
    public StarRatingBar(@d Context context, @e AttributeSet attributeSet, int i2, int i3, int i4) {
        this(context, attributeSet, i2, i3, i4, 0, false, 96, null);
    }

    @h
    public StarRatingBar(@d Context context, @e AttributeSet attributeSet, int i2, int i3, int i4, int i5) {
        this(context, attributeSet, i2, i3, i4, i5, false, 64, null);
    }

    public /* synthetic */ StarRatingBar(Context context, AttributeSet attributeSet, int i2, int i3, int i4, int i5, boolean z, int i6, u uVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? R.attr.ratingBarStyle : i2, (i6 & 8) != 0 ? 2 : i3, (i6 & 16) != 0 ? 0 : i4, (i6 & 32) == 0 ? i5 : 0, (i6 & 64) != 0 ? true : z);
    }

    private final BitmapDrawable a(Drawable drawable) {
        if (this.b == 0) {
            this.b = drawable.getIntrinsicHeight();
        }
        if (this.f4238c == 0) {
            this.f4238c = drawable.getIntrinsicWidth();
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.f4238c + (this.f4242g * 2), this.b, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int i2 = this.f4242g;
        drawable.setBounds(i2, 0, this.f4238c + i2, this.b);
        drawable.draw(canvas);
        return new BitmapDrawable(getResources(), createBitmap);
    }

    private final void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.StarRatingBar);
        setInnerPadding((int) obtainStyledAttributes.getDimension(2, getInnerPadding()));
        setDrawableHeight((int) obtainStyledAttributes.getDimension(0, 0.0f));
        setDrawableWidth((int) obtainStyledAttributes.getDimension(1, 0.0f));
        setCompensatingMarginActive(obtainStyledAttributes.getBoolean(3, true));
        obtainStyledAttributes.recycle();
    }

    @SuppressLint({"RestrictedApi"})
    private final Drawable d(Drawable drawable, boolean z) {
        if (drawable instanceof DrawableWrapper) {
            DrawableWrapper drawableWrapper = (DrawableWrapper) drawable;
            Drawable wrappedDrawable = drawableWrapper.getWrappedDrawable();
            if (wrappedDrawable != null) {
                drawableWrapper.setWrappedDrawable(d(wrappedDrawable, z));
            }
            return drawable;
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            int i2 = 0;
            if (numberOfLayers > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    int id = layerDrawable.getId(i3);
                    drawableArr[i3] = d(layerDrawable.getDrawable(i3), id == 16908301 || id == 16908303);
                    if (i4 >= numberOfLayers) {
                        break;
                    }
                    i3 = i4;
                }
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            if (numberOfLayers > 0) {
                while (true) {
                    int i5 = i2 + 1;
                    layerDrawable2.setId(i2, layerDrawable.getId(i2));
                    if (i5 >= numberOfLayers) {
                        break;
                    }
                    i2 = i5;
                }
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f4240e == null) {
                this.f4240e = bitmap;
            }
            BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
            ShapeDrawable shapeDrawable = new ShapeDrawable(this.f4241f);
            shapeDrawable.getPaint().setShader(bitmapShader);
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, GravityCompat.START, 1) : shapeDrawable;
        } else {
            return d(a(drawable), z);
        }
    }

    public final boolean c() {
        return this.f4239d;
    }

    public final int getDrawableHeight() {
        return this.b;
    }

    public final int getDrawableWidth() {
        return this.f4238c;
    }

    public final int getInnerPadding() {
        return this.a;
    }

    @Override // androidx.appcompat.widget.AppCompatRatingBar, android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i2, int i3) {
        int measuredHeight = getMeasuredHeight();
        int i4 = 1073741824;
        if (i3 != 1073741824) {
            measuredHeight = this.b;
        } else {
            i4 = i3;
        }
        super.onMeasure(i2, i4);
        Bitmap bitmap = this.f4240e;
        int i5 = 0;
        if (bitmap != null) {
            setMeasuredDimension(RatingBar.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i2, 0), RatingBar.resolveSizeAndState(measuredHeight, i3, 0));
        }
        if (this.f4239d) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            int marginStart = (layoutParams2 instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams2) : 0) - this.f4242g;
            ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
            int i6 = marginLayoutParams2 == null ? 0 : marginLayoutParams2.topMargin;
            ViewGroup.LayoutParams layoutParams4 = getLayoutParams();
            int marginEnd = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams4) : 0;
            ViewGroup.LayoutParams layoutParams5 = getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams5 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams5 : null;
            if (marginLayoutParams3 != null) {
                i5 = marginLayoutParams3.bottomMargin;
            }
            marginLayoutParams.setMargins(marginStart, i6, marginEnd, i5);
        }
    }

    public final void setCompensatingMarginActive(boolean z) {
        this.f4239d = z;
    }

    public final void setDrawableHeight(int i2) {
        this.b = i2;
    }

    public final void setDrawableWidth(int i2) {
        this.f4238c = i2;
    }

    public final void setInnerPadding(int i2) {
        this.a = i2;
    }

    @h
    public StarRatingBar(@d Context context, @e AttributeSet attributeSet, int i2, int i3, int i4, int i5, boolean z) {
        super(context, attributeSet, i2);
        this.a = i3;
        this.b = i4;
        this.f4238c = i5;
        this.f4239d = z;
        this.f4241f = new RectShape();
        if (attributeSet != null) {
            b(attributeSet);
        }
        this.f4242g = this.a / 2;
        setProgressDrawable((LayerDrawable) d(getProgressDrawable(), false));
    }
}
