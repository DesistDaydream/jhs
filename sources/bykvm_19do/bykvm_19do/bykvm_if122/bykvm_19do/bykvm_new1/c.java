package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.i;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.f0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.o;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.t;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: d  reason: collision with root package name */
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c f894d;

    /* renamed from: e  reason: collision with root package name */
    public Map<Integer, List<j>> f895e;

    /* renamed from: f  reason: collision with root package name */
    public String f896f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f897g;

    /* renamed from: h  reason: collision with root package name */
    public AdSlot f898h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f899i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f900j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f901k;
    public List<Integer> n;
    public int t;
    public GMAdSlotBase w;
    public long y;
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final AtomicBoolean b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f893c = new AtomicBoolean(false);

    /* renamed from: l  reason: collision with root package name */
    public int f902l = -1;

    /* renamed from: m  reason: collision with root package name */
    public final List<j> f903m = new CopyOnWriteArrayList();
    public List<TTBaseAd> o = new CopyOnWriteArrayList();
    public List<TTBaseAd> p = new CopyOnWriteArrayList();
    public List<TTBaseAd> q = new CopyOnWriteArrayList();
    public Map<String, Object> r = new HashMap();
    public h s = new h();
    public AtomicBoolean u = new AtomicBoolean(false);
    public i v = new i();
    public final AtomicBoolean x = new AtomicBoolean(false);
    public boolean z = false;
    public int A = 0;
    public Map<String, TTAbsAdLoaderAdapter> B = new ConcurrentHashMap();

    /* loaded from: classes.dex */
    public class a implements d.a {
        public final /* synthetic */ AdSlot a;
        public final /* synthetic */ List b;

        public a(AdSlot adSlot, List list) {
            this.a = adSlot;
            this.b = list;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.d.a
        public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a aVar) {
            c.this.a(this.a, this.b, aVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ String a;

        /* loaded from: classes.dex */
        public class a implements d.a {
            public a() {
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.d.a
            public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a aVar) {
                Map<Integer, List<j>> map = c.this.f895e;
                List<j> list = map != null ? map.get(0) : null;
                c cVar = c.this;
                cVar.a(cVar.f898h, list, aVar);
            }
        }

        public b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.f fVar = (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.f) bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.e.a();
            String str = this.a;
            c cVar = c.this;
            fVar.a(str, cVar.y, cVar.f898h, cVar.f894d, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdSlot adSlot, List<j> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a aVar) {
        List<TTBaseAd> list2;
        List<TTBaseAd> list3;
        AdError adError;
        StringBuilder sb;
        String str;
        List<TTBaseAd> list4;
        List<TTBaseAd> list5;
        if (this.v != null && aVar != null && !TextUtils.isEmpty(aVar.f846c)) {
            this.v.a = aVar.f846c;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        String C = cVar != null ? cVar.C() : null;
        if (aVar != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(adSlot, aVar.f848e, aVar.f849f, C, aVar.f846c, this.s.g() ? 1 : 0, aVar.f850g, aVar.f851h);
        }
        if (aVar == null || f0.a(aVar.a)) {
            this.f902l = 2;
            if (this.a.get() || this.b.get()) {
                return;
            }
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "serverBidding响应失败了.......... ");
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.s.a((String) null);
                }
            }
            this.s.a(0, true);
            if (this.s.g() || !this.s.f()) {
                A();
            } else {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "所有广告都已经加载完成....... ");
                List<TTBaseAd> list6 = this.q;
                if ((list6 == null || list6.size() <= 0) && (((list2 = this.o) == null || list2.size() <= 0) && ((list3 = this.p) == null || list3.size() <= 0))) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar2 = this.f894d;
                    if (cVar2 == null || !cVar2.I()) {
                        adError = new AdError(20005, AdError.getMessage(20005));
                        a(adError, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
                    } else {
                        a(new AdError(10013, AdError.getMessage(10013)), (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
                    }
                } else {
                    sb = new StringBuilder();
                    sb.append(TTLogUtil.getTagSecondLevel(this.f896f));
                    str = "exchange响应失败且所有的广告都已经加载完成，则给出成功回调.....";
                    sb.append(str);
                    Logger.e("TTMediationSDK", sb.toString());
                    q();
                }
            }
        } else {
            this.f902l = 1;
            if (this.a.get() || this.b.get()) {
                return;
            }
            Handler handler = this.f897g;
            if (handler != null) {
                handler.removeMessages(4);
                this.f897g.removeMessages(1);
                this.f897g.removeMessages(3);
            }
            this.f903m.clear();
            List<j> list7 = aVar.a;
            if (list7 != null) {
                this.f903m.addAll(list7);
            }
            a(this.f903m, this.f894d.J());
            if (f0.a(this.f903m)) {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "serverBidding响应回来..........没有P层，且普通广告全都没有胜出.....直接返回");
                List<TTBaseAd> list8 = this.q;
                if ((list8 == null || list8.size() <= 0) && (((list4 = this.o) == null || list4.size() <= 0) && ((list5 = this.p) == null || list5.size() <= 0))) {
                    adError = new AdError(20005, AdError.getMessage(20005));
                    a(adError, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
                } else {
                    if (!this.f900j) {
                        sb = new StringBuilder();
                        sb.append(TTLogUtil.getTagSecondLevel(this.f896f));
                        str = "没有client bidding....直接给出成功回调.....";
                    } else if (m()) {
                        sb = new StringBuilder();
                        sb.append(TTLogUtil.getTagSecondLevel(this.f896f));
                        str = "存在client bidding且满足触发成功回调的条件，则给出成功回调.....";
                    }
                    sb.append(str);
                    Logger.e("TTMediationSDK", sb.toString());
                    q();
                }
            } else {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "serverBidding响应回来..........开始从头开始请求waterFallConfig ");
                a();
            }
        }
        if (aVar == null || !aVar.b) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()).a().c(1);
    }

    private void c(TTBaseAd tTBaseAd) {
        AdSlot adSlot;
        if (tTBaseAd == null || (adSlot = this.f898h) == null || !adSlot.isBidNotify()) {
            return;
        }
        if (tTBaseAd.isMultiBiddingAd() || tTBaseAd.isClientBiddingAd() || tTBaseAd.isServerBiddingAd()) {
            tTBaseAd.bidWinNotify(null);
        }
    }

    public void A() {
        StringBuilder sb;
        String str;
        if (s()) {
            if (this.q.size() < i()) {
                for (TTBaseAd tTBaseAd : this.o) {
                    if (a(tTBaseAd) && m()) {
                        sb = new StringBuilder();
                        sb.append(TTLogUtil.getTagSecondLevel(this.f896f));
                        str = "抛出成功回调_普通层池中广告满足数量，且满足client bidding的返回条件，给出成功回调，直接返回......";
                    }
                }
                return;
            }
            sb = new StringBuilder();
            sb.append(TTLogUtil.getTagSecondLevel(this.f896f));
            str = "抛出成功回调_P层池中广告满足数量，直接返回......";
            sb.append(str);
            Logger.d("TTMediationSDK", sb.toString());
            q();
        }
    }

    public TTAbsAdLoaderAdapter a(String str, String str2, String str3) {
        return this.B.get(String.format("%1$s_%2$s_%3$s", str, str2, str3));
    }

    public void a() {
        a(0, false);
        A();
    }

    public void a(int i2) {
        i iVar = this.v;
        if (iVar != null) {
            iVar.b = i2;
        }
    }

    public abstract void a(int i2, boolean z);

    public void a(Context context, AdSlot adSlot, List<j> list, boolean z) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.d a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.e.a();
        if (a2 != null) {
            this.f902l = 0;
            i iVar = this.v;
            if (iVar != null) {
                iVar.f776d = true;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.b bVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.b();
            bVar.a = adSlot;
            bVar.b = list;
            bVar.f853d = this.f894d;
            bVar.f855f = z;
            bVar.f854e = adSlot != null ? adSlot.getPrimeRitReqType() : 1;
            a2.a(this.B, context, bVar, new a(adSlot, list));
        }
    }

    public void a(AdError adError) {
    }

    public abstract void a(AdError adError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar);

    public void a(TTBaseAd tTBaseAd, GMAdConstant.BiddingLossReason biddingLossReason) {
        AdSlot adSlot;
        if (tTBaseAd == null || (adSlot = this.f898h) == null || biddingLossReason == null || !adSlot.isBidNotify()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("bidding_lose_reason", biddingLossReason);
        tTBaseAd.bidLoseNotify(hashMap);
    }

    public void a(List<TTBaseAd> list) {
        boolean z;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList<TTBaseAd> arrayList = new ArrayList();
        arrayList.addAll(list);
        for (TTBaseAd tTBaseAd : arrayList) {
            c(tTBaseAd);
        }
        if (this.p.size() != 0) {
            ArrayList<TTBaseAd> arrayList2 = new ArrayList();
            arrayList2.addAll(this.p);
            for (TTBaseAd tTBaseAd2 : arrayList2) {
                Iterator<TTBaseAd> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    TTBaseAd next = it.next();
                    if (next != null && tTBaseAd2 != null && next == tTBaseAd2) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    a(tTBaseAd2, GMAdConstant.BiddingLossReason.LOW_PRICE);
                }
            }
        }
    }

    public void a(List<TTBaseAd> list, AdError adError) {
    }

    public void a(List<j> list, boolean z) {
        if (list == null) {
            list = new ArrayList<>();
        }
        Map<Integer, List<j>> a2 = z ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.c.a(list) : bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.c.b(list);
        if (a2 == null) {
            a2 = new HashMap<>();
        }
        this.f895e = a2;
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        arrayList.addAll(this.f895e.keySet());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.b.a(this.n);
        this.s.b(this.n);
        this.s.a(list, g(), d());
        b(list);
    }

    public void a(boolean z, StackTraceElement[] stackTraceElementArr) {
        if (z) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a((TTBaseAd) null, this.f898h, t.a(stackTraceElementArr), 3);
        }
    }

    public boolean a(TTBaseAd tTBaseAd) {
        Map<Integer, List<j>> map;
        if (tTBaseAd == null || TextUtils.isEmpty(tTBaseAd.getAdNetworkSlotId()) || !tTBaseAd.isNormalAd() || (map = this.f895e) == null) {
            return false;
        }
        List<j> list = map.get(Integer.valueOf(tTBaseAd.getLoadSort()));
        if (f0.a(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList);
        return !f0.b(arrayList) && tTBaseAd.getAdNetworkSlotId().equals(((j) arrayList.get(0)).d());
    }

    public boolean a(String str) {
        if (!TextUtils.isEmpty(str) && p() && w()) {
            for (j jVar : this.f903m) {
                if (str.equals(jVar.d())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public GMAdEcpmInfo b() {
        List<TTBaseAd> u;
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().p() || (u = u()) == null || u.size() == 0) {
            return null;
        }
        return o.a(u.get(0), false);
    }

    public void b(TTBaseAd tTBaseAd) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().t()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd, this.f898h, t.a(Thread.currentThread().getStackTrace()), 2);
        }
    }

    public void b(String str) {
    }

    public void b(List<j> list) {
        StringBuilder sb;
        String str;
        boolean z;
        if (list == null || list.size() == 0) {
            this.o.clear();
            sb = new StringBuilder();
            sb.append(TTLogUtil.getTagSecondLevel(this.f896f));
            str = "没有胜出的普通广告，普通广告被全部过滤掉了 :";
        } else {
            for (TTBaseAd tTBaseAd : this.o) {
                Iterator<j> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    j next = it.next();
                    if (tTBaseAd != null && next != null && tTBaseAd.getAdNetworkSlotId().equals(next.d())) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "已经响应的广告: " + tTBaseAd.getAdNetworkSlotId() + "  没有在severBidding的waterFall列表中，需要被移除掉");
                    this.o.remove(tTBaseAd);
                }
            }
            sb = new StringBuilder();
            sb.append(TTLogUtil.getTagSecondLevel(this.f896f));
            str = "已经响应的广告被serverBidding过滤完还剩: ";
        }
        sb.append(str);
        sb.append(this.o.size());
        Logger.e("TTMediationSDK", sb.toString());
    }

    public List<GMAdEcpmInfo> c() {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().p()) {
            ArrayList arrayList = new ArrayList();
            for (TTBaseAd tTBaseAd : u()) {
                if (tTBaseAd != null) {
                    arrayList.add(o.a(tTBaseAd, false));
                }
            }
            return arrayList;
        }
        return null;
    }

    public void c(String str) {
        ThreadHelper.runOnMSDKThread(new b(str));
    }

    public List<j> d() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (cVar == null || cVar.B() == null || this.f894d.B().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.f894d.B()) {
            if (jVar != null && (jVar.f() == 1 || jVar.f() == 3)) {
                arrayList.add(jVar);
            }
        }
        return arrayList;
    }

    public void d(String str) {
        i iVar = this.v;
        if (iVar != null) {
            iVar.f775c = str;
        }
    }

    public int e() {
        i iVar = this.v;
        if (iVar != null) {
            return iVar.b;
        }
        return 0;
    }

    public List<GMAdEcpmInfo> f() {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().p()) {
            ArrayList arrayList = new ArrayList();
            for (TTBaseAd tTBaseAd : this.p) {
                if (tTBaseAd != null) {
                    arrayList.add(o.a(tTBaseAd, false));
                }
            }
            return arrayList;
        }
        return null;
    }

    public List<j> g() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (cVar == null || cVar.B() == null || this.f894d.B().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.f894d.B()) {
            if (jVar != null && jVar.f() == 100) {
                arrayList.add(jVar);
            }
        }
        return arrayList;
    }

    public int h() {
        return -1;
    }

    public int i() {
        AdSlot adSlot = this.f898h;
        if (adSlot == null) {
            return 1;
        }
        return adSlot.getAdCount();
    }

    public String j() {
        i iVar = this.v;
        if (iVar == null) {
            return null;
        }
        return iVar.a;
    }

    public String k() {
        i iVar = this.v;
        if (iVar != null) {
            return iVar.f775c;
        }
        return null;
    }

    public String l() {
        return this.f896f;
    }

    public boolean m() {
        return !n() || this.x.get() || this.s.b() == 0;
    }

    public boolean n() {
        return this.f900j;
    }

    public boolean o() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().r();
    }

    public boolean p() {
        return this.f899i;
    }

    public abstract void q();

    public boolean r() {
        return this.q.size() >= i();
    }

    public boolean s() {
        return this.q.size() + this.o.size() >= i();
    }

    public boolean t() {
        return false;
    }

    public List<TTBaseAd> u() {
        ArrayList arrayList = new ArrayList();
        if (!f0.a(this.o)) {
            arrayList.addAll(this.o);
        }
        if (!f0.a(this.p)) {
            arrayList.addAll(this.p);
        }
        g.a(arrayList, g.c());
        if (!f0.a(this.q)) {
            arrayList.addAll(0, this.q);
        }
        return arrayList;
    }

    public boolean v() {
        return this.f901k;
    }

    public boolean w() {
        return this.f902l == 1;
    }

    public boolean x() {
        return this.f902l > 0;
    }

    public void y() {
        i iVar;
        if (!p() || (iVar = this.v) == null || TextUtils.isEmpty(iVar.a)) {
            return;
        }
        for (TTBaseAd tTBaseAd : this.q) {
            tTBaseAd.putEventParam("server_bidding_extra", this.v.a);
        }
        for (TTBaseAd tTBaseAd2 : this.p) {
            tTBaseAd2.putEventParam("server_bidding_extra", this.v.a);
        }
        for (TTBaseAd tTBaseAd3 : this.o) {
            tTBaseAd3.putEventParam("server_bidding_extra", this.v.a);
        }
    }

    public void z() {
        i iVar = this.v;
        if (iVar != null) {
            iVar.b = 2;
        }
    }
}
