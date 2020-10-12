package com.freshfred.petfirst.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.freshfred.petfirst.data.models.DogBreed;

import java.util.List;

@Dao
public interface DogDao {
    @Insert
    List<Long> insertAll(DogBreed... breeds);

    @Query("SELECT * FROM dogbreed")
    List<DogBreed> getAllDogs();

    @Query("SELECT * FROM dogbreed WHERE uuid = :dogId")
    DogBreed getDogBreed(int dogId);

    @Query("DELETE FROM dogbreed")
    void deleteAllDogs();
}
