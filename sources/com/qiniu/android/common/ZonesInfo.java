package com.qiniu.android.common;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ZonesInfo implements Cloneable {
    private boolean isTemporary;
    public final ArrayList<ZoneInfo> zonesInfo;

    public ZonesInfo(ArrayList<ZoneInfo> arrayList) {
        this(arrayList, false);
    }

    public static ZonesInfo createZonesInfo(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("hosts");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    ZoneInfo buildFromJson = ZoneInfo.buildFromJson(jSONArray.getJSONObject(i2));
                    if (buildFromJson != null && buildFromJson.isValid()) {
                        arrayList.add(buildFromJson);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return new ZonesInfo(arrayList);
    }

    public Object clone() throws CloneNotSupportedException {
        ArrayList arrayList = new ArrayList();
        ArrayList<ZoneInfo> arrayList2 = this.zonesInfo;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<ZoneInfo> it = this.zonesInfo.iterator();
            while (it.hasNext()) {
                arrayList.add((ZoneInfo) it.next().clone());
            }
        }
        ZonesInfo zonesInfo = new ZonesInfo(arrayList);
        zonesInfo.isTemporary = this.isTemporary;
        return zonesInfo;
    }

    public boolean isTemporary() {
        return this.isTemporary;
    }

    public boolean isValid() {
        ArrayList<ZoneInfo> arrayList = this.zonesInfo;
        return arrayList != null && arrayList.size() > 0 && this.zonesInfo.get(0).isValid();
    }

    public void toTemporary() {
        this.isTemporary = true;
    }

    public ZonesInfo(ArrayList<ZoneInfo> arrayList, boolean z) {
        this.zonesInfo = arrayList;
        this.isTemporary = z;
    }
}
