package e.j.a.c.w;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class d {
    private static final String r = "TextAppearance";
    private static final int s = 1;
    private static final int t = 2;
    private static final int u = 3;
    @Nullable
    public final ColorStateList a;
    @Nullable
    public final ColorStateList b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f11061c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final ColorStateList f11062d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final String f11063e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11064f;

    /* renamed from: g  reason: collision with root package name */
    public final int f11065g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f11066h;

    /* renamed from: i  reason: collision with root package name */
    public final float f11067i;

    /* renamed from: j  reason: collision with root package name */
    public final float f11068j;

    /* renamed from: k  reason: collision with root package name */
    public final float f11069k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f11070l;

    /* renamed from: m  reason: collision with root package name */
    public final float f11071m;
    public float n;
    @FontRes
    private final int o;
    private boolean p = false;
    private Typeface q;

    /* loaded from: classes2.dex */
    public class a extends ResourcesCompat.FontCallback {
        public final /* synthetic */ f a;

        public a(f fVar) {
            this.a = fVar;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrievalFailed(int i2) {
            d.this.p = true;
            this.a.a(i2);
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrieved(@NonNull Typeface typeface) {
            d dVar = d.this;
            dVar.q = Typeface.create(typeface, dVar.f11064f);
            d.this.p = true;
            this.a.b(d.this.q, false);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends f {
        public final /* synthetic */ TextPaint a;
        public final /* synthetic */ f b;

        public b(TextPaint textPaint, f fVar) {
            this.a = textPaint;
            this.b = fVar;
        }

        @Override // e.j.a.c.w.f
        public void a(int i2) {
            this.b.a(i2);
        }

        @Override // e.j.a.c.w.f
        public void b(@NonNull Typeface typeface, boolean z) {
            d.this.l(this.a, typeface);
            this.b.b(typeface, z);
        }
    }

    public d(@NonNull Context context, @StyleRes int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.TextAppearance);
        this.n = obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.a = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
        this.b = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.f11061c = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.f11064f = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.f11065g = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int e2 = c.e(obtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.o = obtainStyledAttributes.getResourceId(e2, 0);
        this.f11063e = obtainStyledAttributes.getString(e2);
        this.f11066h = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.f11062d = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.f11067i = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f11068j = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f11069k = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i2, R.styleable.MaterialTextAppearance);
            int i3 = R.styleable.MaterialTextAppearance_android_letterSpacing;
            this.f11070l = obtainStyledAttributes2.hasValue(i3);
            this.f11071m = obtainStyledAttributes2.getFloat(i3, 0.0f);
            obtainStyledAttributes2.recycle();
            return;
        }
        this.f11070l = false;
        this.f11071m = 0.0f;
    }

    private void d() {
        String str;
        if (this.q == null && (str = this.f11063e) != null) {
            this.q = Typeface.create(str, this.f11064f);
        }
        if (this.q == null) {
            int i2 = this.f11065g;
            if (i2 == 1) {
                this.q = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.q = Typeface.SERIF;
            } else if (i2 != 3) {
                this.q = Typeface.DEFAULT;
            } else {
                this.q = Typeface.MONOSPACE;
            }
            this.q = Typeface.create(this.q, this.f11064f);
        }
    }

    private boolean i(Context context) {
        if (e.b()) {
            return true;
        }
        int i2 = this.o;
        return (i2 != 0 ? ResourcesCompat.getCachedFont(context, i2) : null) != null;
    }

    public Typeface e() {
        d();
        return this.q;
    }

    @NonNull
    @VisibleForTesting
    public Typeface f(@NonNull Context context) {
        if (this.p) {
            return this.q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font = ResourcesCompat.getFont(context, this.o);
                this.q = font;
                if (font != null) {
                    this.q = Typeface.create(font, this.f11064f);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e2) {
                Log.d(r, "Error loading font " + this.f11063e, e2);
            }
        }
        d();
        this.p = true;
        return this.q;
    }

    public void g(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        l(textPaint, e());
        h(context, new b(textPaint, fVar));
    }

    public void h(@NonNull Context context, @NonNull f fVar) {
        if (i(context)) {
            f(context);
        } else {
            d();
        }
        int i2 = this.o;
        if (i2 == 0) {
            this.p = true;
        }
        if (this.p) {
            fVar.b(this.q, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i2, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.p = true;
            fVar.a(1);
        } catch (Exception e2) {
            Log.d(r, "Error loading font " + this.f11063e, e2);
            this.p = true;
            fVar.a(-3);
        }
    }

    public void j(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        k(context, textPaint, fVar);
        ColorStateList colorStateList = this.a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : ViewCompat.MEASURED_STATE_MASK);
        float f2 = this.f11069k;
        float f3 = this.f11067i;
        float f4 = this.f11068j;
        ColorStateList colorStateList2 = this.f11062d;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void k(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        if (i(context)) {
            l(textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void l(@NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i2 = (~typeface.getStyle()) & this.f11064f;
        textPaint.setFakeBoldText((i2 & 1) != 0);
        textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.n);
        if (Build.VERSION.SDK_INT < 21 || !this.f11070l) {
            return;
        }
        textPaint.setLetterSpacing(this.f11071m);
    }
}
