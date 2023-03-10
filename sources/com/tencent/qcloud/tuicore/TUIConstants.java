package com.tencent.qcloud.tuicore;

/* loaded from: classes3.dex */
public final class TUIConstants {

    /* loaded from: classes3.dex */
    public static final class GroupType {
        public static final String IS_GROUP = "isGroup";
        public static final String TYPE = "type";
        public static final String TYPE_CHAT_ROOM = "ChatRoom";
        public static final String TYPE_COMMUNITY = "Community";
        public static final String TYPE_MEETING = "Meeting";
        public static final String TYPE_PRIVATE = "Private";
        public static final String TYPE_PUBLIC = "Public";
        public static final String TYPE_WORK = "Work";
    }

    /* loaded from: classes3.dex */
    public static final class Message {
        public static final String CALLING_TYPE_KEY = "call_type";
        public static final String CUSTOM_BUSINESS_ID_KEY = "type";
    }

    /* loaded from: classes3.dex */
    public static final class Service {
        public static final String TUI_BEAUTY = "TUIBeauty";
        public static final String TUI_CALLING = "TUICallingService";
        public static final String TUI_CHAT = "TUIChatService";
        public static final String TUI_CONTACT = "TUIContactService";
        public static final String TUI_CONVERSATION = "TUIConversationService";
        public static final String TUI_GROUP = "TUIGroupService";
        public static final String TUI_LIVE = "TUILiveService";
        public static final String TUI_OFFLINEPUSH = "TUIOfflinePushService";
        public static final String TUI_SEARCH = "TUISearchService";
    }

    /* loaded from: classes3.dex */
    public static final class TUIBeauty {
        public static final String METHOD_INIT_XMAGIC = "initXmagic";
        public static final String METHOD_PROCESS_VIDEO_FRAME = "processVideoFrame";
        public static final String PARAM_NAME_CONTEXT = "context";
        public static final String PARAM_NAME_FRAME_HEIGHT = "frameHeight";
        public static final String PARAM_NAME_FRAME_WIDTH = "frameWidth";
        public static final String PARAM_NAME_LICENSE_KEY = "licenseKey";
        public static final String PARAM_NAME_LICENSE_URL = "licenseUrl";
        public static final String PARAM_NAME_SRC_TEXTURE_ID = "srcTextureId";
        public static final String SERVICE_NAME = "TUIBeauty";
    }

    /* loaded from: classes3.dex */
    public static final class TUICalling {
        public static final int ACTION_ID_AUDIO_CALL = 1;
        public static final int ACTION_ID_VIDEO_CALL = 2;
        public static final String CALL_ID = "callId";
        public static final Double CALL_TIMEOUT_BUSINESS_ID = Double.valueOf(1.0d);
        public static final String CUSTOM_MESSAGE_BUSINESS_ID = "av_call";
        public static final String DATA = "data";
        public static final String EVENT_ACTIVE_HANGUP = "active_hangup";
        public static final String EVENT_KEY_CALLING = "calling";
        public static final String EVENT_KEY_NAME = "event_name";
        public static final String GROUP_ID = "groupId";
        public static final String INVITED_LIST = "invitedList";
        public static final String METHOD_NAME_CALL = "call";
        public static final String METHOD_NAME_RECEIVEAPNSCALLED = "receiveAPNSCalled";
        public static final String METHOD_START_CALL = "startCall";
        public static final String PARAM_NAME_CALLMODEL = "call_model_data";
        public static final String PARAM_NAME_GROUPID = "groupId";
        public static final String PARAM_NAME_TYPE = "type";
        public static final String PARAM_NAME_USERIDS = "userIDs";
        public static final String SENDER = "sender";
        public static final String SERVICE_NAME = "TUICallingService";
        public static final String TYPE_AUDIO = "audio";
        public static final String TYPE_VIDEO = "video";
    }

    /* loaded from: classes3.dex */
    public static final class TUIChat {
        public static final String AT_INFO_LIST = "atInfoList";
        public static final String C2C_CHAT_ACTIVITY_NAME = "TUIC2CChatActivity";
        public static final String CHAT_ID = "chatId";
        public static final String CHAT_NAME = "chatName";
        public static final String CHAT_TYPE = "chatType";
        public static final String CONTEXT = "context";
        public static final String CUSTOM_C2C_CHAT_ACTIVITY_NAME = "ImChatActivity";
        public static final String DRAFT_TEXT = "draftText";
        public static final String DRAFT_TIME = "draftTime";
        public static final String EVENT_KEY_INPUT_MORE = "eventKeyInputMore";
        public static final String EVENT_SUB_KEY_ON_CLICK = "eventSubKeyOnClick";
        public static final String EXTENSION_INPUT_MORE_AUDIO_CALL = "inputMoreAudioCall";
        public static final String EXTENSION_INPUT_MORE_CUSTOM_MESSAGE = "inputMoreCustomMessage";
        public static final String EXTENSION_INPUT_MORE_LIVE = "inputMoreLive";
        public static final String EXTENSION_INPUT_MORE_VIDEO_CALL = "inputMoreVideoCall";
        public static final String FACE_URL = "faceUrl";
        public static final String GROUP_CHAT_ACTIVITY_NAME = "TUIGroupChatActivity";
        public static final String GROUP_NAME = "groupName";
        public static final String GROUP_TYPE = "groupType";
        public static final String INPUT_MORE_ACTION_ID = "actionId";
        public static final String INPUT_MORE_ICON = "icon";
        public static final String INPUT_MORE_TITLE = "title";
        public static final String INPUT_MORE_VIEW = "inputMoreView";
        public static final String IS_GROUP_CHAT = "isGroupChat";
        public static final String IS_TOP_CHAT = "isTopChat";
        public static final String JOIN_TYPE = "joinType";
        public static final String LOCATE_MESSAGE = "locateMessage";
        public static final String MEMBER_COUNT = "memberCount";
        public static final String MEMBER_DETAILS = "memberDetails";
        public static final String MESSAGE_CONTENT = "messageContent";
        public static final String MESSAGE_DESCRIPTION = "messageDescription";
        public static final String MESSAGE_EXTENSION = "messageExtension";
        public static final String METHOD_EXIT_CHAT = "exitChat";
        public static final String METHOD_GET_DISPLAY_STRING = "getDisplayString";
        public static final String METHOD_SEND_MESSAGE = "sendMessage";
        public static final String NOTICE = "notice";
        public static final String OWNER = "owner";
        public static final String RECEIVE_OPTION = "receiveOption";
        public static final String SERVICE_NAME = "TUIChatService";
        public static String SOFT_KEY_BOARD_HEIGHT = "soft_key_board_height";
        public static String UI_PARAMS = "ui_params";
        public static final String V2TIMMESSAGE = "v2TIMMessage";
    }

    /* loaded from: classes3.dex */
    public static final class TUIContact {
        public static final String EVENT_FRIEND_INFO_CHANGED = "eventFriendInfoChanged";
        public static final String EVENT_FRIEND_STATE_CHANGED = "eventFriendStateChanged";
        public static final String EVENT_SUB_KEY_FRIEND_DELETE = "eventSubKeyFriendDelete";
        public static final String EVENT_SUB_KEY_FRIEND_REMARK_CHANGED = "eventFriendRemarkChanged";
        public static final String FRIEND_ID = "friendId";
        public static final String FRIEND_ID_LIST = "friendIdList";
        public static final String FRIEND_REMARK = "friendRemark";
        public static final String SERVICE_NAME = "TUIContactService";
    }

    /* loaded from: classes3.dex */
    public static final class TUIConversation {
        public static final String CHAT_ID = "chatId";
        public static final String CONTEXT = "context";
        public static final String CONVERSATION_C2C_PREFIX = "c2c_";
        public static final String CONVERSATION_GROUP_PREFIX = "group_";
        public static final String CONVERSATION_ID = "conversationId";
        public static final String EVENT_SUB_KEY_UNREAD_CHANGED = "unreadCountChanged";
        public static final String EVENT_UNREAD = "eventTotalUnreadCount";
        public static final String EXTENSION_SEARCH = "extensionSearch";
        public static final String IS_GROUP = "isGroup";
        public static final String IS_SET_TOP = "isSetTop";
        public static final String IS_TOP = "isTop";
        public static final String METHOD_CLEAR_CONVERSATION_MESSAGE = "clearConversationMessage";
        public static final String METHOD_DELETE_CONVERSATION = "deleteConversation";
        public static final String METHOD_GET_TOTAL_UNREAD_COUNT = "getTotalUnreadCount";
        public static final String METHOD_IS_TOP_CONVERSATION = "isTopConversation";
        public static final String METHOD_SET_TOP_CONVERSATION = "setTopConversation";
        public static final String METHOD_UPDATE_TOTAL_UNREAD_COUNT = "updateTotalUnreadCount";
        public static final String SEARCH_VIEW = "searchView";
        public static final String SERVICE_NAME = "TUIConversationService";
        public static final String TOTAL_UNREAD_COUNT = "totalUnreadCount";
    }

    /* loaded from: classes3.dex */
    public static final class TUIGroup {
        public static final String EVENT_GROUP = "eventGroup";
        public static final String EVENT_SUB_KEY_CLEAR_MESSAGE = "eventSubKeyGroupClearMessage";
        public static final String EVENT_SUB_KEY_EXIT_GROUP = "eventExitGroup";
        public static final String EVENT_SUB_KEY_GROUP_DISMISS = "eventMemberGroupDismiss";
        public static final String EVENT_SUB_KEY_GROUP_INFO_CHANGED = "eventSubKeyGroupInfoChanged";
        public static final String EVENT_SUB_KEY_GROUP_RECYCLE = "eventMemberGroupRecycle";
        public static final String EVENT_SUB_KEY_INVITED_GROUP = "eventSubKeyInvitedGroup";
        public static final String EVENT_SUB_KEY_JOIN_GROUP = "eventSubKeyJoinGroup";
        public static final String EVENT_SUB_KEY_MEMBER_KICKED_GROUP = "eventMemberKickedGroup";
        public static final String GROUP_FACE_URL = "groupFaceUrl";
        public static final String GROUP_ID = "groupId";
        public static final String GROUP_INTRODUCTION = "groupIntroduction";
        public static final String GROUP_MEMBER_ID_LIST = "groupMemberIdList";
        public static final String GROUP_NAME = "groupName";
        public static final String GROUP_NOTIFICATION = "groupNotification";
        public static final String GROUP_OWNER = "groupOwner";
        public static final String SERVICE_NAME = "TUIGroupService";
    }

    /* loaded from: classes3.dex */
    public static final class TUILive {
        public static final int ACTION_ID_LIVE = 0;
        public static final String ANCHOR_ID = "anchorId";
        public static final String ANCHOR_NAME = "anchorName";
        public static final String COVER_PIC = "coverPic";
        public static final String CUSTOM_MESSAGE_BUSINESS_ID = "group_live";
        public static final String GROUP_ID = "groupId";
        public static final String METHOD_LOGIN = "methodLogin";
        public static final String METHOD_LOGOUT = "methodLogout";
        public static final String METHOD_START_ANCHOR = "methodStartAnchor";
        public static final String METHOD_START_AUDIENCE = "methodStartAudience";
        public static final String PUSHER_AVATAR = "pusherAvatar";
        public static final String PUSHER_NAME = "pusherName";
        public static final String ROOM_COVER = "roomCover";
        public static final String ROOM_ID = "roomId";
        public static final String ROOM_NAME = "roomName";
        public static final String ROOM_STATUS = "roomStatus";
        public static final String SDK_APP_ID = "sdkAppId";
        public static final String SERVICE_NAME = "TUILiveService";
        public static final String USER_ID = "userId";
        public static final String USER_SIG = "userSig";
        public static final String USE_CDN_PLAY = "use_cdn_play";
    }

    /* loaded from: classes3.dex */
    public static final class TUILogin {
        public static final String EVENT_IMSDK_INIT_STATE_CHANGED = "eventIMSDKInitStateChanged";
        public static final String EVENT_LOGIN_STATE_CHANGED = "eventLoginStateChanged";
        public static final String EVENT_SUB_KEY_START_INIT = "eventSubKeyStartInit";
        public static final String EVENT_SUB_KEY_START_UNINIT = "eventSubKeyStartUnInit";
        public static final String EVENT_SUB_KEY_USER_INFO_UPDATED = "eventSubKeyUserInfoUpdated";
        public static final String EVENT_SUB_KEY_USER_KICKED_OFFLINE = "eventSubKeyUserKickedOffline";
        public static final String EVENT_SUB_KEY_USER_LOGIN_SUCCESS = "eventSubKeyUserLoginSuccess";
        public static final String EVENT_SUB_KEY_USER_LOGOUT_SUCCESS = "eventSubKeyUserLogoutSuccess";
        public static final String EVENT_SUB_KEY_USER_SIG_EXPIRED = "eventSubKeyUserSigExpired";
        public static final String SELF_ALLOW_TYPE = "selfAllowType";
        public static final String SELF_BIRTHDAY = "selfBirthday";
        public static final String SELF_FACE_URL = "selfFaceUrl";
        public static final String SELF_GENDER = "selfGender";
        public static final String SELF_ID = "selfId";
        public static final String SELF_LEVEL = "selfLevel";
        public static final String SELF_NICK_NAME = "selfNickName";
        public static final String SELF_ROLE = "selfRole";
        public static final String SELF_SIGNATURE = "selfSignature";
    }

    /* loaded from: classes3.dex */
    public static final class TUIOfflinePush {
        public static final String METHOD_UNREGISTER_PUSH = "unRegiterPush";
        public static final String SERVICE_NAME = "TUIOfflinePushService";
    }
}
