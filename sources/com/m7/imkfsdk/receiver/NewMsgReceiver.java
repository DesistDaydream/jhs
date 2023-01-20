package com.m7.imkfsdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.constant.NotifyConstants;
import com.m7.imkfsdk.utils.NotificationUtils;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.YKFConstants;
import com.moor.imkf.utils.YKFUtils;

/* loaded from: classes2.dex */
public class NewMsgReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(IMChatManager.NEW_MSG_ACTION)) {
            Intent intent2 = new Intent("com.m7.imkfsdk.msgreceiver");
            intent2.setPackage(context.getPackageName());
            context.sendBroadcast(intent2);
            if (YKFUtils.getInstance().isForeground()) {
                return;
            }
            NotificationUtils.getInstance(context).setClass(ChatActivity.class).setFlags(268435456).setContentIntent(YKFConstants.TYPE_PEER).setTicker("您有新的消息").setWhen(System.currentTimeMillis()).setFullScreen(true).setPriority(1).setOngoing(true).setOnlyAlertOnce(false).sendNotification(1, NotifyConstants.TITLE_NEWMSG, "您有新的消息", R.drawable.ykfsdk_kf_ic_launcher);
        }
    }
}
