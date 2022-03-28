package kg.geektech.rickandmorty.ui.character;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import kg.geektech.rickandmorty.App;
import kg.geektech.rickandmorty.common.Resource;
import kg.geektech.rickandmorty.data.models.MainResponse;

public class CharactersViewModel extends ViewModel {
    public LiveData<Resource<MainResponse>> liveData;

    public void getCharacters(){
        liveData = App.repository.getCharacters();
    }
}
