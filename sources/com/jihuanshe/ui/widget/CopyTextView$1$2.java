package com.jihuanshe.ui.widget;

import com.jihuanshe.utils.StringUtil;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CopyTextView$1$2 extends Lambda implements a<t1> {
    public final /* synthetic */ CopyTextView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CopyTextView$1$2(CopyTextView copyTextView) {
        super(0);
        this.this$0 = copyTextView;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StringUtil.a.a(this.this$0.getText().toString());
    }
}
