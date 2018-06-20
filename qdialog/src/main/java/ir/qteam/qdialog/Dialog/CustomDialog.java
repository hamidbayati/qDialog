package ir.qteam.qdialog.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by jafar on 5/29/18.
 */

public class CustomDialog extends Dialog {

  protected CustomDialog(Context context)
  {
    super(context);
  }
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
  }

}
