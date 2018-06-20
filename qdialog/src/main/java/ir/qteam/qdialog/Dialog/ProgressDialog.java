package ir.qteam.qdialog.Dialog;

import android.content.Context;
import android.os.Bundle;

import ir.qteam.qdialog.Customs.BoldTextView;
import ir.qteam.qdialog.R;

/**
 * Created by hamid on 5/29/18.
 */

public class ProgressDialog extends CustomDialog {

  private String message = "";
  private Context context;
  private boolean cancelable;
  private BoldTextView tv_message;

  private ProgressDialog(ProgresDialogBuilder builder) {
    super(builder.context);
    this.context = builder.context;
    this.message = builder.message;
    this.cancelable = builder.cancelable;
  }

  public static class ProgresDialogBuilder {
    private String message="";
    private Context context;
    boolean cancelable;

    public ProgresDialogBuilder(Context c) {
      this.context = c;
    }

    public ProgresDialogBuilder setMessage(String message) {
      this.message = message;
      return this;
    }

    public ProgresDialogBuilder setCancelable(boolean cancelable) {
      this.cancelable = cancelable;
      return this;
    }


    public ProgressDialog build() {
      return new ProgressDialog(this);
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.progress_dialog_layout);
    this.setCancelable(this.cancelable);
    tv_message = this.findViewById(R.id.progress_dialog_desc);
    if (!this.message.equals("")) {
      tv_message.setText(this.message);
    }
  }
}
