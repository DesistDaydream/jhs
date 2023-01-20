package com.tencent.android.tpush;

import com.xiaomi.mipush.sdk.MiPushClient;

/* loaded from: classes3.dex */
public enum TypeStr {
    config(10, "config"),
    config_all(11, "config/#"),
    msg(20, "msg"),
    msg_all(21, "msg/#"),
    hearbeat(30, "heart"),
    hearbeat_all(31, "heart/#"),
    feedback(40, "feedback"),
    feedback_all(41, "feedback/#"),
    token(50, "token"),
    register(60, MiPushClient.COMMAND_REGISTER),
    pullupxg(70, "pullupxg"),
    insert_mid_new(80, "insert_mid_new"),
    insert_mid_old(81, "insert_mid_old"),
    hearbeat_cyclecheck(82, "hbcyheck");
    
    private String str;
    private int type;

    TypeStr(int i2, String str) {
        this.type = i2;
        this.str = str;
    }

    public static TypeStr getTypeStr(int i2) {
        if (i2 != 10) {
            if (i2 != 11) {
                if (i2 != 20) {
                    if (i2 != 21) {
                        if (i2 != 30) {
                            if (i2 != 31) {
                                if (i2 != 40) {
                                    if (i2 != 41) {
                                        if (i2 != 50) {
                                            if (i2 != 60) {
                                                if (i2 != 70) {
                                                    switch (i2) {
                                                        case 80:
                                                            return insert_mid_new;
                                                        case 81:
                                                            return insert_mid_old;
                                                        case 82:
                                                            return hearbeat_cyclecheck;
                                                        default:
                                                            return null;
                                                    }
                                                }
                                                return pullupxg;
                                            }
                                            return register;
                                        }
                                        return token;
                                    }
                                    return feedback_all;
                                }
                                return feedback;
                            }
                            return hearbeat_all;
                        }
                        return hearbeat;
                    }
                    return msg_all;
                }
                return msg;
            }
            return config_all;
        }
        return config;
    }

    public String getStr() {
        return this.str;
    }

    public int getType() {
        return this.type;
    }
}
