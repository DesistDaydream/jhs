package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import e.l.k.m3;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class BackProductDialog$onChooseReason$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ BackProductDialog this$0;

    /* renamed from: com.jihuanshe.ui.dialog.BackProductDialog$onChooseReason$1$1 */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<String, t1> {
        public final /* synthetic */ BackProductDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BackProductDialog backProductDialog) {
            super(1);
            this.this$0 = backProductDialog;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(String str) {
            invoke2(str);
            return t1.a;
        }

        /* renamed from: invoke */
        public final void invoke2(@d String str) {
            m3 binding = this.this$0.getBinding();
            TextView textView = binding == null ? null : binding.f13107g;
            if (textView == null) {
                return;
            }
            textView.setText(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackProductDialog$onChooseReason$1(Context context, BackProductDialog backProductDialog) {
        super(1);
        this.$context = context;
        this.this$0 = backProductDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke */
    public final void invoke2(@d View view) {
        new BackGoodReasonDialog(this.$context, new AnonymousClass1(this.this$0)).y();
    }
}
