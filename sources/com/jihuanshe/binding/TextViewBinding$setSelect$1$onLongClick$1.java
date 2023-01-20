package com.jihuanshe.binding;

import com.jihuanshe.utils.StringUtil;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class TextViewBinding$setSelect$1$onLongClick$1 extends Lambda implements a<t1> {
    public final /* synthetic */ SelectTextHelper $mSelectableTextHelper;
    public final /* synthetic */ TextViewBinding$setSelect$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextViewBinding$setSelect$1$onLongClick$1(TextViewBinding$setSelect$1 textViewBinding$setSelect$1, SelectTextHelper selectTextHelper) {
        super(0);
        this.this$0 = textViewBinding$setSelect$1;
        this.$mSelectableTextHelper = selectTextHelper;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StringUtil.a.a(this.this$0.a());
        this.$mSelectableTextHelper.reset();
    }
}
