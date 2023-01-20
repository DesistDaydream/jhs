package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.common.i;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class f extends Event {
    public long a;
    public long b;

    /* renamed from: l  reason: collision with root package name */
    public double f6466l;

    /* renamed from: m  reason: collision with root package name */
    public String f6467m;
    public String n;

    public f(Context context, String str, String str2, int i2, double d2, long j2) {
        super(context, i2, j2);
        this.a = 0L;
        this.b = 0L;
        this.f6466l = 0.0d;
        this.n = str;
        this.f6467m = str2;
        this.f6466l = d2;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public EventType getType() {
        return EventType.PAGE_VIEW;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public boolean onEncode(JSONObject jSONObject) {
        i.a(jSONObject, "pi", this.f6467m);
        i.a(jSONObject, "rf", this.n);
        double d2 = this.f6466l;
        if (d2 > 0.0d) {
            jSONObject.put(com.umeng.analytics.pro.d.W, d2);
        }
        long j2 = this.a;
        if (j2 > 0) {
            i.a(jSONObject, "msgId", j2);
        }
        long j3 = this.b;
        if (j3 > 0) {
            i.a(jSONObject, "busiMsgId", j3);
            return true;
        }
        return true;
    }
}
