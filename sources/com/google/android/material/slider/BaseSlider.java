package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.slider.BaseSlider;
import com.xiaomi.mipush.sdk.Constants;
import e.j.a.c.a0.a;
import e.j.a.c.a0.b;
import e.j.a.c.s.m;
import e.j.a.c.s.s;
import e.j.a.c.s.t;
import e.j.a.c.z.j;
import e.j.a.c.z.o;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends e.j.a.c.a0.a<S>, T extends e.j.a.c.a0.b<S>> extends View {
    public static final int G0 = 1;
    public static final int H0 = 0;
    private static final long I0 = 83;
    private static final long J0 = 117;
    private static final String d0 = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String e0 = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String f0 = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final String g0 = "valueTo(%s) must be greater than valueFrom(%s)";
    private static final String h0 = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String i0 = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.";
    private static final int j0 = 200;
    private static final int k0 = 63;
    private static final double l0 = 1.0E-4d;
    private int A;
    private float B;
    private MotionEvent C;
    private e.j.a.c.a0.d D;
    private boolean E;
    private float F;
    private float G;
    private ArrayList<Float> H;
    private int I;
    private int J;
    private float K;
    private float[] L;
    private boolean M;
    private int N;
    private boolean O;
    private boolean P;
    private boolean Q;
    @NonNull
    private ColorStateList R;
    @NonNull
    private ColorStateList S;
    @NonNull
    private ColorStateList T;
    @NonNull
    private ColorStateList U;
    @NonNull
    private ColorStateList V;
    @NonNull
    private final j W;
    @NonNull
    private final Paint a;
    private float a0;
    @NonNull
    private final Paint b;
    private int b0;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Paint f3021c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Paint f3022d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final Paint f3023e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final Paint f3024f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final e f3025g;

    /* renamed from: h  reason: collision with root package name */
    private final AccessibilityManager f3026h;

    /* renamed from: i  reason: collision with root package name */
    private BaseSlider<S, L, T>.d f3027i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final f f3028j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final List<e.j.a.c.g0.a> f3029k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final List<L> f3030l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final List<T> f3031m;
    private boolean n;
    private ValueAnimator o;
    private ValueAnimator p;
    private final int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;
    private static final String c0 = BaseSlider.class.getSimpleName();
    public static final int m0 = R.style.Widget_MaterialComponents_Slider;

    /* loaded from: classes2.dex */
    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();
        public boolean hasFocus;
        public float stepSize;
        public float valueFrom;
        public float valueTo;
        public ArrayList<Float> values;

        /* loaded from: classes2.dex */
        public static class a implements Parcelable.Creator<SliderState> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public SliderState createFromParcel(@NonNull Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: b */
            public SliderState[] newArray(int i2) {
                return new SliderState[i2];
            }
        }

        public /* synthetic */ SliderState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.valueFrom);
            parcel.writeFloat(this.valueTo);
            parcel.writeList(this.values);
            parcel.writeFloat(this.stepSize);
            parcel.writeBooleanArray(new boolean[]{this.hasFocus});
        }

        public SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(@NonNull Parcel parcel) {
            super(parcel);
            this.valueFrom = parcel.readFloat();
            this.valueTo = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.values = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.stepSize = parcel.readFloat();
            this.hasFocus = parcel.createBooleanArray()[0];
        }
    }

    /* loaded from: classes2.dex */
    public class a implements f {
        public final /* synthetic */ AttributeSet a;
        public final /* synthetic */ int b;

        public a(AttributeSet attributeSet, int i2) {
            this.a = attributeSet;
            this.b = i2;
        }

        @Override // com.google.android.material.slider.BaseSlider.f
        public e.j.a.c.g0.a a() {
            TypedArray j2 = m.j(BaseSlider.this.getContext(), this.a, R.styleable.Slider, this.b, BaseSlider.m0, new int[0]);
            e.j.a.c.g0.a X = BaseSlider.X(BaseSlider.this.getContext(), j2);
            j2.recycle();
            return X;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (e.j.a.c.g0.a aVar : BaseSlider.this.f3029k) {
                aVar.k1(floatValue);
            }
            ViewCompat.postInvalidateOnAnimation(BaseSlider.this);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            for (e.j.a.c.g0.a aVar : BaseSlider.this.f3029k) {
                t.g(BaseSlider.this).remove(aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends ExploreByTouchHelper {
        private final BaseSlider<?, ?, ?> a;
        public Rect b;

        public e(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.b = new Rect();
            this.a = baseSlider;
        }

        @NonNull
        private String a(int i2) {
            if (i2 == this.a.getValues().size() - 1) {
                return this.a.getContext().getString(R.string.material_slider_range_end);
            }
            return i2 == 0 ? this.a.getContext().getString(R.string.material_slider_range_start) : "";
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f2, float f3) {
            for (int i2 = 0; i2 < this.a.getValues().size(); i2++) {
                this.a.k0(i2, this.b);
                if (this.b.contains((int) f2, (int) f3)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i2 = 0; i2 < this.a.getValues().size(); i2++) {
                list.add(Integer.valueOf(i2));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle) {
            if (this.a.isEnabled()) {
                if (i3 == 4096 || i3 == 8192) {
                    float m2 = this.a.m(20);
                    if (i3 == 8192) {
                        m2 = -m2;
                    }
                    if (this.a.K()) {
                        m2 = -m2;
                    }
                    if (this.a.i0(i2, MathUtils.clamp(this.a.getValues().get(i2).floatValue() + m2, this.a.getValueFrom(), this.a.getValueTo()))) {
                        this.a.l0();
                        this.a.postInvalidate();
                        invalidateVirtualView(i2);
                        return true;
                    }
                    return false;
                }
                if (i3 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                    if (this.a.i0(i2, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                        this.a.l0();
                        this.a.postInvalidate();
                        invalidateVirtualView(i2);
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.a.getValues();
            float floatValue = values.get(i2).floatValue();
            float valueFrom = this.a.getValueFrom();
            float valueTo = this.a.getValueTo();
            if (this.a.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.a.getContentDescription() != null) {
                sb.append(this.a.getContentDescription());
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            if (values.size() > 1) {
                sb.append(a(i2));
                sb.append(this.a.D(floatValue));
            }
            accessibilityNodeInfoCompat.setContentDescription(sb.toString());
            this.a.k0(i2, this.b);
            accessibilityNodeInfoCompat.setBoundsInParent(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        e.j.a.c.g0.a a();
    }

    public BaseSlider(@NonNull Context context) {
        this(context, null);
    }

    private void A() {
        if (this.n) {
            this.n = false;
            ValueAnimator q = q(false);
            this.p = q;
            this.o = null;
            q.addListener(new c());
            this.p.start();
        }
    }

    private void B(int i2) {
        if (i2 == 1) {
            R(Integer.MAX_VALUE);
        } else if (i2 == 2) {
            R(Integer.MIN_VALUE);
        } else if (i2 == 17) {
            S(Integer.MAX_VALUE);
        } else if (i2 != 66) {
        } else {
            S(Integer.MIN_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String D(float f2) {
        if (H()) {
            return this.D.a(f2);
        }
        return String.format(((float) ((int) f2)) == f2 ? "%.0f" : "%.2f", Float.valueOf(f2));
    }

    private static float E(ValueAnimator valueAnimator, float f2) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f2;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return floatValue;
    }

    private float F(int i2, float f2) {
        float minSeparation = this.K == 0.0f ? getMinSeparation() : 0.0f;
        if (this.b0 == 0) {
            minSeparation = t(minSeparation);
        }
        if (K()) {
            minSeparation = -minSeparation;
        }
        int i3 = i2 + 1;
        int i4 = i2 - 1;
        return MathUtils.clamp(f2, i4 < 0 ? this.F : this.H.get(i4).floatValue() + minSeparation, i3 >= this.H.size() ? this.G : this.H.get(i3).floatValue() - minSeparation);
    }

    @ColorInt
    private int G(@NonNull ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private void I() {
        this.a.setStrokeWidth(this.v);
        this.b.setStrokeWidth(this.v);
        this.f3023e.setStrokeWidth(this.v / 2.0f);
        this.f3024f.setStrokeWidth(this.v / 2.0f);
    }

    private boolean J() {
        ViewParent parent = getParent();
        while (true) {
            boolean z = false;
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) ? true : true) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    private void M(@NonNull Resources resources) {
        this.t = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.r = dimensionPixelOffset;
        this.w = dimensionPixelOffset;
        this.s = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.x = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
        this.A = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
    }

    private void N() {
        if (this.K <= 0.0f) {
            return;
        }
        n0();
        int min = Math.min((int) (((this.G - this.F) / this.K) + 1.0f), (this.N / (this.v * 2)) + 1);
        float[] fArr = this.L;
        if (fArr == null || fArr.length != min * 2) {
            this.L = new float[min * 2];
        }
        float f2 = this.N / (min - 1);
        for (int i2 = 0; i2 < min * 2; i2 += 2) {
            float[] fArr2 = this.L;
            fArr2[i2] = this.w + ((i2 / 2) * f2);
            fArr2[i2 + 1] = n();
        }
    }

    private void O(@NonNull Canvas canvas, int i2, int i3) {
        if (f0()) {
            int T = (int) (this.w + (T(this.H.get(this.J).floatValue()) * i2));
            if (Build.VERSION.SDK_INT < 28) {
                int i4 = this.z;
                canvas.clipRect(T - i4, i3 - i4, T + i4, i4 + i3, Region.Op.UNION);
            }
            canvas.drawCircle(T, i3, this.z, this.f3022d);
        }
    }

    private void P(@NonNull Canvas canvas) {
        if (!this.M || this.K <= 0.0f) {
            return;
        }
        float[] activeRange = getActiveRange();
        int Z = Z(this.L, activeRange[0]);
        int Z2 = Z(this.L, activeRange[1]);
        int i2 = Z * 2;
        canvas.drawPoints(this.L, 0, i2, this.f3023e);
        int i3 = Z2 * 2;
        canvas.drawPoints(this.L, i2, i3 - i2, this.f3024f);
        float[] fArr = this.L;
        canvas.drawPoints(fArr, i3, fArr.length - i3, this.f3023e);
    }

    private void Q() {
        this.w = this.r + Math.max(this.y - this.s, 0);
        if (ViewCompat.isLaidOut(this)) {
            m0(getWidth());
        }
    }

    private boolean R(int i2) {
        int i3 = this.J;
        int clamp = (int) MathUtils.clamp(i3 + i2, 0L, this.H.size() - 1);
        this.J = clamp;
        if (clamp == i3) {
            return false;
        }
        if (this.I != -1) {
            this.I = clamp;
        }
        l0();
        postInvalidate();
        return true;
    }

    private boolean S(int i2) {
        if (K()) {
            i2 = i2 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i2;
        }
        return R(i2);
    }

    private float T(float f2) {
        float f3 = this.F;
        float f4 = (f2 - f3) / (this.G - f3);
        return K() ? 1.0f - f4 : f4;
    }

    private Boolean U(int i2, @NonNull KeyEvent keyEvent) {
        Boolean bool = Boolean.TRUE;
        if (i2 != 61) {
            if (i2 != 66) {
                if (i2 != 81) {
                    if (i2 == 69) {
                        R(-1);
                        return bool;
                    } else if (i2 != 70) {
                        switch (i2) {
                            case 21:
                                S(-1);
                                return bool;
                            case 22:
                                S(1);
                                return bool;
                            case 23:
                                break;
                            default:
                                return null;
                        }
                    }
                }
                R(1);
                return bool;
            }
            this.I = this.J;
            postInvalidate();
            return bool;
        } else if (keyEvent.hasNoModifiers()) {
            return Boolean.valueOf(R(1));
        } else {
            if (keyEvent.isShiftPressed()) {
                return Boolean.valueOf(R(-1));
            }
            return Boolean.FALSE;
        }
    }

    private void V() {
        for (T t : this.f3031m) {
            t.a(this);
        }
    }

    private void W() {
        for (T t : this.f3031m) {
            t.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static e.j.a.c.g0.a X(@NonNull Context context, @NonNull TypedArray typedArray) {
        return e.j.a.c.g0.a.U0(context, null, 0, typedArray.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
    }

    private static int Z(float[] fArr, float f2) {
        return Math.round(f2 * ((fArr.length / 2) - 1));
    }

    private void a0(Context context, AttributeSet attributeSet, int i2) {
        TypedArray j2 = m.j(context, attributeSet, R.styleable.Slider, i2, m0, new int[0]);
        this.F = j2.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.G = j2.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.F));
        this.K = j2.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        int i3 = R.styleable.Slider_trackColor;
        boolean hasValue = j2.hasValue(i3);
        int i4 = hasValue ? i3 : R.styleable.Slider_trackColorInactive;
        if (!hasValue) {
            i3 = R.styleable.Slider_trackColorActive;
        }
        ColorStateList a2 = e.j.a.c.w.c.a(context, j2, i4);
        if (a2 == null) {
            a2 = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(a2);
        ColorStateList a3 = e.j.a.c.w.c.a(context, j2, i3);
        if (a3 == null) {
            a3 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(a3);
        this.W.n0(e.j.a.c.w.c.a(context, j2, R.styleable.Slider_thumbColor));
        int i5 = R.styleable.Slider_thumbStrokeColor;
        if (j2.hasValue(i5)) {
            setThumbStrokeColor(e.j.a.c.w.c.a(context, j2, i5));
        }
        setThumbStrokeWidth(j2.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList a4 = e.j.a.c.w.c.a(context, j2, R.styleable.Slider_haloColor);
        if (a4 == null) {
            a4 = AppCompatResources.getColorStateList(context, R.color.material_slider_halo_color);
        }
        setHaloTintList(a4);
        this.M = j2.getBoolean(R.styleable.Slider_tickVisible, true);
        int i6 = R.styleable.Slider_tickColor;
        boolean hasValue2 = j2.hasValue(i6);
        int i7 = hasValue2 ? i6 : R.styleable.Slider_tickColorInactive;
        if (!hasValue2) {
            i6 = R.styleable.Slider_tickColorActive;
        }
        ColorStateList a5 = e.j.a.c.w.c.a(context, j2, i7);
        if (a5 == null) {
            a5 = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(a5);
        ColorStateList a6 = e.j.a.c.w.c.a(context, j2, i6);
        if (a6 == null) {
            a6 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(a6);
        setThumbRadius(j2.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(j2.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(j2.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(j2.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        this.u = j2.getInt(R.styleable.Slider_labelBehavior, 0);
        if (!j2.getBoolean(R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        j2.recycle();
    }

    private void d0(int i2) {
        BaseSlider<S, L, T>.d dVar = this.f3027i;
        if (dVar == null) {
            this.f3027i = new d(this, null);
        } else {
            removeCallbacks(dVar);
        }
        this.f3027i.a(i2);
        postDelayed(this.f3027i, 200L);
    }

    private void e0(e.j.a.c.g0.a aVar, float f2) {
        aVar.l1(D(f2));
        int T = (this.w + ((int) (T(f2) * this.N))) - (aVar.getIntrinsicWidth() / 2);
        int n = n() - (this.A + this.y);
        aVar.setBounds(T, n - aVar.getIntrinsicHeight(), aVar.getIntrinsicWidth() + T, n);
        Rect rect = new Rect(aVar.getBounds());
        e.j.a.c.s.c.c(t.f(this), this, rect);
        aVar.setBounds(rect);
        t.g(this).add(aVar);
    }

    private boolean f0() {
        return this.O || Build.VERSION.SDK_INT < 21 || !(getBackground() instanceof RippleDrawable);
    }

    private boolean g0(float f2) {
        return i0(this.I, f2);
    }

    private float[] getActiveRange() {
        float floatValue = ((Float) Collections.max(getValues())).floatValue();
        float floatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.H.size() == 1) {
            floatValue2 = this.F;
        }
        float T = T(floatValue2);
        float T2 = T(floatValue);
        return K() ? new float[]{T2, T} : new float[]{T, T2};
    }

    private float getValueOfTouchPosition() {
        double h02 = h0(this.a0);
        if (K()) {
            h02 = 1.0d - h02;
        }
        float f2 = this.G;
        float f3 = this.F;
        return (float) ((h02 * (f2 - f3)) + f3);
    }

    private float getValueOfTouchPositionAbsolute() {
        float f2 = this.a0;
        if (K()) {
            f2 = 1.0f - f2;
        }
        float f3 = this.G;
        float f4 = this.F;
        return (f2 * (f3 - f4)) + f4;
    }

    private double h0(float f2) {
        float f3 = this.K;
        if (f3 > 0.0f) {
            int i2 = (int) ((this.G - this.F) / f3);
            return Math.round(f2 * i2) / i2;
        }
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i0(int i2, float f2) {
        if (Math.abs(f2 - this.H.get(i2).floatValue()) < l0) {
            return false;
        }
        this.H.set(i2, Float.valueOf(F(i2, f2)));
        this.J = i2;
        u(i2);
        return true;
    }

    private void j(e.j.a.c.g0.a aVar) {
        aVar.j1(t.f(this));
    }

    private boolean j0() {
        return g0(getValueOfTouchPosition());
    }

    private Float k(int i2) {
        float m2 = this.P ? m(20) : l();
        if (i2 == 21) {
            if (!K()) {
                m2 = -m2;
            }
            return Float.valueOf(m2);
        } else if (i2 == 22) {
            if (K()) {
                m2 = -m2;
            }
            return Float.valueOf(m2);
        } else if (i2 != 69) {
            if (i2 == 70 || i2 == 81) {
                return Float.valueOf(m2);
            }
            return null;
        } else {
            return Float.valueOf(-m2);
        }
    }

    private float l() {
        float f2 = this.K;
        if (f2 == 0.0f) {
            return 1.0f;
        }
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        if (f0() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int T = (int) ((T(this.H.get(this.J).floatValue()) * this.N) + this.w);
            int n = n();
            int i2 = this.z;
            DrawableCompat.setHotspotBounds(background, T - i2, n - i2, T + i2, n + i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float m(int i2) {
        float f2;
        float f3;
        float l2 = l();
        return (this.G - this.F) / l2 <= i2 ? l2 : Math.round(f2 / f3) * l2;
    }

    private void m0(int i2) {
        this.N = Math.max(i2 - (this.w * 2), 0);
        N();
    }

    private int n() {
        return this.x + (this.u == 1 ? this.f3029k.get(0).getIntrinsicHeight() : 0);
    }

    private void n0() {
        if (this.Q) {
            p0();
            q0();
            o0();
            r0();
            u0();
            this.Q = false;
        }
    }

    private void o0() {
        if (this.K > 0.0f && !s0(this.G)) {
            throw new IllegalStateException(String.format(h0, Float.toString(this.K), Float.toString(this.F), Float.toString(this.G)));
        }
    }

    private void p0() {
        if (this.F >= this.G) {
            throw new IllegalStateException(String.format(f0, Float.toString(this.F), Float.toString(this.G)));
        }
    }

    private ValueAnimator q(boolean z) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(E(z ? this.p : this.o, z ? 0.0f : 1.0f), z ? 1.0f : 0.0f);
        ofFloat.setDuration(z ? I0 : J0);
        ofFloat.setInterpolator(z ? e.j.a.c.a.a.f10553e : e.j.a.c.a.a.f10551c);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    private void q0() {
        if (this.G <= this.F) {
            throw new IllegalStateException(String.format(g0, Float.toString(this.G), Float.toString(this.F)));
        }
    }

    private void r() {
        if (this.f3029k.size() > this.H.size()) {
            List<e.j.a.c.g0.a> subList = this.f3029k.subList(this.H.size(), this.f3029k.size());
            for (e.j.a.c.g0.a aVar : subList) {
                if (ViewCompat.isAttachedToWindow(this)) {
                    s(aVar);
                }
            }
            subList.clear();
        }
        while (this.f3029k.size() < this.H.size()) {
            e.j.a.c.g0.a a2 = this.f3028j.a();
            this.f3029k.add(a2);
            if (ViewCompat.isAttachedToWindow(this)) {
                j(a2);
            }
        }
        int i2 = this.f3029k.size() == 1 ? 0 : 1;
        for (e.j.a.c.g0.a aVar2 : this.f3029k) {
            aVar2.H0(i2);
        }
    }

    private void r0() {
        Iterator<Float> it = this.H.iterator();
        while (it.hasNext()) {
            Float next = it.next();
            if (next.floatValue() >= this.F && next.floatValue() <= this.G) {
                if (this.K > 0.0f && !s0(next.floatValue())) {
                    throw new IllegalStateException(String.format(e0, Float.toString(next.floatValue()), Float.toString(this.F), Float.toString(this.K), Float.toString(this.K)));
                }
            } else {
                throw new IllegalStateException(String.format(d0, Float.toString(next.floatValue()), Float.toString(this.F), Float.toString(this.G)));
            }
        }
    }

    private void s(e.j.a.c.g0.a aVar) {
        s g2 = t.g(this);
        if (g2 != null) {
            g2.remove(aVar);
            aVar.W0(t.f(this));
        }
    }

    private boolean s0(float f2) {
        double doubleValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Float.toString(this.F))).divide(new BigDecimal(Float.toString(this.K)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(doubleValue)) - doubleValue) < l0;
    }

    private void setValuesInternal(@NonNull ArrayList<Float> arrayList) {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.H.size() == arrayList.size() && this.H.equals(arrayList)) {
                return;
            }
            this.H = arrayList;
            this.Q = true;
            this.J = 0;
            l0();
            r();
            v();
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    private float t(float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        float f3 = (f2 - this.w) / this.N;
        float f4 = this.F;
        return (f3 * (f4 - this.G)) + f4;
    }

    private float t0(float f2) {
        return (T(f2) * this.N) + this.w;
    }

    private void u(int i2) {
        for (L l2 : this.f3030l) {
            l2.a(this, this.H.get(i2).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.f3026h;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        d0(i2);
    }

    private void u0() {
        float f2 = this.K;
        if (f2 == 0.0f) {
            return;
        }
        if (((int) f2) != f2) {
            Log.w(c0, String.format(i0, "stepSize", Float.valueOf(f2)));
        }
        float f3 = this.F;
        if (((int) f3) != f3) {
            Log.w(c0, String.format(i0, "valueFrom", Float.valueOf(f3)));
        }
        float f4 = this.G;
        if (((int) f4) != f4) {
            Log.w(c0, String.format(i0, "valueTo", Float.valueOf(f4)));
        }
    }

    private void v() {
        for (L l2 : this.f3030l) {
            Iterator<Float> it = this.H.iterator();
            while (it.hasNext()) {
                l2.a(this, it.next().floatValue(), false);
            }
        }
    }

    private void w(@NonNull Canvas canvas, int i2, int i3) {
        float[] activeRange = getActiveRange();
        int i4 = this.w;
        float f2 = i2;
        float f3 = i3;
        canvas.drawLine(i4 + (activeRange[0] * f2), f3, i4 + (activeRange[1] * f2), f3, this.b);
    }

    private void x(@NonNull Canvas canvas, int i2, int i3) {
        int i4;
        float[] activeRange = getActiveRange();
        float f2 = i2;
        float f3 = this.w + (activeRange[1] * f2);
        if (f3 < i4 + i2) {
            float f4 = i3;
            canvas.drawLine(f3, f4, i4 + i2, f4, this.a);
        }
        int i5 = this.w;
        float f5 = i5 + (activeRange[0] * f2);
        if (f5 > i5) {
            float f6 = i3;
            canvas.drawLine(i5, f6, f5, f6, this.a);
        }
    }

    private void y(@NonNull Canvas canvas, int i2, int i3) {
        if (!isEnabled()) {
            Iterator<Float> it = this.H.iterator();
            while (it.hasNext()) {
                canvas.drawCircle(this.w + (T(it.next().floatValue()) * i2), i3, this.y, this.f3021c);
            }
        }
        Iterator<Float> it2 = this.H.iterator();
        while (it2.hasNext()) {
            canvas.save();
            int T = this.w + ((int) (T(it2.next().floatValue()) * i2));
            int i4 = this.y;
            canvas.translate(T - i4, i3 - i4);
            this.W.draw(canvas);
            canvas.restore();
        }
    }

    private void z() {
        if (this.u == 2) {
            return;
        }
        if (!this.n) {
            this.n = true;
            ValueAnimator q = q(true);
            this.o = q;
            this.p = null;
            q.start();
        }
        Iterator<e.j.a.c.g0.a> it = this.f3029k.iterator();
        for (int i2 = 0; i2 < this.H.size() && it.hasNext(); i2++) {
            if (i2 != this.J) {
                e0(it.next(), this.H.get(i2).floatValue());
            }
        }
        if (it.hasNext()) {
            e0(it.next(), this.H.get(this.J).floatValue());
            return;
        }
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.f3029k.size()), Integer.valueOf(this.H.size())));
    }

    @VisibleForTesting
    public void C(boolean z) {
        this.O = z;
    }

    public boolean H() {
        return this.D != null;
    }

    public final boolean K() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public boolean L() {
        return this.M;
    }

    public boolean Y() {
        if (this.I != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float t0 = t0(valueOfTouchPositionAbsolute);
        this.I = 0;
        float abs = Math.abs(this.H.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i2 = 1; i2 < this.H.size(); i2++) {
            float abs2 = Math.abs(this.H.get(i2).floatValue() - valueOfTouchPositionAbsolute);
            float t02 = t0(this.H.get(i2).floatValue());
            if (Float.compare(abs2, abs) > 1) {
                break;
            }
            boolean z = !K() ? t02 - t0 >= 0.0f : t02 - t0 <= 0.0f;
            if (Float.compare(abs2, abs) < 0) {
                this.I = i2;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else if (Math.abs(t02 - t0) < this.q) {
                    this.I = -1;
                    return false;
                } else if (z) {
                    this.I = i2;
                }
            }
            abs = abs2;
        }
        return this.I != -1;
    }

    public void b0(@NonNull L l2) {
        this.f3030l.remove(l2);
    }

    public void c0(@NonNull T t) {
        this.f3031m.remove(t);
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return this.f3025g.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.setColor(G(this.V));
        this.b.setColor(G(this.U));
        this.f3023e.setColor(G(this.T));
        this.f3024f.setColor(G(this.S));
        for (e.j.a.c.g0.a aVar : this.f3029k) {
            if (aVar.isStateful()) {
                aVar.setState(getDrawableState());
            }
        }
        if (this.W.isStateful()) {
            this.W.setState(getDrawableState());
        }
        this.f3022d.setColor(G(this.R));
        this.f3022d.setAlpha(63);
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f3025g.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.I;
    }

    public int getFocusedThumbIndex() {
        return this.J;
    }

    @Dimension
    public int getHaloRadius() {
        return this.z;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.R;
    }

    public int getLabelBehavior() {
        return this.u;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.K;
    }

    public float getThumbElevation() {
        return this.W.x();
    }

    @Dimension
    public int getThumbRadius() {
        return this.y;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.W.M();
    }

    public float getThumbStrokeWidth() {
        return this.W.P();
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.W.y();
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.S;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.T;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.T.equals(this.S)) {
            return this.S;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.U;
    }

    @Dimension
    public int getTrackHeight() {
        return this.v;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.V;
    }

    @Dimension
    public int getTrackSidePadding() {
        return this.w;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.V.equals(this.U)) {
            return this.U;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Dimension
    public int getTrackWidth() {
        return this.N;
    }

    public float getValueFrom() {
        return this.F;
    }

    public float getValueTo() {
        return this.G;
    }

    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.H);
    }

    public void h(@Nullable L l2) {
        this.f3030l.add(l2);
    }

    public void i(@NonNull T t) {
        this.f3031m.add(t);
    }

    public void k0(int i2, Rect rect) {
        int T = this.w + ((int) (T(getValues().get(i2).floatValue()) * this.N));
        int n = n();
        int i3 = this.y;
        rect.set(T - i3, n - i3, T + i3, n + i3);
    }

    public void o() {
        this.f3030l.clear();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (e.j.a.c.g0.a aVar : this.f3029k) {
            j(aVar);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.d dVar = this.f3027i;
        if (dVar != null) {
            removeCallbacks(dVar);
        }
        this.n = false;
        for (e.j.a.c.g0.a aVar : this.f3029k) {
            s(aVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        if (this.Q) {
            n0();
            N();
        }
        super.onDraw(canvas);
        int n = n();
        x(canvas, this.N, n);
        if (((Float) Collections.max(getValues())).floatValue() > this.F) {
            w(canvas, this.N, n);
        }
        P(canvas);
        if ((this.E || isFocused()) && isEnabled()) {
            O(canvas, this.N, n);
            if (this.I != -1) {
                z();
            }
        }
        y(canvas, this.N, n);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, @Nullable Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (!z) {
            this.I = -1;
            A();
            this.f3025g.clearKeyboardFocusForVirtualView(this.J);
            return;
        }
        B(i2);
        this.f3025g.requestKeyboardFocusForVirtualView(this.J);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @NonNull KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.H.size() == 1) {
            this.I = 0;
        }
        if (this.I == -1) {
            Boolean U = U(i2, keyEvent);
            return U != null ? U.booleanValue() : super.onKeyDown(i2, keyEvent);
        }
        this.P |= keyEvent.isLongPress();
        Float k2 = k(i2);
        if (k2 != null) {
            if (g0(this.H.get(this.I).floatValue() + k2.floatValue())) {
                l0();
                postInvalidate();
            }
            return true;
        }
        if (i2 != 23) {
            if (i2 == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return R(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return R(-1);
                }
                return false;
            } else if (i2 != 66) {
                return super.onKeyDown(i2, keyEvent);
            }
        }
        this.I = -1;
        A();
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, @NonNull KeyEvent keyEvent) {
        this.P = false;
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.t + (this.u == 1 ? this.f3029k.get(0).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.F = sliderState.valueFrom;
        this.G = sliderState.valueTo;
        setValuesInternal(sliderState.values);
        this.K = sliderState.stepSize;
        if (sliderState.hasFocus) {
            requestFocus();
        }
        v();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.valueFrom = this.F;
        sliderState.valueTo = this.G;
        sliderState.values = new ArrayList<>(this.H);
        sliderState.stepSize = this.K;
        sliderState.hasFocus = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        m0(i2);
        l0();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (isEnabled()) {
            float x = motionEvent.getX();
            float f2 = (x - this.w) / this.N;
            this.a0 = f2;
            float max = Math.max(0.0f, f2);
            this.a0 = max;
            this.a0 = Math.min(1.0f, max);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.B = x;
                if (!J()) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (Y()) {
                        requestFocus();
                        this.E = true;
                        j0();
                        l0();
                        invalidate();
                        V();
                    }
                }
            } else if (actionMasked == 1) {
                this.E = false;
                MotionEvent motionEvent2 = this.C;
                if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.C.getX() - motionEvent.getX()) <= this.q && Math.abs(this.C.getY() - motionEvent.getY()) <= this.q && Y()) {
                    V();
                }
                if (this.I != -1) {
                    j0();
                    this.I = -1;
                    W();
                }
                A();
                invalidate();
            } else if (actionMasked == 2) {
                if (!this.E) {
                    if (J() && Math.abs(x - this.B) < this.q) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    V();
                }
                if (Y()) {
                    this.E = true;
                    j0();
                    l0();
                    invalidate();
                }
            }
            setPressed(this.E);
            this.C = MotionEvent.obtain(motionEvent);
            return true;
        }
        return false;
    }

    public void p() {
        this.f3031m.clear();
    }

    public void setActiveThumbIndex(int i2) {
        this.I = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i2) {
        if (i2 >= 0 && i2 < this.H.size()) {
            this.J = i2;
            this.f3025g.requestKeyboardFocusForVirtualView(i2);
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("index out of range");
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int i2) {
        if (i2 == this.z) {
            return;
        }
        this.z = i2;
        Drawable background = getBackground();
        if (!f0() && (background instanceof RippleDrawable)) {
            e.j.a.c.o.a.b((RippleDrawable) background, this.z);
        } else {
            postInvalidate();
        }
    }

    public void setHaloRadiusResource(@DimenRes int i2) {
        setHaloRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.R)) {
            return;
        }
        this.R = colorStateList;
        Drawable background = getBackground();
        if (!f0() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.f3022d.setColor(G(colorStateList));
        this.f3022d.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i2) {
        if (this.u != i2) {
            this.u = i2;
            requestLayout();
        }
    }

    public void setLabelFormatter(@Nullable e.j.a.c.a0.d dVar) {
        this.D = dVar;
    }

    public void setSeparationUnit(int i2) {
        this.b0 = i2;
    }

    public void setStepSize(float f2) {
        if (f2 >= 0.0f) {
            if (this.K != f2) {
                this.K = f2;
                this.Q = true;
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format(h0, Float.toString(f2), Float.toString(this.F), Float.toString(this.G)));
    }

    public void setThumbElevation(float f2) {
        this.W.m0(f2);
    }

    public void setThumbElevationResource(@DimenRes int i2) {
        setThumbElevation(getResources().getDimension(i2));
    }

    public void setThumbRadius(@IntRange(from = 0) @Dimension int i2) {
        if (i2 == this.y) {
            return;
        }
        this.y = i2;
        Q();
        this.W.setShapeAppearanceModel(o.a().q(0, this.y).m());
        j jVar = this.W;
        int i3 = this.y;
        jVar.setBounds(0, 0, i3 * 2, i3 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(@DimenRes int i2) {
        setThumbRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        this.W.E0(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int i2) {
        if (i2 != 0) {
            setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setThumbStrokeWidth(float f2) {
        this.W.H0(f2);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int i2) {
        if (i2 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i2));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.W.y())) {
            return;
        }
        this.W.n0(colorStateList);
        invalidate();
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.S)) {
            return;
        }
        this.S = colorStateList;
        this.f3024f.setColor(G(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.T)) {
            return;
        }
        this.T = colorStateList;
        this.f3023e.setColor(G(colorStateList));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z) {
        if (this.M != z) {
            this.M = z;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.U)) {
            return;
        }
        this.U = colorStateList;
        this.b.setColor(G(colorStateList));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int i2) {
        if (this.v != i2) {
            this.v = i2;
            I();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.V)) {
            return;
        }
        this.V = colorStateList;
        this.a.setColor(G(colorStateList));
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f2) {
        this.F = f2;
        this.Q = true;
        postInvalidate();
    }

    public void setValueTo(float f2) {
        this.G = f2;
        this.Q = true;
        postInvalidate();
    }

    public void setValues(@NonNull Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public int a;

        private d() {
            this.a = -1;
        }

        public void a(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.f3025g.sendEventForVirtualView(this.a, 4);
        }

        public /* synthetic */ d(BaseSlider baseSlider, a aVar) {
            this();
        }
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(e.j.a.c.e0.a.a.c(context, attributeSet, i2, m0), attributeSet, i2);
        this.f3029k = new ArrayList();
        this.f3030l = new ArrayList();
        this.f3031m = new ArrayList();
        this.n = false;
        this.E = false;
        this.H = new ArrayList<>();
        this.I = -1;
        this.J = -1;
        this.K = 0.0f;
        this.M = true;
        this.P = false;
        j jVar = new j();
        this.W = jVar;
        this.b0 = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.a = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.f3021c = paint3;
        paint3.setStyle(Paint.Style.FILL);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.f3022d = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.f3023e = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.f3024f = paint6;
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeCap(Paint.Cap.ROUND);
        M(context2.getResources());
        this.f3028j = new a(attributeSet, i2);
        a0(context2, attributeSet, i2);
        setFocusable(true);
        setClickable(true);
        jVar.w0(2);
        this.q = ViewConfiguration.get(context2).getScaledTouchSlop();
        e eVar = new e(this);
        this.f3025g = eVar;
        ViewCompat.setAccessibilityDelegate(this, eVar);
        this.f3026h = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public void setValues(@NonNull List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }
}
