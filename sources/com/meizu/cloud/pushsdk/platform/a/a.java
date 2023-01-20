package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bc;
import com.bytedance.msdk.api.reward.RewardItem;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.tencent.android.tpush.common.Constants;
import java.io.File;
import java.util.LinkedHashMap;

/* loaded from: classes2.dex */
public class a {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f4923c;

    /* renamed from: d  reason: collision with root package name */
    private String f4924d;

    /* renamed from: e  reason: collision with root package name */
    private String f4925e;

    /* renamed from: f  reason: collision with root package name */
    private String f4926f;

    /* renamed from: g  reason: collision with root package name */
    private String f4927g;

    /* renamed from: h  reason: collision with root package name */
    private String f4928h;

    /* renamed from: i  reason: collision with root package name */
    private String f4929i;

    /* renamed from: j  reason: collision with root package name */
    private String f4930j;

    /* renamed from: k  reason: collision with root package name */
    private String f4931k;

    /* renamed from: l  reason: collision with root package name */
    private String f4932l;

    /* renamed from: m  reason: collision with root package name */
    private String f4933m;
    private String n;
    private String o;

    public a(Context context) {
        this.a = "https://api-push.meizu.com/garcia/api/client/";
        this.b = this.a + "message/registerPush";
        this.f4923c = this.a + "message/unRegisterPush";
        this.f4924d = this.a + "advance/unRegisterPush";
        this.f4925e = this.a + "message/getRegisterSwitch";
        this.f4926f = this.a + "message/changeRegisterSwitch";
        this.f4927g = this.a + "message/changeAllSwitch";
        this.f4928h = this.a + "message/subscribeTags";
        this.f4929i = this.a + "message/unSubscribeTags";
        this.f4930j = this.a + "message/unSubAllTags";
        this.f4931k = this.a + "message/getSubTags";
        this.f4932l = this.a + "message/subscribeAlias";
        this.f4933m = this.a + "message/unSubscribeAlias";
        this.n = this.a + "message/getSubAlias";
        this.o = this.a + "advance/changeRegisterSwitch";
        com.meizu.cloud.pushsdk.c.a.a();
        if (MzSystemUtils.isOverseas()) {
            this.a = "https://api-push.in.meizu.com/garcia/api/client/";
            this.b = this.a + "message/registerPush";
            this.f4923c = this.a + "message/unRegisterPush";
            this.f4924d = this.a + "advance/unRegisterPush";
            this.f4925e = this.a + "message/getRegisterSwitch";
            this.f4926f = this.a + "message/changeRegisterSwitch";
            this.f4927g = this.a + "message/changeAllSwitch";
            this.f4928h = this.a + "message/subscribeTags";
            this.f4929i = this.a + "message/unSubscribeTags";
            this.f4930j = this.a + "message/unSubAllTags";
            this.f4931k = this.a + "message/getSubTags";
            this.f4932l = this.a + "message/subscribeAlias";
            this.f4933m = this.a + "message/unSubscribeAlias";
            this.n = this.a + "message/getSubAlias";
            this.o = this.a + "advance/changeRegisterSwitch";
        }
    }

    public c a(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(Constants.FLAG_DEVICE_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        e.p.a.a.a.c("PushAPI", "register post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.b).a(linkedHashMap2).a().a();
    }

    public c a(String str, String str2, String str3, int i2, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("msgType", String.valueOf(i2));
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        e.p.a.a.a.c("PushAPI", this.f4926f + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.f4926f).a(linkedHashMap2).a().a();
    }

    public c<String> a(String str, String str2, String str3, File file) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("msgId", str);
        linkedHashMap.put(Constants.FLAG_DEVICE_ID, str2);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, "4a2ca769d79f4856bb3bd982d30de790"));
        if (!TextUtils.isEmpty(str3)) {
            linkedHashMap2.put(RewardItem.KEY_ERROR_MSG, str3);
        }
        e.p.a.a.a.c("PushAPI", "uploadLogFile post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.c("https://api-push.meizu.com/garcia/api/client/log/upload").a(linkedHashMap2).a("logFile", file).a().a();
    }

    public c a(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put(bc.f1477l, str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        e.p.a.a.a.c("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.f4928h).a(linkedHashMap2).a().a();
    }

    public c a(String str, String str2, String str3, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        e.p.a.a.a.c("PushAPI", this.f4927g + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.f4927g).a(linkedHashMap2).a().a();
    }

    public c b(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(Constants.FLAG_DEVICE_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        e.p.a.a.a.c("PushAPI", "unregister post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.a(this.f4923c).a(linkedHashMap2).a().a();
    }

    public c b(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put(bc.f1477l, str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        e.p.a.a.a.c("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.f4929i).a(linkedHashMap2).a().a();
    }

    public c c(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        e.p.a.a.a.c("PushAPI", "checkPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.a(this.f4925e).a(linkedHashMap2).a().a();
    }

    public c c(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(com.heytap.mcssdk.constant.b.z, str2);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put(PushConstants.SUB_ALIAS_STATUS_NAME, str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        e.p.a.a.a.c("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.f4932l).a(linkedHashMap2).a().a();
    }

    public c d(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        e.p.a.a.a.c("PushAPI", "subScribeAllTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.f4930j).a(linkedHashMap2).a().a();
    }

    public c d(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put(PushConstants.SUB_ALIAS_STATUS_NAME, str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        e.p.a.a.a.c("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.f4933m).a(linkedHashMap2).a().a();
    }

    public c e(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", com.meizu.cloud.pushsdk.platform.b.a(linkedHashMap, str2));
        e.p.a.a.a.c("PushAPI", "checkPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.a(this.f4931k).a(linkedHashMap2).a().a();
    }
}
