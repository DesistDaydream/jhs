package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.util.Strings;
import java.io.UnsupportedEncodingException;

/* loaded from: classes3.dex */
public class MqttTopic {
    private static final int MAX_TOPIC_LEN = 65535;
    private static final int MIN_TOPIC_LEN = 1;
    public static final String MULTI_LEVEL_WILDCARD = "#";
    public static final String MULTI_LEVEL_WILDCARD_PATTERN = "/#";
    private static final char NUL = 0;
    public static final String SINGLE_LEVEL_WILDCARD = "+";
    public static final String TOPIC_LEVEL_SEPARATOR = "/";
    public static final String TOPIC_WILDCARDS = "#+";
    private ClientComms comms;
    private String name;

    public MqttTopic(String str, ClientComms clientComms) {
        this.comms = clientComms;
        this.name = str;
    }

    private MqttPublish createPublish(MqttMessage mqttMessage) {
        return new MqttPublish(getName(), mqttMessage);
    }

    public static boolean isMatched(String str, String str2) throws IllegalArgumentException {
        int length = str2.length();
        int length2 = str.length();
        validate(str, true);
        validate(str2, false);
        if (str.equals(str2)) {
            return true;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2 && i3 < length && ((str2.charAt(i3) != '/' || str.charAt(i2) == '/') && (str.charAt(i2) == '+' || str.charAt(i2) == '#' || str.charAt(i2) == str2.charAt(i3)))) {
            if (str.charAt(i2) == '+') {
                while (true) {
                    int i4 = i3 + 1;
                    if (i4 < length && str2.charAt(i4) != '/') {
                        i3++;
                    }
                }
            } else if (str.charAt(i2) == '#') {
                i3 = length - 1;
            }
            i2++;
            i3++;
        }
        return i3 == length && i2 == length2;
    }

    public static void validate(String str, boolean z) throws IllegalArgumentException {
        try {
            int length = str.getBytes("UTF-8").length;
            if (length < 1 || length > 65535) {
                throw new IllegalArgumentException(String.format("Invalid topic length, should be in range[%d, %d]!", new Integer(1), new Integer(65535)));
            }
            if (z) {
                if (Strings.equalsAny(str, new String[]{MULTI_LEVEL_WILDCARD, "+"})) {
                    return;
                }
                if (Strings.countMatches(str, MULTI_LEVEL_WILDCARD) <= 1 && (!str.contains(MULTI_LEVEL_WILDCARD) || str.endsWith(MULTI_LEVEL_WILDCARD_PATTERN))) {
                    validateSingleLevelWildcard(str);
                    return;
                }
                throw new IllegalArgumentException("Invalid usage of multi-level wildcard in topic string: " + str);
            } else if (Strings.containsAny(str, TOPIC_WILDCARDS)) {
                throw new IllegalArgumentException("The topic name MUST NOT contain any wildcard characters (#+)");
            }
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException(e2.getMessage());
        }
    }

    private static void validateSingleLevelWildcard(String str) {
        char charAt = "+".charAt(0);
        char charAt2 = TOPIC_LEVEL_SEPARATOR.charAt(0);
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 - 1;
            char c2 = i3 >= 0 ? charArray[i3] : (char) 0;
            int i4 = i2 + 1;
            char c3 = i4 < length ? charArray[i4] : (char) 0;
            if (charArray[i2] == charAt && ((c2 != charAt2 && c2 != 0) || (c3 != charAt2 && c3 != 0))) {
                throw new IllegalArgumentException(String.format("Invalid usage of single-level wildcard in topic string '%s'!", str));
            }
            i2 = i4;
        }
    }

    public String getName() {
        return this.name;
    }

    public MqttDeliveryToken publish(byte[] bArr, int i2, boolean z) throws MqttException, MqttPersistenceException {
        MqttMessage mqttMessage = new MqttMessage(bArr);
        mqttMessage.setQos(i2);
        mqttMessage.setRetained(z);
        return publish(mqttMessage);
    }

    public String toString() {
        return getName();
    }

    public MqttDeliveryToken publish(MqttMessage mqttMessage) throws MqttException, MqttPersistenceException {
        MqttDeliveryToken mqttDeliveryToken = new MqttDeliveryToken(this.comms.getClient().getClientId());
        mqttDeliveryToken.setMessage(mqttMessage);
        this.comms.sendNoWait(createPublish(mqttMessage), mqttDeliveryToken);
        mqttDeliveryToken.internalTok.waitUntilSent();
        return mqttDeliveryToken;
    }
}
