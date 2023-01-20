package e.j.a.c.c0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class c {
    @NonNull
    private final TabLayout a;
    @NonNull
    private final ViewPager2 b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f10579c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10580d;

    /* renamed from: e  reason: collision with root package name */
    private final b f10581e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.Adapter<?> f10582f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10583g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private C0352c f10584h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private TabLayout.f f10585i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f10586j;

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            c.this.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3) {
            c.this.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i2, int i3) {
            c.this.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i2, int i3, int i4) {
            c.this.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i2, int i3) {
            c.this.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3, @Nullable Object obj) {
            c.this.d();
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(@NonNull TabLayout.Tab tab, int i2);
    }

    /* renamed from: e.j.a.c.c0.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0352c extends ViewPager2.OnPageChangeCallback {
        @NonNull
        private final WeakReference<TabLayout> a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f10587c;

        public C0352c(TabLayout tabLayout) {
            this.a = new WeakReference<>(tabLayout);
            a();
        }

        public void a() {
            this.f10587c = 0;
            this.b = 0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i2) {
            this.b = this.f10587c;
            this.f10587c = i2;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null) {
                int i4 = this.f10587c;
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
            int i3 = this.f10587c;
            tabLayout.N(tabLayout.z(i2), i3 == 0 || (i3 == 2 && this.b == 0));
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements TabLayout.f {
        private final ViewPager2 a;
        private final boolean b;

        public d(ViewPager2 viewPager2, boolean z) {
            this.a = viewPager2;
            this.b = z;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(@NonNull TabLayout.Tab tab) {
            this.a.setCurrentItem(tab.getPosition(), this.b);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.Tab tab) {
        }
    }

    public c(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, @NonNull b bVar) {
        this(tabLayout, viewPager2, true, bVar);
    }

    public void a() {
        if (!this.f10583g) {
            RecyclerView.Adapter<?> adapter = this.b.getAdapter();
            this.f10582f = adapter;
            if (adapter != null) {
                this.f10583g = true;
                C0352c c0352c = new C0352c(this.a);
                this.f10584h = c0352c;
                this.b.registerOnPageChangeCallback(c0352c);
                d dVar = new d(this.b, this.f10580d);
                this.f10585i = dVar;
                this.a.d(dVar);
                if (this.f10579c) {
                    a aVar = new a();
                    this.f10586j = aVar;
                    this.f10582f.registerAdapterDataObserver(aVar);
                }
                d();
                this.a.P(this.b.getCurrentItem(), 0.0f, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public void b() {
        RecyclerView.Adapter<?> adapter;
        if (this.f10579c && (adapter = this.f10582f) != null) {
            adapter.unregisterAdapterDataObserver(this.f10586j);
            this.f10586j = null;
        }
        this.a.I(this.f10585i);
        this.b.unregisterOnPageChangeCallback(this.f10584h);
        this.f10585i = null;
        this.f10584h = null;
        this.f10582f = null;
        this.f10583g = false;
    }

    public boolean c() {
        return this.f10583g;
    }

    public void d() {
        this.a.G();
        RecyclerView.Adapter<?> adapter = this.f10582f;
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            for (int i2 = 0; i2 < itemCount; i2++) {
                TabLayout.Tab D = this.a.D();
                this.f10581e.a(D, i2);
                this.a.h(D, false);
            }
            if (itemCount > 0) {
                int min = Math.min(this.b.getCurrentItem(), this.a.getTabCount() - 1);
                if (min != this.a.getSelectedTabPosition()) {
                    TabLayout tabLayout = this.a;
                    tabLayout.M(tabLayout.z(min));
                }
            }
        }
    }

    public c(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z, @NonNull b bVar) {
        this(tabLayout, viewPager2, z, true, bVar);
    }

    public c(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z, boolean z2, @NonNull b bVar) {
        this.a = tabLayout;
        this.b = viewPager2;
        this.f10579c = z;
        this.f10580d = z2;
        this.f10581e = bVar;
    }
}
