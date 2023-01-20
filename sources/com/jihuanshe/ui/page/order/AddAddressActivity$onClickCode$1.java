package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.ui.widget.PhonePopupWindow;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddAddressActivity$onClickCode$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ AddAddressActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.order.AddAddressActivity$onClickCode$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<String, t1> {
        public final /* synthetic */ AddAddressActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AddAddressActivity addAddressActivity) {
            super(1);
            this.this$0 = addAddressActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(String str) {
            invoke2(str);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d String str) {
            this.this$0.j0().setValue(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddAddressActivity$onClickCode$1(AddAddressActivity addAddressActivity) {
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
        AddAddressActivity addAddressActivity = this.this$0;
        new PhonePopupWindow(addAddressActivity, new AnonymousClass1(addAddressActivity)).showAsDropDown(this.this$0.p0());
    }
}
