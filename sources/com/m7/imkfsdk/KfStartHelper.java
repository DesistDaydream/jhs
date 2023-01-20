package com.m7.imkfsdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.dialog.LoadingFragmentDialog;
import com.m7.imkfsdk.utils.ToastUtils;
import com.m7.imkfsdk.utils.faceutils.FaceConversionUtil;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.YKFConstants;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.listener.GetGlobleConfigListen;
import com.moor.imkf.listener.GetPeersListener;
import com.moor.imkf.listener.InitListener;
import com.moor.imkf.model.entity.CardInfo;
import com.moor.imkf.model.entity.Peer;
import com.moor.imkf.model.entity.ScheduleConfig;
import com.moor.imkf.utils.MoorUtils;
import com.moor.imkf.utils.YKFUtils;
import com.tencent.android.tpush.common.MessageKey;
import java.util.List;

/* loaded from: classes2.dex */
public class KfStartHelper {
    public static String avatarUrl;
    private String accessId;
    private Context context;
    private SharedPreferences.Editor edit;
    private LoadingFragmentDialog loadingDialog;
    private String receiverAction = "com.m7.imkf.KEFU_NEW_MSG";
    private SharedPreferences spData;
    private String userId;
    private String userName;

    /* loaded from: classes2.dex */
    public static class KfStartHelperClassHolder {
        private static final KfStartHelper instance = new KfStartHelper();

        private KfStartHelperClassHolder() {
        }
    }

    public static KfStartHelper getInstance() {
        return KfStartHelperClassHolder.instance;
    }

    private void initHelper() {
        this.context = YKFUtils.getInstance().getApplication();
        this.loadingDialog = new LoadingFragmentDialog();
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(YKFConstants.MOOR_SP, 0);
        this.spData = sharedPreferences;
        this.edit = sharedPreferences.edit();
        MoorUtils.init(YKFUtils.getInstance().getApplication());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startChatActivityForPeer(final Activity activity, final String str) {
        IMChatManager.getInstance().getPeers(new GetPeersListener() { // from class: com.m7.imkfsdk.KfStartHelper.5
            @Override // com.moor.imkf.listener.GetPeersListener
            public void onFailed() {
                KfStartHelper.this.loadingDialog.dismiss();
                ToastUtils.showShort(KfStartHelper.this.context, KfStartHelper.this.context.getString(R.string.ykfsdk_ykf_nopeer));
            }

            @Override // com.moor.imkf.listener.GetPeersListener
            public void onSuccess(List<Peer> list) {
                KfStartHelper.this.loadingDialog.dismiss();
                if (list.size() > 1) {
                    KfStartHelper.this.startPeersDialog(activity, str, list, IMChatManager.getInstance().getCardInfo());
                } else if (list.size() == 1) {
                    new ChatActivity.Builder().setType(YKFConstants.TYPE_PEER).setPeerId(list.get(0).getId()).setCardInfo(IMChatManager.getInstance().getCardInfo()).setNewCardInfo(IMChatManager.getInstance().getNewCardInfo()).build(KfStartHelper.this.context);
                } else {
                    ToastUtils.showShort(KfStartHelper.this.context, R.string.ykfsdk_peer_no_number);
                }
            }
        });
    }

    private void startKFService() {
        IMChatManager.getInstance().setOnInitListener(new InitListener() { // from class: com.m7.imkfsdk.KfStartHelper.1
            @Override // com.moor.imkf.listener.InitListener
            public void onInitFailed(int i2) {
                IMChatManager.getInstance().isIniting = false;
                Context context = KfStartHelper.this.context;
                ToastUtils.showShort(context, KfStartHelper.this.context.getString(R.string.ykfsdk_sdkinitwrong) + i2);
                MoorLogUtils.d("MainActivity", "sdk初始化失败:" + i2);
                IMChatManager.getInstance().quitSDk();
                KfStartHelper.this.loadingDialog.dismiss();
            }

            @Override // com.moor.imkf.listener.InitListener
            public void oninitStart() {
                KfStartHelper.this.loadingDialog.show(YKFUtils.getInstance().getCurrentActivity().getFragmentManager(), "");
                KfStartHelper.this.initFaceUtils();
            }

            @Override // com.moor.imkf.listener.InitListener
            public void oninitSuccess() {
                if (!YKFUtils.getInstance().getCurrentActivity().isFinishing()) {
                    KfStartHelper.this.getIsGoSchedule(YKFUtils.getInstance().getCurrentActivity(), YKFConstants.FROMMAIN);
                }
                MoorLogUtils.d("MainActivity", "sdk初始化成功");
            }
        });
        IMChatManager.getInstance().init(this.context, this.receiverAction, this.accessId, this.userName, this.userId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startScheduleDialog(final Activity activity, final String str, final List<ScheduleConfig.EntranceNodeBean.EntrancesBean> list, final String str2, final String str3) {
        String[] strArr = new String[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            strArr[i2] = list.get(i2).getName();
        }
        new AlertDialog.Builder(activity).setTitle(this.context.getString(R.string.ykfsdk_ykf_select_scu)).setCancelable(false).setNegativeButton(this.context.getString(R.string.ykfsdk_back), new DialogInterface.OnClickListener() { // from class: com.m7.imkfsdk.KfStartHelper.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                Activity activity2;
                IMChatManager.getInstance().quitSDk();
                if (!YKFConstants.FROMCHAT.equals(str) || (activity2 = activity) == null) {
                    return;
                }
                activity2.finish();
            }
        }).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.m7.imkfsdk.KfStartHelper.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
                ScheduleConfig.EntranceNodeBean.EntrancesBean entrancesBean = (ScheduleConfig.EntranceNodeBean.EntrancesBean) list.get(i3);
                MoorLogUtils.aTag("选择日程：", entrancesBean.getName());
                new ChatActivity.Builder().setType(YKFConstants.TYPE_SCHEDULE).setScheduleId(str2).setProcessId(str3).setCurrentNodeId(entrancesBean.getProcessTo()).setProcessType(entrancesBean.getProcessType()).setEntranceId(entrancesBean.get_id()).setCardInfo(IMChatManager.getInstance().getCardInfo()).setNewCardInfo(IMChatManager.getInstance().getNewCardInfo()).build(KfStartHelper.this.context);
            }
        }).create().show();
    }

    public void getIsGoSchedule(final Activity activity, final String str) {
        IMChatManager.getInstance().getWebchatScheduleConfig(new GetGlobleConfigListen() { // from class: com.m7.imkfsdk.KfStartHelper.2
            @Override // com.moor.imkf.listener.GetGlobleConfigListen
            public void getPeers() {
                MoorLogUtils.aTag(MessageKey.MSG_ACCEPT_TIME_START, "技能组");
                KfStartHelper.this.startChatActivityForPeer(activity, str);
            }

            @Override // com.moor.imkf.listener.GetGlobleConfigListen
            public void getSchedule(ScheduleConfig scheduleConfig) {
                KfStartHelper.this.loadingDialog.dismiss();
                MoorLogUtils.aTag("MainActivity", "日程");
                if (scheduleConfig.getScheduleId().equals("") || scheduleConfig.getProcessId().equals("") || scheduleConfig.getEntranceNode() == null || scheduleConfig.getLeavemsgNodes() == null) {
                    ToastUtils.showShort(KfStartHelper.this.context, R.string.ykfsdk_sorryconfigurationiswrong);
                } else if (scheduleConfig.getEntranceNode().getEntrances().size() <= 0) {
                    ToastUtils.showShort(KfStartHelper.this.context, R.string.ykfsdk_sorryconfigurationiswrong);
                } else if (scheduleConfig.getEntranceNode().getEntrances().size() != 1) {
                    KfStartHelper.this.startScheduleDialog(activity, str, scheduleConfig.getEntranceNode().getEntrances(), scheduleConfig.getScheduleId(), scheduleConfig.getProcessId());
                } else {
                    ScheduleConfig.EntranceNodeBean.EntrancesBean entrancesBean = scheduleConfig.getEntranceNode().getEntrances().get(0);
                    new ChatActivity.Builder().setType(YKFConstants.TYPE_SCHEDULE).setScheduleId(scheduleConfig.getScheduleId()).setProcessId(scheduleConfig.getProcessId()).setCurrentNodeId(entrancesBean.getProcessTo()).setProcessType(entrancesBean.getProcessType()).setEntranceId(entrancesBean.get_id()).setCardInfo(IMChatManager.getInstance().getCardInfo()).setNewCardInfo(IMChatManager.getInstance().getNewCardInfo()).build(KfStartHelper.this.context);
                }
            }
        });
    }

    public void initFaceUtils() {
        if (FaceConversionUtil.getInstace().emojis == null || FaceConversionUtil.getInstace().emojis.size() == 0) {
            FaceConversionUtil.getInstace().getFileText(this.context);
        }
    }

    public void initSdkChat(String str, String str2, String str3, String str4) {
        avatarUrl = str4;
        initSdkChat(str, str2, str3);
    }

    public void setChatActivityEmoji(boolean z) {
        if (this.spData == null) {
            return;
        }
        this.edit.putBoolean(YKFConstants.CHATACTIVITYEMOJI, z).apply();
    }

    public void setChatActivityLeftText(String str) {
        if (this.spData == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.edit.putString(YKFConstants.CHATACTIVITYLEFTTEXT, str).apply();
    }

    public void setReceiverAction(String str) {
        this.receiverAction = str;
    }

    public void startPeersDialog(final Activity activity, final String str, final List<Peer> list, final CardInfo cardInfo) {
        String[] strArr = new String[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            strArr[i2] = list.get(i2).getName();
        }
        new AlertDialog.Builder(activity).setTitle(this.context.getString(R.string.ykfsdk_ykf_select_peer)).setCancelable(false).setNegativeButton(this.context.getString(R.string.ykfsdk_back), new DialogInterface.OnClickListener() { // from class: com.m7.imkfsdk.KfStartHelper.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                Activity activity2;
                IMChatManager.getInstance().quitSDk();
                if (!YKFConstants.FROMCHAT.equals(str) || (activity2 = activity) == null) {
                    return;
                }
                activity2.finish();
            }
        }).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.m7.imkfsdk.KfStartHelper.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
                Peer peer = (Peer) list.get(i3);
                MoorLogUtils.aTag("选择技能组：", peer.getName());
                new ChatActivity.Builder().setType(YKFConstants.TYPE_PEER).setPeerId(peer.getId()).setCardInfo(cardInfo).setNewCardInfo(IMChatManager.getInstance().getNewCardInfo()).build(KfStartHelper.this.context);
            }
        }).create().show();
    }

    public void initSdkChat(String str, String str2, String str3) {
        initHelper();
        if (IMChatManager.getInstance().isIniting) {
            return;
        }
        this.accessId = str;
        this.userName = str2;
        this.userId = str3;
        if (!MoorUtils.isNetWorkConnected(this.context)) {
            Toast.makeText(this.context, R.string.ykfsdk_notnetwork, 0).show();
        } else {
            startKFService();
        }
    }
}
