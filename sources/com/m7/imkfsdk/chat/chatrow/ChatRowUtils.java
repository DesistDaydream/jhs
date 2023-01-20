package com.m7.imkfsdk.chat.chatrow;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.moor.imkf.model.entity.FromToMessage;

/* loaded from: classes2.dex */
public class ChatRowUtils {
    public static int getChattingMessageType(FromToMessage fromToMessage) {
        String str = fromToMessage.msgType;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1896999753:
                if (str.equals(FromToMessage.MSG_TYPE_BREAK_TIP)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1551543255:
                if (str.equals(FromToMessage.MSG_TYPE_RICHTEXT)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1247949901:
                if (str.equals(FromToMessage.MSG_TYPE_XBOT_FORM_DATA)) {
                    c2 = 2;
                    break;
                }
                break;
            case -1191214428:
                if (str.equals(FromToMessage.MSG_TYPE_IFRAME)) {
                    c2 = 3;
                    break;
                }
                break;
            case -334200353:
                if (str.equals("investigate")) {
                    c2 = 4;
                    break;
                }
                break;
            case -31699676:
                if (str.equals(FromToMessage.MSG_TYPE_INVESTIGATE_SUCCESS)) {
                    c2 = 5;
                    break;
                }
                break;
            case -8565794:
                if (str.equals(FromToMessage.MSG_TYPE_CARDINFO)) {
                    c2 = 6;
                    break;
                }
                break;
            case 3046160:
                if (str.equals(FromToMessage.MSG_TYPE_CARD)) {
                    c2 = 7;
                    break;
                }
                break;
            case 3143036:
                if (str.equals("file")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 100313435:
                if (str.equals(FromToMessage.MSG_TYPE_IMAGE)) {
                    c2 = '\n';
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    c2 = 11;
                    break;
                }
                break;
            case 112386354:
                if (str.equals("voice")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 405552556:
                if (str.equals(FromToMessage.MSG_TYPE_TAB_QUESTION)) {
                    c2 = '\r';
                    break;
                }
                break;
            case 492599609:
                if (str.equals(FromToMessage.MSG_TYPE_INVESTIGATE_CANCEL)) {
                    c2 = 14;
                    break;
                }
                break;
            case 543260718:
                if (str.equals(FromToMessage.MSG_TYPE_TRIP)) {
                    c2 = 15;
                    break;
                }
                break;
            case 1248180638:
                if (str.equals(FromToMessage.MSG_TYPE_NEW_CARD_INFO)) {
                    c2 = 16;
                    break;
                }
                break;
            case 1343727782:
                if (str.equals(FromToMessage.MSG_TYPE_LOGISTICS_INFO_LIST)) {
                    c2 = 17;
                    break;
                }
                break;
            case 1582165898:
                if (str.equals(FromToMessage.QUICK_MENU_LIST)) {
                    c2 = 18;
                    break;
                }
                break;
            case 1844693200:
                if (str.equals(FromToMessage.MSG_TYPE_NEW_CARD)) {
                    c2 = 19;
                    break;
                }
                break;
            case 1846945195:
                if (str.equals(FromToMessage.MSG_TYPE_XBOT_FORM_SUBMIT)) {
                    c2 = 20;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 800;
            case 1:
                return 1300;
            case 2:
                return 2500;
            case 3:
                return 700;
            case 4:
                return 500;
            case 5:
                return PushConstants.DOWN_LOAD_LARGE_ICON_ERROR;
            case 6:
                return 1400;
            case 7:
                return 1500;
            case '\b':
                return 600;
            case '\t':
                return 200;
            case '\n':
                return 300;
            case 11:
                return 1600;
            case '\f':
                return 400;
            case '\r':
                return 2400;
            case 14:
                return PushConstants.EXPIRE_NOTIFICATION;
            case 15:
                return TypedValues.Custom.TYPE_INT;
            case 16:
                return 2100;
            case 17:
                return 1700;
            case 18:
                return 2700;
            case 19:
                return 2000;
            case 20:
                return 2600;
            default:
                return 9900;
        }
    }
}
