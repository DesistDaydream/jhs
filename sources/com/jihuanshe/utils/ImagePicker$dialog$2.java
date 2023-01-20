package com.jihuanshe.utils;

import androidx.fragment.app.FragmentActivity;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.PictureDialog;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ImagePicker$dialog$2 extends Lambda implements h.k2.u.a<PictureDialog> {
    public final /* synthetic */ ImagePicker this$0;

    /* loaded from: classes2.dex */
    public static final class a implements PictureDialog.PListener {
        public final /* synthetic */ ImagePicker a;

        public a(ImagePicker imagePicker) {
            this.a = imagePicker;
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.input.PictureDialog.PListener
        public void onClickPhoto() {
            this.a.I();
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.input.PictureDialog.PListener
        public void onClickTakePhoto() {
            this.a.F();
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.input.PictureDialog.PListener
        public void onClickTakeVideo() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePicker$dialog$2(ImagePicker imagePicker) {
        super(0);
        this.this$0 = imagePicker;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @e
    public final PictureDialog invoke() {
        FragmentActivity n;
        n = this.this$0.n();
        if (n == null) {
            return null;
        }
        return new PictureDialog(n, new a(this.this$0), Boolean.FALSE);
    }
}
