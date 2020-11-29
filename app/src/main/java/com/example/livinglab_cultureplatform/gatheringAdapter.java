package com.example.livinglab_cultureplatform;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class gatheringAdapter extends RecyclerView.Adapter<gatheringAdapter.ViewHolder> {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ChildEventListener mChild;
    ArrayList<gathering> items = new ArrayList<gathering>();
    gatheringAdapter(ArrayList<gathering> list){
        items = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView price;
        TextView place;
        TextView pNum;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title);
            this.price = itemView.findViewById(R.id.price);
            this.place = itemView.findViewById(R.id.place);
            this.pNum = itemView.findViewById(R.id.pNum);
            this.date = itemView.findViewById(R.id.date);
        }

//        public void setItem(gathering item) {
//            title.setText(item.getTitle());
//            place.setText(item.getPlace());
//            price.setText(item.getPrice());
//            date.setText(item.getDate());
//            pNum.setText(item.getpNum());
//        }
    }

    public gatheringAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.gathering_listviewitem, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

            gathering gat = items.get(position);
            holder.place.setText(gat.getPlace());
            holder.title.setText(gat.getTitle());
            holder.pNum.setText(gat.getpNum());
            holder.price.setText(gat.getPrice());
            holder.date.setText(gat.getDate());

    }
        @Override
        public int getItemCount () {
            return items.size();
        }
    }