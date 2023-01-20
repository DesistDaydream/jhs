package com.vector.view.swipe.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.qiniu.android.collect.ReportItem;
import com.vector.view.swipe.ScrollableExtend;
import e.t.o.c;
import e.t.u.p;
import h.k2.h;
import h.k2.v.u;
import h.t1;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u000bH$J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\bH&J\u0018\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J\u0016\u0010#\u001a\u00020\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0%H\u0016J\u0016\u0010&\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!R\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/vector/view/swipe/header/BaseHeader;", "Landroid/widget/LinearLayout;", "Lcom/vector/view/swipe/ScrollableExtend;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "<set-?>", "Lcom/vector/view/swipe/ScrollableExtend$State;", "lastState", "getLastState", "()Lcom/vector/view/swipe/ScrollableExtend$State;", "", "percent", "getPercent", "()F", "changeState", "", "state", "initContentView", "nativeInit", "offset", "onPercentChanged", "invalidate", "", "onStateChanged", "onStopRefresh", ReportItem.LogTypeBlock, "Lkotlin/Function0;", "setPercent", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseHeader extends LinearLayout implements ScrollableExtend {
    private float a;
    public View b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private ScrollableExtend.State f8068c;

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
    public BaseHeader(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public BaseHeader(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ BaseHeader(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void e() {
        setContentView(d());
        c a2 = e.t.o.d.a.a(getContext());
        Integer e2 = e.t.a.c().e();
        addView(getContentView(), p.l(-1, a2.c((e2 == null ? 60 : e2.intValue()) * 1.3f)));
    }

    private final void h(ScrollableExtend.State state) {
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
        if (this.f8068c == state) {
            return;
        }
        h(state);
        this.f8068c = state;
    }

    @d
    public abstract View d();

    public abstract void f(int i2);

    public void g(float f2, boolean z) {
    }

    @d
    public final View getContentView() {
        View view = this.b;
        Objects.requireNonNull(view);
        return view;
    }

    @d
    public final ScrollableExtend.State getLastState() {
        return this.f8068c;
    }

    public final float getPercent() {
        return this.a;
    }

    public void i(@d h.k2.u.a<t1> aVar) {
        aVar.invoke();
    }

    public final void j(float f2, boolean z) {
        this.a = f2;
        g(f2, z);
    }

    public final void setContentView(@d View view) {
        this.b = view;
    }

    @h
    public BaseHeader(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8068c = ScrollableExtend.State.IDLE;
        e();
    }
}
