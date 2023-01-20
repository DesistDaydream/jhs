package e.t.l;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u0004\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u0004¨\u0006\f"}, d2 = {"inflate", "Landroid/view/View;", "Landroidx/fragment/app/Fragment;", "res", "", "parent", "Landroid/view/ViewGroup;", "attachToRoot", "", "inflateEmptyOfDp", "value", "inflateEmptyOfPx", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class m {
    @k.e.a.d
    public static final View a(@k.e.a.d Fragment fragment, int i2, @k.e.a.e ViewGroup viewGroup, boolean z) {
        return k.h(fragment.requireContext(), i2, viewGroup, z);
    }

    public static /* synthetic */ View b(Fragment fragment, int i2, ViewGroup viewGroup, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            viewGroup = null;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return a(fragment, i2, viewGroup, z);
    }

    @k.e.a.d
    public static final View c(@k.e.a.d Fragment fragment, @Dimension(unit = 0) int i2) {
        return d(fragment, e.t.o.d.a.a(fragment.requireContext()).d(i2));
    }

    @k.e.a.d
    public static final View d(@k.e.a.d Fragment fragment, @Dimension(unit = 1) int i2) {
        return k.l(fragment.requireContext(), i2);
    }
}
