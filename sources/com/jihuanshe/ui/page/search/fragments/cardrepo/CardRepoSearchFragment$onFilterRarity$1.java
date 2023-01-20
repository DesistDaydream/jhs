package com.jihuanshe.ui.page.search.fragments.cardrepo;

import com.jihuanshe.model.Rarity;
import com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel;
import com.xiaomi.mipush.sdk.Constants;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardRepoSearchFragment$onFilterRarity$1 extends Lambda implements l<List<? extends Rarity>, t1> {
    public final /* synthetic */ CardRepoSearchFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.search.fragments.cardrepo.CardRepoSearchFragment$onFilterRarity$1$1  reason: invalid class name */
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
    public CardRepoSearchFragment$onFilterRarity$1(CardRepoSearchFragment cardRepoSearchFragment) {
        super(1);
        this.this$0 = cardRepoSearchFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Rarity> list) {
        invoke2((List<Rarity>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e List<Rarity> list) {
        ((CardRepoSearchViewModel) this.this$0.T()).v0().r(list == null ? null : CollectionsKt___CollectionsKt.Z2(list, Constants.ACCEPT_TIME_SEPARATOR_SP, null, null, 0, null, AnonymousClass1.INSTANCE, 30, null));
    }
}
