package e.b.a.p.m.d;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class y implements e.b.a.p.g<ParcelFileDescriptor, Bitmap> {
    private final o a;

    public y(o oVar) {
        this.a = oVar;
    }

    @Override // e.b.a.p.g
    @Nullable
    /* renamed from: c */
    public e.b.a.p.k.s<Bitmap> b(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, @NonNull e.b.a.p.f fVar) throws IOException {
        return this.a.d(parcelFileDescriptor, i2, i3, fVar);
    }

    @Override // e.b.a.p.g
    /* renamed from: d */
    public boolean a(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull e.b.a.p.f fVar) {
        return this.a.o(parcelFileDescriptor);
    }
}
