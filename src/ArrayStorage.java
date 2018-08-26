import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private String RESUME_ABSENT = "Such resume is absent";
    private Resume[] storage = new Resume[10000];
    private int quantityOfElements = 0;

    void clear() {
        Arrays.fill(storage, 0, quantityOfElements, null);
        quantityOfElements = 0;
    }

    void save(Resume resume) {
        if (getPosition(resume.getUuid()) != -1) {
            System.out.println("Resume already exist");
            return;
        }

        if (quantityOfElements >= storage.length) {
            System.out.println("Storage of resume is full");
            return;
        }

        storage[quantityOfElements] = resume;
        quantityOfElements++;
    }

    Resume get(String uuid) {
        int position = getPosition(uuid);

        if (position == -1) {
            System.out.println(RESUME_ABSENT);
            return null;
        }
        return storage[position];
    }

    void delete(String uuid) {
        int position = getPosition(uuid);

        if (position == -1) {
            System.out.println(RESUME_ABSENT);
        } else {
            storage[position] = storage[quantityOfElements - 1];
            storage[quantityOfElements] = null;
            quantityOfElements--;
        }
    }

    void update(Resume resume) {
        int position = getPosition(resume.getUuid());
        if (position == -1) {
            System.out.println(RESUME_ABSENT);
            return;
        }
        storage[position] = resume;
    }

    private int getPosition(String uuid) {
        for (int i = 0; i < quantityOfElements; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, quantityOfElements);
    }

    int size() {
        return quantityOfElements;
    }
}
