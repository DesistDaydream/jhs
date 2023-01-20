package com.moor.imkf.lib.jobqueue.messaging;

import com.moor.imkf.lib.jobqueue.messaging.message.AddJobMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.CallbackMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.CancelMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.CancelResultMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.CommandMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.ConstraintChangeMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.JobConsumerIdleMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.PublicQueryMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.RunJobMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.RunJobResultMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.SchedulerMessage;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum Type {
    CALLBACK(CallbackMessage.class, 0),
    CANCEL_RESULT_CALLBACK(CancelResultMessage.class, 0),
    RUN_JOB(RunJobMessage.class, 0),
    COMMAND(CommandMessage.class, 0),
    PUBLIC_QUERY(PublicQueryMessage.class, 0),
    JOB_CONSUMER_IDLE(JobConsumerIdleMessage.class, 0),
    ADD_JOB(AddJobMessage.class, 1),
    CANCEL(CancelMessage.class, 1),
    CONSTRAINT_CHANGE(ConstraintChangeMessage.class, 2),
    RUN_JOB_RESULT(RunJobResultMessage.class, 3),
    SCHEDULER(SchedulerMessage.class, 4);
    
    public static final int MAX_PRIORITY;
    public static final Map<Class<? extends Message>, Type> mapping = new HashMap();
    public final Class<? extends Message> klass;
    public final int priority;

    static {
        Type[] values;
        int i2 = 0;
        for (Type type : values()) {
            mapping.put(type.klass, type);
            int i3 = type.priority;
            if (i3 > i2) {
                i2 = i3;
            }
        }
        MAX_PRIORITY = i2;
    }

    Type(Class cls, int i2) {
        this.klass = cls;
        this.priority = i2;
    }
}
