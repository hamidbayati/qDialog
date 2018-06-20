package library.qteam.ir.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ir.qteam.qdialog.Dialog.AnnoncementDialog;
import ir.qteam.qdialog.Dialog.CustomDialog;
import ir.qteam.qdialog.Dialog.ProgressDialog;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
//    CustomDialog d=new AnnoncementDialog.AnnoncementDialogBuilder(this,"dasd","asdsad").build();
//    d.show();
  }
}
