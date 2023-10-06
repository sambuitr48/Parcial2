package problema2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToyStoreService implements ToyStoreInterface{
    private List<ToyStoreDTO> toys;
    public ToyStoreService() throws IOException, ClassNotFoundException {
        toys = new ArrayList<>();
    }

    @Override
    public ToyStoreDTO findById(int id) {
        return toys.stream()
                .filter(toy -> toy.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<ToyStoreDTO> findAll() throws IOException, ClassNotFoundException {
        toys = (List<ToyStoreDTO>) TSObjectSerializable.readObjectFromFile("toyss.ax");
        return toys;
    }

    @Override
    public void save(ToyStoreDTO toy) throws IOException {
        toys.add(toy);
        TSObjectSerializable.writeObjectToFile(toys, "toyss.ax");
    }

    @Override
    public void update(ToyStoreDTO toy) throws IOException {
        ToyStoreDTO oldToy = findById(toy.getId());
        if (oldToy != null){
            toys.remove(oldToy);
            toys.add(toy);
            TSObjectSerializable.writeObjectToFile(toys, "toyss.ax");
        }
    }

    @Override
    public void delete(ToyStoreDTO toy) throws IOException {
        toys.remove(toy);
        TSObjectSerializable.writeObjectToFile(toys, "toyss.ax");
    }
}
