package com.effective.android.panel.interfaces.listener;

import android.view.View;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJK\u0010\u0007\u001a\u00020\u00062<\u0010\u0007\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\tj\u0002`\f¢\u0006\u0004\b\u0007\u0010\rRP\u0010\u0007\u001a<\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tj\u0004\u0018\u0001`\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/effective/android/panel/interfaces/listener/OnEditFocusChangeListenerBuilder;", "Lcom/effective/android/panel/interfaces/listener/OnEditFocusChangeListener;", "Landroid/view/View;", "view", "", "hasFocus", "Lh/t1;", "onFocusChange", "(Landroid/view/View;Z)V", "Lkotlin/Function2;", "Lh/k0;", "name", "Lcom/effective/android/panel/interfaces/listener/OnFocusChange;", "(Lh/k2/u/p;)V", "Lh/k2/u/p;", "<init>", "()V", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class OnEditFocusChangeListenerBuilder implements OnEditFocusChangeListener {
    private p<? super View, ? super Boolean, t1> onFocusChange;

    @Override // com.effective.android.panel.interfaces.listener.OnEditFocusChangeListener
    public void onFocusChange(@e View view, boolean z) {
        p<? super View, ? super Boolean, t1> pVar = this.onFocusChange;
        if (pVar != null) {
            pVar.invoke(view, Boolean.valueOf(z));
        }
    }

    public final void onFocusChange(@d p<? super View, ? super Boolean, t1> pVar) {
        this.onFocusChange = pVar;
    }
}
