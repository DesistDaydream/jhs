package e.t.l.d0;

import android.view.View;
import android.view.ViewGroup;
import com.qiniu.android.collect.ReportItem;
import h.k2.u.l;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¨\u0006\u0006"}, d2 = {"forEachChild", "", "Landroid/view/ViewGroup;", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Landroid/view/View;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class h {
    public static final void a(@k.e.a.d ViewGroup viewGroup, @k.e.a.d l<? super View, t1> lVar) {
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            lVar.invoke(viewGroup.getChildAt(i2));
            if (i3 >= childCount) {
                return;
            }
            i2 = i3;
        }
    }
}
