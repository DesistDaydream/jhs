package com.jihuanshe.ui.page.photo;

import android.view.View;
import com.jihuanshe.model.RecentPhoto;
import com.jihuanshe.ui.widget.imagepreview.GPreviewBuilder;
import com.jihuanshe.ui.widget.imagepreview.enitity.ImageViewInfo;
import com.jihuanshe.viewmodel.photo.RecentPhotoViewModel;
import h.a2.u;
import h.k2.u.p;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RecentPhotoFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ RecentPhotoFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentPhotoFragment$onItemClick$1(RecentPhotoFragment recentPhotoFragment) {
        super(2);
        this.this$0 = recentPhotoFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        ArrayList arrayList;
        List<RecentPhoto> value = ((RecentPhotoViewModel) this.this$0.T()).q0().getValue();
        if (value == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(u.Y(value, 10));
            for (RecentPhoto recentPhoto : value) {
                arrayList2.add(new ImageViewInfo(recentPhoto.getUrl()));
            }
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return;
        }
        GPreviewBuilder.b(this.this$0).f(arrayList).e(i2).j(true).q();
    }
}
