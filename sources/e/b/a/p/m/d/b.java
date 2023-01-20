package e.b.a.p.m.d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;

/* loaded from: classes.dex */
public class b implements e.b.a.p.h<BitmapDrawable> {
    private final e.b.a.p.k.x.e a;
    private final e.b.a.p.h<Bitmap> b;

    public b(e.b.a.p.k.x.e eVar, e.b.a.p.h<Bitmap> hVar) {
        this.a = eVar;
        this.b = hVar;
    }

    @Override // e.b.a.p.h
    @NonNull
    public EncodeStrategy b(@NonNull e.b.a.p.f fVar) {
        return this.b.b(fVar);
    }

    @Override // e.b.a.p.a
    /* renamed from: c */
    public boolean a(@NonNull e.b.a.p.k.s<BitmapDrawable> sVar, @NonNull File file, @NonNull e.b.a.p.f fVar) {
        return this.b.a(new g(sVar.get().getBitmap(), this.a), file, fVar);
    }
}
