package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.DownloadService;

/* loaded from: classes3.dex */
public class h extends com.ss.android.socialbase.downloader.downloader.a {

    /* renamed from: e  reason: collision with root package name */
    private static final String f5780e = "h";

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void a(Intent intent, int i2, int i3) {
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(f5780e, "onStartCommand");
        }
        if (!com.ss.android.socialbase.downloader.i.a.a(262144)) {
            this.b = true;
        }
        e();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void c() {
        if (com.ss.android.socialbase.downloader.i.a.a(262144)) {
            this.b = true;
            this.f5594d = false;
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(f5780e, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, DownloadService.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, DownloadService.class));
        this.b = false;
    }
}
