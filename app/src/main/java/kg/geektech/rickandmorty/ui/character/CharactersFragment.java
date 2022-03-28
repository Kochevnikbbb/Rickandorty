package kg.geektech.rickandmorty.ui.character;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import kg.geektech.rickandmorty.R;
import kg.geektech.rickandmorty.common.Resource;
import kg.geektech.rickandmorty.data.models.MainResponse;
import kg.geektech.rickandmorty.databinding.FragmentCharactersBinding;

public class CharactersFragment extends Fragment {
    private FragmentCharactersBinding binding;
    private CharactersAdapter adapter;
    private CharactersViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new CharactersAdapter();
        viewModel = new ViewModelProvider(requireActivity()).get(CharactersViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCharactersBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.rvCharacter.setAdapter(adapter);
        viewModel.getCharacters();
        viewModel.liveData.observe(getViewLifecycleOwner(), mainResponseResource -> {
            switch (mainResponseResource.status){
                case SUCCESS:{
                    binding.rvCharacter.setVisibility(View.VISIBLE);
                    binding.progress.setVisibility(View.GONE);
                    adapter.setCharacters(mainResponseResource.data.getResults());
                    break;

                }
                case ERROR:{
                    binding.rvCharacter.setVisibility(View.GONE);
                    binding.progress.setVisibility(View.GONE);
                    Snackbar.make(binding.getRoot(),
                            mainResponseResource.msg,
                            BaseTransientBottomBar.LENGTH_LONG).show();
                    break;

                }
                case LOADING:{
                    binding.rvCharacter.setVisibility(View.GONE);
                    binding.progress.setVisibility(View.VISIBLE);
                    break;
                }
            }
        });
    }
}