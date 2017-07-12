package br.com.cmb.mysalescontrol.Login;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import br.com.cmb.mysalescontrol.Principal.Principal;
import br.com.cmb.mysalescontrol.R;

public class LoginActivity extends AppCompatActivity {

    private String TAG = "MySalesControl";
    private Button _btnLogin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "LoginActivity - onLoadControls");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        onLoadControls();
    }

    // Private Methods
    private void onLoadControls() {

        try {

            _btnLogin = (Button) findViewById(R.id.btnLogin);

            _btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this, Principal.class);
                    startActivity(intent);
                    finish();
                }
            });

        } catch (Exception e) {
            Log.e(TAG, "LoginActivity - onLoadControls\nErro: " + e.getMessage());
        }
    }
}
