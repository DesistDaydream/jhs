package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.ui.dialog.ListDialog;
import e.l.g.y0;
import e.l.s.o.b;
import h.a2.u;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopOwnerConfirmActivity$onClickBank$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ShopOwnerConfirmActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity$onClickBank$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<Integer, t1> {
        public final /* synthetic */ ShopOwnerConfirmActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ShopOwnerConfirmActivity shopOwnerConfirmActivity) {
            super(1);
            this.this$0 = shopOwnerConfirmActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
            invoke(num.intValue());
            return t1.a;
        }

        public final void invoke(int i2) {
            List<String> value = ((b) this.this$0.L()).F0().getValue();
            String str = value == null ? null : (String) CollectionsKt___CollectionsKt.J2(value, i2);
            ((b) this.this$0.L()).G0().setValue(str);
            ((b) this.this$0.L()).L0().setValue(Boolean.valueOf(f0.g(str, "其他银行")));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopOwnerConfirmActivity$onClickBank$1(ShopOwnerConfirmActivity shopOwnerConfirmActivity) {
        super(1);
        this.this$0 = shopOwnerConfirmActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        List list;
        ShopOwnerConfirmActivity shopOwnerConfirmActivity = this.this$0;
        List<String> value = ((b) shopOwnerConfirmActivity.L()).F0().getValue();
        if (value == null) {
            list = null;
        } else {
            List arrayList = new ArrayList(u.Y(value, 10));
            for (String str : value) {
                arrayList.add(new y0(str));
            }
            list = arrayList;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.E();
        }
        new ListDialog(shopOwnerConfirmActivity, list, 0, new AnonymousClass2(this.this$0)).y();
    }
}
