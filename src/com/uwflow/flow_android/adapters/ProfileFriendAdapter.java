package com.uwflow.flow_android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.uwflow.flow_android.R;
import com.uwflow.flow_android.db_object.User;

import java.util.List;

public class ProfileFriendAdapter extends BaseAdapter {
    private List<User> mFriends;
    private Context mContext;

    public ProfileFriendAdapter(List<User> friends, Context context) {
        mFriends = friends;
        mContext = context;
    }

    public int getCount() {
        return mFriends.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // verify that convertView is not null
        if (convertView == null) {
            // inflate a new view
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.profile_friends_row_item, parent, false);
        }

        // Fill view with appropriate data
        TextView first, second;
        ImageView image;

        first = (TextView) convertView.findViewById(R.id.first);
        second = (TextView) convertView.findViewById(R.id.second);

        image = (ImageView) convertView.findViewById(R.id.image);

        first.setText(mFriends.get(position).getName());
        second.setText(mFriends.get(position).getProgramName());

        Picasso.with(mContext).load(mFriends.get(position).getProfilePicUrls().getSquare()).placeholder(R.drawable.photo_profile_empty).into(image);

        return convertView;
    }

    public Object getItem(int arg0) {
        return mFriends.get(arg0);
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
}

