package e.t.l;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.vector.design.ui.activity.ActivityEx;
import h.k2.v.n0;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001f\u0010\u0006\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\u0002\u0010\b\u001a\u001f\u0010\u0006\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"getClz", "Ljava/lang/Class;", "VM", "Lcom/vector/design/viewModel/ViewModelEx;", k.b.a.a.n.n.c.b, "", "getViewModel", "Lcom/vector/design/ui/activity/ActivityEx;", "(Lcom/vector/design/ui/activity/ActivityEx;)Lcom/vector/design/viewModel/ViewModelEx;", "Lcom/vector/design/ui/frag/FragEx;", "(Lcom/vector/design/ui/frag/FragEx;)Lcom/vector/design/viewModel/ViewModelEx;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a0 {
    private static final <VM extends e.t.k.b.a> Class<VM> a(Object obj) {
        h.p2.d<?> c2 = e.t.u.j.a.c(obj, n0.d(ViewModel.class));
        Objects.requireNonNull(c2, "null cannot be cast to non-null type kotlin.reflect.KClass<VM of com.vector.ext.VMHostKt.getClz>");
        return h.k2.a.c(c2);
    }

    @k.e.a.d
    public static final <VM extends e.t.k.b.a> VM b(@k.e.a.d ActivityEx<VM> activityEx) {
        return (VM) new ViewModelProvider(activityEx).get(a(activityEx));
    }

    @k.e.a.d
    public static final <VM extends e.t.k.b.a> VM c(@k.e.a.d e.t.k.a.g.c<VM> cVar) {
        return (VM) new ViewModelProvider(cVar).get(a(cVar));
    }
}
