package cyou.joiplay.commons.dialog;

import android.app.AlertDialog;
import android.content.Context;

public class Dialog {
    public interface OnPositiveListener{
        void onPositive();
    }

    public interface OnNegativeListener{
        void onNegative();
    }

    private String mTitle = "";
    private Integer mTitleRes;
    private String mMessage = "";
    private Integer mMessageRes;
    private String mPositiveText = "";
    private Integer mPositiveTextRes;
    private String mNegativeText = "";
    private Integer mNegativeTextRes;

    private OnPositiveListener mOnPositiveListener = () -> {};
    private OnNegativeListener mOnNegativeListener = () -> {};

    public void setTitle(String title){
        mTitle = title;
    }
    public void setTitle(int id){
        mTitleRes = id;
    }

    public void setMessage(String message){
        mMessage = message;
    }
    public void setMessage(int id){
        mMessageRes = id;
    }

    public void setPositiveButton(String text, OnPositiveListener onPositiveListener){
        mPositiveText = text;
        mOnPositiveListener = onPositiveListener;
    }
    public void setPositiveButton(int stringID, OnPositiveListener onPositiveListener){
        mPositiveTextRes = stringID;
        mOnPositiveListener = onPositiveListener;
    }

    public void setNegativeButton(String text, OnNegativeListener onNegativeListener){
        mNegativeText = text;
        mOnNegativeListener = onNegativeListener;
    }
    public void setNegativeButton(int stringID, OnNegativeListener onNegativeListener){
        mNegativeTextRes = stringID;
        mOnNegativeListener = onNegativeListener;
    }

    public void show(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        if (mTitleRes != null){
            builder.setTitle(mTitleRes);
        } else {
            builder.setTitle(mTitle);
        }

        if (mMessageRes != null){
            builder.setMessage(mMessageRes);
        } else {
            builder.setMessage(mMessage);
        }

        if (mPositiveTextRes != null){
            builder.setPositiveButton(mPositiveTextRes, (dialogInterface, i) -> mOnPositiveListener.onPositive());
        } else {
            builder.setPositiveButton(mPositiveText, (dialogInterface, i) -> mOnPositiveListener.onPositive());
        }

        if (mNegativeTextRes != null){
            builder.setNegativeButton(mNegativeTextRes, (dialogInterface, i) -> mOnNegativeListener.onNegative());
        } else {
            builder.setNegativeButton(mNegativeText, (dialogInterface, i) -> mOnNegativeListener.onNegative());
        }

        builder.setCancelable(false);
        builder.create().show();
    }
}
