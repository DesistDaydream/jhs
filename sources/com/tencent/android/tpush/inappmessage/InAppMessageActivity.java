package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class InAppMessageActivity extends Activity {
    private Context a;
    private Handler b;

    /* renamed from: c  reason: collision with root package name */
    private c f6106c;

    /* renamed from: d  reason: collision with root package name */
    private Intent f6107d;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.a = this;
            this.b = new Handler();
            Intent intent = getIntent();
            this.f6107d = intent;
            if (a(intent)) {
                String stringExtra = this.f6107d.getStringExtra("inAppMsg");
                this.f6107d.putExtra("pushChannel", 100);
                a(stringExtra);
            } else {
                finish();
            }
        } catch (Throwable th) {
            TLogger.e("InAppMessageActivity", "InAppMsg start InAppMessageActivity :" + th.toString());
            try {
                finish();
            } catch (Throwable th2) {
                TLogger.e("InAppMessageActivity", "InAppMsg finish InAppMessageActivity :" + th2.toString());
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        c cVar = this.f6106c;
        if (cVar != null) {
            cVar.dismiss();
        }
        super.onDestroy();
    }

    private boolean a(Intent intent) {
        if (intent != null && intent.hasExtra(MessageKey.MSG_INAPP_PORTECT_TAG)) {
            String stringExtra = intent.getStringExtra(MessageKey.MSG_INAPP_PORTECT_TAG);
            if (!com.tencent.android.tpush.common.i.b(stringExtra)) {
                try {
                    Long valueOf = Long.valueOf(Rijndael.decrypt(stringExtra));
                    if (valueOf.longValue() > 0) {
                        return System.currentTimeMillis() >= valueOf.longValue();
                    }
                } catch (NumberFormatException e2) {
                    TLogger.e("InAppMessageActivity", "InAppMsg checkIntent :" + e2.toString());
                }
            }
        }
        return false;
    }

    private void a(final String str) {
        TLogger.i("InAppMessageActivity", "InAppMsg parseData :" + str);
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.inappmessage.InAppMessageActivity.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r10v18, types: [java.lang.Object, java.lang.Integer] */
            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                JSONObject jSONObject;
                String str7;
                String str8;
                int length;
                String str9;
                String str10;
                String str11;
                JSONObject jSONObject2;
                int optInt;
                int optInt2;
                Boolean bool = Boolean.TRUE;
                Boolean bool2 = Boolean.FALSE;
                try {
                    final HashMap hashMap = new HashMap();
                    JSONObject optJSONObject = new JSONObject(str).optJSONObject("dispContent");
                    if (optJSONObject == null) {
                        return;
                    }
                    hashMap.put("Message.template.type", Integer.valueOf(optJSONObject.optInt("templateType", 1)));
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("titleLabel");
                    try {
                        if (optJSONObject2 != null) {
                            String optString = optJSONObject2.optString("text", "");
                            String optString2 = optJSONObject2.optString("color", "");
                            str3 = "color";
                            int optInt3 = optJSONObject2.optInt("size", 20);
                            String optString3 = optJSONObject2.optString("font", "");
                            str2 = "font";
                            int optInt4 = optJSONObject2.optInt("style", 0);
                            int optInt5 = optJSONObject2.optInt("alignment", 17);
                            int optInt6 = optJSONObject2.optInt("location", 0);
                            hashMap.put("Title.Text", optString);
                            hashMap.put("Title.Color", optString2);
                            hashMap.put("Title.Size", Integer.valueOf(optInt3));
                            hashMap.put("Title.Align", Integer.valueOf(optInt5));
                            hashMap.put("Title.Paint", optString3);
                            ?? valueOf = Integer.valueOf(optInt4);
                            hashMap.put("Title.Typeface", valueOf);
                            hashMap.put(Integer.valueOf(optInt6), "Title.Location");
                            hashMap.put("Title Is Have", bool);
                            str4 = valueOf;
                        } else {
                            str2 = "font";
                            str3 = "color";
                            hashMap.put("Title Is Have", bool2);
                            str4 = "font";
                        }
                        JSONObject optJSONObject3 = optJSONObject.optJSONObject("contentLabel");
                        if (optJSONObject3 != null) {
                            String optString4 = optJSONObject3.optString("text", "");
                            String optString5 = optJSONObject3.optString(str3, "");
                            int optInt7 = optJSONObject3.optInt("size", 20);
                            String optString6 = optJSONObject3.optString(str2, "");
                            int optInt8 = optJSONObject3.optInt("style", 0);
                            int optInt9 = optJSONObject3.optInt("alignment", 17);
                            int optInt10 = optJSONObject3.optInt("location", 0);
                            hashMap.put("Message.Size", Integer.valueOf(optInt7));
                            hashMap.put("Message.Align", Integer.valueOf(optInt9));
                            hashMap.put("Message.Paint", optString6);
                            hashMap.put("Message.Typeface", Integer.valueOf(optInt8));
                            hashMap.put("Message.Text", optString4);
                            hashMap.put("Message.Color", optString5);
                            hashMap.put(Integer.valueOf(optInt10), "Message.Location");
                            hashMap.put("Message Is Have", bool);
                            str5 = optString4;
                        } else {
                            hashMap.put("Message Is Have", bool2);
                            str5 = str4;
                        }
                        JSONObject optJSONObject4 = optJSONObject.optJSONObject("mediaView");
                        try {
                            if (optJSONObject4 != null) {
                                String optString7 = optJSONObject4.optString("url", "");
                                str5 = this;
                                int optInt11 = optJSONObject4.optInt("width", SizeUtil.dipTopx(InAppMessageActivity.this.a, 255.0f));
                                int optInt12 = optJSONObject4.optInt("height", SizeUtil.dipTopx(InAppMessageActivity.this.a, 215.0f));
                                int optInt13 = optJSONObject4.optInt("location", 0);
                                hashMap.put("Media url", optString7);
                                hashMap.put("Media width", Integer.valueOf(optInt11));
                                hashMap.put("Media heigh", Integer.valueOf(optInt12));
                                hashMap.put(Integer.valueOf(optInt13), "Media.Location");
                                hashMap.put("Media Is Have", bool);
                            } else {
                                str5 = this;
                                hashMap.put("Media Is Have", bool2);
                            }
                            hashMap.put("Close button", Integer.valueOf(optJSONObject.optInt("showCloseBtn", 1)));
                            JSONArray optJSONArray = optJSONObject.optJSONArray("customBtns");
                            if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
                                str6 = "corner";
                                jSONObject = optJSONObject;
                                str7 = "url";
                                str8 = "action";
                            } else {
                                JSONObject jSONObject3 = optJSONArray.getJSONObject(0);
                                if (jSONObject3 == null || (optInt2 = jSONObject3.optInt("buttonId", 0)) == 0) {
                                    str9 = "corner";
                                    jSONObject = optJSONObject;
                                    str7 = "url";
                                    str10 = "text";
                                    str11 = "action";
                                } else {
                                    String optString8 = jSONObject3.optString("bgColor", "");
                                    String optString9 = jSONObject3.optString("text", "");
                                    str7 = "url";
                                    String optString10 = jSONObject3.optString("textColor", "");
                                    jSONObject = optJSONObject;
                                    str10 = "text";
                                    int optInt14 = jSONObject3.optInt("textSize", 20);
                                    int optInt15 = jSONObject3.optInt("corner", 0);
                                    int optInt16 = jSONObject3.optInt("location", 0);
                                    String optString11 = jSONObject3.optString("action", "");
                                    str11 = "action";
                                    str9 = "corner";
                                    int optInt17 = jSONObject3.optInt("actionType", 0);
                                    hashMap.put("Accept button.Text", optString9);
                                    hashMap.put("Accept button.Background color", optString8);
                                    hashMap.put("Accept button.Text color", optString10);
                                    hashMap.put("Accept button.Text size", Integer.valueOf(optInt14));
                                    hashMap.put("Accept button.corner", Integer.valueOf(optInt15));
                                    hashMap.put("Accept button.id", Integer.valueOf(optInt2));
                                    hashMap.put("Accept button.action", optString11);
                                    hashMap.put(Integer.valueOf(optInt16), "Button.Location");
                                    hashMap.put("Accept button.count", Integer.valueOf(length));
                                    hashMap.put("Accept button.action.type", Integer.valueOf(optInt17));
                                }
                                if (length != 2 || (jSONObject2 = optJSONArray.getJSONObject(1)) == null || (optInt = jSONObject2.optInt("buttonId", 0)) == 0) {
                                    str8 = str11;
                                    str6 = str9;
                                } else {
                                    String optString12 = jSONObject2.optString("bgColor", "");
                                    String optString13 = jSONObject2.optString(str10, "");
                                    String optString14 = jSONObject2.optString("textColor", "");
                                    int optInt18 = jSONObject2.optInt("textSize", 20);
                                    str6 = str9;
                                    int optInt19 = jSONObject2.optInt(str6, 0);
                                    str8 = str11;
                                    String optString15 = jSONObject2.optString(str8, "");
                                    int optInt20 = jSONObject3.optInt("actionType", 0);
                                    hashMap.put("Accept sec button.Text", optString13);
                                    hashMap.put("Accept sec button.Background color", optString12);
                                    hashMap.put("Accept sec button.Text color", optString14);
                                    hashMap.put("Accept sec button.Text size", Integer.valueOf(optInt18));
                                    hashMap.put("Accept sec button.corner", Integer.valueOf(optInt19));
                                    hashMap.put("Accept sec button.id", Integer.valueOf(optInt));
                                    hashMap.put("Accept sec button.action", optString15);
                                    hashMap.put("Accept sec button.action.type", Integer.valueOf(optInt20));
                                }
                            }
                            JSONObject optJSONObject5 = jSONObject.optJSONObject("bgCard");
                            if (optJSONObject5 != null) {
                                String optString16 = optJSONObject5.optString(str7, "");
                                String optString17 = optJSONObject5.optString(str8, "");
                                int optInt21 = optJSONObject5.optInt(str6, 0);
                                hashMap.put("Background color", optJSONObject5.optString("bgColor", ""));
                                hashMap.put("Background image url", optString16);
                                hashMap.put("Background action", optString17);
                                hashMap.put("Background corner", Integer.valueOf(optInt21));
                            }
                            hashMap.put("Layout.Width", 303);
                            hashMap.put("Layout.Height", 600);
                            InAppMessageActivity.this.b.post(new Runnable() { // from class: com.tencent.android.tpush.inappmessage.InAppMessageActivity.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        d dVar = new d(new com.tencent.android.tpush.inappmessage.a.a("center_popup", hashMap, "message_id"));
                                        InAppMessageActivity.this.f6106c = new c((InAppMessageActivity) InAppMessageActivity.this.a, dVar, InAppMessageActivity.this.f6107d);
                                        InAppMessageActivity.this.f6106c.show();
                                        ServiceStat.appReportSDKReceived(com.tencent.android.tpush.service.b.e(), InAppMessageActivity.this.f6107d);
                                    } catch (Throwable th) {
                                        TLogger.e("InAppMessageActivity", "init CenterPopup :" + th.toString());
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            th = th;
                            TLogger.e("InAppMessageActivity", "unexpected for InAppMsg:" + th.toString());
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        });
    }
}
