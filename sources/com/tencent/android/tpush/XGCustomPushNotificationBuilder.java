package com.tencent.android.tpush;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import android.widget.RemoteViews;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import e.t.u.b0;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class XGCustomPushNotificationBuilder extends XGPushNotificationBuilder {
    private Integer D = null;
    private Integer E = null;
    private Integer F = null;
    private Integer G = null;
    private Integer H = null;
    private Integer I = null;
    private Integer J = null;
    private Bitmap K = null;

    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    public void a(JSONObject jSONObject) {
        CommonHelper.jsonPut(jSONObject, "layoutId", this.D);
        CommonHelper.jsonPut(jSONObject, "layoutIconId", this.E);
        CommonHelper.jsonPut(jSONObject, "layoutTitleId", this.F);
        CommonHelper.jsonPut(jSONObject, "layoutTextId", this.G);
        CommonHelper.jsonPut(jSONObject, "layoutIconDrawableId", this.H);
        CommonHelper.jsonPut(jSONObject, "statusBarIconDrawableId", this.I);
        CommonHelper.jsonPut(jSONObject, "layoutTimeId", this.J);
    }

    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    public void b(JSONObject jSONObject) {
        this.D = (Integer) CommonHelper.jsonGet(jSONObject, "layoutId", null);
        this.E = (Integer) CommonHelper.jsonGet(jSONObject, "layoutIconId", null);
        this.F = (Integer) CommonHelper.jsonGet(jSONObject, "layoutTitleId", null);
        this.G = (Integer) CommonHelper.jsonGet(jSONObject, "layoutTextId", null);
        this.H = (Integer) CommonHelper.jsonGet(jSONObject, "layoutIconDrawableId", null);
        this.I = (Integer) CommonHelper.jsonGet(jSONObject, "statusBarIconDrawableId", null);
        this.J = (Integer) CommonHelper.jsonGet(jSONObject, "layoutTimeId", null);
    }

    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    public Pair<Notification, Object> buildNotification(Context context) {
        if (this.D != null) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), this.D.intValue());
            Integer num = this.F;
            if (num != null) {
                remoteViews.setTextViewText(num.intValue(), getTitle(context));
            }
            Integer num2 = this.G;
            if (num2 != null) {
                remoteViews.setTextViewText(num2.intValue(), this.s);
            }
            Integer num3 = this.E;
            if (num3 != null) {
                remoteViews.setImageViewResource(num3.intValue(), this.H.intValue());
                if (this.K != null) {
                    remoteViews.setImageViewBitmap(this.E.intValue(), this.K);
                }
            }
            Integer num4 = this.I;
            if (num4 != null) {
                remoteViews.setTextViewText(num4.intValue(), getTitle(context));
            }
            if (this.J != null) {
                remoteViews.setTextViewText(this.J.intValue(), String.valueOf(new SimpleDateFormat(b0.a.p).format(new Date(System.currentTimeMillis()))));
            }
            this.f6014e = remoteViews;
            return a(context);
        }
        return a(context);
    }

    public int getLayoutIconDrawableId() {
        return this.H.intValue();
    }

    public Integer getLayoutIconId() {
        return this.E;
    }

    public int getLayoutId() {
        return this.D.intValue();
    }

    public int getLayoutTextId() {
        return this.G.intValue();
    }

    public int getLayoutTimeId() {
        return this.J.intValue();
    }

    public int getLayoutTitleId() {
        return this.F.intValue();
    }

    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    public String getType() {
        return XGPushNotificationBuilder.CUSTOM_NOTIFICATION_BUILDER_TYPE;
    }

    public XGCustomPushNotificationBuilder setLayoutIconDrawableBmp(Bitmap bitmap) {
        this.K = bitmap;
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutIconDrawableId(int i2) {
        this.H = Integer.valueOf(i2);
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutIconId(int i2) {
        this.E = Integer.valueOf(i2);
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutId(int i2) {
        this.D = Integer.valueOf(i2);
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutTextId(int i2) {
        this.G = Integer.valueOf(i2);
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutTimeId(int i2) {
        this.J = Integer.valueOf(i2);
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutTitleId(int i2) {
        this.F = Integer.valueOf(i2);
        return this;
    }
}
