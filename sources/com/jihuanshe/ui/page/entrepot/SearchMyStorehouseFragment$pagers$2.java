package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.R;
import com.jihuanshe.ui.BaseFragment;
import com.vector.util.Res;
import e.l.h.l.b;
import e.t.k.a.c.h.c;
import h.k2.u.a;
import h.k2.u.l;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchMyStorehouseFragment$pagers$2 extends Lambda implements a<c> {
    public final /* synthetic */ SearchMyStorehouseFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.entrepot.SearchMyStorehouseFragment$pagers$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<Integer, BaseFragment<? extends b>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        public final BaseFragment<? extends b> invoke(int i2) {
            return SearchChildCheckFragmentCreator.create(SearchChildCheckFragment.B).get();
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ BaseFragment<? extends b> invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* renamed from: com.jihuanshe.ui.page.entrepot.SearchMyStorehouseFragment$pagers$2$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<Integer, BaseFragment<? extends b>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        public final BaseFragment<? extends b> invoke(int i2) {
            return SearchChildNoPassFragmentCreator.create().get();
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ BaseFragment<? extends b> invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* renamed from: com.jihuanshe.ui.page.entrepot.SearchMyStorehouseFragment$pagers$2$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass3 extends Lambda implements l<Integer, SearchChildCheckFragment> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        public final SearchChildCheckFragment invoke(int i2) {
            return SearchChildCheckFragmentCreator.create(SearchChildCheckFragment.C).get();
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ SearchChildCheckFragment invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* renamed from: com.jihuanshe.ui.page.entrepot.SearchMyStorehouseFragment$pagers$2$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass4 extends Lambda implements l<Integer, SearchChildCheckFragment> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        public final SearchChildCheckFragment invoke(int i2) {
            return SearchChildCheckFragmentCreator.create(SearchChildCheckFragment.D).get();
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ SearchChildCheckFragment invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* renamed from: com.jihuanshe.ui.page.entrepot.SearchMyStorehouseFragment$pagers$2$5  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass5 extends Lambda implements l<Integer, SearchSoldFragment> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        public final SearchSoldFragment invoke(int i2) {
            return SearchSoldFragmentCreator.create(1).get();
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ SearchSoldFragment invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* renamed from: com.jihuanshe.ui.page.entrepot.SearchMyStorehouseFragment$pagers$2$6  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass6 extends Lambda implements l<Integer, SearchSoldFragment> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        public AnonymousClass6() {
            super(1);
        }

        public final SearchSoldFragment invoke(int i2) {
            return SearchSoldFragmentCreator.create(0).get();
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ SearchSoldFragment invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchMyStorehouseFragment$pagers$2(SearchMyStorehouseFragment searchMyStorehouseFragment) {
        super(0);
        this.this$0 = searchMyStorehouseFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final c invoke() {
        Integer h0 = this.this$0.h0();
        if (h0 != null && h0.intValue() == 4) {
            List P = CollectionsKt__CollectionsKt.P(AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE);
            Res res = Res.a;
            return e.t.k.a.c.h.d.a(P, CollectionsKt__CollectionsKt.P(Res.w(res, R.string.common_wait, null, 2, null), Res.w(res, R.string.common_no_pass, null, 2, null)));
        } else if (h0 != null && h0.intValue() == 5) {
            List P2 = CollectionsKt__CollectionsKt.P(AnonymousClass3.INSTANCE, AnonymousClass4.INSTANCE);
            Res res2 = Res.a;
            return e.t.k.a.c.h.d.a(P2, CollectionsKt__CollectionsKt.P(Res.w(res2, R.string.common_on_sold, null, 2, null), Res.w(res2, R.string.common_wait_on_sold, null, 2, null)));
        } else if (h0 != null && h0.intValue() == 6) {
            List P3 = CollectionsKt__CollectionsKt.P(AnonymousClass5.INSTANCE, AnonymousClass6.INSTANCE);
            Res res3 = Res.a;
            return e.t.k.a.c.h.d.a(P3, CollectionsKt__CollectionsKt.P(Res.w(res3, R.string.common_on_sold_ed, null, 2, null), Res.w(res3, R.string.common_sold_ing, null, 2, null)));
        } else {
            return e.t.k.a.c.h.d.c(new l[0]);
        }
    }
}
