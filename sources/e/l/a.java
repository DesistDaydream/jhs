package e.l;

import android.view.View;
import android.widget.PopupWindow;
import com.jihuanshe.JApp;
import com.tencent.qcloud.tuikit.tuichat.IRequest;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements IRequest {
    public static final /* synthetic */ a a = new a();

    @Override // com.tencent.qcloud.tuikit.tuichat.IRequest
    public final PopupWindow getCopyWindow(View view, View.OnClickListener onClickListener) {
        PopupWindow B;
        B = JApp.B(view, onClickListener);
        return B;
    }
}
