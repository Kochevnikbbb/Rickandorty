package kg.geektech.rickandmorty.data.remote;

import kg.geektech.rickandmorty.data.models.MainResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RickAndMortyApi {
    @GET("character")
    Call<MainResponse> getCharacters();
}
