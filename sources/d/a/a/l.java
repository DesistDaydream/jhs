package d.a.a;

import java.util.Date;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class l {
    private final String mEventName;
    private Date mEventTime;
    private final JSONObject mProperties;
    private TimeZone mTimeZone;

    public l(String str, JSONObject jSONObject) {
        this.mEventName = str;
        this.mProperties = jSONObject;
    }

    public abstract cn.thinkingdata.android.utils.l getDataType();

    public String getEventName() {
        return this.mEventName;
    }

    public Date getEventTime() {
        return this.mEventTime;
    }

    public abstract String getExtraField();

    public abstract String getExtraValue();

    public JSONObject getProperties() {
        return this.mProperties;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public void setEventTime(Date date) {
        this.mEventTime = date;
    }

    public void setEventTime(Date date, TimeZone timeZone) {
        this.mEventTime = date;
        this.mTimeZone = timeZone;
    }
}
