package com.bewei.greendao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/11/6 15:56
 */


public class OtherActivity extends AppCompatActivity {
    @Bind(R.id.bt_add)
    Button btAdd;
    @Bind(R.id.bt_delete)
    Button btDelete;
    @Bind(R.id.bt_updata)
    Button btUpdata;
    @Bind(R.id.bt_find)
    Button btFind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定控件
        ButterKnife.bind(this);
        btAdd.setText("add");
    }
  //设置监听
    @OnClick({R.id.bt_add,R.id.bt_delete,R.id.bt_updata,R.id.bt_find})
    public  void onClick(View view){
        switch (view.getId()){
            case R.id.bt_add:
                Toast.makeText(this, "添加", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_delete:
                Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show();

                break;

        }
    }

}
