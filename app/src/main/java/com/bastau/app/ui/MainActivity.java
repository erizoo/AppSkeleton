package com.bastau.app.ui;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bastau.app.R;
import com.bastau.app.data.models.ResponseAuth;
import com.bastau.app.data.models.ResponseWrites;
import com.bastau.app.ui.adapters.PostsAdapter;
import com.bumptech.glide.Glide;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    @BindView(R.id.rv_posts)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.avatar)
    ImageView avatar;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.points)
    TextView points;
    @BindView(R.id.likes_get)
    TextView likesGet;
    @BindView(R.id.likes_send)
    TextView likesSend;
    @BindView(R.id.layout_likes)
    LinearLayout likesLayout;
    @BindView(R.id.title)
    TextView title;

    private Unbinder unbinder;
    private PostsAdapter postsAdapter;
    private SkeletonScreen skeletonScreen;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_dashboard:
                title.setText("Лента");
                avatar.setVisibility(View.GONE);
                name.setVisibility(View.GONE);
                likesLayout.setVisibility(View.GONE);
                points.setVisibility(View.GONE);
                userName.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                return true;
            case R.id.navigation_notifications:
                title.setText("Профиль");
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                presenter.getUser();
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar.setVisibility(View.GONE);
        title.setText("Лента");
        postsAdapter = new PostsAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postsAdapter);

        skeletonScreen = Skeleton.bind(recyclerView)
                .adapter(postsAdapter)
                .load(R.layout.item_skeleton_news)
                .show();

        presenter.getPosts();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onReceived(ResponseWrites responseWrites) {
        skeletonScreen.hide();
        progressBar.setVisibility(View.GONE);
        postsAdapter.setItems(responseWrites.getPosts());
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void error(Throwable throwable) {
        Snackbar.make(name, "Ошибка получения данных", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onReceivedUser(ResponseAuth responseAuth) {
        progressBar.setVisibility(View.GONE);
        avatar.setVisibility(View.VISIBLE);
        name.setVisibility(View.VISIBLE);
        likesLayout.setVisibility(View.VISIBLE);
        points.setVisibility(View.VISIBLE);
        userName.setVisibility(View.VISIBLE);
        Glide.with(this)
                .load(responseAuth.getProfilePicUrlHd())
                .into(avatar);
        name.setText(responseAuth.getFullName());
        userName.setText(responseAuth.getInstausername());
        String textPoints = "Стартовый " + " " + "(" + responseAuth.getPoints() + ")" + " " + "баллов";
        points.setText(textPoints);
        String textGetLikes = responseAuth.getWasLiked() + " лайков получил";
        likesGet.setText(textGetLikes);
        String textSendLikes = responseAuth.getWasLiked() + " раз лайкнул";
        likesSend.setText(textSendLikes);
    }
}
