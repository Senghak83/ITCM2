package edu.itc.itcm2.retrofit_recyler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.itc.itcm2.R;
import edu.itc.itcm2.Retrofit_1.PostModel;

public class PostAdapter extends RecyclerView.Adapter<PostHorlder> {
  private List<PostModelRecy> ls ;

  public PostAdapter(){
      ls = new ArrayList<>();
      ls.add(new PostModelRecy());

  }
  public PostAdapter(List<PostModelRecy>ls){this.ls = ls;}

    @NonNull
    @Override
    public PostHorlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_post_adapter,parent,false);
        return new PostHorlder(v);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PostHorlder h, int position) {

      if(ls.size()==0)return ;
      PostModelRecy p = ls.get(position);
      h.getUserid().setText(" User ID : "+  p.getUserId());
      h.getId().setText("ID  : "+p.getId());
      h.getTitle().setText("Title : "+p.getTitle());
      h.getDescr().setText("Descr : "+p.getMessage());




    }

    @Override
    public int getItemCount() {

      //return 10;
      return ls.isEmpty()?0: ls.size();
    }
}
