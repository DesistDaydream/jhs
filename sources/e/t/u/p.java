package e.t.u;

import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.gridlayout.widget.GridLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007J0\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0007J\u001c\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0007J\u001c\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J0\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u001c\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u001c\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u001c\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u001c\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0005\u001a\u00020\t2\b\b\u0002\u0010\u0007\u001a\u00020\tH\u0007J\u001c\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u001c\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u001c\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006#"}, d2 = {"Lcom/vector/util/LPUtil;", "", "()V", "abs", "Landroid/widget/AbsoluteLayout$LayoutParams;", IAdInterListener.AdReqParam.WIDTH, "", "h", "x", "", "y", "constraint", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "left", "top", "right", "bottom", TypedValues.Attributes.S_FRAME, "Landroid/widget/FrameLayout$LayoutParams;", "grid", "Landroidx/gridlayout/widget/GridLayout$LayoutParams;", "rowSpec", "Landroidx/gridlayout/widget/GridLayout$Spec;", "columnSpec", "linear", "Landroid/widget/LinearLayout$LayoutParams;", "listView", "Landroid/widget/AbsListView$LayoutParams;", "relative", "Landroid/widget/RelativeLayout$LayoutParams;", "scrollView", "Landroid/view/ViewGroup$LayoutParams;", "viewGroup", "viewGroupMargin", "Landroid/view/ViewGroup$MarginLayoutParams;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class p {
    @k.e.a.d
    public static final p a = new p();

    private p() {
    }

    @h.k2.k
    @k.e.a.d
    public static final AbsoluteLayout.LayoutParams a(int i2, int i3, float f2, float f3) {
        return b(i2, i3, (int) f2, (int) f3);
    }

    @h.k2.k
    @k.e.a.d
    public static final AbsoluteLayout.LayoutParams b(int i2, int i3, int i4, int i5) {
        return new AbsoluteLayout.LayoutParams(i2, i3, i4, i5);
    }

    public static /* synthetic */ AbsoluteLayout.LayoutParams c(int i2, int i3, float f2, float f3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = -2;
        }
        if ((i4 & 2) != 0) {
            i3 = -2;
        }
        if ((i4 & 4) != 0) {
            f2 = 0.0f;
        }
        if ((i4 & 8) != 0) {
            f3 = 0.0f;
        }
        return a(i2, i3, f2, f3);
    }

    public static /* synthetic */ AbsoluteLayout.LayoutParams d(int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = -2;
        }
        if ((i6 & 2) != 0) {
            i3 = -2;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return b(i2, i3, i4, i5);
    }

    @h.k2.k
    @k.e.a.d
    public static final ConstraintLayout.LayoutParams e(int i2, int i3) {
        return new ConstraintLayout.LayoutParams(i2, i3);
    }

    @h.k2.k
    @k.e.a.d
    public static final ConstraintLayout.LayoutParams f(int i2, int i3, int i4, int i5) {
        ConstraintLayout.LayoutParams g2 = g(0, 0, 3, null);
        g2.leftToLeft = i2;
        g2.topToTop = i3;
        g2.rightToRight = i4;
        g2.bottomToBottom = i5;
        return g2;
    }

    public static /* synthetic */ ConstraintLayout.LayoutParams g(int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = -1;
        }
        if ((i4 & 2) != 0) {
            i3 = -1;
        }
        return e(i2, i3);
    }

    @h.k2.k
    @k.e.a.d
    public static final FrameLayout.LayoutParams h(int i2, int i3) {
        return new FrameLayout.LayoutParams(i2, i3);
    }

    public static /* synthetic */ FrameLayout.LayoutParams i(int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = -1;
        }
        if ((i4 & 2) != 0) {
            i3 = -2;
        }
        return h(i2, i3);
    }

    @h.k2.k
    @k.e.a.d
    public static final GridLayout.LayoutParams j(@k.e.a.d GridLayout.Spec spec, @k.e.a.d GridLayout.Spec spec2, int i2, int i3) {
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(spec, spec2);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = i2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = i3;
        return layoutParams;
    }

    public static /* synthetic */ GridLayout.LayoutParams k(GridLayout.Spec spec, GridLayout.Spec spec2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            spec = GridLayout.spec(Integer.MIN_VALUE);
        }
        if ((i4 & 2) != 0) {
            spec2 = GridLayout.spec(Integer.MIN_VALUE);
        }
        if ((i4 & 4) != 0) {
            i2 = -2;
        }
        if ((i4 & 8) != 0) {
            i3 = -2;
        }
        return j(spec, spec2, i2, i3);
    }

    @h.k2.k
    @k.e.a.d
    public static final LinearLayout.LayoutParams l(int i2, int i3) {
        return new LinearLayout.LayoutParams(i2, i3);
    }

    public static /* synthetic */ LinearLayout.LayoutParams m(int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = -1;
        }
        if ((i4 & 2) != 0) {
            i3 = -2;
        }
        return l(i2, i3);
    }

    @h.k2.k
    @k.e.a.d
    public static final AbsListView.LayoutParams n(int i2, int i3) {
        return new AbsListView.LayoutParams(i2, i3);
    }

    public static /* synthetic */ AbsListView.LayoutParams o(int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = -1;
        }
        if ((i4 & 2) != 0) {
            i3 = -1;
        }
        return n(i2, i3);
    }

    @h.k2.k
    @k.e.a.d
    public static final RelativeLayout.LayoutParams p(int i2, int i3) {
        return new RelativeLayout.LayoutParams(i2, i3);
    }

    public static /* synthetic */ RelativeLayout.LayoutParams q(int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = -1;
        }
        if ((i4 & 2) != 0) {
            i3 = -2;
        }
        return p(i2, i3);
    }

    @h.k2.k
    @k.e.a.d
    public static final ViewGroup.LayoutParams r(float f2, float f3) {
        return s((int) f2, (int) f3);
    }

    @h.k2.k
    @k.e.a.d
    public static final ViewGroup.LayoutParams s(int i2, int i3) {
        return new ViewGroup.LayoutParams(i2, i3);
    }

    public static /* synthetic */ ViewGroup.LayoutParams t(float f2, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        return r(f2, f3);
    }

    public static /* synthetic */ ViewGroup.LayoutParams u(int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = -1;
        }
        if ((i4 & 2) != 0) {
            i3 = -1;
        }
        return s(i2, i3);
    }

    @h.k2.k
    @k.e.a.d
    public static final ViewGroup.LayoutParams v(int i2, int i3) {
        return new ViewGroup.LayoutParams(i2, i3);
    }

    public static /* synthetic */ ViewGroup.LayoutParams w(int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = -1;
        }
        if ((i4 & 2) != 0) {
            i3 = -2;
        }
        return v(i2, i3);
    }

    @h.k2.k
    @k.e.a.d
    public static final ViewGroup.MarginLayoutParams x(int i2, int i3) {
        return new ViewGroup.MarginLayoutParams(i2, i3);
    }

    public static /* synthetic */ ViewGroup.MarginLayoutParams y(int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = -1;
        }
        if ((i4 & 2) != 0) {
            i3 = -2;
        }
        return x(i2, i3);
    }
}
