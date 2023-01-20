package com.jihuanshe.base.model;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.Serializable;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import okhttp3.Headers;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u001c\u0010\"\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010\u001fR\u001e\u0010%\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u0011\u0010(\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/jihuanshe/base/model/Result;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "()V", "code", "", "getCode", "()Ljava/lang/Integer;", "setCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "data", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "header", "Lokhttp3/Headers;", "getHeader", "()Lokhttp3/Headers;", "setHeader", "(Lokhttp3/Headers;)V", "isSuccessful", "", "()Z", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "messageDetail", "getMessageDetail", "msg", "getMsg", "setMsg", "status", "getStatus", "setStatus", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "getStatusCode", "()I", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class Result<T> implements Serializable {
    @e
    private Integer code;
    @e
    private T data;
    @e
    private Headers header;
    @e
    private String message;
    @e
    private String msg;
    @e
    private Integer status;

    @e
    public final Integer getCode() {
        return this.code;
    }

    @e
    public final T getData() {
        return this.data;
    }

    @e
    public final Headers getHeader() {
        return this.header;
    }

    @e
    public final String getMessage() {
        return this.message;
    }

    @d
    public final String getMessageDetail() {
        String str;
        String str2 = this.message;
        if (str2 == null || str2.length() == 0) {
            str = this.msg;
            if (str == null) {
                return "";
            }
        } else {
            str = this.message;
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    @e
    public final String getMsg() {
        return this.msg;
    }

    @e
    public final Integer getStatus() {
        return this.status;
    }

    public final int getStatusCode() {
        Integer num = this.code;
        if (num == null && (num = this.status) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final boolean isSuccessful() {
        Integer num = this.code;
        if (num != null && num.intValue() == 1) {
            return true;
        }
        Integer num2 = this.status;
        return num2 != null && num2.intValue() == 1;
    }

    public final void setCode(@e Integer num) {
        this.code = num;
    }

    public final void setData(@e T t) {
        this.data = t;
    }

    public final void setHeader(@e Headers headers) {
        this.header = headers;
    }

    public final void setMessage(@e String str) {
        this.message = str;
    }

    public final void setMsg(@e String str) {
        this.msg = str;
    }

    public final void setStatus(@e Integer num) {
        this.status = num;
    }
}
