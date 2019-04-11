package com.cszyx.litepaltest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LitePal.initialize(this);

        //创建数据库
        Button createDatabase=(Button)findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });

        //插入数据
        Button addData=(Button)findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movie=new Movie();
                movie.setDirector("Zhang Yuxin");
                movie.setDuration(1);
                movie.setNamw("fhoiushdf");
                movie.setPrice(12);
                movie.save();
            }
        });

        //更新数据
        Button updateData=(Button)findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movie=new Movie();
                movie.setNamw("AK");
                movie.updateAll("director = ?","Li yang");
//                Movie movie=new Movie();
////                movie.setDirector("Li yang");
////                movie.setDuration(2);
////                movie.setNamw("flower");
////                movie.setPrice(30);
////                movie.save();
////                movie.setPrice(100);
////                movie.save();
            }
        });

        //删除数据
        Button deleteButton=(Button)findViewById(R.id.delete_data);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(Movie.class,"director = ?","Zhang Yuxin");
            }
        });

        //查询数据
        Button queryButton=(Button)findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Movie> movies=LitePal.findAll(Movie.class);
                for (Movie movie:movies){
                    Log.d("MainActivity", "movie director is  "+movie.getDirector());
                }
            }
        });
    }
}
