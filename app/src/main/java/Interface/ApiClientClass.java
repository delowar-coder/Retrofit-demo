package Interface;

import modelClass.ArrayDesignClass;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClientClass {
  @GET("teams")
    Call<ArrayDesignClass> getAllTeams(@Query("api_token") String api_token);
}
