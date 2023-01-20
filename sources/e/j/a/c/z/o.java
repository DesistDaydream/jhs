package e.j.a.c.z;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;

/* loaded from: classes2.dex */
public class o {

    /* renamed from: m  reason: collision with root package name */
    public static final d f11132m = new m(0.5f);
    public e a;
    public e b;

    /* renamed from: c  reason: collision with root package name */
    public e f11133c;

    /* renamed from: d  reason: collision with root package name */
    public e f11134d;

    /* renamed from: e  reason: collision with root package name */
    public d f11135e;

    /* renamed from: f  reason: collision with root package name */
    public d f11136f;

    /* renamed from: g  reason: collision with root package name */
    public d f11137g;

    /* renamed from: h  reason: collision with root package name */
    public d f11138h;

    /* renamed from: i  reason: collision with root package name */
    public g f11139i;

    /* renamed from: j  reason: collision with root package name */
    public g f11140j;

    /* renamed from: k  reason: collision with root package name */
    public g f11141k;

    /* renamed from: l  reason: collision with root package name */
    public g f11142l;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public interface c {
        @NonNull
        d a(@NonNull d dVar);
    }

    @NonNull
    public static b a() {
        return new b();
    }

    @NonNull
    public static b b(Context context, @StyleRes int i2, @StyleRes int i3) {
        return c(context, i2, i3, 0);
    }

    @NonNull
    private static b c(Context context, @StyleRes int i2, @StyleRes int i3, int i4) {
        return d(context, i2, i3, new e.j.a.c.z.a(i4));
    }

    @NonNull
    private static b d(Context context, @StyleRes int i2, @StyleRes int i3, @NonNull d dVar) {
        if (i3 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
            i2 = i3;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.ShapeAppearance);
        try {
            int i4 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i5 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i4);
            int i6 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i4);
            int i7 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i4);
            int i8 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i4);
            d m2 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, dVar);
            d m3 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, m2);
            d m4 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, m2);
            d m5 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, m2);
            return new b().I(i5, m3).N(i6, m4).A(i7, m5).v(i8, m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, m2));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static b e(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        return f(context, attributeSet, i2, i3, 0);
    }

    @NonNull
    public static b f(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3, int i4) {
        return g(context, attributeSet, i2, i3, new e.j.a.c.z.a(i4));
    }

    @NonNull
    public static b g(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3, @NonNull d dVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, dVar);
    }

    @NonNull
    private static d m(TypedArray typedArray, int i2, @NonNull d dVar) {
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue == null) {
            return dVar;
        }
        int i3 = peekValue.type;
        if (i3 == 5) {
            return new e.j.a.c.z.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i3 == 6 ? new m(peekValue.getFraction(1.0f, 1.0f)) : dVar;
    }

    @NonNull
    public g h() {
        return this.f11141k;
    }

    @NonNull
    public e i() {
        return this.f11134d;
    }

    @NonNull
    public d j() {
        return this.f11138h;
    }

    @NonNull
    public e k() {
        return this.f11133c;
    }

    @NonNull
    public d l() {
        return this.f11137g;
    }

    @NonNull
    public g n() {
        return this.f11142l;
    }

    @NonNull
    public g o() {
        return this.f11140j;
    }

    @NonNull
    public g p() {
        return this.f11139i;
    }

    @NonNull
    public e q() {
        return this.a;
    }

    @NonNull
    public d r() {
        return this.f11135e;
    }

    @NonNull
    public e s() {
        return this.b;
    }

    @NonNull
    public d t() {
        return this.f11136f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean u(@NonNull RectF rectF) {
        boolean z = this.f11142l.getClass().equals(g.class) && this.f11140j.getClass().equals(g.class) && this.f11139i.getClass().equals(g.class) && this.f11141k.getClass().equals(g.class);
        float a2 = this.f11135e.a(rectF);
        return z && ((this.f11136f.a(rectF) > a2 ? 1 : (this.f11136f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f11138h.a(rectF) > a2 ? 1 : (this.f11138h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f11137g.a(rectF) > a2 ? 1 : (this.f11137g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.b instanceof n) && (this.a instanceof n) && (this.f11133c instanceof n) && (this.f11134d instanceof n));
    }

    @NonNull
    public b v() {
        return new b(this);
    }

    @NonNull
    public o w(float f2) {
        return v().o(f2).m();
    }

    @NonNull
    public o x(@NonNull d dVar) {
        return v().p(dVar).m();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public o y(@NonNull c cVar) {
        return v().L(cVar.a(r())).Q(cVar.a(t())).y(cVar.a(j())).D(cVar.a(l())).m();
    }

    private o(@NonNull b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.f11133c = bVar.f11143c;
        this.f11134d = bVar.f11144d;
        this.f11135e = bVar.f11145e;
        this.f11136f = bVar.f11146f;
        this.f11137g = bVar.f11147g;
        this.f11138h = bVar.f11148h;
        this.f11139i = bVar.f11149i;
        this.f11140j = bVar.f11150j;
        this.f11141k = bVar.f11151k;
        this.f11142l = bVar.f11152l;
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @NonNull
        private e a;
        @NonNull
        private e b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private e f11143c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private e f11144d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private d f11145e;
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        private d f11146f;
        @NonNull

        /* renamed from: g  reason: collision with root package name */
        private d f11147g;
        @NonNull

        /* renamed from: h  reason: collision with root package name */
        private d f11148h;
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        private g f11149i;
        @NonNull

        /* renamed from: j  reason: collision with root package name */
        private g f11150j;
        @NonNull

        /* renamed from: k  reason: collision with root package name */
        private g f11151k;
        @NonNull

        /* renamed from: l  reason: collision with root package name */
        private g f11152l;

        public b() {
            this.a = k.b();
            this.b = k.b();
            this.f11143c = k.b();
            this.f11144d = k.b();
            this.f11145e = new e.j.a.c.z.a(0.0f);
            this.f11146f = new e.j.a.c.z.a(0.0f);
            this.f11147g = new e.j.a.c.z.a(0.0f);
            this.f11148h = new e.j.a.c.z.a(0.0f);
            this.f11149i = k.c();
            this.f11150j = k.c();
            this.f11151k = k.c();
            this.f11152l = k.c();
        }

        private static float n(e eVar) {
            if (eVar instanceof n) {
                return ((n) eVar).a;
            }
            if (eVar instanceof f) {
                return ((f) eVar).a;
            }
            return -1.0f;
        }

        @NonNull
        public b A(int i2, @NonNull d dVar) {
            return B(k.a(i2)).D(dVar);
        }

        @NonNull
        public b B(@NonNull e eVar) {
            this.f11143c = eVar;
            float n = n(eVar);
            if (n != -1.0f) {
                C(n);
            }
            return this;
        }

        @NonNull
        public b C(@Dimension float f2) {
            this.f11147g = new e.j.a.c.z.a(f2);
            return this;
        }

        @NonNull
        public b D(@NonNull d dVar) {
            this.f11147g = dVar;
            return this;
        }

        @NonNull
        public b E(@NonNull g gVar) {
            this.f11152l = gVar;
            return this;
        }

        @NonNull
        public b F(@NonNull g gVar) {
            this.f11150j = gVar;
            return this;
        }

        @NonNull
        public b G(@NonNull g gVar) {
            this.f11149i = gVar;
            return this;
        }

        @NonNull
        public b H(int i2, @Dimension float f2) {
            return J(k.a(i2)).K(f2);
        }

        @NonNull
        public b I(int i2, @NonNull d dVar) {
            return J(k.a(i2)).L(dVar);
        }

        @NonNull
        public b J(@NonNull e eVar) {
            this.a = eVar;
            float n = n(eVar);
            if (n != -1.0f) {
                K(n);
            }
            return this;
        }

        @NonNull
        public b K(@Dimension float f2) {
            this.f11145e = new e.j.a.c.z.a(f2);
            return this;
        }

        @NonNull
        public b L(@NonNull d dVar) {
            this.f11145e = dVar;
            return this;
        }

        @NonNull
        public b M(int i2, @Dimension float f2) {
            return O(k.a(i2)).P(f2);
        }

        @NonNull
        public b N(int i2, @NonNull d dVar) {
            return O(k.a(i2)).Q(dVar);
        }

        @NonNull
        public b O(@NonNull e eVar) {
            this.b = eVar;
            float n = n(eVar);
            if (n != -1.0f) {
                P(n);
            }
            return this;
        }

        @NonNull
        public b P(@Dimension float f2) {
            this.f11146f = new e.j.a.c.z.a(f2);
            return this;
        }

        @NonNull
        public b Q(@NonNull d dVar) {
            this.f11146f = dVar;
            return this;
        }

        @NonNull
        public o m() {
            return new o(this);
        }

        @NonNull
        public b o(@Dimension float f2) {
            return K(f2).P(f2).C(f2).x(f2);
        }

        @NonNull
        public b p(@NonNull d dVar) {
            return L(dVar).Q(dVar).D(dVar).y(dVar);
        }

        @NonNull
        public b q(int i2, @Dimension float f2) {
            return r(k.a(i2)).o(f2);
        }

        @NonNull
        public b r(@NonNull e eVar) {
            return J(eVar).O(eVar).B(eVar).w(eVar);
        }

        @NonNull
        public b s(@NonNull g gVar) {
            return E(gVar).G(gVar).F(gVar).t(gVar);
        }

        @NonNull
        public b t(@NonNull g gVar) {
            this.f11151k = gVar;
            return this;
        }

        @NonNull
        public b u(int i2, @Dimension float f2) {
            return w(k.a(i2)).x(f2);
        }

        @NonNull
        public b v(int i2, @NonNull d dVar) {
            return w(k.a(i2)).y(dVar);
        }

        @NonNull
        public b w(@NonNull e eVar) {
            this.f11144d = eVar;
            float n = n(eVar);
            if (n != -1.0f) {
                x(n);
            }
            return this;
        }

        @NonNull
        public b x(@Dimension float f2) {
            this.f11148h = new e.j.a.c.z.a(f2);
            return this;
        }

        @NonNull
        public b y(@NonNull d dVar) {
            this.f11148h = dVar;
            return this;
        }

        @NonNull
        public b z(int i2, @Dimension float f2) {
            return B(k.a(i2)).C(f2);
        }

        public b(@NonNull o oVar) {
            this.a = k.b();
            this.b = k.b();
            this.f11143c = k.b();
            this.f11144d = k.b();
            this.f11145e = new e.j.a.c.z.a(0.0f);
            this.f11146f = new e.j.a.c.z.a(0.0f);
            this.f11147g = new e.j.a.c.z.a(0.0f);
            this.f11148h = new e.j.a.c.z.a(0.0f);
            this.f11149i = k.c();
            this.f11150j = k.c();
            this.f11151k = k.c();
            this.f11152l = k.c();
            this.a = oVar.a;
            this.b = oVar.b;
            this.f11143c = oVar.f11133c;
            this.f11144d = oVar.f11134d;
            this.f11145e = oVar.f11135e;
            this.f11146f = oVar.f11136f;
            this.f11147g = oVar.f11137g;
            this.f11148h = oVar.f11138h;
            this.f11149i = oVar.f11139i;
            this.f11150j = oVar.f11140j;
            this.f11151k = oVar.f11141k;
            this.f11152l = oVar.f11142l;
        }
    }

    public o() {
        this.a = k.b();
        this.b = k.b();
        this.f11133c = k.b();
        this.f11134d = k.b();
        this.f11135e = new e.j.a.c.z.a(0.0f);
        this.f11136f = new e.j.a.c.z.a(0.0f);
        this.f11137g = new e.j.a.c.z.a(0.0f);
        this.f11138h = new e.j.a.c.z.a(0.0f);
        this.f11139i = k.c();
        this.f11140j = k.c();
        this.f11141k = k.c();
        this.f11142l = k.c();
    }
}
