package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import e.j.a.c.w.c;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class ClockFaceView extends RadialViewGroup implements ClockHandView.d {
    private static final float s = 0.001f;
    private static final int t = 12;
    private static final String u = "";

    /* renamed from: e */
    private final ClockHandView f3103e;

    /* renamed from: f */
    private final Rect f3104f;

    /* renamed from: g */
    private final RectF f3105g;

    /* renamed from: h */
    private final SparseArray<TextView> f3106h;

    /* renamed from: i */
    private final AccessibilityDelegateCompat f3107i;

    /* renamed from: j */
    private final int[] f3108j;

    /* renamed from: k */
    private final float[] f3109k;

    /* renamed from: l */
    private final int f3110l;

    /* renamed from: m */
    private final int f3111m;
    private final int n;
    private final int o;
    private String[] p;
    private float q;
    private final ColorStateList r;

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
            ClockFaceView.this = r1;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (ClockFaceView.this.isShown()) {
                ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                ClockFaceView.this.h(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f3103e.g()) - ClockFaceView.this.f3110l);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AccessibilityDelegateCompat {
        public b() {
            ClockFaceView.this = r1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int intValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
            if (intValue > 0) {
                accessibilityNodeInfoCompat.setTraversalAfter((View) ClockFaceView.this.f3106h.get(intValue - 1));
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, intValue, 1, false, view.isSelected()));
        }
    }

    public ClockFaceView(@NonNull Context context) {
        this(context, null);
    }

    private void o() {
        RectF d2 = this.f3103e.d();
        for (int i2 = 0; i2 < this.f3106h.size(); i2++) {
            TextView textView = this.f3106h.get(i2);
            if (textView != null) {
                textView.getDrawingRect(this.f3104f);
                this.f3104f.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.f3104f);
                this.f3105g.set(this.f3104f);
                textView.getPaint().setShader(p(d2, this.f3105g));
                textView.invalidate();
            }
        }
    }

    private RadialGradient p(RectF rectF, RectF rectF2) {
        if (RectF.intersects(rectF, rectF2)) {
            return new RadialGradient(rectF.centerX() - this.f3105g.left, rectF.centerY() - this.f3105g.top, rectF.width() * 0.5f, this.f3108j, this.f3109k, Shader.TileMode.CLAMP);
        }
        return null;
    }

    private static float q(float f2, float f3, float f4) {
        return Math.max(Math.max(f2, f3), f4);
    }

    private void r(@StringRes int i2) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.f3106h.size();
        for (int i3 = 0; i3 < Math.max(this.p.length, size); i3++) {
            TextView textView = this.f3106h.get(i3);
            if (i3 >= this.p.length) {
                removeView(textView);
                this.f3106h.remove(i3);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    this.f3106h.put(i3, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.p[i3]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i3));
                ViewCompat.setAccessibilityDelegate(textView, this.f3107i);
                textView.setTextColor(this.r);
                if (i2 != 0) {
                    textView.setContentDescription(getResources().getString(i2, this.p[i3]));
                }
            }
        }
    }

    public void c(String[] strArr, @StringRes int i2) {
        this.p = strArr;
        r(i2);
    }

    public void d(@FloatRange(from = 0.0d, to = 360.0d) float f2) {
        this.f3103e.l(f2);
        o();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void e(float f2, boolean z) {
        if (Math.abs(this.q - f2) > s) {
            this.q = f2;
            o();
        }
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void h(int i2) {
        if (i2 != g()) {
            super.h(i2);
            this.f3103e.k(g());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.p.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        o();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int q = (int) (this.o / q(this.f3111m / displayMetrics.heightPixels, this.n / displayMetrics.widthPixels, 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(q, 1073741824);
        setMeasuredDimension(q, q);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3104f = new Rect();
        this.f3105g = new RectF();
        this.f3106h = new SparseArray<>();
        this.f3109k = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockFaceView, i2, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList a2 = c.a(context, obtainStyledAttributes, R.styleable.ClockFaceView_clockNumberTextColor);
        this.r = a2;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.f3103e = clockHandView;
        this.f3110l = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = a2.getColorForState(new int[]{16842913}, a2.getDefaultColor());
        this.f3108j = new int[]{colorForState, colorForState, a2.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = AppCompatResources.getColorStateList(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList a3 = c.a(context, obtainStyledAttributes, R.styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(a3 != null ? a3.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.f3107i = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        c(strArr, 0);
        this.f3111m = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.n = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.o = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }
}
