package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.WorkerThread;
import e.j.d.f.r;
import e.j.d.i.b;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
public class FirebaseMessagingService extends zze {
    private static final Queue<String> zza = new ArrayDeque(10);

    @WorkerThread
    public void onDeletedMessages() {
    }

    @WorkerThread
    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    @WorkerThread
    public void onMessageSent(String str) {
    }

    @WorkerThread
    public void onNewToken(String str) {
    }

    @WorkerThread
    public void onSendError(String str, Exception exc) {
    }

    @Override // com.google.firebase.messaging.zze
    public final Intent zza(Intent intent) {
        return r.b().e();
    }

    @Override // com.google.firebase.messaging.zze
    public final boolean zzb(Intent intent) {
        if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
            if (pendingIntent != null) {
                try {
                    pendingIntent.send();
                } catch (PendingIntent.CanceledException unused) {
                    Log.e("FirebaseMessaging", "Notification pending intent canceled");
                }
            }
            if (b.e(intent)) {
                b.c(intent);
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ea, code lost:
        if (r1.equals("send_error") == false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c1  */
    @Override // com.google.firebase.messaging.zze
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzc(android.content.Intent r12) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.zzc(android.content.Intent):void");
    }
}
