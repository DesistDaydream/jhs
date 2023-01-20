package cn.thinkingdata.android;

import android.text.TextUtils;
import cn.thinkingdata.android.utils.TDLog;
import d.a.a.l;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TDFirstEvent extends l {
    private static final String TAG = "ThinkingAnalytics.TDUniqueEvent";
    private String mExtraValue;

    public TDFirstEvent(String str, JSONObject jSONObject) {
        super(str, jSONObject);
    }

    @Override // d.a.a.l
    public cn.thinkingdata.android.utils.l getDataType() {
        return cn.thinkingdata.android.utils.l.TRACK;
    }

    @Override // d.a.a.l
    public String getExtraField() {
        return "#first_check_id";
    }

    @Override // d.a.a.l
    public String getExtraValue() {
        return this.mExtraValue;
    }

    public void setFirstCheckId(String str) {
        if (TextUtils.isEmpty(str)) {
            TDLog.w(TAG, "Invalid firstCheckId. Use device Id");
        } else {
            this.mExtraValue = str;
        }
    }
}
