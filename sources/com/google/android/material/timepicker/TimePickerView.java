package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Locale;

/* loaded from: classes2.dex */
public class TimePickerView extends ConstraintLayout implements e.j.a.c.f0.f {
    private final Chip a;
    private final Chip b;

    /* renamed from: c  reason: collision with root package name */
    private final ClockHandView f3125c;

    /* renamed from: d  reason: collision with root package name */
    private final ClockFaceView f3126d;

    /* renamed from: e  reason: collision with root package name */
    private final MaterialButtonToggleGroup f3127e;

    /* renamed from: f  reason: collision with root package name */
    private final View.OnClickListener f3128f;

    /* renamed from: g  reason: collision with root package name */
    private f f3129g;

    /* renamed from: h  reason: collision with root package name */
    private g f3130h;

    /* renamed from: i  reason: collision with root package name */
    private e f3131i;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TimePickerView.this.f3130h != null) {
                TimePickerView.this.f3130h.d(((Integer) view.getTag(R.id.selection_type)).intValue());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements MaterialButtonToggleGroup.e {
        public b() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z) {
            int i3 = i2 == R.id.material_clock_period_pm_button ? 1 : 0;
            if (TimePickerView.this.f3129g == null || !z) {
                return;
            }
            TimePickerView.this.f3129g.c(i3);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            if (TimePickerView.this.f3131i != null) {
                TimePickerView.this.f3131i.a();
            }
            return onDoubleTap;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnTouchListener {
        public final /* synthetic */ GestureDetector a;

        public d(GestureDetector gestureDetector) {
            this.a = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface f {
        void c(int i2);
    }

    /* loaded from: classes2.dex */
    public interface g {
        void d(int i2);
    }

    public TimePickerView(Context context) {
        this(context, null);
    }

    private void r() {
        Chip chip = this.a;
        int i2 = R.id.selection_type;
        chip.setTag(i2, 12);
        this.b.setTag(i2, 10);
        this.a.setOnClickListener(this.f3128f);
        this.b.setOnClickListener(this.f3128f);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void s() {
        d dVar = new d(new GestureDetector(getContext(), new c()));
        this.a.setOnTouchListener(dVar);
        this.b.setOnTouchListener(dVar);
    }

    private void u() {
        if (this.f3127e.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            constraintSet.clear(R.id.material_clock_display, ViewCompat.getLayoutDirection(this) == 0 ? 2 : 1);
            constraintSet.applyTo(this);
        }
    }

    @Override // e.j.a.c.f0.f
    public void a(int i2) {
        this.a.setChecked(i2 == 12);
        this.b.setChecked(i2 == 10);
    }

    @Override // e.j.a.c.f0.f
    @SuppressLint({"DefaultLocale"})
    public void b(int i2, int i3, int i4) {
        this.f3127e.j(i2 == 1 ? R.id.material_clock_period_pm_button : R.id.material_clock_period_am_button);
        Locale locale = getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i4));
        String format2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
        this.a.setText(format);
        this.b.setText(format2);
    }

    @Override // e.j.a.c.f0.f
    public void c(String[] strArr, @StringRes int i2) {
        this.f3126d.c(strArr, i2);
    }

    @Override // e.j.a.c.f0.f
    public void d(float f2) {
        this.f3125c.l(f2);
    }

    public void i(ClockHandView.d dVar) {
        this.f3125c.b(dVar);
    }

    public void j(boolean z) {
        this.f3125c.j(z);
    }

    public void k(float f2, boolean z) {
        this.f3125c.m(f2, z);
    }

    public void l(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.a, accessibilityDelegateCompat);
    }

    public void m(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.b, accessibilityDelegateCompat);
    }

    public void n(ClockHandView.c cVar) {
        this.f3125c.o(cVar);
    }

    public void o(@Nullable e eVar) {
        this.f3131i = eVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        u();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (view == this && i2 == 0) {
            u();
        }
    }

    public void p(f fVar) {
        this.f3129g = fVar;
    }

    public void q(g gVar) {
        this.f3130h = gVar;
    }

    public void t() {
        this.f3127e.setVisibility(0);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3128f = new a();
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.f3126d = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.f3127e = materialButtonToggleGroup;
        materialButtonToggleGroup.g(new b());
        this.a = (Chip) findViewById(R.id.material_minute_tv);
        this.b = (Chip) findViewById(R.id.material_hour_tv);
        this.f3125c = (ClockHandView) findViewById(R.id.material_clock_hand);
        s();
        r();
    }
}
