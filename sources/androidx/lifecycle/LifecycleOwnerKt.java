package androidx.lifecycle;

import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "getLifecycleScope", "(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class LifecycleOwnerKt {
    @d
    public static final LifecycleCoroutineScope getLifecycleScope(@d LifecycleOwner lifecycleOwner) {
        return LifecycleKt.getCoroutineScope(lifecycleOwner.getLifecycle());
    }
}
