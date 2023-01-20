package com.tencent.qcloud.tuikit.tuichat.component.face;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class CustomFaceConfig {
    private List<CustomFaceGroup> mFaceConfigs;

    public CustomFaceConfig addFaceGroup(CustomFaceGroup customFaceGroup) {
        if (this.mFaceConfigs == null) {
            this.mFaceConfigs = new ArrayList();
        }
        this.mFaceConfigs.add(customFaceGroup);
        return this;
    }

    public List<CustomFaceGroup> getFaceGroups() {
        return this.mFaceConfigs;
    }
}
