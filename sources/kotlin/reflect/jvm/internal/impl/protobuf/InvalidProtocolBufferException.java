package kotlin.reflect.jvm.internal.impl.protobuf;

import h.p2.b0.g.t.i.n;
import java.io.IOException;

/* loaded from: classes3.dex */
public class InvalidProtocolBufferException extends IOException {
    private n unfinishedMessage;

    public InvalidProtocolBufferException(String str) {
        super(str);
        this.unfinishedMessage = null;
    }

    public static InvalidProtocolBufferException invalidEndTag() {
        return new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
    }

    public static InvalidProtocolBufferException invalidTag() {
        return new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    public static InvalidProtocolBufferException invalidUtf8() {
        return new InvalidProtocolBufferException("Protocol message had invalid UTF-8.");
    }

    public static InvalidProtocolBufferException invalidWireType() {
        return new InvalidProtocolBufferException("Protocol message tag had invalid wire type.");
    }

    public static InvalidProtocolBufferException malformedVarint() {
        return new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
    }

    public static InvalidProtocolBufferException negativeSize() {
        return new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static InvalidProtocolBufferException recursionLimitExceeded() {
        return new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static InvalidProtocolBufferException sizeLimitExceeded() {
        return new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static InvalidProtocolBufferException truncatedMessage() {
        return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public n getUnfinishedMessage() {
        return this.unfinishedMessage;
    }

    public InvalidProtocolBufferException setUnfinishedMessage(n nVar) {
        this.unfinishedMessage = nVar;
        return this;
    }
}
