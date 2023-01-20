package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import h.k2.u.a;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class BaseDialog$layoutInflater$2 extends Lambda implements a<LayoutInflater> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDialog$layoutInflater$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    public final LayoutInflater invoke() {
        return LayoutInflater.from(this.$context);
    }
}
