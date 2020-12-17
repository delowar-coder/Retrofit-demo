package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.delowar.retrofitexample4.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import modelClass.Teams;

public class CustomAdapter extends BaseAdapter {
    private Context mContext;
    private List<Teams> teamsList;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context mContext, List<Teams> teamsList) {
        this.mContext = mContext;
        this.teamsList = teamsList;
        this.layoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return teamsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view= layoutInflater.inflate(R.layout.row_grid_item,viewGroup,false);

        ImageView imageView;
        TextView textView;

        imageView=view.findViewById(R.id.image_view);
        textView=view.findViewById(R.id.text_view1);

        textView.setText(teamsList.get(i).getName());
        Picasso.get().load(teamsList.get(i).getImage_path()).into(imageView);
        return view;
    }
}
