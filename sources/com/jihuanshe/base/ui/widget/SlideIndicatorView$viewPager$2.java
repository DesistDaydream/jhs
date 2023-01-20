package com.jihuanshe.base.ui.widget;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.vector.view.pager.ViewPager;
import h.k2.u.l;
import h.k2.u.q;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00060\u0002R\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/vector/view/pager/ViewPager$OnPageChangeListenerBuilder;", "Lcom/vector/view/pager/ViewPager;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class SlideIndicatorView$viewPager$2 extends Lambda implements l<ViewPager.b, t1> {
    public final /* synthetic */ SlideIndicatorView this$0;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.jihuanshe.base.ui.widget.SlideIndicatorView$viewPager$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<Integer, t1> {
        public final /* synthetic */ SlideIndicatorView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SlideIndicatorView slideIndicatorView) {
            super(1);
            this.this$0 = slideIndicatorView;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
            invoke(num.intValue());
            return t1.a;
        }

        public final void invoke(int i2) {
            this.this$0.a(i2);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "position", "", "positionOffset", "", "positionOffsetPixels"}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.jihuanshe.base.ui.widget.SlideIndicatorView$viewPager$2$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements q<Integer, Float, Integer, t1> {
        public final /* synthetic */ SlideIndicatorView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SlideIndicatorView slideIndicatorView) {
            super(3);
            this.this$0 = slideIndicatorView;
        }

        @Override // h.k2.u.q
        public /* bridge */ /* synthetic */ t1 invoke(Integer num, Float f2, Integer num2) {
            invoke(num.intValue(), f2.floatValue(), num2.intValue());
            return t1.a;
        }

        public final void invoke(int i2, float f2, int i3) {
            this.this$0.b(i2, f2, i3);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.jihuanshe.base.ui.widget.SlideIndicatorView$viewPager$2$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass3 extends Lambda implements l<Integer, t1> {
        public final /* synthetic */ SlideIndicatorView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(SlideIndicatorView slideIndicatorView) {
            super(1);
            this.this$0 = slideIndicatorView;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
            invoke(num.intValue());
            return t1.a;
        }

        public final void invoke(int i2) {
            this.this$0.c(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlideIndicatorView$viewPager$2(SlideIndicatorView slideIndicatorView) {
        super(1);
        this.this$0 = slideIndicatorView;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ViewPager.b bVar) {
        invoke2(bVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d ViewPager.b bVar) {
        bVar.e(new AnonymousClass1(this.this$0));
        bVar.f(new AnonymousClass2(this.this$0));
        bVar.g(new AnonymousClass3(this.this$0));
    }
}
