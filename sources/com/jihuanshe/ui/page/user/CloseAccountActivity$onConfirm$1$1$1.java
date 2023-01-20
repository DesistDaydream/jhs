package com.jihuanshe.ui.page.user;

import androidx.lifecycle.LifecycleOwnerKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CloseContent;
import com.jihuanshe.ui.dialog.UseDialog;
import e.l.n.c.v;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CloseAccountActivity$onConfirm$1$1$1 extends Lambda implements a<t1> {
    public final /* synthetic */ UseDialog $this_apply;
    public final /* synthetic */ CloseAccountActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.CloseAccountActivity$onConfirm$1$1$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<CloseContent, t1> {
        public final /* synthetic */ CloseAccountActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CloseAccountActivity closeAccountActivity) {
            super(1);
            this.this$0 = closeAccountActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(CloseContent closeContent) {
            invoke2(closeContent);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e CloseContent closeContent) {
            this.this$0.Z().setValue(Boolean.TRUE);
            this.this$0.a0().setValue(closeContent == null ? null : closeContent.getContent());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloseAccountActivity$onConfirm$1$1$1(UseDialog useDialog, CloseAccountActivity closeAccountActivity) {
        super(0);
        this.$this_apply = useDialog;
        this.this$0 = closeAccountActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BinderKt.p(BinderKt.k(e.g.d.a.j(e.g.d.a.h(FlowKt.c(v.a.a((v) e.l.n.a.d(v.class, true, false, false, 60L, true), null, 1, null)), LifecycleOwnerKt.getLifecycleScope(this.$this_apply), null, 2, null), null, new AnonymousClass1(this.this$0), 1, null), this.this$0, false, 2, null));
    }
}
