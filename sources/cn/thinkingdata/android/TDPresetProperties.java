package cn.thinkingdata.android;

import android.content.Context;
import android.content.res.Resources;
import cn.thinkingdata.android.utils.TDLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TDPresetProperties {
    private static final String TAG = "ThinkingAnalytics.TDPresetProperties";
    public static final List<String> disableList = new ArrayList();
    public String appVersion;
    public String bundleId;
    public String carrier;
    public String deviceId;
    public String deviceModel;
    public String deviceType;
    public String disk;
    public int fps;
    public String installTime;
    public boolean isSimulator;
    public String manufacture;
    public String networkType;
    public String os;
    public String osVersion;
    private JSONObject presetProperties;
    public String ram;
    public int screenHeight;
    public int screenWidth;
    public String systemLanguage;
    public double zoneOffset;

    public TDPresetProperties() {
    }

    public TDPresetProperties(JSONObject jSONObject) {
        this.presetProperties = jSONObject;
        List<String> list = disableList;
        if (!list.contains("#bundle_id")) {
            this.bundleId = jSONObject.optString("#bundle_id");
        }
        if (!list.contains("#carrier")) {
            this.carrier = jSONObject.optString("#carrier");
        }
        if (!list.contains("#device_id")) {
            this.deviceId = jSONObject.optString("#device_id");
        }
        if (!list.contains("#device_model")) {
            this.deviceModel = jSONObject.optString("#device_model");
        }
        if (!list.contains("#manufacturer")) {
            this.manufacture = jSONObject.optString("#manufacturer");
        }
        if (!list.contains("#network_type")) {
            this.networkType = jSONObject.optString("#network_type");
        }
        if (!list.contains("#os")) {
            this.os = jSONObject.optString("#os");
        }
        if (!list.contains("#os_version")) {
            this.osVersion = jSONObject.optString("#os_version");
        }
        if (!list.contains("#screen_height")) {
            this.screenHeight = jSONObject.optInt("#screen_height");
        }
        if (!list.contains("#screen_width")) {
            this.screenWidth = jSONObject.optInt("#screen_width");
        }
        if (!list.contains("#system_language")) {
            this.systemLanguage = jSONObject.optString("#system_language");
        }
        if (!list.contains("#zone_offset")) {
            this.zoneOffset = jSONObject.optDouble("#zone_offset");
        }
        if (!list.contains("#app_version")) {
            this.appVersion = jSONObject.optString("#app_version");
        }
        if (!list.contains("#install_time")) {
            this.installTime = jSONObject.optString("#install_time");
        }
        if (!list.contains("#simulator")) {
            this.isSimulator = jSONObject.optBoolean("#simulator");
        }
        if (!list.contains("#ram")) {
            this.ram = jSONObject.optString("#ram");
        }
        if (!list.contains("#disk")) {
            this.disk = jSONObject.optString("#disk");
        }
        if (!list.contains("#fps")) {
            this.fps = jSONObject.optInt("#fps");
        }
        if (list.contains("#device_type")) {
            return;
        }
        this.deviceType = jSONObject.optString("#device_type");
    }

    public static void initDisableList(Context context) {
        String str;
        String noClassDefFoundError;
        List<String> list = disableList;
        synchronized (list) {
            if (list.isEmpty()) {
                try {
                    Resources resources = context.getResources();
                    list.addAll(Arrays.asList(resources.getStringArray(resources.getIdentifier("TDDisPresetProperties", "array", context.getPackageName()))));
                } catch (Exception e2) {
                    str = TAG;
                    noClassDefFoundError = e2.toString();
                    TDLog.e(str, noClassDefFoundError);
                } catch (NoClassDefFoundError e3) {
                    str = TAG;
                    noClassDefFoundError = e3.toString();
                    TDLog.e(str, noClassDefFoundError);
                }
            }
        }
    }

    public static void initDisableList(String[] strArr) {
        List<String> list = disableList;
        synchronized (list) {
            list.clear();
            list.addAll(Arrays.asList(strArr));
        }
    }

    public JSONObject toEventPresetProperties() {
        return this.presetProperties;
    }
}
