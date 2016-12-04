package sh.dfm.beatystylefrag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView nailIv;
    private TextView nailTv;
    private ImageView addressIv;
    private TextView addressTv;
    private ImageView hairIm;
    private TextView hairTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nailIv = (ImageView) findViewById(R.id.im_nail);
        nailTv = (TextView) findViewById(R.id.tv_nail);
        nailTv.setOnClickListener(this);
        nailIv.setOnClickListener(this);
        ///////// адрес
        addressIv = (ImageView) findViewById(R.id.im_address);
        addressTv = (TextView) findViewById(R.id.tv_address);
        addressIv.setOnClickListener(this);
        addressTv.setOnClickListener(this);
        // hair
        hairIm = (ImageView) findViewById(R.id.im_hair);
        hairTv = (TextView) findViewById(R.id.tv_hair);
        hairIm.setOnClickListener(this);
        hairTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, DataActivityFrag.class);
        String type = "";
        switch (view.getId()){
            case R.id.im_nail:
                type="nail";
                break;
            case R.id.im_hair:
                type="hair";
                break;
        }
        intent.putExtra(DataActivityFrag.EXTRA_TYPE_ID, type.toString() );
        startActivity(intent);


    }
}