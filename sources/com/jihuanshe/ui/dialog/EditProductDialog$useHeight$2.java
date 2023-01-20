package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import e.t.o.d;
import h.k2.u.a;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EditProductDialog$useHeight$2 extends Lambda implements a<Integer> {
    public final /* synthetic */ EditProductDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditProductDialog$useHeight$2(EditProductDialog editProductDialog) {
        super(0);
        this.this$0 = editProductDialog;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Integer invoke2() {
        return Integer.valueOf(invoke());
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [int, java.lang.Integer] */
    @Override // h.k2.u.a
    public final Integer invoke() {
        Display defaultDisplay;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Context context = this.this$0.getContext();
        Object systemService = context == null ? null : context.getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels - d.a.c(d.a, null, 1, null).d(133);
    }
}
