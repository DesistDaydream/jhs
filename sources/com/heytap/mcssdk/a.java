package com.heytap.mcssdk;

import android.content.Context;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface a {
    @Deprecated
    void clearNotificationType();

    @Deprecated
    void clearNotificationType(JSONObject jSONObject);

    void clearNotifications();

    void clearNotifications(JSONObject jSONObject);

    void disableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService);

    void enableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService);

    void getAppNotificationSwitch(IGetAppNotificationCallBackService iGetAppNotificationCallBackService);

    void getNotificationStatus();

    void getNotificationStatus(JSONObject jSONObject);

    void getRegister();

    void getRegister(JSONObject jSONObject);

    String getRegisterID();

    void openNotificationSettings();

    void openNotificationSettings(JSONObject jSONObject);

    void pausePush();

    void pausePush(JSONObject jSONObject);

    void register(Context context, String str, String str2, ICallBackResultService iCallBackResultService);

    void register(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService);

    void requestNotificationPermission();

    void resumePush();

    void resumePush(JSONObject jSONObject);

    @Deprecated
    void setNotificationType(int i2);

    @Deprecated
    void setNotificationType(int i2, JSONObject jSONObject);

    void setPushTime(List<Integer> list, int i2, int i3, int i4, int i5);

    void setPushTime(List<Integer> list, int i2, int i3, int i4, int i5, JSONObject jSONObject);

    void setRegisterID(String str);

    void unRegister();

    void unRegister(JSONObject jSONObject);
}
