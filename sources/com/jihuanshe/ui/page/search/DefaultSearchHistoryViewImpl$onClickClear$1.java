package com.jihuanshe.ui.page.search;

import android.app.Activity;
import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.UseDialog;
import com.vector.util.Res;
import e.n.p;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class DefaultSearchHistoryViewImpl$onClickClear$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ DefaultSearchHistoryViewImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSearchHistoryViewImpl$onClickClear$1(DefaultSearchHistoryViewImpl defaultSearchHistoryViewImpl) {
        super(1);
        this.this$0 = defaultSearchHistoryViewImpl;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Activity activity;
        activity = this.this$0.a;
        UseDialog useDialog = new UseDialog(activity);
        DefaultSearchHistoryViewImpl defaultSearchHistoryViewImpl = this.this$0;
        p leftButtonText = useDialog.getLeftButtonText();
        Res res = Res.a;
        leftButtonText.setValue(Res.w(res, R.string.common_cancel, null, 2, null));
        useDialog.getRightButtonText().setValue(Res.w(res, R.string.common_confirm, null, 2, null));
        useDialog.getContent().setValue(Res.w(res, R.string.search_delete_history, null, 2, null));
        useDialog.setOnClickLeftButton(new DefaultSearchHistoryViewImpl$onClickClear$1$1$1(useDialog));
        useDialog.setOnClickRightButton(new DefaultSearchHistoryViewImpl$onClickClear$1$1$2(useDialog, defaultSearchHistoryViewImpl));
        useDialog.y();
    }
}
