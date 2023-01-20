package com.vector.network.image.glide;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DecodeFormat;
import com.caverock.androidsvg.SVG;
import e.b.a.l.c;
import e.b.a.p.k.x.k;
import e.b.a.p.k.y.g;
import e.b.a.p.k.y.i;
import e.b.a.p.k.y.l;
import e.b.a.r.a;
import e.b.a.t.h;
import e.t.r.a.j;
import e.t.r.a.m.c;
import h.t1;
import java.io.InputStream;
import k.e.a.d;
import kotlin.Metadata;
import okhttp3.OkHttpClient;

@c
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/vector/network/image/glide/VectorGlideModule;", "Lcom/bumptech/glide/module/AppGlideModule;", "()V", "applyOptions", "", "context", "Landroid/content/Context;", "builder", "Lcom/bumptech/glide/GlideBuilder;", "isManifestParsingEnabled", "", "registerComponents", "glide", "Lcom/bumptech/glide/Glide;", "registry", "Lcom/bumptech/glide/Registry;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class VectorGlideModule extends a {
    @Override // e.b.a.r.a, e.b.a.r.b
    public void a(@d Context context, @d e.b.a.d dVar) {
        dVar.j(new g(context, e.t.a.a().h(), e.t.a.a().d()));
        l a = new l.a(context).d(3.0f).g(2.0f).a();
        dVar.q(new i(a.d()));
        dVar.e(new k(a.b()));
        dVar.v(e.b.a.p.k.z.a.i().c(e.b.a.p.k.z.a.a() + 4).a());
        dVar.h(new h().E(DecodeFormat.PREFER_ARGB_8888));
    }

    @Override // e.b.a.r.d, e.b.a.r.f
    public void b(@d Context context, @d e.b.a.c cVar, @d Registry registry) {
        OkHttpClient a = e.t.r.a.m.d.a.a();
        a.dispatcher().setMaxRequestsPerHost(e.b.a.p.k.z.a.a() + 4);
        t1 t1Var = t1.a;
        registry.y(e.b.a.p.l.g.class, InputStream.class, new c.a(a));
        registry.x(SVG.class, PictureDrawable.class, new j()).c(InputStream.class, SVG.class, new e.t.r.a.i());
    }

    @Override // e.b.a.r.a
    public boolean c() {
        return false;
    }
}
