package com.xiaomi.push;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.qiniu.android.collect.ReportItem;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ce implements Comparable<ce> {
    public String a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    private final LinkedList<bt> f8324c;

    /* renamed from: d  reason: collision with root package name */
    private long f8325d;

    public ce() {
        this(null, 0);
    }

    public ce(String str) {
        this(str, 0);
    }

    public ce(String str, int i2) {
        this.f8324c = new LinkedList<>();
        this.f8325d = 0L;
        this.a = str;
        this.b = i2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ce ceVar) {
        if (ceVar == null) {
            return 1;
        }
        return ceVar.b - this.b;
    }

    public synchronized ce a(JSONObject jSONObject) {
        this.f8325d = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
        this.b = jSONObject.getInt("wt");
        this.a = jSONObject.getString(ReportItem.RequestKeyHost);
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            this.f8324c.add(new bt().a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.f8325d);
        jSONObject.put("wt", this.b);
        jSONObject.put(ReportItem.RequestKeyHost, this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator<bt> it = this.f8324c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().b());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public synchronized void a(bt btVar) {
        if (btVar != null) {
            this.f8324c.add(btVar);
            int a = btVar.a();
            if (a > 0) {
                this.b += btVar.a();
            } else {
                int i2 = 0;
                for (int size = this.f8324c.size() - 1; size >= 0 && this.f8324c.get(size).a() < 0; size--) {
                    i2++;
                }
                this.b += a * i2;
            }
            if (this.f8324c.size() > 30) {
                this.b -= this.f8324c.remove().a();
            }
        }
    }

    public String toString() {
        return this.a + Constants.COLON_SEPARATOR + this.b;
    }
}
