package id.ac.poliban.mi.yusfan.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnStore, btnGetall;
    private EditText etName;
    private DatabaseHelper databaseHelper;
    private TextView tvNames;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        tvNames = (TextView) findViewById(R.id.tvNames);

        btnStore = (Button) findViewById(R.id.btnStore);
        btnGetall = (Button) findViewById(R.id.btnGet);
        etName = (EditText) findViewById(R.id.etName);

        btnStore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                databaseHelper.addStudentDetail(etName.getText().toString());
                etName.setText("");
                Toast.makeText(MainActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
            }
        });
        btnGetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = databaseHelper.getAllStudentsList();
                tvNames.setText("");
                for (int i = 0; i < arrayList.size();i++){
                    tvNames.setText(tvNames.getText().toString()+", "+arrayList.get(i));
                }
            }
        });
    }
}
