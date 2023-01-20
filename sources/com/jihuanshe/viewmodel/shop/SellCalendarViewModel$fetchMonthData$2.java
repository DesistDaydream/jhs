package com.jihuanshe.viewmodel.shop;

import androidx.fragment.app.Fragment;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.page.EmptyFragmentCreator;
import e.n.f;
import e.t.k.a.c.h.c;
import h.a2.u;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class SellCalendarViewModel$fetchMonthData$2 extends Lambda implements l<Pair<? extends List<? extends String>, ? extends List<? extends Product>>, t1> {
    public final /* synthetic */ SellCalendarViewModel this$0;

    /* renamed from: com.jihuanshe.viewmodel.shop.SellCalendarViewModel$fetchMonthData$2$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<Integer, Fragment> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ Fragment invoke(Integer num) {
            return invoke(num.intValue());
        }

        @d
        public final Fragment invoke(int i2) {
            return EmptyFragmentCreator.create().get();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellCalendarViewModel$fetchMonthData$2(SellCalendarViewModel sellCalendarViewModel) {
        super(1);
        this.this$0 = sellCalendarViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Pair<? extends List<? extends String>, ? extends List<? extends Product>> pair) {
        invoke2((Pair<? extends List<String>, ? extends List<Product>>) pair);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Pair<? extends List<String>, ? extends List<Product>> pair) {
        this.this$0.B0().clear();
        List<String> B0 = this.this$0.B0();
        List<String> first = pair == null ? null : pair.getFirst();
        if (first == null) {
            first = CollectionsKt__CollectionsKt.E();
        }
        B0.addAll(first);
        f<c> C0 = this.this$0.C0();
        int size = this.this$0.B0().size();
        List<String> B02 = this.this$0.B0();
        ArrayList arrayList = new ArrayList(u.Y(B02, 10));
        for (String str : B02) {
            if (StringsKt__StringsKt.V2(str, "年", false, 2, null)) {
                str = (String) StringsKt__StringsKt.S4(str, new String[]{"年"}, false, 0, 6, null).get(1);
            }
            arrayList.add(str);
        }
        C0.r(e.t.k.a.c.h.d.i(size, arrayList, null, AnonymousClass2.INSTANCE, 4, null));
        this.this$0.v0().r(pair != null ? pair.getSecond() : null);
    }
}
