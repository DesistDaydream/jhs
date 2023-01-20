package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.bj;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SplashFocusParams {
    private final Builder mBuilder;

    /* loaded from: classes.dex */
    public static class Builder {
        private int iconRightMarginDp = 15;
        private int iconBottomMarginDp = 95;
        private int iconSizeDp = 44;
        private boolean autoAnimOffset = true;
        private int animOffsetPx = 0;
        private double darkAlpha = 0.0d;

        public SplashFocusParams build() {
            return new SplashFocusParams(this);
        }

        @Deprecated
        public Builder setAnimOffsetPx(int i2) {
            this.autoAnimOffset = false;
            this.animOffsetPx = i2;
            return this;
        }

        public Builder setDarkAlpha(double d2) {
            this.darkAlpha = d2;
            return this;
        }

        public Builder setIconBottomMarginDp(int i2) {
            this.iconBottomMarginDp = i2;
            return this;
        }

        public Builder setIconRightMarginDp(int i2) {
            this.iconRightMarginDp = i2;
            return this;
        }

        public Builder setIconSizeDp(int i2) {
            this.iconSizeDp = i2;
            return this;
        }
    }

    public SplashFocusParams(Builder builder) {
        this.mBuilder = builder;
    }

    public JSONObject getFocusParams() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", this.mBuilder.iconRightMarginDp);
            jSONObject.put("bottom_margin", this.mBuilder.iconBottomMarginDp);
            jSONObject.put("icon_size", this.mBuilder.iconSizeDp);
            if (!this.mBuilder.autoAnimOffset) {
                jSONObject.put("anim_offset_y", this.mBuilder.animOffsetPx);
            }
            jSONObject.put("icon_dark_alpha", this.mBuilder.darkAlpha);
        } catch (JSONException e2) {
            bj.a().a(e2);
        }
        return jSONObject;
    }
}
