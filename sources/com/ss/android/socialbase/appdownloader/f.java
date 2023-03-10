package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.s;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class f {
    private boolean A;
    private int C;
    private boolean D;
    private String E;
    private boolean G;
    private boolean H;
    private boolean I;
    private int L;
    private x N;
    private n O;
    private com.ss.android.socialbase.appdownloader.c.e P;
    private IDownloadFileUriProvider Q;
    private r R;
    private boolean S;
    private af T;
    private boolean U;
    private JSONObject V;
    private String W;
    private int Y;
    private long Z;
    private Activity a;
    private int aa;
    private boolean ab;
    private String ae;
    private int[] af;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f5468c;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f5469d;

    /* renamed from: e  reason: collision with root package name */
    private String f5470e;

    /* renamed from: f  reason: collision with root package name */
    private String f5471f;

    /* renamed from: g  reason: collision with root package name */
    private String f5472g;

    /* renamed from: h  reason: collision with root package name */
    private List<com.ss.android.socialbase.downloader.model.c> f5473h;

    /* renamed from: m  reason: collision with root package name */
    private IDownloadListener f5478m;
    private IDownloadListener n;
    private String o;
    private boolean q;
    private com.ss.android.socialbase.downloader.downloader.g r;
    private com.ss.android.socialbase.downloader.downloader.h s;
    private s t;
    private com.ss.android.socialbase.downloader.notification.a u;
    private boolean v;
    private boolean w;
    private String x;
    private String y;
    private long z;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5474i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5475j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5476k = true;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5477l = false;
    private String p = AdBaseConstants.MIME_APK;
    private int B = 5;
    private boolean F = true;
    private EnqueueType J = EnqueueType.ENQUEUE_NONE;
    private int K = 150;
    private boolean M = true;
    private List<m> X = new ArrayList();
    private boolean ac = true;
    private boolean ad = true;

    public f(@NonNull Context context, @NonNull String str) {
        this.b = context.getApplicationContext();
        this.f5468c = str;
    }

    public boolean A() {
        return this.F;
    }

    public boolean B() {
        return this.G;
    }

    public s C() {
        return this.t;
    }

    public int D() {
        return this.K;
    }

    public int E() {
        return this.L;
    }

    public boolean F() {
        return this.H;
    }

    public boolean G() {
        return this.I;
    }

    public boolean H() {
        return this.M;
    }

    public boolean I() {
        return this.S;
    }

    public EnqueueType J() {
        return this.J;
    }

    public boolean K() {
        return this.A;
    }

    public String L() {
        return this.f5471f;
    }

    public x M() {
        return this.N;
    }

    public n N() {
        return this.O;
    }

    public com.ss.android.socialbase.appdownloader.c.e O() {
        return this.P;
    }

    public IDownloadFileUriProvider P() {
        return this.Q;
    }

    public af Q() {
        return this.T;
    }

    public List<m> R() {
        return this.X;
    }

    public boolean S() {
        return this.U;
    }

    public int T() {
        return this.Y;
    }

    public long U() {
        return this.Z;
    }

    public boolean V() {
        return this.ad;
    }

    public String W() {
        return this.ae;
    }

    public int[] X() {
        return this.af;
    }

    public boolean Y() {
        return this.ab;
    }

    public boolean Z() {
        return this.ac;
    }

    public String a() {
        return this.f5468c;
    }

    public String aa() {
        return this.W;
    }

    public List<String> ab() {
        return this.f5469d;
    }

    public r ac() {
        return this.R;
    }

    public JSONObject ad() {
        return this.V;
    }

    public String b() {
        return this.f5470e;
    }

    public String c() {
        return this.f5472g;
    }

    public List<com.ss.android.socialbase.downloader.model.c> d() {
        return this.f5473h;
    }

    public boolean e() {
        return this.f5474i;
    }

    public boolean f() {
        return this.f5475j;
    }

    public boolean g() {
        return this.f5476k;
    }

    public Activity getActivity() {
        return this.a;
    }

    public Context getContext() {
        return this.b;
    }

    public boolean h() {
        return this.f5477l;
    }

    public IDownloadListener i() {
        return this.f5478m;
    }

    public IDownloadListener j() {
        return this.n;
    }

    public String k() {
        return this.o;
    }

    public String l() {
        return this.p;
    }

    public boolean m() {
        return this.q;
    }

    public com.ss.android.socialbase.downloader.notification.a n() {
        return this.u;
    }

    public com.ss.android.socialbase.downloader.downloader.h o() {
        return this.s;
    }

    public com.ss.android.socialbase.downloader.downloader.g p() {
        return this.r;
    }

    public boolean q() {
        return this.v;
    }

    public boolean r() {
        return this.w;
    }

    public int s() {
        return this.aa;
    }

    public String t() {
        return this.x;
    }

    public String u() {
        return this.y;
    }

    public long v() {
        return this.z;
    }

    public int w() {
        return this.B;
    }

    public int x() {
        return this.C;
    }

    public boolean y() {
        return this.D;
    }

    public String z() {
        return this.E;
    }

    public void a(int i2) {
        this.aa = i2;
    }

    public f b(String str) {
        this.f5471f = str;
        return this;
    }

    public f c(@NonNull String str) {
        this.f5472g = str;
        return this;
    }

    public f d(String str) {
        this.o = str;
        return this;
    }

    public f e(String str) {
        this.p = str;
        return this;
    }

    public f f(boolean z) {
        this.w = z;
        return this;
    }

    public f g(String str) {
        this.y = str;
        return this;
    }

    public f h(String str) {
        this.E = str;
        return this;
    }

    public f i(boolean z) {
        this.F = z;
        return this;
    }

    public f j(boolean z) {
        this.G = z;
        return this;
    }

    public f k(boolean z) {
        this.H = z;
        return this;
    }

    public f l(boolean z) {
        this.I = z;
        return this;
    }

    public f m(boolean z) {
        this.M = z;
        return this;
    }

    public f n(boolean z) {
        this.A = z;
        return this;
    }

    public f o(boolean z) {
        this.ab = z;
        return this;
    }

    public f p(boolean z) {
        this.ac = z;
        return this;
    }

    public f a(String str) {
        this.f5470e = str;
        return this;
    }

    public f b(boolean z) {
        this.f5475j = z;
        return this;
    }

    public f c(boolean z) {
        this.f5477l = z;
        return this;
    }

    public f d(boolean z) {
        this.q = z;
        return this;
    }

    public f e(boolean z) {
        this.v = z;
        return this;
    }

    public f f(String str) {
        this.x = str;
        return this;
    }

    public f g(boolean z) {
        this.D = z;
        return this;
    }

    public f h(boolean z) {
        this.S = z;
        return this;
    }

    public f i(String str) {
        this.ae = str;
        return this;
    }

    public f j(String str) {
        this.W = str;
        return this;
    }

    public f a(List<com.ss.android.socialbase.downloader.model.c> list) {
        this.f5473h = list;
        return this;
    }

    public f b(int i2) {
        this.B = i2;
        return this;
    }

    public f c(int i2) {
        this.C = i2;
        return this;
    }

    public f d(int i2) {
        this.K = i2;
        return this;
    }

    public f e(int i2) {
        this.L = i2;
        return this;
    }

    public f f(int i2) {
        this.Y = i2;
        return this;
    }

    public f a(boolean z) {
        this.f5474i = z;
        return this;
    }

    public f b(List<String> list) {
        this.f5469d = list;
        return this;
    }

    public f a(IDownloadListener iDownloadListener) {
        this.f5478m = iDownloadListener;
        return this;
    }

    public f a(long j2) {
        this.z = j2;
        return this;
    }

    public f a(EnqueueType enqueueType) {
        this.J = enqueueType;
        return this;
    }

    public f a(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.Q = iDownloadFileUriProvider;
        return this;
    }

    public f a(r rVar) {
        this.R = rVar;
        return this;
    }

    public f a(JSONObject jSONObject) {
        this.V = jSONObject;
        return this;
    }

    public f a(m mVar) {
        synchronized (this.X) {
            if (mVar != null) {
                if (!this.X.contains(mVar)) {
                    this.X.add(mVar);
                    return this;
                }
            }
            return this;
        }
    }
}
