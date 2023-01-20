package com.tencent.android.tpush.stat.event;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a extends f {
    private static int o;

    public a(Context context, int i2, double d2, long j2) {
        super(context, null, null, i2, d2, j2);
        if (o == 0) {
            int a = com.tencent.android.tpush.stat.b.d.a(context, "back_ev_index", 0);
            o = a;
            if (a > 2147383647) {
                o = 0;
            }
        }
        int i3 = o + 1;
        o = i3;
        com.tencent.android.tpush.stat.b.d.b(context, "back_ev_index", i3);
    }

    @Override // com.tencent.android.tpush.stat.event.f, com.tencent.android.tpush.stat.event.Event
    public EventType getType() {
        return EventType.BACKGROUND;
    }

    @Override // com.tencent.android.tpush.stat.event.f, com.tencent.android.tpush.stat.event.Event
    public boolean onEncode(JSONObject jSONObject) {
        jSONObject.put("bc", o);
        jSONObject.put("ft", 1);
        return super.onEncode(jSONObject);
    }
}
