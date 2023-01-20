package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.m;
import com.ss.android.socialbase.downloader.depend.ad;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class d {
    private static final String a = "d";
    private static volatile d b = null;

    /* renamed from: f */
    private static boolean f5440f = false;

    /* renamed from: g */
    private static boolean f5441g = false;

    /* renamed from: c */
    private String f5442c;

    /* renamed from: d */
    private String f5443d;

    /* renamed from: e */
    private DownloadReceiver f5444e;

    /* renamed from: h */
    private boolean f5445h = false;

    /* renamed from: i */
    private com.ss.android.socialbase.appdownloader.c.c f5446i;

    /* renamed from: j */
    private com.ss.android.socialbase.appdownloader.c.d f5447j;

    /* renamed from: k */
    private com.ss.android.socialbase.appdownloader.c.h f5448k;

    /* renamed from: l */
    private com.ss.android.socialbase.appdownloader.c.g f5449l;

    /* renamed from: m */
    private m f5450m;
    private com.ss.android.socialbase.appdownloader.c.f n;
    private j o;
    private ad p;
    private ag q;

    private d() {
    }

    public static d j() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    private void q() {
        if (f5441g) {
            return;
        }
        if (this.f5444e == null) {
            this.f5444e = new DownloadReceiver();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
            intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter2.addDataScheme("package");
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter3.addDataScheme("file");
            com.ss.android.socialbase.downloader.downloader.c.N().registerReceiver(this.f5444e, intentFilter);
            com.ss.android.socialbase.downloader.downloader.c.N().registerReceiver(this.f5444e, intentFilter2);
            com.ss.android.socialbase.downloader.downloader.c.N().registerReceiver(this.f5444e, intentFilter3);
            f5441g = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void r() {
        if (Build.VERSION.SDK_INT >= 21) {
            r.a(new r.b() { // from class: com.ss.android.socialbase.appdownloader.d.1
                {
                    d.this = this;
                }

                @Override // com.ss.android.socialbase.downloader.impls.r.b
                public void a(DownloadInfo downloadInfo, long j2, boolean z, int i2) {
                    RetryJobSchedulerService.a(downloadInfo, j2, z, i2);
                }
            });
        }
    }

    public com.ss.android.socialbase.appdownloader.c.d b() {
        return this.f5447j;
    }

    public com.ss.android.socialbase.appdownloader.c.h c() {
        return this.f5448k;
    }

    public String d() {
        return this.f5443d;
    }

    public com.ss.android.socialbase.appdownloader.c.f e() {
        return this.n;
    }

    public boolean f() {
        return com.ss.android.socialbase.downloader.g.a.b().optInt("package_flag_config", 1) == 1;
    }

    public j g() {
        return this.o;
    }

    public File h() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getGlobalSaveDir();
    }

    public String i() {
        return this.f5442c;
    }

    public m k() {
        return this.f5450m;
    }

    public com.ss.android.socialbase.appdownloader.c.g l() {
        return this.f5449l;
    }

    public com.ss.android.socialbase.downloader.downloader.r m() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener();
    }

    public ad n() {
        return this.p;
    }

    public ag o() {
        return this.q;
    }

    private void c(Context context) {
        if (context == null || f5440f) {
            return;
        }
        com.ss.android.socialbase.downloader.constants.e.a(AdBaseConstants.MIME_APK);
        com.ss.android.socialbase.downloader.downloader.c.a(context);
        com.ss.android.socialbase.downloader.downloader.c.a(new com.ss.android.socialbase.appdownloader.d.b());
        q();
        r();
        f5440f = true;
    }

    public void b(String str) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).setDefaultSavePath(str);
    }

    private DownloadInfo b(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList != null) {
            for (DownloadInfo downloadInfo : downloadInfoList) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    return downloadInfo;
                }
            }
            return null;
        }
        return null;
    }

    public com.ss.android.socialbase.appdownloader.c.c a() {
        return this.f5446i;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5443d = str;
    }

    public void a(j jVar) {
        this.o = jVar;
    }

    public List<DownloadInfo> b(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    @Deprecated
    public void a(Context context, String str, com.ss.android.socialbase.appdownloader.c.c cVar, com.ss.android.socialbase.appdownloader.c.d dVar, com.ss.android.socialbase.appdownloader.c.h hVar) {
        if (cVar != null) {
            this.f5446i = cVar;
        }
        if (dVar != null) {
            this.f5447j = dVar;
        }
        if (hVar != null) {
            this.f5448k = hVar;
        }
        c(context);
    }

    public static boolean a(Context context, int i2) {
        return c.a(context, i2, true) == 1;
    }

    public void a(Context context, int i2, int i3) {
        try {
            switch (i3) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i2);
                    break;
                case -3:
                    c.a(context, i2, true);
                    break;
                case -2:
                    Downloader.getInstance(context).resume(i2);
                    break;
                case 0:
                case 6:
                default:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    Downloader.getInstance(context).pause(i2);
                    break;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(25:37|(2:41|42)|45|(1:113)(1:52)|53|(2:59|(1:61)(19:62|63|(1:65)|66|(3:68|(2:71|69)|72)|73|74|75|(1:77)(1:110)|78|79|(6:84|(1:107)(1:88)|89|(1:93)|(1:(1:105)(1:104))|106)|108|(1:86)|107|89|(2:91|93)|(0)|106))|112|63|(0)|66|(0)|73|74|75|(0)(0)|78|79|(8:81|84|(0)|107|89|(0)|(0)|106)|108|(0)|107|89|(0)|(0)|106) */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0137 A[Catch: all -> 0x0388, TryCatch #2 {all -> 0x0388, blocks: (B:132:0x0010, B:135:0x0023, B:139:0x002c, B:141:0x003a, B:142:0x0042, B:144:0x004a, B:145:0x0053, B:148:0x005a, B:150:0x0066, B:153:0x0072, B:155:0x0080, B:156:0x0084, B:158:0x008b, B:161:0x0093, B:163:0x00a7, B:166:0x00c1, B:169:0x00da, B:171:0x00e0, B:175:0x00f1, B:177:0x00f7, B:179:0x00fd, B:181:0x0103, B:183:0x0109, B:185:0x0117, B:186:0x0131, B:188:0x0137, B:189:0x013c, B:191:0x0146, B:192:0x014a, B:194:0x0150, B:195:0x015a, B:201:0x0185, B:203:0x018b, B:209:0x0197, B:211:0x01a4, B:213:0x01b4, B:215:0x0328, B:217:0x0332, B:220:0x033d, B:222:0x0343, B:224:0x0349, B:226:0x0353, B:228:0x0359, B:229:0x0369), top: B:244:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0146 A[Catch: all -> 0x0388, TryCatch #2 {all -> 0x0388, blocks: (B:132:0x0010, B:135:0x0023, B:139:0x002c, B:141:0x003a, B:142:0x0042, B:144:0x004a, B:145:0x0053, B:148:0x005a, B:150:0x0066, B:153:0x0072, B:155:0x0080, B:156:0x0084, B:158:0x008b, B:161:0x0093, B:163:0x00a7, B:166:0x00c1, B:169:0x00da, B:171:0x00e0, B:175:0x00f1, B:177:0x00f7, B:179:0x00fd, B:181:0x0103, B:183:0x0109, B:185:0x0117, B:186:0x0131, B:188:0x0137, B:189:0x013c, B:191:0x0146, B:192:0x014a, B:194:0x0150, B:195:0x015a, B:201:0x0185, B:203:0x018b, B:209:0x0197, B:211:0x01a4, B:213:0x01b4, B:215:0x0328, B:217:0x0332, B:220:0x033d, B:222:0x0343, B:224:0x0349, B:226:0x0353, B:228:0x0359, B:229:0x0369), top: B:244:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0164 A[Catch: all -> 0x0185, TryCatch #1 {all -> 0x0185, blocks: (B:196:0x015e, B:198:0x0164, B:200:0x016f, B:199:0x016a), top: B:242:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x016a A[Catch: all -> 0x0185, TryCatch #1 {all -> 0x0185, blocks: (B:196:0x015e, B:198:0x0164, B:200:0x016f, B:199:0x016a), top: B:242:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0197 A[Catch: all -> 0x0388, TryCatch #2 {all -> 0x0388, blocks: (B:132:0x0010, B:135:0x0023, B:139:0x002c, B:141:0x003a, B:142:0x0042, B:144:0x004a, B:145:0x0053, B:148:0x005a, B:150:0x0066, B:153:0x0072, B:155:0x0080, B:156:0x0084, B:158:0x008b, B:161:0x0093, B:163:0x00a7, B:166:0x00c1, B:169:0x00da, B:171:0x00e0, B:175:0x00f1, B:177:0x00f7, B:179:0x00fd, B:181:0x0103, B:183:0x0109, B:185:0x0117, B:186:0x0131, B:188:0x0137, B:189:0x013c, B:191:0x0146, B:192:0x014a, B:194:0x0150, B:195:0x015a, B:201:0x0185, B:203:0x018b, B:209:0x0197, B:211:0x01a4, B:213:0x01b4, B:215:0x0328, B:217:0x0332, B:220:0x033d, B:222:0x0343, B:224:0x0349, B:226:0x0353, B:228:0x0359, B:229:0x0369), top: B:244:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0328 A[Catch: all -> 0x0388, TryCatch #2 {all -> 0x0388, blocks: (B:132:0x0010, B:135:0x0023, B:139:0x002c, B:141:0x003a, B:142:0x0042, B:144:0x004a, B:145:0x0053, B:148:0x005a, B:150:0x0066, B:153:0x0072, B:155:0x0080, B:156:0x0084, B:158:0x008b, B:161:0x0093, B:163:0x00a7, B:166:0x00c1, B:169:0x00da, B:171:0x00e0, B:175:0x00f1, B:177:0x00f7, B:179:0x00fd, B:181:0x0103, B:183:0x0109, B:185:0x0117, B:186:0x0131, B:188:0x0137, B:189:0x013c, B:191:0x0146, B:192:0x014a, B:194:0x0150, B:195:0x015a, B:201:0x0185, B:203:0x018b, B:209:0x0197, B:211:0x01a4, B:213:0x01b4, B:215:0x0328, B:217:0x0332, B:220:0x033d, B:222:0x0343, B:224:0x0349, B:226:0x0353, B:228:0x0359, B:229:0x0369), top: B:244:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x033b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.ss.android.socialbase.appdownloader.f r23) {
        /*
            Method dump skipped, instructions count: 946
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.d.a(com.ss.android.socialbase.appdownloader.f):int");
    }

    public void a(DownloadTask downloadTask, int i2, boolean z) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i2);
        }
        if (downloadInfo == null || !z) {
            return;
        }
        downloadInfo.setSavePathRedirected(z);
    }

    private List<com.ss.android.socialbase.downloader.model.c> a(List<com.ss.android.socialbase.downloader.model.c> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.a()) && !TextUtils.isEmpty(cVar.b())) {
                    if (cVar.a().equals("User-Agent")) {
                        z = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.model.c(cVar.a(), cVar.b()));
                }
            }
        }
        if (!z) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("User-Agent", com.ss.android.socialbase.appdownloader.b.a.a));
        }
        return arrayList;
    }

    public String a(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || c.c(str2)) ? str2 : AdBaseConstants.MIME_APK;
    }

    private z a(final com.ss.android.socialbase.appdownloader.c.e eVar) {
        if (eVar == null) {
            return null;
        }
        return new z() { // from class: com.ss.android.socialbase.appdownloader.d.4
            {
                d.this = this;
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public void a(int i2, DownloadInfo downloadInfo, String str, String str2) {
                if (i2 != 1 && i2 != 3) {
                    switch (i2) {
                        case 5:
                        case 6:
                        case 7:
                            break;
                        case 8:
                            eVar.a(i2, downloadInfo.getPackageName(), str, str2);
                            return;
                        case 9:
                            eVar.a(com.ss.android.socialbase.downloader.downloader.c.N(), str);
                            return;
                        case 10:
                            eVar.a(downloadInfo);
                            return;
                        default:
                            return;
                    }
                }
                eVar.a(i2, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public boolean a(boolean z) {
                return eVar.a(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public String a() {
                return eVar.a();
            }
        };
    }

    public DownloadInfo a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo a2 = a(context, str, h());
                if (a2 == null) {
                    a2 = a(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                }
                if (a2 == null) {
                    a2 = a(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (a2 == null) {
                    a2 = a(context, str, context.getFilesDir());
                }
                return (a2 == null && com.ss.android.socialbase.downloader.g.a.c().a("get_download_info_by_list")) ? b(context, str) : a2;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.c.a.b(a, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo a(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    public List<DownloadInfo> a(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public void a(com.ss.android.socialbase.appdownloader.c.g gVar) {
        this.f5449l = gVar;
    }

    public void a(com.ss.android.socialbase.downloader.downloader.r rVar) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).setReserveWifiStatusListener(rVar);
    }

    public void a(ad adVar) {
        this.p = adVar;
    }

    public void a(ag agVar) {
        this.q = agVar;
    }
}
