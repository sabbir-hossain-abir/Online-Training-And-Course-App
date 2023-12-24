package com.example.onlinetrainingandcourse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

//public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.viewholder> {
public class HomeAdapter extends FirebaseRecyclerAdapter<HomeModel, HomeAdapter.viewholder> {

    public HomeAdapter(@NonNull FirebaseRecyclerOptions<HomeModel> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull HomeModel model) {

        holder.homeTitle.setText(model.getCoursename());
        holder.homeofferby.setText(model.getOfferby());
//        holder.homeratings.setText(model.getRating().toString());
        // Handle potential null rating
        if (model.getRating() != null) {
            holder.homeratings.setText(model.getRating().toString());
        } else {
            holder.homeratings.setText("N/A");
        }
        Glide.with(holder.homeImage.getContext()).load(model.getPicurl()).into(holder.homeImage);



    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_card_row, parent, false);
        return new viewholder(view);
    }


//    @NonNull
//    @Override
//    public HomeAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull HomeAdapter.viewholder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }

    public class viewholder extends RecyclerView.ViewHolder {

        ImageView homeImage;
        TextView homeTitle, homeofferby, homeratings;
         public viewholder(@NonNull View itemView) {
            super(itemView);
            homeImage = itemView.findViewById(R.id.homecardimage);
            homeTitle = itemView.findViewById(R.id.homecardcoursename);
            homeofferby = itemView.findViewById(R.id.homecardcourseoffer);
            homeratings = itemView.findViewById(R.id.homecardcourserating);
        }
    }
}
