package cyou.joiplay.commons.dialog;

import android.app.AlertDialog;
import android.content.Context;

public class ConfirmationDialog {
    public interface OnConfirmListener{
        void onConfirm();
    }

    private String mTitle = "";
    private Integer mTitleRes;
    private String mMessage = "";
    private Integer mMessageRes;
    private String mConfirmButtonText = "";
    private Integer mConfirmButtonTextRes;

    private OnConfirmListener mOnConfirmListener = () -> {};

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

    public void setConfirmButton(String text, OnConfirmListener onConfirmListener){
        mConfirmButtonText = text;
        mOnConfirmListener = onConfirmListener;
    }
    public void setConfirmButton(int stringID, OnConfirmListener onConfirmListener){
        mConfirmButtonTextRes = stringID;
        mOnConfirmListener = onConfirmListener;
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

        if (mConfirmButtonTextRes != null){
            builder.setPositiveButton(mConfirmButtonTextRes, (dialogInterface, i) -> mOnConfirmListener.onConfirm());
        } else {
            builder.setPositiveButton(mConfirmButtonText, (dialogInterface, i) -> mOnConfirmListener.onConfirm());
        }

        builder.setCancelable(false);
        builder.create().show();
    }
}
