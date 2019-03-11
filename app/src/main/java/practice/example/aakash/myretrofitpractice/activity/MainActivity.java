package practice.example.aakash.myretrofitpractice.activity;

import android.databinding.DataBindingUtil;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import practice.example.aakash.myretrofitpractice.R;
import practice.example.aakash.myretrofitpractice.adapter.DisplayAdapter;
import practice.example.aakash.myretrofitpractice.databinding.ActivityMainBinding;
import practice.example.aakash.myretrofitpractice.model.Employee;
import practice.example.aakash.myretrofitpractice.model.EmployeeList;
import practice.example.aakash.myretrofitpractice.network.ApiService;
import practice.example.aakash.myretrofitpractice.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private DisplayAdapter displayAdapter;
    ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //setContentView(R.layout.activity_main);
        callRetrofit();
    }

    private void callRetrofit() {
        ApiService apiService=RetrofitClient.getRetrofitClient().create(ApiService.class);
        Call<EmployeeList> call = apiService.getData(123);
        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                generateEmployeeList(response.body().getEmployeeList());
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"failed to retrive data",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void generateEmployeeList(List<Employee> employeeList) {
        displayAdapter= new DisplayAdapter(employeeList);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(MainActivity.this);
        activityMainBinding.recyclerView.setLayoutManager(layoutManager);
        activityMainBinding.recyclerView.setAdapter(displayAdapter);
    }
}