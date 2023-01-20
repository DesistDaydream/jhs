package e.l.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewKt;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes2.dex */
public abstract class e<T> extends BaseAdapter {
    @k.e.a.e
    private List<? extends T> a;
    private int b = -1;

    @k.e.a.e
    public final List<T> a() {
        return (List<? extends T>) this.a;
    }

    public abstract int b();

    public final int c() {
        return this.b;
    }

    public abstract void d(@k.e.a.e T t, @k.e.a.e ViewDataBinding viewDataBinding);

    public boolean e() {
        return true;
    }

    public final void f(@k.e.a.e List<? extends T> list) {
        this.a = list;
        notifyDataSetChanged();
    }

    public final void g(int i2) {
        this.b = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<? extends T> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    @k.e.a.e
    public T getItem(int i2) {
        List<? extends T> list = this.a;
        if (list == null) {
            return null;
        }
        return (T) CollectionsKt___CollectionsKt.J2(list, i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.Adapter
    @k.e.a.d
    public View getView(int i2, @k.e.a.e View view, @k.e.a.e ViewGroup viewGroup) {
        this.b = i2;
        if (view == null || !e()) {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), b(), viewGroup, false);
            LifecycleOwner findViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(viewGroup);
            if (findViewTreeLifecycleOwner != null) {
                com.vector.ext.view.ViewKt.G(inflate.getRoot(), findViewTreeLifecycleOwner);
            }
            new e.t.k.a.c.b(inflate);
            View root = inflate.getRoot();
            root.setTag(new e.t.k.a.c.b(inflate));
            view = root;
        }
        Object tag = view.getTag();
        Objects.requireNonNull(tag, "null cannot be cast to non-null type com.vector.design.ui.adapter.BaseViewHolder");
        e.t.k.a.c.b bVar = (e.t.k.a.c.b) tag;
        List<? extends T> list = this.a;
        d(list == null ? null : CollectionsKt___CollectionsKt.J2(list, i2), bVar.a());
        return view;
    }
}
