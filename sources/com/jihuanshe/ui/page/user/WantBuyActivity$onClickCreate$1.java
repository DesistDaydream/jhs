package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.ui.dialog.CreateListDialog;
import com.jihuanshe.viewmodel.user.WantBuyViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantBuyActivity$onClickCreate$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ WantBuyActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.WantBuyActivity$onClickCreate$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements p<String, Boolean, t1> {
        public final /* synthetic */ WantBuyActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.user.WantBuyActivity$onClickCreate$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01281 extends Lambda implements l<WantBuyList, t1> {
            public final /* synthetic */ WantBuyActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01281(WantBuyActivity wantBuyActivity) {
                super(1);
                this.this$0 = wantBuyActivity;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(WantBuyList wantBuyList) {
                invoke2(wantBuyList);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@e WantBuyList wantBuyList) {
                if (wantBuyList == null) {
                    return;
                }
                List<WantBuyList> value = ((WantBuyViewModel) this.this$0.L()).r0().getValue();
                List<WantBuyList> L5 = value == null ? null : CollectionsKt___CollectionsKt.L5(value);
                if (L5 == null) {
                    L5 = new ArrayList<>();
                }
                L5.add(wantBuyList);
                ((WantBuyViewModel) this.this$0.L()).r0().setValue(L5);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WantBuyActivity wantBuyActivity) {
            super(2);
            this.this$0 = wantBuyActivity;
        }

        @Override // h.k2.u.p
        public /* bridge */ /* synthetic */ t1 invoke(String str, Boolean bool) {
            invoke(str, bool.booleanValue());
            return t1.a;
        }

        public final void invoke(@d String str, boolean z) {
            BinderKt.p(BinderKt.k(a.j(((WantBuyViewModel) this.this$0.L()).q0(str), null, new C01281(this.this$0), 1, null), this.this$0, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantBuyActivity$onClickCreate$1(WantBuyActivity wantBuyActivity) {
        super(1);
        this.this$0 = wantBuyActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        WantBuyActivity wantBuyActivity = this.this$0;
        new CreateListDialog(wantBuyActivity, Boolean.FALSE, new AnonymousClass1(wantBuyActivity)).y();
    }
}
