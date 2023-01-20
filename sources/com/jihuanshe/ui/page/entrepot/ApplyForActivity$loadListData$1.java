package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.ui.page.entrepot.ApplyForActivity;
import com.jihuanshe.ui.page.entrepot.ApplyForActivity$loadListData$1;
import com.vector.view.scrollable.ListView;
import e.l.h.i.e;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ApplyForActivity$loadListData$1 extends Lambda implements l<e<ApplyForItem>, t1> {
    public final /* synthetic */ ApplyForActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyForActivity$loadListData$1(ApplyForActivity applyForActivity) {
        super(1);
        this.this$0 = applyForActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m22invoke$lambda0(ApplyForActivity applyForActivity) {
        ListView f0;
        f0 = applyForActivity.f0();
        f0.Q(0, Boolean.FALSE);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(e<ApplyForItem> eVar) {
        invoke2(eVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@k.e.a.e e<ApplyForItem> eVar) {
        ListView f0;
        f0 = this.this$0.f0();
        final ApplyForActivity applyForActivity = this.this$0;
        f0.postDelayed(new Runnable() { // from class: e.l.q.b.e.a
            @Override // java.lang.Runnable
            public final void run() {
                ApplyForActivity$loadListData$1.m22invoke$lambda0(ApplyForActivity.this);
            }
        }, 100L);
    }
}
