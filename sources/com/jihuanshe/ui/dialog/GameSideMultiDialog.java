package com.jihuanshe.ui.dialog;

import android.content.Context;
import com.jihuanshe.R;
import com.jihuanshe.model.Game;
import com.vector.util.Res;
import h.a2.u;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes2.dex */
public final class GameSideMultiDialog extends BaseSideDialog {
    @d
    private final List<Game> B;
    @d
    private List<Game> C;
    @d
    private final l<List<Game>, t1> D;
    @d
    private final List<Game> E;
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
    public GameSideMultiDialog(@d Context context, @d List<Game> list, @d List<Game> list2, @d l<? super List<Game>, t1> lVar) {
        super(context);
        this.B = list;
        this.C = list2;
        this.D = lVar;
        this.E = CollectionsKt___CollectionsKt.L5(list2);
        ArrayList<Game> arrayList = new ArrayList();
        for (Object obj : list) {
            if (getCurGame().contains((Game) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(u.Y(arrayList, 10));
        for (Game game : arrayList) {
            arrayList2.add(Integer.valueOf(getGame().indexOf(game)));
        }
        this.F = CollectionsKt___CollectionsKt.L5(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        List<Game> game2 = getGame();
        ArrayList arrayList4 = new ArrayList(u.Y(game2, 10));
        for (Game game3 : game2) {
            String name = game3.getName();
            if (name == null) {
                name = "";
            }
            arrayList4.add(name);
        }
        arrayList3.addAll(arrayList4);
        t1 t1Var = t1.a;
        this.G = arrayList3;
        Res res = Res.a;
        this.H = Res.w(res, R.string.common_filter_game, null, 2, null);
        this.I = Res.w(res, R.string.common_kind_game, null, 2, null);
        this.J = 2;
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
        Game game = (Game) CollectionsKt___CollectionsKt.J2(this.B, i2);
        if (game == null) {
            return;
        }
        this.E.remove(game);
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    public void F(int i2) {
        Game game = (Game) CollectionsKt___CollectionsKt.J2(this.B, i2);
        if (game == null || this.E.contains(game)) {
            return;
        }
        this.E.add(game);
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    public void H() {
        this.C.clear();
        this.D.invoke(this.C);
        h();
    }

    @d
    public final List<Game> getCurGame() {
        return this.C;
    }

    @d
    public final List<Game> getGame() {
        return this.B;
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    @d
    public List<Integer> getInitIndexs() {
        return this.F;
    }

    @d
    public final l<List<Game>, t1> getListener() {
        return this.D;
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    @d
    public List<String> getLocalData() {
        return this.G;
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

    public final void setCurGame(@d List<Game> list) {
        this.C = list;
    }
}
