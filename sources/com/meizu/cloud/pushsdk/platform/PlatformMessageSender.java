package com.meizu.cloud.pushsdk.platform;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.a.c.d;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;

/* loaded from: classes2.dex */
public class PlatformMessageSender {

    /* loaded from: classes2.dex */
    public interface a {
        String a();

        BasicPushStatus b();

        String c();

        String d();
    }

    public static void a(Context context, int i2, boolean z, String str) {
        String appVersionName = MzSystemUtils.getAppVersionName(context, PushConstants.PUSH_PACKAGE_NAME);
        e.p.a.a.a.c("PlatformMessageSender", context.getPackageName() + " switchPushMessageSetting cloudVersion_name " + appVersionName);
        if (TextUtils.isEmpty(appVersionName) || Integer.parseInt(appVersionName.substring(0, 1)) < 6) {
            return;
        }
        Intent intent = new Intent(PushConstants.MZ_PUSH_ON_MESSAGE_SWITCH_SETTING);
        intent.putExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_SETTING_TYPE, i2);
        intent.putExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_SETTING_STATUS, z);
        intent.putExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_SETTING_PACKAGE_NAME, str);
        intent.setClassName(PushConstants.PUSH_PACKAGE_NAME, PushConstants.MZ_PUSH_SERVICE_NAME);
        try {
            context.startService(intent);
        } catch (Exception e2) {
            e.p.a.a.a.f("PlatformMessageSender", "start switch push message setting service error " + e2.getMessage());
        }
    }

    private static void a(Context context, String str, a aVar) {
        Intent intent = new Intent();
        intent.addCategory(str);
        intent.setPackage(str);
        intent.putExtra(PushConstants.MZ_PUSH_MESSAGE_METHOD, aVar.a());
        if (MinSdkChecker.isSupportTransmitMessageValue(context, str)) {
            intent.putExtra(PushConstants.MZ_MESSAGE_VALUE, aVar.d());
        } else {
            intent.putExtra(aVar.c(), aVar.b());
        }
        MzSystemUtils.sendMessageFromBroadcast(context, intent, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, str);
        com.meizu.cloud.pushsdk.a.a(context);
    }

    public static void a(Context context, String str, final PushSwitchStatus pushSwitchStatus) {
        a(context, str, new a() { // from class: com.meizu.cloud.pushsdk.platform.PlatformMessageSender.1
            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public String a() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PUSH_STATUS;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public BasicPushStatus b() {
                return PushSwitchStatus.this;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public String c() {
                return PushConstants.EXTRA_APP_PUSH_SWITCH_STATUS;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public String d() {
                return com.meizu.cloud.pushsdk.platform.message.a.a(PushSwitchStatus.this);
            }
        });
    }

    public static void a(Context context, String str, final RegisterStatus registerStatus) {
        a(context, str, new a() { // from class: com.meizu.cloud.pushsdk.platform.PlatformMessageSender.2
            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public String a() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_REGISTER_STATUS;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public BasicPushStatus b() {
                return RegisterStatus.this;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public String c() {
                return PushConstants.EXTRA_APP_PUSH_REGISTER_STATUS;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public String d() {
                return com.meizu.cloud.pushsdk.platform.message.a.a(RegisterStatus.this);
            }
        });
    }

    public static void a(Context context, String str, final SubAliasStatus subAliasStatus) {
        a(context, str, new a() { // from class: com.meizu.cloud.pushsdk.platform.PlatformMessageSender.5
            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public String a() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBALIAS_STATUS;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public BasicPushStatus b() {
                return SubAliasStatus.this;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public String c() {
                return PushConstants.EXTRA_APP_PUSH_SUBALIAS_STATUS;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public String d() {
                return com.meizu.cloud.pushsdk.platform.message.a.a(SubAliasStatus.this);
            }
        });
    }

    public static void a(Context context, String str, final SubTagsStatus subTagsStatus) {
        a(context, str, new a() { // from class: com.meizu.cloud.pushsdk.platform.PlatformMessageSender.4
            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public String a() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBTAGS_STATUS;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public BasicPushStatus b() {
                return SubTagsStatus.this;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public String c() {
                return PushConstants.EXTRA_APP_PUSH_SUBTAGS_STATUS;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public String d() {
                return com.meizu.cloud.pushsdk.platform.message.a.a(SubTagsStatus.this);
            }
        });
    }

    public static void a(Context context, String str, final UnRegisterStatus unRegisterStatus) {
        a(context, str, new a() { // from class: com.meizu.cloud.pushsdk.platform.PlatformMessageSender.3
            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public String a() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_UNREGISTER_STATUS;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public BasicPushStatus b() {
                return UnRegisterStatus.this;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public String c() {
                return PushConstants.EXTRA_APP_PUSH_UNREGISTER_STATUS;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
            public String d() {
                return com.meizu.cloud.pushsdk.platform.message.a.a(UnRegisterStatus.this);
            }
        });
    }

    public static void launchStartActivity(Context context, String str, String str2, String str3) {
        d a2 = com.meizu.cloud.pushsdk.util.d.a(str3);
        MessageV3 parse = MessageV3.parse(str, str, a2.e(), a2.f(), a2.c(), a2.d(), str2);
        Intent intent = new Intent();
        intent.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, parse);
        intent.putExtra(PushConstants.MZ_PUSH_MESSAGE_METHOD, PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE);
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
            intent.setClassName(str, "com.meizu.cloud.pushsdk.NotificationService");
        }
        intent.putExtra("command_type", "reflect_receiver");
        e.p.a.a.a.c("PlatformMessageSender", "start notification service " + parse);
        try {
            context.startService(intent);
        } catch (Exception e2) {
            e.p.a.a.a.f("PlatformMessageSender", "launchStartActivity error " + e2.getMessage());
        }
    }

    public static void showQuickNotification(Context context, String str, String str2) {
        d a2 = com.meizu.cloud.pushsdk.util.d.a(str2);
        Intent intent = new Intent();
        intent.putExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID, a2.d());
        intent.putExtra(PushConstants.EXTRA_APP_PUSH_TASK_ID, a2.c());
        intent.putExtra(PushConstants.EXTRA_APP_PUSH_TASK_TIMES_TAMP, a2.e());
        intent.putExtra(PushConstants.EXTRA_APP_PUSH_SERVICE_DEFAULT_PACKAGE_NAME, context.getPackageName());
        intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, str);
        intent.putExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY, a2.f());
        intent.putExtra(PushConstants.MZ_PUSH_MESSAGE_METHOD, PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_SHOW_V3);
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        intent.setClassName(context.getPackageName(), "com.meizu.cloud.pushsdk.NotificationService");
        intent.putExtra("command_type", "reflect_receiver");
        try {
            e.p.a.a.a.f("PlatformMessageSender", "start notification service to show notification");
            context.startService(intent);
        } catch (Exception e2) {
            e.p.a.a.a.f("PlatformMessageSender", "showNotification error " + e2.getMessage());
        }
    }
}
