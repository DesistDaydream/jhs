package com.bytedance.msdk.adapter.gdt;

import android.content.Context;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMNativeBaseAdapter;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import com.qq.e.comm.managers.status.SDKStatus;

/* loaded from: classes.dex */
public class GdtNativeAdapter extends GMNativeBaseAdapter {
    private GMAdSlotGDTOption A;
    private Context z;

    @JProtect
    private void D() {
        GdtNativeExpressLoader gdtNativeExpressLoader = new GdtNativeExpressLoader();
        gdtNativeExpressLoader.b(getAdLoadCount()).d(getAdSlotId()).j(this.mGMAdSlotNative.getWidth()).h(this.mGMAdSlotNative.getHeight()).c(this.A);
        gdtNativeExpressLoader.loadAd(this.z, isClientBidding(), this);
    }

    @JProtect
    private void E() {
        GdtNativeLoader gdtNativeLoader = new GdtNativeLoader();
        gdtNativeLoader.b(getAdLoadCount()).e(getAdSlotId()).d(this.A);
        GMAdSlotGDTOption gMAdSlotGDTOption = this.A;
        if (gMAdSlotGDTOption != null) {
            gdtNativeLoader.c(gMAdSlotGDTOption.getNativeAdLogoParams());
        }
        gdtNativeLoader.loadAd(this.z, isClientBidding(), this);
        while (true) {
            for (char c2 = '`'; c2 != '^'; c2 = '^') {
                if (c2 != '`') {
                    break;
                }
            }
            return;
        }
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "gdt";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        try {
            return SDKStatus.getSDKVersion();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0049 A[LOOP:0: B:24:0x0049->B:29:0x0049, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0045 -> B:26:0x004c). Please submit an issue!!! */
    @Override // com.bytedance.msdk.adapter.ad.GMNativeBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @com.bytedance.JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadAd(android.content.Context r3, java.util.Map<java.lang.String, java.lang.Object> r4) {
        /*
            r2 = this;
            super.loadAd(r3, r4)
            r2.z = r3
            com.bytedance.msdk.api.v2.slot.GMAdSlotNative r3 = r2.mGMAdSlotNative
            if (r3 == 0) goto L4f
            if (r4 == 0) goto L43
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption r3 = r3.getGMAdSlotGDTOption()
            r2.A = r3
            java.lang.String r3 = "tt_ad_origin_type"
            java.lang.Object r3 = r4.get(r3)
            r4 = 2
            r0 = 1
            if (r3 == 0) goto L31
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 == r0) goto L2d
            r1 = 3
            if (r3 != r1) goto L27
            goto L2d
        L27:
            if (r3 != r4) goto L31
            r2.E()
            return
        L2d:
            r2.D()
            goto L4c
        L31:
            com.bytedance.msdk.api.v2.slot.GMAdSlotNative r3 = r2.mGMAdSlotNative
            int r3 = r3.getAdStyleType()
            if (r3 != r0) goto L3d
            r2.D()
            goto L52
        L3d:
            if (r3 != r4) goto L52
            r2.E()
            goto L52
        L43:
            r3 = 58
        L45:
            switch(r3) {
                case 57: goto L4b;
                case 58: goto L52;
                case 59: goto L49;
                default: goto L48;
            }
        L48:
            goto L4c
        L49:
            goto L49
        L4b:
            return
        L4c:
            r3 = 57
            goto L45
        L4f:
            r2.notifyLoadFailBecauseGMAdSlotIsNull()
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtNativeAdapter.loadAd(android.content.Context, java.util.Map):void");
    }
}
