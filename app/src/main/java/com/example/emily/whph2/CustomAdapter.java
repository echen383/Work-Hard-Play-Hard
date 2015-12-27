package com.example.emily.whph2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Emily on 12/27/15.
 */

public class CustomAdapter extends BaseAdapter {

    Activity context;
    List<StudyBuddy> studyBuddies;

    public CustomAdapter(Activity context, List<StudyBuddy> studyBuddies) {
        this.context = context;
        this.studyBuddies = studyBuddies;

    }


    @Override
    public int getCount() {
        return studyBuddies.size();
    }

    @Override
    public Object getItem(int position) {
        return studyBuddies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView,
                        final ViewGroup parent){
        StudyBuddy sbTemp = studyBuddies.get(position);
        final View v = this.context.getLayoutInflater().inflate(R.layout.study_feed_list_item,null);
        ((TextView) v.findViewById(R.id.tvName)).setText(sbTemp.getName());
        ((TextView) v.findViewById(R.id.tvLocation)).setText(sbTemp.getLocation());
        ((TextView) v.findViewById(R.id.tvTime)).setText(sbTemp.getStartTime());
        ((TextView) v.findViewById(R.id.tvSubject)).setText(sbTemp.getSubject());

        return v;
    }
}

