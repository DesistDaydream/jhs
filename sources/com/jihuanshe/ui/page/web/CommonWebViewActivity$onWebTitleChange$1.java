package com.jihuanshe.ui.page.web;

import e.l.s.p.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class CommonWebViewActivity$onWebTitleChange$1 extends Lambda implements l<String, t1> {
    public final /* synthetic */ CommonWebViewActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonWebViewActivity$onWebTitleChange$1(CommonWebViewActivity commonWebViewActivity) {
        super(1);
        this.this$0 = commonWebViewActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d String str) {
        String value = ((a) this.this$0.L()).C0().getValue();
        if (value == null || value.length() == 0) {
            if (!StringsKt__StringsKt.V2(str, "http", false, 2, null) || StringsKt__StringsKt.V2(str, com.baidu.mobads.sdk.internal.a.f1401f, false, 2, null)) {
                ((a) this.this$0.L()).C0().setValue(str);
            }
        }
    }
}
