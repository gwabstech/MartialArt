package com.gwabs.martialart.View;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.gwabs.martialart.RoomDB.MartialArt;

public class MartialArtListAdapter extends ListAdapter<MartialArt,MartialArtViewHolder> {

    private ListItemLongClickListener mListItemLongClickListener;
    protected MartialArtListAdapter(ListItemLongClickListener listItemLongClickListener,@NonNull DiffUtil.ItemCallback<MartialArt> diffCallback) {
        super(diffCallback);
       this.mListItemLongClickListener = listItemLongClickListener;
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
        holder.itemView.setOnLongClickListener(v -> {
            mListItemLongClickListener.listItemLongClicked(currentMrtialArtObjrct);
            return true;
        });
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
