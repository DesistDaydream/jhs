package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;

/* loaded from: classes3.dex */
public class l implements e {
    private final i a;
    private final com.ss.android.socialbase.downloader.model.e b;

    /* renamed from: c  reason: collision with root package name */
    private final e f5685c;

    public l(DownloadInfo downloadInfo, b bVar, i iVar) throws BaseException {
        this.a = iVar;
        this.b = a(downloadInfo, iVar);
        this.f5685c = new h(bVar, this);
    }

    public e a() {
        return this.f5685c;
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) throws IOException {
        this.b.a(aVar.a, 0, aVar.f5646c);
        this.a.b(aVar.f5646c);
    }

    public void c() throws IOException {
        this.b.c();
    }

    public void d() {
        com.ss.android.socialbase.downloader.i.f.a(this.b);
    }

    public i e() {
        return this.a;
    }

    private com.ss.android.socialbase.downloader.model.e a(DownloadInfo downloadInfo, i iVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.e a = com.ss.android.socialbase.downloader.i.f.a(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("flush_buffer_size_byte", -1));
        try {
            a.a(iVar.e());
            return a;
        } catch (IOException e2) {
            throw new BaseException(1054, e2);
        }
    }

    public void b() throws IOException {
        this.b.b();
    }
}
