package com.jihuanshe.ui.page.shop;

import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.page.shop.SellCalendarActivity;
import com.jihuanshe.viewmodel.shop.SellCalendarViewModel;
import com.vector.ext.view.ViewKt;
import com.vector.view.scrollable.ListView;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellCalendarActivity$onFilterGame$1 extends Lambda implements l<List<? extends Game>, t1> {
    public final /* synthetic */ SellCalendarActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.shop.SellCalendarActivity$onFilterGame$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<Object, t1> {
        public final /* synthetic */ SellCalendarActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SellCalendarActivity sellCalendarActivity) {
            super(1);
            this.this$0 = sellCalendarActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Object obj) {
            invoke2(obj);
            return t1.a;
        }

        @Override // h.k2.u.l
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e Object obj) {
            SlideIndicatorView e0;
            ListView g0;
            e0 = this.this$0.e0();
            ViewKt.I(e0);
            g0 = this.this$0.g0();
            final SellCalendarActivity sellCalendarActivity = this.this$0;
            g0.postDelayed(new Runnable() { // from class: e.l.q.b.k.b
                @Override // java.lang.Runnable
                public final void run() {
                    SellCalendarActivity.b0(SellCalendarActivity.this);
                }
            }, 50L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellCalendarActivity$onFilterGame$1(SellCalendarActivity sellCalendarActivity) {
        super(1);
        this.this$0 = sellCalendarActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Game> list) {
        invoke2((List<Game>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d List<Game> list) {
        SlideIndicatorView e0;
        ((SellCalendarViewModel) this.this$0.L()).u0().clear();
        ((SellCalendarViewModel) this.this$0.L()).u0().addAll(list);
        e0 = this.this$0.e0();
        ViewKt.o(e0);
        a.j(((SellCalendarViewModel) this.this$0.L()).s0(), null, new AnonymousClass1(this.this$0), 1, null);
    }
}
