package com.baidu.mobads.sdk.internal.concrete;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import java.util.Map;

/* loaded from: classes.dex */
public class ViewCompatDelegate implements a {
    private static final String a = "generateViewId";
    private final b b;

    public ViewCompatDelegate(@NonNull IAdInterListener iAdInterListener) {
        this.b = b.a(iAdInterListener, this);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.b.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.b.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.b.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.b.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.b.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.b.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if (a.equals(str2)) {
            return Integer.valueOf(ViewCompat.generateViewId());
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.b.setTarget(obj);
    }
}
