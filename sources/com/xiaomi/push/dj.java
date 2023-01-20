package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class dj implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Context b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f8451c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f8452d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ di f8453e;

    public dj(di diVar, String str, Context context, String str2, String str3) {
        this.f8453e = diVar;
        this.a = str;
        this.b = context;
        this.f8451c = str2;
        this.f8452d = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        String str;
        String str2;
        Context context2;
        String str3;
        String str4;
        di diVar;
        Context context3;
        di diVar2;
        dk dkVar;
        Context context4;
        if (TextUtils.isEmpty(this.a)) {
            context = this.b;
            str = "null";
            str2 = "A receive a incorrect message with empty info";
        } else {
            try {
                dd.a(this.b, this.a, 1001, "get message");
                JSONObject jSONObject = new JSONObject(this.a);
                String optString = jSONObject.optString("action");
                String optString2 = jSONObject.optString("awakened_app_packagename");
                String optString3 = jSONObject.optString("awake_app_packagename");
                String optString4 = jSONObject.optString("awake_app");
                String optString5 = jSONObject.optString("awake_type");
                int optInt = jSONObject.optInt("awake_foreground", 0);
                if (this.f8451c.equals(optString3) && this.f8452d.equals(optString4)) {
                    if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString2)) {
                        this.f8453e.b(optString3);
                        this.f8453e.a(optString4);
                        dh dhVar = new dh();
                        dhVar.b(optString);
                        dhVar.a(optString2);
                        dhVar.a(optInt);
                        dhVar.d(this.a);
                        if ("service".equals(optString5)) {
                            if (TextUtils.isEmpty(optString)) {
                                dhVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                                diVar2 = this.f8453e;
                                dkVar = dk.SERVICE_COMPONENT;
                                context4 = this.b;
                            } else {
                                diVar2 = this.f8453e;
                                dkVar = dk.SERVICE_ACTION;
                                context4 = this.b;
                            }
                            diVar2.a(dkVar, context4, dhVar);
                            return;
                        }
                        dk dkVar2 = dk.ACTIVITY;
                        if (dkVar2.f8457e.equals(optString5)) {
                            diVar = this.f8453e;
                            context3 = this.b;
                        } else {
                            dkVar2 = dk.PROVIDER;
                            if (dkVar2.f8457e.equals(optString5)) {
                                diVar = this.f8453e;
                                context3 = this.b;
                            } else {
                                context2 = this.b;
                                str3 = this.a;
                                str4 = "A receive a incorrect message with unknown type " + optString5;
                            }
                        }
                        diVar.a(dkVar2, context3, dhVar);
                        return;
                    }
                    context2 = this.b;
                    str3 = this.a;
                    str4 = "A receive a incorrect message with empty type";
                    dd.a(context2, str3, 1008, str4);
                    return;
                }
                dd.a(this.b, this.a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
                return;
            } catch (JSONException e2) {
                com.xiaomi.a.a.a.c.a(e2);
                context = this.b;
                str = this.a;
                str2 = "A meet a exception when receive the message";
            }
        }
        dd.a(context, str, 1008, str2);
    }
}
