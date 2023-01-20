package com.jihuanshe.viewmodel;

import android.view.View;
import e.n.f;
import e.n.i;
import e.n.l;
import h.k2.u.p;
import h.t1;
import k.e.a.e;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FilterBarImpl$onClickSortItem$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ FilterBarImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterBarImpl$onClickSortItem$1(FilterBarImpl filterBarImpl) {
        super(2);
        this.this$0 = filterBarImpl;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        l lVar;
        f fVar;
        i iVar;
        i iVar2;
        i iVar3;
        i iVar4;
        i iVar5;
        i iVar6;
        i iVar7;
        i iVar8;
        Boolean bool = Boolean.FALSE;
        Boolean bool2 = Boolean.TRUE;
        lVar = this.this$0.r;
        lVar.setValue(0);
        this.this$0.f4353d.r(CollectionsKt___CollectionsKt.J2(this.this$0.b, i2));
        fVar = this.this$0.f4354e;
        fVar.r(CollectionsKt___CollectionsKt.J2(this.this$0.b, i2));
        FilterBarImpl filterBarImpl = this.this$0;
        filterBarImpl.U(filterBarImpl.f4353d, this.this$0.f4361l);
        Pair pair = (Pair) CollectionsKt___CollectionsKt.J2(this.this$0.b, i2);
        String str = pair == null ? null : (String) pair.getFirst();
        if (str != null) {
            switch (str.hashCode()) {
                case -1651662948:
                    if (str.equals("价钱低到高")) {
                        iVar = this.this$0.f4362m;
                        iVar.setValue(bool2);
                        iVar2 = this.this$0.n;
                        iVar2.setValue(bool2);
                        return;
                    }
                    return;
                case -1633098468:
                    if (str.equals("价钱高到低")) {
                        iVar3 = this.this$0.f4362m;
                        iVar3.setValue(bool);
                        iVar4 = this.this$0.n;
                        iVar4.setValue(bool2);
                        return;
                    }
                    return;
                case 671092068:
                    if (!str.equals("匹配优先")) {
                        return;
                    }
                    iVar7 = this.this$0.f4362m;
                    iVar7.setValue(bool);
                    iVar8 = this.this$0.n;
                    iVar8.setValue(bool2);
                    return;
                case 811235074:
                    if (!str.equals("最新发布")) {
                        return;
                    }
                    iVar5 = this.this$0.f4362m;
                    iVar5.setValue(bool);
                    iVar6 = this.this$0.n;
                    iVar6.setValue(bool);
                    return;
                case 990691486:
                    if (!str.equals("编号排序")) {
                        return;
                    }
                    iVar5 = this.this$0.f4362m;
                    iVar5.setValue(bool);
                    iVar6 = this.this$0.n;
                    iVar6.setValue(bool);
                    return;
                case 993148941:
                    if (!str.equals("匹配优先（任意版本）")) {
                        return;
                    }
                    iVar7 = this.this$0.f4362m;
                    iVar7.setValue(bool);
                    iVar8 = this.this$0.n;
                    iVar8.setValue(bool2);
                    return;
                default:
                    return;
            }
        }
    }
}
