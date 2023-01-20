package e.l.q.a;

import android.view.View;
import com.jihuanshe.ui.dialog.CardCommentsDialog;

/* loaded from: classes2.dex */
public final /* synthetic */ class i implements View.OnFocusChangeListener {
    public static final /* synthetic */ i a = new i();

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        CardCommentsDialog.F(view, z);
    }
}
