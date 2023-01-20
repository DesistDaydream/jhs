package com.tencent.android.tpns.mqtt.internal.websocket;

import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class WebSocketHandshake {
    private static final String ACCEPT_SALT = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    private static final String EMPTY = "";
    private static final String HTTP_HEADER_CONNECTION = "connection";
    private static final String HTTP_HEADER_CONNECTION_VALUE = "upgrade";
    private static final String HTTP_HEADER_SEC_WEBSOCKET_ACCEPT = "sec-websocket-accept";
    private static final String HTTP_HEADER_SEC_WEBSOCKET_PROTOCOL = "sec-websocket-protocol";
    private static final String HTTP_HEADER_UPGRADE = "upgrade";
    private static final String HTTP_HEADER_UPGRADE_WEBSOCKET = "websocket";
    private static final String LINE_SEPARATOR = "\r\n";
    private static final String SHA1_PROTOCOL = "SHA1";
    public String host;
    public InputStream input;
    public OutputStream output;
    public int port;
    public String uri;

    public WebSocketHandshake(InputStream inputStream, OutputStream outputStream, String str, String str2, int i2) {
        this.input = inputStream;
        this.output = outputStream;
        this.uri = str;
        this.host = str2;
        this.port = i2;
    }

    private Map getHeaders(ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        for (int i2 = 1; i2 < arrayList.size(); i2++) {
            String[] split = ((String) arrayList.get(i2)).split(Constants.COLON_SEPARATOR);
            hashMap.put(split[0].toLowerCase(), split[1]);
        }
        return hashMap;
    }

    private void receiveHandshakeResponse(String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.input, "UTF-8"));
        ArrayList arrayList = new ArrayList();
        String readLine = bufferedReader.readLine();
        if (readLine != null) {
            while (readLine != null && !readLine.equals("")) {
                arrayList.add(readLine);
                readLine = bufferedReader.readLine();
            }
            Map headers = getHeaders(arrayList);
            String str2 = (String) headers.get(HTTP_HEADER_CONNECTION);
            if (str2 != null && !str2.equalsIgnoreCase("upgrade")) {
                String str3 = (String) headers.get("upgrade");
                if (str3 != null && str3.toLowerCase().contains(HTTP_HEADER_UPGRADE_WEBSOCKET)) {
                    if (((String) headers.get(HTTP_HEADER_SEC_WEBSOCKET_PROTOCOL)) != null) {
                        if (headers.containsKey(HTTP_HEADER_SEC_WEBSOCKET_ACCEPT)) {
                            try {
                                verifyWebSocketKey(str, (String) headers.get(HTTP_HEADER_SEC_WEBSOCKET_ACCEPT));
                                return;
                            } catch (HandshakeFailedException unused) {
                                throw new IOException("WebSocket Response header: Incorrect Sec-WebSocket-Key");
                            } catch (NoSuchAlgorithmException e2) {
                                throw new IOException(e2.getMessage());
                            }
                        }
                        throw new IOException("WebSocket Response header: Missing Sec-WebSocket-Accept");
                    }
                    throw new IOException("WebSocket Response header: empty sec-websocket-protocol");
                }
                throw new IOException("WebSocket Response header: Incorrect upgrade.");
            }
            throw new IOException("WebSocket Response header: Incorrect connection header");
        }
        throw new IOException("WebSocket Response header: Invalid response from Server, It may not support WebSockets.");
    }

    private void sendHandshakeRequest(String str) throws IOException {
        String userInfo;
        try {
            String str2 = "/mqtt";
            URI uri = new URI(this.uri);
            if (uri.getRawPath() != null && !uri.getRawPath().isEmpty()) {
                str2 = uri.getRawPath();
                if (uri.getRawQuery() != null && !uri.getRawQuery().isEmpty()) {
                    str2 = str2 + "?" + uri.getRawQuery();
                }
            }
            PrintWriter printWriter = new PrintWriter(this.output);
            printWriter.print("GET " + str2 + " HTTP/1.1" + LINE_SEPARATOR);
            int i2 = this.port;
            if (i2 != 80 && i2 != 443) {
                printWriter.print("Host: " + this.host + Constants.COLON_SEPARATOR + this.port + LINE_SEPARATOR);
            } else {
                printWriter.print("Host: " + this.host + LINE_SEPARATOR);
            }
            printWriter.print("Upgrade: websocket\r\n");
            printWriter.print("Connection: Upgrade\r\n");
            printWriter.print("Sec-WebSocket-Key: " + str + LINE_SEPARATOR);
            printWriter.print("Sec-WebSocket-Protocol: mqtt\r\n");
            printWriter.print("Sec-WebSocket-Version: 13\r\n");
            if (uri.getUserInfo() != null) {
                printWriter.print("Authorization: Basic " + Base64.encode(userInfo) + LINE_SEPARATOR);
            }
            printWriter.print(LINE_SEPARATOR);
            printWriter.flush();
        } catch (URISyntaxException e2) {
            throw new IllegalStateException(e2.getMessage());
        }
    }

    private byte[] sha1(String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(SHA1_PROTOCOL).digest(str.getBytes());
    }

    private void verifyWebSocketKey(String str, String str2) throws NoSuchAlgorithmException, HandshakeFailedException {
        if (!Base64.encodeBytes(sha1(str + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11")).trim().equals(str2.trim())) {
            throw new HandshakeFailedException();
        }
    }

    public void execute() throws IOException {
        byte[] bArr = new byte[16];
        System.arraycopy("".getBytes(), 0, bArr, 0, 16);
        String encodeBytes = Base64.encodeBytes(bArr);
        sendHandshakeRequest(encodeBytes);
        receiveHandshakeResponse(encodeBytes);
    }
}
