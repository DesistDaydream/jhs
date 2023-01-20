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
public final class BaseUploadInfoDialogFragment$onClickSubmit$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ BaseUploadInfoDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseUploadInfoDialogFragment$onClickSubmit$1(BaseUploadInfoDialogFragment baseUploadInfoDialogFragment) {
        super(1);
        this.this$0 = baseUploadInfoDialogFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        LabelsView M;
        EditText O;
        M = this.this$0.M();
        List selectLabelDatas = M.getSelectLabelDatas();
        if (selectLabelDatas.size() < 1) {
            e.d(this.this$0, Res.w(Res.a, R.string.card_choose_error, null, 2, null), (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? 1 : 0, (r13 & 32) == 0 ? null : null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (FileInfo fileInfo : this.this$0.X()) {
            String url = fileInfo.getUrl();
            if (url != null) {
                arrayList.add(url);
            }
        }
        BaseUploadInfoDialogFragment baseUploadInfoDialogFragment = this.this$0;
        O = this.this$0.O();
        baseUploadInfoDialogFragment.d0(new ImageErrorInfo((String) selectLabelDatas.get(0), O.getText().toString(), arrayList));
    }
}
