package com.example.w8_fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements FragmentOne.FragmentOneCallBackInterface,
        FragmentDialog.DialogClickListener
{
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportFragmentManager().beginTransaction()
//                .setReorderingAllowed(true)
//                .add(R.id.container2, FragmentOne.class, null)
//                .commit();
    }


    public void firstToSecondswich_clicked(View view) {
        FragmentOne fragmentOne = new FragmentOne();
        fragmentOne.listener = this;
        fm.beginTransaction().replace(R.id.container1,fragmentOne).commit();


    }

    public void secondToFirst_swich_clicked(View view) {

        Fragment1 f1 = new Fragment1();
        fm.beginTransaction().replace(R.id.container1,f1).commit();

    }

    @Override
    public void buttonClicked() {
        Toast.makeText(this,"Button on Fragment One Clicked",Toast.LENGTH_LONG).show();

    }

    public void add_remove_fragment(View view) {

        Fragment2 f2 = (Fragment2)fm.findFragmentById(R.id.container2);
        if (f2 != null){
            // there is a fragment go remove it
            fm.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fm.beginTransaction().remove(f2).commit();
        }else {

            // // no fragment go add it
            Fragment2 fragment2 = Fragment2.newInstance(R.drawable.img);
            fm.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fm.beginTransaction().add(R.id.container2, fragment2).commit();
        }
    }


    public void OpenDialog(View view) {
        FragmentDialog dialog = FragmentDialog.newInstance("Please Enter Your City");
        dialog.show(fm,FragmentDialog.Tag);
        dialog.listener = this;

    }

    @Override
    public void dialogListnerWithCity(String city) {
        Toast.makeText(this," Provided City is  " + city,Toast.LENGTH_LONG).show();

    }

    @Override
    public void dialogListnerWithCancel() {
        Toast.makeText(this," City is not Provided  " ,Toast.LENGTH_LONG).show();

    }
}