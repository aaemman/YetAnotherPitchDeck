package com.yapd.alexander.yapd.client.util.widget.expandable_text_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.application.Yapd;
import com.yapd.alexander.yapd.client.util.code.StringUtil;
import com.yapd.alexander.yapd.client.util.widget.custom_text_view.CustomTextView;

/**
 * Created by alexander on 9/23/16.
 */
public class ExpandableTextView extends CustomTextView {
    private static final int MAX_LINES = 3;
    public static final int MORE_BUTTON_TEXT = R.string.more_button_text;
    public static final int ELIPSES = R.string.elipses;
    private String fullText;
    private boolean isExpanded = true;
    private boolean isDrawn = false;

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setClickable(true);
        setFocusable(true);
        setOnClickListener(view -> {
            if (!isExpanded) {
                isDrawn = false;
                expand(true);
                invalidate();
                requestLayout();
            }
        });
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (fullText == null && text != null && !StringUtil.isEmpty(text.toString())) {
            fullText = text.toString();
        }
        super.setText(text, type);
    }

    public void expand(boolean shouldExpand) {
        this.isExpanded = !shouldExpand;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isDrawn) {
            isDrawn = true;
            String expandText = getContext().getString(MORE_BUTTON_TEXT);
            if (isExpanded && MAX_LINES > 0 && getLineCount() > MAX_LINES) {
                isExpanded = false;
                int lineEndIndex = getLayout().getLineEnd(MAX_LINES - 1);
                String text = fullText.subSequence(0, lineEndIndex - expandText.length() + 1) + getContext().getString(ELIPSES) + " " + expandText;
                updateTextToIncludeMoreButton(text, expandText);
            } else {
                isExpanded = true;
                setText(fullText);
            }
        }
    }

    protected void updateTextToIncludeMoreButton(String text, String expandText) {
        setText(addClickablePartTextViewResizable(Html.fromHtml(text), expandText), TextView.BufferType.SPANNABLE);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    private SpannableStringBuilder addClickablePartTextViewResizable(final Spanned content, final String expandText) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);

        spannableStringBuilder.setSpan(new MySpannable(false), content.length() - expandText.length(), content.length(), 0);
        return spannableStringBuilder;
    }


    // ------ HELPERS ------

    public class MySpannable extends ClickableSpan {
        private boolean isUnderline = true;

        public MySpannable(boolean isUnderline) {
            this.isUnderline = isUnderline;
        }

        @Override
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(Yapd.getStaticResources().getColor(R.color.colorPrimary));
            textPaint.setTypeface(Typeface.DEFAULT_BOLD);
            textPaint.setUnderlineText(isUnderline);
        }

        @Override
        public void onClick(View view) {
            //
        }
    }
}