package com.jihuanshe.ui.dialog;

import android.content.Context;
import com.jihuanshe.R;
import com.jihuanshe.model.Rarity;
import com.vector.util.Res;
import h.a2.u;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes2.dex */
public final class ConditionSideDialog extends BaseSideDialog {
    @d
    private final List<Rarity> B;
    @d
    private List<Rarity> C;
    @d
    private final l<List<Rarity>, t1> D;
    @d
    private final List<Rarity> E;
    @d
    private final List<Integer> F;
    @d
    private final List<String> G;
    @d
    private final String H;
    @d
    private final String I;
    private final int J;

    /* JADX WARN: Multi-variable type inference failed */
    public ConditionSideDialog(@d Context context, @d List<Rarity> list, @d List<Rarity> list2, @d l<? super List<Rarity>, t1> lVar) {
        super(context);
        this.B = list;
        this.C = list2;
        this.D = lVar;
        this.E = CollectionsKt___CollectionsKt.L5(list2);
        ArrayList<Rarity> arrayList = new ArrayList();
        for (Object obj : list) {
            if (getCurRarity().contains((Rarity) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(u.Y(arrayList, 10));
        for (Rarity rarity : arrayList) {
            arrayList2.add(Integer.valueOf(getRarity().indexOf(rarity)));
        }
        this.F = CollectionsKt___CollectionsKt.L5(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        List<Rarity> rarity2 = getRarity();
        ArrayList arrayList4 = new ArrayList(u.Y(rarity2, 10));
        for (Rarity rarity3 : rarity2) {
            arrayList4.add((rarity3.getCount() != null && rarity3.getCount().intValue() >= 0) ? rarity3.getRarity() + '\n' + rarity3.getCount() + (char) 24352 : rarity3.getRarity());
        }
        arrayList3.addAll(arrayList4);
        t1 t1Var = t1.a;
        this.G = arrayList3;
        Res res = Res.a;
        this.H = Res.w(res, R.string.common_filter, null, 2, null);
        this.I = Res.w(res, R.string.card_rarity, null, 2, null);
        this.J = 1;
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    public void C() {
        this.C.clear();
        this.C.addAll(this.E);
        h();
        this.D.invoke(this.C);
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    public void E(int i2) {
        Rarity rarity = (Rarity) CollectionsKt___CollectionsKt.J2(this.B, i2);
        if (rarity == null) {
            return;
        }
        this.E.remove(rarity);
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    public void F(int i2) {
        Rarity rarity = (Rarity) CollectionsKt___CollectionsKt.J2(this.B, i2);
        if (rarity == null || this.E.contains(rarity)) {
            return;
        }
        this.E.add(rarity);
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    public void H() {
        this.C.clear();
        this.D.invoke(this.C);
        h();
    }

    @d
    public final List<Rarity> getCurRarity() {
        return this.C;
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    @d
    public List<Integer> getInitIndexs() {
        return this.F;
    }

    @d
    public final l<List<Rarity>, t1> getListener() {
        return this.D;
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    @d
    public List<String> getLocalData() {
        return this.G;
    }

    @d
    public final List<Rarity> getRarity() {
        return this.B;
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    public int getSelectType() {
        return this.J;
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    @d
    public String getSubTitleText() {
        return this.I;
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    @d
    public String getTitleText() {
        return this.H;
    }

    public final void setCurRarity(@d List<Rarity> list) {
        this.C = list;
    }
}
