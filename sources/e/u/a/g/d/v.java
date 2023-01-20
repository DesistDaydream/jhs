package e.u.a.g.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xres.address_selector.R;
import com.xres.address_selector.widget.SideBar;
import h.t1;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/xres/address_selector/widget/address_selector/AddressFragment;", "Landroidx/fragment/app/Fragment;", "mAdapter", "Lcom/xres/address_selector/widget/address_selector/AddressAdapter;", "(Lcom/xres/address_selector/widget/address_selector/AddressAdapter;)V", "binding", "Lcom/xres/address_selector/databinding/FragmentAddressBinding;", "getMAdapter", "()Lcom/xres/address_selector/widget/address_selector/AddressAdapter;", "myLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public final class v extends Fragment {
    @k.e.a.d
    private final t a;
    private LinearLayoutManager b;

    /* renamed from: c  reason: collision with root package name */
    private e.u.a.c.a f14731c;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016¨\u0006\b"}, d2 = {"com/xres/address_selector/widget/address_selector/AddressFragment$onViewCreated$2", "Lcom/xres/address_selector/widget/address_selector/DataPreparedListener;", "onPrepared", "", "map", "", "", "", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements y {
        public a() {
        }

        @Override // e.u.a.g.d.y
        public void a(@k.e.a.d Map<String, Integer> map) {
            e.u.a.c.a aVar = v.this.f14731c;
            Objects.requireNonNull(aVar);
            aVar.a.setRawList(map);
        }
    }

    public v(@k.e.a.d t tVar) {
        this.a = tVar;
    }

    @Override // androidx.fragment.app.Fragment
    @k.e.a.d
    public View onCreateView(@k.e.a.d LayoutInflater layoutInflater, @k.e.a.e ViewGroup viewGroup, @k.e.a.e Bundle bundle) {
        e.u.a.c.a aVar = (e.u.a.c.a) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_address, viewGroup, false);
        this.f14731c = aVar;
        return aVar.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@k.e.a.d View view, @k.e.a.e Bundle bundle) {
        e.u.a.c.a aVar = this.f14731c;
        Objects.requireNonNull(aVar);
        RecyclerView recyclerView = aVar.b;
        recyclerView.setAdapter(q());
        recyclerView.addItemDecoration(new z(q().b()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), 1, false);
        this.b = linearLayoutManager;
        t1 t1Var = t1.a;
        recyclerView.setLayoutManager(linearLayoutManager);
        e.u.a.c.a aVar2 = this.f14731c;
        Objects.requireNonNull(aVar2);
        SideBar sideBar = aVar2.a;
        LinearLayoutManager linearLayoutManager2 = this.b;
        Objects.requireNonNull(linearLayoutManager2);
        sideBar.setMLayoutManager(linearLayoutManager2);
        this.a.p(new a());
        h.k2.u.a<t1> g2 = this.a.g();
        if (g2 == null) {
            return;
        }
        g2.invoke();
    }

    @k.e.a.d
    public final t q() {
        return this.a;
    }
}
