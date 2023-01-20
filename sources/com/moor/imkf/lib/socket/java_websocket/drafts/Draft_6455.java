package com.moor.imkf.lib.socket.java_websocket.drafts;

import androidx.annotation.RequiresApi;
import com.moor.imkf.lib.socket.java_websocket.WebSocketImpl;
import com.moor.imkf.lib.socket.java_websocket.enums.CloseHandshakeType;
import com.moor.imkf.lib.socket.java_websocket.enums.HandshakeState;
import com.moor.imkf.lib.socket.java_websocket.enums.Opcode;
import com.moor.imkf.lib.socket.java_websocket.enums.ReadyState;
import com.moor.imkf.lib.socket.java_websocket.enums.Role;
import com.moor.imkf.lib.socket.java_websocket.exceptions.IncompleteException;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidDataException;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidFrameException;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidHandshakeException;
import com.moor.imkf.lib.socket.java_websocket.exceptions.LimitExceededException;
import com.moor.imkf.lib.socket.java_websocket.exceptions.NotSendableException;
import com.moor.imkf.lib.socket.java_websocket.extensions.DefaultExtension;
import com.moor.imkf.lib.socket.java_websocket.extensions.IExtension;
import com.moor.imkf.lib.socket.java_websocket.framing.BinaryFrame;
import com.moor.imkf.lib.socket.java_websocket.framing.CloseFrame;
import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.java_websocket.framing.FramedataImpl1;
import com.moor.imkf.lib.socket.java_websocket.framing.TextFrame;
import com.moor.imkf.lib.socket.java_websocket.handshake.ClientHandshake;
import com.moor.imkf.lib.socket.java_websocket.handshake.ClientHandshakeBuilder;
import com.moor.imkf.lib.socket.java_websocket.handshake.HandshakeBuilder;
import com.moor.imkf.lib.socket.java_websocket.handshake.ServerHandshake;
import com.moor.imkf.lib.socket.java_websocket.handshake.ServerHandshakeBuilder;
import com.moor.imkf.lib.socket.java_websocket.logger.Logger;
import com.moor.imkf.lib.socket.java_websocket.logger.LoggerFactory;
import com.moor.imkf.lib.socket.java_websocket.protocols.IProtocol;
import com.moor.imkf.lib.socket.java_websocket.protocols.Protocol;
import com.moor.imkf.lib.socket.java_websocket.util.Base64;
import com.moor.imkf.lib.socket.java_websocket.util.Charsetfunctions;
import com.umeng.analytics.pro.cb;
import h.k2.v.n;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes2.dex */
public class Draft_6455 extends Draft {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CONNECTION = "Connection";
    private static final String SEC_WEB_SOCKET_ACCEPT = "Sec-WebSocket-Accept";
    private static final String SEC_WEB_SOCKET_EXTENSIONS = "Sec-WebSocket-Extensions";
    private static final String SEC_WEB_SOCKET_KEY = "Sec-WebSocket-Key";
    private static final String SEC_WEB_SOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
    private static final String UPGRADE = "Upgrade";
    private final List<ByteBuffer> byteBufferList;
    private Framedata currentContinuousFrame;
    private IExtension extension;
    private ByteBuffer incompleteframe;
    private List<IExtension> knownExtensions;
    private List<IProtocol> knownProtocols;
    private final Logger log;
    private int maxFrameSize;
    private IProtocol protocol;
    private final Random reuseableRandom;

    /* loaded from: classes2.dex */
    public class TranslatedPayloadMetaData {
        private int payloadLength;
        private int realPackageSize;

        public TranslatedPayloadMetaData(int i2, int i3) {
            Draft_6455.this = r1;
            this.payloadLength = i2;
            this.realPackageSize = i3;
        }

        public int getPayloadLength() {
            return this.payloadLength;
        }

        public int getRealPackageSize() {
            return this.realPackageSize;
        }
    }

    public Draft_6455() {
        this(Collections.emptyList());
    }

    private void addToBufferList(ByteBuffer byteBuffer) {
        synchronized (this.byteBufferList) {
            this.byteBufferList.add(byteBuffer);
        }
    }

    private void checkBufferLimit() throws LimitExceededException {
        long byteBufferListSize = getByteBufferListSize();
        if (byteBufferListSize <= this.maxFrameSize) {
            return;
        }
        clearBufferList();
        this.log.trace("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(this.maxFrameSize), Long.valueOf(byteBufferListSize));
        throw new LimitExceededException(this.maxFrameSize);
    }

    private void clearBufferList() {
        synchronized (this.byteBufferList) {
            this.byteBufferList.clear();
        }
    }

    private HandshakeState containsRequestedProtocol(String str) {
        for (IProtocol iProtocol : this.knownProtocols) {
            if (iProtocol.acceptProvidedProtocol(str)) {
                this.protocol = iProtocol;
                this.log.trace("acceptHandshake - Matching protocol found: {}", iProtocol);
                return HandshakeState.MATCHED;
            }
        }
        return HandshakeState.NOT_MATCHED;
    }

    private ByteBuffer createByteBufferFromFramedata(Framedata framedata) {
        ByteBuffer payloadData = framedata.getPayloadData();
        int i2 = 0;
        boolean z = this.role == Role.CLIENT;
        int sizeBytes = getSizeBytes(payloadData);
        ByteBuffer allocate = ByteBuffer.allocate((sizeBytes > 1 ? sizeBytes + 1 : sizeBytes) + 1 + (z ? 4 : 0) + payloadData.remaining());
        byte fromOpcode = (byte) (fromOpcode(framedata.getOpcode()) | ((byte) (framedata.isFin() ? -128 : 0)));
        if (framedata.isRSV1()) {
            fromOpcode = (byte) (fromOpcode | getRSVByte(1));
        }
        if (framedata.isRSV2()) {
            fromOpcode = (byte) (fromOpcode | getRSVByte(2));
        }
        if (framedata.isRSV3()) {
            fromOpcode = (byte) (getRSVByte(3) | fromOpcode);
        }
        allocate.put(fromOpcode);
        byte[] byteArray = toByteArray(payloadData.remaining(), sizeBytes);
        if (sizeBytes == 1) {
            allocate.put((byte) (byteArray[0] | getMaskByte(z)));
        } else if (sizeBytes == 2) {
            allocate.put((byte) (getMaskByte(z) | 126));
            allocate.put(byteArray);
        } else if (sizeBytes == 8) {
            allocate.put((byte) (getMaskByte(z) | n.b));
            allocate.put(byteArray);
        } else {
            throw new IllegalStateException("Size representation not supported/specified");
        }
        if (z) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.reuseableRandom.nextInt());
            allocate.put(allocate2.array());
            while (payloadData.hasRemaining()) {
                allocate.put((byte) (payloadData.get() ^ allocate2.get(i2 % 4)));
                i2++;
            }
        } else {
            allocate.put(payloadData);
            payloadData.flip();
        }
        allocate.flip();
        return allocate;
    }

    private byte fromOpcode(Opcode opcode) {
        if (opcode == Opcode.CONTINUOUS) {
            return (byte) 0;
        }
        if (opcode == Opcode.TEXT) {
            return (byte) 1;
        }
        if (opcode == Opcode.BINARY) {
            return (byte) 2;
        }
        if (opcode == Opcode.CLOSING) {
            return (byte) 8;
        }
        if (opcode == Opcode.PING) {
            return (byte) 9;
        }
        if (opcode == Opcode.PONG) {
            return (byte) 10;
        }
        throw new IllegalArgumentException("Don't know how to handle " + opcode.toString());
    }

    private String generateFinalKey(String str) {
        try {
            return Base64.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + WebSocketProtocol.ACCEPT_MAGIC).getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private long getByteBufferListSize() {
        long j2;
        synchronized (this.byteBufferList) {
            j2 = 0;
            for (ByteBuffer byteBuffer : this.byteBufferList) {
                j2 += byteBuffer.limit();
            }
        }
        return j2;
    }

    private byte getMaskByte(boolean z) {
        if (z) {
            return n.a;
        }
        return (byte) 0;
    }

    private ByteBuffer getPayloadFromByteBufferList() throws LimitExceededException {
        ByteBuffer allocate;
        synchronized (this.byteBufferList) {
            long j2 = 0;
            for (ByteBuffer byteBuffer : this.byteBufferList) {
                j2 += byteBuffer.limit();
            }
            checkBufferLimit();
            allocate = ByteBuffer.allocate((int) j2);
            for (ByteBuffer byteBuffer2 : this.byteBufferList) {
                allocate.put(byteBuffer2);
            }
        }
        allocate.flip();
        return allocate;
    }

    private byte getRSVByte(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return (byte) 0;
                }
                return cb.n;
            }
            return (byte) 32;
        }
        return (byte) 64;
    }

    private String getServerTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private int getSizeBytes(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 125) {
            return 1;
        }
        return byteBuffer.remaining() <= 65535 ? 2 : 8;
    }

    private void logRuntimeException(WebSocketImpl webSocketImpl, RuntimeException runtimeException) {
        this.log.error("Runtime exception during onWebsocketMessage", runtimeException);
        webSocketImpl.getWebSocketListener().onWebsocketError(webSocketImpl, runtimeException);
    }

    private void processFrameBinary(WebSocketImpl webSocketImpl, Framedata framedata) {
        try {
            webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, framedata.getPayloadData());
        } catch (RuntimeException e2) {
            logRuntimeException(webSocketImpl, e2);
        }
    }

    private void processFrameClosing(WebSocketImpl webSocketImpl, Framedata framedata) {
        int i2;
        String str;
        if (framedata instanceof CloseFrame) {
            CloseFrame closeFrame = (CloseFrame) framedata;
            i2 = closeFrame.getCloseCode();
            str = closeFrame.getMessage();
        } else {
            i2 = 1005;
            str = "";
        }
        if (webSocketImpl.getReadyState() == ReadyState.CLOSING) {
            webSocketImpl.closeConnection(i2, str, true);
        } else if (getCloseHandshakeType() == CloseHandshakeType.TWOWAY) {
            webSocketImpl.close(i2, str, true);
        } else {
            webSocketImpl.flushAndClose(i2, str, false);
        }
    }

    @RequiresApi(api = 19)
    private void processFrameContinuousAndNonFin(WebSocketImpl webSocketImpl, Framedata framedata, Opcode opcode) throws InvalidDataException {
        Opcode opcode2 = Opcode.CONTINUOUS;
        if (opcode != opcode2) {
            processFrameIsNotFin(framedata);
        } else if (framedata.isFin()) {
            processFrameIsFin(webSocketImpl, framedata);
        } else if (this.currentContinuousFrame == null) {
            this.log.error("Protocol error: Continuous frame sequence was not started.");
            throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
        }
        if (opcode == Opcode.TEXT && !Charsetfunctions.isValidUTF8(framedata.getPayloadData())) {
            this.log.error("Protocol error: Payload is not UTF8");
            throw new InvalidDataException(1007);
        } else if (opcode != opcode2 || this.currentContinuousFrame == null) {
        } else {
            addToBufferList(framedata.getPayloadData());
        }
    }

    @RequiresApi(api = 19)
    private void processFrameIsFin(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException {
        if (this.currentContinuousFrame != null) {
            addToBufferList(framedata.getPayloadData());
            checkBufferLimit();
            if (this.currentContinuousFrame.getOpcode() == Opcode.TEXT) {
                ((FramedataImpl1) this.currentContinuousFrame).setPayload(getPayloadFromByteBufferList());
                ((FramedataImpl1) this.currentContinuousFrame).isValid();
                try {
                    webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, Charsetfunctions.stringUtf8(this.currentContinuousFrame.getPayloadData()));
                } catch (RuntimeException e2) {
                    logRuntimeException(webSocketImpl, e2);
                }
            } else if (this.currentContinuousFrame.getOpcode() == Opcode.BINARY) {
                ((FramedataImpl1) this.currentContinuousFrame).setPayload(getPayloadFromByteBufferList());
                ((FramedataImpl1) this.currentContinuousFrame).isValid();
                try {
                    webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, this.currentContinuousFrame.getPayloadData());
                } catch (RuntimeException e3) {
                    logRuntimeException(webSocketImpl, e3);
                }
            }
            this.currentContinuousFrame = null;
            clearBufferList();
            return;
        }
        this.log.trace("Protocol error: Previous continuous frame sequence not completed.");
        throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
    }

    private void processFrameIsNotFin(Framedata framedata) throws InvalidDataException {
        if (this.currentContinuousFrame == null) {
            this.currentContinuousFrame = framedata;
            addToBufferList(framedata.getPayloadData());
            checkBufferLimit();
            return;
        }
        this.log.trace("Protocol error: Previous continuous frame sequence not completed.");
        throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
    }

    @RequiresApi(api = 19)
    private void processFrameText(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException {
        try {
            webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, Charsetfunctions.stringUtf8(framedata.getPayloadData()));
        } catch (RuntimeException e2) {
            logRuntimeException(webSocketImpl, e2);
        }
    }

    private byte[] toByteArray(long j2, int i2) {
        byte[] bArr = new byte[i2];
        int i3 = (i2 * 8) - 8;
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) (j2 >>> (i3 - (i4 * 8)));
        }
        return bArr;
    }

    private Opcode toOpcode(byte b) throws InvalidFrameException {
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    switch (b) {
                        case 8:
                            return Opcode.CLOSING;
                        case 9:
                            return Opcode.PING;
                        case 10:
                            return Opcode.PONG;
                        default:
                            throw new InvalidFrameException("Unknown opcode " + ((int) b));
                    }
                }
                return Opcode.BINARY;
            }
            return Opcode.TEXT;
        }
        return Opcode.CONTINUOUS;
    }

    private Framedata translateSingleFrame(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i2 = 2;
            translateSingleFrameCheckPacketSize(remaining, 2);
            byte b = byteBuffer.get();
            boolean z = (b >> 8) != 0;
            boolean z2 = (b & 64) != 0;
            boolean z3 = (b & 32) != 0;
            boolean z4 = (b & cb.n) != 0;
            byte b2 = byteBuffer.get();
            boolean z5 = (b2 & n.a) != 0;
            int i3 = (byte) (b2 & n.b);
            Opcode opcode = toOpcode((byte) (b & cb.f7124m));
            if (i3 < 0 || i3 > 125) {
                TranslatedPayloadMetaData translateSingleFramePayloadLength = translateSingleFramePayloadLength(byteBuffer, opcode, i3, remaining, 2);
                i3 = translateSingleFramePayloadLength.getPayloadLength();
                i2 = translateSingleFramePayloadLength.getRealPackageSize();
            }
            translateSingleFrameCheckLengthLimit(i3);
            translateSingleFrameCheckPacketSize(remaining, i2 + (z5 ? 4 : 0) + i3);
            ByteBuffer allocate = ByteBuffer.allocate(checkAlloc(i3));
            if (z5) {
                byte[] bArr = new byte[4];
                byteBuffer.get(bArr);
                for (int i4 = 0; i4 < i3; i4++) {
                    allocate.put((byte) (byteBuffer.get() ^ bArr[i4 % 4]));
                }
            } else {
                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                byteBuffer.position(byteBuffer.position() + allocate.limit());
            }
            FramedataImpl1 framedataImpl1 = FramedataImpl1.get(opcode);
            framedataImpl1.setFin(z);
            framedataImpl1.setRSV1(z2);
            framedataImpl1.setRSV2(z3);
            framedataImpl1.setRSV3(z4);
            allocate.flip();
            framedataImpl1.setPayload(allocate);
            getExtension().isFrameValid(framedataImpl1);
            getExtension().decodeFrame(framedataImpl1);
            framedataImpl1.isValid();
            return framedataImpl1;
        }
        throw new IllegalArgumentException();
    }

    private void translateSingleFrameCheckLengthLimit(long j2) throws LimitExceededException {
        if (j2 <= 2147483647L) {
            int i2 = this.maxFrameSize;
            if (j2 > i2) {
                this.log.trace("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(i2), Long.valueOf(j2));
                throw new LimitExceededException("Payload limit reached.", this.maxFrameSize);
            } else if (j2 >= 0) {
                return;
            } else {
                this.log.trace("Limit underflow: Payloadsize is to little...");
                throw new LimitExceededException("Payloadsize is to little...");
            }
        }
        this.log.trace("Limit exedeed: Payloadsize is to big...");
        throw new LimitExceededException("Payloadsize is to big...");
    }

    private void translateSingleFrameCheckPacketSize(int i2, int i3) throws IncompleteException {
        if (i2 >= i3) {
            return;
        }
        this.log.trace("Incomplete frame: maxpacketsize < realpacketsize");
        throw new IncompleteException(i3);
    }

    private TranslatedPayloadMetaData translateSingleFramePayloadLength(ByteBuffer byteBuffer, Opcode opcode, int i2, int i3, int i4) throws InvalidFrameException, IncompleteException, LimitExceededException {
        int i5;
        int i6;
        if (opcode != Opcode.PING && opcode != Opcode.PONG && opcode != Opcode.CLOSING) {
            if (i2 == 126) {
                i5 = i4 + 2;
                translateSingleFrameCheckPacketSize(i3, i5);
                i6 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
            } else {
                i5 = i4 + 8;
                translateSingleFrameCheckPacketSize(i3, i5);
                byte[] bArr = new byte[8];
                for (int i7 = 0; i7 < 8; i7++) {
                    bArr[i7] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr).longValue();
                translateSingleFrameCheckLengthLimit(longValue);
                i6 = (int) longValue;
            }
            return new TranslatedPayloadMetaData(i6, i5);
        }
        this.log.trace("Invalid frame: more than 125 octets");
        throw new InvalidFrameException("more than 125 octets");
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.drafts.Draft
    public HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidHandshakeException {
        if (!basicAccept(serverHandshake)) {
            this.log.trace("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return HandshakeState.NOT_MATCHED;
        } else if (clientHandshake.hasFieldValue(SEC_WEB_SOCKET_KEY) && serverHandshake.hasFieldValue(SEC_WEB_SOCKET_ACCEPT)) {
            if (!generateFinalKey(clientHandshake.getFieldValue(SEC_WEB_SOCKET_KEY)).equals(serverHandshake.getFieldValue(SEC_WEB_SOCKET_ACCEPT))) {
                this.log.trace("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return HandshakeState.NOT_MATCHED;
            }
            HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
            String fieldValue = serverHandshake.getFieldValue(SEC_WEB_SOCKET_EXTENSIONS);
            Iterator<IExtension> it = this.knownExtensions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IExtension next = it.next();
                if (next.acceptProvidedExtensionAsClient(fieldValue)) {
                    this.extension = next;
                    handshakeState = HandshakeState.MATCHED;
                    this.log.trace("acceptHandshakeAsClient - Matching extension found: {}", next);
                    break;
                }
            }
            HandshakeState containsRequestedProtocol = containsRequestedProtocol(serverHandshake.getFieldValue(SEC_WEB_SOCKET_PROTOCOL));
            HandshakeState handshakeState2 = HandshakeState.MATCHED;
            if (containsRequestedProtocol == handshakeState2 && handshakeState == handshakeState2) {
                return handshakeState2;
            }
            this.log.trace("acceptHandshakeAsClient - No matching extension or protocol found.");
            return HandshakeState.NOT_MATCHED;
        } else {
            this.log.trace("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return HandshakeState.NOT_MATCHED;
        }
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.drafts.Draft
    public HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) throws InvalidHandshakeException {
        if (readVersion(clientHandshake) != 13) {
            this.log.trace("acceptHandshakeAsServer - Wrong websocket version.");
            return HandshakeState.NOT_MATCHED;
        }
        HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
        String fieldValue = clientHandshake.getFieldValue(SEC_WEB_SOCKET_EXTENSIONS);
        Iterator<IExtension> it = this.knownExtensions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IExtension next = it.next();
            if (next.acceptProvidedExtensionAsServer(fieldValue)) {
                this.extension = next;
                handshakeState = HandshakeState.MATCHED;
                this.log.trace("acceptHandshakeAsServer - Matching extension found: {}", next);
                break;
            }
        }
        HandshakeState containsRequestedProtocol = containsRequestedProtocol(clientHandshake.getFieldValue(SEC_WEB_SOCKET_PROTOCOL));
        HandshakeState handshakeState2 = HandshakeState.MATCHED;
        if (containsRequestedProtocol == handshakeState2 && handshakeState == handshakeState2) {
            return handshakeState2;
        }
        this.log.trace("acceptHandshakeAsServer - No matching extension or protocol found.");
        return HandshakeState.NOT_MATCHED;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.drafts.Draft
    public Draft copyInstance() {
        ArrayList arrayList = new ArrayList();
        for (IExtension iExtension : getKnownExtensions()) {
            arrayList.add(iExtension.copyInstance());
        }
        ArrayList arrayList2 = new ArrayList();
        for (IProtocol iProtocol : getKnownProtocols()) {
            arrayList2.add(iProtocol.copyInstance());
        }
        return new Draft_6455(arrayList, arrayList2, this.maxFrameSize);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.drafts.Draft
    public ByteBuffer createBinaryFrame(Framedata framedata) {
        getExtension().encodeFrame(framedata);
        return createByteBufferFromFramedata(framedata);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.drafts.Draft
    public List<Framedata> createFrames(ByteBuffer byteBuffer, boolean z) {
        BinaryFrame binaryFrame = new BinaryFrame();
        binaryFrame.setPayload(byteBuffer);
        binaryFrame.setTransferemasked(z);
        try {
            binaryFrame.isValid();
            return Collections.singletonList(binaryFrame);
        } catch (InvalidDataException e2) {
            throw new NotSendableException(e2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Draft_6455 draft_6455 = (Draft_6455) obj;
        if (this.maxFrameSize != draft_6455.getMaxFrameSize()) {
            return false;
        }
        IExtension iExtension = this.extension;
        if (iExtension == null ? draft_6455.getExtension() == null : iExtension.equals(draft_6455.getExtension())) {
            IProtocol iProtocol = this.protocol;
            IProtocol protocol = draft_6455.getProtocol();
            return iProtocol != null ? iProtocol.equals(protocol) : protocol == null;
        }
        return false;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.drafts.Draft
    public CloseHandshakeType getCloseHandshakeType() {
        return CloseHandshakeType.TWOWAY;
    }

    public IExtension getExtension() {
        return this.extension;
    }

    public List<IExtension> getKnownExtensions() {
        return this.knownExtensions;
    }

    public List<IProtocol> getKnownProtocols() {
        return this.knownProtocols;
    }

    public int getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public IProtocol getProtocol() {
        return this.protocol;
    }

    public int hashCode() {
        IExtension iExtension = this.extension;
        int hashCode = (iExtension != null ? iExtension.hashCode() : 0) * 31;
        IProtocol iProtocol = this.protocol;
        int hashCode2 = iProtocol != null ? iProtocol.hashCode() : 0;
        int i2 = this.maxFrameSize;
        return ((hashCode + hashCode2) * 31) + (i2 ^ (i2 >>> 32));
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.drafts.Draft
    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.put(UPGRADE, "websocket");
        clientHandshakeBuilder.put(CONNECTION, UPGRADE);
        byte[] bArr = new byte[16];
        this.reuseableRandom.nextBytes(bArr);
        clientHandshakeBuilder.put(SEC_WEB_SOCKET_KEY, Base64.encodeBytes(bArr));
        clientHandshakeBuilder.put("Sec-WebSocket-Version", "13");
        StringBuilder sb = new StringBuilder();
        for (IExtension iExtension : this.knownExtensions) {
            if (iExtension.getProvidedExtensionAsClient() != null && iExtension.getProvidedExtensionAsClient().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(iExtension.getProvidedExtensionAsClient());
            }
        }
        if (sb.length() != 0) {
            clientHandshakeBuilder.put(SEC_WEB_SOCKET_EXTENSIONS, sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (IProtocol iProtocol : this.knownProtocols) {
            if (iProtocol.getProvidedProtocol().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(iProtocol.getProvidedProtocol());
            }
        }
        if (sb2.length() != 0) {
            clientHandshakeBuilder.put(SEC_WEB_SOCKET_PROTOCOL, sb2.toString());
        }
        return clientHandshakeBuilder;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.drafts.Draft
    public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.put(UPGRADE, "websocket");
        serverHandshakeBuilder.put(CONNECTION, clientHandshake.getFieldValue(CONNECTION));
        String fieldValue = clientHandshake.getFieldValue(SEC_WEB_SOCKET_KEY);
        if (fieldValue != null && !"".equals(fieldValue)) {
            serverHandshakeBuilder.put(SEC_WEB_SOCKET_ACCEPT, generateFinalKey(fieldValue));
            if (getExtension().getProvidedExtensionAsServer().length() != 0) {
                serverHandshakeBuilder.put(SEC_WEB_SOCKET_EXTENSIONS, getExtension().getProvidedExtensionAsServer());
            }
            if (getProtocol() != null && getProtocol().getProvidedProtocol().length() != 0) {
                serverHandshakeBuilder.put(SEC_WEB_SOCKET_PROTOCOL, getProtocol().getProvidedProtocol());
            }
            serverHandshakeBuilder.setHttpStatusMessage("Web Socket Protocol Handshake");
            serverHandshakeBuilder.put("Server", "TooTallNate Java-WebSocket");
            serverHandshakeBuilder.put("Date", getServerTime());
            return serverHandshakeBuilder;
        }
        throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.drafts.Draft
    @RequiresApi(api = 19)
    public void processFrame(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException {
        Opcode opcode = framedata.getOpcode();
        if (opcode == Opcode.CLOSING) {
            processFrameClosing(webSocketImpl, framedata);
        } else if (opcode == Opcode.PING) {
            webSocketImpl.getWebSocketListener().onWebsocketPing(webSocketImpl, framedata);
        } else if (opcode == Opcode.PONG) {
            webSocketImpl.updateLastPong();
            webSocketImpl.getWebSocketListener().onWebsocketPong(webSocketImpl, framedata);
        } else if (framedata.isFin() && opcode != Opcode.CONTINUOUS) {
            if (this.currentContinuousFrame == null) {
                if (opcode == Opcode.TEXT) {
                    processFrameText(webSocketImpl, framedata);
                    return;
                } else if (opcode == Opcode.BINARY) {
                    processFrameBinary(webSocketImpl, framedata);
                    return;
                } else {
                    this.log.error("non control or continious frame expected");
                    throw new InvalidDataException(1002, "non control or continious frame expected");
                }
            }
            this.log.error("Protocol error: Continuous frame sequence not completed.");
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            processFrameContinuousAndNonFin(webSocketImpl, framedata, opcode);
        }
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.drafts.Draft
    public void reset() {
        this.incompleteframe = null;
        IExtension iExtension = this.extension;
        if (iExtension != null) {
            iExtension.reset();
        }
        this.extension = new DefaultExtension();
        this.protocol = null;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (getExtension() != null) {
            draft = draft + " extension: " + getExtension().toString();
        }
        if (getProtocol() != null) {
            draft = draft + " protocol: " + getProtocol().toString();
        }
        return draft + " max frame size: " + this.maxFrameSize;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.drafts.Draft
    public List<Framedata> translateFrame(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.incompleteframe == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.incompleteframe.remaining();
                if (remaining2 > remaining) {
                    this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(translateSingleFrame((ByteBuffer) this.incompleteframe.duplicate().position(0)));
                this.incompleteframe = null;
            } catch (IncompleteException e2) {
                ByteBuffer allocate = ByteBuffer.allocate(checkAlloc(e2.getPreferredSize()));
                this.incompleteframe.rewind();
                allocate.put(this.incompleteframe);
                this.incompleteframe = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(translateSingleFrame(byteBuffer));
            } catch (IncompleteException e3) {
                byteBuffer.reset();
                ByteBuffer allocate2 = ByteBuffer.allocate(checkAlloc(e3.getPreferredSize()));
                this.incompleteframe = allocate2;
                allocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public Draft_6455(IExtension iExtension) {
        this(Collections.singletonList(iExtension));
    }

    public Draft_6455(List<IExtension> list) {
        this(list, Collections.singletonList(new Protocol("")));
    }

    public Draft_6455(List<IExtension> list, List<IProtocol> list2) {
        this(list, list2, Integer.MAX_VALUE);
    }

    public Draft_6455(List<IExtension> list, int i2) {
        this(list, Collections.singletonList(new Protocol("")), i2);
    }

    public Draft_6455(List<IExtension> list, List<IProtocol> list2, int i2) {
        this.log = LoggerFactory.getLogger(Draft_6455.class);
        this.extension = new DefaultExtension();
        this.reuseableRandom = new Random();
        if (list != null && list2 != null && i2 >= 1) {
            this.knownExtensions = new ArrayList(list.size());
            this.knownProtocols = new ArrayList(list2.size());
            boolean z = false;
            this.byteBufferList = new ArrayList();
            for (IExtension iExtension : list) {
                if (iExtension.getClass().equals(DefaultExtension.class)) {
                    z = true;
                }
            }
            this.knownExtensions.addAll(list);
            if (!z) {
                List<IExtension> list3 = this.knownExtensions;
                list3.add(list3.size(), this.extension);
            }
            this.knownProtocols.addAll(list2);
            this.maxFrameSize = i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.drafts.Draft
    @RequiresApi(api = 19)
    public List<Framedata> createFrames(String str, boolean z) {
        TextFrame textFrame = new TextFrame();
        textFrame.setPayload(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(str)));
        textFrame.setTransferemasked(z);
        try {
            textFrame.isValid();
            return Collections.singletonList(textFrame);
        } catch (InvalidDataException e2) {
            throw new NotSendableException(e2);
        }
    }
}
