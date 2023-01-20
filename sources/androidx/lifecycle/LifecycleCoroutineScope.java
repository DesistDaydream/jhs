package androidx.lifecycle;

import com.qiniu.android.collect.ReportItem;
import h.e2.c;
import h.k2.u.p;
import h.t1;
import i.b.b2;
import i.b.i;
import i.b.n0;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\t\u001a\u00020\b2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ9\u0010\u000b\u001a\u00020\b2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\nJ9\u0010\f\u001a\u00020\b2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nR\u0016\u0010\u0010\u001a\u00020\r8 @ X \u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/LifecycleCoroutineScope;", "Li/b/n0;", "Lkotlin/Function2;", "Lh/e2/c;", "Lh/t1;", "", "Lh/q;", ReportItem.LogTypeBlock, "Li/b/b2;", "launchWhenCreated", "(Lh/k2/u/p;)Li/b/b2;", "launchWhenStarted", "launchWhenResumed", "Landroidx/lifecycle/Lifecycle;", "getLifecycle$lifecycle_runtime_ktx_release", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "<init>", "()V", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public abstract class LifecycleCoroutineScope implements n0 {
    @d
    public abstract Lifecycle getLifecycle$lifecycle_runtime_ktx_release();

    @d
    public final b2 launchWhenCreated(@d p<? super n0, ? super c<? super t1>, ? extends Object> pVar) {
        b2 f2;
        f2 = i.f(this, null, null, new LifecycleCoroutineScope$launchWhenCreated$1(this, pVar, null), 3, null);
        return f2;
    }

    @d
    public final b2 launchWhenResumed(@d p<? super n0, ? super c<? super t1>, ? extends Object> pVar) {
        b2 f2;
        f2 = i.f(this, null, null, new LifecycleCoroutineScope$launchWhenResumed$1(this, pVar, null), 3, null);
        return f2;
    }

    @d
    public final b2 launchWhenStarted(@d p<? super n0, ? super c<? super t1>, ? extends Object> pVar) {
        b2 f2;
        f2 = i.f(this, null, null, new LifecycleCoroutineScope$launchWhenStarted$1(this, pVar, null), 3, null);
        return f2;
    }
}
