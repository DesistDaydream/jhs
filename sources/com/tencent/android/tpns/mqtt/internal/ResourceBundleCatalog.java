package com.tencent.android.tpns.mqtt.internal;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* loaded from: classes3.dex */
public class ResourceBundleCatalog extends MessageCatalog {
    private ResourceBundle bundle = ResourceBundle.getBundle("com.tencent.android.tpns.mqtt.internal.nls.messages");

    @Override // com.tencent.android.tpns.mqtt.internal.MessageCatalog
    public String getLocalizedMessage(int i2) {
        try {
            return this.bundle.getString(Integer.toString(i2));
        } catch (MissingResourceException unused) {
            return "MqttException";
        }
    }
}
