package com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder;

import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.File;

/* loaded from: classes3.dex */
public class SoundMessageHolder extends MessageContentHolder {
    private static final int READ = 1;
    private static final int UNREAD = 0;
    private LinearLayout audioContentView;
    private ImageView audioPlayImage;
    private TextView audioTimeText;
    private static final int AUDIO_MIN_WIDTH = ScreenUtil.getPxByDp(60.0f);
    private static final int AUDIO_MAX_WIDTH = ScreenUtil.getPxByDp(250.0f);

    /* renamed from: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.SoundMessageHolder$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ SoundMessageBean val$message;

        public AnonymousClass1(SoundMessageBean soundMessageBean) {
            this.val$message = soundMessageBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AudioPlayer.getInstance().isPlaying()) {
                AudioPlayer.getInstance().stopPlay();
                if (TextUtils.equals(AudioPlayer.getInstance().getPath(), this.val$message.getDataPath())) {
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.val$message.getDataPath())) {
                SoundMessageHolder.this.audioPlayImage.setImageResource(R.drawable.play_voice_message);
                if (this.val$message.isSelf()) {
                    SoundMessageHolder.this.audioPlayImage.setRotation(180.0f);
                }
                final AnimationDrawable animationDrawable = (AnimationDrawable) SoundMessageHolder.this.audioPlayImage.getDrawable();
                animationDrawable.start();
                this.val$message.setCustomInt(1);
                SoundMessageHolder.this.unreadAudioText.setVisibility(8);
                AudioPlayer.getInstance().startPlay(this.val$message.getDataPath(), new AudioPlayer.Callback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.SoundMessageHolder.1.1
                    @Override // com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer.Callback
                    public void onCompletion(Boolean bool) {
                        SoundMessageHolder.this.audioPlayImage.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.SoundMessageHolder.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                animationDrawable.stop();
                                SoundMessageHolder.this.audioPlayImage.setImageResource(R.drawable.voice_msg_playing_3);
                                if (AnonymousClass1.this.val$message.isSelf()) {
                                    SoundMessageHolder.this.audioPlayImage.setRotation(180.0f);
                                }
                            }
                        });
                    }
                });
                return;
            }
            ToastUtil.toastShortMessage(TUIChatService.getAppContext().getString(R.string.voice_play_tip));
            SoundMessageHolder.this.getSound(this.val$message);
        }
    }

    public SoundMessageHolder(View view) {
        super(view);
        this.audioTimeText = (TextView) view.findViewById(R.id.audio_time_tv);
        this.audioPlayImage = (ImageView) view.findViewById(R.id.audio_play_iv);
        this.audioContentView = (LinearLayout) view.findViewById(R.id.audio_content_ll);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSound(final SoundMessageBean soundMessageBean) {
        final String str = TUIConfig.getRecordDownloadDir() + soundMessageBean.getUUID();
        if (!new File(str).exists()) {
            soundMessageBean.downloadSound(str, new SoundMessageBean.SoundDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.SoundMessageHolder.2
                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean.SoundDownloadCallback
                public void onError(int i2, String str2) {
                    TUIChatLog.e("getSoundToFile failed code = ", i2 + ", info = " + str2);
                    ToastUtil.toastLongMessage("getSoundToFile failed code = " + i2 + ", info = " + str2);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean.SoundDownloadCallback
                public void onProgress(long j2, long j3) {
                    TUIChatLog.i("downloadSound progress current:", j2 + ", total:" + j3);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean.SoundDownloadCallback
                public void onSuccess() {
                    soundMessageBean.setDataPath(str);
                }
            });
        } else {
            soundMessageBean.setDataPath(str);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.message_adapter_content_audio;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder
    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i2) {
        SoundMessageBean soundMessageBean = (SoundMessageBean) tUIMessageBean;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (soundMessageBean.isSelf()) {
            this.audioTimeText.setTextColor(this.audioTimeText.getResources().getColor(TUIThemeManager.getAttrResId(this.audioTimeText.getContext(), R.attr.chat_self_msg_text_color)));
            layoutParams.addRule(11);
            layoutParams.rightMargin = 24;
            this.audioPlayImage.setImageResource(R.drawable.voice_msg_playing_3);
            this.audioPlayImage.setRotation(180.0f);
            this.audioContentView.removeView(this.audioPlayImage);
            this.audioContentView.addView(this.audioPlayImage);
            this.unreadAudioText.setVisibility(8);
        } else {
            this.audioTimeText.setTextColor(this.audioTimeText.getResources().getColor(TUIThemeManager.getAttrResId(this.audioTimeText.getContext(), R.attr.chat_other_msg_text_color)));
            layoutParams.addRule(9);
            layoutParams.leftMargin = 24;
            this.audioPlayImage.setImageResource(R.drawable.voice_msg_playing_3);
            this.audioContentView.removeView(this.audioPlayImage);
            this.audioContentView.addView(this.audioPlayImage, 0);
            if (soundMessageBean.getCustomInt() == 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.isReadText.getLayoutParams();
                layoutParams2.gravity = 16;
                layoutParams2.leftMargin = 10;
                this.unreadAudioText.setVisibility(0);
                this.unreadAudioText.setLayoutParams(layoutParams2);
            } else {
                this.unreadAudioText.setVisibility(8);
            }
        }
        this.audioContentView.setLayoutParams(layoutParams);
        int duration = soundMessageBean.getDuration();
        if (duration == 0) {
            duration = 1;
        }
        ViewGroup.LayoutParams layoutParams3 = this.msgContentFrame.getLayoutParams();
        int pxByDp = AUDIO_MIN_WIDTH + ScreenUtil.getPxByDp(duration * 6);
        layoutParams3.width = pxByDp;
        int i3 = AUDIO_MAX_WIDTH;
        if (pxByDp > i3) {
            layoutParams3.width = i3;
        }
        this.msgContentFrame.setLayoutParams(layoutParams3);
        TextView textView = this.audioTimeText;
        textView.setText(duration + "''");
        this.msgContentFrame.setOnClickListener(new AnonymousClass1(soundMessageBean));
    }
}
