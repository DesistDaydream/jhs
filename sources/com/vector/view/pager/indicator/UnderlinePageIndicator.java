package com.vector.view.pager.indicator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.vector.R;
import com.vector.view.pager.ViewPager2;
import com.vector.view.pager.indicator.UnderlinePageIndicator;
import e.t.v.h.d.c;

/* loaded from: classes3.dex */
public class UnderlinePageIndicator extends View implements c {
    private static final int r = -1;
    private static final int s = 30;
    private final Paint a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f8007c;

    /* renamed from: d  reason: collision with root package name */
    private int f8008d;

    /* renamed from: e  reason: collision with root package name */
    private int f8009e;

    /* renamed from: f  reason: collision with root package name */
    private ViewPager f8010f;

    /* renamed from: g  reason: collision with root package name */
    private ViewPager.OnPageChangeListener f8011g;

    /* renamed from: h  reason: collision with root package name */
    private int f8012h;

    /* renamed from: i  reason: collision with root package name */
    private int f8013i;

    /* renamed from: j  reason: collision with root package name */
    private float f8014j;

    /* renamed from: k  reason: collision with root package name */
    private int f8015k;

    /* renamed from: l  reason: collision with root package name */
    private float f8016l;

    /* renamed from: m  reason: collision with root package name */
    private int f8017m;
    private boolean n;
    private int o;
    private Boolean p;
    private final Runnable q;

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int currentPage;

        /* loaded from: classes3.dex */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (a) null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.currentPage);
        }

        public /* synthetic */ SavedState(Parcelable parcelable, a aVar) {
            this(parcelable);
        }

        private SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentPage = parcel.readInt();
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (UnderlinePageIndicator.this.b) {
                int max = Math.max(UnderlinePageIndicator.this.a.getAlpha() - UnderlinePageIndicator.this.f8009e, 0);
                UnderlinePageIndicator.this.invalidate();
                if (max > 0) {
                    UnderlinePageIndicator.this.postDelayed(this, 30L);
                }
            }
        }
    }

    public UnderlinePageIndicator(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h() {
        if (this.b) {
            post(this.q);
        }
    }

    @Override // e.t.v.h.d.c
    public void a(ViewPager2 viewPager2, int i2) {
    }

    @Override // e.t.v.h.d.c
    public void b(ViewPager viewPager, int i2) {
        setViewPager(viewPager);
        setCurrentItem(i2);
    }

    @Override // e.t.v.h.d.c
    public void e() {
        invalidate();
    }

    public int getFadeDelay() {
        return this.f8007c;
    }

    public int getFadeLength() {
        return this.f8008d;
    }

    public boolean getFades() {
        return this.b;
    }

    public int getSelectedColor() {
        return this.a.getColor();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f8010f;
        if (viewPager != null) {
            viewPager.clearOnPageChangeListeners();
            this.f8010f = null;
        }
        if (this.f8011g != null) {
            this.f8011g = null;
        }
        removeCallbacks(this.q);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int count;
        super.onDraw(canvas);
        ViewPager viewPager = this.f8010f;
        if (viewPager == null || viewPager.getAdapter() == null || (count = this.f8010f.getAdapter().getCount()) == 0) {
            return;
        }
        if (this.f8013i >= count) {
            setCurrentItem(count - 1);
            return;
        }
        int paddingLeft = getPaddingLeft();
        float width = ((getWidth() - paddingLeft) - getPaddingRight()) / (count * 1.0f);
        int i2 = this.o;
        float f2 = (i2 == 0 || ((float) i2) >= width) ? 0.0f : (width - i2) / 2.0f;
        if (Float.isNaN(this.f8014j)) {
            this.f8014j = 0.0f;
        }
        float f3 = paddingLeft + ((this.f8013i + this.f8014j) * width) + f2;
        float f4 = (width + f3) - (f2 * 2.0f);
        float paddingTop = getPaddingTop();
        float height = getHeight() - getPaddingBottom();
        if (this.p.booleanValue()) {
            canvas.drawRoundRect(f3, paddingTop, f4, height, getHeight() / 2.0f, getHeight() / 2.0f, this.a);
        } else {
            canvas.drawRect(f3, paddingTop, f4, height, this.a);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        this.f8012h = i2;
        ViewPager.OnPageChangeListener onPageChangeListener = this.f8011g;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        this.f8013i = i2;
        this.f8014j = f2;
        if (this.b) {
            if (i3 > 0) {
                removeCallbacks(this.q);
                this.a.setAlpha(255);
            } else if (this.f8012h != 1) {
                postDelayed(this.q, this.f8007c);
            }
        }
        invalidate();
        ViewPager.OnPageChangeListener onPageChangeListener = this.f8011g;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i2, f2, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        if (this.f8012h == 0) {
            this.f8013i = i2;
            this.f8014j = 0.0f;
            invalidate();
            this.q.run();
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.f8011g;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i2);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f8013i = savedState.currentPage;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState(), (a) null);
        savedState.currentPage = this.f8013i;
        return savedState;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter adapter;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        ViewPager viewPager = this.f8010f;
        if (viewPager == null || (adapter = viewPager.getAdapter()) == null || adapter.getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX(motionEvent.findPointerIndex(this.f8017m));
                    float f2 = x - this.f8016l;
                    if (!this.n && Math.abs(f2) > this.f8015k) {
                        this.n = true;
                    }
                    if (this.n) {
                        this.f8016l = x;
                        if (this.f8010f.isFakeDragging() || this.f8010f.beginFakeDrag()) {
                            this.f8010f.fakeDragBy(f2);
                        }
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.f8016l = motionEvent.getX(actionIndex);
                        this.f8017m = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        int actionIndex2 = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex2) == this.f8017m) {
                            this.f8017m = motionEvent.getPointerId(actionIndex2 == 0 ? 1 : 0);
                        }
                        this.f8016l = motionEvent.getX(motionEvent.findPointerIndex(this.f8017m));
                    }
                }
            }
            if (!this.n) {
                int count = this.f8010f.getAdapter().getCount();
                float width = getWidth();
                float f3 = width / 2.0f;
                float f4 = width / 6.0f;
                if (this.f8013i > 0 && motionEvent.getX() < f3 - f4) {
                    if (action != 3) {
                        this.f8010f.setCurrentItem(this.f8013i - 1);
                    }
                    return true;
                } else if (this.f8013i < count - 1 && motionEvent.getX() > f3 + f4) {
                    if (action != 3) {
                        this.f8010f.setCurrentItem(this.f8013i + 1);
                    }
                    return true;
                }
            }
            this.n = false;
            this.f8017m = -1;
            if (this.f8010f.isFakeDragging()) {
                this.f8010f.endFakeDrag();
            }
        } else {
            this.f8017m = motionEvent.getPointerId(0);
            this.f8016l = motionEvent.getX();
        }
        return true;
    }

    public void setCorner(Boolean bool) {
        this.p = bool;
    }

    @Override // e.t.v.h.d.c
    public void setCurrentItem(int i2) {
        ViewPager viewPager = this.f8010f;
        if (viewPager != null) {
            viewPager.setCurrentItem(i2);
            this.f8013i = i2;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void setFadeDelay(int i2) {
        this.f8007c = i2;
    }

    public void setFadeLength(int i2) {
        this.f8008d = i2;
        this.f8009e = 255 / (i2 / 30);
    }

    public void setFades(boolean z) {
        if (z != this.b) {
            this.b = z;
            if (z) {
                post(this.q);
                return;
            }
            removeCallbacks(this.q);
            this.a.setAlpha(255);
            invalidate();
        }
    }

    public void setLineWidth(int i2) {
        this.o = i2;
    }

    @Override // e.t.v.h.d.c
    public void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
    }

    @Override // e.t.v.h.d.c
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f8011g = onPageChangeListener;
    }

    public void setSelectedColor(int i2) {
        this.a.setColor(i2);
        invalidate();
    }

    @Override // e.t.v.h.d.c
    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f8010f;
        if (viewPager2 == viewPager) {
            return;
        }
        if (viewPager2 != null) {
            viewPager2.removeOnPageChangeListener(this);
        }
        if (viewPager.getAdapter() != null) {
            this.f8010f = viewPager;
            viewPager.addOnPageChangeListener(this);
            invalidate();
            post(new Runnable() { // from class: e.t.v.h.d.a
                @Override // java.lang.Runnable
                public final void run() {
                    UnderlinePageIndicator.this.h();
                }
            });
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    @Override // e.t.v.h.d.c
    public void setViewPager2(com.vector.view.pager.ViewPager2 viewPager2) {
    }

    public UnderlinePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiUnderlinePageIndicatorStyle);
    }

    public UnderlinePageIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new Paint(1);
        this.f8016l = -1.0f;
        this.f8017m = -1;
        this.p = Boolean.FALSE;
        this.q = new a();
        if (isInEditMode()) {
            return;
        }
        Resources resources = getResources();
        boolean z = resources.getBoolean(R.bool.default_underline_indicator_fades);
        int integer = resources.getInteger(R.integer.default_underline_indicator_fade_delay);
        int integer2 = resources.getInteger(R.integer.default_underline_indicator_fade_length);
        boolean z2 = resources.getBoolean(R.bool.default_underline_indicator_corner);
        int color = resources.getColor(R.color.default_underline_indicator_selected_color);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UnderlinePageIndicator, i2, 0);
        setFades(obtainStyledAttributes.getBoolean(R.styleable.UnderlinePageIndicator_fades, z));
        setSelectedColor(obtainStyledAttributes.getInteger(R.styleable.UnderlinePageIndicator_selectedPageColor, color));
        setCorner(Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.UnderlinePageIndicator_corner, z2)));
        setFadeDelay(obtainStyledAttributes.getInteger(R.styleable.UnderlinePageIndicator_fadeDelay, integer));
        setFadeLength(obtainStyledAttributes.getInteger(R.styleable.UnderlinePageIndicator_fadeLength, integer2));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.UnderlinePageIndicator_android_background);
        if (drawable != null) {
            ViewCompat.setBackground(this, drawable);
        }
        obtainStyledAttributes.recycle();
        this.f8015k = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }
}
