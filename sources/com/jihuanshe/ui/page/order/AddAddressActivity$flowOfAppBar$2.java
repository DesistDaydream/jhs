package com.jihuanshe.ui.page.order;

import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.UserAddress;
import com.jihuanshe.ui.widget.ReviewPopupWindow;
import com.vector.util.Res;
import e.l.h.d.f;
import e.l.j.a;
import e.l.n.c.k;
import e.t.o.d;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddAddressActivity$flowOfAppBar$2 extends Lambda implements l<View, t1> {
    public final /* synthetic */ AddAddressActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.order.AddAddressActivity$flowOfAppBar$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<View, t1> {
        public final /* synthetic */ AddAddressActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.order.AddAddressActivity$flowOfAppBar$2$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01081 extends Lambda implements l<t1, t1> {
            public final /* synthetic */ AddAddressActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01081(AddAddressActivity addAddressActivity) {
                super(1);
                this.this$0 = addAddressActivity;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
                invoke2(t1Var);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@e t1 t1Var) {
                f.b.c(a.f12238h, this.this$0.e0());
                this.this$0.finish();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AddAddressActivity addAddressActivity) {
            super(1);
            this.this$0 = addAddressActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(View view) {
            invoke2(view);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d View view) {
            UserAddress e0 = this.this$0.e0();
            Integer valueOf = e0 == null ? null : Integer.valueOf(e0.getId());
            if (valueOf == null) {
                return;
            }
            valueOf.intValue();
            BinderKt.p(BinderKt.k(e.g.d.a.h(e.g.d.a.j(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).V(this.this$0.e0().getId())), null, new C01081(this.this$0), 1, null), LifecycleOwnerKt.getLifecycleScope(this.this$0), null, 2, null), this.this$0, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddAddressActivity$flowOfAppBar$2(AddAddressActivity addAddressActivity) {
        super(1);
        this.this$0 = addAddressActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        ReviewPopupWindow reviewPopupWindow = new ReviewPopupWindow(this.this$0, Res.w(Res.a, R.string.common_delete, null, 2, null), e.t.j.h.d.a.a(new AnonymousClass1(this.this$0)));
        d.a aVar = e.t.o.d.a;
        reviewPopupWindow.showAsDropDown(view, -d.a.c(aVar, null, 1, null).d(38), -d.a.c(aVar, null, 1, null).d(16));
    }
}
