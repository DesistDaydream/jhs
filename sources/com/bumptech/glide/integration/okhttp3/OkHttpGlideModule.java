package com.bumptech.glide.integration.okhttp3;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Registry;
import e.b.a.d;
import e.b.a.o.a.c;
import e.b.a.p.l.g;
import e.b.a.r.c;
import java.io.InputStream;

@Deprecated
/* loaded from: classes.dex */
public class OkHttpGlideModule implements c {
    @Override // e.b.a.r.b
    public void a(@NonNull Context context, @NonNull d dVar) {
    }

    @Override // e.b.a.r.f
    public void b(Context context, e.b.a.c cVar, Registry registry) {
        registry.y(g.class, InputStream.class, new c.a());
    }
}
