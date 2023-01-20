package e.t.j.g;

import android.view.View;
import androidx.databinding.BindingAdapter;
import androidx.gridlayout.widget.GridLayout;
import e.t.j.g.v;
import h.t1;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/vector/databinding/adapter/GridLayoutBinding;", "", "()V", "COLUMN_COUNT", "", "DATA", "setData", "", "view", "Landroidx/gridlayout/widget/GridLayout;", "data", "", "Lcom/vector/databinding/adapter/GridLayoutSet;", "columnCount", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class t {
    @k.e.a.d
    public static final t a = new t();
    @k.e.a.d
    private static final String b = "android:gridLayout_data";
    @k.e.a.d

    /* renamed from: c */
    private static final String f14515c = "android:gridLayout_columnCount";

    private t() {
    }

    public static /* synthetic */ void a(h.k2.u.l lVar, View view) {
        d(lVar, view);
    }

    @BindingAdapter(requireAll = false, value = {b, f14515c})
    @h.k2.k
    public static final void b(@k.e.a.d GridLayout gridLayout, @k.e.a.e List<v> list, int i2) {
        t1 t1Var;
        gridLayout.removeAllViews();
        gridLayout.setColumnCount(i2);
        if (list == null) {
            return;
        }
        for (v vVar : list) {
            View c2 = vVar.c();
            if (c2 == null) {
                c2 = e.t.l.k.i(gridLayout.getContext(), vVar.b(), null, false, 6, null);
            }
            h.k2.u.l<View, t1> f2 = vVar.f();
            if (f2 != null) {
                f2.invoke(c2);
            }
            final h.k2.u.l<View, t1> e2 = vVar.e();
            if (e2 != null) {
                c2.setOnClickListener(new View.OnClickListener() { // from class: e.t.j.g.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        t.a(e2, view);
                    }
                });
            }
            if (vVar.a()) {
                v.a d2 = vVar.d();
                if (d2 == null) {
                    t1Var = null;
                } else {
                    gridLayout.addView(c2, e.t.u.p.k(null, null, d2.a() / i2, 0, 11, null));
                    t1Var = t1.a;
                }
                if (t1Var == null) {
                    gridLayout.addView(c2);
                }
            } else {
                gridLayout.addView(c2);
            }
        }
    }

    public static /* synthetic */ void c(GridLayout gridLayout, List list, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 1;
        }
        b(gridLayout, list, i2);
    }

    public static final void d(h.k2.u.l lVar, View view) {
        lVar.invoke(view);
    }
}
