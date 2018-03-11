package practice.example.aakash.myretrofitpractice.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import practice.example.aakash.myretrofitpractice.R;
import practice.example.aakash.myretrofitpractice.adapter.DisplayAdapter;
import practice.example.aakash.myretrofitpractice.databinding.ActivityMainBinding;
import practice.example.aakash.myretrofitpractice.model.Employee;
import practice.example.aakash.myretrofitpractice.model.EmployeeList;
import practice.example.aakash.myretrofitpractice.network.ApiService;
import practice.example.aakash.myretrofitpractice.network.RetrofitClient;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private DisplayAdapter displayAdapter;
    private Disposable disposable;
    List<Employee>employeeList;
    ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        callRetrofit();
    }

    private void callRetrofit() {
        ApiService apiService=RetrofitClient.getRetrofitClient().create(ApiService.class);
        Observable<EmployeeList> observable = apiService.getData(123)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<EmployeeList>() {

            @Override
            public void onSubscribe(Disposable d) {
                disposable=d;
            }

            @Override
            public void onNext(EmployeeList employeeList) {
                Log.d("MainActivity","success");
                displayAdapter= new DisplayAdapter(employeeList.getEmployeeList());
                RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(MainActivity.this);
                activityMainBinding.recyclerView.setLayoutManager(layoutManager);
                activityMainBinding.recyclerView.setAdapter(displayAdapter);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("MainActivity", "failed");
            }

            @Override
            public void onComplete() {
            }
        });
    }
}