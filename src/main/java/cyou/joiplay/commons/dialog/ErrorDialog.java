package cyou.joiplay.commons.dialog;

import android.app.AlertDialog;
import android.content.Context;

public class ErrorDialog {
    public interface OnCloseListener{
        void onClose();
    }

    private String mTitle = "";
    private Integer mTitleRes;
    private String mMessage = "";
    private Integer mMessageRes;
    private String mCloseButtonText = "";
    private Integer mCloseButtonTextRes;

    private OnCloseListener mOnCloseListener = () -> {};

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

    public void setCloseButton(String text, OnCloseListener onCloseListener){
        mCloseButtonText = text;
        mOnCloseListener = onCloseListener;
    }
    public void setCloseButton(int stringID, OnCloseListener onCloseListener){
        mCloseButtonTextRes = stringID;
        mOnCloseListener = onCloseListener;
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

        if (mCloseButtonTextRes != null){
            builder.setPositiveButton(mCloseButtonTextRes, (dialogInterface, i) -> mOnCloseListener.onClose());
        } else {
            builder.setPositiveButton(mCloseButtonText, (dialogInterface, i) -> mOnCloseListener.onClose());
        }

        builder.setCancelable(false);
        builder.create().show();
    }
}
