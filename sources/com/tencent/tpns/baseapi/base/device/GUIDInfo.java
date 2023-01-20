package com.tencent.tpns.baseapi.base.device;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.Util;

/* loaded from: classes3.dex */
public class GUIDInfo {
    public int errCode;
    public String token = "";
    public String tokenList = "";
    public String mqttServer = "";
    public String mqttServerIP = "";
    public String userName = "";
    public String passWord = "";
    public long guid = 0;
    public long expiredSeconds = 0;
    public long refreshTime = 0;
    public long guidLastAccessid = 0;
    public int refuseRate = 0;
    public String mqttPortList = "";
    public int encrypt = 0;
    public long mqttServerRefreshTime = 0;
    public String result = "";

    public static GUIDInfo getGuidInfoFromShar(Context context) {
        GUIDInfo gUIDInfo = new GUIDInfo();
        try {
            gUIDInfo.guid = PushPreferences.getLong(context, "XG_GUID_GUID", 0L);
            gUIDInfo.expiredSeconds = PushPreferences.getLong(context, "XG_GUID_EXPIRED_SECONDS", 0L);
            gUIDInfo.refreshTime = PushPreferences.getLong(context, "XG_GUID_LAST_REFRESH_TIME", 0L);
            gUIDInfo.token = PushPreferences.getString(context, "XG_GUID_TOKEN", "");
            gUIDInfo.tokenList = PushPreferences.getString(context, "XG_GUID_TOKEN_LIST", "");
            gUIDInfo.mqttServer = PushPreferences.getString(context, "XG_GUID_MQTT_SERVER", "");
            gUIDInfo.userName = PushPreferences.getString(context, "XG_GUID_MQTT_USERNAME", "");
            gUIDInfo.passWord = PushPreferences.getString(context, "XG_GUID_MQTT_PASSWORD", "");
            gUIDInfo.guidLastAccessid = PushPreferences.getLong(context, "XG_GUID_LAST_ACCESSID", 0L);
            gUIDInfo.mqttServerRefreshTime = PushPreferences.getLong(context, "XG_GUID_MQTT_SERVER_LAST_REFRESH_TIME", 0L);
            gUIDInfo.refuseRate = PushPreferences.getInt(context, "XG_GUID_SERVER_ABANDON_RATE", 0);
            gUIDInfo.mqttPortList = PushPreferences.getString(context, "XG_GUID_MQTT_PORTLIST", "");
            gUIDInfo.encrypt = PushPreferences.getInt(context, "XG_GUID_SERVER_ENCRYPT_LEVEL", 0);
        } catch (Throwable unused) {
        }
        return gUIDInfo;
    }

    public boolean isError() {
        if (this.errCode != 0) {
            return true;
        }
        if (Util.isNullOrEmptyString(this.token) || Util.isNullOrEmptyString(this.mqttServer) || Util.isNullOrEmptyString(this.userName) || Util.isNullOrEmptyString(this.passWord)) {
            this.errCode = -5;
            this.result = "GUID check result is null";
            return true;
        }
        return false;
    }

    public void saveGuidToSha(Context context) {
        ContentValues contentValues = new ContentValues();
        if (!Util.isNullOrEmptyString(this.token)) {
            contentValues.put("XG_GUID_TOKEN", this.token);
        }
        if (!Util.isNullOrEmptyString(this.tokenList)) {
            contentValues.put("XG_GUID_TOKEN_LIST", this.tokenList);
        }
        if (!Util.isNullOrEmptyString(this.mqttServer)) {
            contentValues.put("XG_GUID_MQTT_SERVER", this.mqttServer);
        }
        if (!Util.isNullOrEmptyString(this.userName)) {
            contentValues.put("XG_GUID_MQTT_USERNAME", this.userName);
        }
        if (!Util.isNullOrEmptyString(this.passWord)) {
            contentValues.put("XG_GUID_MQTT_PASSWORD", this.passWord);
        }
        long j2 = this.guid;
        if (j2 >= 0) {
            contentValues.put("XG_GUID_GUID", Long.valueOf(j2));
        }
        long j3 = this.expiredSeconds;
        if (j3 >= 0) {
            contentValues.put("XG_GUID_EXPIRED_SECONDS", Long.valueOf(j3));
        }
        long j4 = this.refreshTime;
        if (j4 >= 0) {
            contentValues.put("XG_GUID_LAST_REFRESH_TIME", Long.valueOf(j4));
        }
        long j5 = this.guidLastAccessid;
        if (j5 >= 0) {
            contentValues.put("XG_GUID_LAST_ACCESSID", Long.valueOf(j5));
        }
        int i2 = this.refuseRate;
        if (i2 >= 0) {
            contentValues.put("XG_GUID_SERVER_ABANDON_RATE", Integer.valueOf(i2));
        }
        int i3 = this.encrypt;
        if (i3 >= 0) {
            contentValues.put("XG_GUID_SERVER_ENCRYPT_LEVEL", Integer.valueOf(i3));
        }
        if (!Util.isNullOrEmptyString(this.mqttPortList)) {
            contentValues.put("XG_GUID_MQTT_PORTLIST", this.mqttPortList);
        }
        PushPreferences.putContentValues(context, contentValues);
    }
}
