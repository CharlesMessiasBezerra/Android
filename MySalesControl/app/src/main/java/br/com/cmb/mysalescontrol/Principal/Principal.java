package br.com.cmb.mysalescontrol.Principal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import br.com.cmb.mysalescontrol.Login.LoginActivity;
import br.com.cmb.mysalescontrol.R;

public class Principal extends AppCompatActivity {
    private String TAG = "MySalesControl";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "LoginActivity - onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "LoginActivity - onBackPressed");
        super.onBackPressed();
        Intent intent = new Intent();
        intent.setClass(Principal.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
