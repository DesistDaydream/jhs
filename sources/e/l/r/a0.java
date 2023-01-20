package e.l.r;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;
import com.jihuanshe.ui.page.crop.MCropActivity;
import com.jihuanshe.utils.ClipInfo;
import com.jihuanshe.utils.ImagePickerKt;
import com.yalantis.ucrop.UCrop;
import h.t1;

/* loaded from: classes2.dex */
public final class a0 extends ActivityResultContract<ClipInfo, Uri> {
    private final float a;

    public a0(float f2) {
        this.a = f2;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @k.e.a.d
    /* renamed from: a */
    public Intent createIntent(@k.e.a.d Context context, @k.e.a.d ClipInfo clipInfo) {
        UCrop of = UCrop.of(clipInfo.getUri(), ImagePickerKt.c(context));
        UCrop.Options options = new UCrop.Options();
        options.setShowCropGrid(false);
        options.withAspectRatio(b(), 0.0f);
        options.getOptionBundle().putBoolean("is_min", clipInfo.getMin());
        t1 t1Var = t1.a;
        return of.withOptions(options).getIntent(context).setClass(context, MCropActivity.class);
    }

    public final float b() {
        return this.a;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    @k.e.a.e
    public Uri parseResult(int i2, @k.e.a.e Intent intent) {
        if (i2 == -1) {
            return UCrop.getOutput(intent);
        }
        return null;
    }
}
