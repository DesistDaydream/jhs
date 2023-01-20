package com.jihuanshe.ui.page.photo;

import android.content.Intent;
import android.net.Uri;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ChoosePhotoActivity$imagePicker$1 extends Lambda implements l<Uri, t1> {
    public final /* synthetic */ ChoosePhotoActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChoosePhotoActivity$imagePicker$1(ChoosePhotoActivity choosePhotoActivity) {
        super(1);
        this.this$0 = choosePhotoActivity;
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
        ChoosePhotoActivity choosePhotoActivity = this.this$0;
        Intent intent = new Intent();
        intent.putExtra("result", uri);
        t1 t1Var = t1.a;
        choosePhotoActivity.setResult(-1, intent);
        this.this$0.finish();
    }
}
