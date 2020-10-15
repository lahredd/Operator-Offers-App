package com.myzong.zongprime.actv1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.myzong.zongprime.R;

import java.util.List;



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Anime> mData ;



    public RecyclerViewAdapter(Context mContext, List<Anime> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.anime_row_item,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;

        MobileAds.initialize(mContext, "ca-app-pub-9762360130572732~6889552928");
        final InterstitialAd mInterstitialAd = new InterstitialAd(mContext);
        mInterstitialAd.setAdUnitId("ca-app-pub-9762360130572732/4722554585");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Intent i = new Intent(mContext, AnimeActivity.class);
                i.putExtra("anime_title",mData.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("anime_volume",mData.get(viewHolder.getAdapterPosition()).getVolume());
                i.putExtra("anime_duration",mData.get(viewHolder.getAdapterPosition()).getDuration());
                i.putExtra("anime_activation",mData.get(viewHolder.getAdapterPosition()).getActivation());
                i.putExtra("anime_deactivation",mData.get(viewHolder.getAdapterPosition()).getDeactivation());
                i.putExtra("anime_price",mData.get(viewHolder.getAdapterPosition()).getPrice());

                mContext.startActivity(i);
                if(mInterstitialAd.isLoaded()){
                    mInterstitialAd.show();
                }


            }
        });




        return viewHolder;
    }

    public static Drawable getDrawable(String name, Context mContext) {
        int resourceId = mContext.getResources().getIdentifier(name, "drawable", mContext.getPackageName());
        return mContext.getResources().getDrawable(resourceId);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.title.setText(mData.get(position).getTitle());
        holder.price.setText(mData.get(position).getPrice());
        holder.detail.setText(mData.get(position).getDetail());


        String imageName = mData.get(position).getPhoto();
        int imageResID = mContext.getResources().getIdentifier(imageName, "drawable",
                mContext.getPackageName());

        holder.photo.setImageResource(imageResID);














    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title ;
        TextView price ;
        TextView detail;
        ImageView photo;
        ConstraintLayout view_container;





        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            title = itemView.findViewById(R.id.textView14);
            price = itemView.findViewById(R.id.textView16);
            detail = itemView.findViewById(R.id.textView15);
            photo = itemView.findViewById(R.id.imageView2);


        }
    }



}

