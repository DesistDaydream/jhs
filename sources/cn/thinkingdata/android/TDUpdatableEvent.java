package cn.thinkingdata.android;

import d.a.a.l;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TDUpdatableEvent extends l {
    private final String mEventId;

    public TDUpdatableEvent(String str, JSONObject jSONObject, String str2) {
        super(str, jSONObject);
        this.mEventId = str2;
    }

    @Override // d.a.a.l
    public cn.thinkingdata.android.utils.l getDataType() {
        return cn.thinkingdata.android.utils.l.TRACK_UPDATE;
    }

    @Override // d.a.a.l
    public String getExtraField() {
        return "#event_id";
    }

    @Override // d.a.a.l
    public String getExtraValue() {
        return this.mEventId;
    }
}
