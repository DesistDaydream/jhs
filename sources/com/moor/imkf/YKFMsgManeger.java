package com.moor.imkf;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes2.dex */
public class YKFMsgManeger {
    private static YKFMsgManeger instance;
    private final SharedPreferences.Editor editorData;
    private Context mContext;
    private final SharedPreferences xiaomoorRobot_sp;

    public YKFMsgManeger(Context context) {
        this.mContext = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(YKFConstants.MOOR_SP, 0);
        this.xiaomoorRobot_sp = sharedPreferences;
        this.editorData = sharedPreferences.edit();
    }

    public static YKFMsgManeger getInstance(Context context) {
        if (instance == null) {
            synchronized (YKFMsgManeger.class) {
                if (instance == null) {
                    instance = new YKFMsgManeger(context);
                }
            }
        }
        return instance;
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0595 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void msgDispense(android.content.Context r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 1440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moor.imkf.YKFMsgManeger.msgDispense(android.content.Context, java.lang.String):void");
    }
}
