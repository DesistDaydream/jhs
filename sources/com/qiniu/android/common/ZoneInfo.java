package com.qiniu.android.common;

import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ZoneInfo implements Cloneable {
    private static int DOMAIN_FROZEN_SECONDS = 600;
    public static final String EmptyRegionId = "unknown";
    public static final String SDKDefaultIOHost = "sdkDefaultIOHost";
    public List<String> allHosts;
    private final Date buildDate = new Date();
    public JSONObject detailInfo;
    public final List<String> domains;
    public final boolean http3Enabled;
    public final boolean ipv6;
    public final List<String> old_domains;
    public final String regionId;
    public final int ttl;

    @Deprecated
    /* loaded from: classes3.dex */
    public static class UploadServerGroup {
        public final ArrayList<String> allHosts;
        public final ArrayList<String> backup;
        public final String info;
        public final ArrayList<String> main;

        public UploadServerGroup(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
            this.info = str;
            this.main = arrayList;
            this.backup = arrayList2;
            this.allHosts = arrayList3;
        }

        public static UploadServerGroup buildInfoFromJson(JSONObject jSONObject) {
            String str = null;
            if (jSONObject == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            try {
                str = jSONObject.getString("info");
            } catch (JSONException unused) {
            }
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("main");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string = jSONArray.getString(i2);
                    arrayList.add(string);
                    arrayList3.add(string);
                }
            } catch (JSONException unused2) {
            }
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("backup");
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    String string2 = jSONArray2.getString(i3);
                    arrayList.add(string2);
                    arrayList3.add(string2);
                }
            } catch (JSONException unused3) {
            }
            return new UploadServerGroup(str, arrayList, arrayList2, arrayList3);
        }
    }

    private ZoneInfo(int i2, boolean z, boolean z2, String str, List<String> list, List<String> list2) {
        this.ttl = i2;
        this.http3Enabled = z;
        this.ipv6 = z2;
        this.regionId = str;
        this.domains = list;
        this.old_domains = list2;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        this.allHosts = arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.qiniu.android.common.ZoneInfo buildFromJson(org.json.JSONObject r12) throws org.json.JSONException {
        /*
            r0 = 0
            if (r12 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = "ttl"
            int r3 = r12.optInt(r1)
            r1 = 0
            java.lang.String r2 = "features"
            org.json.JSONObject r2 = r12.getJSONObject(r2)     // Catch: java.lang.Exception -> L31
            java.lang.String r4 = "http3"
            org.json.JSONObject r4 = r2.optJSONObject(r4)     // Catch: java.lang.Exception -> L31
            java.lang.String r5 = "enabled"
            if (r4 == 0) goto L20
            boolean r4 = r4.optBoolean(r5)     // Catch: java.lang.Exception -> L31
            goto L21
        L20:
            r4 = 0
        L21:
            java.lang.String r6 = "ipv6"
            org.json.JSONObject r2 = r2.optJSONObject(r6)     // Catch: java.lang.Exception -> L32
            if (r2 == 0) goto L2e
            boolean r2 = r2.optBoolean(r5)     // Catch: java.lang.Exception -> L32
            goto L2f
        L2e:
            r2 = 0
        L2f:
            r5 = r2
            goto L33
        L31:
            r4 = 0
        L32:
            r5 = 0
        L33:
            java.lang.String r2 = "region"
            java.lang.String r6 = "unknown"
            java.lang.String r6 = r12.optString(r2, r6)
            java.lang.String r2 = "up"
            org.json.JSONObject r2 = r12.optJSONObject(r2)
            if (r2 != 0) goto L44
            return r0
        L44:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.lang.String r8 = "domains"
            org.json.JSONArray r8 = r2.optJSONArray(r8)
            if (r8 == 0) goto L70
            int r9 = r8.length()
            if (r9 <= 0) goto L70
            r9 = 0
        L58:
            int r10 = r8.length()
            if (r9 >= r10) goto L70
            java.lang.String r10 = r8.optString(r9)
            if (r10 == 0) goto L6d
            int r11 = r10.length()
            if (r11 <= 0) goto L6d
            r7.add(r10)
        L6d:
            int r9 = r9 + 1
            goto L58
        L70:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.String r9 = "old"
            org.json.JSONArray r2 = r2.optJSONArray(r9)
            if (r2 == 0) goto L9b
            int r9 = r2.length()
            if (r9 <= 0) goto L9b
        L83:
            int r9 = r2.length()
            if (r1 >= r9) goto L9b
            java.lang.String r9 = r2.optString(r1)
            if (r9 == 0) goto L98
            int r10 = r9.length()
            if (r10 <= 0) goto L98
            r8.add(r9)
        L98:
            int r1 = r1 + 1
            goto L83
        L9b:
            int r1 = r7.size()
            if (r1 != 0) goto La8
            int r1 = r8.size()
            if (r1 != 0) goto La8
            return r0
        La8:
            com.qiniu.android.common.ZoneInfo r0 = new com.qiniu.android.common.ZoneInfo
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r0.detailInfo = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.common.ZoneInfo.buildFromJson(org.json.JSONObject):com.qiniu.android.common.ZoneInfo");
    }

    public static ZoneInfo buildInfo(List<String> list, String str) {
        return buildInfo(list, null, str);
    }

    public Object clone() throws CloneNotSupportedException {
        ZoneInfo zoneInfo = new ZoneInfo(this.ttl, this.http3Enabled, this.ipv6, this.regionId, this.domains, this.old_domains);
        zoneInfo.detailInfo = this.detailInfo;
        return zoneInfo;
    }

    public String getRegionId() {
        return this.regionId;
    }

    public boolean isValid() {
        return this.ttl > ((int) (((double) new Date().getTime()) * 0.001d)) - ((int) (((double) this.buildDate.getTime()) * 0.001d));
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("ttl", Integer.valueOf(this.ttl));
        hashMap.put("allHost", this.allHosts);
        return new JSONObject(hashMap).toString();
    }

    public static ZoneInfo buildInfo(List<String> list, List<String> list2, String str) {
        if (list == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("domains", new JSONArray((Collection) list));
        if (list2 != null) {
            hashMap.put("old", new JSONArray((Collection) list2));
        }
        JSONObject jSONObject = new JSONObject(hashMap);
        if (str == null) {
            str = "unknown";
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("ttl", Integer.valueOf((int) BaseConstants.Time.DAY));
        hashMap2.put("region", str);
        hashMap2.put("up", jSONObject);
        try {
            return buildFromJson(new JSONObject(hashMap2));
        } catch (JSONException unused) {
            return null;
        }
    }
}
