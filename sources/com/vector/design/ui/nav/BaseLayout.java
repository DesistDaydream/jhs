package com.vector.design.ui.nav;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.qiniu.android.collect.ReportItem;
import com.vector.R;
import com.vector.design.ui.nav.AppBar;
import com.vector.util.Res;
import e.t.a;
import e.t.u.p;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nJ!\u0010\t\u001a\u0004\u0018\u00010\n2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010J\u001f\u0010\u0011\u001a\u00020\n2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010J(\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u0013\u001a\u00020\u00072\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u0015J\u001f\u0010\u0016\u001a\u00020\u00172\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010J\"\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020#H\u0016¨\u0006$"}, d2 = {"Lcom/vector/design/ui/nav/BaseLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "add", "Landroid/view/View;", "v", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Lcom/vector/design/ui/nav/ViewAttrs;", "", "Lkotlin/ExtensionFunctionType;", "addImage", "Lcom/vector/design/ui/nav/ImageAttrs;", "id", "onClick", "Lcom/vector/design/ui/nav/ClickAction;", "addText", "Landroid/widget/TextView;", "Lcom/vector/design/ui/nav/TextAttrs;", "bold", "", "text", "", "convert", "dp", "getLinearParams", "Landroid/widget/LinearLayout$LayoutParams;", "getTextParams", "params", "Landroid/widget/RelativeLayout$LayoutParams;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseLayout extends LinearLayout {
    @h
    public BaseLayout(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public BaseLayout(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ BaseLayout(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final LinearLayout.LayoutParams getLinearParams() {
        AppBar.a aVar = AppBar.f7769h;
        int i2 = i(aVar.a().j());
        if (i2 == 0) {
            i2 = -2;
        }
        LinearLayout.LayoutParams l2 = p.l(aVar.a().s() ? i2 : -2, i2);
        l2.gravity = 17;
        l2.weight = 0.0f;
        return l2;
    }

    private final LinearLayout.LayoutParams getTextParams() {
        int i2 = i(AppBar.f7769h.a().j());
        if (i2 == 0) {
            i2 = -2;
        }
        LinearLayout.LayoutParams l2 = p.l(-2, i2);
        l2.gravity = 17;
        l2.weight = 0.0f;
        return l2;
    }

    public static /* synthetic */ TextView h(BaseLayout baseLayout, int i2, Context context, boolean z, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z = false;
            }
            return baseLayout.e(i2, context, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addText");
    }

    private final int i(int i2) {
        return i2 == 0 ? i2 : e.t.o.d.a.a(getContext()).d(i2);
    }

    @e
    public final View a(@d View view) {
        return b(new BaseLayout$add$2(view));
    }

    @e
    public final View b(@d l<? super ViewAttrs, t1> lVar) {
        ViewAttrs viewAttrs = new ViewAttrs(getContext());
        lVar.invoke(viewAttrs);
        View h2 = viewAttrs.h();
        if (h2 != null) {
            addView(h2);
        }
        return viewAttrs.m();
    }

    @d
    public final View c(@DrawableRes int i2, @d l<? super View, t1> lVar) {
        ImageAttrs imageAttrs = new ImageAttrs(getContext());
        imageAttrs.x(i2);
        imageAttrs.g(lVar);
        View h2 = imageAttrs.h(getContext());
        addView(h2, getLinearParams());
        return h2;
    }

    @d
    public final View d(@d l<? super ImageAttrs, t1> lVar) {
        ImageAttrs imageAttrs = new ImageAttrs(getContext());
        lVar.invoke(imageAttrs);
        View h2 = imageAttrs.h(getContext());
        addView(h2, getLinearParams());
        return h2;
    }

    @d
    public final TextView e(@StringRes int i2, @d Context context, boolean z) {
        return f(Res.a.u(i2, context), z);
    }

    @d
    public final TextView f(@d String str, boolean z) {
        return g(new BaseLayout$addText$1(str, z));
    }

    @d
    public final TextView g(@d l<? super TextAttrs, t1> lVar) {
        TextAttrs textAttrs = new TextAttrs(getContext());
        lVar.invoke(textAttrs);
        TextView h2 = textAttrs.h(getContext());
        addView(h2, getTextParams());
        return h2;
    }

    @d
    public RelativeLayout.LayoutParams j() {
        int i2 = i(AppBar.f7769h.a().j());
        if (i2 == 0) {
            i2 = -2;
        }
        RelativeLayout.LayoutParams p = p.p(-2, i2);
        p.addRule(15);
        if (a.a().e()) {
            p.addRule(3, R.id.flat_bar);
        }
        return p;
    }

    @h
    public BaseLayout(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setOrientation(0);
        setGravity(17);
    }
}
