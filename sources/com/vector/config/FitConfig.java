package com.vector.config;

import com.vector.fitter.Mode;
import h.w;
import h.z;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0013\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0016\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001b\u0010\u0019\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001a\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/vector/config/FitConfig;", "", "()V", "defaultMode", "Lcom/vector/fitter/Mode;", "getDefaultMode", "()Lcom/vector/fitter/Mode;", "setDefaultMode", "(Lcom/vector/fitter/Mode;)V", "height", "", "getHeight", "()F", "setHeight", "(F)V", "heightDensity", "getHeightDensity", "heightDensity$delegate", "Lkotlin/Lazy;", "scale", "getScale", "setScale", "width", "getWidth", "setWidth", "widthDensity", "getWidthDensity", "widthDensity$delegate", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class FitConfig {
    @d
    public static final FitConfig a = new FitConfig();
    private static float b = 3.0f;

    /* renamed from: c  reason: collision with root package name */
    private static float f7648c = 1080.0f;

    /* renamed from: d  reason: collision with root package name */
    private static float f7649d = 1920.0f;
    @d

    /* renamed from: e  reason: collision with root package name */
    private static final w f7650e = z.c(FitConfig$widthDensity$2.INSTANCE);
    @d

    /* renamed from: f  reason: collision with root package name */
    private static final w f7651f = z.c(FitConfig$heightDensity$2.INSTANCE);
    @d

    /* renamed from: g  reason: collision with root package name */
    private static Mode f7652g = Mode.DEFAULT;

    private FitConfig() {
    }

    @d
    public final Mode a() {
        return f7652g;
    }

    public final float b() {
        return f7649d;
    }

    public final float c() {
        return ((Number) f7651f.getValue()).floatValue();
    }

    public final float d() {
        return b;
    }

    public final float e() {
        return f7648c;
    }

    public final float f() {
        return ((Number) f7650e.getValue()).floatValue();
    }

    public final void g(@d Mode mode) {
        f7652g = mode;
    }

    public final void h(float f2) {
        f7649d = f2;
    }

    public final void i(float f2) {
        b = f2;
    }

    public final void j(float f2) {
        f7648c = f2;
    }
}
