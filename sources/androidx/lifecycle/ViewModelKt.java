package androidx.lifecycle;

import i.b.b1;
import i.b.e3;
import i.b.n0;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/lifecycle/ViewModel;", "Li/b/n0;", "getViewModelScope", "(Landroidx/lifecycle/ViewModel;)Li/b/n0;", "viewModelScope", "", "JOB_KEY", "Ljava/lang/String;", "lifecycle-viewmodel-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class ViewModelKt {
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    @d
    public static final n0 getViewModelScope(@d ViewModel viewModel) {
        n0 n0Var = (n0) viewModel.getTag(JOB_KEY);
        return n0Var != null ? n0Var : (n0) viewModel.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(e3.c(null, 1, null).plus(b1.e().z0())));
    }
}
