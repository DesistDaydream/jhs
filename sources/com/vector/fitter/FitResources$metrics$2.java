package com.vector.fitter;

import android.util.DisplayMetrics;
import e.t.o.f;
import h.k2.u.a;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroid/util/DisplayMetrics;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class FitResources$metrics$2 extends Lambda implements a<DisplayMetrics> {
    public final /* synthetic */ FitResources this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitResources$metrics$2(FitResources fitResources) {
        super(0);
        this.this$0 = fitResources;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final DisplayMetrics invoke() {
        DisplayMetrics displayMetrics;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics = super/*android.content.res.Resources*/.getDisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        f.a.c(displayMetrics2, this.this$0.d());
        return displayMetrics2;
    }
}
