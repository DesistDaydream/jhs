package com.vector.config;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import h.k2.k;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 F2\u00020\u0001:\u0002FGB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR&\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00048\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001e\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001e\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\u001e\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR$\u0010,\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020+@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\u001e\u0010:\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\u001e\u0010=\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001a\u0010@\u001a\u00020AX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lcom/vector/config/NavBarConfig;", "", "()V", "bgColorRes", "", "getBgColorRes", "()I", "setBgColorRes", "(I)V", "bgRes", "getBgRes", "setBgRes", "dividerColorRes", "getDividerColorRes", "setDividerColorRes", "dividerHeight", "getDividerHeight", "setDividerHeight", "focusBgColor", "getFocusBgColor", "setFocusBgColor", "focusBgDrawableRes", "getFocusBgDrawableRes", "setFocusBgDrawableRes", "focusTextBgColor", "getFocusTextBgColor", "setFocusTextBgColor", "focusTextBgDrawableRes", "getFocusTextBgDrawableRes", "setFocusTextBgDrawableRes", "value", "height", "getHeight", "setHeight", "iconPadding", "getIconPadding", "setIconPadding", "iconSize", "getIconSize", "setIconSize", "insideDiameter", "getInsideDiameter", "setInsideDiameter", "Lcom/vector/config/NavBarConfig$Shape;", "shape", "getShape", "()Lcom/vector/config/NavBarConfig$Shape;", "setShape", "(Lcom/vector/config/NavBarConfig$Shape;)V", "state", "Lcom/vector/config/NavBarState;", "getState", "()Lcom/vector/config/NavBarState;", "setState", "(Lcom/vector/config/NavBarState;)V", "textColor", "getTextColor", "setTextColor", "textPadding", "getTextPadding", "setTextPadding", "textSize", "getTextSize", "setTextSize", "useSquare", "", "getUseSquare$vector_release", "()Z", "setUseSquare$vector_release", "(Z)V", "Companion", "Shape", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NavBarConfig {
    @d
    public static final a s = new a(null);
    @d
    private Shape a;
    @Dimension(unit = 0)
    private int b;
    @Dimension(unit = 0)

    /* renamed from: c  reason: collision with root package name */
    private int f7653c;
    @Dimension(unit = 0)

    /* renamed from: d  reason: collision with root package name */
    private int f7654d;
    @Dimension(unit = 0)

    /* renamed from: e  reason: collision with root package name */
    private int f7655e;
    @Dimension(unit = 0)

    /* renamed from: f  reason: collision with root package name */
    private int f7656f;
    @Dimension(unit = 1)

    /* renamed from: g  reason: collision with root package name */
    private int f7657g;
    @ColorRes

    /* renamed from: h  reason: collision with root package name */
    private int f7658h;
    @DrawableRes

    /* renamed from: i  reason: collision with root package name */
    private int f7659i;
    @ColorRes

    /* renamed from: j  reason: collision with root package name */
    private int f7660j;
    @ColorRes

    /* renamed from: k  reason: collision with root package name */
    private int f7661k;
    @ColorInt

    /* renamed from: l  reason: collision with root package name */
    private int f7662l;
    @DrawableRes

    /* renamed from: m  reason: collision with root package name */
    private int f7663m;
    @ColorInt
    private int n;
    @DrawableRes
    private int o;
    @d
    private NavBarState p;
    private boolean q;
    @Dimension(unit = 0)
    private int r;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/vector/config/NavBarConfig$Shape;", "", "(Ljava/lang/String;I)V", "SQUARE", "INSIDE", "WRAP", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum Shape {
        SQUARE,
        INSIDE,
        WRAP
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0007¨\u0006\t"}, d2 = {"Lcom/vector/config/NavBarConfig$Companion;", "", "()V", "build", "Lcom/vector/config/NavBarConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        @d
        public final NavBarConfig a(@d l<? super NavBarConfig, t1> lVar) {
            NavBarConfig navBarConfig = new NavBarConfig(null);
            lVar.invoke(navBarConfig);
            return navBarConfig;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Shape.values().length];
            iArr[Shape.SQUARE.ordinal()] = 1;
            iArr[Shape.INSIDE.ordinal()] = 2;
            iArr[Shape.WRAP.ordinal()] = 3;
            a = iArr;
        }
    }

    private NavBarConfig() {
        this.a = Shape.WRAP;
        this.p = NavBarState.LINEAR;
        this.q = true;
    }

    public /* synthetic */ NavBarConfig(u uVar) {
        this();
    }

    @k
    @d
    public static final NavBarConfig a(@d l<? super NavBarConfig, t1> lVar) {
        return s.a(lVar);
    }

    public final void A(int i2) {
        this.o = i2;
    }

    public final void B(int i2) {
        this.b = i2;
        if (this.r == 0) {
            this.r = i2;
        }
    }

    public final void C(int i2) {
        this.f7655e = i2;
    }

    public final void D(int i2) {
        this.f7653c = i2;
    }

    public final void E(int i2) {
        this.r = i2;
    }

    public final void F(@d Shape shape) {
        this.a = shape;
        int i2 = b.a[shape.ordinal()];
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            z = false;
        }
        this.q = z;
    }

    public final void G(@d NavBarState navBarState) {
        this.p = navBarState;
    }

    public final void H(int i2) {
        this.f7658h = i2;
    }

    public final void I(int i2) {
        this.f7656f = i2;
    }

    public final void J(int i2) {
        this.f7654d = i2;
    }

    public final void K(boolean z) {
        this.q = z;
    }

    public final int b() {
        return this.f7660j;
    }

    public final int c() {
        return this.f7659i;
    }

    public final int d() {
        return this.f7661k;
    }

    public final int e() {
        return this.f7657g;
    }

    public final int f() {
        return this.f7662l;
    }

    public final int g() {
        return this.f7663m;
    }

    public final int h() {
        return this.n;
    }

    public final int i() {
        return this.o;
    }

    public final int j() {
        return this.b;
    }

    public final int k() {
        return this.f7655e;
    }

    public final int l() {
        return this.f7653c;
    }

    public final int m() {
        return this.r;
    }

    @d
    public final Shape n() {
        return this.a;
    }

    @d
    public final NavBarState o() {
        return this.p;
    }

    public final int p() {
        return this.f7658h;
    }

    public final int q() {
        return this.f7656f;
    }

    public final int r() {
        return this.f7654d;
    }

    public final boolean s() {
        return this.q;
    }

    public final void t(int i2) {
        this.f7660j = i2;
    }

    public final void u(int i2) {
        this.f7659i = i2;
    }

    public final void v(int i2) {
        this.f7661k = i2;
    }

    public final void w(int i2) {
        this.f7657g = i2;
    }

    public final void x(int i2) {
        this.f7662l = i2;
    }

    public final void y(int i2) {
        this.f7663m = i2;
    }

    public final void z(int i2) {
        this.n = i2;
    }
}
