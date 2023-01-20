package com.tencent.android.tpush.common;

import com.tencent.imsdk.BaseConstants;

/* loaded from: classes3.dex */
public enum ReturnCode {
    FLAG_ONLINE(0, "返回标志，表示在线操作"),
    FLAG_OFFLINE(1, "返回标志，表示离线操作"),
    CODE_SUCCESS(0, "成功"),
    ERRORCODE_UNKNOWN(10000, "起始错误"),
    CODE_LOGIC_ILLEGAL_ARGUMENT(10001, "操作类型错误码，例如参数错误时将会发生该错误"),
    CODE_LOGIC_REGISTER_IN_PROCESS(10002, "正在执行注册操作时，又有一个注册操作到来，则回调此错误码"),
    CODE_PERMISSIONS_ERROR(10003, "权限出错"),
    CODE_SO_ERROR(BaseConstants.ERR_SVR_GROUP_INVALID_PARAMETERS, ".so出错"),
    CODE_ACCESSKET_OR_ACCESSID_ERROR(BaseConstants.ERR_SVR_GROUP_FREQ_LIMIT, "AccessKey 或者 AccessID 错误"),
    CODE_SERVICE_DISABLED(10007, "初始化信鸽Service错误"),
    CODE_PROVIDER_ERROR(BaseConstants.ERR_SVR_GROUP_INVALID_REQ, "AccessKey 或者 AccessID 错误"),
    CODE_JCE_ERROR(BaseConstants.ERR_SVR_GROUP_SUPER_NOT_ALLOW_QUIT, "jce JAR错误"),
    CODE_NETWORK_UNREACHABLE(10100, "当前网络不可用"),
    CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED(10101, "创建链路失败"),
    CODE_NETWORK_CHANNEL_CANCELLED(10102, "请求处理过程中， 链路被主动关闭"),
    CODE_NETWORK_IOEXCEPTION_OCCUR(10103, "请求处理过程中，服务器关闭链接"),
    CODE_NETWORK_INNER_EXCEPTION_OCCUR(10104, "请求处理过程中，客户段产生异常"),
    CODE_NETWORK_TIMEOUT_EXCEPTION_OCCUR(10105, "请求处理过程中，发送或接收报文超时"),
    CODE_NETWORK_TIMEOUT_WAITING_TO_SEND(10106, "请求处理过程中， 等待发送请求超时"),
    CODE_NETWORK_TIMEOUT_WAITING_FOR_RESPONSE(10107, "请求处理过程中，等待接收应答超时"),
    CODE_NETWORK_UNEXPECTED_DATA_EXCEPTION_OCCUR(10108, "服务器返回异常报文"),
    CODE_NETWORK_UNKNOWN_EXCEPTION(10109, "未知异常"),
    CODE_NETWORK_HANDLER_NULL(10110, "创建链路的handler为null"),
    CODE_NETWORK_SECERETY_EEROR(10111, "认证过程错误"),
    CODE_DUPLICATE_REGISTER_EEROR(10115, "短时间内重复注册"),
    CODE_INVALID_ACCOUNT(10116, "无效的账号"),
    CODE_INVALID_TAG(10117, "无效的标签"),
    CODE_INVALID_ATTRIBUTE(10118, "无效的用户属性"),
    CODE_INVALID_QUERYTAGS(10119, "无效的查询 TAG 参数"),
    CODE_SDK_API_FREQUENCY_LIMIT_ERROR(10120, "SDK 接口限频，请勿调用推送服务接口 10 秒内超过 10 次"),
    CODE_STRATEGY_INIT(10300, "跑马策略相关返回码"),
    CODE_SDK_PARAM_ERROR(10400, "SDK参数错误");
    
    private String str;
    private int type;

    ReturnCode(int i2, String str) {
        this.type = i2;
        this.str = str;
    }

    public static String errCodeToMsg(int i2) {
        if (i2 != -1) {
            if (i2 != 10115) {
                if (i2 != 20001) {
                    if (i2 != 20002) {
                        switch (i2) {
                            case 10001:
                                return "ILLEGAL_ARGUMENT";
                            case 10002:
                                return "CODE_LOGIC_REGISTER_IN_PROCESS";
                            case 10003:
                                return "CODE_PERMISSIONS_ERROR";
                            case BaseConstants.ERR_SVR_GROUP_INVALID_PARAMETERS /* 10004 */:
                                return "CODE_SO_ERROR";
                            case BaseConstants.ERR_SVR_GROUP_ACOUNT_COUNT_LIMIT /* 10005 */:
                                return "CODE_AIDL_CONFIG_ERROR";
                            case BaseConstants.ERR_SVR_GROUP_FREQ_LIMIT /* 10006 */:
                                return "CODE_ACCESSKEY_OR_ACCESSID_ERROR";
                            case 10007:
                                return "CODE_SERVICE_DISABLED";
                            case BaseConstants.ERR_SVR_GROUP_INVALID_REQ /* 10008 */:
                                return "CODE_PROVIDER_CONFIG_ERROR";
                            case BaseConstants.ERR_SVR_GROUP_SUPER_NOT_ALLOW_QUIT /* 10009 */:
                                return "CODE_JCE_JAR_ERROR";
                            default:
                                return "UNKNOWN_ERROR_CODE";
                        }
                    }
                    return "CODE_MQTT_CONNECT_ERROR";
                }
                return "CODE_SUBSCRIBE_ERROR";
            }
            return "CODE_DUPLICATE_REGISTER_EEROR";
        }
        return "CODE_SDK_INNER_ERROR";
    }

    public String getStr() {
        return this.str;
    }

    public int getType() {
        return this.type;
    }
}
