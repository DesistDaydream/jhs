package com.bytedance.msdk.adapter.pangle;

import android.content.Context;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMNativeBaseAdapter;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* loaded from: classes.dex */
public class PangleNativeAdapter extends GMNativeBaseAdapter {
    private Context z;

    @JProtect
    private void D(TTAdNative tTAdNative, AdSlot.Builder builder) {
        new PangleNativeLoader().loadAd(this.z, isClientBidding(), tTAdNative, builder.build(), this);
    }

    @JProtect
    private void E(TTAdNative tTAdNative, AdSlot.Builder builder, int i2, int i3) {
        builder.setExpressViewAcceptedSize(i2, i3 > 0 ? i3 : 0.0f);
        new PangleNativeExpressLoader().loadAd(this.z, isClientBidding(), tTAdNative, builder.build(), this);
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

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00aa, code lost:
        if (r12 != 6) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b0 A[FALL_THROUGH, PHI: r3 
      PHI: (r3v1 char) = (r3v3 char), (r3v0 char) binds: [B:33:0x00ad, B:4:0x000f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00a4 -> B:28:0x00a5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00b0 -> B:33:0x00ad). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ba -> B:42:0x00bf). Please submit an issue!!! */
    @Override // com.bytedance.msdk.adapter.ad.GMNativeBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @com.bytedance.JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadAd(android.content.Context r11, java.util.Map<java.lang.String, java.lang.Object> r12) {
        /*
            r10 = this;
            super.loadAd(r11, r12)
            r10.z = r11
            com.bytedance.msdk.api.v2.slot.GMAdSlotNative r11 = r10.mGMAdSlotNative
            r0 = 67
            r1 = 4
            r2 = 5
            r3 = 45
            if (r11 == 0) goto L9f
            if (r12 == 0) goto Lb0
            com.bytedance.sdk.openadsdk.TTAdManager r11 = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager()
            android.content.Context r3 = r10.z
            com.bytedance.sdk.openadsdk.TTAdNative r11 = r11.createAdNative(r3)
            com.bytedance.msdk.api.AdSlot r3 = r10.mAdSlot
            com.bytedance.msdk.api.v2.slot.GMAdSlotNative r4 = r10.mGMAdSlotNative
            java.lang.String r5 = r10.getAdSlotId()
            java.lang.String r6 = r10.mWaterfallAbTestParam
            java.lang.String r7 = r10.getClientReqId()
            java.lang.String r8 = r10.getAdm()
            r9 = 0
            com.bytedance.sdk.openadsdk.AdSlot$Builder r3 = com.bytedance.msdk.adapter.pangle.PangleAdapterUtils.buildPangleAdSlot(r3, r4, r5, r6, r7, r8, r9)
            java.lang.String r4 = "ad_width"
            java.lang.Object r4 = r12.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.String r5 = "ad_height"
            java.lang.Object r5 = r12.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r4 <= 0) goto L5d
            if (r5 <= 0) goto L5d
            android.content.Context r6 = r10.z
            int r6 = com.bytedance.msdk.adapter.pangle.PangleAdapterUtils.dp2px(r6, r4)
            android.content.Context r7 = r10.z
            int r7 = com.bytedance.msdk.adapter.pangle.PangleAdapterUtils.dp2px(r7, r5)
            r3.setImageAcceptedSize(r6, r7)
        L5d:
            java.lang.String r6 = "tt_ad_origin_type"
            java.lang.Object r12 = r12.get(r6)
            r6 = 2
            r7 = 1
            if (r12 == 0) goto L87
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            if (r12 != r7) goto L73
            r10.E(r11, r3, r4, r5)
            return
        L73:
            if (r12 != r6) goto L79
            r10.D(r11, r3)
            goto Lca
        L79:
            r8 = 3
            if (r12 != r8) goto L87
            com.bytedance.msdk.api.AdError r11 = new com.bytedance.msdk.api.AdError
            java.lang.String r12 = "渲染类型错误"
            r11.<init>(r12)
            r10.notifyAdFailed(r11)
            goto Lbf
        L87:
            com.bytedance.msdk.api.v2.slot.GMAdSlotNative r12 = r10.mGMAdSlotNative
            int r12 = r12.getAdStyleType()
            if (r12 != r7) goto L93
            r10.E(r11, r3, r4, r5)
            goto Lca
        L93:
            com.bytedance.msdk.api.v2.slot.GMAdSlotNative r12 = r10.mGMAdSlotNative
            int r12 = r12.getAdStyleType()
            if (r12 != r6) goto Lca
            r10.D(r11, r3)
            goto Lca
        L9f:
            r10.notifyLoadFailBecauseGMAdSlotIsNull()
            r11 = 42
        La4:
            r12 = 5
        La5:
            if (r12 == r1) goto Lb3
            if (r12 == r2) goto Lca
            r4 = 6
            if (r12 == r4) goto Lad
            goto La4
        Lad:
            switch(r11) {
                case 87: goto La4;
                case 88: goto Lca;
                case 89: goto Lca;
                default: goto Lb0;
            }
        Lb0:
            r11 = 89
            goto Lad
        Lb3:
            r12 = 66
            if (r11 == r12) goto Lc8
            if (r11 == r0) goto Lba
            goto Lca
        Lba:
            switch(r3) {
                case 10: goto Lca;
                case 11: goto Lbf;
                case 12: goto Lbe;
                default: goto Lbd;
            }
        Lbd:
            goto Lc5
        Lbe:
            return
        Lbf:
            r3 = 12
            r11 = 67
            r12 = 4
            goto La5
        Lc5:
            r3 = 11
            goto Lba
        Lc8:
            if (r3 != r2) goto Lca
        Lca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleNativeAdapter.loadAd(android.content.Context, java.util.Map):void");
    }
}
