package practice.example.aakash.myretrofitpractice.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aakash on 3/3/18.
 */

public class RetrofitClient {
    public static final String BASE_URL="http://navjacinth9.000webhostapp.com/json/";
    //ApiService apiService;
    private static Retrofit retrofit=null;
    private RetrofitClient(){
    }
    public static Retrofit getRetrofitClient(){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
           // apiService=retrofit.create(ApiService.class);
        return retrofit;
    }
//    public ApiService getApiService(){
//        return apiService;
//    }
}

