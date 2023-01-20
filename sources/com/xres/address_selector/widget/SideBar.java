package com.xres.address_selector.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.xres.address_selector.widget.SideBar;
import e.u.a.f.a;
import e.u.a.g.b;
import e.u.a.g.c;
import h.k2.h;
import h.k2.v.u;
import h.o2.q;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0014J\u0018\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014J(\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0014J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u001a\u00105\u001a\u00020&2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000707R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0010j\b\u0012\u0004\u0012\u00020\r`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/xres/address_selector/widget/SideBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "baseLine", "", "capIndexMap", "", "", "charHeight", "characters", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getMLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setMLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "mSlideListener", "Lcom/xres/address_selector/widget/OnSlideListener;", "getMSlideListener", "()Lcom/xres/address_selector/widget/OnSlideListener;", "setMSlideListener", "(Lcom/xres/address_selector/widget/OnSlideListener;)V", "paddingV", "paint", "Landroid/graphics/Paint;", "roundBackground", "Landroid/graphics/drawable/GradientDrawable;", "selectedIndex", "textPaint", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", IAdInterListener.AdReqParam.WIDTH, "h", "oldw", "oldh", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setRawList", "map", "", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SideBar extends View {
    @d
    private final ArrayList<String> a;
    @d
    private final Map<String, Integer> b;

    /* renamed from: c */
    private int f9238c;
    @e

    /* renamed from: d */
    private LinearLayoutManager f9239d;

    /* renamed from: e */
    public b f9240e;

    /* renamed from: f */
    private final int f9241f;

    /* renamed from: g */
    private final int f9242g;
    @d

    /* renamed from: h */
    private final GradientDrawable f9243h;
    @d

    /* renamed from: i */
    private final Paint f9244i;
    @d

    /* renamed from: j */
    private final Paint f9245j;

    /* renamed from: k */
    private float f9246k;

    @h
    public SideBar(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public SideBar(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ SideBar(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static final void b(SideBar sideBar, int i2, boolean z) {
        Integer num = sideBar.b.get(sideBar.a.get(i2));
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        LinearLayoutManager mLayoutManager = sideBar.getMLayoutManager();
        if (mLayoutManager == null) {
            return;
        }
        mLayoutManager.scrollToPositionWithOffset(intValue, 0);
    }

    @e
    public final LinearLayoutManager getMLayoutManager() {
        return this.f9239d;
    }

    @d
    public final b getMSlideListener() {
        b bVar = this.f9240e;
        Objects.requireNonNull(bVar);
        return bVar;
    }

    @Override // android.view.View
    public void onDraw(@d Canvas canvas) {
        super.onDraw(canvas);
        this.f9243h.draw(canvas);
        float f2 = this.f9242g + (this.f9241f / 2.0f);
        int i2 = 0;
        for (Object obj : this.a) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            String str = (String) obj;
            if (this.f9238c == i2) {
                this.f9244i.setColor(-1);
                canvas.drawCircle(getWidth() / 2.0f, f2, a.f(7.0f), this.f9245j);
            } else {
                this.f9244i.setColor(Color.parseColor("#333333"));
            }
            canvas.drawText(str, getWidth() / 2.0f, this.f9246k + f2, this.f9244i);
            f2 += this.f9241f;
            i2 = i3;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int size;
        int i5;
        super.onMeasure(i2, i3);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int i6 = 0;
        if (mode != Integer.MIN_VALUE) {
            i4 = mode != 1073741824 ? 0 : q.n(size2, this.f9241f);
        } else {
            i4 = this.f9241f;
        }
        int size3 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size = this.a.size();
            i5 = this.f9241f;
        } else {
            if (mode2 == 1073741824) {
                size = this.a.size();
                i5 = q.u(this.f9241f, size3);
            }
            setMeasuredDimension(i4, i6 + (this.f9242g * 2));
        }
        i6 = size * i5;
        setMeasuredDimension(i4, i6 + (this.f9242g * 2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int i6 = this.f9242g;
        setPadding(0, i6, 0, i6);
        GradientDrawable gradientDrawable = this.f9243h;
        gradientDrawable.setColor(a.d(c.a));
        gradientDrawable.setBounds(0, 0, i2, i3);
        gradientDrawable.setCornerRadius(a.f(16.0f));
        Paint paint = this.f9245j;
        paint.setColor(Color.parseColor("#ffcc00"));
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = this.f9244i;
        paint2.setAntiAlias(true);
        paint2.setTextSize(a.f(10.0f));
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        float f2 = fontMetrics.bottom;
        this.f9246k = ((f2 - fontMetrics.top) / 2) - f2;
        setMSlideListener(new b() { // from class: e.u.a.g.a
            {
                SideBar.this = this;
            }

            @Override // e.u.a.g.b
            public final void a(int i7, boolean z) {
                SideBar.b(SideBar.this, i7, z);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0030, code lost:
        if (r5 != 2) goto L12;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@k.e.a.d android.view.MotionEvent r5) {
        /*
            r4 = this;
            float r0 = r5.getY()
            int r1 = r4.f9242g
            float r1 = (float) r1
            float r0 = r0 - r1
            int r1 = r4.f9241f
            float r1 = (float) r1
            float r0 = r0 / r1
            double r0 = (double) r0
            double r0 = java.lang.Math.ceil(r0)
            float r0 = (float) r0
            int r0 = (int) r0
            r1 = 1
            int r0 = r0 - r1
            r2 = 0
            if (r0 < 0) goto L22
            java.util.ArrayList<java.lang.String> r3 = r4.a
            int r3 = kotlin.collections.CollectionsKt__CollectionsKt.G(r3)
            if (r0 > r3) goto L22
            r3 = 1
            goto L23
        L22:
            r3 = 0
        L23:
            if (r3 == 0) goto L45
            r4.f9238c = r0
            int r5 = r5.getAction()
            if (r5 == 0) goto L3b
            if (r5 == r1) goto L33
            r3 = 2
            if (r5 == r3) goto L3b
            goto L42
        L33:
            e.u.a.g.b r5 = r4.getMSlideListener()
            r5.a(r0, r1)
            goto L42
        L3b:
            e.u.a.g.b r5 = r4.getMSlideListener()
            r5.a(r0, r2)
        L42:
            r4.invalidate()
        L45:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xres.address_selector.widget.SideBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setMLayoutManager(@e LinearLayoutManager linearLayoutManager) {
        this.f9239d = linearLayoutManager;
    }

    public final void setMSlideListener(@d b bVar) {
        this.f9240e = bVar;
    }

    public final void setRawList(@d Map<String, Integer> map) {
        ArrayList<String> arrayList = this.a;
        arrayList.clear();
        arrayList.addAll(map.keySet());
        Map<String, Integer> map2 = this.b;
        map2.clear();
        map2.putAll(map);
        requestLayout();
    }

    @h
    public SideBar(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new ArrayList<>();
        this.b = new LinkedHashMap();
        this.f9238c = -1;
        this.f9241f = a.f(20.0f);
        this.f9242g = a.f(8.0f);
        this.f9243h = new GradientDrawable();
        this.f9244i = new Paint();
        this.f9245j = new Paint();
    }
}
