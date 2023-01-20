package com.jihuanshe.binding;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.SnapHelper;
import com.jihuanshe.binding.RecyclerViewBinding;
import com.vector.design.ui.adapter.RecyclerClickSupport;
import com.vector.util.LayoutManagers;
import e.t.j.h.l;
import e.t.j.h.m;
import e.t.k.a.c.f;
import h.k2.k;
import h.k2.v.f0;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class RecyclerViewBinding {
    @d
    public static final RecyclerViewBinding a = new RecyclerViewBinding();
    @d
    private static final String b = "android:recyclerView_adapter";
    @d

    /* renamed from: c */
    private static final String f3901c = "android:recyclerView_data";
    @d

    /* renamed from: d */
    private static final String f3902d = "android:recyclerView_layoutManager";
    @d

    /* renamed from: e */
    private static final String f3903e = "android:recyclerView_onItemClick";
    @d

    /* renamed from: f */
    private static final String f3904f = "android:recyclerView_onItemLongClick";
    @d

    /* renamed from: g */
    private static final String f3905g = "android:recyclerView_snap";
    @d

    /* renamed from: h */
    private static final String f3906h = "android:recyclerView_onScroll";
    @d

    /* renamed from: i */
    private static final String f3907i = "android:recyclerView_initPos";
    @d

    /* renamed from: j */
    private static final String f3908j = "android:recyclerView_decoration";
    @d

    /* renamed from: k */
    private static final String f3909k = "android:recyclerView_itemAnimator";

    private RecyclerViewBinding() {
    }

    @BindingAdapter(requireAll = false, value = {b, f3901c, f3902d, f3905g, f3906h, f3907i, f3908j})
    @k
    public static final <T, A extends f<T>> void b(@d final RecyclerView recyclerView, @d A a2, @e List<? extends T> list, @d LayoutManagers.a aVar, @e SnapHelper snapHelper, @e RecyclerView.OnScrollListener onScrollListener, @e final Integer num, @e RecyclerView.ItemDecoration itemDecoration) {
        if (recyclerView.getAdapter() == null || !f0.g(recyclerView.getAdapter(), a2)) {
            recyclerView.setLayoutManager(aVar.create(recyclerView.getContext()));
            recyclerView.setAdapter(a2);
            if (snapHelper != null) {
                snapHelper.attachToRecyclerView(recyclerView);
            }
            if (onScrollListener != null) {
                recyclerView.addOnScrollListener(onScrollListener);
            }
            if (num != null) {
                recyclerView.post(new Runnable() { // from class: e.l.i.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        RecyclerViewBinding.d(recyclerView, num);
                    }
                });
            }
        }
        a2.setData(list);
        if (recyclerView.getItemDecorationCount() >= 1 || itemDecoration == null) {
            return;
        }
        recyclerView.addItemDecoration(itemDecoration);
    }

    public static final void d(RecyclerView recyclerView, Integer num) {
        recyclerView.scrollToPosition(num.intValue());
    }

    @BindingAdapter({f3909k})
    @k
    public static final void e(@d RecyclerView recyclerView, @e RecyclerView.ItemAnimator itemAnimator) {
        RecyclerView.ItemAnimator itemAnimator2 = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator2 instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator2 : null;
        if (simpleItemAnimator == null) {
            return;
        }
        simpleItemAnimator.setSupportsChangeAnimations(false);
    }

    @BindingAdapter(requireAll = false, value = {f3903e, f3904f})
    @k
    public static final void f(@d RecyclerView recyclerView, @e l lVar, @e m mVar) {
        RecyclerClickSupport a2 = RecyclerClickSupport.f7735d.a(recyclerView);
        a2.d(new RecyclerViewBinding$setOnItemClick$1$1(lVar));
        a2.e(new RecyclerViewBinding$setOnItemClick$1$2(mVar));
    }
}
