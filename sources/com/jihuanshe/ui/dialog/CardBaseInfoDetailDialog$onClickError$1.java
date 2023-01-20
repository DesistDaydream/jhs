package com.jihuanshe.ui.dialog;

import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.jihuanshe.repo.ReportRepo;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardBaseInfoDetailDialog$onClickError$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardBaseInfoDetailDialog this$0;

    /* renamed from: com.jihuanshe.ui.dialog.CardBaseInfoDetailDialog$onClickError$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ CardBaseInfoDetailDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CardBaseInfoDetailDialog cardBaseInfoDetailDialog) {
            super(0);
            this.this$0 = cardBaseInfoDetailDialog;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Integer D = this.this$0.D();
            if (D == null) {
                return;
            }
            D.intValue();
            if (this.this$0.F() == null) {
                return;
            }
            CardErrorCorrectionDialogFragment.A.a(this.this$0.D().intValue(), this.this$0.F()).show(this.this$0.getChildFragmentManager(), "correct");
            ReportRepo.a.b(LifecycleOwnerKt.getLifecycleScope(this.this$0));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardBaseInfoDetailDialog$onClickError$1(CardBaseInfoDetailDialog cardBaseInfoDetailDialog) {
        super(1);
        this.this$0 = cardBaseInfoDetailDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        e.l.l.a.d(new AnonymousClass1(this.this$0));
    }
}
