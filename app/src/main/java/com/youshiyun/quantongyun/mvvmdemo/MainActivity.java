package com.youshiyun.quantongyun.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.youshiyun.quantongyun.mvvmdemo.databinding.ActivityMainBinding;
import com.youshiyun.quantongyun.mvvmdemo.moudle.MainVM;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MainVM mMainVM = new MainVM("主页");
    private int mI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setB(mMainVM);
        binding.setP(new Presenter());


    }

    public class Presenter {
        public void  onTextChanged(CharSequence s,int start,int end,int couunt){
            mMainVM.setName(s.toString());
            binding.setB(mMainVM);
        }
        public void onClick(View pView){
            Toast.makeText(MainActivity.this, "被点击了", Toast.LENGTH_SHORT).show();
        }


        public void demoWay(MainVM pMainVM){
            Toast.makeText(MainActivity.this, pMainVM.getName(), Toast.LENGTH_SHORT).show();
        }

    }
}
