package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.UnknownHostException;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class ek {

    /* loaded from: classes3.dex */
    public static class a {
        public ed a;
        public String b;
    }

    public static a a(Exception exc) {
        e(exc);
        boolean z = exc instanceof fn;
        Exception exc2 = exc;
        if (z) {
            fn fnVar = (fn) exc;
            exc2 = exc;
            if (fnVar.a() != null) {
                exc2 = fnVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        int a2 = fd.a(exc2);
        if (a2 != 0) {
            aVar.a = ed.a(ed.GSLB_REQUEST_SUCCESS.a() + a2);
        }
        if (aVar.a == null) {
            aVar.a = ed.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.a == ed.GSLB_TCP_ERR_OTHER) {
            aVar.b = str;
        }
        return aVar;
    }

    public static a b(Exception exc) {
        ed edVar;
        ed edVar2;
        Throwable cause;
        e(exc);
        boolean z = exc instanceof fn;
        Exception exc2 = exc;
        if (z) {
            fn fnVar = (fn) exc;
            exc2 = exc;
            if (fnVar.a() != null) {
                exc2 = fnVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fd.a(exc2);
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (a2 != 0) {
            ed a3 = ed.a(ed.CONN_SUCCESS.a() + a2);
            aVar.a = a3;
            if (a3 == ed.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                edVar = ed.CONN_BOSH_UNKNOWNHOST;
            }
            edVar2 = aVar.a;
            if (edVar2 != ed.CONN_TCP_ERR_OTHER || edVar2 == ed.CONN_XMPP_ERR || edVar2 == ed.CONN_BOSH_ERR) {
                aVar.b = str;
            }
            return aVar;
        }
        edVar = ed.CONN_XMPP_ERR;
        aVar.a = edVar;
        edVar2 = aVar.a;
        if (edVar2 != ed.CONN_TCP_ERR_OTHER) {
        }
        aVar.b = str;
        return aVar;
    }

    public static a c(Exception exc) {
        ed edVar;
        ed edVar2;
        e(exc);
        boolean z = exc instanceof fn;
        Exception exc2 = exc;
        if (z) {
            fn fnVar = (fn) exc;
            exc2 = exc;
            if (fnVar.a() != null) {
                exc2 = fnVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fd.a(exc2);
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (a2 == 105) {
            edVar = ed.BIND_TCP_READ_TIMEOUT;
        } else if (a2 == 199) {
            edVar = ed.BIND_TCP_ERR;
        } else if (a2 == 499) {
            aVar.a = ed.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                edVar = ed.BIND_BOSH_ITEM_NOT_FOUND;
            }
            edVar2 = aVar.a;
            if (edVar2 != ed.BIND_TCP_ERR || edVar2 == ed.BIND_XMPP_ERR || edVar2 == ed.BIND_BOSH_ERR) {
                aVar.b = str;
            }
            return aVar;
        } else {
            edVar = a2 != 109 ? a2 != 110 ? ed.BIND_XMPP_ERR : ed.BIND_TCP_BROKEN_PIPE : ed.BIND_TCP_CONNRESET;
        }
        aVar.a = edVar;
        edVar2 = aVar.a;
        if (edVar2 != ed.BIND_TCP_ERR) {
        }
        aVar.b = str;
        return aVar;
    }

    public static a d(Exception exc) {
        ed edVar;
        ed edVar2;
        e(exc);
        boolean z = exc instanceof fn;
        Exception exc2 = exc;
        if (z) {
            fn fnVar = (fn) exc;
            exc2 = exc;
            if (fnVar.a() != null) {
                exc2 = fnVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        int a2 = fd.a(exc2);
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (a2 == 105) {
            edVar = ed.CHANNEL_TCP_READTIMEOUT;
        } else if (a2 == 199) {
            edVar = ed.CHANNEL_TCP_ERR;
        } else if (a2 == 499) {
            aVar.a = ed.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                edVar = ed.CHANNEL_BOSH_ITEMNOTFIND;
            }
            edVar2 = aVar.a;
            if (edVar2 != ed.CHANNEL_TCP_ERR || edVar2 == ed.CHANNEL_XMPPEXCEPTION || edVar2 == ed.CHANNEL_BOSH_EXCEPTION) {
                aVar.b = str;
            }
            return aVar;
        } else {
            edVar = a2 != 109 ? a2 != 110 ? ed.CHANNEL_XMPPEXCEPTION : ed.CHANNEL_TCP_BROKEN_PIPE : ed.CHANNEL_TCP_CONNRESET;
        }
        aVar.a = edVar;
        edVar2 = aVar.a;
        if (edVar2 != ed.CHANNEL_TCP_ERR) {
        }
        aVar.b = str;
        return aVar;
    }

    private static void e(Exception exc) {
        Objects.requireNonNull(exc);
    }
}
