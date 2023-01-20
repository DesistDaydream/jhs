package com.vector.util;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.android.flexbox.FlexboxLayoutManager;
import e.n.i;
import e.t.u.s;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bJ\"\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bJ\"\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u001a\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b¨\u0006\u0014"}, d2 = {"Lcom/vector/util/LayoutManagers;", "", "()V", "flexBox", "Lcom/vector/util/LayoutManagers$LayoutManagerFactory;", "orientation", "Lcom/vector/util/LayoutManagers$Orientation;", "wrap", "", "fully", "reverseLayout", "", "grid", "spanCount", "grid2", "linear", "scroll", "staggeredGrid", "LayoutManagerFactory", ExifInterface.TAG_ORIENTATION, "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class LayoutManagers {
    @k.e.a.d
    public static final LayoutManagers a = new LayoutManagers();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/vector/util/LayoutManagers$Orientation;", "", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "", "(Ljava/lang/String;II)V", "getInt", "()I", "VERTICAL", "HORIZONTAL", "ROW", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum Orientation {
        VERTICAL(1),
        HORIZONTAL(0),
        ROW(0);
        

        /* renamed from: int  reason: not valid java name */
        private final int f0int;

        Orientation(int i2) {
            this.f0int = i2;
        }

        public final int getInt() {
            return this.f0int;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/vector/util/LayoutManagers$LayoutManagerFactory;", "", "create", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getState", "Lcom/live/LiveBool;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public interface a {
        @k.e.a.d
        RecyclerView.LayoutManager create(@k.e.a.e Context context);

        @k.e.a.d
        i getState();
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/vector/util/LayoutManagers$flexBox$1", "Lcom/vector/util/LayoutManagers$LayoutManagerFactory;", "create", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getState", "Lcom/live/LiveBool;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b implements a {
        public final /* synthetic */ Orientation a;
        public final /* synthetic */ int b;

        public b(Orientation orientation, int i2) {
            this.a = orientation;
            this.b = i2;
        }

        @Override // com.vector.util.LayoutManagers.a
        @k.e.a.d
        public RecyclerView.LayoutManager create(@k.e.a.e Context context) {
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(context, this.a.getInt());
            flexboxLayoutManager.setFlexWrap(this.b);
            return flexboxLayoutManager;
        }

        @Override // com.vector.util.LayoutManagers.a
        @k.e.a.d
        public i getState() {
            return s.a();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/vector/util/LayoutManagers$fully$1", "Lcom/vector/util/LayoutManagers$LayoutManagerFactory;", "create", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getState", "Lcom/live/LiveBool;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class c implements a {
        public final /* synthetic */ Orientation a;
        public final /* synthetic */ boolean b;

        public c(Orientation orientation, boolean z) {
            this.a = orientation;
            this.b = z;
        }

        @Override // com.vector.util.LayoutManagers.a
        @k.e.a.d
        public RecyclerView.LayoutManager create(@k.e.a.e Context context) {
            return new FullyLinearLayoutManager(context, this.a.getInt(), this.b);
        }

        @Override // com.vector.util.LayoutManagers.a
        @k.e.a.d
        public i getState() {
            return s.a();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/vector/util/LayoutManagers$grid$1", "Lcom/vector/util/LayoutManagers$LayoutManagerFactory;", "create", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getState", "Lcom/live/LiveBool;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class d implements a {
        public final /* synthetic */ int a;
        public final /* synthetic */ Orientation b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f7896c;

        public d(int i2, Orientation orientation, boolean z) {
            this.a = i2;
            this.b = orientation;
            this.f7896c = z;
        }

        @Override // com.vector.util.LayoutManagers.a
        @k.e.a.d
        public RecyclerView.LayoutManager create(@k.e.a.e Context context) {
            return new sssLayoutManager(context, this.a, this.b.getInt(), this.f7896c);
        }

        @Override // com.vector.util.LayoutManagers.a
        @k.e.a.d
        public i getState() {
            return s.a();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/vector/util/LayoutManagers$grid2$1", "Lcom/vector/util/LayoutManagers$LayoutManagerFactory;", "create", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getState", "Lcom/live/LiveBool;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class e implements a {
        public final /* synthetic */ int a;
        public final /* synthetic */ Orientation b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f7897c;

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/vector/util/LayoutManagers$grid2$1$create$1$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class a extends GridLayoutManager.SpanSizeLookup {
            public final /* synthetic */ GridLayoutManager a;

            public a(GridLayoutManager gridLayoutManager) {
                this.a = gridLayoutManager;
            }

            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i2) {
                if (i2 == 0) {
                    return this.a.getSpanCount();
                }
                return 1;
            }
        }

        public e(int i2, Orientation orientation, boolean z) {
            this.a = i2;
            this.b = orientation;
            this.f7897c = z;
        }

        @Override // com.vector.util.LayoutManagers.a
        @k.e.a.d
        public RecyclerView.LayoutManager create(@k.e.a.e Context context) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, this.a, this.b.getInt(), this.f7897c);
            gridLayoutManager.setSpanSizeLookup(new a(gridLayoutManager));
            return gridLayoutManager;
        }

        @Override // com.vector.util.LayoutManagers.a
        @k.e.a.d
        public i getState() {
            return s.a();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/vector/util/LayoutManagers$linear$1", "Lcom/vector/util/LayoutManagers$LayoutManagerFactory;", "create", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getState", "Lcom/live/LiveBool;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class f implements a {
        public final /* synthetic */ Orientation a;
        public final /* synthetic */ boolean b;

        public f(Orientation orientation, boolean z) {
            this.a = orientation;
            this.b = z;
        }

        @Override // com.vector.util.LayoutManagers.a
        @k.e.a.d
        public RecyclerView.LayoutManager create(@k.e.a.e Context context) {
            return new FixLinearLayoutManager(context, this.a.getInt(), this.b);
        }

        @Override // com.vector.util.LayoutManagers.a
        @k.e.a.d
        public i getState() {
            return s.a();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/vector/util/LayoutManagers$scroll$1", "Lcom/vector/util/LayoutManagers$LayoutManagerFactory;", "create", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getState", "Lcom/live/LiveBool;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class g implements a {
        @Override // com.vector.util.LayoutManagers.a
        @k.e.a.d
        public RecyclerView.LayoutManager create(@k.e.a.e Context context) {
            return new ScrollLinearLayoutManager(context);
        }

        @Override // com.vector.util.LayoutManagers.a
        @k.e.a.d
        public i getState() {
            return s.a();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/vector/util/LayoutManagers$staggeredGrid$1", "Lcom/vector/util/LayoutManagers$LayoutManagerFactory;", "create", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getState", "Lcom/live/LiveBool;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class h implements a {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public h(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        @Override // com.vector.util.LayoutManagers.a
        @k.e.a.d
        public RecyclerView.LayoutManager create(@k.e.a.e Context context) {
            return new StaggeredGridLayoutManager(this.a, this.b);
        }

        @Override // com.vector.util.LayoutManagers.a
        @k.e.a.d
        public i getState() {
            return s.a();
        }
    }

    private LayoutManagers() {
    }

    public static /* synthetic */ a b(LayoutManagers layoutManagers, Orientation orientation, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            orientation = Orientation.ROW;
        }
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        return layoutManagers.a(orientation, i2);
    }

    public static /* synthetic */ a d(LayoutManagers layoutManagers, Orientation orientation, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            orientation = Orientation.VERTICAL;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        return layoutManagers.c(orientation, z);
    }

    public static /* synthetic */ a f(LayoutManagers layoutManagers, int i2, Orientation orientation, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            orientation = Orientation.VERTICAL;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return layoutManagers.e(i2, orientation, z);
    }

    public static /* synthetic */ a h(LayoutManagers layoutManagers, int i2, Orientation orientation, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            orientation = Orientation.VERTICAL;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return layoutManagers.g(i2, orientation, z);
    }

    public static /* synthetic */ a j(LayoutManagers layoutManagers, Orientation orientation, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            orientation = Orientation.VERTICAL;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        return layoutManagers.i(orientation, z);
    }

    @k.e.a.d
    public final a a(@k.e.a.d Orientation orientation, int i2) {
        return new b(orientation, i2);
    }

    @k.e.a.d
    public final a c(@k.e.a.d Orientation orientation, boolean z) {
        return new c(orientation, z);
    }

    @k.e.a.d
    public final a e(int i2, @k.e.a.d Orientation orientation, boolean z) {
        return new d(i2, orientation, z);
    }

    @k.e.a.d
    public final a g(int i2, @k.e.a.d Orientation orientation, boolean z) {
        return new e(i2, orientation, z);
    }

    @k.e.a.d
    public final a i(@k.e.a.d Orientation orientation, boolean z) {
        return new f(orientation, z);
    }

    @k.e.a.d
    public final a k() {
        return new g();
    }

    @k.e.a.d
    public final a l(int i2, int i3) {
        return new h(i2, i3);
    }
}
