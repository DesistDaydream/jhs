package com.vector.util;

import android.os.Environment;
import e.t.u.g;
import h.k2.u.a;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CachingEx$externalPath$2 extends Lambda implements a<String> {
    public static final CachingEx$externalPath$2 INSTANCE = new CachingEx$externalPath$2();

    public CachingEx$externalPath$2() {
        super(0);
    }

    @Override // h.k2.u.a
    public final String invoke() {
        File cacheDir;
        g gVar = g.a;
        if (gVar.r()) {
            if (gVar.p()) {
                cacheDir = e.t.a.b().getExternalCacheDir();
            } else if (gVar.r()) {
                cacheDir = Environment.getExternalStorageDirectory();
            } else {
                cacheDir = e.t.a.b().getCacheDir();
            }
        } else {
            cacheDir = e.t.a.b().getCacheDir();
        }
        if (cacheDir == null) {
            cacheDir = gVar.j();
        }
        return cacheDir.getPath();
    }
}
