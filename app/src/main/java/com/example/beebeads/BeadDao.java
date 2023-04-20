package com.example.beebeads;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BeadDao {

    @Insert
    void insert(Bead bead);

    @Update
    void update(Bead bead);

    @Delete
    void delete(Bead bead);

    @Query("DELETE FROM " + AppDatebase.BEAD_TABLE)
    void deleteAllBeads();

    @Query("SELECT * FROM " + AppDatebase.BEAD_TABLE + " ORDER BY beadId DESC")
    LiveData<List<Bead>> getAllBeads();
}
