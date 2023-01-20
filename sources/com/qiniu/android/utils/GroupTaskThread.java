package com.qiniu.android.utils;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GroupTaskThread extends Thread {
    public final GroupTaskCompleteHandler completeHandler;
    private ArrayList<GroupTask> tasks = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface GroupTaskCompleteHandler {
        void complete();
    }

    public GroupTaskThread(GroupTaskCompleteHandler groupTaskCompleteHandler) {
        this.completeHandler = groupTaskCompleteHandler;
    }

    private void completeAction() {
        GroupTaskCompleteHandler groupTaskCompleteHandler = this.completeHandler;
        if (groupTaskCompleteHandler != null) {
            groupTaskCompleteHandler.complete();
        }
    }

    private GroupTask getNextWaitingTask() {
        for (int i2 = 0; i2 < this.tasks.size(); i2++) {
            GroupTask groupTask = this.tasks.get(i2);
            if (groupTask.state == GroupTask.State.Waiting) {
                return groupTask;
            }
        }
        return null;
    }

    private boolean isAllTasksCompleted() {
        if (this.tasks.size() == 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.tasks.size(); i2++) {
            if (this.tasks.get(i2).state != GroupTask.State.Complete) {
                return false;
            }
        }
        return true;
    }

    public void addTask(GroupTask groupTask) {
        synchronized (this) {
            if (!isAllTasksCompleted()) {
                this.tasks.add(groupTask);
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean isAllTasksCompleted;
        super.run();
        while (!isInterrupted()) {
            synchronized (this) {
                isAllTasksCompleted = isAllTasksCompleted();
            }
            if (isAllTasksCompleted) {
                completeAction();
                return;
            }
            GroupTask nextWaitingTask = getNextWaitingTask();
            if (nextWaitingTask != null) {
                nextWaitingTask.state = GroupTask.State.Running;
                nextWaitingTask.run(nextWaitingTask);
            } else {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class GroupTask {
        public final String id;
        public State state;

        /* loaded from: classes3.dex */
        public enum State {
            Waiting,
            Running,
            Complete
        }

        public GroupTask() {
            this.state = State.Waiting;
            this.id = null;
        }

        public abstract void run(GroupTask groupTask);

        public void taskComplete() {
            this.state = State.Complete;
        }

        public GroupTask(String str) {
            this.state = State.Waiting;
            this.id = str;
        }
    }
}
