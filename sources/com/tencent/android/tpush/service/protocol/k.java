package com.tencent.android.tpush.service.protocol;

import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class k extends e {
    public long a = 0;
    public ArrayList<j> b = new ArrayList<>();

    public void a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        j jVar = new j();
        jVar.a(jSONObject);
        this.b.add(jVar);
        this.a = jVar.f6322h * 1000000;
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.PUSH_MESSAGE;
    }
}
