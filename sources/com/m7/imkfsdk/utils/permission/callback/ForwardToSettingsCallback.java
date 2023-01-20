package com.m7.imkfsdk.utils.permission.callback;

import com.m7.imkfsdk.utils.permission.request.ForwardScope;
import java.util.List;

/* loaded from: classes2.dex */
public interface ForwardToSettingsCallback {
    void onForwardToSettings(ForwardScope forwardScope, List<String> list);
}
