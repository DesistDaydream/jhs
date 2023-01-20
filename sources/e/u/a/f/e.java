package e.u.a.f;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\n"}, d2 = {"init", "Landroidx/viewpager2/widget/ViewPager2;", "fragment", "Landroidx/fragment/app/Fragment;", "fragments", "", "isUserInputEnabled", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "address-selector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class e {

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/xres/address_selector/ext/ViewExtKt$init$1", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a extends FragmentStateAdapter {
        public final /* synthetic */ List<Fragment> a;
        public final /* synthetic */ Fragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends Fragment> list, Fragment fragment) {
            super(fragment);
            this.a = list;
            this.b = fragment;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @k.e.a.d
        public Fragment createFragment(int i2) {
            return this.a.get(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.size();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/xres/address_selector/ext/ViewExtKt$init$2", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b extends FragmentStateAdapter {
        public final /* synthetic */ List<Fragment> a;
        public final /* synthetic */ FragmentActivity b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends Fragment> list, FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            this.a = list;
            this.b = fragmentActivity;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @k.e.a.d
        public Fragment createFragment(int i2) {
            return this.a.get(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.size();
        }
    }

    @k.e.a.d
    public static final ViewPager2 a(@k.e.a.d ViewPager2 viewPager2, @k.e.a.d Fragment fragment, @k.e.a.d List<? extends Fragment> list, boolean z) {
        viewPager2.setUserInputEnabled(z);
        viewPager2.setOffscreenPageLimit(list.size());
        viewPager2.setAdapter(new a(list, fragment));
        return viewPager2;
    }

    @k.e.a.d
    public static final ViewPager2 b(@k.e.a.d ViewPager2 viewPager2, @k.e.a.d FragmentActivity fragmentActivity, @k.e.a.d List<? extends Fragment> list, boolean z) {
        viewPager2.setUserInputEnabled(z);
        viewPager2.setOffscreenPageLimit(list.size());
        viewPager2.setAdapter(new b(list, fragmentActivity));
        return viewPager2;
    }

    public static /* synthetic */ ViewPager2 c(ViewPager2 viewPager2, Fragment fragment, List list, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        return a(viewPager2, fragment, list, z);
    }

    public static /* synthetic */ ViewPager2 d(ViewPager2 viewPager2, FragmentActivity fragmentActivity, List list, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        return b(viewPager2, fragmentActivity, list, z);
    }
}
