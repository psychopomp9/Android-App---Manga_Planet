package com.example.bhargavdesai_project1;

import android.content.Context;
import android.content.Intent;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

// adapter, use firebase

public class MangaAdapter extends FirebaseRecyclerAdapter<Manga, MangaAdapter.MangaHolder> {
    public MangaAdapter(FirebaseRecyclerOptions<Manga> options) { super(options); }

    @Override
    public MangaAdapter.MangaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MangaHolder(layoutInflater, parent);
    }

    @Override
    protected void onBindViewHolder(MangaAdapter.MangaHolder holder, int position, Manga model) {
        StorageReference storRef = FirebaseStorage.getInstance().getReferenceFromUrl(model.getPicture());
        // fetch picture from firebase using url link

        //set title
        holder.txtTitle.setText(model.getTitle());

        //display picture into imgPicture widget of design
        Glide.with(holder.imgPicture.getContext()).load(storRef).into(holder.imgPicture);
    }

    class MangaHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPicture;
        TextView txtTitle;

        @Override
        public void onClick(View v) {
            Manga m = getItem(getAdapterPosition()); // when an item is clicked in recycler view, it gets which item is clicked
            Context c = v.getContext();

            Intent i = new Intent(c, MangaDetails.class); // create intent to go to next activity (here Details activity)

            // pass details of clicked item to new activity
            i.putExtra("photo", m.getPicture());
            i.putExtra("title", m.getTitle());
            i.putExtra("author", m.getAuthor());
            i.putExtra("description", m.getDescription());
            i.putExtra("price", m.getPrice());
            i.putExtra("publication_year", m.getPublication_year());

            // start new activity
            c.startActivity(i);
        }

        public MangaHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.row_layout, parent, false));

            txtTitle = itemView.findViewById(R.id.txtTitle);
            imgPicture = itemView.findViewById(R.id.imgPicture);

            itemView.setOnClickListener(this); // allows recycler items to be clicked
        }
    }
}
