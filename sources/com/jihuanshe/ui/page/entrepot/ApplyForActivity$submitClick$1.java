package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.viewmodel.entrepot.ApplyForViewModel;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ApplyForActivity$submitClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ApplyForActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyForActivity$submitClick$1(ApplyForActivity applyForActivity) {
        super(1);
        this.this$0 = applyForActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        List<ApplyForItem> value = ((ApplyForViewModel) this.this$0.L()).r0().getValue();
        if ((value == null ? null : (ApplyForItem) CollectionsKt___CollectionsKt.J2(value, 0)) == null) {
            return;
        }
        SubmitOrderActivityCreator.create(((ApplyForViewModel) this.this$0.L()).s0().getValue()).checked(this.this$0.b0().getValue()).start(this.this$0);
    }
}
