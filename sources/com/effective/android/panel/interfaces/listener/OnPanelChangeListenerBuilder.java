package com.effective.android.panel.interfaces.listener;

import com.effective.android.panel.view.panel.IPanelView;
import h.k2.u.a;
import h.k2.u.l;
import h.k2.u.t;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJA\u0010\u0011\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00020\u0013j\u0002`\u0014¢\u0006\u0004\b\u0003\u0010\u0015J\u001f\u0010\u0005\u001a\u00020\u00022\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00020\u0013j\u0002`\u0016¢\u0006\u0004\b\u0005\u0010\u0015J6\u0010\b\u001a\u00020\u00022'\u0010\b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00020\u0017j\u0002`\u001b¢\u0006\u0004\b\b\u0010\u001cJ¡\u0001\u0010\u0011\u001a\u00020\u00022\u0091\u0001\u0010\u0011\u001a\u008c\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00020\u001dj\u0002`\u001f¢\u0006\u0004\b\u0011\u0010 R¥\u0001\u0010\u0011\u001a\u0090\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001dj\u0004\u0018\u0001`\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010!R$\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\"R$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013j\u0004\u0018\u0001`\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\"R;\u0010\b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017j\u0004\u0018\u0001`\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010#¨\u0006%"}, d2 = {"Lcom/effective/android/panel/interfaces/listener/OnPanelChangeListenerBuilder;", "Lcom/effective/android/panel/interfaces/listener/OnPanelChangeListener;", "Lh/t1;", "onKeyboard", "()V", "onNone", "Lcom/effective/android/panel/view/panel/IPanelView;", "panel", "onPanel", "(Lcom/effective/android/panel/view/panel/IPanelView;)V", "", "portrait", "", "oldWidth", "oldHeight", "width", "height", "onPanelSizeChange", "(Lcom/effective/android/panel/view/panel/IPanelView;ZIIII)V", "Lkotlin/Function0;", "Lcom/effective/android/panel/interfaces/listener/OnKeyboard;", "(Lh/k2/u/a;)V", "Lcom/effective/android/panel/interfaces/listener/OnNone;", "Lkotlin/Function1;", "Lh/k0;", "name", "view", "Lcom/effective/android/panel/interfaces/listener/OnPanel;", "(Lh/k2/u/l;)V", "Lkotlin/Function6;", "panelView", "Lcom/effective/android/panel/interfaces/listener/OnPanelSizeChange;", "(Lh/k2/u/t;)V", "Lh/k2/u/t;", "Lh/k2/u/a;", "Lh/k2/u/l;", "<init>", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class OnPanelChangeListenerBuilder implements OnPanelChangeListener {
    private a<t1> onKeyboard;
    private a<t1> onNone;
    private l<? super IPanelView, t1> onPanel;
    private t<? super IPanelView, ? super Boolean, ? super Integer, ? super Integer, ? super Integer, ? super Integer, t1> onPanelSizeChange;

    @Override // com.effective.android.panel.interfaces.listener.OnPanelChangeListener
    public void onKeyboard() {
        a<t1> aVar = this.onKeyboard;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    @Override // com.effective.android.panel.interfaces.listener.OnPanelChangeListener
    public void onNone() {
        a<t1> aVar = this.onNone;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    @Override // com.effective.android.panel.interfaces.listener.OnPanelChangeListener
    public void onPanel(@e IPanelView iPanelView) {
        l<? super IPanelView, t1> lVar = this.onPanel;
        if (lVar != null) {
            lVar.invoke(iPanelView);
        }
    }

    @Override // com.effective.android.panel.interfaces.listener.OnPanelChangeListener
    public void onPanelSizeChange(@e IPanelView iPanelView, boolean z, int i2, int i3, int i4, int i5) {
        t<? super IPanelView, ? super Boolean, ? super Integer, ? super Integer, ? super Integer, ? super Integer, t1> tVar = this.onPanelSizeChange;
        if (tVar != null) {
            tVar.invoke(iPanelView, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        }
    }

    public final void onKeyboard(@d a<t1> aVar) {
        this.onKeyboard = aVar;
    }

    public final void onNone(@d a<t1> aVar) {
        this.onNone = aVar;
    }

    public final void onPanel(@d l<? super IPanelView, t1> lVar) {
        this.onPanel = lVar;
    }

    public final void onPanelSizeChange(@d t<? super IPanelView, ? super Boolean, ? super Integer, ? super Integer, ? super Integer, ? super Integer, t1> tVar) {
        this.onPanelSizeChange = tVar;
    }
}
