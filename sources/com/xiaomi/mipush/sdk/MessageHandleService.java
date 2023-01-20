package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.dt;
import com.xiaomi.push.ec;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class MessageHandleService extends BaseService {
    private static ConcurrentLinkedQueue<a> a = new ConcurrentLinkedQueue<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f3a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* loaded from: classes3.dex */
    public static class a {
        private Intent a;

        /* renamed from: a  reason: collision with other field name */
        private PushMessageReceiver f4a;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f4a = pushMessageReceiver;
            this.a = intent;
        }

        public Intent a() {
            return this.a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public PushMessageReceiver m45a() {
            return this.f4a;
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        b(context);
    }

    public static void a(Context context, a aVar) {
        String[] stringArrayExtra;
        if (aVar == null) {
            return;
        }
        try {
            PushMessageReceiver m45a = aVar.m45a();
            Intent a2 = aVar.a();
            int intExtra = a2.getIntExtra("message_type", 1);
            if (intExtra == 1) {
                PushMessageHandler.a a3 = am.a(context).a(a2);
                int intExtra2 = a2.getIntExtra("eventMessageType", -1);
                if (a3 == null) {
                    return;
                }
                if (a3 instanceof MiPushMessage) {
                    MiPushMessage miPushMessage = (MiPushMessage) a3;
                    if (!miPushMessage.isArrivedMessage()) {
                        m45a.onReceiveMessage(context, miPushMessage);
                    }
                    if (miPushMessage.getPassThrough() == 1) {
                        dt.a(context.getApplicationContext()).a(context.getPackageName(), a2, PushConstants.NOTIFICATION_SERVICE_SEND_MESSAGE_ERROR, (String) null);
                        com.xiaomi.a.a.a.c.f("begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                        m45a.onReceivePassThroughMessage(context, miPushMessage);
                        return;
                    } else if (!miPushMessage.isNotified()) {
                        com.xiaomi.a.a.a.c.f("begin execute onNotificationMessageArrived from " + miPushMessage.getMessageId());
                        m45a.onNotificationMessageArrived(context, miPushMessage);
                        return;
                    } else {
                        if (intExtra2 == 1000) {
                            dt.a(context.getApplicationContext()).a(context.getPackageName(), a2, 1007, (String) null);
                        } else {
                            dt.a(context.getApplicationContext()).a(context.getPackageName(), a2, 3007, (String) null);
                        }
                        com.xiaomi.a.a.a.c.f("begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                        m45a.onNotificationMessageClicked(context, miPushMessage);
                        return;
                    }
                } else if (!(a3 instanceof MiPushCommandMessage)) {
                    return;
                } else {
                    MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a3;
                    com.xiaomi.a.a.a.c.f("begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                    m45a.onCommandResult(context, miPushCommandMessage);
                    if (!TextUtils.equals(miPushCommandMessage.getCommand(), ec.COMMAND_REGISTER.f8488k)) {
                        return;
                    }
                    m45a.onReceiveRegisterResult(context, miPushCommandMessage);
                    PushMessageHandler.a(context, miPushCommandMessage);
                    if (miPushCommandMessage.getResultCode() != 0) {
                        return;
                    }
                }
            } else if (intExtra != 3) {
                if (intExtra == 5 && PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(a2.getStringExtra("error_type")) && (stringArrayExtra = a2.getStringArrayExtra("error_message")) != null) {
                    com.xiaomi.a.a.a.c.f("begin execute onRequirePermissions, lack of necessary permissions");
                    m45a.onRequirePermissions(context, stringArrayExtra);
                    return;
                }
                return;
            } else {
                MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) a2.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                com.xiaomi.a.a.a.c.f("(Local) begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                m45a.onCommandResult(context, miPushCommandMessage2);
                if (!TextUtils.equals(miPushCommandMessage2.getCommand(), ec.COMMAND_REGISTER.f8488k)) {
                    return;
                }
                m45a.onReceiveRegisterResult(context, miPushCommandMessage2);
                PushMessageHandler.a(context, miPushCommandMessage2);
                if (miPushCommandMessage2.getResultCode() != 0) {
                    return;
                }
            }
            i.b(context);
        } catch (RuntimeException e2) {
            com.xiaomi.a.a.a.c.a(e2);
        }
    }

    public static void addJob(Context context, a aVar) {
        if (aVar != null) {
            a.add(aVar);
            b(context);
            startService(context);
        }
    }

    private static void b(Context context) {
        if (f3a.isShutdown()) {
            return;
        }
        f3a.execute(new z(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        try {
            a(context, a.poll());
        } catch (RuntimeException e2) {
            com.xiaomi.a.a.a.c.a(e2);
        }
    }

    public static void startService(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, MessageHandleService.class));
        com.xiaomi.push.m.a(context).a(new y(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    public boolean mo51a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
    }
}
