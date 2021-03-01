package com.cogniwide.cogniwidetask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cogniwide.cogniwidetask.databinding.MoviesListItemBinding;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.UserViewHolder> {

    private List<PopularMoviesModel> mPopularMoviesModelList;
    private Context mContext;

    public CustomAdapter(Context context, List<PopularMoviesModel> popularMoviesModelList) {
        this.mPopularMoviesModelList = popularMoviesModelList;
        mContext = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MoviesListItemBinding productRowBinding = MoviesListItemBinding.inflate(layoutInflater, parent, false);
        return new UserViewHolder(productRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        final PopularMoviesModel user = mPopularMoviesModelList.get(position);
        holder.moviesListItemBinding.setUser(user);
        holder.moviesListItemBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mPopularMoviesModelList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        MoviesListItemBinding moviesListItemBinding;

        public UserViewHolder(@NonNull MoviesListItemBinding moviesListItemBinding) {
            super(moviesListItemBinding.getRoot());
            this.moviesListItemBinding = moviesListItemBinding;
        }
    }
}
