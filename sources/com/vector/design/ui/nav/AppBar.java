package com.vector.design.ui.nav;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.IntRange;
import com.tencent.android.tpush.common.MessageKey;
import com.vector.R;
import com.vector.config.AppBarConfig;
import com.vector.util.Res;
import com.vector.util.UIUtil;
import e.t.u.p;
import h.k2.h;
import h.k2.v.u;
import h.t1;
import h.w;
import h.z;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010*\u001a\u00020+R&\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b#\u0010 R\u001b\u0010%\u001a\u00020&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001c\u001a\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lcom/vector/design/ui/nav/AppBar;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "backgroundAlpha", "getBackgroundAlpha", "()I", "setBackgroundAlpha", "(I)V", "divider", "Landroid/view/View;", "", "dividerEnable", "getDividerEnable", "()Z", "setDividerEnable", "(Z)V", MessageKey.MSG_ACCEPT_TIME_END, "Lcom/vector/design/ui/nav/EndLayout;", "getEnd", "()Lcom/vector/design/ui/nav/EndLayout;", "end$delegate", "Lkotlin/Lazy;", "mid", "Lcom/vector/design/ui/nav/MidLayout;", "getMid", "()Lcom/vector/design/ui/nav/MidLayout;", "mid$delegate", "midAlign", "getMidAlign", "midAlign$delegate", MessageKey.MSG_ACCEPT_TIME_START, "Lcom/vector/design/ui/nav/StartLayout;", "getStart", "()Lcom/vector/design/ui/nav/StartLayout;", "start$delegate", "onlyFlatBar", "", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AppBar extends RelativeLayout {
    @d

    /* renamed from: h */
    public static final a f7769h = new a(null);

    /* renamed from: i */
    private static AppBarConfig f7770i;
    @d
    private final w a;
    @d
    private final w b;
    @d

    /* renamed from: c */
    private final w f7771c;
    @d

    /* renamed from: d */
    private final w f7772d;
    @e

    /* renamed from: e */
    private View f7773e;

    /* renamed from: f */
    private boolean f7774f;
    @IntRange(from = 0, to = 255)

    /* renamed from: g */
    private int f7775g;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/vector/design/ui/nav/AppBar$Companion;", "", "()V", "<set-?>", "Lcom/vector/config/AppBarConfig;", "config", "getConfig", "()Lcom/vector/config/AppBarConfig;", "init", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final AppBarConfig a() {
            AppBarConfig appBarConfig = AppBar.f7770i;
            Objects.requireNonNull(appBarConfig);
            return appBarConfig;
        }

        public final void b(@d AppBarConfig appBarConfig) {
            AppBar.f7770i = appBarConfig;
        }
    }

    @h
    public AppBar(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public AppBar(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ AppBar(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void c() {
    }

    public final int getBackgroundAlpha() {
        return this.f7775g;
    }

    public final boolean getDividerEnable() {
        return this.f7774f;
    }

    @d
    public final EndLayout getEnd() {
        return (EndLayout) this.f7772d.getValue();
    }

    @d
    public final MidLayout getMid() {
        return (MidLayout) this.b.getValue();
    }

    @d
    public final MidLayout getMidAlign() {
        return (MidLayout) this.f7771c.getValue();
    }

    @d
    public final StartLayout getStart() {
        return (StartLayout) this.a.getValue();
    }

    public final void setBackgroundAlpha(int i2) {
        getBackground().setAlpha(i2);
        View view = this.f7773e;
        Drawable background = view == null ? null : view.getBackground();
        if (background != null) {
            background.setAlpha(i2);
        }
        this.f7775g = i2;
    }

    public final void setDividerEnable(boolean z) {
        if (z == this.f7774f) {
            return;
        }
        if (z) {
            a aVar = f7769h;
            int e2 = aVar.a().e();
            if (e2 != 0) {
                View view = new View(getContext());
                view.setId(R.id.app_bar_divider);
                if (aVar.a().d() != 0) {
                    view.setBackgroundResource(aVar.a().d());
                }
                t1 t1Var = t1.a;
                this.f7773e = view;
                RelativeLayout.LayoutParams p = p.p(-1, e2);
                p.addRule(8, getMid().getId());
                addView(this.f7773e, p);
            }
        } else {
            removeView(this.f7773e);
            this.f7773e = null;
        }
        this.f7774f = z;
    }

    @h
    public AppBar(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = z.c(new AppBar$start$2(context, this));
        this.b = z.c(new AppBar$mid$2(context, this));
        this.f7771c = z.c(new AppBar$midAlign$2(context, this));
        this.f7772d = z.c(new AppBar$end$2(context, this));
        a aVar = f7769h;
        int c2 = aVar.a().c();
        if (c2 != 0) {
            setBackgroundResource(c2);
        } else {
            int b = aVar.a().b();
            if (b != 0) {
                setBackgroundColor(Res.k(b));
            }
        }
        if (e.t.a.a().e()) {
            View view = new View(context);
            view.setId(R.id.flat_bar);
            addView(view, p.p(-1, UIUtil.c()));
        }
    }
}
