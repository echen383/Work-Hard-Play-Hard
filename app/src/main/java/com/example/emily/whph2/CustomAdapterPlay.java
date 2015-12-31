package com.example.emily.whph2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Emily on 12/30/15.
 */

public class CustomAdapterPlay extends BaseAdapter {

    Activity context;
    List<PlayBuddy> playBuddies;

    public CustomAdapterPlay(Activity context, List<PlayBuddy> playBuddies) {
        this.context = context;
        this.playBuddies = playBuddies;
    }

    @Override
    public int getCount() {
        return playBuddies.size();
    }

    @Override
    public Object getItem(int position) {
        return playBuddies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView,
                        final ViewGroup parent){

        PlayBuddy pbTemp = playBuddies.get(position);
        final View v = this.context.getLayoutInflater().inflate(R.layout.play_feed_list_item,null);

        ((TextView) v.findViewById(R.id.tvName)).setText(pbTemp.getName());
        ((TextView) v.findViewById(R.id.tvLocation)).setText(pbTemp.getLocation());
        ((TextView) v.findViewById(R.id.tvTime)).setText(pbTemp.getStartTime());
        ((TextView) v.findViewById(R.id.tvActivity)).setText(pbTemp.getActivity());

        return v;
    }
}

