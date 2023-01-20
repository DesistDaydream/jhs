package com.moor.imkf.lib.socket.java_websocket.protocols;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class Protocol implements IProtocol {
    private final String providedProtocol;
    private static final Pattern patternSpace = Pattern.compile(ExpandableTextView.N);
    private static final Pattern patternComma = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

    public Protocol(String str) {
        if (str != null) {
            this.providedProtocol = str;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.protocols.IProtocol
    public boolean acceptProvidedProtocol(String str) {
        if ("".equals(this.providedProtocol)) {
            return true;
        }
        for (String str2 : patternComma.split(patternSpace.matcher(str).replaceAll(""))) {
            if (this.providedProtocol.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.protocols.IProtocol
    public IProtocol copyInstance() {
        return new Protocol(getProvidedProtocol());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.providedProtocol.equals(((Protocol) obj).providedProtocol);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.protocols.IProtocol
    public String getProvidedProtocol() {
        return this.providedProtocol;
    }

    public int hashCode() {
        return this.providedProtocol.hashCode();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.protocols.IProtocol
    public String toString() {
        return getProvidedProtocol();
    }
}
