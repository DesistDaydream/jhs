package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class StaticLayoutBuilderCompat {
    public static final int n;
    public static final float o = 0.0f;
    public static final float p = 1.0f;
    private static final String q = "android.text.TextDirectionHeuristic";
    private static final String r = "android.text.TextDirectionHeuristics";
    private static final String s = "LTR";
    private static final String t = "RTL";
    private static boolean u;
    @Nullable
    private static Constructor<StaticLayout> v;
    @Nullable
    private static Object w;
    private CharSequence a;
    private final TextPaint b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2944c;

    /* renamed from: e  reason: collision with root package name */
    private int f2946e;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2953l;

    /* renamed from: d  reason: collision with root package name */
    private int f2945d = 0;

    /* renamed from: f  reason: collision with root package name */
    private Layout.Alignment f2947f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g  reason: collision with root package name */
    private int f2948g = Integer.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    private float f2949h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private float f2950i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    private int f2951j = n;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2952k = true;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private TextUtils.TruncateAt f2954m = null;

    /* loaded from: classes2.dex */
    public static class StaticLayoutBuilderCompatException extends Exception {
        public StaticLayoutBuilderCompatException(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    static {
        n = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.a = charSequence;
        this.b = textPaint;
        this.f2944c = i2;
        this.f2946e = charSequence.length();
    }

    private void b() throws StaticLayoutBuilderCompatException {
        Class<?> cls;
        int i2 = Build.VERSION.SDK_INT;
        if (u) {
            return;
        }
        try {
            boolean z = this.f2953l && i2 >= 23;
            if (i2 >= 18) {
                cls = TextDirectionHeuristic.class;
                w = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                ClassLoader classLoader = StaticLayoutBuilderCompat.class.getClassLoader();
                String str = this.f2953l ? t : s;
                Class<?> loadClass = classLoader.loadClass(q);
                Class<?> loadClass2 = classLoader.loadClass(r);
                w = loadClass2.getField(str).get(loadClass2);
                cls = loadClass;
            }
            Class cls2 = Integer.TYPE;
            Class cls3 = Float.TYPE;
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls2, cls2, TextPaint.class, cls2, Layout.Alignment.class, cls, cls3, cls3, Boolean.TYPE, TextUtils.TruncateAt.class, cls2, cls2);
            v = declaredConstructor;
            declaredConstructor.setAccessible(true);
            u = true;
        } catch (Exception e2) {
            throw new StaticLayoutBuilderCompatException(e2);
        }
    }

    @NonNull
    public static StaticLayoutBuilderCompat c(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, @IntRange(from = 0) int i2) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i2);
    }

    public StaticLayout a() throws StaticLayoutBuilderCompatException {
        if (this.a == null) {
            this.a = "";
        }
        int max = Math.max(0, this.f2944c);
        CharSequence charSequence = this.a;
        if (this.f2948g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.b, max, this.f2954m);
        }
        int min = Math.min(charSequence.length(), this.f2946e);
        this.f2946e = min;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f2953l && this.f2948g == 1) {
                this.f2947f = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f2945d, min, this.b, max);
            obtain.setAlignment(this.f2947f);
            obtain.setIncludePad(this.f2952k);
            obtain.setTextDirection(this.f2953l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f2954m;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f2948g);
            float f2 = this.f2949h;
            if (f2 != 0.0f || this.f2950i != 1.0f) {
                obtain.setLineSpacing(f2, this.f2950i);
            }
            if (this.f2948g > 1) {
                obtain.setHyphenationFrequency(this.f2951j);
            }
            return obtain.build();
        }
        b();
        try {
            return (StaticLayout) ((Constructor) Preconditions.checkNotNull(v)).newInstance(charSequence, Integer.valueOf(this.f2945d), Integer.valueOf(this.f2946e), this.b, Integer.valueOf(max), this.f2947f, Preconditions.checkNotNull(w), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f2952k), null, Integer.valueOf(max), Integer.valueOf(this.f2948g));
        } catch (Exception e2) {
            throw new StaticLayoutBuilderCompatException(e2);
        }
    }

    @NonNull
    public StaticLayoutBuilderCompat d(@NonNull Layout.Alignment alignment) {
        this.f2947f = alignment;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat e(@Nullable TextUtils.TruncateAt truncateAt) {
        this.f2954m = truncateAt;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat f(@IntRange(from = 0) int i2) {
        this.f2946e = i2;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat g(int i2) {
        this.f2951j = i2;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat h(boolean z) {
        this.f2952k = z;
        return this;
    }

    public StaticLayoutBuilderCompat i(boolean z) {
        this.f2953l = z;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat j(float f2, float f3) {
        this.f2949h = f2;
        this.f2950i = f3;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat k(@IntRange(from = 0) int i2) {
        this.f2948g = i2;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat l(@IntRange(from = 0) int i2) {
        this.f2945d = i2;
        return this;
    }
}
