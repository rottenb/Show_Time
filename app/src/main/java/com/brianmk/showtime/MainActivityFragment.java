package com.brianmk.showtime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private static final String LOG_TAG = MainActivityFragment.class.getSimpleName();

    // TODO - Remove this stuff when we load real data
    protected String[] mTitles = {
            "Amy",
            "Ant-Man",
            "Being Evel",
            "Birdman",
            "Black Mass",
            "Bone Tomahawk",
            "Everest",
            "Heroes of Dirt",
            "Mad Max - Fury Road",
            "Mission Impossible - Rogue Nation",
            "Pawn Sacrifice",
            "Rotor DR1",
            "Sicario",
            "Star Wars - The Force Awakens",
            "Straight Outta Compton",
            "The Good Dinosaur",
            "The Martian" };

    protected Integer[] mPosters = {
            R.drawable.amy,
            R.drawable.ant_man,
            R.drawable.being_evel,
            R.drawable.birdman,
            R.drawable.black_mass,
            R.drawable.bone_tomahawk,
            R.drawable.everest,
            R.drawable.heros_of_dirt,
            R.drawable.mad_max_fury_road,
            R.drawable.mission_impossible_rn,
            R.drawable.pawn_sacrifice,
            R.drawable.rotor_dr1,
            R.drawable.sicario,
            R.drawable.star_wars_tfa,
            R.drawable.straight_outta_compton,
            R.drawable.the_good_dinosaur,
            R.drawable.the_martian };

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.movie_grid_view);
        gridView.setAdapter(new MovieAdapter(this.getContext()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] movieRef = { mTitles[position], Integer.toString(mPosters[position])};

                Intent detailIntent = new Intent(getActivity(), DetailActivity.class)
                        .putExtra(Intent.EXTRA_TEXT, mTitles[position]);
                detailIntent.putExtra(DetailActivity.EXTRA_POSTER_REF, mPosters[position]);
                startActivity(detailIntent);
            }
        });

        return rootView;
    }

    public class MovieAdapter extends BaseAdapter {
        private Context mContext;


        public MovieAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mPosters.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // Create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.poster_view, null);
            }

            ImageView imageView = (ImageView) convertView.findViewById(R.id.poster_image);
            imageView.setImageResource(mPosters[position]);

            return imageView;
        }
    }
}
