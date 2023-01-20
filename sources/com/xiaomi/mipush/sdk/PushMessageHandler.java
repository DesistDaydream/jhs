package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.dt;
import com.xiaomi.push.ec;
import com.xiaomi.push.gu;
import com.xiaomi.push.ib;
import com.xiaomi.push.jl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class PushMessageHandler extends BaseService {
    private static List<MiPushClient.ICallbackResult> a = new ArrayList();
    private static List<MiPushClient.MiPushClientCallback> b = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f15a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* loaded from: classes3.dex */
    public interface a extends Serializable {
    }

    public static void a() {
        synchronized (b) {
            b.clear();
        }
    }

    public static void a(long j2, String str, String str2) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                miPushClientCallback.onInitializeResult(j2, str, str2);
            }
        }
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2.getMessage());
        }
    }

    public static void a(Context context, Intent intent) {
        com.xiaomi.a.a.a.c.c("addjob PushMessageHandler " + intent);
        if (intent != null) {
            c(context, intent);
            a(context);
        }
    }

    private static void a(Context context, Intent intent, ResolveInfo resolveInfo, boolean z) {
        try {
            MessageHandleService.a aVar = new MessageHandleService.a(intent, (PushMessageReceiver) jl.a(context, resolveInfo.activityInfo.name).newInstance());
            if (z) {
                MessageHandleService.a(context.getApplicationContext(), aVar);
            } else {
                MessageHandleService.addJob(context.getApplicationContext(), aVar);
            }
            MessageHandleService.a(context, new Intent(context.getApplicationContext(), MessageHandleService.class));
        } catch (Throwable th) {
            com.xiaomi.a.a.a.c.a(th);
        }
    }

    public static void a(Context context, MiPushCommandMessage miPushCommandMessage) {
        synchronized (a) {
            for (MiPushClient.ICallbackResult iCallbackResult : a) {
                if (iCallbackResult instanceof MiPushClient.UPSRegisterCallBack) {
                    MiPushClient.TokenResult tokenResult = new MiPushClient.TokenResult();
                    if (miPushCommandMessage != null && miPushCommandMessage.getCommandArguments() != null && miPushCommandMessage.getCommandArguments().size() > 0) {
                        tokenResult.setResultCode(miPushCommandMessage.getResultCode());
                        tokenResult.setToken(miPushCommandMessage.getCommandArguments().get(0));
                    }
                    iCallbackResult.onResult(tokenResult);
                }
            }
        }
    }

    public static void a(Context context, MiPushMessage miPushMessage) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(miPushMessage.getCategory(), miPushClientCallback.getCategory())) {
                    miPushClientCallback.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    miPushClientCallback.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    public static void a(Context context, a aVar) {
        if (aVar instanceof MiPushMessage) {
            a(context, (MiPushMessage) aVar);
        } else if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String command = miPushCommandMessage.getCommand();
            String str = null;
            if (ec.COMMAND_REGISTER.f8488k.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (ec.COMMAND_SET_ALIAS.f8488k.equals(command) || ec.COMMAND_UNSET_ALIAS.f8488k.equals(command) || ec.COMMAND_SET_ACCEPT_TIME.f8488k.equals(command)) {
                a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
            } else if (ec.COMMAND_SUBSCRIBE_TOPIC.f8488k.equals(command)) {
                List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                    str = commandArguments2.get(0);
                }
                a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (ec.COMMAND_UNSUBSCRIBE_TOPIC.f8488k.equals(command)) {
                List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                    str = commandArguments3.get(0);
                }
                b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            }
        }
    }

    public static void a(Context context, String str, long j2, String str2, String str3) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onSubscribeResult(j2, str2, str3);
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, long j2, String str3, List<String> list) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onCommandResult(str2, j2, str3, list);
                }
            }
        }
    }

    public static void a(MiPushClient.ICallbackResult iCallbackResult) {
        synchronized (a) {
            if (!a.contains(iCallbackResult)) {
                a.add(iCallbackResult);
            }
        }
    }

    public static void a(MiPushClient.MiPushClientCallback miPushClientCallback) {
        synchronized (b) {
            if (!b.contains(miPushClientCallback)) {
                b.add(miPushClientCallback);
            }
        }
    }

    public static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    public static void b() {
        synchronized (a) {
            a.clear();
        }
    }

    private static void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("action_clicked_activity_finish");
            context.sendBroadcast(intent, d.a(context));
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("callback sync error" + e2);
        }
    }

    public static void b(Context context, Intent intent) {
        boolean z = false;
        try {
            z = intent.getBooleanExtra("is_clicked_activity_call", false);
        } catch (Throwable th) {
            com.xiaomi.a.a.a.c.a("intent unparcel error:" + th);
        }
        try {
            ResolveInfo resolveInfo = null;
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                o.a(context, intent, null);
            } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                gu guVar = new gu();
                ib.a(guVar, intent.getByteArrayExtra("mipush_payload"));
                com.xiaomi.a.a.a.c.c("PushMessageHandler.onHandleIntent " + guVar.m());
                MiTinyDataClient.upload(context, guVar);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                if (m50b()) {
                    com.xiaomi.a.a.a.c.d("receive a message before application calling initialize");
                    if (z) {
                        b(context);
                        return;
                    }
                    return;
                }
                a a2 = am.a(context).a(intent);
                if (a2 != null) {
                    a(context, a2);
                }
            } else if (!"com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(context.getPackageName());
                intent2.putExtras(intent);
                try {
                    List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                    if (queryBroadcastReceivers != null) {
                        Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ResolveInfo next = it.next();
                            ActivityInfo activityInfo = next.activityInfo;
                            if (activityInfo != null && activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(jl.a(context, next.activityInfo.name))) {
                                resolveInfo = next;
                                break;
                            }
                        }
                    }
                    if (resolveInfo != null) {
                        a(context, intent2, resolveInfo, z);
                    } else {
                        com.xiaomi.a.a.a.c.d("cannot find the receiver to handler this message, check your manifest");
                        dt.a(context).a(context.getPackageName(), intent, "11");
                    }
                } catch (Exception e2) {
                    com.xiaomi.a.a.a.c.a(e2);
                    dt.a(context).a(context.getPackageName(), intent, "9");
                }
            }
        } catch (Throwable th2) {
            try {
                com.xiaomi.a.a.a.c.a(th2);
                dt.a(context).a(context.getPackageName(), intent, "10");
                if (!z) {
                }
            } finally {
                if (z) {
                    b(context);
                }
            }
        }
    }

    public static void b(Context context, String str, long j2, String str2, String str3) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onUnsubscribeResult(j2, str2, str3);
                }
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m50b() {
        return b.isEmpty();
    }

    private static void c(Context context, Intent intent) {
        if (intent == null || f15a.isShutdown()) {
            return;
        }
        f15a.execute(new al(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo51a() {
        ThreadPoolExecutor threadPoolExecutor = f15a;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f15a.getQueue().size() <= 0) ? false : true;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
        c(getApplicationContext(), intent);
    }
}
