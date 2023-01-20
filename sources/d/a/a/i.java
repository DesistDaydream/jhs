package d.a.a;

import android.content.Context;
import android.content.Intent;
import cn.thinkingdata.android.TDConfig;
import cn.thinkingdata.android.TDPresetProperties;
import cn.thinkingdata.android.ThinkingAnalyticsSDK;
import d.a.a.o.n;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class i extends ThinkingAnalyticsSDK {
    public Context a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    private final JSONObject f9290c;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[cn.thinkingdata.android.utils.l.values().length];
            a = iArr;
            try {
                iArr[cn.thinkingdata.android.utils.l.TRACK_OVERWRITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[cn.thinkingdata.android.utils.l.TRACK_UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[cn.thinkingdata.android.utils.l.TRACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public i(TDConfig tDConfig) {
        super(tDConfig, new boolean[0]);
        this.a = tDConfig.mContext;
        this.f9290c = new JSONObject();
        this.b = n.y(this.a);
    }

    public double a(String str) {
        c cVar;
        synchronized (this.mTrackTimer) {
            cVar = this.mTrackTimer.get(str);
            this.mTrackTimer.remove(str);
        }
        if (cVar != null) {
            return Double.parseDouble(cVar.c());
        }
        return 0.0d;
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void autoTrack(String str, JSONObject jSONObject) {
        Intent b = b();
        b.putExtra("#event_name", str);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject c2 = c(str, jSONObject);
        try {
            JSONObject optJSONObject = getAutoTrackProperties().optJSONObject(str);
            if (optJSONObject != null) {
                n.v(optJSONObject, c2, this.mConfig.getDefaultTimeZone());
            }
            b.putExtra("properties", c2.toString());
            b.putExtra("TD_ACTION", 1048582);
            this.a.sendBroadcast(b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Intent b() {
        Intent intent = new Intent();
        String D = n.D(this.a);
        String str = "cn.thinkingdata.receiver";
        if (D.length() != 0) {
            str = D + ".cn.thinkingdata.receiver";
        }
        intent.setAction(str);
        intent.putExtra("#app_id", this.mConfig.getName());
        return intent;
    }

    public JSONObject c(String str, JSONObject jSONObject) {
        JSONObject dynamicSuperProperties;
        JSONObject jSONObject2 = new JSONObject();
        try {
            List<String> list = TDPresetProperties.disableList;
            if (!list.contains("#bundle_id")) {
                jSONObject2.put("#bundle_id", this.b);
            }
            double a2 = a(str);
            if (a2 > 0.0d && !list.contains("#duration")) {
                jSONObject2.put("#duration", a2);
            }
        } catch (JSONException unused) {
        }
        if (getDynamicSuperPropertiesTracker() != null && (dynamicSuperProperties = getDynamicSuperPropertiesTracker().getDynamicSuperProperties()) != null) {
            try {
                n.v(dynamicSuperProperties, jSONObject2, this.mConfig.getDefaultTimeZone());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (getDynamicSuperPropertiesTrackerListener() != null) {
            try {
                n.v(new JSONObject(getDynamicSuperPropertiesTrackerListener().getDynamicSuperPropertiesString()), jSONObject2, this.mConfig.getDefaultTimeZone());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        try {
            n.v(jSONObject, jSONObject2, this.mConfig.getDefaultTimeZone());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject2;
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void clearSuperProperties() {
        Intent b = b();
        b.putExtra("TD_ACTION", 2097159);
        this.a.sendBroadcast(b);
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void enableAutoTrack(List<ThinkingAnalyticsSDK.AutoTrackEventType> list, ThinkingAnalyticsSDK.AutoTrackEventListener autoTrackEventListener) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void enableTracking(boolean z) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void flush() {
        Intent b = b();
        b.putExtra("TD_ACTION", 2097157);
        this.a.sendBroadcast(b);
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public JSONObject getAutoTrackProperties() {
        return this.f9290c;
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public boolean hasOptOut() {
        return false;
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void identify(String str) {
        Intent b = b();
        b.putExtra("TD_ACTION", 2097156);
        b.putExtra("#distinct_id", (str == null || str.length() <= 0) ? "" : "");
        this.a.sendBroadcast(b);
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void login(String str) {
        Intent b = b();
        b.putExtra("TD_ACTION", 2097154);
        b.putExtra("#account_id", (str == null || str.length() <= 0) ? "" : "");
        this.a.sendBroadcast(b);
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void logout() {
        Intent b = b();
        b.putExtra("TD_ACTION", 2097155);
        this.a.sendBroadcast(b);
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void optInTracking() {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void optOutTracking() {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void optOutTrackingAndDeleteUser() {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void setAutoTrackProperties(List<ThinkingAnalyticsSDK.AutoTrackEventType> list, JSONObject jSONObject) {
        if (hasDisabled()) {
            return;
        }
        if (jSONObject != null) {
            try {
                if (cn.thinkingdata.android.utils.g.b(jSONObject)) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (ThinkingAnalyticsSDK.AutoTrackEventType autoTrackEventType : list) {
                        JSONObject jSONObject3 = new JSONObject();
                        n.v(jSONObject, jSONObject3, this.mConfig.getDefaultTimeZone());
                        jSONObject2.put(autoTrackEventType.getEventName(), jSONObject3);
                    }
                    synchronized (this.f9290c) {
                        n.A(jSONObject2, this.f9290c, this.mConfig.getDefaultTimeZone());
                    }
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (this.mConfig.shouldThrowException()) {
            throw new cn.thinkingdata.android.m("Set autoTrackEvent properties failed. Please refer to the SDK debug log for details.");
        }
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void setNetworkType(ThinkingAnalyticsSDK.ThinkingdataNetworkType thinkingdataNetworkType) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void setSuperProperties(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            n.v(jSONObject, jSONObject2, this.mConfig.getDefaultTimeZone());
            Intent b = b();
            b.putExtra("TD_ACTION", 2097153);
            if (jSONObject != null) {
                b.putExtra("properties", jSONObject2.toString());
            }
            this.a.sendBroadcast(b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void setTrackStatus(ThinkingAnalyticsSDK.TATrackStatus tATrackStatus) {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void track(d.a.a.l r5) {
        /*
            r4 = this;
            android.content.Intent r0 = r4.b()
            int[] r1 = d.a.a.i.a.a
            cn.thinkingdata.android.utils.l r2 = r5.getDataType()
            int r2 = r2.ordinal()
            r1 = r1[r2]
            java.lang.String r2 = "TD_ACTION"
            r3 = 1
            if (r1 == r3) goto L24
            r3 = 2
            if (r1 == r3) goto L20
            r3 = 3
            if (r1 == r3) goto L1c
            goto L2a
        L1c:
            r1 = 1048579(0x100003, float:1.469372E-39)
            goto L27
        L20:
            r1 = 1048580(0x100004, float:1.469374E-39)
            goto L27
        L24:
            r1 = 1048581(0x100005, float:1.469375E-39)
        L27:
            r0.putExtra(r2, r1)
        L2a:
            java.lang.String r1 = r5.getEventName()
            java.lang.String r2 = "#event_name"
            r0.putExtra(r2, r1)
            org.json.JSONObject r1 = r5.getProperties()
            if (r1 != 0) goto L3f
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            goto L43
        L3f:
            org.json.JSONObject r1 = r5.getProperties()
        L43:
            java.lang.String r2 = r5.getEventName()
            org.json.JSONObject r1 = r4.c(r2, r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "properties"
            r0.putExtra(r2, r1)
            java.util.Date r1 = r5.getEventTime()
            if (r1 == 0) goto L67
            java.util.Date r1 = r5.getEventTime()
            long r1 = r1.getTime()
            java.lang.String r3 = "TD_DATE"
            r0.putExtra(r3, r1)
        L67:
            java.util.TimeZone r1 = r5.getTimeZone()
            if (r1 == 0) goto L7a
            java.util.TimeZone r1 = r5.getTimeZone()
            java.lang.String r1 = r1.getID()
            java.lang.String r2 = "TD_KEY_TIMEZONE"
            r0.putExtra(r2, r1)
        L7a:
            java.lang.String r5 = r5.getExtraValue()
            java.lang.String r1 = "TD_KEY_EXTRA_FIELD"
            r0.putExtra(r1, r5)
            android.content.Context r5 = r4.a
            r5.sendBroadcast(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.a.i.track(d.a.a.l):void");
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void track(String str) {
        track(str, (JSONObject) null, (Date) null, (TimeZone) null);
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void track(String str, JSONObject jSONObject) {
        track(str, jSONObject, (Date) null, (TimeZone) null);
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void track(String str, JSONObject jSONObject, Date date) {
        track(str, jSONObject, date, (TimeZone) null);
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void track(String str, JSONObject jSONObject, Date date, TimeZone timeZone) {
        Intent b = b();
        b.putExtra("TD_ACTION", 1048578);
        b.putExtra("#event_name", str);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        b.putExtra("properties", c(str, jSONObject).toString());
        if (date != null) {
            b.putExtra("TD_DATE", date.getTime());
        }
        if (timeZone != null) {
            b.putExtra("TD_KEY_TIMEZONE", timeZone.getID());
        }
        this.a.sendBroadcast(b);
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void unsetSuperProperty(String str) {
        Intent b = b();
        b.putExtra("TD_ACTION", 2097158);
        if (str != null) {
            b.putExtra("properties", str);
        }
        this.a.sendBroadcast(b);
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void user_operations(cn.thinkingdata.android.utils.l lVar, JSONObject jSONObject, Date date) {
        Intent b = b();
        b.putExtra("TD_ACTION", 2097152);
        b.putExtra("TD_KEY_USER_PROPERTY_SET_TYPE", lVar.a());
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                n.v(jSONObject, jSONObject2, this.mConfig.getDefaultTimeZone());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            b.putExtra("properties", jSONObject2.toString());
        }
        if (date != null) {
            b.putExtra("TD_DATE", date.getTime());
        }
        this.a.sendBroadcast(b);
    }
}
