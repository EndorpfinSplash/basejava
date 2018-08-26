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

    void save(Resume r) {
        if (isResumeExist(r)) {
            System.out.println("Resume already exist");
            return;
        }

        if (quantityOfElements >= storage.length) {
            System.out.println("Storage of resume is full");
            return;
        }

        storage[quantityOfElements] = r;
        quantityOfElements++;
    }

    Resume get(String uuid) {
        int position = getPosition(uuid);

        if (position == -1) {
            System.out.println(RESUME_ABSENT);
        } else return storage[position];
        return null;
    }

    void delete(String uuid) {
        int position = getPosition(uuid);

        if (position == -1) {
            System.out.println(RESUME_ABSENT);
        } else storage[position] = storage[quantityOfElements - 1];

        quantityOfElements--;
    }

    void update(Resume resume) {
        if (!isResumeExist(resume)) {
            System.out.println(RESUME_ABSENT);
            return;
        }

        int position = getPosition(resume.getUuid());
        storage[position] = resume;
    }

    int getPosition(String uuid) {
        for (int i = 0; i < quantityOfElements; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    Boolean isResumeExist(Resume resume) {
        return getPosition(resume.getUuid()) != -1;
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
