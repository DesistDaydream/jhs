package com.jihuanshe.ui.page.login;

import android.net.Uri;
import com.jihuanshe.R;
import com.jihuanshe.utils.ImagePickerKt;
import com.vector.util.Res;
import com.yalantis.ucrop.UCrop;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LoginActivity$imagePicker$1 extends Lambda implements l<Uri, t1> {
    public final /* synthetic */ LoginActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginActivity$imagePicker$1(LoginActivity loginActivity) {
        super(1);
        this.this$0 = loginActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Uri uri) {
        invoke2(uri);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Uri uri) {
        if (uri == null) {
            return;
        }
        Uri c2 = ImagePickerKt.c(this.this$0);
        if (c2 == null) {
            e.l.h.j.b.e.h(this.this$0, Res.w(Res.a, R.string.error_photo, null, 2, null), null, null, null, 0, null, 62, null);
            return;
        }
        UCrop of = UCrop.of(uri, c2);
        UCrop.Options options = new UCrop.Options();
        options.setHideBottomControls(true);
        options.setStatusBarColor(-1);
        t1 t1Var = t1.a;
        of.withOptions(options).withAspectRatio(1.0f, 1.0f).start(this.this$0);
    }
}
