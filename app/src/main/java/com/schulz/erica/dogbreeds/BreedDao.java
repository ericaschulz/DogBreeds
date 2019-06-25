package com.schulz.erica.dogbreeds;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao

public interface BreedDao {

    @Insert
    void insert(Breed breed);

    @Query("DELETE FROM breed_table")
    void deleteAll();

    @Query("SELECT * from breed_table ORDER BY breed ASC")
    LiveData<List<Breed>> getAllBreeds();
}





