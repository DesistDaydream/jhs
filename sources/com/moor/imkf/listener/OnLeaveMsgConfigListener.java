package com.moor.imkf.listener;

import com.moor.imkf.model.entity.LeaveMsgField;
import java.util.List;

/* loaded from: classes2.dex */
public interface OnLeaveMsgConfigListener {
    void onFailed();

    void onSuccess(String str, List<LeaveMsgField> list);
}
