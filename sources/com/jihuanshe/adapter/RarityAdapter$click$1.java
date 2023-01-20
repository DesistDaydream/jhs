package com.jihuanshe.adapter;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.model.Rarity;
import com.vector.util.Res;
import com.xiaomi.mipush.sdk.Constants;
import h.a2.u;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RarityAdapter$click$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ int $pos;
    public final /* synthetic */ RarityAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RarityAdapter$click$1(RarityAdapter rarityAdapter, int i2) {
        super(1);
        this.this$0 = rarityAdapter;
        this.$pos = i2;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        List list;
        List list2;
        List<Number> list3;
        String Z2;
        Rarity rarity;
        List list4;
        List list5;
        List list6;
        Rarity rarity2;
        if (this.this$0.z()) {
            list5 = this.this$0.f3758f;
            list5.clear();
            list6 = this.this$0.f3758f;
            list6.add(Integer.valueOf(this.$pos));
            List<Rarity> d2 = this.this$0.d();
            Z2 = (d2 == null || (rarity2 = (Rarity) CollectionsKt___CollectionsKt.J2(d2, this.$pos)) == null) ? null : rarity2.getRarity();
            if (Z2 == null) {
                Z2 = "";
            }
        } else {
            list = this.this$0.f3758f;
            if (list.contains(Integer.valueOf(this.$pos))) {
                list4 = this.this$0.f3758f;
                list4.remove(Integer.valueOf(this.$pos));
            } else {
                list2 = this.this$0.f3758f;
                list2.add(Integer.valueOf(this.$pos));
            }
            list3 = this.this$0.f3758f;
            RarityAdapter rarityAdapter = this.this$0;
            ArrayList arrayList = new ArrayList(u.Y(list3, 10));
            for (Number number : list3) {
                int intValue = number.intValue();
                List<Rarity> d3 = rarityAdapter.d();
                String rarity3 = (d3 == null || (rarity = (Rarity) CollectionsKt___CollectionsKt.J2(d3, intValue)) == null) ? null : rarity.getRarity();
                if (rarity3 == null) {
                    rarity3 = "";
                }
                arrayList.add(rarity3);
            }
            Z2 = CollectionsKt___CollectionsKt.Z2(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP, null, null, 0, null, null, 62, null);
        }
        this.this$0.y().N().r(new Pair<>(Res.w(Res.a, R.string.shop_all_rarity, null, 2, null), Z2));
        this.this$0.y().C().r(new Pair<>("", Z2));
        this.this$0.y().i().n();
    }
}
