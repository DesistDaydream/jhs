package com.vector.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.widget.NestedScrollView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.r.c0;
import h.k2.h;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0012B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0014J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/vector/view/ObservableScrollView;", "Landroidx/core/widget/NestedScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", c0.a.a, "Lcom/vector/view/ObservableScrollView$OnScrollViewListener;", "onScrollChanged", "", NotifyType.LIGHTS, am.aI, "oldl", "oldt", "setOnScrollListener", "OnScrollViewListener", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class ObservableScrollView extends NestedScrollView {
    @e
    private a a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/vector/view/ObservableScrollView$OnScrollViewListener;", "", "onScrollChanged", "", NotifyType.LIGHTS, "", am.aI, "oldl", "oldt", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2, int i3, int i4, int i5);
    }

    @h
    public ObservableScrollView(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public ObservableScrollView(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ObservableScrollView(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a aVar = this.a;
        if (aVar == null) {
            return;
        }
        aVar.a(i2, i3, i4, i5);
    }

    public final void setOnScrollListener(@d a aVar) {
        this.a = aVar;
    }

    @h
    public ObservableScrollView(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
