package com.jihuanshe.ui.dialog;

import android.view.View;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardProductDialogFragment$onReportClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardProductDialogFragment this$0;

    /* renamed from: com.jihuanshe.ui.dialog.CardProductDialogFragment$onReportClick$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ CardProductDialogFragment this$0;

        /* renamed from: com.jihuanshe.ui.dialog.CardProductDialogFragment$onReportClick$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00991 extends Lambda implements l<String, t1> {
            public final /* synthetic */ CardProductDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00991(CardProductDialogFragment cardProductDialogFragment) {
                super(1);
                this.this$0 = cardProductDialogFragment;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(String str) {
                invoke2(str);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@e String str) {
                this.this$0.Q().setValue(str);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CardProductDialogFragment cardProductDialogFragment) {
            super(0);
            this.this$0 = cardProductDialogFragment;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            new ReportDialog(this.this$0.requireActivity(), new C00991(this.this$0)).y();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardProductDialogFragment$onReportClick$1(CardProductDialogFragment cardProductDialogFragment) {
        super(1);
        this.this$0 = cardProductDialogFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (this.this$0.F().getValue() == null) {
            return;
        }
        e.l.l.a.d(new AnonymousClass1(this.this$0));
    }
}
