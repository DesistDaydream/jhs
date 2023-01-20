package e.t.k.a.c.h;

import android.util.SparseLongArray;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.umeng.analytics.pro.am;
import com.vector.ext.AnyKt;
import com.vector.view.pager.ViewPager2;
import h.a2.l0;
import h.o2.q;
import java.util.Iterator;
import java.util.List;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0015\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001b\u001a\u00020\u000eJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/vector/design/ui/adapter/pager/FragStateAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;)V", "dataCount", "", "getDataCount", "()I", "map", "Landroid/util/SparseLongArray;", "nextValue", "", "pager", "Lcom/vector/design/ui/adapter/pager/Pager;", "containsItem", "", "itemId", "createFragment", "position", "getItemCount", "getItemId", "getPageTitle", "", "setData", "", am.ax, "viewPager2", "Lcom/vector/view/pager/ViewPager2;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class b extends FragmentStateAdapter {
    @e
    private c a;
    private long b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final SparseLongArray f14557c;

    public b(@k.e.a.d FragmentManager fragmentManager, @k.e.a.d Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.b = 1L;
        this.f14557c = new SparseLongArray();
    }

    private final int a() {
        c cVar = this.a;
        if (cVar == null) {
            return 0;
        }
        return cVar.f();
    }

    @e
    public final CharSequence b(int i2) {
        List<String> g2;
        c cVar = this.a;
        if (cVar == null || (g2 = cVar.g()) == null) {
            return null;
        }
        return g2.get(i2);
    }

    public final void c(@k.e.a.d c cVar, @k.e.a.d ViewPager2 viewPager2) {
        this.a = cVar;
        long itemId = getItemId(viewPager2.getCurrentItem());
        notifyDataSetChanged();
        Integer d2 = cVar.d();
        if (d2 != null) {
            viewPager2.e(d2.intValue(), false);
        } else if (containsItem(itemId)) {
            Iterator<Integer> it = q.n1(0, cVar.f()).iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                int nextInt = ((l0) it).nextInt();
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.W();
                }
                if (getItemId(nextInt) == itemId) {
                    break;
                }
                i2++;
            }
            viewPager2.e(i2, false);
        }
        this.f14557c.clear();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public boolean containsItem(long j2) {
        return this.f14557c.indexOfValue(j2) > 0;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @k.e.a.d
    public Fragment createFragment(int i2) {
        c cVar = this.a;
        return (Fragment) AnyKt.I(cVar == null ? null : cVar.b(i2), "Can not new a Fragment.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return a();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        long j2 = this.f14557c.get(i2, -1L);
        if (j2 == -1) {
            long j3 = this.b + 1;
            this.b = j3;
            this.f14557c.put(i2, j3);
            return this.b;
        }
        return j2;
    }

    public b(@k.e.a.d FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    public b(@k.e.a.d Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }
}
