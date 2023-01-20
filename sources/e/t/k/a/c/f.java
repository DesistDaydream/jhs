package e.t.k.a.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.vector.ext.view.ViewKt$findAll$1;
import com.vector.network.image.NImageView;
import e.t.l.d0.h;
import h.k2.v.f0;
import h.k2.v.u;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001<B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u001d\u0010 \u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ(\u0010!\u001a\u00020\"2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bH\u0002J\r\u0010#\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010$J\u0015\u0010%\u001a\u0004\u0018\u00018\u00002\u0006\u0010&\u001a\u00020\u0011¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0011H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010&\u001a\u00020\u0011H\u0016J\r\u0010+\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010$J\u0006\u0010,\u001a\u00020\u0011J\u0010\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0011H&J\u0006\u0010/\u001a\u00020\u0019J%\u00100\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00112\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u000203H&¢\u0006\u0002\u00104J\u0018\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0011H\u0016J\u0018\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u0002092\u0006\u0010.\u001a\u00020\u0011H\u0016J(\u0010:\u001a\u00020\"2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bH\u0016J\u0010\u0010;\u001a\u00020\"2\u0006\u00106\u001a\u00020\u0003H\u0016R4\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006="}, d2 = {"Lcom/vector/design/ui/adapter/MultiAdapterEx;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/vector/design/ui/adapter/BaseViewHolder;", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "value", "", "data", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getOwner$vector_release", "()Landroidx/lifecycle/LifecycleOwner;", "pos", "", "getPos", "()I", "setPos", "(I)V", "size", "getSize", "usingDiffCompare", "", "getUsingDiffCompare", "()Z", "areContentsTheSame", "old", "new", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "areItemsTheSame", "compareItems", "", "getFirstItem", "()Ljava/lang/Object;", "getItem", "position", "(I)Ljava/lang/Object;", "getItemCount", "getItemId", "", "getLastItem", "getLastItemIndex", "getLayoutId", "viewType", "isEmpty", "onBindBinding", "item", "binding", "Landroidx/databinding/ViewDataBinding;", "(ILjava/lang/Object;Landroidx/databinding/ViewDataBinding;)V", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "onSetData", "onViewRecycled", "AdapterListUpdateCallback", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class f<T> extends RecyclerView.Adapter<e.t.k.a.c.b> {
    @k.e.a.e
    private final LifecycleOwner a;
    @k.e.a.e
    private List<? extends T> b;

    /* renamed from: c */
    private int f14555c;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/vector/design/ui/adapter/MultiAdapterEx$AdapterListUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "wrapped", "Lcom/vector/design/ui/adapter/MultiAdapterEx;", "(Lcom/vector/design/ui/adapter/MultiAdapterEx;)V", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements ListUpdateCallback {
        @k.e.a.d
        private final f<?> a;

        public a(@k.e.a.d f<?> fVar) {
            this.a = fVar;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i2, int i3, @k.e.a.e Object obj) {
            this.a.notifyItemRangeChanged(i2, i3, obj);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i2, int i3) {
            this.a.notifyItemRangeInserted(i2, i3);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i2, int i3) {
            this.a.notifyItemMoved(i2, i3);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i2, int i3) {
            this.a.notifyItemRangeRemoved(i2, i3);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/vector/design/ui/adapter/MultiAdapterEx$data$diff$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b extends DiffUtil.Callback {
        public final /* synthetic */ f<T> a;
        public final /* synthetic */ List<T> b;

        /* renamed from: c */
        public final /* synthetic */ List<T> f14556c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(f<T> fVar, List<? extends T> list, List<? extends T> list2) {
            this.a = fVar;
            this.b = list;
            this.f14556c = list2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i2, int i3) {
            return this.a.a(this.b.get(i2), this.f14556c.get(i3));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i2, int i3) {
            return this.a.b(this.b.get(i2), this.f14556c.get(i3));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        @k.e.a.e
        public Object getChangePayload(int i2, int i3) {
            T t = this.f14556c.get(i3);
            if (areContentsTheSame(i2, i3)) {
                return null;
            }
            return t;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.f14556c.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.b.size();
        }
    }

    public f() {
        this(null, 1, null);
    }

    public /* synthetic */ f(LifecycleOwner lifecycleOwner, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : lifecycleOwner);
    }

    private final void c(List<? extends T> list, List<? extends T> list2) {
        if (list != null && (!list.isEmpty()) && list2 == null) {
            notifyItemRangeRemoved(0, list.size());
        } else {
            notifyDataSetChanged();
        }
    }

    public boolean a(T t, T t2) {
        return b(t, t2);
    }

    public boolean b(T t, T t2) {
        return false;
    }

    @k.e.a.e
    public List<T> d() {
        return (List<? extends T>) this.b;
    }

    @k.e.a.e
    public final T e() {
        List<T> d2 = d();
        if (d2 == null) {
            return null;
        }
        return (T) CollectionsKt___CollectionsKt.t2(d2);
    }

    @k.e.a.e
    public final T f() {
        List<T> d2 = d();
        if (d2 == null) {
            return null;
        }
        return (T) CollectionsKt___CollectionsKt.i3(d2);
    }

    public final int g() {
        List<T> d2 = d();
        int G = d2 == null ? 0 : CollectionsKt__CollectionsKt.G(d2);
        if (G < 0) {
            return 0;
        }
        return G;
    }

    @k.e.a.e
    public final T getItem(int i2) {
        List<T> d2 = d();
        if (d2 == null) {
            return null;
        }
        return (T) CollectionsKt___CollectionsKt.J2(d2, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return hasStableIds() ? i2 : super.getItemId(i2);
    }

    public abstract int h(int i2);

    @k.e.a.e
    public final LifecycleOwner i() {
        return this.a;
    }

    public final int j() {
        return this.f14555c;
    }

    public final int k() {
        List<T> d2 = d();
        if (d2 == null) {
            return 0;
        }
        return d2.size();
    }

    public boolean l() {
        return false;
    }

    public final boolean m() {
        return k() == 0;
    }

    public abstract void n(int i2, T t, @k.e.a.d ViewDataBinding viewDataBinding);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(@k.e.a.d e.t.k.a.c.b bVar, int i2) {
        this.f14555c = i2;
        ViewDataBinding a2 = bVar.a();
        if (a2 == null) {
            return;
        }
        List d2 = d();
        Object J2 = d2 == null ? null : CollectionsKt___CollectionsKt.J2(d2, i2);
        if (J2 == null) {
            return;
        }
        n(getItemViewType(i2), J2, a2);
        LifecycleOwner lifecycleOwner = a2.getLifecycleOwner();
        if (lifecycleOwner == null || !f0.g(lifecycleOwner, this.a)) {
            a2.setLifecycleOwner(this.a);
        }
        a2.executePendingBindings();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k.e.a.d
    /* renamed from: p */
    public e.t.k.a.c.b onCreateViewHolder(@k.e.a.d ViewGroup viewGroup, int i2) {
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), h(i2), viewGroup, false);
        LifecycleOwner lifecycleOwner = this.a;
        if (lifecycleOwner == null) {
            lifecycleOwner = ViewKt.findViewTreeLifecycleOwner(viewGroup);
        }
        if (lifecycleOwner != null) {
            com.vector.ext.view.ViewKt.G(inflate.getRoot(), lifecycleOwner);
        }
        return new e.t.k.a.c.b(inflate);
    }

    public void q(@k.e.a.e List<? extends T> list, @k.e.a.e List<? extends T> list2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r */
    public void onViewRecycled(@k.e.a.d e.t.k.a.c.b bVar) {
        if (e.t.a.c().c()) {
            View view = bVar.itemView;
            if (view instanceof ViewGroup) {
                ArrayList<NImageView> arrayList = new ArrayList();
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.addLast(view);
                while (!arrayDeque.isEmpty()) {
                    View view2 = (View) arrayDeque.getFirst();
                    if (view2 instanceof ViewGroup) {
                        h.a((ViewGroup) view2, new ViewKt$findAll$1(arrayDeque));
                    }
                    if (view2 instanceof NImageView) {
                        arrayList.add(view2);
                    }
                    arrayDeque.pollFirst();
                }
                for (NImageView nImageView : arrayList) {
                    nImageView.clear();
                }
            }
        }
    }

    public final void s(int i2) {
        this.f14555c = i2;
    }

    public void setData(@k.e.a.e List<? extends T> list) {
        List<? extends T> list2;
        List<? extends T> list3 = this.b;
        if (list != null) {
            list2 = new ArrayList<>();
            list2.addAll(list);
        } else {
            list2 = list;
        }
        this.b = list2;
        if (list3 == null && list == null) {
            return;
        }
        q(list3, list2);
        if (!l()) {
            c(list3, list);
        } else if (list3 != null && list != null) {
            DiffUtil.calculateDiff(new b(this, list3, list)).dispatchUpdatesTo(new a(this));
        } else {
            c(list3, list);
        }
    }

    public f(@k.e.a.e LifecycleOwner lifecycleOwner) {
        this.a = lifecycleOwner;
    }
}
