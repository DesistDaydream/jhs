package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.g;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.l0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.n;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.v2.ad.AdUtils;
import com.bytedance.msdk.api.v2.ad.custom.init.GMCustomAdapterConfiguration;
import com.bytedance.msdk.base.TTBaseAd;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.android.tpush.XGServerInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    private static volatile a a;

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a$a */
    /* loaded from: classes.dex */
    public class C0039a extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a {
        public final /* synthetic */ d a;

        public C0039a(d dVar) {
            a.this = r1;
            this.a = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:186:0x0084 A[Catch: all -> 0x0348, TryCatch #13 {all -> 0x0348, blocks: (B:163:0x0011, B:165:0x0028, B:169:0x0032, B:186:0x0084, B:188:0x008e, B:176:0x005e, B:183:0x007b, B:171:0x003c, B:178:0x006c), top: B:301:0x0011 }] */
        /* JADX WARN: Removed duplicated region for block: B:236:0x0201 A[Catch: all -> 0x02eb, TryCatch #12 {all -> 0x02eb, blocks: (B:229:0x01da, B:228:0x01d7, B:230:0x01e6, B:234:0x01f7, B:236:0x0201, B:238:0x021c, B:241:0x0223, B:247:0x0261, B:248:0x0264, B:249:0x026a, B:251:0x0277, B:254:0x027e, B:260:0x02da, B:261:0x02dd, B:256:0x0284, B:243:0x0229), top: B:303:0x01d7 }] */
        /* JADX WARN: Removed duplicated region for block: B:256:0x0284 A[Catch: all -> 0x02c1, TRY_ENTER, TRY_LEAVE, TryCatch #12 {all -> 0x02eb, blocks: (B:229:0x01da, B:228:0x01d7, B:230:0x01e6, B:234:0x01f7, B:236:0x0201, B:238:0x021c, B:241:0x0223, B:247:0x0261, B:248:0x0264, B:249:0x026a, B:251:0x0277, B:254:0x027e, B:260:0x02da, B:261:0x02dd, B:256:0x0284, B:243:0x0229), top: B:303:0x01d7 }] */
        /* JADX WARN: Removed duplicated region for block: B:270:0x030d A[Catch: all -> 0x0346, TryCatch #14 {all -> 0x0346, blocks: (B:263:0x02e2, B:268:0x02f5, B:269:0x0308, B:270:0x030d, B:271:0x0321), top: B:300:0x0026 }] */
        /* JADX WARN: Removed duplicated region for block: B:280:0x036a  */
        /* JADX WARN: Type inference failed for: r1v0, types: [bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a$a] */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v26, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v37 */
        /* JADX WARN: Type inference failed for: r1v38 */
        /* JADX WARN: Type inference failed for: r1v39 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v40 */
        /* JADX WARN: Type inference failed for: r1v41 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4, types: [bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a$a] */
        /* JADX WARN: Type inference failed for: r2v9 */
        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b r21, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b r22) {
            /*
                Method dump skipped, instructions count: 914
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.C0039a.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b r4, java.io.IOException r5) {
            /*
                r3 = this;
                boolean r4 = r5 instanceof java.net.SocketTimeoutException
                if (r4 == 0) goto Lc
                r4 = 44405(0xad75, float:6.2225E-41)
            L7:
                java.lang.String r5 = r5.toString()
                goto L14
            Lc:
                r4 = 44404(0xad74, float:6.2223E-41)
                if (r5 == 0) goto L12
                goto L7
            L12:
                java.lang.String r5 = "没有网络"
            L14:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Server Bidding Request onError...errorCode="
                r0.append(r1)
                r0.append(r4)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "ServerBiddingHelper"
                com.bytedance.msdk.adapter.util.Logger.e(r1, r0)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a$d r0 = r3.a
                if (r0 == 0) goto L38
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.this
                com.bytedance.msdk.api.AdError r2 = new com.bytedance.msdk.api.AdError
                r2.<init>(r4, r5)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(r1, r0, r2)
            L38:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.C0039a.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b, java.io.IOException):void");
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ d a;
        public final /* synthetic */ AdError b;

        public b(a aVar, d dVar, AdError adError) {
            this.a = dVar;
            this.b = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(this.b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ d a;
        public final /* synthetic */ g b;

        public c(a aVar, d dVar, g gVar) {
            this.a = dVar;
            this.b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(this.b);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(g gVar);

        void a(AdError adError);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x001a, code lost:
        return 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x001c, code lost:
        return 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x001e, code lost:
        return 4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(int r4) {
        /*
        L0:
            r0 = 93
            r1 = 93
        L4:
            r2 = 3
            r3 = 4
            switch(r1) {
                case 92: goto Ld;
                case 93: goto L10;
                case 94: goto La;
                default: goto L9;
            }
        L9:
            goto L0
        La:
            if (r0 <= r3) goto L0
            goto L1e
        Ld:
            switch(r0) {
                case 21: goto L1e;
                case 22: goto L1c;
                case 23: goto L1a;
                default: goto L10;
            }
        L10:
            switch(r0) {
                case 91: goto L20;
                case 92: goto L1e;
                case 93: goto L16;
                default: goto L13;
            }
        L13:
            r0 = 91
            goto L10
        L16:
            switch(r4) {
                case 1: goto L1c;
                case 2: goto L20;
                case 3: goto L1a;
                case 4: goto L1a;
                case 5: goto L1f;
                case 6: goto L19;
                case 7: goto L1a;
                case 8: goto L1a;
                case 9: goto L1f;
                default: goto L19;
            }
        L19:
            goto L1f
        L1a:
            r2 = 5
            goto L1f
        L1c:
            r2 = 2
            goto L1f
        L1e:
            r2 = 4
        L1f:
            return r2
        L20:
            r1 = 94
            r0 = 75
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x008c A[Catch: all -> 0x0118, TryCatch #2 {all -> 0x0118, blocks: (B:55:0x001b, B:57:0x002f, B:61:0x0039, B:78:0x008c, B:80:0x0096, B:82:0x010e, B:68:0x0065, B:75:0x0082, B:70:0x0073, B:63:0x0043), top: B:89:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.h a(org.json.JSONObject r7) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(org.json.JSONObject):bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.h");
    }

    private String a(AdSlot adSlot, j jVar) {
        String linkedId = adSlot != null ? adSlot.getLinkedId() : null;
        if (jVar != null) {
            return (linkedId + "_") + jVar.d();
        }
        return linkedId;
    }

    private String a(String str) {
        ITTAdapterConfiguration iTTAdapterConfiguration;
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                GMCustomAdapterConfiguration a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(str);
                if (a2 != null) {
                    str2 = a2.getNetworkSdkVersion();
                } else {
                    Map<String, ITTAdapterConfiguration> e2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
                    if (e2 != null) {
                        String classNameByAdnName = DefaultAdapterClasses.getClassNameByAdnName(str);
                        if (!TextUtils.isEmpty(classNameByAdnName) && (iTTAdapterConfiguration = e2.get(classNameByAdnName)) != null) {
                            str2 = iTTAdapterConfiguration.getNetworkSdkVersion();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                Logger.e("TTMediationSDK_SDK_Init", "GDT SDK 初始化失败。。 e=" + th.toString());
            }
        }
        return str2;
    }

    private String a(Map<String, TTAbsAdLoaderAdapter> map, Context context, AdSlot adSlot, j jVar, Map<String, Object> map2) {
        if (adSlot == null || jVar == null) {
            Logger.i("serverBiddingRequest", "adSlot is null or waterFallConfig is null can not get server bidding token");
            return "";
        } else if (TextUtils.equals("baidu", jVar.e())) {
            TTAbsAdLoaderAdapter a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(adSlot.getAdUnitId(), jVar);
            if (a2 == null) {
                return "";
            }
            map.put(String.format("%1$s_%2$s_%3$s", adSlot.getLinkedId(), adSlot.getAdUnitId(), jVar.d()), a2);
            return a2.getBiddingToken(context, jVar.d(), AdUtils.covertAdSlot2GMAdSlotBase(adSlot));
        } else {
            return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(map2, jVar.e());
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:351:0x058c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private java.lang.String a(java.util.Map<java.lang.String, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter> r33, android.content.Context r34, com.bytedance.msdk.api.AdSlot r35, java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> r36, java.util.List<com.bytedance.msdk.base.TTBaseAd> r37, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c r38, int r39, boolean r40) {
        /*
            Method dump skipped, instructions count: 1462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(java.util.Map, android.content.Context, com.bytedance.msdk.api.AdSlot, java.util.List, java.util.List, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c, int, boolean):java.lang.String");
    }

    private String a(JSONObject jSONObject, boolean z) {
        JSONObject a2 = l0.a(jSONObject);
        if (a2 != null) {
            try {
                a2.putOpt("token_type", Integer.valueOf(z ? 1 : 0));
            } catch (Exception unused) {
            }
            return a2.toString();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x002a A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0012 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject a() {
        /*
            r3 = this;
            r0 = 0
        L1:
            r1 = 74
            r2 = 55
        L5:
            switch(r1) {
                case 72: goto L1;
                case 73: goto Lb;
                case 74: goto Le;
                default: goto L8;
            }
        L8:
            r1 = 72
            goto L5
        Lb:
            switch(r2) {
                case 94: goto L36;
                case 95: goto L12;
                case 96: goto L12;
                default: goto Le;
            }
        Le:
            switch(r2) {
                case 55: goto L2a;
                case 56: goto L12;
                case 57: goto L12;
                default: goto L11;
            }
        L11:
            goto L36
        L12:
            r1 = 0
            if (r0 == 0) goto L16
            goto L29
        L16:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L25
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()     // Catch: java.lang.Exception -> L25
            java.lang.String r2 = r2.c()     // Catch: java.lang.Exception -> L25
            r0.<init>(r2)     // Catch: java.lang.Exception -> L25
            r1 = r0
            goto L29
        L25:
            r0 = move-exception
            r0.printStackTrace()
        L29:
            return r1
        L2a:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()
            java.lang.String r0 = r0.c()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
        L36:
            r1 = 73
            r2 = 96
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a():org.json.JSONObject");
    }

    private JSONObject a(AdSlot adSlot) {
        while (true) {
            char c2 = 15;
            while (true) {
                switch (c2) {
                    case '\r':
                        break;
                    case 14:
                        JSONObject jSONObject = new JSONObject();
                        try {
                            int adType = adSlot.getAdType();
                            jSONObject.put("id", adSlot.getAdUnitId());
                            jSONObject.put("adtype", adType);
                            jSONObject.put("pos", a(adType));
                            a(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
                            jSONObject.put("is_support_dpl", adSlot.isSupportDeepLink());
                            int adCount = adSlot.getAdCount();
                            int i2 = 1;
                            if (adCount < 1) {
                                adCount = 1;
                            }
                            if (adCount > 3) {
                                adCount = 3;
                            }
                            if (adType != 7 && adType != 8) {
                                i2 = adCount;
                            }
                            jSONObject.put("ad_count", i2);
                        } catch (Exception unused) {
                        }
                        return jSONObject;
                    case 15:
                    default:
                        c2 = 14;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x009a A[Catch: all -> 0x00cc, TryCatch #2 {all -> 0x00cc, blocks: (B:82:0x0029, B:84:0x003d, B:88:0x0046, B:106:0x009a, B:108:0x00a4, B:110:0x00c2, B:96:0x0073, B:103:0x0090, B:90:0x0050, B:98:0x0081), top: B:117:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00e5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0026 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0013 -> B:81:0x0026). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.g r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "ServerBiddingHelper"
            r1 = 14
            if (r5 != 0) goto L9
            r6 = 14
            goto L26
        L9:
            boolean r2 = android.text.TextUtils.isEmpty(r6)
            if (r2 == 0) goto L29
            r5 = 12
            r6 = 128(0x80, float:1.794E-43)
        L13:
            switch(r5) {
                case 12: goto L1d;
                case 13: goto Le5;
                case 14: goto L17;
                default: goto L16;
            }
        L16:
            goto L26
        L17:
            r5 = 27
            if (r6 >= r5) goto L21
            goto Le5
        L1d:
            r5 = 84
            if (r6 >= r5) goto Le5
        L21:
            r6 = 26
            r5 = 14
            goto L13
        L26:
            r5 = 13
            goto L13
        L29:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lcc
            r1.<init>(r6)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r6 = "cypher"
            r2 = -1
            int r6 = r1.optInt(r6, r2)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r3 = "message"
            java.lang.String r1 = r1.optString(r3)     // Catch: java.lang.Throwable -> Lcc
            if (r6 <= r2) goto Lc9
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lcc
            if (r2 != 0) goto Lc9
            r2 = 2
            if (r6 != r2) goto L70
            java.lang.String r6 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.l0.a(r1)     // Catch: java.lang.Throwable -> Lcc
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> Lcc
            if (r1 != 0) goto L97
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L56
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L56
            goto L98
        L56:
            r6 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcc
            r1.<init>()     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r2 = ">>>>> m_meta data error: "
            r1.append(r2)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lcc
            r1.append(r6)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> Lcc
            com.bytedance.msdk.adapter.util.Logger.d(r0, r6)     // Catch: java.lang.Throwable -> Lcc
            goto L97
        L70:
            r2 = 1
            if (r6 != r2) goto L8e
            java.lang.String r6 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a()     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r6 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(r1, r6)     // Catch: java.lang.Throwable -> Lcc
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> Lcc
            if (r1 != 0) goto L97
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L87
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L87
            goto L98
        L87:
            r6 = move-exception
            java.lang.String r1 = "m_meta data error: "
            com.bytedance.msdk.adapter.util.Logger.d(r0, r1, r6)     // Catch: java.lang.Throwable -> Lcc
            goto L97
        L8e:
            if (r6 != 0) goto L97
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lcc
            r6.<init>(r1)     // Catch: java.lang.Throwable -> Lcc
            r1 = r6
            goto L98
        L97:
            r1 = 0
        L98:
            if (r1 == 0) goto Lc6
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> Lcc
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> Lcc
            if (r6 != 0) goto Lc0
            java.lang.String r6 = "request_id"
            java.lang.String r6 = r1.optString(r6)     // Catch: java.lang.Throwable -> Lcc
            r5.a(r6)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r6 = "server_bidding_extra"
            java.lang.String r6 = r1.optString(r6)     // Catch: java.lang.Throwable -> Lcc
            r5.b(r6)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r6 = "server_request_id"
            java.lang.String r6 = r1.optString(r6)     // Catch: java.lang.Throwable -> Lcc
            r5.c(r6)     // Catch: java.lang.Throwable -> Lcc
            goto Le5
        Lc0:
            java.lang.String r5 = "m_meta..data.string is null "
        Lc2:
            com.bytedance.msdk.adapter.util.Logger.e(r0, r5)     // Catch: java.lang.Throwable -> Lcc
            goto Le5
        Lc6:
            java.lang.String r5 = "m_meta...data is null"
            goto Lc2
        Lc9:
            java.lang.String r5 = "m_meta onResponse error "
            goto Lc2
        Lcc:
            r5 = move-exception
            java.lang.String r5 = r5.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "m_meta onResponse throwable ："
            r6.append(r1)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.bytedance.msdk.adapter.util.Logger.e(r0, r5)
        Le5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.g, java.lang.String):void");
    }

    private void a(d dVar, g gVar) {
        ThreadHelper.runOnMSDKThread(new c(this, dVar, gVar));
    }

    private void a(d dVar, AdError adError) {
        ThreadHelper.runOnMSDKThread(new b(this, dVar, adError));
    }

    public static /* synthetic */ void a(a aVar, d dVar, g gVar) {
        aVar.a(dVar, gVar);
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                default:
                                    c2 = '[';
                                case '[':
                                case '\\':
                                case ']':
                                    break;
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
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

    public static /* synthetic */ void a(a aVar, d dVar, AdError adError) {
        aVar.a(dVar, adError);
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                default:
                                    c2 = '[';
                                case '[':
                                case '\\':
                                case ']':
                                    break;
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
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

    private void a(JSONObject jSONObject, String str, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i2);
            jSONObject2.put("height", i3);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b());
            jSONObject.put("name", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().i());
            c(jSONObject);
            b(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject b(AdSlot adSlot) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request_id", adSlot.getLinkedId());
            jSONObject.put("ad_sdk_version", "3.7.0.2");
            jSONObject.put("source_type", PushConstants.EXTRA_APPLICATION_PENDING_INTENT);
            jSONObject.put(PushConstants.EXTRA_APPLICATION_PENDING_INTENT, b());
            JSONObject a2 = m.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
            if (a2 != null && adSlot.getOrientation() > 0) {
                a2.put("orientation", adSlot.getOrientation());
            }
            jSONObject.put("device", a2);
            jSONObject.put("ua", e.c.c.a.b.b);
            jSONObject.put(XGServerInfo.TAG_IP, m.a());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(a(adSlot));
            jSONObject.put("adslots", jSONArray);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("req_sign", n.a((adSlot.getAdUnitId() == null || adSlot.getLinkedId() == null) ? "" : String.valueOf(currentTimeMillis).concat(adSlot.getAdUnitId()).concat(adSlot.getLinkedId())));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    private void b(org.json.JSONObject r6) {
        /*
            r5 = this;
            r0 = 92
        L2:
            r1 = 14
        L4:
            switch(r1) {
                case 13: goto L31;
                case 14: goto L33;
                case 15: goto L8;
                default: goto L7;
            }
        L7:
            goto L2
        L8:
            switch(r0) {
                case 94: goto L33;
                case 95: goto Lc;
                case 96: goto L33;
                default: goto Lb;
            }
        Lb:
            goto L33
        Lc:
            android.content.Context r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e.b(r0)
            if (r0 == 0) goto L30
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L30
            r1.<init>()     // Catch: java.lang.Exception -> L30
            java.lang.String r2 = "latitude"
            float r3 = r0.a     // Catch: java.lang.Exception -> L30
            double r3 = (double) r3     // Catch: java.lang.Exception -> L30
            r1.put(r2, r3)     // Catch: java.lang.Exception -> L30
            java.lang.String r2 = "longitude"
            float r0 = r0.b     // Catch: java.lang.Exception -> L30
            double r3 = (double) r0     // Catch: java.lang.Exception -> L30
            r1.put(r2, r3)     // Catch: java.lang.Exception -> L30
            java.lang.String r0 = "geo"
            r6.put(r0, r1)     // Catch: java.lang.Exception -> L30
        L30:
            return
        L31:
            r1 = 72
        L33:
            r0 = 95
            r1 = 15
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.b(org.json.JSONObject):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0002, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a c() {
        /*
            java.lang.Class<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a> r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.class
        L2:
            r1 = 74
            r2 = 55
        L6:
            switch(r1) {
                case 72: goto L2;
                case 73: goto Lc;
                case 74: goto Lf;
                default: goto L9;
            }
        L9:
            r1 = 72
            goto L6
        Lc:
            switch(r2) {
                case 94: goto L17;
                case 95: goto L1c;
                case 96: goto L1c;
                default: goto Lf;
            }
        Lf:
            r1 = 56
            if (r2 == r1) goto L2
            r1 = 57
            if (r2 == r1) goto L1c
        L17:
            r1 = 73
            r2 = 96
            goto L6
        L1c:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a
            if (r1 != 0) goto L31
            monitor-enter(r0)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a     // Catch: java.lang.Throwable -> L2e
            if (r1 != 0) goto L2c
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a r1 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a     // Catch: java.lang.Throwable -> L2e
            r1.<init>()     // Catch: java.lang.Throwable -> L2e
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a = r1     // Catch: java.lang.Throwable -> L2e
        L2c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2e
            goto L31
        L2e:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2e
            throw r1
        L31:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.c():bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a");
    }

    private void c(JSONObject jSONObject) {
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
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
                        try {
                            jSONObject.put("package_name", l0.a());
                            jSONObject.put("version_code", l0.d());
                            jSONObject.put("version", l0.e());
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    default:
                        c3 = '[';
                }
            }
        }
    }

    public String a(Map<String, TTAbsAdLoaderAdapter> map, Context context, AdSlot adSlot, List<j> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar, int i2, boolean z) {
        return a(map, context, adSlot, list, null, cVar, i2, z);
    }

    public void a(String str, d dVar) {
        char c2 = '(';
        while (true) {
            if (c2 != '(' && c2 == ')') {
                break;
            }
            c2 = ')';
        }
        if (TextUtils.isEmpty(str)) {
            Logger.e("ServerBiddingHelper", "Server Bidding Request onResponse...response is invalid");
            a(dVar, new AdError(-1, "response is invalid"));
            return;
        }
        try {
            g gVar = new g();
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("items");
            String optString = jSONObject.optString("m_meta");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    h a2 = a(optJSONArray.optJSONObject(i2));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                gVar.b(arrayList);
            }
            a(gVar, optString);
            a(dVar, gVar);
        } catch (Throwable th) {
            String th2 = th.toString();
            Logger.e("ServerBiddingHelper", "Server Bidding onResponse throwable ：" + th2);
            if (TextUtils.isEmpty(th2)) {
                th2 = AdError.getMessage(-1);
            }
            a(dVar, new AdError(-1, th2));
        }
    }

    public void a(Map<String, TTAbsAdLoaderAdapter> map, Context context, AdSlot adSlot, List<j> list, List<TTBaseAd> list2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar, int i2, boolean z, d dVar) {
        String a2 = a(map, context, adSlot, list, list2, cVar, i2, z);
        Logger.i("serverBiddingRequest", "serverBiddingRequest-encryptBody=" + a2);
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c c2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.b().a().c();
        c2.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c.b());
        String q = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().q();
        if (!TextUtils.isEmpty(q)) {
            c2.a("X-Tt-Env", q);
            c2.a("x-use-ppe", "1");
        }
        c2.a("User-Agent", e.c.c.a.b.b);
        c2.c(a2);
        c2.a(new C0039a(dVar));
    }
}
