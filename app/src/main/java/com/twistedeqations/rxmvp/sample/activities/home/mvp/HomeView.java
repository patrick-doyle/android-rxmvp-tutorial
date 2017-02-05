package com.twistedeqations.rxmvp.sample.activities.home.mvp;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jakewharton.rxbinding.view.RxView;
import com.twistedeqations.rxmvp.sample.R;
import rx.Observable;

@SuppressLint("ViewConstructor")
public class HomeView extends FrameLayout {

  @BindView(R.id.edit_username)
  EditText usernameEditText;

  @BindView(R.id.btn_username_lookup)
  Button usernameLookUpBtn;

  @BindView(R.id.main_toolbar)
  Toolbar toolbar;

  private final ProgressDialog progressDialog = new ProgressDialog(getContext());

  public HomeView(Activity activity) {
    super(activity);

    inflate(getContext(), R.layout.activity_main, this);

    progressDialog.setMessage("Looking up user");
    ButterKnife.bind(this);
  }

  public void setMessage(String message) {
    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
  }

  public Observable<Void> observeButton() {
    return RxView.clicks(usernameLookUpBtn);
  }

  public String getUsernameEdit() {
    return usernameEditText.getText().toString();
  }

  public void showLoading(boolean loading) {
    if(loading) {
      progressDialog.show();
    } else {
      progressDialog.dismiss();
    }
  }
}
