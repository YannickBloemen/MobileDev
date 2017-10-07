package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yannick on 2-10-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    int backgroundColorId;
    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundColorId) {
        super(context, 0, words);
        this.backgroundColorId = backgroundColorId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        miwokTextView.setText(currentWord.getmDefaultTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        defaultTextView.setText(currentWord.getmMiwokTranslation());
        if (currentWord.getmImageResourceId() != -1){
            ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
            iconView.setImageResource(currentWord.getmImageResourceId());
        }
        else{
            ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
            iconView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),backgroundColorId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
