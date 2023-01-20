package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.donkingliang.labels.LabelsView;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.CommonReportDialog;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.Res;
import e.l.k.e4;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.g;
import h.k2.v.n0;
import h.m2.e;
import h.p2.n;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final class CommonReportDialog extends BaseDialog {
    public static final /* synthetic */ n<Object>[] B = {n0.r(new PropertyReference1Impl(n0.d(CommonReportDialog.class), "et", "getEt()Landroid/widget/EditText;"))};
    @d
    private final e A;
    private final int t;
    @d
    private final List<String> u;
    private int v;
    @k.e.a.e
    private TextView w;
    @d
    private final g x;
    @d
    private final LabelsView.c y;
    @d
    private final g z;

    public CommonReportDialog(int i2, @d Context context) {
        super(context);
        this.t = i2;
        Res res = Res.a;
        this.u = CollectionsKt__CollectionsKt.P(Res.w(res, R.string.report_reason_ad, null, 2, null), Res.w(res, R.string.report_reason_unkind, null, 2, null), Res.w(res, R.string.report_reason_tort, null, 2, null), Res.w(res, R.string.report_reason_sex, null, 2, null), Res.w(res, R.string.report_reason_country, null, 2, null), Res.w(res, R.string.report_reason_blood, null, 2, null), Res.w(res, R.string.report_reason_guilt, null, 2, null), Res.w(res, R.string.report_reason_gamble, null, 2, null), Res.w(res, R.string.report_reason_other, null, 2, null));
        this.v = -1;
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.x = dVar.a(new CommonReportDialog$onClose$1(this));
        this.y = new LabelsView.c() { // from class: e.l.q.a.k
            {
                CommonReportDialog.this = this;
            }

            @Override // com.donkingliang.labels.LabelsView.c
            public final void a(TextView textView, Object obj, int i3) {
                CommonReportDialog.F(CommonReportDialog.this, textView, obj, i3);
            }
        };
        this.z = dVar.a(new CommonReportDialog$onCommit$1(this));
        this.A = BindViewKt.p(this, R.id.descEt);
    }

    public static final void F(CommonReportDialog commonReportDialog, TextView textView, Object obj, int i2) {
        if (commonReportDialog.v == i2) {
            commonReportDialog.v = -1;
            if (textView != null) {
                textView.setSelected(false);
            }
            commonReportDialog.w = null;
            return;
        }
        commonReportDialog.v = i2;
        TextView textView2 = commonReportDialog.w;
        if (textView2 != null) {
            textView2.setSelected(false);
        }
        commonReportDialog.w = textView;
        textView.setSelected(true);
    }

    public final EditText getEt() {
        return (EditText) this.A.a(this, B[0]);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        e4 e2 = e4.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final LabelsView.c getOnClick() {
        return this.y;
    }

    @d
    public final g getOnClose() {
        return this.x;
    }

    @d
    public final g getOnCommit() {
        return this.z;
    }

    @d
    public final List<String> getReasons() {
        return this.u;
    }

    public final int getUid() {
        return this.t;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setMoveWithKeyboard(true);
        setGravity(80);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public k l(@d View view) {
        return new r(view);
    }
}
