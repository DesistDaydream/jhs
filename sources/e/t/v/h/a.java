package e.t.v.h;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.vector.view.pager.ViewPager2;
import e.t.l.h;
import h.t1;
import java.lang.ref.WeakReference;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0015\u0016\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u0012H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/vector/view/pager/TabLayoutMediator;", "", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "viewPager", "Lcom/vector/view/pager/ViewPager2;", "(Lcom/google/android/material/tabs/TabLayout;Lcom/vector/view/pager/ViewPager2;)V", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "attached", "", "onPageChangeCallback", "Lcom/vector/view/pager/TabLayoutMediator$TabLayoutOnPageChangeCallback;", "onTabSelectedListener", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "pagerAdapterObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "attach", "", "detach", "populateTabsFromPagerAdapter", "PagerAdapterObserver", "TabLayoutOnPageChangeCallback", "ViewPagerOnTabSelectedListener", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    @k.e.a.d
    private final TabLayout a;
    @k.e.a.d
    private final ViewPager2 b;
    @e

    /* renamed from: c */
    private RecyclerView.Adapter<?> f14680c;

    /* renamed from: d */
    private boolean f14681d;
    @e

    /* renamed from: e */
    private c f14682e;
    @e

    /* renamed from: f */
    private TabLayout.f f14683f;
    @e

    /* renamed from: g */
    private RecyclerView.AdapterDataObserver f14684g;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/vector/view/pager/TabLayoutMediator$1", "Lcom/vector/view/pager/ViewPager2$AccessibilityProvider;", "onAttachAdapter", "", "newAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "onDetachAdapter", "oldAdapter", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: e.t.v.h.a$a */
    /* loaded from: classes3.dex */
    public static final class C0418a extends ViewPager2.a {
        public C0418a() {
            a.this = r1;
        }

        @Override // com.vector.view.pager.ViewPager2.a
        public void a(@e RecyclerView.Adapter<?> adapter) {
            if (adapter == null) {
                return;
            }
            a.this.f14680c = adapter;
            a.this.c();
        }

        @Override // com.vector.view.pager.ViewPager2.a
        public void b(@e RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                a.this.d();
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, d2 = {"Lcom/vector/view/pager/TabLayoutMediator$PagerAdapterObserver;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "(Lcom/vector/view/pager/TabLayoutMediator;)V", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final class b extends RecyclerView.AdapterDataObserver {
        public b() {
            a.this = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            a.this.e();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3) {
            a.this.e();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i2, int i3) {
            a.this.e();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i2, int i3, int i4) {
            a.this.e();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i2, int i3) {
            a.this.e();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3, @e Object obj) {
            a.this.e();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0016J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\r\u0010\u0013\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/vector/view/pager/TabLayoutMediator$TabLayoutOnPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "(Lcom/google/android/material/tabs/TabLayout;)V", "previousScrollState", "", "scrollState", "tabLayoutRef", "Ljava/lang/ref/WeakReference;", "onPageScrollStateChanged", "", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "reset", "reset$vector_release", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        @k.e.a.d
        private final WeakReference<TabLayout> a;
        private int b;

        /* renamed from: c */
        private int f14685c;

        public c(@k.e.a.d TabLayout tabLayout) {
            this.a = new WeakReference<>(tabLayout);
            a();
        }

        public final void a() {
            this.f14685c = 0;
            this.b = 0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i2) {
            this.b = this.f14685c;
            this.f14685c = i2;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null) {
                int i4 = this.f14685c;
                boolean z = false;
                tabLayout.Q(i2, f2, i4 != 2 || this.b == 1, (i4 == 2 && this.b == 0) ? true : true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i2 || i2 >= tabLayout.getTabCount()) {
                return;
            }
            int i3 = this.f14685c;
            tabLayout.N(tabLayout.z(i2), i3 == 0 || (i3 == 2 && this.b == 0));
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/vector/view/pager/TabLayoutMediator$ViewPagerOnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "viewPager", "Lcom/vector/view/pager/ViewPager2;", "(Lcom/vector/view/pager/ViewPager2;)V", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class d implements TabLayout.f {
        @k.e.a.d
        private final com.vector.view.pager.ViewPager2 a;

        public d(@k.e.a.d com.vector.view.pager.ViewPager2 viewPager2) {
            this.a = viewPager2;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(@k.e.a.d TabLayout.Tab tab) {
            this.a.setCurrentItem(tab.getPosition());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(@k.e.a.d TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(@k.e.a.d TabLayout.Tab tab) {
        }
    }

    public a(@k.e.a.d TabLayout tabLayout, @k.e.a.d com.vector.view.pager.ViewPager2 viewPager2) {
        this.a = tabLayout;
        this.b = viewPager2;
        RecyclerView.Adapter<?> adapter = viewPager2.getAdapter();
        this.f14680c = adapter;
        if (adapter == null) {
            viewPager2.setAccessibilityProvider(new C0418a());
        } else {
            c();
        }
    }

    public final void e() {
        int currentItem;
        TabLayout.Tab z;
        this.a.G();
        RecyclerView.Adapter<?> adapter = this.f14680c;
        if (adapter != null) {
            int itemCount = adapter == null ? 0 : adapter.getItemCount();
            if (itemCount > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    TabLayout.Tab D = this.a.D();
                    RecyclerView.Adapter<?> adapter2 = this.f14680c;
                    if (adapter2 != null && (adapter2 instanceof e.t.k.a.c.h.b)) {
                        D.setText(((e.t.k.a.c.h.b) adapter2).b(i2));
                    }
                    new h();
                    this.a.h(D, false);
                    if (i3 >= itemCount) {
                        break;
                    }
                    i2 = i3;
                }
            }
            if (itemCount <= 0 || (currentItem = this.b.getCurrentItem()) == this.a.getSelectedTabPosition() || (z = this.a.z(currentItem)) == null) {
                return;
            }
            z.select();
        }
    }

    public final void c() {
        if (this.f14681d) {
            return;
        }
        this.f14681d = true;
        c cVar = new c(this.a);
        this.b.d(cVar);
        t1 t1Var = t1.a;
        this.f14682e = cVar;
        d dVar = new d(this.b);
        this.a.d(dVar);
        this.f14683f = dVar;
        b bVar = new b();
        RecyclerView.Adapter<?> adapter = this.f14680c;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(bVar);
        }
        this.f14684g = bVar;
        e();
        this.a.P(this.b.getCurrentItem(), 0.0f, true);
    }

    public final void d() {
        if (this.f14681d) {
            RecyclerView.AdapterDataObserver adapterDataObserver = this.f14684g;
            if (adapterDataObserver != null) {
                RecyclerView.Adapter<?> adapter = this.f14680c;
                if (adapter != null) {
                    adapter.unregisterAdapterDataObserver(adapterDataObserver);
                }
                this.f14684g = null;
            }
            TabLayout.f fVar = this.f14683f;
            if (fVar != null) {
                this.a.I(fVar);
                this.f14683f = null;
            }
            c cVar = this.f14682e;
            if (cVar != null) {
                this.b.f(cVar);
                this.f14682e = null;
            }
            this.f14681d = false;
        }
    }
}
