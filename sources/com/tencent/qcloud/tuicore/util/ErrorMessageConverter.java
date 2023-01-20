package com.tencent.qcloud.tuicore.util;

import com.tencent.imsdk.BaseConstants;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUIConfig;

/* loaded from: classes3.dex */
public class ErrorMessageConverter {
    public static String convertIMError(int i2, String str) {
        if (i2 != -10001) {
            if (i2 != -10000) {
                if (i2 != 6106) {
                    if (i2 != 6107) {
                        if (i2 != 6200) {
                            if (i2 != 6201) {
                                switch (i2) {
                                    case BaseConstants.ERR_SVR_SSO_OVERLOAD /* -10114 */:
                                        return getLocalizedString(R.string.TUIKitErrorSVRSSOOverload);
                                    case BaseConstants.ERR_SVR_SSO_FREQ_LIMIT /* -10113 */:
                                        return getLocalizedString(R.string.TUIKitErrorSVRSSOFreqLimit);
                                    case BaseConstants.ERR_SVR_SSO_APPID_WITHOUT_USING /* -10112 */:
                                        return getLocalizedString(R.string.TUIKitErrorSVRSSOAppidWithoutUsing);
                                    case BaseConstants.ERR_SVR_SSO_CMD_BLACK_LIST /* -10111 */:
                                        return getLocalizedString(R.string.TUIKitErrorSVRSSOCmdBlackList);
                                    case BaseConstants.ERR_SVR_SSO_APPID_BLACK_LIST /* -10110 */:
                                        return getLocalizedString(R.string.TUIKitErrorSVRSSOAppidBlackList);
                                    case BaseConstants.ERR_SVR_SSO_PACKET_WRONG /* -10109 */:
                                        return getLocalizedString(R.string.TUIKitErrorSVRSSOPacketWrong);
                                    case BaseConstants.ERR_SVR_SSO_PREPAID_ARREARS /* -10108 */:
                                        return getLocalizedString(R.string.TUIKitErrorSVRSSOPrepaidArrears);
                                    case BaseConstants.ERR_SVR_SSO_UNSURPPORT /* -10107 */:
                                        return getLocalizedString(R.string.TUIKitErrorSVRSSOUnsupport);
                                    case BaseConstants.ERR_SVR_SSO_D2KEY_WRONG /* -10106 */:
                                        return getLocalizedString(R.string.TUIKitErrorSVRSSOD2KeyWrong);
                                    case BaseConstants.ERR_SVR_SSO_MSFSDK_QUIT /* -10105 */:
                                        return getLocalizedString(R.string.TUIKitErrorSVRSSOMSFSDKQuit);
                                    case BaseConstants.ERR_SVR_SSO_CLIENT_CLOSE /* -10104 */:
                                        return getLocalizedString(R.string.TUIKitErrorSVRSSOClientClose);
                                    case BaseConstants.ERR_SVR_SSO_IDENTIFIER_INVALID /* -10103 */:
                                        return getLocalizedString(R.string.TUIKitErrorSVRSSOIdentifierInvalid);
                                    case BaseConstants.ERR_SVR_SSO_DISCONNECT /* -10102 */:
                                        return getLocalizedString(R.string.TUIKitErrorSVRSSODisconnect);
                                    case BaseConstants.ERR_SVR_SSO_DOWN_TIP /* -10101 */:
                                        return getLocalizedString(R.string.TUIKitErrorSVRSSODownTips);
                                    default:
                                        switch (i2) {
                                            case BaseConstants.ERR_SVR_SSO_COOKIE_INVALID /* -10009 */:
                                                return getLocalizedString(R.string.TUIKitErrorSVRSSOCookieInvalid);
                                            case BaseConstants.ERR_SVR_SSO_NO_IMEI_AND_A2 /* -10008 */:
                                                return getLocalizedString(R.string.TUIKitErrorSVRSSONoImeiAndA2);
                                            case BaseConstants.ERR_SVR_SSO_VCODE_TIMEOUT /* -10007 */:
                                                return getLocalizedString(R.string.TUIKitErrorSVRSSOVCodeTimeout);
                                            case BaseConstants.ERR_SVR_SSO_UIN_INVALID /* -10006 */:
                                                return getLocalizedString(R.string.TUIKitErrorSVRSSOUinInvalid);
                                            case BaseConstants.ERR_SVR_SSO_EMPTY_KEY /* -10005 */:
                                                return getLocalizedString(R.string.TUIKitErrorSVRSSOEmpeyKey);
                                            case BaseConstants.ERR_SVR_SSO_A2_DOWN_INVALID /* -10004 */:
                                                return getLocalizedString(R.string.TUIKitErrorSVRA2DownInvalid);
                                            case BaseConstants.ERR_SVR_SSO_A2_UP_INVALID /* -10003 */:
                                                return getLocalizedString(R.string.TUIKitErrorSVRA2UpInvalid);
                                            default:
                                                switch (i2) {
                                                    case BaseConstants.ERR_SVR_SSO_CONNECT_LIMIT /* -302 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKSVRSSOConnectLimit);
                                                    case 6001:
                                                        return getLocalizedString(R.string.TUIKitErrorParseResponseFaild);
                                                    case 6002:
                                                        return getLocalizedString(R.string.TUIKitErrorSerializeReqFaild);
                                                    case 6003:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRNoSuccessResult);
                                                    case 6004:
                                                        return getLocalizedString(R.string.TUIKitErrorInvalidConveration);
                                                    case 6005:
                                                        return getLocalizedString(R.string.TUIKitErrorLoadMsgFailed);
                                                    case 6006:
                                                        return getLocalizedString(R.string.TUIKitErrorFileTransAuthFailed);
                                                    case BaseConstants.ERR_FILE_TRANS_NO_SERVER /* 6007 */:
                                                        return getLocalizedString(R.string.TUIKitErrorFileTransNoServer);
                                                    case BaseConstants.ERR_FILE_TRANS_UPLOAD_FAILED /* 6008 */:
                                                        return getLocalizedString(R.string.TUIKitErrorFileTransUploadFailed);
                                                    case BaseConstants.ERR_FILE_TRANS_DOWNLOAD_FAILED /* 6009 */:
                                                        return getLocalizedString(R.string.TUIKitErrorFileTransDownloadFailed);
                                                    case BaseConstants.ERR_HTTP_REQ_FAILED /* 6010 */:
                                                        return getLocalizedString(R.string.TUIKitErrorHTTPRequestFailed);
                                                    case BaseConstants.ERR_TO_USER_INVALID /* 6011 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRToUserInvalid);
                                                    case BaseConstants.ERR_REQUEST_TIMEOUT /* 6012 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRRequestTimeout);
                                                    case BaseConstants.ERR_SDK_NOT_INITIALIZED /* 6013 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNotInit);
                                                    case BaseConstants.ERR_SDK_NOT_LOGGED_IN /* 6014 */:
                                                        return getLocalizedString(R.string.TUIKitErrorNotLogin);
                                                    case BaseConstants.ERR_IN_PROGESS /* 6015 */:
                                                        return getLocalizedString(R.string.TUIKitErrorInProcess);
                                                    case BaseConstants.ERR_INVALID_MSG_ELEM /* 6016 */:
                                                        return getLocalizedString(R.string.TUIKitErrorInvalidMsgElem);
                                                    case BaseConstants.ERR_INVALID_PARAMETERS /* 6017 */:
                                                        return getLocalizedString(R.string.TUIKitErrorInvalidParameters);
                                                    case BaseConstants.ERR_INIT_CORE_FAIL /* 6018 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRInitCoreFail);
                                                    case BaseConstants.ERR_DATABASE_OPERATE_FAILED /* 6019 */:
                                                        return getLocalizedString(R.string.TUIKitErrorDatabaseOperateFailed);
                                                    case BaseConstants.ERR_EXPIRED_SESSION_NODE /* 6020 */:
                                                        return getLocalizedString(R.string.TUIKitErrorExpiredSessionNode);
                                                    case BaseConstants.ERR_INVALID_SDK_OBJECT /* 6021 */:
                                                        return getLocalizedString(R.string.TUIKitErrorInvalidSDKObject);
                                                    case BaseConstants.ERR_IO_OPERATION_FAILED /* 6022 */:
                                                        return getLocalizedString(R.string.TUIKitErrorIOOperateFaild);
                                                    case BaseConstants.ERR_LOGGED_OUT_BEFORE_LOGIN_FINISHED /* 6023 */:
                                                        return getLocalizedString(R.string.TUIKitErrorLoggedOutBeforeLoginFinished);
                                                    case BaseConstants.ERR_TLSSDK_NOT_INITIALIZED /* 6024 */:
                                                        return getLocalizedString(R.string.TUIKitErrorTLSSDKNotInitialized);
                                                    case BaseConstants.ERR_TLSSDK_USER_NOT_FOUND /* 6025 */:
                                                        return getLocalizedString(R.string.TUIKitErrorTLSSDKUserNotFound);
                                                    case BaseConstants.ERR_NO_PREVIOUS_LOGIN /* 6026 */:
                                                        return getLocalizedString(R.string.TUIKitErrorNoPreviousLogin);
                                                    case BaseConstants.ERR_INVALID_JSON /* 6027 */:
                                                        return getLocalizedString(R.string.TUIKitErrorInvalidJson);
                                                    case BaseConstants.ERR_OUT_OF_MEMORY /* 6028 */:
                                                        return getLocalizedString(R.string.TUIKitErrorOutOfMemory);
                                                    case BaseConstants.ERR_AUTOLOGIN_NEED_USERSIG /* 6226 */:
                                                        return getLocalizedString(R.string.TUIKitErrorAutoLoginNeedUserSig);
                                                    case BaseConstants.ERR_REQUEST_NO_NET_ONREQ /* 6250 */:
                                                        return getLocalizedString(R.string.TUIKitErrorRequestNoNetOnReq);
                                                    case BaseConstants.ERR_REQUEST_NO_NET_ONRSP /* 6251 */:
                                                        return getLocalizedString(R.string.TUIKitErrorRequestNoNetOnRsp);
                                                    case BaseConstants.ERR_REQUEST_OVERLOADED /* 6254 */:
                                                        return getLocalizedString(R.string.TUIKitErrorRequestOnverLoaded);
                                                    case BaseConstants.ERR_REQUEST_KICK_OFF /* 6255 */:
                                                        return getLocalizedString(R.string.TUIKitErrorReqKickOff);
                                                    case BaseConstants.ERR_REQUEST_SERVICE_SUSPEND /* 6256 */:
                                                        return getLocalizedString(R.string.TUIKitErrorReqServiceSuspend);
                                                    case BaseConstants.ERR_REQUEST_INVALID_SIGN /* 6257 */:
                                                        return getLocalizedString(R.string.TUIKitErrorReqInvalidSign);
                                                    case BaseConstants.ERR_REQUEST_INVALID_COOKIE /* 6258 */:
                                                        return getLocalizedString(R.string.TUIKitErrorReqInvalidCookie);
                                                    case BaseConstants.ERR_QAL_NO_SHORT_CONN_AVAILABLE /* 6300 */:
                                                        return getLocalizedString(R.string.TUIKitErrorQALNoShortConneAvailable);
                                                    case BaseConstants.ERR_SDK_COMM_CROSS_THREAD /* 7001 */:
                                                        return getLocalizedString(R.string.TUIKitErrorCrossThread);
                                                    case BaseConstants.ERR_SDK_COMM_TINYID_EMPTY /* 7002 */:
                                                        return getLocalizedString(R.string.TUIKitErrorTinyIdEmpty);
                                                    case BaseConstants.ERR_SDK_COMM_INVALID_IDENTIFIER /* 7003 */:
                                                        return getLocalizedString(R.string.TUIKitErrorInvalidIdentifier);
                                                    case BaseConstants.ERR_SDK_COMM_FILE_NOT_FOUND /* 7004 */:
                                                        return getLocalizedString(R.string.TUIKitErrorFileNotFound);
                                                    case BaseConstants.ERR_SDK_COMM_FILE_TOO_LARGE /* 7005 */:
                                                        return getLocalizedString(R.string.TUIKitErrorFileTooLarge);
                                                    case BaseConstants.ERR_SDK_COMM_FILE_SIZE_EMPTY /* 7006 */:
                                                        return getLocalizedString(R.string.TUIKitErrorEmptyFile);
                                                    case BaseConstants.ERR_SDK_COMM_FILE_OPEN_FAILED /* 7007 */:
                                                        return getLocalizedString(R.string.TUIKitErrorFileOpenFailed);
                                                    case BaseConstants.ERR_SDK_ACCOUNT_TLS_INIT_FAILED /* 7503 */:
                                                        return getLocalizedString(R.string.TUIKitErrorTLSSDKInit);
                                                    case BaseConstants.ERR_SDK_ACCOUNT_TLS_NOT_INITIALIZED /* 7504 */:
                                                        return getLocalizedString(R.string.TUIKitErrorTLSSDKUninit);
                                                    case BaseConstants.ERR_SDK_ACCOUNT_TLS_TRANSPKG_ERROR /* 7505 */:
                                                        return getLocalizedString(R.string.TUIKitErrorTLSSDKTRANSPackageFormat);
                                                    case BaseConstants.ERR_SDK_ACCOUNT_TLS_DECRYPT_FAILED /* 7506 */:
                                                        return getLocalizedString(R.string.TUIKitErrorTLSDecrypt);
                                                    case BaseConstants.ERR_SDK_ACCOUNT_TLS_REQUEST_FAILED /* 7507 */:
                                                        return getLocalizedString(R.string.TUIKitErrorTLSSDKRequest);
                                                    case BaseConstants.ERR_SDK_ACCOUNT_TLS_REQUEST_TIMEOUT /* 7508 */:
                                                        return getLocalizedString(R.string.TUIKitErrorTLSSDKRequestTimeout);
                                                    case 8001:
                                                        return getLocalizedString(R.string.TUIKitSDKMsgBodySizeLimit);
                                                    case 8002:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKMsgKeyReqDifferRsp);
                                                    case BaseConstants.ERR_SDK_GROUP_INVALID_ID /* 8501 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKGroupInvalidID);
                                                    case BaseConstants.ERR_SDK_GROUP_INVALID_NAME /* 8502 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKGroupInvalidName);
                                                    case BaseConstants.ERR_SDK_GROUP_INVALID_INTRODUCTION /* 8503 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKGroupInvalidIntroduction);
                                                    case BaseConstants.ERR_SDK_GROUP_INVALID_NOTIFICATION /* 8504 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKGroupInvalidNotification);
                                                    case BaseConstants.ERR_SDK_GROUP_INVALID_FACE_URL /* 8505 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKGroupInvalidFaceURL);
                                                    case BaseConstants.ERR_SDK_GROUP_INVALID_NAME_CARD /* 8506 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKGroupInvalidNameCard);
                                                    case BaseConstants.ERR_SDK_GROUP_MEMBER_COUNT_LIMIT /* 8507 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKGroupMemberCountLimit);
                                                    case BaseConstants.ERR_SDK_GROUP_JOIN_PRIVATE_GROUP_DENY /* 8508 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKGroupJoinPrivateGroupDeny);
                                                    case BaseConstants.ERR_SDK_GROUP_INVITE_SUPER_DENY /* 8509 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKGroupInviteSuperDeny);
                                                    case BaseConstants.ERR_SDK_GROUP_INVITE_NO_MEMBER /* 8510 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKGroupInviteNoMember);
                                                    case 9001:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKFriendShipInvalidProfileKey);
                                                    case 9002:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKFriendshipInvalidAddRemark);
                                                    case 9003:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKFriendshipInvalidAddWording);
                                                    case 9004:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKFriendshipInvalidAddSource);
                                                    case 9005:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKFriendshipFriendGroupEmpty);
                                                    case BaseConstants.ERR_SDK_NET_ENCODE_FAILED /* 9501 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetEncodeFailed);
                                                    case BaseConstants.ERR_SDK_NET_DECODE_FAILED /* 9502 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetDecodeFailed);
                                                    case BaseConstants.ERR_SDK_NET_AUTH_INVALID /* 9503 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetAuthInvalid);
                                                    case BaseConstants.ERR_SDK_NET_COMPRESS_FAILED /* 9504 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetCompressFailed);
                                                    case BaseConstants.ERR_SDK_NET_UNCOMPRESS_FAILED /* 9505 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetUncompressFaile);
                                                    case BaseConstants.ERR_SDK_NET_FREQ_LIMIT /* 9506 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetFreqLimit);
                                                    case BaseConstants.ERR_SDK_NET_REQ_COUNT_LIMIT /* 9507 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKnetReqCountLimit);
                                                    case BaseConstants.ERR_SDK_NET_DISCONNECT /* 9508 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetDisconnect);
                                                    case BaseConstants.ERR_SDK_NET_ALLREADY_CONN /* 9509 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetAllreadyConn);
                                                    case BaseConstants.ERR_SDK_NET_CONN_TIMEOUT /* 9510 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetConnTimeout);
                                                    case BaseConstants.ERR_SDK_NET_CONN_REFUSE /* 9511 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetConnRefuse);
                                                    case BaseConstants.ERR_SDK_NET_NET_UNREACH /* 9512 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetNetUnreach);
                                                    case BaseConstants.ERR_SDK_NET_SOCKET_NO_BUFF /* 9513 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetSocketNoBuff);
                                                    case BaseConstants.ERR_SDK_NET_RESET_BY_PEER /* 9514 */:
                                                        return getLocalizedString(R.string.TUIKitERRORSDKNetResetByPeer);
                                                    case BaseConstants.ERR_SDK_NET_SOCKET_INVALID /* 9515 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetSOcketInvalid);
                                                    case BaseConstants.ERR_SDK_NET_HOST_GETADDRINFO_FAILED /* 9516 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetHostGetAddressFailed);
                                                    case BaseConstants.ERR_SDK_NET_CONNECT_RESET /* 9517 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetConnectReset);
                                                    case BaseConstants.ERR_SDK_NET_WAIT_INQUEUE_TIMEOUT /* 9518 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetWaitInQueueTimeout);
                                                    case BaseConstants.ERR_SDK_NET_WAIT_SEND_TIMEOUT /* 9519 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetWaitSendTimeout);
                                                    case BaseConstants.ERR_SDK_NET_WAIT_ACK_TIMEOUT /* 9520 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKNetWaitAckTimeut);
                                                    case 10002:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountInternalError);
                                                    case 10003:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupApiNameError);
                                                    case BaseConstants.ERR_SVR_GROUP_INVALID_PARAMETERS /* 10004 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRResInvalidParameters);
                                                    case BaseConstants.ERR_SVR_GROUP_ACOUNT_COUNT_LIMIT /* 10005 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupAccountCountLimit);
                                                    case BaseConstants.ERR_SVR_GROUP_FREQ_LIMIT /* 10006 */:
                                                        return getLocalizedString(R.string.TUIkitErrorSVRGroupFreqLimit);
                                                    case 10007:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupPermissionDeny);
                                                    case BaseConstants.ERR_SVR_GROUP_INVALID_REQ /* 10008 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupInvalidReq);
                                                    case BaseConstants.ERR_SVR_GROUP_SUPER_NOT_ALLOW_QUIT /* 10009 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupSuperNotAllowQuit);
                                                    case 10010:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupNotFound);
                                                    case 10011:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupJsonParseFailed);
                                                    case 10012:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupInvalidId);
                                                    case 10013:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupAllreadyMember);
                                                    case 10014:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupFullMemberCount);
                                                    case 10015:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupInvalidGroupId);
                                                    case BaseConstants.ERR_SVR_GROUP_REJECT_FROM_THIRDPARTY /* 10016 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupRejectFromThirdParty);
                                                    case BaseConstants.ERR_SVR_GROUP_SHUTUP_DENY /* 10017 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupShutDeny);
                                                    case BaseConstants.ERR_SVR_GROUP_RSP_SIZE_LIMIT /* 10018 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupRspSizeLimit);
                                                    case BaseConstants.ERR_SVR_GROUP_ACCOUNT_NOT_FOUND /* 10019 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupAccountNotFound);
                                                    case BaseConstants.ERR_SVR_GROUP_GROUPID_IN_USED /* 10021 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupGroupIdInUse);
                                                    case BaseConstants.ERR_SVR_GROUP_SEND_MSG_FREQ_LIMIT /* 10023 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupSendMsgFreqLimit);
                                                    case BaseConstants.ERR_SVR_GROUP_REQ_ALLREADY_BEEN_PROCESSED /* 10024 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupReqAllreadyBeenProcessed);
                                                    case BaseConstants.ERR_SVR_GROUP_GROUPID_IN_USED_FOR_SUPER /* 10025 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupGroupIdUserdForSuper);
                                                    case BaseConstants.ERR_SVR_GROUP_SDKAPPID_DENY /* 10026 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupSDkAppidDeny);
                                                    case BaseConstants.ERR_SVR_GROUP_REVOKE_MSG_NOT_FOUND /* 10030 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupRevokeMsgNotFound);
                                                    case BaseConstants.ERR_SVR_GROUP_REVOKE_MSG_TIME_LIMIT /* 10031 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupRevokeMsgTimeLimit);
                                                    case BaseConstants.ERR_SVR_GROUP_REVOKE_MSG_DENY /* 10032 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupRevokeMsgDeny);
                                                    case BaseConstants.ERR_SVR_GROUP_NOT_ALLOW_REVOKE_MSG /* 10033 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupNotAllowRevokeMsg);
                                                    case BaseConstants.ERR_SVR_GROUP_REMOVE_MSG_DENY /* 10034 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupRemoveMsgDeny);
                                                    case BaseConstants.ERR_SVR_GROUP_NOT_ALLOW_REMOVE_MSG /* 10035 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupNotAllowRemoveMsg);
                                                    case BaseConstants.ERR_SVR_GROUP_AVCHATROOM_COUNT_LIMIT /* 10036 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupAvchatRoomCountLimit);
                                                    case BaseConstants.ERR_SVR_GROUP_COUNT_LIMIT /* 10037 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupCountLimit);
                                                    case BaseConstants.ERR_SVR_GROUP_MEMBER_COUNT_LIMIT /* 10038 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRGroupMemberCountLimit);
                                                    case 20001:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgPkgParseFailed);
                                                    case BaseConstants.ERR_SVR_MSG_INTERNAL_AUTH_FAILED /* 20002 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgInternalAuthFailed);
                                                    case BaseConstants.ERR_SVR_MSG_INVALID_ID /* 20003 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgInvalidId);
                                                    case BaseConstants.ERR_SVR_MSG_NET_ERROR /* 20004 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgNetError);
                                                    case 20005:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountInternalError);
                                                    case BaseConstants.ERR_SVR_MSG_PUSH_DENY /* 20006 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgPushDeny);
                                                    case BaseConstants.ERR_SVR_MSG_IN_PEER_BLACKLIST /* 20007 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgInPeerBlackList);
                                                    case BaseConstants.ERR_SVR_MSG_BOTH_NOT_FRIEND /* 20009 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgBothNotFriend);
                                                    case BaseConstants.ERR_SVR_MSG_NOT_PEER_FRIEND /* 20010 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgNotPeerFriend);
                                                    case BaseConstants.ERR_SVR_MSG_NOT_SELF_FRIEND /* 20011 */:
                                                        return getLocalizedString(R.string.TUIkitErrorSVRMsgNotSelfFriend);
                                                    case BaseConstants.ERR_SVR_MSG_SHUTUP_DENY /* 20012 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgShutupDeny);
                                                    case BaseConstants.ERR_SVR_MSG_REVOKE_TIME_LIMIT /* 20016 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgRevokeTimeLimit);
                                                    case BaseConstants.ERR_SVR_MSG_DEL_RAMBLE_INTERNAL_ERROR /* 20018 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgDelRambleInternalError);
                                                    case 30001:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipInvalidParameters);
                                                    case BaseConstants.ERR_SVR_FRIENDSHIP_INVALID_SDKAPPID /* 30002 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipInvalidSdkAppid);
                                                    case BaseConstants.ERR_SVR_FRIENDSHIP_ACCOUNT_NOT_FOUND /* 30003 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipAccountNotFound);
                                                    case BaseConstants.ERR_SVR_FRIENDSHIP_ADMIN_REQUIRED /* 30004 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipAdminRequired);
                                                    case BaseConstants.ERR_SVR_FRIENDSHIP_SENSITIVE_TEXT /* 30005 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipSensitiveText);
                                                    case BaseConstants.ERR_SVR_FRIENDSHIP_INTERNAL_ERROR /* 30006 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountInternalError);
                                                    case BaseConstants.ERR_SVR_FRIENDSHIP_NET_TIMEOUT /* 30007 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipNetTimeout);
                                                    case BaseConstants.ERR_SVR_FRIENDSHIP_WRITE_CONFLICT /* 30008 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipWriteConflict);
                                                    case BaseConstants.ERR_SVR_FRIENDSHIP_ADD_FRIEND_DENY /* 30009 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipAddFriendDeny);
                                                    case 30010:
                                                        return getLocalizedString(R.string.TUIkitErrorSVRFriendshipCountLimit);
                                                    case 30011:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipGroupCountLimit);
                                                    case 30012:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipPendencyLimit);
                                                    case BaseConstants.ERR_SVR_FRIENDSHIP_BLACKLIST_LIMIT /* 30013 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipBlacklistLimit);
                                                    case 30014:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipPeerFriendLimit);
                                                    case 30515:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipInSelfBlacklist);
                                                    case 30516:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipAllowTypeDenyAny);
                                                    case 30525:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipInPeerBlackList);
                                                    case 30539:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipAllowTypeNeedConfirm);
                                                    case BaseConstants.ERR_SVR_FRIENDSHIP_ADD_FRIEND_SEC_RSTR /* 30540 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipAddFriendSecRstr);
                                                    case BaseConstants.ERR_SVR_FRIENDSHIP_PENDENCY_NOT_FOUND /* 30614 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipPendencyNotFound);
                                                    case BaseConstants.ERR_SVR_FRIENDSHIP_DEL_FRIEND_SEC_RSTR /* 31707 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipDelFriendSecRstr);
                                                    case BaseConstants.ERR_SVR_FRIENDSHIP_ACCOUNT_NOT_FOUND_EX /* 31804 */:
                                                        return getLocalizedString(R.string.TUIKirErrorSVRFriendAccountNotFoundEx);
                                                    case BaseConstants.ERR_SVR_PROFILE_INVALID_PARAMETERS /* 40001 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRProfileInvalidParameters);
                                                    case BaseConstants.ERR_SVR_PROFILE_ACCOUNT_MISS /* 40002 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRProfileAccountMiss);
                                                    case BaseConstants.ERR_SVR_PROFILE_ACCOUNT_NOT_FOUND /* 40003 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRProfileAccountNotFound);
                                                    case BaseConstants.ERR_SVR_PROFILE_ADMIN_REQUIRED /* 40004 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRProfileAdminRequired);
                                                    case BaseConstants.ERR_SVR_PROFILE_SENSITIVE_TEXT /* 40005 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRProfileSensitiveText);
                                                    case BaseConstants.ERR_SVR_PROFILE_INTERNAL_ERROR /* 40006 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRProfileInternalError);
                                                    case BaseConstants.ERR_SVR_PROFILE_READ_PERMISSION_REQUIRED /* 40007 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRProfileReadWritePermissionRequired);
                                                    case BaseConstants.ERR_SVR_PROFILE_WRITE_PERMISSION_REQUIRED /* 40008 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRProfileReadWritePermissionRequired);
                                                    case BaseConstants.ERR_SVR_PROFILE_TAG_NOT_FOUND /* 40009 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRProfileTagNotFound);
                                                    case BaseConstants.ERR_SVR_PROFILE_SIZE_LIMIT /* 40601 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRProfileSizeLimit);
                                                    case BaseConstants.ERR_SVR_PROFILE_VALUE_ERROR /* 40605 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRProfileValueError);
                                                    case BaseConstants.ERR_SVR_PROFILE_INVALID_VALUE_FORMAT /* 40610 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRProfileInvalidValueFormat);
                                                    case BaseConstants.ERR_SVR_CONV_ACCOUNT_NOT_FOUND /* 50001 */:
                                                        return getLocalizedString(R.string.TUIKirErrorSVRFriendAccountNotFoundEx);
                                                    case BaseConstants.ERR_SVR_CONV_INVALID_PARAMETERS /* 50002 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipInvalidParameters);
                                                    case BaseConstants.ERR_SVR_CONV_ADMIN_REQUIRED /* 50003 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipAdminRequired);
                                                    case BaseConstants.ERR_SVR_CONV_INTERNAL_ERROR /* 50004 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountInternalError);
                                                    case BaseConstants.ERR_SVR_CONV_NET_TIMEOUT /* 50005 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRFriendshipNetTimeout);
                                                    case BaseConstants.ERR_SVR_COMM_INVALID_HTTP_URL /* 60002 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonInvalidHttpUrl);
                                                    case BaseConstants.ERR_SVR_COMM_REQ_JSON_PARSE_FAILED /* 60003 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommomReqJsonParseFailed);
                                                    case BaseConstants.ERR_SVR_COMM_INVALID_ACCOUNT /* 60004 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonInvalidAccount);
                                                    case BaseConstants.ERR_SVR_COMM_INVALID_ACCOUNT_EX /* 60005 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonInvalidAccount);
                                                    case BaseConstants.ERR_SVR_COMM_INVALID_SDKAPPID /* 60006 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonInvalidSdkappid);
                                                    case BaseConstants.ERR_SVR_COMM_REST_FREQ_LIMIT /* 60007 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonRestFreqLimit);
                                                    case BaseConstants.ERR_SVR_COMM_REQUEST_TIMEOUT /* 60008 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonRequestTimeout);
                                                    case BaseConstants.ERR_SVR_COMM_INVALID_RES /* 60009 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonInvalidRes);
                                                    case BaseConstants.ERR_SVR_COMM_ID_NOT_ADMIN /* 60010 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonIDNotAdmin);
                                                    case BaseConstants.ERR_SVR_COMM_SDKAPPID_FREQ_LIMIT /* 60011 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonSdkappidFreqLimit);
                                                    case BaseConstants.ERR_SVR_COMM_SDKAPPID_MISS /* 60012 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonSdkappidMiss);
                                                    case BaseConstants.ERR_SVR_COMM_RSP_JSON_PARSE_FAILED /* 60013 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonRspJsonParseFailed);
                                                    case BaseConstants.ERR_SVR_COMM_EXCHANGE_ACCOUNT_TIMEUT /* 60014 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonExchangeAccountTimeout);
                                                    case BaseConstants.ERR_SVR_COMM_INVALID_ID_FORMAT /* 60015 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonInvalidIdFormat);
                                                    case BaseConstants.ERR_SVR_COMM_SDKAPPID_FORBIDDEN /* 60016 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonSDkappidForbidden);
                                                    case BaseConstants.ERR_SVR_COMM_REQ_FORBIDDEN /* 60017 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonReqForbidden);
                                                    case BaseConstants.ERR_SVR_COMM_REQ_FREQ_LIMIT /* 60018 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonReqFreqLimit);
                                                    case BaseConstants.ERR_SVR_COMM_REQ_FREQ_LIMIT_EX /* 60019 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonReqFreqLimit);
                                                    case BaseConstants.ERR_SVR_COMM_INVALID_SERVICE /* 60020 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonInvalidService);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_USERSIG_EXPIRED /* 70001 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountUserSigExpired);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_USERSIG_EMPTY /* 70002 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountUserSigEmpty);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_USERSIG_CHECK_FAILED /* 70003 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountUserSigCheckFailed);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_USERSIG_CHECK_FAILED_EX /* 70005 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountUserSigCheckFailed);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_USERSIG_MISMATCH_PUBLICKEY /* 70009 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountUserSigMismatchPublicKey);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_USERSIG_MISMATCH_ID /* 70013 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountUserSigMismatchId);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_USERSIG_MISMATCH_SDKAPPID /* 70014 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountUserSigMismatchSdkAppid);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_USERSIG_PUBLICKEY_NOT_FOUND /* 70016 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountUserSigPublicKeyNotFound);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_SDKAPPID_NOT_FOUND /* 70020 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountUserSigSdkAppidNotFount);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_FREQ_LIMIT /* 70050 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountFreqLimit);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_BLACKLIST /* 70051 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountBlackList);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_INVALID_USERSIG /* 70052 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountInvalidUserSig);
                                                    case BaseConstants.ERR_LOGIN_SIG_EXPIRE /* 70101 */:
                                                        return getLocalizedString(R.string.TUIKitErrorLoginSigExpire);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_NOT_FOUND /* 70107 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountNotFound);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_SEC_RSTR /* 70114 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountSecRstr);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_INTERNAL_TIMEOUT /* 70169 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountInternalTimeout);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_INVALID_COUNT /* 70206 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountInvalidCount);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_COUNT_LIMIT /* 70398 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountCountLimit);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_INVALID_PARAMETERS /* 70402 */:
                                                        return getLocalizedString(R.string.TUIkitErrorSVRAccountINvalidParameters);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_ADMIN_REQUIRED /* 70403 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountAdminRequired);
                                                    case BaseConstants.ERR_SVR_ACCOUNT_INTERNAL_ERROR /* 70500 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountInternalError);
                                                    case BaseConstants.ERR_SVR_COMM_SENSITIVE_TEXT /* 80001 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonSensitiveText);
                                                    case BaseConstants.ERR_SVR_COMM_BODY_SIZE_LIMIT /* 80002 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRCommonBodySizeLimit);
                                                    case BaseConstants.ERR_REQ_CONTENT_ATTACK /* 80101 */:
                                                        return getLocalizedString(R.string.TUIKitErrorReqContentAttach);
                                                    case BaseConstants.ERR_SVR_MSG_JSON_PARSE_FAILED /* 90001 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgJsonParseFailed);
                                                    case BaseConstants.ERR_SVR_MSG_INVALID_JSON_BODY_FORMAT /* 90002 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgInvalidJsonBodyFormat);
                                                    case BaseConstants.ERR_SVR_MSG_INVALID_TO_ACCOUNT /* 90003 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgInvalidToAccount);
                                                    case BaseConstants.ERR_SVR_MSG_INVALID_RAND /* 90005 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgInvalidRand);
                                                    case BaseConstants.ERR_SVR_MSG_INVALID_TIMESTAMP /* 90006 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgInvalidTimestamp);
                                                    case BaseConstants.ERR_SVR_MSG_BODY_NOT_ARRAY /* 90007 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgBodyNotArray);
                                                    case BaseConstants.ERR_SVR_MSG_ADMIN_REQUIRED /* 90009 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountAdminRequired);
                                                    case BaseConstants.ERR_SVR_MSG_INVALID_JSON_FORMAT /* 90010 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgInvalidJsonFormat);
                                                    case BaseConstants.ERR_SVR_MSG_TO_ACCOUNT_COUNT_LIMIT /* 90011 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgToAccountCountLimit);
                                                    case BaseConstants.ERR_SVR_MSG_TO_ACCOUNT_NOT_FOUND /* 90012 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgToAccountNotFound);
                                                    case BaseConstants.ERR_SVR_MSG_TIME_LIMIT /* 90026 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgTimeLimit);
                                                    case BaseConstants.ERR_SVR_MSG_INVALID_SYNCOTHERMACHINE /* 90031 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgInvalidSyncOtherMachine);
                                                    case BaseConstants.ERR_SVR_MSG_INVALID_MSGLIFETIME /* 90044 */:
                                                        return getLocalizedString(R.string.TUIkitErrorSVRMsgInvalidMsgLifeTime);
                                                    case BaseConstants.ERR_SVR_MSG_ACCOUNT_NOT_FOUND /* 90048 */:
                                                        return getLocalizedString(R.string.TUIKirErrorSVRFriendAccountNotFoundEx);
                                                    case BaseConstants.ERR_SDK_HAD_INITIALIZED /* 90101 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSDKHadInit);
                                                    case BaseConstants.ERR_SVR_MSG_INTERNAL_ERROR5 /* 90992 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountInternalError);
                                                    case BaseConstants.ERR_SVR_MSG_INTERNAL_ERROR2 /* 90994 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountInternalError);
                                                    case BaseConstants.ERR_SVR_MSG_INTERNAL_ERROR3 /* 90995 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountInternalError);
                                                    case BaseConstants.ERR_SVR_MSG_INTERNAL_ERROR4 /* 91000 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRAccountInternalError);
                                                    case BaseConstants.ERR_SVR_MSG_LONGPOLLING_COUNT_LIMIT /* 91101 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRmsgLongPollingCountLimit);
                                                    case BaseConstants.ERR_SVR_MSG_BODY_SIZE_LIMIT /* 93000 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRMsgBodySizeLimit);
                                                    case BaseConstants.ERR_SVR_RES_NOT_FOUND /* 114000 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRResNotFound);
                                                    case BaseConstants.ERR_SVR_RES_ACCESS_DENY /* 114001 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRResAccessDeny);
                                                    case BaseConstants.ERR_SVR_RES_SIZE_LIMIT /* 114002 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRResSizeLimit);
                                                    case BaseConstants.ERR_SVR_RES_SEND_CANCEL /* 114003 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRResSendCancel);
                                                    case BaseConstants.ERR_SVR_RES_READ_FAILED /* 114004 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRResReadFailed);
                                                    case BaseConstants.ERR_SVR_RES_TRANSFER_TIMEOUT /* 114005 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRResTransferTimeout);
                                                    case BaseConstants.ERR_SVR_RES_INVALID_PARAMETERS /* 114011 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRResInvalidParameters);
                                                    case BaseConstants.ERR_OPENBDH_BASE /* 115000 */:
                                                        return getLocalizedString(R.string.TUIKitErrorOpenBDHBase);
                                                    case BaseConstants.ERR_SVR_RES_INVALID_FILE_MD5 /* 115066 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRResInvalidFileMd5);
                                                    case BaseConstants.ERR_SVR_RES_INVALID_PART_MD5 /* 115068 */:
                                                        return getLocalizedString(R.string.TUIKitErrorSVRResInvalidPartMd5);
                                                    default:
                                                        switch (i2) {
                                                            case BaseConstants.ERR_PACKET_FAIL_UNKNOWN /* 6120 */:
                                                                return getLocalizedString(R.string.TUIKitErrorPacketFailUnknown);
                                                            case BaseConstants.ERR_PACKET_FAIL_REQ_NO_NET /* 6121 */:
                                                                return getLocalizedString(R.string.TUIKitErrorPacketFailReqNoNet);
                                                            case BaseConstants.ERR_PACKET_FAIL_RESP_NO_NET /* 6122 */:
                                                                return getLocalizedString(R.string.TUIKitErrorPacketFailRespNoNet);
                                                            case BaseConstants.ERR_PACKET_FAIL_REQ_NO_AUTH /* 6123 */:
                                                                return getLocalizedString(R.string.TUIKitErrorPacketFailReqNoAuth);
                                                            case BaseConstants.ERR_PACKET_FAIL_SSO_ERR /* 6124 */:
                                                                return getLocalizedString(R.string.TUIKitErrorPacketFailSSOErr);
                                                            case BaseConstants.ERR_PACKET_FAIL_REQ_TIMEOUT /* 6125 */:
                                                                return getLocalizedString(R.string.TUIKitErrorSVRRequestTimeout);
                                                            case BaseConstants.ERR_PACKET_FAIL_RESP_TIMEOUT /* 6126 */:
                                                                return getLocalizedString(R.string.TUIKitErrorPacketFailRespTimeout);
                                                            default:
                                                                switch (i2) {
                                                                    case BaseConstants.ERR_FRIENDSHIP_PROXY_NOT_SYNCED /* 6150 */:
                                                                        return getLocalizedString(R.string.TUIKitErrorFriendshipProxySyncing);
                                                                    case BaseConstants.ERR_FRIENDSHIP_PROXY_SYNCING /* 6151 */:
                                                                        return getLocalizedString(R.string.TUIKitErrorFriendshipProxySyncing);
                                                                    case BaseConstants.ERR_FRIENDSHIP_PROXY_SYNCED_FAIL /* 6152 */:
                                                                        return getLocalizedString(R.string.TUIKitErrorFriendshipProxySyncedFail);
                                                                    case BaseConstants.ERR_FRIENDSHIP_PROXY_LOCAL_CHECK_ERR /* 6153 */:
                                                                        return getLocalizedString(R.string.TUIKitErrorFriendshipProxyLocalCheckErr);
                                                                    default:
                                                                        switch (i2) {
                                                                            case BaseConstants.ERR_GROUP_INVALID_FIELD /* 6160 */:
                                                                                return getLocalizedString(R.string.TUIKitErrorGroupInvalidField);
                                                                            case BaseConstants.ERR_GROUP_STORAGE_DISABLED /* 6161 */:
                                                                                return getLocalizedString(R.string.TUIKitErrorGroupStoreageDisabled);
                                                                            case BaseConstants.ERR_LOADGRPINFO_FAILED /* 6162 */:
                                                                                return getLocalizedString(R.string.TUIKitErrorLoadGrpInfoFailed);
                                                                            default:
                                                                                switch (i2) {
                                                                                    case BaseConstants.ERR_SERIVCE_NOT_READY /* 6205 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorServiceNotReady);
                                                                                    case BaseConstants.ERR_USER_SIG_EXPIRED /* 6206 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorUserSigExpired);
                                                                                    case BaseConstants.ERR_LOGIN_AUTH_FAILED /* 6207 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorLoginAuthFailed);
                                                                                    case BaseConstants.ERR_LOGIN_KICKED_OFF_BY_OTHER /* 6208 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorLoginKickedOffByOther);
                                                                                    case BaseConstants.ERR_NEVER_CONNECT_AFTER_LAUNCH /* 6209 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorNeverConnectAfterLaunch);
                                                                                    case BaseConstants.ERR_REQ_FAILED /* 6210 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorReqFailed);
                                                                                    case BaseConstants.ERR_REQ_INVALID_REQ /* 6211 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorReqInvaidReq);
                                                                                    case BaseConstants.ERR_REQ_OVERLOADED /* 6212 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorReqOnverLoaded);
                                                                                    case BaseConstants.ERR_REQ_KICK_OFF /* 6213 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorReqKickOff);
                                                                                    case BaseConstants.ERR_REQ_SERVICE_SUSPEND /* 6214 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorReqServiceSuspend);
                                                                                    case BaseConstants.ERR_REQ_INVALID_SIGN /* 6215 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorReqInvalidSign);
                                                                                    case BaseConstants.ERR_REQ_INVALID_COOKIE /* 6216 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorReqInvalidCookie);
                                                                                    case BaseConstants.ERR_LOGIN_TLS_RSP_PARSE_FAILED /* 6217 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorLoginTlsRspParseFailed);
                                                                                    case BaseConstants.ERR_LOGIN_OPENMSG_TIMEOUT /* 6218 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorLoginOpenMsgTimeout);
                                                                                    case BaseConstants.ERR_LOGIN_OPENMSG_RSP_PARSE_FAILED /* 6219 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorLoginOpenMsgRspParseFailed);
                                                                                    case BaseConstants.ERR_LOGIN_TLS_DECRYPT_FAILED /* 6220 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorLoginTslDecryptFailed);
                                                                                    case BaseConstants.ERR_WIFI_NEED_AUTH /* 6221 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorWifiNeedAuth);
                                                                                    case BaseConstants.ERR_USER_CANCELED /* 6222 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorUserCanceled);
                                                                                    case 6223:
                                                                                        return getLocalizedString(R.string.TUIkitErrorRevokeTimeLimitExceed);
                                                                                    case BaseConstants.ERR_LACK_UGC_EXT /* 6224 */:
                                                                                        return getLocalizedString(R.string.TUIKitErrorLackUGExt);
                                                                                    default:
                                                                                        return str;
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                            }
                            return getLocalizedString(R.string.TUIKitErrorReqNoNetOnResp);
                        }
                        return getLocalizedString(R.string.TUIKitErrorReqNoNetOnReq);
                    }
                    return getLocalizedString(R.string.TUIKitErrorBindFaildIsBinding);
                }
                return getLocalizedString(R.string.TUIKitErrorBindFaildRegTimeout);
            }
            return getLocalizedString(R.string.TUIKitErrorSDKSVRSSOVCode);
        }
        return getLocalizedString(R.string.TUIKitErrorSVRSSOD2Expired);
    }

    private static String getLocalizedString(int i2) {
        return TUIConfig.getAppContext().getString(i2);
    }
}
