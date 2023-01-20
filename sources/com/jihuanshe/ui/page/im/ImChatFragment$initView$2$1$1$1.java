package com.jihuanshe.ui.page.im;

import com.eth.ext.FlowKt;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.dialog.UseDialog;
import com.vector.util.Res;
import e.l.n.c.k;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ImChatFragment$initView$2$1$1$1 extends Lambda implements a<t1> {
    public final /* synthetic */ UseDialog $this_apply;
    public final /* synthetic */ ImChatFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.im.ImChatFragment$initView$2$1$1$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ UseDialog $this_apply;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(UseDialog useDialog) {
            super(1);
            this.$this_apply = useDialog;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            e.l.h.j.b.e.f(this.$this_apply, Res.w(Res.a, R.string.ban_success, null, 2, null), (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImChatFragment$initView$2$1$1$1(ImChatFragment imChatFragment, UseDialog useDialog) {
        super(0);
        this.this$0 = imChatFragment;
        this.$this_apply = useDialog;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BinderKt.p(BinderKt.j(e.g.d.a.j(e.g.d.a.g(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).F(this.this$0.getChatInfo().getId())), this.this$0, null, 2, null), null, new AnonymousClass1(this.$this_apply), 1, null), this.this$0, false, 2, null));
    }
}
