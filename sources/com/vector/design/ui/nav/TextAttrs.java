package com.vector.design.ui.nav;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.vector.design.ui.nav.AppBar;
import com.vector.ext.view.ViewKt;
import com.vector.util.Res;
import e.t.k.a.h.a;
import e.t.l.d0.g;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010?\u001a\u00020@2\u0006\u0010\u0002\u001a\u00020\u0003R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001e\u0010\u001b\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\"\u0010\u001e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001e\u0010!\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001e\u0010$\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b%\u0010\b\"\u0004\b&\u0010\nR\u001e\u0010'\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b(\u0010\b\"\u0004\b)\u0010\nR\u001e\u0010*\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\u001e\u0010-\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u001e\u00100\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b:\u0010\u0014\"\u0004\b;\u0010\u0016R\u001a\u0010<\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000f\"\u0004\b>\u0010\u0011¨\u0006A"}, d2 = {"Lcom/vector/design/ui/nav/TextAttrs;", "Lcom/vector/design/ui/nav/BaseAttrs;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bold", "", "getBold", "()Ljava/lang/Boolean;", "setBold", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "colorId", "", "getColorId", "()I", "setColorId", "(I)V", "colorInt", "getColorInt", "()Ljava/lang/Integer;", "setColorInt", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "drawableLeft", "getDrawableLeft", "setDrawableLeft", "drawablePadding", "getDrawablePadding", "setDrawablePadding", "drawableRight", "getDrawableRight", "setDrawableRight", "drawableSize", "getDrawableSize", "setDrawableSize", "enable", "getEnable", "setEnable", "marquee", "getMarquee", "setMarquee", "maxLength", "getMaxLength", "setMaxLength", "maxWidth", "getMaxWidth", "setMaxWidth", "padding", "getPadding", "setPadding", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textId", "getTextId", "setTextId", "textSize", "getTextSize", "setTextSize", "build", "Landroid/widget/TextView;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class TextAttrs extends a {
    @StringRes
    @e

    /* renamed from: d  reason: collision with root package name */
    private Integer f7791d;
    @e

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f7792e;
    @DrawableRes
    @e

    /* renamed from: f  reason: collision with root package name */
    private Integer f7793f;
    @DrawableRes
    @e

    /* renamed from: g  reason: collision with root package name */
    private Integer f7794g;
    @Dimension(unit = 1)

    /* renamed from: h  reason: collision with root package name */
    private int f7795h;
    @Dimension(unit = 1)

    /* renamed from: i  reason: collision with root package name */
    private int f7796i;
    @ColorRes

    /* renamed from: j  reason: collision with root package name */
    private int f7797j;
    @ColorInt
    @e

    /* renamed from: k  reason: collision with root package name */
    private Integer f7798k;

    /* renamed from: l  reason: collision with root package name */
    private int f7799l;
    @Dimension(unit = 1)

    /* renamed from: m  reason: collision with root package name */
    private int f7800m;
    @Dimension(unit = 1)
    private int n;
    @Dimension(unit = 1)
    private int o;
    @e
    private Boolean p;
    @e
    private Boolean q;
    @e
    private Boolean r;

    public TextAttrs(@d Context context) {
        super(context);
        AppBar.a aVar = AppBar.f7769h;
        this.f7795h = a(aVar.a().k());
        this.f7796i = a(aVar.a().l());
        this.f7797j = aVar.a().p();
        this.f7799l = aVar.a().r();
        this.o = a(aVar.a().q());
        this.p = Boolean.TRUE;
    }

    public final void A(@e Integer num) {
        this.f7793f = num;
    }

    public final void B(int i2) {
        this.f7795h = i2;
    }

    public final void C(@e Integer num) {
        this.f7794g = num;
    }

    public final void D(int i2) {
        this.f7796i = i2;
    }

    public final void E(@e Boolean bool) {
        this.q = bool;
    }

    public final void F(@e Boolean bool) {
        this.r = bool;
    }

    public final void G(int i2) {
        this.f7800m = i2;
    }

    public final void H(int i2) {
        this.n = i2;
    }

    public final void I(int i2) {
        this.o = i2;
    }

    public final void J(@e CharSequence charSequence) {
        this.f7792e = charSequence;
    }

    public final void K(@e Integer num) {
        this.f7791d = num;
    }

    public final void L(int i2) {
        this.f7799l = i2;
    }

    @d
    public final TextView h(@d Context context) {
        t1 t1Var;
        int i2;
        TextView textView = new TextView(context);
        textView.setGravity(17);
        int i3 = this.f7799l;
        if (i3 != 0) {
            textView.setTextSize(2, i3);
        }
        Integer num = this.f7798k;
        if (num == null) {
            t1Var = null;
        } else {
            textView.setTextColor(num.intValue());
            t1Var = t1.a;
        }
        if (t1Var == null && (i2 = this.f7797j) != 0) {
            textView.setTextColor(Res.a.l(i2));
        }
        int i4 = this.o;
        if (i4 != 0) {
            textView.setPadding(i4, 0, i4, 0);
        }
        int i5 = this.f7800m;
        if (i5 > 0) {
            textView.setMaxWidth(i5 * this.f7799l);
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
        }
        int i6 = this.n;
        if (i6 > 0) {
            textView.setMaxWidth(i6);
            textView.setSingleLine();
            textView.setEllipsize(f0.g(this.r, Boolean.TRUE) ? TextUtils.TruncateAt.MARQUEE : TextUtils.TruncateAt.END);
            textView.setMarqueeRepeatLimit(-1);
            textView.setFocusable(true);
            textView.setSelected(true);
            textView.setHorizontallyScrolling(true);
            textView.setTextIsSelectable(false);
        }
        Boolean bool = this.p;
        if (bool != null) {
            bool.booleanValue();
            textView.setTypeface(null, 1);
        }
        Boolean bool2 = this.q;
        if (bool2 != null) {
            textView.setEnabled(bool2.booleanValue());
        }
        l<View, t1> d2 = d();
        if (d2 != null) {
            ViewKt.B(textView, new TextAttrs$build$4$1(d2));
        }
        Integer num2 = this.f7791d;
        if (num2 != null && num2.intValue() != 0) {
            textView.setText(num2.intValue());
        } else {
            textView.setText(this.f7792e);
        }
        textView.setCompoundDrawablePadding(this.f7795h);
        int i7 = this.f7796i;
        if (i7 != 0) {
            Integer num3 = this.f7793f;
            Drawable p = (num3 == null || num3.intValue() == 0) ? null : Res.a.p(context, num3.intValue());
            Integer num4 = this.f7794g;
            Drawable p2 = (num4 == null || num4.intValue() == 0) ? null : Res.a.p(context, num4.intValue());
            if (p != null) {
                p.setBounds(0, 0, i7, i7);
            }
            if (p2 != null) {
                p2.setBounds(0, 0, i7, i7);
            }
            g.d(textView, p, null, p2, null, 10, null);
        } else {
            g.e(textView, this.f7793f, null, this.f7794g, null, 10, null);
        }
        AppBar.a aVar = AppBar.f7769h;
        e(textView, aVar.a().h(), aVar.a().i());
        return textView;
    }

    @e
    public final Boolean i() {
        return this.p;
    }

    public final int j() {
        return this.f7797j;
    }

    @e
    public final Integer k() {
        return this.f7798k;
    }

    @e
    public final Integer l() {
        return this.f7793f;
    }

    public final int m() {
        return this.f7795h;
    }

    @e
    public final Integer n() {
        return this.f7794g;
    }

    public final int o() {
        return this.f7796i;
    }

    @e
    public final Boolean p() {
        return this.q;
    }

    @e
    public final Boolean q() {
        return this.r;
    }

    public final int r() {
        return this.f7800m;
    }

    public final int s() {
        return this.n;
    }

    public final int t() {
        return this.o;
    }

    @e
    public final CharSequence u() {
        return this.f7792e;
    }

    @e
    public final Integer v() {
        return this.f7791d;
    }

    public final int w() {
        return this.f7799l;
    }

    public final void x(@e Boolean bool) {
        this.p = bool;
    }

    public final void y(int i2) {
        this.f7797j = i2;
    }

    public final void z(@e Integer num) {
        this.f7798k = num;
    }
}
