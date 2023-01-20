package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.os.Message;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.f0;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class f extends e {
    public Map<Integer, Integer> e0;
    public boolean f0;

    public f(Context context, String str) {
        super(context, str);
        this.e0 = new HashMap();
        this.f0 = false;
    }

    private void d0() {
        if (s()) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "抛出成功回调_广告池中广告满足数量直接返回......");
            if (m()) {
                Logger.i("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "当前广告池中有广告且满足client bididing的返回条件...给出成功回调...");
                q();
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    public void A() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (cVar == null || !cVar.J()) {
            super.A();
        } else {
            d0();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void X() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (cVar == null || !cVar.J()) {
            super.X();
            return;
        }
        a0();
        c0();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    public void a() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (cVar == null || !cVar.J()) {
            super.a();
            return;
        }
        this.f0 = false;
        c0();
        A();
    }

    public void a(int i2, int i3, boolean z) {
        int i4;
        if (i3 < -100) {
            b(i2, z);
            return;
        }
        if (i3 == -100) {
            i4 = i2 + 1;
        } else if (i3 == 0) {
            for (int i5 = 0; i5 < I(); i5++) {
                int i6 = i2 + i5 + 1;
                if (i6 < this.n.size()) {
                    a(i6, z);
                }
            }
            return;
        } else {
            i4 = i(i2);
            if (i4 <= -1) {
                return;
            }
        }
        a(i4, z);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    public void a(int i2, boolean z) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (cVar == null || !cVar.J()) {
            super.a(i2, z);
        } else {
            c(i2, z);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void a(Message message) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (cVar == null || !cVar.J()) {
            super.a(message);
            return;
        }
        b(message);
        while (true) {
            char c2 = 'J';
            char c3 = '7';
            while (true) {
                switch (c2) {
                    case 'H':
                        break;
                    case 'I':
                        switch (c3) {
                            case '^':
                                break;
                            case '_':
                            case '`':
                                return;
                            default:
                                if (c3 != '8' || c3 == '9') {
                                    return;
                                }
                                break;
                        }
                        c2 = 'I';
                        c3 = '`';
                        break;
                    case 'J':
                        if (c3 != '8') {
                            return;
                        }
                        return;
                    default:
                        c2 = 'H';
                }
            }
        }
    }

    public void a0() {
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            this.e0.put(this.n.get(i2), 0);
        }
    }

    public void b(int i2, boolean z) {
        int j2 = j(i2);
        if (j2 > -1) {
            a(j2, z);
        } else if (b0() && !this.f0) {
            this.f0 = true;
            int h2 = h(i2);
            if (h2 > 0) {
                if (this.n.get(h2).intValue() <= 0) {
                    if (this.n.get(h2).intValue() != 0 && v()) {
                        return;
                    }
                    a(h2, z);
                    return;
                }
                for (int i3 = 0; i3 < I(); i3++) {
                    int i4 = h2 + i3;
                    if (i4 < this.n.size()) {
                        a(i4, z);
                    }
                }
            }
        }
    }

    public void b(Message message) {
        StringBuilder sb;
        List<TTBaseAd> list;
        int i2;
        List<TTBaseAd> list2;
        List<TTBaseAd> list3;
        int i3 = message.what;
        if (i3 == 1) {
            if (message.arg1 == 10003) {
                int intValue = ((Integer) message.obj).intValue();
                this.e0.put(Integer.valueOf(intValue), 4);
                if (p() && !x()) {
                    Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "当前层超时....server Bidding 的请求还没有返回，继续执行下一层普通层(不一定执行)....mTTCommonAdPoolList.size()=" + this.o.size());
                    int f2 = f(intValue);
                    if (f2 <= -1 || (i2 = i(f2)) <= -1) {
                        return;
                    }
                } else if (s()) {
                    Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "当前层超时....广告池已有广告不执行下层....mTTCommonAdPoolList.size()=" + this.o.size());
                    if (!m()) {
                        return;
                    }
                    sb = new StringBuilder();
                    sb.append(TTLogUtil.getTagSecondLevel(this.f896f));
                    sb.append("当前层超时....广告池已有广告不执行下层且满足client bidding的返回条件....mTTCommonAdPoolList.size()=");
                    list = this.o;
                } else {
                    Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "当前层超时....普通广告池没广告尝试执行下层(不一定执行)....mTTCommonAdPoolList.size()=" + this.o.size());
                    int f3 = f(intValue);
                    if (f3 <= -1 || (i2 = i(f3)) <= -1) {
                        return;
                    }
                }
                a(i2, false);
                return;
            }
            return;
        } else if (i3 == 2) {
            M();
            return;
        } else if (i3 == 3) {
            L();
            return;
        } else if (i3 != 4) {
            if (i3 != 5) {
                return;
            }
            this.x.set(true);
            if (p() && x()) {
                if (s()) {
                    Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "SeverBidding广告成功返回且到达ClientBidding的等待时间，广告池中的广告数量满足...直接返回......");
                    q();
                }
                if (this.s.g() || !this.s.f()) {
                    return;
                }
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "所有广告都已经加载完成....... ");
                List<TTBaseAd> list4 = this.q;
                if ((list4 == null || list4.size() <= 0) && (((list2 = this.o) == null || list2.size() <= 0) && ((list3 = this.p) == null || list3.size() <= 0))) {
                    a(new AdError(20005, AdError.getMessage(20005)), (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
                    return;
                }
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "SeverBidding广告返回且到达ClientBidding的等待时间，所有广告都有返回结果...直接返回......");
                q();
            }
            return;
        } else {
            int intValue2 = ((Integer) message.obj).intValue();
            if (this.e0.get(Integer.valueOf(intValue2)) != null && this.e0.get(Integer.valueOf(intValue2)).intValue() == 1) {
                this.e0.put(Integer.valueOf(intValue2), 4);
            }
            if (!r()) {
                Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "当前层超时....P层广告池没广告或者数量不达标,尝试执行下层(不一定执行)....mTTPAdPoolList.size()=" + this.q.size());
                int f4 = f(intValue2);
                if (f4 > -1) {
                    b(f4, false);
                    return;
                }
                return;
            }
            sb = new StringBuilder();
            sb.append(TTLogUtil.getTagSecondLevel(this.f896f));
            sb.append("当前层超时....广告池已有P层类型广告不执行下层....mTTPAdPoolList.size()=");
            list = this.q;
        }
        sb.append(list.size());
        Logger.w("TTMediationSDK", sb.toString());
        q();
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0191, code lost:
        if (android.text.TextUtils.isEmpty(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_this102.a.a(r1.getTestSlotId())) == false) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(com.bytedance.msdk.api.AdError r9, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d r10) {
        /*
            Method dump skipped, instructions count: 742
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.f.b(com.bytedance.msdk.api.AdError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d):void");
    }

    public boolean b0() {
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            if (this.n.get(i2).intValue() < -100 && (this.e0.get(this.n.get(i2)).intValue() == 0 || this.e0.get(this.n.get(i2)).intValue() == 1)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x028c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(int r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 790
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.f.c(int, boolean):void");
    }

    public void c(List<TTBaseAd> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        if (this.f897g == null || dVar == null) {
            return;
        }
        if (dVar != null) {
            a(dVar.d(), dVar.c(), dVar.e(), e.c.c.a.a.c(dVar.b(), dVar.h()), 0, AdLoadInfo.AD_LOADED);
        }
        a(list, dVar);
        if (dVar.a() == 0 && !f0.b(list)) {
            String adNetworkSlotId = list.get(0).getAdNetworkSlotId();
            if (a(adNetworkSlotId)) {
                this.e0.put(Integer.valueOf(list.get(0).getShowSort()), 3);
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
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "P层广告已经成功返回loadSort:" + list.get(0).getLoadSort() + " ,showSort:" + list.get(0).getShowSort());
            this.e0.put(Integer.valueOf(list.get(0).getShowSort()), 2);
        } else if (((!p() && !n()) || (p() && x())) && !f0.b(list) && list.get(0).isNormalAd() && s()) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "普通层广告已经成功返回loadSort:" + list.get(0).getLoadSort() + " ,showSort:" + list.get(0).getShowSort());
            if (!m()) {
                return;
            }
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "满足广告的返回条件...直接返回...");
        } else if (dVar.m() && s() && m()) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "SeverBidding广告返回结果且满足ClientBidding等待时间时广告池中有广告直接返回......");
        } else if (!this.s.f() || !m()) {
            return;
        } else {
            Logger.i("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f896f) + "所有层级和所有waterfall都已完成直接回调...");
        }
        q();
    }

    public void c0() {
        if (f0.b(this.n)) {
            return;
        }
        int intValue = this.n.get(0).intValue();
        if (intValue < -100) {
            for (int i2 = 0; i2 < I(); i2++) {
                if (i2 < this.n.size() && this.n.get(i2).intValue() < -100) {
                    a(i2, false);
                }
            }
        } else if (intValue == -100 || intValue == 0) {
            a(0, false);
        } else {
            for (int i3 = 0; i3 < I(); i3++) {
                if (i3 < this.n.size()) {
                    a(i3, false);
                }
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public boolean d(int i2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        return (cVar == null || !cVar.J()) ? super.d(i2) : g(i2);
    }

    public int f(int i2) {
        int i3 = -1;
        for (int i4 = 0; i4 < this.n.size(); i4++) {
            if (this.n.get(i4).intValue() == i2) {
                i3 = i4;
            }
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean g(int r14) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.f.g(int):boolean");
    }

    public int h(int i2) {
        for (int i3 = 0; i3 < this.n.size(); i3++) {
            int i4 = i2 + i3 + 1;
            if (i4 < this.n.size()) {
                int intValue = this.n.get(i4).intValue();
                if (this.e0.get(Integer.valueOf(intValue)) != null && this.e0.get(Integer.valueOf(intValue)).intValue() == 0) {
                    return i4;
                }
            }
        }
        return -1;
    }

    public int i(int i2) {
        int intValue;
        for (int i3 = 0; i3 < this.n.size(); i3++) {
            int i4 = i2 + i3 + 1;
            if (i4 < this.n.size() && (intValue = this.n.get(i4).intValue()) > 0 && this.e0.get(Integer.valueOf(intValue)).intValue() == 0) {
                return i4;
            }
        }
        return -1;
    }

    public int j(int i2) {
        int intValue;
        for (int i3 = 0; i3 < this.n.size(); i3++) {
            int i4 = i2 + i3 + 1;
            if (i4 < this.n.size() && (intValue = this.n.get(i4).intValue()) < -100 && this.e0.get(Integer.valueOf(intValue)).intValue() == 0) {
                return i4;
            }
        }
        return -1;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdFailed(AdError adError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (cVar == null || !cVar.J()) {
            super.onAdFailed(adError, dVar);
        } else {
            b(adError, dVar);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdLoaded(List<TTBaseAd> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (cVar == null || !cVar.J()) {
            super.onAdLoaded(list, dVar);
        } else {
            c(list, dVar);
        }
    }
}
