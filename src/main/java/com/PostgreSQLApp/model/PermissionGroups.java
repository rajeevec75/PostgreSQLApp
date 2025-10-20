package com.PostgreSQLApp.model;

import java.util.List;

public class PermissionGroups {

    private String PermissionGroupsId;
    private String PermissionGroupsName;
    private List<Permission> permissions;

    public PermissionGroups() {
        super();
    }

    public PermissionGroups(String PermissionGroupsId, String PermissionGroupsName) {
        this.PermissionGroupsId = PermissionGroupsId;
        this.PermissionGroupsName = PermissionGroupsName;
    }

    public String getPermissionGroupsId() {
        return PermissionGroupsId;
    }

    public void setPermissionGroupsId(String PermissionGroupsId) {
        this.PermissionGroupsId = PermissionGroupsId;
    }

    public String getPermissionGroupsName() {
        return PermissionGroupsName;
    }

    public void setPermissionGroupsName(String PermissionGroupsName) {
        this.PermissionGroupsName = PermissionGroupsName;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

}
