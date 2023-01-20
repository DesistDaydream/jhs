package e.t.k.a.c;

import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.vector.ext.AnyKt;
import e.t.l.h;
import e.t.u.p;
import h.k2.v.f0;
import h.k2.v.u;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0012\u0018\u0000 ;*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002;<B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0002J\b\u0010$\u001a\u00020\bH\u0016J\u000e\u0010%\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bJ\u0010\u0010&\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\bH\u0002J\u0006\u0010(\u001a\u00020\u001dJ\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\bH\u0002J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\bJ\u000e\u0010+\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\bJ\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\bH\u0016J\u0018\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\bH\u0016J\u0010\u00105\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u00106\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0003H\u0016J\u0010\u00107\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0003H\u0016J\u0010\u00108\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0003H\u0016J\u0010\u00109\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0003H\u0016J\u000e\u0010:\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006="}, d2 = {"Lcom/vector/design/ui/adapter/ExtendAdapterWrapper;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/vector/design/ui/adapter/BaseViewHolder;", "wrapped", "Lcom/vector/design/ui/adapter/MultiAdapterEx;", "(Lcom/vector/design/ui/adapter/MultiAdapterEx;)V", "footerSize", "", "getFooterSize", "()I", "footers", "Landroidx/collection/SparseArrayCompat;", "Lcom/vector/design/ui/adapter/ExtendAdapterWrapper$ExtendView;", "headerSize", "getHeaderSize", "headers", "observer", "com/vector/design/ui/adapter/ExtendAdapterWrapper$observer$1", "Lcom/vector/design/ui/adapter/ExtendAdapterWrapper$observer$1;", "size", "getSize", "getWrapped", "()Lcom/vector/design/ui/adapter/MultiAdapterEx;", "addFooterView", "", "view", "Landroid/view/View;", "isEmptyView", "", "isErrorView", "addHeaderView", "getExtendViewHolder", "extendView", "getFooterIndex", "position", "getItemCount", "getItemFixPosition", "getItemViewType", "getLastItemIndexWithExtend", "isEmpty", "isExtendPosition", "isFooterPosition", "isHeaderPosition", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "onFailedToRecycleView", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "removeFooterView", "Companion", "ExtendView", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c<T> extends RecyclerView.Adapter<e.t.k.a.c.b> {
    @k.e.a.d

    /* renamed from: e */
    public static final a f14547e = new a(null);

    /* renamed from: f */
    private static final int f14548f = 100000;

    /* renamed from: g */
    private static final int f14549g = 200000;

    /* renamed from: h */
    private static final int f14550h = 150000;

    /* renamed from: i */
    private static final int f14551i = 160000;
    @k.e.a.d
    private final f<T> a;
    @k.e.a.d
    private final SparseArrayCompat<b> b = new SparseArrayCompat<>();
    @k.e.a.d

    /* renamed from: c */
    private final SparseArrayCompat<b> f14552c = new SparseArrayCompat<>();
    @k.e.a.d

    /* renamed from: d */
    private final C0412c f14553d = new C0412c(this);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/vector/design/ui/adapter/ExtendAdapterWrapper$Companion;", "", "()V", "BASE_VIEW_TYPE_EMPTY", "", "BASE_VIEW_TYPE_ERROR", "BASE_VIEW_TYPE_FOOTER", "BASE_VIEW_TYPE_HEADER", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/vector/design/ui/adapter/ExtendAdapterWrapper$ExtendView;", "", "ref", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "(Ljava/lang/ref/WeakReference;)V", "getRef", "()Ljava/lang/ref/WeakReference;", "component1", "copy", "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "toString", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b {
        @k.e.a.d
        private final WeakReference<View> a;

        public b(@k.e.a.d WeakReference<View> weakReference) {
            this.a = weakReference;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ b c(b bVar, WeakReference weakReference, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                weakReference = bVar.a;
            }
            return bVar.b(weakReference);
        }

        @k.e.a.d
        public final WeakReference<View> a() {
            return this.a;
        }

        @k.e.a.d
        public final b b(@k.e.a.d WeakReference<View> weakReference) {
            return new b(weakReference);
        }

        @k.e.a.d
        public final WeakReference<View> d() {
            return this.a;
        }

        public boolean equals(@k.e.a.e Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && f0.g(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        @k.e.a.d
        public String toString() {
            return "ExtendView(ref=" + this.a + ')';
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, d2 = {"com/vector/design/ui/adapter/ExtendAdapterWrapper$observer$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: e.t.k.a.c.c$c */
    /* loaded from: classes3.dex */
    public static final class C0412c extends RecyclerView.AdapterDataObserver {
        public final /* synthetic */ c<T> a;

        public C0412c(c<T> cVar) {
            this.a = cVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.a.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3, @k.e.a.e Object obj) {
            c<T> cVar = this.a;
            cVar.notifyItemRangeChanged(i2 + cVar.h(), i3, obj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i2, int i3) {
            c<T> cVar = this.a;
            cVar.notifyItemRangeInserted(i2 + cVar.h(), i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i2, int i3, int i4) {
            c<T> cVar = this.a;
            cVar.notifyItemMoved(i2 + cVar.h(), i3 + this.a.h());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i2, int i3) {
            c<T> cVar = this.a;
            cVar.notifyItemRangeRemoved(i2 + cVar.h(), i3);
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/vector/design/ui/adapter/ExtendAdapterWrapper$onAttachedToRecyclerView$1$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class d extends GridLayoutManager.SpanSizeLookup {
        public final /* synthetic */ c<T> a;
        public final /* synthetic */ GridLayoutManager b;

        /* renamed from: c */
        public final /* synthetic */ GridLayoutManager.SpanSizeLookup f14554c;

        public d(c<T> cVar, GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.a = cVar;
            this.b = gridLayoutManager;
            this.f14554c = spanSizeLookup;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return this.a.n(i2) ? this.b.getSpanCount() : this.f14554c.getSpanSize(i2);
        }
    }

    public c(@k.e.a.d f<T> fVar) {
        this.a = fVar;
    }

    public static /* synthetic */ void c(c cVar, View view, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        cVar.b(view, z, z2);
    }

    private final e.t.k.a.c.b e(b bVar) {
        View view = (View) AnyKt.I(bVar == null ? null : bVar.d().get(), "extend view is recycled");
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(p.v(-1, -2));
        }
        ViewDataBinding binding = DataBindingUtil.getBinding(view);
        if (binding != null && this.a.i() != null) {
            binding.setLifecycleOwner(this.a.i());
            return new e.t.k.a.c.b(binding);
        }
        return new e.t.k.a.c.b(view);
    }

    private final int f(int i2) {
        return (i2 - h()) - k();
    }

    private final int j() {
        int itemCount = getItemCount();
        if (itemCount > 0) {
            return itemCount - 1;
        }
        return 0;
    }

    public final boolean n(int i2) {
        return p(i2) || o(i2);
    }

    public final void b(@k.e.a.d View view, boolean z, boolean z2) {
        b bVar = new b(new WeakReference(view));
        if (z) {
            this.f14552c.put(g() + f14550h, bVar);
        } else if (z2) {
            this.f14552c.put(g() + f14551i, bVar);
        } else {
            this.f14552c.put(g() + 200000, bVar);
        }
        notifyItemInserted(j());
    }

    public final void d(@k.e.a.d View view) {
        this.b.put(h() + 100000, new b(new WeakReference(view)));
        notifyItemInserted(h());
    }

    public final int g() {
        return this.f14552c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return h() + k() + g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (p(i2)) {
            return this.b.keyAt(i2);
        }
        if (o(i2)) {
            return this.f14552c.keyAt(f(i2));
        }
        return this.a.getItemViewType(i(i2));
    }

    public final int h() {
        return this.b.size();
    }

    public final int i(int i2) {
        return i2 - h();
    }

    public final int k() {
        return this.a.getItemCount();
    }

    @k.e.a.d
    public final f<T> l() {
        return this.a;
    }

    public final boolean m() {
        return getItemCount() == 0;
    }

    public final boolean o(int i2) {
        return i2 >= h() + k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@k.e.a.d RecyclerView recyclerView) {
        this.a.onAttachedToRecyclerView(recyclerView);
        this.a.registerAdapterDataObserver(this.f14553d);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new d(this, gridLayoutManager, gridLayoutManager.getSpanSizeLookup()));
        }
        new h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@k.e.a.d RecyclerView recyclerView) {
        this.a.onDetachedFromRecyclerView(recyclerView);
        this.a.unregisterAdapterDataObserver(this.f14553d);
    }

    public final boolean p(int i2) {
        return i2 < h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public void onBindViewHolder(@k.e.a.d e.t.k.a.c.b bVar, int i2) {
        if (n(i2)) {
            return;
        }
        this.a.onBindViewHolder(bVar, i(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k.e.a.d
    /* renamed from: r */
    public e.t.k.a.c.b onCreateViewHolder(@k.e.a.d ViewGroup viewGroup, int i2) {
        return this.b.indexOfKey(i2) >= 0 ? e(this.b.get(i2)) : this.f14552c.indexOfKey(i2) >= 0 ? e(this.f14552c.get(i2)) : this.a.onCreateViewHolder(viewGroup, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s */
    public boolean onFailedToRecycleView(@k.e.a.d e.t.k.a.c.b bVar) {
        return n(bVar.getLayoutPosition()) ? super.onFailedToRecycleView(bVar) : this.a.onFailedToRecycleView(bVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: t */
    public void onViewAttachedToWindow(@k.e.a.d e.t.k.a.c.b bVar) {
        if (n(bVar.getLayoutPosition())) {
            ViewGroup.LayoutParams layoutParams = bVar.itemView.getLayoutParams();
            if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
            new h();
            return;
        }
        this.a.onViewAttachedToWindow(bVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u */
    public void onViewDetachedFromWindow(@k.e.a.d e.t.k.a.c.b bVar) {
        if (n(bVar.getLayoutPosition())) {
            return;
        }
        this.a.onViewDetachedFromWindow(bVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: v */
    public void onViewRecycled(@k.e.a.d e.t.k.a.c.b bVar) {
        if (n(bVar.getLayoutPosition())) {
            return;
        }
        this.a.onViewRecycled(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void w(@k.e.a.d android.view.View r6) {
        /*
            r5 = this;
            int r0 = r5.g()
            r1 = -1
            if (r0 <= 0) goto L26
            r2 = 0
        L8:
            int r3 = r2 + 1
            androidx.collection.SparseArrayCompat<e.t.k.a.c.c$b> r4 = r5.f14552c
            java.lang.Object r4 = r4.valueAt(r2)
            e.t.k.a.c.c$b r4 = (e.t.k.a.c.c.b) r4
            java.lang.ref.WeakReference r4 = r4.d()
            java.lang.Object r4 = r4.get()
            boolean r4 = h.k2.v.f0.g(r4, r6)
            if (r4 == 0) goto L21
            goto L27
        L21:
            if (r3 < r0) goto L24
            goto L26
        L24:
            r2 = r3
            goto L8
        L26:
            r2 = -1
        L27:
            if (r2 == r1) goto L3b
            androidx.collection.SparseArrayCompat<e.t.k.a.c.c$b> r6 = r5.f14552c
            r6.removeAt(r2)
            int r6 = r5.k()
            int r0 = r5.h()
            int r6 = r6 + r0
            int r6 = r6 + r2
            r5.notifyItemRemoved(r6)
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.t.k.a.c.c.w(android.view.View):void");
    }
}
