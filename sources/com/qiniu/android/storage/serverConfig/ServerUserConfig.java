package com.qiniu.android.storage.serverConfig;

import com.qiniu.android.utils.Utils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ServerUserConfig {
    private Boolean http3Enable;
    private JSONObject info;
    private Boolean networkCheckEnable;
    private long timestamp;
    private long ttl;

    public ServerUserConfig(JSONObject jSONObject) {
        this.ttl = 10L;
        if (jSONObject == null) {
            return;
        }
        this.info = jSONObject;
        this.ttl = jSONObject.optLong("ttl", 300L);
        if (jSONObject.opt("timestamp") != null) {
            this.timestamp = jSONObject.optLong("timestamp");
        }
        if (this.timestamp == 0) {
            long currentSecondTimestamp = Utils.currentSecondTimestamp();
            this.timestamp = currentSecondTimestamp;
            try {
                jSONObject.putOpt("timestamp", Long.valueOf(currentSecondTimestamp));
            } catch (JSONException unused) {
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("http3");
        if (optJSONObject != null && optJSONObject.opt("enabled") != null) {
            this.http3Enable = Boolean.valueOf(optJSONObject.optBoolean("enabled"));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("network_check");
        if (optJSONObject2 == null || optJSONObject2.opt("enabled") == null) {
            return;
        }
        this.networkCheckEnable = Boolean.valueOf(optJSONObject2.optBoolean("enabled"));
    }

    public Boolean getHttp3Enable() {
        return this.http3Enable;
    }

    public JSONObject getInfo() {
        return this.info;
    }

    public Boolean getNetworkCheckEnable() {
        return this.networkCheckEnable;
    }

    public boolean isValid() {
        return Utils.currentSecondTimestamp() < this.timestamp + this.ttl;
    }
}
