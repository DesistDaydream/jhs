package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMDownloadCallback;
import com.tencent.imsdk.v2.V2TIMElem;
import com.tencent.imsdk.v2.V2TIMFileElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FileReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import java.io.File;

/* loaded from: classes3.dex */
public class FileMessageBean extends TUIMessageBean {
    private String dataPath;
    private V2TIMFileElem fileElem;

    /* loaded from: classes3.dex */
    public interface FileDownloadCallback {
        void onError(int i2, String str);

        void onProgress(long j2, long j3);

        void onSuccess();
    }

    public void downloadFile(String str, final FileDownloadCallback fileDownloadCallback) {
        V2TIMFileElem v2TIMFileElem = this.fileElem;
        if (v2TIMFileElem != null) {
            v2TIMFileElem.downloadFile(str, new V2TIMDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean.1
                {
                    FileMessageBean.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i2, String str2) {
                    FileDownloadCallback fileDownloadCallback2 = fileDownloadCallback;
                    if (fileDownloadCallback2 != null) {
                        fileDownloadCallback2.onError(i2, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMDownloadCallback
                public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
                    FileDownloadCallback fileDownloadCallback2 = fileDownloadCallback;
                    if (fileDownloadCallback2 != null) {
                        fileDownloadCallback2.onProgress(v2ProgressInfo.getCurrentSize(), v2ProgressInfo.getTotalSize());
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    FileDownloadCallback fileDownloadCallback2 = fileDownloadCallback;
                    if (fileDownloadCallback2 != null) {
                        fileDownloadCallback2.onSuccess();
                    }
                }
            });
        }
    }

    public String getDataPath() {
        return this.dataPath;
    }

    public String getFileName() {
        V2TIMFileElem v2TIMFileElem = this.fileElem;
        return v2TIMFileElem != null ? v2TIMFileElem.getFileName() : "";
    }

    public int getFileSize() {
        V2TIMFileElem v2TIMFileElem = this.fileElem;
        if (v2TIMFileElem != null) {
            return v2TIMFileElem.getFileSize();
        }
        return 0;
    }

    public String getPath() {
        V2TIMFileElem v2TIMFileElem = this.fileElem;
        return v2TIMFileElem != null ? v2TIMFileElem.getPath() : "";
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return FileReplyQuoteBean.class;
    }

    public String getUUID() {
        V2TIMFileElem v2TIMFileElem = this.fileElem;
        return v2TIMFileElem != null ? v2TIMFileElem.getUUID() : "";
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public String onGetDisplayString() {
        return getExtra();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        if (getStatus() == 275) {
            return;
        }
        V2TIMFileElem fileElem = v2TIMMessage.getFileElem();
        this.fileElem = fileElem;
        String uuid = fileElem.getUUID();
        if (TextUtils.isEmpty(uuid)) {
            uuid = System.currentTimeMillis() + this.fileElem.getFileName();
        }
        String str = TUIConfig.getFileDownloadDir() + uuid;
        if (new File(str).exists()) {
            if (isSelf()) {
                setStatus(2);
            }
            setDownloadStatus(6);
        } else if (isSelf()) {
            if (TextUtils.isEmpty(this.fileElem.getPath())) {
                setDownloadStatus(5);
            } else if (new File(this.fileElem.getPath()).exists()) {
                setStatus(2);
                setDownloadStatus(6);
                str = this.fileElem.getPath();
            } else {
                setDownloadStatus(5);
            }
        } else {
            setDownloadStatus(5);
        }
        setDataPath(str);
        setExtra(TUIChatService.getAppContext().getString(R.string.file_extra));
    }

    public void setDataPath(String str) {
        this.dataPath = str;
    }
}
