package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: classes3.dex */
public class h implements e {
    private final e a;
    private final e b;

    public h(e eVar, e eVar2) {
        this.a = eVar;
        this.b = eVar2;
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) throws IOException {
        aVar.b = this.b;
        this.a.b(aVar);
    }
}
