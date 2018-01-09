package project.android.fkq.movingsquare.view;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import project.android.fkq.movingsquare.R;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private DrawerLayout mDrawerLayout;
    private GameFragment gameFragment;
    private IntroFragment introFragment;
    private RankFragment rankFragment;
    onRefresh currentFragment;
    private FragmentManager fragmentManager;


    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        mDrawerLayout = findViewById(R.id.drawer_layout);


        swipeRefresh = findViewById(R.id.swipe_refresh);
        // 修改进度条的颜色
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(this::refresh);

        gameFragment = new GameFragment();
        introFragment = new IntroFragment();
        rankFragment = new RankFragment();
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, gameFragment).commit();
        currentFragment = gameFragment;

        NavigationView navView = findViewById(R.id.nav_view);
        navView.setCheckedItem(R.id.nav_game);
        navView.setNavigationItemSelectedListener(item -> {
//            Log.d(TAG, "onCreate: " + item);
            switch (item.getItemId()) {
                case R.id.nav_game:
                    currentFragment = gameFragment;
                    fragmentManager.beginTransaction().replace(R.id.content_frame, gameFragment).commit();
                    break;
                case R.id.nav_intro:
                    currentFragment = introFragment;
                    fragmentManager.beginTransaction().replace(R.id.content_frame, introFragment).commit();
                    break;
                case R.id.nav_rank:
                    currentFragment = rankFragment;
                    fragmentManager.beginTransaction().replace(R.id.content_frame, rankFragment).commit();
                    break;
            }
            mDrawerLayout.closeDrawers();
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.settings:
                Toast.makeText(this, "这个设置暂时没想好要放什么功能", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    private void refresh() {
        currentFragment.refresh();
    }

}
