package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.k;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.i;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.error.AdFreqError;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMNetworkRequestInfo;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.base.TTBaseAd;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class a extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.a {

    /* renamed from: j */
    private static volatile a f799j;

    /* renamed from: c */
    private final String[] f800c = {"unity", "ks"};

    /* renamed from: d */
    private final Map<String, Integer> f801d = new HashMap();

    /* renamed from: e */
    private final Map<String, Integer> f802e = new HashMap();

    /* renamed from: f */
    private final Map<String, CopyOnWriteArrayList<e>> f803f = new ConcurrentHashMap();

    /* renamed from: g */
    private final Map<String, j> f804g = new HashMap();

    /* renamed from: h */
    private final Map<String, String> f805h = new HashMap();

    /* renamed from: i */
    private final Map<String, Integer> f806i = new HashMap();

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a$a */
    /* loaded from: classes.dex */
    public class RunnableC0036a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ AdSlot b;

        /* renamed from: c */
        public final /* synthetic */ boolean f807c;

        /* renamed from: d */
        public final /* synthetic */ Map f808d;

        /* renamed from: e */
        public final /* synthetic */ Context f809e;

        /* renamed from: f */
        public final /* synthetic */ GMNetworkRequestInfo f810f;

        /* renamed from: g */
        public final /* synthetic */ i f811g;

        /* renamed from: h */
        public final /* synthetic */ GMAdSlotBase f812h;

        public RunnableC0036a(String str, AdSlot adSlot, boolean z, Map map, Context context, GMNetworkRequestInfo gMNetworkRequestInfo, i iVar, GMAdSlotBase gMAdSlotBase) {
            a.this = r1;
            this.a = str;
            this.b = adSlot;
            this.f807c = z;
            this.f808d = map;
            this.f809e = context;
            this.f810f = gMNetworkRequestInfo;
            this.f811g = iVar;
            this.f812h = gMAdSlotBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            e eVar;
            List<e> list = (List) a.this.f803f.get(this.a);
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (e eVar2 : list) {
                    if (eVar2 != null && eVar2.a.isHasShown()) {
                        list.remove(eVar2);
                        arrayList.add(eVar2);
                    }
                }
            }
            boolean z = false;
            if (Logger.isDebug()) {
                if (arrayList.size() <= 0 || (eVar = (e) arrayList.get(0)) == null) {
                    str = "";
                    str2 = str;
                } else {
                    str2 = e.c.c.a.a.c(eVar.a.getAdType(), eVar.a.getSubAdType());
                    str = eVar.a.getAdNetWorkName();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("--==-- 广告复用:show时缓存移除 -----：");
                sb.append(str);
                sb.append(", ");
                sb.append(str2);
                sb.append(", ");
                sb.append(this.a);
                sb.append(arrayList.size() > 0 ? ", size: " + arrayList.size() : "移除广告数为0");
                Logger.d("TTMediationSDK", sb.toString());
            }
            AdSlot adSlot = this.b;
            String adUnitId = adSlot != null ? adSlot.getAdUnitId() : "";
            AdSlot adSlot2 = this.b;
            boolean z2 = adSlot2 == null || adSlot2.getAdType() == 1;
            if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a(adUnitId, this.a) && this.f807c) {
                z = true;
            }
            if (z && !z2 && a.this.d(adUnitId, this.a)) {
                a.this.a(this.a, this.b, this.f808d, this.f809e, this.f810f, this.f811g, this.f812h);
                return;
            }
            Logger.d("TTMediationSDK", "--==-- 广告复用:show时预请求取消，因为：已发起waterfall预加载，或feed多广告，或未开启adn预加载，或是banner轮播 --: " + this.a);
        }
    }

    /* loaded from: classes.dex */
    public class b implements TTAbsAdLoaderAdapter.AdapterLoaderListener {
        private AdSlot a;

        public b(AdSlot adSlot) {
            a.this = r1;
            this.a = adSlot;
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdFailed(AdError adError, d dVar) {
            if (adError == null || dVar == null) {
                return;
            }
            Logger.d("TTMediationSDK", "--==-- 广告复用:show时预请求广告缓存失败 --- " + dVar.c() + ", " + dVar.d() + ", " + e.c.c.a.a.c(dVar.b(), dVar.h()) + ", errCode: " + adError.thirdSdkErrorCode + ",msg=" + adError.thirdSdkErrorMessage);
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdLoaded(TTBaseAd tTBaseAd, d dVar) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(tTBaseAd);
            onAdLoaded(arrayList, dVar);
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdLoaded(List<TTBaseAd> list, d dVar) {
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd != null) {
                    tTBaseAd.setFillTime(SystemClock.elapsedRealtime());
                    arrayList.add(new e(tTBaseAd, dVar, 0L, this.a));
                }
            }
            if (arrayList.size() > 0) {
                TTBaseAd tTBaseAd2 = ((e) arrayList.get(0)).a;
                Logger.d("TTMediationSDK", "--==-- 广告复用:show时预请求广告缓存成功 --- " + tTBaseAd2.getAdNetWorkName() + ", adType: " + e.c.c.a.a.c(tTBaseAd2.getAdType(), tTBaseAd2.getSubAdType()) + ", adnSlotId: " + tTBaseAd2.getAdNetworkSlotId() + ", ad个数: " + arrayList.size());
                a.this.a(tTBaseAd2.getAdNetworkSlotId(), arrayList);
            }
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdVideoCache() {
        }
    }

    private a() {
    }

    public static a a() {
        if (f799j == null) {
            synchronized (a.class) {
                if (f799j == null) {
                    f799j = new a();
                }
            }
        }
        return f799j;
    }

    private String a(List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a> list) {
        if (list.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            int i2 = 0;
            while (i2 < list.size()) {
                sb.append(list.get(i2).a());
                sb.append(i2 == list.size() + (-1) ? "]" : Constants.ACCEPT_TIME_SEPARATOR_SP);
                i2++;
            }
            try {
                return new JSONArray(sb.toString()).toString();
            } catch (JSONException e2) {
                Logger.d("TTMediationSDK", "--==-- 广告复用：adCannotUseInfo json err: " + e2.getMessage());
            }
        }
        return list.size() > 0 ? "json error" : HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public void a(String str, AdSlot adSlot, Map<String, Object> map, Context context, GMNetworkRequestInfo gMNetworkRequestInfo, i iVar, GMAdSlotBase gMAdSlotBase) {
        String a;
        String str2;
        StringBuilder sb;
        String str3;
        if (adSlot == null) {
            sb = new StringBuilder();
            str3 = "--==-- 广告复用:show时预请求取消，adSlot为空 -------: ";
        } else if (context != null) {
            j c2 = c(adSlot.getAdUnitId(), str);
            if (c2 != null) {
                try {
                    a = g.a(c2.q(), g.c(c2.e()), e.c.c.a.a.c(c2.t(), c2.z()));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (!TextUtils.isEmpty(a) || !g.a(a) || c2 == null) {
                    str2 = "--==-- 广告复用:show时预请求取消，className或wfcBean为空, className: " + a + ", wfcBean: " + c2 + ", adnSlotId: " + str;
                    Logger.d("TTMediationSDK", str2);
                }
                String[] strArr = this.f800c;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        String str4 = strArr[i2];
                        if (TextUtils.equals(str4, c2.e())) {
                            sb = new StringBuilder();
                            sb.append("--==-- 广告复用:show时预请求取消，");
                            sb.append(str4);
                            str3 = "为单例模式 -------: ";
                            break;
                        }
                        i2++;
                    } else {
                        int intValue = this.f806i.get(str) != null ? this.f806i.get(str).intValue() : -1;
                        Logger.d("TTMediationSDK", "--==-- 广告复用:show时预请求开始 -------: " + str);
                        TTAbsAdLoaderAdapter b2 = g.b(a);
                        if (b2 == null) {
                            h.a(c2, adSlot, 4, 1);
                            return;
                        }
                        h.b(c2, adSlot, 4, 1);
                        if (!k.b().b(adSlot.getAdUnitId(), c2.d())) {
                            Logger.d("TMe", "adn 代码位预请求触发次数拦截............");
                            Pair<String, String> d2 = k.b().d(adSlot.getAdUnitId(), c2.d());
                            if (d2 != null) {
                                AdFreqError adFreqError = new AdFreqError(AdError.ERROR_CODE_ADN_EXCEED_FREQCTL, AdError.getMessage(AdError.ERROR_CODE_ADN_EXCEED_FREQCTL), (String) d2.second, (String) d2.first);
                                h.a(c2, adSlot, a().a(c2.d()), true, 2, intValue, 4, 1, (AdError) adFreqError, -1L);
                                h.a(adFreqError, adSlot, c2, intValue, 4, 1, a().a(c2.d()), 0L, null, null, null);
                                return;
                            }
                            return;
                        }
                        b2.setAdapterListener(new b(adSlot));
                        b2.loadAdInter(context, c2, g.a(c2, adSlot, map, gMNetworkRequestInfo, 4, 1, true, -1L), adSlot, iVar, intValue, gMAdSlotBase);
                        sb = new StringBuilder();
                        str3 = "--==-- 广告复用:show时预请求已发完 -------: ";
                    }
                }
            }
            a = null;
            if (!TextUtils.isEmpty(a)) {
            }
            str2 = "--==-- 广告复用:show时预请求取消，className或wfcBean为空, className: " + a + ", wfcBean: " + c2 + ", adnSlotId: " + str;
            Logger.d("TTMediationSDK", str2);
        } else {
            sb = new StringBuilder();
            str3 = "--==-- 广告复用:show时预请求取消，context为null -------: ";
        }
        sb.append(str3);
        sb.append(str);
        str2 = sb.toString();
        Logger.d("TTMediationSDK", str2);
    }

    private boolean a(List<e> list, e eVar) {
        for (e eVar2 : list) {
            if (eVar2 != null && eVar != null && eVar2.a == eVar.a) {
                return true;
            }
        }
        return false;
    }

    private int b(String str, AdSlot adSlot, boolean z) {
        int i2;
        String str2;
        CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f803f.get(str);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            Logger.d("TTMediationSDK", "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
            return 1;
        }
        String adUnitId = adSlot != null ? adSlot.getAdUnitId() : "";
        ArrayList arrayList = new ArrayList();
        e eVar = null;
        boolean z2 = false;
        for (e eVar2 : copyOnWriteArrayList) {
            GMAdConstant.AdIsReadyStatus isReadyStatus = eVar2.a.isReadyStatus();
            if (isReadyStatus == GMAdConstant.AdIsReadyStatus.AD_IS_NOT_READY ? a(adUnitId, eVar2.a) : isReadyStatus != GMAdConstant.AdIsReadyStatus.AD_IS_READY) {
                copyOnWriteArrayList.remove(eVar2);
                i2 = 5;
                str2 = "--==-- 广告复用:广告过期了 -------: " + eVar2.a.getAdNetWorkName() + ", adSlotId: " + str;
            } else if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.a.a(eVar2.a(), adSlot, eVar2.a)) {
                Logger.d("TTMediationSDK", "--==-- 广告复用:复用成功：--------" + eVar2.a.getAdNetWorkName() + ", adSlotId: " + str);
                z2 = true;
            } else {
                i2 = 6;
                str2 = "--==-- 广告复用:AdSlot不符合 -------: " + eVar2.a.getAdNetWorkName() + ", adSlotId: " + str;
            }
            Logger.d("TTMediationSDK", str2);
            if (eVar == null) {
                eVar = eVar2;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a aVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a();
            aVar.c(eVar2.a.getLoadSort());
            aVar.e(eVar2.a.getShowSort());
            aVar.b(eVar2.a.getAdNetworkSlotId());
            aVar.d(i2);
            aVar.b(eVar2.a.isHasShown() ? 1 : 0);
            arrayList.add(aVar);
        }
        if (z2) {
            return 3;
        }
        if (z && eVar != null) {
            h.a(adSlot, eVar.a, a(arrayList));
        }
        return 2;
    }

    public int a(String str, AdSlot adSlot, boolean z) {
        int i2;
        synchronized (this) {
            i2 = 1;
            if (b(adSlot != null ? adSlot.getAdUnitId() : "", str) == 0) {
                i2 = b(str, adSlot, z);
            } else {
                CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f803f.get(str);
                if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                    Logger.d("TTMediationSDK", "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
                } else {
                    e eVar = null;
                    ArrayList arrayList = z ? new ArrayList() : null;
                    boolean z2 = false;
                    for (e eVar2 : copyOnWriteArrayList) {
                        int a = a(eVar2, eVar2.a(), adSlot, "广告复用");
                        if (a == -1) {
                            z2 = true;
                        } else {
                            if (a != 6) {
                                copyOnWriteArrayList.remove(eVar2);
                            }
                            if (z) {
                                if (eVar == null) {
                                    eVar = eVar2;
                                }
                                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a aVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a();
                                aVar.c(eVar2.a.getLoadSort());
                                aVar.e(eVar2.a.getShowSort());
                                aVar.b(eVar2.a.getAdNetworkSlotId());
                                aVar.d(a);
                                aVar.b(eVar2.a.isHasShown() ? 1 : 0);
                                arrayList.add(aVar);
                            }
                        }
                    }
                    if (z2) {
                        i2 = 3;
                    } else {
                        if (z && eVar != null) {
                            h.a(adSlot, eVar.a, a(arrayList));
                        }
                        i2 = 2;
                    }
                }
            }
        }
        return i2;
    }

    public String a(String str) {
        return this.f805h.get(str);
    }

    public List<e> a(String str, AdSlot adSlot) {
        ArrayList arrayList;
        synchronized (this) {
            CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f803f.get(str);
            if (copyOnWriteArrayList == null) {
                arrayList = null;
            } else {
                int adCount = adSlot != null ? adSlot.getAdCount() : 1;
                ArrayList<e> arrayList2 = new ArrayList();
                for (int i2 = 0; arrayList2.size() < adCount && i2 < copyOnWriteArrayList.size(); i2++) {
                    if (!copyOnWriteArrayList.get(i2).c() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.a.a(copyOnWriteArrayList.get(i2).a(), adSlot, copyOnWriteArrayList.get(i2).a)) {
                        arrayList2.add(copyOnWriteArrayList.get(i2));
                    }
                }
                for (int i3 = 0; arrayList2.size() < adCount && i3 < copyOnWriteArrayList.size(); i3++) {
                    if (copyOnWriteArrayList.get(i3).c() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.a.a(copyOnWriteArrayList.get(i3).a(), adSlot, copyOnWriteArrayList.get(i3).a)) {
                        arrayList2.add(copyOnWriteArrayList.get(i3));
                    }
                }
                for (e eVar : arrayList2) {
                    eVar.a(true);
                }
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    public void a(String str, AdSlot adSlot, Map<String, Object> map, boolean z, GMNetworkRequestInfo gMNetworkRequestInfo, i iVar, Context context, GMAdSlotBase gMAdSlotBase) {
        ThreadHelper.runOnMSDKThread(new RunnableC0036a(str, adSlot, z, map, context, gMNetworkRequestInfo, iVar, gMAdSlotBase));
    }

    public void a(String str, String str2, j jVar, int i2) {
        if (jVar != null) {
            Map<String, j> map = this.f804g;
            map.put(str + "_" + str2, jVar);
        }
        this.f806i.put(str2, Integer.valueOf(i2));
    }

    public void a(String str, List<e> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f803f.get(str);
        if (copyOnWriteArrayList == null) {
            this.f803f.put(str, new CopyOnWriteArrayList<>(list));
            return;
        }
        for (e eVar : list) {
            if (!a(copyOnWriteArrayList, eVar)) {
                copyOnWriteArrayList.add(eVar);
            }
        }
    }

    public j c(String str, String str2) {
        Map<String, j> map = this.f804g;
        return map.get(str + "_" + str2);
    }

    public boolean c(String str, String str2, int i2) {
        if (i2 == 2) {
            return false;
        }
        Map<String, Integer> map = this.f801d;
        Integer num = map.get(str + "_" + str2);
        return num != null && num.intValue() == 1;
    }

    public void d(String str, String str2, int i2) {
        Map<String, Integer> map = this.f802e;
        map.put(str + "_" + str2, Integer.valueOf(i2));
    }

    public boolean d(String str, String str2) {
        Map<String, Integer> map = this.f802e;
        Integer num = map.get(str + "_" + str2);
        return num != null && num.intValue() == 1;
    }

    public void e(String str, String str2) {
        this.f805h.put(str, str2);
    }

    public void e(String str, String str2, int i2) {
        Map<String, Integer> map = this.f801d;
        map.put(str + "_" + str2, Integer.valueOf(i2));
    }
}
