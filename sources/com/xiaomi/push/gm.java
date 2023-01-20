package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class gm {
    private static HashMap<String, ArrayList<gu>> a(Context context, List<gu> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<gu>> hashMap = new HashMap<>();
        for (gu guVar : list) {
            a(context, guVar);
            ArrayList<gu> arrayList = hashMap.get(guVar.k());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                hashMap.put(guVar.k(), arrayList);
            }
            arrayList.add(guVar);
        }
        return hashMap;
    }

    private static void a(Context context, go goVar, HashMap<String, ArrayList<gu>> hashMap) {
        for (Map.Entry<String, ArrayList<gu>> entry : hashMap.entrySet()) {
            try {
                ArrayList<gu> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    goVar.a(value, value.get(0).q(), entry.getKey());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, go goVar, List<gu> list) {
        HashMap<String, ArrayList<gu>> a = a(context, list);
        if (a != null && a.size() != 0) {
            a(context, goVar, a);
            return;
        }
        com.xiaomi.a.a.a.c.a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
    }

    private static void a(Context context, gu guVar) {
        if (guVar.f8709f) {
            guVar.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(guVar.m())) {
            guVar.f(com.xiaomi.push.service.bc.a());
        }
        guVar.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(guVar.q())) {
            guVar.e(context.getPackageName());
        }
        if (TextUtils.isEmpty(guVar.k())) {
            guVar.e(guVar.q());
        }
    }
}
