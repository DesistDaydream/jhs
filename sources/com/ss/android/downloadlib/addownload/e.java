package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.m7.imkfsdk.utils.permission.PermissionConstants;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.c;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.g;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class e implements f, m.a {
    private static final String a = "e";
    private final m b;

    /* renamed from: c  reason: collision with root package name */
    private g f5300c;

    /* renamed from: d  reason: collision with root package name */
    private d f5301d;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<Context> f5302e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Integer, Object> f5303f;

    /* renamed from: g  reason: collision with root package name */
    private DownloadShortInfo f5304g;

    /* renamed from: h  reason: collision with root package name */
    private DownloadInfo f5305h;

    /* renamed from: i  reason: collision with root package name */
    private c f5306i;

    /* renamed from: j  reason: collision with root package name */
    private final IDownloadListener f5307j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5308k;

    /* renamed from: l  reason: collision with root package name */
    private long f5309l;

    /* renamed from: m  reason: collision with root package name */
    private long f5310m;
    private DownloadModel n;
    private DownloadEventConfig o;
    private DownloadController p;
    private SoftReference<OnItemClickListener> q;
    private boolean r;
    private final boolean s;
    private SoftReference<IDownloadButtonClickListener> t;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j2);
    }

    public e() {
        m mVar = new m(Looper.getMainLooper(), this);
        this.b = mVar;
        this.f5303f = new ConcurrentHashMap();
        this.f5307j = new g.a(mVar);
        this.f5310m = -1L;
        this.n = null;
        this.o = null;
        this.p = null;
        this.f5300c = new g(this);
        this.f5301d = new d(mVar);
        this.s = com.ss.android.socialbase.downloader.g.a.c().a("ttdownloader_callback_twice");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.f5302e;
        if (weakReference != null && weakReference.get() != null) {
            return this.f5302e.get();
        }
        return j.getContext();
    }

    private void k() {
        SoftReference<OnItemClickListener> softReference = this.q;
        if (softReference != null && softReference.get() != null) {
            this.q.get().onItemClick(this.n, l(), m());
            this.q = null;
            return;
        }
        j.b().a(getContext(), this.n, m(), l());
    }

    @NonNull
    private DownloadEventConfig l() {
        DownloadEventConfig downloadEventConfig = this.o;
        return downloadEventConfig == null ? new c.a().a() : downloadEventConfig;
    }

    @NonNull
    private DownloadController m() {
        if (this.p == null) {
            this.p = new com.ss.android.download.api.download.b();
        }
        return this.p;
    }

    private void n() {
        String str = a;
        com.ss.android.downloadlib.g.k.a(str, "pICD", null);
        if (this.f5300c.d(this.f5305h)) {
            com.ss.android.downloadlib.g.k.a(str, "pICD BC", null);
            f(false);
            return;
        }
        com.ss.android.downloadlib.g.k.a(str, "pICD IC", null);
        k();
    }

    private boolean o() {
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
            DownloadInfo downloadInfo = this.f5305h;
            if (downloadInfo == null) {
                return true;
            }
            if ((downloadInfo.getStatus() == -3 && this.f5305h.getCurBytes() <= 0) || this.f5305h.getStatus() == 0 || this.f5305h.getStatus() == -4) {
                return true;
            }
            return com.ss.android.socialbase.downloader.i.f.a(this.f5305h.getStatus(), this.f5305h.getSavePath(), this.f5305h.getName());
        }
        DownloadInfo downloadInfo2 = this.f5305h;
        if (downloadInfo2 == null) {
            return true;
        }
        return !(downloadInfo2.getStatus() == -3 || Downloader.getInstance(j.getContext()).canResume(this.f5305h.getId())) || this.f5305h.getStatus() == 0;
    }

    private void p() {
        c cVar = this.f5306i;
        if (cVar != null && cVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.f5306i.cancel(true);
        }
        c cVar2 = new c();
        this.f5306i = cVar2;
        com.ss.android.downloadlib.g.b.a(cVar2, this.n.getDownloadUrl(), this.n.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo q() {
        if (this.f5304g == null) {
            this.f5304g = new DownloadShortInfo();
        }
        return this.f5304g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final boolean z) {
        this.f5301d.a(new com.ss.android.downloadlib.addownload.b.e(this.f5310m, this.n, l(), m()));
        this.f5301d.a(0, 0L, 0L, new a() { // from class: com.ss.android.downloadlib.addownload.e.5
            @Override // com.ss.android.downloadlib.addownload.e.a
            public void a() {
                if (e.this.f5301d.a()) {
                    return;
                }
                e.this.h(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z) {
        for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(this.f5303f)) {
            downloadStatusChangeListener.onDownloadStart(this.n, m());
        }
        int a2 = this.f5300c.a(j.getContext(), this.f5307j);
        String str = a;
        com.ss.android.downloadlib.g.k.a(str, "beginDown id:" + a2, null);
        if (a2 != 0) {
            if (this.f5305h != null && !com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
                this.f5300c.a(this.f5305h, false);
            } else if (z) {
                this.f5300c.a();
            }
        } else {
            DownloadInfo a3 = new DownloadInfo.a(this.n.getDownloadUrl()).a();
            a3.setStatus(-1);
            a(a3);
            com.ss.android.downloadlib.d.a.a().a(this.f5310m, new BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.e.c.a().b("beginDown");
        }
        if (this.f5300c.a(c())) {
            com.ss.android.downloadlib.g.k.a(str, "beginDown IC id:" + a2, null);
            k();
        }
    }

    public boolean c() {
        DownloadInfo downloadInfo = this.f5305h;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public long d() {
        return this.f5309l;
    }

    public boolean e() {
        return j.i().optInt("quick_app_enable_switch", 0) == 0 && this.n.getQuickAppModel() != null && !TextUtils.isEmpty(this.n.getQuickAppModel().a()) && com.ss.android.downloadlib.addownload.c.a(this.f5305h) && com.ss.android.downloadlib.g.l.a(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.n.getQuickAppModel().a())));
    }

    public void f() {
        this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.e.1
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(e.this.f5303f)) {
                    downloadStatusChangeListener.onInstalled(e.this.q());
                }
            }
        });
    }

    public boolean i() {
        SoftReference<IDownloadButtonClickListener> softReference = this.t;
        if (softReference == null) {
            return false;
        }
        return h.a(this.n, softReference.get());
    }

    private boolean c(int i2) {
        if (e()) {
            int i3 = -1;
            String a2 = this.n.getQuickAppModel().a();
            if (i2 == 1) {
                i3 = 5;
            } else if (i2 == 2) {
                i3 = 4;
            }
            DownloadModel downloadModel = this.n;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(3);
            }
            boolean c2 = com.ss.android.downloadlib.g.i.c(j.getContext(), a2);
            if (c2) {
                com.ss.android.downloadlib.d.a.a().a(this.f5310m, i2);
                Message obtain = Message.obtain();
                obtain.what = i3;
                obtain.obj = Long.valueOf(this.n.getId());
                com.ss.android.downloadlib.addownload.c.a().a(this, i3, this.n);
            } else {
                com.ss.android.downloadlib.d.a.a().a(this.f5310m, false, 0);
            }
            return c2;
        }
        return false;
    }

    private void f(final boolean z) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        String str = a;
        com.ss.android.downloadlib.g.k.a(str, "pBCD", null);
        if (o()) {
            com.ss.android.downloadlib.addownload.b.e e2 = com.ss.android.downloadlib.addownload.b.f.a().e(this.f5310m);
            if (this.r) {
                if (i()) {
                    if (d(false) && (downloadController2 = e2.f5257d) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        a(z, true);
                        return;
                    }
                    return;
                }
                a(z, true);
                return;
            } else if (this.n.isAd() && (downloadController = e2.f5257d) != null && downloadController.enableShowComplianceDialog() && e2.b != null && com.ss.android.downloadlib.addownload.compliance.b.a().a(e2.b) && com.ss.android.downloadlib.addownload.compliance.b.a().a(e2)) {
                return;
            } else {
                a(z, true);
                return;
            }
        }
        com.ss.android.downloadlib.g.k.a(str, "pBCD continue download, status:" + this.f5305h.getStatus(), null);
        DownloadInfo downloadInfo = this.f5305h;
        if (downloadInfo != null && (downloadModel = this.n) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.f5305h.getStatus();
        final int id = this.f5305h.getId();
        final com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(this.f5305h);
        if (status != -2 && status != -1) {
            if (l.a(status)) {
                if (this.n.enablePause()) {
                    this.f5301d.a(true);
                    com.ss.android.downloadlib.c.h.a().b(com.ss.android.downloadlib.addownload.b.f.a().d(this.f5310m));
                    com.ss.android.downloadlib.addownload.d.f.a().a(a2, status, new com.ss.android.downloadlib.addownload.d.c() { // from class: com.ss.android.downloadlib.addownload.e.3
                        @Override // com.ss.android.downloadlib.addownload.d.c
                        public void a(com.ss.android.downloadad.api.a.b bVar) {
                            if (e.this.f5305h == null && com.ss.android.socialbase.downloader.g.a.c().a("fix_handle_pause")) {
                                e.this.f5305h = Downloader.getInstance(j.getContext()).getDownloadInfo(id);
                            }
                            e.this.f5300c.a(e.this.f5305h, z);
                            if (e.this.f5305h != null && com.ss.android.socialbase.downloader.i.f.b(j.getContext()) && e.this.f5305h.isPauseReserveOnWifi()) {
                                e.this.f5305h.stopPauseReserveOnWifi();
                                com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_cancel_on_wifi", a2);
                                return;
                            }
                            e eVar = e.this;
                            eVar.a(id, status, eVar.f5305h);
                        }
                    });
                    return;
                }
                return;
            }
            this.f5300c.a(this.f5305h, z);
            a(id, status, this.f5305h);
            return;
        }
        this.f5300c.a(this.f5305h, z);
        if (a2 != null) {
            a2.h(System.currentTimeMillis());
            a2.i(this.f5305h.getCurBytes());
        }
        this.f5305h.setDownloadFromReserveWifi(false);
        this.f5301d.a(new com.ss.android.downloadlib.addownload.b.e(this.f5310m, this.n, l(), m()));
        this.f5301d.a(id, this.f5305h.getCurBytes(), this.f5305h.getTotalBytes(), new a() { // from class: com.ss.android.downloadlib.addownload.e.2
            @Override // com.ss.android.downloadlib.addownload.e.a
            public void a() {
                if (e.this.f5301d.a()) {
                    return;
                }
                e eVar = e.this;
                eVar.a(id, status, eVar.f5305h);
            }
        });
    }

    public boolean d(boolean z) {
        SoftReference<IDownloadButtonClickListener> softReference = this.t;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z) {
                    this.t.get().handleComplianceDialog(true);
                } else {
                    this.t.get().handleMarketFailedComplianceDialog();
                }
                this.t = null;
                return true;
            } catch (Exception unused) {
                com.ss.android.downloadlib.e.c.a().b("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.ss.android.downloadlib.e.c.a().b("mDownloadButtonClickListener has recycled");
        return false;
    }

    public void g() {
        if (this.f5303f.size() == 0) {
            return;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(this.f5303f)) {
            downloadStatusChangeListener.onIdle();
        }
        DownloadInfo downloadInfo = this.f5305h;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(Context context) {
        if (context != null) {
            this.f5302e = new WeakReference<>(context);
        }
        j.b(context);
        return this;
    }

    /* loaded from: classes3.dex */
    public class c extends AsyncTask<String, Void, DownloadInfo> {
        private c() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr != null) {
                if (strArr.length < 1 || !TextUtils.isEmpty(strArr[0])) {
                    String str = strArr[0];
                    if (e.this.n != null && !TextUtils.isEmpty(e.this.n.getFilePath())) {
                        downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(str, e.this.n.getFilePath());
                    }
                    return downloadInfo == null ? com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), str) : downloadInfo;
                }
                return null;
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || e.this.n == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.b.c a = com.ss.android.downloadlib.g.l.a(e.this.n.getPackageName(), e.this.n.getVersionCode(), e.this.n.getVersionName());
                com.ss.android.downloadlib.addownload.b.h.a().a(e.this.n.getVersionCode(), a.b(), com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo));
                boolean a2 = a.a();
                if (downloadInfo != null && downloadInfo.getId() != 0 && (a2 || !Downloader.getInstance(j.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    Downloader.getInstance(j.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (e.this.f5305h == null || e.this.f5305h.getStatus() != -4) {
                        e.this.f5305h = downloadInfo;
                        if (e.this.s) {
                            Downloader.getInstance(j.getContext()).setMainThreadListener(e.this.f5305h.getId(), e.this.f5307j, false);
                        } else {
                            Downloader.getInstance(j.getContext()).setMainThreadListener(e.this.f5305h.getId(), e.this.f5307j);
                        }
                    } else {
                        e.this.f5305h = null;
                    }
                    e.this.f5300c.a(e.this.f5305h, e.this.q(), g.a(e.this.f5303f));
                } else {
                    if (downloadInfo != null && Downloader.getInstance(j.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        com.ss.android.socialbase.downloader.notification.b.a().f(downloadInfo.getId());
                        e.this.f5305h = null;
                    }
                    if (e.this.f5305h != null) {
                        Downloader.getInstance(j.getContext()).removeTaskMainListener(e.this.f5305h.getId());
                        if (e.this.s) {
                            Downloader.getInstance(e.this.getContext()).setMainThreadListener(e.this.f5305h.getId(), e.this.f5307j, false);
                        } else {
                            Downloader.getInstance(e.this.getContext()).setMainThreadListener(e.this.f5305h.getId(), e.this.f5307j);
                        }
                    }
                    if (!a2) {
                        for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(e.this.f5303f)) {
                            downloadStatusChangeListener.onIdle();
                        }
                        e.this.f5305h = null;
                    } else {
                        e eVar = e.this;
                        eVar.f5305h = new DownloadInfo.a(eVar.n.getDownloadUrl()).a();
                        e.this.f5305h.setStatus(-3);
                        e.this.f5300c.a(e.this.f5305h, e.this.q(), g.a(e.this.f5303f));
                    }
                }
                e.this.f5300c.c(e.this.f5305h);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void e(boolean z) {
        if (com.ss.android.downloadlib.g.e.b(this.n).b("notification_opt_2") == 1 && this.f5305h != null) {
            com.ss.android.socialbase.downloader.notification.b.a().f(this.f5305h.getId());
        }
        f(z);
    }

    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(int i2, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (j.i().optInt("back_use_softref_listener") == 1) {
                this.f5303f.put(Integer.valueOf(i2), downloadStatusChangeListener);
            } else {
                this.f5303f.put(Integer.valueOf(i2), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public boolean b() {
        return this.f5308k;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void b(int i2) {
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.f5300c.a(this.f5310m);
        if (!com.ss.android.downloadlib.addownload.b.f.a().e(this.f5310m).y()) {
            com.ss.android.downloadlib.e.c.a().a("handleDownload ModelBox !isStrictValid");
        }
        if (this.f5300c.a(getContext(), i2, this.r)) {
            return;
        }
        boolean c2 = c(i2);
        if (i2 == 1) {
            if (c2) {
                return;
            }
            String str = a;
            com.ss.android.downloadlib.g.k.a(str, "handleDownload id:" + this.f5310m + ",pIC:", null);
            c(true);
        } else if (i2 == 2 && !c2) {
            String str2 = a;
            com.ss.android.downloadlib.g.k.a(str2, "handleDownload id:" + this.f5310m + ",pBC:", null);
            b(true);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.ss.android.downloadlib.e.c.a().a("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.ss.android.downloadlib.e.c.a().a(false, "setDownloadModel id=0");
                if (com.ss.android.socialbase.downloader.g.a.c().a("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.b.f.a().a(downloadModel);
            this.f5310m = downloadModel.getId();
            this.n = downloadModel;
            if (h.a(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(this.f5310m);
                if (d2 != null && d2.l() != 3) {
                    d2.e(3L);
                    com.ss.android.downloadlib.addownload.b.i.a().a(d2);
                }
            }
        }
        return this;
    }

    public void c(boolean z) {
        if (z) {
            com.ss.android.downloadlib.d.a.a().a(this.f5310m, 1);
        }
        n();
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void h() {
        com.ss.android.downloadlib.addownload.b.f.a().f(this.f5310m);
    }

    public void b(boolean z) {
        e(z);
    }

    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(DownloadController downloadController) {
        JSONObject extra;
        this.p = downloadController;
        if (com.ss.android.downloadlib.g.e.b(this.n).b("force_auto_open") == 1) {
            m().setLinkMode(1);
        }
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_show_dialog") && (extra = this.n.getExtra()) != null && extra.optInt("subprocess") > 0) {
            m().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.b.f.a().a(this.f5310m, m());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(DownloadEventConfig downloadEventConfig) {
        this.o = downloadEventConfig;
        this.r = l().getDownloadScene() == 0;
        com.ss.android.downloadlib.addownload.b.f.a().a(this.f5310m, l());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public f a(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.q = null;
        } else {
            this.q = new SoftReference<>(onItemClickListener);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void a() {
        this.f5308k = true;
        com.ss.android.downloadlib.addownload.b.f.a().a(this.f5310m, l());
        com.ss.android.downloadlib.addownload.b.f.a().a(this.f5310m, m());
        this.f5300c.a(this.f5310m);
        p();
        if (j.i().optInt("enable_empty_listener", 1) == 1 && this.f5303f.get(Integer.MIN_VALUE) == null) {
            b(Integer.MIN_VALUE, new com.ss.android.download.api.config.a());
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public boolean a(int i2) {
        if (i2 == 0) {
            this.f5303f.clear();
        } else {
            this.f5303f.remove(Integer.valueOf(i2));
        }
        if (this.f5303f.isEmpty()) {
            this.f5308k = false;
            this.f5309l = System.currentTimeMillis();
            if (this.f5305h != null) {
                Downloader.getInstance(j.getContext()).removeTaskMainListener(this.f5305h.getId());
            }
            c cVar = this.f5306i;
            if (cVar != null && cVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.f5306i.cancel(true);
            }
            this.f5300c.a(this.f5305h);
            String str = a;
            StringBuilder sb = new StringBuilder();
            sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.f5305h;
            sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
            com.ss.android.downloadlib.g.k.a(str, sb.toString(), null);
            this.b.removeCallbacksAndMessages(null);
            this.f5304g = null;
            this.f5305h = null;
            return true;
        }
        if (this.f5303f.size() == 1 && this.f5303f.containsKey(Integer.MIN_VALUE)) {
            this.f5300c.b(this.f5305h);
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void a(boolean z) {
        if (this.f5305h != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.c.d b2 = com.ss.android.socialbase.appdownloader.d.j().b();
                if (b2 != null) {
                    b2.a(this.f5305h);
                }
                Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).cancel(this.f5305h.getId(), true);
                return;
            }
            Intent intent = new Intent(j.getContext(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.f5305h.getId());
            j.getContext().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public f a(long j2) {
        if (j2 != 0) {
            DownloadModel a2 = com.ss.android.downloadlib.addownload.b.f.a().a(j2);
            if (a2 != null) {
                this.n = a2;
                this.f5310m = j2;
                this.f5300c.a(j2);
            }
        } else {
            com.ss.android.downloadlib.e.c.a().a(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.g.m.a
    public void a(Message message) {
        if (message != null && this.f5308k && message.what == 3) {
            this.f5305h = (DownloadInfo) message.obj;
            this.f5300c.a(message, q(), this.f5303f);
        }
    }

    public void a(boolean z, final boolean z2) {
        if (z) {
            com.ss.android.downloadlib.d.a.a().a(this.f5310m, 2);
        }
        if (!com.ss.android.downloadlib.g.j.b(PermissionConstants.STORE) && !m().enableNewActivity()) {
            this.n.setFilePath(this.f5300c.b());
        }
        if (com.ss.android.downloadlib.g.e.c(this.n) == 0) {
            com.ss.android.downloadlib.g.k.a(a, "pBCD not start", null);
            this.f5300c.a(new s() { // from class: com.ss.android.downloadlib.addownload.e.4
                @Override // com.ss.android.download.api.config.s
                public void a() {
                    com.ss.android.downloadlib.g.k.a(e.a, "pBCD start download", null);
                    e.this.g(z2);
                }

                @Override // com.ss.android.download.api.config.s
                public void a(String str) {
                    com.ss.android.downloadlib.g.k.a(e.a, "pBCD onDenied", null);
                }
            });
            return;
        }
        g(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, @NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
            if (i3 != -3 && !com.ss.android.socialbase.downloader.downloader.d.a().e(i2)) {
                a(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), i2, i3);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), i2, i3);
    }

    private void a(DownloadInfo downloadInfo) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = downloadInfo;
        this.b.sendMessage(obtain);
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public f a(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.t = null;
        } else {
            this.t = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }
}
