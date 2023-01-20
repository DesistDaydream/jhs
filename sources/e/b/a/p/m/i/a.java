package e.b.a.p.m.i;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.p.k.s;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class a implements e<Bitmap, byte[]> {
    private final Bitmap.CompressFormat a;
    private final int b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // e.b.a.p.m.i.e
    @Nullable
    public s<byte[]> a(@NonNull s<Bitmap> sVar, @NonNull e.b.a.p.f fVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        sVar.get().compress(this.a, this.b, byteArrayOutputStream);
        sVar.recycle();
        return new e.b.a.p.m.e.b(byteArrayOutputStream.toByteArray());
    }

    public a(@NonNull Bitmap.CompressFormat compressFormat, int i2) {
        this.a = compressFormat;
        this.b = i2;
    }
}
