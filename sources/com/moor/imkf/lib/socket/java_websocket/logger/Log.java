package com.moor.imkf.lib.socket.java_websocket.logger;

/* loaded from: classes2.dex */
public interface Log {

    /* loaded from: classes2.dex */
    public enum Level {
        TRACE(1),
        DEBUG(2),
        INFO(3),
        WARNING(4),
        ERROR(5),
        FATAL(6);
        
        private int level;

        Level(int i2) {
            this.level = i2;
        }

        public boolean isEnabled(Level level) {
            return this.level <= level.level;
        }
    }

    boolean isLevelEnabled(Level level);

    void log(Level level, String str);

    void log(Level level, String str, Throwable th);
}
