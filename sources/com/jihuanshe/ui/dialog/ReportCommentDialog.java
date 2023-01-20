package com.jihuanshe.ui.dialog;

import android.content.Context;
import com.jihuanshe.R;
import com.jihuanshe.model.ImageErrorInfo;
import com.jihuanshe.utils.ImagePicker;
import com.vector.util.Res;
import e.n.f;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class ReportCommentDialog extends BaseUploadInfoDialog {
    @d
    private final String J;
    @d
    private final String K;
    @d
    private final String L;

    public ReportCommentDialog(@d Context context, @d f<List<String>> fVar, @d ImagePicker imagePicker, @d l<? super ImageErrorInfo, t1> lVar) {
        super(context, fVar, imagePicker, lVar);
        Res res = Res.a;
        this.J = Res.w(res, R.string.report_title_text, null, 2, null);
        this.K = Res.w(res, R.string.report_desc_hint, null, 2, null);
        this.L = Res.w(res, R.string.report_upload_tips, null, 2, null);
    }

    @Override // com.jihuanshe.ui.dialog.BaseUploadInfoDialog
    @d
    public String getEditHint() {
        return this.K;
    }

    @Override // com.jihuanshe.ui.dialog.BaseUploadInfoDialog
    @d
    public String getTitleText() {
        return this.J;
    }

    @Override // com.jihuanshe.ui.dialog.BaseUploadInfoDialog
    @d
    public String getUploadTips() {
        return this.L;
    }
}
