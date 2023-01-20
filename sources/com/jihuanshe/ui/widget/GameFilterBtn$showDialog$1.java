package com.jihuanshe.ui.widget;

import android.content.res.ColorStateList;
import androidx.core.widget.TextViewCompat;
import com.jihuanshe.R;
import com.jihuanshe.model.Game;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GameFilterBtn$showDialog$1 extends Lambda implements l<List<? extends Game>, t1> {
    public final /* synthetic */ GameFilterBtn this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameFilterBtn$showDialog$1(GameFilterBtn gameFilterBtn) {
        super(1);
        this.this$0 = gameFilterBtn;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Game> list) {
        invoke2((List<Game>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d List<Game> list) {
        l<List<Game>, t1> multiListener = this.this$0.getMultiListener();
        if (multiListener != null) {
            multiListener.invoke(this.this$0.getCurrents());
        }
        GameFilterBtn gameFilterBtn = this.this$0;
        TextViewCompat.setCompoundDrawableTintList(gameFilterBtn, ColorStateList.valueOf(gameFilterBtn.getCurrents().isEmpty() ? this.this$0.f4110g : Res.k(R.color.common_color)));
    }
}
