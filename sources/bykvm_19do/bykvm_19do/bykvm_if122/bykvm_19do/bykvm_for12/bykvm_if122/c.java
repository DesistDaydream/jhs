package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122;

import android.content.Context;
import android.os.SystemClock;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.f;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.f0;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.v2.ad.AdUtils;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class c extends f {
    private long g0;

    public c(Context context, String str) {
        super(context, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0019 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c r1, com.bytedance.msdk.api.AdError r2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d r3) {
        /*
            super.onAdFailed(r2, r3)
        L3:
            r1 = 94
            r2 = 75
            r3 = 93
        L9:
            r0 = 92
            if (r1 == r0) goto L10
            if (r1 == r3) goto L13
            goto L1a
        L10:
            switch(r2) {
                case 21: goto L1a;
                case 22: goto L1a;
                case 23: goto L1a;
                default: goto L13;
            }
        L13:
            switch(r2) {
                case 91: goto L3;
                case 92: goto L1a;
                case 93: goto L19;
                default: goto L16;
            }
        L16:
            r2 = 91
            goto L13
        L19:
            return
        L1a:
            r1 = 93
            r2 = 93
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c, com.bytedance.msdk.api.AdError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d):void");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void O() {
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                            case 21:
                                return;
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    return;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            return;
                        }
                }
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void P() {
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
                        case 21:
                            return;
                        case 22:
                        case 23:
                            c2 = ']';
                            c3 = ']';
                    }
                } else if (c2 != ']') {
                    c2 = ']';
                    c3 = ']';
                }
            }
            while (true) {
                switch (c3) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        return;
                    default:
                        c3 = '[';
                }
            }
        }
    }

    public void a(AdSlot adSlot, b.f fVar) {
        this.g0 = SystemClock.currentThreadTimeMillis();
        b.d().a(this.f896f, this.g0);
        this.f898h = adSlot;
        this.w = AdUtils.covertAdSlot2GMAdSlotBase(adSlot);
        this.I = null;
        this.b0 = fVar;
        S();
        for (char c2 = 'I'; c2 != 'H'; c2 = 'H') {
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void b(AdError adError) {
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
                        case 21:
                            return;
                        case 22:
                        case 23:
                            c2 = ']';
                            c3 = ']';
                    }
                } else if (c2 != ']') {
                    c2 = ']';
                    c3 = ']';
                }
            }
            while (true) {
                switch (c3) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        return;
                    default:
                        c3 = '[';
                }
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    public void b(List<j> list) {
        boolean z;
        TTBaseAd tTBaseAd;
        super.b(list);
        Map<String, List<e>> b = b.d().b(this.f896f);
        if (b == null || b.keySet() == null) {
            return;
        }
        CopyOnWriteArrayList<TTBaseAd> copyOnWriteArrayList = new CopyOnWriteArrayList();
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(b.keySet());
        for (String str : arrayList) {
            List<e> list2 = b.get(str);
            if (list2 != null && list2.size() > 0) {
                for (e eVar : list2) {
                    if (eVar != null && (tTBaseAd = eVar.a) != null && tTBaseAd.isNormalAd()) {
                        copyOnWriteArrayList.add(eVar.a);
                    }
                }
            }
        }
        if (copyOnWriteArrayList.size() != 0) {
            if (f0.a(list)) {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "处理预缓存逻辑......没有胜出的普通广告，普通广告被全部过滤掉了");
                return;
            }
            for (TTBaseAd tTBaseAd2 : copyOnWriteArrayList) {
                Iterator<j> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    j next = it.next();
                    if (tTBaseAd2 != null && next != null && tTBaseAd2.getAdNetworkSlotId().equals(next.d())) {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "处理预缓存逻辑......已经响应的广告: " + tTBaseAd2.getAdNetworkSlotId() + "  没有在severBidding的waterFall列表中，需要被移除掉");
                    copyOnWriteArrayList.remove(tTBaseAd2);
                }
            }
            for (TTBaseAd tTBaseAd3 : copyOnWriteArrayList) {
                if (tTBaseAd3 != null) {
                    b.remove(tTBaseAd3.getAdNetworkSlotId());
                }
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void b(List<TTBaseAd> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        if (list == null) {
            return;
        }
        for (TTBaseAd tTBaseAd : list) {
            if (tTBaseAd != null) {
                b.d().a(this.f896f, new e(tTBaseAd, dVar, this.g0, this.f898h));
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.f, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdFailed(AdError adError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        a(this, adError, dVar);
        b.d().a(this.f896f, dVar.d(), this.g0, adError);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    public boolean t() {
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                            case 21:
                                return true;
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    return true;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            return true;
                        }
                }
            }
        }
    }
}
