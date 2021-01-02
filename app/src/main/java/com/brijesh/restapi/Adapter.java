package com.brijesh.restapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brijesh.restapi.Country;
import com.brijesh.restapi.CountryActivity;
import com.brijesh.restapi.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    private Context mContext;
    private List<Country> country = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.country_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(country.get(position).getName());
        holder.capital.setText(country.get(position).getCapital());
        String Country_Name = country.get(position).getName();
        String Country_Capital = country.get(position).getCapital();
        String Country_Flag = country.get(position).getFlag();
        String Country_Region = country.get(position).getRegion();
        String Country_Subregion = country.get(position).getSubregion();
        String Country_Population = country.get(position).getPopulation();
        String Country_Borders = country.get(position).getBorders();
        Object Country_Languages = country.get(position).getLanguages();
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, CountryActivity.class);
            intent.putExtra("name",Country_Name);
            intent.putExtra("capital",Country_Capital);
            intent.putExtra("flag",Country_Flag);
            intent.putExtra("region",Country_Region);
            intent.putExtra("subregion",Country_Subregion);
            intent.putExtra("population",Country_Population);
            intent.putExtra("borders",Country_Borders);
            intent.putExtra("languages", (Bundle) Country_Languages);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return country.size();
    }

    public void setCountry(Context mContext, List<Country> mCountry){
        this.mContext = mContext;
        this.country = mCountry;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,capital;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            capital = itemView.findViewById(R.id.capital);;
        }
    }
}
