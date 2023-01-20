package com.jihuanshe.ui.dialog;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.ActivityCompat;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.PosterDialog$onPosterClick$1;
import com.jihuanshe.utils.ImagePickerKt;
import com.m7.imkfsdk.utils.permission.PermissionConstants;
import com.vector.util.Res;
import e.l.h.j.b.e;
import e.l.r.u;
import e.q.a.c;
import e.q.a.g.p;
import e.q.a.g.r;
import e.t.a;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class PosterDialog$onPosterClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ PosterDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PosterDialog$onPosterClick$1(PosterDialog posterDialog) {
        super(1);
        this.this$0 = posterDialog;
    }

    /* renamed from: invoke$lambda-0 */
    public static final void m18invoke$lambda0(boolean z, PosterDialog posterDialog, p pVar, List list) {
        if (z) {
            return;
        }
        ImagePickerKt.e(posterDialog.requireActivity(), R.string.common_album, R.string.permission_album_desc, R.drawable.ic_svg_me);
    }

    /* renamed from: invoke$lambda-1 */
    public static final void m19invoke$lambda1(PosterDialog posterDialog, boolean z, List list, List list2) {
        ImageView E;
        if (z) {
            E = posterDialog.E();
            Drawable drawable = E.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                if (bitmapDrawable.getBitmap() != null && !bitmapDrawable.getBitmap().isRecycled()) {
                    if (u.a.d(a.b(), bitmapDrawable.getBitmap()).length() > 0) {
                        e.e(posterDialog, R.string.common_photo_save_success, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
                        return;
                    }
                }
                e.d(posterDialog, Res.w(Res.a, R.string.common_photo_save_error, null, 2, null), (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? 1 : 0, (r13 & 32) == 0 ? null : null);
            }
        }
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke */
    public final void invoke2(@d View view) {
        final boolean shouldShowRequestPermissionRationale = ActivityCompat.shouldShowRequestPermissionRationale(this.this$0.requireActivity(), "android.permission.READ_EXTERNAL_STORAGE");
        r b = c.a(this.this$0).b("android.permission.READ_EXTERNAL_STORAGE", PermissionConstants.STORE);
        final PosterDialog posterDialog = this.this$0;
        r n = b.n(new e.q.a.d.c() { // from class: e.l.q.a.o
            @Override // e.q.a.d.c
            public final void a(e.q.a.g.p pVar, List list) {
                PosterDialog$onPosterClick$1.m18invoke$lambda0(shouldShowRequestPermissionRationale, posterDialog, pVar, list);
            }
        });
        final PosterDialog posterDialog2 = this.this$0;
        n.p(new e.q.a.d.d() { // from class: e.l.q.a.p
            @Override // e.q.a.d.d
            public final void onResult(boolean z, List list, List list2) {
                PosterDialog$onPosterClick$1.m19invoke$lambda1(posterDialog2, z, list, list2);
            }
        });
    }
}
