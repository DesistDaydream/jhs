package com.qiniu.android.http.metrics;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.dns.DnsSource;
import com.qiniu.android.http.request.Request;
import com.qiniu.android.utils.Utils;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UploadSingleRequestMetrics extends UploadMetrics {
    public static final String RequestHijacked = "forsure";
    public static final String RequestMaybeHijacked = "maybe";
    private UploadSingleRequestMetrics connectCheckMetrics;
    private Date connectEndDate;
    private Date connectStartDate;
    private Date domainLookupEndDate;
    private Date domainLookupStartDate;
    private String hijacked;
    private String httpVersion;
    private String localAddress;
    private Integer localPort;
    private String remoteAddress;
    private Integer remotePort;
    private Request request;
    private Date requestEndDate;
    private Date requestStartDate;
    private ResponseInfo response;
    private Date responseEndDate;
    private Date responseStartDate;
    private Date secureConnectionEndDate;
    private Date secureConnectionStartDate;
    private String syncDnsError;
    private String syncDnsSource;
    private String clientName = DnsSource.Custom;
    private String clientVersion = "unknown";
    private long countOfRequestHeaderBytesSent = 0;
    private long countOfRequestBodyBytesSent = 0;
    private long countOfResponseHeaderBytesReceived = 0;
    private long countOfResponseBodyBytesReceived = 0;
    private long totalBytes = 0;

    private long time(Date date, Date date2) {
        return Utils.dateDuration(date, date2);
    }

    public Long bytesReceived() {
        long j2 = this.countOfResponseHeaderBytesReceived + this.countOfResponseBodyBytesReceived;
        if (j2 < 0) {
            j2 = 0;
        }
        return Long.valueOf(j2);
    }

    public Long bytesSend() {
        long j2 = totalBytes();
        long j3 = this.countOfRequestHeaderBytesSent + this.countOfRequestBodyBytesSent;
        if (j3 <= j2) {
            j2 = j3;
        }
        return Long.valueOf(j2);
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getClientVersion() {
        return this.clientVersion;
    }

    public UploadSingleRequestMetrics getConnectCheckMetrics() {
        return this.connectCheckMetrics;
    }

    public Date getConnectEndDate() {
        return this.connectEndDate;
    }

    public Date getConnectStartDate() {
        return this.connectStartDate;
    }

    public long getCountOfRequestBodyBytesSent() {
        return this.countOfRequestBodyBytesSent;
    }

    public long getCountOfRequestHeaderBytesSent() {
        return this.countOfRequestHeaderBytesSent;
    }

    public long getCountOfResponseBodyBytesReceived() {
        return this.countOfResponseBodyBytesReceived;
    }

    public long getCountOfResponseHeaderBytesReceived() {
        return this.countOfResponseHeaderBytesReceived;
    }

    public Date getDomainLookupEndDate() {
        return this.domainLookupEndDate;
    }

    public Date getDomainLookupStartDate() {
        return this.domainLookupStartDate;
    }

    public String getHijacked() {
        return this.hijacked;
    }

    public String getHttpVersion() {
        return this.httpVersion;
    }

    public String getLocalAddress() {
        return this.localAddress;
    }

    public Integer getLocalPort() {
        return this.localPort;
    }

    public String getRemoteAddress() {
        return this.remoteAddress;
    }

    public Integer getRemotePort() {
        return this.remotePort;
    }

    public Request getRequest() {
        return this.request;
    }

    public Date getRequestEndDate() {
        return this.requestEndDate;
    }

    public Date getRequestStartDate() {
        return this.requestStartDate;
    }

    public ResponseInfo getResponse() {
        return this.response;
    }

    public Date getResponseEndDate() {
        return this.responseEndDate;
    }

    public Date getResponseStartDate() {
        return this.responseStartDate;
    }

    public Date getSecureConnectionEndDate() {
        return this.secureConnectionEndDate;
    }

    public Date getSecureConnectionStartDate() {
        return this.secureConnectionStartDate;
    }

    public String getSyncDnsError() {
        return this.syncDnsError;
    }

    public String getSyncDnsSource() {
        return this.syncDnsSource;
    }

    public boolean isForsureHijacked() {
        String str = this.hijacked;
        return str != null && str.contains(RequestHijacked);
    }

    public boolean isMaybeHijacked() {
        String str = this.hijacked;
        return str != null && str.contains(RequestMaybeHijacked);
    }

    public Long perceptiveSpeed() {
        return Utils.calculateSpeed(Long.valueOf(bytesSend().longValue() + bytesReceived().longValue()), Long.valueOf(totalElapsedTime()));
    }

    public void setClientName(String str) {
        this.clientName = str;
    }

    public void setClientVersion(String str) {
        this.clientVersion = str;
    }

    public void setConnectCheckMetrics(UploadSingleRequestMetrics uploadSingleRequestMetrics) {
        this.connectCheckMetrics = uploadSingleRequestMetrics;
    }

    public void setConnectEndDate(Date date) {
        this.connectEndDate = date;
    }

    public void setConnectStartDate(Date date) {
        this.connectStartDate = date;
    }

    public void setCountOfRequestBodyBytesSent(long j2) {
        this.countOfRequestBodyBytesSent = j2;
    }

    public void setCountOfRequestHeaderBytesSent(long j2) {
        this.countOfRequestHeaderBytesSent = j2;
    }

    public void setCountOfResponseBodyBytesReceived(long j2) {
        this.countOfResponseBodyBytesReceived = j2;
    }

    public void setCountOfResponseHeaderBytesReceived(long j2) {
        this.countOfResponseHeaderBytesReceived = j2;
    }

    public void setDomainLookupEndDate(Date date) {
        this.domainLookupEndDate = date;
    }

    public void setDomainLookupStartDate(Date date) {
        this.domainLookupStartDate = date;
    }

    public void setHijacked(String str) {
        this.hijacked = str;
    }

    public void setHttpVersion(String str) {
        this.httpVersion = str;
    }

    public void setLocalAddress(String str) {
        this.localAddress = str;
    }

    public void setLocalPort(Integer num) {
        this.localPort = num;
    }

    public void setRemoteAddress(String str) {
        this.remoteAddress = str;
    }

    public void setRemotePort(Integer num) {
        this.remotePort = num;
    }

    public void setRequest(Request request) {
        if (request != null) {
            Request request2 = new Request(request.urlString, request.httpMethod, request.allHeaders, null, request.timeout);
            this.request = request2;
            request2.host = request.host;
            request2.ip = request.ip;
            long length = request.allHeaders != null ? new JSONObject(request.allHeaders).toString().length() : 0L;
            byte[] bArr = request.httpBody;
            this.totalBytes = length + (bArr != null ? bArr.length : 0L);
        }
    }

    public void setRequestEndDate(Date date) {
        this.requestEndDate = date;
    }

    public void setRequestStartDate(Date date) {
        this.requestStartDate = date;
    }

    public void setResponse(ResponseInfo responseInfo) {
        this.response = responseInfo;
    }

    public void setResponseEndDate(Date date) {
        this.responseEndDate = date;
    }

    public void setResponseStartDate(Date date) {
        this.responseStartDate = date;
    }

    public void setSecureConnectionEndDate(Date date) {
        this.secureConnectionEndDate = date;
    }

    public void setSecureConnectionStartDate(Date date) {
        this.secureConnectionStartDate = date;
    }

    public void setSyncDnsError(String str) {
        this.syncDnsError = str;
    }

    public void setSyncDnsSource(String str) {
        this.syncDnsSource = str;
    }

    public long totalBytes() {
        return this.totalBytes;
    }

    public long totalConnectTime() {
        return time(this.connectStartDate, this.connectEndDate);
    }

    public long totalDnsTime() {
        return time(this.domainLookupStartDate, this.domainLookupEndDate);
    }

    public long totalRequestTime() {
        return time(this.requestStartDate, this.requestEndDate);
    }

    public long totalResponseTime() {
        return time(this.responseStartDate, this.responseEndDate);
    }

    public long totalSecureConnectTime() {
        return time(this.secureConnectionStartDate, this.secureConnectionEndDate);
    }

    public long totalWaitTime() {
        return time(this.requestEndDate, this.responseStartDate);
    }
}
