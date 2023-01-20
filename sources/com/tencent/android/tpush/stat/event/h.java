package com.tencent.android.tpush.stat.event;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class h extends Event {
    private com.tencent.android.tpush.stat.b.a a;
    private JSONObject b;

    public h(Context context, int i2, JSONObject jSONObject, long j2) {
        super(context, i2, j2);
        this.b = null;
        this.a = new com.tencent.android.tpush.stat.b.a(context, j2);
        this.b = jSONObject;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public EventType getType() {
        return EventType.SESSION_ENV;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public boolean onEncode(JSONObject jSONObject) {
        jSONObject.put("ut", 1);
        JSONObject jSONObject2 = this.b;
        if (jSONObject2 != null) {
            jSONObject.put("cfg", jSONObject2);
        }
        if (com.tencent.android.tpush.stat.b.b.e(this.f6458k)) {
            jSONObject.put("ncts", 1);
        }
        this.a.a(jSONObject, (Thread) null);
        return true;
    }
}
