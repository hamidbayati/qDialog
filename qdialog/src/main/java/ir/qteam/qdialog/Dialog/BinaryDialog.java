package ir.qteam.qdialog.Dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import ir.qteam.qdialog.Customs.BoldTextView;
import ir.qteam.qdialog.R;

/**
 * Created by jafar on 5/29/18.
 */


public class BinaryDialog extends CustomDialog {
  private String message;
  private String title;
  private String txt_btn_ok, txt_btn_cancel;
  private Context context;
  private boolean cancelable;
  private BoldTextView btn_ok,btn_cancel;
  private BoldTextView tv_title, tv_message;
  private View.OnClickListener positiveListener;
  private View.OnClickListener negativeListener;

  private BinaryDialog(BinaryDialogBuilder builder) {
    super(builder.context);
    this.context = builder.context;
    this.message = builder.message;
    this.title = builder.title;
    this.txt_btn_ok = builder.txt_btn_ok;
    this.txt_btn_cancel = builder.txt_btn_cancel;
    this.cancelable = builder.cancelable;
    this.positiveListener = builder.positiveListener;
    this.negativeListener=builder.negativeListener;

  }

  public static class BinaryDialogBuilder {
    private String message = "";
    private String title = "";
    private String txt_btn_ok = "";
    private String txt_btn_cancel = "";
    private Context context;
    private boolean cancelable;
    private View.OnClickListener positiveListener;
    private View.OnClickListener negativeListener;

    public BinaryDialogBuilder(Context c, String title, String message) {
      this.context = c;
      this.message = message;
      this.title = title;
    }

    public BinaryDialogBuilder setTxtBtnOk(String txt_btn_ok) {
      this.txt_btn_ok = txt_btn_ok;
      return this;
    }

    public BinaryDialogBuilder setTxtBtnCancel(String txt_btn_cancel) {
      this.txt_btn_cancel = txt_btn_cancel;
      return this;
    }

    public BinaryDialogBuilder setTitle(String title) {
      this.title = title;
      return this;
    }

    public BinaryDialogBuilder setMessage(String message) {
      this.message = message;
      return this;
    }

    public BinaryDialogBuilder setCancelable(boolean cancelable) {
      this.cancelable = cancelable;
      return this;
    }

    public BinaryDialogBuilder onPositiveBtnClickListener(View.OnClickListener listener) {
      this.positiveListener = listener;
      return this;
    }

    public BinaryDialogBuilder onNegativeBtnClickListener(View.OnClickListener listener) {
      this.negativeListener = listener;
      return this;
    }


    public BinaryDialog build() {
      return new BinaryDialog(this);
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.binary_dialog_layout);
    tv_message = this.findViewById(R.id.dialog_desc);
    btn_ok = this.findViewById(R.id.btn_ok_dialog);
    btn_cancel = this.findViewById(R.id.btn_cencel_dialog);
    tv_title = this.findViewById(R.id.dialog_tit);
    configDialog();
    if (positiveListener != null) {
      btn_ok.setOnClickListener(positiveListener);
    }
    if (negativeListener != null) {
      btn_cancel.setOnClickListener(negativeListener);
    }
  }

  private void configDialog() {
    tv_message.setText(message);
    tv_title.setText(title);
    if (!txt_btn_ok.equals("")) {
      btn_ok.setText(txt_btn_ok);
    }
    if (!txt_btn_cancel.equals("")) {
      btn_cancel.setText(txt_btn_cancel);
    }
    btn_cancel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (this != null)
          dismiss();
      }
    });

  }
}
