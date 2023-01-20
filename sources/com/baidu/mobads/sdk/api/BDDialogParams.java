package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.bj;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BDDialogParams {
    public static final int ANIM_STYLE_BREATHE = 1;
    public static final int ANIM_STYLE_GUIDE = 3;
    public static final int ANIM_STYLE_NONE = 0;
    public static final int ANIM_STYLE_SWIPE = 2;
    public static final int TYPE_BOTTOM_POPUP = 0;
    public static final int TYPE_CENTER_DECORATE = 2;
    public static final int TYPE_CENTER_NORMAL = 1;
    private final Builder mBuilder;

    /* loaded from: classes.dex */
    public static class Builder {
        private int mDlDialogType = 0;
        private int mDlDialogAnimStyle = 0;

        public BDDialogParams build() {
            return new BDDialogParams(this);
        }

        public Builder setDlDialogAnimStyle(int i2) {
            this.mDlDialogAnimStyle = i2;
            return this;
        }

        public Builder setDlDialogType(int i2) {
            this.mDlDialogType = i2;
            return this;
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.mBuilder.mDlDialogType);
            jSONObject.put("anim_style", this.mBuilder.mDlDialogAnimStyle);
        } catch (JSONException e2) {
            bj.a().a(e2);
        }
        return jSONObject;
    }

    private BDDialogParams(Builder builder) {
        this.mBuilder = builder;
    }
}
