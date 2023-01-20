package com.m7.imkfsdk.chat.chatrow;

/* loaded from: classes2.dex */
public enum ChatRowType {
    TEXT_ROW_RECEIVED("C200R", 1),
    TEXT_ROW_TRANSMIT("C200T", 2),
    IMAGE_ROW_RECEIVED("C300R", 3),
    IMAGE_ROW_TRANSMIT("C300T", 4),
    VOICE_ROW_RECEIVED("C400R", 5),
    VOICE_ROW_TRANSMIT("C400T", 6),
    INVESTIGATE_ROW_TRANSMIT("C500T", 7),
    FILE_ROW_RECEIVED("C600R", 8),
    FILE_ROW_TRANSMIT("C600T", 9),
    IFRAME_ROW_RECEIVED("C700R", 10),
    BREAK_TIP_ROW_RECEIVED("C800R", 11),
    TRIP_ROW_RECEIVED("C900R", 12),
    RICHTEXT_ROW_RECEIVED("C1300R", 13),
    RICHTEXT_ROW_TRANSMIT("C1400T", 14),
    CARDINFO_ROW_TRANSMIT("C1500T", 15),
    VIDEO_ROW_TRANSMIT("C1600T", 16),
    VIDEO_ROW_RECEIVED("C1600R", 17),
    LOGISTICS_INFORMATION_ROW_RECEIVED("C1700R", 18),
    LOGISTICS_INFORMATION_ROW_TRANSMIT("C1700T", 19),
    ORDER_INFO_ROW_TRANSMIT("C2000T", 20),
    SEND_ORDER_INFO_ROW_TRANSMIT("C2100T", 21),
    RECEIVED_ORDER_INFO_ROW_RECEIVED("C2100R", 22),
    INVESTIGATE_CANCEL_RECEIVED("C2200R", 23),
    INVESTIGATE_SUCCESS_TRANSMIT("C2300T", 24),
    TAB_QUESTION_RECEIVED("C2400R", 25),
    XBOT_FORM_DATA_RECEIVED("C2500R", 26),
    XBOT_FORM_DATA_SUBMIT("C2600T", 27),
    QUICK_MENU_LIST("C2700R", 28),
    TAB_QUESTION_UNKNOWN("C9900R", 100);
    
    private final Object mDefaultValue;
    private final Integer mId;

    ChatRowType(Object obj, Integer num) {
        this.mId = num;
        this.mDefaultValue = obj;
    }

    public static ChatRowType fromValue(String str) {
        ChatRowType[] values = values();
        int length = values.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (values[i2].mDefaultValue.equals(str)) {
                return values[i2];
            }
        }
        return null;
    }

    public Object getDefaultValue() {
        return this.mDefaultValue;
    }

    public Integer getId() {
        return this.mId;
    }
}
