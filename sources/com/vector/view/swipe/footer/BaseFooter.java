package com.vector.view.swipe.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.LayoutRes;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.vector.ext.view.ViewKt;
import com.vector.view.swipe.ScrollableExtend;
import e.t.l.k;
import e.t.u.p;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0006\u0010\u001c\u001a\u00020\u0011J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0011H\u0016J\u0006\u0010\"\u001a\u00020\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\b8eX¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/vector/view/swipe/footer/BaseFooter;", "Landroid/widget/LinearLayout;", "Lcom/vector/view/swipe/ScrollableExtend;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contentView", "Landroid/view/View;", "contentViewId", "getContentViewId", "()I", "onRetryClick", "Lkotlin/Function1;", "", "getOnRetryClick", "()Lkotlin/jvm/functions/Function1;", "setOnRetryClick", "(Lkotlin/jvm/functions/Function1;)V", "<set-?>", "Lcom/vector/view/swipe/ScrollableExtend$State;", "state", "getState", "()Lcom/vector/view/swipe/ScrollableExtend$State;", "changeState", "hide", "onStateChanged", "setNoMoreText", "text", "", "setViews", TTLogUtil.TAG_EVENT_SHOW, "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseFooter extends LinearLayout implements ScrollableExtend {
    @d
    private final View a;
    @d
    private ScrollableExtend.State b;
    @e

    /* renamed from: c */
    private l<? super View, t1> f8063c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ScrollableExtend.State.values().length];
            iArr[ScrollableExtend.State.IDLE.ordinal()] = 1;
            iArr[ScrollableExtend.State.READY.ordinal()] = 2;
            iArr[ScrollableExtend.State.LOADING.ordinal()] = 3;
            iArr[ScrollableExtend.State.ERROR.ordinal()] = 4;
            iArr[ScrollableExtend.State.FINISH.ordinal()] = 5;
            a = iArr;
        }
    }

    @h
    public BaseFooter(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public BaseFooter(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ BaseFooter(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void e(ScrollableExtend.State state) {
        int i2 = a.a[state.ordinal()];
        if (i2 == 1) {
            b();
        } else if (i2 == 2) {
            onReady();
        } else if (i2 == 3) {
            c();
        } else if (i2 == 4) {
            onError();
        } else if (i2 != 5) {
        } else {
            onFinish();
        }
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void a(@d ScrollableExtend.State state) {
        if (this.b == state) {
            return;
        }
        e(state);
        this.b = state;
    }

    public final void d() {
        ViewKt.n(this.a);
    }

    public void f() {
    }

    public final void g() {
        ViewKt.I(this.a);
    }

    @LayoutRes
    public abstract int getContentViewId();

    @e
    public final l<View, t1> getOnRetryClick() {
        return this.f8063c;
    }

    @d
    public final ScrollableExtend.State getState() {
        return this.b;
    }

    public void setNoMoreText(@d String str) {
    }

    public final void setOnRetryClick(@e l<? super View, t1> lVar) {
        this.f8063c = lVar;
    }

    @h
    public BaseFooter(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View i3 = k.i(context, getContentViewId(), null, false, 6, null);
        this.a = i3;
        this.b = ScrollableExtend.State.IDLE;
        addView(i3, p.l(-1, -2));
        f();
    }
}
