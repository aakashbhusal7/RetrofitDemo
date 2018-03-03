package practice.example.aakash.myretrofitpractice.network;

import practice.example.aakash.myretrofitpractice.model.EmployeeList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aakash on 3/3/18.
 */

public interface ApiService {
    @GET("retrofit-demo.php")
    Call<EmployeeList>getData(@Query("company_no")int companyNumber);
}
