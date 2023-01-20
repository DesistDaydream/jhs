package e.l.q.c.r0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.R;
import com.vector.util.Res;
import e.t.o.d;
import h.k2.v.f0;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class a extends RecyclerView.ItemDecoration {
    @d
    private final InterfaceC0395a a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14201c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final Paint f14202d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14203e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14204f;

    /* renamed from: g  reason: collision with root package name */
    private final int f14205g;
    @e

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f14206h;
    @e

    /* renamed from: i  reason: collision with root package name */
    private final Drawable f14207i;

    /* renamed from: e.l.q.c.r0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0395a {
        @d
        String a(int i2);

        int c(int i2);

        boolean e(int i2);

        boolean h(int i2);

        @d
        String k(int i2);
    }

    public a(@d InterfaceC0395a interfaceC0395a) {
        this.a = interfaceC0395a;
        d.a aVar = e.t.o.d.a;
        this.b = d.a.c(aVar, null, 1, null).d(30);
        this.f14201c = d.a.c(aVar, null, 1, null).d(1);
        Paint paint = new Paint();
        this.f14202d = paint;
        this.f14203e = -1;
        this.f14204f = Res.k(R.color.black_b5b5b7);
        this.f14205g = Res.k(R.color.common_color);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(d.a.c(aVar, null, 1, null).d(1));
        paint.setFakeBoldText(true);
        paint.setTextSize(TypedValue.applyDimension(2, 12.0f, e.t.a.b().getResources().getDisplayMetrics()));
        Res res = Res.a;
        this.f14206h = Res.q(res, R.drawable.ic_today, null, 2, null);
        this.f14207i = Res.q(res, R.drawable.ic_today_up, null, 2, null);
    }

    private final void a(RecyclerView recyclerView, View view, Canvas canvas, int i2) {
        this.f14202d.setColor(this.f14203e);
        canvas.drawRect(recyclerView.getPaddingStart(), (view.getTop() - this.b) - this.f14201c, recyclerView.getWidth() - recyclerView.getPaddingEnd(), view.getTop() - this.f14201c, this.f14202d);
        this.f14202d.setColor(this.f14204f);
        String k2 = this.a.k(i2);
        int paddingStart = recyclerView.getPaddingStart();
        d.a aVar = e.t.o.d.a;
        canvas.drawText(k2, paddingStart + d.a.c(aVar, null, 1, null).c(12.0f), view.getTop() - d.a.c(aVar, null, 1, null).d(11), this.f14202d);
    }

    private final void b(RecyclerView recyclerView, Canvas canvas, int i2, float f2) {
        this.f14202d.setColor(this.f14203e);
        canvas.drawRect(recyclerView.getPaddingStart(), 0.0f, recyclerView.getWidth() - recyclerView.getPaddingEnd(), f2, this.f14202d);
        this.f14202d.setColor(this.f14204f);
        String k2 = this.a.k(i2);
        int paddingStart = recyclerView.getPaddingStart();
        d.a aVar = e.t.o.d.a;
        canvas.drawText(k2, paddingStart + d.a.c(aVar, null, 1, null).c(12.0f), f2 - d.a.c(aVar, null, 1, null).d(11), this.f14202d);
    }

    private final void c(RecyclerView recyclerView, View view, Canvas canvas, int i2) {
        if (i2 == 1) {
            this.f14202d.setColor(this.f14205g);
            Drawable drawable = this.f14207i;
            int paddingStart = recyclerView.getPaddingStart();
            d.a aVar = e.t.o.d.a;
            drawable.setBounds(paddingStart + d.a.c(aVar, null, 1, null).d(12), view.getBottom() - d.a.c(aVar, null, 1, null).d(15), recyclerView.getPaddingStart() + d.a.c(aVar, null, 1, null).d(38), view.getBottom());
            this.f14207i.draw(canvas);
            canvas.drawLine(recyclerView.getPaddingStart(), view.getBottom(), recyclerView.getWidth() - recyclerView.getPaddingEnd(), view.getBottom(), this.f14202d);
        } else if (i2 != 2) {
        } else {
            this.f14202d.setColor(this.f14205g);
            Drawable drawable2 = this.f14206h;
            int paddingStart2 = recyclerView.getPaddingStart();
            d.a aVar2 = e.t.o.d.a;
            drawable2.setBounds(paddingStart2 + d.a.c(aVar2, null, 1, null).d(12), view.getTop(), recyclerView.getPaddingStart() + d.a.c(aVar2, null, 1, null).d(38), view.getTop() + d.a.c(aVar2, null, 1, null).d(15));
            this.f14206h.draw(canvas);
            canvas.drawLine(recyclerView.getPaddingStart(), view.getTop(), recyclerView.getWidth() - recyclerView.getPaddingEnd(), view.getTop(), this.f14202d);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@k.e.a.d Rect rect, @k.e.a.d View view, @k.e.a.d RecyclerView recyclerView, @k.e.a.d RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (this.a.e(childAdapterPosition)) {
            rect.set(0, this.b + (this.f14201c * 2), 0, 0);
        } else {
            rect.set(0, this.a.h(childAdapterPosition) ? this.f14201c : 0, 0, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@k.e.a.d Canvas canvas, @k.e.a.d RecyclerView recyclerView, @k.e.a.d RecyclerView.State state) {
        int childCount = recyclerView.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            View childAt = recyclerView.getChildAt(i2);
            if (childAt != null) {
                int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                if (this.a.e(childAdapterPosition)) {
                    a(recyclerView, childAt, canvas, childAdapterPosition);
                }
            }
            if (i3 >= childCount) {
                return;
            }
            i2 = i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@k.e.a.d Canvas canvas, @k.e.a.d RecyclerView recyclerView, @k.e.a.d RecyclerView.State state) {
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                View childAt = recyclerView.getChildAt(i2);
                if (childAt != null) {
                    c(recyclerView, childAt, canvas, this.a.c(recyclerView.getChildAdapterPosition(childAt)));
                }
                if (i3 >= childCount) {
                    break;
                }
                i2 = i3;
            }
        }
        if (recyclerView.getChildCount() > 1) {
            View childAt2 = recyclerView.getChildAt(0);
            View childAt3 = recyclerView.getChildAt(1);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt2);
            int childAdapterPosition2 = recyclerView.getChildAdapterPosition(childAt3);
            String a = this.a.a(childAdapterPosition);
            String a2 = this.a.a(childAdapterPosition2);
            int i4 = this.b + this.f14201c;
            if (!f0.g(a, a2) && i4 > childAt2.getBottom()) {
                i4 = childAt2.getBottom();
            }
            b(recyclerView, canvas, childAdapterPosition, i4);
        }
    }
}
