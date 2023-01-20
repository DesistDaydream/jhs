package com.vector.design.ui.nav;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.DrawableRes;
import com.vector.design.ui.nav.AppBar;
import com.vector.ext.view.ViewKt;
import e.t.k.a.h.a;
import e.t.u.p;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u00102\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u0003R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001e\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR\u001a\u0010 \u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\nR\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\b\"\u0004\b1\u0010\n¨\u00064"}, d2 = {"Lcom/vector/design/ui/nav/ImageAttrs;", "Lcom/vector/design/ui/nav/BaseAttrs;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bg", "", "getBg", "()I", "setBg", "(I)V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "height", "getHeight", "setHeight", "iconSize", "getIconSize", "setIconSize", "id", "getId", "setId", "marginEnd", "getMarginEnd", "setMarginEnd", "marginStart", "getMarginStart", "setMarginStart", "padding", "getPadding", "setPadding", "rtlMirror", "", "getRtlMirror", "()Z", "setRtlMirror", "(Z)V", "tint", "Landroid/content/res/ColorStateList;", "getTint", "()Landroid/content/res/ColorStateList;", "setTint", "(Landroid/content/res/ColorStateList;)V", "width", "getWidth", "setWidth", "build", "Landroid/view/View;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageAttrs extends a {

    /* renamed from: d */
    private int f7781d;

    /* renamed from: e */
    private int f7782e;
    @DrawableRes

    /* renamed from: f */
    private int f7783f;
    @e

    /* renamed from: g */
    private Drawable f7784g;

    /* renamed from: h */
    private int f7785h;

    /* renamed from: i */
    private int f7786i;

    /* renamed from: j */
    private boolean f7787j;
    @e

    /* renamed from: k */
    private ColorStateList f7788k;

    /* renamed from: l */
    private int f7789l;

    /* renamed from: m */
    private int f7790m;
    private int n;

    public ImageAttrs(@d Context context) {
        super(context);
        AppBar.a aVar = AppBar.f7769h;
        this.f7785h = a(aVar.a().l());
        this.f7786i = a(aVar.a().k());
    }

    public final void A(int i2) {
        this.f7786i = i2;
    }

    public final void B(boolean z) {
        this.f7787j = z;
    }

    public final void C(@e ColorStateList colorStateList) {
        this.f7788k = colorStateList;
    }

    public final void D(int i2) {
        this.f7781d = i2;
    }

    @d
    public final View h(@d Context context) {
        RelativeLayout.LayoutParams p;
        Drawable drawable;
        int i2;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        int i3 = this.f7781d;
        if (i3 != 0 && (i2 = this.f7782e) != 0) {
            p = p.p(i3, i2);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            int i4 = this.f7785h;
            if (i4 != 0) {
                p = p.p(i4, i4);
            } else {
                p = p.p(-2, -2);
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
        }
        int i5 = this.f7783f;
        if (i5 != 0) {
            imageView.setImageResource(i5);
        }
        Drawable drawable2 = this.f7784g;
        if (drawable2 != null) {
            imageView.setImageDrawable(drawable2);
        }
        ColorStateList colorStateList = this.f7788k;
        if (colorStateList != null) {
            imageView.setImageTintList(colorStateList);
        }
        if (this.f7787j && (drawable = imageView.getDrawable()) != null) {
            drawable.setAutoMirrored(true);
        }
        int i6 = this.f7786i;
        imageView.setPadding(i6, 0, i6, 0);
        p.setMarginStart(this.f7790m);
        p.setMarginEnd(this.n);
        p.addRule(13);
        relativeLayout.addView(imageView, p);
        l<View, t1> d2 = d();
        if (d2 != null) {
            ViewKt.B(relativeLayout, new ImageAttrs$build$1$1(d2));
        }
        int i7 = this.f7789l;
        if (i7 != 0) {
            imageView.setBackgroundResource(i7);
        }
        return relativeLayout;
    }

    public final int i() {
        return this.f7789l;
    }

    @e
    public final Drawable j() {
        return this.f7784g;
    }

    public final int k() {
        return this.f7782e;
    }

    public final int l() {
        return this.f7785h;
    }

    public final int m() {
        return this.f7783f;
    }

    public final int n() {
        return this.n;
    }

    public final int o() {
        return this.f7790m;
    }

    public final int p() {
        return this.f7786i;
    }

    public final boolean q() {
        return this.f7787j;
    }

    @e
    public final ColorStateList r() {
        return this.f7788k;
    }

    public final int s() {
        return this.f7781d;
    }

    public final void t(int i2) {
        this.f7789l = i2;
    }

    public final void u(@e Drawable drawable) {
        this.f7784g = drawable;
    }

    public final void v(int i2) {
        this.f7782e = i2;
    }

    public final void w(int i2) {
        this.f7785h = i2;
    }

    public final void x(int i2) {
        this.f7783f = i2;
    }

    public final void y(int i2) {
        this.n = i2;
    }

    public final void z(int i2) {
        this.f7790m = i2;
    }
}
