package com.yapd.alexander.yapd.client.util.widget.section_header;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.yapd.alexander.yapd.R;

/**
 * Created by alexander on 9/21/16.
 */
public class SectionHeader extends FrameLayout {
    private static final int LAYOUT = R.layout.view_section_header;
    private ViewBinder viewBinder;

    public SectionHeader(Context context) {
        this(context, null, 0);
    }

    public SectionHeader(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SectionHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view = inflateView();
        viewBinder = new ViewBinder(view);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.SectionHeader);
        setTitle(attributes.getString(R.styleable.SectionHeader_title));
    }

    private View inflateView() {
        return LayoutInflater.from(getContext()).inflate(LAYOUT, this, true);
    }

    public void setTitle(String title) {
        viewBinder.getSectionTitleTextView().setText(title);
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        viewBinder.getLayout().setOnClickListener(l);
    }

    // ------ VIEW BINDER ------

    private class ViewBinder extends com.yapd.alexander.yapd.client.util.view.common.ViewBinder {
        private TextView sectionTitleTextView;
        private ViewGroup layout;

        public ViewBinder(View view) {
            super(view);
        }

        public TextView getSectionTitleTextView() {
            return sectionTitleTextView = getView(sectionTitleTextView, R.id.view_section_header_text_view);
        }

        public ViewGroup getLayout() {
            return layout = getView(layout, R.id.view_section_header_layout);
        }
    }
}
