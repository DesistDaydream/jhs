package com.vector.design.ui.adapter.pager;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.PagerAdapter;
import e.t.v.h.d.b;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0017\u0010!\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001e\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H&J\b\u0010'\u001a\u00020\u0012H\u0016J\b\u0010(\u001a\u00020\u0012H\u0016J\u0018\u0010)\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\b\u0010*\u001a\u00020\fH\u0016J\u0018\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020 H\u0016J\b\u0010.\u001a\u00020\u001bH\u0016J%\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u000203H&¢\u0006\u0002\u00104J\u0006\u00105\u001a\u00020\u001bR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/vector/design/ui/adapter/pager/PagerAdapterEx;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/viewpager/widget/PagerAdapter;", "Lcom/vector/view/pager/indicator/IconPagerAdapter;", "()V", "data", "", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "forceRefresh", "", "getForceRefresh", "()Z", "setForceRefresh", "(Z)V", "lastItemPosition", "", "getLastItemPosition", "()I", "mapLoop", "Landroid/util/SparseArray;", "Landroid/view/View;", "modify", "updateCount", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "object", "", "getItem", "(I)Ljava/lang/Object;", "getItemPosition", "getItemViewType", "getLayoutId", "itemType", "getPageCount", "getRealCount", "instantiateItem", "isPagerLoop", "isViewFromObject", "arg0", "arg1", "notifyDataSetChanged", "onBindBinding", "viewType", "item", "binding", "Landroidx/databinding/ViewDataBinding;", "(ILjava/lang/Object;Landroidx/databinding/ViewDataBinding;)V", "onDestroy", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class PagerAdapterEx<T> extends PagerAdapter implements b {
    @e
    private List<? extends T> data;
    private boolean forceRefresh;
    @d
    private SparseArray<View> mapLoop = new SparseArray<>();
    private boolean modify;
    private int updateCount;

    private final T getItem(int i2) {
        if (isPagerLoop()) {
            i2 %= getRealCount();
        }
        List<? extends T> list = this.data;
        if (list == null) {
            return null;
        }
        return list.get(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@d ViewGroup viewGroup, int i2, @d Object obj) {
        viewGroup.removeView((View) obj);
    }

    @e
    public final List<T> getData() {
        return (List<? extends T>) this.data;
    }

    public boolean getForceRefresh() {
        return this.forceRefresh;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@d Object obj) {
        if (this.updateCount >= getCount()) {
            this.modify = false;
        }
        this.updateCount++;
        return this.modify ? -2 : -1;
    }

    public int getItemViewType(int i2) {
        return 0;
    }

    public final int getLastItemPosition() {
        int count = getCount();
        if (count == 0) {
            return 0;
        }
        return count - 1;
    }

    public abstract int getLayoutId(int i2);

    @Override // e.t.v.h.d.b
    public int getPageCount() {
        List<? extends T> list = this.data;
        int size = list == null ? 0 : list.size();
        if (!isPagerLoop() || size < 2) {
            return size;
        }
        return Integer.MAX_VALUE;
    }

    @Override // e.t.v.h.d.b
    public int getRealCount() {
        List<? extends T> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @d
    public Object instantiateItem(@d ViewGroup viewGroup, int i2) {
        View view;
        if (isPagerLoop()) {
            i2 %= getRealCount();
            view = this.mapLoop.get(i2);
        } else {
            view = null;
        }
        boolean z = true;
        if (view != null) {
            if (view.getParent() != null) {
                this.mapLoop.remove(i2);
            } else {
                z = false;
            }
        }
        int itemViewType = getItemViewType(i2);
        if (z || getForceRefresh()) {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), getLayoutId(itemViewType), viewGroup, false);
            View root = inflate.getRoot();
            root.setTag(new e.t.k.a.c.b(inflate));
            T item = getItem(i2);
            if (item != null) {
                onBindBinding(itemViewType, item, inflate);
            }
            this.mapLoop.put(i2, root);
            view = root;
        }
        viewGroup.addView(view);
        if (view != null) {
            return view;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // e.t.v.h.d.b
    public boolean isPagerLoop() {
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@d View view, @d Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.modify = true;
        this.updateCount = 0;
    }

    public abstract void onBindBinding(int i2, T t, @d ViewDataBinding viewDataBinding);

    public final void onDestroy() {
        this.mapLoop.clear();
    }

    public final void setData(@e List<? extends T> list) {
        this.data = list;
    }

    public void setForceRefresh(boolean z) {
        this.forceRefresh = z;
    }
}
