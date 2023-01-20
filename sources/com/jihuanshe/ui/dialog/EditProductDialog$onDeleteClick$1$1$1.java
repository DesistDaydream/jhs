package com.jihuanshe.ui.dialog;

import androidx.lifecycle.LifecycleOwnerKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.base.ext.BinderKt;
import e.l.h.d.f;
import e.l.n.c.k;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EditProductDialog$onDeleteClick$1$1$1 extends Lambda implements a<t1> {
    public final /* synthetic */ EditProductDialog this$0;

    /* renamed from: com.jihuanshe.ui.dialog.EditProductDialog$onDeleteClick$1$1$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ EditProductDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EditProductDialog editProductDialog) {
            super(1);
            this.this$0 = editProductDialog;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            int i2;
            f fVar = f.b;
            i2 = this.this$0.f3969e;
            fVar.c(e.l.j.a.f12242l, Integer.valueOf(i2));
            this.this$0.dismiss();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditProductDialog$onDeleteClick$1$1$1(EditProductDialog editProductDialog) {
        super(0);
        this.this$0 = editProductDialog;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int i2;
        i2 = this.this$0.f3969e;
        BinderKt.p(BinderKt.j(e.g.d.a.h(e.g.d.a.j(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).P(Integer.valueOf(i2))), null, new AnonymousClass1(this.this$0), 1, null), LifecycleOwnerKt.getLifecycleScope(this.this$0), null, 2, null), this.this$0, false, 2, null));
    }
}
