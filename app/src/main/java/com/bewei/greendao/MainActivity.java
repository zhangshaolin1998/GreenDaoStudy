package com.bewei.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bewei.greendao.app.MyApp;
import com.bewei.greendao.bean.User;
import com.bewei.greendao.gen.DaoSession;
import com.bewei.greendao.gen.UserDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        DaoSession daoSessio = MyApp.getmInstance().getDaoSessio();
        userDao = daoSessio.getUserDao();
    }

    private void initView() {
        Button bt_add = (Button) findViewById(R.id.bt_add);
        Button bt_delete = (Button) findViewById(R.id.bt_delete);
        Button bt_updata = (Button) findViewById(R.id.bt_updata);
        Button bt_find = (Button) findViewById(R.id.bt_find);
        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        bt_updata.setOnClickListener(this);
        bt_find.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bt_add:
                List<User> users = new ArrayList<>();
                User user1 = new User(Long.valueOf(5), "张三");
                User user2 = new User(Long.valueOf(2), "李四");
                User user3 = new User(Long.valueOf(3), "王五");
                User user4 = new User(Long.valueOf(4), "赵六");
                users.add(user1);
                users.add(user2);
                users.add(user3);
                users.add(user4);
                for (int i=0;i<users.size();i++){
                    userDao.insert(users.get(i));
                }
                Toast.makeText(this, "添加数据成功", Toast.LENGTH_SHORT).show();


                break;
            case R.id.bt_delete:
                User useDelete = userDao.load(Long.valueOf(1));

                userDao.delete(useDelete);//删除对象
                Toast.makeText(this, "删除数据成功", Toast.LENGTH_SHORT).show();

                break;
            case R.id.bt_updata:
                User useUpdata = userDao.load(Long.valueOf(1));
                useUpdata.setName("马七");
                userDao.update(useUpdata);//更新对象
                break;
            case R.id.bt_find:
                User useFind = userDao.load(Long.valueOf(1));//查询对象
                String name = useFind.getName();
                Toast.makeText(this, "查询数据成功：name" + name, Toast.LENGTH_SHORT).show();
                List<User> userList = userDao.loadAll();//查询集合
                for (User userinfo : userList ) {
                    String userinfoName = userinfo.getName();
                    Toast.makeText(this, "查询数据成功：userinfoName:" + userinfoName, Toast.LENGTH_SHORT).show();

                }
                break;
        }

    }
}
