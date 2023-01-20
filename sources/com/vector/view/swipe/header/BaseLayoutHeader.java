package com.vector.view.swipe.header;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.core.view.ViewCompat;
import e.t.l.k;
import h.k2.h;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\u0010\u0010\r\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0012H$R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/vector/view/swipe/header/BaseLayoutHeader;", "Lcom/vector/view/swipe/header/BaseHeader;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contentHeight", "contentViewId", "getContentViewId", "()I", "offset", "getOffset", "setOffset", "(I)V", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "findViews", "initContentView", "Landroid/view/View;", "nativeInit", "setViews", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseLayoutHeader extends BaseHeader {

    /* renamed from: d  reason: collision with root package name */
    private int f8069d;

    /* renamed from: e  reason: collision with root package name */
    private int f8070e;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"com/vector/ext/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "vector_release", "com/vector/ext/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@d View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            view.removeOnLayoutChangeListener(this);
            BaseLayoutHeader baseLayoutHeader = BaseLayoutHeader.this;
            baseLayoutHeader.f8070e = baseLayoutHeader.getContentView().getHeight();
            BaseLayoutHeader baseLayoutHeader2 = BaseLayoutHeader.this;
            baseLayoutHeader2.setOffset(-baseLayoutHeader2.f8070e);
        }
    }

    @h
    public BaseLayoutHeader(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public BaseLayoutHeader(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ BaseLayoutHeader(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void e() {
        m();
        n();
        if (ViewCompat.isLaidOut(this) && !isLayoutRequested()) {
            this.f8070e = getContentView().getHeight();
            setOffset(-this.f8070e);
            return;
        }
        addOnLayoutChangeListener(new a());
    }

    @Override // com.vector.view.swipe.header.BaseHeader
    @d
    public View d() {
        return k.i(getContext(), getContentViewId(), null, false, 6, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@d Canvas canvas) {
        if (getWidth() == 0) {
            return;
        }
        int save = canvas.save();
        canvas.clipRect(0, 0, getWidth(), this.f8070e);
        canvas.translate(0.0f, this.f8069d);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // com.vector.view.swipe.header.BaseHeader
    public void f(int i2) {
        this.f8069d += i2;
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @LayoutRes
    public abstract int getContentViewId();

    public final int getOffset() {
        return this.f8069d;
    }

    public void m() {
    }

    public abstract void n();

    public final void setOffset(int i2) {
        this.f8069d = i2;
    }

    @h
    public BaseLayoutHeader(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e();
    }
}
