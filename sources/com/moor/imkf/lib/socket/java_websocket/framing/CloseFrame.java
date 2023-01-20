package com.moor.imkf.lib.socket.java_websocket.framing;

import com.moor.imkf.lib.socket.java_websocket.enums.Opcode;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidDataException;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidFrameException;
import com.moor.imkf.lib.socket.java_websocket.util.ByteBufferUtils;
import com.moor.imkf.lib.socket.java_websocket.util.Charsetfunctions;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class CloseFrame extends ControlFrame {
    public static final int ABNORMAL_CLOSE = 1006;
    public static final int BAD_GATEWAY = 1014;
    public static final int BUGGYCLOSE = -2;
    public static final int EXTENSION = 1010;
    public static final int FLASHPOLICY = -3;
    public static final int GOING_AWAY = 1001;
    public static final int NEVER_CONNECTED = -1;
    public static final int NOCODE = 1005;
    public static final int NORMAL = 1000;
    public static final int NO_UTF8 = 1007;
    public static final int POLICY_VALIDATION = 1008;
    public static final int PROTOCOL_ERROR = 1002;
    public static final int REFUSE = 1003;
    public static final int SERVICE_RESTART = 1012;
    public static final int TLS_ERROR = 1015;
    public static final int TOOBIG = 1009;
    public static final int TRY_AGAIN_LATER = 1013;
    public static final int UNEXPECTED_CONDITION = 1011;
    private int code;
    private String reason;

    public CloseFrame() {
        super(Opcode.CLOSING);
        setReason("");
        setCode(1000);
    }

    private void updatePayload() {
        byte[] utf8Bytes = Charsetfunctions.utf8Bytes(this.reason);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(this.code);
        allocate.position(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(utf8Bytes.length + 2);
        allocate2.put(allocate);
        allocate2.put(utf8Bytes);
        allocate2.rewind();
        super.setPayload(allocate2);
    }

    private void validateUtf8(ByteBuffer byteBuffer, int i2) throws InvalidDataException {
        try {
            try {
                byteBuffer.position(byteBuffer.position() + 2);
                this.reason = Charsetfunctions.stringUtf8(byteBuffer);
            } catch (IllegalArgumentException unused) {
                throw new InvalidDataException(1007);
            }
        } finally {
            byteBuffer.position(i2);
        }
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.framing.FramedataImpl1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && super.equals(obj)) {
            CloseFrame closeFrame = (CloseFrame) obj;
            if (this.code != closeFrame.code) {
                return false;
            }
            String str = this.reason;
            String str2 = closeFrame.reason;
            return str != null ? str.equals(str2) : str2 == null;
        }
        return false;
    }

    public int getCloseCode() {
        return this.code;
    }

    public String getMessage() {
        return this.reason;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.framing.FramedataImpl1, com.moor.imkf.lib.socket.java_websocket.framing.Framedata
    public ByteBuffer getPayloadData() {
        if (this.code == 1005) {
            return ByteBufferUtils.getEmptyByteBuffer();
        }
        return super.getPayloadData();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.framing.FramedataImpl1
    public int hashCode() {
        int hashCode = ((super.hashCode() * 31) + this.code) * 31;
        String str = this.reason;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.framing.ControlFrame, com.moor.imkf.lib.socket.java_websocket.framing.FramedataImpl1
    public void isValid() throws InvalidDataException {
        super.isValid();
        if (this.code == 1007 && this.reason.isEmpty()) {
            throw new InvalidDataException(1007, "Received text is no valid utf8 string!");
        }
        if (this.code == 1005 && this.reason.length() > 0) {
            throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
        }
        int i2 = this.code;
        if (i2 > 1015 && i2 < 3000) {
            throw new InvalidDataException(1002, "Trying to send an illegal close code!");
        }
        if (i2 == 1006 || i2 == 1015 || i2 == 1005 || i2 > 4999 || i2 < 1000 || i2 == 1004) {
            throw new InvalidFrameException("closecode must not be sent over the wire: " + this.code);
        }
    }

    public void setCode(int i2) {
        this.code = i2;
        if (i2 == 1015) {
            this.code = 1005;
            this.reason = "";
        }
        updatePayload();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.framing.FramedataImpl1
    public void setPayload(ByteBuffer byteBuffer) {
        this.code = 1005;
        this.reason = "";
        byteBuffer.mark();
        if (byteBuffer.remaining() == 0) {
            this.code = 1000;
        } else if (byteBuffer.remaining() == 1) {
            this.code = 1002;
        } else {
            if (byteBuffer.remaining() >= 2) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.position(2);
                allocate.putShort(byteBuffer.getShort());
                allocate.position(0);
                this.code = allocate.getInt();
            }
            byteBuffer.reset();
            try {
                validateUtf8(byteBuffer, byteBuffer.position());
            } catch (InvalidDataException unused) {
                this.code = 1007;
                this.reason = null;
            }
        }
    }

    public void setReason(String str) {
        if (str == null) {
            str = "";
        }
        this.reason = str;
        updatePayload();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.framing.FramedataImpl1
    public String toString() {
        return super.toString() + "code: " + this.code;
    }
}
