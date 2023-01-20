package okhttp3.internal.ws;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import j.m;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001a\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00148\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0016\u0010\u001b\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0016\u0010\u001c\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0016\u0010\u001d\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013R\u0016\u0010\u001f\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0013R\u0016\u0010 \u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b \u0010\u0013R\u0016\u0010!\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b!\u0010\u0013R\u0016\u0010\"\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\"\u0010\u0013R\u0016\u0010#\u001a\u00020\u00148\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b#\u0010\u0016R\u0016\u0010$\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b$\u0010\u0013R\u0016\u0010%\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b%\u0010\u0013R\u0016\u0010&\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b&\u0010\u0013R\u0016\u0010'\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b'\u0010\u0013R\u0016\u0010(\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b(\u0010\u0013R\u0016\u0010)\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b+\u0010\u0013¨\u0006."}, d2 = {"Lokhttp3/internal/ws/WebSocketProtocol;", "", "Lj/m$a;", "cursor", "", "key", "Lh/t1;", "toggleMask", "(Lj/m$a;[B)V", "", "code", "", "closeCodeExceptionMessage", "(I)Ljava/lang/String;", "validateCloseCode", "(I)V", "acceptHeader", "(Ljava/lang/String;)Ljava/lang/String;", "CLOSE_CLIENT_GOING_AWAY", ExpandableTextView.P, "", "PAYLOAD_BYTE_MAX", "J", "CLOSE_NO_STATUS_CODE", "PAYLOAD_SHORT_MAX", "OPCODE_CONTINUATION", "PAYLOAD_SHORT", "PAYLOAD_LONG", "OPCODE_BINARY", "B0_FLAG_RSV2", "OPCODE_CONTROL_PING", "OPCODE_TEXT", "B1_FLAG_MASK", "B0_FLAG_RSV1", "B0_FLAG_RSV3", "CLOSE_MESSAGE_MAX", "OPCODE_CONTROL_PONG", "OPCODE_CONTROL_CLOSE", "B0_FLAG_FIN", "B0_MASK_OPCODE", "OPCODE_FLAG_CONTROL", "ACCEPT_MAGIC", "Ljava/lang/String;", "B1_MASK_LENGTH", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class WebSocketProtocol {
    @d
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    @d
    public final String acceptHeader(@d String str) {
        ByteString.a aVar = ByteString.Companion;
        return aVar.l(str + ACCEPT_MAGIC).sha1().base64();
    }

    @e
    public final String closeCodeExceptionMessage(int i2) {
        if (i2 < 1000 || i2 >= 5000) {
            return "Code must be in range [1000,5000): " + i2;
        } else if ((1004 > i2 || 1006 < i2) && (1015 > i2 || 2999 < i2)) {
            return null;
        } else {
            return "Code " + i2 + " is reserved and may not be used.";
        }
    }

    public final void toggleMask(@d m.a aVar, @d byte[] bArr) {
        int length = bArr.length;
        int i2 = 0;
        do {
            byte[] bArr2 = aVar.f15992e;
            int i3 = aVar.f15993f;
            int i4 = aVar.f15994g;
            if (bArr2 != null) {
                while (i3 < i4) {
                    int i5 = i2 % length;
                    bArr2[i3] = (byte) (bArr2[i3] ^ bArr[i5]);
                    i3++;
                    i2 = i5 + 1;
                }
            }
        } while (aVar.j() != -1);
    }

    public final void validateCloseCode(int i2) {
        String closeCodeExceptionMessage = closeCodeExceptionMessage(i2);
        if (!(closeCodeExceptionMessage == null)) {
            throw new IllegalArgumentException(closeCodeExceptionMessage.toString());
        }
    }
}
