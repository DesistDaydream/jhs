package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: classes3.dex */
public class p implements com.ss.android.socialbase.downloader.downloader.m {
    private final a a;
    private final com.ss.android.socialbase.downloader.downloader.j b;

    /* renamed from: c  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.o f5788c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f5789d;

    public p() {
        this(false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.e(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean b(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.n(i2);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void c(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.f(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void d(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.g(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public long e(int i2) {
        DownloadInfo b;
        com.ss.android.socialbase.downloader.downloader.j jVar = this.b;
        if (jVar == null || (b = jVar.b(i2)) == null) {
            return 0L;
        }
        int chunkCount = b.getChunkCount();
        if (chunkCount <= 1) {
            return b.getCurBytes();
        }
        List<com.ss.android.socialbase.downloader.model.b> c2 = this.b.c(i2);
        if (c2 == null || c2.size() != chunkCount) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.i.f.b(c2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int f(int i2) {
        DownloadInfo d2;
        a aVar = this.a;
        if (aVar == null || (d2 = aVar.d(i2)) == null) {
            return 0;
        }
        return d2.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean g(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.a(i2);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public DownloadInfo h(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.d(i2);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<com.ss.android.socialbase.downloader.model.b> i(int i2) {
        return this.b.c(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void j(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.m(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void k(int i2) {
        com.ss.android.socialbase.downloader.c.a.a(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean l(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.k(i2);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int m(int i2) {
        return com.ss.android.socialbase.downloader.downloader.d.a().a(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean n(int i2) {
        return this.b.e(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void o(int i2) {
        this.b.d(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean p(int i2) {
        return this.b.f(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public z q(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.i(i2);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public af r(int i2) {
        a aVar = this.a;
        af h2 = aVar != null ? aVar.h(i2) : null;
        return h2 == null ? com.ss.android.socialbase.downloader.downloader.c.J() : h2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public IDownloadFileUriProvider s(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.j(i2);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void startService() {
    }

    public p(boolean z) {
        this.a = com.ss.android.socialbase.downloader.downloader.c.C();
        this.b = com.ss.android.socialbase.downloader.downloader.c.x();
        if (!z) {
            this.f5788c = com.ss.android.socialbase.downloader.downloader.c.y();
        } else {
            this.f5788c = com.ss.android.socialbase.downloader.downloader.c.z();
        }
        this.f5789d = com.ss.android.socialbase.downloader.g.a.c().b("service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i2, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> b(String str) {
        com.ss.android.socialbase.downloader.downloader.j jVar = this.b;
        if (jVar != null) {
            return jVar.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> c(String str) {
        com.ss.android.socialbase.downloader.downloader.j jVar = this.b;
        if (jVar != null) {
            return jVar.c(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> d() {
        com.ss.android.socialbase.downloader.downloader.j jVar = this.b;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean g() {
        com.ss.android.socialbase.downloader.downloader.o oVar;
        return this.f5789d && (oVar = this.f5788c) != null && oVar.a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void f() {
        this.b.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(List<String> list) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean c() {
        return com.ss.android.socialbase.downloader.downloader.c.O();
    }

    public void d(int i2, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.c(i2, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void c(int i2, boolean z) {
        com.ss.android.socialbase.downloader.downloader.d.a().a(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(List<String> list) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public DownloadInfo b(String str, String str2) {
        return h(com.ss.android.socialbase.downloader.downloader.c.a(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean c(DownloadInfo downloadInfo) {
        return this.b.a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> d(String str) {
        com.ss.android.socialbase.downloader.downloader.j jVar = this.b;
        if (jVar != null) {
            return jVar.d(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> e(String str) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> a(String str) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i2, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(i2, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean e() {
        return this.b.d();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int a(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.c.a(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i2, i3, iDownloadListener, fVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(i2, i3, iDownloadListener, fVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean b() {
        com.ss.android.socialbase.downloader.downloader.o oVar = this.f5788c;
        if (oVar != null) {
            return oVar.b();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i2, i3, iDownloadListener, fVar, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.o oVar = this.f5788c;
        if (oVar != null) {
            oVar.c(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean a = com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (a) {
            if (com.ss.android.socialbase.downloader.i.a.a(33554432)) {
                b(downloadInfo.getId(), true);
            } else {
                d(downloadInfo.getId(), true);
            }
        }
        return a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(DownloadInfo downloadInfo) {
        this.b.b(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        this.b.b(i2, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, Notification notification) {
        com.ss.android.socialbase.downloader.downloader.o oVar = this.f5788c;
        if (oVar != null) {
            oVar.a(i2, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.downloader.o oVar = this.f5788c;
        if (oVar != null) {
            oVar.a(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.o oVar = this.f5788c;
        if (oVar != null) {
            oVar.b(downloadTask);
        } else if (downloadTask != null) {
            com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        this.b.a(i2, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        this.b.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, long j2) {
        this.b.a(i2, i3, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, int i4, long j2) {
        this.b.a(i2, i3, i4, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, int i4, int i5) {
        this.b.a(i2, i3, i4, i5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(ak akVar) {
        com.ss.android.socialbase.downloader.downloader.c.a(akVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3) {
        if (com.ss.android.socialbase.downloader.downloader.c.e() != null) {
            for (ak akVar : com.ss.android.socialbase.downloader.downloader.c.e()) {
                if (akVar != null) {
                    akVar.a(i3, i2);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, z zVar) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i2, zVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, long j2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(i2, j2);
        }
    }
}
