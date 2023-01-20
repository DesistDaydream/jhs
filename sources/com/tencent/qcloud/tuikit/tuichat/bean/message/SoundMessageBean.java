package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMDownloadCallback;
import com.tencent.imsdk.v2.V2TIMElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMSoundElem;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.SoundReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;

/* loaded from: classes3.dex */
public class SoundMessageBean extends TUIMessageBean {
    private String dataPath;
    private V2TIMSoundElem soundElem;

    /* loaded from: classes3.dex */
    public interface SoundDownloadCallback {
        void onError(int i2, String str);

        void onProgress(long j2, long j3);

        void onSuccess();
    }

    public void downloadSound(String str, final SoundDownloadCallback soundDownloadCallback) {
        V2TIMSoundElem v2TIMSoundElem = this.soundElem;
        if (v2TIMSoundElem != null) {
            v2TIMSoundElem.downloadSound(str, new V2TIMDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean.2
                {
                    SoundMessageBean.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i2, String str2) {
                    SoundDownloadCallback soundDownloadCallback2 = soundDownloadCallback;
                    if (soundDownloadCallback2 != null) {
                        soundDownloadCallback2.onError(i2, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMDownloadCallback
                public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
                    SoundDownloadCallback soundDownloadCallback2 = soundDownloadCallback;
                    if (soundDownloadCallback2 != null) {
                        soundDownloadCallback2.onProgress(v2ProgressInfo.getCurrentSize(), v2ProgressInfo.getTotalSize());
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    SoundDownloadCallback soundDownloadCallback2 = soundDownloadCallback;
                    if (soundDownloadCallback2 != null) {
                        soundDownloadCallback2.onSuccess();
                    }
                }
            });
        }
    }

    public int getCustomInt() {
        if (getV2TIMMessage() != null) {
            return getV2TIMMessage().getLocalCustomInt();
        }
        return 0;
    }

    public String getDataPath() {
        return this.dataPath;
    }

    public int getDuration() {
        V2TIMSoundElem v2TIMSoundElem = this.soundElem;
        if (v2TIMSoundElem != null) {
            return v2TIMSoundElem.getDuration();
        }
        return 0;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return SoundReplyQuoteBean.class;
    }

    public String getUUID() {
        V2TIMSoundElem v2TIMSoundElem = this.soundElem;
        return v2TIMSoundElem != null ? v2TIMSoundElem.getUUID() : "";
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public String onGetDisplayString() {
        return getExtra();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        this.soundElem = v2TIMMessage.getSoundElem();
        if (isSelf() && !TextUtils.isEmpty(this.soundElem.getPath())) {
            this.dataPath = this.soundElem.getPath();
        } else {
            final String str = TUIConfig.getRecordDownloadDir() + this.soundElem.getUUID();
            if (!new File(str).exists()) {
                this.soundElem.downloadSound(str, new V2TIMDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean.1
                    {
                        SoundMessageBean.this = this;
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onError(int i2, String str2) {
                        TUIChatLog.e("ChatMessageInfoUtil getSoundToFile", i2 + Constants.COLON_SEPARATOR + str2);
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMDownloadCallback
                    public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
                        long currentSize = v2ProgressInfo.getCurrentSize();
                        long totalSize = v2ProgressInfo.getTotalSize();
                        int i2 = totalSize > 0 ? (int) ((currentSize * 100) / totalSize) : 0;
                        if (i2 > 100) {
                            i2 = 100;
                        }
                        TUIChatLog.i("ChatMessageInfoUtil getSoundToFile", "progress:" + i2);
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onSuccess() {
                        SoundMessageBean.this.dataPath = str;
                    }
                });
            } else {
                this.dataPath = str;
            }
        }
        setExtra(TUIChatService.getAppContext().getString(R.string.audio_extra));
    }

    public void setCustomInt(int i2) {
        if (getV2TIMMessage() != null) {
            getV2TIMMessage().setLocalCustomInt(i2);
        }
    }

    public void setDataPath(String str) {
        this.dataPath = str;
    }

    public void setSoundElem(V2TIMSoundElem v2TIMSoundElem) {
        this.soundElem = v2TIMSoundElem;
    }
}
