package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import e.j.a.c.s.j;
import e.j.a.c.s.m;
import e.j.a.c.w.c;
import e.j.a.c.w.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* loaded from: classes2.dex */
public class BadgeDrawable extends Drawable implements j.b {
    public static final int q = 8388661;
    public static final int r = 8388659;
    public static final int s = 8388693;
    public static final int t = 8388691;
    private static final int u = 4;
    private static final int v = -1;
    private static final int w = 9;
    @StyleRes
    private static final int x = R.style.Widget_MaterialComponents_Badge;
    @AttrRes
    private static final int y = R.attr.badgeStyle;
    public static final String z = "+";
    @NonNull
    private final WeakReference<Context> a;
    @NonNull
    private final e.j.a.c.z.j b;
    @NonNull

    /* renamed from: c */
    private final j f2736c;
    @NonNull

    /* renamed from: d */
    private final Rect f2737d;

    /* renamed from: e */
    private final float f2738e;

    /* renamed from: f */
    private final float f2739f;

    /* renamed from: g */
    private final float f2740g;
    @NonNull

    /* renamed from: h */
    private final SavedState f2741h;

    /* renamed from: i */
    private float f2742i;

    /* renamed from: j */
    private float f2743j;

    /* renamed from: k */
    private int f2744k;

    /* renamed from: l */
    private float f2745l;

    /* renamed from: m */
    private float f2746m;
    private float n;
    @Nullable
    private WeakReference<View> o;
    @Nullable
    private WeakReference<FrameLayout> p;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ FrameLayout b;

        public a(View view, FrameLayout frameLayout) {
            BadgeDrawable.this = r1;
            this.a = view;
            this.b = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            BadgeDrawable.this.S(this.a, this.b);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface b {
    }

    private BadgeDrawable(@NonNull Context context) {
        this.a = new WeakReference<>(context);
        m.c(context);
        Resources resources = context.getResources();
        this.f2737d = new Rect();
        this.b = new e.j.a.c.z.j();
        this.f2738e = resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.f2740g = resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.f2739f = resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        j jVar = new j(this);
        this.f2736c = jVar;
        jVar.e().setTextAlign(Paint.Align.CENTER);
        this.f2741h = new SavedState(context);
        L(R.style.TextAppearance_MaterialComponents_Badge);
    }

    private void K(@Nullable d dVar) {
        Context context;
        if (this.f2736c.d() == dVar || (context = this.a.get()) == null) {
            return;
        }
        this.f2736c.i(dVar, context);
        T();
    }

    private void L(@StyleRes int i2) {
        Context context = this.a.get();
        if (context == null) {
            return;
        }
        K(new d(context, i2));
    }

    private void O(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R.id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.p;
            if (weakReference == null || weakReference.get() != viewGroup) {
                P(view);
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R.id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(indexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, indexOfChild);
                this.p = new WeakReference<>(frameLayout);
                frameLayout.post(new a(view, frameLayout));
            }
        }
    }

    private static void P(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void T() {
        Context context = this.a.get();
        WeakReference<View> weakReference = this.o;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f2737d);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<FrameLayout> weakReference2 = this.p;
        FrameLayout frameLayout = weakReference2 != null ? weakReference2.get() : null;
        if (frameLayout != null || e.j.a.c.c.a.a) {
            if (frameLayout == null) {
                frameLayout = (ViewGroup) view.getParent();
            }
            frameLayout.offsetDescendantRectToMyCoords(view, rect2);
        }
        b(context, rect2, view);
        e.j.a.c.c.a.l(this.f2737d, this.f2742i, this.f2743j, this.f2746m, this.n);
        this.b.j0(this.f2745l);
        if (rect.equals(this.f2737d)) {
            return;
        }
        this.b.setBounds(this.f2737d);
    }

    private void U() {
        this.f2744k = ((int) Math.pow(10.0d, r() - 1.0d)) - 1;
    }

    private void b(@NonNull Context context, @NonNull Rect rect, @NonNull View view) {
        int i2 = this.f2741h.verticalOffset + this.f2741h.additionalVerticalOffset;
        int i3 = this.f2741h.badgeGravity;
        if (i3 != 8388691 && i3 != 8388693) {
            this.f2743j = rect.top + i2;
        } else {
            this.f2743j = rect.bottom - i2;
        }
        if (s() <= 9) {
            float f2 = !v() ? this.f2738e : this.f2739f;
            this.f2745l = f2;
            this.n = f2;
            this.f2746m = f2;
        } else {
            float f3 = this.f2739f;
            this.f2745l = f3;
            this.n = f3;
            this.f2746m = (this.f2736c.f(m()) / 2.0f) + this.f2740g;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(v() ? R.dimen.mtrl_badge_text_horizontal_edge_offset : R.dimen.mtrl_badge_horizontal_edge_offset);
        int i4 = this.f2741h.horizontalOffset + this.f2741h.additionalHorizontalOffset;
        int i5 = this.f2741h.badgeGravity;
        if (i5 != 8388659 && i5 != 8388691) {
            this.f2742i = ViewCompat.getLayoutDirection(view) == 0 ? ((rect.right + this.f2746m) - dimensionPixelSize) - i4 : (rect.left - this.f2746m) + dimensionPixelSize + i4;
        } else {
            this.f2742i = ViewCompat.getLayoutDirection(view) == 0 ? (rect.left - this.f2746m) + dimensionPixelSize + i4 : ((rect.right + this.f2746m) - dimensionPixelSize) - i4;
        }
    }

    @NonNull
    public static BadgeDrawable d(@NonNull Context context) {
        return e(context, null, y, x);
    }

    @NonNull
    private static BadgeDrawable e(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.w(context, attributeSet, i2, i3);
        return badgeDrawable;
    }

    @NonNull
    public static BadgeDrawable f(@NonNull Context context, @XmlRes int i2) {
        AttributeSet a2 = e.j.a.c.o.a.a(context, i2, "badge");
        int styleAttribute = a2.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = x;
        }
        return e(context, a2, y, styleAttribute);
    }

    @NonNull
    public static BadgeDrawable g(@NonNull Context context, @NonNull SavedState savedState) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.y(savedState);
        return badgeDrawable;
    }

    private void h(Canvas canvas) {
        Rect rect = new Rect();
        String m2 = m();
        this.f2736c.e().getTextBounds(m2, 0, m2.length(), rect);
        canvas.drawText(m2, this.f2742i, this.f2743j + (rect.height() / 2), this.f2736c.e());
    }

    @NonNull
    private String m() {
        if (s() <= this.f2744k) {
            return NumberFormat.getInstance().format(s());
        }
        Context context = this.a.get();
        return context == null ? "" : context.getString(R.string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.f2744k), "+");
    }

    private void w(Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TypedArray j2 = m.j(context, attributeSet, R.styleable.Badge, i2, i3, new int[0]);
        I(j2.getInt(R.styleable.Badge_maxCharacterCount, 4));
        int i4 = R.styleable.Badge_number;
        if (j2.hasValue(i4)) {
            J(j2.getInt(i4, 0));
        }
        B(x(context, j2, R.styleable.Badge_backgroundColor));
        int i5 = R.styleable.Badge_badgeTextColor;
        if (j2.hasValue(i5)) {
            D(x(context, j2, i5));
        }
        C(j2.getInt(R.styleable.Badge_badgeGravity, q));
        H(j2.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0));
        M(j2.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0));
        j2.recycle();
    }

    private static int x(Context context, @NonNull TypedArray typedArray, @StyleableRes int i2) {
        return c.a(context, typedArray, i2).getDefaultColor();
    }

    private void y(@NonNull SavedState savedState) {
        I(savedState.maxCharacterCount);
        if (savedState.number != -1) {
            J(savedState.number);
        }
        B(savedState.backgroundColor);
        D(savedState.badgeTextColor);
        C(savedState.badgeGravity);
        H(savedState.horizontalOffset);
        M(savedState.verticalOffset);
        z(savedState.additionalHorizontalOffset);
        A(savedState.additionalVerticalOffset);
        N(savedState.isVisible);
    }

    public void A(int i2) {
        this.f2741h.additionalVerticalOffset = i2;
        T();
    }

    public void B(@ColorInt int i2) {
        this.f2741h.backgroundColor = i2;
        ColorStateList valueOf = ColorStateList.valueOf(i2);
        if (this.b.y() != valueOf) {
            this.b.n0(valueOf);
            invalidateSelf();
        }
    }

    public void C(int i2) {
        if (this.f2741h.badgeGravity != i2) {
            this.f2741h.badgeGravity = i2;
            WeakReference<View> weakReference = this.o;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            View view = this.o.get();
            WeakReference<FrameLayout> weakReference2 = this.p;
            S(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    public void D(@ColorInt int i2) {
        this.f2741h.badgeTextColor = i2;
        if (this.f2736c.e().getColor() != i2) {
            this.f2736c.e().setColor(i2);
            invalidateSelf();
        }
    }

    public void E(@StringRes int i2) {
        this.f2741h.contentDescriptionExceedsMaxBadgeNumberRes = i2;
    }

    public void F(CharSequence charSequence) {
        this.f2741h.contentDescriptionNumberless = charSequence;
    }

    public void G(@PluralsRes int i2) {
        this.f2741h.contentDescriptionQuantityStrings = i2;
    }

    public void H(int i2) {
        this.f2741h.horizontalOffset = i2;
        T();
    }

    public void I(int i2) {
        if (this.f2741h.maxCharacterCount != i2) {
            this.f2741h.maxCharacterCount = i2;
            U();
            this.f2736c.j(true);
            T();
            invalidateSelf();
        }
    }

    public void J(int i2) {
        int max = Math.max(0, i2);
        if (this.f2741h.number != max) {
            this.f2741h.number = max;
            this.f2736c.j(true);
            T();
            invalidateSelf();
        }
    }

    public void M(int i2) {
        this.f2741h.verticalOffset = i2;
        T();
    }

    public void N(boolean z2) {
        setVisible(z2, false);
        this.f2741h.isVisible = z2;
        if (!e.j.a.c.c.a.a || p() == null || z2) {
            return;
        }
        ((ViewGroup) p().getParent()).invalidate();
    }

    public void Q(@NonNull View view) {
        S(view, null);
    }

    @Deprecated
    public void R(@NonNull View view, @Nullable ViewGroup viewGroup) {
        if (viewGroup instanceof FrameLayout) {
            S(view, (FrameLayout) viewGroup);
            return;
        }
        throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
    }

    public void S(@NonNull View view, @Nullable FrameLayout frameLayout) {
        this.o = new WeakReference<>(view);
        boolean z2 = e.j.a.c.c.a.a;
        if (z2 && frameLayout == null) {
            O(view);
        } else {
            this.p = new WeakReference<>(frameLayout);
        }
        if (!z2) {
            P(view);
        }
        T();
        invalidateSelf();
    }

    @Override // e.j.a.c.s.j.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a() {
        invalidateSelf();
    }

    public void c() {
        this.f2741h.number = -1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.b.draw(canvas);
        if (v()) {
            h(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2741h.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2737d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2737d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int i() {
        return this.f2741h.additionalHorizontalOffset;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public int j() {
        return this.f2741h.additionalVerticalOffset;
    }

    @ColorInt
    public int k() {
        return this.b.y().getDefaultColor();
    }

    public int l() {
        return this.f2741h.badgeGravity;
    }

    @ColorInt
    public int n() {
        return this.f2736c.e().getColor();
    }

    @Nullable
    public CharSequence o() {
        Context context;
        if (isVisible()) {
            if (v()) {
                if (this.f2741h.contentDescriptionQuantityStrings <= 0 || (context = this.a.get()) == null) {
                    return null;
                }
                if (s() <= this.f2744k) {
                    return context.getResources().getQuantityString(this.f2741h.contentDescriptionQuantityStrings, s(), Integer.valueOf(s()));
                }
                return context.getString(this.f2741h.contentDescriptionExceedsMaxBadgeNumberRes, Integer.valueOf(this.f2744k));
            }
            return this.f2741h.contentDescriptionNumberless;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable, e.j.a.c.s.j.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Nullable
    public FrameLayout p() {
        WeakReference<FrameLayout> weakReference = this.p;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int q() {
        return this.f2741h.horizontalOffset;
    }

    public int r() {
        return this.f2741h.maxCharacterCount;
    }

    public int s() {
        if (v()) {
            return this.f2741h.number;
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f2741h.alpha = i2;
        this.f2736c.e().setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @NonNull
    public SavedState t() {
        return this.f2741h;
    }

    public int u() {
        return this.f2741h.verticalOffset;
    }

    public boolean v() {
        return this.f2741h.number != -1;
    }

    public void z(int i2) {
        this.f2741h.additionalHorizontalOffset = i2;
        T();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        @Dimension(unit = 1)
        private int additionalHorizontalOffset;
        @Dimension(unit = 1)
        private int additionalVerticalOffset;
        private int alpha;
        @ColorInt
        private int backgroundColor;
        private int badgeGravity;
        @ColorInt
        private int badgeTextColor;
        @StringRes
        private int contentDescriptionExceedsMaxBadgeNumberRes;
        @Nullable
        private CharSequence contentDescriptionNumberless;
        @PluralsRes
        private int contentDescriptionQuantityStrings;
        @Dimension(unit = 1)
        private int horizontalOffset;
        private boolean isVisible;
        private int maxCharacterCount;
        private int number;
        @Dimension(unit = 1)
        private int verticalOffset;

        /* loaded from: classes2.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(@NonNull Context context) {
            this.alpha = 255;
            this.number = -1;
            this.badgeTextColor = new d(context, R.style.TextAppearance_MaterialComponents_Badge).a.getDefaultColor();
            this.contentDescriptionNumberless = context.getString(R.string.mtrl_badge_numberless_content_description);
            this.contentDescriptionQuantityStrings = R.plurals.mtrl_badge_content_description;
            this.contentDescriptionExceedsMaxBadgeNumberRes = R.string.mtrl_exceed_max_badge_number_content_description;
            this.isVisible = true;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            parcel.writeInt(this.backgroundColor);
            parcel.writeInt(this.badgeTextColor);
            parcel.writeInt(this.alpha);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            parcel.writeString(this.contentDescriptionNumberless.toString());
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeInt(this.badgeGravity);
            parcel.writeInt(this.horizontalOffset);
            parcel.writeInt(this.verticalOffset);
            parcel.writeInt(this.additionalHorizontalOffset);
            parcel.writeInt(this.additionalVerticalOffset);
            parcel.writeInt(this.isVisible ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel) {
            this.alpha = 255;
            this.number = -1;
            this.backgroundColor = parcel.readInt();
            this.badgeTextColor = parcel.readInt();
            this.alpha = parcel.readInt();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = parcel.readInt();
            this.horizontalOffset = parcel.readInt();
            this.verticalOffset = parcel.readInt();
            this.additionalHorizontalOffset = parcel.readInt();
            this.additionalVerticalOffset = parcel.readInt();
            this.isVisible = parcel.readInt() != 0;
        }
    }
}
