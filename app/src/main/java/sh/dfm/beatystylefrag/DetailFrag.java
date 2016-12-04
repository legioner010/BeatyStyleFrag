package sh.dfm.beatystylefrag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by е on 04.12.2016.
 */
public class DetailFrag extends Fragment {

    private long detailId = 0;
    private String listId = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.e("DetailFrag DetailFrag ", "listId = " + listId);

        View view = getView();
        if (view != null) {
            if (listId.equals("hair")) {


                TextView title = (TextView) view.findViewById(R.id.textTitle);
                Data data = Data.hairs[(int) detailId];
                title.setText(Data.hairs[(int) detailId].getName());

                TextView description = (TextView) view.findViewById(R.id.textDscription);
                description.setText(Data.hairs[(int) detailId].getDescription());

                ImageView imageResourceId = (ImageView) view.findViewById(R.id.image_resource);
                imageResourceId.setImageResource(Data.hairs[(int) detailId].getImageresourceId());

            } else {
                TextView title = (TextView) view.findViewById(R.id.textTitle);
                Data data = Data.nails[(int) detailId];
                title.setText(Data.nails[(int) detailId].getName());

                TextView description = (TextView) view.findViewById(R.id.textDscription);
                description.setText(Data.nails[(int) detailId].getDescription());

                ImageView imageResourceId = (ImageView) view.findViewById(R.id.image_resource);
                imageResourceId.setImageResource(Data.nails[(int) detailId].getImageresourceId());

            }


        }

    }

    public void setData(long id, String listId) {
        this.detailId = id;
        this.listId = listId;
    }

}
