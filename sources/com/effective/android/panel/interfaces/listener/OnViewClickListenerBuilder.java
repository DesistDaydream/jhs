package com.effective.android.panel.interfaces.listener;

import android.view.View;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J6\u0010\u0005\u001a\u00020\u00042'\u0010\u0005\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\n¢\u0006\u0004\b\u0005\u0010\u000bR;\u0010\u0005\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007j\u0004\u0018\u0001`\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/effective/android/panel/interfaces/listener/OnViewClickListenerBuilder;", "Lcom/effective/android/panel/interfaces/listener/OnViewClickListener;", "Landroid/view/View;", "view", "Lh/t1;", "onClickBefore", "(Landroid/view/View;)V", "Lkotlin/Function1;", "Lh/k0;", "name", "Lcom/effective/android/panel/interfaces/listener/OnClickBefore;", "(Lh/k2/u/l;)V", "Lh/k2/u/l;", "<init>", "()V", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class OnViewClickListenerBuilder implements OnViewClickListener {
    private l<? super View, t1> onClickBefore;

    @Override // com.effective.android.panel.interfaces.listener.OnViewClickListener
    public void onClickBefore(@e View view) {
        l<? super View, t1> lVar = this.onClickBefore;
        if (lVar != null) {
            lVar.invoke(view);
        }
    }

    public final void onClickBefore(@d l<? super View, t1> lVar) {
        this.onClickBefore = lVar;
    }
}
