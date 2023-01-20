package com.jihuanshe.viewmodel.shop;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.R;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.Product;
import com.jihuanshe.model.SellCalendar;
import com.vector.util.Res;
import com.xiaomi.mipush.sdk.Constants;
import e.l.h.l.b;
import e.l.n.c.k;
import e.n.f;
import e.t.k.a.c.h.c;
import h.k2.v.f0;
import h.k2.v.u;
import h.t1;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class SellCalendarViewModel extends b {
    @d

    /* renamed from: m  reason: collision with root package name */
    public static final a f4543m = new a(null);
    @d
    private static final String n = "SellCalendarViewModel";
    private static final int o = 0;
    private static final int p = 1;
    private static final int q = 2;
    @d
    private final List<String> b = new ArrayList();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final f<List<Product>> f4544c = new f<>(null, 1, null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private final List<Game> f4545d = new ArrayList();
    @d

    /* renamed from: e  reason: collision with root package name */
    private final f<c> f4546e = new f<>(null, 1, null);

    /* renamed from: f  reason: collision with root package name */
    private final Calendar f4547f;
    @e

    /* renamed from: g  reason: collision with root package name */
    private Product f4548g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final List<Integer> f4549h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final HashSet<String> f4550i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private f<List<Game>> f4551j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private String f4552k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4553l;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public SellCalendarViewModel() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        t1 t1Var = t1.a;
        this.f4547f = calendar;
        this.f4549h = new ArrayList();
        this.f4550i = new HashSet<>();
        this.f4551j = new f<>(null, 1, null);
        this.f4552k = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(Calendar calendar, String str, Product product) {
        if (!this.f4553l && calendar.compareTo(this.f4547f) <= 0) {
            this.f4552k = str;
            this.f4548g = product;
            this.f4553l = calendar.compareTo(this.f4547f) == 0;
        }
    }

    private final String x0() {
        if (this.f4545d.isEmpty()) {
            return null;
        }
        return CollectionsKt___CollectionsKt.Z2(this.f4545d, Constants.ACCEPT_TIME_SEPARATOR_SP, null, null, 0, null, SellCalendarViewModel$getGameIds$1.INSTANCE, 30, null);
    }

    @d
    public final List<Integer> A0() {
        return this.f4549h;
    }

    @d
    public final List<String> B0() {
        return this.b;
    }

    @d
    public final f<c> C0() {
        return this.f4546e;
    }

    @e
    public final Product D0() {
        return this.f4548g;
    }

    public final void F0(@d f<List<Game>> fVar) {
        this.f4551j = fVar;
    }

    public final void G0(@e Product product) {
        this.f4548g = product;
    }

    public final void r0(int i2) {
        String Z2;
        int i3 = i2 / 20;
        Integer num = (Integer) CollectionsKt___CollectionsKt.J2(this.f4549h, i3);
        if (num == null || num.intValue() == 0) {
            int i4 = i3 * 20;
            int i5 = i4 + 20;
            List<Product> value = this.f4544c.getValue();
            if (value == null) {
                Z2 = null;
            } else {
                ArrayList arrayList = new ArrayList();
                int i6 = 0;
                for (Object obj : value) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt__CollectionsKt.W();
                    }
                    Product product = (Product) obj;
                    if (i4 <= i6 && i6 < i5) {
                        arrayList.add(obj);
                    }
                    i6 = i7;
                }
                Z2 = CollectionsKt___CollectionsKt.Z2(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP, null, null, 0, null, SellCalendarViewModel$fetchDetail$ids$2.INSTANCE, 30, null);
            }
            if (Z2 == null) {
                return;
            }
            if (this.f4549h.size() > i3) {
                this.f4549h.set(i3, 1);
            }
            e.g.d.a.h(e.g.d.a.o(e.g.d.a.j(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).n0(Z2)), null, new SellCalendarViewModel$fetchDetail$1(this, i3), 1, null), null, new SellCalendarViewModel$fetchDetail$2(this, i3), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
        }
    }

    @d
    public final e.g.d.a<?> s0() {
        this.f4544c.r(CollectionsKt__CollectionsKt.E());
        this.f4548g = null;
        this.f4549h.clear();
        this.f4552k = "";
        this.f4553l = false;
        final Flow<List<SellCalendar>> C = ((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).C(x0());
        return e.g.d.a.h(e.g.d.a.j(FlowKt.c(new Flow<Pair<? extends List<? extends String>, ? extends List<? extends Product>>>() { // from class: com.jihuanshe.viewmodel.shop.SellCalendarViewModel$fetchMonthData$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.shop.SellCalendarViewModel$fetchMonthData$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<List<? extends SellCalendar>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ SellCalendarViewModel$fetchMonthData$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.shop.SellCalendarViewModel$fetchMonthData$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public Object L$0;
                    public Object L$1;
                    public Object L$2;
                    public Object L$3;
                    public Object L$4;
                    public Object L$5;
                    public Object L$6;
                    public Object L$7;
                    public int label;
                    public /* synthetic */ Object result;

                    public AnonymousClass1(h.e2.c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @e
                    public final Object invokeSuspend(@d Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i.b.v3.f fVar, SellCalendarViewModel$fetchMonthData$$inlined$map$1 sellCalendarViewModel$fetchMonthData$$inlined$map$1) {
                    this.a = fVar;
                    this.b = sellCalendarViewModel$fetchMonthData$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(java.util.List<? extends com.jihuanshe.model.SellCalendar> r23, @k.e.a.d h.e2.c r24) {
                    /*
                        Method dump skipped, instructions count: 530
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.shop.SellCalendarViewModel$fetchMonthData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super Pair<? extends List<? extends String>, ? extends List<? extends Product>>> fVar, @d h.e2.c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), null, new SellCalendarViewModel$fetchMonthData$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @e
    public final Integer t0(int i2) {
        if (f0.g(this.b.get(i2), Res.w(Res.a, R.string.calendar_today, null, 2, null))) {
            List<Product> value = this.f4544c.getValue();
            if (value == null) {
                return null;
            }
            return Integer.valueOf(CollectionsKt___CollectionsKt.Q2(value, this.f4548g));
        }
        List<Product> value2 = this.f4544c.getValue();
        if (value2 == null) {
            return null;
        }
        int i3 = 0;
        Iterator<Product> it = value2.iterator();
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (f0.g(it.next().getGroupMonth(), B0().get(i2))) {
                break;
            } else {
                i3++;
            }
        }
        return Integer.valueOf(i3);
    }

    @d
    public final List<Game> u0() {
        return this.f4545d;
    }

    @d
    public final f<List<Product>> v0() {
        return this.f4544c;
    }

    @d
    public final f<List<Game>> w0() {
        return this.f4551j;
    }

    @d
    public final HashSet<String> y0() {
        return this.f4550i;
    }

    public final boolean z0() {
        return this.f4553l;
    }
}
