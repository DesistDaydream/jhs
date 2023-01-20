package com.m7.imkfsdk.chat;

import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.listener.OnCancelDialogListener;
import com.m7.imkfsdk.constant.NotifyConstants;
import com.m7.imkfsdk.utils.NotificationUtils;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.listener.OnCallEventListener;
import com.moor.imkf.model.entity.YKFCallInfoBean;
import com.moor.imkf.utils.YKFUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes2.dex */
public class YKFCallHelper {
    public static String YKFCALLMANAGER_CLASS = "com.m7.imkfsdk.video.YKFCallManager";
    private static OnCancelDialogListener mListener;

    /* loaded from: classes2.dex */
    public static class KfVideoHandle implements InvocationHandler {
        private KfVideoHandle() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if ("createNotify".equals(method.getName())) {
                MoorLogUtils.d("==createNotify==" + objArr[0] + "===" + objArr[1]);
                Class<?> cls = Class.forName("org.jitsi.meet.sdk.JitsiMeetActivity");
                if (((Boolean) objArr[1]).booleanValue()) {
                    String str = ((Boolean) objArr[0]).booleanValue() ? NotifyConstants.TITLE_VIDEO_INVITED : NotifyConstants.TITLE_VOICE_INVITED;
                    NotificationUtils.getInstance(YKFUtils.getInstance().getCurrentActivity()).setClass(cls).setFlags(268435456).setContentIntent("").setTicker(str).setWhen(System.currentTimeMillis()).setFullScreen(true).setPriority(1).setOngoing(true).setOnlyAlertOnce(false).sendNotification(NotifyConstants.INVITED_VIDEO, str, NotifyConstants.CONTENT_DETAIL, R.drawable.ykfsdk_kf_ic_launcher);
                    return null;
                }
                NotificationUtils autoCancel = NotificationUtils.getInstance(YKFUtils.getInstance().getCurrentActivity()).setClass(cls).setContentIntent("video").setFlags(268435456).setTicker("视频通话").setWhen(System.currentTimeMillis()).setPriority(2).setOngoing(true).setOnlyAlertOnce(false).setAutoCancel(false);
                if (((Boolean) objArr[0]).booleanValue()) {
                    autoCancel.sendNotification(273, "视频通话", NotifyConstants.CONTENT_VIDEO, R.drawable.ykfsdk_kf_ic_launcher);
                    return null;
                }
                autoCancel.sendNotification(273, NotifyConstants.TITLE_VOICE, NotifyConstants.CONTENT_VOICE, R.drawable.ykfsdk_kf_ic_launcher);
                return null;
            } else if ("cancelNotify".equals(method.getName())) {
                MoorLogUtils.d("==cancelNotify==");
                NotificationUtils.getInstance(YKFUtils.getInstance().getCurrentActivity()).getManager().cancel(((Integer) objArr[0]).intValue());
                return null;
            } else if ("cancelLoadingDialog".equals(method.getName())) {
                MoorLogUtils.d("==cancelLoadingDialog==");
                if (YKFCallHelper.mListener != null) {
                    YKFCallHelper.mListener.cancelDialog();
                    return null;
                }
                return null;
            } else {
                return null;
            }
        }
    }

    public static boolean existVideo() {
        try {
            Class<?> cls = Class.forName(YKFCALLMANAGER_CLASS);
            return ((Boolean) cls.getMethod("existVideo", new Class[0]).invoke(cls.getMethod("getInstance", new Class[0]).invoke(new Object(), new Object[0]), new Object[0])).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void leave(boolean z) {
        try {
            Class<?> cls = Class.forName(YKFCALLMANAGER_CLASS);
            cls.getMethod("leave", Boolean.TYPE).invoke(cls.getMethod("getInstance", new Class[0]).invoke(new Object(), new Object[0]), Boolean.valueOf(z));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void openActivity() {
        try {
            Class<?> cls = Class.forName(YKFCALLMANAGER_CLASS);
            cls.getMethod("openActivity", new Class[0]).invoke(cls.getMethod("getInstance", new Class[0]).invoke(new Object(), new Object[0]), new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void openCall(YKFCallInfoBean yKFCallInfoBean) {
        try {
            KfVideoHandle kfVideoHandle = new KfVideoHandle();
            Class<?> cls = Class.forName(YKFCALLMANAGER_CLASS);
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(new Object(), new Object[0]);
            cls.getMethod("setCallBack", OnCallEventListener.class).invoke(invoke, Proxy.newProxyInstance(ChatActivity.class.getClassLoader(), new Class[]{OnCallEventListener.class}, kfVideoHandle));
            cls.getMethod("openCall", YKFCallInfoBean.class).invoke(invoke, yKFCallInfoBean);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void receivedCall(YKFCallInfoBean yKFCallInfoBean) {
        try {
            KfVideoHandle kfVideoHandle = new KfVideoHandle();
            Class<?> cls = Class.forName(YKFCALLMANAGER_CLASS);
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(new Object(), new Object[0]);
            cls.getMethod("setCallBack", OnCallEventListener.class).invoke(invoke, Proxy.newProxyInstance(ChatActivity.class.getClassLoader(), new Class[]{OnCallEventListener.class}, kfVideoHandle));
            cls.getMethod("ReceivedCall", YKFCallInfoBean.class).invoke(invoke, yKFCallInfoBean);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setInvitedIntentNull() {
        try {
            Class<?> cls = Class.forName(YKFCALLMANAGER_CLASS);
            cls.getMethod("setInvitedIntentNull", new Class[0]).invoke(cls.getMethod("getInstance", new Class[0]).invoke(new Object(), new Object[0]), new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setOnCancelDialogListener(OnCancelDialogListener onCancelDialogListener) {
        mListener = onCancelDialogListener;
    }
}
