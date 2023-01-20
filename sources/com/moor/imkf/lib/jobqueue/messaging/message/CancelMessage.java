package com.moor.imkf.lib.jobqueue.messaging.message;

import com.moor.imkf.lib.jobqueue.base.CancelResult;
import com.moor.imkf.lib.jobqueue.base.TagConstraint;
import com.moor.imkf.lib.jobqueue.messaging.Message;
import com.moor.imkf.lib.jobqueue.messaging.Type;

/* loaded from: classes2.dex */
public class CancelMessage extends Message {
    private CancelResult.AsyncCancelCallback callback;
    private TagConstraint constraint;
    private String[] tags;

    public CancelMessage() {
        super(Type.CANCEL);
    }

    public CancelResult.AsyncCancelCallback getCallback() {
        return this.callback;
    }

    public TagConstraint getConstraint() {
        return this.constraint;
    }

    public String[] getTags() {
        return this.tags;
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.Message
    public void onRecycled() {
    }

    public void setCallback(CancelResult.AsyncCancelCallback asyncCancelCallback) {
        this.callback = asyncCancelCallback;
    }

    public void setConstraint(TagConstraint tagConstraint) {
        this.constraint = tagConstraint;
    }

    public void setTags(String[] strArr) {
        this.tags = strArr;
    }
}
