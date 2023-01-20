package com.ss.android.socialbase.appdownloader.e;

import android.content.Context;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes3.dex */
public class b extends com.ss.android.socialbase.downloader.depend.d {
    private Context a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private String f5459c;

    /* renamed from: d  reason: collision with root package name */
    private String f5460d;

    /* renamed from: e  reason: collision with root package name */
    private String f5461e;

    /* renamed from: f  reason: collision with root package name */
    private String f5462f;

    /* renamed from: g  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.notification.a f5463g;

    public b(Context context, int i2, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.a = context.getApplicationContext();
        } else {
            this.a = com.ss.android.socialbase.downloader.downloader.c.N();
        }
        this.b = i2;
        this.f5459c = str;
        this.f5460d = str2;
        this.f5461e = str3;
        this.f5462f = str4;
    }

    @Override // com.ss.android.socialbase.downloader.depend.d
    public com.ss.android.socialbase.downloader.notification.a a() {
        Context context;
        com.ss.android.socialbase.downloader.notification.a aVar = this.f5463g;
        return (aVar != null || (context = this.a) == null) ? aVar : new a(context, this.b, this.f5459c, this.f5460d, this.f5461e, this.f5462f);
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null || this.a == null || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onFailed(downloadInfo, baseException);
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPause(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPrepare(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onProgress(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onStart(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.a == null) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.onSuccessed(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            com.ss.android.socialbase.appdownloader.f.b.a(downloadInfo);
        }
    }

    public b(com.ss.android.socialbase.downloader.notification.a aVar) {
        this.a = com.ss.android.socialbase.downloader.downloader.c.N();
        this.f5463g = aVar;
    }
}
