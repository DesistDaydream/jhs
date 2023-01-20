package com.tencent.android.tpush.common;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.HttpHelper;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e2) {
            Logger.e("AccountHttpHelper", "getHostName Exception :", e2);
            return "";
        }
    }

    public static void a(Context context, String str, long j2, int i2, final XGIOperateCallback xGIOperateCallback) {
        try {
            if (CloudManager.getInstance(context).shouldRefuse()) {
                Logger.i("AccountHttpHelper", "sendAccountByhttp refused by cloud");
                if (xGIOperateCallback != null) {
                    ReturnCode returnCode = ReturnCode.CODE_SERVICE_DISABLED;
                    xGIOperateCallback.onFail("", returnCode.getType(), ReturnCode.errCodeToMsg(returnCode.getType()));
                    return;
                }
                return;
            }
            JSONObject a = a(context, str, j2, i2);
            if (a == null) {
                if (xGIOperateCallback != null) {
                    ReturnCode returnCode2 = ReturnCode.CODE_NETWORK_INNER_EXCEPTION_OCCUR;
                    xGIOperateCallback.onFail("", returnCode2.getType(), ReturnCode.errCodeToMsg(returnCode2.getType()));
                    return;
                }
                return;
            }
            String jSONObject = a.toString();
            String batchOpertorServerAddr = XGApiConfig.getBatchOpertorServerAddr(context);
            String a2 = a(batchOpertorServerAddr);
            Logger.d("AccountHttpHelper", "accountReqStr:" + jSONObject + ", url:" + batchOpertorServerAddr);
            HttpHelper.sendHttpRequest(context, GuidInfoManager.getServerIPAddress(context, batchOpertorServerAddr), a2, jSONObject, new HttpRequestCallback() { // from class: com.tencent.android.tpush.common.a.1
                @Override // com.tencent.tpns.baseapi.core.net.HttpRequestCallback
                public void onFailure(int i3, String str2) {
                    XGIOperateCallback xGIOperateCallback2 = XGIOperateCallback.this;
                    if (xGIOperateCallback2 != null) {
                        xGIOperateCallback2.onFail("", i3, str2);
                    }
                }

                @Override // com.tencent.tpns.baseapi.core.net.HttpRequestCallback
                public void onSuccess(String str2) {
                    XGIOperateCallback xGIOperateCallback2;
                    try {
                        if (!i.b(str2) && new JSONObject(str2).getInt("ret_code") == 0 && (xGIOperateCallback2 = XGIOperateCallback.this) != null) {
                            xGIOperateCallback2.onSuccess("", 0);
                            return;
                        }
                    } catch (Throwable unused) {
                    }
                    XGIOperateCallback xGIOperateCallback3 = XGIOperateCallback.this;
                    if (xGIOperateCallback3 != null) {
                        ReturnCode returnCode3 = ReturnCode.CODE_NETWORK_INNER_EXCEPTION_OCCUR;
                        xGIOperateCallback3.onFail("", returnCode3.getType(), ReturnCode.errCodeToMsg(returnCode3.getType()));
                    }
                }
            }, true);
        } catch (Throwable th) {
            Logger.w("AccountHttpHelper", "unexpected for sendAccountByhttp, exception:", th);
            if (xGIOperateCallback != null) {
                ReturnCode returnCode3 = ReturnCode.CODE_NETWORK_INNER_EXCEPTION_OCCUR;
                xGIOperateCallback.onFail("", returnCode3.getType(), ReturnCode.errCodeToMsg(returnCode3.getType()));
            }
        }
    }

    private static JSONObject a(Context context, String str, long j2, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("accessId", j2);
            jSONObject.put(com.heytap.mcssdk.constant.b.C, "1.3.5.0");
            jSONObject.put("from", 1);
            if (i2 == 6 || i2 == 2) {
                jSONObject.put("operator_type", 1);
            } else if (i2 == 1) {
                jSONObject.put("operator_type", 4);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(GuidInfoManager.getToken(context));
                jSONObject.put("token_list", jSONArray);
                return jSONObject;
            } else if (i2 == 0) {
                jSONObject.put("operator_type", 2);
            } else {
                if (i2 != 3 && i2 != 7) {
                    Logger.w("AccountHttpHelper", "unsupport account operate type：" + i2);
                    return null;
                }
                jSONObject.put("operator_type", 3);
            }
            JSONObject jSONObject2 = new JSONObject();
            if (!i.b(str)) {
                jSONObject2.put("account_list", new JSONArray(str));
            }
            jSONObject2.put("token", GuidInfoManager.getToken(context));
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            jSONObject.put("token_accounts", jSONArray2);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
