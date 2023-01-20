package e.t.k.a.h;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.view.ViewCompat;
import com.vector.R;
import com.vector.config.AppBarConfig;
import com.vector.design.ui.nav.AppBar;
import e.t.u.p;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0004J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\"\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00102\b\b\u0001\u0010\u001c\u001a\u00020\u00062\b\b\u0001\u0010\u001d\u001a\u00020\u0006R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fj\u0004\u0018\u0001`\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/vector/design/ui/nav/BaseAttrs;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "backgroundRes", "", "getBackgroundRes", "()Ljava/lang/Integer;", "setBackgroundRes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getContext", "()Landroid/content/Context;", "onClick", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lcom/vector/design/ui/nav/ClickAction;", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "convert", "dp", "convertToInside", "v", "setBackground", "color", "drawableRes", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class a {
    @d
    private final Context a;
    @e
    private l<? super View, t1> b;
    @DrawableRes
    @e

    /* renamed from: c */
    private Integer f14572c;

    public a(@d Context context) {
        this.a = context;
    }

    private final View b(View view) {
        RelativeLayout.LayoutParams layoutParams;
        if (view instanceof ViewGroup) {
            if (Build.VERSION.SDK_INT < 28) {
                view.setBackgroundResource(R.drawable.selector_fake_item);
            }
            View view2 = new View(this.a);
            int a = a(AppBar.f7769h.a().m());
            int sqrt = (int) (a / Math.sqrt(2.0d));
            if (view instanceof RelativeLayout) {
                RelativeLayout.LayoutParams p = p.p(sqrt, sqrt);
                p.addRule(13);
                layoutParams = p;
            } else {
                ViewGroup.MarginLayoutParams x = p.x(-1, -1);
                int i2 = (a - sqrt) / 2;
                x.setMargins(i2, i2, i2, i2);
                layoutParams = x;
            }
            ((ViewGroup) view).addView(view2, layoutParams);
            return view2;
        }
        return view;
    }

    public final int a(int i2) {
        return i2 == 0 ? i2 : e.t.o.d.a.a(this.a).d(i2);
    }

    @e
    public final Integer c() {
        return this.f14572c;
    }

    @e
    public final l<View, t1> d() {
        return this.b;
    }

    public final void e(@d View view, @ColorInt int i2, @DrawableRes int i3) {
        Integer num = this.f14572c;
        if (num != null) {
            view.setBackgroundResource(num.intValue());
            return;
        }
        if (AppBar.f7769h.a().n() == AppBarConfig.Shape.INSIDE) {
            view = b(view);
        }
        if (i2 == 0) {
            if (i3 != 0) {
                view.setBackgroundResource(i3);
                return;
            }
            return;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(i2));
        stateListDrawable.addState(new int[]{-16842919}, colorDrawable);
        ViewCompat.setBackground(view, stateListDrawable);
    }

    public final void f(@e Integer num) {
        this.f14572c = num;
    }

    public final void g(@e l<? super View, t1> lVar) {
        this.b = lVar;
    }

    @d
    public final Context getContext() {
        return this.a;
    }
}
