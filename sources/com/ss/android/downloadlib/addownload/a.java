package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a implements m.a {
    private static final String a = "a";
    private static a b;

    /* renamed from: c  reason: collision with root package name */
    private m f5211c = new m(Looper.getMainLooper(), this);

    /* renamed from: d  reason: collision with root package name */
    private long f5212d;

    private a() {
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public void a(@NonNull DownloadInfo downloadInfo, long j2, long j3, String str, String str2, String str3, String str4) {
        com.ss.android.downloadlib.addownload.b.a aVar = new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), j2, j3, str, str2, str3, str4);
        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        if (a2.a("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.f.d.l() || com.ss.android.socialbase.appdownloader.f.d.m()) && com.ss.android.socialbase.downloader.i.j.a(j.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message obtainMessage = this.f5211c.obtainMessage(200, aVar);
                obtainMessage.arg1 = 2;
                this.f5211c.sendMessageDelayed(obtainMessage, a2.a("check_silent_install_interval", BaseConstants.Time.MINUTE));
                return;
            }
            com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(aVar.b);
            JSONObject jSONObject = new JSONObject();
            int i2 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i2 = 5;
            } catch (Exception unused) {
            }
            j.f().a(null, new BaseException(i2, jSONObject.toString()), i2);
            com.ss.android.downloadlib.d.a.a().a("embeded_ad", "ah_result", jSONObject, d2);
        }
        if (com.ss.android.downloadlib.g.e.c()) {
            long currentTimeMillis = System.currentTimeMillis() - this.f5212d;
            long d3 = com.ss.android.downloadlib.g.e.d();
            if (currentTimeMillis < com.ss.android.downloadlib.g.e.e()) {
                long e2 = com.ss.android.downloadlib.g.e.e() - currentTimeMillis;
                d3 += e2;
                this.f5212d = System.currentTimeMillis() + e2;
            } else {
                this.f5212d = System.currentTimeMillis();
            }
            m mVar = this.f5211c;
            mVar.sendMessageDelayed(mVar.obtainMessage(200, aVar), d3);
        }
    }

    private void a(com.ss.android.downloadlib.addownload.b.a aVar, int i2) {
        if (j.k() == null || j.k().a() || aVar == null) {
            return;
        }
        if (2 == i2) {
            com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(aVar.b);
            JSONObject jSONObject = new JSONObject();
            int i3 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.ss.android.downloadlib.g.l.d(j.getContext(), aVar.f5232d)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i3 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i3 = 5;
                }
            } catch (Exception unused) {
            }
            j.f().a(null, new BaseException(i3, jSONObject.toString()), i3);
            com.ss.android.downloadlib.d.a.a().a("embeded_ad", "ah_result", jSONObject, d2);
        }
        if (com.ss.android.downloadlib.g.l.d(j.getContext(), aVar.f5232d)) {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_installed", aVar.b);
        } else if (!com.ss.android.downloadlib.g.l.a(aVar.f5235g)) {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_file_lost", aVar.b);
        } else if (com.ss.android.downloadlib.addownload.a.a.a().a(aVar.f5232d)) {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_conflict_with_back_dialog", aVar.b);
        } else {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_install_start", aVar.b);
            com.ss.android.socialbase.appdownloader.d.a(j.getContext(), (int) aVar.a);
        }
    }

    @Override // com.ss.android.downloadlib.g.m.a
    public void a(Message message) {
        if (message.what != 200) {
            return;
        }
        a((com.ss.android.downloadlib.addownload.b.a) message.obj, message.arg1);
    }
}
