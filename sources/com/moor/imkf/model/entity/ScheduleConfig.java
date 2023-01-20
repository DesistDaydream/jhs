package com.moor.imkf.model.entity;

import java.util.List;

/* loaded from: classes2.dex */
public class ScheduleConfig {
    private EntranceNodeBean entranceNode;
    private List<LeavemsgNodesBean> leavemsgNodes;
    private String processId;
    private boolean scheduleEnable;
    private String scheduleId;

    /* loaded from: classes2.dex */
    public static class EntranceNodeBean {
        private String _id;
        private String accessType;
        private String account;
        private ButtonStyleBean buttonStyle;
        private String createTime;
        private String createUser;
        private List<EntrancesBean> entrances;
        private String name;
        private List<String> nextNodeIds;
        private List<String> processIds;
        private String processTo;
        private String processType;
        private String type;
        private String updateTime;
        private String updateUser;
        private boolean using;
        private boolean usingButtonStyle;

        /* loaded from: classes2.dex */
        public static class ButtonStyleBean {
            private String bottomMargin;
            private String icon;
            private int iconType;
            private String location;
            private String sideMargin;
            private String text;

            public String getBottomMargin() {
                return this.bottomMargin;
            }

            public String getIcon() {
                return this.icon;
            }

            public int getIconType() {
                return this.iconType;
            }

            public String getLocation() {
                return this.location;
            }

            public String getSideMargin() {
                return this.sideMargin;
            }

            public String getText() {
                return this.text;
            }

            public void setBottomMargin(String str) {
                this.bottomMargin = str;
            }

            public void setIcon(String str) {
                this.icon = str;
            }

            public void setIconType(int i2) {
                this.iconType = i2;
            }

            public void setLocation(String str) {
                this.location = str;
            }

            public void setSideMargin(String str) {
                this.sideMargin = str;
            }

            public void setText(String str) {
                this.text = str;
            }
        }

        /* loaded from: classes2.dex */
        public static class EntrancesBean {
            private String _id;
            private String name;
            private String processTo;
            private String processType;

            public String getName() {
                return this.name;
            }

            public String getProcessTo() {
                return this.processTo;
            }

            public String getProcessType() {
                return this.processType;
            }

            public String get_id() {
                return this._id;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setProcessTo(String str) {
                this.processTo = str;
            }

            public void setProcessType(String str) {
                this.processType = str;
            }

            public void set_id(String str) {
                this._id = str;
            }
        }

        public String getAccessType() {
            return this.accessType;
        }

        public String getAccount() {
            return this.account;
        }

        public ButtonStyleBean getButtonStyle() {
            return this.buttonStyle;
        }

        public String getCreateTime() {
            return this.createTime;
        }

        public String getCreateUser() {
            return this.createUser;
        }

        public List<EntrancesBean> getEntrances() {
            return this.entrances;
        }

        public String getName() {
            return this.name;
        }

        public List<String> getNextNodeIds() {
            return this.nextNodeIds;
        }

        public List<String> getProcessIds() {
            return this.processIds;
        }

        public String getProcessTo() {
            return this.processTo;
        }

        public String getProcessType() {
            return this.processType;
        }

        public String getType() {
            return this.type;
        }

        public String getUpdateTime() {
            return this.updateTime;
        }

        public String getUpdateUser() {
            return this.updateUser;
        }

        public String get_id() {
            return this._id;
        }

        public boolean isUsing() {
            return this.using;
        }

        public boolean isUsingButtonStyle() {
            return this.usingButtonStyle;
        }

        public void setAccessType(String str) {
            this.accessType = str;
        }

        public void setAccount(String str) {
            this.account = str;
        }

        public void setButtonStyle(ButtonStyleBean buttonStyleBean) {
            this.buttonStyle = buttonStyleBean;
        }

        public void setCreateTime(String str) {
            this.createTime = str;
        }

        public void setCreateUser(String str) {
            this.createUser = str;
        }

        public void setEntrances(List<EntrancesBean> list) {
            this.entrances = list;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setNextNodeIds(List<String> list) {
            this.nextNodeIds = list;
        }

        public void setProcessIds(List<String> list) {
            this.processIds = list;
        }

        public void setProcessTo(String str) {
            this.processTo = str;
        }

        public void setProcessType(String str) {
            this.processType = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setUpdateTime(String str) {
            this.updateTime = str;
        }

        public void setUpdateUser(String str) {
            this.updateUser = str;
        }

        public void setUsing(boolean z) {
            this.using = z;
        }

        public void setUsingButtonStyle(boolean z) {
            this.usingButtonStyle = z;
        }

        public void set_id(String str) {
            this._id = str;
        }
    }

    /* loaded from: classes2.dex */
    public static class LeavemsgNodesBean {
        private String _id;
        private String account;
        private String contentTip;
        private String createTime;
        private String createUser;
        private List<LeavemsgFieldsBean> leavemsgFields;
        private String name;
        private List<?> nextNodeIds;
        private List<String> processIds;
        private String title;
        private String type;
        private String updateTime;
        private String updateUser;
        private boolean using;

        /* loaded from: classes2.dex */
        public static class LeavemsgFieldsBean {
            private String _id;
            private boolean enable;
            private String name;
            private boolean required;

            public String getName() {
                return this.name;
            }

            public String get_id() {
                return this._id;
            }

            public boolean isEnable() {
                return this.enable;
            }

            public boolean isRequired() {
                return this.required;
            }

            public void setEnable(boolean z) {
                this.enable = z;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setRequired(boolean z) {
                this.required = z;
            }

            public void set_id(String str) {
                this._id = str;
            }
        }

        public String getAccount() {
            return this.account;
        }

        public String getContentTip() {
            return this.contentTip;
        }

        public String getCreateTime() {
            return this.createTime;
        }

        public String getCreateUser() {
            return this.createUser;
        }

        public List<LeavemsgFieldsBean> getLeavemsgFields() {
            return this.leavemsgFields;
        }

        public String getName() {
            return this.name;
        }

        public List<?> getNextNodeIds() {
            return this.nextNodeIds;
        }

        public List<String> getProcessIds() {
            return this.processIds;
        }

        public String getTitle() {
            return this.title;
        }

        public String getType() {
            return this.type;
        }

        public String getUpdateTime() {
            return this.updateTime;
        }

        public String getUpdateUser() {
            return this.updateUser;
        }

        public String get_id() {
            return this._id;
        }

        public boolean isUsing() {
            return this.using;
        }

        public void setAccount(String str) {
            this.account = str;
        }

        public void setContentTip(String str) {
            this.contentTip = str;
        }

        public void setCreateTime(String str) {
            this.createTime = str;
        }

        public void setCreateUser(String str) {
            this.createUser = str;
        }

        public void setLeavemsgFields(List<LeavemsgFieldsBean> list) {
            this.leavemsgFields = list;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setNextNodeIds(List<?> list) {
            this.nextNodeIds = list;
        }

        public void setProcessIds(List<String> list) {
            this.processIds = list;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setUpdateTime(String str) {
            this.updateTime = str;
        }

        public void setUpdateUser(String str) {
            this.updateUser = str;
        }

        public void setUsing(boolean z) {
            this.using = z;
        }

        public void set_id(String str) {
            this._id = str;
        }
    }

    public EntranceNodeBean getEntranceNode() {
        return this.entranceNode;
    }

    public List<LeavemsgNodesBean> getLeavemsgNodes() {
        return this.leavemsgNodes;
    }

    public String getProcessId() {
        return this.processId;
    }

    public String getScheduleId() {
        return this.scheduleId;
    }

    public boolean isScheduleEnable() {
        return this.scheduleEnable;
    }

    public void setEntranceNode(EntranceNodeBean entranceNodeBean) {
        this.entranceNode = entranceNodeBean;
    }

    public void setLeavemsgNodes(List<LeavemsgNodesBean> list) {
        this.leavemsgNodes = list;
    }

    public void setProcessId(String str) {
        this.processId = str;
    }

    public void setScheduleEnable(boolean z) {
        this.scheduleEnable = z;
    }

    public void setScheduleId(String str) {
        this.scheduleId = str;
    }
}
