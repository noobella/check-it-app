package com.example.checkit;

import java.util.Comparator;

public class CheckItemComparator implements Comparator<CheckItem> {
    @Override
    public int compare(CheckItem checkItemOne, CheckItem checkItemTwo) {
        return (checkItemOne.getmItemStatus().compareTo(checkItemTwo.getmItemStatus()));
    }
}
