package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import e.l.k.s5;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.g;
import h.w;
import h.z;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class ShareDialog extends BaseDialog {
    @d
    private final w t;
    @d
    private final g u;
    @d
    private final g v;
    @d
    private final g w;
    @d
    private final g x;
    @d
    private final g y;

    public ShareDialog(@d Context context) {
        super(context);
        this.t = z.c(new ShareDialog$bitmap$2(this));
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.u = dVar.a(new ShareDialog$cancel$1(this));
        this.v = dVar.a(new ShareDialog$savePicture$1(this));
        this.w = dVar.a(new ShareDialog$shareWXFriend$1(this));
        this.x = dVar.a(new ShareDialog$shareWXCircle$1(this));
        this.y = dVar.a(ShareDialog$shareQQ$1.INSTANCE);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        s5 e2 = s5.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final Bitmap getBitmap() {
        return (Bitmap) this.t.getValue();
    }

    @d
    public final g getCancel() {
        return this.u;
    }

    @d
    public final g getSavePicture() {
        return this.v;
    }

    @d
    public final g getShareQQ() {
        return this.y;
    }

    @d
    public final g getShareWXCircle() {
        return this.x;
    }

    @d
    public final g getShareWXFriend() {
        return this.w;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setGravity(80);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public k l(@d View view) {
        return new r(view);
    }
}
