package com.m7.imkfsdk.recordbutton;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.recordbutton.AudioManager;
import com.moor.imkf.utils.MoorUtils;
import java.io.File;

/* loaded from: classes2.dex */
public class AudioRecorderButton extends AppCompatButton implements AudioManager.AudioStateListener {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DISTANCE_Y_CANCEL = 50;
    private static final int MSG_DIALOG_DISMISS = 19;
    private static final int MSG_RECORDER_PREPARE = 17;
    private static final int MSG_TIME_LEFT_EXCEED_ALARM = 21;
    private static final int MSG_TIME_LEFT_TEN = 20;
    private static final int MSG_VOICE_CHANGE = 18;
    private static final int STATE_NORMAL = 1;
    private static final int STATE_RECORDING = 2;
    private static final int STATE_WANT_TO_CANCEL = 3;
    private String dir;
    private Handler handler;
    private boolean isRecording;
    private boolean is_send;
    public int leftTime;
    private RecorderFinishListener listener;
    private AudioManager mAudioManager;
    private int mCurrentState;
    private DialogManager mDialogManager;
    private Runnable mGetVoiceLevelRunnable;
    private boolean mReady;
    public float mTime;

    /* loaded from: classes2.dex */
    public interface RecorderFinishListener {
        void onRecordFinished(float f2, String str, String str2);
    }

    public AudioRecorderButton(Context context) {
        this(context, null);
    }

    private void changeState(int i2) {
        if (this.mCurrentState != i2) {
            this.mCurrentState = i2;
            if (i2 == 1) {
                setBackgroundResource(R.drawable.ykfsdk_kf_chat_input_bg);
                setText(R.string.ykfsdk_recorder_normal);
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                setBackgroundResource(R.drawable.ykfsdk_kf_btn_recorder_press);
                setText(R.string.ykfsdk_recorder_want_cancel);
                this.mDialogManager.wantToCancel();
            } else {
                setBackgroundResource(R.drawable.ykfsdk_kf_btn_recorder_press);
                setText(R.string.ykfsdk_recorder_recording);
                if (this.isRecording) {
                    this.mDialogManager.recording();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.isRecording = false;
        this.mReady = false;
        this.mTime = 0.0f;
        changeState(1);
    }

    private boolean wanttocancel(int i2, int i3) {
        return i2 < 0 || i2 > getWidth() || i3 < -50 || i3 > getHeight() + 50;
    }

    public void cancelListener() {
        this.mAudioManager.setAudioStateListener(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0) {
            changeState(2);
        } else if (action != 1) {
            if (action != 2) {
                if (action == 3) {
                    if (!this.mReady) {
                        reset();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (this.isRecording && this.mTime >= 0.9d) {
                        int i2 = this.mCurrentState;
                        if (i2 == 2) {
                            this.mDialogManager.dismissDialog();
                            RecorderFinishListener recorderFinishListener = this.listener;
                            if (recorderFinishListener != null) {
                                recorderFinishListener.onRecordFinished(this.mTime, this.mAudioManager.getCurrentFilePath(), this.mAudioManager.getPCMFilePath());
                            }
                            this.handler.removeMessages(20);
                            this.handler.removeMessages(21);
                            this.mAudioManager.release();
                        } else if (i2 == 3) {
                            this.mDialogManager.dismissDialog();
                            this.mAudioManager.cancel();
                            this.handler.removeMessages(20);
                            this.handler.removeMessages(21);
                        }
                    } else {
                        this.mDialogManager.tooShort();
                        this.mAudioManager.cancel();
                        this.handler.sendEmptyMessageDelayed(19, 1000L);
                    }
                    reset();
                }
            } else if (this.isRecording) {
                if (wanttocancel(x, y)) {
                    changeState(3);
                } else {
                    changeState(2);
                }
            }
        } else if (!this.mReady) {
            reset();
            return super.onTouchEvent(motionEvent);
        } else {
            if (this.isRecording && this.mTime >= 0.9d) {
                int i3 = this.mCurrentState;
                if (i3 == 2) {
                    this.mDialogManager.dismissDialog();
                    RecorderFinishListener recorderFinishListener2 = this.listener;
                    if (recorderFinishListener2 != null) {
                        recorderFinishListener2.onRecordFinished(this.mTime, this.mAudioManager.getCurrentFilePath(), this.mAudioManager.getPCMFilePath());
                    }
                    this.handler.removeMessages(20);
                    this.handler.removeMessages(21);
                    this.mAudioManager.release();
                } else if (i3 == 3) {
                    this.mDialogManager.dismissDialog();
                    this.mAudioManager.cancel();
                    this.handler.removeMessages(20);
                    this.handler.removeMessages(21);
                }
            } else {
                this.mDialogManager.tooShort();
                this.mAudioManager.cancel();
                this.handler.sendEmptyMessageDelayed(19, 1000L);
            }
            reset();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setRecordFinishListener(RecorderFinishListener recorderFinishListener) {
        this.listener = recorderFinishListener;
    }

    @Override // com.m7.imkfsdk.recordbutton.AudioManager.AudioStateListener
    public void wellPrepared() {
        this.handler.sendEmptyMessage(17);
    }

    public AudioRecorderButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 1;
        this.isRecording = false;
        this.is_send = true;
        this.mGetVoiceLevelRunnable = new Runnable() { // from class: com.m7.imkfsdk.recordbutton.AudioRecorderButton.1
            @Override // java.lang.Runnable
            public void run() {
                AudioRecorderButton.this.is_send = true;
                while (AudioRecorderButton.this.isRecording) {
                    try {
                        Thread.sleep(100L);
                        AudioRecorderButton audioRecorderButton = AudioRecorderButton.this;
                        audioRecorderButton.mTime += 0.1f;
                        if (audioRecorderButton.is_send && 60 - Math.round(AudioRecorderButton.this.mTime + 0.5f) == 10) {
                            AudioRecorderButton audioRecorderButton2 = AudioRecorderButton.this;
                            audioRecorderButton2.leftTime = 10;
                            audioRecorderButton2.handler.sendEmptyMessage(20);
                            AudioRecorderButton.this.is_send = false;
                        }
                        AudioRecorderButton.this.handler.sendEmptyMessage(18);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        };
        this.handler = new Handler() { // from class: com.m7.imkfsdk.recordbutton.AudioRecorderButton.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 17:
                        AudioRecorderButton.this.mDialogManager.showDialog();
                        AudioRecorderButton.this.isRecording = true;
                        new Thread(AudioRecorderButton.this.mGetVoiceLevelRunnable).start();
                        return;
                    case 18:
                        AudioRecorderButton.this.mDialogManager.updateVoiceLevel(AudioRecorderButton.this.mAudioManager.getVoiceLevel(7));
                        return;
                    case 19:
                        AudioRecorderButton.this.mDialogManager.dismissDialog();
                        return;
                    case 20:
                        AudioRecorderButton audioRecorderButton = AudioRecorderButton.this;
                        if (audioRecorderButton.leftTime >= 0) {
                            audioRecorderButton.mDialogManager.secondLeft(AudioRecorderButton.this.leftTime);
                            Message obtainMessage = AudioRecorderButton.this.handler.obtainMessage();
                            obtainMessage.what = 20;
                            AudioRecorderButton.this.handler.sendMessageDelayed(obtainMessage, 1000L);
                            AudioRecorderButton.this.leftTime--;
                            return;
                        }
                        audioRecorderButton.mDialogManager.exceedTime();
                        AudioRecorderButton.this.handler.sendMessageDelayed(AudioRecorderButton.this.handler.obtainMessage(21), 1000L);
                        if (AudioRecorderButton.this.listener != null) {
                            RecorderFinishListener recorderFinishListener = AudioRecorderButton.this.listener;
                            AudioRecorderButton audioRecorderButton2 = AudioRecorderButton.this;
                            recorderFinishListener.onRecordFinished(audioRecorderButton2.mTime, audioRecorderButton2.mAudioManager.getCurrentFilePath(), AudioRecorderButton.this.mAudioManager.getPCMFilePath());
                        }
                        AudioRecorderButton.this.mAudioManager.release();
                        AudioRecorderButton.this.reset();
                        return;
                    case 21:
                        AudioRecorderButton.this.mDialogManager.dismissDialog();
                        return;
                    default:
                        return;
                }
            }
        };
        this.mDialogManager = new DialogManager(context);
        if (Build.VERSION.SDK_INT >= 29) {
            this.dir = MoorUtils.getApp().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "m7_chat_recorder/";
        } else {
            this.dir = Environment.getExternalStorageDirectory() + "/m7_chat_recorder";
        }
        AudioManager audioManager = AudioManager.getInstance(this.dir);
        this.mAudioManager = audioManager;
        audioManager.setAudioStateListener(this);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.m7.imkfsdk.recordbutton.AudioRecorderButton.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                AudioRecorderButton.this.mReady = true;
                AudioRecorderButton.this.mAudioManager.prepareAudio();
                return false;
            }
        });
    }
}
