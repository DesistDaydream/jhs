package com.jihuanshe.ui.dialog;

import androidx.lifecycle.ViewModelProvider;
import com.jihuanshe.viewmodel.UploadViewModel;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EditProductDialog$viewModel$2 extends Lambda implements a<UploadViewModel> {
    public final /* synthetic */ EditProductDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditProductDialog$viewModel$2(EditProductDialog editProductDialog) {
        super(0);
        this.this$0 = editProductDialog;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final UploadViewModel invoke() {
        return (UploadViewModel) new ViewModelProvider(this.this$0).get(UploadViewModel.class);
    }
}
