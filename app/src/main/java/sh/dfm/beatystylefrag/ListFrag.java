package sh.dfm.beatystylefrag;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by е on 04.12.2016.
 */
public class ListFrag extends ListFragment {

    private ListFragListner listner;
    private static  String listID = "";



    public static interface ListFragListner {
        void itemClicked(long id, String listID);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listner = (ListFragListner) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(listID.equals("nail")){
            String[] names = new String[Data.nails.length];
            for (int i = 0; i < names.length; i++) {
                names[i] = Data.nails[i].getName();
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(),
                    android.R.layout.simple_list_item_1, names);
            setListAdapter(adapter);
        } else{
            String[] names = new String[Data.hairs.length];
            for (int i = 0; i < names.length; i++) {
                names[i] = Data.hairs[i].getName();
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(),
                    android.R.layout.simple_list_item_1, names);
            setListAdapter(adapter);
        }





        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        listner.itemClicked(id, listID);
    }

    public void setListID(String id) {
        this.listID = id;
    }
}
