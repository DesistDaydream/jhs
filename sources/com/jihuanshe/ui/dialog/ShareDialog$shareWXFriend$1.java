package com.jihuanshe.ui.dialog;

import android.view.View;
import com.jihuanshe.wxapi.WXTool;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShareDialog$shareWXFriend$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ShareDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDialog$shareWXFriend$1(ShareDialog shareDialog) {
        super(1);
        this.this$0 = shareDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        WXTool.a.j(this.this$0.getBitmap(), false);
    }
}
