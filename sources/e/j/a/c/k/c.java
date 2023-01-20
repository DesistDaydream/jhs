package e.j.a.c.k;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.j.a.c.k.b;

/* loaded from: classes2.dex */
public interface c extends b.a {

    /* loaded from: classes2.dex */
    public static class b implements TypeEvaluator<e> {
        public static final TypeEvaluator<e> b = new b();
        private final e a = new e();

        @Override // android.animation.TypeEvaluator
        @NonNull
        /* renamed from: a */
        public e evaluate(float f2, @NonNull e eVar, @NonNull e eVar2) {
            this.a.b(e.j.a.c.t.a.f(eVar.a, eVar2.a, f2), e.j.a.c.t.a.f(eVar.b, eVar2.b, f2), e.j.a.c.t.a.f(eVar.f10868c, eVar2.f10868c, f2));
            return this.a;
        }
    }

    /* renamed from: e.j.a.c.k.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0367c extends Property<c, e> {
        public static final Property<c, e> a = new C0367c("circularReveal");

        private C0367c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        @Nullable
        /* renamed from: a */
        public e get(@NonNull c cVar) {
            return cVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull c cVar, @Nullable e eVar) {
            cVar.setRevealInfo(eVar);
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends Property<c, Integer> {
        public static final Property<c, Integer> a = new d("circularRevealScrimColor");

        private d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull c cVar, @NonNull Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: d  reason: collision with root package name */
        public static final float f10867d = Float.MAX_VALUE;
        public float a;
        public float b;

        /* renamed from: c  reason: collision with root package name */
        public float f10868c;

        public boolean a() {
            return this.f10868c == Float.MAX_VALUE;
        }

        public void b(float f2, float f3, float f4) {
            this.a = f2;
            this.b = f3;
            this.f10868c = f4;
        }

        public void c(@NonNull e eVar) {
            b(eVar.a, eVar.b, eVar.f10868c);
        }

        private e() {
        }

        public e(float f2, float f3, float f4) {
            this.a = f2;
            this.b = f3;
            this.f10868c = f4;
        }

        public e(@NonNull e eVar) {
            this(eVar.a, eVar.b, eVar.f10868c);
        }
    }

    void a();

    void b();

    void draw(Canvas canvas);

    @Nullable
    Drawable getCircularRevealOverlayDrawable();

    @ColorInt
    int getCircularRevealScrimColor();

    @Nullable
    e getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(@Nullable Drawable drawable);

    void setCircularRevealScrimColor(@ColorInt int i2);

    void setRevealInfo(@Nullable e eVar);
}
