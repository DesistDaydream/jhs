package e.j.a.c.m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

/* loaded from: classes2.dex */
public final class a {
    @NonNull
    private final Rect a;
    private final ColorStateList b;

    /* renamed from: c  reason: collision with root package name */
    private final ColorStateList f10872c;

    /* renamed from: d  reason: collision with root package name */
    private final ColorStateList f10873d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10874e;

    /* renamed from: f  reason: collision with root package name */
    private final e.j.a.c.z.o f10875f;

    private a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i2, e.j.a.c.z.o oVar, @NonNull Rect rect) {
        Preconditions.checkArgumentNonnegative(rect.left);
        Preconditions.checkArgumentNonnegative(rect.top);
        Preconditions.checkArgumentNonnegative(rect.right);
        Preconditions.checkArgumentNonnegative(rect.bottom);
        this.a = rect;
        this.b = colorStateList2;
        this.f10872c = colorStateList;
        this.f10873d = colorStateList3;
        this.f10874e = i2;
        this.f10875f = oVar;
    }

    @NonNull
    public static a a(@NonNull Context context, @StyleRes int i2) {
        Preconditions.checkArgument(i2 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList a = e.j.a.c.w.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList a2 = e.j.a.c.w.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList a3 = e.j.a.c.w.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        e.j.a.c.z.o m2 = e.j.a.c.z.o.b(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        obtainStyledAttributes.recycle();
        return new a(a, a2, a3, dimensionPixelSize, m2, rect);
    }

    public int b() {
        return this.a.bottom;
    }

    public int c() {
        return this.a.left;
    }

    public int d() {
        return this.a.right;
    }

    public int e() {
        return this.a.top;
    }

    public void f(@NonNull TextView textView) {
        e.j.a.c.z.j jVar = new e.j.a.c.z.j();
        e.j.a.c.z.j jVar2 = new e.j.a.c.z.j();
        jVar.setShapeAppearanceModel(this.f10875f);
        jVar2.setShapeAppearanceModel(this.f10875f);
        jVar.n0(this.f10872c);
        jVar.D0(this.f10874e, this.f10873d);
        textView.setTextColor(this.b);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.b.withAlpha(30), jVar, jVar2) : jVar;
        Rect rect = this.a;
        ViewCompat.setBackground(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
