package com.example.dragonfly_main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SpeciesListAdapter extends ArrayAdapter<Species> {

    private static final String TAG = "SpeciesListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView species_name;
        TextView common_name;
        TextView type;
    }

    /**
     * Default constructor for the SpeciesListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public SpeciesListAdapter(Context context, int resource, ArrayList<Species> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the Speciess information
        String species_name = getItem(position).getspecies_name();
        String common_name = getItem(position).getcommon_name();
        String type = getItem(position).gettype();

        //Create the Species object with the information
        Species Species = new Species(species_name,common_name,type);

        //create the view result for showing the animation
        final View result;

        //ViewHolder object
        ViewHolder holder;


        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder= new ViewHolder();
            holder.species_name = (TextView) convertView.findViewById(R.id.textView1);
            holder.common_name = (TextView) convertView.findViewById(R.id.textView2);
            holder.type = (TextView) convertView.findViewById(R.id.textView3);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }


        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        holder.species_name.setText(Species.getspecies_name());
        holder.common_name.setText(Species.getcommon_name());
        holder.type.setText(Species.gettype());


        return convertView;
    }
}