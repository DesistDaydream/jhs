package e.l.h.j.b.f;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006#"}, d2 = {"Lcom/jihuanshe/base/ui/widget/list/GridLayoutManagerDivider;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "includeEdge", "", "getIncludeEdge", "()Z", "setIncludeEdge", "(Z)V", "leftRightSpace", "", "getLeftRightSpace", "()I", "setLeftRightSpace", "(I)V", "notFirst", "getNotFirst", "setNotFirst", "spanCount", "getSpanCount", "setSpanCount", "upDownSpace", "getUpDownSpace", "setUpDownSpace", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "Companion", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class a extends RecyclerView.ItemDecoration {
    @d

    /* renamed from: f  reason: collision with root package name */
    public static final C0388a f12132f = new C0388a(null);
    private int a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f12133c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12134d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12135e;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/jihuanshe/base/ui/widget/list/GridLayoutManagerDivider$Companion;", "", "()V", "build", "Lcom/jihuanshe/base/ui/widget/list/GridLayoutManagerDivider;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: e.l.h.j.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0388a {
        private C0388a() {
        }

        public /* synthetic */ C0388a(u uVar) {
            this();
        }

        @d
        public final a a(@d l<? super a, t1> lVar) {
            a aVar = new a(null);
            lVar.invoke(aVar);
            return aVar;
        }
    }

    private a() {
    }

    public /* synthetic */ a(u uVar) {
        this();
    }

    public final boolean a() {
        return this.f12134d;
    }

    public final int b() {
        return this.f12133c;
    }

    public final boolean c() {
        return this.f12135e;
    }

    public final int d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    public final void f(boolean z) {
        this.f12134d = z;
    }

    public final void g(int i2) {
        this.f12133c = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@d Rect rect, @d View view, @d RecyclerView recyclerView, @d RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == 0 && this.f12135e) {
            return;
        }
        int i2 = childAdapterPosition - (this.f12135e ? 1 : 0);
        int i3 = this.a;
        int i4 = i2 % i3;
        if (this.f12134d) {
            int i5 = this.f12133c;
            rect.left = i5 - ((i4 * i5) / i3);
            rect.right = ((i4 + 1) * i5) / i3;
            if (i2 < i3) {
                rect.top = this.b;
            }
            rect.bottom = this.b;
            return;
        }
        int i6 = this.f12133c;
        rect.left = (i4 * i6) / i3;
        rect.right = i6 - (((i4 + 1) * i6) / i3);
        if (i2 >= i3) {
            rect.top = this.b;
        }
    }

    public final void h(boolean z) {
        this.f12135e = z;
    }

    public final void i(int i2) {
        this.a = i2;
    }

    public final void j(int i2) {
        this.b = i2;
    }
}
