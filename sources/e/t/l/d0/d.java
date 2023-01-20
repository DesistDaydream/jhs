package e.t.l.d0;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.qiniu.android.collect.ReportItem;
import com.vector.design.ui.nav.AppBar;
import h.k2.u.l;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aG\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072%\b\u0002\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0002\u001aA\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00072%\b\u0002\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¨\u0006\u000f"}, d2 = {"setAppBarAlpha", "", "delegate", "Lcom/vector/design/ui/delegate/RefreshDelegate;", "appBar", "Lcom/vector/design/ui/nav/AppBar;", "height", "", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "alpha", "fadeByScroll", "inHeight", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class d {

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/vector/ext/view/ViewKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f14580c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AppBar f14581d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.t.k.a.e.b f14582e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f14583f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ l f14584g;

        public a(View view, boolean z, ViewTreeObserver viewTreeObserver, AppBar appBar, e.t.k.a.e.b bVar, int i2, l lVar) {
            this.a = view;
            this.b = z;
            this.f14580c = viewTreeObserver;
            this.f14581d = appBar;
            this.f14582e = bVar;
            this.f14583f = i2;
            this.f14584g = lVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            int height = this.f14581d.getHeight();
            if (height != 0) {
                d.d(this.f14582e, this.f14581d, this.f14583f - height, this.f14584g);
            }
            if (this.b) {
                return true;
            }
            if (this.f14580c.isAlive()) {
                this.f14580c.removeOnPreDrawListener(this);
                return true;
            }
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"com/vector/ext/view/AppBarKt$setAppBarAlpha$1", "Lcom/vector/design/ui/delegate/OnScrollMixListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrolled", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b extends e.t.k.a.e.a {
        public final /* synthetic */ int a;
        public final /* synthetic */ AppBar b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l<Integer, t1> f14585c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(int i2, AppBar appBar, l<? super Integer, t1> lVar) {
            this.a = i2;
            this.b = appBar;
            this.f14585c = lVar;
        }

        @Override // e.t.k.a.e.a, android.widget.AbsListView.OnScrollListener
        public void onScroll(@k.e.a.d AbsListView absListView, int i2, int i3, int i4) {
            int i5 = 255;
            if (i2 == 0) {
                float f2 = (-absListView.getChildAt(0).getTop()) / this.a;
                if (f2 > 1.0f) {
                    f2 = 1.0f;
                }
                i5 = (int) (f2 * 255);
            } else if (i2 <= 0) {
                i5 = 0;
            }
            this.b.setBackgroundAlpha(i5);
            l<Integer, t1> lVar = this.f14585c;
            if (lVar == null) {
                return;
            }
            lVar.invoke(Integer.valueOf(i5));
        }

        @Override // e.t.k.a.e.a, androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@k.e.a.d RecyclerView recyclerView, int i2, int i3) {
            int i4;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                int i5 = 0;
                if (layoutManager instanceof GridLayoutManager) {
                    i4 = ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
                } else if (layoutManager instanceof LinearLayoutManager) {
                    i4 = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                } else {
                    i4 = layoutManager instanceof StaggeredGridLayoutManager ? ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null)[0] : 0;
                }
                if (i4 == 0) {
                    View childAt = recyclerView.getChildAt(0);
                    Integer valueOf = childAt != null ? Integer.valueOf(childAt.getTop()) : null;
                    if (valueOf != null) {
                        float f2 = (-valueOf.intValue()) / this.a;
                        if (f2 > 1.0f) {
                            f2 = 1.0f;
                        }
                        i5 = (int) (f2 * 255);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else if (i4 > 0) {
                    i5 = 255;
                }
                this.b.setBackgroundAlpha(i5);
                l<Integer, t1> lVar = this.f14585c;
                if (lVar == null) {
                    return;
                }
                lVar.invoke(Integer.valueOf(i5));
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final void b(@k.e.a.d AppBar appBar, @k.e.a.d e.t.k.a.e.b bVar, int i2, @k.e.a.e l<? super Integer, t1> lVar) {
        if (appBar.getHeight() == 0 && appBar.getVisibility() != 8 && appBar.getViewTreeObserver().isAlive()) {
            ViewTreeObserver viewTreeObserver = appBar.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnPreDrawListener(new a(appBar, false, viewTreeObserver, appBar, bVar, i2, lVar));
                return;
            }
            return;
        }
        d(bVar, appBar, i2 - appBar.getHeight(), lVar);
    }

    public static /* synthetic */ void c(AppBar appBar, e.t.k.a.e.b bVar, int i2, l lVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            lVar = null;
        }
        b(appBar, bVar, i2, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(e.t.k.a.e.b bVar, AppBar appBar, int i2, l<? super Integer, t1> lVar) {
        bVar.a(new b(i2, appBar, lVar));
    }

    public static /* synthetic */ void e(e.t.k.a.e.b bVar, AppBar appBar, int i2, l lVar, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            lVar = null;
        }
        d(bVar, appBar, i2, lVar);
    }
}
