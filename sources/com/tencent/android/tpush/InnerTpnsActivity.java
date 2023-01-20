package com.tencent.android.tpush;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Md5;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.ACTIVITYCHECK, EType.INTENTCHECK, EType.INTENTSCHEMECHECK})
/* loaded from: classes3.dex */
public class InnerTpnsActivity extends Activity {
    public static final String CHECK_CODE = "checkCode";
    public static final String CUSTOM_CONTENT = "customContent";
    public static final String JUMP_type = "jumpType";
    public static final String MSG_TYPE = "msgType";
    public static final String TARGE_ACTIVITY = "targetActivity";
    public static final String TIMESTAMP = "timestamp";
    public static Application.ActivityLifecycleCallbacks a = null;
    public static List<String> b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f5903c = "";

    /* renamed from: d  reason: collision with root package name */
    public static long f5904d;

    /* renamed from: e  reason: collision with root package name */
    public static long f5905e;

    /* renamed from: f  reason: collision with root package name */
    private String f5906f = "";

    /* renamed from: g  reason: collision with root package name */
    private int f5907g = 100;

    public static void addActivityNames(String str) {
        if (i.b(str)) {
            return;
        }
        if (b == null) {
            b = new ArrayList();
        }
        if (b.contains(str)) {
            return;
        }
        b.add(str);
    }

    private void c(Intent intent) {
        String md5;
        if (intent != null) {
            try {
                final Uri data = intent.getData();
                if (data != null) {
                    String uri = data.toString();
                    TLogger.ii("InnerTpnsActivity", "InnerTpnsActivity receiver otherChannelDeepLink url:" + uri);
                    String queryParameter = data.getQueryParameter("msgId");
                    String queryParameter2 = data.getQueryParameter("checkCode");
                    String queryParameter3 = data.getQueryParameter("pushChannel");
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        this.f5907g = Integer.parseInt(queryParameter3);
                    }
                    if (queryParameter != null && !TextUtils.isEmpty(queryParameter) && queryParameter2 != null && !TextUtils.isEmpty(queryParameter2) && (md5 = Md5.md5(queryParameter)) != null && queryParameter2.equals(md5)) {
                        String queryParameter4 = data.getQueryParameter("jumpType");
                        String queryParameter5 = data.getQueryParameter("targetActivity");
                        if (queryParameter4 != null && queryParameter5 != null && !TextUtils.isEmpty(queryParameter5)) {
                            if (queryParameter5 != null && queryParameter5.length() > 0) {
                                if (queryParameter4 != null && queryParameter4.equals("0")) {
                                    a();
                                } else if (queryParameter4 != null && queryParameter4.equals("1")) {
                                    a(queryParameter5);
                                } else if (queryParameter4 != null && queryParameter4.equals("2")) {
                                    b(queryParameter5);
                                } else if (queryParameter4 != null && queryParameter4.equals("3")) {
                                    c(queryParameter5);
                                }
                            }
                            CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.InnerTpnsActivity.3
                                @Override // com.tencent.tpns.baseapi.base.util.TTask
                                public void TRun() {
                                    if (i.a(InnerTpnsActivity.this.getApplicationContext()) > 0) {
                                        TLogger.e("InnerTpnsActivity", "otherChannelDeepLink initGlobal failed");
                                    }
                                    InnerTpnsActivity.this.a(data);
                                }
                            });
                        }
                        TLogger.i("InnerTpnsActivity", "InnerTpnsActivity receiver jumpType == null || targetIntent == null");
                        a();
                        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.InnerTpnsActivity.3
                            @Override // com.tencent.tpns.baseapi.base.util.TTask
                            public void TRun() {
                                if (i.a(InnerTpnsActivity.this.getApplicationContext()) > 0) {
                                    TLogger.e("InnerTpnsActivity", "otherChannelDeepLink initGlobal failed");
                                }
                                InnerTpnsActivity.this.a(data);
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                TLogger.ii("InnerTpnsActivity", "InnerTpnsActivity receiver e:" + th);
                finish();
                return;
            }
        }
        finish();
    }

    private void d(Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getStringExtra("activity") != null ? intent.getStringExtra("activity") : "";
            if (XGPushConfig.enableDebug) {
                TLogger.i("InnerTpnsActivity", "activity intent =" + intent + "activity = " + str + "intent.getFlags()" + intent.getFlags());
            }
            f5904d = intent.getLongExtra("msgId", 0L);
            f5905e = intent.getLongExtra("busiMsgId", 0L);
            f5903c = str;
        } else {
            str = null;
        }
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2.addFlags(intent.getFlags());
            intent2.setClassName(getApplicationContext(), str);
            intent.putExtra(Constants.TAG_TPUSH_MESSAGE, "true");
            intent2.putExtras(intent);
        }
        intent2.addFlags(536870912);
        intent2.putExtra(Constants.TAG_TPUSH_NOTIFICATION, XGPushManager.a(this));
        String decrypt = Rijndael.decrypt(intent.getStringExtra("custom_content"));
        if (!TextUtils.isEmpty(decrypt)) {
            intent2.putExtra("custom_content", decrypt);
        }
        try {
            a(getApplication());
            startActivity(intent2);
        } catch (ActivityNotFoundException unused) {
        }
        finish();
    }

    private void e(Intent intent) {
        g(intent);
        ResolveInfo d2 = d(intent.getStringExtra(Constants.FLAG_PACKAGE_NAME));
        if (d2 != null) {
            ActivityInfo activityInfo = d2.activityInfo;
            String str = activityInfo.name;
            String str2 = activityInfo.packageName;
            Intent intent2 = new Intent();
            intent2.putExtras(intent);
            intent2.setComponent(new ComponentName(str2, str));
            String decrypt = Rijndael.decrypt(intent.getStringExtra("custom_content"));
            if (!TextUtils.isEmpty(decrypt)) {
                intent2.putExtra("custom_content", decrypt);
            }
            a(0, intent2);
            return;
        }
        a(1, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Intent intent) {
        try {
            Intent intent2 = new Intent();
            NotificationAction notificationAction = NotificationAction.intent;
            int intExtra = intent.getIntExtra(Constants.FLAG_ACTION_TYPE, notificationAction.getType());
            if (intExtra == notificationAction.getType()) {
                int intExtra2 = intent.getIntExtra("PUSH.CHANNEL", 100);
                this.f5907g = intExtra2;
                if (intExtra2 != 101 && intExtra2 != 99) {
                    intent2 = Intent.parseUri(intent.getStringExtra("activity"), 1);
                    intent2.setAction("android.intent.action.VIEW");
                }
                intent2 = Intent.parseUri(URLDecoder.decode(intent.getStringExtra("activity"), "UTF-8"), 1);
                intent2.setAction("android.intent.action.VIEW");
            } else if (intExtra == NotificationAction.intent_with_action.getType()) {
                intent2.setAction(intent.getStringExtra("activity"));
                intent2.setPackage(getPackageName());
                intent2.setFlags(268435456);
            }
            intent2.putExtra("pushChannel", this.f5907g);
            String decrypt = Rijndael.decrypt(intent.getStringExtra("custom_content"));
            if (!TextUtils.isEmpty(decrypt)) {
                intent2.putExtra("custom_content", decrypt);
            }
            XGPushManager.a(this);
            if (intent2.resolveActivity(getPackageManager()) != null) {
                startActivity(intent2);
            }
            finish();
        } catch (Throwable th) {
            TLogger.e("InnerTpnsActivity", "openIntent error.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Intent intent) {
        XGPushManager.a(getApplicationContext(), intent);
    }

    public static long getMsgIdWithIntent(Intent intent) {
        long j2;
        Uri data;
        Object obj;
        if (intent == null) {
            return 0L;
        }
        try {
            Bundle extras = intent.getExtras();
            if (extras != null && (obj = extras.get("msgId")) != null) {
                if (obj instanceof String) {
                    j2 = Long.parseLong((String) obj);
                } else if (obj instanceof Long) {
                    j2 = ((Long) obj).longValue();
                }
                if (j2 != 0 && (data = intent.getData()) != null) {
                    String queryParameter = data.getQueryParameter("msgId");
                    return !i.b(queryParameter) ? Long.parseLong(queryParameter) : j2;
                }
            }
            j2 = 0;
            return j2 != 0 ? j2 : j2;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static boolean isMonitorActivityNames(String str) {
        return (b == null || i.b(str) || !b.contains(str)) ? false : true;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            TLogger.i("InnerTpnsActivity", "InnerTpnsActivity receiver intent:" + intent);
            if (intent != null && intent.getExtras() != null) {
                Bundle extras = intent.getExtras();
                if (extras.containsKey("pushChannel") && (extras.get("pushChannel") instanceof String) && (string = extras.getString("pushChannel")) != null && !TextUtils.isEmpty(string)) {
                    int intValue = Integer.valueOf(string).intValue();
                    this.f5907g = intValue;
                    if (intValue == 101) {
                        b(intent);
                    }
                }
            }
            if (a(intent)) {
                this.f5907g = intent.getIntExtra("pushChannel", 100);
                int intExtra = intent.getIntExtra(MessageKey.NOTIFACTION_ID, 0);
                if (intent.getBooleanExtra(Constants.FLAG_BUTTON_CLICK_IN_CUSTOM_LAYOUT, false)) {
                    XGPushManager.cancelNotifaction(getApplicationContext(), intExtra);
                }
                NotificationAction notificationAction = NotificationAction.activity;
                int intExtra2 = intent.getIntExtra(Constants.FLAG_ACTION_TYPE, notificationAction.getType());
                if (intExtra2 == notificationAction.getType()) {
                    d(intent);
                    return;
                } else if (intExtra2 == NotificationAction.action_package.getType()) {
                    e(intent);
                    return;
                } else if (intExtra2 == NotificationAction.url.getType()) {
                    b(0, intent);
                    return;
                } else {
                    if (intExtra2 != NotificationAction.intent.getType() && intExtra2 != NotificationAction.intent_with_action.getType()) {
                        finish();
                        return;
                    }
                    b(1, intent);
                    return;
                }
            }
            c(intent);
        } catch (Throwable th) {
            TLogger.ww("InnerTpnsActivity", "warning", th);
            try {
                finish();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }

    private void b(Intent intent) {
        final Bundle extras = intent.getExtras();
        if (extras == null) {
            finish();
        }
        String stringExtra = intent.getStringExtra("checkCode");
        String md5 = Md5.md5(intent.getStringExtra("msgId"));
        if (md5 != null && stringExtra.equals(md5)) {
            String string = extras.getString("content");
            TLogger.ii("InnerTpnsActivity", "fcmChannelDeepLink content ：" + string);
            if (string != null && !TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    JSONObject optJSONObject = jSONObject.optJSONObject("action");
                    int optInt = optJSONObject.optInt(Constants.FLAG_ACTION_TYPE, 0);
                    String optString = optJSONObject.optString("activity");
                    String optString2 = optJSONObject.optJSONObject("browser").optString("url");
                    String optString3 = optJSONObject.optString(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
                    String optString4 = jSONObject.optString("custom_content");
                    final XGPushClickedResult xGPushClickedResult = new XGPushClickedResult();
                    if (optInt != 1) {
                        if (optInt != 2) {
                            if (optInt == 3 && optString3 != null && !TextUtils.isEmpty(optString3)) {
                                xGPushClickedResult.activityName = optString3;
                                c(optString3);
                            }
                        } else if (optString2 != null && !TextUtils.isEmpty(optString2)) {
                            xGPushClickedResult.activityName = optString2;
                            b(optString2);
                        }
                    } else if (optString != null && !TextUtils.isEmpty(optString)) {
                        xGPushClickedResult.activityName = optString;
                        a(optString);
                    } else {
                        xGPushClickedResult.activityName = optString;
                        a();
                    }
                    xGPushClickedResult.notificationActionType = optInt;
                    xGPushClickedResult.customContent = optString4;
                    CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.InnerTpnsActivity.1
                        @Override // com.tencent.tpns.baseapi.base.util.TTask
                        public void TRun() {
                            if (i.a(InnerTpnsActivity.this.getApplicationContext()) > 0) {
                                TLogger.e("InnerTpnsActivity", "fcmChannelDeepLink initGlobal failed");
                            }
                            InnerTpnsActivity.this.a(extras, xGPushClickedResult);
                        }
                    });
                } catch (Throwable th) {
                    TLogger.ii("InnerTpnsActivity", "InnerTpnsActivity fcmChannelDeepLink e:" + th);
                }
            }
        } else {
            finish();
        }
        finish();
    }

    private boolean a(Intent intent) {
        if (intent == null || !intent.hasExtra(MessageKey.MSG_PORTECT_TAG)) {
            return false;
        }
        String stringExtra = intent.getStringExtra(MessageKey.MSG_PORTECT_TAG);
        if (i.b(stringExtra)) {
            return false;
        }
        try {
            Long valueOf = Long.valueOf(Rijndael.decrypt(stringExtra));
            if (valueOf.longValue() > 0) {
                return System.currentTimeMillis() >= valueOf.longValue();
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle, XGPushClickedResult xGPushClickedResult) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String str;
        String str2;
        long j2;
        try {
            string = bundle.getString("groupId");
            string2 = bundle.getString("ts");
            string3 = bundle.getString(MessageKey.MSG_TARGET_TYPE);
            string4 = bundle.getString("busiMsgId");
            string5 = bundle.getString("msgId");
            string6 = bundle.getString(MessageKey.MSG_PUSH_TIME);
            string7 = bundle.getString(MessageKey.MSG_SOURCE);
            string8 = bundle.getString("type");
            string9 = bundle.getString("pushChannel");
            string10 = bundle.getString(MessageKey.MSG_TEMPLATE_ID);
            string11 = bundle.getString(MessageKey.MSG_TRACE_ID);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Intent intent = new Intent();
            if (string4 != null) {
                long longValue = Long.valueOf(f5905e).longValue();
                str = MessageKey.MSG_TRACE_ID;
                str2 = MessageKey.MSG_TEMPLATE_ID;
                j2 = longValue;
            } else {
                str = MessageKey.MSG_TRACE_ID;
                str2 = MessageKey.MSG_TEMPLATE_ID;
                j2 = 0;
            }
            intent.putExtra("busiMsgId", j2);
            intent.putExtra("msgId", string5 != null ? Long.valueOf(string5).longValue() : 0L);
            intent.putExtra("type", string8 != null ? Long.valueOf(string8).longValue() : 1L);
            intent.putExtra("groupId", string);
            intent.putExtra("pushChannel", string9 != null ? Integer.valueOf(string9).intValue() : 101);
            intent.putExtra(MessageKey.MSG_TARGET_TYPE, string3 != null ? Long.valueOf(string3).longValue() : 0L);
            intent.putExtra(MessageKey.MSG_PUSH_TIME, string6 != null ? Long.valueOf(string6).longValue() * 1000 : 0L);
            intent.putExtra(MessageKey.MSG_SOURCE, string7 != null ? Long.valueOf(string7).longValue() : 0L);
            intent.putExtra("timestamps", string2 != null ? Long.valueOf(string2).longValue() * 1000 : 0L);
            String str3 = str2;
            intent.putExtra(str3, string10);
            String str4 = str;
            intent.putExtra(str4, string11);
            g(intent);
            Intent intent2 = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
            intent2.setPackage(getApplicationContext().getPackageName());
            intent2.putExtra("TPUSH.FEEDBACK", 4);
            intent2.putExtra("TPUSH.ERRORCODE", 0);
            intent2.putExtra("PUSH.CHANNEL", string9 != null ? Integer.valueOf(string9).intValue() : 101);
            intent2.putExtra("action", NotificationAction.clicked.getType());
            int i2 = xGPushClickedResult.notificationActionType;
            if (i2 == 0) {
                i2 = NotificationAction.activity.getType();
            }
            intent2.putExtra("notificationActionType", i2);
            intent2.putExtra("custom_content", xGPushClickedResult.customContent);
            intent2.putExtra("msgId", string5 != null ? Long.valueOf(string5).longValue() : 0L);
            intent2.putExtra(str3, string10);
            intent2.putExtra(str4, string11);
            String str5 = xGPushClickedResult.activityName;
            if (str5 != null && !TextUtils.isEmpty(str5)) {
                intent2.putExtra("activity", xGPushClickedResult.activityName);
            } else {
                String a2 = a(this);
                this.f5906f = a2;
                intent2.putExtra("activity", a2);
            }
            BroadcastAgent.sendBroadcast(getApplicationContext(), intent2);
        } catch (Throwable th2) {
            th = th2;
            TLogger.ii("InnerTpnsActivity", "InnerTpnsActivity reportAndFeekbackFcmChannelDeepLink e:" + th);
        }
    }

    private ResolveInfo d(String str) {
        try {
            PackageManager packageManager = getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            Collections.sort(queryIntentActivities, new ResolveInfo.DisplayNameComparator(packageManager));
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                String str2 = activityInfo.name;
                if (activityInfo.packageName.equals(str)) {
                    return resolveInfo;
                }
            }
        } catch (Throwable th) {
            TLogger.e("InnerTpnsActivity", "查找主Activity出错", th);
        }
        return null;
    }

    private void c(String str) {
        try {
            new Intent();
            TLogger.i("InnerTpnsActivity", "InnerTpnsActivity receiver jumpOtherChannelIntent targetActivity:" + str);
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.setAction("android.intent.action.VIEW");
            parseUri.putExtra("pushChannel", this.f5907g);
            if (parseUri.resolveActivity(getPackageManager()) != null) {
                startActivity(parseUri);
            }
        } catch (Throwable th) {
            TLogger.e("InnerTpnsActivity", "jumpOtherChannelIntent error: ", th);
        }
    }

    private void b(String str) {
        try {
            TLogger.i("InnerTpnsActivity", "InnerTpnsActivity receiver jumpOtherChannelUrl targetActivity :" + str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            intent.putExtra("pushChannel", this.f5907g);
            startActivity(intent);
        } catch (Throwable th) {
            TLogger.e("InnerTpnsActivity", "openUrl error: ", th);
        }
    }

    private void b(int i2, final Intent intent) {
        if (i2 != 0) {
            if (i2 == 1) {
                if (intent.getIntExtra(Constants.FLAG_ACTION_CONFIRM, 0) == 1) {
                    new AlertDialog.Builder(this).setTitle("提示").setCancelable(false).setMessage("继续打开Intent?").setPositiveButton("确认", new DialogInterface.OnClickListener() { // from class: com.tencent.android.tpush.InnerTpnsActivity.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            InnerTpnsActivity.this.f(intent);
                            InnerTpnsActivity.this.finish();
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.tencent.android.tpush.InnerTpnsActivity.10
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            InnerTpnsActivity.this.g(intent);
                            dialogInterface.cancel();
                            InnerTpnsActivity.this.finish();
                        }
                    }).show();
                    return;
                } else {
                    f(intent);
                    return;
                }
            }
            return;
        }
        final String stringExtra = intent.getStringExtra("activity");
        if (intent.getIntExtra(Constants.FLAG_ACTION_CONFIRM, 0) == 1) {
            AlertDialog.Builder cancelable = new AlertDialog.Builder(this).setTitle("提示").setCancelable(false);
            cancelable.setMessage("是否打开网站:" + stringExtra + "?").setPositiveButton("确认", new DialogInterface.OnClickListener() { // from class: com.tencent.android.tpush.InnerTpnsActivity.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    InnerTpnsActivity.this.a(stringExtra, intent);
                    InnerTpnsActivity.this.finish();
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.tencent.android.tpush.InnerTpnsActivity.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    InnerTpnsActivity.this.g(intent);
                    dialogInterface.cancel();
                    InnerTpnsActivity.this.finish();
                }
            }).show();
            return;
        }
        a(stringExtra, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Uri uri) {
        String str;
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String str2;
        String str3;
        long j2;
        String str4;
        long j3;
        try {
            String queryParameter7 = uri.getQueryParameter("jumpType");
            String queryParameter8 = uri.getQueryParameter("busiMsgId");
            String queryParameter9 = uri.getQueryParameter("msgId");
            String queryParameter10 = uri.getQueryParameter("msgType");
            try {
                String queryParameter11 = uri.getQueryParameter("groupId");
                String queryParameter12 = uri.getQueryParameter("pushChannel");
                try {
                    queryParameter = uri.getQueryParameter(MessageKey.MSG_TARGET_TYPE);
                    String queryParameter13 = uri.getQueryParameter(MessageKey.MSG_PUSH_TIME);
                    String queryParameter14 = uri.getQueryParameter(MessageKey.MSG_SOURCE);
                    queryParameter2 = uri.getQueryParameter("timestamp");
                    queryParameter3 = uri.getQueryParameter("customContent");
                    queryParameter4 = uri.getQueryParameter("targetActivity");
                    queryParameter5 = uri.getQueryParameter("tmpl");
                    queryParameter6 = uri.getQueryParameter("trace");
                    Intent intent = new Intent();
                    if (queryParameter8 != null) {
                        str2 = queryParameter13;
                        str3 = queryParameter14;
                        j2 = Long.valueOf(queryParameter8).longValue();
                    } else {
                        str2 = queryParameter13;
                        str3 = queryParameter14;
                        j2 = 0;
                    }
                    intent.putExtra("busiMsgId", j2);
                    intent.putExtra("msgId", queryParameter9 != null ? Long.valueOf(queryParameter9).longValue() : 0L);
                    intent.putExtra("type", queryParameter10 != null ? Long.valueOf(queryParameter10).longValue() : 1L);
                    intent.putExtra("groupId", queryParameter11);
                    intent.putExtra("pushChannel", queryParameter12 != null ? Integer.valueOf(queryParameter12).intValue() : 0);
                    intent.putExtra(MessageKey.MSG_TARGET_TYPE, queryParameter != null ? Long.valueOf(queryParameter).longValue() : 0L);
                    intent.putExtra(MessageKey.MSG_PUSH_TIME, str2 != null ? Long.valueOf(str2).longValue() * 1000 : 0L);
                    if (str3 != null) {
                        j3 = Long.valueOf(str3).longValue();
                        str4 = MessageKey.MSG_SOURCE;
                    } else {
                        str4 = MessageKey.MSG_SOURCE;
                        j3 = 0;
                    }
                    intent.putExtra(str4, j3);
                    intent.putExtra("timestamps", queryParameter2 != null ? Long.valueOf(queryParameter2).longValue() * 1000 : 0L);
                    intent.putExtra(MessageKey.MSG_TEMPLATE_ID, queryParameter5);
                    intent.putExtra(MessageKey.MSG_TRACE_ID, queryParameter6);
                    g(intent);
                    str = "InnerTpnsActivity";
                } catch (Throwable th) {
                    th = th;
                    str = "InnerTpnsActivity";
                    TLogger.ii(str, "InnerTpnsActivity reportOtherChannelDeepLink exception:" + th);
                }
                try {
                    TLogger.i(str, "InnerTpnsActivity receiver params : msgBuildId " + queryParameter8 + " , msgId = " + queryParameter9 + " , jumpType = " + queryParameter7 + " , msgType = " + queryParameter10 + " , groupId = " + queryParameter11 + " , pushChannel = " + queryParameter12 + " , targetType = " + queryParameter + " , pushTime = " + str2 + " , source = " + str3 + " , timestamp = " + queryParameter2 + " , templateId = " + queryParameter5 + " , traceId = " + queryParameter6);
                    Intent intent2 = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
                    intent2.setPackage(getApplicationContext().getPackageName());
                    intent2.putExtra("TPUSH.FEEDBACK", 4);
                    intent2.putExtra("TPUSH.ERRORCODE", 0);
                    intent2.putExtra("PUSH.CHANNEL", queryParameter12 != null ? Integer.valueOf(queryParameter12).intValue() : 0);
                    intent2.putExtra("action", NotificationAction.clicked.getType());
                    intent2.putExtra("notificationActionType", queryParameter7 != null ? Integer.valueOf(queryParameter7).intValue() : NotificationAction.activity.getType());
                    intent2.putExtra("custom_content", queryParameter3);
                    intent2.putExtra("msgId", queryParameter9 != null ? Long.valueOf(queryParameter9).longValue() : 0L);
                    intent2.putExtra(MessageKey.MSG_TEMPLATE_ID, queryParameter5);
                    intent2.putExtra(MessageKey.MSG_TRACE_ID, queryParameter6);
                    if (queryParameter4 != null && !TextUtils.isEmpty(queryParameter4)) {
                        intent2.putExtra("activity", queryParameter4);
                    } else {
                        String a2 = a(this);
                        this.f5906f = a2;
                        intent2.putExtra("activity", a2);
                    }
                    BroadcastAgent.sendBroadcast(getApplicationContext(), intent2);
                } catch (Throwable th2) {
                    th = th2;
                    TLogger.ii(str, "InnerTpnsActivity reportOtherChannelDeepLink exception:" + th);
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            str = "InnerTpnsActivity";
        }
    }

    private void a(String str) {
        try {
            Intent intent = new Intent();
            TLogger.i("InnerTpnsActivity", "InnerTpnsActivity receiver  jumpOtherChannelActivitys targetActivity = " + str);
            intent.setClassName(getApplicationContext(), str);
            intent.putExtra("pushChannel", this.f5907g);
            intent.setFlags(603979776);
            startActivity(intent);
        } catch (Throwable th) {
            TLogger.ii("InnerTpnsActivity", "InnerTpnsActivity receiver jumpOtherChannelActivitys = " + th);
        }
    }

    private void a() {
        Intent intent = new Intent();
        String str = this.f5906f;
        if (str == null || TextUtils.isEmpty(str)) {
            this.f5906f = a(this);
        }
        TLogger.i("InnerTpnsActivity", "InnerTpnsActivity receiver  jumpOtherChannelActivity targetActivity = " + this.f5906f);
        intent.setClassName(getApplicationContext(), this.f5906f);
        intent.setFlags(603979776);
        intent.putExtra("pushChannel", this.f5907g);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            TLogger.ii("InnerTpnsActivity", "InnerTpnsActivity receiver ActivityNotFoundException = " + e2);
        }
    }

    private static String a(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    return activityInfo.name;
                }
            }
        } catch (Throwable th) {
            TLogger.e("InnerTpnsActivity", "get Activity error", th);
        }
        return null;
    }

    public static void a(Application application) {
        if (a == null) {
            a = new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.android.tpush.InnerTpnsActivity.4
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                }
            };
            if (application != null) {
                try {
                    ((Application) application.getApplicationContext()).registerActivityLifecycleCallbacks(a);
                } catch (Throwable unused) {
                }
            }
        }
    }

    private void a(int i2, final Intent intent) {
        if (i2 == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.android.tpush.InnerTpnsActivity.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    intent.putExtra("action", NotificationAction.open_cancel.getType());
                    InnerTpnsActivity.this.g(intent);
                    InnerTpnsActivity.this.finish();
                }
            }).setTitle("提示").setMessage("是否确定打开此应用？").setPositiveButton("打开", new DialogInterface.OnClickListener() { // from class: com.tencent.android.tpush.InnerTpnsActivity.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    intent.putExtra("action", NotificationAction.open.getType());
                    InnerTpnsActivity.this.g(intent);
                    try {
                        InnerTpnsActivity.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                    }
                    InnerTpnsActivity.this.finish();
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.tencent.android.tpush.InnerTpnsActivity.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    intent.putExtra("action", NotificationAction.open_cancel.getType());
                    InnerTpnsActivity.this.g(intent);
                    dialogInterface.dismiss();
                    InnerTpnsActivity.this.finish();
                }
            });
            builder.create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Intent intent) {
        try {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent2.setFlags(268435456);
            intent2.putExtra("pushChannel", this.f5907g);
            XGPushManager.a(this);
            startActivity(intent2);
        } catch (Throwable th) {
            TLogger.e("InnerTpnsActivity", "openUrl error.", th);
        }
        finish();
    }
}
