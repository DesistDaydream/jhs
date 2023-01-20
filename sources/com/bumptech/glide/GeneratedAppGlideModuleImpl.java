package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.vector.network.image.glide.VectorGlideModule;
import e.b.a.c;
import e.b.a.d;
import e.b.a.o.a.a;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    private final VectorGlideModule a = new VectorGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.vector.network.image.glide.VectorGlideModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule");
        }
    }

    @Override // e.b.a.r.a, e.b.a.r.b
    public void a(@NonNull Context context, @NonNull d dVar) {
        this.a.a(context, dVar);
    }

    @Override // e.b.a.r.d, e.b.a.r.f
    public void b(@NonNull Context context, @NonNull c cVar, @NonNull Registry registry) {
        new a().b(context, cVar, registry);
        this.a.b(context, cVar, registry);
    }

    @Override // e.b.a.r.a
    public boolean c() {
        return this.a.c();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    public Set<Class<?>> d() {
        return Collections.emptySet();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    /* renamed from: f */
    public e.b.a.a e() {
        return new e.b.a.a();
    }
}
