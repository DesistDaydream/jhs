package com.jihuanshe.ui.page.search.fragments.global;

import com.jihuanshe.model.Rarity;
import e.l.s.m.d.a;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GlobalSearchProductFragment$onFilterRarity$1 extends Lambda implements l<List<? extends Rarity>, t1> {
    public final /* synthetic */ GlobalSearchProductFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.search.fragments.global.GlobalSearchProductFragment$onFilterRarity$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<Rarity, CharSequence> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // h.k2.u.l
        @d
        public final CharSequence invoke(@d Rarity rarity) {
            return rarity.getRarity();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSearchProductFragment$onFilterRarity$1(GlobalSearchProductFragment globalSearchProductFragment) {
        super(1);
        this.this$0 = globalSearchProductFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Rarity> list) {
        invoke2((List<Rarity>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e List<Rarity> list) {
        ((a) this.this$0.T()).s0().setValue(list == null ? null : CollectionsKt___CollectionsKt.Z2(list, null, null, null, 0, null, AnonymousClass1.INSTANCE, 31, null));
        ((a) this.this$0.T()).t0().n();
    }
}
