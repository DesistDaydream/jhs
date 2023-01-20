package com.jihuanshe.ui.page.order;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.adapter.AddressAdapter;
import com.jihuanshe.base.bus.Bus;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.UserAddress;
import com.jihuanshe.ui.BaseActivity;
import com.vector.util.LayoutManagers;
import e.l.h.d.f;
import e.l.h.d.h;
import e.l.k.k;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.l;
import h.k2.v.f0;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Creator
/* loaded from: classes2.dex */
public final class AddressActivity extends BaseActivity<e.l.s.j.a> {
    @f.a.a.a(true)
    private boolean manager;
    @d
    private final w n = z.c(AddressActivity$adapter$2.INSTANCE);
    @d
    private final w o = z.c(AddressActivity$layoutManager$2.INSTANCE);
    @d
    private final w p = z.c(AddressActivity$decoration$2.INSTANCE);
    @d
    private final l q = d.e.a.a(new AddressActivity$onItemClick$1(this));
    @k.e.a.d
    private final g r = e.t.j.h.d.a.a(new AddressActivity$onClickAdd$1(this));

    /* loaded from: classes2.dex */
    public static final class a<T> implements Observer {
        public final /* synthetic */ Bus a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AddressActivity f4028c;

        public a(Bus bus, String str, AddressActivity addressActivity) {
            this.a = bus;
            this.b = str;
            this.f4028c = addressActivity;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(h hVar) {
            if (this.a.e().getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED || !f0.g(hVar.g(), this.b)) {
                return;
            }
            Object f2 = hVar.f();
            if (f2 != null && (f2 instanceof UserAddress)) {
                UserAddress userAddress = (UserAddress) f2;
                List<UserAddress> value = ((e.l.s.j.a) this.f4028c.L()).q0().getValue();
                List<UserAddress> L5 = value == null ? null : CollectionsKt___CollectionsKt.L5(value);
                if (L5 == null) {
                    L5 = new ArrayList<>();
                }
                L5.add(userAddress);
                ((e.l.s.j.a) this.f4028c.L()).q0().setValue(L5);
            }
            new e.t.l.h();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<T> implements Observer {
        public final /* synthetic */ Bus a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AddressActivity f4029c;

        public b(Bus bus, String str, AddressActivity addressActivity) {
            this.a = bus;
            this.b = str;
            this.f4029c = addressActivity;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(h hVar) {
            if (this.a.e().getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED || !f0.g(hVar.g(), this.b)) {
                return;
            }
            Object f2 = hVar.f();
            if (f2 != null && (f2 instanceof UserAddress)) {
                UserAddress userAddress = (UserAddress) f2;
                List<UserAddress> value = ((e.l.s.j.a) this.f4029c.L()).q0().getValue();
                List<UserAddress> L5 = value == null ? null : CollectionsKt___CollectionsKt.L5(value);
                if (L5 == null) {
                    L5 = new ArrayList<>();
                }
                int indexOf = L5.indexOf(userAddress);
                if (indexOf >= 0) {
                    L5.set(indexOf, userAddress);
                    ((e.l.s.j.a) this.f4029c.L()).q0().setValue(L5);
                }
            }
            new e.t.l.h();
        }
    }

    /* loaded from: classes2.dex */
    public static final class c<T> implements Observer {
        public final /* synthetic */ Bus a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AddressActivity f4030c;

        public c(Bus bus, String str, AddressActivity addressActivity) {
            this.a = bus;
            this.b = str;
            this.f4030c = addressActivity;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(h hVar) {
            if (this.a.e().getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED || !f0.g(hVar.g(), this.b)) {
                return;
            }
            Object f2 = hVar.f();
            if (f2 != null && (f2 instanceof UserAddress)) {
                UserAddress userAddress = (UserAddress) f2;
                NLive<List<UserAddress>> q0 = ((e.l.s.j.a) this.f4030c.L()).q0();
                List<UserAddress> value = q0.getValue();
                List<UserAddress> L5 = value == null ? null : CollectionsKt___CollectionsKt.L5(value);
                if (L5 != null) {
                    L5.remove(userAddress);
                    q0.setValue(L5);
                }
            }
            new e.t.l.h();
        }
    }

    @k.e.a.d
    public final AddressAdapter W() {
        return (AddressAdapter) this.n.getValue();
    }

    @k.e.a.d
    public final e.l.h.j.b.f.b X() {
        return (e.l.h.j.b.f.b) this.p.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a Y() {
        return (LayoutManagers.a) this.o.getValue();
    }

    public final boolean Z() {
        return this.manager;
    }

    @k.e.a.d
    public final g a0() {
        return this.r;
    }

    @k.e.a.d
    public final l b0() {
        return this.q;
    }

    public final void c0(boolean z) {
        this.manager = z;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        BinderKt.p(BinderKt.k(e.g.d.a.j(((e.l.s.j.a) L()).p0(), null, new AddressActivity$flowOfSetup$1(this), 1, null), this, false, 2, null));
        f fVar = f.b;
        Bus e2 = fVar.e(this);
        e2.l(e2.e(), e2.d(), new a(e2, e.l.j.a.f12236f, this));
        Bus e3 = fVar.e(this);
        e3.l(e3.e(), e3.d(), new b(e3, e.l.j.a.f12237g, this));
        Bus e4 = fVar.e(this);
        e4.l(e4.e(), e4.d(), new c(e4, e.l.j.a.f12238h, this));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(AddressActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        k e2 = k.e(getLayoutInflater());
        e2.i(this);
        e2.j((e.l.s.j.a) L());
        return e2;
    }
}
