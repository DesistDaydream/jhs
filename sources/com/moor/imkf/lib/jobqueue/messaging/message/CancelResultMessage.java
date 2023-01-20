package com.moor.imkf.lib.jobqueue.messaging.message;

import com.moor.imkf.lib.jobqueue.base.CancelResult;
import com.moor.imkf.lib.jobqueue.messaging.Message;
import com.moor.imkf.lib.jobqueue.messaging.Type;

/* loaded from: classes2.dex */
public class CancelResultMessage extends Message {
    public CancelResult.AsyncCancelCallback callback;
    public CancelResult result;

    public CancelResultMessage() {
        super(Type.CANCEL_RESULT_CALLBACK);
    }

    public CancelResult.AsyncCancelCallback getCallback() {
        return this.callback;
    }

    public CancelResult getResult() {
        return this.result;
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.Message
    public void onRecycled() {
        this.result = null;
        this.callback = null;
    }

    public void set(CancelResult.AsyncCancelCallback asyncCancelCallback, CancelResult cancelResult) {
        this.callback = asyncCancelCallback;
        this.result = cancelResult;
    }
}
