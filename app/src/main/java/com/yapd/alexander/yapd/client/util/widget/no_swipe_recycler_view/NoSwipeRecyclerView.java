package com.yapd.alexander.yapd.client.util.widget.no_swipe_recycler_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by alexander on 9/25/16.
 */
public class NoSwipeRecyclerView extends LinearLayout {
    private LayoutManager mLayoutManager;
    private Adapter mAdapter;

    public NoSwipeRecyclerView(Context context) {
        this(context, null, 0);
    }

    public NoSwipeRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NoSwipeRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
        setOrientation(VERTICAL);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        mLayoutManager = layoutManager;
    }

    public void setAdapter(NoSwipeRecyclerView.Adapter adapter) {
        if (mLayoutManager == null) {
            throw new IllegalStateException("YOU CANNOT SET THE ADAPTER OF A TagCloudView WITHOUT FIRST SETTING IT'S LayoutManager");
        }

        if (adapter.equals(mAdapter)) {
            invalidate();
        } else {
            removeAllViews();
            mAdapter = adapter;
            requestLayout();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mLayoutManager != null && mAdapter != null) {
            mLayoutManager.layoutViewsForAdapter(this, mAdapter);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public Adapter getAdapter() {
        return mAdapter;
    }

    // ------ INNER CLASSES ------

    public static abstract class Adapter<VH extends ViewHolder> {
        public abstract VH onCreateTagViewHolder(ViewGroup parent, int viewType);

        public abstract void onBindTagViewHolder(VH holder, int position);

        public abstract int getItemCount();

        public int getViewType(int position) {
            return 0;
        }
    }

    public static abstract class ViewHolder<T> implements com.yapd.alexander.yapd.client.util.view.recyclerView.ViewHolder<T> {
        protected View mItemView;

        public ViewHolder(View itemView) {
            mItemView = itemView;
        }

        @Override
        public abstract void bindTo(T t);
    }

    public static abstract class LayoutManager {
        protected abstract void layoutViewsForAdapter(NoSwipeRecyclerView noSwipeRecyclerView, Adapter adapter);
    }
}
