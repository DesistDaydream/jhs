package e.u.a.g.d;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import h.t1;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/xres/address_selector/widget/address_selector/MyDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "capMap", "", "", "", "(Ljava/util/Map;)V", "floatText", "mBounds", "Landroid/graphics/Rect;", "paint", "Landroid/graphics/Paint;", "textPaint", "getCapByPosition", "firstVisible", "getCapByPositionLast", "getItemOffsets", "", "outRect", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "onDrawOver", "Companion", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class z extends RecyclerView.ItemDecoration {
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final a f14732f = new a(null);

    /* renamed from: g  reason: collision with root package name */
    private static final int f14733g = e.u.a.f.a.f(40.0f);

    /* renamed from: h  reason: collision with root package name */
    private static final int f14734h = e.u.a.f.a.f(40.0f);

    /* renamed from: i  reason: collision with root package name */
    private static final int f14735i = e.u.a.f.a.f(0.67f);

    /* renamed from: j  reason: collision with root package name */
    private static final int f14736j = e.u.a.f.a.f(24.0f);
    @k.e.a.d

    /* renamed from: k  reason: collision with root package name */
    private static final String f14737k = "#ffffff";
    @k.e.a.d

    /* renamed from: l  reason: collision with root package name */
    private static final String f14738l = "#B5B5B7";
    @k.e.a.d
    private final Map<String, Integer> a;
    @k.e.a.d
    private final Rect b = new Rect();
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private String f14739c = "";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final Paint f14740d;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final Paint f14741e;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/xres/address_selector/widget/address_selector/MyDecoration$Companion;", "", "()V", "BOTTOM_LINE_HEIGHT", "", "CAP_BG_COLOR", "", "CAP_HEIGHT", "CAP_TEXT_POSITION", "PADDING", "TEXT_COLOR", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public z(@k.e.a.d Map<String, Integer> map) {
        this.a = map;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(e.u.a.f.a.d("#ffffff"));
        t1 t1Var = t1.a;
        this.f14740d = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(e.u.a.f.a.d(f14738l));
        paint2.setTextSize(e.u.a.f.a.f(12.0f));
        this.f14741e = paint2;
    }

    private final String a(int i2) {
        Map<String, Integer> map = this.a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return (String) CollectionsKt___CollectionsKt.r2(linkedHashMap.keySet());
    }

    private final String b(int i2) {
        Map<String, Integer> map = this.a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() <= i2) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        String str = (String) CollectionsKt___CollectionsKt.g3(linkedHashMap.keySet());
        return str == null ? "" : str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@k.e.a.d Rect rect, @k.e.a.d View view, @k.e.a.d RecyclerView recyclerView, @k.e.a.d RecyclerView.State state) {
        if (this.a.containsValue(Integer.valueOf(recyclerView.getChildLayoutPosition(view)))) {
            rect.top = f14734h;
        }
        rect.bottom = f14735i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@k.e.a.d Canvas canvas, @k.e.a.d RecyclerView recyclerView, @k.e.a.d RecyclerView.State state) {
        canvas.save();
        for (View view : ViewGroupKt.getChildren(recyclerView)) {
            recyclerView.getDecoratedBoundsWithMargins(view, this.b);
            Rect rect = this.b;
            int i2 = rect.left;
            int i3 = f14733g;
            int i4 = rect.bottom;
            canvas.drawRect(new Rect(i2 + i3, i4, rect.right - i3, f14735i + i4), this.f14740d);
            String a2 = a(recyclerView.getChildLayoutPosition(view));
            if (a2 != null) {
                Rect rect2 = this.b;
                int i5 = rect2.left;
                int i6 = rect2.top;
                Rect rect3 = new Rect(i5, i6, rect2.right, f14734h + i6);
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setAntiAlias(true);
                paint.setStrokeWidth(1.0f);
                paint.setColor(Color.parseColor("#f2f2f2"));
                paint.setPathEffect(new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f));
                float f2 = rect3.left + i3;
                int i7 = rect3.top;
                canvas.drawLine(f2, i7, rect3.right - i3, i7, paint);
                canvas.drawRect(rect3, this.f14740d);
                Rect rect4 = this.b;
                canvas.drawText(a2, rect4.left + i3, rect4.top + f14736j + 30, this.f14741e);
            }
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@k.e.a.d Canvas canvas, @k.e.a.d RecyclerView recyclerView, @k.e.a.d RecyclerView.State state) {
        View view;
        canvas.save();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager2).findFirstCompletelyVisibleItemPosition();
        this.f14739c = b(findFirstVisibleItemPosition);
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(findFirstCompletelyVisibleItemPosition);
        if (findViewHolderForAdapterPosition != null && (view = findViewHolderForAdapterPosition.itemView) != null) {
            Rect rect = new Rect();
            recyclerView.getDecoratedBoundsWithMargins(view, rect);
            int min = !this.a.containsValue(Integer.valueOf(findFirstCompletelyVisibleItemPosition)) ? f14734h : Math.min(rect.top, f14734h);
            int i2 = f14734h;
            canvas.drawRect(new Rect(0, min - i2, recyclerView.getWidth(), min), this.f14740d);
            canvas.drawText(this.f14739c, f14733g, (min - i2) + f14736j, this.f14741e);
        }
        canvas.restore();
    }
}
