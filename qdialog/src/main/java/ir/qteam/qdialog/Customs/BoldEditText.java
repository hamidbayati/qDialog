package ir.qteam.qdialog.Customs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import ir.qteam.qdialog.R;


/**
 * Created by godq on 6/30/16.
 */
public class BoldEditText extends AppCompatEditText {
    public BoldEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public BoldEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.BoldTextView, 0, 0);
        boolean isBold = a.getBoolean(R.styleable.BoldTextView_isBold,true);
        changeTypeFace(isBold);
        a.recycle();
    }

    public BoldEditText(Context context) {
        super(context);
        init();
    }

    public void changeTypeFace(boolean isBold){
        if(isBold==true){
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "IRANSansMobile_Medium.ttf");
            setTypeface(tf);
        }else{
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "IRANSansMobile_Light.ttf");
            setTypeface(tf);
        }


    }
    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "IRANSansMobile_Light.ttf");
        setTypeface(tf);

    }
}