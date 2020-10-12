package com.freshfred.petfirst.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.freshfred.petfirst.R;
import com.freshfred.petfirst.data.models.DogBreed;
import com.freshfred.petfirst.databinding.ItemBinding;
import com.freshfred.petfirst.view.ui.ClickListener;
import com.freshfred.petfirst.view.ui.fragments.ListFragmentDirections;

import java.util.ArrayList;
import java.util.List;

public class DogsListAdapter extends RecyclerView.Adapter<DogsListAdapter.DogViewHolder> implements ClickListener {

    private ArrayList<DogBreed> dogsList;

    public DogsListAdapter(ArrayList<DogBreed> dogsList) {
        this.dogsList = dogsList;
    }

    public void updateDogsList(List<DogBreed> newDogsList) {
        dogsList.clear();
        dogsList.addAll(newDogsList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBinding view = DataBindingUtil.inflate(inflater, R.layout.item, parent, false);
        return new DogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        holder.itemView.setDog(dogsList.get(position));
        holder.itemView.setListener(this);
    }

    @Override
    public int getItemCount() {
        return dogsList.size();
    }

    @Override
    public void onClicked(View v) {
        String uuidString = ((TextView) v.findViewById(R.id.dogId)).getText().toString();
        int uuid = Integer.parseInt(uuidString);
        ListFragmentDirections.ActionDetail actionDetail = ListFragmentDirections.actionDetail(uuid);
        Navigation.findNavController(v).navigate(actionDetail);
    }

    class DogViewHolder extends RecyclerView.ViewHolder {

        public ItemBinding itemView;

        public DogViewHolder(@NonNull ItemBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }

}
