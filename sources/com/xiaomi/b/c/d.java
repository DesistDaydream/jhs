package com.xiaomi.b.c;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.xiaomi.push.av;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class d implements b {
    public Context a;
    private HashMap<String, HashMap<String, com.xiaomi.b.a.d>> b;

    public d(Context context) {
        this.a = context;
    }

    public static String a(com.xiaomi.b.a.d dVar) {
        return String.valueOf(dVar.f8207e) + MqttTopic.MULTI_LEVEL_WILDCARD + dVar.f8208f;
    }

    private String c(com.xiaomi.b.a.d dVar) {
        String str;
        int i2 = dVar.f8207e;
        String str2 = dVar.f8208f;
        if (i2 <= 0 || TextUtils.isEmpty(str2)) {
            str = "";
        } else {
            str = String.valueOf(i2) + MqttTopic.MULTI_LEVEL_WILDCARD + str2;
        }
        File externalFilesDir = this.a.getExternalFilesDir("perf");
        if (externalFilesDir == null) {
            com.xiaomi.a.a.a.c.d("cannot get folder when to write perf");
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return new File(externalFilesDir, str).getAbsolutePath();
    }

    private String d(com.xiaomi.b.a.d dVar) {
        String c2 = c(dVar);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        for (int i2 = 0; i2 < 20; i2++) {
            String str = c2 + i2;
            if (av.b(this.a, str)) {
                return str;
            }
        }
        return null;
    }

    @Override // com.xiaomi.b.c.e
    public void a() {
        av.a(this.a, "perf", "perfUploading");
        File[] c2 = av.c(this.a, "perfUploading");
        if (c2 == null || c2.length <= 0) {
            return;
        }
        for (File file : c2) {
            if (file != null) {
                List<String> a = g.a(this.a, file.getAbsolutePath());
                file.delete();
                a(a);
            }
        }
    }

    @Override // com.xiaomi.b.c.b
    public void a(HashMap<String, HashMap<String, com.xiaomi.b.a.d>> hashMap) {
        this.b = hashMap;
    }

    public void a(List<String> list) {
        av.a(this.a, list);
    }

    public void a(com.xiaomi.b.a.d[] dVarArr) {
        String d2 = d(dVarArr[0]);
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        g.a(d2, dVarArr);
    }

    @Override // com.xiaomi.b.c.f
    public void b() {
        HashMap<String, HashMap<String, com.xiaomi.b.a.d>> hashMap = this.b;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            for (String str : this.b.keySet()) {
                HashMap<String, com.xiaomi.b.a.d> hashMap2 = this.b.get(str);
                if (hashMap2 != null && hashMap2.size() > 0) {
                    com.xiaomi.b.a.d[] dVarArr = new com.xiaomi.b.a.d[hashMap2.size()];
                    hashMap2.values().toArray(dVarArr);
                    a(dVarArr);
                }
            }
        }
        this.b.clear();
    }

    @Override // com.xiaomi.b.c.f
    public void b(com.xiaomi.b.a.d dVar) {
        if ((dVar instanceof com.xiaomi.b.a.c) && this.b != null) {
            com.xiaomi.b.a.c cVar = (com.xiaomi.b.a.c) dVar;
            String a = a(cVar);
            String a2 = g.a(cVar);
            HashMap<String, com.xiaomi.b.a.d> hashMap = this.b.get(a);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            com.xiaomi.b.a.c cVar2 = (com.xiaomi.b.a.c) hashMap.get(a2);
            if (cVar2 != null) {
                cVar.b += cVar2.b;
                cVar.f8204c += cVar2.f8204c;
            }
            hashMap.put(a2, cVar);
            this.b.put(a, hashMap);
        }
    }
}
