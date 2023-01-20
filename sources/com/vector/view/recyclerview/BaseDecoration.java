package com.vector.view.recyclerview;

import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.RecyclerView;
import e.t.k.a.c.c;
import e.t.l.h;
import e.t.v.i.e.a;
import h.t1;
import h.w;
import h.z;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u001e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u001a\u0010\u001c\u001a\u00020\u001dX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0011¨\u0006$"}, d2 = {"Lcom/vector/view/recyclerview/BaseDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "config", "Lcom/vector/view/recyclerview/config/DecorationConfig;", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/vector/view/recyclerview/config/DecorationConfig;)V", "bounds", "Landroid/graphics/Rect;", "getBounds", "()Landroid/graphics/Rect;", "bounds$delegate", "Lkotlin/Lazy;", "value", "", "color", "getColor", "()I", "setColor", "(I)V", "itemCount", "getItemCount", "setItemCount", "<set-?>", "offsetFoot", "getOffsetFoot", "offsetHead", "getOffsetHead", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "width", "getWidth", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseDecoration extends RecyclerView.ItemDecoration {
    @d
    private final w a = z.c(BaseDecoration$bounds$2.INSTANCE);
    @d
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private int f8018c;
    @ColorInt

    /* renamed from: d  reason: collision with root package name */
    private int f8019d;

    /* renamed from: e  reason: collision with root package name */
    private int f8020e;

    /* renamed from: f  reason: collision with root package name */
    private int f8021f;

    /* renamed from: g  reason: collision with root package name */
    private int f8022g;

    public BaseDecoration(@d RecyclerView recyclerView, @e a aVar) {
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        t1 t1Var = t1.a;
        this.b = paint;
        this.f8019d = -7829368;
        this.f8020e = 1;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            i(adapter.getItemCount());
        }
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        if (adapter2 != null && (adapter2 instanceof c)) {
            c cVar = (c) adapter2;
            this.f8021f = cVar.h();
            this.f8022g = cVar.g();
        }
        new h();
        if (aVar == null) {
            return;
        }
        h(aVar.a());
        this.f8020e = aVar.e();
        this.f8021f = aVar.c();
        this.f8022g = aVar.b();
    }

    private final void h(int i2) {
        this.f8019d = i2;
        this.b.setColor(i2);
    }

    @d
    public final Rect a() {
        return (Rect) this.a.getValue();
    }

    public final int b() {
        return this.f8019d;
    }

    public final int c() {
        return this.f8018c;
    }

    public final int d() {
        return this.f8022g;
    }

    public final int e() {
        return this.f8021f;
    }

    @d
    public final Paint f() {
        return this.b;
    }

    public final int g() {
        return this.f8020e;
    }

    public final void i(int i2) {
        this.f8018c = i2;
    }

    public final void j(@d Paint paint) {
        this.b = paint;
    }
}
