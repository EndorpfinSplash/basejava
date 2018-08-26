/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    String RESUME_ABSENT = "Such resume is absent";
    Resume[] storage = new Resume[10000];

    private int quantityOfElements = 0;

    void clear() {
        for (int i = 0; i < quantityOfElements; i++) {
            storage[i] = null;
        }
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

        Integer position = getPosition(uuid);

        if (position == null) {
            System.out.println(RESUME_ABSENT);

        } else return storage[position];
        return null;
    }

    void delete(String uuid) {

        Integer position = getPosition(uuid);

        if (position == null) {
            System.out.println(RESUME_ABSENT);
        } else storage[position] = storage[quantityOfElements - 1];
        quantityOfElements--;

    }

    void update(Resume resume) {

        if (!isResumeExist(resume)) {
            System.out.println(RESUME_ABSENT);
            return;
        }

        Integer position = getPosition(resume.getUuid());
        storage[position] = resume;
    }

    Integer getPosition(String uuid) {
        for (int i = 0; i < quantityOfElements; i++) {
            if (uuid.equals(storage[i])) {
                return i;
            }
        }
        return null;
    }

    Boolean isResumeExist(Resume resume) {
        return getPosition(resume.getUuid()) == null ? false : true;
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
