package com.jihuanshe.ui.dialog;

import android.view.View;
import com.jihuanshe.R;
import e.l.h.j.b.e;
import e.l.r.u;
import e.t.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShareDialog$savePicture$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ShareDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDialog$savePicture$1(ShareDialog shareDialog) {
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
        if (u.a.d(a.b(), this.this$0.getBitmap()).length() > 0) {
            e.e(this.this$0, R.string.save_tips, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        }
    }
}
