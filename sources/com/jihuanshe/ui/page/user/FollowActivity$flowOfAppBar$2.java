package com.jihuanshe.ui.page.user;

import com.jihuanshe.ui.page.search.SearchActivityCreator;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FollowActivity$flowOfAppBar$2 extends Lambda implements a<t1> {
    public final /* synthetic */ FollowActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowActivity$flowOfAppBar$2(FollowActivity followActivity) {
        super(0);
        this.this$0 = followActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SearchActivityCreator.create(13).start(this.this$0);
    }
}
