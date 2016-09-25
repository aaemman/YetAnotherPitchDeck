package com.yapd.alexander.yapd.client.util.widget.no_swipe_recycler_view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexander on 9/25/16.
 */

public class TagCloudLayoutManager extends NoSwipeRecyclerView.LayoutManager {
    @Override
    protected void layoutViewsForAdapter(final NoSwipeRecyclerView noSwipeRecyclerView, final NoSwipeRecyclerView.Adapter adapter) {
        noSwipeRecyclerView.removeAllViews();
        Context context = noSwipeRecyclerView.getContext();
        if (adapter.getItemCount() > 0) {
            noSwipeRecyclerView.setOrientation(LinearLayout.VERTICAL);

            int currentRow = 0;
            List<LinearLayout> rowLayouts = new ArrayList();

            rowLayouts.add(getNewRowLayout(context));
            noSwipeRecyclerView.addView(rowLayouts.get(currentRow));

            for (int position = 0; position < adapter.getItemCount(); position++) {
                NoSwipeRecyclerView.ViewHolder holder = adapter.onCreateTagViewHolder(noSwipeRecyclerView, adapter.getViewType(position));
                adapter.onBindTagViewHolder(holder, position);
                holder.mItemView.measure(noSwipeRecyclerView.getMeasuredWidth(), noSwipeRecyclerView.getMeasuredHeight());
                rowLayouts.get(currentRow).measure(noSwipeRecyclerView.getMeasuredWidth(), noSwipeRecyclerView.getMeasuredHeight());

                if (isViewWidthGreaterThanTheRemainingSpaceInRow(rowLayouts.get(currentRow), holder.mItemView, noSwipeRecyclerView)) {
                    rowLayouts.add(getNewRowLayout(context));
                    currentRow++;
                    noSwipeRecyclerView.addView(rowLayouts.get(currentRow));
                }

                rowLayouts.get(currentRow).addView(holder.mItemView);
            }
        }
    }

    private boolean isViewWidthGreaterThanTheRemainingSpaceInRow(final LinearLayout rowLayout, final View tag, final NoSwipeRecyclerView noSwipeRecyclerView) {
        return rowLayout.getMeasuredWidth() + tag.getMeasuredWidth() > noSwipeRecyclerView.getMeasuredWidth() && rowLayout.getMeasuredWidth() != 0;
    }

    @NonNull
    private LinearLayout getNewRowLayout(Context context) {
        LinearLayout row = new LinearLayout(context);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return row;
    }
}