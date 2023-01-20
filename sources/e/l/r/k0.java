package e.l.r;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.activity.result.contract.ActivityResultContract;

/* loaded from: classes2.dex */
public final class k0 extends ActivityResultContract<String, Uri> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    @k.e.a.d
    public Intent createIntent(@k.e.a.d Context context, @k.e.a.d String str) {
        Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        return intent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    @k.e.a.e
    public Uri parseResult(int i2, @k.e.a.e Intent intent) {
        Uri data = intent == null ? null : intent.getData();
        if (i2 != -1 || data == null) {
            return null;
        }
        return data;
    }
}
