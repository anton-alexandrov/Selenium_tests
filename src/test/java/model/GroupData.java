package model;

import java.util.Objects;

public class GroupData {
    private final String groupName;
    private final String groupHeader;
    private final String groupFooter;
    private  int groupID;

    public GroupData(String groupName, String groupHeader, String groupFooter, int groupID) {
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
        this.groupID = groupID;
    }

    public GroupData(String groupName, String groupHeader, String groupFooter) {
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
        this.groupID = 0;
    }
    public String getGroupName() {
        return groupName;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public int getGroupID() {
        return groupID;
    }

    public String getGroupFooter() {
        return groupFooter;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "groupName='" + groupName + '\'' +
                ", groupID='" + groupID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return groupID == groupData.groupID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupID);
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }
}
