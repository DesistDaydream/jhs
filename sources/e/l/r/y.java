package e.l.r;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.content.FileProvider;
import com.jihuanshe.R;
import com.jihuanshe.utils.ImagePickerKt;
import com.vector.util.Res;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class y extends ActivityResultContract<String, Uri> {
    @k.e.a.e
    private Uri a;
    @k.e.a.e
    private Uri b;
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private File f14328c;

    private final void a(Context context) {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (externalStoragePublicDirectory == null) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            StringBuilder sb = new StringBuilder();
            String str = File.separator;
            sb.append(str);
            sb.append("DCIM");
            sb.append((Object) str);
            sb.append("Camera");
            sb.append((Object) str);
            externalStoragePublicDirectory = new File(externalStorageDirectory, sb.toString());
        }
        File file = null;
        if (!externalStoragePublicDirectory.isDirectory() && !externalStoragePublicDirectory.mkdirs() && (((externalStoragePublicDirectory = context.getExternalFilesDir(null)) == null || !externalStoragePublicDirectory.exists()) && (((externalStoragePublicDirectory = context.getFilesDir()) == null || !externalStoragePublicDirectory.exists()) && ((externalStoragePublicDirectory = context.getFilesDir()) == null || !externalStoragePublicDirectory.exists())))) {
            StringBuilder sb2 = new StringBuilder();
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append("data");
            sb2.append((Object) str2);
            sb2.append("data");
            sb2.append((Object) str2);
            sb2.append((Object) context.getPackageName());
            sb2.append((Object) str2);
            sb2.append("cache");
            sb2.append((Object) str2);
            externalStoragePublicDirectory = new File(sb2.toString());
            if (!externalStoragePublicDirectory.exists()) {
                externalStoragePublicDirectory.mkdirs();
            }
        }
        try {
            file = File.createTempFile("IMG", ".jpg", externalStoragePublicDirectory);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f14328c = file;
    }

    @k.e.a.e
    public final Uri b(@k.e.a.e Context context, @k.e.a.e File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, e.t.m.e.a(), file);
        }
        return Uri.fromFile(file);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    @k.e.a.d
    public Intent createIntent(@k.e.a.d Context context, @k.e.a.e String str) {
        Uri fromFile;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(context.getPackageManager()) == null && !context.getPackageManager().hasSystemFeature("android.hardware.camera.any")) {
            e.l.h.j.b.e.f(this, Res.w(Res.a, R.string.error_photo, null, 2, null), (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        } else {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                Uri b = ImagePickerKt.b(context);
                this.a = b;
                intent.putExtra("output", b);
                intent.addFlags(1);
                intent.addFlags(2);
                return intent;
            }
            a(context);
            File file = this.f14328c;
            boolean z = false;
            if (file != null && file.isFile()) {
                z = true;
            }
            if (!z) {
                e.l.h.j.b.e.f(this, Res.w(Res.a, R.string.error_photo, null, 2, null), (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
            } else {
                if (i2 >= 24) {
                    fromFile = FileProvider.getUriForFile(e.t.a.b(), e.t.m.e.a(), this.f14328c);
                } else {
                    fromFile = Uri.fromFile(this.f14328c);
                }
                intent.addFlags(1);
                intent.addFlags(2);
                intent.putExtra("output", fromFile);
                return intent;
            }
        }
        return new Intent();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    @k.e.a.e
    public Uri parseResult(int i2, @k.e.a.e Intent intent) {
        if (i2 == -1) {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.a;
            }
            return b(e.t.a.b(), this.f14328c);
        }
        return null;
    }
}
