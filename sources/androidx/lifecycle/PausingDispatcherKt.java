package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import com.qiniu.android.collect.ReportItem;
import h.e2.c;
import h.k2.u.p;
import i.b.b1;
import i.b.g;
import i.b.n0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aF\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001aF\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u000b\u001aF\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\t\u001aF\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000b\u001aF\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\t\u001aF\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000b\u001aN\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LifecycleOwner;", "Lkotlin/Function2;", "Li/b/n0;", "Lh/e2/c;", "", "Lh/q;", ReportItem.LogTypeBlock, "whenCreated", "(Landroidx/lifecycle/LifecycleOwner;Lh/k2/u/p;Lh/e2/c;)Ljava/lang/Object;", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;Lh/k2/u/p;Lh/e2/c;)Ljava/lang/Object;", "whenStarted", "whenResumed", "Landroidx/lifecycle/Lifecycle$State;", "minState", "whenStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lh/k2/u/p;Lh/e2/c;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class PausingDispatcherKt {
    @e
    public static final <T> Object whenCreated(@d LifecycleOwner lifecycleOwner, @d p<? super n0, ? super c<? super T>, ? extends Object> pVar, @d c<? super T> cVar) {
        return whenCreated(lifecycleOwner.getLifecycle(), pVar, cVar);
    }

    @e
    public static final <T> Object whenResumed(@d LifecycleOwner lifecycleOwner, @d p<? super n0, ? super c<? super T>, ? extends Object> pVar, @d c<? super T> cVar) {
        return whenResumed(lifecycleOwner.getLifecycle(), pVar, cVar);
    }

    @e
    public static final <T> Object whenStarted(@d LifecycleOwner lifecycleOwner, @d p<? super n0, ? super c<? super T>, ? extends Object> pVar, @d c<? super T> cVar) {
        return whenStarted(lifecycleOwner.getLifecycle(), pVar, cVar);
    }

    @e
    public static final <T> Object whenStateAtLeast(@d Lifecycle lifecycle, @d Lifecycle.State state, @d p<? super n0, ? super c<? super T>, ? extends Object> pVar, @d c<? super T> cVar) {
        return g.i(b1.e().z0(), new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, pVar, null), cVar);
    }

    @e
    public static final <T> Object whenCreated(@d Lifecycle lifecycle, @d p<? super n0, ? super c<? super T>, ? extends Object> pVar, @d c<? super T> cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, pVar, cVar);
    }

    @e
    public static final <T> Object whenResumed(@d Lifecycle lifecycle, @d p<? super n0, ? super c<? super T>, ? extends Object> pVar, @d c<? super T> cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, pVar, cVar);
    }

    @e
    public static final <T> Object whenStarted(@d Lifecycle lifecycle, @d p<? super n0, ? super c<? super T>, ? extends Object> pVar, @d c<? super T> cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, pVar, cVar);
    }
}
