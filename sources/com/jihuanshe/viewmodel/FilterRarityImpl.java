package com.jihuanshe.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.model.Rarity;
import com.xiaomi.mipush.sdk.Constants;
import e.l.s.g;
import e.n.f;
import e.n.i;
import e.n.p;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes2.dex */
public final class FilterRarityImpl implements g {
    @d
    private final f<List<Rarity>> a = new f<>(null, 1, null);
    @d
    private final p b = new p(null, 1, null);
    @d

    /* renamed from: c  reason: collision with root package name */
    private final i f4363c = new i(null, 1, null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private final FilterRarityImpl$rarityFilterListener$1 f4364d = new l<List<? extends Rarity>, t1>() { // from class: com.jihuanshe.viewmodel.FilterRarityImpl$rarityFilterListener$1
        public void a(@e List<Rarity> list) {
            p pVar;
            p pVar2;
            if (list == null || list.isEmpty()) {
                pVar2 = FilterRarityImpl.this.b;
                pVar2.r(null);
                return;
            }
            pVar = FilterRarityImpl.this.b;
            pVar.r(CollectionsKt___CollectionsKt.Z2(list, Constants.ACCEPT_TIME_SEPARATOR_SP, null, null, 0, null, FilterRarityImpl$rarityFilterListener$1$invoke$1.INSTANCE, 30, null));
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(List<? extends Rarity> list) {
            a(list);
            return t1.a;
        }
    };

    @Override // e.l.s.g
    @d
    public f<List<Rarity>> H() {
        return this.a;
    }

    @Override // e.l.s.g
    @e
    public String J() {
        return this.b.getValue();
    }

    @Override // e.l.s.g
    public void b0(@e List<Rarity> list) {
        f<List<Rarity>> fVar = this.a;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.E();
        }
        fVar.r(list);
    }

    @Override // e.l.s.g
    @d
    public i c() {
        return this.f4363c;
    }

    @Override // e.l.s.g
    @d
    public l<List<Rarity>, t1> i0() {
        return this.f4364d;
    }

    @Override // e.l.s.g
    public void j() {
        this.f4363c.r(Boolean.TRUE);
    }

    @Override // e.l.s.g
    public void z(@e LifecycleOwner lifecycleOwner, @d l<? super String, t1> lVar) {
        this.b.j(lifecycleOwner, new FilterRarityImpl$observeRarity$1(lVar));
    }
}
