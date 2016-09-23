package com.yapd.alexander.yapd.client.util.widget.expandable_text_view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;

import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.application.Yapd;
import com.yapd.alexander.yapd.client.util.widget.custom_text_view.CustomTextView;

/**
 * Created by alexander on 9/23/16.
 */
public class ExpandableTextView extends CustomTextView {
    public static final int MORE_BUTTON_TEXT = R.string.more_button_text;
    public static final int ELIPSES = R.string.elipses;
    private static final int DEFAULT_TRIM_LENGTH = 220;

    private CharSequence originalText;
    private CharSequence trimmedText;
    private boolean trim = true;
    private int trimLength = DEFAULT_TRIM_LENGTH;

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void setText() {
        super.setText(getDisplayableText(), BufferType.SPANNABLE);
    }

    private CharSequence getDisplayableText() {
        return trim ? trimmedText : originalText;
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        originalText = text;
        trimmedText = getTrimmedText(text);
        setText();
    }

    private CharSequence getTrimmedText(CharSequence text) {
        if (originalText != null && originalText.length() > trimLength) {
            String expandText = getContext().getString(MORE_BUTTON_TEXT);
            return addExpandTextToText(text.subSequence(0, trimLength - expandText.length() + 1) + getContext().getString(ELIPSES) + " " + expandText, getResources().getString(MORE_BUTTON_TEXT));
        } else {
            return originalText;
        }
    }

    public CharSequence getOriginalText() {
        return originalText;
    }

    public void setTrimLength(int trimLength) {
        this.trimLength = trimLength;
        trimmedText = getTrimmedText(originalText);
        setText();
    }

    public int getTrimLength() {
        return trimLength;
    }

    public void setExpanded(boolean shouldExpand) {
        trim = !shouldExpand;
        setText();
    }

    protected SpannableStringBuilder addExpandTextToText(String text, String expandText) {
        return addClickablePartTextViewResizable(Html.fromHtml(text), expandText);
    }

    private SpannableStringBuilder addClickablePartTextViewResizable(final Spanned content, final String expandText) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);

        if (shouldCreateClickableSpan(content, expandText)) {
            spannableStringBuilder.setSpan(new MySpannable(false), content.length() - expandText.length(), content.length(), 0);
        }
        return spannableStringBuilder;
    }

    private boolean shouldCreateClickableSpan(Spanned content, String expandText) {
        return content.toString().contains(getContext().getString(ELIPSES)) && SpannedStringHasExpandTextAtTheEndOfIt(content, expandText);
    }

    private boolean SpannedStringHasExpandTextAtTheEndOfIt(Spanned spannedString, String expandText) {
        return spannedString.subSequence(spannedString.length() - expandText.length(), spannedString.length()).toString().equals(expandText);
    }

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