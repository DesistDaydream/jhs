package e.l.h.j.b.f;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.vector.util.Res;
import e.t.k.a.c.c;
import e.t.l.h;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.u;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 V2\u00020\u0001:\u0001VB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002J\u0018\u00108\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002J\u0018\u00109\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002J(\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u00106\u001a\u0002072\u0006\u0010?\u001a\u00020@H\u0016J\u0017\u0010A\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010CJ\u001f\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00192\b\u0010B\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010FJ\u001f\u0010G\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00192\b\u0010B\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010FJ\u000e\u0010H\u001a\u00020\u00042\u0006\u00106\u001a\u000207J!\u0010I\u001a\u00020\u00042\b\u0010J\u001a\u0004\u0018\u00010\u00192\b\u0010B\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010KJ+\u0010I\u001a\u00020\u00042\b\u0010J\u001a\u0004\u0018\u00010\u00192\b\u0010B\u001a\u0004\u0018\u00010\u00192\b\u0010L\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010MJ\u001f\u0010N\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00192\b\u0010B\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010FJ)\u0010O\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00192\b\u0010B\u001a\u0004\u0018\u00010\u00192\b\u0010J\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010PJ \u0010Q\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010R\u001a\u0002032\b\b\u0001\u0010S\u001a\u00020\u0019J\u0010\u0010T\u001a\u0002032\b\b\u0001\u0010U\u001a\u00020\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\u001a\u0010'\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001a\u0010*\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001d¨\u0006W"}, d2 = {"Lcom/jihuanshe/base/ui/widget/list/LinearLayoutDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "drawBottom", "", "getDrawBottom", "()Z", "setDrawBottom", "(Z)V", "drawFooter", "getDrawFooter", "setDrawFooter", "drawHeader", "getDrawHeader", "setDrawHeader", "drawLeft", "getDrawLeft", "setDrawLeft", "drawRight", "getDrawRight", "setDrawRight", "drawTop", "getDrawTop", "setDrawTop", "headerHeight", "", "getHeaderHeight", "()I", "setHeaderHeight", "(I)V", "marginDrawLeftHorizontal", "getMarginDrawLeftHorizontal", "setMarginDrawLeftHorizontal", "marginDrawRightHorizontal", "getMarginDrawRightHorizontal", "setMarginDrawRightHorizontal", "marginHorizontal", "getMarginHorizontal", "setMarginHorizontal", "marginVertical", "getMarginVertical", "setMarginVertical", "offset", "getOffset", "setOffset", "paint", "Landroid/graphics/Paint;", "size", "getSize", "setSize", "drawGrid", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "drawHorizontal", "drawVertical", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "isFirst", "position", "(Ljava/lang/Integer;)Z", "isFirstColumn", "spanCount", "(ILjava/lang/Integer;)Z", "isFirstRow", "isFooter", "isLast", "count", "(Ljava/lang/Integer;Ljava/lang/Integer;)Z", "footSize", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Z", "isLastColumn", "isLastRow", "(ILjava/lang/Integer;Ljava/lang/Integer;)Z", "onDraw", "setDividerColor", "color", "setDividerColorRes", "resId", "Companion", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class b extends RecyclerView.ItemDecoration {
    @d
    public static final a o = new a(null);
    @d
    private Paint a;
    private int b;

    /* renamed from: c */
    private int f12136c;

    /* renamed from: d */
    private int f12137d;

    /* renamed from: e */
    private int f12138e;

    /* renamed from: f */
    private boolean f12139f;

    /* renamed from: g */
    private boolean f12140g;

    /* renamed from: h */
    private boolean f12141h;

    /* renamed from: i */
    private boolean f12142i;

    /* renamed from: j */
    private int f12143j;

    /* renamed from: k */
    private boolean f12144k;

    /* renamed from: l */
    private boolean f12145l;

    /* renamed from: m */
    private boolean f12146m;
    private boolean n;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/jihuanshe/base/ui/widget/list/LinearLayoutDecoration$Companion;", "", "()V", "build", "Lcom/jihuanshe/base/ui/widget/list/LinearLayoutDecoration;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final b a(@d l<? super b, t1> lVar) {
            b bVar = new b(null);
            lVar.invoke(bVar);
            return bVar;
        }
    }

    private b() {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        t1 t1Var = t1.a;
        this.a = paint;
    }

    public /* synthetic */ b(u uVar) {
        this();
    }

    private final void a(Canvas canvas, RecyclerView recyclerView) {
        canvas.save();
        Rect rect = new Rect();
        int childCount = recyclerView.getChildCount();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Integer valueOf = adapter == null ? null : Integer.valueOf(adapter.getItemCount());
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        int i2 = 0;
        int spanCount = gridLayoutManager == null ? 0 : gridLayoutManager.getSpanCount();
        if (childCount > 0) {
            while (true) {
                int i3 = i2 + 1;
                View childAt = recyclerView.getChildAt(i2);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                RecyclerView.LayoutParams layoutParams2 = layoutParams instanceof RecyclerView.LayoutParams ? (RecyclerView.LayoutParams) layoutParams : null;
                Integer valueOf2 = layoutParams2 == null ? null : Integer.valueOf(layoutParams2.getViewLayoutPosition());
                RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                if (layoutManager2 != null) {
                    layoutManager2.getDecoratedBoundsWithMargins(childAt, rect);
                }
                if (this.f12145l && q(spanCount, valueOf2)) {
                    int i4 = rect.top;
                    int i5 = this.b;
                    int i6 = i4 + i5;
                    int i7 = rect.left;
                    int i8 = this.f12138e;
                    int i9 = i7 + i8;
                    int i10 = (rect.right - i8) - i5;
                    if (this.f12144k && p(spanCount, valueOf2)) {
                        i9 += this.b;
                    }
                    if (!this.f12146m && u(spanCount, valueOf2)) {
                        i10 += this.b;
                    }
                    canvas.drawRect(i9, i4, i10, i6, this.a);
                }
                boolean v = v(spanCount, valueOf2, valueOf);
                if ((this.n && v) || !v) {
                    int i11 = rect.bottom;
                    int i12 = this.b;
                    int i13 = i11 - i12;
                    int i14 = rect.left;
                    int i15 = this.f12138e;
                    int i16 = i14 + i15;
                    int i17 = (rect.right - i15) - i12;
                    if (p(spanCount, valueOf2)) {
                        i16 += this.b;
                    }
                    canvas.drawRect(i16, i13, i17, i11, this.a);
                }
                if (this.f12144k && p(spanCount, valueOf2)) {
                    int i18 = rect.top;
                    int i19 = this.f12137d;
                    int i20 = i18 + i19;
                    int i21 = rect.bottom - i19;
                    int i22 = this.b;
                    int i23 = i21 - i22;
                    int i24 = rect.left;
                    int i25 = i22 + i24;
                    if (q(spanCount, valueOf2)) {
                        i20 += this.b;
                    }
                    canvas.drawRect(i24, i20, i25, i23, this.a);
                }
                boolean u = u(spanCount, valueOf2);
                if ((this.f12146m && u) || !u) {
                    int i26 = rect.top;
                    int i27 = this.f12137d;
                    int i28 = i26 + i27;
                    int i29 = rect.bottom - i27;
                    int i30 = this.b;
                    int i31 = i29 - i30;
                    int i32 = rect.right;
                    int i33 = i32 - i30;
                    if (q(spanCount, valueOf2)) {
                        i28 += this.b;
                    }
                    canvas.drawRect(i33, i28, i32, i31, this.a);
                }
                if (i3 >= childCount) {
                    break;
                }
                i2 = i3;
            }
        }
        canvas.restore();
    }

    private final void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int i2;
        int width;
        Integer num;
        View view;
        int i3;
        int width2;
        int paddingEnd;
        RecyclerView recyclerView2 = recyclerView;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            if (this.f12139f) {
                i2 = recyclerView.getPaddingStart() + this.f12138e;
            } else {
                i2 = recyclerView.getPaddingStart();
            }
            if (this.f12140g) {
                width2 = recyclerView.getWidth() - recyclerView.getPaddingEnd();
                paddingEnd = this.f12138e;
            } else {
                width2 = recyclerView.getWidth();
                paddingEnd = recyclerView.getPaddingEnd();
            }
            width = width2 - paddingEnd;
            canvas.clipRect(i2, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i2 = this.f12138e + 0;
            width = recyclerView.getWidth() - this.f12138e;
        }
        Rect rect = new Rect();
        int childCount = recyclerView.getChildCount();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Integer valueOf = adapter == null ? null : Integer.valueOf(adapter.getItemCount());
        if (childCount > 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                if ((valueOf == null ? 0 : valueOf.intValue()) < this.f12136c) {
                    i3 = i5;
                } else {
                    View childAt = recyclerView2.getChildAt(i4);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    RecyclerView.LayoutParams layoutParams2 = layoutParams instanceof RecyclerView.LayoutParams ? (RecyclerView.LayoutParams) layoutParams : null;
                    Integer valueOf2 = layoutParams2 == null ? null : Integer.valueOf(layoutParams2.getViewLayoutPosition());
                    recyclerView2.getDecoratedBoundsWithMargins(childAt, rect);
                    if (this.f12141h && o(valueOf2)) {
                        if ((valueOf == null ? 0 : valueOf.intValue()) > 1) {
                            int round = rect.top + Math.round(childAt.getTranslationY());
                            int i6 = this.b + round;
                            int i7 = this.f12143j;
                            num = valueOf2;
                            view = childAt;
                            float f2 = i7 == 0 ? i6 : round + i7;
                            i3 = i5;
                            canvas.drawRect(i2, round, width, f2, this.a);
                            RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
                            int g2 = (adapter2 == null && (adapter2 instanceof c)) ? ((c) adapter2).g() : 1;
                            new h();
                            if (!this.f12142i || !t(valueOf, num, Integer.valueOf(g2))) {
                                int round2 = rect.bottom + Math.round(view.getTranslationY());
                                canvas.drawRect(i2, round2 - this.b, width, round2, this.a);
                            }
                        }
                    }
                    num = valueOf2;
                    view = childAt;
                    i3 = i5;
                    RecyclerView.Adapter adapter22 = recyclerView.getAdapter();
                    if (adapter22 == null) {
                    }
                    new h();
                    if (!this.f12142i) {
                    }
                    int round22 = rect.bottom + Math.round(view.getTranslationY());
                    canvas.drawRect(i2, round22 - this.b, width, round22, this.a);
                }
                if (i3 >= childCount) {
                    break;
                }
                recyclerView2 = recyclerView;
                i4 = i3;
            }
        }
        canvas.restore();
    }

    private final void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int i2;
        int height;
        Integer num;
        View view;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i2 = recyclerView.getPaddingTop() + this.f12137d;
            height = (recyclerView.getHeight() - recyclerView.getPaddingBottom()) - this.f12137d;
            canvas.clipRect(recyclerView.getPaddingStart(), i2, recyclerView.getWidth() - recyclerView.getPaddingEnd(), height);
        } else {
            i2 = this.f12137d + 0;
            height = recyclerView.getHeight() - this.f12137d;
        }
        Rect rect = new Rect();
        int childCount = recyclerView.getChildCount();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Integer valueOf = adapter == null ? null : Integer.valueOf(adapter.getItemCount());
        if (childCount > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if ((valueOf == null ? 0 : valueOf.intValue()) >= this.f12136c) {
                    View childAt = recyclerView.getChildAt(i3);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    RecyclerView.LayoutParams layoutParams2 = layoutParams instanceof RecyclerView.LayoutParams ? (RecyclerView.LayoutParams) layoutParams : null;
                    Integer valueOf2 = layoutParams2 == null ? null : Integer.valueOf(layoutParams2.getViewLayoutPosition());
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager != null) {
                        layoutManager.getDecoratedBoundsWithMargins(childAt, rect);
                    }
                    if (this.f12141h && o(valueOf2)) {
                        if ((valueOf == null ? 0 : valueOf.intValue()) > 1) {
                            int round = rect.left + Math.round(childAt.getTranslationX());
                            int i5 = this.b + round;
                            int i6 = this.f12143j;
                            num = valueOf2;
                            view = childAt;
                            canvas.drawRect(round, i2, i5, i6 == 0 ? height : i2 + i6, this.a);
                            if (!this.f12142i || !s(valueOf, num)) {
                                int round2 = rect.right + Math.round(view.getTranslationX());
                                canvas.drawRect(round2 - this.b, i2, round2, height, this.a);
                            }
                        }
                    }
                    num = valueOf2;
                    view = childAt;
                    if (!this.f12142i) {
                    }
                    int round22 = rect.right + Math.round(view.getTranslationX());
                    canvas.drawRect(round22 - this.b, i2, round22, height, this.a);
                }
                if (i4 >= childCount) {
                    break;
                }
                i3 = i4;
            }
        }
        canvas.restore();
    }

    private final boolean o(Integer num) {
        return num != null && num.intValue() == 0;
    }

    private final boolean p(int i2, Integer num) {
        return num != null && num.intValue() % i2 == 0;
    }

    private final boolean q(int i2, Integer num) {
        return (num == null ? 0 : num.intValue()) < i2;
    }

    private final boolean s(Integer num, Integer num2) {
        return f0.g(num2, num == null ? null : Integer.valueOf(num.intValue() - 1));
    }

    private final boolean t(Integer num, Integer num2, Integer num3) {
        int intValue;
        int intValue2 = num2 == null ? 0 : num2.intValue();
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue() - (num3 == null ? 0 : num3.intValue());
        }
        return intValue2 >= intValue;
    }

    private final boolean u(int i2, Integer num) {
        return num != null && (num.intValue() + 1) % i2 == 0;
    }

    private final boolean v(int i2, Integer num, Integer num2) {
        return f0.g(num == null ? null : Integer.valueOf(num.intValue() / i2), num2 != null ? Integer.valueOf((num2.intValue() - 1) / i2) : null);
    }

    public final void A(boolean z) {
        this.f12141h = z;
    }

    public final void B(boolean z) {
        this.f12144k = z;
    }

    public final void C(boolean z) {
        this.f12146m = z;
    }

    public final void D(boolean z) {
        this.f12145l = z;
    }

    public final void E(int i2) {
        this.f12143j = i2;
    }

    public final void F(boolean z) {
        this.f12139f = z;
    }

    public final void G(boolean z) {
        this.f12140g = z;
    }

    public final void H(int i2) {
        this.f12138e = i2;
    }

    public final void I(int i2) {
        this.f12137d = i2;
    }

    public final void J(int i2) {
        this.f12136c = i2;
    }

    public final void K(int i2) {
        this.b = i2;
    }

    public final boolean b() {
        return this.n;
    }

    public final boolean c() {
        return this.f12142i;
    }

    public final boolean d() {
        return this.f12141h;
    }

    public final boolean e() {
        return this.f12144k;
    }

    public final boolean f() {
        return this.f12146m;
    }

    public final boolean g() {
        return this.f12145l;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@d Rect rect, @d View view, @d RecyclerView recyclerView, @d RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        RecyclerView.LayoutParams layoutParams2 = layoutParams instanceof RecyclerView.LayoutParams ? (RecyclerView.LayoutParams) layoutParams : null;
        Integer valueOf = layoutParams2 == null ? null : Integer.valueOf(layoutParams2.getViewLayoutPosition());
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Integer valueOf2 = adapter != null ? Integer.valueOf(adapter.getItemCount()) : null;
        if (!r(recyclerView) && (layoutManager instanceof LinearLayoutManager)) {
            int i2 = 0;
            if (layoutManager instanceof GridLayoutManager) {
                int spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
                int i3 = (this.f12144k && p(spanCount, valueOf)) ? this.b : 0;
                int i4 = (this.f12145l && q(spanCount, valueOf)) ? this.b : 0;
                int i5 = (!u(spanCount, valueOf) || this.f12146m) ? this.b : 0;
                if (!v(spanCount, valueOf, valueOf2) || this.n) {
                    i2 = this.b;
                }
                rect.set(i3, i4, i5, i2);
                return;
            }
            if ((valueOf == null ? 0 : valueOf.intValue()) < this.f12136c) {
                return;
            }
            int i6 = this.f12143j;
            if (i6 == 0) {
                i6 = this.b;
            }
            i6 = (this.f12141h && o(valueOf)) ? 0 : 0;
            int i7 = (!s(valueOf2, valueOf) || this.f12142i) ? this.b : 0;
            if (((LinearLayoutManager) layoutManager).getOrientation() == 1) {
                rect.set(0, i6, 0, i7);
            } else {
                rect.set(i6, 0, i7, 0);
            }
        }
    }

    public final int h() {
        return this.f12143j;
    }

    public final boolean i() {
        return this.f12139f;
    }

    public final boolean j() {
        return this.f12140g;
    }

    public final int k() {
        return this.f12138e;
    }

    public final int l() {
        return this.f12137d;
    }

    public final int m() {
        return this.f12136c;
    }

    public final int n() {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@d Canvas canvas, @d RecyclerView recyclerView, @d RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!r(recyclerView) && (layoutManager instanceof LinearLayoutManager)) {
            if (layoutManager instanceof GridLayoutManager) {
                a(canvas, recyclerView);
            } else if (((LinearLayoutManager) layoutManager).getOrientation() == 1) {
                drawHorizontal(canvas, recyclerView);
            } else {
                drawVertical(canvas, recyclerView);
            }
        }
    }

    public final boolean r(@d RecyclerView recyclerView) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null && (adapter instanceof c)) {
            c cVar = (c) adapter;
            if (recyclerView.getChildCount() == 1 && cVar.k() == 0) {
                return true;
            }
        }
        new h();
        return false;
    }

    public final void w(@ColorInt int i2) {
        this.a.setColor(i2);
    }

    public final void x(@ColorRes int i2) {
        this.a.setColor(Res.k(i2));
    }

    public final void y(boolean z) {
        this.n = z;
    }

    public final void z(boolean z) {
        this.f12142i = z;
    }
}
