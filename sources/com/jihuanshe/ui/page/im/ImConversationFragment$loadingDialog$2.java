package com.jihuanshe.ui.page.im;

import e.t.k.a.f.h;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ImConversationFragment$loadingDialog$2 extends Lambda implements a<h> {
    public final /* synthetic */ ImConversationFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImConversationFragment$loadingDialog$2(ImConversationFragment imConversationFragment) {
        super(0);
        this.this$0 = imConversationFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final h invoke() {
        return new h(this.this$0.requireActivity(), false, 2, null);
    }
}
