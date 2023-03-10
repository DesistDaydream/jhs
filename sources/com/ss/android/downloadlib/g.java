package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes3.dex */
public class g {
    private static volatile g a;
    private final com.ss.android.download.api.a b;

    /* renamed from: c */
    private final f f5377c;

    /* renamed from: d */
    private final com.ss.android.downloadad.api.a f5378d;

    /* renamed from: e */
    private com.ss.android.downloadad.api.b f5379e;

    /* renamed from: f */
    private long f5380f;

    private g(Context context) {
        this.f5377c = f.a();
        this.b = new e();
        this.f5380f = System.currentTimeMillis();
        b(context);
        this.f5378d = a.a();
    }

    public static g a(final Context context) {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g unused = g.a = new g(context);
                        }
                    });
                }
            }
        }
        return a;
    }

    private void b(Context context) {
        j.a(context);
        Downloader.getInstance(j.getContext());
        com.ss.android.downloadlib.addownload.b.f.a().b();
        com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), "misc_config", new com.ss.android.downloadlib.c.g(), new com.ss.android.downloadlib.c.f(context), new c());
        com.ss.android.downloadlib.c.d dVar = new com.ss.android.downloadlib.c.d();
        com.ss.android.socialbase.appdownloader.d.j().a(dVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(dVar);
        com.ss.android.socialbase.appdownloader.d.j().a(new k());
        com.ss.android.socialbase.downloader.downloader.c.a(new com.ss.android.downloadlib.c.e());
        com.ss.android.socialbase.appdownloader.d.j().a(com.ss.android.downloadlib.f.c.a());
    }

    public f h() {
        return this.f5377c;
    }

    public com.ss.android.download.api.a a() {
        return this.b;
    }

    public DownloadInfo a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), str);
    }

    @MainThread
    public void a(final Context context, final int i2, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.4
            {
                g.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.h().a(context, i2, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    public void a(com.ss.android.download.api.download.a.a aVar) {
        h().a(aVar);
    }

    @MainThread
    public void a(final String str, final int i2) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.2
            {
                g.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.h().a(str, i2);
            }
        });
    }

    @MainThread
    public void a(final String str, final long j2, final int i2, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.6
            {
                g.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.h().a(str, j2, i2, downloadEventConfig, downloadController);
            }
        });
    }

    @MainThread
    public void a(final String str, final long j2, final int i2, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.7
            {
                g.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.h().a(str, j2, i2, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void a(final String str, final long j2, final int i2, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final OnItemClickListener onItemClickListener, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.5
            {
                g.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.h().a(str, j2, i2, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void a(final String str, final boolean z) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.3
            {
                g.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.h().a(str, z);
            }
        });
    }

    public long b() {
        return this.f5380f;
    }

    public void c() {
        this.f5380f = System.currentTimeMillis();
    }

    public com.ss.android.downloadad.api.a d() {
        return this.f5378d;
    }

    public com.ss.android.downloadad.api.b e() {
        if (this.f5379e == null) {
            this.f5379e = b.a();
        }
        return this.f5379e;
    }

    public String f() {
        return j.m();
    }

    public void g() {
        d.a().e();
    }
}
