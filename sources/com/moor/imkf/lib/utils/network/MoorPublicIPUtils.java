package com.moor.imkf.lib.utils.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class MoorPublicIPUtils {

    /* loaded from: classes2.dex */
    public static class GetPublicIPTask implements Callable<String> {
        public String host;

        public GetPublicIPTask(String str) {
            this.host = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            try {
                return InetAddress.getByName(this.host).getHostAddress();
            } catch (UnknownHostException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public static String getPublicIp(String str) {
        try {
            return (String) Executors.newCachedThreadPool().submit(new GetPublicIPTask(str)).get();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return null;
        } catch (ExecutionException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
