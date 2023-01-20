package com.effective.android.panel.interfaces;

import h.k2.u.a;
import h.k2.u.l;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J4\u0010\u0004\u001a\u00020\f2%\u0010\u0004\u001a!\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00020\bj\u0002`\u000b¢\u0006\u0004\b\u0004\u0010\rJ\u001f\u0010\u0006\u001a\u00020\f2\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00020\u000ej\u0002`\u000f¢\u0006\u0004\b\u0006\u0010\u0010R9\u0010\u0004\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bj\u0004\u0018\u0001`\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011R$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/effective/android/panel/interfaces/ContentScrollMeasurerBuilder;", "Lcom/effective/android/panel/interfaces/ContentScrollMeasurer;", "", "defaultDistance", "getScrollDistance", "(I)I", "getScrollViewId", "()I", "Lkotlin/Function1;", "Lh/k0;", "name", "Lcom/effective/android/panel/interfaces/GetScrollDistance;", "Lh/t1;", "(Lh/k2/u/l;)V", "Lkotlin/Function0;", "Lcom/effective/android/panel/interfaces/GetScrollViewId;", "(Lh/k2/u/a;)V", "Lh/k2/u/l;", "Lh/k2/u/a;", "<init>", "()V", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ContentScrollMeasurerBuilder implements ContentScrollMeasurer {
    private l<? super Integer, Integer> getScrollDistance;
    private a<Integer> getScrollViewId;

    @Override // com.effective.android.panel.interfaces.ContentScrollMeasurer
    public int getScrollDistance(int i2) {
        Integer invoke;
        l<? super Integer, Integer> lVar = this.getScrollDistance;
        if (lVar == null || (invoke = lVar.invoke(Integer.valueOf(i2))) == null) {
            return 0;
        }
        return invoke.intValue();
    }

    @Override // com.effective.android.panel.interfaces.ContentScrollMeasurer
    public int getScrollViewId() {
        Integer invoke;
        a<Integer> aVar = this.getScrollViewId;
        if (aVar == null || (invoke = aVar.invoke()) == null) {
            return -1;
        }
        return invoke.intValue();
    }

    public final void getScrollDistance(@d l<? super Integer, Integer> lVar) {
        this.getScrollDistance = lVar;
    }

    public final void getScrollViewId(@d a<Integer> aVar) {
        this.getScrollViewId = aVar;
    }
}
