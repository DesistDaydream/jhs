package com.jihuanshe.viewmodel.rank;

import androidx.fragment.app.Fragment;
import com.jihuanshe.model.RankTypeInfo;
import com.jihuanshe.ui.page.rank.RankListFragmentCreator;
import e.l.h.d.f;
import e.l.h.d.i;
import e.l.j.a;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RankViewModel$rankTypeList$1 extends Lambda implements l<List<? extends RankTypeInfo>, t1> {
    public final /* synthetic */ RankViewModel this$0;

    /* renamed from: com.jihuanshe.viewmodel.rank.RankViewModel$rankTypeList$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<Integer, Fragment> {
        public final /* synthetic */ RankViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(RankViewModel rankViewModel) {
            super(1);
            this.this$0 = rankViewModel;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ Fragment invoke(Integer num) {
            return invoke(num.intValue());
        }

        @d
        public final Fragment invoke(int i2) {
            List<RankTypeInfo> value = this.this$0.y0().getValue();
            return RankListFragmentCreator.create(value == null ? null : value.get(i2)).get();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankViewModel$rankTypeList$1(RankViewModel rankViewModel) {
        super(1);
        this.this$0 = rankViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends RankTypeInfo> list) {
        invoke2((List<RankTypeInfo>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e List<RankTypeInfo> list) {
        this.this$0.y0().setValue(list);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (RankTypeInfo rankTypeInfo : list) {
                arrayList.add(rankTypeInfo.getRankingTypeName());
            }
        }
        this.this$0.v0().setValue(e.t.k.a.c.h.d.i(arrayList.size(), arrayList, null, new AnonymousClass2(this.this$0), 4, null));
        this.this$0.z0(0);
        i.d(f.b, a.u, null, 2, null);
    }
}
