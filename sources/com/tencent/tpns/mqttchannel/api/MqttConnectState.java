package com.tencent.tpns.mqttchannel.api;

/* loaded from: classes3.dex */
public enum MqttConnectState {
    DISCONNECTED(0),
    CONNECTED(1),
    CONNECTFAIL(2),
    CONNECTING(3),
    DISCONNECTING(4),
    SUBTOPICS(5),
    UNKOWN(10);
    
    private int a;

    MqttConnectState(int i2) {
        this.a = i2;
    }

    public static MqttConnectState from(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return UNKOWN;
                            }
                            return SUBTOPICS;
                        }
                        return DISCONNECTING;
                    }
                    return CONNECTING;
                }
                return CONNECTFAIL;
            }
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public int getType() {
        return this.a;
    }
}
