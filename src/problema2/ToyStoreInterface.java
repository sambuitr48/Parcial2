package problema2;

import java.io.IOException;
import java.util.List;

public interface ToyStoreInterface {
    ToyStoreDTO findById(int id);
    List<ToyStoreDTO> findAll() throws IOException, ClassNotFoundException;
    void save (ToyStoreDTO toy) throws IOException;
    void update (ToyStoreDTO toy) throws IOException;
    void delete (ToyStoreDTO toy) throws IOException;
}
