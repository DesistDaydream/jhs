package com.bytedance.msdk.api.v2;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class GMConfigUserInfoForSegment {
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNKNOWN = "unknown";
    public final String TAG = "TTMediationSDK";
    private String a = "";
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f2016c = "";

    /* renamed from: d  reason: collision with root package name */
    private int f2017d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f2018e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f2019f = "";

    /* renamed from: g  reason: collision with root package name */
    private Map<String, String> f2020g;

    public static boolean checkValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00af, code lost:
        if (r7 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            if (r6 != r7) goto L6
            goto Lb9
        L6:
            if (r7 == 0) goto Lb8
            java.lang.Class<com.bytedance.msdk.api.v2.GMConfigUserInfoForSegment> r2 = com.bytedance.msdk.api.v2.GMConfigUserInfoForSegment.class
            java.lang.Class r3 = r7.getClass()
            if (r2 == r3) goto L12
            goto Lb8
        L12:
            com.bytedance.msdk.api.v2.GMConfigUserInfoForSegment r7 = (com.bytedance.msdk.api.v2.GMConfigUserInfoForSegment) r7
            int r2 = r6.getAge()
            int r3 = r7.getAge()
            if (r2 != r3) goto L66
            java.lang.String r2 = r6.getUserValueGroup()
            java.lang.String r3 = r7.getUserValueGroup()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L66
            java.lang.String r2 = r6.getUserId()
            java.lang.String r3 = r7.getUserId()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L66
            java.lang.String r2 = r6.getChannel()
            java.lang.String r3 = r7.getChannel()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L66
            java.lang.String r2 = r6.getSubChannel()
            java.lang.String r3 = r7.getSubChannel()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L66
            java.lang.String r2 = r6.getGender()
            java.lang.String r3 = r7.getGender()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L66
            r2 = 1
            goto L67
        L66:
            r2 = 0
        L67:
            java.util.Map r7 = r7.getCustomInfos()
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.f2020g
            if (r3 == 0) goto Lad
            if (r7 == 0) goto Lad
            int r3 = r3.size()
            int r4 = r7.size()
            if (r3 == r4) goto L7c
            goto Lb3
        L7c:
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.f2020g
            java.util.Set r3 = r3.keySet()
            java.util.Iterator r3 = r3.iterator()
        L86:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Lb1
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L86
            java.util.Map<java.lang.String, java.lang.String> r5 = r6.f2020g
            java.lang.Object r5 = r5.get(r4)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r4 = r7.get(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 != 0) goto L86
            goto Lb3
        Lad:
            if (r3 != 0) goto Lb3
            if (r7 != 0) goto Lb3
        Lb1:
            r7 = 1
            goto Lb4
        Lb3:
            r7 = 0
        Lb4:
            if (r2 == 0) goto Lb8
            if (r7 != 0) goto Lb9
        Lb8:
            r0 = 0
        Lb9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.api.v2.GMConfigUserInfoForSegment.equals(java.lang.Object):boolean");
    }

    public int getAge() {
        return this.f2017d;
    }

    public String getChannel() {
        return this.b;
    }

    public Map<String, String> getCustomInfos() {
        return this.f2020g;
    }

    public String getGender() {
        return this.f2018e;
    }

    public String getSubChannel() {
        return this.f2016c;
    }

    public String getUserId() {
        return this.a;
    }

    public String getUserValueGroup() {
        return this.f2019f;
    }

    public void setAge(int i2) {
        this.f2017d = i2;
    }

    public void setChannel(String str) {
        if (checkValid(str)) {
            this.b = str;
        } else {
            Log.e("TTMediationSDK", "流量分组channer字段存在不合法输入");
        }
    }

    public void setCustomInfos(Map<String, String> map) {
        StringBuilder sb;
        String str;
        this.f2020g = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!checkValid(entry.getKey())) {
                    sb = new StringBuilder();
                    sb.append("流量分组");
                    sb.append(entry.getKey());
                    str = "字段存在不合法输入";
                } else if (checkValid(entry.getValue())) {
                    this.f2020g.put(entry.getKey(), entry.getValue());
                } else {
                    sb = new StringBuilder();
                    sb.append("流量分组");
                    sb.append(entry.getKey());
                    sb.append("字段的值");
                    sb.append(entry.getValue());
                    str = "存在不合法输入";
                }
                sb.append(str);
                Log.e("TTMediationSDK", sb.toString());
            }
        }
    }

    public void setGender(String str) {
        if (checkValid(str)) {
            this.f2018e = str;
        } else {
            Log.e("TTMediationSDK", "流量分组gender字段存在不合法输入");
        }
    }

    public void setSubChannel(String str) {
        if (checkValid(str)) {
            this.f2016c = str;
        } else {
            Log.e("TTMediationSDK", "流量分组sub_channer字段存在不合法输入");
        }
    }

    public void setUserId(String str) {
        if (checkValid(str)) {
            this.a = str;
        } else {
            Log.e("TTMediationSDK", "流量分组user_id字段存在不合法输入");
        }
    }

    public void setUserValueGroup(String str) {
        if (checkValid(str)) {
            this.f2019f = str;
        } else {
            Log.e("TTMediationSDK", "流量分组user_value_group字段存在不合法输入");
        }
    }
}
