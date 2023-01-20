package com.jihuanshe.viewmodel;

import android.view.View;
import android.widget.TextView;
import com.jihuanshe.R;
import com.jihuanshe.adapter.RarityAdapter;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Rarity;
import com.vector.util.LayoutManagers;
import com.vector.util.Res;
import e.l.g.w0;
import e.l.l.b;
import e.l.s.c;
import e.n.f;
import e.n.i;
import e.n.l;
import e.n.p;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.h;
import e.t.k.a.c.a;
import h.k2.v.f0;
import h.r0;
import h.t1;
import h.w;
import h.z;
import java.util.List;
import k.e.a.d;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public class FilterBarImpl implements c {
    @d
    private l a = new l(0);
    @d
    private List<Pair<String, String>> b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final f<Pair<String, String>> f4352c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final f<Pair<String, String>> f4353d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final f<Pair<String, String>> f4354e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final f<Pair<String, String>> f4355f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final f<Pair<String, String>> f4356g;

    /* renamed from: h  reason: collision with root package name */
    private int f4357h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final i f4358i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final f<List<Rarity>> f4359j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final f<List<Pair<String, String>>> f4360k;
    @d

    /* renamed from: l  reason: collision with root package name */
    private final p f4361l;
    @d

    /* renamed from: m  reason: collision with root package name */
    private final i f4362m;
    @d
    private final i n;
    @d
    private final i o;
    @d
    private final w p;
    @d
    private final w q;
    @d
    private final l r;
    @d
    private final w s;
    @d
    private final i t;
    @d
    private final p u;
    @d
    private final h.k2.u.l<List<Rarity>, t1> v;

    /* renamed from: com.jihuanshe.viewmodel.FilterBarImpl$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements h.k2.u.l<Pair<? extends String, ? extends String>, t1> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Pair<? extends String, ? extends String> pair) {
            invoke2((Pair<String, String>) pair);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d Pair<String, String> pair) {
            i iVar = FilterBarImpl.this.o;
            String second = pair.getSecond();
            iVar.setValue(Boolean.valueOf(!(second == null || second.length() == 0)));
        }
    }

    /* renamed from: com.jihuanshe.viewmodel.FilterBarImpl$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements h.k2.u.l<Integer, t1> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
            invoke(num.intValue());
            return t1.a;
        }

        public final void invoke(int i2) {
            List<Pair<String, String>> sorting_seller;
            FilterBarImpl filterBarImpl = FilterBarImpl.this;
            if (i2 != 0) {
                sorting_seller = Constants.Companion.getSORTING_NEWEST();
            } else {
                sorting_seller = Constants.Companion.getSORTING_SELLER();
            }
            filterBarImpl.b = sorting_seller;
            FilterBarImpl.this.f4360k.r(FilterBarImpl.this.b);
            FilterBarImpl.this.f4353d.r(FilterBarImpl.this.b.get(0));
            FilterBarImpl filterBarImpl2 = FilterBarImpl.this;
            filterBarImpl2.U(filterBarImpl2.f4353d, FilterBarImpl.this.f4361l);
            FilterBarImpl.this.o.setValue(Boolean.FALSE);
            FilterBarImpl.this.f4355f.r(new Pair(Res.w(Res.a, R.string.shop_all_rarity, null, 2, null), ""));
        }
    }

    public FilterBarImpl() {
        Constants.Companion companion = Constants.Companion;
        this.b = companion.getSORTING_NEWEST();
        this.f4352c = new f<>(companion.getPRICE_TYPE().get(0));
        this.f4353d = new f<>(this.b.get(0));
        this.f4354e = new f<>(this.b.get(0));
        Res res = Res.a;
        this.f4355f = new f<>(new Pair(Res.w(res, R.string.shop_all_rarity, null, 2, null), ""));
        f<Pair<String, String>> fVar = new f<>(new Pair(Res.w(res, R.string.shop_all_rarity, null, 2, null), ""));
        this.f4356g = fVar;
        this.f4357h = companion.getTYPE_NEWEST();
        Boolean bool = Boolean.FALSE;
        this.f4358i = new i(bool);
        this.f4359j = new f<>(null, 1, null);
        this.f4360k = new f<>(this.b);
        this.f4361l = new p("最新发布");
        this.f4362m = new i(bool);
        this.n = new i(bool);
        this.o = new i(bool);
        this.p = z.c(new FilterBarImpl$adapter$2(this));
        this.q = z.c(FilterBarImpl$sortAdapter$2.INSTANCE);
        f.g(fVar, null, new AnonymousClass1(), 1, null);
        f.g(this.a, null, new AnonymousClass2(), 1, null);
        this.r = new l(0);
        this.s = z.c(FilterBarImpl$innerLayoutManager$2.INSTANCE);
        this.t = new i(bool);
        this.u = new p(null, 1, null);
        this.v = new FilterBarImpl$filterRarity$1(this);
    }

    private final RarityAdapter K() {
        return (RarityAdapter) this.p.getValue();
    }

    private final LayoutManagers.a R() {
        return (LayoutManagers.a) this.s.getValue();
    }

    private final w0 T() {
        return (w0) this.q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(f<Pair<String, String>> fVar, p pVar) {
        Pair<String, String> value = fVar.getValue();
        String first = value == null ? null : value.getFirst();
        if (first == null) {
            return;
        }
        try {
            Result.a aVar = Result.Companion;
            if (f0.g(first, "匹配优先（任意版本）")) {
                first = "匹配优先";
            }
            pVar.setValue(first);
            Result.m106constructorimpl(t1.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
        }
    }

    @Override // e.l.s.c
    @d
    public a<Pair<String, String>> A() {
        return T();
    }

    @Override // e.l.s.c
    public boolean B() {
        return false;
    }

    @Override // e.l.s.c
    @d
    public f<Pair<String, String>> C() {
        return this.f4356g;
    }

    @Override // e.l.s.c
    @d
    public g F(@d View view) {
        return e.t.j.h.d.a.a(new FilterBarImpl$onClickSearch$1(this));
    }

    @Override // e.l.s.c
    @d
    public f<List<Pair<String, String>>> G() {
        return this.f4360k;
    }

    @Override // e.l.s.c
    @d
    public i I() {
        return this.f4358i;
    }

    @Override // e.l.s.c
    @d
    public f<Pair<String, String>> L() {
        return this.f4353d;
    }

    @Override // e.l.s.c
    @d
    public p M() {
        return this.u;
    }

    @Override // e.l.s.c
    @d
    public f<Pair<String, String>> N() {
        return this.f4355f;
    }

    @Override // e.l.s.c
    @d
    public g O(@d View view) {
        return e.t.j.h.d.a.a(new FilterBarImpl$onChoiceRarity$1(this));
    }

    @Override // e.l.s.c
    @d
    public l P() {
        return this.r;
    }

    @Override // e.l.s.c
    @d
    public e.t.j.h.l Q() {
        return d.e.a.a(new FilterBarImpl$onClickSortItem$1(this));
    }

    @Override // e.l.s.c
    @k.e.a.d
    public a<Rarity> S() {
        return K();
    }

    @Override // e.l.s.c
    @k.e.a.d
    public f<String> V() {
        return this.f4361l;
    }

    @Override // e.l.s.c
    @k.e.a.d
    public f<Pair<String, String>> W() {
        return this.f4352c;
    }

    @Override // e.l.s.c
    @k.e.a.d
    public i X() {
        return this.n;
    }

    @Override // e.l.s.c
    @k.e.a.d
    public LayoutManagers.a Y() {
        return R();
    }

    @Override // e.l.s.c
    public boolean Z() {
        return false;
    }

    @Override // e.l.s.c
    public void a(@k.e.a.d List<Rarity> list) {
        this.f4359j.setValue(list);
        this.f4355f.r(new Pair<>(Res.w(Res.a, R.string.shop_all_rarity, null, 2, null), ""));
    }

    @Override // e.l.s.c
    @k.e.a.d
    public g a0(int i2) {
        return e.t.j.h.d.a.a(new FilterBarImpl$onChoicePriceType$1(this, i2));
    }

    @Override // e.l.s.c
    @k.e.a.d
    public g b(@k.e.a.d View view) {
        return e.t.j.h.d.a.a(new FilterBarImpl$onChoiceSorting$1(this));
    }

    @Override // e.l.s.c
    public void c0(@k.e.a.d TextView textView) {
        e.l.h.d.f.b.c(e.l.j.a.f12240j, textView.getText().toString());
    }

    @Override // e.l.s.c
    @k.e.a.d
    public i d() {
        return this.o;
    }

    @Override // e.l.s.c
    public void d0(int i2) {
        this.r.setValue(Integer.valueOf(i2));
    }

    @Override // e.l.s.c
    @k.e.a.d
    public i f0() {
        return this.f4362m;
    }

    @Override // e.l.s.c
    @k.e.a.d
    public g g0() {
        return e.t.j.h.d.a.a(FilterBarImpl$onClickWarehouse$1.INSTANCE);
    }

    @Override // e.l.s.c
    @k.e.a.d
    public h.k2.u.l<List<Rarity>, t1> h0() {
        return this.v;
    }

    @Override // e.l.s.c
    @k.e.a.d
    public f<List<Rarity>> i() {
        return this.f4359j;
    }

    @Override // e.l.s.c
    public boolean j0() {
        return true;
    }

    @Override // e.l.s.c
    public boolean k() {
        return true;
    }

    @Override // e.l.s.c
    @k.e.a.d
    public l l() {
        return this.a;
    }

    @Override // e.l.s.c
    @k.e.a.d
    public g m(@k.e.a.d View view) {
        return e.t.j.h.d.a.a(FilterBarImpl$onClickSearchHouse$1.INSTANCE);
    }

    @Override // e.l.s.c
    @k.e.a.d
    public f<Pair<String, String>> n() {
        return this.f4354e;
    }

    @Override // e.l.s.c
    @k.e.a.d
    public g q(@k.e.a.d View view) {
        return e.t.j.h.d.a.a(new FilterBarImpl$onClickSearchSell$1(this));
    }

    @Override // e.l.s.c
    public void r(@k.e.a.d Pair<String, String> pair) {
        Boolean bool = Boolean.FALSE;
        Boolean bool2 = Boolean.TRUE;
        this.r.setValue(0);
        this.f4353d.r(pair);
        this.f4354e.r(pair);
        U(this.f4353d, this.f4361l);
        String first = pair.getFirst();
        switch (first.hashCode()) {
            case -1651662948:
                if (first.equals("价钱低到高")) {
                    this.f4362m.setValue(bool2);
                    this.n.setValue(bool2);
                    return;
                }
                return;
            case -1633098468:
                if (first.equals("价钱高到低")) {
                    this.f4362m.setValue(bool);
                    this.n.setValue(bool2);
                    return;
                }
                return;
            case 671092068:
                if (!first.equals("匹配优先")) {
                    return;
                }
                this.f4362m.setValue(bool);
                this.n.setValue(bool2);
                return;
            case 811235074:
                if (!first.equals("最新发布")) {
                    return;
                }
                this.f4362m.setValue(bool);
                this.n.setValue(bool);
                return;
            case 990691486:
                if (!first.equals("编号排序")) {
                    return;
                }
                this.f4362m.setValue(bool);
                this.n.setValue(bool);
                return;
            case 993148941:
                if (!first.equals("匹配优先（任意版本）")) {
                    return;
                }
                this.f4362m.setValue(bool);
                this.n.setValue(bool2);
                return;
            default:
                return;
        }
    }

    @Override // e.l.s.c
    @k.e.a.d
    public i s() {
        return this.t;
    }

    @Override // e.l.s.c
    public void v(int i2) {
        List<Pair<String, String>> sorting;
        K().w();
        this.f4357h = i2;
        this.r.p();
        i iVar = this.n;
        Boolean bool = Boolean.FALSE;
        iVar.setValue(bool);
        this.f4362m.setValue(bool);
        Constants.Companion companion = Constants.Companion;
        if (i2 == companion.getTYPE_NEWEST()) {
            sorting = companion.getSORTING_NEWEST();
        } else if (i2 == companion.getTYPE_WAREHOUSE_SELLER()) {
            sorting = companion.getSORTING_SELLER();
        } else if (i2 == companion.getTYPE_SELLER()) {
            if (b.a(W().getValue())) {
                sorting = companion.getSORTING_NEWEST();
            } else {
                sorting = companion.getSORTING_SELLER();
            }
        } else {
            sorting = companion.getSORTING();
        }
        this.b = sorting;
        this.f4360k.r(sorting);
        this.f4353d.r(this.b.get(0));
        U(this.f4353d, this.f4361l);
        this.o.setValue(bool);
        this.f4355f.r(new Pair<>(Res.w(Res.a, R.string.shop_all_rarity, null, 2, null), ""));
    }

    @Override // e.l.s.c
    @k.e.a.d
    public h w() {
        return d.c.a.c(new FilterBarImpl$getEditAction$1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.l.s.c
    public void y(int i2) {
        this.n.setValue(Boolean.valueOf(i2 != 0));
        this.f4353d.r(CollectionsKt___CollectionsKt.J2(this.b, i2));
        this.f4354e.r(CollectionsKt___CollectionsKt.J2(this.b, i2));
        U(this.f4353d, this.f4361l);
    }
}
