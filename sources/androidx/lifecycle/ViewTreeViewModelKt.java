package androidx.lifecycle;

import android.view.View;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/view/View;", "Landroidx/lifecycle/ViewModelStoreOwner;", "findViewTreeViewModelStoreOwner", "(Landroid/view/View;)Landroidx/lifecycle/ViewModelStoreOwner;", "lifecycle-viewmodel-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class ViewTreeViewModelKt {
    @e
    public static final ViewModelStoreOwner findViewTreeViewModelStoreOwner(@d View view) {
        return ViewTreeViewModelStoreOwner.get(view);
    }
}
