package com.gwabs.martialart.View;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.gwabs.martialart.RoomDB.MartialArt;

public class MartialArtListAdapter extends ListAdapter<MartialArt,MartialArtViewHolder> {

    protected MartialArtListAdapter(@NonNull DiffUtil.ItemCallback<MartialArt> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MartialArtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MartialArtViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MartialArtViewHolder holder, int position) {
        MartialArt currentMrtialArtObjrct = getItem(position);
        holder.bind(currentMrtialArtObjrct.mFavMartialArt);
    }

    public static class MartialArtDiff extends DiffUtil.ItemCallback<MartialArt>{

        @Override
        public boolean areItemsTheSame(@NonNull MartialArt oldItem, @NonNull MartialArt newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull MartialArt oldItem, @NonNull MartialArt newItem) {
            return oldItem.mFavMartialArt.equals(newItem.getmFavMartialArt());
        }
    }
}
