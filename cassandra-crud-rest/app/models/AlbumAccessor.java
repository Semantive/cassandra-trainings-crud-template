package models;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;

@Accessor
public interface AlbumAccessor {

    @Query("SELECT * FROM albums WHERE album_title LIKE ?")
    Result<Album> searchByTitle(String pattern);

}
