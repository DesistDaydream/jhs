package com.effective.android.panel.interfaces;

import h.k2.u.a;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0003\u001a\u00020\f2\u0010\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\u00020\tj\u0002`\n¢\u0006\u0004\b\u0003\u0010\rJ\u001f\u0010\u0005\u001a\u00020\f2\u0010\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\u00020\tj\u0002`\u000e¢\u0006\u0004\b\u0005\u0010\rJ\u001f\u0010\u0007\u001a\u00020\f2\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00060\tj\u0002`\u0010¢\u0006\u0004\b\u0007\u0010\rR$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tj\u0004\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tj\u0004\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/effective/android/panel/interfaces/PanelHeightMeasurerBuilder;", "Lcom/effective/android/panel/interfaces/PanelHeightMeasurer;", "", "getTargetPanelDefaultHeight", "()I", "getPanelTriggerId", "", "synchronizeKeyboardHeight", "()Z", "Lkotlin/Function0;", "Lcom/effective/android/panel/interfaces/GetTargetPanelDefaultHeight;", "getPanelDefaultHeight", "Lh/t1;", "(Lh/k2/u/a;)V", "Lcom/effective/android/panel/interfaces/GetPanelId;", "getPanelId", "Lcom/effective/android/panel/interfaces/SynchronizeKeyboardHeight;", "Lh/k2/u/a;", "<init>", "()V", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PanelHeightMeasurerBuilder implements PanelHeightMeasurer {
    private a<Integer> getPanelDefaultHeight;
    private a<Integer> getPanelId;
    private a<Boolean> synchronizeKeyboardHeight;

    @Override // com.effective.android.panel.interfaces.PanelHeightMeasurer
    public int getPanelTriggerId() {
        Integer invoke;
        a<Integer> aVar = this.getPanelId;
        if (aVar == null || (invoke = aVar.invoke()) == null) {
            return -1;
        }
        return invoke.intValue();
    }

    @Override // com.effective.android.panel.interfaces.PanelHeightMeasurer
    public int getTargetPanelDefaultHeight() {
        Integer invoke;
        a<Integer> aVar = this.getPanelDefaultHeight;
        if (aVar == null || (invoke = aVar.invoke()) == null) {
            return 0;
        }
        return invoke.intValue();
    }

    @Override // com.effective.android.panel.interfaces.PanelHeightMeasurer
    public boolean synchronizeKeyboardHeight() {
        Boolean invoke;
        a<Boolean> aVar = this.synchronizeKeyboardHeight;
        if (aVar == null || (invoke = aVar.invoke()) == null) {
            return true;
        }
        return invoke.booleanValue();
    }

    public final void getPanelTriggerId(@d a<Integer> aVar) {
        this.getPanelId = aVar;
    }

    public final void getTargetPanelDefaultHeight(@d a<Integer> aVar) {
        this.getPanelDefaultHeight = aVar;
    }

    public final void synchronizeKeyboardHeight(@d a<Boolean> aVar) {
        this.synchronizeKeyboardHeight = aVar;
    }
}
