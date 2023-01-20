package com.xiaomi.push;

import android.text.TextUtils;
import com.qiniu.android.collect.ReportItem;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class bv {
    private String a;
    private final ArrayList<bu> b = new ArrayList<>();

    public bv() {
    }

    public bv(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.a = str;
    }

    public synchronized bu a() {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            bu buVar = this.b.get(size);
            if (buVar.a()) {
                by.a().g(buVar.e());
                return buVar;
            }
        }
        return null;
    }

    public synchronized bv a(JSONObject jSONObject) {
        this.a = jSONObject.getString(ReportItem.RequestKeyHost);
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            this.b.add(new bu(this.a).a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }

    public synchronized void a(bu buVar) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.b.size()) {
                break;
            } else if (this.b.get(i2).a(buVar)) {
                this.b.set(i2, buVar);
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= this.b.size()) {
            this.b.add(buVar);
        }
    }

    public synchronized void a(boolean z) {
        ArrayList<bu> arrayList;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            bu buVar = this.b.get(size);
            if (z) {
                if (buVar.c()) {
                    arrayList = this.b;
                    arrayList.remove(size);
                }
            } else if (!buVar.b()) {
                arrayList = this.b;
                arrayList.remove(size);
            }
        }
    }

    public ArrayList<bu> b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public synchronized JSONObject d() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(ReportItem.RequestKeyHost, this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator<bu> it = this.b.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().f());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("\n");
        Iterator<bu> it = this.b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
