package com.heytap.msp.push.callback;

import android.content.Context;
import com.heytap.msp.push.mode.DataMessage;

/* loaded from: classes2.dex */
public interface IDataMessageCallBackService {
    void processMessage(Context context, DataMessage dataMessage);
}
