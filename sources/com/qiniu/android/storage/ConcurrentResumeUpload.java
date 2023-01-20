package com.qiniu.android.storage;

import com.qiniu.android.storage.BaseUpload;
import com.qiniu.android.storage.PartsUpload;
import com.qiniu.android.utils.GroupTaskThread;
import com.qiniu.android.utils.LogUtil;
import com.qiniu.android.utils.StringUtils;

/* loaded from: classes3.dex */
public class ConcurrentResumeUpload extends PartsUpload {
    private GroupTaskThread groupTaskThread;

    public ConcurrentResumeUpload(UploadSource uploadSource, String str, UpToken upToken, UploadOptions uploadOptions, Configuration configuration, Recorder recorder, String str2, BaseUpload.UpTaskCompletionHandler upTaskCompletionHandler) {
        super(uploadSource, str, upToken, uploadOptions, configuration, recorder, str2, upTaskCompletionHandler);
    }

    @Override // com.qiniu.android.storage.PartsUpload, com.qiniu.android.storage.BaseUpload
    public int prepareToUpload() {
        return super.prepareToUpload();
    }

    @Override // com.qiniu.android.storage.PartsUpload
    public void uploadRestData(final PartsUpload.UploadFileRestDataCompleteHandler uploadFileRestDataCompleteHandler) {
        LogUtil.i("key:" + StringUtils.toNonnullString(this.key));
        this.groupTaskThread = new GroupTaskThread(new GroupTaskThread.GroupTaskCompleteHandler() { // from class: com.qiniu.android.storage.ConcurrentResumeUpload.1
            @Override // com.qiniu.android.utils.GroupTaskThread.GroupTaskCompleteHandler
            public void complete() {
                uploadFileRestDataCompleteHandler.complete();
            }
        });
        for (int i2 = 0; i2 < this.config.concurrentTaskCount; i2++) {
            this.groupTaskThread.addTask(new GroupTaskThread.GroupTask() { // from class: com.qiniu.android.storage.ConcurrentResumeUpload.2
                @Override // com.qiniu.android.utils.GroupTaskThread.GroupTask
                public void run(final GroupTaskThread.GroupTask groupTask) {
                    ConcurrentResumeUpload.this.performUploadRestData(new PartsUpload.UploadFileRestDataCompleteHandler() { // from class: com.qiniu.android.storage.ConcurrentResumeUpload.2.1
                        @Override // com.qiniu.android.storage.PartsUpload.UploadFileRestDataCompleteHandler
                        public void complete() {
                            groupTask.taskComplete();
                        }
                    });
                }
            });
        }
        this.groupTaskThread.start();
    }
}
