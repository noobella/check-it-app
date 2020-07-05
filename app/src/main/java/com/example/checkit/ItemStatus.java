package com.example.checkit;

public enum ItemStatus {

    IMPORTANT("Important", R.drawable.important), NOT_STARTED("Not Started", R.drawable.notstarted), STARTED("Started", R.drawable.started), COMPLETED("Completed", R.drawable.completed), MIGRATED("Migrated", R.drawable.migrated), DELETED("Deleted", R.drawable.deleted);

    private String mValue;
    private int mIconResourceId;
    private ItemStatus(String value, int imageResourceId){
        this.mValue = value;
        this.mIconResourceId = imageResourceId;
    }

    public String getValue(){
        return mValue;
    }
    public int getIconResourceId(){
        return mIconResourceId;
    }

}
