package kg.geektech.rickandmorty;

import android.app.Application;

import kg.geektech.rickandmorty.data.remote.RetrofitClient;
import kg.geektech.rickandmorty.data.remote.RickAndMortyApi;
import kg.geektech.rickandmorty.data.repositories.MainRepository;

public class App extends Application {
    private RetrofitClient retrofitClient;
    private RickAndMortyApi api;
    public static MainRepository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.provideApi();
        repository = new MainRepository(api);
    }
}
