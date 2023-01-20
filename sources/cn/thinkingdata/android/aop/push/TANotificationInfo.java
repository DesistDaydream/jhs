package cn.thinkingdata.android.aop.push;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TANotificationInfo {
    public String content;
    public long time;
    public String title;

    public TANotificationInfo(String str, String str2, long j2) {
        this.title = str;
        this.content = str2;
        this.time = j2;
    }

    public static TANotificationInfo fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new TANotificationInfo(jSONObject.optString("title"), jSONObject.optString("content"), jSONObject.optLong("time"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public String getContent() {
        return this.content;
    }

    public long getTime() {
        return this.time;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setTime(long j2) {
        this.time = j2;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("title", this.title);
            jSONObject.put("content", this.content);
            jSONObject.put("time", this.time);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }
}
