package com.example.checkit;

public class CheckItem {

    private ItemStatus mItemStatus;
    private String mCheckListString;

    public CheckItem(ItemStatus itemStatus, String itemString){
        this.mItemStatus = itemStatus;
        this.mCheckListString = itemString;
    }

    public ItemStatus getmItemStatus() {
        return mItemStatus;
    }

    public void setmItemStatus(ItemStatus mItemStatus) {
        this.mItemStatus = mItemStatus;
    }

    public String getmCheckListString() {
        return mCheckListString;
    }

    public void setmCheckListString(String mCheckListString) {
        this.mCheckListString = mCheckListString;
    }
}
