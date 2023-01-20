package com.vector.view.scrollable;

import android.widget.AbsListView;
import com.vector.design.ui.delegate.LoadMore;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0007\n\u0000\n\u0000*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "com/vector/view/scrollable/GroupListView$innerOnScrollListener$2$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupListView$innerOnScrollListener$2 extends Lambda implements h.k2.u.a<a> {
    public final /* synthetic */ GroupListView this$0;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vector/view/scrollable/GroupListView$innerOnScrollListener$2$1", "Landroid/widget/AbsListView$OnScrollListener;", "firstVisibleItem", "", "getFirstVisibleItem", "()I", "setFirstVisibleItem", "(I)V", "totalItemCount", "getTotalItemCount", "setTotalItemCount", "visibleItemCount", "getVisibleItemCount", "setVisibleItemCount", "onScroll", "", "view", "Landroid/widget/AbsListView;", "onScrollStateChanged", "scrollState", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements AbsListView.OnScrollListener {
        private int a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f8050c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ GroupListView f8051d;

        public a(GroupListView groupListView) {
            this.f8051d = groupListView;
        }

        public final int a() {
            return this.a;
        }

        public final int b() {
            return this.f8050c;
        }

        public final int c() {
            return this.b;
        }

        public final void d(int i2) {
            this.a = i2;
        }

        public final void e(int i2) {
            this.f8050c = i2;
        }

        public final void f(int i2) {
            this.b = i2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(@d AbsListView absListView, int i2, int i3, int i4) {
            List<e.t.k.a.e.a> list;
            list = this.f8051d.f8047k;
            if (list != null) {
                for (e.t.k.a.e.a aVar : list) {
                    aVar.onScroll(absListView, i2, i3, i4);
                }
            }
            this.a = i2;
            this.b = i3;
            this.f8050c = i4;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(@d AbsListView absListView, int i2) {
            List<e.t.k.a.e.a> list;
            LoadMore.b bVar;
            boolean z;
            list = this.f8051d.f8047k;
            if (list != null) {
                for (e.t.k.a.e.a aVar : list) {
                    aVar.onScrollStateChanged(absListView, i2);
                }
            }
            bVar = this.f8051d.f8045i;
            if (bVar == null) {
                return;
            }
            z = this.f8051d.f8044h;
            if (z || i2 != 0) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupListView$innerOnScrollListener$2(GroupListView groupListView) {
        super(0);
        this.this$0 = groupListView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final a invoke() {
        return new a(this.this$0);
    }
}
