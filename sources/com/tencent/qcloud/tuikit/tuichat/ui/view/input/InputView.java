package com.tencent.qcloud.tuikit.tuichat.ui.view.input;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.moor.imkf.model.entity.FromToMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.FileUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.DraftInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.component.camera.CameraActivity;
import com.tencent.qcloud.tuikit.tuichat.component.face.Emoji;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IChatLayout;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IInputLayout;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.PictureDialog;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.face.FaceFragment;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.inputmore.InputMoreFragment;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class InputView extends LinearLayout implements IInputLayout, View.OnClickListener, TextWatcher {
    public static final int AUDIO_RECORD = 2;
    public static final int CALL_MEMBER_LIMIT = 8;
    public static final int CAPTURE = 1;
    public static final int SEND_FILE = 5;
    public static final int SEND_PHOTO = 4;
    private static final int STATE_ACTION_INPUT = 3;
    private static final int STATE_FACE_INPUT = 2;
    private static final int STATE_NONE_INPUT = -1;
    private static final int STATE_SOFT_INPUT = 0;
    private static final int STATE_VOICE_INPUT = 1;
    private static final String TAG = InputView.class.getSimpleName();
    private Map<String, String> atUserInfoMap;
    private String displayInputString;
    private boolean isReplyModel;
    public AppCompatActivity mActivity;
    private boolean mAudioCancel;
    public boolean mAudioInputDisable;
    public ImageView mAudioInputSwitchButton;
    private boolean mCaptureDisable;
    public ChatInfo mChatInfo;
    private ChatInputHandler mChatInputHandler;
    private IChatLayout mChatLayout;
    private int mCurrentState;
    public ImageView mEmojiInputButton;
    public boolean mEmojiInputDisable;
    private FaceFragment mFaceFragment;
    private FragmentManager mFragmentManager;
    private String mInputContent;
    public List<InputMoreActionUnit> mInputMoreActionList;
    public List<InputMoreActionUnit> mInputMoreCustomActionList;
    private InputMoreFragment mInputMoreFragment;
    public View mInputMoreLayout;
    public View mInputMoreView;
    private int mLastMsgLineCount;
    private MessageHandler mMessageHandler;
    public ImageView mMoreInputButton;
    public boolean mMoreInputDisable;
    public Object mMoreInputEvent;
    private AlertDialog mPermissionDialog;
    public Button mSendAudioButton;
    private boolean mSendEnable;
    private boolean mSendFileDisable;
    private boolean mSendPhotoDisable;
    public Button mSendTextButton;
    private OnStartActivityListener mStartActivityListener;
    private float mStartRecordY;
    public TIMMentionEditText mTextInput;
    private boolean mVideoRecordDisable;
    private ChatPresenter presenter;
    private ImageView replyCloseBtn;
    private View replyLayout;
    private ReplyPreviewBean replyPreviewBean;
    private TextView replyTv;

    /* renamed from: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView$13  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass13 implements PermissionHelper.PermissionCallback {
        public AnonymousClass13() {
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
        public void onDenied() {
            TUIChatLog.i(InputView.TAG, "startVideoRecord checkPermission failed");
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
        public void onGranted() {
            InputView.this.requestPermission(2, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.13.1
                @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                public void onDenied() {
                    TUIChatLog.i(InputView.TAG, "startVideoRecord checkPermission failed");
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                public void onGranted() {
                    Intent intent = new Intent(InputView.this.getContext(), CameraActivity.class);
                    intent.putExtra(TUIChatConstants.CAMERA_TYPE, 258);
                    CameraActivity.mCallBack = new IUIKitCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.13.1.1
                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onError(String str, int i2, String str2) {
                        }

                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onSuccess(Object obj) {
                            Intent intent2 = (Intent) obj;
                            TUIMessageBean buildVideoMessage = ChatMessageBuilder.buildVideoMessage(intent2.getStringExtra(TUIChatConstants.CAMERA_IMAGE_PATH), intent2.getStringExtra(TUIChatConstants.CAMERA_VIDEO_PATH), intent2.getIntExtra(TUIChatConstants.IMAGE_WIDTH, 0), intent2.getIntExtra(TUIChatConstants.IMAGE_HEIGHT, 0), intent2.getLongExtra(TUIChatConstants.VIDEO_TIME, 0L));
                            if (InputView.this.mMessageHandler != null) {
                                InputView.this.mMessageHandler.sendMessage(buildVideoMessage);
                                InputView.this.hideSoftInput();
                            }
                        }
                    };
                    InputView.this.setOpenPhotoCallback();
                    InputView.this.mInputMoreFragment.startActivityForResult(intent, 1012);
                }
            });
        }
    }

    /* renamed from: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView$28  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass28 extends InputMoreActionUnit.OnActionClickListener {
        public final /* synthetic */ InputMoreActionUnit val$videoUnit;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass28(InputMoreActionUnit inputMoreActionUnit, InputMoreActionUnit inputMoreActionUnit2) {
            super();
            this.val$videoUnit = inputMoreActionUnit2;
            Objects.requireNonNull(inputMoreActionUnit);
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit.OnActionClickListener
        public void onClick() {
            PermissionHelper.requestPermission(1, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.28.1
                @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                public void onDenied() {
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                public void onGranted() {
                    PermissionHelper.requestPermission(2, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.28.1.1
                        @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                        public void onDenied() {
                        }

                        @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                        public void onGranted() {
                            AnonymousClass28 anonymousClass28 = AnonymousClass28.this;
                            InputView.this.onCustomActionClick(anonymousClass28.val$videoUnit.getActionId());
                        }
                    });
                }
            });
        }
    }

    /* renamed from: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass4 implements View.OnTouchListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, final MotionEvent motionEvent) {
            String str = InputView.TAG;
            TUIChatLog.i(str, "mSendAudioButton onTouch action:" + motionEvent.getAction());
            InputView.this.requestPermission(2, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.4.1
                @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                public void onDenied() {
                    TUIChatLog.i(InputView.TAG, "audio record checkPermission failed");
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                public void onGranted() {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        InputView.this.mAudioCancel = true;
                        InputView.this.mStartRecordY = motionEvent.getY();
                        if (InputView.this.mChatInputHandler != null) {
                            InputView.this.mChatInputHandler.onRecordStatusChanged(1);
                        }
                        InputView.this.mSendAudioButton.setText(TUIChatService.getAppContext().getString(R.string.release_end));
                        AudioPlayer.getInstance().startRecord(new AudioPlayer.Callback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.4.1.1
                            @Override // com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer.Callback
                            public void onCompletion(Boolean bool) {
                                InputView.this.recordComplete(bool.booleanValue());
                            }
                        });
                        return;
                    }
                    if (action != 1) {
                        if (action == 2) {
                            if (motionEvent.getY() - InputView.this.mStartRecordY < -100.0f) {
                                InputView.this.mAudioCancel = true;
                                if (InputView.this.mChatInputHandler != null) {
                                    InputView.this.mChatInputHandler.onRecordStatusChanged(3);
                                }
                            } else {
                                if (InputView.this.mAudioCancel && InputView.this.mChatInputHandler != null) {
                                    InputView.this.mChatInputHandler.onRecordStatusChanged(1);
                                }
                                InputView.this.mAudioCancel = false;
                            }
                            InputView.this.mSendAudioButton.setText(TUIChatService.getAppContext().getString(R.string.release_end));
                            return;
                        } else if (action != 3) {
                            return;
                        }
                    }
                    InputView.this.mAudioCancel = motionEvent.getY() - InputView.this.mStartRecordY < -100.0f;
                    if (InputView.this.mChatInputHandler != null) {
                        InputView.this.mChatInputHandler.onRecordStatusChanged(2);
                    }
                    AudioPlayer.getInstance().stopRecord();
                    InputView.this.mSendAudioButton.setText(TUIChatService.getAppContext().getString(R.string.hold_say));
                }
            });
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public interface ChatInputHandler {
        public static final int RECORD_CANCEL = 3;
        public static final int RECORD_FAILED = 5;
        public static final int RECORD_START = 1;
        public static final int RECORD_STOP = 2;
        public static final int RECORD_TOO_SHORT = 4;

        void onInputAreaClick();

        void onRecordStatusChanged(int i2);
    }

    /* loaded from: classes3.dex */
    public interface MessageHandler {
        void scrollToEnd();

        void sendMessage(TUIMessageBean tUIMessageBean);
    }

    /* loaded from: classes3.dex */
    public interface OnStartActivityListener {
        void onStartGroupMemberSelectActivity();
    }

    public InputView(Context context) {
        super(context);
        this.mInputMoreActionList = new ArrayList();
        this.mInputMoreCustomActionList = new ArrayList();
        this.atUserInfoMap = new HashMap();
        this.isReplyModel = false;
        initViews();
    }

    private void addActionsFromListeners() {
        if (this.mChatInfo == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("chatId", this.mChatInfo.getId());
        hashMap.put(TUIConstants.TUIChat.CHAT_NAME, this.mChatInfo.getChatName());
        hashMap.put(TUIConstants.TUIChat.CHAT_TYPE, Integer.valueOf(this.mChatInfo.getType()));
        hashMap.put("context", getContext());
        Map<String, Object> extensionInfo = TUICore.getExtensionInfo(TUIConstants.TUIChat.EXTENSION_INPUT_MORE_AUDIO_CALL, hashMap);
        if (extensionInfo != null) {
            int intValue = ((Integer) extensionInfo.get(TUIConstants.TUIChat.INPUT_MORE_ACTION_ID)).intValue();
            InputMoreActionUnit inputMoreActionUnit = new InputMoreActionUnit();
            inputMoreActionUnit.setActionId(intValue);
            inputMoreActionUnit.setUnitView((View) extensionInfo.get(TUIConstants.TUIChat.INPUT_MORE_VIEW));
            inputMoreActionUnit.setPriority(2);
            inputMoreActionUnit.setOnClickListener(new InputMoreActionUnit.OnActionClickListener(inputMoreActionUnit, inputMoreActionUnit) { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.27
                public final /* synthetic */ InputMoreActionUnit val$audioUnit;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                    this.val$audioUnit = inputMoreActionUnit;
                    Objects.requireNonNull(inputMoreActionUnit);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit.OnActionClickListener
                public void onClick() {
                    PermissionHelper.requestPermission(1, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.27.1
                        @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                        public void onDenied() {
                        }

                        @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                        public void onGranted() {
                            AnonymousClass27 anonymousClass27 = AnonymousClass27.this;
                            InputView.this.onCustomActionClick(anonymousClass27.val$audioUnit.getActionId());
                        }
                    });
                }
            });
            this.mInputMoreActionList.add(inputMoreActionUnit);
        }
        Map<String, Object> extensionInfo2 = TUICore.getExtensionInfo(TUIConstants.TUIChat.EXTENSION_INPUT_MORE_VIDEO_CALL, hashMap);
        if (extensionInfo2 != null) {
            int intValue2 = ((Integer) extensionInfo2.get(TUIConstants.TUIChat.INPUT_MORE_ACTION_ID)).intValue();
            InputMoreActionUnit inputMoreActionUnit2 = new InputMoreActionUnit();
            inputMoreActionUnit2.setActionId(intValue2);
            inputMoreActionUnit2.setUnitView((View) extensionInfo2.get(TUIConstants.TUIChat.INPUT_MORE_VIEW));
            inputMoreActionUnit2.setPriority(1);
            inputMoreActionUnit2.setOnClickListener(new AnonymousClass28(inputMoreActionUnit2, inputMoreActionUnit2));
            this.mInputMoreActionList.add(inputMoreActionUnit2);
        }
        Map<String, Object> extensionInfo3 = TUICore.getExtensionInfo(TUIConstants.TUIChat.EXTENSION_INPUT_MORE_CUSTOM_MESSAGE, hashMap);
        if (extensionInfo3 != null) {
            InputMoreActionUnit inputMoreActionUnit3 = new InputMoreActionUnit();
            inputMoreActionUnit3.setActionId(((Integer) extensionInfo3.get(TUIConstants.TUIChat.INPUT_MORE_ACTION_ID)).intValue());
            inputMoreActionUnit3.setIconResId(((Integer) extensionInfo3.get("icon")).intValue());
            inputMoreActionUnit3.setTitleId(((Integer) extensionInfo3.get("title")).intValue());
            inputMoreActionUnit3.setPriority(10);
            inputMoreActionUnit3.setOnClickListener(new InputMoreActionUnit.OnActionClickListener(inputMoreActionUnit3, inputMoreActionUnit3) { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.29
                public final /* synthetic */ InputMoreActionUnit val$unit;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                    this.val$unit = inputMoreActionUnit3;
                    Objects.requireNonNull(inputMoreActionUnit3);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit.OnActionClickListener
                public void onClick() {
                    InputView.this.onCustomActionClick(this.val$unit.getActionId());
                }
            });
            this.mInputMoreActionList.add(inputMoreActionUnit3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TUIMessageBean buildVideoMessage(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L, 1);
            if (frameAtTime == null) {
                TUIChatLog.e(TAG, "buildVideoMessage() bitmap is null");
                return null;
            }
            return ChatMessageBuilder.buildVideoMessage(FileUtil.saveBitmap("JCamera", frameAtTime), str, frameAtTime.getWidth(), frameAtTime.getHeight(), Long.valueOf(extractMetadata).longValue());
        } catch (Exception e2) {
            String str2 = TAG;
            TUIChatLog.e(str2, "MediaMetadataRetriever exception " + e2);
            return null;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map<java.lang.String, java.lang.String> getDisplayAtNameMap(java.util.List<java.lang.String> r9, java.util.List<java.lang.String> r10) {
        /*
            r8 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText r1 = r8.mTextInput
            java.lang.String r2 = "@"
            if (r1 == 0) goto L2a
            android.text.Editable r1 = r1.getText()
            com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText r3 = r8.mTextInput
            int r3 = r3.getSelectionEnd()
            if (r1 == 0) goto L2a
            if (r3 <= 0) goto L2a
            java.lang.String r1 = r1.toString()
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 != 0) goto L2a
            int r4 = r3 + (-1)
            java.lang.String r1 = r1.substring(r4, r3)
            goto L2b
        L2a:
            r1 = r2
        L2b:
            r3 = 0
            r4 = 0
        L2d:
            int r5 = r10.size()
            if (r4 >= r5) goto Lda
            java.lang.String r5 = " "
            if (r4 != 0) goto L87
            java.lang.Object r6 = r9.get(r3)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L65
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r1)
            java.lang.Object r7 = r10.get(r3)
            java.lang.String r7 = (java.lang.String) r7
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.Object r6 = r10.get(r3)
            java.lang.String r6 = (java.lang.String) r6
            r0.put(r5, r6)
            goto Ld6
        L65:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r1)
            java.lang.Object r7 = r9.get(r3)
            java.lang.String r7 = (java.lang.String) r7
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.Object r6 = r10.get(r3)
            java.lang.String r6 = (java.lang.String) r6
            r0.put(r5, r6)
            goto Ld6
        L87:
            java.lang.Object r6 = r9.get(r4)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto La9
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.Object r7 = r10.get(r4)
            java.lang.String r7 = (java.lang.String) r7
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            goto Lbe
        La9:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.Object r7 = r9.get(r4)
            java.lang.String r7 = (java.lang.String) r7
            r6.append(r7)
            java.lang.String r6 = r6.toString()
        Lbe:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            java.lang.Object r6 = r10.get(r4)
            java.lang.String r6 = (java.lang.String) r6
            r0.put(r5, r6)
        Ld6:
            int r4 = r4 + 1
            goto L2d
        Lda:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.getDisplayAtNameMap(java.util.List, java.util.List):java.util.Map");
    }

    private int getNavigateBarHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i3 = displayMetrics.heightPixels;
        if (i3 > i2) {
            return i3 - i2;
        }
        return 0;
    }

    private void hideInputMoreLayout() {
        this.mInputMoreView.setVisibility(8);
    }

    private void initViews() {
        AppCompatActivity appCompatActivity = (AppCompatActivity) getContext();
        this.mActivity = appCompatActivity;
        LinearLayout.inflate(appCompatActivity, R.layout.chat_input_layout, this);
        this.mInputMoreView = findViewById(R.id.more_groups);
        this.mSendAudioButton = (Button) findViewById(R.id.chat_voice_input);
        this.mAudioInputSwitchButton = (ImageView) findViewById(R.id.voice_input_switch);
        this.mEmojiInputButton = (ImageView) findViewById(R.id.face_btn);
        this.mMoreInputButton = (ImageView) findViewById(R.id.more_btn);
        this.mSendTextButton = (Button) findViewById(R.id.send_btn);
        this.mTextInput = (TIMMentionEditText) findViewById(R.id.chat_message_input);
        this.replyLayout = findViewById(R.id.reply_preview_bar);
        this.replyTv = (TextView) findViewById(R.id.reply_text);
        this.replyCloseBtn = (ImageView) findViewById(R.id.reply_close_btn);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.chat_input_icon_size);
        ViewGroup.LayoutParams layoutParams = this.mEmojiInputButton.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize;
        this.mEmojiInputButton.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.mAudioInputSwitchButton.getLayoutParams();
        layoutParams2.width = dimensionPixelSize;
        layoutParams2.height = dimensionPixelSize;
        this.mAudioInputSwitchButton.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.mMoreInputButton.getLayoutParams();
        layoutParams3.width = dimensionPixelSize;
        layoutParams3.height = dimensionPixelSize;
        this.mMoreInputButton.setLayoutParams(layoutParams3);
        init();
    }

    private boolean isSoftInputShown() {
        View decorView = ((Activity) getContext()).getWindow().getDecorView();
        int height = decorView.getHeight();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        return (height - rect.bottom) - getNavigateBarHeight() >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCustomActionClick(int i2) {
        if (i2 != 1 && i2 != 2) {
            HashMap hashMap = new HashMap();
            hashMap.put(TUIConstants.TUIChat.INPUT_MORE_ACTION_ID, Integer.valueOf(i2));
            hashMap.put("chatId", this.mChatInfo.getId());
            hashMap.put(TUIConstants.TUIChat.CHAT_NAME, this.mChatInfo.getChatName());
            hashMap.put(TUIConstants.TUIChat.CHAT_TYPE, Integer.valueOf(this.mChatInfo.getType()));
            TUICore.notifyEvent(TUIConstants.TUIChat.EVENT_KEY_INPUT_MORE, TUIConstants.TUIChat.EVENT_SUB_KEY_ON_CLICK, hashMap);
            return;
        }
        String str = i2 == 1 ? TUIConstants.TUICalling.TYPE_AUDIO : "video";
        if (TUIChatUtils.isGroupChat(getChatInfo().getType())) {
            Bundle bundle = new Bundle();
            bundle.putString("groupId", getChatInfo().getId());
            bundle.putString("type", str);
            bundle.putString("group_id", getChatInfo().getId());
            bundle.putBoolean("isSelectForCall", true);
            bundle.putInt("limit", 8);
            TUICore.startActivity(getContext(), "StartGroupMemberSelectActivity", bundle, 11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordComplete(boolean z) {
        int duration = AudioPlayer.getInstance().getDuration();
        String str = TAG;
        TUIChatLog.i(str, "recordComplete duration:" + duration);
        ChatInputHandler chatInputHandler = this.mChatInputHandler;
        if (chatInputHandler != null) {
            if (z && duration != 0) {
                if (this.mAudioCancel) {
                    chatInputHandler.onRecordStatusChanged(3);
                    return;
                } else if (duration < 1000) {
                    chatInputHandler.onRecordStatusChanged(4);
                    return;
                } else {
                    chatInputHandler.onRecordStatusChanged(2);
                }
            } else {
                chatInputHandler.onRecordStatusChanged(5);
                return;
            }
        }
        MessageHandler messageHandler = this.mMessageHandler;
        if (messageHandler == null || !z) {
            return;
        }
        messageHandler.sendMessage(ChatMessageBuilder.buildAudioMessage(AudioPlayer.getInstance().getPath(), duration));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOpenPhotoCallback() {
        this.mInputMoreFragment.setCallback(new IUIKitCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.11
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                String str3 = InputView.TAG;
                TUIChatLog.i(str3, "errCode: " + i2);
                ToastUtil.toastLongMessage(str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Object obj) {
                String str = InputView.TAG;
                TUIChatLog.i(str, "onSuccess: " + obj);
                if (obj == null) {
                    TUIChatLog.e(InputView.TAG, "data is null");
                } else if (TextUtils.isEmpty(obj.toString())) {
                    TUIChatLog.e(InputView.TAG, "uri is empty");
                } else {
                    Uri uri = (Uri) obj;
                    String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(FileUtil.getFileExtensionFromUrl(FileUtil.getFileName(TUIChatService.getAppContext(), uri)));
                    if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                        TUIChatLog.e(InputView.TAG, "mimeType is empty.");
                    } else if (mimeTypeFromExtension.contains("video")) {
                        TUIMessageBean buildVideoMessage = InputView.this.buildVideoMessage(FileUtil.getPathFromUri(uri));
                        if (buildVideoMessage == null) {
                            String str2 = InputView.TAG;
                            TUIChatLog.e(str2, "start send video error data: " + obj);
                        } else if (InputView.this.mMessageHandler != null) {
                            InputView.this.mMessageHandler.sendMessage(buildVideoMessage);
                            InputView.this.hideSoftInput();
                        }
                    } else if (!mimeTypeFromExtension.contains(FromToMessage.MSG_TYPE_IMAGE)) {
                        String str3 = InputView.TAG;
                        TUIChatLog.e(str3, "Send photo or video failed , invalid mimeType : " + mimeTypeFromExtension);
                    } else {
                        TUIMessageBean buildImageMessage = ChatMessageBuilder.buildImageMessage(uri);
                        if (InputView.this.mMessageHandler != null) {
                            InputView.this.mMessageHandler.sendMessage(buildImageMessage);
                            InputView.this.hideSoftInput();
                        }
                    }
                }
            }
        });
    }

    private void showCustomInputMoreFragment() {
        TUIChatLog.i(TAG, "showCustomInputMoreFragment");
        if (this.mFragmentManager == null) {
            this.mFragmentManager = this.mActivity.getSupportFragmentManager();
        }
        hideSoftInput();
        this.mInputMoreView.setVisibility(0);
        this.mFragmentManager.beginTransaction().replace(R.id.more_groups, (BaseInputFragment) this.mMoreInputEvent).commitAllowingStateLoss();
        if (this.mChatInputHandler != null) {
            postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.18
                @Override // java.lang.Runnable
                public void run() {
                    InputView.this.mChatInputHandler.onInputAreaClick();
                }
            }, 100L);
        }
    }

    private void showFaceViewGroup() {
        TUIChatLog.i(TAG, "showFaceViewGroup");
        if (this.mFragmentManager == null) {
            this.mFragmentManager = this.mActivity.getSupportFragmentManager();
        }
        if (this.mFaceFragment == null) {
            this.mFaceFragment = new FaceFragment();
        }
        hideSoftInput();
        this.mInputMoreView.setVisibility(0);
        this.mTextInput.requestFocus();
        this.mFaceFragment.setListener(new FaceFragment.OnEmojiClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.16
            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.input.face.FaceFragment.OnEmojiClickListener
            public void onCustomFaceClick(int i2, Emoji emoji) {
                MessageHandler messageHandler = InputView.this.mMessageHandler;
                messageHandler.sendMessage(ChatMessageBuilder.buildFaceMessage(i2, emoji.getFilter() + ".gif"));
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.input.face.FaceFragment.OnEmojiClickListener
            public void onEmojiClick(Emoji emoji) {
                int selectionStart = InputView.this.mTextInput.getSelectionStart();
                Editable text = InputView.this.mTextInput.getText();
                text.insert(selectionStart, emoji.getFilter());
                FaceManager.handlerEmojiText(InputView.this.mTextInput, text.toString(), true);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.input.face.FaceFragment.OnEmojiClickListener
            public void onEmojiDelete() {
                boolean z;
                int selectionStart = InputView.this.mTextInput.getSelectionStart();
                Editable text = InputView.this.mTextInput.getText();
                if (selectionStart <= 0) {
                    return;
                }
                int i2 = selectionStart - 1;
                if (text.charAt(i2) == ']') {
                    int i3 = selectionStart - 2;
                    while (true) {
                        if (i3 < 0) {
                            break;
                        } else if (text.charAt(i3) != '[') {
                            i3--;
                        } else if (FaceManager.isFaceChar(text.subSequence(i3, selectionStart).toString())) {
                            text.delete(i3, selectionStart);
                            z = true;
                        }
                    }
                }
                z = false;
                if (z) {
                    return;
                }
                text.delete(i2, selectionStart);
            }
        });
        this.mFragmentManager.beginTransaction().replace(R.id.more_groups, this.mFaceFragment).commitAllowingStateLoss();
        if (this.mChatInputHandler != null) {
            postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.17
                @Override // java.lang.Runnable
                public void run() {
                    InputView.this.mChatInputHandler.onInputAreaClick();
                }
            }, 100L);
        }
    }

    private void showInputMoreLayout() {
        TUIChatLog.i(TAG, "showInputMoreLayout");
        if (this.mFragmentManager == null) {
            this.mFragmentManager = this.mActivity.getSupportFragmentManager();
        }
        if (this.mInputMoreFragment == null) {
            this.mInputMoreFragment = new InputMoreFragment();
        }
        assembleActions();
        this.mInputMoreFragment.setActions(this.mInputMoreActionList);
        hideSoftInput();
        PictureDialog pictureDialog = new PictureDialog(getContext(), new PictureDialog.PListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.19
            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.input.PictureDialog.PListener
            public void onClickPhoto() {
                InputView.this.startSendPhoto();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.input.PictureDialog.PListener
            public void onClickTakePhoto() {
                InputView.this.startCapture();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.input.PictureDialog.PListener
            public void onClickTakeVideo() {
                InputView.this.startVideoRecord();
            }
        });
        pictureDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.20
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                InputView.this.mCurrentState = -1;
            }
        });
        pictureDialog.show();
        this.mFragmentManager.beginTransaction().replace(R.id.more_groups, this.mInputMoreFragment).commitAllowingStateLoss();
        if (this.mChatInputHandler != null) {
            postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.21
                @Override // java.lang.Runnable
                public void run() {
                    InputView.this.mChatInputHandler.onInputAreaClick();
                }
            }, 100L);
        }
    }

    private void updateAtUserInfoMap(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        String str;
        this.displayInputString = "";
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            this.atUserInfoMap.put(arrayList2.get(i2), arrayList.get(i2));
            if (TextUtils.isEmpty(arrayList.get(i2))) {
                this.displayInputString += arrayList2.get(i2);
                this.displayInputString += ExpandableTextView.N;
                this.displayInputString += TIMMentionEditText.TIM_MENTION_TAG;
            } else {
                this.displayInputString += arrayList.get(i2);
                this.displayInputString += ExpandableTextView.N;
                this.displayInputString += TIMMentionEditText.TIM_MENTION_TAG;
            }
        }
        if (this.displayInputString.isEmpty()) {
            return;
        }
        this.displayInputString = this.displayInputString.substring(0, str.length() - 1);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IInputLayout
    public void addAction(InputMoreActionUnit inputMoreActionUnit) {
        this.mInputMoreCustomActionList.add(inputMoreActionUnit);
    }

    public void addInputText(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        updateAtUserInfoMap(new ArrayList<String>(str) { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.7
            public final /* synthetic */ String val$name;

            {
                this.val$name = str;
                add(str);
            }
        }, new ArrayList<String>(str2) { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.8
            public final /* synthetic */ String val$id;

            {
                this.val$id = str2;
                add(str2);
            }
        });
        if (this.mTextInput != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(TIMMentionEditText.TIM_MENTION_TAG + this.displayInputString, str2);
            this.mTextInput.setMentionMap(hashMap);
            int selectionEnd = this.mTextInput.getSelectionEnd();
            if (selectionEnd != -1) {
                String str3 = TIMMentionEditText.TIM_MENTION_TAG + this.displayInputString;
                FaceManager.handlerEmojiText(this.mTextInput, this.mTextInput.getText().insert(selectionEnd, str3).toString(), true);
                this.mTextInput.setSelection(selectionEnd + str3.length());
            }
            showSoftInput();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(editable.toString().trim())) {
            this.mSendEnable = false;
            showSendTextButton(8);
            showMoreInputButton(0);
            return;
        }
        this.mSendEnable = true;
        showSendTextButton(0);
        showMoreInputButton(8);
        if (this.mTextInput.getLineCount() != this.mLastMsgLineCount) {
            this.mLastMsgLineCount = this.mTextInput.getLineCount();
            ChatInputHandler chatInputHandler = this.mChatInputHandler;
            if (chatInputHandler != null) {
                chatInputHandler.onInputAreaClick();
            }
        }
        if (TextUtils.equals(this.mInputContent, this.mTextInput.getText().toString())) {
            return;
        }
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        FaceManager.handlerEmojiText(tIMMentionEditText, tIMMentionEditText.getText().toString(), true);
    }

    public void appendText(String str) {
        if (this.mChatInfo == null) {
            TUIChatLog.e(TAG, "appendText error :  chatInfo is null");
            return;
        }
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        if (tIMMentionEditText == null) {
            TUIChatLog.e(TAG, "appendText error :  textInput is null");
            return;
        }
        String obj = tIMMentionEditText.getText().toString();
        this.mTextInput.setText(obj + str);
        TIMMentionEditText tIMMentionEditText2 = this.mTextInput;
        tIMMentionEditText2.setSelection(tIMMentionEditText2.getText().length());
    }

    public void assembleActions() {
        this.mInputMoreActionList.clear();
        if (!this.mSendPhotoDisable) {
            InputMoreActionUnit inputMoreActionUnit = new InputMoreActionUnit() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.22
                @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit
                public void onAction(String str, int i2) {
                    InputView.this.startSendPhoto();
                }
            };
            inputMoreActionUnit.setIconResId(R.drawable.ic_more_picture);
            inputMoreActionUnit.setTitleId(R.string.pic);
            this.mInputMoreActionList.add(inputMoreActionUnit);
        }
        if (!this.mCaptureDisable) {
            InputMoreActionUnit inputMoreActionUnit2 = new InputMoreActionUnit() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.23
                @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit
                public void onAction(String str, int i2) {
                    InputView.this.startCapture();
                }
            };
            inputMoreActionUnit2.setIconResId(R.drawable.ic_more_camera);
            inputMoreActionUnit2.setTitleId(R.string.photo);
            this.mInputMoreActionList.add(inputMoreActionUnit2);
        }
        if (!this.mVideoRecordDisable) {
            InputMoreActionUnit inputMoreActionUnit3 = new InputMoreActionUnit() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.24
                @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit
                public void onAction(String str, int i2) {
                    InputView.this.startVideoRecord();
                }
            };
            inputMoreActionUnit3.setIconResId(R.drawable.ic_more_video);
            inputMoreActionUnit3.setTitleId(R.string.video);
            this.mInputMoreActionList.add(inputMoreActionUnit3);
        }
        if (!this.mSendFileDisable) {
            InputMoreActionUnit inputMoreActionUnit4 = new InputMoreActionUnit() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.25
                @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit
                public void onAction(String str, int i2) {
                    InputView.this.startSendFile();
                }
            };
            inputMoreActionUnit4.setIconResId(R.drawable.ic_more_file);
            inputMoreActionUnit4.setTitleId(R.string.file);
            this.mInputMoreActionList.add(inputMoreActionUnit4);
        }
        addActionsFromListeners();
        this.mInputMoreActionList.addAll(this.mInputMoreCustomActionList);
        Collections.sort(this.mInputMoreActionList, new Comparator<InputMoreActionUnit>() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.26
            @Override // java.util.Comparator
            public int compare(InputMoreActionUnit inputMoreActionUnit5, InputMoreActionUnit inputMoreActionUnit6) {
                return inputMoreActionUnit5.getPriority() - inputMoreActionUnit6.getPriority();
            }
        });
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.mInputContent = charSequence.toString();
    }

    public void clearCustomActionList() {
        this.mInputMoreCustomActionList.clear();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IInputLayout
    public void disableAudioInput(boolean z) {
        this.mAudioInputDisable = z;
        if (z) {
            this.mAudioInputSwitchButton.setVisibility(8);
        } else {
            this.mAudioInputSwitchButton.setVisibility(0);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IInputLayout
    public void disableCaptureAction(boolean z) {
        this.mCaptureDisable = z;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IInputLayout
    public void disableEmojiInput(boolean z) {
        this.mEmojiInputDisable = z;
        if (z) {
            this.mEmojiInputButton.setVisibility(8);
        } else {
            this.mEmojiInputButton.setVisibility(0);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IInputLayout
    public void disableMoreInput(boolean z) {
        this.mMoreInputDisable = z;
        if (z) {
            this.mMoreInputButton.setVisibility(8);
        } else {
            this.mMoreInputButton.setVisibility(0);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IInputLayout
    public void disableSendFileAction(boolean z) {
        this.mSendFileDisable = z;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IInputLayout
    public void disableSendPhotoAction(boolean z) {
        this.mSendPhotoDisable = z;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IInputLayout
    public void disableVideoRecordAction(boolean z) {
        this.mVideoRecordDisable = z;
    }

    public void exitReply() {
        this.isReplyModel = false;
        this.replyPreviewBean = null;
        this.replyLayout.setVisibility(8);
    }

    public ChatInfo getChatInfo() {
        return this.mChatInfo;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IInputLayout
    public EditText getInputText() {
        return this.mTextInput;
    }

    public void hideSoftInput() {
        TUIChatLog.i(TAG, "hideSoftInput");
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mTextInput.getWindowToken(), 0);
        this.mTextInput.clearFocus();
        this.mInputMoreView.setVisibility(8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void init() {
        this.mAudioInputSwitchButton.setOnClickListener(this);
        this.mEmojiInputButton.setOnClickListener(this);
        this.mMoreInputButton.setOnClickListener(this);
        this.mSendTextButton.setOnClickListener(this);
        this.mTextInput.addTextChangedListener(this);
        this.mTextInput.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    InputView.this.presenter.clearMessageAndReLoad();
                    InputView.this.showSoftInput();
                    return false;
                }
                return false;
            }
        });
        this.mTextInput.setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (i2 == 67 && keyEvent.getAction() == 0 && InputView.this.isReplyModel && TextUtils.isEmpty(InputView.this.mTextInput.getText().toString())) {
                    InputView.this.exitReply();
                    return false;
                }
                return false;
            }
        });
        this.mTextInput.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 == 4) {
                    InputView inputView = InputView.this;
                    inputView.onClick(inputView.mSendTextButton);
                    return true;
                }
                return false;
            }
        });
        this.mSendAudioButton.setOnTouchListener(new AnonymousClass4());
        this.mTextInput.setOnMentionInputListener(new TIMMentionEditText.OnMentionInputListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.5
            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText.OnMentionInputListener
            public void onMentionCharacterInput(String str) {
                if ((str.equals(TIMMentionEditText.TIM_MENTION_TAG) || str.equals(TIMMentionEditText.TIM_MENTION_TAG_FULL)) && TUIChatUtils.isGroupChat(InputView.this.mChatLayout.getChatInfo().getType()) && InputView.this.mStartActivityListener != null) {
                    InputView.this.mStartActivityListener.onStartGroupMemberSelectActivity();
                }
            }
        });
        this.replyCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InputView.this.exitReply();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onClick id:");
        sb.append(view.getId());
        sb.append("|voice_input_switch:");
        int i2 = R.id.voice_input_switch;
        sb.append(i2);
        sb.append("|face_btn:");
        int i3 = R.id.face_btn;
        sb.append(i3);
        sb.append("|more_btn:");
        int i4 = R.id.more_btn;
        sb.append(i4);
        sb.append("|send_btn:");
        int i5 = R.id.send_btn;
        sb.append(i5);
        sb.append("|mCurrentState:");
        sb.append(this.mCurrentState);
        sb.append("|mSendEnable:");
        sb.append(this.mSendEnable);
        sb.append("|mMoreInputEvent:");
        sb.append(this.mMoreInputEvent);
        TUIChatLog.i(str, sb.toString());
        if (view.getId() == i2) {
            int i6 = this.mCurrentState;
            if (i6 == 2 || i6 == 3) {
                this.mCurrentState = 1;
                this.mInputMoreView.setVisibility(8);
                this.mEmojiInputButton.setImageResource(R.drawable.action_face_selector);
            } else if (i6 == 0) {
                this.mCurrentState = 1;
            } else {
                this.mCurrentState = 0;
            }
            if (this.mCurrentState == 1) {
                this.mSendAudioButton.setVisibility(0);
                this.mTextInput.setVisibility(8);
                this.mAudioInputSwitchButton.setImageResource(R.drawable.chat_input_keyboard);
                hideSoftInput();
                return;
            }
            this.mAudioInputSwitchButton.setImageResource(R.drawable.action_audio_selector);
            this.mSendAudioButton.setVisibility(8);
            this.mTextInput.setVisibility(0);
            showSoftInput();
        } else if (view.getId() == i3) {
            this.mAudioInputSwitchButton.setImageResource(R.drawable.action_audio_selector);
            if (this.mCurrentState == 1) {
                this.mCurrentState = -1;
                this.mSendAudioButton.setVisibility(8);
                this.mTextInput.setVisibility(0);
            }
            if (this.mCurrentState == 2) {
                this.mCurrentState = 0;
                this.mInputMoreView.setVisibility(8);
                this.mEmojiInputButton.setImageResource(R.drawable.action_face_selector);
                this.mTextInput.setVisibility(0);
                showSoftInput();
                return;
            }
            this.mCurrentState = 2;
            this.mEmojiInputButton.setImageResource(R.drawable.chat_input_keyboard);
            showFaceViewGroup();
        } else if (view.getId() == i4) {
            hideSoftInput();
            Object obj = this.mMoreInputEvent;
            if (obj instanceof View.OnClickListener) {
                ((View.OnClickListener) obj).onClick(view);
            } else if (obj instanceof BaseInputFragment) {
                showCustomInputMoreFragment();
            } else if (this.mCurrentState == 3) {
                this.mCurrentState = -1;
                if (this.mInputMoreView.getVisibility() == 0) {
                    this.mInputMoreView.setVisibility(8);
                } else {
                    this.mInputMoreView.setVisibility(0);
                }
            } else {
                showInputMoreLayout();
                this.mCurrentState = 3;
                this.mAudioInputSwitchButton.setImageResource(R.drawable.action_audio_selector);
                this.mEmojiInputButton.setImageResource(R.drawable.action_face_selector);
                this.mSendAudioButton.setVisibility(8);
                this.mTextInput.setVisibility(0);
            }
        } else if (view.getId() == i5 && this.mSendEnable) {
            if (this.mMessageHandler != null) {
                if (this.isReplyModel && this.replyPreviewBean != null) {
                    if (TUIChatUtils.isGroupChat(this.mChatLayout.getChatInfo().getType()) && !this.mTextInput.getMentionIdList().isEmpty()) {
                        this.mMessageHandler.sendMessage(ChatMessageBuilder.buildAtReplyMessage(this.mTextInput.getText().toString().trim(), new ArrayList(this.mTextInput.getMentionIdList()), this.replyPreviewBean));
                    } else {
                        this.mMessageHandler.sendMessage(ChatMessageBuilder.buildReplyMessage(this.mTextInput.getText().toString().trim(), this.replyPreviewBean));
                    }
                    exitReply();
                } else if (TUIChatUtils.isGroupChat(this.mChatLayout.getChatInfo().getType()) && !this.mTextInput.getMentionIdList().isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.mTextInput.getMentionIdList());
                    if (arrayList.isEmpty()) {
                        this.mMessageHandler.sendMessage(ChatMessageBuilder.buildTextMessage(this.mTextInput.getText().toString().trim()));
                    } else {
                        this.mMessageHandler.sendMessage(ChatMessageBuilder.buildTextAtMessage(arrayList, this.mTextInput.getText().toString().trim()));
                    }
                } else {
                    this.mMessageHandler.sendMessage(ChatMessageBuilder.buildTextMessage(this.mTextInput.getText().toString().trim()));
                }
            }
            this.mTextInput.setText("");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mTextInput.removeTextChangedListener(this);
        this.atUserInfoMap.clear();
    }

    public void onEmptyClick() {
        hideSoftInput();
        this.mCurrentState = 0;
        this.mEmojiInputButton.setImageResource(R.drawable.action_face_selector);
        this.mAudioInputSwitchButton.setImageResource(R.drawable.action_audio_selector);
        this.mSendAudioButton.setVisibility(8);
        this.mTextInput.setVisibility(0);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IInputLayout
    public void replaceMoreInput(BaseInputFragment baseInputFragment) {
        this.mMoreInputEvent = baseInputFragment;
    }

    public void requestPermission(int i2, PermissionHelper.PermissionCallback permissionCallback) {
        PermissionHelper.requestPermission(i2 != 1 ? i2 != 2 ? (i2 == 4 || i2 == 5) ? 3 : 0 : 1 : 2, permissionCallback);
    }

    public void setChatInfo(ChatInfo chatInfo) {
        DraftInfo draft;
        this.mChatInfo = chatInfo;
        if (chatInfo == null || (draft = chatInfo.getDraft()) == null || TextUtils.isEmpty(draft.getDraftText()) || this.mTextInput == null) {
            return;
        }
        Gson gson = new Gson();
        String draftText = draft.getDraftText();
        try {
            HashMap hashMap = (HashMap) gson.n(draft.getDraftText(), HashMap.class);
            if (hashMap != null) {
                String str = (String) hashMap.get("content");
                try {
                    ReplyPreviewBean replyPreviewBean = (ReplyPreviewBean) gson.n((String) hashMap.get("reply"), ReplyPreviewBean.class);
                    if (replyPreviewBean != null) {
                        showReplyPreview(replyPreviewBean);
                    }
                    draftText = str;
                } catch (JsonSyntaxException unused) {
                    draftText = str;
                    TUIChatLog.e(TAG, " getCustomJsonMap error ");
                    this.mTextInput.setText(draftText);
                    TIMMentionEditText tIMMentionEditText = this.mTextInput;
                    tIMMentionEditText.setSelection(tIMMentionEditText.getText().length());
                }
            }
        } catch (JsonSyntaxException unused2) {
        }
        this.mTextInput.setText(draftText);
        TIMMentionEditText tIMMentionEditText2 = this.mTextInput;
        tIMMentionEditText2.setSelection(tIMMentionEditText2.getText().length());
    }

    public void setChatInputHandler(ChatInputHandler chatInputHandler) {
        this.mChatInputHandler = chatInputHandler;
    }

    public void setChatLayout(IChatLayout iChatLayout) {
        this.mChatLayout = iChatLayout;
    }

    public void setDraft() {
        if (this.mChatInfo == null) {
            TUIChatLog.e(TAG, "set drafts error :  chatInfo is null");
            return;
        }
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        if (tIMMentionEditText == null) {
            TUIChatLog.e(TAG, "set drafts error :  textInput is null");
            return;
        }
        String obj = tIMMentionEditText.getText().toString();
        if (this.isReplyModel && this.replyPreviewBean != null) {
            Gson gson = new Gson();
            HashMap hashMap = new HashMap();
            hashMap.put("content", obj);
            hashMap.put("reply", gson.z(this.replyPreviewBean));
            obj = gson.z(hashMap);
        }
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.setDraft(obj);
        }
    }

    public void setMessageHandler(MessageHandler messageHandler) {
        this.mMessageHandler = messageHandler;
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
    }

    public void setStartActivityListener(OnStartActivityListener onStartActivityListener) {
        this.mStartActivityListener = onStartActivityListener;
    }

    public void showEmojiInputButton(int i2) {
        if (this.mEmojiInputDisable) {
            return;
        }
        this.mEmojiInputButton.setVisibility(i2);
    }

    public void showMoreInputButton(int i2) {
        if (this.mMoreInputDisable) {
            return;
        }
        this.mMoreInputButton.setVisibility(i2);
    }

    public void showReplyPreview(ReplyPreviewBean replyPreviewBean) {
        this.isReplyModel = true;
        this.replyPreviewBean = replyPreviewBean;
        String messageAbstract = replyPreviewBean.getMessageAbstract();
        String msgTypeStr = ChatMessageParser.getMsgTypeStr(replyPreviewBean.getMessageType());
        if (replyPreviewBean.getOriginalMessageBean() instanceof FileMessageBean) {
            this.replyTv.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else {
            this.replyTv.setEllipsize(TextUtils.TruncateAt.END);
        }
        this.replyTv.setText(FaceManager.emojiJudge(replyPreviewBean.getMessageSender() + " : " + msgTypeStr + ExpandableTextView.N + messageAbstract));
        this.replyLayout.setVisibility(0);
        MessageHandler messageHandler = this.mMessageHandler;
        if (messageHandler != null) {
            messageHandler.scrollToEnd();
        }
        showSoftInput();
    }

    public void showSendTextButton(int i2) {
    }

    public void showSoftInput() {
        TUIChatLog.i(TAG, "showSoftInput");
        hideInputMoreLayout();
        this.mAudioInputSwitchButton.setImageResource(R.drawable.action_audio_selector);
        this.mEmojiInputButton.setImageResource(R.drawable.chat_input_face);
        this.mCurrentState = 0;
        this.mSendAudioButton.setVisibility(8);
        this.mTextInput.setVisibility(0);
        this.mTextInput.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (!isSoftInputShown()) {
            inputMethodManager.toggleSoftInput(0, 0);
        }
        if (this.mChatInputHandler != null) {
            postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.15
                @Override // java.lang.Runnable
                public void run() {
                    InputView.this.mChatInputHandler.onInputAreaClick();
                }
            }, 200L);
        }
    }

    public void startCapture() {
        TUIChatLog.i(TAG, "startCapture");
        requestPermission(1, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.12
            @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
            public void onDenied() {
                TUIChatLog.i(InputView.TAG, "startCapture checkPermission failed");
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
            public void onGranted() {
                Intent intent = new Intent(InputView.this.getContext(), CameraActivity.class);
                intent.putExtra(TUIChatConstants.CAMERA_TYPE, 257);
                CameraActivity.mCallBack = new IUIKitCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.12.1
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i2, String str2) {
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(Object obj) {
                        TUIMessageBean buildImageMessage = ChatMessageBuilder.buildImageMessage(Uri.fromFile(new File(obj.toString())));
                        if (InputView.this.mMessageHandler != null) {
                            InputView.this.mMessageHandler.sendMessage(buildImageMessage);
                            InputView.this.hideSoftInput();
                        }
                    }
                };
                InputView.this.setOpenPhotoCallback();
                InputView.this.mInputMoreFragment.startActivityForResult(intent, 1012);
            }
        });
    }

    public void startSendFile() {
        TUIChatLog.i(TAG, "startSendFile");
        requestPermission(5, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.14
            @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
            public void onDenied() {
                TUIChatLog.i(InputView.TAG, "startSendFile checkPermission failed");
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
            public void onGranted() {
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("*/*");
                intent.addCategory("android.intent.category.OPENABLE");
                InputView.this.mInputMoreFragment.setCallback(new IUIKitCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.14.1
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i2, String str2) {
                        ToastUtil.toastLongMessage(str2);
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(Object obj) {
                        TUIMessageBean buildFileMessage = ChatMessageBuilder.buildFileMessage((Uri) obj);
                        if (InputView.this.mMessageHandler != null) {
                            InputView.this.mMessageHandler.sendMessage(buildFileMessage);
                            InputView.this.hideSoftInput();
                        }
                    }
                });
                InputView.this.mInputMoreFragment.startActivityForResult(intent, 1011);
            }
        });
    }

    public void startSendPhoto() {
        TUIChatLog.i(TAG, "startSendPhoto");
        requestPermission(4, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.10
            @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
            public void onDenied() {
                TUIChatLog.i(InputView.TAG, "startSendPhoto checkPermission failed");
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
            public void onGranted() {
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                InputView.this.setOpenPhotoCallback();
                InputView.this.mInputMoreFragment.startActivityForResult(intent, 1012);
            }
        });
    }

    public void startVideoRecord() {
        TUIChatLog.i(TAG, "startVideoRecord");
        requestPermission(1, new AnonymousClass13());
    }

    public void updateInputText(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        updateAtUserInfoMap(arrayList, arrayList2);
        if (this.mTextInput != null) {
            this.mTextInput.setMentionMap(getDisplayAtNameMap(arrayList, arrayList2));
            int selectionEnd = this.mTextInput.getSelectionEnd();
            if (selectionEnd != -1) {
                FaceManager.handlerEmojiText(this.mTextInput, this.mTextInput.getText().insert(selectionEnd, this.displayInputString).toString(), true);
                this.mTextInput.setSelection(selectionEnd + this.displayInputString.length());
            }
            BackgroundTasks.getInstance().postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.9
                @Override // java.lang.Runnable
                public void run() {
                    InputView.this.showSoftInput();
                }
            }, 200L);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IInputLayout
    public void replaceMoreInput(View.OnClickListener onClickListener) {
        this.mMoreInputEvent = onClickListener;
    }

    public InputView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInputMoreActionList = new ArrayList();
        this.mInputMoreCustomActionList = new ArrayList();
        this.atUserInfoMap = new HashMap();
        this.isReplyModel = false;
        initViews();
    }

    public InputView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mInputMoreActionList = new ArrayList();
        this.mInputMoreCustomActionList = new ArrayList();
        this.atUserInfoMap = new HashMap();
        this.isReplyModel = false;
        initViews();
    }
}
