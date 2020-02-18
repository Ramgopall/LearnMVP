package com.duke.learnmvp.view.activities;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.duke.learnmvp.R;
import com.duke.learnmvp.presenter.Presenter;
import com.duke.learnmvp.view.View;


public abstract class AbstractActivity extends AppCompatActivity implements View {

    protected final String TAG = getClass().getSimpleName();
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    abstract Presenter getPresenter();

    @Override
    protected void onStart() {
        super.onStart();
        if (getPresenter() != null) {
            getPresenter().onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    public void showToast(String text) {
        if (text == null || text.isEmpty()) return;
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void showToast(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_LONG).show();
    }

    public void showShortToast(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startLoading() {
        if (mDialog != null && mDialog.isShowing()) {
            return;
        }
        mDialog = new ProgressDialog(this); // , R.style.AppTheme_AlertDialog
        mDialog.setMessage("Loading...");
        mDialog.setCancelable(false);
        mDialog.show();

    }

    @Override
    public void stopLoading() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

}
