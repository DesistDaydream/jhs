package com.vector.design.ui.nav;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.vector.design.ui.nav.AppBar;
import com.vector.ext.view.ViewKt;
import e.t.k.a.h.a;
import e.t.u.p;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010 \u001a\u0004\u0018\u00010\u0018R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/vector/design/ui/nav/ViewAttrs;", "Lcom/vector/design/ui/nav/BaseAttrs;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "gravity", "", "getGravity", "()Ljava/lang/Integer;", "setGravity", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "height", "getHeight", "()I", "setHeight", "(I)V", "marginEnd", "getMarginEnd", "setMarginEnd", "marginStart", "getMarginStart", "setMarginStart", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "width", "getWidth", "setWidth", "build", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewAttrs extends a {

    /* renamed from: d  reason: collision with root package name */
    private int f7801d;

    /* renamed from: e  reason: collision with root package name */
    private int f7802e;
    @e

    /* renamed from: f  reason: collision with root package name */
    private Integer f7803f;

    /* renamed from: g  reason: collision with root package name */
    private int f7804g;

    /* renamed from: h  reason: collision with root package name */
    private int f7805h;
    @e

    /* renamed from: i  reason: collision with root package name */
    private View f7806i;

    public ViewAttrs(@d Context context) {
        super(context);
        this.f7801d = -2;
        this.f7802e = -2;
    }

    @e
    public final View h() {
        View view = this.f7806i;
        if (view == null) {
            return null;
        }
        l<View, t1> d2 = d();
        if (d2 != null) {
            ViewKt.B(view, new ViewAttrs$build$1$1(d2));
        }
        LinearLayout.LayoutParams l2 = p.l(this.f7801d, this.f7802e);
        l2.setMarginEnd(this.f7804g);
        l2.setMarginStart(this.f7805h);
        Integer num = this.f7803f;
        l2.gravity = num == null ? 17 : num.intValue();
        view.setLayoutParams(l2);
        AppBar.a aVar = AppBar.f7769h;
        e(view, aVar.a().f(), aVar.a().g());
        return view;
    }

    @e
    public final Integer i() {
        return this.f7803f;
    }

    public final int j() {
        return this.f7802e;
    }

    public final int k() {
        return this.f7804g;
    }

    public final int l() {
        return this.f7805h;
    }

    @e
    public final View m() {
        return this.f7806i;
    }

    public final int n() {
        return this.f7801d;
    }

    public final void o(@e Integer num) {
        this.f7803f = num;
    }

    public final void p(int i2) {
        this.f7802e = i2;
    }

    public final void q(int i2) {
        this.f7804g = i2;
    }

    public final void r(int i2) {
        this.f7805h = i2;
    }

    public final void s(@e View view) {
        this.f7806i = view;
    }

    public final void t(int i2) {
        this.f7801d = i2;
    }
}
