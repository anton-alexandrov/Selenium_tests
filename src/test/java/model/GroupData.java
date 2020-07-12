package model;

import java.util.Objects;

public class GroupData {
    private  String groupName;
    private  String groupHeader;
    private  String groupFooter;
    private  int groupID = Integer.MAX_VALUE;

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


    public GroupData withName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupData withHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }

    public GroupData withFooter(String groupFooter) {
        this.groupFooter = groupFooter;
        return this;
    }

    public GroupData withID(int groupID) {
        this.groupID = groupID;
        return this;
    }
}
