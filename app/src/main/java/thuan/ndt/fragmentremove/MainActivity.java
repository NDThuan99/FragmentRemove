package thuan.ndt.fragmentremove;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager =getFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void addA(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frlayout, new FragmnetA(), "A");
        //đưa vào ngă xếp
        fragmentTransaction.addToBackStack("aaa");
        fragmentTransaction.commit();
    }
    public void addB(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frlayout, new FragmnetB(), "B");
        fragmentTransaction.addToBackStack("bbb");
        fragmentTransaction.commit();
    }
    public void addC(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //add Fragmnet vào activity
        fragmentTransaction.add(R.id.frlayout, new FragmnetC(), "C");
        fragmentTransaction.addToBackStack("ccc");
        fragmentTransaction.commit();
    }
    public void dellA(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //ánh xạ Fragment theo tag
        FragmnetA fragmnetA = (FragmnetA) fragmentManager.findFragmentByTag("A");
        //kiểm tra xem fragment có tồn tại k
        if (fragmnetA == null){
            Toast.makeText(this, "Fragment không tồn tại", Toast.LENGTH_SHORT).show();
        }
        else {
            fragmentTransaction.remove(fragmnetA);
        }
        //xác nhận
        fragmentTransaction.commit();
    }
    public void dellB(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //ánh xạ Fragment theo tag
        FragmnetB fragmnetB = (FragmnetB) fragmentManager.findFragmentByTag("B");
        //kiểm tra xem fragment có tồn tại k
        if (fragmnetB == null){
            Toast.makeText(this, "Fragment không tồn tại", Toast.LENGTH_SHORT).show();
        }
        else {
            fragmentTransaction.remove(fragmnetB);
        }
        //xác nhận
        fragmentTransaction.commit();
    }
    public void dellC(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //ánh xạ Fragment theo tag
        FragmnetC fragmnetC = (FragmnetC) fragmentManager.findFragmentByTag("C");
        //kiểm tra xem fragment có tồn tại k
        if (fragmnetC == null){
            Toast.makeText(this, "Fragment không tồn tại", Toast.LENGTH_SHORT).show();
        }
        else {
            fragmentTransaction.remove(fragmnetC);
        }
        //xác nhận
        fragmentTransaction.commit();
    }
    public void Back(View view){
        //lấy ra khỏi ngăn xếp
        //theo thứ tự FILO: vào trước ra sau
        getFragmentManager().popBackStack();
    }
    public void pop(View view){
        //lấy ra ngăn xếp theo tên mình truyền vào
        //getFragmentManager().popBackStack("aaa", 0);
        //getFragmentManager().popBackStack("bbb", 1);
        getFragmentManager().popBackStack("ccc", 2);
    }
    //bắt sự kiện back ngăn xếp khi bấn phím back cứng

    @Override
    public void onBackPressed() {
        //kiểm tra ngăn xếp có bao nhiêu phần tử
        //getBackStackEntryCount(): đếm số lượng phần tử trong ngăn xếp
        /*if (getFragmentManager().getBackStackEntryCount() > 0){
            getFragmentManager().popBackStack();
        }else {
            super.onBackPressed();
        }*/
        super.onBackPressed();

    }
}