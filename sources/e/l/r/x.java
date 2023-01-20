package e.l.r;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;
import com.jihuanshe.ui.page.camera.CaptureActivity;
import com.jihuanshe.ui.page.camera.CaptureActivityCreator;

/* loaded from: classes2.dex */
public final class x extends ActivityResultContract<String, Uri> {
    private final float a;

    public x(float f2) {
        this.a = f2;
    }

    public final float a() {
        return this.a;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @k.e.a.d
    public Intent createIntent(@k.e.a.d Context context, @k.e.a.e String str) {
        return CaptureActivityCreator.newIntent(context, Float.valueOf(this.a), null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    @k.e.a.e
    public Uri parseResult(int i2, @k.e.a.e Intent intent) {
        if (i2 != -1 || intent == null) {
            return null;
        }
        return (Uri) intent.getParcelableExtra(CaptureActivity.s.a());
    }
}
