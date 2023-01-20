package com.m7.imkfsdk.utils.permission.callback;

import com.m7.imkfsdk.utils.permission.request.ExplainScope;
import java.util.List;

/* loaded from: classes2.dex */
public interface ExplainReasonCallbackWithBeforeParam {
    void onExplainReason(ExplainScope explainScope, List<String> list, boolean z);
}
