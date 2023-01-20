package com.m7.imkfsdk.chat;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.effective.android.panel.PanelSwitchHelper;
import com.effective.android.panel.interfaces.ContentScrollMeasurer;
import com.effective.android.panel.interfaces.listener.OnEditFocusChangeListener;
import com.effective.android.panel.interfaces.listener.OnPanelChangeListener;
import com.effective.android.panel.view.panel.IPanelView;
import com.effective.android.panel.view.panel.PanelView;
import com.google.gson.Gson;
import com.m7.imkfsdk.KfStartHelper;
import com.m7.imkfsdk.MoorWebCenter;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.adapter.ChatAdapter;
import com.m7.imkfsdk.chat.adapter.ChatTagLabelsAdapter;
import com.m7.imkfsdk.chat.dialog.BottomSheetLogisticsInfoDialog;
import com.m7.imkfsdk.chat.dialog.BottomSheetLogisticsProgressDialog;
import com.m7.imkfsdk.chat.dialog.BottomTabQuestionDialog;
import com.m7.imkfsdk.chat.dialog.BottomXbotFormDialog;
import com.m7.imkfsdk.chat.dialog.CommonBottomSheetDialog;
import com.m7.imkfsdk.chat.dialog.InvestigateDialog;
import com.m7.imkfsdk.chat.dialog.LoadingFragmentDialog;
import com.m7.imkfsdk.chat.emotion.EmotionPagerView;
import com.m7.imkfsdk.chat.emotion.Emotions;
import com.m7.imkfsdk.chat.listener.OnCancelDialogListener;
import com.m7.imkfsdk.chat.listener.SubmitPingjiaListener;
import com.m7.imkfsdk.chat.model.CommonQuestionBean;
import com.m7.imkfsdk.chat.model.MsgTaskBean;
import com.m7.imkfsdk.chat.model.MsgTaskItemBean;
import com.m7.imkfsdk.chat.model.OrderBaseBean;
import com.m7.imkfsdk.chat.model.OrderInfoBean;
import com.m7.imkfsdk.chat.model.OrderInfoParams;
import com.m7.imkfsdk.recordbutton.AudioRecorderButton;
import com.m7.imkfsdk.utils.FileUtils;
import com.m7.imkfsdk.utils.PickUtils;
import com.m7.imkfsdk.utils.RegexUtils;
import com.m7.imkfsdk.utils.ToastUtils;
import com.m7.imkfsdk.utils.permission.PermissionConstants;
import com.m7.imkfsdk.utils.permission.PermissionXUtil;
import com.m7.imkfsdk.utils.permission.callback.OnRequestCallback;
import com.m7.imkfsdk.utils.statusbar.StatusBarUtils;
import com.m7.imkfsdk.view.BottomSheetVideoOrVoiceDialog;
import com.m7.imkfsdk.view.ChatListView;
import com.m7.imkfsdk.view.SpaceItemDecoration;
import com.moor.imkf.IMChat;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.IMMessage;
import com.moor.imkf.YKFConstants;
import com.moor.imkf.db.dao.GlobalSetDao;
import com.moor.imkf.db.dao.InfoDao;
import com.moor.imkf.db.dao.MessageDao;
import com.moor.imkf.event.MsgEvent;
import com.moor.imkf.event.MsgunReadToReadEvent;
import com.moor.imkf.event.ReSendMessage;
import com.moor.imkf.event.TcpBreakEvent;
import com.moor.imkf.event.TransferAgent;
import com.moor.imkf.event.UnAssignEvent;
import com.moor.imkf.event.VoiceToTextEvent;
import com.moor.imkf.event.XbotFormEvent;
import com.moor.imkf.http.HttpManager;
import com.moor.imkf.lib.socket.websocket.WebSocketHandler;
import com.moor.imkf.lib.utils.MoorAntiShakeUtils;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.lib.utils.MoorNullUtil;
import com.moor.imkf.listener.AcceptOtherAgentListener;
import com.moor.imkf.listener.ChatListener;
import com.moor.imkf.listener.HttpResponseListener;
import com.moor.imkf.listener.OnConvertManualListener;
import com.moor.imkf.listener.onResponseListener;
import com.moor.imkf.model.construct.JsonBuild;
import com.moor.imkf.model.entity.CardInfo;
import com.moor.imkf.model.entity.FlowBean;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.entity.GlobalSet;
import com.moor.imkf.model.entity.MoorFastBtnBean;
import com.moor.imkf.model.entity.NewCardInfo;
import com.moor.imkf.model.entity.XbotForm;
import com.moor.imkf.model.entity.YKFCallInfoBean;
import com.moor.imkf.model.parser.HttpParser;
import com.moor.imkf.utils.MoorUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.bugly.Bugly;
import com.xiaomi.mipush.sdk.Constants;
import e.j.e.t.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import k.c.a.c;
import k.c.a.l;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ChatActivity extends KFBaseActivity implements View.OnClickListener, ChatListView.OnRefreshListener, AudioRecorderButton.RecorderFinishListener {
    private static final int HANDLER_BREAK = 2184;
    private static final int HANDLER_BREAK_TIP = 2457;
    private static final int HANDLER_CLIAM = 1638;
    private static final int HANDLER_FINISH = 1911;
    private static final int HANDLER_INVESTIGATE = 1092;
    private static final int HANDLER_LEAVEMSG = 4352;
    private static final int HANDLER_MSG = 1;
    private static final int HANDLER_MSG_MORE = 2;
    private static final int HANDLER_NO_WRITING = 4864;
    private static final int HANDLER_OFFNLINE = 819;
    private static final int HANDLER_ONLINE = 546;
    private static final int HANDLER_QUEUENUM = 1365;
    private static final int HANDLER_ROBOT = 273;
    private static final int HANDLER_VIPASSIGNFAIL = 4096;
    private static final int HANDLER_WRITING = 4608;
    private static final int PICK_FILE_ACTIVITY_REQUEST_CODE = 300;
    private static final int PICK_IMAGE_ACTIVITY_REQUEST_CODE = 200;
    public static boolean isCustomerRead = false;
    private static final String tag = "ChatActivity";
    public LinearLayout bar_bottom;
    public BreakTimerTask breakTimerTask;
    public BreakTipTimerTask breakTipTimerTask;
    public Timer break_timer;
    public Timer break_tip_timer;
    public String break_tips;
    private ChatAdapter chatAdapter;
    public LinearLayout chat_queue_ll;
    public TextView chat_queue_tv;
    public ImageView chat_tv_back;
    public TextView chat_tv_convert;
    private DelaySendTask delaySendTask;
    private InvestigateDialog dialog;
    private String exten;
    private List<FromToMessage> fromToMessage;
    private ChatHandler handler;
    private View header;
    private String id;
    private ImageView ivDeleteEmoji;
    public KeFuStatusReceiver keFuStatusReceiver;
    private String left_text;
    private LinearLayout ll_bottom_intercept;
    private LinearLayout ll_hintView;
    private LinearLayout ll_invite;
    private LoadingFragmentDialog loadingDialog;
    private RelativeLayout mChatEdittextLayout;
    private ImageView mChatEmojiNormal;
    private EditText mChatInput;
    private ChatListView mChatList;
    private ImageView mChatMore;
    private TextView mChatSend;
    private Button mChatSetModeKeyboard;
    private Button mChatSetModeVoice;
    private CountDownTimer mCountDownTimer;
    private PanelSwitchHelper mHelper;
    private TextView mOtherName;
    private AudioRecorderButton mRecorderButton;
    private BottomSheetLogisticsInfoDialog moreOrderInfoDialog;
    public MsgReceiver msgReceiver;
    private EmotionPagerView pagerView;
    private String picFileFullName;
    private ArrayList<CommonQuestionBean> questionList;
    private LinearLayout rl_bottom;
    private RecyclerView rvTagLabel;
    private boolean sdkTypeNoticeFlag;
    private boolean showInviteButton;
    private boolean showQuestionButton;
    private SharedPreferences spData;
    private ChatTagLabelsAdapter tagLabeAdapter;
    private String userIcon;
    private String userName;
    private boolean isFront = false;
    private boolean isListBottom = false;
    private Boolean JZflag = Boolean.TRUE;
    private boolean isZXResply = false;
    private int pageSize = 2;
    private List<FromToMessage> descFromToMessage = new ArrayList();
    private String peerId = "";
    private boolean show_emoji = true;
    private boolean isRobot = false;
    private String type = "";
    private String scheduleId = "";
    private String processId = "";
    private String currentNodeId = "";
    private String schedule_id = "";
    private String schedule_topeer = "";
    private String processType = "";
    private String titleName = "";
    private String entranceId = "";
    private boolean NotAllowCustomerPushCsr = false;
    private boolean NotAllowCustomerCloseCsr = false;
    private Boolean robotEvaluationFinish = Boolean.FALSE;
    private boolean hasSendRobotMsg = false;
    private boolean hasSendPersonMsg = false;
    private boolean isQueue = false;
    private boolean isInvestigate = true;
    private boolean convesationIsLive = true;
    private boolean hasSet = true;
    private boolean conversationOver = false;
    private boolean INVITATION_INVESTIGATE = false;
    private List<FlowBean> flowBeanList = new ArrayList();
    public long breakTime = 0;
    public long breakTipTime = 0;
    private Set<String> mHashSet = new HashSet();
    private String chatId = "";
    private int unfilledHeight = 0;

    /* loaded from: classes2.dex */
    public class BreakTimerTask extends TimerTask {
        public BreakTimerTask() {
            ChatActivity.this = r1;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ChatActivity.this.handler.sendEmptyMessage(ChatActivity.HANDLER_BREAK);
            ChatActivity.this.break_timer.cancel();
            HttpManager.getChatclientAutoClose(ChatActivity.this.chatId, null);
        }
    }

    /* loaded from: classes2.dex */
    public class BreakTipTimerTask extends TimerTask {
        public BreakTipTimerTask() {
            ChatActivity.this = r1;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ChatActivity.this.handler.sendEmptyMessage(ChatActivity.HANDLER_BREAK_TIP);
            ChatActivity.this.break_tip_timer.cancel();
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private String PeerId;
        private CardInfo cardInfo;
        private String currentNodeId;
        private String entranceId;
        private NewCardInfo newCardInfo;
        private String processId;
        private String processType;
        private String scheduleId;
        private String type;

        public Intent build(Context context) {
            if (!TextUtils.isEmpty(this.type)) {
                if (YKFConstants.TYPE_PEER.equals(this.type)) {
                    if (TextUtils.isEmpty(this.PeerId)) {
                        ToastUtils.showShort(context, "ErrorCode1007");
                        MoorLogUtils.eTag("ErrorCode1007", "1007:进入会话也没有携带技能组id");
                        IMChatManager.getInstance().quitSDk();
                        return null;
                    }
                } else if (YKFConstants.TYPE_SCHEDULE.equals(this.type) && (TextUtils.isEmpty(this.scheduleId) || TextUtils.isEmpty(this.processId) || TextUtils.isEmpty(this.currentNodeId))) {
                    ToastUtils.showShort(context, "ErrorCode1008");
                    MoorLogUtils.eTag("ErrorCode1008", "1008:进入会话没有携带日程所需字段");
                    IMChatManager.getInstance().quitSDk();
                    return null;
                }
                IMChatManager.getInstance().cancelInitTimer();
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("type", this.type);
                intent.putExtra("scheduleId", this.scheduleId);
                intent.putExtra("processId", this.processId);
                intent.putExtra("currentNodeId", this.currentNodeId);
                intent.putExtra("processType", this.processType);
                intent.putExtra("entranceId", this.entranceId);
                intent.putExtra("PeerId", this.PeerId);
                intent.setFlags(268435456);
                context.startActivity(intent);
                return intent;
            }
            ToastUtils.showShort(context, "ErrorCode1009");
            MoorLogUtils.eTag("ErrorCode1009", "1009:进入会话没有携带会话类型");
            IMChatManager.getInstance().quitSDk();
            return null;
        }

        public Builder setCardInfo(CardInfo cardInfo) {
            this.cardInfo = cardInfo;
            if (cardInfo != null) {
                FromToMessage fromToMessage = new FromToMessage();
                fromToMessage.msgType = FromToMessage.MSG_TYPE_CARD;
                fromToMessage.cardInfo = JsonBuild.getCardInfo(cardInfo);
                fromToMessage.userType = "0";
                fromToMessage.when = Long.valueOf(System.currentTimeMillis());
                MoorLogUtils.aTag("cardinfo==", JsonBuild.getCardInfo(cardInfo));
                MessageDao.getInstance().insertSendMsgsToDao(fromToMessage);
            }
            return this;
        }

        public Builder setCurrentNodeId(String str) {
            this.currentNodeId = str;
            return this;
        }

        public Builder setEntranceId(String str) {
            this.entranceId = str;
            return this;
        }

        public Builder setNewCardInfo(NewCardInfo newCardInfo) {
            this.newCardInfo = newCardInfo;
            if (newCardInfo != null) {
                FromToMessage fromToMessage = new FromToMessage();
                fromToMessage.msgType = FromToMessage.MSG_TYPE_NEW_CARD;
                fromToMessage.newCardInfo = new Gson().z(newCardInfo);
                fromToMessage.userType = "0";
                fromToMessage.when = Long.valueOf(System.currentTimeMillis());
                MoorLogUtils.aTag("newCardInfo==", new Gson().z(newCardInfo));
                MessageDao.getInstance().insertSendMsgsToDao(fromToMessage);
            }
            return this;
        }

        public Builder setPeerId(String str) {
            this.PeerId = str;
            if (str != null && !"".equals(str)) {
                InfoDao.getInstance().updataPeedID(str);
            }
            return this;
        }

        public Builder setProcessId(String str) {
            this.processId = str;
            return this;
        }

        public Builder setProcessType(String str) {
            this.processType = str;
            return this;
        }

        public Builder setScheduleId(String str) {
            this.scheduleId = str;
            return this;
        }

        public Builder setType(String str) {
            this.type = str;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class ChatHandler extends Handler {
        public StringBuilder fullResult = new StringBuilder();
        private final WeakReference<ChatActivity> mActivty;

        public ChatHandler(ChatActivity chatActivity) {
            this.mActivty = new WeakReference<>(chatActivity);
        }

        public void clearResult() {
            this.fullResult = new StringBuilder();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            ChatActivity chatActivity = this.mActivty.get();
            if (chatActivity != null) {
                chatActivity.handleMessage(message, this.fullResult);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class DelaySendTask implements Runnable {
        private boolean canceled;
        private String mText;

        private DelaySendTask() {
            ChatActivity.this = r1;
            this.canceled = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.canceled) {
                return;
            }
            ChatActivity.this.sendTypingStatus(this.mText);
        }

        public DelaySendTask setCanceled(boolean z) {
            this.canceled = z;
            return this;
        }

        public DelaySendTask setText(String str) {
            this.mText = str;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public class GetLianXiangDataResponeHandler implements HttpResponseListener {
        private GetLianXiangDataResponeHandler() {
            ChatActivity.this = r1;
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
            ChatActivity.this.ll_hintView.setVisibility(8);
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
            System.out.println(str);
            String succeed = HttpParser.getSucceed(str);
            if (TextUtils.isEmpty(ChatActivity.this.mChatInput.getText().toString().trim()) || !"true".equals(succeed)) {
                ChatActivity.this.ll_hintView.setVisibility(8);
                return;
            }
            ChatActivity.this.ll_hintView.removeAllViews();
            try {
                JSONObject jSONObject = new JSONObject(str);
                final JSONArray jSONArray = jSONObject.getJSONArray("questions");
                String string = jSONObject.getString("keyword");
                if (jSONArray.length() > 0) {
                    ChatActivity.this.ll_hintView.setVisibility(0);
                    for (final int i2 = 0; i2 < jSONArray.length(); i2++) {
                        View inflate = View.inflate(ChatActivity.this, R.layout.ykfsdk_item_hint_view, null);
                        TextView textView = (TextView) inflate.findViewById(R.id.tv_hintView);
                        if (TextUtils.isEmpty(string)) {
                            textView.setText(jSONArray.getString(i2));
                        } else {
                            textView.setText(RegexUtils.matchSearchText(-65536, jSONArray.getString(i2), string));
                        }
                        textView.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.GetLianXiangDataResponeHandler.1
                            {
                                GetLianXiangDataResponeHandler.this = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                try {
                                    if (!MoorUtils.isNetWorkConnected(IMChatManager.getInstance().getAppContext()) && !WebSocketHandler.getDefault().isConnect()) {
                                        Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(R.string.ykfsdk_ykf_not_netwokr_error), 0).show();
                                        ChatActivity.this.startReStartDialog3();
                                    } else if (IMChatManager.getInstance().isFinishWhenReConnect) {
                                        ChatActivity.this.startReStartDialog();
                                    } else {
                                        ChatActivity.this.sendTextMsg(jSONArray.getString(i2));
                                        ChatActivity.this.mChatInput.setText("");
                                        ChatActivity.this.ll_hintView.setVisibility(8);
                                    }
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        });
                        ChatActivity.this.ll_hintView.addView(inflate);
                    }
                    return;
                }
                ChatActivity.this.ll_hintView.setVisibility(8);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class KeFuStatusReceiver extends BroadcastReceiver {
        public KeFuStatusReceiver() {
            ChatActivity.this = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (IMChatManager.ROBOT_ACTION.equals(action)) {
                ChatActivity.this.handler.sendEmptyMessage(273);
            } else if (IMChatManager.ONLINE_ACTION.equals(action)) {
                ChatActivity.this.handler.sendEmptyMessage(546);
            } else if (IMChatManager.OFFLINE_ACTION.equals(action)) {
                ChatActivity.this.handler.sendEmptyMessage(ChatActivity.HANDLER_OFFNLINE);
            } else if (IMChatManager.INVESTIGATE_ACTION.equals(action)) {
                ChatActivity.this.chatId = intent.getStringExtra("chatId");
                ChatActivity.this.handler.sendEmptyMessage(ChatActivity.HANDLER_INVESTIGATE);
            } else if (IMChatManager.QUEUENUM_ACTION.equals(action)) {
                if (intent.getStringExtra(IMChatManager.QUEUENUM_ACTION) != null) {
                    String stringExtra = intent.getStringExtra(IMChatManager.QUEUENUM_ACTION);
                    Message obtain = Message.obtain();
                    obtain.what = ChatActivity.HANDLER_QUEUENUM;
                    obtain.obj = stringExtra;
                    ChatActivity.this.handler.sendMessage(obtain);
                }
            } else if (IMChatManager.CLIAM_ACTION.equals(action)) {
                ChatActivity.this.handler.sendEmptyMessage(ChatActivity.HANDLER_CLIAM);
            } else if (IMChatManager.LEAVEMSG_ACTION.equals(action)) {
                ChatActivity.this.schedule_id = intent.getStringExtra("_id");
                ChatActivity.this.schedule_topeer = intent.getStringExtra(IMChatManager.CONSTANT_TOPEER);
                ChatActivity.this.handler.sendEmptyMessage(4352);
            } else if (IMChatManager.FINISH_ACTION.equals(action)) {
                ChatActivity.this.handler.sendEmptyMessage(ChatActivity.HANDLER_FINISH);
            } else if (IMChatManager.USERINFO_ACTION.equals(action)) {
                String stringExtra2 = intent.getStringExtra("type");
                ChatActivity.this.exten = intent.getStringExtra(IMChatManager.CONSTANT_EXTEN);
                ChatActivity.this.userName = intent.getStringExtra(IMChatManager.CONSTANT_USERNAME);
                ChatActivity.this.userIcon = intent.getStringExtra(IMChatManager.CONSTANT_USERICON);
                if ("claim".equals(stringExtra2)) {
                    TextView textView = ChatActivity.this.mOtherName;
                    StringBuilder sb = new StringBuilder();
                    sb.append(MoorNullUtil.checkNull(ChatActivity.this.userName));
                    ChatActivity chatActivity = ChatActivity.this;
                    int i2 = R.string.ykfsdk_seiveceforyou;
                    sb.append(chatActivity.getString(i2));
                    textView.setText(sb.toString());
                    ChatActivity chatActivity2 = ChatActivity.this;
                    chatActivity2.titleName = MoorNullUtil.checkNull(ChatActivity.this.userName) + ChatActivity.this.getString(i2);
                }
                if ("activeClaim".equals(stringExtra2)) {
                    TextView textView2 = ChatActivity.this.mOtherName;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(MoorNullUtil.checkNull(ChatActivity.this.userName));
                    ChatActivity chatActivity3 = ChatActivity.this;
                    int i3 = R.string.ykfsdk_seiveceforyou;
                    sb2.append(chatActivity3.getString(i3));
                    textView2.setText(sb2.toString());
                    ChatActivity chatActivity4 = ChatActivity.this;
                    chatActivity4.titleName = MoorNullUtil.checkNull(ChatActivity.this.userName) + ChatActivity.this.getString(i3);
                }
                if ("redirect".equals(stringExtra2)) {
                    TextView textView3 = ChatActivity.this.mOtherName;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(MoorNullUtil.checkNull(ChatActivity.this.userName));
                    ChatActivity chatActivity5 = ChatActivity.this;
                    int i4 = R.string.ykfsdk_seiveceforyou;
                    sb3.append(chatActivity5.getString(i4));
                    textView3.setText(sb3.toString());
                    ChatActivity chatActivity6 = ChatActivity.this;
                    chatActivity6.titleName = MoorNullUtil.checkNull(ChatActivity.this.userName) + ChatActivity.this.getString(i4);
                }
                if ("robot".equals(stringExtra2)) {
                    TextView textView4 = ChatActivity.this.mOtherName;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(MoorNullUtil.checkNull(ChatActivity.this.userName));
                    ChatActivity chatActivity7 = ChatActivity.this;
                    int i5 = R.string.ykfsdk_seiveceforyou;
                    sb4.append(chatActivity7.getString(i5));
                    textView4.setText(sb4.toString());
                    ChatActivity chatActivity8 = ChatActivity.this;
                    chatActivity8.titleName = MoorNullUtil.checkNull(ChatActivity.this.userName) + ChatActivity.this.getString(i5);
                }
            } else if (IMChatManager.VIPASSIGNFAIL_ACTION.equals(action)) {
                ChatActivity.this.handler.sendEmptyMessage(4096);
            } else {
                boolean z = false;
                if (IMChatManager.CANCEL_ROBOT_ACCESS_ACTION.equals(action)) {
                    Toast.makeText(ChatActivity.this, R.string.ykfsdk_receivepeopleaction, 0).show();
                } else if (IMChatManager.WITHDRAW_ACTION.equals(action)) {
                    ChatActivity.this.handler.sendEmptyMessage(1);
                } else if (IMChatManager.WRITING_ACTION.equals(action)) {
                    ChatActivity.this.handler.sendEmptyMessage(ChatActivity.HANDLER_WRITING);
                    ChatActivity.this.handler.sendEmptyMessageDelayed(ChatActivity.HANDLER_NO_WRITING, 5000L);
                } else if (IMChatManager.ROBOT_SWITCH_ACTION.equals(action)) {
                    intent.getStringExtra(IMChatManager.CONSTANT_ROBOT_SWITCH);
                    intent.getStringExtra(IMChatManager.CONSTANT_SESSIONID);
                } else if (IMChatManager.TCP_ACTION.equals(action)) {
                    intent.getStringExtra(IMChatManager.TCPSTATUS);
                } else if (IMChatManager.ZXMSG_ACTION.equals(action)) {
                    if (ChatActivity.this.isZXResply) {
                        return;
                    }
                    ChatActivity.this.OnlycheckConverstaion();
                } else if (IMChatManager.ZXMSG_OLD_ACTION.equals(action)) {
                    ChatActivity.this.isZXResply = true;
                    ChatActivity.this.setChatMoreList();
                } else if (IMChatManager.VIDEO_INVITED_ACTION.equals(action)) {
                    String stringExtra3 = intent.getStringExtra(IMChatManager.CONSTANT_VIDEO_ROOMNAME);
                    String stringExtra4 = intent.getStringExtra(IMChatManager.CONSTANT_VIDEO_VIDEO_TYPE);
                    if (!TextUtils.isEmpty(stringExtra4) && stringExtra4.equals("video")) {
                        z = true;
                    }
                    YKFCallInfoBean yKFCallInfoBean = new YKFCallInfoBean();
                    yKFCallInfoBean.setUserName(ChatActivity.this.userName).setUserIcon(ChatActivity.this.userIcon).setRoomId(stringExtra3).setVideo(z).setPassword(intent.getStringExtra(IMChatManager.CONSTANT_VIDEO_PASSWORD)).setVideoType(stringExtra4).setExten(ChatActivity.this.exten);
                    YKFCallHelper.receivedCall(yKFCallInfoBean);
                } else if (IMChatManager.VIDEO_PC_HANGUP_ACTION.equals(action)) {
                    if (YKFCallHelper.existVideo()) {
                        YKFCallHelper.leave(true);
                    }
                } else if (IMChatManager.STOP_TIMER.equals(action)) {
                    ChatActivity.this.cancelTimer();
                } else if (IMChatManager.START_TIMER.equals(action)) {
                    ChatActivity.this.resetBreakTimer();
                } else if (IMChatManager.VIDEO_PC_CANCEL_ACTION.equals(action)) {
                    YKFCallHelper.setInvitedIntentNull();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class MsgReceiver extends BroadcastReceiver {
        public MsgReceiver() {
            ChatActivity.this = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ChatActivity.this.handler.sendEmptyMessage(1);
        }
    }

    public void OnlycheckConverstaion() {
        HttpManager.getChatSession(new HttpResponseListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.15
            {
                ChatActivity.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str) {
                MoorLogUtils.eTag("huihua", str);
                try {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
                    if (jSONObject != null) {
                        ChatActivity.this.convesationIsLive = true;
                        ChatActivity.this.id = jSONObject.getString("_id");
                        if (!jSONObject.has("replyMsgCount")) {
                            ChatActivity.this.isZXResply = false;
                        } else if (jSONObject.getInt("replyMsgCount") > 0) {
                            ChatActivity.this.isZXResply = true;
                        } else {
                            ChatActivity.this.isZXResply = false;
                        }
                    } else {
                        ChatActivity.this.convesationIsLive = false;
                    }
                    ChatActivity.this.setChatMoreList();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                ChatActivity.this.setChatMoreList();
            }
        });
    }

    private void beginChatSession() {
        if (this.type.equals(YKFConstants.TYPE_PEER)) {
            beginSession(this.peerId);
        }
        if (this.type.equals(YKFConstants.TYPE_SCHEDULE)) {
            beginScheduleSession(this.scheduleId, this.processId, this.currentNodeId, this.entranceId);
        }
    }

    private void beginScheduleSession(String str, String str2, String str3, String str4) {
        if (IMChatManager.getInstance().getAppContext() == null) {
            return;
        }
        String userOtherParams = IMChatManager.getInstance().getUserOtherParams();
        IMChatManager.userId = InfoDao.getInstance().getUserId();
        HttpManager.beginNewScheduleChatSession(InfoDao.getInstance().getConnectionId(), IMChatManager.getInstance().getIsNewVisitor(), str, str2, str3, str4, userOtherParams, getResponseListener(false));
    }

    private void beginSession(String str) {
        if (IMChatManager.getInstance().getAppContext() == null) {
            return;
        }
        String userOtherParams = IMChatManager.getInstance().getUserOtherParams();
        IMChatManager.userId = InfoDao.getInstance().getUserId();
        HttpManager.beginNewChatSession(InfoDao.getInstance().getConnectionId(), IMChatManager.getInstance().getIsNewVisitor(), str, userOtherParams, getResponseListener(true));
    }

    public void cancelTimer() {
        Timer timer = this.break_timer;
        if (timer != null) {
            timer.cancel();
            this.break_timer = null;
        }
        Timer timer2 = this.break_tip_timer;
        if (timer2 != null) {
            timer2.cancel();
            this.break_tip_timer = null;
        }
        BreakTimerTask breakTimerTask = this.breakTimerTask;
        if (breakTimerTask != null) {
            breakTimerTask.cancel();
        }
        BreakTipTimerTask breakTipTimerTask = this.breakTipTimerTask;
        if (breakTipTimerTask != null) {
            breakTipTimerTask.cancel();
        }
    }

    private void checkConverstaion() {
        HttpManager.getChatSession(new HttpResponseListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.16
            {
                ChatActivity.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str) {
                MoorLogUtils.dTag("huihua", str);
                try {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
                    if (jSONObject != null) {
                        ChatActivity.this.convesationIsLive = true;
                        ChatActivity.this.id = jSONObject.getString("_id");
                        if (!jSONObject.has("replyMsgCount")) {
                            ChatActivity.this.isZXResply = false;
                        } else if (jSONObject.getInt("replyMsgCount") > 0) {
                            ChatActivity.this.isZXResply = true;
                        } else {
                            ChatActivity.this.isZXResply = false;
                        }
                        HttpManager.checkIsAppraised(ChatActivity.this.id, new HttpResponseListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.16.1
                            {
                                AnonymousClass16.this = this;
                            }

                            @Override // com.moor.imkf.listener.HttpResponseListener
                            public void onFailed() {
                            }

                            @Override // com.moor.imkf.listener.HttpResponseListener
                            public void onSuccess(String str2) {
                                try {
                                    ChatActivity.this.isInvestigate = new JSONObject(str2).getBoolean("isInvestigate");
                                    ChatActivity.this.setChatMoreList();
                                } catch (JSONException e2) {
                                    ToastUtils.showShort(ChatActivity.this, e2.toString());
                                }
                                MoorLogUtils.eTag("piangjia", str2);
                            }
                        });
                        return;
                    }
                    ChatActivity.this.convesationIsLive = false;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    private void checkImCsrTimeout(final String str, final FromToMessage fromToMessage, final boolean z, String str2, String str3) {
        LoadingFragmentDialog loadingFragmentDialog = this.loadingDialog;
        if (loadingFragmentDialog != null) {
            loadingFragmentDialog.show(getFragmentManager(), "");
        }
        IMChatManager.getInstance().checkImCsrTimeout(str2, str3, new onResponseListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.11
            {
                ChatActivity.this = this;
            }

            @Override // com.moor.imkf.listener.onResponseListener
            public void onFailed() {
                ChatActivity chatActivity = ChatActivity.this;
                ToastUtils.showShort(chatActivity, chatActivity.getString(R.string.ykfsdk_ykf_httpfun_error));
                if (ChatActivity.this.loadingDialog != null) {
                    ChatActivity.this.loadingDialog.dismiss();
                }
            }

            @Override // com.moor.imkf.listener.onResponseListener
            public void onSuccess() {
                if (ChatActivity.this.loadingDialog != null) {
                    ChatActivity.this.loadingDialog.dismiss();
                }
                ChatActivity.this.showInvestigateDialog(false, str, fromToMessage, z);
            }

            @Override // com.moor.imkf.listener.onResponseListener
            public void onTimeOut() {
                ChatActivity chatActivity = ChatActivity.this;
                ToastUtils.showShort(chatActivity, chatActivity.getString(R.string.ykfsdk_ykf_evaluation_timeout));
                if (ChatActivity.this.loadingDialog != null) {
                    ChatActivity.this.loadingDialog.dismiss();
                }
            }
        });
    }

    public void dealAddMoreViewClickEvent(PanelView panelView) {
        this.ll_invite = (LinearLayout) panelView.findViewById(R.id.ll_invite);
        LinearLayout linearLayout = (LinearLayout) panelView.findViewById(R.id.ll_question);
        LinearLayout linearLayout2 = (LinearLayout) panelView.findViewById(R.id.ll_video);
        ((LinearLayout) panelView.findViewById(R.id.ll_photo)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.35
            {
                ChatActivity.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PermissionXUtil.checkPermission(ChatActivity.this, new OnRequestCallback() { // from class: com.m7.imkfsdk.chat.ChatActivity.35.1
                    {
                        AnonymousClass35.this = this;
                    }

                    @Override // com.m7.imkfsdk.utils.permission.callback.OnRequestCallback
                    public void requestSuccess() {
                        if (!MoorUtils.isNetWorkConnected(IMChatManager.getInstance().getAppContext()) && !WebSocketHandler.getDefault().isConnect()) {
                            Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(R.string.ykfsdk_ykf_not_netwokr_error), 0).show();
                            MoorLogUtils.aTag("chat_morebreak", new Object[0]);
                            ChatActivity.this.startReStartDialog3();
                            return;
                        }
                        ChatActivity.this.openAlbum();
                    }
                }, PermissionConstants.STORE);
            }
        });
        ((LinearLayout) panelView.findViewById(R.id.ll_file)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.36
            {
                ChatActivity.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PermissionXUtil.checkPermission(ChatActivity.this, new OnRequestCallback() { // from class: com.m7.imkfsdk.chat.ChatActivity.36.1
                    {
                        AnonymousClass36.this = this;
                    }

                    @Override // com.m7.imkfsdk.utils.permission.callback.OnRequestCallback
                    public void requestSuccess() {
                        if (MoorUtils.isNetWorkConnected(IMChatManager.getInstance().getAppContext()) || WebSocketHandler.getDefault().isConnect()) {
                            ChatActivity.this.openFile();
                            return;
                        }
                        Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(R.string.ykfsdk_ykf_not_netwokr_error), 0).show();
                        MoorLogUtils.aTag("chat_morebreak", new Object[0]);
                        ChatActivity.this.startReStartDialog3();
                    }
                }, PermissionConstants.STORE);
            }
        });
        this.ll_invite.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.37
            {
                ChatActivity.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!MoorUtils.isNetWorkConnected(IMChatManager.getInstance().getAppContext()) && !WebSocketHandler.getDefault().isConnect()) {
                    Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(R.string.ykfsdk_ykf_not_netwokr_error), 0).show();
                    MoorLogUtils.aTag("chat_morebreak", new Object[0]);
                    ChatActivity.this.startReStartDialog3();
                    return;
                }
                ChatActivity.this.openInvestigateDialog(true, YKFConstants.INVESTIGATE_TYPE_IN, null, false);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.38
            {
                ChatActivity.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!MoorUtils.isNetWorkConnected(IMChatManager.getInstance().getAppContext()) && !WebSocketHandler.getDefault().isConnect()) {
                    Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(R.string.ykfsdk_ykf_not_netwokr_error), 0).show();
                    MoorLogUtils.aTag("chat_morebreak", new Object[0]);
                    ChatActivity.this.startReStartDialog3();
                    return;
                }
                ChatActivity.this.startActivity(new Intent(ChatActivity.this, CommonQuestionsActivity.class));
            }
        });
        LinearLayout linearLayout3 = this.ll_invite;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(this.showInviteButton ? 0 : 8);
        }
        linearLayout.setVisibility(this.showQuestionButton ? 0 : 8);
        boolean equals = "1".equals(MoorNullUtil.checkNull(GlobalSetDao.getInstance().getGlobalSet().mobileVideoChat));
        boolean equals2 = "1".equals(MoorNullUtil.checkNull(GlobalSetDao.getInstance().getGlobalSet().mobileVideoChatIm));
        if (equals && equals2) {
            try {
                Class.forName(YKFCallHelper.YKFCALLMANAGER_CLASS);
                linearLayout2.setVisibility(0);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                linearLayout2.setVisibility(8);
            }
        } else {
            linearLayout2.setVisibility(8);
        }
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.39
            {
                ChatActivity.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (IMChatManager.getInstance().isManual) {
                    PermissionXUtil.checkPermission(ChatActivity.this, new OnRequestCallback() { // from class: com.m7.imkfsdk.chat.ChatActivity.39.1
                        {
                            AnonymousClass39.this = this;
                        }

                        @Override // com.m7.imkfsdk.utils.permission.callback.OnRequestCallback
                        public void requestSuccess() {
                            if (MoorUtils.isNetWorkConnected(IMChatManager.getInstance().getAppContext()) || WebSocketHandler.getDefault().isConnect()) {
                                ChatActivity.this.openVideo();
                                return;
                            }
                            Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(R.string.ykfsdk_ykf_not_netwokr_error), 0).show();
                            MoorLogUtils.aTag("chat_morebreak", new Object[0]);
                            ChatActivity.this.startReStartDialog3();
                        }
                    }, PermissionConstants.CAMERA, PermissionConstants.RECORD_AUDIO);
                    return;
                }
                ChatActivity chatActivity = ChatActivity.this;
                ToastUtils.showShort(chatActivity, chatActivity.getString(R.string.ykfsdk_ykf_starting_video_tips));
            }
        });
    }

    public void dealLogOut() {
        this.NotAllowCustomerCloseCsr = this.spData.getBoolean(YKFConstants.NOT_ALLOW_CUSTOMERCLOSECSR, false);
        if (!this.isRobot && IMChatManager.getInstance().isInvestigateOn() && this.convesationIsLive && this.hasSendPersonMsg && this.isZXResply && this.isInvestigate && this.hasSet && !this.conversationOver && !this.NotAllowCustomerCloseCsr) {
            showInvestigateDialog(true, YKFConstants.INVESTIGATE_TYPE_IN, null, false);
        } else {
            IMChatManager.getInstance().quitSDk();
            finish();
        }
        IMChatManager.getInstance().setIsShowBottomList(false);
    }

    private void getInvestigateTime() {
        IMChatManager.getInstance().getServerTime(null);
    }

    public void getIsGoSchedule() {
        if (!isFinishing()) {
            KfStartHelper.getInstance().getIsGoSchedule(this, YKFConstants.FROMCHAT);
        } else {
            ToastUtils.showShort(this, getString(R.string.ykfsdk_ykf_chatactivity_isfinish));
        }
    }

    private void getMainQuestions() {
        HttpManager.getTabCommonQuestions(new HttpResponseListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.41
            {
                ChatActivity.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
                ChatActivity.this.showOrHideQuestionButton(false);
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str) {
                try {
                    JSONArray jSONArray = new JSONObject(str).getJSONArray("catalogList");
                    if (jSONArray.length() > 0) {
                        ChatActivity.this.questionList = new ArrayList();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            CommonQuestionBean commonQuestionBean = new CommonQuestionBean();
                            commonQuestionBean.setTabContent(jSONObject.getString("name"));
                            commonQuestionBean.setTabId(jSONObject.getString("_id"));
                            ChatActivity.this.questionList.add(commonQuestionBean);
                        }
                    }
                    ChatActivity.this.showOrHideQuestionButton(jSONArray.length() > 0);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public HttpResponseListener getResponseListener(boolean z) {
        return new HttpResponseListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.17
            {
                ChatActivity.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
                IMChatManager.getInstance().isIniting = false;
                if (ChatActivity.this.loadingDialog != null) {
                    ChatActivity.this.loadingDialog.dismiss();
                }
                ChatActivity chatActivity = ChatActivity.this;
                ToastUtils.showShort(chatActivity, chatActivity.getString(R.string.ykfsdk_ykf_chatbegin_fail));
                ChatActivity.this.finish();
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str) {
                MoorLogUtils.aTag("开始会话", str);
                IMChatManager.getInstance().isIniting = false;
                if (ChatActivity.this.loadingDialog != null) {
                    ChatActivity.this.loadingDialog.dismiss();
                }
                if (!"true".equals(HttpParser.getSucceed(str))) {
                    if (ChatActivity.this.loadingDialog != null) {
                        ChatActivity.this.loadingDialog.dismiss();
                    }
                    ChatActivity chatActivity = ChatActivity.this;
                    ToastUtils.showShort(chatActivity, chatActivity.getString(R.string.ykfsdk_ykf_chatbegin_fail));
                    ChatActivity.this.finish();
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        JSONObject jSONObject2 = jSONObject.getJSONObject("Config");
                        if (jSONObject2.has(YKFConstants.SYSTEMMSGLOGO)) {
                            ChatActivity.this.spData.edit().putString(YKFConstants.SYSTEMMSGLOGO, jSONObject2.getString(YKFConstants.SYSTEMMSGLOGO)).apply();
                            MoorLogUtils.dTag("systemMsgLogo=", ChatActivity.this.spData.getString(YKFConstants.SYSTEMMSGLOGO, ""));
                        }
                        IMChatManager.getInstance().setIsInvestigateOn(jSONObject2.getBoolean("webchat_csr"));
                        boolean z2 = jSONObject2.getBoolean("showTransferBtn");
                        IMChatManager.getInstance().setIsShowTransferBtn(z2);
                        MoorLogUtils.dTag("handleMessage==", "getResponseListener====showTransferBtn===" + z2);
                        ChatActivity chatActivity2 = ChatActivity.this;
                        chatActivity2.chat_tv_convert.setVisibility((chatActivity2.isRobot && z2) ? 0 : 8);
                        if (!jSONObject.has("bottomList")) {
                            ChatActivity.this.rvTagLabel.setVisibility(8);
                        } else {
                            IMChatManager.getInstance().setIsShowBottomList(true);
                            JSONArray jSONArray = jSONObject.getJSONArray("bottomList");
                            IMChatManager.getInstance().setBottomList(jSONArray);
                            ChatActivity.this.rvTagLabel.setVisibility(0);
                            if (jSONArray != null) {
                                try {
                                    JSONArray bottomList = IMChatManager.getInstance().getBottomList();
                                    for (int i2 = 0; i2 < bottomList.length(); i2++) {
                                        JSONObject jSONObject3 = bottomList.getJSONObject(i2);
                                        FlowBean flowBean = new FlowBean();
                                        flowBean.setButton(jSONObject3.getString("button"));
                                        flowBean.setText(jSONObject3.getString("text"));
                                        flowBean.setButton_type(jSONObject3.optInt("button_type"));
                                        ChatActivity.this.flowBeanList.add(flowBean);
                                    }
                                    ChatActivity.this.tagLabeAdapter.refreshData(ChatActivity.this.flowBeanList);
                                } catch (Exception unused) {
                                    ChatActivity.this.rvTagLabel.setVisibility(8);
                                }
                            }
                        }
                        if (jSONObject.has("chatSession")) {
                            ChatActivity.this.chatId = jSONObject.getJSONObject("chatSession").optString("_id");
                        }
                        JSONArray optJSONArray = jSONObject.optJSONArray("quickMenu");
                        long optLong = jSONObject.optLong("quickMenuWhen");
                        if (optJSONArray != null) {
                            MessageDao.getInstance().insertSendMsgsToDao(IMMessage.createQuickMenuList(optJSONArray.toString(), optLong));
                            ChatActivity.this.updateMessage();
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                if (ChatActivity.this.loadingDialog != null) {
                    ChatActivity.this.loadingDialog.dismiss();
                }
            }
        };
    }

    private void handleLogOutOrBackPressed() {
        if (YKFCallHelper.existVideo()) {
            final CommonBottomSheetDialog instance = CommonBottomSheetDialog.instance(getString(R.string.ykfsdk_ykf_dialog_exist_video), getString(R.string.ykfsdk_ykf_determine), getString(R.string.ykfsdk_cancel));
            instance.setListener(new CommonBottomSheetDialog.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.9
                {
                    ChatActivity.this = this;
                }

                @Override // com.m7.imkfsdk.chat.dialog.CommonBottomSheetDialog.OnClickListener
                public void onClickNegative() {
                    instance.close(false);
                }

                @Override // com.m7.imkfsdk.chat.dialog.CommonBottomSheetDialog.OnClickListener
                public void onClickPositive() {
                    instance.close(false);
                    YKFCallHelper.leave(false);
                    ChatActivity.this.dealLogOut();
                }
            });
            instance.show(getSupportFragmentManager(), "");
            return;
        }
        dealLogOut();
    }

    public boolean isListViewReachBottomEdge(AbsListView absListView) {
        if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
            return absListView.getHeight() >= absListView.getChildAt(absListView.getLastVisiblePosition() - absListView.getFirstVisiblePosition()).getBottom();
        }
        return false;
    }

    public static boolean isServiceRunning(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            MoorLogUtils.aTag("runService", "服务名字是空的");
        }
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        if (runningServices.size() <= 0) {
            MoorLogUtils.aTag("runService", "服务数是0");
        }
        for (int i2 = 0; i2 < runningServices.size(); i2++) {
            if (runningServices.get(i2).service.getClassName().equals(str)) {
                MoorLogUtils.aTag("runService", "服务还活着true");
                return true;
            }
        }
        return false;
    }

    public void openFile() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        startActivityForResult(intent, 300);
    }

    private void openRobotInvestigateDialog() {
        new AlertDialog.Builder(this).setTitle(getString(R.string.ykfsdk_ykf_evaluation_robot)).setItems(new String[]{getString(R.string.ykfsdk_ykf_solved_ok), getString(R.string.ykfsdk_ykf_solved_fail), getString(R.string.ykfsdk_cancel)}, new DialogInterface.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.13
            {
                ChatActivity.this = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (i2 == 2) {
                    return;
                }
                String str = i2 == 0 ? "true" : Bugly.SDK_IS_DEV;
                if ("xbot".equals(GlobalSetDao.getInstance().getGlobalSet().robotType)) {
                    HttpManager.getRobotCsrInfo(str, new HttpResponseListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.13.1
                        {
                            AnonymousClass13.this = this;
                        }

                        @Override // com.moor.imkf.listener.HttpResponseListener
                        public void onFailed() {
                            ChatActivity.this.robotEvaluationFinish = Boolean.FALSE;
                            ChatActivity chatActivity = ChatActivity.this;
                            ToastUtils.showLong(chatActivity, chatActivity.getString(R.string.ykfsdk_ykf_robot_evaluation_fail));
                        }

                        @Override // com.moor.imkf.listener.HttpResponseListener
                        public void onSuccess(String str2) {
                            ChatActivity.this.robotEvaluationFinish = Boolean.TRUE;
                            ChatActivity chatActivity = ChatActivity.this;
                            ToastUtils.showLong(chatActivity, chatActivity.getString(R.string.ykfsdk_ykf_robot_evaluation_ok));
                            ChatActivity.this.setChatMoreList();
                        }
                    });
                } else {
                    HttpManager.getRobotCsrInfo(IMChat.getInstance().getBotId(), str, new HttpResponseListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.13.2
                        {
                            AnonymousClass13.this = this;
                        }

                        @Override // com.moor.imkf.listener.HttpResponseListener
                        public void onFailed() {
                            ChatActivity.this.robotEvaluationFinish = Boolean.FALSE;
                            ChatActivity chatActivity = ChatActivity.this;
                            ToastUtils.showLong(chatActivity, chatActivity.getString(R.string.ykfsdk_ykf_robot_evaluation_fail));
                        }

                        @Override // com.moor.imkf.listener.HttpResponseListener
                        public void onSuccess(String str2) {
                            ChatActivity.this.robotEvaluationFinish = Boolean.TRUE;
                            ChatActivity chatActivity = ChatActivity.this;
                            ToastUtils.showLong(chatActivity, chatActivity.getString(R.string.ykfsdk_ykf_robot_evaluation_ok));
                            ChatActivity.this.setChatMoreList();
                        }
                    });
                }
            }
        }).create().show();
    }

    public void openVideo() {
        final BottomSheetVideoOrVoiceDialog bottomSheetVideoOrVoiceDialog = new BottomSheetVideoOrVoiceDialog();
        bottomSheetVideoOrVoiceDialog.setOnClickListener(new BottomSheetVideoOrVoiceDialog.onClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.40
            {
                ChatActivity.this = this;
            }

            @Override // com.m7.imkfsdk.view.BottomSheetVideoOrVoiceDialog.onClickListener
            public void onClick(int i2) {
                ChatActivity.this.loadingDialog.show(ChatActivity.this.getFragmentManager(), "");
                ChatActivity.this.loadingDialog.setCanceledOnTouchOutside(true);
                YKFCallInfoBean yKFCallInfoBean = new YKFCallInfoBean();
                yKFCallInfoBean.setUserName(ChatActivity.this.userName).setUserIcon(ChatActivity.this.userIcon).setVideo(i2 == 0).setExten(ChatActivity.this.exten);
                YKFCallHelper.setOnCancelDialogListener(new OnCancelDialogListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.40.1
                    {
                        AnonymousClass40.this = this;
                    }

                    @Override // com.m7.imkfsdk.chat.listener.OnCancelDialogListener
                    public void cancelDialog() {
                        if (ChatActivity.this.loadingDialog != null) {
                            ChatActivity.this.loadingDialog.dismiss();
                        }
                    }
                });
                YKFCallHelper.openCall(yKFCallInfoBean);
                bottomSheetVideoOrVoiceDialog.close(false);
            }
        });
        bottomSheetVideoOrVoiceDialog.show(getSupportFragmentManager(), "");
    }

    private void registerRec() {
        IntentFilter intentFilter = new IntentFilter("com.m7.imkfsdk.msgreceiver");
        MsgReceiver msgReceiver = new MsgReceiver();
        this.msgReceiver = msgReceiver;
        registerReceiver(msgReceiver, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(IMChatManager.ROBOT_ACTION);
        intentFilter2.addAction(IMChatManager.ONLINE_ACTION);
        intentFilter2.addAction(IMChatManager.OFFLINE_ACTION);
        intentFilter2.addAction(IMChatManager.CLIAM_ACTION);
        intentFilter2.addAction(IMChatManager.INVESTIGATE_ACTION);
        intentFilter2.addAction(IMChatManager.QUEUENUM_ACTION);
        intentFilter2.addAction(IMChatManager.LEAVEMSG_ACTION);
        intentFilter2.addAction(IMChatManager.FINISH_ACTION);
        intentFilter2.addAction(IMChatManager.USERINFO_ACTION);
        intentFilter2.addAction(IMChatManager.VIPASSIGNFAIL_ACTION);
        intentFilter2.addAction(IMChatManager.CANCEL_ROBOT_ACCESS_ACTION);
        intentFilter2.addAction(IMChatManager.WITHDRAW_ACTION);
        intentFilter2.addAction(IMChatManager.WRITING_ACTION);
        intentFilter2.addAction(IMChatManager.ROBOT_SWITCH_ACTION);
        intentFilter2.addAction(IMChatManager.TCP_ACTION);
        intentFilter2.addAction(IMChatManager.ZXMSG_ACTION);
        intentFilter2.addAction(IMChatManager.VIDEO_INVITED_ACTION);
        intentFilter2.addAction(IMChatManager.VIDEO_ACCEPT_ACTION);
        intentFilter2.addAction(IMChatManager.VIDEO_PC_HANGUP_ACTION);
        intentFilter2.addAction(IMChatManager.VIDEO_PC_CANCEL_ACTION);
        intentFilter2.addAction(IMChatManager.VIDEO_REFUSE_ACTION);
        intentFilter2.addAction(IMChatManager.STOP_TIMER);
        intentFilter2.addAction(IMChatManager.START_TIMER);
        KeFuStatusReceiver keFuStatusReceiver = new KeFuStatusReceiver();
        this.keFuStatusReceiver = keFuStatusReceiver;
        registerReceiver(keFuStatusReceiver, intentFilter2);
    }

    public void resetBreakTimer() {
        cancelTimer();
        if (this.breakTime > 0) {
            this.break_timer = new Timer();
            BreakTimerTask breakTimerTask = new BreakTimerTask();
            this.breakTimerTask = breakTimerTask;
            this.break_timer.schedule(breakTimerTask, this.breakTime);
        }
        if (this.breakTipTime > 0) {
            this.break_tip_timer = new Timer();
            BreakTipTimerTask breakTipTimerTask = new BreakTipTimerTask();
            this.breakTipTimerTask = breakTipTimerTask;
            this.break_tip_timer.schedule(breakTipTimerTask, this.breakTipTime);
        }
        MoorLogUtils.dTag("BreakTimer", "resetBreakTimer===重置断开提示定时器");
    }

    private void scrollTop(List<FromToMessage> list) {
        this.descFromToMessage.addAll(0, list);
        this.chatAdapter.setMessageList(this.descFromToMessage);
        this.chatAdapter.notifyDataSetChanged();
        int top = this.mChatList.getTop();
        try {
            this.mChatList.onRefreshFinished();
            this.JZflag = Boolean.TRUE;
            if (list.size() > 0) {
                this.pageSize++;
            }
            this.mChatList.setSelectionFromTop(list.size(), top);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void sendMsgToServer(FromToMessage fromToMessage) {
        IMChat.getInstance().sendMessage(fromToMessage, new ChatListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.28
            {
                ChatActivity.this = this;
            }

            @Override // com.moor.imkf.listener.ChatListener
            public void onFailed(String str) {
                MoorLogUtils.eTag("SendMessage", str);
                ChatActivity.this.updateMessage();
            }

            @Override // com.moor.imkf.listener.ChatListener
            public void onProgress(int i2) {
                ChatActivity.this.updateMessage();
            }

            @Override // com.moor.imkf.listener.ChatListener
            public void onSuccess(String str) {
                ChatActivity.this.updateMessage();
            }
        });
    }

    private void sendSingleMessage(FromToMessage fromToMessage) {
        if (!MoorUtils.isNetWorkConnected(IMChatManager.getInstance().getAppContext()) && !WebSocketHandler.getDefault().isConnect()) {
            Toast.makeText(getApplicationContext(), getString(R.string.ykfsdk_ykf_not_netwokr_error), 0).show();
            MoorLogUtils.aTag("发送消息break", new Object[0]);
            startReStartDialog3();
        } else if (this.conversationOver) {
            startReStartDialog();
        } else {
            this.descFromToMessage.add(fromToMessage);
            this.chatAdapter.notifyDataSetChanged();
            scrollToBottom();
            this.mChatInput.setText("");
            resetBreakTimer();
            sendMsgToServer(fromToMessage);
        }
    }

    public void sendTypingStatus(String str) {
        if (!this.sdkTypeNoticeFlag || this.isRobot) {
            return;
        }
        HttpManager.sendTypingStatus(str, new HttpResponseListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.42
            {
                ChatActivity.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str2) {
            }
        });
    }

    public void sendVoiceAutoText(FromToMessage fromToMessage, String str, boolean z) {
        if (z) {
            fromToMessage.message = str;
            fromToMessage.msgType = "text";
            fromToMessage.isRobot = false;
        } else {
            fromToMessage.msgType = "voice";
            fromToMessage.isRobot = false;
        }
        sendMsgToServer(fromToMessage);
    }

    private void sendVoiceMsg(String str, FromToMessage fromToMessage) {
        fromToMessage.voiceText = str;
        resetBreakTimer();
        sendMsgToServer(fromToMessage);
    }

    public void setChatMoreList() {
        showOrHideInviteButton(false);
        this.NotAllowCustomerPushCsr = this.spData.getBoolean(YKFConstants.NOT_ALLOWCUSTOMER_PUSH_CSR, false);
        if (!this.isRobot && IMChatManager.getInstance().isInvestigateOn() && this.convesationIsLive && this.isZXResply && this.isInvestigate && this.hasSet && this.hasSendPersonMsg && !this.NotAllowCustomerPushCsr) {
            showOrHideInviteButton(true);
        }
        GlobalSet globalSet = GlobalSetDao.getInstance().getGlobalSet();
        if (this.isRobot && !this.robotEvaluationFinish.booleanValue() && this.hasSendRobotMsg) {
            if ("xbot".equals(globalSet.robotType)) {
                if (this.isRobot && !this.robotEvaluationFinish.booleanValue() && this.hasSendRobotMsg && IMChat.getInstance().getBotsatisfaOn()) {
                    showOrHideInviteButton(true);
                }
            } else if (IMChat.getInstance().getBotsatisfaOn()) {
                showOrHideInviteButton(true);
            }
        }
        if (this.isQueue) {
            showOrHideInviteButton(false);
        }
    }

    private void setGlobalConfig() {
        GlobalSet globalSet = GlobalSetDao.getInstance().getGlobalSet();
        if (globalSet != null) {
            isCustomerRead = globalSet.isCustomerRead;
            String str = globalSet.break_len;
            String str2 = globalSet.break_tips_len;
            this.break_tips = globalSet.break_tips;
            this.sdkTypeNoticeFlag = globalSet.sdkTypeNoticeFlag;
            try {
                this.breakTime = Integer.parseInt(str) * 60 * 1000;
                MoorLogUtils.dTag("BreakTimer", "breakTime===" + str);
            } catch (Exception unused) {
            }
            try {
                this.breakTipTime = this.breakTime - ((Integer.parseInt(str2) * 60) * 1000);
                MoorLogUtils.dTag("BreakTimer", "breakTipTime===" + str2);
            } catch (Exception unused2) {
            }
            if (this.breakTime > 0) {
                this.break_timer = new Timer();
                BreakTimerTask breakTimerTask = new BreakTimerTask();
                this.breakTimerTask = breakTimerTask;
                this.break_timer.schedule(breakTimerTask, this.breakTime);
            }
            if (this.breakTipTime > 0) {
                this.break_tip_timer = new Timer();
                BreakTipTimerTask breakTipTimerTask = new BreakTipTimerTask();
                this.breakTipTimerTask = breakTipTimerTask;
                this.break_tip_timer.schedule(breakTipTimerTask, this.breakTipTime);
            }
        }
    }

    public void showInvestigateDialog(final boolean z, final String str, final FromToMessage fromToMessage, final boolean z2) {
        if (this.hasSet) {
            InvestigateDialog investigateDialog = this.dialog;
            if (investigateDialog == null || investigateDialog.getDialog() == null || !this.dialog.getDialog().isShowing()) {
                final String str2 = fromToMessage == null ? "" : fromToMessage.chatId;
                InvestigateDialog build = new InvestigateDialog.Builder().setType(str).setConnectionId(InfoDao.getInstance().getConnectionId()).setSessionId(str2).setSubmitListener(new SubmitPingjiaListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.12
                    {
                        ChatActivity.this = this;
                    }

                    @Override // com.m7.imkfsdk.chat.listener.SubmitPingjiaListener
                    public void OnSubmitCancle() {
                        if (!z) {
                            if (ChatActivity.this.INVITATION_INVESTIGATE) {
                                IMChatManager.getInstance().getServerTime(new onResponseListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.12.2
                                    {
                                        AnonymousClass12.this = this;
                                    }

                                    @Override // com.moor.imkf.listener.onResponseListener
                                    public void onFailed() {
                                        if (str.equals(YKFConstants.INVESTIGATE_TYPE_OUT)) {
                                            AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                                            if (z2) {
                                                return;
                                            }
                                            String str3 = ChatActivity.this.chatId;
                                            String string = ChatActivity.this.spData.getString(YKFConstants.TIMEOUT, "");
                                            FromToMessage createInvestigateCancelMessage = IMMessage.createInvestigateCancelMessage(str3, string, System.currentTimeMillis() + "");
                                            MessageDao.getInstance().insertSendMsgsToDao(createInvestigateCancelMessage);
                                            ChatActivity.this.descFromToMessage.add(createInvestigateCancelMessage);
                                            ChatActivity.this.chatAdapter.notifyDataSetChanged();
                                            ChatActivity.this.scrollToBottom();
                                        }
                                    }

                                    @Override // com.moor.imkf.listener.onResponseListener
                                    public void onSuccess() {
                                        if (str.equals(YKFConstants.INVESTIGATE_TYPE_OUT)) {
                                            AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                                            if (z2) {
                                                return;
                                            }
                                            FromToMessage createInvestigateCancelMessage = IMMessage.createInvestigateCancelMessage(ChatActivity.this.chatId, ChatActivity.this.spData.getString(YKFConstants.TIMEOUT, ""), ChatActivity.this.spData.getString(YKFConstants.SERVERTIMESTAMP, ""));
                                            MessageDao.getInstance().insertSendMsgsToDao(createInvestigateCancelMessage);
                                            ChatActivity.this.descFromToMessage.add(createInvestigateCancelMessage);
                                            ChatActivity.this.chatAdapter.notifyDataSetChanged();
                                            ChatActivity.this.scrollToBottom();
                                        }
                                    }

                                    @Override // com.moor.imkf.listener.onResponseListener
                                    public void onTimeOut() {
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        IMChatManager.getInstance().getServerTime(new onResponseListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.12.1
                            {
                                AnonymousClass12.this = this;
                            }

                            @Override // com.moor.imkf.listener.onResponseListener
                            public void onFailed() {
                            }

                            @Override // com.moor.imkf.listener.onResponseListener
                            public void onSuccess() {
                                if (str.equals(YKFConstants.INVESTIGATE_TYPE_IN)) {
                                    AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                                    if (z2) {
                                        return;
                                    }
                                    MessageDao.getInstance().insertSendMsgsToDao(IMMessage.createInvestigateCancelMessage(ChatActivity.this.chatId, ChatActivity.this.spData.getString(YKFConstants.TIMEOUT, ""), ChatActivity.this.spData.getString(YKFConstants.SERVERTIMESTAMP, "")));
                                    IMChatManager.getInstance().quitSDk();
                                    ChatActivity.this.finish();
                                }
                            }

                            @Override // com.moor.imkf.listener.onResponseListener
                            public void onTimeOut() {
                            }
                        });
                    }

                    @Override // com.m7.imkfsdk.chat.listener.SubmitPingjiaListener
                    public void OnSubmitFailed() {
                        if (!z) {
                            ChatActivity.this.isInvestigate = true;
                            return;
                        }
                        IMChatManager.getInstance().quitSDk();
                        ChatActivity.this.finish();
                    }

                    @Override // com.m7.imkfsdk.chat.listener.SubmitPingjiaListener
                    public void OnSubmitSuccess(String str3, String str4) {
                        ToastUtils.showShort(ChatActivity.this, str4);
                        FromToMessage createInvestigateSuccessMessage = IMMessage.createInvestigateSuccessMessage(str3);
                        MessageDao.getInstance().insertSendMsgsToDao(createInvestigateSuccessMessage);
                        MessageDao.getInstance().updateHasEvaluatedByChatId(str2);
                        if (z) {
                            IMChatManager.getInstance().quitSDk();
                            ChatActivity.this.finish();
                            return;
                        }
                        if (!z2) {
                            ChatActivity.this.isInvestigate = false;
                        } else if (ChatActivity.this.isInvestigate && MoorNullUtil.checkNull(fromToMessage.chatId).equals(ChatActivity.this.chatId)) {
                            ChatActivity.this.isInvestigate = false;
                        }
                        ChatActivity.this.setChatMoreList();
                        ChatActivity.this.descFromToMessage.add(createInvestigateSuccessMessage);
                        ChatActivity.this.chatAdapter.notifyDataSetChanged();
                        ChatActivity.this.scrollToBottom();
                    }
                }).build();
                this.dialog = build;
                build.show(getFragmentManager(), "InvestigateDialog");
            }
        }
    }

    public void showOffLineDialog() {
        final GlobalSet globalSet;
        if (this.type.equals(YKFConstants.TYPE_SCHEDULE) || (globalSet = GlobalSetDao.getInstance().getGlobalSet()) == null) {
            return;
        }
        if (this.isRobot) {
            this.bar_bottom.setVisibility(0);
        } else {
            this.bar_bottom.setVisibility(8);
        }
        String str = globalSet.inviteLeavemsgTip;
        if (TextUtils.isEmpty(str)) {
            str = MoorNullUtil.checkNull(globalSet.msg);
        }
        if ("1".equals(MoorNullUtil.checkNull(globalSet.isLeaveMsg))) {
            new AlertDialog.Builder(this).setTitle(R.string.ykfsdk_warm_prompt).setMessage(str).setNegativeButton(R.string.ykfsdk_back, new DialogInterface.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.19
                {
                    ChatActivity.this = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    IMChatManager.getInstance().quitSDk();
                    ChatActivity.this.finish();
                }
            }).setPositiveButton(R.string.ykfsdk_ykf_leave_msg, new DialogInterface.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.18
                {
                    ChatActivity.this = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Intent intent = new Intent(ChatActivity.this, OfflineMessageActicity.class);
                    intent.putExtra("PeerId", ChatActivity.this.peerId);
                    intent.putExtra("leavemsgTip", MoorNullUtil.checkNull(globalSet.leavemsgTip));
                    intent.putExtra("inviteLeavemsgTip", MoorNullUtil.checkNull(globalSet.inviteLeavemsgTip));
                    ChatActivity.this.startActivity(intent);
                    ChatActivity.this.finish();
                }
            }).setCancelable(false).create().show();
            return;
        }
        try {
            new AlertDialog.Builder(this).setTitle(R.string.ykfsdk_warm_prompt).setMessage(MoorNullUtil.checkNull(globalSet.msg)).setPositiveButton(R.string.ykfsdk_iknow, new DialogInterface.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.20
                {
                    ChatActivity.this = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    IMChatManager.getInstance().quitSDk();
                    ChatActivity.this.finish();
                }
            }).setCancelable(false).create().show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void showOrHideInviteButton(boolean z) {
        this.showInviteButton = z;
        LinearLayout linearLayout = this.ll_invite;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 0 : 8);
        }
    }

    public void showOrHideQuestionButton(boolean z) {
        this.showQuestionButton = z;
    }

    private void showQueueNumLabel(String str) {
        if (Integer.parseInt(str) > 0) {
            this.chat_queue_ll.setVisibility(0);
            try {
                String str2 = GlobalSetDao.getInstance().getGlobalSet().queueNumText;
                int indexOf = str2.indexOf("{");
                SpannableString spannableString = new SpannableString(str2.replace(str2.substring(indexOf, str2.indexOf("}") + 1), str));
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.ykfsdk_maincolor)), indexOf, indexOf + 1, 33);
                this.chat_queue_tv.setText(spannableString);
                return;
            } catch (Exception unused) {
                TextView textView = this.chat_queue_tv;
                textView.setText(((Object) getResources().getText(R.string.ykfsdk_numbers01)) + str + ((Object) getResources().getText(R.string.ykfsdk_number02)));
                return;
            }
        }
        this.chat_queue_ll.setVisibility(8);
    }

    private void showVipAssignFailDialog() {
        new AlertDialog.Builder(this).setTitle(R.string.ykfsdk_warm_prompt).setMessage(R.string.ykfsdk_doyouneedother).setPositiveButton(R.string.ykfsdk_need, new DialogInterface.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.2
            {
                ChatActivity.this = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                IMChatManager.getInstance().acceptOtherAgent(ChatActivity.this.peerId, new AcceptOtherAgentListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.2.1
                    {
                        AnonymousClass2.this = this;
                    }

                    @Override // com.moor.imkf.listener.AcceptOtherAgentListener
                    public void onFailed() {
                        ChatActivity chatActivity = ChatActivity.this;
                        Toast.makeText(chatActivity, chatActivity.getString(R.string.ykfsdk_ykf_notify_otheragent_fail), 0).show();
                    }

                    @Override // com.moor.imkf.listener.AcceptOtherAgentListener
                    public void onSuccess() {
                        ChatActivity chatActivity = ChatActivity.this;
                        Toast.makeText(chatActivity, chatActivity.getString(R.string.ykfsdk_ykf_notify_otheragent), 0).show();
                        if (ChatActivity.this.type.equals(YKFConstants.TYPE_PEER)) {
                            HttpManager.beginNewVipOfflineSession(InfoDao.getInstance().getConnectionId(), IMChatManager.getInstance().getIsNewVisitor(), ChatActivity.this.peerId, "", ChatActivity.this.getResponseListener(true));
                        }
                        if (ChatActivity.this.type.equals(YKFConstants.TYPE_SCHEDULE)) {
                            HttpManager.beginNewVipOfflineScheduleChatSession(InfoDao.getInstance().getConnectionId(), IMChatManager.getInstance().getIsNewVisitor(), ChatActivity.this.scheduleId, ChatActivity.this.processId, ChatActivity.this.currentNodeId, ChatActivity.this.entranceId, "", ChatActivity.this.getResponseListener(false));
                        }
                    }
                });
            }
        }).setNegativeButton(R.string.ykfsdk_noneed, new DialogInterface.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.1
            {
                ChatActivity.this = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                IMChatManager.getInstance().quitSDk();
                ChatActivity.this.finish();
            }
        }).setCancelable(false).create().show();
    }

    public void showVoice() {
        PanelSwitchHelper panelSwitchHelper = this.mHelper;
        if (panelSwitchHelper != null) {
            panelSwitchHelper.hookSystemBackByPanelSwitcher();
        }
        this.mChatEdittextLayout.setVisibility(8);
        this.mChatSetModeKeyboard.setVisibility(0);
        this.mChatSend.setVisibility(8);
        this.mChatMore.setVisibility(0);
        this.mRecorderButton.setVisibility(0);
        this.mChatEmojiNormal.setVisibility(0);
    }

    private void startScheduleOffline() {
        GlobalSet globalSet = GlobalSetDao.getInstance().getGlobalSet();
        Intent intent = new Intent(this, ScheduleOfflineMessageActivity.class);
        intent.putExtra("LeavemsgNodeId", this.schedule_id);
        intent.putExtra("ToPeer", this.schedule_topeer);
        if (globalSet != null) {
            intent.putExtra("inviteLeavemsgTip", MoorNullUtil.checkNull(globalSet.scheduleLeavemsgTip));
        }
        startActivity(intent);
        finish();
    }

    public void stopTimer() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void JZMoreMessage() {
        List<FromToMessage> messages = IMChatManager.getInstance().getMessages(this.pageSize);
        this.fromToMessage = messages;
        if (messages.size() > 0) {
            Collections.reverse(this.fromToMessage);
            scrollTop(this.fromToMessage);
            return;
        }
        this.mChatList.onRefreshFinished();
        this.JZflag = Boolean.TRUE;
    }

    public void dealCancelInvestigateClick(FromToMessage fromToMessage) {
        FromToMessage messageById = MessageDao.getInstance().getMessageById(fromToMessage._id);
        if (!this.isInvestigate && MoorNullUtil.checkNull(messageById.chatId).equals(this.chatId)) {
            ToastUtils.showShort(this, getString(R.string.ykfsdk_ykf_has_been_evaluated));
        } else if (messageById.hasEvaluated) {
            ToastUtils.showShort(this, getString(R.string.ykfsdk_ykf_has_been_evaluated));
        } else if (this.spData.getBoolean(YKFConstants.CSRAGING, false) && !TextUtils.isEmpty(messageById.timeStamp)) {
            checkImCsrTimeout(YKFConstants.INVESTIGATE_TYPE_OUT, messageById, true, messageById.timeOut, messageById.timeStamp);
        } else {
            showInvestigateDialog(false, YKFConstants.INVESTIGATE_TYPE_OUT, messageById, true);
        }
    }

    public ChatAdapter getChatAdapter() {
        return this.chatAdapter;
    }

    public ChatListView getChatListView() {
        return this.mChatList;
    }

    public void getIntentData(Intent intent) {
        if (intent.getStringExtra("PeerId") != null) {
            this.peerId = intent.getStringExtra("PeerId");
        }
        if (intent.getStringExtra("type") != null) {
            this.type = intent.getStringExtra("type");
        }
        if (intent.getStringExtra("scheduleId") != null) {
            this.scheduleId = intent.getStringExtra("scheduleId");
        }
        if (intent.getStringExtra("processId") != null) {
            this.processId = intent.getStringExtra("processId");
        }
        if (intent.getStringExtra("currentNodeId") != null) {
            this.currentNodeId = intent.getStringExtra("currentNodeId");
        }
        if (intent.getStringExtra("entranceId") != null) {
            this.entranceId = intent.getStringExtra("entranceId");
        }
        if (intent.getStringExtra("processType") != null) {
            this.processType = intent.getStringExtra("processType");
        }
        MoorUtils.initForUnread(this);
        IMChatManager.getInstance().isFinishWhenReConnect = false;
    }

    public void getVoiceToText(final FromToMessage fromToMessage) {
        this.mCountDownTimer = new CountDownTimer(180000L, 1000L) { // from class: com.m7.imkfsdk.chat.ChatActivity.26
            {
                ChatActivity.this = this;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                VoiceToTextEvent voiceToTextEvent = new VoiceToTextEvent();
                voiceToTextEvent.id = fromToMessage._id;
                voiceToTextEvent.status_code = "400";
                ChatActivity.this.onEventMainThread(voiceToTextEvent);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }
        }.start();
        HttpManager.sendVoiceToText(fromToMessage._id, fromToMessage.message, fromToMessage.when.longValue(), new HttpResponseListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.27
            {
                ChatActivity.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
                ChatActivity.this.stopTimer();
                fromToMessage.isCacheShowVtoT = false;
                MessageDao.getInstance().updateMsgToDao(fromToMessage);
                ChatActivity.this.chatAdapter.notifyDataSetChanged();
                ChatActivity chatActivity = ChatActivity.this;
                ToastUtils.showLong(chatActivity, chatActivity.getText(R.string.ykfsdk_voice_to_text_error));
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str) {
                Log.e("语音转文本", str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.optBoolean("Succeed")) {
                        ChatActivity.this.stopTimer();
                        FromToMessage fromToMessage2 = fromToMessage;
                        if (fromToMessage2.isRobot) {
                            ChatActivity.this.sendVoiceAutoText(fromToMessage2, "", false);
                        } else {
                            fromToMessage2.isCacheShowVtoT = false;
                            MessageDao.getInstance().updateMsgToDao(fromToMessage);
                            ChatActivity.this.chatAdapter.notifyDataSetChanged();
                            ChatActivity chatActivity = ChatActivity.this;
                            ToastUtils.showLong(chatActivity, ((Object) ChatActivity.this.getText(R.string.ykfsdk_voice_to_text_error)) + Constants.COLON_SEPARATOR + jSONObject.optString("Message"));
                        }
                    } else if (!TextUtils.isEmpty(jSONObject.optString("messageId"))) {
                        String optString = jSONObject.optString("voiceMessage");
                        String optString2 = jSONObject.optString("messageId");
                        VoiceToTextEvent voiceToTextEvent = new VoiceToTextEvent();
                        voiceToTextEvent.id = optString2;
                        voiceToTextEvent.toText = optString;
                        voiceToTextEvent.status_code = VoiceToTextEvent.STATUS_OK;
                        ChatActivity.this.onEventMainThread(voiceToTextEvent);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void handleMessage(Message message, StringBuilder sb) {
        int i2 = message.what;
        if (i2 == 1) {
            updateMessage();
        } else if (i2 == 2) {
            JZMoreMessage();
        } else if (i2 == 273) {
            ToastUtils.showShort(this, R.string.ykfsdk_now_robit);
            if (IMChatManager.getInstance().isShowTransferBtn()) {
                this.chat_tv_convert.setVisibility(0);
                MoorLogUtils.dTag("handleMessage==", "当前是机器人-显示按钮");
            } else {
                this.chat_tv_convert.setVisibility(8);
                MoorLogUtils.dTag("handleMessage==", "当前是机器人-隐藏按钮");
            }
            this.bar_bottom.setVisibility(0);
            this.isRobot = true;
            setChatMoreList();
        } else if (i2 == 546) {
            this.chat_tv_convert.setVisibility(8);
        } else if (i2 == HANDLER_WRITING) {
            this.mOtherName.setText(R.string.ykfsdk_other_writing);
        } else if (i2 == HANDLER_NO_WRITING) {
            this.mOtherName.setText(this.titleName);
        } else if (i2 == HANDLER_OFFNLINE) {
            ToastUtils.showShort(this, R.string.ykfsdk_people_not_online);
            if (IMChatManager.getInstance().isShowTransferBtn()) {
                this.chat_tv_convert.setVisibility(0);
            } else {
                this.chat_tv_convert.setVisibility(8);
            }
            if (this.isRobot) {
                this.bar_bottom.setVisibility(0);
            } else {
                this.bar_bottom.setVisibility(0);
            }
            showOffLineDialog();
        } else if (i2 == HANDLER_INVESTIGATE) {
            this.INVITATION_INVESTIGATE = true;
            openInvestigateDialog(false, YKFConstants.INVESTIGATE_TYPE_OUT, null, false);
        } else if (i2 == HANDLER_QUEUENUM) {
            showQueueNumLabel((String) message.obj);
            this.isQueue = true;
            setChatMoreList();
        } else if (i2 == HANDLER_CLIAM) {
            this.chat_queue_ll.setVisibility(8);
            this.chat_tv_convert.setVisibility(8);
            this.bar_bottom.setVisibility(0);
            this.isRobot = false;
            this.isQueue = false;
            checkConverstaion();
            Toast.makeText(getApplicationContext(), R.string.ykfsdk_people_now, 0).show();
            IMChatManager.getInstance().setIsShowBottomList(false);
            this.rvTagLabel.setVisibility(8);
        } else if (i2 == HANDLER_FINISH) {
            TextView textView = this.mOtherName;
            int i3 = R.string.ykfsdk_people_isleave;
            textView.setText(i3);
            this.titleName = getString(i3);
            this.chat_tv_convert.setVisibility(8);
            this.conversationOver = true;
            this.ll_bottom_intercept.setVisibility(0);
        } else if (i2 == 4352) {
            startScheduleOffline();
        } else if (i2 == HANDLER_BREAK) {
            MoorLogUtils.dTag("BreakTimer", "HANDLER_BREAK===断开会话");
            IMChatManager.getInstance().quitSDk();
            finish();
        } else if (i2 == HANDLER_BREAK_TIP) {
            MoorLogUtils.dTag("BreakTimer", "HANDLER_BREAK_TIP===断开会话前提示");
            IMChat.getInstance().createBreakTipMsg(this.break_tips);
            updateMessage();
        } else if (i2 == 4096) {
            showVipAssignFailDialog();
        }
    }

    public void handleOnClickOfLogisticsItem(String str, String str2, OrderInfoBean orderInfoBean) {
        if (this.conversationOver) {
            startReStartDialog();
        } else if (orderInfoBean == null) {
        } else {
            this.mHashSet.add(str);
            IMChatManager.getInstance().updateOrderInfo(str, "1");
            BottomSheetLogisticsInfoDialog bottomSheetLogisticsInfoDialog = this.moreOrderInfoDialog;
            if (bottomSheetLogisticsInfoDialog != null && bottomSheetLogisticsInfoDialog.isShowing()) {
                this.moreOrderInfoDialog.dismiss();
            }
            FromToMessage fromToMessage = new FromToMessage();
            fromToMessage.userType = "0";
            fromToMessage.message = "发送卡片信息";
            fromToMessage.msgType = FromToMessage.MSG_TYPE_LOGISTICS_INFO_LIST;
            fromToMessage.when = Long.valueOf(System.currentTimeMillis());
            fromToMessage.sessionId = IMChat.getInstance().getSessionId();
            fromToMessage.tonotify = IMChat.getInstance().get_id();
            fromToMessage.type = "User";
            fromToMessage.from = IMChat.getInstance().get_id();
            if (orderInfoBean != null) {
                fromToMessage.newCardInfo = new Gson().z(orderInfoBean);
            }
            MsgTaskBean item = new MsgTaskBean().setCurrent(str2).setItem(new MsgTaskItemBean().setTarget("next").setParams(new OrderInfoParams().setOrderNo(orderInfoBean.getParams().getOrderNo())));
            fromToMessage.msgTask = new Gson().z(item);
            MoorLogUtils.aTag("MsgTaskBean==", new Gson().z(item));
            sendSingleMessage(fromToMessage);
        }
    }

    public void handleOnClickOfLogisticsMore(String str, final String str2) {
        LoadingFragmentDialog loadingFragmentDialog = this.loadingDialog;
        if (loadingFragmentDialog != null) {
            loadingFragmentDialog.show(getFragmentManager(), "");
        }
        HttpManager.getMoreOrderInfo(new Gson().z(new MsgTaskBean().setCurrent(str).setItem(new MsgTaskItemBean().setTarget("self").setPage("all"))), new HttpResponseListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.24
            {
                ChatActivity.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
                if (ChatActivity.this.loadingDialog != null) {
                    ChatActivity.this.loadingDialog.dismiss();
                }
                ChatActivity chatActivity = ChatActivity.this;
                ToastUtils.showShort(chatActivity, chatActivity.getString(R.string.ykfsdk_ykf_loadmore_fail));
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str3) {
                if (ChatActivity.this.loadingDialog != null) {
                    ChatActivity.this.loadingDialog.dismiss();
                }
                String succeed = HttpParser.getSucceed(str3);
                MoorLogUtils.aTag("查看更多返回===：", str3);
                if ("true".equals(succeed)) {
                    try {
                        String string = new JSONObject(str3).getString(FromToMessage.MSG_TYPE_LOGISTICS_INFO_LIST);
                        if (MoorNullUtil.checkNULL(string)) {
                            OrderBaseBean orderBaseBean = (OrderBaseBean) new Gson().o(string, new a<OrderBaseBean>() { // from class: com.m7.imkfsdk.chat.ChatActivity.24.1
                                {
                                    AnonymousClass24.this = this;
                                }
                            }.getType());
                            if (orderBaseBean.getData() != null) {
                                ArrayList<OrderInfoBean> shop_list = orderBaseBean.getData().getShop_list();
                                if (shop_list == null) {
                                    shop_list = orderBaseBean.getData().getItem_list();
                                }
                                if (shop_list == null) {
                                    shop_list = new ArrayList<>();
                                }
                                ChatActivity.this.moreOrderInfoDialog = BottomSheetLogisticsInfoDialog.init(shop_list, orderBaseBean.getCurrent(), str2);
                                ChatActivity.this.moreOrderInfoDialog.show(ChatActivity.this.getSupportFragmentManager(), "");
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                ChatActivity chatActivity = ChatActivity.this;
                ToastUtils.showShort(chatActivity, chatActivity.getString(R.string.ykfsdk_ykf_loadmore_fail));
            }
        });
    }

    public void handleOnClickOfLogisticsProgressMore(FromToMessage fromToMessage) {
        String str = fromToMessage.msgTask;
        if (str == null || "".equals(str)) {
            return;
        }
        OrderBaseBean orderBaseBean = (OrderBaseBean) new Gson().o(fromToMessage.msgTask, new a<OrderBaseBean>() { // from class: com.m7.imkfsdk.chat.ChatActivity.25
            {
                ChatActivity.this = this;
            }
        }.getType());
        if (orderBaseBean.getData() != null) {
            ArrayList<OrderInfoBean> shop_list = orderBaseBean.getData().getShop_list();
            if (shop_list == null) {
                shop_list = orderBaseBean.getData().getItem_list();
            }
            if (shop_list == null) {
                shop_list = new ArrayList<>();
            }
            BottomSheetLogisticsProgressDialog.init(orderBaseBean.getData().getList_title(), orderBaseBean.getData().getList_num(), orderBaseBean.getData().getMessage(), shop_list).show(getSupportFragmentManager(), "");
        }
    }

    public void handleOnClickOfLogisticsShop(String str) {
        if (this.conversationOver) {
            startReStartDialog();
        } else if (TextUtils.isEmpty(str)) {
        } else {
            Intent intent = new Intent(this, MoorWebCenter.class);
            intent.putExtra("OpenUrl", str);
            intent.putExtra("titleName", "详情");
            startActivity(intent);
        }
    }

    public void handleTab_QusetionMoreClick(String str, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        final BottomTabQuestionDialog init = BottomTabQuestionDialog.init(str, arrayList);
        init.show(getSupportFragmentManager(), "");
        init.setonQuestionClickListener(new BottomTabQuestionDialog.onQuestionClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.10
            {
                ChatActivity.this = this;
            }

            @Override // com.m7.imkfsdk.chat.dialog.BottomTabQuestionDialog.onQuestionClickListener
            public void OnItemClick(String str2) {
                ChatActivity.this.sendTextMsg(str2);
                init.close(true);
            }
        });
    }

    public void handle_QuickItemClick(MoorFastBtnBean moorFastBtnBean) {
        if (moorFastBtnBean != null) {
            if (moorFastBtnBean.getButton_type() == 2) {
                if (TextUtils.isEmpty(moorFastBtnBean.getContent())) {
                    return;
                }
                Intent intent = new Intent(this, MoorWebCenter.class);
                intent.putExtra("OpenUrl", moorFastBtnBean.getContent());
                intent.putExtra("titleName", moorFastBtnBean.getName());
                startActivity(intent);
            } else if (TextUtils.isEmpty(moorFastBtnBean.getContent())) {
            } else {
                sendTextMsg(moorFastBtnBean.getContent());
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void initBottomList() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_tag_label);
        this.rvTagLabel = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        ChatTagLabelsAdapter chatTagLabelsAdapter = new ChatTagLabelsAdapter(new ArrayList());
        this.tagLabeAdapter = chatTagLabelsAdapter;
        this.rvTagLabel.setAdapter(chatTagLabelsAdapter);
        this.rvTagLabel.addItemDecoration(new SpaceItemDecoration(MoorDensityUtil.dp2px(10.0f), 0));
        this.tagLabeAdapter.setOnItemClickListener(new ChatTagLabelsAdapter.onItemClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.4
            {
                ChatActivity.this = this;
            }

            @Override // com.m7.imkfsdk.chat.adapter.ChatTagLabelsAdapter.onItemClickListener
            public void OnItemClick(FlowBean flowBean) {
                if (flowBean.getButton_type() == 2) {
                    if (TextUtils.isEmpty(flowBean.getText())) {
                        return;
                    }
                    Intent intent = new Intent(ChatActivity.this, MoorWebCenter.class);
                    intent.putExtra("OpenUrl", flowBean.getText());
                    intent.putExtra("titleName", flowBean.getButton());
                    ChatActivity.this.startActivity(intent);
                    return;
                }
                ChatActivity.this.sendXbotTextMsg(flowBean.getText());
            }
        });
        this.rvTagLabel.setVisibility(8);
        this.mChatSend = (TextView) findViewById(R.id.chat_send);
        this.chat_tv_back = (ImageView) findViewById(R.id.chat_tv_back);
        AudioRecorderButton audioRecorderButton = (AudioRecorderButton) findViewById(R.id.chat_press_to_speak);
        this.mRecorderButton = audioRecorderButton;
        audioRecorderButton.setRecordFinishListener(this);
        this.mChatInput = (EditText) findViewById(R.id.chat_input);
        this.ll_hintView = (LinearLayout) findViewById(R.id.ll_hintView);
        this.rl_bottom = (LinearLayout) findViewById(R.id.rl_bottom);
        this.mChatEdittextLayout = (RelativeLayout) findViewById(R.id.chat_edittext_layout);
        this.mChatEmojiNormal = (ImageView) findViewById(R.id.chat_emoji_normal);
        this.ivDeleteEmoji = (ImageView) findViewById(R.id.iv_delete_emoji);
        this.mChatMore = (ImageView) findViewById(R.id.chat_more);
        this.mChatSetModeVoice = (Button) findViewById(R.id.chat_set_mode_voice);
        this.mChatSetModeKeyboard = (Button) findViewById(R.id.chat_set_mode_keyboard);
        this.chat_tv_convert = (TextView) findViewById(R.id.chat_tv_convert);
        this.chat_queue_ll = (LinearLayout) findViewById(R.id.chat_queue_ll);
        this.chat_queue_tv = (TextView) findViewById(R.id.chat_queue_tv);
        this.bar_bottom = (LinearLayout) findViewById(R.id.bar_bottom);
        this.mOtherName = (TextView) findViewById(R.id.other_name);
        this.mChatList = (ChatListView) findViewById(R.id.chat_list);
        this.pagerView = (EmotionPagerView) findViewById(R.id.view_pager);
        this.ll_bottom_intercept = (LinearLayout) findViewById(R.id.ll_bottom_intercept);
        if (this.type.equals(YKFConstants.TYPE_SCHEDULE) && !this.processType.equals("robot")) {
            this.chat_tv_convert.setVisibility(8);
        }
        if (!IMChatManager.getInstance().isShowTransferBtn()) {
            this.chat_tv_convert.setVisibility(8);
            MoorLogUtils.dTag("handleMessage==", "可以删除的逻辑-隐藏按钮");
        }
        if (this.show_emoji) {
            this.mChatEmojiNormal.setVisibility(0);
        } else {
            this.mChatEmojiNormal.setVisibility(8);
        }
        this.mChatInput.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.5
            {
                ChatActivity.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!MoorUtils.isNetWorkConnected(IMChatManager.getInstance().getAppContext()) && !WebSocketHandler.getDefault().isConnect()) {
                    MoorLogUtils.aTag("第五个地方break", new Object[0]);
                    ChatActivity.this.startReStartDialog3();
                } else if (!IMChatManager.getInstance().isFinishWhenReConnect) {
                    ChatActivity.this.mChatEmojiNormal.setVisibility(0);
                    ChatActivity.this.mChatEmojiNormal.setSelected(false);
                } else {
                    ChatActivity.this.startReStartDialog();
                }
            }
        });
        this.mChatInput.addTextChangedListener(new TextWatcher() { // from class: com.m7.imkfsdk.chat.ChatActivity.6
            {
                ChatActivity.this = this;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(editable)) {
                    if (ChatActivity.this.isRobot) {
                        if (IMChat.getInstance().getLianXiangOn()) {
                            HttpManager.queryLianXiangData(InfoDao.getInstance().getConnectionId(), IMChat.getInstance().getRobotType(), editable.toString(), new GetLianXiangDataResponeHandler());
                            return;
                        }
                        return;
                    } else if (IMChat.getInstance().isHumanLianXiangOn()) {
                        HttpManager.queryLianXiangData(InfoDao.getInstance().getConnectionId(), IMChat.getInstance().getRobotType(), editable.toString(), new GetLianXiangDataResponeHandler());
                        return;
                    } else {
                        return;
                    }
                }
                ChatActivity.this.ll_hintView.setVisibility(8);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    ChatActivity.this.mChatMore.setVisibility(8);
                    ChatActivity.this.mChatSend.setVisibility(0);
                } else {
                    ChatActivity.this.mChatMore.setVisibility(0);
                    ChatActivity.this.mChatSend.setVisibility(8);
                }
                if (ChatActivity.this.delaySendTask != null) {
                    ChatActivity.this.delaySendTask.setCanceled(true);
                    ChatActivity.this.handler.removeCallbacks(ChatActivity.this.delaySendTask);
                } else {
                    ChatActivity chatActivity = ChatActivity.this;
                    chatActivity.delaySendTask = new DelaySendTask();
                }
                ChatActivity.this.delaySendTask.setCanceled(false);
                ChatActivity.this.delaySendTask.setText(charSequence.toString());
                ChatActivity.this.handler.postDelayed(ChatActivity.this.delaySendTask, 1000L);
            }
        });
        this.header = View.inflate(this, R.layout.ykfsdk_kf_chatlist_header, null);
        this.header.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mChatList.setOnTouchListener(new View.OnTouchListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.7
            {
                ChatActivity.this = this;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return ChatActivity.this.mHelper != null && ChatActivity.this.mHelper.hookSystemBackByPanelSwitcher();
            }
        });
    }

    public boolean isListBottom() {
        return this.isListBottom;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 200) {
            if (i3 == -1) {
                Uri data = intent.getData();
                if (data != null) {
                    this.picFileFullName = PickUtils.getPath(this, data);
                    Log.d("发送图片消息了", "图片的本地路径是：" + this.picFileFullName);
                    FromToMessage createImageMessage = IMMessage.createImageMessage(this.picFileFullName);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(createImageMessage);
                    this.descFromToMessage.addAll(arrayList);
                    this.chatAdapter.notifyDataSetChanged();
                    scrollToBottom();
                    resetBreakTimer();
                    sendMsgToServer(createImageMessage);
                    return;
                }
                Log.e(tag, "从相册获取图片失败");
            }
        } else if (i2 == 300 && i3 == -1) {
            String path = PickUtils.getPath(this, intent.getData());
            if (!MoorNullUtil.checkNULL(path)) {
                Toast.makeText(this, getString(R.string.ykfsdk_ykf_not_support_file), 0).show();
                return;
            }
            File file = new File(path);
            if (file.exists()) {
                long length = file.length();
                if ((length / 1024) / 1024 > 200.0d) {
                    Toast.makeText(this, getString(R.string.ykfsdk_sendfiletoobig) + "200MB", 0).show();
                    return;
                }
                FromToMessage createFileMessage = IMMessage.createFileMessage(path, path.substring(path.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1), FileUtils.formatFileLength(length), getString(R.string.ykfsdk_ykf_has_been_upload_tips));
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(createFileMessage);
                this.descFromToMessage.addAll(arrayList2);
                this.chatAdapter.notifyDataSetChanged();
                scrollToBottom();
                resetBreakTimer();
                sendMsgToServer(createFileMessage);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PanelSwitchHelper panelSwitchHelper = this.mHelper;
        if (panelSwitchHelper == null || !panelSwitchHelper.hookSystemBackByPanelSwitcher()) {
            InvestigateDialog investigateDialog = this.dialog;
            if (investigateDialog == null || investigateDialog.getDialog() == null || !this.dialog.getDialog().isShowing()) {
                handleLogOutOrBackPressed();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.chat_tv_back) {
            handleLogOutOrBackPressed();
        } else if (id == R.id.chat_tv_convert) {
            if (MoorAntiShakeUtils.getInstance().check()) {
                return;
            }
            onEventMainThread(new TransferAgent());
        } else if (id == R.id.chat_send) {
            String obj = this.mChatInput.getText().toString();
            if (!MoorUtils.isNetWorkConnected(IMChatManager.getInstance().getAppContext()) && !WebSocketHandler.getDefault().isConnect()) {
                Toast.makeText(getApplicationContext(), getString(R.string.ykfsdk_ykf_not_netwokr_error), 0).show();
                MoorLogUtils.aTag("第四个地方break", new Object[0]);
                startReStartDialog3();
            } else if (IMChatManager.getInstance().isFinishWhenReConnect) {
                startReStartDialog();
            } else {
                this.ll_hintView.setVisibility(8);
                sendTextMsg(obj);
            }
        } else if (id == R.id.chat_set_mode_voice) {
            PermissionXUtil.checkPermission(this, new OnRequestCallback() { // from class: com.m7.imkfsdk.chat.ChatActivity.8
                {
                    ChatActivity.this = this;
                }

                @Override // com.m7.imkfsdk.utils.permission.callback.OnRequestCallback
                public void requestSuccess() {
                    if (MoorUtils.isNetWorkConnected(IMChatManager.getInstance().getAppContext()) || WebSocketHandler.getDefault().isConnect()) {
                        ChatActivity.this.showVoice();
                        return;
                    }
                    Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(R.string.ykfsdk_ykf_not_netwokr_error), 0).show();
                    MoorLogUtils.aTag("voicebreak", new Object[0]);
                    ChatActivity.this.startReStartDialog3();
                }
            }, PermissionConstants.RECORD_AUDIO);
        } else if (id == R.id.chat_set_mode_keyboard) {
            this.mChatInput.requestFocus(100);
            this.mChatEdittextLayout.setVisibility(0);
            this.mChatSetModeKeyboard.setVisibility(8);
            this.mRecorderButton.setVisibility(8);
            if (TextUtils.isEmpty(this.mChatInput.getText())) {
                this.mChatMore.setVisibility(0);
                this.mChatSend.setVisibility(8);
                return;
            }
            this.mChatMore.setVisibility(8);
            this.mChatSend.setVisibility(0);
        } else if (id == R.id.iv_delete_emoji) {
            KeyEvent keyEvent = new KeyEvent(0, 67);
            KeyEvent keyEvent2 = new KeyEvent(1, 67);
            this.mChatInput.onKeyDown(67, keyEvent);
            this.mChatInput.onKeyUp(67, keyEvent2);
        } else if (id != R.id.rl_bottom && id == R.id.ll_bottom_intercept) {
            if (this.conversationOver) {
                startReStartDialog();
            } else {
                this.ll_bottom_intercept.setVisibility(8);
            }
        }
    }

    @Override // com.m7.imkfsdk.chat.KFBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            supportRequestWindowFeature(1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.spData = getSharedPreferences(YKFConstants.MOOR_SP, 0);
        setContentView(R.layout.ykfsdk_kf_activity_chat);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.ykfsdk_all_white));
        getIntentData(getIntent());
        this.handler = new ChatHandler(this);
        this.spData.edit().putString(YKFConstants.SERVERTIMESTAMP, "").commit();
        this.left_text = this.spData.getString(YKFConstants.CHATACTIVITYLEFTTEXT, "");
        this.show_emoji = this.spData.getBoolean(YKFConstants.CHATACTIVITYEMOJI, true);
        this.titleName = getString(R.string.ykfsdk_wait_link);
        registerRec();
        c.f().v(this);
        initBottomList();
        registerListener();
        ChatAdapter chatAdapter = new ChatAdapter(this, this.descFromToMessage);
        this.chatAdapter = chatAdapter;
        this.mChatList.setAdapter((ListAdapter) chatAdapter);
        updateMessage();
        if (IMChatManager.getInstance().getInvestigate().size() > 0) {
            this.hasSet = true;
        } else {
            this.hasSet = false;
        }
        LoadingFragmentDialog loadingFragmentDialog = new LoadingFragmentDialog();
        this.loadingDialog = loadingFragmentDialog;
        loadingFragmentDialog.setCanceledOnTouchOutside(false);
        this.loadingDialog.show(getFragmentManager(), "");
        beginChatSession();
        setGlobalConfig();
        getMainQuestions();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mHashSet.size() > 0) {
            for (String str : this.mHashSet) {
                IMChatManager.getInstance().updateOrderInfo(str, "2");
            }
        }
        ChatHandler chatHandler = this.handler;
        if (chatHandler != null) {
            chatHandler.removeCallbacksAndMessages(null);
        }
        unregisterReceiver(this.msgReceiver);
        unregisterReceiver(this.keFuStatusReceiver);
        this.mRecorderButton.cancelListener();
        Timer timer = this.break_timer;
        if (timer != null) {
            timer.cancel();
            this.break_timer = null;
        }
        Timer timer2 = this.break_tip_timer;
        if (timer2 != null) {
            timer2.cancel();
            this.break_tip_timer = null;
        }
        BreakTimerTask breakTimerTask = this.breakTimerTask;
        if (breakTimerTask != null) {
            breakTimerTask.cancel();
        }
        BreakTipTimerTask breakTipTimerTask = this.breakTipTimerTask;
        if (breakTipTimerTask != null) {
            breakTipTimerTask.cancel();
        }
        IMChat.getInstance().setCancel(true);
        MessageDao.getInstance().delecteCardMsgs();
        MessageDao.getInstance().delecteNewCardMsgs();
        c.f().A(this);
        super.onDestroy();
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(UnAssignEvent unAssignEvent) {
        this.chat_tv_convert.setVisibility(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        updateMessage();
        this.robotEvaluationFinish = Boolean.FALSE;
        this.conversationOver = false;
        this.hasSendRobotMsg = false;
        this.hasSendPersonMsg = false;
        this.isQueue = false;
        this.JZflag = Boolean.TRUE;
        LinearLayout linearLayout = this.ll_bottom_intercept;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.titleName = getString(R.string.ykfsdk_wait_link);
        resetBreakTimer();
        getIntentData(intent);
        beginChatSession();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.chatAdapter.onPause();
        this.isFront = false;
    }

    @Override // com.m7.imkfsdk.recordbutton.AudioRecorderButton.RecorderFinishListener
    public void onRecordFinished(float f2, String str, String str2) {
        if (!FileUtils.isExists(str)) {
            ToastUtils.showShort(this, getString(R.string.ykfsdk_ykf_recording_error));
            return;
        }
        FromToMessage createAudioMessage = IMMessage.createAudioMessage(f2, str, "");
        this.descFromToMessage.add(createAudioMessage);
        this.chatAdapter.notifyDataSetChanged();
        scrollToBottom();
        sendVoiceMsg("", createAudioMessage);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isFront = true;
        if (IMChatManager.getInstance().getAppContext() == null) {
            IMChatManager.getInstance().setAppContext(getApplication());
        }
        onEventMainThread(new MsgEvent());
        MoorLogUtils.aTag("chatActivity", "走到OnResume了：" + WebSocketHandler.getDefault().isConnect());
        if (MoorUtils.isNetWorkConnected(this)) {
            MoorLogUtils.aTag("onresume", "监测到网络ok");
            if (isServiceRunning(this, "com.moor.imkf.SocketService")) {
                if (!WebSocketHandler.getDefault().isConnect()) {
                    c.f().q(new TcpBreakEvent());
                }
            } else {
                startReStartDialog3();
            }
        } else {
            startReStartDialog3();
            MoorLogUtils.aTag("onresume", "监测到网络not ok");
        }
        YKFCallHelper.openActivity();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mHelper == null) {
            this.mHelper = new PanelSwitchHelper.Builder(this).addEditTextFocusChangeListener(new OnEditFocusChangeListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.33
                {
                    ChatActivity.this = this;
                }

                @Override // com.effective.android.panel.interfaces.listener.OnEditFocusChangeListener
                public void onFocusChange(@Nullable View view, boolean z) {
                    if (z) {
                        ChatActivity.this.scrollToBottom();
                    }
                }
            }).addContentScrollMeasurer(new ContentScrollMeasurer() { // from class: com.m7.imkfsdk.chat.ChatActivity.32
                {
                    ChatActivity.this = this;
                }

                @Override // com.effective.android.panel.interfaces.ContentScrollMeasurer
                public int getScrollDistance(int i2) {
                    return i2 - ChatActivity.this.unfilledHeight;
                }

                @Override // com.effective.android.panel.interfaces.ContentScrollMeasurer
                public int getScrollViewId() {
                    return R.id.chat_list;
                }
            }).addPanelChangeListener(new OnPanelChangeListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.31
                {
                    ChatActivity.this = this;
                }

                @Override // com.effective.android.panel.interfaces.listener.OnPanelChangeListener
                public void onKeyboard() {
                    ChatActivity.this.scrollToBottom();
                    ChatActivity.this.mChatEmojiNormal.setSelected(false);
                    ChatActivity.this.mChatMore.setSelected(false);
                }

                @Override // com.effective.android.panel.interfaces.listener.OnPanelChangeListener
                public void onNone() {
                    ChatActivity.this.mChatEmojiNormal.setSelected(false);
                    ChatActivity.this.mChatMore.setSelected(false);
                }

                @Override // com.effective.android.panel.interfaces.listener.OnPanelChangeListener
                public void onPanel(IPanelView iPanelView) {
                    ChatActivity.this.scrollToBottom();
                    if (iPanelView instanceof PanelView) {
                        PanelView panelView = (PanelView) iPanelView;
                        ChatActivity.this.mChatEmojiNormal.setSelected(panelView.getId() == R.id.panel_emotion);
                        boolean z = panelView.getId() == R.id.panel_addition;
                        if (z) {
                            ChatActivity.this.mChatEdittextLayout.setVisibility(0);
                            ChatActivity.this.mChatSetModeKeyboard.setVisibility(8);
                            ChatActivity.this.mRecorderButton.setVisibility(8);
                        }
                        ChatActivity.this.mChatMore.setSelected(z);
                    }
                }

                @Override // com.effective.android.panel.interfaces.listener.OnPanelChangeListener
                public void onPanelSizeChange(IPanelView iPanelView, boolean z, int i2, int i3, int i4, int i5) {
                    if (iPanelView instanceof PanelView) {
                        PanelView panelView = (PanelView) iPanelView;
                        if (panelView.getId() == R.id.panel_emotion) {
                            ChatActivity.this.pagerView.buildEmotionViews(ChatActivity.this.mChatInput, Emotions.getEmotions(), i4, i5 - MoorDensityUtil.dp2px(20.0f));
                        } else if (panelView.getId() == R.id.panel_addition) {
                            ChatActivity.this.dealAddMoreViewClickEvent(panelView);
                        }
                    }
                }
            }).logTrack(false).build();
            this.mChatList.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.34
                {
                    ChatActivity.this = this;
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                    ChatListView.firstItemIndex = i2;
                    int childCount = ChatActivity.this.mChatList.getChildCount();
                    if (childCount > 0) {
                        int bottom = ChatActivity.this.mChatList.getChildAt(childCount - 1).getBottom();
                        ChatActivity.this.unfilledHeight = ((ChatActivity.this.mChatList.getHeight() - ChatActivity.this.mChatList.getPaddingBottom()) - ChatActivity.this.rvTagLabel.getHeight()) - bottom;
                    }
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i2) {
                    if (i2 != 0) {
                        return;
                    }
                    ChatActivity chatActivity = ChatActivity.this;
                    chatActivity.isListBottom = chatActivity.isListViewReachBottomEdge(absListView);
                }
            });
        }
    }

    public void openAlbum() {
        Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        if (getPackageManager().queryIntentActivities(intent, 65536).size() != 0) {
            startActivityForResult(intent, 200);
        } else {
            ToastUtils.showShort(this, getString(R.string.ykfsdk_ykf_no_imagepick));
        }
    }

    public void openInvestigateDialog(boolean z, String str, FromToMessage fromToMessage, boolean z2) {
        if (this.isRobot) {
            openRobotInvestigateDialog();
            return;
        }
        SharedPreferences sharedPreferences = this.spData;
        if (sharedPreferences != null) {
            boolean z3 = sharedPreferences.getBoolean(YKFConstants.CSRAGING, false);
            String string = this.spData.getString(YKFConstants.SERVERTIMESTAMP, "");
            if (this.INVITATION_INVESTIGATE && z && z3 && !TextUtils.isEmpty(string)) {
                checkImCsrTimeout(str, fromToMessage, z2, this.spData.getString(YKFConstants.TIMEOUT, ""), string);
            } else {
                showInvestigateDialog(false, str, fromToMessage, z2);
            }
        }
    }

    public void registerListener() {
        this.mChatSend.setOnClickListener(this);
        this.chat_tv_back.setOnClickListener(this);
        this.mChatSetModeVoice.setOnClickListener(this);
        this.mChatSetModeKeyboard.setOnClickListener(this);
        this.mChatList.setOnRefreshListener(this);
        this.chat_tv_convert.setOnClickListener(this);
        this.ivDeleteEmoji.setOnClickListener(this);
        this.rl_bottom.setOnClickListener(this);
        this.ll_bottom_intercept.setOnClickListener(this);
    }

    public void resendMsg(FromToMessage fromToMessage, int i2) {
        if (IMChatManager.getInstance().isFinishWhenReConnect) {
            startReStartDialog();
        } else if (MoorAntiShakeUtils.getInstance().check()) {
        } else {
            fromToMessage.sendState = "sending";
            MessageDao.getInstance().updateMsgToDao(fromToMessage);
            updateMessage();
            resetBreakTimer();
            IMChat.getInstance().reSendMessage(fromToMessage, new ChatListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.21
                {
                    ChatActivity.this = this;
                }

                @Override // com.moor.imkf.listener.ChatListener
                public void onFailed(String str) {
                    MoorLogUtils.eTag("SendMessage", str);
                    ChatActivity.this.updateMessage();
                }

                @Override // com.moor.imkf.listener.ChatListener
                public void onProgress(int i3) {
                    ChatActivity.this.updateMessage();
                }

                @Override // com.moor.imkf.listener.ChatListener
                public void onSuccess(String str) {
                    ChatActivity.this.updateMessage();
                }
            });
        }
    }

    public void scrollToBottom() {
        this.mChatList.post(new Runnable() { // from class: com.m7.imkfsdk.chat.ChatActivity.3
            {
                ChatActivity.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatActivity.this.mChatList.setSelection(ChatActivity.this.mChatList.getBottom());
            }
        });
    }

    public void sendCardMsg(FromToMessage fromToMessage, String str) {
        FromToMessage fromToMessage2 = new FromToMessage();
        fromToMessage2.userType = "0";
        fromToMessage2.message = "";
        fromToMessage2.msgType = str;
        fromToMessage2.when = Long.valueOf(System.currentTimeMillis());
        fromToMessage2.sessionId = IMChat.getInstance().getSessionId();
        fromToMessage2.tonotify = IMChat.getInstance().get_id();
        fromToMessage2.type = "User";
        fromToMessage2.from = IMChat.getInstance().get_id();
        String str2 = fromToMessage.cardInfo;
        if (str2 != null) {
            fromToMessage2.cardInfo = str2;
        }
        String str3 = fromToMessage.newCardInfo;
        if (str3 != null) {
            fromToMessage2.newCardInfo = str3;
        }
        sendSingleMessage(fromToMessage2);
    }

    public void sendTextMsg(String str) {
        if (this.conversationOver) {
            startReStartDialog();
            return;
        }
        if (this.isRobot && !this.hasSendRobotMsg) {
            this.hasSendRobotMsg = true;
            setChatMoreList();
        }
        if (!this.isRobot && !this.hasSendPersonMsg) {
            this.hasSendPersonMsg = true;
            setChatMoreList();
        }
        MoorLogUtils.aTag("send", str);
        sendSingleMessage(IMMessage.createTxtMessage(str));
    }

    public void sendXbotTextMsg(String str) {
        boolean z = this.isRobot;
        if (!z) {
            ToastUtils.showShort(this, getString(R.string.ykfsdk_ykf_not_robot_send));
            return;
        }
        if (z && !this.hasSendRobotMsg) {
            this.hasSendRobotMsg = true;
            setChatMoreList();
        }
        if (!this.isRobot && !this.hasSendPersonMsg) {
            this.hasSendPersonMsg = true;
            setChatMoreList();
        }
        MoorLogUtils.aTag("send", str);
        sendSingleMessage(IMMessage.createTxtMessage(str));
    }

    public void showXbotfrom() {
        FromToMessage fromToMessage = MessageDao.getInstance().getisFristXbotFormMessages();
        if (fromToMessage != null) {
            XbotForm xbotForm = (XbotForm) new Gson().n(fromToMessage.xbotForm, XbotForm.class);
            BottomXbotFormDialog.init(xbotForm.formName, xbotForm, fromToMessage._id).show(getSupportFragmentManager(), "");
            MessageDao.getInstance().upFristXbotForm();
        }
    }

    public void startReStartDialog() {
        final CommonBottomSheetDialog instance = CommonBottomSheetDialog.instance(getString(R.string.ykfsdk_ykf_chatfinish_reopen), getString(R.string.ykfsdk_ykf_chatbegin), getString(R.string.ykfsdk_back));
        instance.setListener(new CommonBottomSheetDialog.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.22
            {
                ChatActivity.this = this;
            }

            @Override // com.m7.imkfsdk.chat.dialog.CommonBottomSheetDialog.OnClickListener
            public void onClickNegative() {
                instance.close(false);
                IMChatManager.getInstance().quitSDk();
                ChatActivity.this.finish();
            }

            @Override // com.m7.imkfsdk.chat.dialog.CommonBottomSheetDialog.OnClickListener
            public void onClickPositive() {
                instance.close(false);
                ChatActivity.this.getIsGoSchedule();
            }
        });
        instance.show(getSupportFragmentManager(), "");
    }

    public void startReStartDialog3() {
        final CommonBottomSheetDialog instance = CommonBottomSheetDialog.instance(getString(R.string.ykfsdk_ykf_nonetwork_error), getString(R.string.ykfsdk_ykf_chatbegin_reconnect), "");
        instance.setListener(new CommonBottomSheetDialog.OnClickListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.23
            {
                ChatActivity.this = this;
            }

            @Override // com.m7.imkfsdk.chat.dialog.CommonBottomSheetDialog.OnClickListener
            public void onClickNegative() {
            }

            @Override // com.m7.imkfsdk.chat.dialog.CommonBottomSheetDialog.OnClickListener
            public void onClickPositive() {
                instance.close(false);
                IMChatManager.getInstance().quitSDk();
                ChatActivity.this.finish();
            }
        });
        if (isFinishing()) {
            return;
        }
        instance.show(getSupportFragmentManager(), "");
    }

    @Override // com.m7.imkfsdk.view.ChatListView.OnRefreshListener
    public void toRefresh() {
        if (this.JZflag.booleanValue()) {
            this.JZflag = Boolean.FALSE;
            new Thread() { // from class: com.m7.imkfsdk.chat.ChatActivity.14
                {
                    ChatActivity.this = this;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(300L);
                        ChatActivity.this.handler.sendEmptyMessage(2);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }.start();
        }
    }

    public void updateMessage() {
        this.pageSize = 2;
        this.fromToMessage = IMChatManager.getInstance().getMessages(1);
        this.descFromToMessage.clear();
        Collections.reverse(this.fromToMessage);
        this.descFromToMessage.addAll(this.fromToMessage);
        if (IMChatManager.getInstance().isReachEndMessage(this.descFromToMessage.size())) {
            this.mChatList.dismiss();
        } else {
            this.mChatList.visible();
        }
        this.chatAdapter.notifyDataSetChanged();
        scrollToBottom();
        IMChatManager.getInstance().resetMsgUnReadCount();
        this.mOtherName.setText(this.titleName);
        if (this.handler.hasMessages(HANDLER_NO_WRITING)) {
            this.handler.removeMessages(HANDLER_NO_WRITING);
        }
        showXbotfrom();
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(ReSendMessage reSendMessage) {
        updateMessage();
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(VoiceToTextEvent voiceToTextEvent) {
        stopTimer();
        if (voiceToTextEvent != null) {
            if (!"VoiceToTextEvent_nullID".equals(voiceToTextEvent.id)) {
                FromToMessage messageById = MessageDao.getInstance().getMessageById(voiceToTextEvent.id);
                if (messageById.isRobot) {
                    if (VoiceToTextEvent.STATUS_OK.equals(voiceToTextEvent.status_code)) {
                        sendVoiceAutoText(messageById, voiceToTextEvent.toText, true);
                    } else {
                        sendVoiceAutoText(messageById, "", false);
                    }
                } else {
                    if (VoiceToTextEvent.STATUS_OK.equals(voiceToTextEvent.status_code)) {
                        messageById.voiceToText = voiceToTextEvent.toText;
                        messageById.isShowVtoT = true;
                    } else if (VoiceToTextEvent.STATUS_FAIL.equals(voiceToTextEvent.status_code)) {
                        ToastUtils.showLong(this, ((Object) getText(R.string.ykfsdk_voice_to_text_error)) + getString(R.string.ykfsdk_ykf_autotext_fail_reclick));
                    } else if ("400".equals(voiceToTextEvent.status_code)) {
                        ToastUtils.showLong(this, ((Object) getText(R.string.ykfsdk_voice_to_text_error)) + getString(R.string.ykfsdk_ykf_autotext_fail_reclick));
                    } else if (VoiceToTextEvent.STATUS_UNDEFINED.equals(voiceToTextEvent.status_code)) {
                        ToastUtils.showLong(this, ((Object) getText(R.string.ykfsdk_voice_to_text_error)) + getString(R.string.ykfsdk_ykf_autotext_fail_nocheck));
                    } else if (VoiceToTextEvent.STATUS_TOLONG.equals(voiceToTextEvent.status_code)) {
                        ToastUtils.showLong(this, getString(R.string.ykfsdk_ykf_autotext_fail_solong));
                    }
                    messageById.isCacheShowVtoT = false;
                    MessageDao.getInstance().updateMsgToDao(messageById);
                    for (int i2 = 0; i2 < this.descFromToMessage.size(); i2++) {
                        if (!TextUtils.isEmpty(this.descFromToMessage.get(i2)._id) && this.descFromToMessage.get(i2)._id.equals(messageById._id)) {
                            this.descFromToMessage.set(i2, messageById);
                        }
                    }
                }
                this.chatAdapter.notifyDataSetChanged();
                return;
            }
            ToastUtils.showShort(this, ((Object) getText(R.string.ykfsdk_voice_to_text_error)) + ":VoiceToTextEvent_nullID");
        }
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MsgunReadToReadEvent msgunReadToReadEvent) {
        MessageDao.getInstance().updateUnReadToRead();
        for (int i2 = 0; i2 < this.descFromToMessage.size(); i2++) {
            if (Bugly.SDK_IS_DEV.equals(this.descFromToMessage.get(i2).dealUserMsg) && "true".equals(this.descFromToMessage.get(i2).sendState)) {
                this.descFromToMessage.get(i2).dealUserMsg = "true";
            }
        }
        this.chatAdapter.notifyDataSetChanged();
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MsgEvent msgEvent) {
        ChatHandler chatHandler;
        if (!this.isFront || (chatHandler = this.handler) == null) {
            return;
        }
        chatHandler.postDelayed(new Runnable() { // from class: com.m7.imkfsdk.chat.ChatActivity.29
            {
                ChatActivity.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < ChatActivity.this.descFromToMessage.size(); i2++) {
                    FromToMessage fromToMessage = (FromToMessage) ChatActivity.this.descFromToMessage.get(i2);
                    if ("1".equals(fromToMessage.userType) && !fromToMessage.dealMsg) {
                        arrayList.add(fromToMessage._id);
                    }
                }
                HttpManager.sdkDealImMsg(arrayList, new HttpResponseListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.29.1
                    {
                        AnonymousClass29.this = this;
                    }

                    @Override // com.moor.imkf.listener.HttpResponseListener
                    public void onFailed() {
                    }

                    @Override // com.moor.imkf.listener.HttpResponseListener
                    public void onSuccess(String str) {
                        MoorLogUtils.aTag("消费坐席发送来的消息返回值", str);
                    }
                });
            }
        }, 700L);
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(TransferAgent transferAgent) {
        IMChatManager.getInstance().convertManual(transferAgent.peerid, new OnConvertManualListener() { // from class: com.m7.imkfsdk.chat.ChatActivity.30
            {
                ChatActivity.this = this;
            }

            @Override // com.moor.imkf.listener.OnConvertManualListener
            public void offLine() {
                if (ChatActivity.this.type.equals(YKFConstants.TYPE_SCHEDULE)) {
                    return;
                }
                ChatActivity.this.showOffLineDialog();
                IMChatManager.getInstance().setIsShowBottomList(false);
                ChatActivity.this.rvTagLabel.setVisibility(8);
            }

            @Override // com.moor.imkf.listener.OnConvertManualListener
            public void onLine() {
                if (ChatActivity.this.type.equals(YKFConstants.TYPE_SCHEDULE)) {
                    return;
                }
                ChatActivity.this.chat_tv_convert.setVisibility(8);
                ChatActivity.this.bar_bottom.setVisibility(0);
                TextView textView = ChatActivity.this.mOtherName;
                int i2 = R.string.ykfsdk_wait_link;
                textView.setText(i2);
                ChatActivity chatActivity = ChatActivity.this;
                chatActivity.titleName = chatActivity.getString(i2);
                Toast.makeText(ChatActivity.this.getApplicationContext(), R.string.ykfsdk_topeoplesucceed, 0).show();
                IMChatManager.getInstance().setIsShowBottomList(false);
                ChatActivity.this.rvTagLabel.setVisibility(8);
            }
        });
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(XbotFormEvent xbotFormEvent) {
        String str = xbotFormEvent.xbotForm;
        if (str != null) {
            sendSingleMessage(IMMessage.createXbotFormMessage(str));
        }
    }
}
