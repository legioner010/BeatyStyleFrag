package sh.dfm.beatystylefrag;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class DataActivityFrag extends AppCompatActivity  implements  ListFrag.ListFragListner{

    public static final String EXTRA_TYPE_ID = "id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       String type_id = getIntent().getStringExtra(EXTRA_TYPE_ID);
       ListFrag listfrag = new ListFrag();

       if(type_id.equals("nail")){
           listfrag.setListID("nail");
       }else{
           listfrag.setListID("hair");
       }

        setContentView(R.layout.activity_datafrag);

    }

    @Override
    public void itemClicked(long id, String listID) {
        Log.e("DataActivityFrag","itemClicked = " +listID);

        View fragmentcontainer = findViewById(R.id.fragment_container);
        if(fragmentcontainer !=null){
            DetailFrag detail = new DetailFrag();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            detail.setData(id, listID);
            ft.replace(R.id.fragment_container, detail);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        }else{
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_ID, id);
            intent.putExtra(DetailActivity.EXTRA_LIST, (String) listID);
            startActivity(intent);
        }

    }
}
