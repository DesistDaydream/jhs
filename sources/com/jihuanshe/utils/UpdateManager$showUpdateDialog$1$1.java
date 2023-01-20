package com.jihuanshe.utils;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import e.t.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class UpdateManager$showUpdateDialog$1$1 extends Lambda implements l<View, t1> {
    public static final UpdateManager$showUpdateDialog$1$1 INSTANCE = new UpdateManager$showUpdateDialog$1$1();

    public UpdateManager$showUpdateDialog$1$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse("https://a.app.qq.com/o/simple.jsp?pkgname=com.jihuanshe"));
        a.b().startActivity(intent);
    }
}
