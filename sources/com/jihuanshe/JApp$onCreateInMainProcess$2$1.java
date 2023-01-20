package com.jihuanshe;

import android.view.View;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class JApp$onCreateInMainProcess$2$1 extends Lambda implements a<t1> {
    public final /* synthetic */ View.OnClickListener $listener;
    public final /* synthetic */ View $v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JApp$onCreateInMainProcess$2$1(View.OnClickListener onClickListener, View view) {
        super(0);
        this.$listener = onClickListener;
        this.$v = view;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$listener.onClick(this.$v);
    }
}
