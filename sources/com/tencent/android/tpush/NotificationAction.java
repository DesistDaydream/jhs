package com.tencent.android.tpush;

/* loaded from: classes3.dex */
public enum NotificationAction {
    clicked(0),
    activity(1),
    url(2),
    intent(3),
    action_package(4),
    intent_with_action(5),
    delete(2),
    open(3),
    open_cancel(4),
    download(5),
    download_cancel(6);
    
    private int type;

    NotificationAction(int i2) {
        this.type = i2;
    }

    public static NotificationAction getNotificationAction(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return null;
                            }
                            return intent_with_action;
                        }
                        return action_package;
                    }
                    return intent;
                }
                return url;
            }
            return activity;
        }
        return clicked;
    }

    public int getType() {
        return this.type;
    }
}
