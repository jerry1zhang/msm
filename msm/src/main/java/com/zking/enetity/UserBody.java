package com.zking.enetity;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;

public class UserBody {
    private User user;
    private Group group;
    private long num;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }
}
