/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    private int quantityOfElements = 0;

    void clear() {
        for (int i = 0; i < quantityOfElements; i++) {
            storage[i] = null;
        }
        quantityOfElements = 0;
    }

    void save(Resume r) {
        storage[quantityOfElements] = r;
        quantityOfElements++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < quantityOfElements; i++) {
            if (uuid.equals(storage[i].toString())) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < quantityOfElements; i++) {
            if (uuid.equals(storage[i].toString())) {
                storage[i] = storage[quantityOfElements - 1];
                storage[quantityOfElements - 1] = null;
                quantityOfElements--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume[] resumes = new Resume[quantityOfElements];
        for (int i = 0; i < quantityOfElements; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return quantityOfElements;
    }
}
