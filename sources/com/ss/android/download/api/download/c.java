package com.ss.android.download.api.download;

import org.json.JSONObject;

@Deprecated
/* loaded from: classes3.dex */
public class c implements DownloadEventConfig {
    private String a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private String f5108c;

    /* renamed from: d  reason: collision with root package name */
    private String f5109d;

    /* renamed from: e  reason: collision with root package name */
    private String f5110e;

    /* renamed from: f  reason: collision with root package name */
    private String f5111f;

    /* renamed from: g  reason: collision with root package name */
    private String f5112g;

    /* renamed from: h  reason: collision with root package name */
    private String f5113h;

    /* renamed from: i  reason: collision with root package name */
    private String f5114i;

    /* renamed from: j  reason: collision with root package name */
    private String f5115j;

    /* renamed from: k  reason: collision with root package name */
    private String f5116k;

    /* renamed from: l  reason: collision with root package name */
    private Object f5117l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f5118m;
    private boolean n;
    private boolean o;
    private String p;
    private String q;

    /* loaded from: classes3.dex */
    public static final class a {
        private String a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private String f5119c;

        /* renamed from: d  reason: collision with root package name */
        private String f5120d;

        /* renamed from: e  reason: collision with root package name */
        private String f5121e;

        /* renamed from: f  reason: collision with root package name */
        private String f5122f;

        /* renamed from: g  reason: collision with root package name */
        private String f5123g;

        /* renamed from: h  reason: collision with root package name */
        private String f5124h;

        /* renamed from: i  reason: collision with root package name */
        private String f5125i;

        /* renamed from: j  reason: collision with root package name */
        private String f5126j;

        /* renamed from: k  reason: collision with root package name */
        private String f5127k;

        /* renamed from: l  reason: collision with root package name */
        private Object f5128l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f5129m;
        private boolean n;
        private boolean o;
        private String p;
        private String q;

        public c a() {
            return new c(this);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.a;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.f5111f;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.f5112g;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.f5108c;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.f5110e;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.f5109d;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.f5117l;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.q;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.f5115j;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.b;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.f5118m;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i2) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public c() {
    }

    private c(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.f5108c = aVar.f5119c;
        this.f5109d = aVar.f5120d;
        this.f5110e = aVar.f5121e;
        this.f5111f = aVar.f5122f;
        this.f5112g = aVar.f5123g;
        this.f5113h = aVar.f5124h;
        this.f5114i = aVar.f5125i;
        this.f5115j = aVar.f5126j;
        this.f5116k = aVar.f5127k;
        this.f5117l = aVar.f5128l;
        this.f5118m = aVar.f5129m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
    }
}
