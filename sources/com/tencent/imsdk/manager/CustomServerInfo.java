package com.tencent.imsdk.manager;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class CustomServerInfo {
    public List<ServerAddress> longconnectionAddressList = new ArrayList();
    public List<ServerAddress> shortconnectionAddressList = new ArrayList();
    public String serverPublicKey = "";

    /* loaded from: classes3.dex */
    public static class ServerAddress {
        public String ip = "";
        public int port = 0;
        public boolean isIPv6 = false;
    }
}
