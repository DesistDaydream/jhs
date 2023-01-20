package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.am;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class m2 extends e2 {

    /* renamed from: e  reason: collision with root package name */
    private final Context f152e;

    public m2(Context context) {
        super(true, true);
        this.f152e = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    public boolean a(JSONObject jSONObject) {
        k2.a(jSONObject, am.N, this.f152e.getResources().getConfiguration().locale.getLanguage());
        int rawOffset = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            rawOffset = 12;
        }
        jSONObject.put(am.M, rawOffset);
        k2.a(jSONObject, "region", Locale.getDefault().getCountry());
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        k2.a(jSONObject, "tz_name", timeZone.getID());
        jSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis() / 1000));
        return true;
    }
}
