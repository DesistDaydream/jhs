package com.jihuanshe.ui.dialog;

import android.view.View;
import android.widget.EditText;
import com.eth.ext.FlowKt;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import e.g.d.a;
import e.l.n.c.v;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CommonReportDialog$onCommit$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CommonReportDialog this$0;

    /* renamed from: com.jihuanshe.ui.dialog.CommonReportDialog$onCommit$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ CommonReportDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CommonReportDialog commonReportDialog) {
            super(1);
            this.this$0 = commonReportDialog;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            e.l.h.j.b.e.e(this.this$0, R.string.report_success, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
            this.this$0.h();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonReportDialog$onCommit$1(CommonReportDialog commonReportDialog) {
        super(1);
        this.this$0 = commonReportDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        int i2;
        int i3;
        EditText et;
        i2 = this.this$0.v;
        if (i2 < 0) {
            e.l.h.j.b.e.f(this.this$0, "请先选择一个举报类型", (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
            return;
        }
        int uid = this.this$0.getUid();
        List<String> reasons = this.this$0.getReasons();
        i3 = this.this$0.v;
        et = this.this$0.getEt();
        BinderKt.p(BinderKt.f(a.j(a.g(FlowKt.c(((v) e.l.n.a.d(v.class, true, false, false, 60L, true)).e(uid, reasons.get(i3), et.getText().toString())), this.this$0, null, 2, null), null, new AnonymousClass1(this.this$0), 1, null), this.this$0.getContext()));
    }
}
