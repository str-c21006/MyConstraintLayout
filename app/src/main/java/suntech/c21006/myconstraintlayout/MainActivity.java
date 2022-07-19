package suntech.c21006.myconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSent=findViewById(R.id.btSend);
        HelloListener listener=new HelloListener();
        btSent.setOnClickListener(listener);
        Button btClear=findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);
        Button btConfirm=findViewById(R.id.btConfirm);
        btConfirm.setOnClickListener(listener);

    }

    private class HelloListener implements View.OnClickListener, suntech.c21006.myconstraintlayout.HelloListener {

        //        イベントハンドラ<=イベント発生時の処理
        @Override
        public void onClick(View view) {

            EditText input1=findViewById(R.id.etName);
            EditText input2=findViewById(R.id.etMail);
            EditText input3=findViewById(R.id.etTai);
            EditText input4=findViewById(R.id.etComment);

            String inputStr1=input1.getText().toString();
            String inputStr2=input2.getText().toString();
            String inputStr3=input3.getText().toString();
            String inputStr4=input4.getText().toString();

            String show="名前："+inputStr1+"：メールアドレス："+inputStr2+"：メールタイトル："+inputStr3+"：質問内容："+inputStr4;


            int id=view.getId();
            switch (id) {
                case R.id.btSend:

                    Toast.makeText(MainActivity.this,show,Toast.LENGTH_LONG).show();

                    break;

                case R.id.btClear:
                    input1.setText("");
                    input2.setText("");
                    input3.setText("");
                    input4.setText("");


                    break;

                case R.id.btConfirm:

                    OrderConfirmDialogFragment dialogFragment=new OrderConfirmDialogFragment(show);
                    dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");
                    break;


            }

        }

    }
}
