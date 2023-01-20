package com.qiniu.android.http.dns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DnsCacheInfo implements Serializable {
    private String currentTime;
    private ConcurrentHashMap<String, List<IDnsNetworkAddress>> info;
    private String localIp;

    public DnsCacheInfo() {
    }

    public static DnsCacheInfo createDnsCacheInfoByData(byte[] bArr) {
        String str;
        String str2;
        JSONObject jSONObject;
        if (bArr == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(new String(bArr));
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            try {
                str = jSONObject2.getString("currentTime");
            } catch (Exception unused) {
                str = null;
            }
            try {
                str2 = jSONObject2.getString("localIp");
            } catch (Exception unused2) {
                str2 = null;
            }
            try {
                jSONObject = jSONObject2.getJSONObject("info");
            } catch (Exception unused3) {
                jSONObject = null;
            }
            if (str == null || str2 == null || jSONObject == null) {
                return null;
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        arrayList.add(DnsNetworkAddress.address(jSONArray.getJSONObject(i2)));
                    }
                    if (arrayList.size() > 0) {
                        concurrentHashMap.put(next, arrayList);
                    }
                } catch (Exception unused4) {
                }
            }
            return new DnsCacheInfo(str, str2, concurrentHashMap);
        } catch (Exception unused5) {
            return null;
        }
    }

    public String cacheKey() {
        return this.localIp;
    }

    public String getCurrentTime() {
        return this.currentTime;
    }

    public ConcurrentHashMap<String, List<IDnsNetworkAddress>> getInfo() {
        return this.info;
    }

    public String getLocalIp() {
        return this.localIp;
    }

    public void setCurrentTime(String str) {
        this.currentTime = str;
    }

    public void setInfo(ConcurrentHashMap<String, List<IDnsNetworkAddress>> concurrentHashMap) {
        this.info = concurrentHashMap;
    }

    public void setLocalIp(String str) {
        this.localIp = str;
    }

    public byte[] toJsonData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("currentTime", this.currentTime);
        } catch (JSONException unused) {
        }
        try {
            jSONObject.putOpt("localIp", this.localIp);
        } catch (JSONException unused2) {
        }
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.info.keySet()) {
            List<IDnsNetworkAddress> list = this.info.get(str);
            JSONArray jSONArray = new JSONArray();
            if (list != null) {
                for (IDnsNetworkAddress iDnsNetworkAddress : list) {
                    if (iDnsNetworkAddress instanceof DnsNetworkAddress) {
                        try {
                            jSONArray.put(((DnsNetworkAddress) iDnsNetworkAddress).toJson());
                        } catch (Exception unused3) {
                        }
                    }
                }
            }
            if (jSONArray.length() > 0) {
                try {
                    jSONObject2.put(str, jSONArray);
                } catch (JSONException unused4) {
                }
            }
        }
        try {
            jSONObject.putOpt("info", jSONObject2);
        } catch (JSONException unused5) {
        }
        return jSONObject.toString().getBytes();
    }

    public String toString() {
        return "{\"currentTime\":\"" + this.currentTime + "\", \"localIp\":\"" + this.localIp + "\"}";
    }

    public DnsCacheInfo(String str, String str2, ConcurrentHashMap<String, List<IDnsNetworkAddress>> concurrentHashMap) {
        this.currentTime = str;
        this.localIp = str2;
        this.info = concurrentHashMap;
    }
}
