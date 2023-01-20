package com.tencent.qcloud.tuikit.tuiconversation;

/* loaded from: classes3.dex */
public class TUIConversationConstants {
    public static final int FORWARD_CREATE_GROUP_CODE = 103;
    public static final String FORWARD_CREATE_NEW_CHAT = "forward_create_new_chat";
    public static final int FORWARD_SELECT_ACTIVTY_CODE = 101;
    public static final String FORWARD_SELECT_CONVERSATION_KEY = "forward_select_conversation_key";
    public static final int FORWARD_SELECT_MEMBERS_CODE = 102;
    public static final int JSON_VERSION_1 = 1;
    public static final int JSON_VERSION_4 = 4;
    public static final int JSON_VERSION_UNKNOWN = 0;
    public static int version = 4;

    /* loaded from: classes3.dex */
    public static class GroupType {
        public static final int CHAT_ROOM = 2;
        public static final int COMMUNITY = 3;
        public static final String GROUP = "isGroup";
        public static final int PRIVATE = 0;
        public static final int PUBLIC = 1;
        public static final String TYPE = "type";
    }

    public static String covert2HTMLString(String str) {
        return "\"<font color=\"#5B6B92\">" + str + "</font>\"";
    }
}
