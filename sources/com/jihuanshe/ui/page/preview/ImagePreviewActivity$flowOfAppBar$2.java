package com.jihuanshe.ui.page.preview;

import android.content.Intent;
import com.jihuanshe.ui.widget.imagepreview.enitity.IThumbViewInfo;
import h.k2.u.a;
import h.t1;
import java.util.List;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ImagePreviewActivity$flowOfAppBar$2 extends Lambda implements a<t1> {
    public final /* synthetic */ ImagePreviewActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreviewActivity$flowOfAppBar$2(ImagePreviewActivity imagePreviewActivity) {
        super(0);
        this.this$0 = imagePreviewActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IThumbViewInfo iThumbViewInfo;
        ImagePreviewActivity imagePreviewActivity = this.this$0;
        Intent intent = new Intent();
        ImagePreviewActivity imagePreviewActivity2 = this.this$0;
        List list = imagePreviewActivity2.f4034m;
        String str = null;
        if (list != null && (iThumbViewInfo = (IThumbViewInfo) list.get(imagePreviewActivity2.U())) != null) {
            str = iThumbViewInfo.getUrl();
        }
        if (str == null) {
            str = "";
        }
        intent.putExtra("choose", str);
        t1 t1Var = t1.a;
        imagePreviewActivity.setResult(-1, intent);
        this.this$0.finish();
    }
}
