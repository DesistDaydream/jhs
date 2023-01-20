package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.f0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.l0;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.config.IGMInitAdnResult;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.error.AdBreakError;
import com.bytedance.msdk.api.error.AdFreqError;
import com.bytedance.msdk.api.error.AdPacingError;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.bytedance.msdk.api.v2.GMNetworkRequestInfo;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter;
import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomAdConfig;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class e extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c implements TTAbsAdLoaderAdapter.AdapterLoaderListener {
    public long C;
    public long D;
    public long E;
    public long F;
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d G;
    public Context H;
    public ITTAdatperCallback I;
    public ITTAdatperCallback J;
    public TTBaseAd N;
    public GMNetworkRequestInfo S;
    private boolean W;
    public int Z;
    public TTBaseAd a0;
    public b.f b0;
    public volatile boolean K = false;
    public volatile boolean L = false;
    public volatile boolean M = false;
    private final Map<String, TTAbsAdLoaderAdapter> O = new HashMap();
    public int P = -1000;
    public int Q = -1000;
    public final AtomicBoolean R = new AtomicBoolean(false);
    private ConcurrentHashMap<String, AdLoadInfo> T = new ConcurrentHashMap<>();
    public long U = 0;
    private long V = 0;
    private final Map<Integer, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> X = new HashMap();
    public boolean Y = false;
    private final Comparator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> c0 = new h(this);
    private final Comparator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> d0 = new i(this);

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ AdError a;

        public a(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ AdError a;

        public c(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public final /* synthetic */ List a;
        public final /* synthetic */ AdError b;

        public d(List list, AdError adError) {
            this.a = list;
            this.b = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(this.a, this.b);
        }
    }

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0042e implements Runnable {
        public RunnableC0042e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.P();
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.P();
            }
        }

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!e.this.a.get() || e.this.f893c.get()) {
                return;
            }
            e.this.f893c.set(true);
            AdSlot adSlot = e.this.f898h;
            if ((adSlot != null && adSlot.getAdType() == 7) || e.this.f898h.getAdType() == 8) {
                Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f896f) + "m-sdk----设置 cacheTimeout 已到时间【" + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().d(e.this.f898h.getAdUnitId()) + "】，给外部invokeAdVideoCache ...");
            }
            if (e.this.t()) {
                return;
            }
            e.this.f0();
            ThreadHelper.runOnUiThread(new a());
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.P();
        }
    }

    /* loaded from: classes.dex */
    public class h implements Comparator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> {
        public h(e eVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar2) {
            int p;
            int p2;
            if (jVar.p() == jVar2.p()) {
                p = jVar.y();
                p2 = jVar2.y();
            } else {
                p = jVar.p();
                p2 = jVar2.p();
            }
            return p - p2;
        }
    }

    /* loaded from: classes.dex */
    public class i implements Comparator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> {
        public i(e eVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar2) {
            return (jVar.i() > jVar2.i() ? 1 : (jVar.i() == jVar2.i() ? 0 : -1)) >= 0 ? -1 : 1;
        }
    }

    /* loaded from: classes.dex */
    public class j extends Handler {
        public j(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e.this.a(message);
        }
    }

    /* loaded from: classes.dex */
    public class k extends Handler {
        public k(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e.this.a(message);
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ StackTraceElement[] b;

        public l(boolean z, StackTraceElement[] stackTraceElementArr) {
            this.a = z;
            this.b = stackTraceElementArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<Integer> list;
            Map<Integer, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> map;
            String str;
            e eVar;
            AdBreakError adBreakError;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d dVar;
            e.this.U = SystemClock.elapsedRealtime();
            e.this.j0();
            if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.d.k()) {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f896f) + "MSDK未进行初始化！！！");
                e.this.e(1);
                eVar = e.this;
                adBreakError = new AdBreakError(1, AdError.getMessage(1));
            } else if (e.this.M) {
                Logger.e("TTMediationSDK", "调用过销毁方法_destroy()！！！");
                e.this.e(AdError.ERROR_CODE_DESTROY);
                eVar = e.this;
                adBreakError = new AdBreakError(AdError.ERROR_CODE_DESTROY, AdError.getMessage(AdError.ERROR_CODE_DESTROY));
            } else {
                e eVar2 = e.this;
                if (eVar2.H == null) {
                    Logger.e("TTMediationSDK", "Context为null！！！");
                    e.this.e(AdError.ERROR_CODE_CONTEXT_ERROR);
                    eVar = e.this;
                    adBreakError = new AdBreakError(AdError.ERROR_CODE_CONTEXT_ERROR, AdError.getMessage(AdError.ERROR_CODE_CONTEXT_ERROR));
                } else if (eVar2.f898h == null) {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f896f) + "AdSlot can't be null！！");
                    e.this.e(AdError.ERROR_CODE_ADSLOT_CONFIG_ERROR);
                    eVar = e.this;
                    adBreakError = new AdBreakError(AdError.ERROR_CODE_ADSLOT_CONFIG_ERROR, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_CONFIG_ERROR));
                } else if (eVar2.f897g == null) {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f896f) + "msdk threadHandler can't be null！！");
                    e.this.e(AdError.ERROR_CODE_MSDK_THREAD_HANDLER);
                    eVar = e.this;
                    adBreakError = new AdBreakError(AdError.ERROR_CODE_MSDK_THREAD_HANDLER, AdError.getMessage(AdError.ERROR_CODE_MSDK_THREAD_HANDLER));
                } else {
                    if (eVar2.f894d == null && (dVar = eVar2.G) != null) {
                        eVar2.f894d = dVar.c(eVar2.f896f);
                        e.this.W();
                        e.this.j0();
                    }
                    e eVar3 = e.this;
                    eVar3.K = true;
                    eVar3.Y();
                    if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.a.b().a()) {
                        String a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_this102.a.a(e.this.f898h.getTestSlotId());
                        if (!TextUtils.isEmpty(a)) {
                            e.this.z();
                            e eVar4 = e.this;
                            eVar4.f894d = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_this102.a.a(eVar4.f894d, a);
                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = e.this.f894d;
                            int y = cVar != null ? cVar.y() : 0;
                            e.this.W();
                            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f896f) + "测试工具加载广告........totalWaterFallCount: " + y + "  ,rit_id:" + e.this.f896f + " ,slot_id:" + a);
                        }
                        e.this.Z();
                        if (e.this.f898h.getAdType() == 3 && TextUtils.equals(l0.a(), "com.header.app.untext") && e.this.f898h.isForceLoadBottom()) {
                            str = "强制开启开屏兜底...............";
                        } else {
                            e eVar5 = e.this;
                            if (eVar5.f894d != null) {
                                eVar5.t = eVar5.f898h.getAdCount();
                                e eVar6 = e.this;
                                eVar6.f895e = eVar6.f894d.A();
                                e eVar7 = e.this;
                                eVar7.n = new ArrayList(eVar7.f894d.i());
                                if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().f(e.this.f896f) || (list = e.this.n) == null || list.size() == 0 || (map = e.this.f895e) == null || map.size() == 0) {
                                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f896f) + "settings config.......注意，AdUnitId = " + e.this.f898h.getAdUnitId() + "  没有对应的waterfall配置信息");
                                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(e.this.f898h, 3);
                                    e.this.e(AdError.ERROR_CODE_REQUEST_BUT_CONFIG_ERROR);
                                    e eVar8 = e.this;
                                    eVar8.a(eVar8.f896f, eVar8.R);
                                    return;
                                }
                                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m.b();
                                if (!b.b(e.this.f896f + "")) {
                                    Logger.d("TMe", "广告位 请求触发次数拦截............");
                                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m b2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m.b();
                                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g h2 = b2.h(e.this.f896f + "");
                                    Pair<String, String> f2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m.b().f(e.this.f896f);
                                    if (h2 == null || f2 == null) {
                                        return;
                                    }
                                    AdFreqError adFreqError = new AdFreqError(AdError.ERROR_CODE_EXCEED_FREQCTL, AdError.getMessage(AdError.ERROR_CODE_EXCEED_FREQCTL), (String) f2.second, (String) f2.first);
                                    e.this.e(adFreqError.code);
                                    e.this.a(adFreqError, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
                                    return;
                                }
                                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m b3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m.b();
                                if (!b3.c(e.this.f896f + "") && !e.this.t()) {
                                    Logger.d("TMe", "广告位 请求触发时间间隔拦截............");
                                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m b4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m.b();
                                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i i2 = b4.i(e.this.f896f + "");
                                    if (i2 != null) {
                                        String message = AdError.getMessage(AdError.ERROR_CODE_EXCEED_PACING);
                                        AdPacingError adPacingError = new AdPacingError(AdError.ERROR_CODE_EXCEED_PACING, message, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m.b().g(e.this.f896f) + "", i2.j());
                                        e.this.e(adPacingError.code);
                                        e.this.a(adPacingError, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
                                        return;
                                    }
                                    return;
                                }
                                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.b.a(e.this.n);
                                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b d2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d();
                                e eVar9 = e.this;
                                if (d2.a(eVar9.f896f, eVar9.e()) == 2) {
                                    boolean z = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().d(e.this.f896f) == null;
                                    if (!e.this.t() && !z && e.this.R()) {
                                        e eVar10 = e.this;
                                        eVar10.Y = true;
                                        eVar10.N();
                                        return;
                                    }
                                    if (!e.this.t() && !z) {
                                        e.this.f898h.setPrimeRitReqType(3);
                                    }
                                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b d3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d();
                                    e eVar11 = e.this;
                                    d3.a(eVar11.f896f, eVar11.f898h);
                                }
                                e.this.e(0);
                                e.this.a(this.a, this.b);
                                e eVar12 = e.this;
                                eVar12.s.a(eVar12.n);
                                e eVar13 = e.this;
                                eVar13.s.e(eVar13.f894d.y());
                                e eVar14 = e.this;
                                Handler handler = eVar14.f897g;
                                if (handler != null) {
                                    handler.sendEmptyMessageDelayed(2, eVar14.E);
                                }
                                if (e.this.f894d.I()) {
                                    e eVar15 = e.this;
                                    eVar15.f902l = 0;
                                    eVar15.s.b(true);
                                    e.this.i0();
                                } else {
                                    e.this.X();
                                }
                                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()).c(1);
                                return;
                            } else if (eVar5.f898h.getAdType() != 3 || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().x() || e.this.S == null) {
                                if (e.this.G == null || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().g()) {
                                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f896f) + "settings config.......没有settings config配置信息,AdUnitId = " + e.this.f898h.getAdUnitId());
                                    e.this.e(AdError.ERROR_CODE_REQUEST_BUT_CONFIG_ERROR);
                                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(e.this.f898h, 1);
                                } else {
                                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f896f) + "settings config.......注意，AdUnitId = " + e.this.f898h.getAdUnitId() + " 的配置信息为 null ！！");
                                    e.this.e(AdError.ERROR_CODE_REQUEST_BUT_CONFIG_ERROR);
                                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(e.this.f898h, 2);
                                }
                                e eVar16 = e.this;
                                eVar16.a(eVar16.f896f, eVar16.R);
                                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.e();
                                return;
                            } else {
                                str = "执行开启开屏兜底...............";
                            }
                        }
                        Logger.e("TTMediationSDK", str);
                        e.this.T();
                        return;
                    }
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f896f) + "请求过于频繁，触发了熔断机制");
                    e.this.e(AdError.ERROR_CODE_REQUEST_CIRCUIT_BREAKER);
                    eVar = e.this;
                    adBreakError = new AdBreakError(AdError.ERROR_CODE_REQUEST_CIRCUIT_BREAKER, AdError.getMessage(AdError.ERROR_CODE_REQUEST_CIRCUIT_BREAKER));
                }
            }
            eVar.a(adBreakError, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public final /* synthetic */ GMCustomBaseAdapter a;
        public final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f909c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f910d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f911e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f912f;

        public m(GMCustomBaseAdapter gMCustomBaseAdapter, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, int i2, int i3, long j2, int i4) {
            this.a = gMCustomBaseAdapter;
            this.b = jVar;
            this.f909c = i2;
            this.f910d = i3;
            this.f911e = j2;
            this.f912f = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                GMCustomBaseAdapter gMCustomBaseAdapter = this.a;
                e eVar = e.this;
                Context context = eVar.H;
                AdSlot adSlot = eVar.f898h;
                GMAdSlotBase gMAdSlotBase = eVar.w;
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar = this.b;
                Map<String, Object> a = eVar.a(this.f909c, this.f910d, jVar, this.f911e);
                e eVar2 = e.this;
                gMCustomBaseAdapter.loadInner(context, adSlot, gMAdSlotBase, jVar, a, eVar2.v, this.f912f, eVar2);
            } catch (Exception e2) {
                e eVar3 = e.this;
                TTBaseAd tTBaseAd = eVar3.N;
                AdSlot adSlot2 = eVar3.f898h;
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar2 = this.b;
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("", tTBaseAd, adSlot2, jVar2, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, "自定义Adapter 加载广告内部错误 " + e2.getClass().getName()));
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public n(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(this.a, this.b);
        }
    }

    /* loaded from: classes.dex */
    public class o implements IGMInitAdnResult {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public o(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
        public void fail(@NonNull AdError adError) {
        }

        @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
        public void success() {
            e.this.a(this.a, this.b);
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Handler handler = e.this.f897g;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                List<TTBaseAd> list = e.this.q;
                if (list != null) {
                    list.clear();
                }
                List<TTBaseAd> list2 = e.this.o;
                if (list2 != null) {
                    list2.clear();
                }
                List<TTBaseAd> list3 = e.this.p;
                if (list3 != null) {
                    list3.clear();
                }
                TTBaseAd tTBaseAd = e.this.N;
                if (tTBaseAd != null) {
                    tTBaseAd.onDestroy();
                }
                if (e.this.O != null) {
                    for (Map.Entry entry : e.this.O.entrySet()) {
                        if (entry != null) {
                            TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = (TTAbsAdLoaderAdapter) entry.getValue();
                            tTAbsAdLoaderAdapter.setAdapterListener(null);
                            tTAbsAdLoaderAdapter.destroy();
                        }
                    }
                    e.this.O.clear();
                }
                e.this.s.h();
            } catch (Throwable th) {
                if (Logger.isDebug()) {
                    th.printStackTrace();
                }
            }
            e eVar = e.this;
            eVar.I = null;
            eVar.J = null;
            eVar.G = null;
            eVar.f895e = null;
            eVar.H = null;
            eVar.S = null;
            eVar.M = true;
            if (eVar.K) {
                e.this.a(new AdBreakError(AdError.ERROR_CODE_DESTROY, AdError.getMessage(AdError.ERROR_CODE_DESTROY)), (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class q implements Runnable {
        public final /* synthetic */ boolean a;

        public q(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            b.f fVar = eVar.b0;
            if (fVar != null) {
                fVar.a(eVar.f896f, this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.O();
        }
    }

    public e(Context context, String str) {
        Map<Integer, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> A;
        this.H = context;
        this.f896f = str;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d f2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f();
        this.G = f2;
        if (f2 != null) {
            a(f2.l());
            d(this.G.o());
            this.f894d = this.G.c(this.f896f);
            W();
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (cVar != null && (A = cVar.A()) != null) {
            for (Map.Entry<Integer, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> entry : A.entrySet()) {
                List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> value = entry.getValue();
                if (value != null && value.size() > 0 && value.get(0).f() == 100) {
                    this.X.put(entry.getKey(), entry.getValue());
                }
            }
        }
        Looper mSDKThreadLooper = ThreadHelper.getMSDKThreadLooper();
        if (mSDKThreadLooper != null) {
            this.f897g = new j(mSDKThreadLooper);
            return;
        }
        ThreadHelper.initMSDKThread();
        this.f897g = new k(ThreadHelper.getMSDKThreadLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> a(int i2, int i3, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, long j2) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(jVar, this.f898h, this.r, this.S, i2, i3, !t(), j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        Handler handler;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(str2, str, -4, -4);
        if (this.C != 0 && (handler = this.f897g) != null) {
            handler.removeMessages(3);
            this.f897g.sendEmptyMessageDelayed(3, this.C);
        }
        a(a2, -1);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()).c(1);
    }

    private void a(boolean z) {
        ThreadHelper.runOnMSDKThread(new q(z));
    }

    private boolean a(int i2, int i3, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, int i4, long j2) {
        TTAbsAdLoaderAdapter c2 = c(jVar);
        if (c2 == null) {
            a(jVar, i2, i3);
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + " 创建TTAbsAdLoaderAdapter失败");
        } else if (this.H != null) {
            c2.setAdapterListener(this);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.i iVar = this.v;
            if (iVar != null) {
                jVar.h(iVar.a);
            }
            if (jVar.f() == 2 && jVar.x() != null) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(jVar, this.f898h, c2.getSdkVersion());
            }
            c2.loadAdInter(this.H, jVar, a(i2, i3, jVar, j2), this.f898h, this.v, i4, this.w);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(this.f896f, jVar.d(), jVar, i4);
            return true;
        } else {
            a(jVar, i2, i3);
        }
        return false;
    }

    private boolean a(Class<?> cls, Class<?> cls2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar) {
        String b2;
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.c.a(cls, cls2)) {
            b2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.c.b(cls, cls2);
        } else {
            b2 = "自定义ADN初始化对象失败  ---------  初始化类 " + cls.getSimpleName() + " 需要继承自自定义ADN的广告对象基类 " + cls2.getSimpleName();
        }
        if (TextUtils.isEmpty(b2)) {
            return true;
        }
        Logger.e("TTMediationSDK_SDK_Init", b2);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("", this.N, this.f898h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, b2));
        return false;
    }

    private boolean a(String str, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, int i2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(this.f896f, str, jVar, i2);
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(str, this.f898h);
        if (a2 == null || a2.size() <= 0) {
            return false;
        }
        TTBaseAd tTBaseAd = a2.get(0).a;
        AdSlot adSlot = this.f898h;
        int mediationRitReqType = tTBaseAd.getMediationRitReqType(adSlot != null ? adSlot.getLinkedId() : null);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(jVar, this.f898h, 3, mediationRitReqType);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(jVar, this.f898h, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(str), !t(), 1, i2, 3, mediationRitReqType, (AdError) null, -1L);
        ArrayList arrayList = new ArrayList();
        for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e eVar : a2) {
            eVar.a.setMediationRitReqType(3);
            eVar.a.setMediationRitReqTypeSrc(mediationRitReqType);
            a(eVar.a, str);
            arrayList.add(eVar.a);
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(a2.get(0).a, 0, "adn cache命中", 0L, this.f898h, i2, arrayList.size(), 2, (String) null, -1L);
        onAdLoaded(arrayList, a2.get(0).b);
        return true;
    }

    private int a0() {
        Map<Integer, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> A;
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> list;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        int i2 = 0;
        if (cVar != null && (A = cVar.A()) != null && A.size() != 0) {
            ArrayList<Integer> arrayList = new ArrayList();
            arrayList.addAll(A.keySet());
            for (Integer num : arrayList) {
                if (this.s.c(num.intValue()) && (list = A.get(num)) != null) {
                    i2 += list.size();
                }
            }
        }
        return i2;
    }

    private TTBaseAd b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar) {
        TTBaseAd next;
        if (jVar == null) {
            return null;
        }
        String d2 = jVar.d();
        String c2 = jVar.x() != null ? jVar.x().c() : null;
        if (TextUtils.isEmpty(d2)) {
            return null;
        }
        Iterator<TTBaseAd> it = this.q.iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (next != null && d2.equals(next.getAdNetworkSlotId())) {
                    break;
                }
            } else {
                Iterator<TTBaseAd> it2 = this.o.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        Iterator<TTBaseAd> it3 = this.p.iterator();
                        while (it3.hasNext()) {
                            next = it3.next();
                            if (next != null) {
                                if (!next.isServerBiddingAd() || TextUtils.isEmpty(c2) || TextUtils.isEmpty(next.getAid())) {
                                    if (d2.equals(next.getAdNetworkSlotId())) {
                                    }
                                } else if (d2.equals(next.getAdNetworkSlotId()) && c2.equals(next.getAid())) {
                                }
                            }
                        }
                        return null;
                    }
                    next = it2.next();
                    if (next != null && d2.equals(next.getAdNetworkSlotId())) {
                        break;
                    }
                }
            }
        }
        return next;
    }

    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0105: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:34:0x0105 */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0109: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:36:0x0109 */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x010d: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:38:0x010d */
    private boolean b(int i2, int i3, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, int i4, long j2) {
        String str;
        String str2;
        GMCustomAdConfig className;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "";
        if (this.w == null) {
            Logger.e("TTMediationSDK_SDK_Init", "自定义Adapter 老API不支持自定义Adapter，请使用新的API");
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("", this.N, this.f898h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, "自定义Adapter 老API不支持自定义Adapter，请使用新的API"));
        } else {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().a(jVar.e());
            if (a2 == null) {
                a(jVar, i2, i3);
                str6 = "自定义Adapter 配置为空";
            } else {
                Logger.i("TTMediationSDK_SDK_Init", "自定义Adapter 获取配置wfcBean = " + jVar);
                try {
                    className = a2.c().getClassName(jVar.t(), jVar.z());
                } catch (ClassNotFoundException e2) {
                    e = e2;
                    str = "TTMediationSDK_SDK_Init";
                    str2 = "";
                }
                if (className == null) {
                    str6 = "自定义Adapter 配置的className为空，无法反射创建自定义广告Adapter对象 ";
                } else {
                    Class<?> cls = Class.forName(className.getClassName());
                    try {
                        if (a(cls, className.getClazz(), jVar)) {
                            try {
                                Object newInstance = cls.newInstance();
                                try {
                                    if (newInstance instanceof GMCustomBaseAdapter) {
                                        GMCustomBaseAdapter gMCustomBaseAdapter = (GMCustomBaseAdapter) newInstance;
                                        Logger.i("TTMediationSDK_SDK_Init", "自定义Adapter 反射创建初始化对象为 " + gMCustomBaseAdapter);
                                        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(jVar.e()) != null) {
                                            ThreadHelper.runOnThreadPool(new m(gMCustomBaseAdapter, jVar, i2, i3, j2, i4));
                                            return true;
                                        }
                                        Logger.e("TTMediationSDK_SDK_Init", "自定义Adapter 创建广告对象失败  ---------  没有初始化，不能加载广告，请检查初始化配置");
                                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("", this.N, this.f898h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, "自定义Adapter 创建广告对象失败  ---------  没有初始化，不能加载广告，请检查初始化配置"));
                                        str = "TTMediationSDK_SDK_Init";
                                        str2 = "";
                                    } else {
                                        str = "TTMediationSDK_SDK_Init";
                                        String str8 = "自定义ADN 创建广告对象失败  ---------  对象类型错误  对象类型为 " + GMCustomBaseAdapter.class.getName();
                                        Logger.e(str, str8);
                                        str2 = "";
                                        try {
                                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(str2, this.N, this.f898h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, str8));
                                        } catch (IllegalAccessException e3) {
                                            e = e3;
                                            e.printStackTrace();
                                            str7 = "自定义Adapter IllegalAccessException";
                                            Logger.e(str, str7);
                                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(str2, this.N, this.f898h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, str7));
                                            a(jVar, i2, i3);
                                            return false;
                                        } catch (InstantiationException e4) {
                                            e = e4;
                                            e.printStackTrace();
                                            str7 = "自定义Adapter InstantiationException";
                                            Logger.e(str, str7);
                                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(str2, this.N, this.f898h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, str7));
                                            a(jVar, i2, i3);
                                            return false;
                                        }
                                    }
                                    a(jVar, i2, i3);
                                    return true;
                                } catch (ClassNotFoundException e5) {
                                    e = e5;
                                    str2 = str5;
                                    e.printStackTrace();
                                    str7 = "自定义Adapter ClassNotFoundException";
                                    Logger.e(str, str7);
                                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(str2, this.N, this.f898h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, str7));
                                    a(jVar, i2, i3);
                                    return false;
                                } catch (IllegalAccessException e6) {
                                    e = e6;
                                    str2 = str4;
                                } catch (InstantiationException e7) {
                                    e = e7;
                                    str2 = str3;
                                }
                            } catch (IllegalAccessException e8) {
                                e = e8;
                                str = "TTMediationSDK_SDK_Init";
                                str2 = "";
                            } catch (InstantiationException e9) {
                                e = e9;
                                str = "TTMediationSDK_SDK_Init";
                                str2 = "";
                            }
                        } else {
                            str = "TTMediationSDK_SDK_Init";
                            str2 = "";
                        }
                    } catch (ClassNotFoundException e10) {
                        e = e10;
                    }
                    Logger.e(str, str7);
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(str2, this.N, this.f898h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, str7));
                    a(jVar, i2, i3);
                }
            }
            str = "TTMediationSDK_SDK_Init";
            str2 = "";
            str7 = str6;
            Logger.e(str, str7);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(str2, this.N, this.f898h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, str7));
            a(jVar, i2, i3);
        }
        return false;
    }

    private boolean b0() {
        List<TTBaseAd> list = this.q;
        if (list != null) {
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd.isCacheSuccess()) {
                    return true;
                }
            }
        }
        List<TTBaseAd> list2 = this.p;
        if (list2 != null) {
            for (TTBaseAd tTBaseAd2 : list2) {
                if (tTBaseAd2.isCacheSuccess()) {
                    return true;
                }
            }
        }
        List<TTBaseAd> list3 = this.o;
        if (list3 != null) {
            for (TTBaseAd tTBaseAd3 : list3) {
                if (tTBaseAd3.isCacheSuccess()) {
                    return true;
                }
            }
        }
        return false;
    }

    private TTAbsAdLoaderAdapter c(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar) {
        if (jVar != null) {
            return (TextUtils.equals("baidu", jVar.e()) && jVar.G()) ? a(this.f898h.getLinkedId(), this.f896f, jVar.d()) : bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(this.f896f, jVar);
        }
        Logger.i("TTMediationSDK", "wfcBean is null getTTAbsAdLoaderAdapter fail");
        return null;
    }

    private boolean c0() {
        return !t();
    }

    private void d(AdError adError) {
        this.W = true;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.f898h, adError, cVar != null ? cVar.C() : null, j());
    }

    private boolean d0() {
        return t() && h() == 2;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00d6 -> B:36:0x00d8). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00f7 -> B:51:0x00f9). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e0() {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e.e0():void");
    }

    private TTBaseAd f(List<TTBaseAd> list) {
        TTBaseAd tTBaseAd = null;
        if (list != null && list.size() != 0) {
            for (TTBaseAd tTBaseAd2 : list) {
                if (tTBaseAd == null || tTBaseAd2.getFillTime() < tTBaseAd.getFillTime()) {
                    tTBaseAd = tTBaseAd2;
                }
            }
        }
        return tTBaseAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        AdSlot adSlot = this.f898h;
        if ((adSlot == null || adSlot.getAdType() != 7) && this.f898h.getAdType() != 8) {
            return;
        }
        AdSlot adSlot2 = this.f898h;
        TTBaseAd tTBaseAd = this.N;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.V;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(adSlot2, tTBaseAd, elapsedRealtime - j2, cVar != null ? cVar.C() : null);
    }

    private List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> g(List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> it = list.iterator();
        while (it.hasNext()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j next = it.next();
            if (next.F()) {
                it.remove();
                arrayList2.add(next);
            } else if (next.G() || next.E() || next.B()) {
                it.remove();
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j();
                jVar.a(next.d());
                jVar.c(next.f());
                jVar.b(next.e());
                jVar.a(next.c());
                jVar.g(next.q());
                jVar.g(next.p());
                jVar.j(next.y());
                jVar.i(next.t());
                jVar.e("" + next.i());
                jVar.f(next.j());
                jVar.i(next.A());
                jVar.h(next.u());
                jVar.a(next.x());
                TTBaseAd b2 = b(jVar);
                if (b2 != null) {
                    jVar.e("" + b2.getBiddingCpmWithOutExchangeRate());
                }
                arrayList.add(jVar);
            }
        }
        list.addAll(arrayList);
        Collections.sort(list, this.d0);
        Collections.sort(arrayList2, this.c0);
        list.addAll(0, arrayList2);
        return list;
    }

    private void g0() {
        if (this.f897g != null) {
            if (!b0()) {
                this.f897g.postDelayed(new f(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().d(this.f898h.getAdUnitId()));
            } else if (!this.a.get() || this.f893c.get()) {
            } else {
                this.f893c.set(true);
                AdSlot adSlot = this.f898h;
                if ((adSlot != null && adSlot.getAdType() == 7) || this.f898h.getAdType() == 8) {
                    Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "从onAdLoaded给外部invokeAdVideoCache ...");
                }
                if (t()) {
                    return;
                }
                f0();
                ThreadHelper.runOnUiThread(new RunnableC0042e());
            }
        }
    }

    private void h0() {
        Handler handler = this.f897g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        AdError adError;
        this.y = System.currentTimeMillis();
        Map<Integer, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> map = this.f895e;
        if (map == null) {
            adError = new AdError(AdError.ERROR_CODE_NO_CONFIG, AdError.getMessage(AdError.ERROR_CODE_NO_CONFIG));
        } else {
            List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> list = map.get(0);
            if (!f0.a(list)) {
                e(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.c().a(this.B, this.H, this.f898h, list, this.f894d, this.f898h.getPrimeRitReqType(), !t()));
                return;
            }
            adError = new AdError(AdError.ERROR_CODE_NO_CONFIG, AdError.getMessage(AdError.ERROR_CODE_NO_CONFIG));
        }
        c(adError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        AdSlot adSlot = this.f898h;
        if (adSlot == null || this.f894d == null) {
            return;
        }
        adSlot.setNetWorkNum("network_ad_num_" + this.f894d.b());
        GMAdSlotBase gMAdSlotBase = this.w;
        if (gMAdSlotBase != null) {
            gMAdSlotBase.setNetWorkNum("network_ad_num_" + this.f894d.b());
        }
    }

    public void B() {
        ThreadHelper.runOnMSDKThread(new p());
    }

    public List<AdLoadInfo> C() {
        AdLoadInfo value;
        ArrayList arrayList = new ArrayList(this.T.size());
        for (Map.Entry<String, AdLoadInfo> entry : this.T.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !TextUtils.equals(AdLoadInfo.AD_LOADED, value.getErrMsg()) && !TextUtils.equals(AdLoadInfo.AD_LOADING, value.getErrMsg())) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public ConcurrentHashMap<String, AdLoadInfo> D() {
        return this.T;
    }

    public int E() {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetworkPlatformId();
        }
        return -2;
    }

    public String F() {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetworkSlotId();
        }
        return null;
    }

    public Map<String, Object> G() {
        TTBaseAd tTBaseAd = this.N;
        return tTBaseAd != null ? tTBaseAd.getMediaExtraInfo() : new HashMap();
    }

    public String H() {
        if (this.N == null) {
            return null;
        }
        return (o() || !(this.N.isServerBiddingAd() || this.N.isClientBiddingAd() || this.N.isMultiBiddingAd())) ? this.N.getNetWorkPlatFormCpm() : GMNetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    public int I() {
        return this.Z;
    }

    public GMAdEcpmInfo J() {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd == null) {
            return null;
        }
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.o.a(tTBaseAd, true);
    }

    public List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> K() {
        boolean z;
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> arrayList = new ArrayList<>();
        if (this.M) {
            return arrayList;
        }
        List<Integer> list = this.n;
        int i2 = 0;
        if (list == null || list.size() <= 0) {
            z = false;
        } else {
            int i3 = 0;
            z = false;
            while (i2 < list.size()) {
                int intValue = list.get(i2).intValue();
                if (intValue == -100) {
                    i3 = 1;
                }
                if (intValue < -100) {
                    z = true;
                }
                if (this.f895e.get(Integer.valueOf(intValue)) != null) {
                    arrayList.addAll(this.f895e.get(Integer.valueOf(intValue)));
                }
                i2++;
            }
            i2 = i3;
        }
        if (i2 == 0 && n() && !f0.b(this.p)) {
            for (TTBaseAd tTBaseAd : this.p) {
                if (this.f894d != null && (tTBaseAd.isMultiBiddingAd() || tTBaseAd.isClientBiddingAd())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j a2 = this.f894d.a(tTBaseAd.getAdNetworkSlotId());
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
            }
        }
        if (!z) {
            List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> g2 = g();
            if (!f0.a(g2)) {
                arrayList.addAll(g2);
            }
        }
        Iterator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove();
            }
        }
        if (p() || n()) {
            return g(arrayList);
        }
        Collections.sort(arrayList, this.c0);
        return arrayList;
    }

    public void L() {
        Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "超过当前层最短加载时间.....");
        if (this.a.get() || this.b.get()) {
            return;
        }
        if (r()) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "超过当前层最短加载时间....有P层广告回调成功出去....");
            q();
        }
        if (p() && !x()) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "超过当前层最短加载时间.....  当前有serverBidding广告，serverBidding请求还未发起或者还没有返回.......");
        } else if (s() && m()) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "超过当前层最短加载时间且满足client bidding限制条件....有广告回调成功出去....");
            q();
        }
    }

    public void M() {
        List<TTBaseAd> list;
        List<TTBaseAd> list2;
        this.s.a(true);
        V();
        if (this.a.get() || this.b.get()) {
            return;
        }
        List<TTBaseAd> list3 = this.q;
        if ((list3 == null || list3.size() <= 0) && (((list = this.o) == null || list.size() <= 0) && ((list2 = this.p) == null || list2.size() <= 0))) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "总加载时间超时.......没有广告回调失败");
            a(new AdError(10003, AdError.getMessage(10003)), (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
            return;
        }
        Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "总加载时间超时.......有广告回调成功");
        q();
    }

    public void N() {
        AdSlot a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(this.f896f);
        if (a2 != null) {
            this.f898h.setLinkedId(a2.getLinkedId());
            this.f898h.setPrimeRitReqType(a2.getPrimeRitReqType());
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(this.f896f, this.f898h);
        e(0);
        e((List<TTBaseAd>) null);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c c2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().c(this.f896f);
        if (c2 != null) {
            this.v = c2.v;
            this.T = c2.D();
        }
        q();
    }

    public abstract void O();

    public abstract void P();

    public void Q() {
        AdSlot adSlot = this.f898h;
        if ((adSlot != null && adSlot.getAdType() == 7) || this.f898h.getAdType() == 8) {
            Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "广告缓存成功！给外部回调：invokeAdVideoCacheOnMainUI........");
        }
        if (t()) {
            return;
        }
        f0();
        ThreadHelper.runOnUiThread(new g());
    }

    public boolean R() {
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> e2;
        Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "mLoadSortList: " + this.n);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(this.f896f, this.f898h, cVar != null ? cVar.C() : null) && (e2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().e(this.f896f)) != null && e2.size() > 0) {
            for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e eVar : e2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eVar.a);
                c(arrayList);
            }
            if (this.q.size() > 0 || this.p.size() > 0 || this.o.size() > 0) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "--==-- hit cache!!! -----");
                return true;
            }
        }
        Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "--==-- not hit cache!!! -----");
        return false;
    }

    public void S() {
        boolean t = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().t();
        ThreadHelper.runOnMSDKThread(new l(t, t ? Thread.currentThread().getStackTrace() : null));
    }

    public void T() {
        if (this.S != null) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "settings config.......AdUnitId = " + this.f896f + "  开屏广告走了开发者自定义兜底方案   adnName:" + e.c.c.a.a.b(this.S.getAdNetworkFlatFromId()));
        }
        e(AdError.ERROR_CODE_CONFIG_ERROR);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.f898h, -4);
        e0();
    }

    public void U() {
        List<TTBaseAd> list;
        List<TTBaseAd> list2;
        if (this.s.b() != 0 || this.x.get()) {
            return;
        }
        this.f897g.removeMessages(5);
        if (p() && x()) {
            if (s()) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "SeverBidding广告成功返回...所有的ClientBidding都有返回结果且没有到达其层超时...当前广告池中广告数量满足要求...直接返回......");
                q();
            }
            if (this.s.g() || !this.s.f()) {
                return;
            }
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "所有广告都已经加载完成....... ");
            List<TTBaseAd> list3 = this.q;
            if ((list3 == null || list3.size() <= 0) && (((list = this.o) == null || list.size() <= 0) && ((list2 = this.p) == null || list2.size() <= 0))) {
                a(new AdError(20005, AdError.getMessage(20005)), (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
                return;
            }
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "SeverBidding广告返回且到达ClientBidding的等待时间，所有广告都有返回结果...直接返回......");
            q();
        }
    }

    public void V() {
        TTAbsAdLoaderAdapter value;
        for (Map.Entry<String, TTAbsAdLoaderAdapter> entry : this.O.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.setTotalTimedOut(true);
            }
        }
    }

    public void W() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (cVar != null) {
            cVar.e();
            this.C = this.f894d.j();
            this.D = this.f894d.h();
            this.E = this.f894d.x();
            this.F = this.f894d.l();
            this.f900j = this.f894d.F();
            this.f899i = this.f894d.G();
            this.f901k = this.f894d.k() == 0;
            this.f894d.m();
            this.Z = this.f894d.o();
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "mRitConfig=" + this.f894d.toString());
        }
    }

    public void X() {
        a(0, false);
    }

    public void Y() {
        this.R.set(false);
        this.u.set(false);
        this.p.clear();
        this.o.clear();
        this.q.clear();
        this.a.set(false);
        this.b.set(false);
        this.f893c.set(false);
        Handler handler = this.f897g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.h hVar = this.s;
        if (hVar != null) {
            hVar.h();
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.i iVar = this.v;
        if (iVar != null) {
            iVar.a = null;
        }
    }

    public void Z() {
        this.f898h.setIfTest(e());
        this.f898h.setTransparentParams(k());
        this.f898h.setAdUnitId(this.f896f);
        this.f898h.setAdloadSeq(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a());
        this.f898h.setLinkedId(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.d());
        if (this.f898h.getReuestParam() != null) {
            this.f898h.getReuestParam().getExtraObject().put("tt_request_ad_type", Integer.valueOf(this.f898h.getAdStyleType()));
        }
        this.f898h.setReqType(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(this.f896f, e()));
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (cVar != null) {
            this.f898h.setWaterfallId(cVar.E());
            this.f898h.setVersion(this.f894d.z());
            this.f898h.setSegmentId(this.f894d.t());
            this.f898h.setSegmentVersion(this.f894d.u());
            this.f898h.setmWaterfallExtra(this.f894d.D());
            this.f898h.setBidFloor(this.f894d.c());
            this.f898h.setParalleType(this.f894d.m());
            this.f898h.setReqParallelNum(this.f894d.o());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0276, code lost:
        if (r13 != 5) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0286 A[PHI: r0 
      PHI: (r0v59 char) = (r0v46 char), (r0v60 char) binds: [B:71:0x024a, B:73:0x026e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0278 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x0286 -> B:73:0x026e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x02bd -> B:89:0x02bf). Please submit an issue!!! */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e.a(int, boolean):void");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0185 A[PHI: r3 
      PHI: (r3v13 char) = (r3v8 char), (r3v8 char), (r3v12 char), (r3v15 char) binds: [B:60:0x0181, B:55:0x0178, B:63:0x0187, B:37:0x00b4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x016a -> B:52:0x016e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0187 -> B:62:0x0185). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x018f -> B:63:0x0187). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.os.Message r8) {
        /*
            Method dump skipped, instructions count: 550
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e.a(android.os.Message):void");
    }

    public void a(ViewGroup viewGroup) {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null) {
            tTBaseAd.showSplashClickEyeView(viewGroup);
        }
    }

    public void a(ViewGroup viewGroup, Activity activity) {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null) {
            tTBaseAd.showSplashCardView(viewGroup, activity);
        }
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar) {
        if (jVar == null) {
            return;
        }
        this.s.a(jVar.d());
        this.s.a(jVar.p());
        if (jVar.E() || jVar.B()) {
            this.s.a();
            U();
        }
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, int i2, int i3) {
        if (jVar != null) {
            a(jVar);
            jVar.h(j());
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(jVar, this.f898h, i2, i3);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    public void a(AdError adError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        if (adError == null) {
            adError = new AdError(20005, AdError.getMessage(20005));
        }
        h0();
        if (this.b.get() || this.a.get()) {
            return;
        }
        this.b.set(true);
        d(adError);
        if (t()) {
            a(false);
            return;
        }
        Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "广告加载失败！给外部回调：invokeAdLoadFailCallbackOnMainUI...... error Code = " + adError.code + " error Message = " + adError.message);
        ThreadHelper.runOnUiThread(new a(adError));
    }

    public void a(TTBaseAd tTBaseAd, String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j c2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f896f, str);
        if (tTBaseAd == null || c2 == null) {
            return;
        }
        tTBaseAd.setLoadSort(c2.p());
        tTBaseAd.setShowSort(c2.y());
        tTBaseAd.setExchangeRate(c2.j());
        tTBaseAd.setAdNetworkSlotType(c2.f());
        tTBaseAd.setCpm(c2.i());
    }

    public void a(String str, String str2, String str3, String str4, int i2, String str5) {
        AdLoadInfo adLoadInfo = this.T.get(str);
        if (adLoadInfo == null) {
            adLoadInfo = new AdLoadInfo();
        }
        adLoadInfo.setMediationRit(str).setAdnName(str2).setCustomAdnName(str3).setErrCode(i2).setErrMsg(str5).setAdType(str4);
        this.T.put(str, adLoadInfo);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b A[LOOP:0: B:11:0x006b->B:16:0x006b, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0069 -> B:11:0x006b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r3, java.util.concurrent.atomic.AtomicBoolean r4) {
        /*
            r2 = this;
            boolean r4 = r2.t()
            if (r4 == 0) goto L9
            r3 = 64
            goto L6b
        L9:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d r4 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d
            r4.<init>()
            r0 = -1
            r4.c(r0)
            r4.d(r0)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()
            boolean r0 = r0.e(r3)
            if (r0 != 0) goto L2a
            com.bytedance.msdk.api.AdError r3 = new com.bytedance.msdk.api.AdError
            r0 = 44406(0xad76, float:6.2226E-41)
            java.lang.String r1 = "广告位ID不合法"
            r3.<init>(r0, r1)
            goto L5a
        L2a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r2.f896f
            java.lang.String r1 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagSecondLevel(r1)
            r0.append(r1)
            java.lang.String r1 = "settings config.......AdUnitId = "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = "  暂无config配置信息"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            java.lang.String r0 = "TTMediationSDK"
            com.bytedance.msdk.adapter.util.Logger.e(r0, r3)
            com.bytedance.msdk.api.AdError r3 = new com.bytedance.msdk.api.AdError
            r0 = 40040(0x9c68, float:5.6108E-41)
            java.lang.String r1 = com.bytedance.msdk.api.AdError.getMessage(r0)
            r3.<init>(r0, r1)
        L5a:
            r2.a(r3, r4)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(r3)
            r4 = 1
            r3.c(r4)
        L69:
            r3 = 66
        L6b:
            switch(r3) {
                case 64: goto L6f;
                case 65: goto L69;
                case 66: goto L6f;
                default: goto L6e;
            }
        L6e:
            goto L6b
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e.a(java.lang.String, java.util.concurrent.atomic.AtomicBoolean):void");
    }

    public void a(List<TTBaseAd> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        String adNetworkSlotId = list.get(0).getAdNetworkSlotId();
        if (list.get(0).canAdReuse() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f896f, adNetworkSlotId, e())) {
            ArrayList arrayList = new ArrayList();
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd != null) {
                    arrayList.add(new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e(tTBaseAd, dVar, 0L, this.f898h));
                }
            }
            if (arrayList.size() > 0) {
                TTBaseAd tTBaseAd2 = ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e) arrayList.get(0)).a;
                Logger.d("TTMediationSDK", "--==-- 广告复用:广告缓存成功 -------" + tTBaseAd2.getAdNetWorkName() + ", adType: " + e.c.c.a.a.c(tTBaseAd2.getAdType(), tTBaseAd2.getSubAdType()) + ", adnSlotId: " + tTBaseAd2.getAdNetworkSlotId() + ", ad个数: " + arrayList.size());
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(adNetworkSlotId, arrayList);
            }
        }
    }

    public boolean a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        return dVar != null && (dVar.i() || dVar.j() || dVar.m());
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x02a2, code lost:
        if (r1 != '9') goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0205 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0201 -> B:38:0x0208). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x029e -> B:62:0x02a0). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r21, int r22) {
        /*
            Method dump skipped, instructions count: 696
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j, int):boolean");
    }

    public int b(int i2) {
        List<Integer> list = this.n;
        if (list == null) {
            return -1;
        }
        return list.indexOf(Integer.valueOf(i2)) + 1;
    }

    public abstract void b(AdError adError);

    public void b(List<TTBaseAd> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
    }

    public final void b(List<TTBaseAd> list, AdError adError) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (cVar == null || !cVar.I()) {
            return;
        }
        if (this.M) {
            list = null;
            adError = new AdError(AdError.ERROR_CODE_DESTROY, AdError.getMessage(AdError.ERROR_CODE_DESTROY));
        }
        if (t()) {
            return;
        }
        if (!f0.a(list)) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "单个广告加载完成！给外部回调：invokeSingleAdLoadCallbackUI......");
            for (TTBaseAd tTBaseAd : list) {
                Logger.i("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f896f, TTLogUtil.TAG_EVENT_FILL) + "AdNetWorkName[" + tTBaseAd.getAdNetWorkName() + "] AdUnitId[" + tTBaseAd.getAdNetworkSlotId() + "]  请求成功 (loadSort=" + tTBaseAd.getLoadSort() + ",showSort=" + tTBaseAd.getShowSort() + ")");
            }
        }
        if (adError != null) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "单个广告加载失败！给外部回调：invokeSingleAdLoadCallbackUI...... errorCode:" + adError.code + "  errorMsg:" + adError.message);
        }
        ThreadHelper.runOnUiThread(new d(list, adError));
    }

    public final void c(AdError adError) {
        ThreadHelper.runOnUiThread(new c(adError));
    }

    public void c(TTBaseAd tTBaseAd) {
        AdSlot adSlot = this.f898h;
        int mediationRitReqType = tTBaseAd.getMediationRitReqType(adSlot != null ? adSlot.getLinkedId() : null);
        tTBaseAd.setMediationRitReqType(3);
        tTBaseAd.setMediationRitReqTypeSrc(mediationRitReqType);
    }

    public void c(List<TTBaseAd> list) {
        if (f0.b(list)) {
            return;
        }
        if (this.s.g()) {
            b((List<TTBaseAd>) null, new AdError(10012, AdError.AD_LOAD_AD_TIME_OUT_ERROR_MSG));
        } else {
            b(list, (AdError) null);
        }
        TTBaseAd tTBaseAd = list.get(0);
        if (tTBaseAd.isPAd()) {
            this.q.addAll(list);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(this.q, (Comparator<TTBaseAd>) null);
            if (Logger.isDebug()) {
                for (TTBaseAd tTBaseAd2 : list) {
                    Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "广告加载成功...........返回了P层广告_当前P层广告缓存池数量：" + this.q.size() + ",slotId：" + tTBaseAd2.getAdNetworkSlotId() + ",广告类型：" + tTBaseAd2.getAdNetWorkName() + ",loadSort=" + tTBaseAd2.getLoadSort() + ",showSort=" + tTBaseAd2.getShowSort() + ",CPM=" + tTBaseAd2.getCpm());
                }
            }
        } else if (tTBaseAd.isServerBiddingAd()) {
            this.p.addAll(list);
            for (TTBaseAd tTBaseAd3 : list) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "广告加载成功...........返回了ServerBidding层广告_当前ServerBidding层广告缓存池数量：" + this.p.size() + ",slotId：" + tTBaseAd3.getAdNetworkSlotId() + ",广告类型：" + tTBaseAd3.getAdNetWorkName() + ",loadSort=" + tTBaseAd3.getLoadSort() + ",showSort=" + tTBaseAd3.getShowSort() + ",CPM=" + tTBaseAd3.getCpm());
            }
        } else if (tTBaseAd.isMultiBiddingAd() || tTBaseAd.isClientBiddingAd()) {
            this.p.addAll(list);
            String str = tTBaseAd.isMultiBiddingAd() ? "多阶底价" : "clientBidding";
            for (TTBaseAd tTBaseAd4 : list) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "广告加载成功...........返回了" + str + "层广告_当前" + str + "层广告缓存池数量：" + this.p.size() + ",slotId：" + tTBaseAd4.getAdNetworkSlotId() + ",广告类型：" + tTBaseAd4.getAdNetWorkName() + ",loadSort=" + tTBaseAd4.getLoadSort() + ",showSort=" + tTBaseAd4.getShowSort() + ",CPM=" + tTBaseAd4.getCpm());
            }
            this.s.a();
            U();
        } else {
            this.o.addAll(list);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(this.o, (Comparator<TTBaseAd>) null);
            if (Logger.isDebug()) {
                for (TTBaseAd tTBaseAd5 : list) {
                    Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "广告加载成功...........返回了普通层广告_当前普通广告缓存池数量：" + this.o.size() + ",slotId：" + tTBaseAd5.getAdNetworkSlotId() + ",广告类型：" + tTBaseAd5.getAdNetWorkName() + ",loadSort=" + tTBaseAd5.getLoadSort() + ",showSort=" + tTBaseAd5.getShowSort() + ",CPM=" + tTBaseAd5.getCpm());
                }
            }
        }
    }

    public boolean c(int i2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar;
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> list = this.f895e.get(Integer.valueOf(i2));
        if (list != null) {
            Iterator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> it = list.iterator();
            while (it.hasNext()) {
                jVar = it.next();
                if (jVar != null && jVar.G() && TextUtils.equals(jVar.e(), "pangle")) {
                    break;
                }
            }
        }
        jVar = null;
        return jVar != null && jVar.s() == 3;
    }

    public HashMap<String, TTBaseAd> d(List<TTBaseAd> list) {
        HashMap<String, TTBaseAd> hashMap = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd != null) {
                    hashMap.put(tTBaseAd.getAdNetworkSlotId(), tTBaseAd);
                }
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x013c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x013c -> B:77:0x013e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(int r12) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e.d(int):boolean");
    }

    public void e(int i2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.f898h, cVar != null ? cVar.C() : null, !t(), j(), i2);
    }

    public final void e(String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.f898h, this.f894d.C());
        ThreadHelper.runOnUiThread(new b(str));
    }

    public void e(List<TTBaseAd> list) {
        if (this.a0 == null) {
            this.a0 = f(list);
        }
        if (this.u.get() || this.W) {
            return;
        }
        this.V = SystemClock.elapsedRealtime();
        boolean t = t();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.a0, this.f898h, this.f894d, this.V - this.U, j(), !t, list != null ? list.size() : 0);
        this.u.set(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x01b0, code lost:
        if (android.text.TextUtils.isEmpty(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_this102.a.a(r1.getTestSlotId())) == false) goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onAdFailed(com.bytedance.msdk.api.AdError r9, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d r10) {
        /*
            Method dump skipped, instructions count: 608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e.onAdFailed(com.bytedance.msdk.api.AdError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d):void");
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdLoaded(TTBaseAd tTBaseAd, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(tTBaseAd);
        onAdLoaded(arrayList, dVar);
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdLoaded(List<TTBaseAd> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        StringBuilder sb;
        String str;
        String str2;
        if (this.f897g != null) {
            if (dVar == null) {
                return;
            }
            if (dVar != null) {
                a(dVar.d(), dVar.c(), dVar.e(), e.c.c.a.a.c(dVar.b(), dVar.h()), 0, AdLoadInfo.AD_LOADED);
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(this.f896f, dVar, !f0.b(list) ? list.get(0) : null);
            a(list, dVar);
            if (dVar.a() == 0 && !f0.b(list)) {
                String adNetworkSlotId = list.get(0).getAdNetworkSlotId();
                if (a(adNetworkSlotId)) {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "返回的普通广告被server Bidding过滤了......slotId:" + adNetworkSlotId);
                    return;
                }
            }
            this.s.a(dVar.d());
            if (t()) {
                b(list, dVar);
            }
            c(list);
            e(list);
            if (this.a.get() || this.b.get()) {
                return;
            }
            if (!f0.b(list) && list.get(0).isPAd() && r()) {
                TTBaseAd tTBaseAd = list.get(0);
                str2 = TTLogUtil.getTagSecondLevel(this.f896f) + "P层广告已经成功返回loadSort:" + tTBaseAd.getLoadSort() + " ,showSort:" + tTBaseAd.getLoadSort() + "  mTTPAdPoolList.size:" + this.q.size();
            } else if (((p() || n()) && !(p() && x())) || f0.b(list) || !a(list.get(0)) || !s()) {
                if (dVar.m() && s()) {
                    if (this.q.size() >= i()) {
                        sb = new StringBuilder();
                        sb.append(TTLogUtil.getTagSecondLevel(this.f896f));
                        str = "SeverBidding广告有返回时P层池中有广告直接返回......";
                    } else {
                        for (TTBaseAd tTBaseAd2 : this.o) {
                            if (a(tTBaseAd2) && m()) {
                                sb = new StringBuilder();
                                sb.append(TTLogUtil.getTagSecondLevel(this.f896f));
                                str = "SeverBidding广告有返回且满足ClientBidding等待时间时普通池中有广告直接返回......";
                            }
                        }
                    }
                    sb.append(str);
                    Logger.d("TTMediationSDK", sb.toString());
                    q();
                }
                if (this.s.f() && m()) {
                    Logger.i("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "所有层级和所有waterfall都已完成且满足ClientBidding等待时间直接回调...");
                    q();
                }
                return;
            } else {
                TTBaseAd tTBaseAd3 = list.get(0);
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "普通广告当前层优先级最高的广告已经成功返回loadSort:" + tTBaseAd3.getLoadSort() + " ,showSort:" + tTBaseAd3.getShowSort() + "  mTTCommonAdPoolList.size:" + this.o.size());
                if (m()) {
                    str2 = TTLogUtil.getTagSecondLevel(this.f896f) + "满足广告的返回条件...直接返回...";
                }
            }
            Logger.e("TTMediationSDK", str2);
            q();
        }
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdVideoCache() {
        if (this.f897g == null || this.b.get() || this.f893c.get() || !this.a.get()) {
            return;
        }
        this.f893c.set(true);
        Q();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    public void q() {
        ArrayList arrayList;
        ArrayList arrayList2;
        h0();
        if (this.a.get() || this.b.get()) {
            return;
        }
        Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "广告加载成功！给外部回调：invokeAdLoadCallbackOnMainUI........P.size:" + this.q.size() + "   bidding.size:" + this.p.size() + "   normal.size:" + this.o.size());
        this.a.set(true);
        y();
        if ((d0() || (c0() && !this.Y)) && (p() || n())) {
            List<TTBaseAd> u = u();
            TTBaseAd tTBaseAd = u.size() > 0 ? u.get(0) : null;
            int i2 = i();
            if (i2 > 1) {
                arrayList = new ArrayList();
                for (int i3 = 1; i3 < i2; i3++) {
                    if (i3 < u.size()) {
                        arrayList.add(u.get(i3));
                    }
                }
                if (u.size() > i2) {
                    arrayList2 = new ArrayList();
                    while (i2 < u.size()) {
                        TTBaseAd tTBaseAd2 = u.get(i2);
                        if (tTBaseAd2 != null && tTBaseAd2.isServerBiddingAd()) {
                            arrayList2.add(tTBaseAd2);
                        }
                        i2++;
                    }
                } else {
                    arrayList2 = null;
                }
            } else {
                arrayList = null;
                arrayList2 = null;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd, this.f898h, arrayList, arrayList2);
        }
        if (t()) {
            a(true);
            return;
        }
        int i4 = (this.q.size() + this.o.size()) + this.p.size() >= i() ? i() : this.q.size() + this.o.size() + this.p.size();
        AdSlot adSlot = this.f898h;
        TTBaseAd tTBaseAd3 = this.N;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.U;
        int a0 = a0();
        int b2 = b(this.P);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(adSlot, tTBaseAd3, elapsedRealtime - j2, a0, b2, 0, cVar != null ? cVar.C() : null, i4);
        ThreadHelper.runOnUiThread(new r());
        g0();
    }
}
