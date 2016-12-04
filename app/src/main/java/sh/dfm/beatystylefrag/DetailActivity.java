package sh.dfm.beatystylefrag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_ID ="";
    public static final String EXTRA_LIST ="list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DetailFrag detailFrag = (DetailFrag) getSupportFragmentManager()
                .findFragmentById(R.id.detail_frag);

        long id = (long) getIntent().getLongExtra(EXTRA_ID,0);
        String list = (String) getIntent().getStringExtra(EXTRA_LIST);

        detailFrag.setData(id,list);
    }
}
