package com.jihuanshe.ui.dialog;

import android.view.View;
import android.widget.EditText;
import com.donkingliang.labels.LabelsView;
import com.jihuanshe.R;
import com.jihuanshe.model.ImageErrorInfo;
import com.jihuanshe.net.api.FileInfo;
import com.vector.util.Res;
import e.l.h.j.b.e;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class BaseUploadInfoDialog$onClickSubmit$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ BaseUploadInfoDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseUploadInfoDialog$onClickSubmit$1(BaseUploadInfoDialog baseUploadInfoDialog) {
        super(1);
        this.this$0 = baseUploadInfoDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        LabelsView labelsView;
        EditText mEditText;
        labelsView = this.this$0.getLabelsView();
        List selectLabelDatas = labelsView.getSelectLabelDatas();
        if (selectLabelDatas.size() < 1) {
            e.f(this.this$0, Res.w(Res.a, R.string.card_choose_error, null, 2, null), (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (FileInfo fileInfo : this.this$0.getUpLoadData()) {
            String url = fileInfo.getUrl();
            if (url != null) {
                arrayList.add(url);
            }
        }
        l<ImageErrorInfo, t1> submit = this.this$0.getSubmit();
        mEditText = this.this$0.getMEditText();
        submit.invoke(new ImageErrorInfo((String) selectLabelDatas.get(0), mEditText.getText().toString(), arrayList));
        this.this$0.h();
    }
}
