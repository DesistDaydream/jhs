package com.vector.design.ui.nav;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.IntRange;
import com.tencent.android.tpush.common.MessageKey;
import com.vector.R;
import com.vector.design.ui.nav.AppBar;
import com.vector.util.Res;
import com.vector.util.UIUtil;
import e.t.a;
import e.t.o.d;
import e.t.u.p;
import h.k2.h;
import h.k2.v.u;
import h.t1;
import h.w;
import h.z;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010*\u001a\u00020+R&\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b#\u0010 R\u001b\u0010%\u001a\u00020&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001c\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/vector/design/ui/nav/AppBar2;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "backgroundAlpha", "getBackgroundAlpha", "()I", "setBackgroundAlpha", "(I)V", "divider", "Landroid/view/View;", "", "dividerEnable", "getDividerEnable", "()Z", "setDividerEnable", "(Z)V", MessageKey.MSG_ACCEPT_TIME_END, "Lcom/vector/design/ui/nav/EndLayout;", "getEnd", "()Lcom/vector/design/ui/nav/EndLayout;", "end$delegate", "Lkotlin/Lazy;", "mid", "Lcom/vector/design/ui/nav/MidLayout;", "getMid", "()Lcom/vector/design/ui/nav/MidLayout;", "mid$delegate", "midAlign", "getMidAlign", "midAlign$delegate", MessageKey.MSG_ACCEPT_TIME_START, "Lcom/vector/design/ui/nav/StartLayout;", "getStart", "()Lcom/vector/design/ui/nav/StartLayout;", "start$delegate", "onlyFlatBar", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AppBar2 extends RelativeLayout {
    @d
    private final w a;
    @d
    private final w b;
    @d

    /* renamed from: c */
    private final w f7776c;
    @d

    /* renamed from: d */
    private final w f7777d;
    @e

    /* renamed from: e */
    private View f7778e;

    /* renamed from: f */
    private boolean f7779f;
    @IntRange(from = 0, to = 255)

    /* renamed from: g */
    private int f7780g;

    @h
    public AppBar2(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public AppBar2(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ AppBar2(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void a() {
    }

    public final int getBackgroundAlpha() {
        return this.f7780g;
    }

    public final boolean getDividerEnable() {
        return this.f7779f;
    }

    @d
    public final EndLayout getEnd() {
        return (EndLayout) this.f7777d.getValue();
    }

    @d
    public final MidLayout getMid() {
        return (MidLayout) this.b.getValue();
    }

    @d
    public final MidLayout getMidAlign() {
        return (MidLayout) this.f7776c.getValue();
    }

    @d
    public final StartLayout getStart() {
        return (StartLayout) this.a.getValue();
    }

    public final void setBackgroundAlpha(int i2) {
        getBackground().setAlpha(i2);
        View view = this.f7778e;
        Drawable background = view == null ? null : view.getBackground();
        if (background != null) {
            background.setAlpha(i2);
        }
        this.f7780g = i2;
    }

    public final void setDividerEnable(boolean z) {
        if (z == this.f7779f) {
            return;
        }
        if (z) {
            AppBar.a aVar = AppBar.f7769h;
            int e2 = aVar.a().e();
            if (e2 != 0) {
                View view = new View(getContext());
                view.setId(R.id.app_bar_divider);
                if (aVar.a().d() != 0) {
                    view.setBackgroundResource(aVar.a().d());
                }
                t1 t1Var = t1.a;
                this.f7778e = view;
                RelativeLayout.LayoutParams p = p.p(-1, e2);
                p.addRule(8, getMid().getId());
                addView(this.f7778e, p);
            }
        } else {
            removeView(this.f7778e);
            this.f7778e = null;
        }
        this.f7779f = z;
    }

    @h
    public AppBar2(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = z.c(new AppBar2$start$2(context, this));
        this.b = z.c(new AppBar2$mid$2(context, this));
        this.f7776c = z.c(new AppBar2$midAlign$2(context, this));
        this.f7777d = z.c(new AppBar2$end$2(context, this));
        AppBar.a aVar = AppBar.f7769h;
        int c2 = aVar.a().c();
        if (c2 != 0) {
            setBackgroundResource(c2);
        } else {
            int b = aVar.a().b();
            if (b != 0) {
                setBackgroundColor(Res.k(b));
            }
        }
        if (a.a().e()) {
            View view = new View(context);
            view.setId(R.id.flat_bar);
            addView(view, p.p(-1, UIUtil.c() + d.a.c(e.t.o.d.a, null, 1, null).d(7)));
        }
    }
}
