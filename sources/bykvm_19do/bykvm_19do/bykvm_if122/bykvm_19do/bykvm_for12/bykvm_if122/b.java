package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.v2.GMPreloadRequestInfo;
import com.bytedance.msdk.api.v2.ad.AdUtils;
import com.bytedance.msdk.base.TTBaseAd;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class b extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.a {
    private static volatile b o;

    /* renamed from: c */
    private final Map<String, Integer> f819c = new HashMap();

    /* renamed from: d */
    private final Map<String, Long> f820d = new HashMap();

    /* renamed from: e */
    private final Map<String, AdSlot> f821e = new HashMap();

    /* renamed from: f */
    private final Map<String, Map<String, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e>>> f822f = new HashMap();

    /* renamed from: g */
    private final Map<String, Map<String, AdError>> f823g = new HashMap();

    /* renamed from: h */
    private final Map<String, Boolean> f824h = new HashMap();

    /* renamed from: i */
    private final Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c> f825i = new HashMap();

    /* renamed from: j */
    private boolean f826j = false;

    /* renamed from: k */
    private int f827k = 20;

    /* renamed from: l */
    private List<String> f828l;

    /* renamed from: m */
    private int f829m;
    private int n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        /* renamed from: c */
        public final /* synthetic */ int f830c;

        public a(Context context, String str, int i2) {
            b.this = r1;
            this.a = context;
            this.b = str;
            this.f830c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.a, this.b, 2, this.f830c, (f) null);
        }
    }

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b$b */
    /* loaded from: classes.dex */
    public class RunnableC0037b implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        /* renamed from: c */
        public final /* synthetic */ int f832c;

        public RunnableC0037b(Context context, String str, int i2) {
            b.this = r1;
            this.a = context;
            this.b = str;
            this.f832c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.a, this.b, 4, this.f832c, (f) null);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ List b;

        /* renamed from: c */
        public final /* synthetic */ int f834c;

        /* renamed from: d */
        public final /* synthetic */ int f835d;

        /* loaded from: classes.dex */
        public class a implements e {
            public a() {
                c.this = r1;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.e
            public void a(boolean z) {
                if (z) {
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c().a(b.this.f822f);
            }
        }

        public c(Activity activity, List list, int i2, int i3) {
            b.this = r1;
            this.a = activity;
            this.b = list;
            this.f834c = i2;
            this.f835d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (b.this.f826j) {
                str = "注意：预加载preload只能调用一次";
            } else if (this.a == null) {
                str = "预加载preload传入的activity不能是null";
            } else {
                List list = this.b;
                if (list != null && list.size() > 0) {
                    b.this.f826j = true;
                    b.this.f829m = this.f834c;
                    b.this.n = this.f835d;
                    b.this.f828l = new ArrayList();
                    for (GMPreloadRequestInfo gMPreloadRequestInfo : this.b) {
                        if (gMPreloadRequestInfo != null && gMPreloadRequestInfo.getPrimeRitList() != null) {
                            b.this.f828l.addAll(gMPreloadRequestInfo.getPrimeRitList());
                        }
                    }
                    int i2 = this.f834c;
                    int i3 = (i2 < 1 || i2 > 20) ? 2 : i2;
                    int i4 = this.f835d;
                    int i5 = (i4 < 1 || i4 > 10) ? 2 : i4;
                    List a2 = b.this.a(this.b);
                    if (a2.size() > 0) {
                        new d(this.a, a2, i3, i5, new a()).a();
                        return;
                    }
                    return;
                }
                str = "预加载preload传入的requestInfos不能是null或者size为0";
            }
            Logger.d("TTMediationSDK", str);
        }
    }

    /* loaded from: classes.dex */
    public class d {
        private final Activity a;
        private final int b;

        /* renamed from: c */
        private final int f837c;

        /* renamed from: d */
        private final List<GMPreloadRequestInfo> f838d;

        /* renamed from: e */
        private final e f839e;

        /* renamed from: f */
        private int f840f;

        /* renamed from: g */
        private int f841g;

        /* loaded from: classes.dex */
        public class a implements f {
            public a() {
                d.this = r1;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.f
            public void a(String str, boolean z) {
                d.d(d.this);
                if (!z) {
                    d.f(d.this);
                }
                Logger.d("TTMediationSDK", "--==-- pendingLoadNum: " + d.this.f840f);
                if (d.this.f840f > 0 || d.this.f839e == null) {
                    return;
                }
                d.this.f839e.a(d.this.f841g <= 0);
            }
        }

        /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b$d$b */
        /* loaded from: classes.dex */
        public class RunnableC0038b implements Runnable {
            public RunnableC0038b() {
                d.this = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.a();
            }
        }

        public d(Activity activity, List<GMPreloadRequestInfo> list, int i2, int i3, e eVar) {
            b.this = r1;
            this.a = activity;
            this.f838d = list;
            this.b = i2;
            this.f837c = i3;
            this.f839e = eVar;
            this.f840f = list.size();
            this.f841g = list.size();
        }

        public void a() {
            GMPreloadRequestInfo remove;
            StringBuilder sb;
            String str;
            for (int i2 = 0; i2 < this.b; i2++) {
                if (this.f838d.size() > 0 && (remove = this.f838d.remove(0)) != null) {
                    AdSlot convertGMAdSlotBase2AdSlot = AdUtils.convertGMAdSlotBase2AdSlot(remove.getGmAdSlot());
                    String str2 = remove.getPrimeRitList().get(0);
                    if (convertGMAdSlotBase2AdSlot == null) {
                        sb = new StringBuilder();
                        str = "预加载preload传入的GMAdSlotBase为空，广告位：";
                    } else if (convertGMAdSlotBase2AdSlot.getAdType() == 1) {
                        sb = new StringBuilder();
                        str = "预加载preload传入的GMAdSlotBase为banner类型，不支持该类型预加载，广告位: ";
                    } else if (convertGMAdSlotBase2AdSlot.getAdType() == 2) {
                        sb = new StringBuilder();
                        str = "预加载preload传入的GMAdSlotBase为插屏类型，不支持该类型预加载，广告位: ";
                    } else if (convertGMAdSlotBase2AdSlot.getAdType() == 9) {
                        sb = new StringBuilder();
                        str = "预加载preload传入的GMAdSlotBase为Draw类型，不支持该类型预加载，广告位: ";
                    } else {
                        b.this.a(str2, convertGMAdSlotBase2AdSlot);
                        b.this.a(this.a, str2, 5, 0, new a());
                    }
                    sb.append(str);
                    sb.append(str2);
                    Logger.d("TTMediationSDK", sb.toString());
                }
            }
            if (this.f838d.size() > 0) {
                ThreadHelper.postDelayOnMSDKThread(new RunnableC0038b(), this.f837c * 1000);
            }
        }

        public static /* synthetic */ int d(d dVar) {
            int i2 = dVar.f840f;
            dVar.f840f = i2 - 1;
            return i2;
        }

        public static /* synthetic */ int f(d dVar) {
            int i2 = dVar.f841g;
            dVar.f841g = i2 - 1;
            return i2;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(String str, boolean z);
    }

    private b() {
    }

    private String a(List<j> list, String str, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c cVar) {
        String str2;
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> list2;
        if (list.size() <= 0) {
            return null;
        }
        Map<String, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e>> map = this.f822f.get(str);
        int i2 = 0;
        if (map != null && (list2 = map.get(list.get(0).d())) != null && list2.size() > 0 && list2.get(0) != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e eVar = list2.get(0);
            if (a(eVar, eVar.a(), adSlot, "聚合预请求") == -1) {
                str2 = TTLogUtil.getTagSecondLevel(str) + "--==-- 命中最优广告： " + eVar.a.getAdNetWorkName() + ", loadSort: " + eVar.a.getLoadSort() + ", showSort: " + eVar.a.getShowSort();
                Logger.d("TTMediationSDK", str2);
                return null;
            }
        }
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a> a2 = a(list, str, map, adSlot, cVar);
        if (a2.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder("[");
        while (i2 < a2.size()) {
            sb.append(a2.get(i2).a());
            sb.append(i2 == a2.size() + (-1) ? "]" : Constants.ACCEPT_TIME_SEPARATOR_SP);
            i2++;
        }
        try {
            String jSONArray = new JSONArray(sb.toString()).toString();
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "adCannotUseInfo: " + jSONArray);
            return jSONArray;
        } catch (JSONException e2) {
            str2 = TTLogUtil.getTagSecondLevel(str) + "adCannotUseInfo json err: " + e2.getMessage();
        }
    }

    public List<GMPreloadRequestInfo> a(List<GMPreloadRequestInfo> list) {
        ArrayList arrayList = new ArrayList();
        int i2 = this.f827k;
        HashSet hashSet = new HashSet();
        for (GMPreloadRequestInfo gMPreloadRequestInfo : list) {
            if (arrayList.size() >= i2) {
                break;
            } else if (gMPreloadRequestInfo != null && gMPreloadRequestInfo.getPrimeRitList() != null) {
                for (String str : gMPreloadRequestInfo.getPrimeRitList()) {
                    if (arrayList.size() < i2) {
                        if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                            hashSet.add(str);
                            ArrayList arrayList2 = new ArrayList(1);
                            arrayList2.add(str);
                            arrayList.add(new GMPreloadRequestInfo(gMPreloadRequestInfo.getGmAdSlot(), arrayList2));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a> a(List<j> list, String str, Map<String, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e>> map, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c cVar) {
        int i2;
        int i3;
        TTBaseAd tTBaseAd;
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> list2;
        ArrayList arrayList = new ArrayList();
        int d0 = (cVar.h() == 2 && (cVar instanceof bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.d)) ? ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.d) cVar).d0() : 0;
        while (i2 < list.size() && i2 < d0) {
            String d2 = list.get(i2).d();
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a aVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a();
            aVar.b(d2);
            aVar.e(list.get(i2).y());
            aVar.c(list.get(i2).p());
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e eVar = (map == null || (list2 = map.get(d2)) == null || list2.size() <= 0) ? null : list2.get(0);
            if (eVar == null || (tTBaseAd = eVar.a) == null) {
                Map<String, AdError> map2 = this.f823g.get(str);
                AdError adError = map2 != null ? map2.get(d2) : null;
                if (adError != null) {
                    aVar.d(3);
                    aVar.a(adError.thirdSdkErrorCode);
                    aVar.a(adError.thirdSdkErrorMessage);
                    arrayList.add(aVar);
                } else {
                    i3 = 4;
                }
            } else {
                aVar.b(tTBaseAd.isHasShown() ? 1 : 0);
                i3 = a(eVar, this.f821e.get(str), adSlot, "预缓存");
                i2 = i3 == -1 ? i2 + 1 : 0;
            }
            aVar.d(i3);
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public void a(Context context, String str, int i2, int i3, f fVar) {
        boolean z;
        int a2 = a(str, i3);
        if (a2 != 2) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- 配置未开启预加载缓存，req_type: " + a2);
            if (fVar == null) {
                return;
            }
            z = false;
        } else if (this.f824h.get(str) == null || !this.f824h.get(str).booleanValue()) {
            AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(this.f821e.get(str));
            if (shallowCopy == null) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- 预缓存取消，adslot为null，rit：" + str);
                return;
            }
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- 预缓存开始请求, req_type: " + a2);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.d dVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.d(context, str);
            this.f825i.put(str, dVar);
            this.f824h.put(str, Boolean.TRUE);
            shallowCopy.setPrimeRitReqType(i2);
            dVar.a(shallowCopy, fVar);
            return;
        } else {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- 已发起过预缓存，还未使用掉，此次不发起");
            if (fVar == null) {
                return;
            }
            z = true;
        }
        fVar.a(str, z);
    }

    private void b(String str, AdSlot adSlot) {
        Map<String, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e>> map = this.f822f.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> list = map.get(str2);
                if (list != null && list.size() > 0 && list.get(0) != null) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e eVar = list.get(0);
                    if (a(eVar, eVar.a(), adSlot, "聚合预缓存") != -1) {
                        map.put(str2, null);
                    }
                }
            }
        }
    }

    public static b d() {
        if (o == null) {
            synchronized (b.class) {
                if (o == null) {
                    o = new b();
                }
            }
        }
        return o;
    }

    public int a() {
        return this.f829m;
    }

    public int a(String str, int i2) {
        Integer num;
        if (i2 == 2 || (num = this.f819c.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public AdSlot a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f821e.get(str);
    }

    public void a(int i2) {
        this.f827k = i2;
    }

    public void a(Activity activity, List<GMPreloadRequestInfo> list, int i2, int i3) {
        ThreadHelper.runOnMSDKThread(new c(activity, list, i2, i3));
    }

    public void a(Context context, String str, int i2) {
        ThreadHelper.runOnMSDKThread(new a(context, str, i2));
    }

    public void a(String str, long j2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f820d.put(str, Long.valueOf(j2));
    }

    public void a(String str, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e eVar) {
        if (d(str) == null || d(str).longValue() == eVar.b()) {
            Map<String, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e>> map = this.f822f.get(str);
            String adNetworkSlotId = eVar.a.getAdNetworkSlotId();
            if (map == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eVar);
                HashMap hashMap = new HashMap();
                hashMap.put(adNetworkSlotId, arrayList);
                this.f822f.put(str, hashMap);
                return;
            }
            List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> list = map.get(adNetworkSlotId);
            if (list != null) {
                list.add(eVar);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(eVar);
            map.put(adNetworkSlotId, arrayList2);
        }
    }

    public void a(String str, AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f821e.put(str, adSlot);
    }

    public void a(String str, String str2, long j2, AdError adError) {
        if (d(str) == null || d(str).longValue() == j2) {
            Map<String, AdError> map = this.f823g.get(str);
            if (map == null) {
                map = new HashMap<>();
                this.f823g.put(str, map);
            }
            map.put(str2, adError);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9 A[PHI: r9 
      PHI: (r9v3 char) = (r9v1 char), (r9v4 char), (r9v4 char) binds: [B:69:0x00c7, B:73:0x00cf, B:75:0x00d3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cd A[FALL_THROUGH, PHI: r9 
      PHI: (r9v2 char) = (r9v3 char), (r9v4 char), (r9v4 char) binds: [B:70:0x00c9, B:73:0x00cf, B:75:0x00d3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x00c7 -> B:70:0x00c9). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x00c9 -> B:77:0x00d7). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x00cd -> B:73:0x00cf). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x00d3 -> B:77:0x00d7). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r9, com.bytedance.msdk.api.AdSlot r10, java.lang.String r11) {
        /*
            r8 = this;
            java.util.Map<java.lang.String, java.lang.Boolean> r0 = r8.f824h
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.put(r9, r1)
            java.util.Map<java.lang.String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c> r0 = r8.f825i
            java.lang.Object r0 = r0.get(r9)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c r0 = (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c) r0
            r1 = 0
            if (r0 == 0) goto Ldc
            java.util.List r2 = r0.K()
            boolean r3 = com.bytedance.msdk.adapter.util.Logger.isDebug()
            if (r3 == 0) goto L72
            java.util.Iterator r3 = r2.iterator()
        L20:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L72
            java.lang.Object r4 = r3.next()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r4 = (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagSecondLevel(r9)
            r5.append(r6)
            java.lang.String r6 = "waterfall: "
            r5.append(r6)
            java.lang.String r6 = r4.e()
            r5.append(r6)
            java.lang.String r6 = ", loadSort: "
            r5.append(r6)
            int r6 = r4.p()
            r5.append(r6)
            java.lang.String r6 = ", showSort: "
            r5.append(r6)
            int r6 = r4.y()
            r5.append(r6)
            java.lang.String r6 = ", eCpm: "
            r5.append(r6)
            double r6 = r4.i()
            r5.append(r6)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "TTMediationSDK"
            com.bytedance.msdk.adapter.util.Logger.d(r5, r4)
            goto L20
        L72:
            java.lang.String r3 = r8.a(r2, r9, r10, r0)
            r8.b(r9, r10)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e>>> r4 = r8.f822f
            java.lang.Object r4 = r4.get(r9)
            java.util.Map r4 = (java.util.Map) r4
            if (r4 == 0) goto Laf
            int r0 = r0.h()
            r5 = 2
            if (r0 != r5) goto Laf
            r0 = 0
        L8b:
            int r5 = r2.size()
            if (r0 >= r5) goto Laf
            java.lang.Object r5 = r2.get(r0)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r5 = (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) r5
            java.lang.String r5 = r5.d()
            java.lang.Object r5 = r4.get(r5)
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto Lac
            int r5 = r5.size()
            if (r5 <= 0) goto Lac
            r0 = 1
            r1 = 1
            goto Laf
        Lac:
            int r0 = r0 + 1
            goto L8b
        Laf:
            if (r3 == 0) goto Lc7
            if (r1 == 0) goto Lbf
            java.util.Map<java.lang.String, com.bytedance.msdk.api.AdSlot> r10 = r8.f821e
            java.lang.Object r9 = r10.get(r9)
            com.bytedance.msdk.api.AdSlot r9 = (com.bytedance.msdk.api.AdSlot) r9
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(r9, r3, r11)
            goto Ld7
        Lbf:
            r9 = 3
            r10.setPrimeRitReqType(r9)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(r10, r3, r11)
            goto Ldc
        Lc7:
            r9 = 86
        Lc9:
            switch(r9) {
                case 85: goto Lcd;
                case 86: goto Ldc;
                case 87: goto Ld7;
                default: goto Lcc;
            }
        Lcc:
            goto Lc7
        Lcd:
            r10 = 70
        Lcf:
            switch(r10) {
                case 70: goto Ldc;
                case 71: goto Ld3;
                case 72: goto Lc9;
                default: goto Ld2;
            }
        Ld2:
            goto Lcd
        Ld3:
            switch(r9) {
                case 32: goto Ldc;
                case 33: goto Lcd;
                case 34: goto Ld7;
                default: goto Ld6;
            }
        Ld6:
            goto Lc9
        Ld7:
            r9 = 85
            r10 = 72
            goto Lcf
        Ldc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.a(java.lang.String, com.bytedance.msdk.api.AdSlot, java.lang.String):boolean");
    }

    public List<String> b() {
        return this.f828l;
    }

    public Map<String, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e>> b(String str) {
        return this.f822f.get(str);
    }

    public void b(Context context, String str, int i2) {
        ThreadHelper.runOnMSDKThread(new RunnableC0037b(context, str, i2));
    }

    public void b(String str, int i2) {
        this.f819c.put(str, Integer.valueOf(i2));
    }

    public int c() {
        return this.n;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c c(String str) {
        return this.f825i.get(str);
    }

    public Long d(String str) {
        return this.f820d.get(str);
    }

    public List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> e(String str) {
        ArrayList arrayList = new ArrayList();
        Map<String, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e>> map = this.f822f.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> list = map.get(str2);
                if (list != null && list.size() > 0) {
                    arrayList.addAll(list);
                }
            }
        }
        if (map != null) {
            map.clear();
        }
        Map<String, AdError> map2 = this.f823g.get(str);
        if (map2 != null) {
            map2.clear();
        }
        return arrayList;
    }
}
