package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.text.TextUtils;
import android.util.Log;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.f0;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.error.AdBreakError;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.bytedance.msdk.base.TTBaseAd;
import com.umeng.analytics.pro.am;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h {
    private static int a;
    private static int b;

    /* renamed from: c */
    private static int f962c;

    public static void a() {
        d b2 = d.b();
        b2.e("apm_sdk_init");
        HashMap hashMap = new HashMap();
        JSONArray c2 = c0.c();
        if (c2 != null) {
            Log.d("TMe", "--==-- v3bug size: " + c2.length());
            hashMap.put("sp_v3_bug", c2);
        }
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    public static void a(int i2, int i3, long j2, boolean z, boolean z2, JSONObject jSONObject, long j3) {
        d b2 = d.b();
        boolean a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.R().a("is_config_from_assert");
        if (i2 != 1) {
            i2 = (z || (i2 == 0 && a2)) ? 2 : 0;
        }
        b2.e(i2).a(j2).e("get_config_final").g(i3);
        HashMap hashMap = new HashMap();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c().a(z2, b2, jSONObject, hashMap);
        hashMap.put("config_size", Long.valueOf(j3));
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
        for (char c2 = 'R'; c2 != 'P'; c2 = 'P') {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0011  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x001a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(long r2) {
        /*
        L0:
            r0 = 74
            r1 = 55
        L4:
            switch(r0) {
                case 72: goto L0;
                case 73: goto La;
                case 74: goto Ld;
                default: goto L7;
            }
        L7:
            r0 = 72
            goto L4
        La:
            switch(r1) {
                case 94: goto L15;
                case 95: goto L1a;
                case 96: goto L1a;
                default: goto Ld;
            }
        Ld:
            r0 = 56
            if (r1 == r0) goto L1a
            r0 = 57
            if (r1 == r0) goto L1a
        L15:
            r0 = 73
            r1 = 96
            goto L4
        L1a:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "sdk_backstage"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.e(r1)
            r1.a(r2)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r()
            r3.c(r2)
            android.content.Context r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r3, r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(long):void");
    }

    public static void a(long j2, int i2, int i3, long j3) {
        d b2 = d.b();
        b2.e("sdk_init_end");
        b2.a(j2);
        b2.b(j3);
        b2.a("adn_count", Integer.valueOf(i2));
        HashMap hashMap = new HashMap();
        hashMap.put("is_from_local_config", Integer.valueOf(i3));
        hashMap.put("adapter_version_list", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.f.a());
        hashMap.put("if_use_new_sdkinit", Integer.valueOf(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().o()));
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    public static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, AdSlot adSlot, int i2, int i3) {
        d b2 = d.b();
        b2.e("adapter_request_fail").a(0L).a((String) null).c(AdError.ERROR_ADN_NO_ERROR_CODE).d("adapter create fail !").a("mediationrit_req_type", Integer.valueOf(i2)).a("mediationrit_req_type_src", Integer.valueOf(i3));
        HashMap hashMap = new HashMap();
        a(b2, adSlot, jVar, (TTBaseAd) null, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    public static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, AdSlot adSlot, TTBaseAd tTBaseAd, int i2, String str) {
        d b2 = d.b();
        d a2 = b2.e("bidding_info_invalid").c(i2).d(str).a("ad_count", Integer.valueOf(adSlot != null ? adSlot.getAdCount() : 0));
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f());
        a2.a("grouping_params", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.g()).a("log_source", 2);
        HashMap hashMap = new HashMap();
        a(b2, adSlot, jVar, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
        char c2 = '_';
        while (true) {
            char c3 = '^';
            while (true) {
                if (c3 == '`') {
                    if (c2 != ')') {
                        if (c2 != '*') {
                            return;
                        }
                    }
                }
                c2 = '(';
                c3 = '`';
            }
        }
    }

    public static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, AdSlot adSlot, String str) {
        d b2 = d.b();
        b2.e("get_bidding_adm_to_adn").a(str);
        HashMap hashMap = new HashMap();
        a(b2, adSlot, jVar, (TTBaseAd) null, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
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

    /* JADX WARN: Removed duplicated region for block: B:74:0x00b0 A[LOOP:3: B:73:0x00ad->B:74:0x00b0, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r2, com.bytedance.msdk.api.AdSlot r3, java.lang.String r4, boolean r5, int r6, int r7, int r8, int r9, com.bytedance.msdk.api.AdError r10, long r11) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            boolean r1 = r10 instanceof com.bytedance.msdk.api.error.AdPacingError
            if (r1 != 0) goto L10
            boolean r1 = r10 instanceof com.bytedance.msdk.api.error.AdFreqError
            if (r1 != 0) goto L10
            boolean r1 = r10 instanceof com.bytedance.msdk.api.error.AdBreakError
            if (r1 == 0) goto L1b
        L10:
            int r1 = r10.code
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.c(r1)
            java.lang.String r10 = r10.message
            r1.d(r10)
        L1b:
            java.lang.String r10 = "media_request"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r10 = r0.e(r10)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r10.a(r4)
            if (r3 == 0) goto L2c
            int r10 = r3.getAdCount()
            goto L2d
        L2c:
            r10 = 0
        L2d:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r1 = "ad_count"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r4.a(r1, r10)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r10 = "adn_count"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r4.a(r10, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            java.lang.String r8 = "mediationrit_req_type"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r4.a(r8, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)
            java.lang.String r8 = "mediationrit_req_type_src"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r4.a(r8, r7)
            r5 = r5 ^ 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r7 = "mediation_req_type"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r4.a(r7, r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            java.lang.String r6 = "media_req_type"
            r4.a(r6, r5)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r5 = -1
            int r7 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r7 == 0) goto L83
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r5 = r5 - r11
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            java.lang.String r6 = "start_time"
            r4.put(r6, r5)
        L83:
            r5 = 0
            a(r0, r3, r2, r5, r4)
            android.content.Context r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r2, r0, r4)
            r2 = 12
            r3 = 61
            r4 = 61
        L94:
            r5 = 8
            r6 = 9
            r7 = 9
        L9a:
            r8 = 7
            r9 = 27
            if (r7 == r8) goto Lab
            if (r7 == r5) goto La4
            if (r7 == r6) goto Lb3
            goto L94
        La4:
            switch(r4) {
                case 37: goto Laa;
                case 38: goto Lad;
                case 39: goto Lb3;
                default: goto La7;
            }
        La7:
            r4 = 39
            goto La4
        Laa:
            return
        Lab:
            if (r4 >= r9) goto Lb8
        Lad:
            switch(r2) {
                case 25: goto L94;
                case 26: goto Lb3;
                case 27: goto L94;
                default: goto Lb0;
            }
        Lb0:
            r2 = 27
            goto Lad
        Lb3:
            r4 = 37
            r7 = 8
            goto L9a
        Lb8:
            if (r2 <= r3) goto L94
        Lba:
        Lbb:
            goto Lba
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j, com.bytedance.msdk.api.AdSlot, java.lang.String, boolean, int, int, int, int, com.bytedance.msdk.api.AdError, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0027 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r3) {
        /*
            java.lang.String r0 = "block_pacing"
            java.lang.String r1 = "-1"
            r3.a(r0, r1)
            java.lang.String r0 = "waterfall_show_rule_id"
            r3.a(r0, r1)
            java.lang.String r0 = "block_show_count"
            r3.a(r0, r1)
        L11:
            r3 = 94
            r0 = 75
            r1 = 93
        L17:
            r2 = 92
            if (r3 == r2) goto L1e
            if (r3 == r1) goto L21
            goto L28
        L1e:
            switch(r0) {
                case 21: goto L28;
                case 22: goto L28;
                case 23: goto L28;
                default: goto L21;
            }
        L21:
            switch(r0) {
                case 91: goto L11;
                case 92: goto L28;
                case 93: goto L27;
                default: goto L24;
            }
        L24:
            r0 = 91
            goto L21
        L27:
            return
        L28:
            r3 = 93
            r0 = 93
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d):void");
    }

    private static void a(d dVar, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, TTBaseAd tTBaseAd) {
        a(dVar, adSlot, jVar, tTBaseAd, (Map<String, Object>) null);
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

    /* JADX WARN: Removed duplicated region for block: B:122:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r10, com.bytedance.msdk.api.AdSlot r11, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r12, com.bytedance.msdk.base.TTBaseAd r13, java.util.Map<java.lang.String, java.lang.Object> r14) {
        /*
            Method dump skipped, instructions count: 860
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d, com.bytedance.msdk.api.AdSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j, com.bytedance.msdk.base.TTBaseAd, java.util.Map):void");
    }

    public static void a(AdError adError, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, int i2, int i3, int i4, String str, long j2) {
        d b2 = d.b();
        b2.e("bidding_adm_load_fail").a(j2).a(str).c(adError != null ? adError.thirdSdkErrorCode : -1).d(adError != null ? adError.thirdSdkErrorMessage : "unknown error").a("adn_count", Integer.valueOf(i2)).a("adn_preload", 0).a("mediationrit_req_type", Integer.valueOf(i3)).a("mediationrit_req_type_src", Integer.valueOf(i4));
        if (adError instanceof AdBreakError) {
            b2.n = adError.code;
            b2.f944k = adError.message;
        }
        HashMap hashMap = new HashMap();
        a(b2, adSlot, jVar, (TTBaseAd) null, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.bytedance.msdk.api.AdError r4, com.bytedance.msdk.api.AdSlot r5, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r6, int r7, int r8, int r9, java.lang.String r10, long r11, java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            boolean r1 = r4 instanceof com.bytedance.msdk.api.error.AdPacingError
            java.lang.String r2 = "adn_rit_show_rule_id"
            if (r1 == 0) goto L29
            r1 = r4
            com.bytedance.msdk.api.error.AdPacingError r1 = (com.bytedance.msdk.api.error.AdPacingError) r1
            int r3 = r4.code
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r3 = r0.c(r3)
            java.lang.String r4 = r4.message
            r3.d(r4)
            java.lang.String r4 = r1.getBlockPacing()
            java.lang.String r3 = "block_pacing"
            r0.a(r3, r4)
            java.lang.String r4 = r1.getRuleId()
        L25:
            r0.a(r2, r4)
            goto L6e
        L29:
            boolean r1 = r4 instanceof com.bytedance.msdk.api.error.AdFreqError
            if (r1 == 0) goto L49
            r1 = r4
            com.bytedance.msdk.api.error.AdFreqError r1 = (com.bytedance.msdk.api.error.AdFreqError) r1
            int r3 = r4.code
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r3 = r0.c(r3)
            java.lang.String r4 = r4.message
            r3.d(r4)
            java.lang.String r4 = r1.getBlockShowCount()
            java.lang.String r3 = "block_show_count"
            r0.a(r3, r4)
            java.lang.String r4 = r1.getRuleId()
            goto L25
        L49:
            boolean r1 = r4 instanceof com.bytedance.msdk.api.error.AdBreakError
            if (r1 == 0) goto L59
            int r1 = r4.code
            r0.n = r1
            java.lang.String r4 = r4.message
            r0.f944k = r4
        L55:
            b(r0)
            goto L6e
        L59:
            if (r4 == 0) goto L5e
            int r1 = r4.thirdSdkErrorCode
            goto L5f
        L5e:
            r1 = -1
        L5f:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.c(r1)
            if (r4 == 0) goto L68
            java.lang.String r4 = r4.thirdSdkErrorMessage
            goto L6a
        L68:
            java.lang.String r4 = "unknown error"
        L6a:
            r1.d(r4)
            goto L55
        L6e:
            java.lang.String r4 = "media_fill_fail"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r0.e(r4)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r4.a(r11)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r4.a(r10)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r10 = "adn_count"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r4.a(r10, r7)
            r7 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r10 = "adn_preload"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r4.a(r10, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            java.lang.String r8 = "mediationrit_req_type"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r4.a(r8, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)
            java.lang.String r8 = "mediationrit_req_type_src"
            r4.a(r8, r7)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r7 = 0
            a(r0, r5, r6, r7, r4)
            boolean r5 = android.text.TextUtils.isEmpty(r13)
            if (r5 != 0) goto Lb6
            r0.j(r13)
        Lb6:
            boolean r5 = android.text.TextUtils.isEmpty(r14)
            if (r5 != 0) goto Lc1
            java.lang.String r5 = "level_tag"
            r0.a(r5, r14)
        Lc1:
            if (r15 == 0) goto Lc8
            java.lang.String r5 = "sub_adn_name"
            r0.a(r5, r15)
        Lc8:
            android.content.Context r5 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r5, r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(com.bytedance.msdk.api.AdError, com.bytedance.msdk.api.AdSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j, int, int, int, java.lang.String, long, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x001d, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.bytedance.msdk.api.AdSlot r2, int r3) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "get_config_error"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.e(r1)
            r1.c(r3)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r1 = 0
            a(r0, r2, r1, r1, r3)
            android.content.Context r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r2, r0, r3)
        L1d:
            r2 = 73
            r3 = 96
        L21:
            switch(r2) {
                case 72: goto L2f;
                case 73: goto L27;
                case 74: goto L2a;
                default: goto L24;
            }
        L24:
            r2 = 72
            goto L21
        L27:
            switch(r3) {
                case 94: goto L1d;
                case 95: goto L2f;
                case 96: goto L2f;
                default: goto L2a;
            }
        L2a:
            switch(r3) {
                case 55: goto L2e;
                case 56: goto L2f;
                case 57: goto L2f;
                default: goto L2d;
            }
        L2d:
            goto L1d
        L2e:
            return
        L2f:
            r2 = 74
            r3 = 55
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(com.bytedance.msdk.api.AdSlot, int):void");
    }

    public static void a(AdSlot adSlot, int i2, long j2, String str, String str2, int i3, AdError adError, int i4) {
        d b2 = d.b();
        b2.e("return_bidding_result").a(j2).e(i2).c(adError == null ? 0 : adError.code).d(adError == null ? "" : adError.message).a(2).a("fill_type", Integer.valueOf(i3)).a("waterfall_abtest", str).a("server_bidding_extra", str2).a("ad_count", Integer.valueOf(i4));
        HashMap hashMap = new HashMap();
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, (TTBaseAd) null, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
        char c2 = 26;
        char c3 = '\t';
        while (true) {
            char c4 = 14;
            while (true) {
                if (c4 != 14) {
                    if (c4 != 16) {
                        break;
                    } else if (c2 <= 22) {
                        do {
                        } while (c3 == 29);
                        if (c3 == 30) {
                            return;
                        }
                    } else {
                        continue;
                    }
                }
                c2 = 65492;
                c3 = 30;
                c4 = 16;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(@androidx.annotation.Nullable com.bytedance.msdk.api.AdSlot r3, com.bytedance.msdk.api.AdError r4, java.lang.String r5, java.lang.String r6) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "total_load_fail"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.e(r1)
            java.lang.String r2 = "waterfall_abtest"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r5 = r1.a(r2, r5)
            java.lang.String r1 = "server_bidding_extra"
            r5.a(r1, r6)
            int r5 = r4.code
            r6 = 10003(0x2713, float:1.4017E-41)
            if (r5 != r6) goto L2a
            r4 = 10010(0x271a, float:1.4027E-41)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r0.c(r4)
            java.lang.String r5 = "Ad load timeout!"
        L23:
            r4.d(r5)
        L26:
            a(r0)
            goto L82
        L2a:
            boolean r6 = r4 instanceof com.bytedance.msdk.api.error.AdPacingError
            java.lang.String r1 = "waterfall_show_rule_id"
            if (r6 == 0) goto L4d
            r6 = r4
            com.bytedance.msdk.api.error.AdPacingError r6 = (com.bytedance.msdk.api.error.AdPacingError) r6
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r5 = r0.c(r5)
            java.lang.String r4 = r4.message
            r5.d(r4)
            java.lang.String r4 = r6.getBlockPacing()
            java.lang.String r5 = "block_pacing"
            r0.a(r5, r4)
            java.lang.String r4 = r6.getRuleId()
        L49:
            r0.a(r1, r4)
            goto L82
        L4d:
            boolean r6 = r4 instanceof com.bytedance.msdk.api.error.AdFreqError
            if (r6 == 0) goto L6b
            r6 = r4
            com.bytedance.msdk.api.error.AdFreqError r6 = (com.bytedance.msdk.api.error.AdFreqError) r6
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r5 = r0.c(r5)
            java.lang.String r4 = r4.message
            r5.d(r4)
            java.lang.String r4 = r6.getBlockShowCount()
            java.lang.String r5 = "block_show_count"
            r0.a(r5, r4)
            java.lang.String r4 = r6.getRuleId()
            goto L49
        L6b:
            boolean r6 = r4 instanceof com.bytedance.msdk.api.error.AdBreakError
            if (r6 == 0) goto L79
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r5 = r0.c(r5)
            java.lang.String r4 = r4.message
            r5.d(r4)
            goto L26
        L79:
            r4 = 10086(0x2766, float:1.4133E-41)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r0.c(r4)
            java.lang.String r5 = "Ad load fail all loadsorts! "
            goto L23
        L82:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            int r5 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.f962c
            int r6 = r5 + 1
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.f962c = r6
            int r5 = r5 % 10
            if (r5 != 0) goto L9e
            int r5 = com.bytedance.msdk.adapter.util.ThreadHelper.getGroMoreThreadCount()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "gromore_thread_num"
            r4.put(r6, r5)
        L9e:
            if (r3 == 0) goto La5
            int r5 = r3.getAdCount()
            goto La6
        La5:
            r5 = 0
        La6:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "ad_count"
            r0.a(r6, r5)
            r5 = 0
            a(r0, r3, r5, r5, r4)
            android.content.Context r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r3, r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(com.bytedance.msdk.api.AdSlot, com.bytedance.msdk.api.AdError, java.lang.String, java.lang.String):void");
    }

    public static void a(AdSlot adSlot, TTBaseAd tTBaseAd, long j2, int i2, int i3, int i4, String str, int i5) {
        d b2 = d.b();
        b2.e("mediation_request_end").a(j2).a("waterfall_abtest", str).a("ad_count", Integer.valueOf(i5)).c(i4);
        HashMap hashMap = new HashMap();
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap);
        hashMap.put("requested_adn_count", Integer.valueOf(i2));
        hashMap.put("requested_level_count", Integer.valueOf(i3));
        int i6 = b;
        b = i6 + 1;
        if (i6 % 10 == 0) {
            hashMap.put("gromore_thread_num", Integer.valueOf(ThreadHelper.getGroMoreThreadCount()));
        }
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
        for (char c2 = 16; c2 != 14; c2 = 14) {
        }
    }

    public static void a(AdSlot adSlot, TTBaseAd tTBaseAd, long j2, String str) {
        d b2 = d.b();
        b2.e("mediation_video_cached").a(j2).a("waterfall_abtest", str);
        HashMap hashMap = new HashMap();
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    public static void a(AdSlot adSlot, TTBaseAd tTBaseAd, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar) {
        d b2 = d.b();
        b2.e("media_cache_success");
        HashMap hashMap = new HashMap();
        a(b2, adSlot, jVar, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    public static void a(AdSlot adSlot, TTBaseAd tTBaseAd, String str) {
        d b2 = d.b();
        b2.e("rit_cache_cannot_use").a("cache_invalid_info", str);
        HashMap hashMap = new HashMap();
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap);
        b2.a("mediationrit_req_type", 2);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
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
    public static void a(com.bytedance.msdk.api.AdSlot r4, java.lang.String r5) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "start_bidding_request"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.e(r1)
            r2 = 2
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r1.a(r2)
            java.lang.String r2 = "waterfall_abtest"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r5 = r1.a(r2, r5)
            r1 = 0
            if (r4 == 0) goto L1d
            int r2 = r4.getAdCount()
            goto L1e
        L1d:
            r2 = 0
        L1e:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "ad_count"
            r5.a(r3, r2)
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            r2 = 0
            a(r0, r4, r2, r2, r5)
            android.content.Context r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r4, r0, r5)
            r4 = 55
        L39:
            r5 = 72
        L3b:
            switch(r5) {
                case 72: goto L53;
                case 73: goto L4e;
                case 74: goto L3f;
                default: goto L3e;
            }
        L3e:
            goto L39
        L3f:
            r5 = 53
            if (r1 == r5) goto L48
            r5 = 54
            if (r1 == r5) goto L53
            goto L39
        L48:
            switch(r4) {
                case 29: goto L52;
                case 30: goto L39;
                case 31: goto L3f;
                default: goto L4b;
            }
        L4b:
            r4 = 30
            goto L48
        L4e:
            r5 = 57
            if (r1 > r5) goto L39
        L52:
            return
        L53:
            r5 = 73
            r1 = 16
            goto L3b
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(com.bytedance.msdk.api.AdSlot, java.lang.String):void");
    }

    public static void a(AdSlot adSlot, String str, String str2) {
        d b2 = d.b();
        b2.e("cache_cannot_use").a("cache_invalid_info", str).a("waterfall_abtest", str2);
        HashMap hashMap = new HashMap();
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, (TTBaseAd) null, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    public static void a(AdSlot adSlot, String str, boolean z, String str2, int i2) {
        String str3;
        while (true) {
            char c2 = '\r';
            while (true) {
                switch (c2) {
                    case '\f':
                    case 14:
                        if (i2 > 0) {
                            str3 = AdError.getMessage(i2);
                        } else {
                            str3 = "";
                            i2 = 0;
                        }
                        int i3 = i2 != 0 ? z ? 2 : 3 : !z ? 1 : 0;
                        d b2 = d.b();
                        b2.e("mediation_request").a("waterfall_abtest", str).a("server_bidding_extra", str2).a("mediation_req_type", Integer.valueOf(i3)).a("ad_count", Integer.valueOf(adSlot != null ? adSlot.getAdCount() : 0)).c(i2).d(str3);
                        HashMap hashMap = new HashMap();
                        int i4 = a;
                        a = i4 + 1;
                        if (i4 % 10 == 0) {
                            hashMap.put("gromore_thread_num", Integer.valueOf(ThreadHelper.getGroMoreThreadCount()));
                        }
                        if (adSlot != null && adSlot.getPrimeRitReqType() == 5) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("parallel_num", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a());
                                jSONObject.put(am.aU, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().c());
                                jSONObject.put("primerit_list", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().b());
                                hashMap.put("preload_info", jSONObject);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (adSlot != null && adSlot.getAdType() == 3) {
                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(hashMap);
                        }
                        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, (TTBaseAd) null, hashMap);
                        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
                        return;
                    case '\r':
                        c2 = 14;
                }
            }
        }
    }

    public static void a(TTBaseAd tTBaseAd, int i2, String str, long j2, AdSlot adSlot, int i3, int i4, int i5, String str2, long j3) {
        int i6 = (tTBaseAd == null || !tTBaseAd.isAdnPreload()) ? 0 : 1;
        d b2 = d.b();
        b2.e("media_fill").a(j2).c(i2).d(str).a("adn_count", Integer.valueOf(i3)).a("adn_preload", Integer.valueOf(i6)).a("ad_count", Integer.valueOf(i4));
        b2.a("fill_type", Integer.valueOf(i5));
        if (str2 != null) {
            b2.a("sub_adn_name", str2);
        }
        HashMap hashMap = new HashMap();
        if (j3 != -1) {
            hashMap.put(com.umeng.analytics.pro.d.q, Long.valueOf(j3));
        }
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().J() && tTBaseAd != null && 5 == tTBaseAd.getAdType()) {
            b2.a("ex_info", j.a().a(tTBaseAd));
        }
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, int i2, int i3, int i4, String str) {
        d b2 = d.b();
        b2.e(i3).e("media_show_after").a("play_again", Integer.valueOf(i4)).a(RewardItem.KEY_REASON, Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str)) {
            b2.a("callstack_message", str);
        }
        HashMap hashMap = new HashMap();
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, int i2, String str, int i3, int i4, String str2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d f2;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c c2;
        d b2 = d.b();
        b2.e("media_reward_verify").a("adn_preload", Integer.valueOf((tTBaseAd == null || !tTBaseAd.isAdnPreload()) ? 0 : 1)).a(RewardItem.KEY_REASON, Integer.valueOf(i3)).a("play_again", Integer.valueOf(i2));
        if (i4 != 0 && i4 != 20000) {
            b2.c(i4).d(str2);
        }
        HashMap hashMap = new HashMap();
        if (adSlot != null && (f2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()) != null && (c2 = f2.c(adSlot.getAdUnitId())) != null) {
            hashMap.put("reward_callback_type", Integer.valueOf(c2.v()));
            hashMap.put("reward_start_time", Integer.valueOf(c2.w()));
        }
        if (str != null) {
            b2.a("sub_adn_name", str);
        }
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, int i2, String str, String str2, boolean z) {
        d b2 = d.b();
        b2.e("media_click_listen").a("adn_preload", Integer.valueOf((tTBaseAd == null || !tTBaseAd.isAdnPreload()) ? 0 : 1)).a("play_again", Integer.valueOf(i2)).a("is_repeat", Integer.valueOf(z ? 1 : 0));
        if (str != null) {
            b2.a("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            b2.a("callstack_message", str2);
        }
        HashMap hashMap = new HashMap();
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
        for (char c2 = 16; c2 != 14; c2 = 14) {
        }
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, int i2, String str, boolean z) {
        a(tTBaseAd, adSlot, i2, str, (String) null, z);
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar, long j2, String str, boolean z, int i2) {
        d b2 = d.b();
        b2.e("mediation_fill").a(j2).a("waterfall_abtest", cVar != null ? cVar.C() : null).a("server_bidding_extra", str).a("mediation_req_type", Integer.valueOf(!z ? 1 : 0)).a("ad_count", Integer.valueOf(i2)).c(0).d("");
        HashMap hashMap = new HashMap();
        if (adSlot != null && adSlot.getAdType() == 3) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().a(hashMap);
        }
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
        char c2 = 14;
        while (true) {
            char c3 = '\r';
            while (true) {
                switch (c3) {
                    case '\f':
                        return;
                    case '\r':
                        c2 = 65478;
                        c3 = 14;
                    case 14:
                        if (c2 < 27) {
                            return;
                        }
                        c2 = 65478;
                        c3 = 14;
                }
            }
        }
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar) {
        d b2 = d.b();
        b2.e("bidding_adm_cache");
        HashMap hashMap = new HashMap();
        a(b2, adSlot, jVar, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, long j2) {
        d b2 = d.b();
        b2.e("bidding_adm_load").a(j2);
        HashMap hashMap = new HashMap();
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().J() && tTBaseAd != null && 5 == tTBaseAd.getAdType()) {
            b2.a("ex_info", j.a().a(tTBaseAd));
        }
        a(b2, adSlot, jVar, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, AdError adError, int i2, int i3, String str) {
        a(tTBaseAd, adSlot, adError, i2, i3, str, (String) null);
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, AdError adError, int i2, int i3, String str, String str2) {
        d b2 = d.b();
        b2.e(i2).c(adError != null ? adError.thirdSdkErrorCode : 0).d(adError != null ? adError.thirdSdkErrorMessage : null).e("media_show_fail_listen").a("play_again", Integer.valueOf(i3));
        if (str != null) {
            b2.a("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            b2.a("callstack_message", str2);
        }
        HashMap hashMap = new HashMap();
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, String str) {
        d b2 = d.b();
        b2.e("media_show_dislike").d(str);
        HashMap hashMap = new HashMap();
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
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

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d b2 = d.b();
        b2.e("callstack_static").a("callstack_message", str).a("callstack_report_time", Integer.valueOf(i2));
        HashMap hashMap = new HashMap();
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, List<TTBaseAd> list, List<TTBaseAd> list2) {
        HashMap hashMap;
        while (true) {
            char c2 = 'B';
            while (true) {
                switch (c2) {
                    case '@':
                        d b2 = d.b();
                        b2.e("bidding_win_event");
                        HashMap hashMap2 = new HashMap();
                        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap2);
                        JSONArray jSONArray = new JSONArray();
                        if (!f0.a(list)) {
                            Iterator<TTBaseAd> it = list.iterator();
                            while (it.hasNext()) {
                                TTBaseAd next = it.next();
                                if (next != null) {
                                    Iterator<TTBaseAd> it2 = it;
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        hashMap = hashMap2;
                                        try {
                                            jSONObject.putOpt("mediation_rit", next.getAdNetworkSlotId());
                                            jSONObject.putOpt("adn_name", next.getAdNetWorkName());
                                            jSONObject.putOpt("load_sort", Integer.valueOf(next.getLoadSort()));
                                            jSONObject.putOpt("show_sort", Integer.valueOf(next.getShowSort()));
                                            jSONObject.putOpt("exchange_rate", next.getExchangeRate());
                                            jSONObject.putOpt("rit_cpm", Double.valueOf(next.getCpm()));
                                            jSONObject.putOpt("m_aid", next.getAid());
                                            jSONObject.putOpt("req_bidding_type", Integer.valueOf(next.getAdNetworkSlotType()));
                                            jSONObject.putOpt("win_state", 1);
                                            jSONObject.putOpt("ad_extra", next.getAdExtra());
                                            jSONObject.putOpt("win_callback", next.getWinCallback());
                                            jSONObject.putOpt("loss_callback", next.getFailCallback());
                                            if (next.isServerBiddingAd()) {
                                                jSONObject.putOpt("pricing_type", Integer.valueOf(next.getPricingType()));
                                            }
                                            jSONArray.put(jSONObject);
                                        } catch (Exception unused) {
                                        }
                                    } catch (Exception unused2) {
                                        hashMap = hashMap2;
                                    }
                                    it = it2;
                                    hashMap2 = hashMap;
                                }
                            }
                        }
                        HashMap hashMap3 = hashMap2;
                        if (!f0.a(list2)) {
                            Iterator<TTBaseAd> it3 = list2.iterator();
                            while (it3.hasNext()) {
                                TTBaseAd next2 = it3.next();
                                if (next2 != null) {
                                    Iterator<TTBaseAd> it4 = it3;
                                    try {
                                        JSONObject jSONObject2 = new JSONObject();
                                        JSONArray jSONArray2 = jSONArray;
                                        try {
                                            jSONObject2.putOpt("mediation_rit", next2.getAdNetworkSlotId());
                                            jSONObject2.putOpt("adn_name", next2.getAdNetWorkName());
                                            jSONObject2.putOpt("load_sort", Integer.valueOf(next2.getLoadSort()));
                                            jSONObject2.putOpt("show_sort", Integer.valueOf(next2.getShowSort()));
                                            jSONObject2.putOpt("exchange_rate", next2.getExchangeRate());
                                            jSONObject2.putOpt("rit_cpm", Double.valueOf(next2.getCpm()));
                                            jSONObject2.putOpt("m_aid", next2.getAid());
                                            jSONObject2.putOpt("req_bidding_type", Integer.valueOf(next2.getAdNetworkSlotType()));
                                            jSONObject2.putOpt("win_state", 0);
                                            jSONObject2.putOpt("ad_extra", next2.getAdExtra());
                                            jSONObject2.putOpt("win_callback", next2.getWinCallback());
                                            jSONObject2.putOpt("loss_callback", next2.getFailCallback());
                                            if (next2.isServerBiddingAd()) {
                                                jSONObject2.putOpt("pricing_type", Integer.valueOf(next2.getPricingType()));
                                            }
                                            jSONArray = jSONArray2;
                                            jSONArray.put(jSONObject2);
                                        } catch (Exception unused3) {
                                            jSONArray = jSONArray2;
                                        }
                                    } catch (Exception unused4) {
                                    }
                                    it3 = it4;
                                }
                            }
                        }
                        hashMap3.put("others", jSONArray);
                        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap3);
                        return;
                    case 'B':
                        c2 = '@';
                }
            }
        }
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, boolean z) {
        d b2 = d.b();
        b2.e("media_show").a("adn_preload", Integer.valueOf((tTBaseAd == null || !tTBaseAd.isAdnPreload()) ? 0 : 1)).a("is_repeat", Integer.valueOf(z ? 1 : 0));
        HashMap hashMap = new HashMap();
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x001d, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r3) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            r1 = 0
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.c(r1)
            java.lang.String r2 = "广告请求"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r1.d(r2)
            r1.e(r3)
            r3 = 0
            a(r0, r3, r3, r3)
            android.content.Context r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r1, r0, r3)
        L1d:
            r3 = 73
            r0 = 96
        L21:
            switch(r3) {
                case 72: goto L2f;
                case 73: goto L27;
                case 74: goto L2a;
                default: goto L24;
            }
        L24:
            r3 = 72
            goto L21
        L27:
            switch(r0) {
                case 94: goto L1d;
                case 95: goto L2f;
                case 96: goto L2f;
                default: goto L2a;
            }
        L2a:
            switch(r0) {
                case 55: goto L2e;
                case 56: goto L2e;
                case 57: goto L2f;
                default: goto L2d;
            }
        L2d:
            goto L1d
        L2e:
            return
        L2f:
            r3 = 74
            r0 = 55
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(java.lang.String):void");
    }

    public static void a(String str, TTBaseAd tTBaseAd, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, AdError adError) {
        d b2 = d.b();
        d d2 = b2.c(adError != null ? adError.code : 0).d(adError != null ? adError.message : null);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        d2.b(str).e("custom_adn_init_fail");
        HashMap hashMap = new HashMap();
        a(b2, adSlot, jVar, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    public static void a(List<TTBaseAd> list, AdSlot adSlot) {
        TTBaseAd tTBaseAd = (list == null || list.size() <= 0) ? null : list.get(0);
        d b2 = d.b();
        b2.e("media_show_fail");
        b2.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD);
        if (tTBaseAd != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (TTBaseAd tTBaseAd2 : list) {
                    if (tTBaseAd2 != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("adn", tTBaseAd2.getAdNetWorkName());
                        jSONObject.put("type", e.c.c.a.a.c(tTBaseAd2.getAdType(), tTBaseAd2.getSubAdType()));
                        jSONObject.put("adnSlotId", tTBaseAd2.getAdNetworkSlotId());
                        jSONObject.put("loadSort", tTBaseAd2.getLoadSort());
                        jSONObject.put("showSort", tTBaseAd2.getShowSort());
                        if (adSlot != null) {
                            jSONObject.put("isReady", tTBaseAd2.isReady(adSlot.getAdUnitId()) ? 1 : 0);
                        }
                        jSONObject.put("hasShown", tTBaseAd2.isHasShown() ? 1 : 0);
                        jSONArray.put(jSONObject);
                    }
                }
                b2.d(jSONArray.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        HashMap hashMap = new HashMap();
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap);
        b2.a("is_video_cache_success", 0);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    public static void a(List<TTBaseAd> list, List<TTBaseAd> list2, List<TTBaseAd> list3, AdSlot adSlot, String str) {
        JSONArray jSONArray;
        Iterator it;
        while (true) {
            char c2 = 15;
            char c3 = '\r';
            while (true) {
                switch (c2) {
                    case '\r':
                        ArrayList arrayList = new ArrayList();
                        if (list != null && list.size() > 0) {
                            arrayList.addAll(list);
                        }
                        if (list2 != null && list2.size() > 0) {
                            arrayList.addAll(list2);
                        }
                        if (list3 != null && list3.size() > 0) {
                            arrayList.addAll(list3);
                        }
                        int i2 = 0;
                        TTBaseAd tTBaseAd = arrayList.size() > 0 ? (TTBaseAd) arrayList.get(0) : null;
                        d b2 = d.b();
                        b2.e("media_show_is_ready").a("waterfall_abtest", str);
                        try {
                            jSONArray = new JSONArray();
                            it = arrayList.iterator();
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        while (true) {
                            boolean z = false;
                            while (it.hasNext()) {
                                TTBaseAd tTBaseAd2 = (TTBaseAd) it.next();
                                if (tTBaseAd2 != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("adn", tTBaseAd2.getAdNetWorkName());
                                    jSONObject.put("type", e.c.c.a.a.c(tTBaseAd2.getAdType(), tTBaseAd2.getSubAdType()));
                                    jSONObject.put("adnSlotId", tTBaseAd2.getAdNetworkSlotId());
                                    jSONObject.put("loadSort", tTBaseAd2.getLoadSort());
                                    jSONObject.put("showSort", tTBaseAd2.getShowSort());
                                    if (adSlot != null) {
                                        jSONObject.put("isReady", tTBaseAd2.isReady(adSlot.getAdUnitId()) ? 1 : 0);
                                    }
                                    jSONObject.put("hasShown", tTBaseAd2.isHasShown() ? 1 : 0);
                                    if (tTBaseAd2.adnHasAdVideoCachedApi()) {
                                        jSONObject.put("is_video_cache_success", tTBaseAd2.isCacheSuccess() ? 1 : 0);
                                    }
                                    jSONObject.put("mediationrit_req_type", tTBaseAd2.getMediationRitReqType(adSlot != null ? adSlot.getLinkedId() : null));
                                    jSONObject.put("mediationrit_req_type_src", tTBaseAd2.getMediationRitReqTypeSrc(adSlot != null ? adSlot.getLinkedId() : null));
                                    jSONArray.put(jSONObject);
                                    if (!z && adSlot != null) {
                                        if (adSlot.getAdType() == 5) {
                                            z = tTBaseAd2.isReady(adSlot.getAdUnitId());
                                        } else if (tTBaseAd2.isReady(adSlot.getAdUnitId()) && !tTBaseAd2.isHasShown()) {
                                            z = true;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                i2 = -1;
                            }
                            b2.c(i2);
                            b2.d(jSONArray.toString());
                            HashMap hashMap = new HashMap();
                            a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap);
                            c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
                            return;
                        }
                    case 14:
                        while (true) {
                            switch (c3) {
                                case '\n':
                                case 11:
                                    while (true) {
                                    }
                                case '\f':
                                    break;
                                default:
                                    c3 = '\f';
                            }
                        }
                        break;
                    case 15:
                    default:
                        c2 = '\r';
                }
            }
        }
    }

    public static void a(boolean z) {
        d b2 = d.b();
        b2.e("get_config_start").a(RewardItem.KEY_REASON, Integer.valueOf(z ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.R().a("is_config_from_assert") ? 2 : 1 : 0));
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, null);
    }

    public static void b(long j2) {
        String str;
        d b2 = d.b();
        b2.e("sdk_init").b(j2);
        try {
            Class.forName("com.unity3d.player.UnityPlayer");
            try {
                Class.forName("com.bytedance.ad.sdk.mediation.AdManager");
                str = "unity";
            } catch (Throwable unused) {
                str = "unity_pure";
            }
        } catch (Throwable unused2) {
            str = null;
        }
        if (str != null) {
            b2.a("develop_type", str);
        }
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, null);
    }

    public static void b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, AdSlot adSlot, int i2, int i3) {
        d b2 = d.b();
        b2.e("adapter_request").a("mediationrit_req_type", Integer.valueOf(i2)).a("mediationrit_req_type_src", Integer.valueOf(i3));
        HashMap hashMap = new HashMap();
        a(b2, adSlot, jVar, (TTBaseAd) null, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
    }

    private static void b(d dVar) {
        dVar.a("block_pacing", GMNetworkPlatformConst.AD_NETWORK_NO_PRICE);
        dVar.a("rit_adn_show_rule_id", GMNetworkPlatformConst.AD_NETWORK_NO_PRICE);
        dVar.a("block_show_count", GMNetworkPlatformConst.AD_NETWORK_NO_PRICE);
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

    /* JADX WARN: Removed duplicated region for block: B:34:0x0035 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(com.bytedance.msdk.api.AdSlot r3, java.lang.String r4) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "media_will_show"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.e(r1)
            java.lang.String r2 = "waterfall_abtest"
            r1.a(r2, r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r1 = 0
            a(r0, r3, r1, r1, r4)
            android.content.Context r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r3, r0, r4)
        L1f:
            r3 = 74
            r4 = 55
        L23:
            switch(r3) {
                case 72: goto L1f;
                case 73: goto L29;
                case 74: goto L2c;
                default: goto L26;
            }
        L26:
            r3 = 72
            goto L23
        L29:
            switch(r4) {
                case 94: goto L30;
                case 95: goto L35;
                case 96: goto L35;
                default: goto L2c;
            }
        L2c:
            r3 = 57
            if (r4 == r3) goto L35
        L30:
            r3 = 73
            r4 = 96
            goto L23
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(com.bytedance.msdk.api.AdSlot, java.lang.String):void");
    }

    public static void b(TTBaseAd tTBaseAd, AdSlot adSlot, int i2, String str, String str2, boolean z) {
        d b2 = d.b();
        b2.e("media_show_listen").a("adn_preload", Integer.valueOf((tTBaseAd == null || !tTBaseAd.isAdnPreload()) ? 0 : 1)).a("play_again", Integer.valueOf(i2)).a("is_repeat", Integer.valueOf(z ? 1 : 0));
        if (str != null) {
            b2.a("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            b2.a("callstack_message", str2);
        }
        HashMap hashMap = new HashMap();
        a(b2, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, hashMap);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, hashMap);
        for (char c2 = 16; c2 != 14; c2 = 14) {
        }
    }

    public static void b(TTBaseAd tTBaseAd, AdSlot adSlot, int i2, String str, boolean z) {
        b(tTBaseAd, adSlot, i2, str, null, z);
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d b2 = d.b();
        b2.e("callstack_dynamic");
        b2.a("callstack_message", str);
        b2.a("callstack_report_time", 1);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), b2, null);
    }
}
