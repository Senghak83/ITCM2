package edu.itc.itcm2.retrofit_recyler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.itc.itcm2.R;

public class PostHorlder extends RecyclerView.ViewHolder {

    private TextView userId,id,title,descr;

    public PostHorlder(@NonNull View itemView) {

        super(itemView);

        userId = itemView.findViewById(R.id.list_post_userid);
        id = itemView.findViewById(R.id.list_post_id);
        title = itemView.findViewById(R.id.list_post_title);
        descr = itemView.findViewById(R.id.list_post_descr);
    }

    public TextView getUserid() {
        return userId;
    }

    public TextView getId() {
        return id;
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getDescr() {
        return descr;
    }
}
