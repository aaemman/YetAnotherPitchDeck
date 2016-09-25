package com.yapd.alexander.yapd.client.job_details;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.util.widget.no_swipe_recycler_view.NoSwipeRecyclerView;

import java.util.List;

/**
 * Created by alexander on 9/25/16.
 */
public class CompanyTagCloudAdapter extends NoSwipeRecyclerView.Adapter<CompanyTagCloudAdapter.TagViewHolder> {
    private List<String> tags;

    public CompanyTagCloudAdapter(List<String> userTags) {
        tags = userTags;
    }

    @Override
    public TagViewHolder onCreateTagViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_tag_view, parent, false);
        return new TagViewHolder(view);
    }

    @Override
    public void onBindTagViewHolder(TagViewHolder holder, int position) {
        holder.bindTo(tags.get(position));
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }

    public class TagViewHolder extends NoSwipeRecyclerView.ViewHolder<String> {
        private TextView tagTextView;

        public TagViewHolder(View itemView) {
            super(itemView);
            tagTextView = (TextView) itemView.findViewById(R.id.view_tag_view_text_view);
        }

        @Override
        public void bindTo(String tagTitle) {
            tagTextView.setText(tagTitle);
        }
    }
}
