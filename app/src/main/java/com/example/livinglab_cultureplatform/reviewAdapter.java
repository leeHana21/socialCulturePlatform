package com.example.livinglab_cultureplatform;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class reviewAdapter extends RecyclerView.Adapter<reviewAdapter.ViewHolder> {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ChildEventListener mChild;
    ArrayList<review> items = new ArrayList<review>();
    reviewAdapter(ArrayList<review> list){
        items = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView reTitle;
        TextView rePlace;
        TextView rePNum;
        TextView reDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.reTitle = itemView.findViewById(R.id.reTitle);
            this.rePlace = itemView.findViewById(R.id.rePlace);
            this.rePNum = itemView.findViewById(R.id.rePNum);
            this.reDate = itemView.findViewById(R.id.reDate);
        }

//        public void setItem(gathering item) {
//            title.setText(item.getTitle());
//            place.setText(item.getPlace());
//            price.setText(item.getPrice());
//            date.setText(item.getDate());
//            pNum.setText(item.getpNum());
//        }
    }

    public reviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.review_listviewitem, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final reviewAdapter.ViewHolder holder, int position) {

        review re = items.get(position);
        holder.rePlace.setText(re.getRePlace());
        holder.reTitle.setText(re.getReTitle());
        holder.rePNum.setText(re.getRePNum());
        holder.reDate.setText(re.getReDate());

    }
    @Override
    public int getItemCount () {
        return items.size();
    }
}

