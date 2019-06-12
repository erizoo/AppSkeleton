package com.bastau.app.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bastau.app.R;
import com.bastau.app.data.models.ResponsePosts;
import com.bastau.app.ui.base.BaseViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context context;
    private Callback callback;
    private List<ResponsePosts> responseWrites = new ArrayList<>();

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PostsAdapter.PostsAdapterViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_posts, viewGroup, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return responseWrites.size();
    }

    public void setItems(List<ResponsePosts> responseEpitaphs) {
        this.responseWrites.clear();
        this.responseWrites.addAll(responseEpitaphs);
        notifyDataSetChanged();
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback {

        void openInstagram(String uri, String username);

    }

    public class PostsAdapterViewHolder extends BaseViewHolder {

        @BindView(R.id.layout)
        ConstraintLayout layout;
        @BindView(R.id.avatar)
        ImageView avatar;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.full_text)
        TextView fullText;
        @BindView(R.id.image)
        ImageView image;

        public PostsAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }

        @Override
        public void onBind(int position) {
            layout.setOnClickListener(v -> {
                callback.openInstagram(responseWrites.get(position).getPostUrl(),
                        responseWrites.get(position).getOwner().getUsername());
            });
            name.setText(responseWrites.get(position).getOwner().getUsername());
            fullText.setText(responseWrites.get(position).getCaption());
            Glide
                    .with(context)
                    .load(responseWrites.get(position).getImgUrl())
                    .into(image);
            Glide
                    .with(context)
                    .load(responseWrites.get(position).getOwner().getProfilePicUrlHd())
                    .apply(RequestOptions.circleCropTransform())
                    .into(avatar);
        }
    }
}