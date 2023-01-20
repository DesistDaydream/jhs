package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class AdvanceSettingEx implements Parcelable {
    public static final String ADVANCE_SETTING_EX = "as";
    public static final Parcelable.Creator<AdvanceSettingEx> CREATOR = new Parcelable.Creator<AdvanceSettingEx>() { // from class: com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdvanceSettingEx createFromParcel(Parcel parcel) {
            return new AdvanceSettingEx(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdvanceSettingEx[] newArray(int i2) {
            return new AdvanceSettingEx[i2];
        }
    };
    public static final int MZ_PUSH_PRIORITY_DEFAULT = 0;
    public static final int MZ_PUSH_PRIORITY_HIGH = 1;
    public static final int MZ_PUSH_PRIORITY_LOW = -1;
    public static final int MZ_PUSH_PRIORITY_MAX = 2;
    public static final int MZ_PUSH_PRIORITY_MIN = -2;
    public static final String PRIORITY_DISPLAY = "pd";
    public static final String SOUND_TITLE = "st";
    public static final String TAG = "AdvanceSettingEx";
    private int priorityDisplay;
    private String soundTitle;

    public AdvanceSettingEx() {
        this.priorityDisplay = 0;
    }

    public AdvanceSettingEx(Parcel parcel) {
        this.priorityDisplay = 0;
        this.priorityDisplay = parcel.readInt();
        this.soundTitle = parcel.readString();
    }

    public static AdvanceSettingEx parse(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                e.p.a.a.a.f(TAG, "parse json string error " + e2.getMessage());
            }
            return parse(jSONObject);
        }
        jSONObject = null;
        return parse(jSONObject);
    }

    public static AdvanceSettingEx parse(JSONObject jSONObject) {
        String str;
        AdvanceSettingEx advanceSettingEx = new AdvanceSettingEx();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(PRIORITY_DISPLAY)) {
                    advanceSettingEx.setPriorityDisplay(jSONObject.getInt(PRIORITY_DISPLAY));
                }
                if (!jSONObject.isNull("st")) {
                    advanceSettingEx.setSoundTitle(jSONObject.getString("st"));
                }
            } catch (JSONException e2) {
                str = "parse json obj error " + e2.getMessage();
            }
            return advanceSettingEx;
        }
        str = "no such tag AdvanceSettingEx";
        e.p.a.a.a.f(TAG, str);
        return advanceSettingEx;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPriorityDisplay() {
        return this.priorityDisplay;
    }

    public String getSoundTitle() {
        return this.soundTitle;
    }

    public void setPriorityDisplay(int i2) {
        this.priorityDisplay = (i2 < -2 || i2 > 2) ? 0 : 0;
    }

    public void setSoundTitle(String str) {
        this.soundTitle = str;
    }

    public String toString() {
        return "AdvanceSettingEx{, priorityDisplay=" + this.priorityDisplay + ", soundTitle=" + this.soundTitle + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.priorityDisplay);
        parcel.writeString(this.soundTitle);
    }
}
