package com.xiaomi.push.service;

import com.xiaomi.push.hd;
import java.util.Map;

/* loaded from: classes3.dex */
public class au {
    public static hd a(hd hdVar) {
        Map<String, String> map;
        if (hdVar != null && (map = hdVar.f8785k) != null) {
            map.remove("score_info");
        }
        return hdVar;
    }
}
