package com.vivo.push.d;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public final class d extends z {
    public d(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.i iVar = (com.vivo.push.b.i) oVar;
        String e2 = iVar.e();
        com.vivo.push.e.a().a(iVar.g(), iVar.h(), e2);
        if (TextUtils.isEmpty(iVar.g()) && !TextUtils.isEmpty(e2)) {
            com.vivo.push.e.a().a(e2);
        }
        com.vivo.push.m.b(new e(this, e2, iVar));
    }
}
