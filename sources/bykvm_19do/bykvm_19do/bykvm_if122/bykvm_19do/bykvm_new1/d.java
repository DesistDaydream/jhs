package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1;

import android.app.Activity;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.o;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.y;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomTTBaseAd;
import com.bytedance.msdk.base.TTBaseAd;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class d extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.e {
    public boolean g0;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ TTBaseAd a;

        public a(TTBaseAd tTBaseAd) {
            this.a = tTBaseAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTBaseAd tTBaseAd = this.a;
            if (tTBaseAd == null || !tTBaseAd.adnHasAdVideoCachedApi() || !this.a.isCacheSuccess() || (d.this.N instanceof GMCustomTTBaseAd)) {
                return;
            }
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(d.this.f896f, this.a.getAdNetworkSlotId()) + "在show时触发了预加载【" + this.a.getAdNetWorkName() + "】, loadSort: " + this.a.getLoadSort() + ", showSort: " + this.a.getShowSort());
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b d2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d();
            d dVar = d.this;
            d2.b(dVar.H, dVar.f896f, dVar.e());
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ TTBaseAd a;
        public final /* synthetic */ Activity b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f905c;

        public b(TTBaseAd tTBaseAd, Activity activity, Map map) {
            this.a = tTBaseAd;
            this.b = activity;
            this.f905c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTBaseAd tTBaseAd = this.a;
            if (tTBaseAd != null) {
                d.this.N = tTBaseAd;
                tTBaseAd.setHasShown(true);
                d dVar = d.this;
                dVar.N.setTTAdatperCallback(dVar.I);
                d dVar2 = d.this;
                dVar2.N.setTTAdatperRewardPlayAgainCallback(dVar2.J);
                if (d.this.N.canAdReuse()) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a();
                    d dVar3 = d.this;
                    if (a.c(dVar3.f896f, dVar3.N.getAdNetworkSlotId(), d.this.e())) {
                        d dVar4 = d.this;
                        TTBaseAd tTBaseAd2 = dVar4.N;
                        dVar4.a(tTBaseAd2, tTBaseAd2.getAdNetworkSlotId());
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(TTLogUtil.getTagThirdLevelByEvent(d.this.f896f, TTLogUtil.TAG_EVENT_SHOW));
                sb.append("展示的广告类型：");
                sb.append(e.c.c.a.a.b(d.this.N.getAdNetworkPlatformId()));
                sb.append(",slotId：");
                sb.append(d.this.N.getAdNetworkSlotId());
                sb.append(",slotType:");
                sb.append(d.this.N.getAdNetworkSlotType());
                sb.append(",isReady()：");
                d dVar5 = d.this;
                sb.append(dVar5.N.isReady(dVar5.f896f));
                sb.append("，是否为缓存广告:");
                sb.append(d.this.N.isCacheSuccess());
                Logger.d("TTMediationSDK", sb.toString());
                d.this.N.showAd(this.b, this.f905c);
                m b = m.b();
                b.j(d.this.f896f + "");
                l b2 = l.b();
                d dVar6 = d.this;
                b2.e(dVar6.f896f, dVar6.N.getAdNetworkSlotId());
                d dVar7 = d.this;
                dVar7.L = true;
                if (dVar7.N != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(d.this.N);
                    d.this.a(arrayList);
                }
                d dVar8 = d.this;
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(dVar8.N, dVar8.f898h, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    public d(Context context, String str) {
        super(context, str);
        this.g0 = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0126, code lost:
        c(r5);
        a(r5, r20, r21);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> r17, java.util.List<com.bytedance.msdk.base.TTBaseAd> r18, boolean r19, android.app.Activity r20, java.util.Map<com.bytedance.msdk.api.TTAdConstant.GroMoreExtraKey, java.lang.Object> r21) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d.a(java.util.List, java.util.List, boolean, android.app.Activity, java.util.Map):boolean");
    }

    private boolean i0() {
        boolean e2 = y.e(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
        boolean f2 = y.f(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
        Logger.i("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "setting 下发是否为弱网执行：" + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().I() + "，当前网络环境：2G-type=" + e2 + ",3G-type=" + f2);
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().I() && (e2 || f2);
    }

    public void a(Activity activity, c cVar) {
        List<j> list;
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> a2;
        TTBaseAd tTBaseAd;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar2 = this.f894d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(this.f898h, cVar2 != null ? cVar2.C() : null);
        if (this.L || this.b.get()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a((List<TTBaseAd>) null, this.f898h);
            if (cVar == null) {
                return;
            }
        } else {
            List<TTBaseAd> u = u();
            try {
                list = K();
            } catch (Throwable th) {
                th.printStackTrace();
                list = null;
            }
            if (list != null && list.size() > 0) {
                HashMap<String, TTBaseAd> d2 = d(u);
                for (j jVar : list) {
                    if (jVar != null) {
                        String d3 = jVar.d();
                        TTBaseAd tTBaseAd2 = d2.get(d3);
                        if (tTBaseAd2 != null && tTBaseAd2.isReady(this.f896f) && !tTBaseAd2.isHasShown()) {
                            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f896f, TTLogUtil.TAG_EVENT_SHOW) + "adSlotId：" + tTBaseAd2.getAdNetworkSlotId() + "，广告类型：" + e.c.c.a.a.b(tTBaseAd2.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd2.isReady(this.f896f));
                            a(tTBaseAd2, activity, (Map<TTAdConstant.GroMoreExtraKey, Object>) null);
                            return;
                        } else if (jVar.a() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f896f, d3, e()) && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(d3, this.f898h, false) == 3 && (a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(d3, this.f898h)) != null && a2.size() > 0 && (tTBaseAd = a2.get(0).a) != null && tTBaseAd.isReady(this.f896f) && !tTBaseAd.isHasShown()) {
                            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f896f, TTLogUtil.TAG_EVENT_SHOW) + "adSlotId：" + tTBaseAd.getAdNetworkSlotId() + "，广告类型：" + e.c.c.a.a.b(tTBaseAd.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd.isReady(this.f896f));
                            c(tTBaseAd);
                            a(tTBaseAd, activity, (Map<TTAdConstant.GroMoreExtraKey, Object>) null);
                            return;
                        }
                    }
                }
            }
            if (u != null && u.size() > 0) {
                for (TTBaseAd tTBaseAd3 : u) {
                    if (tTBaseAd3 != null && tTBaseAd3.isReady(this.f896f) && !tTBaseAd3.isHasShown()) {
                        Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f896f, TTLogUtil.TAG_EVENT_SHOW) + "adSlotId：" + tTBaseAd3.getAdNetworkSlotId() + "，广告类型：" + e.c.c.a.a.b(tTBaseAd3.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd3.isReady(this.f896f));
                        a(tTBaseAd3, activity, (Map<TTAdConstant.GroMoreExtraKey, Object>) null);
                        return;
                    }
                }
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(u, this.f898h);
            if (cVar == null) {
                return;
            }
        }
        cVar.a();
    }

    public void a(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map, c cVar) {
        char c2;
        char c3;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar2 = this.f894d;
        List<j> list = null;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(this.f898h, cVar2 != null ? cVar2.C() : null);
        if (!this.L && !this.b.get()) {
            boolean i0 = i0();
            List<TTBaseAd> u = u();
            try {
                list = K();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            List<j> list2 = list;
            if (list2 == null || list2.size() <= 0 || !a(list2, u, i0, activity, map)) {
                if (u != null && u.size() > 0) {
                    for (TTBaseAd tTBaseAd : u) {
                        if (tTBaseAd != null) {
                            if (i0) {
                                if (tTBaseAd.isCacheSuccess()) {
                                    Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f896f, tTBaseAd.getAdNetworkSlotId()) + "弱网情况下已缓存好的广告，广告类型：" + e.c.c.a.a.b(tTBaseAd.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd.isReady(this.f896f));
                                } else {
                                    continue;
                                }
                            }
                            if (tTBaseAd.isReady(this.f896f) && !tTBaseAd.isHasShown()) {
                                a(tTBaseAd, activity, map);
                                return;
                            }
                        }
                    }
                    if (i0 && this.N == null) {
                        for (TTBaseAd tTBaseAd2 : u) {
                            if (tTBaseAd2 != null && tTBaseAd2.isReady(this.f896f) && !tTBaseAd2.isHasShown()) {
                                Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f896f, tTBaseAd2.getAdNetworkSlotId()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + e.c.c.a.a.b(tTBaseAd2.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd2.isReady(this.f896f));
                                a(tTBaseAd2, activity, map);
                                return;
                            }
                        }
                    }
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(u, this.f898h);
                if (cVar != null) {
                    cVar.a();
                    return;
                }
                return;
            }
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a((List<TTBaseAd>) null, this.f898h);
        if (cVar != null) {
            cVar.a();
            c2 = '\t';
            c3 = Attributes.InternalPrefix;
        } else {
            c2 = '\n';
            c3 = '7';
        }
        while (true) {
            switch (c2) {
                case '\b':
                case '\n':
                    return;
                case '\t':
                    switch (c3) {
                        case '-':
                        case '.':
                        case '/':
                        default:
                            return;
                    }
                default:
                    c2 = '\b';
            }
        }
    }

    public void a(TTBaseAd tTBaseAd, Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        ThreadHelper.runOnUiThread(new b(tTBaseAd, activity, map));
    }

    public void a(boolean z) {
        this.g0 = z;
    }

    public void b(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map, c cVar) {
        a(activity, map, cVar);
    }

    public void d(TTBaseAd tTBaseAd) {
        ThreadHelper.runOnUiThread(new a(tTBaseAd));
    }

    public void e0() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (this.N.getAdType() == 10 || this.N.getAdType() == 8 || this.N.getAdType() == 7) {
            if (this.N.adnHasAdVideoCachedApi() && this.N.isCacheSuccess() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(this.f896f, e()) != 0) {
                z3 = false;
            }
            if (this.N.getAdNetworkPlatformId() == 4) {
                z2 = false;
                if (this.N.canAdReuse() || !bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f896f, this.N.getAdNetworkSlotId(), e())) {
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(this.N.getAdNetworkSlotId(), this.f898h, this.r, z2, this.S, this.v, this.H, this.w);
                return;
            }
            z = z3;
        } else {
            z = true;
        }
        z2 = z;
        if (this.N.canAdReuse()) {
        }
    }

    public boolean f0() {
        return this.g0;
    }

    public boolean g0() {
        List<j> list;
        try {
            list = K();
        } catch (Throwable th) {
            th.printStackTrace();
            list = null;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        return o.a(this.q, this.p, this.o, this.f898h, this.L, this.b, this.f896f, e(), list, cVar != null ? cVar.C() : null);
    }

    public void h0() {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd == null || tTBaseAd.getAdNetworkPlatformId() == 4) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(this.H, this.f896f, e());
    }
}
