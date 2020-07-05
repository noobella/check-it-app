package com.example.checkit;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CheckListArrayAdapter extends ArrayAdapter {

    public CheckListArrayAdapter(@NonNull Context context, @NonNull List<CheckItem> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.check_list_item, parent, false);
        }

        CheckItem currentCheckItem = (CheckItem) getItem(position);
        ImageView checkBox = convertView.findViewById(R.id.checkbox_check_list_item);
        TextView checkItemText = convertView.findViewById(R.id.textview_check_list_item);

        checkItemText.setText(currentCheckItem.getmCheckListString());

        int checkItemImageResourceId = currentCheckItem.getmItemStatus().getIconResourceId();
        checkBox.setImageResource(checkItemImageResourceId);

        return convertView;

    }
}
