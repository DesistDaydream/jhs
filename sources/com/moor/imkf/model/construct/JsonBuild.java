package com.moor.imkf.model.construct;

import com.moor.imkf.model.entity.CardInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class JsonBuild {
    public static String getCardInfo(CardInfo cardInfo) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", cardInfo.icon);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("text", cardInfo.title);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("text", cardInfo.name);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("text", cardInfo.concent);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("left", jSONObject);
            jSONObject5.put("right1", jSONObject2);
            jSONObject5.put("right2", jSONObject3);
            jSONObject5.put("right3", jSONObject4);
            jSONObject5.put("url", cardInfo.url);
            return jSONObject5.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
