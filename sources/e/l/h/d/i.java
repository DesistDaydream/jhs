package e.l.h.d;

import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.base.bus.Bus;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/jihuanshe/base/bus/LiveBus;", "", "()V", "bus", "Lcom/jihuanshe/base/bus/BusMutableLiveData;", "Lcom/jihuanshe/base/bus/Event;", "post", "", "flag", "", k.b.a.a.n.n.c.b, "send", "with", "Lcom/jihuanshe/base/bus/Bus;", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class i {
    @k.e.a.d
    private final e<h> a = new e<>();

    public static /* synthetic */ void b(i iVar, String str, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: post");
        }
        if ((i2 & 2) != 0) {
            obj = null;
        }
        iVar.a(str, obj);
    }

    public static /* synthetic */ void d(i iVar, String str, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: send");
        }
        if ((i2 & 2) != 0) {
            obj = null;
        }
        iVar.c(str, obj);
    }

    public final void a(@k.e.a.d String str, @k.e.a.e Object obj) {
        this.a.postValue(new h(str, obj, System.currentTimeMillis()));
    }

    public final void c(@k.e.a.d String str, @k.e.a.e Object obj) {
        this.a.setValue(new h(str, obj, System.currentTimeMillis()));
    }

    @k.e.a.d
    public final Bus e(@k.e.a.d LifecycleOwner lifecycleOwner) {
        return new Bus(lifecycleOwner, this.a);
    }
}
