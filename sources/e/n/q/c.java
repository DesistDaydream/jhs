package e.n.q;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.live.mediator.MediatorLive;
import com.tencent.qcloud.tuicore.TUIConstants;
import h.a2.u;
import h.a2.y;
import h.k2.v.f0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004J+\u0010\t\u001a\u00020\n2\u001e\u0010\u000b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\f\"\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u000e\u001a\u00020\u0002H\u0086\u0002J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0013H\u0016J+\u0010\u0014\u001a\u00020\n2\u001e\u0010\u000b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\f\"\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0002\u0010\rJ\r\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/live/mediator/MediatorLiveBool;", "Lcom/live/mediator/MediatorLive;", "", "default", "(Ljava/lang/Boolean;)V", "ands", "", "Landroidx/lifecycle/LiveData;", "ors", "and", "", "args", "", "([Landroidx/lifecycle/LiveData;)V", "not", "observe", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "or", "requireValue", "()Ljava/lang/Boolean;", "live_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class c extends MediatorLive<Boolean> {
    @d

    /* renamed from: c */
    private final List<LiveData<Boolean>> f14382c;
    @d

    /* renamed from: d */
    private final List<LiveData<Boolean>> f14383d;

    public c() {
        this(null, 1, null);
    }

    public c(@e Boolean bool) {
        super(bool);
        this.f14382c = new ArrayList();
        this.f14383d = new ArrayList();
    }

    public static final void A(c cVar, Boolean bool) {
        List<LiveData<Boolean>> list = cVar.f14383d;
        ArrayList<Boolean> arrayList = new ArrayList(u.Y(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((Boolean) ((LiveData) it.next()).getValue());
        }
        for (Boolean bool2 : arrayList) {
            if (bool == null) {
                bool = null;
            } else {
                boolean booleanValue = bool.booleanValue();
                if (bool2 != null) {
                    bool = Boolean.valueOf(bool2.booleanValue() | booleanValue);
                }
            }
        }
        cVar.setValue(bool);
    }

    public static final void z(c cVar, Boolean bool) {
        List<LiveData<Boolean>> list = cVar.f14382c;
        ArrayList<Boolean> arrayList = new ArrayList(u.Y(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((Boolean) ((LiveData) it.next()).getValue());
        }
        for (Boolean bool2 : arrayList) {
            if (bool == null) {
                bool = null;
            } else {
                boolean booleanValue = bool.booleanValue();
                if (bool2 != null) {
                    bool = Boolean.valueOf(bool2.booleanValue() & booleanValue);
                }
            }
        }
        cVar.setValue(bool);
    }

    public final void B(@d LiveData<Boolean>... liveDataArr) {
        t();
        if (!this.f14383d.isEmpty()) {
            this.f14383d.clear();
        }
        y.s0(this.f14383d, liveDataArr);
    }

    @Override // e.n.f
    @d
    /* renamed from: C */
    public Boolean o() {
        boolean z = true;
        boolean z2 = false;
        if (!this.f14382c.isEmpty()) {
            Iterator<T> it = this.f14382c.iterator();
            while (it.hasNext()) {
                if (f0.g(((LiveData) it.next()).getValue(), Boolean.FALSE)) {
                    z = false;
                }
            }
            z2 = z;
        } else if (!this.f14383d.isEmpty()) {
            Iterator<T> it2 = this.f14383d.iterator();
            while (it2.hasNext()) {
                if (f0.g(((LiveData) it2.next()).getValue(), Boolean.TRUE)) {
                    z2 = true;
                }
            }
        }
        return Boolean.valueOf(z2);
    }

    @Override // e.n.f, androidx.lifecycle.LiveData
    public void observe(@d LifecycleOwner lifecycleOwner, @d Observer<? super Boolean> observer) {
        super.observe(lifecycleOwner, observer);
        Iterator<T> it = this.f14382c.iterator();
        while (it.hasNext()) {
            s((LiveData) it.next(), new Observer() { // from class: e.n.q.a
                {
                    c.this = this;
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    c.z(c.this, (Boolean) obj);
                }
            });
        }
        Iterator<T> it2 = this.f14383d.iterator();
        while (it2.hasNext()) {
            s((LiveData) it2.next(), new Observer() { // from class: e.n.q.b
                {
                    c.this = this;
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    c.A(c.this, (Boolean) obj);
                }
            });
        }
    }

    public final void v(@d LiveData<Boolean>... liveDataArr) {
        t();
        if (!this.f14382c.isEmpty()) {
            this.f14382c.clear();
        }
        y.s0(this.f14382c, liveDataArr);
    }

    public final boolean y() {
        Boolean value = getValue();
        if (value == null) {
            return false;
        }
        return !value.booleanValue();
    }

    public /* synthetic */ c(Boolean bool, int i2, h.k2.v.u uVar) {
        this((i2 & 1) != 0 ? null : bool);
    }
}
