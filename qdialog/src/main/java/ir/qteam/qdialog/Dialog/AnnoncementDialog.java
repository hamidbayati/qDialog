package ir.qteam.qdialog.Dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import ir.qteam.qdialog.Customs.BoldTextView;
import ir.qteam.qdialog.R;


/**
 * Created by jafar on 5/29/18.
 */

public class AnnoncementDialog extends CustomDialog {


  private String message;
  private String title;
  private String txt_btn;
  private Context context;
  private boolean cancelable;
  private BoldTextView btn_accept;
  private BoldTextView tv_title, tv_message;
  private View.OnClickListener acceptListener;

  private AnnoncementDialog(AnnoncementDialogBuilder builder) {
    super(builder.context);
    this.context = builder.context;
    this.message = builder.message;
    this.title = builder.title;
    this.txt_btn = builder.txt_btn;
    this.cancelable = builder.cancelable;
    this.acceptListener = builder.acceptListener;
  }

  public static class AnnoncementDialogBuilder {
    private String message = "";
    private String title = "";
    private String txt_btn = "";
    private Context context;
    private boolean cancelable;
    private View.OnClickListener acceptListener;

    public AnnoncementDialogBuilder(Context c, String title, String message) {
      this.context = c;
      this.message = message;
      this.title = title;
    }

    public AnnoncementDialogBuilder setTxtBtn(String txt_btn) {
      this.txt_btn = txt_btn;
      return this;
    }

    public AnnoncementDialogBuilder setTitle(String title) {
      this.title = title;
      return this;
    }

    public AnnoncementDialogBuilder setMessage(String message) {
      this.message = message;
      return this;
    }

    public AnnoncementDialogBuilder setCancelable(boolean cancelable) {
      this.cancelable = cancelable;
      return this;
    }

    public AnnoncementDialogBuilder onAcceptBtnClickListener(View.OnClickListener listener) {
      this.acceptListener = listener;
      return this;
    }


    public AnnoncementDialog build() {
      return new AnnoncementDialog(this);
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.annoncement_dialog_layout);
    tv_message = this.findViewById(R.id.dialog_desc);
    btn_accept = this.findViewById(R.id.btn_accept_dialog);
    tv_title = this.findViewById(R.id.dialog_tit);
    configDialog();
    if (acceptListener != null) {
      btn_accept.setOnClickListener(acceptListener);
    }
  }

  private void configDialog() {
    tv_message.setText(message);
    tv_title.setText(title);
    if (!txt_btn.equals("")) {
      btn_accept.setText(txt_btn);
    }
    btn_accept.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (this != null)
          dismiss();
      }
    });

  }
}
