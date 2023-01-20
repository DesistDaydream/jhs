package com.tencent.qcloud.tuikit.tuichat.config;

import com.tencent.qcloud.tuikit.tuichat.component.face.CustomFaceConfig;

/* loaded from: classes3.dex */
public class TUIChatConfigs {
    private static TUIChatConfigs sConfigs;
    private CustomFaceConfig customFaceConfig;
    private GeneralConfig generalConfig;

    private TUIChatConfigs() {
    }

    public static TUIChatConfigs getConfigs() {
        if (sConfigs == null) {
            sConfigs = new TUIChatConfigs();
        }
        return sConfigs;
    }

    public CustomFaceConfig getCustomFaceConfig() {
        return this.customFaceConfig;
    }

    public GeneralConfig getGeneralConfig() {
        if (this.generalConfig == null) {
            this.generalConfig = new GeneralConfig();
        }
        return this.generalConfig;
    }

    public TUIChatConfigs setCustomFaceConfig(CustomFaceConfig customFaceConfig) {
        this.customFaceConfig = customFaceConfig;
        return this;
    }

    public TUIChatConfigs setGeneralConfig(GeneralConfig generalConfig) {
        this.generalConfig = generalConfig;
        return this;
    }
}
