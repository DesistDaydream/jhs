package com.jihuanshe.ui.dialog;

import androidx.lifecycle.LifecycleOwnerKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.GameBar;
import e.l.n.a;
import e.l.n.c.w;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardProductDialogFragment$flowOfSetup$1 extends Lambda implements l<String, t1> {
    public final /* synthetic */ CardProductDialogFragment this$0;

    /* renamed from: com.jihuanshe.ui.dialog.CardProductDialogFragment$flowOfSetup$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ CardProductDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CardProductDialogFragment cardProductDialogFragment) {
            super(1);
            this.this$0 = cardProductDialogFragment;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            e.l.h.j.b.e.e(this.this$0, R.string.report_success, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardProductDialogFragment$flowOfSetup$1(CardProductDialogFragment cardProductDialogFragment) {
        super(1);
        this.this$0 = cardProductDialogFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d String str) {
        int i2;
        int i3;
        this.this$0.Q().r(null);
        w wVar = (w) a.d(w.class, false, false, false, 60L, true);
        i2 = this.this$0.f3960f;
        i3 = this.this$0.f3961g;
        GameBar.a aVar = GameBar.b;
        Game value = aVar.a().getValue();
        String gameKey = value == null ? null : value.getGameKey();
        String str2 = gameKey != null ? gameKey : "";
        Game value2 = aVar.a().getValue();
        String gameSubKey = value2 == null ? null : value2.getGameSubKey();
        if (gameSubKey == null) {
            gameSubKey = "";
        }
        BinderKt.p(BinderKt.j(e.g.d.a.h(e.g.d.a.j(FlowKt.c(wVar.a(i2, i3, str, str2, gameSubKey)), null, new AnonymousClass1(this.this$0), 1, null), LifecycleOwnerKt.getLifecycleScope(this.this$0), null, 2, null), this.this$0, false, 2, null));
    }
}
