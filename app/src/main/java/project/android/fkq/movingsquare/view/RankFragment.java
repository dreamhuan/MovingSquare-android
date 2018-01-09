package project.android.fkq.movingsquare.view;

import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import project.android.fkq.movingsquare.R;
import project.android.fkq.movingsquare.utils.SQLiteHelper;


public class RankFragment extends Fragment implements onRefresh {

    private static final String TAG = "RankFragment";
    private TextView top_list;
    private SQLiteHelper sql;
    private Cursor cursor;
    private RadioButton r3;
    private RadioButton r4;
    private RadioButton r5;
    private TextView tvRank;

    private SwipeRefreshLayout swipeRefresh;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        sql = new SQLiteHelper(getActivity());

        top_list = getActivity().findViewById(R.id.top_list);
        swipeRefresh = getActivity().findViewById(R.id.swipe_refresh);
        swipeRefresh.setEnabled(false);

        r3 = getActivity().findViewById(R.id.r3);
        r4 = getActivity().findViewById(R.id.r4);
        r5 = getActivity().findViewById(R.id.r5);

        tvRank  = getActivity().findViewById(R.id.tv_rank);

        r3.setOnClickListener(this::choose);
        r4.setOnClickListener(this::choose);
        r5.setOnClickListener(this::choose);

        //默认显示3*3的排行
        showTop10("" + 3);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rank, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void refresh() {

    }

    /**
     * 显示前10数据
     *
     * @param type 类型
     */
    public void showTop10(String type) {
        int line = 1;//行数
        int count = 9;//显示个数
        top_list.append("       date");
        top_list.append("                         time\n");
        top_list.append("-------------------------------------------------------------" + "\n");
        cursor = sql.query(type);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            if (count == 0) break;
            top_list.append(line + "    ");
            top_list.append(cursor.getString(0));
            top_list.append("              " + cursor.getInt(1) + "s" + "\n");
            //Log.d(TAG, "showTop10: "+cursor.getString(0)+"--------------"+cursor.getInt(1));
            line++;
            count--;
        }
    }

    /**
     * 排行类型选择
     *
     * @param view
     */
    public void choose(View view) {
        if (view.getId() == R.id.r3) {
            tvRank.setText("排行榜(3x3)");
            top_list.setText("");
            showTop10("" + 3);
        } else if (view.getId() == R.id.r4) {
            tvRank.setText("排行榜(4x4)");
            top_list.setText("");
            showTop10("" + 4);
        } else {
            tvRank.setText("排行榜(5x5)");
            top_list.setText("");
            showTop10("" + 5);
        }
    }
}
