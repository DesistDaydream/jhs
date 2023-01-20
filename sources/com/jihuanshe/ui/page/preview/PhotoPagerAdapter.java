package com.jihuanshe.ui.page.preview;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import e.l.q.c.t0.e.a;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes2.dex */
public final class PhotoPagerAdapter extends FragmentStatePagerAdapter {
    @e
    private final List<a> fragments;

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoPagerAdapter(@e FragmentManager fragmentManager, @e List<? extends a> list) {
        super(fragmentManager);
        this.fragments = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<a> list = this.fragments;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @e
    public final List<a> getFragments() {
        return this.fragments;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @d
    public Fragment getItem(int i2) {
        List<a> list = this.fragments;
        a aVar = list == null ? null : (a) CollectionsKt___CollectionsKt.J2(list, i2);
        return aVar == null ? new a() : aVar;
    }
}
