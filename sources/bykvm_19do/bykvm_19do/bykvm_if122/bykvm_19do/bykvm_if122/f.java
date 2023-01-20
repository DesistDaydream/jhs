package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.g;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.f0;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class f implements d {

    /* loaded from: classes.dex */
    public class a implements a.d {
        public final /* synthetic */ long a;
        public final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.b b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int[] f856c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a f857d;

        public a(long j2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.b bVar, int[] iArr, d.a aVar) {
            this.a = j2;
            this.b = bVar;
            this.f856c = iArr;
            this.f857d = aVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.d
        public void a(g gVar) {
            f fVar = f.this;
            long j2 = this.a;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.b bVar = this.b;
            fVar.a(j2, bVar.a, bVar.f853d, this.f856c[0], gVar, this.f857d);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.d
        public void a(AdError adError) {
            f.this.a(this.a, this.f856c[0], adError, this.b.a, this.f857d);
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.d {
        public final /* synthetic */ long a;
        public final /* synthetic */ AdSlot b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c f859c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a f860d;

        public b(long j2, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar, d.a aVar) {
            this.a = j2;
            this.b = adSlot;
            this.f859c = cVar;
            this.f860d = aVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.d
        public void a(g gVar) {
            f.this.a(this.a, this.b, this.f859c, 4, gVar, this.f860d);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.d
        public void a(AdError adError) {
            f.this.a(this.a, 4, adError, this.b, this.f860d);
        }
    }

    private List<j> a(List<j> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar) {
        if (list == null || list.size() == 0 || cVar == null || cVar.B() == null || cVar.B().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : cVar.B()) {
            Iterator<j> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    j next = it.next();
                    if (jVar != null && next != null && jVar.f() == 0 && !TextUtils.isEmpty(jVar.d()) && jVar.d().equals(next.d())) {
                        arrayList.add(jVar);
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, int i2, AdError adError, AdSlot adSlot, d.a aVar) {
        int i3 = (adError == null || adError.code != -1) ? 5 : 4;
        Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding网络请求响应失败......onFail  result:" + i3);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a aVar2 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a();
        aVar2.f848e = i3;
        aVar2.f849f = System.currentTimeMillis() - j2;
        aVar2.f850g = adError;
        if (aVar != null) {
            aVar.a(aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar, int i2, g gVar, d.a aVar) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a aVar2;
        int i3;
        j a2;
        Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding网络请求响返回.............");
        long currentTimeMillis = System.currentTimeMillis();
        if (cVar == null || gVar == null || f0.a(gVar.d())) {
            if (gVar == null || f0.a(gVar.c())) {
                r6 = i2;
            }
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding网络请求响应失败......没有返回serverBiddingModel相关数据");
            aVar2 = null;
        } else {
            List<h> d2 = gVar.d();
            aVar2 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a();
            aVar2.f851h = d2.size();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            sb.append("winners : {");
            for (h hVar : d2) {
                if (hVar != null && (a2 = cVar.a(hVar.i())) != null) {
                    j b2 = a2.b();
                    sb.append(" [ AdnName:" + b2.e() + ",slotId:" + b2.d() + ",loadSort:" + b2.p() + ",showSort:" + b2.y() + "] ");
                    b2.a(hVar);
                    arrayList.add(b2);
                }
            }
            sb.append("}");
            if (f0.a(arrayList)) {
                r6 = f0.a(gVar.c()) ? i2 : 2;
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding网络请求响应失败......：数据有返回，但没有返回winner数据......");
            } else {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding网络请求响应成功......：" + sb.toString());
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.addAll(arrayList);
                List<j> a3 = a(gVar.c(), cVar);
                if (a3 == null || a3.size() <= 0) {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding网络请求响应成功......server bidding物料......");
                    i3 = 3;
                } else {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding网络请求响应成功......waterfall+server bidding物料......");
                    copyOnWriteArrayList.addAll(a3);
                    i3 = 1;
                }
                aVar2.a = copyOnWriteArrayList;
                r6 = i3;
            }
        }
        if (gVar != null) {
            String b3 = gVar.b();
            if (!TextUtils.isEmpty(b3)) {
                if (aVar2 == null) {
                    aVar2 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a();
                }
                aVar2.f846c = b3;
            }
            if (gVar.e()) {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(adSlot.getAdUnitId()) + "server bidding发现config过期了，需要重新拉取配置......：");
                if (aVar2 == null) {
                    aVar2 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a();
                }
                aVar2.b = true;
            }
            if (!f0.a(gVar.a())) {
                if (aVar2 == null) {
                    aVar2 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a();
                }
                aVar2.f847d = gVar.a();
            }
        }
        if (aVar2 == null) {
            aVar2 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a();
        }
        aVar2.f848e = r6;
        aVar2.f849f = currentTimeMillis - j2;
        if (aVar != null) {
            aVar.a(aVar2);
        }
    }

    public void a(String str, long j2, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar, @NonNull d.a aVar) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.c().a(str, new b(j2, adSlot, cVar, aVar));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.d
    public void a(Map<String, TTAbsAdLoaderAdapter> map, Context context, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.b bVar, @NonNull d.a aVar) {
        if (bVar != null && bVar.a != null && bVar.f853d != null && !f0.a(bVar.b)) {
            String C = bVar.f853d.C();
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(bVar.a.getAdUnitId()) + "开启server bidding网络请求......：");
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(bVar.a, C);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.c().a(map, context, bVar.a, bVar.b, bVar.f852c, bVar.f853d, bVar.f854e, bVar.f855f, new a(System.currentTimeMillis(), bVar, new int[]{4}, aVar));
            return;
        }
        aVar.a(null);
        char c2 = '=';
        while (true) {
            char c3 = 'U';
            char c4 = ']';
            while (true) {
                switch (c3) {
                    case 'T':
                        return;
                    case 'U':
                        if (c4 < 27) {
                            break;
                        } else {
                            c3 = 'T';
                        }
                    case 'V':
                        break;
                    default:
                        c3 = 'T';
                }
                while (true) {
                    switch (c4) {
                        case '%':
                            while (true) {
                                switch (c2) {
                                    case 25:
                                    case 26:
                                        break;
                                    case 27:
                                        break;
                                    default:
                                        c2 = 27;
                                }
                            }
                            break;
                        case '&':
                            break;
                        case '\'':
                            break;
                        default:
                            c4 = '\'';
                    }
                }
                c3 = 'T';
            }
        }
        if (c2 <= '=') {
        }
        while (true) {
        }
    }
}
