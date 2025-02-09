package com.freshfred.petfirst.viewmodel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.freshfred.petfirst.data.db.DogDatabase;
import com.freshfred.petfirst.data.models.DogBreed;

public class DetailViewModel extends AndroidViewModel {
    public MutableLiveData<DogBreed> dogLiveData = new MutableLiveData<>();
    private RetrieveDogTask task;

    public DetailViewModel(@NonNull Application application) {
        super(application);
    }

    public  void fetch(int uuid){
        task = new RetrieveDogTask();
        task.execute(uuid);

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (task!= null){
            task.cancel(true);
            task = null;
        }
    }

    private class RetrieveDogTask extends AsyncTask<Integer,Void, DogBreed>{

        @Override
        protected DogBreed doInBackground(Integer... integers) {
            int uuid = integers[0];
            return DogDatabase.getInstance(getApplication()).dogDao().getDogBreed(uuid);
        }

        @Override
        protected void onPostExecute(DogBreed dogBreed) {
            dogLiveData.setValue(dogBreed);
        }
    }
}
