package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class e implements com.ss.android.downloadad.api.a.a {
    public long a;
    public DownloadModel b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadEventConfig f5256c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadController f5257d;

    public e() {
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String a() {
        return this.b.getDownloadUrl();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long b() {
        return this.b.getId();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean c() {
        return this.b.isAd();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String d() {
        return this.b.getLogExtra();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String e() {
        return this.b.getPackageName();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String f() {
        if (this.b.getDeepLink() != null) {
            return this.b.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject g() {
        return this.b.getExtra();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int h() {
        if (this.f5257d.getDownloadMode() == 2) {
            return 2;
        }
        return this.b.getFunnelType();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String i() {
        return this.f5256c.getRefer();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String j() {
        return this.f5256c.getClickButtonTag();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject k() {
        return this.f5256c.getParamsJson();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long l() {
        return this.b.getExtraValue();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean m() {
        return this.f5256c.isEnableV3Event();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public List<String> n() {
        return this.b.getClickTrackUrl();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public Object o() {
        return this.f5256c.getExtraEventObject();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject p() {
        return this.f5256c.getExtraJson();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean q() {
        return this.f5257d.enableNewActivity();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject r() {
        return this.b.getDownloadSettings();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int s() {
        return 0;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int t() {
        return this.f5256c.getDownloadScene();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadModel u() {
        return this.b;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadEventConfig v() {
        return this.f5256c;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadController w() {
        return this.f5257d;
    }

    public boolean x() {
        DownloadModel downloadModel;
        if (this.a == 0 || (downloadModel = this.b) == null || this.f5256c == null || this.f5257d == null) {
            return true;
        }
        return downloadModel.isAd() && this.a <= 0;
    }

    public boolean y() {
        if (x()) {
            return false;
        }
        if (this.b.isAd()) {
            DownloadModel downloadModel = this.b;
            return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.f5256c instanceof AdDownloadEventConfig) && (this.f5257d instanceof AdDownloadController);
        }
        return this.b instanceof AdDownloadModel;
    }

    public e(long j2, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        this.a = j2;
        this.b = downloadModel;
        this.f5256c = downloadEventConfig;
        this.f5257d = downloadController;
    }
}
