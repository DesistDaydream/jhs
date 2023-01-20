package com.jihuanshe.ui.page.user;

import android.widget.TextView;
import h.k2.u.p;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FollowActivity$onEditAction$1 extends Lambda implements p<TextView, Integer, Boolean> {
    public final /* synthetic */ FollowActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowActivity$onEditAction$1(FollowActivity followActivity) {
        super(2);
        this.this$0 = followActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num) {
        return Boolean.valueOf(invoke(textView, num.intValue()));
    }

    public final boolean invoke(@d TextView textView, int i2) {
        if (i2 == 3) {
            this.this$0.c0().a().invoke(textView);
            return true;
        }
        return true;
    }
}
