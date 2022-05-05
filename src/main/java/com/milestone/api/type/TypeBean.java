package com.milestone.api.type;

public class TypeBean {
    private  int  typeId;
    private String typeName;
    public TypeBean(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public TypeBean() {
    }

    public TypeBean(int typeId) {
        this.typeId = typeId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
