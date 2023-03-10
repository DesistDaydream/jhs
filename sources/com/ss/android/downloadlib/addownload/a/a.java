package com.ss.android.downloadlib.addownload.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g;
import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {
    private static final String a = "a";
    private static a b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> f5213c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5214d = false;

    /* renamed from: e  reason: collision with root package name */
    private String f5215e;

    /* renamed from: f  reason: collision with root package name */
    private b f5216f;

    /* renamed from: com.ss.android.downloadlib.addownload.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0175a {
        void a();
    }

    private a() {
        b bVar = new b();
        this.f5216f = bVar;
        this.f5213c = bVar.a("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f5215e = "";
        } else if (TextUtils.equals(this.f5215e, str)) {
            this.f5215e = "";
        }
    }

    private boolean a(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC0175a interfaceC0175a) {
        if (downloadInfo == null) {
            try {
                if (this.f5213c.isEmpty()) {
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z2 = true;
            if (downloadInfo != null && this.f5213c.isEmpty()) {
                a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0175a);
                return true;
            }
            long lastModified = downloadInfo != null ? new File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
            CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> copyOnWriteArrayList = this.f5213c;
            ListIterator<com.ss.android.downloadlib.addownload.b.a> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z2 = false;
                    break;
                }
                com.ss.android.downloadlib.addownload.b.a previous = listIterator.previous();
                if (previous != null && !l.d(j.getContext(), previous.f5232d) && l.a(previous.f5235g)) {
                    if (new File(previous.f5235g).lastModified() >= lastModified) {
                        a(activity, previous, z, interfaceC0175a);
                    } else {
                        a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0175a);
                    }
                }
            }
            String str = a;
            k.a(str, "tryShowInstallDialog isShow:" + z2, null);
            return z2;
        }
        return false;
    }

    @MainThread
    public boolean a(Activity activity, boolean z, InterfaceC0175a interfaceC0175a) {
        if (j.i().optInt("disable_install_app_dialog") == 1 || this.f5214d) {
            return false;
        }
        return a(activity, a(activity), z, interfaceC0175a);
    }

    public void a(Context context, com.ss.android.downloadlib.addownload.b.a aVar, boolean z, InterfaceC0175a interfaceC0175a) {
        this.f5213c.clear();
        a(context, aVar, interfaceC0175a, z);
        this.f5214d = true;
        g.a(context).c();
        this.f5216f.b("sp_ad_install_back_dialog", "key_uninstalled_list");
        k.a(a, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo a(Context context) {
        long b2;
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            b2 = g.a(context).b();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (j.i().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK)) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
            long j2 = 0;
            for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                if (downloadInfo2 != null && !l.d(context, downloadInfo2.getPackageName()) && l.a(downloadInfo2.getTargetFilePath())) {
                    long lastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                    if (lastModified >= b2 && downloadInfo2.getExtra() != null) {
                        try {
                            if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j2 == 0 || lastModified > j2)) {
                                downloadInfo = downloadInfo2;
                                j2 = lastModified;
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
            return downloadInfo;
        }
        return null;
    }

    public void a(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        for (int i2 = 0; i2 < this.f5213c.size(); i2++) {
            com.ss.android.downloadlib.addownload.b.a aVar = this.f5213c.get(i2);
            if (aVar != null && aVar.b == j3) {
                this.f5213c.set(i2, new com.ss.android.downloadlib.addownload.b.a(j2, j3, j4, str, str2, str3, str4));
                this.f5216f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f5213c);
                return;
            }
        }
        this.f5213c.add(new com.ss.android.downloadlib.addownload.b.a(j2, j3, j4, str, str2, str3, str4));
        this.f5216f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f5213c);
    }

    private void a(final Context context, final com.ss.android.downloadlib.addownload.b.a aVar, final InterfaceC0175a interfaceC0175a, boolean z) {
        final com.ss.android.downloadad.api.a.b d2 = f.a().d(aVar.b);
        if (d2 == null) {
            com.ss.android.downloadlib.e.c.a().a("showBackInstallDialog nativeModel null");
            return;
        }
        com.ss.android.download.api.config.k c2 = j.c();
        b.a a2 = new b.a(context).a(z ? "??????????????????" : "????????????");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(aVar.f5233e) ? "?????????????????????" : aVar.f5233e;
        c2.b(a2.b(String.format("%1$s????????????????????????????????????", objArr)).c("????????????").d(z ? "????????????" : String.format("??????%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).a(false).a(l.a(context, aVar.f5235g)).a(new b.InterfaceC0170b() { // from class: com.ss.android.downloadlib.addownload.a.a.1
            @Override // com.ss.android.download.api.model.b.InterfaceC0170b
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("backdialog_install", d2);
                com.ss.android.socialbase.appdownloader.d.a(context, (int) aVar.a);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0170b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("backdialog_exit", d2);
                InterfaceC0175a interfaceC0175a2 = interfaceC0175a;
                if (interfaceC0175a2 != null) {
                    interfaceC0175a2.a();
                }
                a.this.b("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0170b
            public void c(DialogInterface dialogInterface) {
                a.this.b("");
            }
        }).a(1).a());
        com.ss.android.downloadlib.d.a.a().b("backdialog_show", d2);
        this.f5215e = aVar.f5232d;
    }

    public boolean a(String str) {
        return TextUtils.equals(this.f5215e, str);
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        if (j.i().optInt("enable_open_app_dialog", 0) == 1 && !bVar.Z() && bVar.q()) {
            bVar.k(true);
            TTDelegateActivity.a(bVar);
        }
    }
}
