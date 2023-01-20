package com.jihuanshe.ui.widget;

import com.vector.view.pager.ViewPager;
import h.k2.u.l;
import h.k2.u.q;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RankIndicatorView$viewPager$2 extends Lambda implements l<ViewPager.b, t1> {
    public final /* synthetic */ RankIndicatorView this$0;

    /* renamed from: com.jihuanshe.ui.widget.RankIndicatorView$viewPager$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<Integer, t1> {
        public final /* synthetic */ RankIndicatorView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(RankIndicatorView rankIndicatorView) {
            super(1);
            this.this$0 = rankIndicatorView;
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

    /* renamed from: com.jihuanshe.ui.widget.RankIndicatorView$viewPager$2$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements q<Integer, Float, Integer, t1> {
        public final /* synthetic */ RankIndicatorView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(RankIndicatorView rankIndicatorView) {
            super(3);
            this.this$0 = rankIndicatorView;
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

    /* renamed from: com.jihuanshe.ui.widget.RankIndicatorView$viewPager$2$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass3 extends Lambda implements l<Integer, t1> {
        public final /* synthetic */ RankIndicatorView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(RankIndicatorView rankIndicatorView) {
            super(1);
            this.this$0 = rankIndicatorView;
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
    public RankIndicatorView$viewPager$2(RankIndicatorView rankIndicatorView) {
        super(1);
        this.this$0 = rankIndicatorView;
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
