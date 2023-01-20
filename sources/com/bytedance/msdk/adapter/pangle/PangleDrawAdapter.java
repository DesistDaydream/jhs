package com.bytedance.msdk.adapter.pangle;

import android.content.Context;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMDrawBaseAdapter;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* loaded from: classes.dex */
public class PangleDrawAdapter extends GMDrawBaseAdapter {
    private Context A;

    @JProtect
    private void D(TTAdNative tTAdNative, AdSlot.Builder builder) {
        new PangleDrawLoader().loadAd(this.A, isClientBidding(), tTAdNative, builder.build(), this);
    }

    @JProtect
    private void E(TTAdNative tTAdNative, AdSlot.Builder builder, int i2, int i3) {
        builder.setExpressViewAcceptedSize(i2, i3 > 0 ? i3 : 0.0f);
        new PangleDrawExpressLoader().loadAd(this.A, isClientBidding(), tTAdNative, builder.build(), this);
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "pangle";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        try {
            return TTAdSdk.getAdManager().getSDKVersion();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x007d -> B:24:0x0082). Please submit an issue!!! */
    @Override // com.bytedance.msdk.adapter.ad.GMDrawBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @com.bytedance.JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadAd(android.content.Context r8, java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
            r7 = this;
            super.loadAd(r8, r9)
            r7.A = r8
            com.bytedance.msdk.api.v2.slot.GMAdSlotDraw r8 = r7.mGMAdSlotDraw
            if (r8 == 0) goto L78
            if (r9 == 0) goto L81
            com.bytedance.sdk.openadsdk.TTAdManager r8 = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager()
            android.content.Context r0 = r7.A
            com.bytedance.sdk.openadsdk.TTAdNative r8 = r8.createAdNative(r0)
            com.bytedance.msdk.api.AdSlot r0 = r7.mAdSlot
            com.bytedance.msdk.api.v2.slot.GMAdSlotDraw r1 = r7.mGMAdSlotDraw
            java.lang.String r2 = r7.getAdSlotId()
            java.lang.String r3 = r7.mWaterfallAbTestParam
            java.lang.String r4 = r7.getClientReqId()
            java.lang.String r5 = r7.getAdm()
            r6 = 0
            com.bytedance.sdk.openadsdk.AdSlot$Builder r0 = com.bytedance.msdk.adapter.pangle.PangleAdapterUtils.buildPangleAdSlot(r0, r1, r2, r3, r4, r5, r6)
            com.bytedance.msdk.api.v2.slot.GMAdSlotDraw r1 = r7.mGMAdSlotDraw
            int r1 = r1.getWidth()
            com.bytedance.msdk.api.v2.slot.GMAdSlotDraw r2 = r7.mGMAdSlotDraw
            int r2 = r2.getHeight()
            if (r1 <= 0) goto L4b
            if (r2 <= 0) goto L4b
            android.content.Context r3 = r7.A
            int r3 = com.bytedance.msdk.adapter.pangle.PangleAdapterUtils.dp2px(r3, r1)
            android.content.Context r4 = r7.A
            int r4 = com.bytedance.msdk.adapter.pangle.PangleAdapterUtils.dp2px(r4, r2)
            r0.setImageAcceptedSize(r3, r4)
        L4b:
            java.lang.String r3 = "tt_ad_origin_type"
            java.lang.Object r9 = r9.get(r3)
            java.lang.String r3 = "渲染类型错误"
            if (r9 == 0) goto L6f
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            r4 = 1
            if (r9 != r4) goto L62
            r7.E(r8, r0, r1, r2)
            goto L82
        L62:
            r1 = 2
            if (r9 != r1) goto L69
            r7.D(r8, r0)
            goto L82
        L69:
            com.bytedance.msdk.api.AdError r8 = new com.bytedance.msdk.api.AdError
            r8.<init>(r3)
            goto L74
        L6f:
            com.bytedance.msdk.api.AdError r8 = new com.bytedance.msdk.api.AdError
            r8.<init>(r3)
        L74:
            r7.notifyAdFailed(r8)
            goto L82
        L78:
            r7.notifyLoadFailBecauseGMAdSlotIsNull()
            r8 = 93
        L7d:
            switch(r8) {
                case 92: goto L81;
                case 93: goto L81;
                case 94: goto L81;
                default: goto L80;
            }
        L80:
            goto L82
        L81:
            return
        L82:
            r8 = 92
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawAdapter.loadAd(android.content.Context, java.util.Map):void");
    }
}
