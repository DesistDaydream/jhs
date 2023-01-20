package com.moor.imkf.lib.socket.websocket.response;

import com.moor.imkf.lib.socket.websocket.request.Request;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class ErrorResponse {
    public static final int ERROR_NO_CONNECT = 0;
    public static final int ERROR_UNKNOWN = 1;
    public static final int ERROR_UN_INIT = 2;
    private Throwable cause;
    private String description;
    private int errorCode;
    private Request requestData;
    private Object reserved;
    private Response responseData;

    public Throwable getCause() {
        return this.cause;
    }

    public String getDescription() {
        return this.description;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public Request getRequestData() {
        return this.requestData;
    }

    public Object getReserved() {
        return this.reserved;
    }

    public Response getResponseData() {
        return this.responseData;
    }

    public void init(Request request, int i2, Throwable th) {
        this.requestData = request;
        this.cause = th;
        this.errorCode = i2;
    }

    public void release() {
        ResponseFactory.releaseErrorResponse(this);
    }

    public void setCause(Throwable th) {
        this.cause = th;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setRequestData(Request request) {
        this.requestData = request;
    }

    public void setReserved(Object obj) {
        this.reserved = obj;
    }

    public void setResponseData(Response response) {
        this.responseData = response;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[@ErrorResponse");
        sb.append(hashCode());
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("errorCode=");
        sb.append(this.errorCode);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("cause=");
        Throwable th = this.cause;
        sb.append(th == null ? "null" : th.toString());
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("requestData=");
        Request request = this.requestData;
        sb.append(request != null ? request.toString() : "null");
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("responseData=");
        Response response = this.responseData;
        sb.append(response != null ? response.toString() : "null");
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("description=");
        sb.append(this.description);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (this.reserved != null) {
            sb.append("reserved=");
            sb.append(this.reserved.toString());
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        sb.append("]");
        return sb.toString();
    }
}
