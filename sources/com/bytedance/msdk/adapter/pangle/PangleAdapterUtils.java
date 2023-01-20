package com.bytedance.msdk.adapter.pangle;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMMediationAdSdk;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotDraw;
import com.bytedance.msdk.api.v2.slot.GMAdSlotNative;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PangleAdapterUtils {
    public static final double CPM_DEFLAUT_VALUE = 0.0d;
    public static final String MEDIA_EXTRA_COUPON = "coupon";
    public static final String MEDIA_EXTRA_LIVE_ROOM = "live_room";
    public static final String MEDIA_EXTRA_PRODUCT = "product";

    /* renamed from: com.bytedance.msdk.adapter.pangle.PangleAdapterUtils$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[GMAdConstant.GroMoreRitScenes.values().length];
            b = iArr;
            try {
                iArr[GMAdConstant.GroMoreRitScenes.CUSTOMIZE_SCENES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.HOME_OPEN_BONUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.HOME_SVIP_BONUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.HOME_GET_PROPS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.HOME_TRY_PROPS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.HOME_GET_BONUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.HOME_GIFT_BONUS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.GAME_START_BONUS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.GAME_REDUCE_WAITING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.GAME_MORE_KLLKRTUNITIES.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.GAME_FINISH_REWARDS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.GAME_GIFT_BONUS.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr2 = new int[TTAdConstant.GroMoreRitScenes.values().length];
            a = iArr2;
            try {
                iArr2[TTAdConstant.GroMoreRitScenes.CUSTOMIZE_SCENES.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.HOME_OPEN_BONUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.HOME_SVIP_BONUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.HOME_GET_PROPS.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.HOME_TRY_PROPS.ordinal()] = 5;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.HOME_GET_BONUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.HOME_GIFT_BONUS.ordinal()] = 7;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.GAME_START_BONUS.ordinal()] = 8;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.GAME_REDUCE_WAITING.ordinal()] = 9;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.GAME_MORE_KLLKRTUNITIES.ordinal()] = 10;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.GAME_FINISH_REWARDS.ordinal()] = 11;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.GAME_GIFT_BONUS.ordinal()] = 12;
            } catch (NoSuchFieldError unused24) {
            }
        }
    }

    private static TTAdConstant.RitScenes a(TTAdConstant.GroMoreRitScenes groMoreRitScenes) {
        if (groMoreRitScenes == null) {
            return null;
        }
        switch (AnonymousClass1.a[groMoreRitScenes.ordinal()]) {
            case 1:
                return TTAdConstant.RitScenes.CUSTOMIZE_SCENES;
            case 2:
                return TTAdConstant.RitScenes.HOME_OPEN_BONUS;
            case 3:
                return TTAdConstant.RitScenes.HOME_SVIP_BONUS;
            case 4:
                return TTAdConstant.RitScenes.HOME_GET_PROPS;
            case 5:
                return TTAdConstant.RitScenes.HOME_TRY_PROPS;
            case 6:
                return TTAdConstant.RitScenes.HOME_GET_BONUS;
            case 7:
                return TTAdConstant.RitScenes.HOME_GIFT_BONUS;
            case 8:
                return TTAdConstant.RitScenes.GAME_START_BONUS;
            case 9:
                return TTAdConstant.RitScenes.GAME_REDUCE_WAITING;
            case 10:
                return TTAdConstant.RitScenes.GAME_MORE_KLLKRTUNITIES;
            case 11:
                return TTAdConstant.RitScenes.GAME_FINISH_REWARDS;
            case 12:
                return TTAdConstant.RitScenes.GAME_GIFT_BONUS;
            default:
                return null;
        }
    }

    private static TTAdConstant.RitScenes b(GMAdConstant.GroMoreRitScenes groMoreRitScenes) {
        if (groMoreRitScenes == null) {
            return null;
        }
        switch (AnonymousClass1.b[groMoreRitScenes.ordinal()]) {
            case 1:
                return TTAdConstant.RitScenes.CUSTOMIZE_SCENES;
            case 2:
                return TTAdConstant.RitScenes.HOME_OPEN_BONUS;
            case 3:
                return TTAdConstant.RitScenes.HOME_SVIP_BONUS;
            case 4:
                return TTAdConstant.RitScenes.HOME_GET_PROPS;
            case 5:
                return TTAdConstant.RitScenes.HOME_TRY_PROPS;
            case 6:
                return TTAdConstant.RitScenes.HOME_GET_BONUS;
            case 7:
                return TTAdConstant.RitScenes.HOME_GIFT_BONUS;
            case 8:
                return TTAdConstant.RitScenes.GAME_START_BONUS;
            case 9:
                return TTAdConstant.RitScenes.GAME_REDUCE_WAITING;
            case 10:
                return TTAdConstant.RitScenes.GAME_MORE_KLLKRTUNITIES;
            case 11:
                return TTAdConstant.RitScenes.GAME_FINISH_REWARDS;
            case 12:
                return TTAdConstant.RitScenes.GAME_GIFT_BONUS;
            default:
                return null;
        }
    }

    public static AdSlot.Builder buildPangleAdSlot(com.bytedance.msdk.api.AdSlot adSlot, GMAdSlotBase gMAdSlotBase, String str, String str2, String str3, String str4, boolean z) {
        int adCount;
        AdSlot.Builder adCount2 = new AdSlot.Builder().setCodeId(str).setAdCount(1);
        if (adSlot != null) {
            Map<String, Object> extraObject = adSlot.getReuestParam().getExtraObject();
            int[] iArr = null;
            if (extraObject != null) {
                try {
                    iArr = (int[]) extraObject.get(GMAdConstant.PANGLE_VID);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            adCount2.setAdloadSeq(adSlot.getAdloadSeq()).setPrimeRit(adSlot.getAdUnitId()).setSupportDeepLink(adSlot.isSupportDeepLink());
            if (iArr != null && iArr.length > 0) {
                adCount2.setExternalABVid(iArr);
            }
            if (gMAdSlotBase != null) {
                if (gMAdSlotBase instanceof GMAdSlotNative) {
                    adCount = ((GMAdSlotNative) gMAdSlotBase).getRequestCount();
                } else if (gMAdSlotBase instanceof GMAdSlotDraw) {
                    adCount = ((GMAdSlotDraw) gMAdSlotBase).getAdCount();
                }
                adCount2.setAdCount(adCount);
            } else if (5 == adSlot.getAdType() || 9 == adSlot.getAdType()) {
                adCount = adSlot.getAdCount();
                adCount2.setAdCount(adCount);
            }
        }
        if (!TextUtils.isEmpty(str4)) {
            adCount2.withBid(str4);
        }
        e(adCount2, str2, str3, z);
        return adCount2;
    }

    public static AdSlot.Builder buildPangleAdSlot(com.bytedance.msdk.api.AdSlot adSlot, String str, String str2, String str3, String str4, boolean z) {
        return buildPangleAdSlot(adSlot, null, str, str2, str3, str4, z);
    }

    private static Map<String, String> c() {
        return GMMediationAdSdk.getPangleExtraData();
    }

    public static JSONArray d(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = TextUtils.isEmpty(str) ? new JSONArray() : new JSONArray(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            jSONArray = null;
        }
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    public static int dp2px(@NonNull Context context, int i2) {
        return (int) TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    private static void e(AdSlot.Builder builder, String str, String str2, boolean z) {
        JSONArray pangleDataAndExtraData = getPangleDataAndExtraData();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", "mediation_sdk_version");
            jSONObject.putOpt("value", "3.7.0.2");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("name", "mediation_req_type");
            jSONObject2.putOpt("value", "1");
            JSONObject jSONObject3 = null;
            if (!TextUtils.isEmpty(str)) {
                jSONObject3 = new JSONObject();
                jSONObject3.putOpt("name", "waterfall_abtest");
                jSONObject3.putOpt("value", str);
            }
            pangleDataAndExtraData.put(jSONObject2);
            pangleDataAndExtraData.put(jSONObject);
            if (jSONObject3 != null) {
                pangleDataAndExtraData.put(jSONObject3);
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putOpt("name", "m_req_id");
                jSONObject4.putOpt("value", str2);
                pangleDataAndExtraData.put(jSONObject4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!z) {
            setPanglePreviewParam(builder);
        }
        TTAdSdk.updatePaid(GMMediationAdSdk.getPanglePaid());
        if (builder != null) {
            builder.setUserData(pangleDataAndExtraData.toString());
        }
    }

    public static long getAdId(Map<String, Object> map) {
        if (map != null) {
            try {
                if (map.get(GMAdConstant.EXTRA_ADID) != null) {
                    return ((Long) map.get(GMAdConstant.EXTRA_ADID)).longValue();
                }
                return 0L;
            } catch (Throwable th) {
                th.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    public static long getCreativeId(Map<String, Object> map) {
        if (map != null) {
            try {
                if (map.get("creative_id") != null) {
                    return ((Long) map.get("creative_id")).longValue();
                }
                return 0L;
            } catch (Throwable th) {
                th.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    public static String getCustomRitScenes(Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get(TTAdConstant.GroMoreExtraKey.CUSTOMIZE_RIT_SCENES);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static String getPangleData() {
        return GMMediationAdSdk.getPangleData();
    }

    public static JSONArray getPangleDataAndExtraData() {
        JSONArray d2 = d(getPangleData());
        try {
            Map<String, String> c2 = c();
            if (c2 != null && c2.size() > 0) {
                for (String str : c2.keySet()) {
                    String str2 = c2.get(str);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("name", str);
                        jSONObject.putOpt("value", str2);
                        d2.put(jSONObject);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return d2;
    }

    public static String getReqId(Map<String, Object> map) {
        if (map == null || map.get("request_id") == null) {
            return null;
        }
        return (String) map.get("request_id");
    }

    public static TTAdConstant.RitScenes getRitScenes(Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get(TTAdConstant.GroMoreExtraKey.RIT_SCENES);
        if (obj instanceof TTAdConstant.GroMoreRitScenes) {
            return a((TTAdConstant.GroMoreRitScenes) obj);
        }
        if (obj instanceof GMAdConstant.GroMoreRitScenes) {
            return b((GMAdConstant.GroMoreRitScenes) obj);
        }
        return null;
    }

    public static double getValue(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof Float) && !(obj instanceof Double)) {
            try {
                if (obj instanceof String) {
                    return Double.valueOf((String) obj).doubleValue();
                }
                return 0.0d;
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        return ((Double) obj).doubleValue();
    }

    public static void setPangleData(String str) {
        GMMediationAdSdk.setPangleData(str);
    }

    public static void setPanglePreviewParam(AdSlot.Builder builder) {
        if (builder != null && GMMediationAdSdk.isTestDemo()) {
            try {
                String valueFromPPeInfo = GMMediationAdSdk.getValueFromPPeInfo("tt_pangle_preview_ad_id");
                String valueFromPPeInfo2 = GMMediationAdSdk.getValueFromPPeInfo("tt_pangle_preview_creative_id");
                String valueFromPPeInfo3 = GMMediationAdSdk.getValueFromPPeInfo("tt_pangle_preview_ext");
                if (TextUtils.isEmpty(valueFromPPeInfo) || TextUtils.isEmpty(valueFromPPeInfo2) || TextUtils.isEmpty(valueFromPPeInfo3)) {
                    return;
                }
                builder.setAdId(valueFromPPeInfo).setCreativeId(valueFromPPeInfo2).setExt(valueFromPPeInfo3);
            } catch (Throwable unused) {
            }
        }
    }
}
