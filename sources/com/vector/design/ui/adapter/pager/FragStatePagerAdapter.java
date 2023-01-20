package com.vector.design.ui.adapter.pager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.umeng.analytics.pro.am;
import com.vector.ext.AnyKt;
import com.vector.view.pager.ViewPager;
import com.vector.view.pager.ViewPager2;
import e.t.k.a.c.h.a;
import e.t.k.a.c.h.c;
import h.k2.v.f0;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u000f\b\u0002\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0016R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/vector/design/ui/adapter/pager/FragStatePagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "Lcom/vector/design/ui/adapter/pager/BasePagerAdapter;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "manager", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "dataCount", "", "getDataCount", "()I", "modify", "", "pager", "Lcom/vector/design/ui/adapter/pager/Pager;", "getCount", "getItem", "position", "getItemPosition", "object", "", "getPageTitle", "", "notifyDataSetChanged", "", "setData", am.ax, "viewPager", "Lcom/vector/view/pager/ViewPager;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class FragStatePagerAdapter extends FragmentStatePagerAdapter implements a {
    private boolean modify;
    @e
    private c pager;

    private FragStatePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager, 1);
    }

    private final int getDataCount() {
        c cVar = this.pager;
        if (cVar == null) {
            return 0;
        }
        return cVar.f();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return getDataCount();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @d
    public Fragment getItem(int i2) {
        c cVar = this.pager;
        return (Fragment) AnyKt.I(cVar == null ? null : cVar.b(i2), "Can not new a Fragment.");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@d Object obj) {
        return this.modify ? -2 : -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @e
    public CharSequence getPageTitle(int i2) {
        List<String> g2;
        c cVar = this.pager;
        if (cVar == null || (g2 = cVar.g()) == null) {
            return null;
        }
        return g2.get(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.modify = false;
    }

    @Override // e.t.k.a.c.h.a
    public void setData(@d c cVar, @d ViewPager2 viewPager2) {
        a.C0413a.a(this, cVar, viewPager2);
    }

    public FragStatePagerAdapter(@d FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager());
    }

    @Override // e.t.k.a.c.h.a
    public void setData(@d c cVar, @d ViewPager viewPager) {
        c cVar2 = this.pager;
        if (cVar2 != null && !f0.g(cVar2, cVar)) {
            this.modify = true;
        }
        this.pager = cVar;
    }

    public FragStatePagerAdapter(@d Fragment fragment) {
        this(fragment.getChildFragmentManager());
    }
}
