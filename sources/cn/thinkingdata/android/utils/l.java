package cn.thinkingdata.android.utils;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum l {
    TRACK("track"),
    TRACK_UPDATE("track_update"),
    TRACK_OVERWRITE("track_overwrite"),
    USER_ADD("user_add"),
    USER_SET("user_set"),
    USER_SET_ONCE("user_setOnce"),
    USER_UNSET("user_unset"),
    USER_APPEND("user_append"),
    USER_DEL("user_del"),
    USER_UNIQ_APPEND("user_uniq_append");
    

    /* renamed from: l  reason: collision with root package name */
    private static final Map<String, l> f1376l = new HashMap();
    private final String a;

    static {
        l[] values;
        for (l lVar : values()) {
            f1376l.put(lVar.a(), lVar);
        }
    }

    l(String str) {
        this.a = str;
    }

    public static l a(String str) {
        return f1376l.get(str);
    }

    public String a() {
        return this.a;
    }

    public boolean b() {
        return this == TRACK || this == TRACK_OVERWRITE || this == TRACK_UPDATE;
    }
}
