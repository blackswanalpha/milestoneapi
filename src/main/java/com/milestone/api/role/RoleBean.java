package com.milestone.api.role;

public class RoleBean {
    private int roleId;

    public RoleBean() {
        super();
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    private String roleName;


    public RoleBean(int roleId, String roleName) {
        super();
        this.roleId = roleId;
        // TODO Auto-generated constructor stub
        this.roleName = roleName;
    }


}
