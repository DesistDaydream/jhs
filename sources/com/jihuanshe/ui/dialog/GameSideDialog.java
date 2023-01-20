package com.jihuanshe.ui.dialog;

import android.content.Context;
import com.jihuanshe.R;
import com.jihuanshe.model.Game;
import com.vector.util.Res;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes2.dex */
public final class GameSideDialog extends BaseSideDialog {
    @d
    private final List<Game> B;
    @e
    private Game C;
    private final boolean D;
    @d
    private final l<Game, t1> E;
    @d
    private final List<Integer> F;
    private final boolean G;
    @d
    private final List<String> H;
    private final boolean I;
    @d
    private final String J;
    @d
    private final String K;

    public /* synthetic */ GameSideDialog(Context context, List list, Game game, boolean z, l lVar, int i2, u uVar) {
        this(context, list, game, (i2 & 8) != 0 ? true : z, lVar);
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    public void C() {
        h();
        this.E.invoke(this.C);
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    public void E(int i2) {
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    public void F(int i2) {
        Game game;
        if (this.D) {
            game = (Game) CollectionsKt___CollectionsKt.J2(this.B, i2 - 1);
        } else {
            game = (Game) CollectionsKt___CollectionsKt.J2(this.B, i2);
        }
        this.C = game;
    }

    @e
    public final Game getCurGame() {
        return this.C;
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    public boolean getFirstMatch() {
        return this.I;
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
    public final l<Game, t1> getListener() {
        return this.E;
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    @d
    public List<String> getLocalData() {
        return this.H;
    }

    public final boolean getNeedAll() {
        return this.D;
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    public boolean getNeedResetButton() {
        return this.G;
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    @d
    public String getSubTitleText() {
        return this.K;
    }

    @Override // com.jihuanshe.ui.dialog.BaseSideDialog
    @d
    public String getTitleText() {
        return this.J;
    }

    public final void setCurGame(@e Game game) {
        this.C = game;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GameSideDialog(@d Context context, @d List<Game> list, @e Game game, boolean z, @d l<? super Game, t1> lVar) {
        super(context);
        int Q2;
        this.B = list;
        this.C = game;
        this.D = z;
        this.E = lVar;
        Integer[] numArr = new Integer[1];
        if (z) {
            Q2 = game == null ? 0 : CollectionsKt___CollectionsKt.Q2(list, game) + 1;
        } else {
            Q2 = CollectionsKt___CollectionsKt.Q2(list, game);
        }
        numArr[0] = Integer.valueOf(Q2);
        this.F = CollectionsKt__CollectionsKt.P(numArr);
        ArrayList arrayList = new ArrayList();
        if (getNeedAll()) {
            arrayList.add(Res.w(Res.a, R.string.common_all_game, null, 2, null));
        }
        List<Game> game2 = getGame();
        ArrayList arrayList2 = new ArrayList(h.a2.u.Y(game2, 10));
        for (Game game3 : game2) {
            String name = game3.getName();
            if (name == null) {
                name = "";
            }
            arrayList2.add(name);
        }
        arrayList.addAll(arrayList2);
        t1 t1Var = t1.a;
        this.H = arrayList;
        this.I = this.D;
        Res res = Res.a;
        this.J = Res.w(res, R.string.common_filter_game, null, 2, null);
        this.K = Res.w(res, R.string.common_kind_game, null, 2, null);
    }
}
