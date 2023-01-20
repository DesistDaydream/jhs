package e.b.a.p.m.h;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import e.b.a.p.k.s;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class d implements e.b.a.p.h<c> {
    private static final String a = "GifEncoder";

    @Override // e.b.a.p.h
    @NonNull
    public EncodeStrategy b(@NonNull e.b.a.p.f fVar) {
        return EncodeStrategy.SOURCE;
    }

    @Override // e.b.a.p.a
    /* renamed from: c */
    public boolean a(@NonNull s<c> sVar, @NonNull File file, @NonNull e.b.a.p.f fVar) {
        try {
            e.b.a.v.a.e(sVar.get().c(), file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable(a, 5)) {
                Log.w(a, "Failed to encode GIF drawable data", e2);
            }
            return false;
        }
    }
}
